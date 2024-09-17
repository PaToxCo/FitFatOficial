package pe.edu.upc.fitfat.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Mensaje")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMensaje;

    @Column(name = "asunto", nullable = false, length = 25)
    private String asunto;

    @Column(name = "descripcion", nullable = false, length = 15)
    private String descripcion;

    public Mensaje() {}

    public Mensaje(int idMensaje, String asunto, String descripcion) {
        this.idMensaje = idMensaje;
        this.asunto = asunto;
        this.descripcion = descripcion;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
