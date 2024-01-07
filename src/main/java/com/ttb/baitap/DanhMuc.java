/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttb.baitap;

/**
 *
 * @author USER
 */
public class DanhMuc {
    private String loaiDanhMuc;

    public DanhMuc(String loaiDanhMuc) {
        this.loaiDanhMuc = loaiDanhMuc;
    }

    public DanhMuc() {
    }

    @Override
    public String toString() {
        return String.format("%s", this.loaiDanhMuc);
    }

    
    /**
     * @return the loaiDanhMuc
     */
    public String getLoaiDanhMuc() {
        return loaiDanhMuc;
    }

    /**
     * @param loaiDanhMuc the loaiDanhMuc to set
     */
    public void setLoaiDanhMuc(String loai){
            this.loaiDanhMuc = loai;
        }
        
}
