/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.util.Scanner;

/**
 *
 * @author TrinhBac
 */
public class SinhVien extends Nguoi{
    private String maSV, nganhHoc, email , sdt, diaChi;

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    private Diem diem;

    public SinhVien() {
    }

    public SinhVien(String maSV, String nganhHoc, String email, String sdt, Diem diem) {
        this.maSV = maSV;
        this.nganhHoc = nganhHoc;
        this.email = email;
        this.sdt = sdt;
        this.diem = diem;
    }
    
//    public SinhVien()
    public SinhVien(String hoTen, String maSV, String namSinh, String gioiTinh, String nganhHoc, String sdt, String email, String diaChi){
        this.maSV = maSV;
        this.nganhHoc = nganhHoc;
        this.email = email;
        this.sdt = sdt;
        this.hoTen = hoTen;
        this.ngaySinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.sdt =sdt;
        this.email = email;
        this.diaChi = diaChi;
        setDiem(0.0, 0.0, 0.0);
        
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Diem getDiem() {
        return diem;
    }

    public void setDiem(Double d1, Double d2, Double d3) {
        this.diem = new Diem(d1, d2, d3);
    }

    @Override
    public String toString() {
        return "SinhVien{" + "maSV=" + maSV + ", nganhHoc=" + nganhHoc + ", email=" + email + ", sdt=" + sdt + ", diem=" + diem + '}';
    }

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap hoten: ");
        hoTen = sc.nextLine();
        System.out.print("Nhap ngay sinh: ");
        ngaySinh = sc.nextLine();
        System.out.print("Nhap gio tinh: ");
        gioiTinh = sc.nextLine();
        System.out.print("Nhap maSV: ");
        maSV = sc.nextLine();
        System.out.print("Nhap nganh hoc: ");
        nganhHoc = sc.nextLine();
        System.out.print("Nhap email: ");
        email = sc.nextLine();
        System.out.print("Nhap sdt: ");
        sdt = sc.nextLine();
        System.out.print("Nhap diem 1: ");
        Double d1 = sc.nextDouble(); sc.nextLine();
        System.out.print("Nhap diem 2: ");
        Double d2 = sc.nextDouble(); sc.nextLine();
        System.out.print("Nhap diem 3: ");
        Double d3 = sc.nextDouble(); sc.nextLine();
        setDiem(d1,d2,d3);
    }
    
    public double getDiemTB(){
        return diem.getdTB();
    }
    
    public double getMon1(){
        return diem.getMon1();
    }
    
    public double getMon2(){
        return diem.getMon2();
    }
    
    public double getMon3(){
        return diem.getMon3();
    }
    
    public String getKQ(){
        String kq = "Truot";
        if(diem.getdTB()>=5){
            kq ="Dau";
        }
        return kq;
    }
    
    
    public String dataformatted(){
        String kq = "Truot";
        if(diem.getdTB()>=5){
            kq ="Dau";
        }
        return String.format("%15s/%15s/%10s/%10s/%15s/%15s/%10s/%5f/%5f/%5f/%5f\n", hoTen, ngaySinh, gioiTinh, maSV, nganhHoc, email, sdt, getMon1(), getMon2(), getMon3(), getDiemTB());
    }
}
