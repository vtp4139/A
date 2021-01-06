package object;

public class Luat {
    private String SoLuat;
    private String NoiDung;
    private String MucPhat;

    public Luat(String soLuat, String noiDung, String mucPhat) {
        SoLuat = soLuat;
        NoiDung = noiDung;
        MucPhat = mucPhat;
    }

    public Luat() {
        SoLuat = null;
        NoiDung = null;
        MucPhat = null;
    }

    public String getSoLuat() {
        return SoLuat;
    }

    public void setSoLuat(String soLuat) {
        SoLuat = soLuat;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String getMucPhat() {
        return MucPhat;
    }

    public void setMucPhat(String mucPhat) {
        MucPhat = mucPhat;
    }
}
