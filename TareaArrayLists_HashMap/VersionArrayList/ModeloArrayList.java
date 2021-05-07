package TercerTrimestre.TareaArrayLists_HashMap.VersionArrayList;

/**
 * Implementa la parte de Modelo de Datow
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ModeloArrayList extends ModeloAbs {
	private ArrayList<Producto> lista;

	public ModeloArrayList() {
		lista = new ArrayList<Producto>();
	}

	// Implementar los metodos abstractos de ModeloAbs
	@Override
	public boolean insertarProducto(Producto p) {
		// return lista.add(p);
		boolean agregado = false;

		if (lista.contains(p)) {
			System.out.println("  El Codigo de producto ya existe");
		} else {
			if (p.stock <= 0 || p.precio <= 0) {
				System.out.println("  El Stock y el Precio no pueden Ser Negativo o Cero");
			} else {
				lista.add(p);
				System.out.println("  El Producto fue Agregado con Existo");
				agregado = true;
			}
		}
		return agregado;
	}

	public boolean borrarProducto(int codigo) {
		boolean sepuedeBorrar = false;

		Iterator<Producto> it = lista.iterator();
		while (it.hasNext()) {
			if (it.next().getCodigo() == codigo) {
				sepuedeBorrar = true;
				it.remove();
				System.out.println("Borrado con exito");
			}
		}
//		if (!lista.isEmpty()) {
//			for (int i = 0; i < lista.size(); i++) {
//				Producto p = lista.get(i);
//				if (p.getCodigo() == codigo) {
//					sepuedeBorrar = true;
//					lista.remove(i);
//				}
//			}
//		}
		return sepuedeBorrar;
	}

	public Producto buscarProducto(int codigo) {

		boolean encontrado = false;
		Producto encontra = null;

		for (int i = 0; i < lista.size(); i++) {
			Producto p = lista.get(i);
			if (p.getCodigo() == codigo) {
				encontrado = true;
				encontra = p;
				break; // Terminar ciclo, pues ya lo encontramos
			}
		}
		// Al terminar el ciclo comprobamos
		if (encontrado) {
			System.out.println("\t\t   ----------------------------");
			System.out.println("\t\t   >>> DETALLE DEL PRODUCTO <<<");
			System.out.println("\t\t   ----------------------------");
		}
		return encontra;
	}

	public void listarProductosTodos() {
		for (int i = 0; i < lista.size(); i++)
			System.out.println(lista.get(i));
	}

	public void listarProductosStockMin() {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).stock < lista.get(i).stock_min) {
				System.out.println(lista.get(i).toString());
			}
		}
	}

	@SuppressWarnings("resource")
	public boolean modificarProducto(Producto nuevo) {
		boolean modificado = false;
		Scanner aux = new Scanner(System.in);

		if (lista.contains(nuevo)) {
			System.out.print(" Ingrese el nuevo Precio: ");
			float pre = aux.nextFloat();
			if (nuevo.precio > 0 && pre != 0) {
				nuevo.setPrecio(pre);
				modificado = true;
				System.out.println(" El Precio fue cambiado con exito");
			} else {
				System.out.println(" El precio a modificar no puede ser " + pre + " o menor");
			}
		}

		return modificado;
	}

}
