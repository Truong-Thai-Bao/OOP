package com.ttb.baitap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QLCauHoi {

    private List<CauHoi> ds;

    public QLCauHoi() {
        this.ds = new ArrayList<>();
    }

    public List<CauHoi> timCauHoi(String noiDung) {
        return ds.stream().filter(c -> c.getNoiDung().toLowerCase().contains(noiDung.toLowerCase())).collect(Collectors.toList());

    }

    public List<CauHoi> timCauHoi(Do_Kho doKho) {
        return ds.stream().filter(c -> c.getDoKho().equals(doKho)).collect(Collectors.toList());

    }

    public List<CauHoi> timCauHoi(DanhMuc danhMuc) {
        List<CauHoi> kq = new ArrayList<>();
        for (CauHoi c : ds) {
            if (c instanceof MultipleChoice && ((MultipleChoice) c).getDanhMuc().equals(danhMuc)) {
                kq.add(c);
            }
        }
        return kq;
    }

    public void docFileMultipleChoice() throws FileNotFoundException {
        File f = new File("src/main/java/com/ttb/baitap/file/Multiple Choice");

        try ( Scanner sc = new Scanner(f)) {
            String dm = "";
            while (sc.hasNext()) {
                String currentLine = sc.nextLine();

                if (currentLine.startsWith("#")) {
                    dm = currentLine.substring(1);
                } else {
                    sc.nextLine();
                }
                String nd = sc.nextLine();
                List<PhuongAn> listPa = new ArrayList<>();

                while (sc.hasNext()) {
                    currentLine = sc.nextLine();
                    listPa.add(new PhuongAn(currentLine));

                    if (currentLine.isEmpty()) {
                        break;
                    }
                }
                String pad = sc.nextLine();
                Do_Kho doKho = Do_Kho.fromFileValue(Integer.parseInt(sc.nextLine()));
                String gc = sc.nextLine();

                ds.add(new MultipleChoice(nd, listPa, doKho, new PhuongAn(pad), new DanhMuc(dm), gc));
            }
        }
    }

    public void docFileIncomplete() throws FileNotFoundException {
        File f = new File("src/main/java/com/ttb/baitap/file/Incomplete");

        try ( Scanner sc = new Scanner(f)) {
            while (sc.hasNext()) {
                String currentLine = sc.nextLine();

                Do_Kho doKho = Do_Kho.fromFileValue(Integer.parseInt(currentLine));
                String nd = "";
                while (sc.hasNext()) {
                    nd += sc.nextLine();
                    if (sc.nextLine().startsWith("#")) {
                        break;
                    }
                }

                List<PhuongAn> listPa = new ArrayList<>();

                while (sc.hasNext()) {
                    if (currentLine.startsWith("@")) 
                        break;
                    
                    while (sc.hasNext()) {
                        currentLine = sc.nextLine();
                        listPa.add(new PhuongAn(currentLine));

                        if (currentLine.isEmpty()) 
                            break;
                    }
                    sc.nextLine();
                    String pad = currentLine;
                    ds.add(new Incomplete(nd, listPa, doKho, new PhuongAn(pad)));
                    
                }

            }
        }
    }

    public void hienThiDsCauHoi() {
        ds.forEach(c -> c.hienThi());
    }

    /**
     * @return the ds
     */
    public List<CauHoi> getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(List<CauHoi> ds) {
        this.ds = ds;
    }
}
