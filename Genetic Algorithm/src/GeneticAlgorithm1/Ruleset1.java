package GeneticAlgorithm1;

import java.util.Scanner;
import static GeneticAlgorithm1.GA.*;

/**
* Author: Ali Eltanani
* Student ID: 16044867
* Module: UFCFY3-15-3 - Biocomputation 
 */
public class Ruleset1 {
    //import
    static Scanner rules = new Scanner(Ruleset1.class.getResourceAsStream("data1.txt"));
    static String set2 = "";

    static public void GettingRulesData1() {
        DataRule = new String[60];
        Condition = new String[60];
        Output = new String[60];//60



        //Read the whole file
        for (int i = 0; i < 60; i++) { //read each line
            DataRule[i] = rules.nextLine().replaceAll("\\s+", ""); 
        }
        
        for (int j = 0; j < DataRule.length; j++) {
            DataString += DataRule[j];
        }
        
        for (int k = 0; k < DataRule.length; k++) {
            Output[k] = String.valueOf(DataRule[k].charAt(6));
        }
    

        for (int l = 0; l < DataRule.length; l++) {
            set2 = "";
            for (int m = 0; m < 6; m++) {
                set2 += String.valueOf(DataRule[l].charAt(m));
                Condition[l] = set2;
            }

        }

    }

}
