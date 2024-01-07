/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttb.baitap;

/**
 *
 * @author USER
 */
public class PhuongAn {
    private String noiDungPA;


    public PhuongAn(String noiDungPA) {
        this.noiDungPA = noiDungPA;
    }

  

    public PhuongAn() {
        
    }

    @Override
    public String toString() {
        return String.format("%s", this.noiDungPA);
    }
    
    /**
     * @return the noiDungPA
     */
    public String getNoiDungPA() {
        return noiDungPA;
    }

    /**
     * @param noiDungPA the noiDungPA to set
     */
    public void setNoiDungPA(String noiDungPA) {
        this.noiDungPA = noiDungPA;
    }
}
