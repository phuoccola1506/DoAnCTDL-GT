/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public void ketNoiCSDL(String user, String password) {
        // Cấu hình thông tin kết nối
        String url = "jdbc:mysql://localhost:3306/ctdlvgt"; // Đảm bảo CSDL của bạn có tên đúng

        // Kết nối và lấy dữ liệu
        try {
            // Tải driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Tạo kết nối đến MySQL
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                System.out.println("Kết nối thành công!");

                // Tạo câu truy vấn SQL
                String query = "SELECT * FROM sinhvien";

                // Thực hiện truy vấn và lấy kết quả
                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(query)) {

                    // Duyệt qua kết quả
                    while (rs.next()) {
                        // Ví dụ: lấy dữ liệu từ các cột trong bảng
                        String maSV = rs.getString("MaSV");
                        String hoTen = rs.getString("HoTen");
                        double diem = rs.getDouble("Diem");

                        // In kết quả và tạo node trong cây nhị phân
                        System.out.println("MaSV: " + maSV + ", HoTen: " + hoTen + ", Diem: " + diem);
                        
                        // Tạo node mới trong cây nhị phân
                        root = taoCon(root, maSV, hoTen, diem);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy driver JDBC!");
        } catch (SQLException e) {
            System.out.println("Không thể kết nối đến CSDL!");
        }
    }

    // Hàm tạo node trong cây nhị phân
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
                System.out.println("Thoat chuong trinh nhap");
                break;
            } else {
                System.out.print("Nhap hoTen: ");
                String hoTen = sc.nextLine();
                System.out.print("Nhap diem: ");
                double diem = sc.nextDouble();
                sc.nextLine();
                while (true) {
                    if (diem >= 0 && diem <= 10) {
                        break;
                    } else {
                        System.out.print("Diem khong hop le, hay nhap lai: ");
                        diem = sc.nextDouble();
                        sc.nextLine();
                    }
                }
                root = taoCon(root, maSV, hoTen, diem);
            }
        }
    }

    public void duyet() {
        duyetNode(root);
        System.out.println("Duyet thanh cong");
    }

    public void duyetNode(Node current) {
        if (current != null) {
            duyetNode(current.left); // Duyệt cây con bên trái
            inDanhSachNode(current); // In ra nút hiện tại
            duyetNode(current.right); // Duyệt cây con bên phải
        }
    }

    public void inDanhSachNode(Node current) {
        if (current != null) {
            System.out.println("MaSV: " + current.getMaSV());
            System.out.println("HoTen: " + current.getHoTen());
            System.out.println("Diem: " + current.getDiem());
            System.out.println("--------------------------");
        }
    }
    
}
