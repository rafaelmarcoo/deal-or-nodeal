/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

/**
 *
 * @author rafae
 */
public class GameMechanics extends GameUI implements IplayRound, IcaseSelect, Ibanker
{
    public static int playerCase;
    public static double playerCaseValue;
    public static int roundNum = 1;
    
    @Override
    public void selectCase(Cases cases) 
    {
        System.out.println("\n************************ Pick your case! ************************\n");
        System.out.println("Enter 'x' to quit anytime!");
        showCases(cases);
        
        while(true)
        {
            System.out.print("Please select a case to keep for the game! => ");
            String input = getInput();
            
            if(input.equalsIgnoreCase("x"))
            {
                displayExitMessage();
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
                System.out.println(E + ". Invalid input! Only case numbers!\n");
            }
        }
    }
    
    @Override
    public void playRound(Cases cases, int roundNum) 
    {
        int count = 0;
        int casesToPick = 5;
        
        System.out.println("************************ Round " + roundNum + "! ************************");
        System.out.println("\nEnter 'x' to quit anytime!");

        while(count < 5)
        {
            count++;
            showCases(cases);
            
            while(true)
            {
                System.out.print("Please pick a case! (" + casesToPick +
                    " more case(s) to pick.) =>  ");
                String input = getInput();
                
                if(input.equalsIgnoreCase("x"))
                {
                    displayExitMessage();
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
        }
        
    }
    
    @Override
    public void bankerOffer(Cases cases)
    {
        double totalValue = 0;
        for(double d : cases.getCases().values())
        {
            totalValue += d;
        }
        
        double avgTot = totalValue / cases.getCases().size();
        double offer = avgTot * 0.30;
        double roundedOffer = Math.round(offer * 100.0) / 100.0;
        
        System.out.println("Banker's offer is $" + roundedOffer + "\n"
        + "Deal? or no deal? => \n");
    }
    
}
