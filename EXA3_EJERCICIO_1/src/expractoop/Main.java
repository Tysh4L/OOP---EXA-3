package expractoop;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        
        //Creamos un listado de nuestros estudiantes que se almacenara en
        //estudiantes.dat

        system.addStudent(new Estudiante("Jose Gerardo", 1, "4to Grado"));
        system.addStudent(new Estudiante("Rodolfo Sandoval", 2, "2do Grado"));
        system.addStudent(new Estudiante("Gregory Hills", 3, "9no Grado"));
        system.addStudent(new Estudiante("Abdul", 4, "1er Grado"));
        system.addStudent(new Estudiante("Diego Vazquez", 5, "Grado 1337"));

        system.storeData("estudiantes.dat");

        system = new StudentManagementSystem();
        system.loadData("estudiantes.dat");
        
        //Usamos Retrive, el numero que se le asigna sera el cual sacara del listado en
        //estudiantes.dat, en este caso, recuperamos el numero 2 que esta asignado a 
        //rodolfo sandoval
        
        int rollNumberToRetrieve = 1;
        Optional<Estudiante> estudianteRecuperado = system.getStudent(rollNumberToRetrieve);
        estudianteRecuperado.ifPresentOrElse(
                estudiante -> {
                    System.out.println("\n");
                    System.out.println("Información del estudiante:");
                    System.out.println("\n");
                    System.out.println(estudiante);
                },
                () -> System.out.println("No se encontró el estudiante con el número de lista: " + rollNumberToRetrieve)
        );
    }
}