/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

/**
 *
 * @author rafae
 */
public class MechanicsBanker implements Ibanker
{
    
    
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
