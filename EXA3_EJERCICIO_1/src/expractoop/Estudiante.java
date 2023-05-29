package expractoop;

import java.io.Serializable;

public class Estudiante implements Serializable {
    private String nombre;
    private int numeroLista;
    private String grado;

    public Estudiante(String nombre, int numeroLista, String grado) {
        this.nombre = nombre;
        this.numeroLista = numeroLista;
        this.grado = grado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroLista() {
        return numeroLista;
    }

    public void setNumeroLista(int numeroLista) {
        this.numeroLista = numeroLista;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    @Override
    public String toString() {
        return 
                "nombre: '" + nombre + '\'' +
                "\nnumero de lista: " + numeroLista +
                "\ngrado: " + grado;
    }
}
