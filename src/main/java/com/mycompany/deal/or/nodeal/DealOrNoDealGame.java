/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

import java.util.Scanner;

/**
 *
 * @author rafae
 */
public class DealOrNoDealGame extends Methods
{
    private Scanner scan = new Scanner(System.in);
    public static int playerCase;
    public static double playerCaseValue;
    
    @Override
    public void showCases(Cases cases)
    {
        System.out.println("Cases:");
        int count = 0;
        for(int i = 1; i <= cases.getCaseNums().length; i++)
        {
            if(count == 7)
            {
                System.out.println();
                count = 0;
            }
            
            if(!cases.getCases().containsKey(i))
            {
                System.out.print("X  ");
            }
            else
            {
                System.out.print(i + "  ");
            }
            count++;
        }
        System.out.println();
    }
    
    @Override
    public void selectCase(Cases cases) 
    {
        showCases(cases);
        
        System.out.println("Please select a case to keep for the game!");
        String input = scan.next();
        
        int caseNum = Integer.parseInt(input);
        playerCase = caseNum;
        playerCaseValue = cases.getCases().get(caseNum);
        cases.getCases().remove(caseNum);
//        cases.getCaseNums()[caseNum - 1] = 0;
//        cases.getCaseValues()[caseNum - 1] = 0.0;
        System.out.println("You have selected Case " + playerCase + "!");
        System.out.println();
    }

    @Override
    public void playRound(Cases cases, int roundNum) 
    {
        int count = 0;
        int casesToPick = 5;
        
        System.out.println("Round " + roundNum + "!");
        while(count < 5)
        {
            count++;
            
            showCases(cases);
            System.out.print("Please pick a case! (" + casesToPick +
                    " more cases to pick.)");
            String input = scan.next();
            int caseNum = Integer.parseInt(input);
            
            System.out.println("Case " + caseNum
            + " contains: $" + cases.getCases().get(caseNum));
            
            cases.getCases().remove(caseNum);
            
            System.out.println("");
            casesToPick--;
        }
        
    }
    
    @Override
    public double bankerOffer(Cases cases)
    {
        double totalValue = 0;
        for(double d : cases.getCases().values())
        {
            totalValue += d;
        }
        
        double avgTot = totalValue / cases.getCases().size();
        double offer = avgTot * 0.75;
        double roundedOffer = Math.round(offer * 100.0) / 100.0;
        
        return roundedOffer;
    }
    
    @Override
    public void startGame() 
    {
        Cases cases = new Cases();
        double offer = 0;

        displayWelcomeMessage();
        selectCase(cases);

        int roundNum = 1;
        playRound(cases, roundNum);    
        roundNum++;
        System.out.println();
        
        offer = bankerOffer(cases);
        System.out.println("Banker's offer is $" + offer + "\n"
        + "Deal? or no deal? \n");
        
        System.out.println("Your case " + playerCase + " contains $" + playerCaseValue);
        
        
//        for(int i : cases.getCases().keySet())
//        {
//            System.out.println("Case " + i + " - Value: $" + cases.getCases().get(i));
//        }
    }
    
    public static void main(String[] args) 
    {
        
    }

}
