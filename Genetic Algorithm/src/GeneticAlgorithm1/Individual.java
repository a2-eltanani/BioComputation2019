package GeneticAlgorithm1;
import java.util.Random;
/**
* Author: Ali Eltanani
* Student ID: 16044867
* Module: UFCFY3-15-3 - Biocomputation 
 */
public class Individual {

    static int defaultGeneLength = 360 ; 
    private int[] genes = new int[defaultGeneLength];
    private int fitness = 0;
    Random rand = new Random();

    // Create a random individual
    public void generateIndividual() {
        for (int i = 0; i < size(); i++) {
           if (0.5 < Math.random()) { 
              int gene = 1;

                genes[i] = gene;
            } else {
               byte gene = 0;

                
                genes[i] = gene;
            }
        }
    }

    
    // To create individuals with different gene lengths
    public static void setDefaultGeneLength(int length) {
        defaultGeneLength = length;
    }

    public int getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, byte value) {
        genes[index] = value;
        fitness = 0;
    }

   
    public int size() {
        return genes.length;
    }

    public int getFitness() {
        if (fitness == 0) {
            fitness = Fitness.getTheFitness(this);
        }
        return fitness;
    }

    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += getGene(i);
        }
        return geneString;
    }


}
