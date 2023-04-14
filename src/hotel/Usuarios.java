package hotel;

import java.util.LinkedList;

public class Usuarios {
    // Se crean los valores
    private int codigo;
    private String nombre;
    private String apellido;
    private int telefono;
    private String direccion;
    private String correo;
    private String dob;
    private String pass;
    private int role;
    
    // Se crea el constructor
    public Usuarios(int codigo, String nombre, String apellido, int telefono, String direccion, 
            String correo, String dob, String pass, int role) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.dob = dob;
        this.pass = pass;
        this.role = role;

    }

    public Usuarios(String nombre, String apellido, int telefono, String direccion, String correo, 
            String dob, String pass) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.dob = dob;
        this.pass = pass;
    }

    //Usuarios(String text, String text0, String text1, String text2, String text3, String text4, String text5) {
         
        
    //}   
    

    // Acceder y modificar el código. 
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int isRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    LinkedList<Usuarios> lista = new LinkedList<Usuarios>();
    
    
    
}
