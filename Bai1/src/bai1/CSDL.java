/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author TrinhBac
 */
public class CSDL {
    public static String file_url = "D:/Java/Bai1/src/bai1/data.txt";
    public static String header = String.format("%15s %15s %10s %10s %15s %15s %10s %10s", "Ho Ten", "Ngay sinh", "Gioi tinh", "MaSV", "Nganh Hoc", "Email", "SDT", "Ket qua");
    
    public static void ghiFile(ArrayList<SinhVien> danhSach) throws IOException{
        OutputStream outputStream = new FileOutputStream(new File(file_url), true);   //true ghi tiếp vào file
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        
        for (int i = 0; i < danhSach.size(); i++) {
            outputStreamWriter.write(danhSach.get(i).dataformatted() + "\n");
        }
        // bắt chương trình chờ ghi dữ liệu xong thì mới kết thúc chương trình.
        outputStreamWriter.flush();
        System.out.println("--> Da ghi du lieu vao file.");
    }
    
     public static void docFile() throws IOException{  
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
}
