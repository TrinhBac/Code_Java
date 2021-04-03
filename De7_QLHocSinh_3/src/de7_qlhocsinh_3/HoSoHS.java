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
public class HoSoHS extends Nguoi{
    private String lop, khoaHoc;
    private String kyHoc;

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public String getKyHoc() {
        return kyHoc;
    }

    public void setKyHoc(String kyHoc) {
        this.kyHoc = kyHoc;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }


    public Scanner sc = new Scanner(System.in);
    
    public HoSoHS() {
    }

    public HoSoHS(String hoTen, String que, int tuoi, int namSinh, String lop, String khoaHoc, String kyHoc) {
        super(hoTen, que, tuoi, namSinh);
        this.lop = lop;
        this.khoaHoc = khoaHoc;
        this.kyHoc = kyHoc;
    }

    public void nhap() {
        super.nhap();
        System.out.print("Nhap lop: ");
        lop = sc.nextLine();
        System.out.print("Nhap khoa hoc: ");
        khoaHoc = sc.nextLine();
        System.out.print("Nhap ky hoc: ");
        kyHoc = sc.nextLine();
    }

    public void xuat() {
        super.xuat();
        System.out.printf("%10s %10s %10s", lop, khoaHoc, kyHoc);
    }
    
    public String dataFormatted(){
        return String.format("%15s %15s %10d %10d %10s %10s %10s", hoTen, que, tuoi, namSinh, lop, khoaHoc, kyHoc);
    }
}
