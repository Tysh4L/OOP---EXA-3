package expractoop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentManagementSystem {
    private List<Estudiante> estudiantes;

    public StudentManagementSystem() {
        this.estudiantes = new ArrayList<>();
    }

    public void addStudent(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public Optional<Estudiante> getStudent(int rollNumber) {
        return estudiantes.stream()
                .filter(estudiante -> estudiante.getNumeroLista() == rollNumber)
                .findFirst();
    }

    public void storeData(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(estudiantes);
            System.out.println("Datos de estudiantes almacenados en el archivo: " + filename);
        } catch (IOException e) {
            System.out.println("Error al almacenar los datos de estudiantes en el archivo: " + filename);
            e.printStackTrace();
        }
    }

    public void loadData(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            estudiantes = (List<Estudiante>) ois.readObject();
            System.out.println("Datos de estudiantes cargados desde el archivo: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos de estudiantes desde el archivo: " + filename);
            e.printStackTrace();
        }
    }
}
