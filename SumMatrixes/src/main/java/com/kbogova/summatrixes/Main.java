/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kbogova.summatrixes;

/**
 *
 * @author elkabelaya
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("summatrixes start");
        try{
            MatrixesSummator instance = new MatrixesSummator();
            instance.run();
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
        System.out.println("summatrixes complete");
        
    }
}