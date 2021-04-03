/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de7_qlhocsinh_3;

import com.sun.xml.internal.ws.message.StringHeader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import javafx.print.Collation;

/**
 *
 * @author TrinhBac
 */
public class De7_QLHocSinh_3 {

    /**
     * @param args the command line arguments
     */
    public static Scanner sc = new Scanner(System.in);
    public static int n=-1;
    public static ArrayList<HoSoHS> danhSach = new ArrayList<>();
    public static String file_url = "D:/Java/De7_QLHocSinh_2/src/de7_qlhocsinh_2/data.txt";
    public static String header = String.format("%15s %15s %10s %10s %10s %10s %10s", "Ho Ten", "Que", "Tuoi", "Nam Sinh", "Lop", "Khoa Hoc", "Ky Hoc");
    public static String option="-1"; 
    
    public static void nhapTT(int n, ArrayList<HoSoHS> danhSach){
        danhSach.clear();
        for (int i = 0; i < n; i++) {
            System.out.printf("-----HS thu %d-----\n", i+1);
            HoSoHS hs = new HoSoHS();
            hs.nhap();
            danhSach.add(hs);
        }
    }
    
    public static void xuatTT(ArrayList<HoSoHS> danhSach) {
        if(danhSach.size()==0){
            System.out.println("--> Danh sach trong");
        }
        else{
            System.out.println("-----DANH SACH HOC SINH-----");
            System.out.println(header);
            for (int i = 0; i < danhSach.size(); i++) {
                danhSach.get(i).xuat();
                System.out.println();
            }    
        }
    }
    
    public static void docFile() throws IOException{  
//        Cách 2: đọc bằng scanner
        Scanner sc = new Scanner(new File(file_url));
        if (!sc.hasNextLine()) {
            System.out.println("--> File trong.");
        } else {
            System.out.println("Du lieu trong file la:");
            System.out.println(header);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        }
    }
    
    public static void ghiFile(ArrayList<HoSoHS> danhSach) throws IOException{
        OutputStream outputStream = new FileOutputStream(new File(file_url), true);   //true ghi tiếp vào file
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        
        for (int i = 0; i < n; i++) {
            outputStreamWriter.write(danhSach.get(i).dataFormatted() + "\n");
        }
        // bắt chương trình chờ ghi dữ liệu xong thì mới kết thúc chương trình.
        outputStreamWriter.flush();
        System.out.println("--> Da ghi du lieu vao file.");
    }
    
    //hàm tìm kiếm theo tên, làm tượng tự với tìm theo lớp, tuổi, ...
    public static boolean searchByName(ArrayList<HoSoHS> danhSach){
        System.out.print("Nhap ten can tim: ");
        String name = sc.nextLine();
        int dem=0;
        for (int i = 0; i < danhSach.size(); i++)
            if(danhSach.get(i).hoTen.equalsIgnoreCase(name))
                dem++;
        if(dem==0){
            System.out.println("--> Khong ton tai hs ten " + name);
            return false;
        }
        System.out.printf("--> Danh sach SV co ten %s la:\n", name);
        System.out.println(header);
        for (int i = 0; i < danhSach.size(); i++) {
            if(danhSach.get(i).hoTen.equalsIgnoreCase(name)){
                danhSach.get(i).xuat();
                System.out.println("");
            }
        }
        return true;
    }
    
    public static boolean deleteByName(ArrayList<HoSoHS> danhSach){
        System.out.print("Nhap ten can xoa: ");
        String name = sc.nextLine();
        int dem=0;
        for (int i = 0; i < danhSach.size(); i++)
            if(danhSach.get(i).hoTen.equalsIgnoreCase(name))
                dem++;
        if(dem==0){
            System.out.println("--> Khong ton tai hs ten " + name);
            return false;
        }
        
        Iterator<HoSoHS> it = danhSach.iterator();
        while(it.hasNext()){
            HoSoHS hs = it.next();
            if(hs.hoTen.equalsIgnoreCase(name))
                it.remove();
        }
        System.out.println("--> Da xoa nhung hs co ten " + name);
        return true;
    }
    
    //sap xep tang theo ten (abc...)
    public static void sortAscByName(ArrayList<HoSoHS> danhSach){
        Collections.sort(danhSach, new Comparator<HoSoHS>(){
            public int compare(HoSoHS a, HoSoHS b){
                return (a.hoTen.compareTo(b.hoTen));
            }
        });
        System.out.println("--> Da sap xep tang theo ten.");
    }
    
    //sap xep giam theo tuoi
    public static void sortDescByAge(ArrayList<HoSoHS> danhSach){
        Collections.sort(danhSach, new Comparator<HoSoHS>(){
            public int compare(HoSoHS a, HoSoHS b){
                if(a.tuoi<b.tuoi)
                    return 1;
                else
                    return -1;
            }
        });
        System.out.println("--> Da sap xep giam theo tuoi.");
    }
    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String optionsHeader ="------------ MENU ------------\n";
               optionsHeader+= "1. Nhap thong tin n hoc sinh\n2. Xuat danh sach hoc sinh\n";
               optionsHeader+= "3. Tiem kiem hs theo ten\n4. Doc du lieu da co trong file\n";
               optionsHeader+= "5. Ghi danh sach hs vao file\n6. Sap xep tang theo ten\n";
               optionsHeader+= "7. Sap xep giam theo do tuoi\n8. Xoa hoc sinh theo ten\n";
               optionsHeader+= "0. Ket thuc chuong trinh\n";
               optionsHeader+= "Nhap lua chon: ";
        while (true) {            
            System.out.print(optionsHeader);
            option = sc.nextLine();
            switch (option) {
                case "1":   //nhap thong tin n hs
                    System.out.print("Nhap so luong hoc sinh: ");
                    n = sc.nextInt();sc.nextLine();
                    nhapTT(n, danhSach);
                    break;
                case "2":   //xuat ds hs vua nhap
                    if(n==-1){
                        System.out.println("--> Ban chua nhap thong tin nao");
                    }else{
                        xuatTT(danhSach);
                    }
                    break;
                case "3":   //tim kiem hs theo ten
                    if(n==-1){
                        System.out.println("--> Ban chua nhap thong tin nao");
                    }else{
                        searchByName(danhSach);
                    }
                    break;
                case "4":   //doc du lieu trong file
                    docFile();
                    break;
                case "5":   //ghi danh sach hs vua nhap vao file
                    if(n==-1){
                        System.out.println("Ban chua nhap thong tin nao");
                    }else{
                        ghiFile(danhSach);
                    }
                    break;
                case "6":   //sap xep tang theo ten
                    sortAscByName(danhSach);
                    break;
                case "7":   //sap xep tang theo ten
                    sortDescByAge(danhSach);
                    break;
                case "8":   //xoa hoc sinh theo ten
                    deleteByName(danhSach);
                    break;
                case "0":
                    System.out.println("Ket thuc");
                    System.exit(0);
                default:
                    System.out.println("Lua chon khong hop le. Hay chon lai");
            }
        }
    }
}
