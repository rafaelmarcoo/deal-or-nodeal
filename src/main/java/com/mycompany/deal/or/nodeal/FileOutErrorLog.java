/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author rafae
 */
public class FileOutErrorLog implements IFileOut
{
    @Override
    public void FileOutLog(String firstName, String lastName, String action)
    {
        LocalDate date = LocalDate.now();
        
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeNow = time.format(formatTime);
        
        try
        {
            FileOutputStream fos = new FileOutputStream("./resources/ErrorLogs/" + date + "_" +
                    firstName + "_" + lastName + "_Error_Logs.txt", true);
            PrintWriter pw = new PrintWriter(fos);
            pw.println(timeNow + " || Error: " + action);
            pw.close();
        }
        catch(FileNotFoundException E)
        {
            System.out.println(E);
        }
    }
}
