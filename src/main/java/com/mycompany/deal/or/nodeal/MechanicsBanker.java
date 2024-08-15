/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

/**
 *
 * @author rafae
 */
public class MechanicsBanker extends MechanicsControl implements IBanker
{
    
    
    @Override
    public void bankerOffer(Cases cases)
    {
        double totalValue = 0;
        double highestValue = 0;
        int numCases = cases.getCases().size();
        
        for(double d : cases.getCases().values())
        {
            totalValue += d;
            
            if(d > highestValue)
            {
                highestValue = d;
            }
        }
                
        double avgTot = totalValue / numCases;
        
        double multiplier = 0.20 + (roundNum * 0.05);
        if(multiplier > 0.70)
            multiplier = 0.70;
        
        double risk = highestValue / totalValue;
        double offer = avgTot * multiplier * (1 - (risk * 0.5));
        
        double roundedOffer = Math.round(offer * 100.0) / 100.0;
        
        System.out.println("Banker's offer is $" + roundedOffer + "\n"
        + "Deal? or no deal? => \n");
        
        
        
        System.out.println("Your case " + playerCase + " contains: $" + playerCaseValue);
    }
}
