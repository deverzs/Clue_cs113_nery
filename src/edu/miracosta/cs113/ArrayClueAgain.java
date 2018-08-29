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
 * @author Nery Chapeton-Lamas (material from Kevin Lewis), Zsuzsanna Dianovics
 * @version 1.0
 *
 */

import java.util.Scanner;
import model.Theory;
import model.AssistantJack;


public class ArrayClueAgain {

    /*
     * ALGORITHM:
     *
     * PROMPT "Which theory to test? (1, 2, 3[random]): "
     * READ answerSet
     * INSTANTIATE jack = new AssistantJack(answerSet)
     * INSTANTIATE weapon = 1, location = 1, murder = 1
     * LOOP until solution is zero
     *      if solution is zero, exit
     *      if solution is 1, increment weapon
     *      if solution is 2, increment location
     *      if solution is 3, increment murder
     *      in any case but 0, decrement loop variable
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

        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);
        weapon = 1 ;
        location = 1 ;
        murder = 1 ;
        int locid ;


        // INPUT
        System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        // PROCESSING
        jack = new AssistantJack(answerSet);
        for (locid = 0 ; locid < 10 ; locid++){
            solution = jack.checkAnswer( weapon, location, murder );
            if (solution == 0) {
                answer = new Theory( weapon, location, murder) ;
                // OUTPUT
                System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

                if (jack.getTimesAsked() > 20) {
                    System.out.println("FAILED!! You're a horrible Detective...");
                } else {
                    System.out.println("WOW! You might as well be called Batwoman!");
                }
                System.exit(0);
            }
            if (solution == 1) {
                weapon++;
                locid--;
            }
            if (solution == 2) {
                location++;
                locid--;
            }
            if (solution == 3) {
                murder++;
                locid--;
            }
        }








    }






}

