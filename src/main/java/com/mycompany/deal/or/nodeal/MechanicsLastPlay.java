/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

import java.util.Iterator;

/**
 *
 * @author rcman
 */
public class MechanicsLastPlay extends MechanicsControl implements ILastPlay, IPlayRound
{
    GameInputUI inputUI = new GameInputUI();
    GameMessageUI messageUI = new GameMessageUI();
    GameCaseDisplayUI caseUI = new GameCaseDisplayUI();
    GameGoodCommentUI goodUI = new GameGoodCommentUI();
    GameBadCommentUI badUI = new GameBadCommentUI();
    GameCompareLastUI compareUI = new GameCompareLastUI();
    
    FileOutListOfWin folist = new FileOutListOfWin();
    FileOutGameLog folog = new FileOutGameLog();

    int otherCaseNum;
    double otherCaseVal;
    
    @Override
    public void lastPlay(Cases cases)
    {
        System.out.println("-- This is the last play of the game! --");
        System.out.println("You can either keep your case! Or \nswap it with the"
                + " last case on display");
        
        caseUI.showCases(cases);
        
        while(true)
        {
            System.out.print("Keep your case or swap it? ('k' or 's') => ");
            String response = inputUI.getInput();
            
            if(response.equalsIgnoreCase("k"))
            {
                folog.FileOutLog(player.firstName, player.lastName, "Chose to keep case " + playerCase);
                
                Iterator<Integer> caseIterator = cases.getCases().keySet().iterator();
                if(caseIterator.hasNext())
                {
                    otherCaseNum = caseIterator.next();
                }
                otherCaseVal = cases.getCases().get(otherCaseNum);
                
                System.out.println("\nYour case " + playerCase + " contains $" + playerCaseValue);
                System.out.println("\nThe other case " + otherCaseNum + " contains $" + otherCaseVal + "\n");
                compareUI.compareValues(playerCaseValue, otherCaseVal);
                
                folist.FileOutListWin(player.firstName, player.lastName, playerCaseValue);
                folog.FileOutLog(player.firstName, player.lastName, "Won $" + playerCaseValue);
                
                System.out.println();
                break;
            }
            else if(response.equalsIgnoreCase("s"))
            {   
                Iterator<Integer> caseIterator = cases.getCases().keySet().iterator();
                if(caseIterator.hasNext())
                {
                    otherCaseNum = caseIterator.next();
                }
                otherCaseVal = cases.getCases().get(otherCaseNum);
                
                folog.FileOutLog(player.firstName, player.lastName, "Chose to swap case " + playerCase + 
                        " with case " + otherCaseNum);
                
                System.out.println("\nYou swapped your case " + playerCase + " for case " + otherCaseNum);
                System.out.println("\nYour new case " + otherCaseNum + " contains $ " + otherCaseVal + "\n");
                System.out.println("Your old case " + playerCase + " contains $ " + playerCaseValue + "\n");
                compareUI.compareValues(otherCaseVal, playerCaseValue);
                
                folist.FileOutListWin(player.firstName, player.lastName, otherCaseVal);
                folog.FileOutLog(player.firstName, player.lastName, "Won $" + otherCaseVal);
                
                System.out.println();
                break;
            }
            else if(response.equalsIgnoreCase("x"))
            {
                folog.FileOutLog(player.firstName, player.lastName, "User quit game.");
                messageUI.displayExitMessage();
                System.exit(0);
            }
            else
            {
                System.out.println("Invalid!\n");
            }
        }
        
        
    }
    
    // Override playRound for MechanicsLastPlay use
    @Override
    public void playRound(Cases cases, int roundNum)
    {
        int count = 0;
        int casesToPick = 4;
        
        System.out.println("************************ Round " + roundNum + "! ************************");
        System.out.println("\nEnter 'x' to quit anytime!");
        
        folog.FileOutLog(player.firstName, player.lastName, "Start of Round " + roundNum);

        while(count < 4)
        {
            count++;
            caseUI.showCases(cases);
            
            while(true)
            {
                System.out.print("Please pick a case! (" + casesToPick +
                    " more case(s) to pick.) =>  ");
                String input = inputUI.getInput();
                
                if(input.equalsIgnoreCase("x"))
                {
                    messageUI.displayExitMessage();
                    System.exit(0);
                }
                
                try
                {
                    int caseNum = Integer.parseInt(input);
                    
                    if(caseNum <= 0 || caseNum > cases.getCaseNums().length)
                    {
                        System.out.println("Invalid case number! Please try again!\n");
                    }
                    else if(!cases.getCases().containsKey(caseNum))
                    {
                        System.out.println("Case has already been opened! Pick another one!\n");
                    }
                    else
                    {
                        System.out.println("-------- Case " + caseNum
                        + " contains: $" + cases.getCases().get(caseNum) + " --------");
                        
                        if(cases.getCases().get(caseNum) < 50000.00)
                        {
                            String comment = goodUI.comment();
                            System.out.println(comment);
                        }
                        else
                        {
                            String comment = badUI.comment();
                            System.out.println(comment);
                        }

                        cases.getCases().remove(caseNum);

                        System.out.println("");
                        casesToPick--;
                        
                        break;
                    }
                }
                catch(NumberFormatException E)
                {
                    System.out.println(E + ". Invalid input! Only case numbers!\n");
                }
            }
            folog.FileOutLog(player.firstName, player.lastName, "End of Round " + roundNum);
        }
    }
}
