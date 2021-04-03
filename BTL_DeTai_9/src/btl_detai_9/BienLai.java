/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl_detai_9;

/**
 *
 * @author TrinhBac
 */
public class BienLai extends KhachHang{
    private int ID;
    private double chiSoCu, chiSoMoi, tienDien;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setChiSoCu(double chiSoCu) {
        this.chiSoCu = chiSoCu;
    }

    public void setChiSoMoi(double chiSoMoi) {
        this.chiSoMoi = chiSoMoi;
    }

    public void setTienDien(double tienDien) {
        this.tienDien = tienDien;
    }

    public int getID() {
        return ID;
    }

    public double getChiSoCu() {
        return chiSoCu;
    }

    public double getChiSoMoi() {
        return chiSoMoi;
    }

    public double getTienDien() {
        return tienDien;
    }

    public BienLai(int ID, String hoTen, String soNha, String maCongTo, double chiSoCu, double chiSoMoi) {
        super(hoTen, soNha, maCongTo);
        this.ID = ID;
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
        this.tienDien = (chiSoMoi-chiSoCu)*750;
    }
    
    public String dataFormatted(){
        return String.format("%d/%s/%s/%s/%f/%f", ID, hoTen, soNha, maCongTo, chiSoCu, chiSoMoi);
    }
}
