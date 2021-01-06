package object;

public class BienBao {
    private String SoHieu;
    private int HinhAnh;
    private String TenBienBao;
    private String NoiDung;

    public BienBao(String soHieu, int hinhAnh, String tenBienBao, String noiDung) {
        SoHieu = soHieu;
        HinhAnh = hinhAnh;
        TenBienBao = tenBienBao;
        NoiDung = noiDung;
    }

    public BienBao() {
        SoHieu = null;
        HinhAnh = 0;
        TenBienBao = null;
        NoiDung = null;
    }

    public String getSoHieu() {
        return SoHieu;
    }

    public void setSoHieu(String soHieu) {
        SoHieu = soHieu;
    }

    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public String getTenBienBao() {
        return TenBienBao;
    }

    public void setTenBienBao(String tenBienBao) {
        TenBienBao = tenBienBao;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }
}
