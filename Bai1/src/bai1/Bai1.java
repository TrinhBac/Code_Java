/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TrinhBac
 */
public class Bai1 {
    public static Scanner sc = new Scanner(System.in);
    public static int n =-1;
    public static ArrayList<SinhVien> danhSach = new ArrayList<>();
    public static String header = String.format("%15s %15s %10s %10s %15s %15s %10s %10s", "Ho Ten", "Ngay sinh", "Gioi tinh", "MaSV", "Nganh Hoc", "Email", "SDT", "Ket qua");
    /**
     * @param args the command line arguments
     */
     public static void sortAscByName(){
        Collections.sort(danhSach, new Comparator<SinhVien>(){
            public int compare(SinhVien a, SinhVien b){
                return (a.hoTen.compareTo(b.hoTen));
            }
        });
        System.out.println("--> Da sap xep tang theo ten.");
        System.out.println(header);
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println(danhSach.get(i).dataformatted());
        }  
    }
    
    public static void findMaxDiemTB(){
        double max =0;
        SinhVien sv = new SinhVien();
        for (int i = 0; i < danhSach.size(); i++) {
            if(danhSach.get(i).getDiemTB()>max){
                sv = danhSach.get(i);
                max = danhSach.get(i).getDiemTB();
            }
        }
        System.out.println("Thong tin sv co diem TB cao nhat la:");
        System.out.println(header);
        System.out.println(sv.dataformatted());
    }
    
    public static void findMinDiemTB(){
        double min =10;
        SinhVien sv = new SinhVien();
        for (int i = 0; i < danhSach.size(); i++) {
            if(danhSach.get(i).getDiemTB()<min){
                sv = danhSach.get(i);
                min = danhSach.get(i).getDiemTB();
            }
        }
        System.out.println("Thong tin sv co diem TB thap nhat la:");
        System.out.println(header);
        System.out.println(sv.dataformatted());
    }
    
    public static void xoaSvTruot(){
        Iterator<SinhVien> it = danhSach.iterator();
        while(it.hasNext()){
            SinhVien hs = it.next();
            if(hs.getKQ().equalsIgnoreCase("Truot"))
                it.remove();
        }
        System.out.println("DS sau khi xoa SV truot la:");
        System.out.println(header);
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println(danhSach.get(i).dataformatted());
        } 
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        do {            
            System.out.print("Nhap SL sinh vien (>=2): ");
            n = sc.nextInt(); sc.nextLine();
        } while (n<2);
        //nhap danh sach sv
        for (int i = 0; i < n; i++) {
            System.out.printf("-----SV thu %d-----\n", i+1);
            SinhVien sv = new SinhVien();
            sv.nhap();
            danhSach.add(sv);
        }
        
        //xuat ds sv
        System.out.println("-----DANH SACH HOC SINH-----");
        System.out.println(header);
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println(danhSach.get(i).dataformatted());
        }  
        
        //sap xep theo ten
        sortAscByName();
        //tim TB max
        findMaxDiemTB();
        //tim TB min
        findMinDiemTB();
        //xoa hs truot
        xoaSvTruot();
        
        CSDL db = new CSDL();
        try {
            db.docFile();
        } catch (IOException ex) {
            Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            db.ghiFile(danhSach);
        } catch (IOException ex) {
            Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
