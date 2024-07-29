/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rcman
 */


public class Cases 
{
    private HashMap<Integer, Double> cases;
    private int[] caseNums;
    private double[] caseValues;
    private int totalCases = 26;
    
    public Cases()
    {
        cases = new HashMap<>();
        caseNums = new int[totalCases];
        caseValues = new double[totalCases];
        
        try 
        {
            FileReader fr = new FileReader("./resources/prizes.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            int index = 0;
            while((line = br.readLine()) != null && index < totalCases)
            {
                double value = Double.parseDouble(line);
                caseValues[index] = value;
                caseNums[index] = index + 1;
                index++;
            }
            br.close();  
            
            Random rand = new Random();
            for(int i = 0; i < caseValues.length; i++)
            {
                int randomIndex = rand.nextInt(caseValues.length);
                double temp = caseValues[randomIndex];
                caseValues[randomIndex] = caseValues[i];
                caseValues[i] = temp;
            }
            
            for(int i = 0; i < caseNums.length; i++)
            {
                cases.put(caseNums[i], caseValues[i]);
            }
        } 
        catch(FileNotFoundException ex) 
        {
            System.out.println("File not found.");
        }
        catch(IOException e)
        {
            System.out.println("Error reading from file.");
        }
        
        
    }

    public HashMap<Integer, Double> getCases() 
    {
        return cases;
    }

    public int[] getCaseNums() 
    {
        return caseNums;
    }

    public double[] getCaseValues() 
    {
        return caseValues;
    }
    
    public int getTotalCases() 
    {
        return totalCases;
    }
    
    
    public static void main(String[] args) 
    {   
//        for(int i : cases.getCases().keySet())
//        {
//            System.out.println("Case " + i + " - Value: $" + cases.getCases().get(i));
//        }
    }
}


