package dslkdonDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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
        //   System.out.print("List: ");
        while (p != null) {
            System.out.println(p.getMaSV() + "  " + p.getHoten() + "   " + p.getDiem());
            p = p.nextLink;
        }
        System.out.println("");
    }

    public void ketQua() {
        Link p = first;

        while (p != null) {
            if (p.getDiem() >= 5) {
                p.setKq("Dat");
            } else {
                p.setKq("Khong Dat");
            }
            System.out.println(p.getMaSV() + "  " + p.getHoten() + "   " + p.getDiem() + "   " + p.getKq());
            p = p.nextLink;
        }
        System.out.println("");
    }

    public void xepLoai() {
        Link p = first;

        while (p != null) {
            if (p.getDiem() >= 8) {
                p.setXl("Gioi");
            } else if (p.getDiem() >= 6.5) {
                p.setXl("Kha");
            } else if (p.getDiem() >= 5) {
                p.setXl("Trung binh");
            } else {
                p.setXl("Yeu");
            }
            System.out.println(p.getMaSV() + "  " + p.getHoten() + "   " + p.getDiem() + "   " + p.getXl());
            p = p.nextLink;
        }
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

        System.out.println("Diem cao nhat la: " + max);
        inSVmax(max);
        System.out.println("");
    }

    public void inSVmax(double max) {
        Link p = first;

        while (p != null) {
            if (p.getDiem() == max) {
                System.out.println(p.getHoten() + "   " + p.getDiem());
            }
            p = p.nextLink;
        }
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

        System.out.println("Sinh vien xep loai gioi: " + dg);
        System.out.println("Sinh vien xep loai kha: " + dk);
        System.out.println("Sinh vien xep loai trung binh: " + dtb);
        System.out.println("Sinh vien xep loai yeu: " + dy);
        System.out.println("");
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
    }
}
