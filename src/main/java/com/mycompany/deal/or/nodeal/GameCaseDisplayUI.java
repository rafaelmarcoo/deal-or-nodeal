/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

/**
 *
 * @author rafae
 */
public class GameCaseDisplayUI implements IcaseDisplayUI
{
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
}
