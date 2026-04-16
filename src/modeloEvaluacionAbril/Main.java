package modeloEvaluacionAbril;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		final String[] OPTIONS = new String[] {"Mostrar asientos", "Reservar asiento", "Cancelar reserva", "Salir"};
		final int MIN_OPTION = 1;
		final int MAX_OPTION = OPTIONS.length;
		int[][] seats = new int[10][6]; // 10 rows, 6 columns
		Scanner s = new Scanner(System.in);
		initMatrix(seats);
		showMenu(OPTIONS);
		int selectedOption = getParsedInt(s, MIN_OPTION, MAX_OPTION); // Obtener entero "analizado", estamos seguros que es correcto.
		generateAction(selectedOption, seats);
		
		s.close();
	}
	
	public static void initMatrix(int[][] seats) { // 1. inicializarMatriz
		for(int r = 0; r < seats.length; r++) { // r: row
			for(int c = 0; c < seats[r].length; c++) {
				seats[r][c] = 1; // 1: occupied, 2: free
			}
		}
		//System.out.println("DEBUG: Initialization finished");
	}
	
	public static void showMenu(String[] options) { // 2. mostrarMenu
		System.out.println("==========*==========*==========*==========");
		enumerate(options);
		System.out.println("==========*==========*==========*==========");
	}
	
	public static void generateAction(int option, int[][] seats) { // 3. generarAccion
		switch (option) {
		case 1:
			showSeats(seats); 
			break;
		case 2:
			//reserveSeat(seats); // 5. reservarAsiento
			break;
		case 3:
			//cancelReservation(seats); // 6. cancelarReserva
			break;
		case 4:
			//exit();
			break;
		}
	}
	
	public static void showSeats(int seats[][]) { // 4. mostrarAsientos
		final String[] ROWS_LETTERS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		final String[] COLUMNS = {"1", "2", "3", "4", "5", "6"}; // Nota: podria utilizar directamente i + 1 para mostrarlos pero para mayor legibilidad voy a hacerlo así.
		final int HALLWAY_PER_SEATS = 3;
		System.out.print("  ");
		for (int columnIndex = 0; columnIndex < COLUMNS.length; columnIndex++) {
			System.out.print(COLUMNS[columnIndex] + " ");
			if ( ( (columnIndex + 1) % HALLWAY_PER_SEATS) == 0) {
				System.out.print("  ");
			}
		}
		
		System.out.print("\n");
		
		for (int rowLetterIndex = 0; rowLetterIndex < ROWS_LETTERS.length; rowLetterIndex++){
			
			System.out.print(ROWS_LETTERS[rowLetterIndex] + " ");
			for (int seatIndex = 0; seatIndex < seats[rowLetterIndex].length; seatIndex++) {
				
				int seat = seats[rowLetterIndex][seatIndex];
				String seatAvailable = null;
				if (seat == 1) {
					seatAvailable = "x";
				} else if (seat == 2) {
					seatAvailable = "-";
				}
				
				System.out.print(seatAvailable + " ");
				
				if (( ( (seatIndex + 1) % HALLWAY_PER_SEATS ) == 0) && (seatIndex != seats[rowLetterIndex].length - 1)) {
					System.out.print("  ");
				}
			}
			System.out.print(ROWS_LETTERS[rowLetterIndex]);
			System.out.print("\n");
		}
	}
	
	public static int getParsedInt(Scanner s, int min, int max) {
		// Necesito un do while porque hasta que el usuario no ingrese el dato del modo correcto, hay que continuar pidiéndolo.
		
		boolean errorExists = false;
		int n = 0;
		
		do {		
			try {				
				errorExists = false; // Si volvemos a entrar al siguiente ciclo, vamos a reiniciar el indicador de error, esperando que no suceda nuevamente
				n = s.nextInt();
				
				if (n < min || n > max) {
					System.out.println("Error: El número ingresado es incorrecto.");
					errorExists = true;
				}
			}
			catch(InputMismatchException exception) {
				// Por ejemplo si escribo "hola<enter>" el buffer almacena "hola\n"
				System.out.println("Error: El valor ingresado es incorrecto.");
				errorExists = true;
				s.nextLine(); // Mueve el marcador de posición del buffer al índice del primer caracter después de \n
				// como despues de "hola\n" no hay nada (hay un espacio libre), decimos que el buffer "queda limpio"
				// pero en realidad nos estamos posicionando en un lugar libre para llenarlo con la siguiente entrada
				// el "hola\n" anterior sigue en el buffer, solo que ya no lo leemos.
			}
			finally { // Siempre, se ejecuta. Incluso si hay un return en try o catch.
				if(errorExists) {
					System.out.println("Por favor, ingrese un número entero entre " + min + " y " + max);					
				}
			}
			
			// Lo que está acá (dentro del do pero fuera del ámbito try/catch/finally), no se ejecuta si hay un return.
			
		} while (errorExists); // Si hay un error volvemos a ciclar
		
		return n;
		
	}
	
	public static void enumerate(String[] lines) {
		for (int lineNum = 0; lineNum < lines.length; lineNum++) {
			System.out.println((lineNum + 1) + ". " + lines[lineNum]);
		}
	}
}