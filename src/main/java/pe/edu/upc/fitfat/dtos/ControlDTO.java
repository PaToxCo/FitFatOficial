package pe.edu.upc.fitfat.dtos;

import java.math.BigDecimal;
import java.sql.Date;

public class ControlDTO {
    private int idControl;
    private BigDecimal peso;
    private BigDecimal talla;
    private int edad;
    private String genero;
    private int dietaIdDieta;
    private int usuarioId;
    private Date fecha;


    public int getIdControl() {
        return idControl;
    }

    public void setIdControl(int idControl) {
        this.idControl = idControl;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getTalla() {
        return talla;
    }

    public void setTalla(BigDecimal talla) {
        this.talla = talla;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDietaIdDieta() {
        return dietaIdDieta;
    }

    public void setDietaIdDieta(int dietaIdDieta) {
        this.dietaIdDieta = dietaIdDieta;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
