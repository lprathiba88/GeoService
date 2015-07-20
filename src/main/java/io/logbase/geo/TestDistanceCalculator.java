package io.logbase.geo;

import java.io.IOException;

/**
 * Created by prathikarthik on 7/16/15.
 */
public class TestDistanceCalculator {

    public static void main(String args[]) throws IOException {

        DistanceCalculator distanceCalculator = new DistanceCalculator();

        for(double i=10;i<14;i++){

            double j = 80;

            System.out.println("Total distance:"+distanceCalculator.getDistance(i, j));
            System.out.println("Location Name:" + distanceCalculator.getLocation(i,j));

        }

    }

}
