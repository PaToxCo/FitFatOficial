package pe.edu.upc.fitfat.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "correo", nullable = false, length = 255)
    private String correo;

    @Column(name = "contrasena", nullable = false, length = 255)
    private String contrasena;

    @Column(name = "token", length = 255)
    private String token;

    @Column(name = "nombre", length = 255)
    private String nombre;

    @Column(name = "apellidos", length = 255)
    private String apellidos;

    @Column(name = "usuario", length = 255)
    private String usuario;

    @Column(name = "contrasena2", length = 255)
    private String contrasena2;

    @Column(name = "celular")
    private Integer celular;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;

    public Usuarios() {}

    public Usuarios(int id, String correo, String contrasena, String token, String nombre, String apellidos, String usuario, String contrasena2, Integer celular, String direccion, Rol rol) {
        this.idUsuario = id;
        this.correo = correo;
        this.contrasena = contrasena;
        this.token = token;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contrasena2 = contrasena2;
        this.celular = celular;
        this.direccion = direccion;
        this.rol = rol;
    }

    public int getId() {
        return idUsuario;
    }

    public void setId(int id) {
        this.idUsuario = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena2() {
        return contrasena2;
    }

    public void setContrasena2(String contrasena2) {
        this.contrasena2 = contrasena2;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
