package TercerTrimestre.TareaArrayLists_HashMap.VersionHashMap;

/**
 * Write a description of class Producto here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Producto1 {
	// instance variables - replace the example below with your own
	int codigo; // C�digo del producto, se utiliza para buscar
	String nombre; // Nombre un texto
	int stock; // existencia actuales
	int stock_min; // N�mero m�nimo de existencias recomedadas
	float precio; // Precio

	/**
	 * Constructor for objects of class Producto
	 */
	public Producto1() {

	}

	// Completar
	public Producto1(int codigo, String nombre, int stock, int stock_min, float precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.stock = stock;
		this.stock_min = stock_min;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String valor) {
		nombre = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int valor) {
		codigo = valor;
	}

	@Override
	public String toString() {
		// return codigo +":"+ nombre +": Existencias: "+ stock + " : Precio: "+precio;
		return String.format("| %5d | %-20.20s  | %5d | min: %5d | %10.2f |", codigo, nombre, stock, stock_min, precio);
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int valor) {
		stock = valor;
	}

	public int getStock_min() {
		return stock_min;
	}

	public void setStock_min(int valor) {
		stock_min = valor;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float valor) {
		precio = valor;
	}

	@Override
	public boolean equals(Object obj) {
		// hay que asegurar que obj es de la clase Pruducto

		if (obj != null && obj instanceof Producto1) {
			// se comparan los n�meros de codigo
			Producto1 otro = (Producto1) obj;
			return this.codigo == otro.codigo;
		} else {
			return false;
		}
	}

}
