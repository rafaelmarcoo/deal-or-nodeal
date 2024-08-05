/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

/**
 *
 * @author rafae
 */
public interface IGamePlay 
{
    public void selectCase(Cases cases);
    public void playRound(Cases cases, int roundNum);
    public void bankerOffer(Cases cases);
}
