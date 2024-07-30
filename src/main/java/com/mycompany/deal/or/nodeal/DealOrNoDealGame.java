/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

/**
 *
 * @author rafae
 */
public class DealOrNoDealGame extends Methods
{
    @Override
    public void showCases(Cases cases)
    {
        System.out.println("Cases:");
        int count = 0;
        for(int i = 0; i < cases.getCaseNums().length; i++)
        {
            if(count == 8)
            {
                System.out.println();
                count = 0;
            }
            else
            {
                System.out.print(cases.getCaseNums()[i] + "  ");
                count++;
            }
        }
        System.out.println();
    }

}
