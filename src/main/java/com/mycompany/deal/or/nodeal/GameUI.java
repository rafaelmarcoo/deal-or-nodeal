/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

import java.util.Scanner;

/**
 *
 * @author rafae
 */
public class GameUI implements IGameUI
{
    @Override
    public void displayWelcomeMessage() 
    {
        System.out.println("\nWelcome to Deal or No Deal!");
        System.out.print("Enter 'w' to start a game! || Enter 't' for a tutorial! || To quit, enter 'x'!  => ");
    }
    
    @Override
    public void tutorial()
    {
        System.out.println("\n--------------------------------------------------"
                + "----------------------------------------------------------------------------------");
        System.out.println("\nThere are 26 cases, each containing various amount of prize money from as little as"
                + " $0.01 to a whopping $1,000,000.");
        System.out.println("\nHow to play:");
        System.out.println(" - You choose one case to keep for the game.");
        System.out.println(" - You will then select and open a number of cases each round, revealing the amounts.");
        System.out.println(" - After each round, the banker will offer you a cash amount to quit the game.");
        System.out.println(" - You can choose to 'Deal' and take the offer or 'No Deal' and continue playing");
        System.out.println(" - If you reach the final round and have one last case in the show left, you can choose to keep"
                + " the case you selected at the start, \nor swap it with the last remaining case in the display as your own case!");
        System.out.println("\n***** Good luck and have fun! *****");
        System.out.println("\n--------------------------------------------------"
                + "----------------------------------------------------------------------------------");
    }
    
    @Override
    public void displayExitMessage()
    {
        System.out.println("\n****************************************************************************************************************************");
        System.out.println("Thank you for playing Deal or No Deal! See you soon :)");
        System.out.println("****************************************************************************************************************************");
    }
    
    @Override
    public void showCases(Cases cases)
    {
        System.out.println("\nCases:");
        int count = 0;
        
        for(int i = 1; i <= cases.getCaseNums().length; i++)
        {
            if(count == 7)
            {
                System.out.println();
                count = 0;
            }
            
            if(!cases.getCases().containsKey(i))
            {
                System.out.print("{ X }  ");
            }
            else
            {
                System.out.print("{ " + i + " }  ");
            }
            count++;
        }
        System.out.println();
    }
    
    @Override
    public String getInput()
    {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine().trim();
    }
}
