package Model;

/**
 *
 * @author raybnsr
 */
public class Kendaraan {
   private String plat;
   private String jenis;
   private String status;

    public Kendaraan(String plat, String jenis, String status) {
        this.plat = plat;
        this.jenis = jenis;
        this.status = status;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
   
}
