package candyCrush;

public class Casilla {
	// Atributos
	private int coordenadaX; // Indican las coordenadas X y Y de la casilla correspondiente
	private int coordenadaY;
	private boolean fueUsado = false; // Se utiliza para marcar una casilla que fue utilizada en un movimiento válido
	private String contenido; // Toma el símbolo del caramelo asignado a la casilla, con él se determinarán los movimientos
	
	// Constructores
	public Casilla(int coordenadaX, int coordenadaY) {
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}
	
	// Setters
	public void SetCoordenadaX(int coordenadaX) { // Definir la coordenada X
		this.coordenadaX = coordenadaX;
	}
	
	public void SetCoordenadaY(int coordenadaY) { // Definir la coordenada Y
		this.coordenadaY = coordenadaY;
	}
	
	public void SetUso(boolean fueUsado) { // Definir uso de la casilla
		this.fueUsado = fueUsado;
	}
	
	public void SetContenido(String contenido) { // Definir el símbolo de caramelo contenido en la casilla
		this.contenido = contenido;
	}
	// Getters
	public int GetCoordenadaX() { // Obtener la coordenada X
		return this.coordenadaX;
	}
	
	public int GetCoordenadaY() { // Obtener la coordenada Y
		return this.coordenadaY;
	}
	
	public boolean GetUso() { // Consultar si la casilla se utilizó
		return this.fueUsado;
	}
	
	public String GetContenido() { // Consultar el símbolo de caramelo contenido en la casilla
		return this.contenido;
	}
}
