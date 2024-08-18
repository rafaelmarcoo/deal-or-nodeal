/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

/**
 *
 * @author rafae
 */
public class MechanicsPlayRound extends MechanicsControl implements IPlayRound
{
    GameCaseDisplayUI caseUI = new GameCaseDisplayUI();
    GameInputUI inputUI = new GameInputUI();
    GameMessageUI messageUI = new GameMessageUI();
    GameGoodCommentUI goodUI = new GameGoodCommentUI();
    GameBadCommentUI badUI = new GameBadCommentUI();
    
    FileOutGameLog folog = new FileOutGameLog();
    
    @Override
    public void playRound(Cases cases, int roundNum) 
    {
        int count = 0;
        int casesToPick = 5;
        
        System.out.println("************************ Round " + roundNum + "! ************************");
        System.out.println("\nEnter 'x' to quit anytime!");
        
        folog.FileOutLog(player.firstName, player.lastName, "Start of Round " + roundNum);
        
        while(count < 5)
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
                    folog.FileOutLog(player.firstName, player.lastName, "User quit game");
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
                        
                        folog.FileOutLog(player.firstName, player.lastName, "Opened case " + caseNum +
                                " containing $" + cases.getCases().get(caseNum));

                        cases.getCases().remove(caseNum);

                        System.out.println("");
                        casesToPick--;
                        
                        break;
                    }
                }
                catch(NumberFormatException E)
                {
                    System.out.println("Invalid input! Only case numbers!\n");
                }
            }
        }
        folog.FileOutLog(player.firstName, player.lastName, "End of Round " + roundNum);
    }
}
