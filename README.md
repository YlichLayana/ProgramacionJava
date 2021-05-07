# ProgramacionJava
Este repositorio contiene Tareas

En este repositorio crearemos tendremos dos proyectos donde utilizamos dos maneras distintas de implementarlos una es ArrayLits y la segunda es utilizando HashMap, donde cada uno de los proyecto vamos a Implementar una aplicación por consola que implemente un CRUD (Create, Read, Update, Delete) que sirve para mantener un almacén de productos con los siguientes campos que seran los atributos de nuestros objetos productos:
  1. int código - Código del producto, se utiliza para buscar
  2. String nombre - Nombre un texto
  3. int stock - existencia actuales
  4. int stock_min; - Número mínimo de existencias recomedadas
  5. float precio - Precio

El programa deberá implementar el siguiente menú
  1. Nuevo producto → Entrada de productos, dos productos no pueden tener el mismo código. Precio y stock tienen que ser mayor que 0
  2. Consulta producto → Se pide un código y se muestra su información
  3. Borrar producto → Se pide un código, se muestra su información y se piden confirmar la eliminación.
  4. Modificar precio → Se pide un código, se muestra su información y se pide el nuevo valor de precio, que no puede ser negativo o 0
  5. Compra de productos → Se solicita un código y la cantidad de productos comprados, se  incrementa es stock
  6. Venta de productos →  Se solicita un código y la cantidad de productos vendidos,  se decrementa el stock ( No puede ser negativo, no se puede vender más productos de los hay en stock)
  7. Listado completo de productos → Muestra un listado formateado de productos
  8. Listado de productos con stock inferior al mínimo. → Muestra un listado de los productos cuyo stock_min es superior al stock actual.
  9. Terminar → Termina el programa
