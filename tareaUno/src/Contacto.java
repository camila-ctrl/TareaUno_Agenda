
public class Contacto {
    public String nombre;
    public String telefono;
    public String mail;


    public Contacto(String nombre, String telefono, String mail) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public void printContact() {
        System.out.println("• Nombre: " + this.getNombre());
        System.out.println("• Telefono: " + this.getTelefono());
        System.out.println("• Email: " + this.getMail());

    }
}

