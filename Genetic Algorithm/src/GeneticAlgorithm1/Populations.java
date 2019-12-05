package GeneticAlgorithm1;

/**
* Author: Ali Eltanani
* Student ID: 16044867
* Module: UFCFY3-15-3 - Biocomputation 
 */
public class Populations {


    Individual[] individuals;
    // Create population
    public Populations(int populationSize, boolean initialise) {
        individuals = new Individual[populationSize];
        // Initialise population
        if (initialise) {
            // Loop and create individuals
            for (int i = 0; i < popSize(); i++) {
                Individual newIndividual = new Individual();
                newIndividual.generateIndividual();
                saveIndividual(i, newIndividual);
            }
        }
    }

   
    public Individual getIndividual(int index) {
        return individuals[index];
    }

    public Individual getFittest() {
        Individual fittest = individuals[0];
        // Loop through individuals to find fittest
        for (int i = 0; i < popSize(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }

    public int popSize() {
        return individuals.length;

    }

    public void saveIndividual(int index, Individual indiv) {
        individuals[index] = indiv;
    }
}
