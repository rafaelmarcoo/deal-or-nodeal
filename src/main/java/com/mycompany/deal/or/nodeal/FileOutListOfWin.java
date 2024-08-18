/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;

/**
 *
 * @author rcman
 */
public class FileOutListOfWin 
{
    public void FileOutListWin(String firstName, String lastName, double winnings)
    {
        LocalDate date = LocalDate.now();
        
        try
        {
            FileOutputStream fos = new FileOutputStream("./resources/ListOfWinnings/listofwinnings.txt", true);
            PrintWriter pw = new PrintWriter(fos);
            pw.println(date + " || " + firstName + " " + lastName + " - Winnings: $" + winnings);
            pw.close();
        }
        catch(FileNotFoundException E)
        {
            System.out.println(E);
        }
    }
    
}
