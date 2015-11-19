package zonaapp.co.cancharapida.Entities;


public class Reserva {

    private String fechaData;
    private String horaData;
    private int idUser;
    private String cancha;
    private String nombreUsuario;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getFechaData() {
        return fechaData;
    }

    public void setFechaData(String fechaData) {
        this.fechaData = fechaData;
    }

    public String getHoraData() {
        return horaData;
    }

    public void setHoraData(String horaData) {
        this.horaData = horaData;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getCancha() {
        return cancha;
    }

    public void setCancha(String cancha) {
        this.cancha = cancha;
    }
}
