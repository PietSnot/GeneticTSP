/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package genetictsp;

import java.util.List;

/**
 *
 * @author Piet
 */
public class GeneticTSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> cities = List.of("A", "B", "C", "D");
        List<String> distances = List.of(
            "1 m", "2.0 km", "4.5 km", "3.2 km",
            "2.5 km", "1 m", "4.6 km", "3.3 km",
            "5 km", "6 km", "1 m", "3 km",
            "3 km", "1 km", "3 km", "1 m"
        );
        TSP.main(cities, distances);
    }

}
