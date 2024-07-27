package mx.edu.utez.inte.model;

import java.io.Serializable;

//Debe de implemntar las convenciones de Java Bean
public class Usuario implements Serializable {
    //Debe de representar exactamente la estructura de la
    //tabla de la base de datos

    private int id_usuario;
    private String nombre;
    private String apellidos;
    private String correo;
    private String contra;
    private int telefono;
    private String curp;
    private int estatus;
    private String codigo;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre, String apellidos, String correo, String contra, int telefono, String curp, int estatus, String codigo) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contra = contra;
        this.telefono = telefono;
        this.curp = curp;
        this.estatus = estatus;
        this.codigo = codigo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {this.contra = contra;}

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getCodigoRecuperacion() { return codigo;}

    public void setCodigoRecuperacion(String codigo) { this.codigo = codigo;
    }
}
