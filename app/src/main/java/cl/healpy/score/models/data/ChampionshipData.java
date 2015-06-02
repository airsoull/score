package cl.healpy.score.models.data;


import com.j256.ormlite.field.DatabaseField;

public class ChampionshipData {

    @DatabaseField(generatedId = true)
    private int _id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String desde;
    @DatabaseField
    private String temporada;
    @DatabaseField
    private String hasta;
    @DatabaseField
    private String version;
    @DatabaseField
    private int id;
    @DatabaseField
    private String dia;

    public ChampionshipData(String name, String desde, String temporada, String hasta, String version, int id, String dia, String fecha) {
        this.setName(name);
        this.setDesde(desde);
        this.setTemporada(temporada);
        this.setHasta(hasta);
        this.setVersion(version);
        this.setId(id);
        this.setDia(dia);
        this.setFecha(fecha);
    }

    @DatabaseField
    private String fecha;

    public ChampionshipData(){}

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
