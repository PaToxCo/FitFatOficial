package pe.edu.upc.fitfat.dtos;

public class RecetaDTO {
    private int idReceta;
    private String nombre;
    private String descripcion;
    private String instrucciones;
    private int comidaIdComida;

    // Getters and Setters

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public int getComidaIdComida() {
        return comidaIdComida;
    }

    public void setComidaIdComida(int comidaIdComida) {
        this.comidaIdComida = comidaIdComida;
    }
}
