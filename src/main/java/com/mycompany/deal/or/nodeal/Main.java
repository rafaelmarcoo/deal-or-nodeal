/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

/**
 *
 * @author rafae
 */
public class Main 
{
    public static void main(String[] args) 
    {
        Cases cases = new Cases();
        DealOrNoDealGame game = new DealOrNoDealGame();
        
        game.displayWelcomeMessage();
        game.showCases(cases);
    }
}
