package object;

public class LyThuyet {
    private String cauHoi;
    private String dapAn1;
    private String dapAn2;
    private String dapAn3;
    private String dapAnDung;

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getDapAn1() {
        return dapAn1;
    }

    public void setDapAn1(String dapAn1) {
        this.dapAn1 = dapAn1;
    }

    public String getDapAn2() {
        return dapAn2;
    }

    public void setDapAn2(String dapAn2) {
        this.dapAn2 = dapAn2;
    }

    public String getDapAn3() {
        return dapAn3;
    }

    public void setDapAn3(String dapAn3) {
        this.dapAn3 = dapAn3;
    }

    public String getDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(String dapAnDung) {
        this.dapAnDung = dapAnDung;
    }

    public LyThuyet(String cauHoi, String dapAn1, String dapAn2, String dapAn3, String dapAnDung) {
        this.cauHoi = cauHoi;
        this.dapAn1 = dapAn1;
        this.dapAn2 = dapAn2;
        this.dapAn3 = dapAn3;
        this.dapAnDung = dapAnDung;
    }

    public LyThuyet() {
        this.cauHoi = null;
        this.dapAn1 = null;
        this.dapAn2 = null;
        this.dapAn3 = null;
        this.dapAnDung = null;
    }
}
