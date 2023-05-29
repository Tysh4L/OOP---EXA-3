package exprejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void addProduct(Producto producto) {
        if (productos.size() < 10) {
            productos.add(producto);
            System.out.println("Producto agregado al inventario.");
        } else {
            System.out.println("El inventario está lleno. No se puede agregar más productos.");
        }
    }

    public void removeProduct(int productId) {
        Producto producto = searchProduct(productId);
        if (producto != null) {
            productos.remove(producto);
            System.out.println("\n");
            System.out.println("El producto fue eliminado del inventario.");
        } else {
            System.out.println("No se encontró ningún producto con el ID especificado.");
        }
    }

    public Producto searchProduct(int productId) {
        for (Producto producto : productos) {
            if (producto.getId() == productId) {
                return producto;
            }
        }
        return null;
    }

    public void displayInventory() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("\n");
            System.out.println("Inventario:");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
