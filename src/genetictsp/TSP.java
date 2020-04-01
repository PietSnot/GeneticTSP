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
 *
 * Main, executive class for the Traveling Salesman Problem.
 *
 * We don't have a real list of cities, so we randomly generate a number of them
 * on a 100x100 map.
 *
 * The TSP requires that each city is visited once and only once, so we have to
 * be careful when initializing a random Individual and also when applying
 * crossover and mutation. Check out the GeneticAlgorithm class for
 * implementations of crossover and mutation for this problem.
 *
 * @author bkanber
 *
 */
public class TSP {

    public static int maxGenerations = 100;
    public static List<String> cities;

    public static void main(List<String> cityNames, List<String> distances) {

        // check for consistency
        if (cityNames.size() * cityNames.size() != distances.size()) {
            throw new RuntimeException("data do not match!");
        }

        // Create cities
        int numCities = cityNames.size();
        City[] cities = new City[numCities];

        // Loop to create random cities
        for (int i = 0; i < numCities; i++) {
            // Add city
            cities[i] = new City(i, cityNames.get(i), distances.subList(i * numCities, (i + 1) * numCities));
        }

        // Initial GA
//        GeneticAlgorithm ga = new GeneticAlgorithm(numCities, 0.001, 0.9, 2, 5);
        GeneticAlgorithm ga = new GeneticAlgorithm(numCities, 0.001, 0.9, 2, Math.min(numCities, 5));
        // Initialize population
        Population population = ga.initPopulation(cities.length);

        // Evaluate population
        ga.evalPopulation(population, cities);

        Route startRoute = new Route(population.getFittest(0), cities);
        System.out.println("Start Distance: " + startRoute.getDistance());

        // Keep track of current generation
        int generation = 1;
        // Start evolution loop
        while (ga.isTerminationConditionMet(generation, maxGenerations) == false) {
            // Print fittest individual from population
            Route route = new Route(population.getFittest(0), cities);
            System.out.println("G" + generation + "  route: " + route + " Best distance: " + route.getDistance());

            // Apply crossover
            population = ga.crossoverPopulation(population);

            // Apply mutation
            population = ga.mutatePopulation(population);

            // Evaluate population
            ga.evalPopulation(population, cities);

            // Increment the current generation
            generation++;
        }

        System.out.println("Stopped after " + maxGenerations + " generations.");
        Route route = new Route(population.getFittest(0), cities);
        System.out.println("Best distance: " + route.getDistance());
//        for (int i = 0; i < route.)

    }
}
