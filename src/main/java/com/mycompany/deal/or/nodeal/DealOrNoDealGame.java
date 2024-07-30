/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafae
 */
public class DealOrNoDealGame extends Methods
{   
    private int playerCase;
    private Scanner scan = new Scanner(System.in);
    
    @Override
    public void showCases(Cases cases)
    {
        System.out.println("Cases:");
        int count = 0;
        
        for(Cases.Case c : cases.getCases())
        {
            
        }
//        for(int i = 0; i < cases.size(); i++)
//        {
//            if(count == 8)
//            {
//                System.out.println();
//                count = 0;
//            }
//            else
//            {
//                if(cases.getCaseNums()[i] == 0)
//                {
//                    System.out.print("X  ");
//                    count++;
//                }
//                else
//                {
//                    System.out.print(cases.getCaseNums()[i] + "  ");
//                    count++;
//                }
//                
//            }
//        }
        System.out.println();
    }

    @Override
    public void selectCase(Cases cases) 
    {
        Scanner scan = new Scanner(System.in);
   
        System.out.println("Please select a case to keep for the game!");
        String input = scan.next();
        int caseNum = Integer.parseInt(input);
        int playerCase = cases.getCaseNums()[caseNum - 1];
        cases.getCases().remove(caseNum - 1);
        cases.getCaseNums()[caseNum - 1] = 0;
        cases.getCaseValues()[caseNum - 1] = 0.0;
        System.out.println("You have selected Case " + playerCase + "!");
        System.out.println();
        
    }

    @Override
    public void playRound(Cases cases, int roundNum) 
    {
        int count = 0;
        int casesToPick = 5;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Round 1!");
        while(count < 5)
        {
            count++;
            
            showCases(cases);
            System.out.print("Please pick a case! (" + casesToPick +
                    " more cases to pick.)");
            String input = scan.next();
            int caseNum = Integer.parseInt(input);
            
            System.out.println("Case " + cases.getCaseNums()[caseNum - 1]
            + " contains: $" + cases.getCases().get(caseNum - 1));
            
            cases.getCases().remove(caseNum - 1);
            cases.getCaseNums()[caseNum - 1] = 0;
            cases.getCaseValues()[caseNum - 1] = 0.0;
            
            System.out.println("");
            casesToPick--;
        }
        
    }
    
    @Override
    public void startGame() 
    {
        Cases cases = new Cases();

        displayWelcomeMessage();
        selectCase(cases);

        int roundNum = 1;
        playRound(cases, roundNum);    
    }

}
