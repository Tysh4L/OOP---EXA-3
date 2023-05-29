package exprejercicio2;

import java.io.*;
import java.util.List;

public class FileManager {
    public static void saveToFile(String filename, List<Producto> productos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Producto producto : productos) {
                writer.write(producto.getId() + "," + producto.getNombre() + "," + producto.getPrecio() + "," + producto.getCantidad());
                writer.newLine();
            }
            System.out.println("Informacion del inventario guardado en el archivo: " + filename);
        } catch (IOException e) {
            System.out.println("Error al guardar el inventario.");
        }
    }

    public static Inventario loadFromFile(String filename) {
        Inventario inventario = new Inventario();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0]);
                    String nombre = data[1];
                    double precio = Double.parseDouble(data[2]);
                    int cantidad = Integer.parseInt(data[3]);
                    Producto producto = new Producto(id, nombre, precio, cantidad);
                    inventario.addProduct(producto);
                }
            }
            System.out.println("Informacion del inventario cargado del archivo: " + filename);
        } catch (IOException e) {
            System.out.println("Error al cargar el inventario desde el archivo.");
        }
        return inventario;
    }
}
