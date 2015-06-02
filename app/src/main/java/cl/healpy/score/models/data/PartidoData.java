package cl.healpy.score.models.data;


import com.j256.ormlite.field.DatabaseField;


public class PartidoData {

    @DatabaseField(generatedId = true)
    private int _id;
    @DatabaseField
    private int id_championship;
    @DatabaseField
    private String horaEstado;
    @DatabaseField
    private int idPartido;
    @DatabaseField
    private String hora;
    @DatabaseField
    private String ciudad;
    @DatabaseField
    private int idEstado;
    @DatabaseField
    private String nombreArbitro;
    @DatabaseField
    private String golLocal;
    @DatabaseField
    private int idArbitro;
    @DatabaseField
    private String escudoVisita;
    @DatabaseField
    private String golVisita;
    @DatabaseField
    private String idLocal;
    @DatabaseField
    private String estadio;
    @DatabaseField
    private String idVisita;
    @DatabaseField
    private String estado;
    @DatabaseField
    private String escudoLocal;
    @DatabaseField
    private String nombreVisita;
    @DatabaseField
    private String nombreLocal;
    @DatabaseField
    private String fecha;

    public PartidoData(){}

    public PartidoData(int id_championship, String fecha, String nombreLocal, String nombreVisita, String escudoLocal, String estado, String idVisita, String estadio, String idLocal, String golVisita, String escudoVisita, int idArbitro, String golLocal, String nombreArbitro, int idEstado, String ciudad, String hora, int idPartido, String horaEstado) {
        this.setId_championship(id_championship);
        this.setFecha(fecha);
        this.setNombreLocal(nombreLocal);
        this.setNombreVisita(nombreVisita);
        this.setEscudoLocal(escudoLocal);
        this.setEstado(estado);
        this.setIdVisita(idVisita);
        this.setEstadio(estadio);
        this.setIdLocal(idLocal);
        this.setGolVisita(golVisita);
        this.setEscudoVisita(escudoVisita);
        this.setIdArbitro(idArbitro);
        this.setGolLocal(golLocal);
        this.setNombreArbitro(nombreArbitro);
        this.setIdEstado(idEstado);
        this.setCiudad(ciudad);
        this.setHora(hora);
        this.setIdPartido(idPartido);
        this.setHoraEstado(horaEstado);
    }


    public int get_id() { return _id; }

    public void set_id(int _id) { this._id = _id; }

    public int getId_championship() { return id_championship; }

    public void setId_championship(int id_championship) { this.id_championship = id_championship; }

    public String getHoraEstado() {
        return horaEstado;
    }

    public void setHoraEstado(String horaEstado) {
        this.horaEstado = horaEstado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public String getNombreVisita() {
        return nombreVisita;
    }

    public void setNombreVisita(String nombreVisita) {
        this.nombreVisita = nombreVisita;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(String idVisita) {
        this.idVisita = idVisita;
    }

    public String getEscudoLocal() {
        return escudoLocal;
    }

    public void setEscudoLocal(String escudoLocal) {
        this.escudoLocal = escudoLocal;
    }

    public String getGolVisita() {
        return golVisita;
    }

    public void setGolVisita(String golVisita) {
        this.golVisita = golVisita;
    }

    public String getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(String idLocal) {
        this.idLocal = idLocal;
    }

    public String getEscudoVisita() {
        return escudoVisita;
    }

    public void setEscudoVisita(String escudoVisita) {
        this.escudoVisita = escudoVisita;
    }

    public int getIdArbitro() {
        return idArbitro;
    }

    public void setIdArbitro(int idArbitro) {
        this.idArbitro = idArbitro;
    }

    public String getGolLocal() {
        return golLocal;
    }

    public void setGolLocal(String golLocal) {
        this.golLocal = golLocal;
    }

    public String getNombreArbitro() {
        return nombreArbitro;
    }

    public void setNombreArbitro(String nombreArbitro) {
        this.nombreArbitro = nombreArbitro;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }
}
