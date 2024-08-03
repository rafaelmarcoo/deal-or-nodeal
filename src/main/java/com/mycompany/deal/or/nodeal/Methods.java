/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

/**
 *
 * @author rafae
 */
public abstract class Methods
{
    public abstract void showCases(Cases cases);
    public abstract void startGame();
    public abstract void selectCase(Cases cases);
    public abstract void playRound(Cases cases, int roundNum);
    public abstract void bankerOffer(Cases cases);
    public abstract void tutorial();
    
    protected void displayWelcomeMessage() 
    {
        System.out.println("\nWelcome to Deal or No Deal!");
        System.out.print("Enter 'w' to start a game! || Enter 't' for a tutorial! || To quit, enter 'x'!  => ");
    }
    
    protected void displayExitMessage()
    {
        System.out.println("\n****************************************************************************************************************************");
        System.out.println("Thank you for playing Deal or No Deal! See you soon :)");
        System.out.println("****************************************************************************************************************************");

    }
}
