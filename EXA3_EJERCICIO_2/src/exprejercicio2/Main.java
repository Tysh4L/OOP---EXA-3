package exprejercicio2;
public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        Producto producto1 = new Producto(1, "Camiseta Polo", 399.99, 3);
        Producto producto2 = new Producto(2, "Pantalón de vestir", 599.99, 2);
        Producto producto3 = new Producto(3, "Corbata", 259.99, 1);
        Producto producto4 = new Producto(4, "Saco de vestir", 799.99, 1);
        Producto producto5 = new Producto(5, "Zapatos", 259.99, 4);
        
        inventario.addProduct(producto1);
        inventario.addProduct(producto2);
        inventario.addProduct(producto3);
        inventario.addProduct(producto4);
        inventario.addProduct(producto5);

        inventario.displayInventory();

        inventario.removeProduct(4);
        inventario.displayInventory();

        Producto searchResult = inventario.searchProduct(1);
        if (searchResult != null) {
            System.out.println("\n");
            System.out.println("Producto encontrado: " + searchResult.getNombre());
        } else {
            System.out.println("Producto no encontrado.");
        }

        String filename = "inventario.txt";
        FileManager.saveToFile(filename, inventario.getProductos());

        Inventario loadedInventario = FileManager.loadFromFile(filename);
        loadedInventario.displayInventory();
    }
}
