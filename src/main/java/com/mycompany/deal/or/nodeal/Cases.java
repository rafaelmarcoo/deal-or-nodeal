/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author rcman
 */


public class Cases extends Case
{
    private ArrayList<Case> cases;
    private int totalCases = 26;
    
    public Cases()
    {
        cases = new ArrayList<>();
        
        try 
        {
            FileReader fr = new FileReader("./resources/prizes.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            int index = 0;
            while((line = br.readLine()) != null && index < totalCases)
            {
                double value = Double.parseDouble(line);
                cases.add(new Case(index + 1, value));
                index++;
            }
            br.close();  
            
            Collections.shuffle(cases);
            
//            Random rand = new Random();
//            for(int i = 0; i < caseValues.length; i++)
//            {
//                int randomIndex = rand.nextInt(caseValues.length);
//                double temp = caseValues[randomIndex];
//                caseValues[randomIndex] = caseValues[i];
//                caseValues[i] = temp;
//            }
//            
//            for(int i = 0; i < caseNums.length; i++)
//            {
//                cases.put(caseNums[i], caseValues[i]);
//            }
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
    
    public ArrayList<Case> getCases()
    {
        return cases;
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


