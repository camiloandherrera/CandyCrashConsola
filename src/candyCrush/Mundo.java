package candyCrush;
import candyCrush.*;
import java.lang.System;

public class Mundo {
	// Atributos
	// Tablero
	private Casilla[][] tablero;
	private int tamY;
	private int tamX;
	// Jugador/Partida
	private int puntos;
	private int puntosJugada; // Guarda los puntos de una jugada determinada
	private int movimientos;
	private boolean hayMovimientos;
	
	// Constructores
	public Mundo(int tamY, int tamX, int puntos, int movimientos) {
		this.tamY = tamY;
		this.tamX = tamX;
		this.tablero = new Casilla[this.tamY][this.tamX];
		
		this.puntos = puntos;
		this.movimientos = movimientos;
	}
	
	// Setters
	public void SetTablero(Casilla[][] tablero) { // Establece el tablero de la partida
		this.tablero = tablero;
	}
	
	public void SetY(int tamY) { // Establece el límite en la coordenada en Y
		this.tamY = tamY;
	}
	
	public void SetX(int tamX) { // Establece el límite en la coordenada en X
		this.tamX = tamX;
	}
	
	public void SetPuntos(int puntos) { // Establece los puntos obtenidos en esta vida de jugador
		this.puntos = puntos;
	}
	
	public void SetPuntosJugada(int puntosJugada) { // Establece los puntos obtenidos de la última jugada posible
		this.puntosJugada = puntosJugada;
	}
	
	public void SetMovimientos(int movimientos) { // Establece los movimientos restantes en esta vida de jugador
		this.movimientos = movimientos;
	}
	
	public void SetHayMovimientos(boolean hayMovimientos) { // Establece si quedan o no movimientos en el tablero actual
		this.hayMovimientos = hayMovimientos;
	}
	
	// Getters
	public Casilla[][]GetTablero() { // Obtiene el tablero de la partida
		return this.tablero;
	}
	
	public int GetY() { // Obtiene el límite de la coordenada Y
		return this.tamY;
	}
	
	public int GetX() { // Obtiene el límite de la coordenada X
		return this.tamX;
	}
	
	public int GetPuntos() { // Obtiene los puntos obtenidos en esta vida de jugador
		return this.puntos;
	}
	
	public int GetPuntosJugada() {  // Obtiene los puntos de la jugada más reciente
		return this.puntosJugada;
	}
	
	public int GetMovimientos() { // Obtiene los movimientos restantes en esta vida de jugador
		return this.movimientos;
	}
	
	public boolean GetHayMovimientos() { // Obtiene la condición de la existencia de movimientos;
		return this.hayMovimientos;
	}
	
	// Métodos
	public void RestarMovimiento() { // Al hacer un movimiento, resta el contador de los mismos de esta vida de jugador
		this.movimientos = this.movimientos - 1;
	}
	
	public Caramelo CrearCaramelo() { // Genera los caramelos para rellenar el tablero
		Caramelo caramelo;
		int valorAleatorio = (int)Math.floor(Math.random()*5 + 1);
		
		switch(valorAleatorio) {
		case 1:
			caramelo = new Caramelo("Picas", "♠"); // Símbolo U+2660, "Palo de Picas negro"
			break;
		case 2:
			caramelo = new Caramelo("Tréboles", "♣"); // Símbolo U+2663, "Palo de Tréboles negro"
			break;
		case 3:
			caramelo = new Caramelo("Corazones", "♥"); // Símbolo U+2665, "Palo de Corazones negro"
			break;
		case 4:
			caramelo = new Caramelo("Diamantes", "♦"); // Símbolo U+2666, "Palo de Diamantes negro"
			break;
		case 5:
			caramelo = new Caramelo("Comodín", "☻"); // Símbolo U+263B, "Cara negra sonriente"
			break;
		default:
			caramelo = new Caramelo("Picas", "♠"); // Símbolo U+2660, "Palo de Picas negro"
			break;
		}
		return caramelo;
	}
	
	public void RellenarTablero() { // Inicialmente llena el tablero con caramelos aleatorios
		for (int i = 0; i < this.tamY; i++) {
			for (int j = 0; j < this.tamX; j++) {
				this.tablero[i][j] = new Casilla(i, j, CrearCaramelo());
			}
		}
	}
	
	public void DibujarTablero() {
		for (int i = 0; i < this.tamY; i++) {
			if (i == 0) {
				System.out.print("  ");
				for (int m = 1; m <= this.tamX; m++) {
					System.out.print(m + " ");
				}
			}
			System.out.println();
			
			for (int j = 0; j < this.tamX; j++) {
				if (j == 0) {
					System.out.print(i + 1 + " ");
				}
				
				System.out.print(this.tablero[i][j].GetContenido().GetSimbolo() + " ");
			}
		}
	}
}
