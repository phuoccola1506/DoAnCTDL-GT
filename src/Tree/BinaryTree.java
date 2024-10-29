/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

import java.util.Scanner;

/**
 *
 * @author TGDD
 */
public class BinaryTree {

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    private Node taoCon(Node current, String maSV, String hoTen, double diem) {
        if (current == null) {
            return new Node(maSV, hoTen, diem);
        }

        if (maSV.compareTo(current.getMaSV()) < 0) {
            current.left = taoCon(current.left, maSV, hoTen, diem);
        } else if (maSV.compareTo(current.getMaSV()) > 0) {
            current.right = taoCon(current.right, maSV, hoTen, diem);
        }

        return current;
    }

    public void nhapCon() {
        Scanner sc = new Scanner(System.in);
        boolean ok = true;

        while (ok) {
            System.out.println("Nhap thong tin sinh vien");
            System.out.print("Nhap maSV: ");
            String maSV = sc.nextLine();
            if (maSV.isEmpty()) {
                System.out.println("Rong");
                break;
            }
            else {
                System.out.print("Nhap hoTen: ");
                String hoTen = sc.nextLine();
                System.out.print("Nhap diem: ");
                double diem = sc.nextDouble();
                sc.nextLine();
                root = taoCon(root, maSV, hoTen, diem);
            }            
        }
    }

    public void duyet() {
        duyetNode(root);
    }

    public void duyetNode(Node current) {
        if (current != null) {
            inDanhSachNode(current);
            duyetNode(current.left);
            duyetNode(current.right);
            }
    }

    private void inDanhSachNode(Node current) {
        System.out.println("MaSV: " + current.getMaSV() + ", HoTen: " + current.getHoTen()
                + ", Diem: " + current.getDiem() + ", KQ: " + current.getKq()
                + ", XL: " + current.getXl());
    }
}
