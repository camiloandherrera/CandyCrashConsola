package candyCrush;

public class Caramelo {
	// Atributos
	private String nombre; // Nombre del caramelo
	private String simbolo; // Distintivo del caramelo que aparece en el tablero
	
	// Constructores
	public Caramelo(String nombre, String simbolo) { // Caramelo "base"
		this.nombre = nombre;
		this.simbolo = simbolo;
	}
	
	// Setters
	public void SetSimbolo(String simbolo) { // Definir el símbolo de un caramelo 
		this.simbolo = simbolo;
	}
	
	public void SetNombre(String nombre) { // Definir el nombre de un caramelo
		this.nombre = nombre;
	}
	
	// Getters
	public String GetSimbolo() { // Obtener el símbolo de un caramelo
		return this.simbolo;
	}
	
	public String GetNombre() { // Obtener el nombre de un caramelo
		return this.nombre;
	}
}
