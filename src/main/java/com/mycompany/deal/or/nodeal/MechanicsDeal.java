/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

/**
 *
 * @author rcman
 */
public class MechanicsDeal extends MechanicsControl implements IDeal
{
    GameInputUI inputUI = new GameInputUI();
    GameMessageUI messageUI = new GameMessageUI();
    GameCompareUI compareUI = new GameCompareUI();
    
    @Override
    public void dealornodeal(double offer)
    {
        while(true)
        {
            System.out.print("Deal? Or No Deal ? ('d' or 'n') => ");
            String response = inputUI.getInput();
            
            if(response.equalsIgnoreCase("d"))
            {
                System.out.println("\nCongratulations! You will take home $" + offer + "!");
                System.out.println("Your case " + playerCase + " contains $" + playerCaseValue);
                System.out.println();
                compareUI.compareValues(offer, playerCaseValue);
                messageUI.displayExitMessage();
                System.exit(0);
            }
            else if(response.equalsIgnoreCase("n"))
            {
                System.out.println();
                break;
            }
            else if(response.equalsIgnoreCase("x"))
            {
                messageUI.displayExitMessage();
                System.exit(0);
            }
            else
            {
                System.out.println("Invalid!\n");
            }
        }
        
    }
}
