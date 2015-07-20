package io.logbase.geo; /**
 * Created by prathikarthik on 7/16/15.
 */
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DistanceCalculator {

    private Double latitude;
    private Double longitude;
    private double totalDistance;

    public double getDistance(double latitude, double longitude) {

        if (this.latitude == null && this.longitude == null) {

            System.out.println("First set of latitude and longitude received");
            totalDistance=0;

        } else {

            final int R = 6371; // Radius of the earth

            Double latDistance = Math.toRadians(latitude - this.latitude);
            Double lonDistance = Math.toRadians(longitude - this.longitude);
            Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                    + Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(latitude))
                    * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
            Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double distance = R * c; // in Kilometers

            totalDistance = totalDistance+distance;

        }

        this.latitude = latitude;
        this.longitude = longitude;

        return totalDistance;

    }

    public String getLocation(double latitude, double longitude) throws IOException {

        URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?latlng="
                + latitude + "," + longitude + "&sensor=true");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        String formattedAddress = "";

        try {
            InputStream in = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String result, line = reader.readLine();
            result = line;
            while ((line = reader.readLine()) != null) {
                result += line;
            }

            JSONParser parser = new JSONParser();
            JSONObject rsp = (JSONObject) parser.parse(result);

            if (rsp.containsKey("results")) {
                JSONArray matches = (JSONArray) rsp.get("results");
                JSONObject data = (JSONObject) matches.get(0); //TODO: check if idx=0 exists
                formattedAddress = (String) data.get("formatted_address");
            }

            return "";
        }

        finally {
            urlConnection.disconnect();
            return formattedAddress;
        }

    }

}
