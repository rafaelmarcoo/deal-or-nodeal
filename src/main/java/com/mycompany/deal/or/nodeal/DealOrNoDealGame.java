/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;
/**
 *
 * @author rafae
 */
public class DealOrNoDealGame extends GameMechanics implements IGameStart
{
    private final Cases cases;
    
    public DealOrNoDealGame()
    {
        cases = new Cases();
    }
    
    @Override
    public void startGame() 
    {   
        while(true)
        {
            displayWelcomeMessage();
            String response = getInput();
            
            if(response.equalsIgnoreCase("w"))
            {
                selectCase(cases);
                
                while(GameMechanics.roundNum <= 5)
                {
                    playRound(cases, roundNum);    
                    System.out.println("End of Round " + roundNum);
                    bankerOffer(cases);

                    roundNum++;
                }
                
            }
            else if(response.equalsIgnoreCase("t"))
            {
                tutorial();
                continue;
            }
            else if(response.equalsIgnoreCase("x"))
            {
                displayExitMessage();
                break;
            }
            else
            {
                System.out.println("\nInvalid input!");
                continue;
            }
            
            System.out.println("Your case " + playerCase + " contains $" + playerCaseValue);
            displayExitMessage();
            break;
        }
    }
}
