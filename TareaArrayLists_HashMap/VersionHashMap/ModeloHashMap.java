package TercerTrimestre.TareaArrayLists_HashMap.VersionHashMap;

/**
 * Write a description of class ModeloHaspMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ModeloHashMap extends ModeloAbs1 {
	private HashMap<Integer, Producto1> lista;

	public ModeloHashMap() {
		lista = new HashMap<Integer, Producto1>();
	}

	/**
	 * Metodo Insertar producto con condicion de que no deben tener el mismo codido
	 * y su cantidad agregada y eñ precio no deben ser cero
	 */
	public boolean insertarProducto(Producto1 p) {

		boolean agregado = false;

		if (lista.containsValue(p)) {
			System.out.println("  El Codigo de producto ya existe");
		} else {
			if (p.stock <= 0 || p.precio <= 0) {
				System.out.println("  El Stock y el Precio no pueden Ser Negativo o Cero");
			} else {
				lista.put(p.codigo, p);
				System.out.println("  El Producto fue Agregado con Existo");
				agregado = true;
			}
		}
		return agregado;
	}

	/**
	 * Metodo Para Borrar un producto usando
	 */
	public boolean borrarProducto(int codigo) {
		boolean sepuedeBorrar = false;
		Iterator<Integer> it = lista.keySet().iterator();
		while (it.hasNext()) {
			int clave = it.next();
			Producto1 pr = lista.get(clave);
			if (pr.getCodigo() == codigo) {
				sepuedeBorrar = true;
				it.remove();
				System.out.println("Borrado con exito");
			}
		}
		return sepuedeBorrar;
	}

	/**
	 * 
	 */
	public Producto1 buscarProducto(int codigo) {

		boolean encontrado = false;
		Producto1 encontra = null;

		Iterator<Integer> it = lista.keySet().iterator();
		while (it.hasNext()) {
			int clave = it.next();
			Producto1 pr = lista.get(clave);
			if (pr.getCodigo() == codigo) {
				encontrado = true;
				encontra = pr;
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

	/**
	 * el medoto listar producto podemos realizarlo con set o un iterador los cuales
	 * trabajan con el keyset. Este método lo utilizamos para devolver una vista de
	 * conjunto de las claves contenidas en este mapa.
	 */
	public void listarProductosTodos() {
//		Set<Integer> prod = lista.keySet();
//		for (Integer cod : prod) {
//			Producto1 pr = lista.get(cod);
//			System.out.println(pr.toString());
//		}
//		
		Iterator<Integer> it = lista.keySet().iterator();
		while (it.hasNext()) {
			int clave = it.next();
			Producto1 pr = lista.get(clave);
			System.out.println(pr.toString());
		}
	}

	public void listarProductosStockMin() {

		Set<Integer> prod = lista.keySet();
		for (Integer cod : prod) {
			Producto1 pr = lista.get(cod);
			if (pr.getStock() < pr.getStock_min()) {
				System.out.println(pr.toString());
			}
		}
	}

	public boolean modificarProducto(Producto1 nuevo) {
		boolean modificado = false;
		@SuppressWarnings("resource")
		Scanner aux = new Scanner(System.in);

		if (lista.containsKey(nuevo.codigo)) {
			System.out.print(" Ingrese el nuevo Precio: ");
			float pre = aux.nextFloat();
			if (nuevo.getPrecio() > 0 && pre != 0) {
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
