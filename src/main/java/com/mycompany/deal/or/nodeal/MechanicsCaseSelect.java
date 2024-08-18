/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

/**
 *
 * @author rafae
 */
public class MechanicsCaseSelect extends MechanicsControl implements ICaseSelect
{   
//    public static int playerCase;
//    public static double playerCaseValue;
//    public static int roundNum = 1;
    
    GameCaseDisplayUI caseUI = new GameCaseDisplayUI();
    GameInputUI inputUI = new GameInputUI();
    GameMessageUI messageUI = new GameMessageUI();
    
    FileOutGameLog folog = new FileOutGameLog();
    FileOutErrorLog foerror = new FileOutErrorLog();
    
    @Override
    public void selectCase(Cases cases) 
    {
        System.out.println("\n************************ Pick your case! ************************\n");
        System.out.println("Enter 'x' to quit anytime!");
        caseUI.showCases(cases);
        
        while(true)
        {
            System.out.print("Please select a case to keep for the game! => ");
            String input = inputUI.getInput();
            
            if(input.equalsIgnoreCase("x"))
            {
                folog.FileOutLog(Player.firstName, Player.lastName, "User quit game.\n\n");
                messageUI.displayExitMessage();
                System.exit(0);
            }
            
            try
            {
                int caseNum = Integer.parseInt(input);
                if(caseNum <= 0 || caseNum > cases.getCaseNums().length)
                {
                    foerror.FileOutLog(Player.firstName, Player.lastName, "Invalid case number! - MCaseSelect");
                    System.out.println("Invalid case number! Please try again!\n");
                }
                else
                {
                    playerCase = caseNum;
                    playerCaseValue = cases.getCases().get(caseNum);
                    cases.getCases().remove(caseNum);
                    System.out.println("You have selected Case " + playerCase + "!");
                    System.out.println();
                    
                    folog.FileOutLog(Player.firstName, Player.lastName, "Selected case " + playerCase + " for the first time.");
                    
                    break;
                }
            }
            catch(NumberFormatException E)
            {
                foerror.FileOutLog(Player.firstName, Player.lastName, "Invalid input! - MCaseSelect");
                System.out.println("Invalid input! Only case numbers!\n");
            }
        }
    }
}
