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
    MechanicsChangeCase Mchange = new MechanicsChangeCase();
    MechanicsDeal Mdeal = new MechanicsDeal();

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
                
                while(roundNum < 5)
                {
                    Mplay.playRound(cases, roundNum);    
                    
                    if(roundNum <= 2)
                    {
                        System.out.println("You have a chance to change your case from the end Round 3!");
                    }
                      
                    System.out.println("End of Round " + roundNum);
                    double offer = Mbanker.bankerOffer(cases);
                    Mdeal.dealornodeal(offer);
                    
                    if(roundNum == 3 || roundNum == 4)
                    {
                        while(true)
                        {
                            System.out.print("Having mixed feelings now? You can change your case! (y or n) => ");
                            response = inputUI.getInput();

                            if(response.equalsIgnoreCase("y"))
                            {
                                Mchange.changeCase(cases);
                                break;
                            }
                            else if(response.equalsIgnoreCase("n"))
                            {
                                System.out.println();
                                break;
                            }
                            else
                            {
                                System.out.println("Invalid!\n");
                            }
                        }
                    }
                    roundNum++;
                }
                //
                
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
