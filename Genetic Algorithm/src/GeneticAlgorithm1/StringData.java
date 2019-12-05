package GeneticAlgorithm1;
import static GeneticAlgorithm1.Individual.*;
import static GeneticAlgorithm1.GA.*;
/**
* Author: Ali Eltanani
* Student ID: 16044867
* Module: UFCFY3-15-3 - Biocomputation 
 */
public class StringData {
    
    static String currentGenes = "";
    static String set = "";
    static String set1 = "";
    static String set2 = "";
    static String[] RandRule = new String[defaultGeneLength/RuleSet];
    static String[] OutputForRandom = new String[defaultGeneLength/RuleSet];
    static String[] ConditionForRandom = new String[defaultGeneLength/RuleSet];

    public static void ConvertingRandomStringToRules() {
        
        int k = 0;
        for (int i = 1; i < currentGenes.length() + 1; i++) {
            set += currentGenes.charAt(i - 1);
            int test = i % RuleSet;
            if (test == 0) {
                RandRule[k] = set;
                k++;
                set = "";
            }
        }

        
        for (int j = 0; j < RandRule.length; j++) {
            OutputForRandom[j] = String.valueOf(RandRule[j].charAt(RuleSet-1));
        }

        
        for (int l = 0; l < RandRule.length; l++) {
            set1 = "";
            for (int m = 0; m < RuleSet -1; m++) {

                set1 += String.valueOf(RandRule[l].charAt(m));
                ConditionForRandom[l] = set1;

            }

        }
    }
}
