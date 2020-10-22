/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esdproject;

/**
 *
 * @author Bredan
 */


public class Triangle {
    int L1, L2, L3;
   
    public Triangle(int L1,int L2,int L3){
        this.L1 = L1;
        this.L2 = L2;
        this.L3 = L3;
        
    }
    
    public void printType(){
        
//        System.out.println(this.L1);
//        System.out.println(this.L2);
//        System.out.println(this.L3);
        
        // If Equilateral
        
        if (L1 == L2 && L2 == L3){
            System.out.println("This triangle is Equilateral");
        }
        
        // if Scalene
        else if (L1 != L2 && L2 != L3 && L1 != L3){
            System.out.println("This triangle is Scalene");
        }
        
        // if Isosceles
        else {
            System.out.println("This triangle is Isosceles");
        }
        
    }
}
