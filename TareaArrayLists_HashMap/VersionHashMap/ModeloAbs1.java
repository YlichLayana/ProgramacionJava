package TercerTrimestre.TareaArrayLists_HashMap.VersionHashMap;

/**
 * Abstract class ModeloAbs - Clase de acceso a Modelo de DATOS
 * 
 * @author: 
 */
public abstract class ModeloAbs1 {
	public ModeloAbs1() {
	}

	abstract public boolean insertarProducto(Producto1 p);

	abstract boolean borrarProducto(int codigo);

	abstract public Producto1 buscarProducto(int codigo);

	abstract void listarProductosTodos();

	abstract void listarProductosStockMin();

	abstract boolean modificarProducto(Producto1 nuevo);

}
