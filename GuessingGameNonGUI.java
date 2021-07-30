/* Lee Joey Noel
10/13/2020
Project #3 Guessing game */

import java.util.*;     //will be used for the random class
import javax.swing.*;   // used for the JFrame class and also the JOptionPane Class.
class GuessingGameNonGUI        //Class file which will be named GuessingGameNonGUI.java
{
    static JFrame  x = new JFrame();    // new object created for the JFrame class
    static boolean PlayGame(int Num)
    {
        String msg ="";
        for(int i = 4 ; i > 0; i--) 
        {
            int guess = Integer.parseInt(JOptionPane.showInputDialog(x,"("+i+" Guesses leftover) "+msg+"Choose a number (1-10)?")); // this will geneater the game to call the message onto what number to choose between 1-10.
            int comparison = compareTo(Num, guess);
            if(comparison > 0)
            msg = "Number too high! Pick Again! ";        // will assist you into known what number will get you closer and closer to the right one
            else if (comparison < 0)
            msg = "Number too low! Pick Again! ";         // will assist you into known what number will get you closer and closer to the right one
            else return true;
        }
        return false;
    }
    static int compareTo(int Num, int guess)
    {
        return guess-Num;
    }
    public static void main(String[] args) 
    {
        int a;
        Random random = new Random();   //Object created for the Random Class
        do
        {
            int Number = random.nextInt(10)+1;     // this will generate any random integer between the number (1 - 10)
            boolean Results = PlayGame(Number);      // Calls out PlayGame by passing the nmber that needed to be guessed correctly
            if(Results)
            a = JOptionPane.showConfirmDialog(x, "(Game is Over) Congrats! you are correct! Try Again  "); // When getting the random number correct, it will generate this option
            else a = JOptionPane.showConfirmDialog(x, "(Game is Over) Sorry, you lost! (The number was "+Number+") Try again "); // when generated inncorect it will generate this function and tell you if you would like to try again.
            if (a!=JOptionPane.YES_OPTION)  // if the user clicks anything than the yes then the program would close.
            System.exit(0);
        }while(a==JOptionPane.YES_OPTION);
    } 
}