/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

/**
 *
 * @author TrinhBac
 */
public class Diem {
    public double mon1, mon2, mon3, dTB;

    public Diem() {
    }
    
    public Diem(double mon1, double mon2, double mon3) {
        this.mon1 = mon1;
        this.mon2 = mon2;
        this.mon3 = mon3;
        this.dTB = (mon1+mon2+mon3)/3;
    }

    public double getMon1() {
        return mon1;
    }

    public void setMon1(double mon1) {
        this.mon1 = mon1;
    }

    public double getMon2() {
        return mon2;
    }

    public void setMon2(double mon2) {
        this.mon2 = mon2;
    }

    public double getMon3() {
        return mon3;
    }

    public void setMon3(double mon3) {
        this.mon3 = mon3;
    }

    public double getdTB() {
        return dTB;
    }

    public void setdTB(double dTB) {
        this.dTB = dTB;
    }
    
    
}
