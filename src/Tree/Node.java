/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

/**
 *
 * @author TGDD
 */
public class Node {

    private String maSV;
    private String hoTen;
    private double diem;
    private String kq, xl;
    public Node left, right;

    public Node(String maSV, String hoTen, double diem) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diem = diem;
        setKq(diem);
        setXl(xl);
        this.left = null;
        this.right = null;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getKq() {
        return kq;
    }

    public void setKq(double kq) {
        if (getDiem() > 5) {
            this.kq = "Dau";
        }
        else {
            this.kq = "Rot";
        }
    }

    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        if (getDiem() > 8) {
            this.xl = "Gioi";
        }
        else if (getDiem() > 6.5) {
            this.xl = "Kha";
        }
        else if (getDiem() > 5) {
            this.xl = "TB";
        }
        else {
            this.xl = "Yeu";
        }
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}
