package io.logbase.geo;

import com.google.maps.model.LatLng;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by prathikarthik on 7/16/15.
 */
public class TestDistanceCalculator {

    public static void main(String args[]) throws Exception {

        //DistanceCalculator distanceCalculator = new DistanceCalculator();

        long start = System.currentTimeMillis();

        //for(double i=10;i<15;i++){

            //double j = 80;

            LatLng latLng = new LatLng(11,77);
            String apiKey = "AIzaSyDB9ak9f_M49qsxKI5eY43MRUFDpFZxrIQ";
            String addressType = "SUBLOCALITY";
            //GeoLocation.getLocation(latLng);
            System.out.println("Location:"+GeoLocation.getLocation(latLng, apiKey, addressType));

            //System.out.println("Total distance:"+distanceCalculator.getDistance(i, j));
            //System.out.println("Location Name:" + distanceCalculator.getLocation(i,j));

        //}
        long now = System.currentTimeMillis();
        double totalTime = (now - start)/1000.0;
        System.out.println("Total time taken for all requests:" + totalTime + "seconds");

        /*Iterator iterator = distanceCalculator.response.iterator();
        while(iterator.hasNext()){

            String element = (String) iterator.next();
            System.out.println("Response"+element);

        }*/

    }
}
