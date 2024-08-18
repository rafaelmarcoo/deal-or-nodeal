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
    
    FileOutListOfWin folist = new FileOutListOfWin();
    FileOutGameLog folog = new FileOutGameLog();
    FileOutErrorLog foerror = new FileOutErrorLog();
    
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
                
                folist.FileOutListWin(Player.firstName, Player.lastName, offer);
                folog.FileOutLog(Player.firstName, Player.lastName, "Accepted banker's offer of $" + offer);
                folog.FileOutLog(Player.firstName, Player.lastName, "Game Finished.\n\n");
                foerror.FileOutLog(Player.firstName, Player.lastName, "Game Finished.\n\n");
                
                messageUI.displayExitMessage();
                System.exit(0);
            }
            else if(response.equalsIgnoreCase("n"))
            {
                folog.FileOutLog(Player.firstName, Player.lastName, "Rejected banker's offer of $" + offer);
                System.out.println();
                break;
            }
            else if(response.equalsIgnoreCase("x"))
            {
                folog.FileOutLog(Player.firstName, Player.lastName, "User quit game.");
                messageUI.displayExitMessage();
                System.exit(0);
            }
            else
            {
                foerror.FileOutLog(Player.firstName, Player.lastName, "Invalid! ('d' or 'n' only!) - MDeal");
                System.out.println("Invalid! ('d' or 'n' only!)\n");
            }
        }
        
    }
}
