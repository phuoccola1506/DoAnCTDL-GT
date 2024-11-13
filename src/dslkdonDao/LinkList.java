package dslkdonDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LinkList {

    public Link first;
    LinkDao obj = new LinkDao();

    //LinkList constructor
    public LinkList() {
        first = null;

    }

    public void insert(String maSV, String hoten, double diem) {
        //TẠO NÚT VÀ ĐIỀN GIÁ TRỊ CHO NÚT ĐÓ
        Link nut = new Link(maSV, hoten, diem);
        // ĐƯA NÚT ĐÓ VÀO DANH SÁCH
        nut.nextLink = first;
        first = nut;
    }

    public void ghifile() {
        obj.ghiFile(first);
    }

    public void docfile() {
        first = obj.docFile("D:\\Code\\phuoc_tap_lap_trinh\\javahdt\\section01\\CTDLVAGT\\src\\vinhhoanhao.txt");
    }

    public void printList() {
        Link p = first;

        System.out.println("===========================================");
        System.out.println("|           BANG DIEM SINH VIEN           |");
        System.out.println("===========================================");
        System.out.printf("|%7s|%25s|%7s|\n", "MaSV", "Ho Ten SV", "Diem");
        System.out.println("===========================================");
        //   System.out.print("List: ");
        while (p != null) {
            System.out.printf("|%7s|%25s|%7.1f|\n", p.getMaSV(), p.getHoten(), p.getDiem());
//            System.out.println(p.getMaSV() + "  " + p.getHoten() + "   " + p.getDiem());
            p = p.nextLink;
        }
        System.out.println("===========================================");
        System.out.println("");
    }

    public void ketQua() {
        Link p = first;

        System.out.println("======================================================");
        System.out.println("|               BANG KET QUA SINH VIEN               |");
        System.out.println("======================================================");
        System.out.printf("|%7s|%25s|%7s|%10s|\n", "MaSV", "Ho Ten SV", "Diem", "Ket Qua");
        System.out.println("======================================================");
        while (p != null) {
            System.out.printf("|%7s|%25s|%7.1f|%10s|\n", p.getMaSV(), p.getHoten(), p.getDiem(), p.getKq());
            p = p.nextLink;
        }
        System.out.println("=====================================================");
        System.out.println("");
    }

    public void xepLoai() {
        Link p = first;

        System.out.println("======================================================");
        System.out.println("|              BANG XEP LOAI SINH VIEN               |");
        System.out.println("======================================================");
        System.out.printf("|%7s|%25s|%7s|%10s|\n", "MaSV", "Ho Ten SV", "Diem", "Xep Loai");
        System.out.println("======================================================");
        while (p != null) {
            System.out.printf("|%7s|%25s|%7.1f|%10s|\n", p.getMaSV(), p.getHoten(), p.getDiem(), p.getXl());
            p = p.nextLink;
        }
        System.out.println("=====================================================");
        System.out.println("");
    }

    public void max() {
        Link p = first;

        double max = 0;
        while (p != null) {
            if (p.getDiem() > max) {
                max = p.getDiem();
            }
            p = p.nextLink;
        }

        inSVmax(max);
        System.out.println("");
    }

    public void inSVmax(double max) {
        Link p = first;

        while (p != null) {
            if (p.getDiem() == max) {
                System.out.println("==============================");
                System.out.println("| SINH VIEN CO DIEM CAO NHAT |");
                System.out.println("==============================");
                System.out.printf("|%20s|%7s|\n", "Ho va ten SV", "Diem");
                System.out.println("==============================");
                System.out.printf("|%20s|%7.1f|\n", p.getHoten(), p.getDiem());
                System.out.println("==============================");
            }
            p = p.nextLink;
        }
    }

    public void thongKeKetQua() {
        Link p = first;
        int dat = 0;
        int kdat = 0;

        while (p != null) {
            if (p.getDiem() >= 5) {
                p.setKq("Dat");
                dat++;
            } else {
                p.setKq("Khong dat");
                kdat++;
            }
            p = p.nextLink;
        }

        System.out.println("============================");
        System.out.println("|     Thong Ke Ket Qua     |");
        System.out.println("============================");
        System.out.printf("|%15s|%10s|\n", "Ket Qua", "So luong");
        System.out.printf("|%15s|%10d|\n", "Dat", dat);
        System.out.printf("|%15s|%10d|\n", "Khong Dat", kdat);
        System.out.println("============================");
        System.out.println("");
    }

    public void thongKeXepLoai() {
        Link p = first;
        int dg = 0;
        int dk = 0;
        int dtb = 0;
        int dy = 0;

        while (p != null) {
            if (p.getDiem() >= 8) {
                p.setXl("Gioi");
                dg++;
            } else if (p.getDiem() >= 6.5) {
                p.setXl("Kha");
                dk++;
            } else if (p.getDiem() >= 5) {
                p.setXl("Trung binh");
                dtb++;
            } else {
                p.setXl("Yeu");
                dy++;
            }
            p = p.nextLink;
        }

        System.out.println("============================");
        System.out.println("|     Thong Ke Xep Loai    |");
        System.out.println("============================");
        System.out.printf("|%15s|%10s|\n", "Xep loai", "So luong");
        System.out.printf("|%15s|%10d|\n", "Gioi", dg);
        System.out.printf("|%15s|%10d|\n", "Kha", dk);
        System.out.printf("|%15s|%10d|\n", "Trung Binh", dtb);
        System.out.printf("|%15s|%10d|\n", "Yeu", dy);
        System.out.println("============================");
        System.out.println("");
    }

    public Link timKiem(String maSV) {
        Link p = first;

        while (p != null) {
            if (p.getMaSV().equals(maSV)) {
                return p;
            }
            p = p.nextLink;
        }
        return null;
    }

//    @SuppressWarnings({"UnusedAssignment", "null"})
    @SuppressWarnings("null")
    public boolean xoaSinhVien(String maSV) {
        Link p = first;
        Link q = null;

        while (p != null) {
            if (p.getMaSV().equals(maSV)) {
                if (p == first) {
                    first = first.nextLink;
                } else {
                    q.nextLink = p.nextLink;
                }
//                System.out.println("Xoa thanh cong");
                return true;
            }
            q = p;
            p = p.nextLink;
        }
        return false;
    }

    public void sapXep() {
        Link p = first;

        List list = new ArrayList<>();
        while (p != null) {
            list.add(p);
            p = p.nextLink;
        }

        Collections.sort(list, new Comparator<Link>() {
            @Override
            public int compare(Link o1, Link o2) {
                return Double.compare(o2.getDiem(), o1.getDiem());
            }
        });

        first = (Link) list.get(0);
        p = first;

        for (int i = 1; i < list.size(); i++) {
            p.nextLink = (Link) list.get(i);
            p = p.nextLink;
        }

        p.nextLink = null;

        printList();
    }

    public void ketNoiCSDL(String user, String password) {
        // Cấu hình thông tin kết nối
        String url = "jdbc:mysql://localhost:3306/ctdlvgt";

        // Kết nối và lấy dữ liệu
        try {
            // Tải driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Tạo kết nối đến MySQL
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                System.out.println("Ket noi thanh cong!");

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
                        System.out.println("MaSV: " + maSV + ", HoTen: " + hoTen + ", Diem: " + diem);
                        insert(maSV, hoTen, diem);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Khong tim thay driver JDBC!");
        } catch (SQLException e) {
            System.out.println("Khong the ket noi den CSDL!");
        }
    }
}
