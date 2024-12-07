import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventario.cargarProductos("D:\\Proyectos_BanBta\\Gestion_inventario\\Data\\productos.txt");
        int x = 0;
        do {
            Menu.menuPpal();
            System.out.println("ingresa la opcion que deseas: ");
            Scanner sc = new Scanner(System.in);
            try {
                x = sc.nextInt();
                switch (x) {
                    case 1:
                        // Agregar producto
                        Inventario.agregarProducto();
                        break;
                    case 2:
                        // Actualizar producto
                        Inventario.actualizarProducto();
                        break;
                    case 3:
                        // Eliminar producto
                        Inventario.eliminarProducto();
                        break;
                    case 4:
                        // Buscar producto
                        Menu.menuBuscar();
                        int y;
                        do {
                            System.out.println("ingresa la opcion que deseas: ");
                            Scanner sb = new Scanner(System.in);
                            y = sb.nextInt();

                            switch (y) {
                                case 1:
                                    // Buscar por ID
                                    Inventario.buscarProductoID();
                                    Menu.menuBuscar();
                                    break;
                                case 2:
                                    // Buscar por categoría
                                    Inventario.buscarProductoCategoria();
                                    Menu.menuBuscar();
                                    break;
                                case 3:
                                    // Buscar por nombre
                                    Inventario.buscarProductoNombre();
                                    Menu.menuBuscar();
                                    break;
                                default:
                                    System.out.println("Opcion no valida");
                                    break;
                            }
                        } while (y != 4);
                        break;
                    case 5:
                        // Generar reporte
                        Inventario.generarReporte();
                        break;
                    case 6:
                        // Cantidad de productos por categoría
                        Inventario.cantidadProductosPorCategoria();
                        break;
                    case 7:
                        // producto mas caro
                        Inventario.productoMasCaro();
                        break;
                    case 8:
                        //salir
                        System.out.println("¡¡¡¡¡¡¡Nos vemos lokas!!!!!!");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Opcion no valida");
            }
        } while (x != 8);
    }
}