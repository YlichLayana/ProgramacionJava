package TercerTrimestre.TareaArrayLists_HashMap.VersionHashMap;

import java.util.Scanner;

// Crear la clase Producto y completar los métodos

public class MiAlmacen1 {
	// Defino como estaticas para que puedan usarse
	// dentro de la clase sin necesidad de pasarlas como
	// parametros.
	static private ModeloAbs1 almacen;
	static private Scanner sc;

	public static void main(String[] args) {
		almacen = new ModeloHashMap();

		sc = new Scanner(System.in);
		int opcion = 0;
		do {
			System.out.println(">>>>>>>>HashMap<<<<<<<<<<");
			mostrarMenu();
			opcion = leerOpcion(1, 9);
			switch (opcion) {
			case 1:
				crear();
				break;
			case 2:
				consultar();
				break;
			case 3:
				borrar();
				break;
			case 4:
				modificarPrecio();
				break;
			case 5:
				comprar();
				break;
			case 6:
				vender();
				break;
			case 7:
				listar();
				break;
			case 8:
				listarPocoStock();
				break;
			}
			System.out.println("\n---------------------------- ");
			System.out.print("Pulse enter para continuar");
			sc.nextLine();
		} while (opcion != 9);
		sc.close();

	}

	private static void mostrarMenu() {
		System.out.println("\n    MENU");
		System.out.println("1. Nuevo producto ");
		System.out.println("2. Consulta producto ");
		System.out.println("3. Borrar producto ");
		System.out.println("4. Modificar precio ");
		System.out.println("5. Compra de productos ");
		System.out.println("6. Venta de productos ");
		System.out.println("7. Listado completo de productos ");
		System.out.println("8. Listado de productos con stock inferior al mínimo");
		System.out.println("9. Terminar ");
		System.out.print("Elige una opción (1-9): ");
	}

	// Lee un entero del System.in que este comprendido entre primero y ultimo
	private static int leerOpcion(int primero, int ultimo) {
		int valor = leerEntero();
		while (valor < primero || valor > ultimo) {
			valor = leerEntero();
		}
		return valor;
	}

	// Metodos Auxiliares leerFloat y LeerEntero,
	// Lee de la System.in con el scanner sc y controlan la excepcion de
	// NumberFormatException

	static private int leerEntero() {
		boolean error = false;
		int valor = 0;
		String cadena;
		do {
			error = false;
			try {
				// Intento leer directamente un entero
				cadena = sc.nextLine();
				valor = Integer.parseInt(cadena);

			} catch (NumberFormatException e) {
				System.out.println("Error en formato.");
				error = true;
			}
		} while (error);
		return valor;
	}

	static private float leerFloat() {
		boolean error = false;
		float valor = 0;
		String cadena;
		do {
			error = false;
			try {
				// Intento leer directamente un entero
				cadena = sc.nextLine();
				valor = Float.parseFloat(cadena);

			} catch (NumberFormatException e) {
				System.out.println("Error en formato.");
				error = true;
			}
		} while (error);
		return valor;
	}

	// Muestra los datos de un producto a partir de su codigo

	private static void consultar() {
		System.out.println("\n<CONSULTA>");
		System.out.print(" Introduzca codigo:");
		int codigo = leerEntero();
		Producto1 p = almacen.buscarProducto(codigo);
		if (p == null) {
			System.out.println(" El producto no se encuentra en almacen");
		} else {
			System.out.println("\t | CODIGO| NOMBRE\t\t | STOCK | STOCK-MINI | PRECIO \t   |");
			System.out.println("PRODUCTO " + p);
		}

	}

	// Borrar un producto a partir de su codigo

	private static void borrar() {
		System.out.println("\n<ELIMINAR>");
		// System.out.println("Aún no disponible");
		// IMPLEMENTAR
		System.out.print(" Introduzca codigo:");
		int codigo = leerEntero();
		Producto1 p = almacen.buscarProducto(codigo);
		if (p == null) {
			System.out.println("El producto no se encuentra en almacen");
		} else {
			System.out.println("\t | CODIGO| NOMBRE\t\t | STOCK | STOCK-MINI | PRECIO \t   |");
			System.out.println("PRODUCTO " + p);
			almacen.borrarProducto(codigo);
		}
	}

	// Cambia el precio de un producto a partir de su codigo
	private static void modificarPrecio() {
		System.out.println("\n<MODIFICAR PRECIO>");
		System.out.print(" Introduzca codigo del producto a modificar:");
		int cod = leerEntero();
		Producto1 p = almacen.buscarProducto(cod);
		if (p == null) {
			System.out.println(" El producto no se encuentra en almacen");
		} else {
			System.out.println("\t | CODIGO| NOMBRE\t\t | STOCK | STOCK-MINI | PRECIO \t   |");
			System.out.println("PRODUCTO " + p);
			almacen.modificarProducto(p);
		}
	}

	// Incrementa el stock
	private static void comprar() {
		System.out.println("<COMPRAR>");
		System.out.print(" Introduzca codigo del producto que va a Comprar:");
		int cod = leerEntero();
		Producto1 p = almacen.buscarProducto(cod);
		if (p == null) {
			System.out.println(" El Producto no se encuentra en Almacen");
		} else {
			System.out.println("\t | CODIGO| NOMBRE\t\t | STOCK | STOCK-MINI | PRECIO \t   |");
			System.out.println("PRODUCTO " + p);
			System.out.print(" Ingrese la cantidad de producto comprado: ");
			int cantidad = leerEntero();
			int stockNuevo = p.getStock() + cantidad;
			p.setStock(stockNuevo);

		}
		// IMPLEMENTAR
	}

	// Decrementa el stock
	private static void vender() {
		System.out.println("<VENDER>");
		System.out.print(" Introduzca Codigo del Producto a Vender:");
		int cod = leerEntero();
		Producto1 p = almacen.buscarProducto(cod);
		if (p == null) {
			System.out.println(" El Producto no se encuentra en Almacen");
		} else {
			System.out.println("\t | CODIGO| NOMBRE\t\t | STOCK | STOCK-MINI | PRECIO \t   |");
			System.out.println("PRODUCTO " + p);
			System.out.print(" Ingrese la Cantidad de Producto a Vender: ");
			int cantidad = sc.nextInt();
			if (cantidad > 0 && cantidad < p.getStock()) {
				int stockNuevo = p.getStock() - cantidad;
				p.setStock(stockNuevo);
			} else {
				System.out.println(" La cantidad de producto a vender no puede ser cero o mayor al Stock");

			}
		}
	}

	// Listado de todos los productos
	private static void listar() {
		System.out.println("\n<LISTAR>");
		System.out.println("| CODIGO| NOMBRE\t\t| STOCK | STOCK-MINI | PRECIO \t  |");
		almacen.listarProductosTodos();
	}

	// Listado de todos los productos con stock inferior a stock minimo
	private static void listarPocoStock() {
		System.out.println("\n<LISTAR STOCK BAJO MINIMOS>");
		System.out.println("| CODIGO| NOMBRE\t\t| STOCK | STOCK-MINI | PRECIO \t  |");
		almacen.listarProductosStockMin();
	}

	// Solicita datos al usuario para dar de alta un nuevo producto
	// El codigo no se puede repetir
	private static void crear() {
		@SuppressWarnings("unused")
		Producto1 prod;
		System.out.println("\n<NUEVO PRODUCTO>");
		System.out.print("    INGRESE DATOS DEL PRODUCTO\n");
		System.out.print(" >>Codido: ");
		int cod = leerEntero();
		System.out.print(" >>Nombre: ");
		String name = sc.nextLine();
		System.out.print(" >>Stock: ");
		int stock = leerEntero();
		System.out.print(" >>Stock Mini: ");
		int stockMin = leerEntero();
		System.out.print(" >>Precio: ");
		float precio = leerFloat();

		almacen.insertarProducto(prod = new Producto1(cod, name, stock, stockMin, precio));
	}

}
