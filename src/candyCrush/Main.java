package candyCrush;
import candyCrush.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		// Atributos del Main
		Usuario usuario = new Usuario(); // Para ingresar el nombre del usuario
		Mundo mundo = new Mundo(10, 10, 0, 50); // Contiene datos del tablero y la partida en general
		
		int validarInicial = 0; // Valida si se está generando un tablero inicial válido (sin jugadas ya listas)
		Movimiento movimiento = new Movimiento(); // Contiene los movimientos y escaneos del tablero
		
		Scanner ingreso = new Scanner(System.in); // Controla el input de usuario (en ésta clase)
		
		// Llamados, etc.
		System.out.println("#### CANDY CRUSH: PALOS ####");
		usuario.IngresarNombre();
		String auxString = usuario.GetNombre().trim(); // Elimina nombres en blanco (espacios iniciales y finales, saltos de línea, etc)
		usuario.SetNombre(auxString);
		
		if(usuario.GetNombre().length() <= 0) { // Genera el nombre de usuario por defecto si sólo se presionó Enter
			usuario = new Usuario();
		}
		
		do { // Inicia el tablero por primera vez
			validarInicial = 0;
			mundo.RellenarTablero();
			validarInicial = movimiento.EscaneoInicial(mundo, mundo.GetTablero(), true);
		}
		while(validarInicial != 0);
		
		System.out.println("Nombre = " + usuario.GetNombre());
		System.out.println("\nVidas = " + usuario.GetVidas());
		System.out.println("Movimientos restantes: " + mundo.GetMovimientos());
		System.out.println("\nPuntos Totales: " + mundo.GetPuntos());
		System.out.println("Puntos Jugada: " + mundo.GetPuntosJugada());
		mundo.DibujarTablero();
		int cont = 1; // ## TEMPORAL, DEBUG: Condición para seguir jugando ##
		do {
			System.out.println();
			movimiento.SeleccionarCasilla();
		
			Casilla[][] auxiliarTablero;
			auxiliarTablero = mundo.GetTablero();
			
			movimiento.SeleccionarDireccion(auxiliarTablero, mundo);
			boolean hayJugada = movimiento.Verificar(movimiento.GetSelY(), movimiento.GetSelX(), auxiliarTablero, mundo);
			
			System.out.println("\n¿Hay jugada en la coordenada que se movió?: " + hayJugada);
		}
		while(cont == 1); 
	}
}