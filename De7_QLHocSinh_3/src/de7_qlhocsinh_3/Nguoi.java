/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de7_qlhocsinh_3;

import java.util.Scanner;

/**
 *
 * @author TrinhBac
 */
public class Nguoi {
    protected String hoTen, que ;
    protected int tuoi, namSinh ;
    public Scanner sc = new Scanner(System.in);
    
    public Nguoi() {
    }
    
    public Nguoi(String hoTen,  String que, int tuoi, int namSinh){
        this.hoTen = hoTen;  
        this.que = que;
        this.tuoi = tuoi;
        this.namSinh = namSinh;
    }
    public void nhap() {
    	System.out.print("Nhap ho ten: ");
    	hoTen = sc.nextLine();
    	System.out.print("Nhap que: ");
    	que = sc.nextLine();
    	System.out.print("Nhap tuoi: ");
    	tuoi = sc.nextInt();
    	System.out.print("Nhap nam sinh: ");
    	namSinh = sc.nextInt();sc.nextLine();
    }
    public void xuat() {
    	System.out.printf("%15s %15s %10d %10d ", hoTen, que, tuoi, namSinh);
    }
}
