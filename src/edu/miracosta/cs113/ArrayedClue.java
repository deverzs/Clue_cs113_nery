package edu.miracosta.cs113;

/**
 * RandomClue.java : Your job is to ask your AssistantJack and get the correct
 * answer in <= 20 tries.  RandomClue is ONE solution to the problem,
 * where a set of random numbers is generated every attempt until all three
 * random numbers match the solution from the AssistantJack object.
 *
 * This is a sample solution, a driver using random number implementation.
 * You can use this file as a guide to create your own SEPARATE driver for
 * your implementation that can solve it in <= 20 times consistently.
 *
 * @author Nery Chapeton-Lamas (material from Kevin Lewis)
 * @version 1.0
 *
 */

import java.util.Random;
import java.util.Scanner;
import model.Theory;
import model.AssistantJack;


public class ArrayedClue {

    /*
     * ALGORITHM:
     *
     * PROMPT "Which theory to test? (1, 2, 3[random]): "
     * READ answerSet
     * INSTANTIATE jack = new AssistantJack(answerSet)
     * LOOP 6 times, i= 0 to 5
     *      check solution set against Jack
     *          if = 0, DONE
     *          if = 1 , weapon wrong, set weaponArray @i to 1
     *          if = 2 , location wrong, set locationArray @i to 1
     *          if = 3 , murderer wrong, set murderArray @i to 1
     * DO
     *      weapon = first spot in weaponArray that is 0
     *      location = first spot in locationArray that is 0
     *      murder = first spot in murderArray that is 0
     *      solution = jack.checkAnswer(weapon, location, murder)
     *          if = 1 , weapon wrong, set weaponArray @i to 1
     *          if = 2 , location wrong, set locationArray @i to 1
     *          if = 3 , murderer wrong, set murderArray @i to 1
     * WHILE solution != 0
     *
     * OUTPUT "Total checks = " + jack.getTimesAsked()
     * IF jack.getTimesAsked() is greater than 20 THEN
     *      OUTPUT "FAILED"
     * ELSE
     *      OUTPUT "PASSED"
     * END IF
     *
     */

    /**
     * Driver method for random guessing approach
     *
     * @param args not used for driver
     */
    public static void main(String[] args) {
        // DECLARATION + INITIALIZATION
        int answerSet, solution, murder, weapon, location;
        int[] murderArray = new int[6];
        int[] locationArray = new int[10];
        int[] weaponArray = new int[6];
        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);


        // INPUT
        System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        // PROCESSING
        jack = new AssistantJack(answerSet);



        for (int i = 0; i < 6 ; i++) {
            solution = jack.checkAnswer(i,i,i);

            // Solution is zero, therefore we're done
            if (solution == 0) {
                answer = new Theory(i, i, i) ;
                // OUTPUT
                System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

                if (jack.getTimesAsked() > 20) {
                    System.out.println("FAILED!! You're a horrible Detective...");
                } else {
                    System.out.println("WOW! You might as well be called Batwoman!");
                }
                System.exit(0);
            }
            // Otherwise, mark false for the returned incorrect weapon
            if (solution == 1) {
                weaponArray[i] = 1 ; // 1 = definitely not this one
            }
            if (solution == 2) {
                locationArray[i] = 1 ;
            }
            if (solution == 3) {
                murderArray[i] = 1 ;
            }

        }

        do {
            weapon = checkArray(weaponArray) ;
            location = checkArray(locationArray) ;
            murder = checkArray(murderArray) ;

            solution = jack.checkAnswer(weapon, location, murder) ;
            if (solution == 0) {
                break;
            }

            if (solution == 1) {
                weaponArray[weapon] = 1 ; // 1 = definitely not this one
            }
            if (solution == 2) {
                locationArray[location] = 1 ;
            }
            if (solution == 3) {
                murderArray[murder] = 1 ;
            }

            /*
            // checking array content
            for (int j = 0; j < weaponArray.length; j++) {
                System.out.println(weaponArray[j]);
            }
            for (int j = 0; j < locationArray.length; j++) {
                System.out.println(locationArray[j]);
            }
            for (int j = 0; j < murderArray.length; j++) {
                System.out.println(murderArray[j]);
            } */

        } while (solution != 0) ;


        answer = new Theory(weapon, location, murder);

        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!");
        }

    }
    public static int checkArray(int[] array){
        int possibility = 0;

        for (int i = 0; i < array.length ; i++){
            if (array[i] == 0) {
                possibility = i ;
                break ;
            }
        }

        return possibility;
    }


}
