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
    FileOutGameLog folog = new FileOutGameLog();
    
    @Override
    public double bankerOffer(Cases cases)
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
        
        double multiplier = 0.30 + (roundNum * 0.10);
        if(multiplier > 0.80)
            multiplier = 0.80;
        
        double risk = highestValue / totalValue;
        double offer = avgTot * multiplier * (1 - (risk * 0.25));
        
        double roundedOffer = Math.round(offer * 100.0) / 100.0;
        
        System.out.println("Banker's offer is $" + roundedOffer + "!\n");
        
        folog.FileOutLog(Player.firstName, Player.lastName, "Banker offered $" + roundedOffer);
        
//        System.out.println("Your case " + playerCase + " contains: $" + playerCaseValue);
        
        

        return roundedOffer;
    }
}
