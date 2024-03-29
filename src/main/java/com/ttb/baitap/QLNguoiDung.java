package com.ttb.baitap;

import com.ttb.baitap.CauHinh;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QLNguoiDung {

    private List<NguoiDung> ds;

    public QLNguoiDung(List<NguoiDung> ds) {
        this.ds = ds;
    }

    public QLNguoiDung() {
        this.ds = new ArrayList<>();
    }

    public void dSNguoiDung() throws FileNotFoundException {
        File f = new File("src/main/java/com/ttb/baitap/file/DSNGuoiDung");
        try ( Scanner sc = new Scanner(f)) {
            while (sc.hasNext()) {
                this.ds.add(new NguoiDung(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
            }
        }
    }

    public void hienThiDSNguoiDung() {
        if (ds.isEmpty()) {
            System.out.println("Khong tim thay nguoi dung nao");
            return;
        }
        for (NguoiDung nguoiDung : ds) {
            nguoiDung.hienThi();
        }
    }

    public List<NguoiDung> traCuu(String s) {
        return ds.stream().filter(nguoiDung -> nguoiDung.getHoTen().toLowerCase().contains(s.toLowerCase())
                || nguoiDung.getQueQuan().toLowerCase().contains(s.toLowerCase())
                || nguoiDung.getGioiTinh().toLowerCase().contains(s.toLowerCase())
                || nguoiDung.ngaySinhToString().equals(s)).collect(Collectors.toList());
    }

    public Date chuyenDoiNgayThang(String ngayThang) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            return dateFormat.parse(ngayThang);
        } catch (ParseException e) {
            System.out.println("Loi: Ngay thang nam nhap khong dung dinh dang (dd/MM/yyyy). Vui long nhap lai.");
            return null;
        }
    }

    public String chuyenDateSangChuoi(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    public void themNguoiDung(NguoiDung... a) {
        this.ds.addAll(Arrays.asList(a));
    }

    public void themNguoiHoc() {
//        System.out.print("Nhap ho ten: ");
//        String hoTen = CauHinh.SC.nextLine();
//        System.out.print("Nhap que quan: ");
//        String queQuan = CauHinh.SC.nextLine();
//        System.out.print("Nhap gioi tinh: ");
//        String gioiTinh = CauHinh.SC.nextLine();
//        System.out.print("Nhap ngay sinh (dd/MM/yyyy): ");
//        String ngaySinh = CauHinh.SC.nextLine();
//        System.out.print("Nhap ngay gia nhap (dd/MM/yyyy): ");
//        String ngayGiaNhap = CauHinh.SC.nextLine();
//        
//        NguoiDung nguoiDung = new NguoiDung(hoTen, queQuan, gioiTinh, ngaySinh, ngayGiaNhap);
//        ds.add(nguoiDung);
//        ghiNguoiDungVaoFile(nguoiDung);
//        System.out.println("Da them nguoi hoc: " + hoTen);
        System.out.print("Nhap ho ten: ");
        String hoTen = CauHinh.SC.nextLine();
        System.out.print("Nhap que quan: ");
        String queQuan = CauHinh.SC.nextLine();
        System.out.print("Nhap gioi tinh: ");
        String gioiTinh = CauHinh.SC.nextLine();

        String ngaySinhStr;
        Date ngaySinh = null;
        do {
            System.out.print("Nhap ngay sinh (dd/MM/yyyy): ");
            ngaySinhStr = CauHinh.SC.nextLine();
            ngaySinh = chuyenDoiNgayThang(ngaySinhStr);
        } while (ngaySinh == null);

        String ngayGiaNhapStr;
        Date ngayGiaNhap = null;
        do {
            System.out.print("Nhap ngay gia nhap (dd/MM/yyyy): ");
            ngayGiaNhapStr = CauHinh.SC.nextLine();
            ngayGiaNhap = chuyenDoiNgayThang(ngayGiaNhapStr);
        } while (ngayGiaNhap == null);
        ngaySinhStr = chuyenDateSangChuoi(ngaySinh);
        ngayGiaNhapStr = chuyenDateSangChuoi(ngayGiaNhap);
        NguoiDung nguoiDung = new NguoiDung(hoTen, queQuan, gioiTinh, ngaySinhStr, ngayGiaNhapStr);
        ds.add(nguoiDung);
        ghiNguoiDungVaoFile(nguoiDung);
        System.out.println("Da them nguoi hoc: " + hoTen);
    }

    public void ghiNguoiDungVaoFile(NguoiDung nguoiDung) {
        try ( PrintWriter writer = new PrintWriter(new FileWriter("src/main/java/com/ttb/baitap/file/DSNGuoiDung", true))) {
            writer.println(nguoiDung.getHoTen());
            writer.println(nguoiDung.getQueQuan());
            writer.println(nguoiDung.getGioiTinh());
            writer.println(nguoiDung.ngaySinhToString());
            writer.println(nguoiDung.ngayGiaNhapToString());
            System.out.println("Ghi file thanh cong.");
        } catch (IOException e) {
        }
    }

    public void xoaNguoiDung(String ten) {
        NguoiDung nguoiDungXoa = null;
        for (NguoiDung nguoiDung : ds) {
            if (nguoiDung.getHoTen().equals(ten)) {
                nguoiDungXoa = nguoiDung;
                break;
            }
        }

        if (nguoiDungXoa != null) {
            ds.remove(nguoiDungXoa);
            System.out.println("Da xoa nguoi dung co ten: " + ten);
        } else {
            System.out.println("Khong tim thay nguoi dung co ten: " + ten);
        }
    }

    public void ghiNguoiDungVaoFile() {
        try ( PrintWriter writer = new PrintWriter("src/main/java/com/ttb/baitap/file/DSNGuoiDung")) {
            for (NguoiDung nguoiDung : ds) {
                writer.println(nguoiDung.getHoTen());
                writer.println(nguoiDung.getQueQuan());
                writer.println(nguoiDung.getGioiTinh());
                writer.println(nguoiDung.ngaySinhToString());
                writer.println(nguoiDung.ngayGiaNhapToString());
            }
            System.out.println("Ghi file thanh cong.");
        } catch (FileNotFoundException e) {
        }
    }

    public void capNhatThongTin(String ten) {

        NguoiDung nguoiDungCanCapNhat = null;
        for (NguoiDung nguoiDung : ds) {
            if (nguoiDung.getHoTen().equals(ten)) {
                nguoiDungCanCapNhat = nguoiDung;
                break;
            }
        }

        if (nguoiDungCanCapNhat != null) {
            nguoiDungCanCapNhat.hienThi();
            System.out.println("Ban muon cap nhat thuoc tinh nao hay nhap so tuong ung:");
            System.out.println("1. Ho ten");
            System.out.println("2. Que quan");
            System.out.println("3. Gioi tinh");
            System.out.println("4. Ngay sinh");
            System.out.println("5. Ngay gia nhap");
            System.out.print("Nhap: ");
            int choice = Integer.parseInt(CauHinh.SC.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Nhap ho ten moi: ");
                    String hoTenMoi = CauHinh.SC.nextLine();
                    nguoiDungCanCapNhat.setHoTen(hoTenMoi);
                    System.out.println("Da cap nhat ho ten.");
                }
                case 2 -> {
                    System.out.print("Nhap que quan moi: ");
                    String queQuanMoi = CauHinh.SC.nextLine();
                    nguoiDungCanCapNhat.setQueQuan(queQuanMoi);
                    System.out.println("Da cap nhat que quan.");
                }
                case 3 -> {
                    System.out.print("Nhap gioi tinh moi: ");
                    String gioiTinhMoi = CauHinh.SC.nextLine();
                    nguoiDungCanCapNhat.setGioiTinh(gioiTinhMoi);
                    System.out.println("Da cap nhat gioi tinh.");
                }
                case 4 -> {
//                    System.out.print("Nhap ngay sinh moi (yyyy-MM-dd): ");
//                    LocalDate ngaySinhMoi = LocalDate.parse(CauHinh.SC.nextLine());
                    String ngaySinhStr;
                    Date ngaySinh = null;
                    do {
                        System.out.print("Nhap ngay sinh moi (dd/MM/yyyy): ");
                        ngaySinhStr = CauHinh.SC.nextLine();
                        ngaySinh = chuyenDoiNgayThang(ngaySinhStr);
                    } while (ngaySinh == null);
                    ngaySinhStr = chuyenDateSangChuoi(ngaySinh);
                    LocalDate ngaySinhMoi = LocalDate.parse(ngaySinhStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    nguoiDungCanCapNhat.setNgaySinh(ngaySinhMoi);
                    System.out.println("Da cap nhat ngay sinh.");
                }
                case 5 -> {
//                    System.out.print("Nhap ngay gia nhap moi (yyyy-MM-dd): ");
                    String ngayGiaNhapStr;
                    Date ngayGiaNhap = null;
                    do {
                        System.out.print("Nhap ngay gia nhap moi (dd/MM/yyyy): ");
                        ngayGiaNhapStr = CauHinh.SC.nextLine();
                        ngayGiaNhap = chuyenDoiNgayThang(ngayGiaNhapStr);
                    } while (ngayGiaNhap == null);
                    ngayGiaNhapStr = chuyenDateSangChuoi(ngayGiaNhap);
                    LocalDate ngayGiaNhapMoi = LocalDate.parse(ngayGiaNhapStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    nguoiDungCanCapNhat.setNgayGiaNhap(ngayGiaNhapMoi);
                    System.out.println("Da cap nhat ngay gia nhap.");
                }
                default ->
                    System.out.println("Lua chon khong hop le.");

            }
        } else {
            System.out.println("Khong tim thay nguoi dung co ten: " + ten + " - Luu y nhap dung ho ten!!!");
        }

    }

    /**
     * @return the ds
     */
    public List<NguoiDung> getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(List<NguoiDung> ds) {
        this.ds = ds;
    }

}
