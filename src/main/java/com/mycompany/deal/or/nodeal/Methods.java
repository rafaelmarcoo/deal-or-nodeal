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
    public abstract double bankerOffer(Cases cases);
    
    protected void displayWelcomeMessage() 
    {
        System.out.println("Welcome to Deal or No Deal!");
    }
}
