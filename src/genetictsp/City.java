/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetictsp;

import java.util.List;

/**
 *
 * @author Piet A simple abstraction of a city. This class maintains Cartesian
 * coordinates and also knows the Pythagorean theorem.
 *
 * @author bkanber
 *
 */
public class City {
    int index;
    String name;
    double[] distances;

    public City(int index, String name, List<String> distanceData) {
        this.index = index;
        this.name = name;
        processDistances(distanceData);
    }
    
    private void processDistances(List<String> distanceData) {
        distances = new double[distanceData.size()];
        for (int i = 0; i < distances.length; i++) {
            String[] split = distanceData.get(i).split("\\s+");
            if (split[1].equals("km")) distances[i] = Double.parseDouble(split[0]);
            else distances[i] = 0;
        }
    }

    /**
     * Calculate distance from another city
     * @param city The city to calculate the distance from
     * @return distance The distance from the given city
     */
    public double distanceFrom(City city) {
        return distances[city.index];
    }

//    /**
//     * Get x position of city
//     *
//     * @return x X position of city
//     */
//    public int getX() {
//        return this.x;
//    }

//    /**
//     * Get y position of city
//     *
//     * @return y Y position of city
//     */
//    public int getY() {
//        return this.y;
//    }
    @Override
    public String toString() {
        return "" + index;
    }
}
