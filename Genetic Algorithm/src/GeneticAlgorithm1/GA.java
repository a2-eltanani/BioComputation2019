package GeneticAlgorithm1;

/**
* Author: Ali Eltanani
* Student ID: 16044867
* Module: UFCFY3-15-3 - Biocomputation 
 */
import static GeneticAlgorithm1.Ruleset1.*;
import static GeneticAlgorithm1.StringData.*;
import static GeneticAlgorithm1.Ruleset2.*;
import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator.Fitness.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class GA {

    static int RuleSet;
    static String[] DataRule, Condition, Output;
    static String DataString = "";
    

    public static void main(String[] args) throws FileNotFoundException {
        //Comment out depending on which data set is being used: "GettingRulesData1" ,"GettingRulesData2"
         RuleSet = 7; 
         GettingRulesData1(); //data set 1
         //GettingRulesData2(); //data set 2
         

        Fitness.setSolution(DataString);
        System.out.print("Rules from data: ");
        for (int i = 0; i < DataRule.length; i++) {
            System.out.print(DataRule[i] + "  ");
        }
        System.out.println("");
        Populations myPop = new Populations(50, true);//50,100,200

        System.out.println("Random String " + myPop.getFittest()); 

        //Declares the generation count to start at 0
        int generationsCounter = 0;

        // Evolve our population until we reach the solution
        //Repeat until the maximum fitness has been reached
        while (myPop.getFittest().getFitness() < Fitness.getMaxFitness()) { 
            generationsCounter++; 
            System.out.println("Generation: " + generationsCounter + " Fittness: " + myPop.getFittest().getFitness());
            for (int k = 0; k < myPop.individuals.length; k++) {
                for (int i = 1; i < myPop.individuals.length; i++) {
                    int j = i - 1;
                    if (myPop.individuals[j].getFitness() <= myPop.individuals[i].getFitness()) { 
                        Individual temp = myPop.individuals[j];
                        myPop.individuals[j] = myPop.individuals[i];
                        myPop.individuals[i] = temp;
                        
                }
            }

            for (int i = 0; i < myPop.individuals.length; i++) {
                System.out.print(myPop.individuals[i].getFitness() + " > ");
            }
            System.out.println("");

            System.out.println("Average Fitness is: " + myPop.individuals[25].getFitness()); //average
            System.out.println( "Worst Fitness is: " + myPop.individuals[49].getFitness()); //worst
            System.out.println( "Best Fitness is: " + myPop.individuals[1].getFitness()); //best

            System.out.print("Rules from data:        ");
            for (int i = 0; i < DataRule.length; i++) {
                System.out.print(Condition[i] + " " + Output[i] + "  ");
            }

            System.out.println("");

            System.out.print("Rules for current gene: ");
            for (int j = 0; j < RandRule.length; j++) {
               System.out.print(ConditionForRandom[j] + " " + OutputForRandom[j] + "  ");
            }
            System.out.println("");

            myPop = GA_rates.evolvePopulation(myPop); 
        }
        generationsCounter++;
        System.out.println("The correct solution has been found.");
        System.out.println("Fitness: " + myPop.getFittest().getFitness());
        System.out.println("Generations: " + generationsCounter);
        System.out.println("");
        //Print out the data and rules during testing data sets
        System.out.println("Data : " + DataString);
        System.out.println("Rules: " + myPop.getFittest());
        System.out.println("Data to match are: ");
        for (int i = 0; i < DataRule.length; i++)
        {
            System.out.print(Condition[i] + " " + Output[i] + " ");;
        }
    
        System.out.println("Rules to match are: ");
        for (int i = 0; i < RandRule.length; i++)
        {
            System.out.print(ConditionForRandom[i] + " " + OutputForRandom[i] + " ");;
        }
        
       
    }

    }
}
    
    

    
    
    

