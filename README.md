# Ejercicio en Español:
## Introducción a la programación en Java: Sistema de reservas de vuelos

Crear un programa que permita reservar asientos de un avión con las siguientes características: 10 filas y 6
columnas, siendo 3 asientos del lado izquierdo y 3 asientos del lado derecho. La posición de cada asiento se
definirá con una letra (A-J) para la fila y un número (1-6) para la columna. El programa deberá mostrar el
siguiente menú:
1. Mostrar asientos
2. Reservar asiento
3. Cancelar reserva
4. Salir

Cuando se muestran los asientos se deberá crear una pantalla similar a la siguiente:

```
  1 2 3   4 5 6  
A x - -   x - - A
B - - -   x x - B
C x - x   - - - C
D - - x   - - x D
E x - -   x - x E
F x x x   x - - F
G - - x   - x x G
H - - x   x x x H
I x - -   - x - I
J - - -   x - - J 
```

**Métodos a utilizar:**

1. inicializarMatriz: Mediante este método se deben inicializar la matriz entera en 1 (1 significa ocupado y
2 significa desocupado).
2. mostrarMenu: Muestra el menú y permite que el usuario elija una opción.
3. generarAccion: Según la opción elegida en el menú deberá generar la acción correspondiente.
4. mostrarAsientos: Debe mostrar todos los asientos para saber cuáles están ocupados y cuáles no.
5. reservarAsiento: Debe permitir ingresar un asiento y reservarlo en el caso que se pueda.
6. cancelarReserva: Debe permitir ingresar un asiento reservado y cancelarlo.
7. buscarSiExiste: Debe verificar si el asiento que se desea reservar existe o no.

**Notas:**

1. El alumno debe determinar los parámetros de entrada y salida de los métodos a desarrollar de manera
que el programa sea óptimo y la mayoría o todos estos (según sea el caso) cumplan la función de
poder ser reutilizables.
2. Se debe corroborar siempre que el usuario ingrese un dato válido por teclado.
3. Los atributos no pueden ser definidos a nivel global, o a nivel clase, sino que deben ser definidos
dentro de los métodos correspondientes.
4. Se deben utilizar las instrucciones try catch, para prevenir cualquier tipo de error que pueda surgir.
5. El scanner debe declararse solo en el método main y debe cerrarse como corresponde.
6. Antes de hacer la reserva, el programa deberá comprobar que el asiento está libre, y que el avión no
se encuentre lleno. En caso contrario, devolverá un mensaje de error.
7. El alumno puede crear otras funciones si así lo considera mientras se encuentren bien implementadas.
