package com.ttb.baitap;


import java.util.List;

public class Incomplete extends CauHoi {

    private static int dem;
    private boolean flag;
    
    public Incomplete() {
        super(null, null, null, null);
    }

    public Incomplete(String noiDung, List<PhuongAn> phuongAn, Do_Kho doKho, PhuongAn phuongAnDung) {
        super(noiDung, phuongAn, doKho, phuongAnDung);
    }

    

    @Override
    public void phuongAn() {
        
    }

    @Override
    public void hienThi() {
        System.out.println(getNoiDung());
        for(PhuongAn pa: getPhuongAn())
            System.out.printf("%d"+pa.getNoiDungPA()+"\n",++dem);
    }

    
	
}
