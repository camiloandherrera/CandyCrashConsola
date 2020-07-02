package candyCrush;
import java.util.Scanner;

import candyCrush.*;

public class Movimiento {
	// Atributos
	// Para indicar si hay una jugada v�lida en las selecciones del usuario
	private boolean movimientoValido;
	// Para indicar el caramelo seleccionado
	private int selX;
	private int selY;
	// Constructores
	public Movimiento() {
	}
	// Setters
	public void SetMovValido(boolean movimientoValido) { // Indica si hay un movimiento valido en las selecciones del usuario
		this.movimientoValido = movimientoValido;
	}
	
	public void SetSelX(int selX) { // Establece la coordenada X de la casilla a seleccionar
		this.selX = selX;
	}
	
	public void SetSelY(int selY) { // Establece la coordenada Y de la casilla a seleccionar
		this.selY = selY;
	}
	
	// Getters
	public boolean GetMovValido() { // Consulta si hay un movimiento valido en las selecciones del usuario
		return this.movimientoValido;
	}
	public int GetSelX() { // Obtiene la coordenada X de la casilla a seleccionar
		return this.selX;
	}
	
	public int GetSelY() { // Obtiene la coordenada Y de la casilla a seleccionar
		return this.selY;
	}
	
	// M�todos
	// Escaneos para generar un tablero v�lido
	public int EscanearXInicial(Mundo mundo, Casilla[][] tablero/*, boolean esInicial*/) {
		int conteoLineas = 0; // Determina si al inicio hubo una jugada, para generar un tablero v�lido
		
		for(int i = 0; i < mundo.GetY(); i++) { // Escanea las filas para buscar jugadas
			for (int j = 0; j < mundo.GetX() - 2; j++) {
				if(!tablero[i][j].GetUso()) // Si la posici�n no est� en uso
				{
					Caramelo caramelo = tablero[i][j].GetContenido(); // Duplica el caramelo del caramelo actual
					
					Caramelo nuevoCaramelo = new Caramelo("Provisional", "A"); // Crea un caramelo de remplazo
					
					if(caramelo.GetSimbolo() == tablero[i][j + 1].GetContenido().GetSimbolo() && 
					   caramelo.GetSimbolo() == tablero[i][j + 2].GetContenido().GetSimbolo()) // Compara el caramelo de la posici�n actual con el que est� a la derecha
					{
						conteoLineas++;
						
						int conteoCaramelos = 3;
						
						for(int k = j; k <= j + 2; k++)
						{
							tablero[i][k].SetContenido(nuevoCaramelo); // Si son iguales, reemplaza el caramelo con uno nuevo (provisional, pruebas)
							tablero[i][k].SetUso(true); // Si son iguales, marca el uso de la casilla como verdadero
						}
						
						int auxPosicion = j + 3; // Inicia un contador una posici�n despu�s del tercer caramelo igual hallado
						if(auxPosicion < mundo.GetX()) // El escaneo (y reemplazo de ser posible) se mantiene en el l�mite del tablero sin desbordar
						{
							for(int k = auxPosicion; k < mundo.GetX(); k++) // Recorre las posiciones restante
							{
								if(caramelo.GetSimbolo() == tablero[i][k].GetContenido().GetSimbolo()) // Si encuentra s�mbolos iguales...
								{
									conteoCaramelos++;
									
									tablero[i][k].SetContenido(nuevoCaramelo); // ...reemplaza el contenido...
									tablero[i][k].SetUso(true); // ... y marca su uso como verdadero.
								}
								else
								{
									break; // Si no hallan caramelos iguales, la iteraci�n se rompe.
								}
							}
						}
						
						/*if(!esInicial)
						{
							//Llamar la funci�n que suma puntos, ya que en el inicial no se llama, pero en los dem�s s�
							mundo.SetPuntosJugada(PuntosJugada(conteoCaramelos)); // Para mostrar, y sumar al total, los puntos de la �ltima jugada
							mundo.SetPuntos(mundo.GetPuntos() + mundo.GetPuntosJugada()); // Suma los puntos de la jugada al total
						}*/
					}
				}
			}
		}
		return conteoLineas;
	}
	
	public int EscanearYInicial(Mundo mundo, Casilla[][] tablero /*, boolean esInicial*/) { // Escanea las columnas en busca de jugadas
		int conteoLineas = 0; // Determina si al inicio hubo una jugada, para generar un tablero v�lido
		
		for(int i = 0; i < mundo.GetY() - 2; i++) {
			for (int j = 0; j < mundo.GetX(); j++) {
				if(!tablero[i][j].GetUso()) // Si la posici�n no est� en uso
				{
					Caramelo caramelo = tablero[i][j].GetContenido(); // Duplica el caramelo del caramelo actual
					
					Caramelo nuevoCaramelo = new Caramelo("Provisional", "B"); // Crea un caramelo de remplazo
					
					if(caramelo.GetSimbolo() == tablero[i + 1][j].GetContenido().GetSimbolo() && 
					   caramelo.GetSimbolo() == tablero[i + 2][j].GetContenido().GetSimbolo()) // Compara el caramelo de la posici�n actual con el que est� a la derecha
					{
						conteoLineas++;
						
						int conteoCaramelos = 3;
						
						for(int k = i; k <= i + 2; k++)
						{
							tablero[k][j].SetContenido(nuevoCaramelo); // Si son iguales, reemplaza el caramelo con uno nuevo (provisional, pruebas)
							tablero[k][j].SetUso(true); // Si son iguales, marca el uso de la casilla como verdadero
						}
						
						int auxPosicion = i + 3; // Inicia un contador una posici�n despu�s del tercer caramelo igual hallado
						if(auxPosicion < mundo.GetX()) // El escaneo (y reemplazo de ser posible) se mantiene en el l�mite del tablero sin desbordar
						{
							for(int k = auxPosicion; k < mundo.GetX(); k++) // Recorre las posiciones restante
							{
								if(caramelo.GetSimbolo() == tablero[k][j].GetContenido().GetSimbolo()) // Si encuentra s�mbolos iguales...
								{
									conteoCaramelos++;
									
									tablero[k][j].SetContenido(nuevoCaramelo); // ...reemplaza el contenido...
									tablero[k][j].SetUso(true); // ... y marca su uso como verdadero.
								}
								else
								{
									break; // Si no hallan caramelos iguales, la iteraci�n se rompe.
								}
							}
						}
					/*	if(!esInicial)
						{
							//Llamar la funci�n que suma puntos, ya que en el inicial no se llama, pero en los dem�s s�
							mundo.SetPuntosJugada(PuntosJugada(conteoCaramelos)); // Para mostrar, y sumar al total, los puntos de la �ltima jugada
							mundo.SetPuntos(mundo.GetPuntos() + mundo.GetPuntosJugada()); // Suma los puntos de la jugada al total
						} */
					}
				}
			}
		}
		return conteoLineas;
	}
	
	public int EscaneoInicial(Mundo mundo, Casilla[][] tablero, boolean esInicial) { // Para verificar si hay un tablero inicial v�lido
		
		int scanX = EscanearXInicial(mundo, tablero/*, esInicial*/);
		int scanY = EscanearYInicial(mundo, tablero/*, esInicial*/);
		
		int scan = scanX + scanY;
		
		return scan;
	}
	
	// Movimiento de caramelos entre casillas
	public void SeleccionarCasilla() { // Permite el ingreso de usuario de las coordenadas de la casilla (con un caramelo) a jugar
		Scanner ingreso = new Scanner(System.in);
		int selY, selX;
		
		System.out.println("Seleccionar caramelo a mover.");
		System.out.print("Coordenada X: ");
		selX = ingreso.nextInt();
		System.out.print("\nCoordenada Y: ");
		selY = ingreso.nextInt();
		
		this.selY = selY - 1;
		this.selX = selX - 1;
	}
	
	public Casilla[][] MoverDerecha(Casilla[][] auxiliarTablero, Mundo mundo) { // Realizar el movimiento, una casilla a la derecha
		int moverY = this.GetSelY();
		int moverX = this.GetSelX();
		
		if (this.GetSelX() < mundo.GetX() - 1) { // S�lo mover� a la derecha si la casilla seleccionada no est� en el l�mite del tablero
			moverX = this.GetSelX() + 1;
			Mover(auxiliarTablero[this.GetSelY()][this.GetSelX()], auxiliarTablero[moverY][moverX]);
		}
		else {
			moverX = this.GetSelX();
			System.out.println("No se puede mover m�s all� del l�mite.");
			auxiliarTablero = auxiliarTablero;
		}
		
		return auxiliarTablero;
	}
	
	public Casilla[][] MoverIzquierda(Casilla[][] auxiliarTablero, Mundo mundo) { // Realizar el movimiento, una casilla a la izquierda
		int moverY = this.GetSelY();
		int moverX = this.GetSelX();
		
		if (this.GetSelX() > 0) { // S�lo mover� a la derecha si la casilla seleccionada no est� en el l�mite del tablero
			moverX = this.GetSelX() - 1;
			Mover(auxiliarTablero[this.GetSelY()][this.GetSelX()], auxiliarTablero[moverY][moverX]);
		}
		else {
			moverX = this.GetSelX();
			System.out.println("No se puede mover m�s all� del l�mite.");
			auxiliarTablero = auxiliarTablero;
		}
		
		return auxiliarTablero;
	}
	
	public Casilla[][] MoverAbajo(Casilla[][] auxiliarTablero, Mundo mundo) { // Realizar el movimiento, una casilla hacia abajo
		int moverY = this.GetSelY();
		int moverX = this.GetSelX();
		
		if (this.GetSelY() < mundo.GetY() - 1) { // S�lo mover� a la derecha si la casilla seleccionada no est� en el l�mite del tablero
			moverY = this.GetSelY() + 1;
			Mover(auxiliarTablero[this.GetSelY()][this.GetSelX()], auxiliarTablero[moverY][moverX]);
		}
		else {
			moverY = this.GetSelY();
			System.out.println("No se puede mover m�s all� del l�mite.");
			auxiliarTablero = auxiliarTablero;
		}
		
		return auxiliarTablero;
	}
	
	public Casilla[][] MoverArriba(Casilla[][] auxiliarTablero, Mundo mundo) { // Realizar el movimiento, una casilla hacia arriba
		int moverY = this.GetSelY();
		int moverX = this.GetSelX();
		
		if (this.GetSelY() > 0) { // S�lo mover� a la derecha si la casilla seleccionada no est� en el l�mite del tablero
			moverY = this.GetSelY() - 1;
			Mover(auxiliarTablero[this.GetSelY()][this.GetSelX()], auxiliarTablero[moverY][moverX]);
		}
		else {
			moverY = this.GetSelY();
			System.out.println("No se puede mover m�s all� del l�mite.");
			auxiliarTablero = auxiliarTablero;
		}
		
		return auxiliarTablero;
	}
	
	public void SeleccionarDireccion(Casilla[][] auxiliarTablero, Mundo mundo) { // Indicar la posici�n a la que se mover� el caramelo seleccionado
		Scanner ingreso = new Scanner(System.in);
		
		int seleccion; // Controla la selecci�n de usuario, en cuanto a la direcci�n a mover
		System.out.println("\n1: Arriba");
		System.out.println("2: Abajo");
		System.out.println("3: Derecha");
		System.out.println("4: Izquierda");
		System.out.print("Seleccionar direcci�n a mover: ");
		seleccion = ingreso.nextInt();
			
		switch (seleccion) {
			case 1:
				MoverArriba(auxiliarTablero, mundo);
				System.out.println("Arriba");
			break;
			
			case 2:
				MoverAbajo(auxiliarTablero, mundo);
				System.out.println("Abajo");
			break;
			
			case 3:
				MoverDerecha(auxiliarTablero, mundo);
				System.out.println("Derecha");
			break;
			
			case 4:
				MoverIzquierda(auxiliarTablero, mundo);
				System.out.println("Izquierda");
			break;
			
			default:
				System.out.println("Selecci�n inv�lida");
			break;
		}
		mundo.SetTablero(auxiliarTablero);
		auxiliarTablero = mundo.GetTablero();
		mundo.DibujarTablero();
	}
	
	public void Mover(Casilla casillaAMover, Casilla casillaDestino) {
		Casilla provisional1 = new Casilla(casillaAMover.GetCoordenadaX(), casillaAMover.GetCoordenadaY(), casillaAMover.GetContenido());
		Casilla provisional2 = new Casilla(casillaDestino.GetCoordenadaX(), casillaDestino.GetCoordenadaY(), casillaDestino.GetContenido());
		
		provisional1.SetContenido(casillaAMover.GetContenido());
		provisional2.SetContenido(casillaDestino.GetContenido());
		
		casillaAMover.SetContenido(provisional2.GetContenido());
		casillaDestino.SetContenido(provisional1.GetContenido());
	}
	
	public boolean Verificar(int posY, int posX, Casilla[][] tablero, Mundo mundo) {
		boolean hayJugada = false;
		// DE LA CASILLA A LA DERECHA
		// L�mite superior + �timas dos columnas
		// Verifica si al subir una casilla hay jugada, no aplica al l�mite superior
		if (posY != 0 && posX < mundo.GetX() - 2) {
			if(tablero[posY - 1][posX].GetContenido().GetSimbolo() == tablero[posY - 1][posX + 1].GetContenido().GetSimbolo() &&
			tablero[posY - 1][posX + 1].GetContenido().GetSimbolo() == tablero[posY - 1][posX + 2].GetContenido().GetSimbolo()) { 
				hayJugada = true; 
			}
		}
		
		// L�mite inferior + �timas dos columnas
		// Verifica si al bajar una casilla hay jugada, no aplica al l�mite inferior
		if (posY < mundo.GetY() - 1 && posX < mundo.GetX() - 2) {
			if(tablero[posY + 1][posX].GetContenido().GetSimbolo() == tablero[posY + 1][posX + 1].GetContenido().GetSimbolo() &&
			tablero[posY + 1][posX + 1].GetContenido().GetSimbolo() == tablero[posY + 1][posX + 2].GetContenido().GetSimbolo()) {
				hayJugada = true;
			}
		}
		
		// L�mites laterales
		// Verifica si al mover a la izquierda una casilla hay jugada, no aplica a los l�mites laterales
		if (posX > 0 && posX < mundo.GetX() - 1) {
			if(tablero[posY][posX - 1].GetContenido().GetSimbolo() == tablero[posY][posX].GetContenido().GetSimbolo() &&
			tablero[posY][posX].GetContenido().GetSimbolo() == tablero[posY][posX + 1].GetContenido().GetSimbolo()) { 
				hayJugada = true;
			}
		}
		
		// L�mite derecha
		// Verifica si al mover a la derecha una casilla hay jugada, no aplica al l�mite de la derecha - 2
		if(posX < mundo.GetX() - 3) {
			if(tablero[posY][posX + 1].GetContenido().GetSimbolo() == tablero[posY][posX + 2].GetContenido().GetSimbolo() &&
			tablero[posY][posX + 2].GetContenido().GetSimbolo() == tablero[posY][posX + 3].GetContenido().GetSimbolo()) {
				hayJugada = true;
			}
		}
		
		// DE LA CASILLA A LA IZQUIERDA
		// L�mite superior + primeras dos columnas
		// Verifica si al subir una casilla hay jugada, no aplica al l�mite superior, y hasta dos casillas luego del l�mite izquierdo
		if (posY > 0 && posX > 1) {
			if(tablero[posY - 1][posX].GetContenido().GetSimbolo() == tablero[posY - 1][posX - 1].GetContenido().GetSimbolo() &&
			tablero[posY - 1][posX - 1].GetContenido().GetSimbolo() == tablero[posY - 1][posX - 2].GetContenido().GetSimbolo()) {
				hayJugada = true; 
			}
		}
		
		// L�mite inferior + dos primeras columnas
		// Verifica si al bajar una casilla hay jugada, no aplica al l�mite inferior, y hasta dos casillas despu�s del l�mite izquierdo
		if (posY < mundo.GetY() - 1 && posX > 1) {
			if(tablero[posY + 1][posX].GetContenido().GetSimbolo() == tablero[posY + 1][posX - 1].GetContenido().GetSimbolo() &&
			tablero[posY + 1][posX - 1].GetContenido().GetSimbolo() == tablero[posY + 1][posX - 2].GetContenido().GetSimbolo()) {
				hayJugada = true;
			}
		}
		
		// L�mite a la izquierda
		// Verifica si al mover a la izquierda una casilla hay jugada, no aplica al l�mite izquierdo
		if (posX > 2 && posX < mundo.GetX() - 3) {
			if(tablero[posY][posX - 1].GetContenido().GetSimbolo() == tablero[posY][posX - 2].GetContenido().GetSimbolo() &&
			tablero[posY][posX - 2].GetContenido().GetSimbolo() == tablero[posY][posX - 3].GetContenido().GetSimbolo()) {
				hayJugada = true;
			}
		}
		
		// L�mite a la derecha
		// Verifica si al mover a la derecha una casilla hay jugada, no aplica a los l�mites laterales
		if (posX < mundo.GetX() - 1) {
			if(tablero[posY][posX + 1].GetContenido().GetSimbolo() == tablero[posY][posX].GetContenido().GetSimbolo() &&
			tablero[posY][posX].GetContenido().GetSimbolo() == tablero[posY][posX - 1].GetContenido().GetSimbolo()) {
				hayJugada = true;
			}
		}
		
		// HACIA AMBOS LADOS (IZQ-DER)
		// L�mite superior + l�mites laterales
		if (posX > 1 && posX < mundo.GetX() - 1) {
			if (posY > 0 && posY < mundo.GetY() - 1) {
		// Verifica si al bajar una casilla hay jugada, no aplica a los l�mites laterales
				if(tablero[posY + 1][posX].GetContenido().GetSimbolo() == tablero[posY + 1][posX + 1].GetContenido().GetSimbolo() &&
				tablero[posY + 1][posX].GetContenido().GetSimbolo() == tablero[posY + 1][posX - 1].GetContenido().GetSimbolo()) {
					hayJugada = true; 
				}
		// Verifica si al subir una casilla hay jugada, no aplica a los l�mites laterales
				else if(tablero[posY - 1][posX].GetContenido().GetSimbolo() == tablero[posY - 1][posX + 1].GetContenido().GetSimbolo() &&
				tablero[posY - 1][posX + 1].GetContenido().GetSimbolo() == tablero[posY - 1][posX - 1].GetContenido().GetSimbolo()) {
				hayJugada = true; 
				}
			}
		}
		
		// L�mite izquierdo
		// Verifica si al mover a la izquierda una casilla hay jugada, no aplica al l�mite izquierdo
		if (posX > 0) {
			if(tablero[posY][posX - 1].GetContenido().GetSimbolo() == tablero[posY][posX].GetContenido().GetSimbolo() &&
			tablero[posY][posX - 1].GetContenido().GetSimbolo() == tablero[posY][posX + 1].GetContenido().GetSimbolo()) {
				hayJugada = true;
			}
		}
		
		// L�mite derecho
		// Verifica si al mover a la derecha una casilla hay jugada, no aplica al l�mite derecho
		if (posX < mundo.GetX() - 1) {
			if(tablero[posY][posX + 1].GetContenido().GetSimbolo() == tablero[posY][posX].GetContenido().GetSimbolo() &&
			tablero[posY][posX].GetContenido().GetSimbolo() == tablero[posY][posX - 1].GetContenido().GetSimbolo()) {
				hayJugada = true;
			}
		}
		
		// DE LA CASILLA HASTA ARRIBA
		// Verifica si al subir una casilla hay jugada, no aplica al l�mite superior
		if (posY > 2) {
			if(tablero[posY - 1][posX].GetContenido().GetSimbolo() == tablero[posY - 2][posX].GetContenido().GetSimbolo() &&
			tablero[posY - 2][posX].GetContenido().GetSimbolo() == tablero[posY - 3][posX].GetContenido().GetSimbolo()) {
				hayJugada = true; 
			}
		}
		if (posY > 2 && posX > 0 && posX < mundo.GetX() - 1) {
		// Verifica si al mover a la derecha una casilla hay jugada
			if(tablero[posY][posX + 1].GetContenido().GetSimbolo() == tablero[posY - 1][posX + 1].GetContenido().GetSimbolo() &&
			tablero[posY - 1][posX + 1].GetContenido().GetSimbolo() == tablero[posY - 2][posX + 1].GetContenido().GetSimbolo()) {
				hayJugada = true;
			}
		// Verifica si al mover a la izquierda una casilla hay jugada
			else if(tablero[posY][posX - 1].GetContenido().GetSimbolo() == tablero[posY - 1][posX - 1].GetContenido().GetSimbolo() &&
			tablero[posY - 1][posX - 1].GetContenido().GetSimbolo() == tablero[posY - 2][posX - 1].GetContenido().GetSimbolo()) {
				hayJugada = true;
			}
		}			
					
		// Verifica si al bajar una casilla hay jugada, no aplica al l�mite inferior
			if (posY < mundo.GetX() - 3) {
				if(tablero[posY + 1][posX].GetContenido().GetSimbolo() == tablero[posY + 2][posX].GetContenido().GetSimbolo() &&
				tablero[posY + 2][posX].GetContenido().GetSimbolo() == tablero[posY + 3][posX].GetContenido().GetSimbolo()) {
					hayJugada = true; 
				}
			}			
		
		
		
		// DE LA CASILLA HASTA ABAJO
		// L�mite inferior y �ltimas tres filas
		// Verifica si al subir una casilla hay jugada, no aplica al l�mite inferior
		if (posY < mundo.GetY() - 2 && posY > 2) {
			if (posY > 0) {
				if (tablero[posY - 1][posX].GetContenido().GetSimbolo() == tablero[posY][posX].GetContenido().GetSimbolo() &&
				tablero[posY][posX].GetContenido().GetSimbolo() == tablero[posY + 1][posX].GetContenido().GetSimbolo()) { 
					hayJugada = true;
				}
		// Verifica si al bajar una casilla hay jugada, no aplica al l�mite inferior
				else if (tablero[posY + 1][posX].GetContenido().GetSimbolo() == tablero[posY + 2][posX].GetContenido().GetSimbolo() &&
				tablero[posY + 2][posX].GetContenido().GetSimbolo() == tablero[posY - 3][posX].GetContenido().GetSimbolo()) { 
					hayJugada = true;
				}
			}
		}
		
		if (posX > 0 && posX < mundo.GetX() - 3 && posY < mundo.GetY() - 3) { 
		// Verifica si al mover a la derecha una casilla hay jugada	
			if(tablero[posY][posX + 1].GetContenido().GetSimbolo() == tablero[posY + 1][posX + 1].GetContenido().GetSimbolo() &&
			tablero[posY + 1][posX + 1].GetContenido().GetSimbolo() == tablero[posY + 2][posX + 1].GetContenido().GetSimbolo()) {
					hayJugada = true;
				}
		// Verifica si al mover a la izquierda una casilla hay jugada
			else if(tablero[posY][posX - 1].GetContenido().GetSimbolo() == tablero[posY + 1][posX - 1].GetContenido().GetSimbolo() &&
			tablero[posY + 1][posX - 1].GetContenido().GetSimbolo() == tablero[posY + 2][posX - 1].GetContenido().GetSimbolo()) { 
					hayJugada = true; 
			}
		}
		
		// HACIA AMBOS LADOS (UP-DOWN)
		// L�mite superior
		// Verifica si al subir una casilla hay jugada, no aplica al l�mite superior
		if (posY > 1 && posY < mundo.GetX() - 1) {
			if(tablero[posY - 1][posX].GetContenido().GetSimbolo() == tablero[posY][posX].GetContenido().GetSimbolo() &&
			tablero[posY][posX].GetContenido().GetSimbolo() == tablero[posY - 2][posX].GetContenido().GetSimbolo()) {
				hayJugada = true; 
			}
		}
		// Verifica si al bajar una casilla hay jugada, no aplica al l�mite inferior
		if (posY > 0 && posY < mundo.GetY() - 2) {
			if(tablero[posY + 1][posX].GetContenido().GetSimbolo() == tablero[posY][posX].GetContenido().GetSimbolo() &&
			tablero[posY][posX].GetContenido().GetSimbolo() == tablero[posY + 2][posX].GetContenido().GetSimbolo()) {
				hayJugada = true; 
			}
		}
		// L�mites laterales
		// Verifica si al mover a la izquierda hay una jugada
		if (posY > 0 && posY < mundo.GetY() - 1) {
			if (posX > 0 && posX < mundo.GetX() - 1) {
				if(tablero[posY + 1][posX - 1].GetContenido().GetSimbolo() == tablero[posY][posX - 1].GetContenido().GetSimbolo() &&
				tablero[posY][posX - 1].GetContenido().GetSimbolo() == tablero[posY - 1][posX - 1].GetContenido().GetSimbolo()) {
					hayJugada = true; 
				}
		// Verifica si mover a la derecha hay una jugada
				if(tablero[posY + 1][posX + 1].GetContenido().GetSimbolo() == tablero[posY][posX + 1].GetContenido().GetSimbolo() &&
				tablero[posY][posX + 1].GetContenido().GetSimbolo() == tablero[posY + 2][posX + 1].GetContenido().GetSimbolo()) {
					hayJugada = true; 
				}
			}
		}
	
		// OTROS
		// Formar fila hacia abajo
		if (posY > 1 && posY < mundo.GetY() - 3) {
			if(tablero[posY][posX ].GetContenido().GetSimbolo() == tablero[posY + 1][posX].GetContenido().GetSimbolo() &&
			tablero[posY + 1][posX].GetContenido().GetSimbolo() == tablero[posY + 2][posX].GetContenido().GetSimbolo()) {
				hayJugada = true; 
			}
		}
		
		// Formar fila hacia arriba
		if (posY > 2 && posY < mundo.GetY() - 2) {
			if(tablero[posY][posX].GetContenido().GetSimbolo() == tablero[posY - 1][posX].GetContenido().GetSimbolo() &&
			tablero[posY - 1][posX].GetContenido().GetSimbolo() == tablero[posY - 2][posX].GetContenido().GetSimbolo()) {
				hayJugada = true; 
			}
		}
		
		// Formar fila hacia la derecha
		if (posY > 2 && posY < mundo.GetY() - 3) {
			if(tablero[posY][posX].GetContenido().GetSimbolo() == tablero[posY][posX + 1].GetContenido().GetSimbolo() &&
			tablero[posY][posX + 1].GetContenido().GetSimbolo() == tablero[posY][posX + 2].GetContenido().GetSimbolo()) {
				hayJugada = true; 
			}
		}
		
		return hayJugada;
	}
	
	// Otros
	public int PuntosJugada(int conteoCaramelos) { // Suma los puntos de una jugada, acorde al n�mero de caramelos alineados
		int puntosCaramelos;
		switch(conteoCaramelos) {
			case 1:
				puntosCaramelos = 0;
			break;
			
			case 2:
				puntosCaramelos = 0;
			break;
			
			case 3:
				puntosCaramelos = 50;
			break;
			
			case 4: 
				puntosCaramelos = 100;
			break;
			
			case 5:
				puntosCaramelos = 200;
			break;
			
			case 6: 
				puntosCaramelos = 400;
			break;
			
			default:
				puntosCaramelos = 600;
			break;
		}
		
		return puntosCaramelos;
	}
}
