/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

/**
 *
 * @author rcman
 */
public class GameCompareLastUI extends MechanicsControl implements ICompareValues
{
    public void compareValues(double playerValue, double otherValue)
    {
        if(playerValue > otherValue)
        {
            System.out.println("Great choice! Congratulations!");
        }
        else
        {
            System.out.println("Oopppps bad luck! Better luck next time!");
        }
    }
}
