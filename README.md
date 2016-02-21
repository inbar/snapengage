## SnapEngage webhook Task

The app is available at: [https://snapengage-1225.appspot.com](https://snapengage-1225.appspot.com)

### General
A small server which sets up an endpoint for the SnapEngage webhook, persists the data and exposes it to the world through a very small REST api. Very small meaning one Get endpoint 😎.
On the other side, there is a small web based client to visualize the data on a map.

### Backend
A Java backend using the following:
* Good old servlets.
* [Guice](https://github.com/google/guice) is used for dependency management and servlet configuration.
* [GSON](https://github.com/google/gson) for (de)serializing json.

The data persistence is a naive in memory implementation. So everything is gone on server restart. I think i could live with that.

### Frontend
Vanilla Javascript based frontend to show the saved chat data on a map.
The frontend is using:
* [Mapbox](https://www.mapbox.com/) - a too powerful mapping tool.
* Twitter Bootstrap
* As mentioned, vanilla javascript with a little bit of ajax.

### Development/Deployment
The application is deployed on Google App Engine and uses the maven plugins and configuration provided by Google App Engine for local development and deployment.

Run locally:  
```mvn appengine:devserver```

Deploy:  
```mvn appengine:update```


