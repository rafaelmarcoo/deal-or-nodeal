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
                else
                {
                    playerCase = caseNum;
                    playerCaseValue = cases.getCases().get(caseNum);
                    cases.getCases().remove(caseNum);
                    System.out.println("You have selected Case " + playerCase + "!");
                    System.out.println();
                    break;
                }
            }
            catch(NumberFormatException E)
            {
                System.out.println("Invalid input! Only case numbers!\n");
            }
        }
    }
}
