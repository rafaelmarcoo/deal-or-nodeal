/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

/**
 *
 * @author rcman
 */
public class MechanicsChangeCase extends MechanicsControl implements IChangeCase
{
    GameCaseDisplayUI caseUI = new GameCaseDisplayUI();
    GameInputUI inputUI = new GameInputUI();
    GameMessageUI messageUI = new GameMessageUI();

    @Override
    public void changeCase(Cases cases)
    {
        System.out.println("\n************************ Select a new case! ************************\n");
        System.out.println("Enter 'x' to quit the game anytime!");
        caseUI.showCases(cases);
        
        while(true)
        {
            System.out.print("Please select your new case! (enter 'b' to back out) => ");
            String input = inputUI.getInput(); 
            
            if(input.equalsIgnoreCase("x"))
            {
                messageUI.displayExitMessage();
                System.exit(0);
            }
            
            if(input.equalsIgnoreCase("b"))
            {
                System.out.println();
                break;
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
                    int temp = playerCase;
                    double tempValue = playerCaseValue;
                    cases.getCases().put(temp, tempValue);
                            
                    playerCase = caseNum;
                    playerCaseValue = cases.getCases().get(caseNum);
                    cases.getCases().remove(caseNum);
                    System.out.println("You have chosen Case " + playerCase + "!");
                    System.out.println();
                    
                    for(int i : cases.getCases().keySet())
                    {
                        System.out.println("Case " + i + " - Value: $" + cases.getCases().get(i));
                    }
                    break;
                }
            }
            catch(NumberFormatException E)
            {
                System.out.println(E + ". Invalid input! Only case numbers!\n");
            }
        }
    }
}
