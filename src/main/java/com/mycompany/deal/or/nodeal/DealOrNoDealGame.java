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
    public static int roundNum = 1;
    
    @Override
    public void showCases(Cases cases)
    {
        System.out.println("\nCases:");
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
                System.out.print("{ X }  ");
            }
            else
            {
                System.out.print("{ " + i + " }  ");
            }
            count++;
        }
        
        System.out.println();
    }
    
    @Override
    public void selectCase(Cases cases) 
    {
        System.out.println("\n************************ Pick your case! ************************");
        showCases(cases);
        
        while(true)
        {
            System.out.print("Please select a case to keep for the game! => ");
            String input = scan.nextLine().trim();
            
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
                    continue;
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
            catch(Exception E)
            {
                System.out.println(E + ". Invalid input! Only case numbers!\n");
                continue;
            }
        }
        
//        System.out.print("Please select a case to keep for the game! => ");
//        String input = scan.next();
//        int caseNum = Integer.parseInt(input);
//        playerCase = caseNum;
//        playerCaseValue = cases.getCases().get(caseNum);
//        cases.getCases().remove(caseNum);
//        System.out.println("You have selected Case " + playerCase + "!");
//        System.out.println();
//        
    }

    @Override
    public void playRound(Cases cases, int roundNum) 
    {
        int count = 0;
        int casesToPick = 5;
        
        System.out.println("************************ Round " + roundNum + "! ************************");
        while(count < 5)
        {
            count++;
            showCases(cases);
            
            while(true)
            {
                System.out.print("Please pick a case! (" + casesToPick +
                    " more case(s) to pick.) =>  ");
                String input = scan.nextLine().trim();
                
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
                        continue;
                    }
                    else if(!cases.getCases().containsKey(caseNum))
                    {
                        System.out.println("Case has already been opened! Pick another one!\n");
                        continue;
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
                catch(Exception E)
                {
                    System.out.println(E + ". Invalid input! Only case numbers!\n");
                }
            }
            
//            System.out.print("Please pick a case! (" + casesToPick +
//                    " more case(s) to pick.) =>  ");
//            String input = scan.next();
//            int caseNum = Integer.parseInt(input);
//            scan.nextLine();
//            
//            System.out.println("Case " + caseNum
//            + " contains: $" + cases.getCases().get(caseNum));
//            
//            cases.getCases().remove(caseNum);
//            
//            System.out.println("");
//            casesToPick--;
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
        double offer = avgTot * 0.75;
        double roundedOffer = Math.round(offer * 100.0) / 100.0;
        
        System.out.println("Banker's offer is $" + roundedOffer + "\n"
        + "Deal? or no deal? => \n");
    }
    
    @Override
    public void tutorial()
    {
        System.out.println("\n--------------------------------------------------"
                + "----------------------------------------------------------------------------------");
        System.out.println("\nThere are 26 cases, each containing various amount of prize money from as little as"
                + " $0.01 to a whopping $1,000,000.");
        System.out.println("\nHow to play:");
        System.out.println(" - You choose one case to keep for the game.");
        System.out.println(" - You will then select and open a number of cases each round, revealing the amounts.");
        System.out.println(" - After each round, the banker will offer you a cash amount to quit the game.");
        System.out.println(" - You can choose to 'Deal' and take the offer or 'No Deal' and continue playing");
        System.out.println(" - If you reach the final round and have one last case in the show left, you can choose to keep"
                + " the case you selected at the start, \nor swap it with the last remaining case in the display as your own case!");
        System.out.println("\n***** Good luck and have fun! *****");
        System.out.println("\n--------------------------------------------------"
                + "----------------------------------------------------------------------------------");
    }
    
    @Override
    public void startGame() 
    {
        Cases cases = new Cases();
        double offer = 0;
//        int roundNum = 1;
        
        while(true)
        {
            displayWelcomeMessage();
//            System.out.print("Enter 'w' to start a game! || Enter 't' for a tutorial! || To quit, enter 'x'!  = ");
            String response = scan.nextLine().trim();
            
            if(response.equalsIgnoreCase("w"))
            {
                selectCase(cases);
                
                while(roundNum <= 5)
                {
                    playRound(cases, roundNum);    
                    System.out.println("End of Round " + roundNum);
                    bankerOffer(cases);

                    roundNum++;
                }
                
            }
            else if(response.equalsIgnoreCase("t"))
            {
                tutorial();
                continue;
            }
            else if(response.equalsIgnoreCase("x"))
            {
                displayExitMessage();
                break;
            }
            else
            {
                System.out.println("\nInvalid input!");
                continue;
            }
            
            System.out.println("Your case " + playerCase + " contains $" + playerCaseValue);
            displayExitMessage();
            break;
        }
        
//        for(int i : cases.getCases().keySet())
//        {
//            System.out.println("Case " + i + " - Value: $" + cases.getCases().get(i));
//        }
    }
    
    public static void main(String[] args) 
    {
        
    }

}
