/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

/**
 *
 * @author rcman
 */
public class MechanicsGetName implements IGetName
{
    GameInputUI inputUI = new GameInputUI();
    GameMessageUI messageUI = new GameMessageUI();
    
    @Override
    public String getFirstName()
    {
        System.out.println();
        String first;
        while(true)
        {
            try
            {
                System.out.print("Please enter your first name => ");
                first = inputUI.getInput();
                
                if(first.equalsIgnoreCase("x"))
                {
                    messageUI.displayExitMessage();
                    System.exit(0);
                }
                
                if(!first.matches("[a-zA-Z ]+"))
                {
                    throw new IllegalArgumentException("Invalid name! No numbers or special characters!");
                }
                
                break;
            }
            catch(IllegalArgumentException E)
            {
                System.out.println(" Try again!");
            }
        }
        
        return first;
    }
    
    @Override
    public String getLastName()
    {
        String last;
        while(true)
        {
            try
            {
                System.out.print("Please enter your last name => ");
                last = inputUI.getInput();
                
                if(last.equalsIgnoreCase("x"))
                {
                    messageUI.displayExitMessage();
                    System.exit(0);
                }
                
                if(!last.matches("[a-zA-Z ]+"))
                {
                    throw new IllegalArgumentException("Invalid name! No numbers or special characters!");
                }
                
                break;
            }
            catch(IllegalArgumentException E)
            {
                System.out.println(" Try again!");
            }
        }
        return last;
    }
}
