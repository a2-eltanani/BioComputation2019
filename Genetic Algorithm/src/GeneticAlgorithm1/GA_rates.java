package GeneticAlgorithm1;

/**
* Author: Ali Eltanani
* Student ID: 16044867
* Module: UFCFY3-15-3 - Biocomputation 
 */
public class GA_rates {
    private static final double crossoverRate = 0.9;// 0.9(data set 1 & 2)
    private static final double mutationRate = 0.0009; // 0.0001, 0.0003, 0.0008(Data set 1) &  0.0009(Data Set 2)
    private static final int tournamentSize = 2; 
    private static final boolean superiority = true; 

    // Evolve a population
    public static Populations evolvePopulation(Populations pop) {
        Populations newPopulation = new Populations(pop.popSize(), false);

        // Keep the best individual
        if (superiority) {
            newPopulation.saveIndividual(0, pop.getFittest());
        }

        // Crossover population
        int superiorityOffset;
        if (superiority) {
            superiorityOffset = 1;
        } else {
           superiorityOffset = 0;
        }
        // Loop over the population size and create new individuals with crossover
        for (int i = superiorityOffset; i < pop.popSize(); i++) {
            Individual indiv1 = tournamentSelection(pop);
            Individual indiv2 = tournamentSelection(pop);
            Individual newIndiv = crossover(indiv1, indiv2);
            newPopulation.saveIndividual(i, newIndiv);
        }

        // Mutate population
        for (int i = superiorityOffset; i < newPopulation.popSize(); i++) {
            mutate(newPopulation.getIndividual(i));
        }

        return newPopulation;
    }

    // Crossover individuals
    private static Individual crossover(Individual Indi1, Individual Indi2) {
        //parse solution 
        Individual newSolution = new Individual();
        // Loop through genes
        for (int i = 0; i < Indi1.size(); i++) {
            // Crossover
            if (Math.random() <= crossoverRate) {
                newSolution.setGene(i, (byte) Indi1.getGene(i));
            } else {
                newSolution.setGene(i, (byte) Indi2.getGene(i));
            }
        }
        return newSolution;
    }

    // Mutate an individual
    private static void mutate(Individual indiv) {
        // Loop through genes
        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= mutationRate) {
              byte gene = (byte) Math.floor(Math.random() * 3);
                indiv.setGene(i, gene);
            }
        }
    }

    // Select individuals for crossover
    private static Individual tournamentSelection(Populations pop) {
        // Create a tournament population
        Populations tournament = new Populations(tournamentSize, false);
        // For each place in the tournament get a random individual
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.popSize());
            tournament.saveIndividual(i, pop.getIndividual(randomId));
        }
        Individual fittest = tournament.getFittest();
        //retrieve fittest
        return fittest; 
    }
}
