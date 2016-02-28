package com.example.shruj.inclass07;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by shruj on 02/22/2016.
 */
public class NewsUtilUsingPull {
    public static class NewsPullParser {


        static ArrayList<News> parseNews(InputStream inputStream) throws XmlPullParserException, IOException {

            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(inputStream, String.valueOf(Xml.Encoding.UTF_8));
            ArrayList<News> newsArrayList = new ArrayList<>();
            News news = null;
            Boolean itemFound = false;
            int event = parser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {
                switch (event) {

                    case XmlPullParser.START_TAG:

                        if (parser.getName().equals("item")) {
                            itemFound = true;
                            if (itemFound) {
                                news = new News();
                            }

                        } else if (parser.getName().equals("title")) {
                            if (itemFound) {
                                news.setTitle(parser.nextText().trim());
                            }
                        } else if (parser.getName().equals("link")) {
                            if (itemFound) {
                                news.setLink(parser.nextText().trim());
                            }
                        } else if (parser.getName().equals("pubDate")) {
                            if (itemFound) {
                                news.setDatePublishDate(parser.nextText());
                            }
                        } else if (parser.getName().equals("description")) {
                            if (itemFound) {
                                news.setDescription(parser.nextText().trim());
                            }
                        } else if (parser.getName().equals("media:thumbnail")) {
                            if (itemFound) {
                                news.setUrl(parser.getAttributeValue(null, "url"));
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("item")) {
                            if (itemFound)
                                newsArrayList.add(news);
                            news = null;
                        }
                }
                event = parser.next();
            }

            return newsArrayList;

        }
    }
}
