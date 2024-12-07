import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Inventario {
    public static ArrayList<Producto> productos= new ArrayList<>();
    public static void cargarProductos(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                Producto producto = new Producto(
                        parseInt(datos[0]),
                        datos[1],
                        datos[2],
                        Double.parseDouble(datos[3]),
                        parseInt(datos[4])
                );
                productos.add(producto);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar productos: " + e.getMessage());
        }
    }
    public static void agregarProducto() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingresa el nombre del producto:");
            String nombreProducto = scanner.nextLine();
            System.out.println("Ingresa la categoría del producto:");
            String categoria = scanner.nextLine();
            System.out.println("Ingresa el precio del producto:");
            double precio = scanner.nextDouble();
            System.out.println("Ingresa la cantidad disponible del producto:");
            int cantidadDisponible = scanner.nextInt();
            System.out.println("Ingresa el ID del producto:");
            int idProducto = scanner.nextInt();
            String rutaArchivo = "D:\\\\Proyectos_BanBta\\\\Gestion_inventario\\\\Data\\productos.txt";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
                bw.write(idProducto + ";" + nombreProducto + ";" + categoria + ";" + precio + ";" + cantidadDisponible + "\n");
                System.out.println("Producto agregado correctamente."+"\n");
            } catch (IOException e) {
                System.out.println("Error al agregar el producto: " + e.getMessage());
            }
        }catch (Exception e) {
            System.out.println("Error al agregar el producto, por favor ingresa los datos correctamente."+"\n");
        }
    }
    public static void actualizarProducto() {
        Scanner scanner = new Scanner(System.in);
        try {
        System.out.println("Ingresa el nombre del producto a modificar:");
        String nombreProducto = scanner.nextLine();
        int i=0;
        while (i<productos.size()) {
            if (Objects.equals(productos.get(i).getNombreProducto(), nombreProducto)) {
                System.out.println("Ingresa el nuevo nombre del producto:");
                String nuevoNombre = scanner.nextLine();
                System.out.println("Ingresa la nueva categoría del producto:");
                String nuevaCategoria = scanner.nextLine();
                System.out.println("Ingresa el nuevo precio del producto:");
                double nuevoPrecio = scanner.nextDouble();
                System.out.println("Ingresa la nueva cantidad disponible del producto:");
                int nuevaCantidadDisponible = scanner.nextInt();
                Producto producto = productos.get(i);
                producto.setNombreProducto(nuevoNombre);
                producto.setCategoria(nuevaCategoria);
                producto.setPrecio(nuevoPrecio);
                producto.setCantidadDisponible(nuevaCantidadDisponible);
                System.out.println("Producto actualizado correctamente." + "\n");
                return;
            }
            i++;
        }System.out.println("Producto no encontrado."+"\n");
        }catch (Exception e) {
            System.out.println("Error al actualizar el producto, por favor ingresa los datos correctamente."+"\n");
    }
    }

    public static void eliminarProducto() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingresa el ID del producto a eliminar:");
            int idProducto = scanner.nextInt();
            int i = 0;
            while (i < productos.size()) {
                if (Objects.equals(productos.get(i).getIdProducto(), idProducto)) {
                    productos.remove(i);
                    System.out.println("Producto eliminado correctamente." + "\n");
                    return;
                }
                i++;
            }System.out.println("Producto no encontrado."+"\n");
        } catch (Exception e) {
            System.out.println("Error al eliminar el producto, por favor ingresa los datos correctamente."+"\n");
        }
    }
    public static void buscarProductoID() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingresa el ID del producto a buscar:");
            int idProducto = scanner.nextInt();
            int i = 0;
            while (i < productos.size()) {
                if (Objects.equals(productos.get(i).getIdProducto(), idProducto)) {
                    System.out.println("ID: " + productos.get(i).getIdProducto());
                    System.out.println("Nombre: " + productos.get(i).getNombreProducto());
                    System.out.println("Categoría: " + productos.get(i).getCategoria());
                    System.out.println("Precio: " + productos.get(i).getPrecio());
                    System.out.println("Cantidad: " + productos.get(i).getCantidadDisponible());
                    return;
                }
                i++;
            }System.out.println("Producto no encontrado."+"\n");
        }catch (Exception e) {
            System.out.println("Error al buscar el producto, por favor ingresa los datos correctamente."+"\n");
        }
    }
    public static void buscarProductoCategoria() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la categoría del producto a buscar:");
        String categoria = scanner.nextLine();
        for (int j = 0; j < productos.size(); j++) {
            if (Objects.equals(productos.get(j).getCategoria(), categoria)) {
                System.out.println("ID: " + productos.get(j).getIdProducto());
                System.out.println("Nombre: " + productos.get(j).getNombreProducto());
                System.out.println("Categoría: " + productos.get(j).getCategoria());
                System.out.println("Precio: " + productos.get(j).getPrecio());
                System.out.println("Cantidad: " + productos.get(j).getCantidadDisponible());
            }
        }
    }
        public static void buscarProductoNombre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nombre del producto a buscar:");
        String nombre = scanner.nextLine();
        int i=0;
        while (i<productos.size()) {
            if (Objects.equals(productos.get(i).getNombreProducto(), nombre)) {
                System.out.println("ID: " + productos.get(i).getIdProducto());
                System.out.println("Nombre: " + productos.get(i).getNombreProducto());
                System.out.println("Categoría: " + productos.get(i).getCategoria());
                System.out.println("Precio: " + productos.get(i).getPrecio());
                System.out.println("Cantidad: " + productos.get(i).getCantidadDisponible());
                return;
            }
            i++;
        }
            System.out.println("Producto no encontrado."+"\n");
    }
        public static void generarReporte() {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\\\Proyectos_BanBta\\\\Gestion_inventario\\\\Data\\reporte_inventario.txt"))) {
                double valorTotalInventario = 0;
                bw.write("Reporte de Inventario\n");
                bw.write("Jorge Enrique Calderon Rocha\n");
                bw.write("Fecha: " + LocalDate.now() + "\n");
                bw.write("Hora: " + LocalTime.now() + "\n");
                for (Producto p : productos) {
                    double valorProducto = p.getPrecio() * p.getCantidadDisponible();
                    valorTotalInventario += valorProducto;
                    bw.write(String.format("ID: %d; Nombre: %s; Categoría: %s; Precio: %.2f; Cantidad: %d; Valor: %.2f%n",
                            p.getIdProducto(), p.getNombreProducto(), p.getCategoria(), p.getPrecio(), p.getCantidadDisponible(), valorProducto));
                }
                bw.write("Valor total del inventario: " + valorTotalInventario);
                bw.write("Fin del reporte\n");
                System.out.println("Reporte generado correctamente."+"\n");
            } catch (IOException e) {
                System.out.println("Error al generar el reporte: " + e.getMessage());
            }
        }

        public static void cantidadProductosPorCategoria() {
            Map<String, Integer> cantidadPorCategoria = new HashMap<>();
            for (Producto p : productos) {
                String categoria = p.getCategoria();
                cantidadPorCategoria.put(categoria, cantidadPorCategoria.getOrDefault(categoria, 0) + 1);
            }
            for (Map.Entry<String, Integer> entry : cantidadPorCategoria.entrySet()) {
                System.out.println("Categoría: " + entry.getKey() + ", Cantidad: " + entry.getValue());
            }
            System.out.println("Informacion generada correctamente."+"\n");
        }
        public static void productoMasCaro() {
            Producto productoMasCaro = null;
            double precioMasCaro = 0;
            for (Producto p : productos) {
                if (p.getPrecio() > precioMasCaro) {
                    productoMasCaro = p;
                    precioMasCaro = p.getPrecio();
                }
            }
            System.out.println("Producto mas caro:");
            System.out.println("ID: " + productoMasCaro.getIdProducto());
            System.out.println("Nombre: " + productoMasCaro.getNombreProducto());
            System.out.println("Categoría: " + productoMasCaro.getCategoria());
            System.out.println("Precio: " + productoMasCaro.getPrecio());
            System.out.println("Cantidad: " + productoMasCaro.getCantidadDisponible()+"\n");

            System.out.println("Informacion generada correctamente."+"\n");
        }
}