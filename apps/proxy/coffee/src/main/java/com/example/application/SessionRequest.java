package com.example.application;

public class SessionRequest {
    private long sessionId;
    private String type;

    public SessionRequest() {}

    public SessionRequest(long sessionId, String type) {
        this.sessionId = sessionId;
        this.type = type;
    }

    public long getSessionId() {
        return sessionId;
    }

    public String getType() {
        return type;
    }
}
