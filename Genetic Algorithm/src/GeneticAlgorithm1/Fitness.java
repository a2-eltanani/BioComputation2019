package GeneticAlgorithm1;

import static GeneticAlgorithm1.Individual.*;
import static GeneticAlgorithm1.StringData.*;
import static GeneticAlgorithm1.GA.*;

/**
* Author: Ali Eltanani
* Student ID: 16044867
* Module: UFCFY3-15-3 - Biocomputation 
 */
public class Fitness {
    static byte[] solution = new byte[defaultGeneLength];
    static boolean passed;
    static boolean OutputMatched = false;

    // Set solution as a byte array
    public static void setSolution(byte[] newSolution) {
        solution = newSolution;
    }

    
    // with string of 0s and 1s
    static void setSolution(String newSolution) {
        solution = new byte[newSolution.length()];
        // loop through each character of our string and save it in our byte array
        for (int i = 0; i < newSolution.length(); i++) {
            String character = newSolution.substring(i, i + 1);
            if (character.contains("0") || character.contains("1")) {
                solution[i] = Byte.parseByte(character);
            } else {
                solution[i] = 0;
            }
        }
    }
    
 

    static int getTheFitness(Individual individual) {
        int fitness = 0;

        currentGenes = individual.toString();
        ConvertingRandomStringToRules();
        //k = 60
        //j = 10 rules
        for (int k = 0; k < Condition.length; k++) { 
            for (int j = 0; j < ConditionForRandom.length; j++) { 
                passed = true;

                for (int i = 0; i < ConditionForRandom[i].length(); i++) {
                    if (passed == true) {
                        if (Condition[k].charAt(i) != ConditionForRandom[j].charAt(i)) {
                            if (ConditionForRandom[j].charAt(i) != '2') {
                                passed = false;
                            }
                        }
                    }
                }
                if (passed == true) {
                    if (Output[k].equals(OutputForRandom[j])) {
                        fitness++;
                    }
                   
                    break;

                }
                   
            }
                }
        
        return fitness;
    }

    static int getMaxFitness() {
        //Sets the max fitness
        int maxFitness = Condition.length; 
        return maxFitness;
    }


}
