package com.entity;

import java.util.Date;

public class Message {
        private Integer id;
        private String title;
        private String artical;
        private String username;
        private Date reporttime;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtical() {
        return artical;
    }

    public void setArtical(String artical) {
        this.artical = artical;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getReporttime() {
        return reporttime;
    }

    public void setReporttime(Date reporttime) {
        this.reporttime = reporttime;
    }
}