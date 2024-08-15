/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

/**
 *
 * @author rafae
 */
public class MechanicsStartGame extends MechanicsControl implements IGameStart
{
    GameInputUI inputUI = new GameInputUI();
    GameMessageUI messageUI = new GameMessageUI();
    
    MechanicsCaseSelect Mselect = new MechanicsCaseSelect();
    MechanicsBanker Mbanker = new MechanicsBanker();
    MechanicsPlayRound Mplay = new MechanicsPlayRound();

//    private final Cases cases = new Cases();
    
    @Override
    public void startGame() 
    {   
        while(true)
        {
            messageUI.displayWelcomeMessage();
            String response = inputUI.getInput();
            
            if(response.equalsIgnoreCase("w"))
            {
                Mselect.selectCase(cases);
                
                while(GameMechanics.roundNum <= 5)
                {
                    Mplay.playRound(cases, roundNum);    
                    System.out.println("End of Round " + roundNum);
                    Mbanker.bankerOffer(cases);

                    roundNum++;
                }
                
            }
            else if(response.equalsIgnoreCase("t"))
            {
                messageUI.tutorial();
                continue;
            }
            else if(response.equalsIgnoreCase("x"))
            {
                messageUI.displayExitMessage();
                break;
            }
            else
            {
                System.out.println("\nInvalid input!");
                continue;
            }
            
            System.out.println("Your case " + playerCase + " contains $" + playerCaseValue);
            messageUI.displayExitMessage();
            break;
        }
    }
}
