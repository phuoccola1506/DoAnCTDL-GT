package dslkdoiDao;

import java.util.Scanner;

public class DoubleLinkList {

    public DoubleLink first, last;
    DoubleLink q = null;
    DoubleLink p = null;

    public DoubleLinkList() {
        first = null;
        last = null;
    }

    //    Chèn dữ liệu vào danh sách
    public void insert(String maSV, String hoTen, double diem) {
        DoubleLink nut = new DoubleLink(maSV, hoTen, diem);
        if (first == null && last == null) {
            first = nut;
            last = nut;
        } else {
            last.next = nut;
            nut.prev = last;
            last = nut;
        }
    }

    //    Tạo danh sách liên kết
    public void createList() {
        Scanner sc = new Scanner(System.in);
        boolean ok = true;
        while (ok) {
            System.out.print("Nhap ma Sinh Vien: ");
            String maSV = sc.nextLine();
            if (maSV.isEmpty()) {
                System.out.println("Rong");
                break;
            } else {
                System.out.print("Nhap ho ten: ");
                String hoTen = sc.nextLine();
                System.out.print("Nhap diem: ");
                double diem = sc.nextDouble();
                sc.nextLine();
                insert(maSV, hoTen, diem);
            }
        }
    }

    //    In dữ liệu từ first -> last
    public void printListFirst() {
        DoubleLink current = first;
        while (current != null) {
            System.out.println(current.getMaSV() + " - " + current.getHoTen() + " - " + current.getDiem());
            current = current.next;
        }
    }

    //    In list từ last -> first
    public void printListLast() {
        DoubleLink current = last;
        while (current != null) {
            System.out.println(current.getMaSV() + " - " + current.getHoTen() + " - " + current.getDiem());
            current = current.prev;
        }
    }

    //    In full list từ first -> last
    public void printListFull() {
        DoubleLink current = first;
        while (current != null) {
            current.setKq(current.getDiem() >= 5 ? "Dau" : "Rot");
            current.setXl(current.getDiem() < 5 ? "Yeu" : current.getDiem() < 7 ? "TB" : current.getDiem() < 8 ? "Kha" : "Gioi");
            System.out.println(current.getMaSV() + " - " + current.getHoTen() + " - " + current.getDiem() + " - " + current.getKq() + " - " + current.getXl());
            current = current.next;
        }
    }

    //    Tìm kiếm
    public DoubleLink search(String maSV) {
        DoubleLink current = first;
        while (current != null && current.getMaSV().compareTo(maSV) != 0) {
            current = current.next;
        }
        return current;
    }
    
    //    Xem thông tin sinh viên bất kì theo maSV
    public void timKiemThongTin(String maSV) {
        DoubleLink current = search(maSV);
        System.out.println("Xem thong tin sinh vien");
        System.out.println("MaSV: " + current.getMaSV());
        System.out.println("HoTen: " + current.getHoTen());
        System.out.println("Diem: " + current.getDiem());
        System.out.println("Ket qua: " + current.getKq());
        System.out.println("Xep loai: " + current.getXl());
    }

    //    Xoá Sinh viên bất kì theo maSV
    public void deleteWithSearch(String maSV) {
        DoubleLink current = search(maSV);  // Tìm node có mã sinh viên tương ứng
        if (current != null) {
            // Trường hợp node cần xóa là node đầu tiên (first)
            if (current == first) {
                first = current.next;  // Cập nhật first thành node kế tiếp
                if (first != null) {
                    first.prev = null;  // Nếu danh sách không rỗng sau khi xóa, cập nhật first.prev
                }
            } else {
                // Cập nhật next của node trước node hiện tại
                if (current.prev != null) {
                    current.prev.next = current.next;
                }
            }

            // Cập nhật prev của node sau node hiện tại
            if (current.next != null) {
                current.next.prev = current.prev;
            }

            System.out.println("Da xoa phan tu co ma sinh vien " + current.getMaSV());
        } else {
            System.out.println("Khong tim thay ma sinh vien can xoa!");
        }
    }

    //    Chèn thêm một sinh viên
    @SuppressWarnings("UnusedAssignment")
    public void themSinhVien(String maSV, String hoTen, double diem) {
        DoubleLink current = first;
        DoubleLink themsinhvienmoi = new DoubleLink(maSV, hoTen, diem);
        
        if (current == null) {
            current = themsinhvienmoi;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = themsinhvienmoi;
        themsinhvienmoi.prev = current;
        
    }
    
    //    Thống kê sinh viên theo xếp loại
    public void thongKeSinhVien() {
        int dg = 0;
        int dk = 0;
        int dtb = 0;
        int dy = 0;
        DoubleLink current = first;
        
        while (current != null) {
            if (null == current.getXl()) {
                dy++;
            }
            else switch (current.getXl()) {
                case "Gioi" -> dg++;
                case "Kha" -> dk++;
                case "TB" -> dtb++;
                default -> dy++;
            }
        }
        
        System.out.println("So luong sinh vien gioi la " + dg);
        System.out.println("So luong sinh vien kha la " + dk);
        System.out.println("So luong sinh vien trung binh la " + dtb);
        System.out.println("So luong sinh vien yeu la " + dy);
    }
    
    //    Sắp xếp sinh viên
    public void bubbleSortByDiem() {
        if (first == null) {
            return;
        }

        boolean swapped;
        DoubleLink current;
        do {
            swapped = false;
            current = first;

            while (current.getNext() != null) {
                if (current.getDiem() > current.getNext().getDiem()) {
                    // Hoán đổi thông tin sinh viên
                    swapData(current, current.getNext());
                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);
    }

    // Hàm hoán đổi dữ liệu giữa hai node
    private void swapData(DoubleLink a, DoubleLink b) {
        String tempMaSV = a.getMaSV();
        String tempHoTen = a.getHoTen();
        double tempDiem = a.getDiem();
        String tempKq = a.getKq();
        String tempXl = a.getXl();

        a.setMaSV(b.getMaSV());
        a.setHoTen(b.getHoTen());
        a.setDiem(b.getDiem());
        a.setKq(b.getKq());
        a.setXl(b.getXl());

        b.setMaSV(tempMaSV);
        b.setHoTen(tempHoTen);
        b.setDiem(tempDiem);
        b.setKq(tempKq);
        b.setXl(tempXl);
    }

    // Hàm in danh sách sinh viên
    public void printList() {
        DoubleLink temp = first;
        while (temp != null) {
            System.out.println("MaSV: " + temp.getMaSV() + ", HoTen: " + temp.getHoTen() + ", Diem: " + temp.getDiem());
            temp = temp.getNext();
        }
    }
}
