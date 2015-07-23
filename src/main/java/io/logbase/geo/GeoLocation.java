package io.logbase.geo;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

/**
 * Created by prathikarthik on 7/22/15.
 */
public class GeoLocation {

    public static String getLocation(LatLng latLong, String apiKey, String addressType) throws Exception {

        GeoApiContext context = new GeoApiContext().setApiKey(apiKey);
        GeocodingResult[] results =  GeocodingApi.reverseGeocode(context,latLong).await();

        String location="";

        for(int i=0;i<results[0].addressComponents.length;i++){

            for(int j=0;j<results[0].addressComponents[i].types.length;j++) {

                if (((results[0].addressComponents[i].types[j].toString()).equals(addressType))){

                    location += " "+String.valueOf(results[0].addressComponents[i].longName);

                }
            }
        }

        return location;
    }
}
