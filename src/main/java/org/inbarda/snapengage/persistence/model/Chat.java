package org.inbarda.snapengage.persistence.model;

/**
 * Created by Inbar on 19/02/2016.
 */
public class Chat {

    private int internalId = -1;
    private String id;
    private String widget_id;
    private String url;
    private String type;
    private String requested_by;
    private String description;
    private String created_at_date;
    private boolean proactive_chat;
    private String page_url;
    private String referrer_url;
    private String entry_url;
    private String ip_address;
    private String user_agent;
    private String browser;
    private String os;
    private String country_code;
    private String country;
    private String region;
    private String city;
    private double latitude;
    private double longitude;
    private int source_id;
    private int chat_waittime;
    private int chat_duration;
    private String language_code;
    private Transcript[] transcripts;

    public Chat() {
    }

    public String getId() {
        return id;
    }

    public String getWidget_id() {
        return widget_id;
    }

    public String getUrl() {
        return url;
    }

    public String getType() {
        return type;
    }

    public String getRequested_by() {
        return requested_by;
    }

    public String getDescription() {
        return description;
    }

    public String getCreated_at_date() {
        return created_at_date;
    }

    public boolean isProactive_chat() {
        return proactive_chat;
    }

    public String getPage_url() {
        return page_url;
    }

    public String getReferrer_url() {
        return referrer_url;
    }

    public String getEntry_url() {
        return entry_url;
    }

    public String getIp_address() {
        return ip_address;
    }

    public String getUser_agent() {
        return user_agent;
    }

    public String getBrowser() {
        return browser;
    }

    public String getOs() {
        return os;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getSource_id() {
        return source_id;
    }

    public int getChat_waittime() {
        return chat_waittime;
    }

    public int getChat_duration() {
        return chat_duration;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public Transcript[] getTranscripts() {
        return transcripts;
    }

    public int getInternalId() {
        return internalId;
    }

    public void setInternalId(int internalId) {
        this.internalId = internalId;
    }

}
