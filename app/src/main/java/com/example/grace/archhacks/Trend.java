package com.example.grace.archhacks;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import org.json.JSONArray;

/**
 * Created by Grace on 11/5/2016.
 */

@ParseClassName("Trend")
public class Trend extends ParseObject {

    public Trend() {super();}

    public void initializeTrends() { put("trends", new JSONArray()); }

    public void addToTrend(String emotionalLevel) {
        JSONArray trends = getJSONArray("trends");

        this.add("trends",emotionalLevel);

        this.saveInBackground();
    }
}
