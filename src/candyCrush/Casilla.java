package candyCrush;

public class Casilla {
	// Atributos
	private int coordenadaY; // Indican las coordenadas X y Y de la casilla correspondiente
	private int coordenadaX;
	private boolean fueUsado = false; // Se utiliza para marcar una casilla que fue utilizada en un movimiento válido
	private Caramelo contenido; // Toma el símbolo del caramelo asignado a la casilla, con él se determinarán los movimientos
	
	// Constructores
	public Casilla(int coordenadaY, int coordenadaX, Caramelo contenido) {
		this.coordenadaY = coordenadaY;
		this.coordenadaX = coordenadaX;
		this.contenido = contenido;
	}
	
	// Setters
	public void SetCoordenadaY(int coordenadaY) { // Definir la coordenada Y
		this.coordenadaY = coordenadaY;
	}
	
	public void SetCoordenadaX(int coordenadaX) { // Definir la coordenada X
		this.coordenadaX = coordenadaX;
	}
	
	public void SetUso(boolean fueUsado) { // Definir uso de la casilla
		this.fueUsado = fueUsado;
	}
	
	public void SetContenido(Caramelo contenido) { // Definir  caramelo contenido en la casilla
		this.contenido = contenido;
	}
	// Getters
	public int GetCoordenadaY() { // Obtener la coordenada Y
		return this.coordenadaY;
	}
	
	public int GetCoordenadaX() { // Obtener la coordenada X
		return this.coordenadaX;
	}
	
	public boolean GetUso() { // Consultar si la casilla se utilizó
		return this.fueUsado;
	}
	
	public Caramelo GetContenido() { // Consultar el caramelo contenido en la casilla
		return this.contenido;
	}
}
