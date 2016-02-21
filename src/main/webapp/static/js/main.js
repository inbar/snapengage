var Map;

// Berlin
var defaultLatLng = {lat : 52.5167, lng : 13.3833};
var defaultZoom = 5;

var markersLayer;

function init() {
    initMapbox();
    getChats();

    document.getElementById("refresh").addEventListener("click", getChats);
    document.getElementById("loadAll").addEventListener("click", toggleLoadAll);

}

window.onload = init;


function initMapbox() {
   L.mapbox.accessToken = 'pk.eyJ1IjoiaW5iYXJkYSIsImEiOiJoUTlLWjFFIn0.qY3BaCuB4zMSGuCd4kWoBQ';
   Map = L.mapbox.map('map', 'mapbox.streets')
       .setView([52.5167, 13.3833], 7);

};

function addMarkers(markers) {

    if (!Map) {
        return;
    }

    if (markers.length == 0) {
        Map.setView(defaultLatLng, defaultZoom);
        return;
    }

    if (markersLayer != undefined) {
        Map.removeLayer(markersLayer);
    }

    markersLayer = L.mapbox.featureLayer().addTo(Map);

    var geojson = [],
        latSum = 0,
        lngSum = 0,
        latAvg = 0,
        lngAvg = 0;

    _.each(markers, function(marker) {
        var lat = marker.lat;
        var lng = marker.lng;
        latSum += lat;
        lngSum += lng;
        geojson.push(
        {
            "type": "Feature",
            "geometry": {
              "type": "Point",
              "coordinates": [lng, lat]
            },
            "properties": {
              "title": marker.title,
              "description": marker.description,
              "marker-color": "#444",
              "marker-size": "large",
              "marker-symbol": "star"
            }
        });
    });


    lngAvg = lngSum / markers.length;
    latAvg = latSum / markers.length;

    markersLayer.setGeoJSON(geojson);

    markersLayer.on('mouseover', function(e) {
        e.layer.openPopup();
    });

    Map.setView({lng: lngAvg, lat: latAvg}, defaultZoom);
}


function getChats() {

    function handleChats(chats) {
        markerData = [];
        _.each(chats, function(chat){
            markerData.push({
                lng: chat.longitude,
                lat: chat.latitude,
                title: chat.type + ' (' + chat.created_at_date + ')',
                description: 'Last message: "' + chat.description + '"'
                + '<br>Wait time: ' + chat.chat_waittime
                + '<br>Duration: ' + chat.chat_duration
                + '<br><a href="' + chat.url + '" target="_blank">More details</a>'
            })
        });

        addMarkers(markerData);

    }

    function callback(event) {
        if (event.target.readyState == XMLHttpRequest.DONE) {
            if (httpRequest.status === 200) {
                handleChats(JSON.parse(httpRequest.responseText));
            }
        }
    }

    var httpRequest = new XMLHttpRequest();

    if (!httpRequest) {
        return false;
    }

    var params = toLoadAll() ? '' : 'n=10';

    httpRequest.onreadystatechange = callback;
    httpRequest.open('GET', '/api/chats?' + params, true );
    httpRequest.send();
}

function toLoadAll() {
    return getLoadAllCheckbox().checked;
}

function toggleLoadAll() {
    var checkbox = getLoadAllCheckbox();
    checkbox.checked = !checkbox.checked;
}

function getLoadAllCheckbox(){
    return document.getElementById("loadAllCheckbox");
}