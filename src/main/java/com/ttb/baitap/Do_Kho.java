/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.ttb.baitap;

/**
 *
 * @author USER
 */
public enum Do_Kho {
        DE(1),
    TRUNG_BINH(2),
    KHO(3);
    
    protected int diemSo;


    private Do_Kho(int diemSo) {
        this.diemSo = diemSo;
    }

    /**
     * @return the diemSo
     */
    public int getDiemSo() {
        return diemSo;
    }

    /**
     * @param diemSo the diemSo to set
     */
    public void setDiemSo(int diemSo) {
        this.diemSo = diemSo;
    }
    public static Do_Kho fromFileValue(int fileValue) {
        for (Do_Kho value : Do_Kho.values()) {
            if (value.diemSo==fileValue) {
                return value;
            }
        }
        // Nếu không tìm thấy, có thể xử lý hoặc báo lỗi tùy thuộc vào yêu cầu của bạn
        return null;
    }
}
