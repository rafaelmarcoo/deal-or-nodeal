/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

/**
 *
 * @author rcman
 */
public class MechanicsLastPlay extends MechanicsControl
{
    GameInputUI inputUI = new GameInputUI();
    GameMessageUI messageUI = new GameMessageUI();
    
    MechanicsChangeCase Mchange = new MechanicsChangeCase();
    
    public void lastPlay(Cases cases)
    {
        System.out.println("This is the last play of the game!");
        System.out.println("You can either keep your case! Or \nswap it with the"
                + "last case on display\n");
        
        while(true)
        {
            System.out.print("Keep your case or swap it? ('k' or 's') => ");
            String response = inputUI.getInput();
            
            if(response.equalsIgnoreCase("k"))
            {
                
            }
            else if(response.equalsIgnoreCase("s"))
            {
                Mchange.changeCase(cases);
            }
            else if(response.equalsIgnoreCase("x"))
            {
                
            }
            else
            {
                System.out.println("Invalid!\n");
            }
        }
    }
}
