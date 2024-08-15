/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deal.or.nodeal;

import java.util.Scanner;

/**
 *
 * @author rafae
 */
public class GameInputUI implements IInputUI
{
    @Override
    public String getInput()
    {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine().trim();
    }
}
