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
    MechanicsLastPlay Mlast = new MechanicsLastPlay();
    MechanicsGetName Mname = new MechanicsGetName();
    
    FileOutGameLog folog = new FileOutGameLog();
    FileOutErrorLog foerror = new FileOutErrorLog();
       
    @Override
    public void startGame() 
    {   
        while(true)
        {
            messageUI.displayWelcomeMessage();
            String response = inputUI.getInput();
            
            if(response.equalsIgnoreCase("w"))
            {
                String firstName = Mname.getFirstName();
                String lastName = Mname.getLastName();
                player = new Player(firstName, lastName);
                folog.FileOutLog(firstName, lastName, "Entered first and last name.");
                
                Mselect.selectCase(cases);
                
                while(roundNum <= 4)
                {
                    Mplay.playRound(cases, roundNum);    
                    
                    if(roundNum <= 2)
                    {
                        System.out.println("** You have a chance to change your case from the end Round 3! **");
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
                                folog.FileOutLog(firstName, lastName, "Decided to swap case.");
                                Mchange.changeCase(cases);
                                break;
                            }
                            else if(response.equalsIgnoreCase("n"))
                            {
                                folog.FileOutLog(firstName, lastName, "Refused to swap case.");
                                System.out.println();
                                break;
                            }
                            else
                            {
                                foerror.FileOutLog(firstName, lastName, "Invalid input - Swapping Cases");
                                System.out.println("Invalid!\n");
                            }
                        }
                    }
                    roundNum++;
                }
                
                if(roundNum == 5)
                {
                    Mlast.playRound(cases, roundNum);
                    Mlast.lastPlay(cases);
                }
            }
            else if(response.equalsIgnoreCase("t"))
            {
                messageUI.tutorial();
                continue;
            }
            else if(response.equalsIgnoreCase("x"))
            {
                folog.FileOutLog(Player.firstName, Player.lastName, "User quit game.\n\n");
                messageUI.displayExitMessage();
                break;
            }
            else
            {
                System.out.println("\nInvalid input!");
                continue;
            }
            
            folog.FileOutLog(Player.firstName, Player.lastName, "Game Finished.\n\n");
            messageUI.displayExitMessage();
            break;
        }
    }
}
