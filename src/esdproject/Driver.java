/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esdproject;

import java.util.Scanner;

/**
 *
 * @author Bredan
 */
public class Driver {
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        // read inputs in from console
        Scanner lengths = new Scanner(System.in); 
        System.out.println("Enter Lengths");
        
        int L1 = lengths.nextInt();
        System.out.println("L1 is: " + L1);
        
        int L2 = lengths.nextInt();
        System.out.println("L2 is: " + L2);
        
        int L3 = lengths.nextInt();
        System.out.println("L3 is: " + L3);

        Triangle A = new Triangle(L1,L2,L3);
        
        A.printType();
    }
}
