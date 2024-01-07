package com.ttb.baitap;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MultipleChoice extends CauHoi {
    
    private DanhMuc danhMuc;
    private String ghiChu;
    private static int dem;

    public MultipleChoice() {
        super(null, null, null,null);
    }
   
    
    
    public MultipleChoice( String noiDung, List<PhuongAn> phuongAn, Do_Kho doKho, PhuongAn phuongAnDung,DanhMuc danhMuc, String ghiChu) {
        super(noiDung, phuongAn, doKho,phuongAnDung);
        this.danhMuc = danhMuc;
        this.ghiChu = ghiChu;
    }

    
    
    @Override
    public void hienThi(){
        System.out.printf("%d. %s\n%s\n\n",++dem,super.getNoiDung(),super.getPhuongAn());
    }
    


    @Override
    public void phuongAn() {
        System.out.println(super.getPhuongAn());
    }

    /**
     * @return the danhMuc
     */
    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    /**
     * @param danhMuc the danhMuc to set
     */
    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    /**
     * @return the ghiChu
     */
    public String getGhiChu() {
        return ghiChu;
    }

    /**
     * @param ghiChu the ghiChu to set
     */
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
