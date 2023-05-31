package entidades;

public class Tipo {
    int Id;
    String Nombre;

    public Tipo(int id, String nombre) {
        this.Id = id;
        Nombre = nombre;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
