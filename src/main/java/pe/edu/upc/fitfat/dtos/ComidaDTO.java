package pe.edu.upc.fitfat.dtos;

public class ComidaDTO {
    private int idComida;
    private String nombre;
    private Integer calorias;
    private Integer proteinas;
    private Integer carbohidratos;
    private Integer grasas;
    private String descripcion;
    private Boolean comiFavo;
    private int usuarioId;
    private int tipoComidaId;

    // Getters and Setters
    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    public Integer getProteinas() {
        return proteinas;
    }

    public void setProteinas(Integer proteinas) {
        this.proteinas = proteinas;
    }

    public Integer getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(Integer carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public Integer getGrasas() {
        return grasas;
    }

    public void setGrasas(Integer grasas) {
        this.grasas = grasas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getComiFavo() {
        return comiFavo;
    }

    public void setComiFavo(Boolean comiFavo) {
        this.comiFavo = comiFavo;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getTipoComidaId() {
        return tipoComidaId;
    }

    public void setTipoComidaId(int tipoComidaId) {
        this.tipoComidaId = tipoComidaId;
    }
}
