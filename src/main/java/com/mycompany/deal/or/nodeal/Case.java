/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

/**
 *
 * @author rafae
 */
public class Case 
{
    private final int caseNum;
    private final double caseValue;
    
    public Case(int n, double v)
    {
        this.caseNum = n;
        this.caseValue = v;
    }

    public int getCaseNum() 
    {
        return caseNum;
    }

    public double getCaseValue() 
    {
        return caseValue;
    }
}

