package com.example.shruj.inclass07;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shruj on 02/22/2016.
 */
public class News implements Serializable {
    String title, description, link, url;
    Date datePublishDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {

        return url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDatePublishDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M/dd/yyyy h:MM a");
        return simpleDateFormat.format(datePublishDate);
    }

    public void setDatePublishDate(String datePublishDate)  {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
        try {
            this.datePublishDate = simpleDateFormat.parse(datePublishDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", datePublishDate='" + datePublishDate + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
