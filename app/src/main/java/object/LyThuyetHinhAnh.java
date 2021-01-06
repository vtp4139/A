package object;

public class LyThuyetHinhAnh {
    private String cauHoi;
    private int HinhAnh;
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

    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh = hinhAnh;
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

    public LyThuyetHinhAnh(String cauHoi, int hinhAnh, String dapAn1, String dapAn2, String dapAn3, String dapAnDung) {
        this.cauHoi = cauHoi;
        HinhAnh = hinhAnh;
        this.dapAn1 = dapAn1;
        this.dapAn2 = dapAn2;
        this.dapAn3 = dapAn3;
        this.dapAnDung = dapAnDung;
    }

    public LyThuyetHinhAnh() {
        this.cauHoi = null;
        HinhAnh = 0;
        this.dapAn1 = null;
        this.dapAn2 = null;
        this.dapAn3 = null;
        this.dapAnDung = null;
    }
}
