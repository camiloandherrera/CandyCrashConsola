package candyCrush;
import java.util.Scanner; // Importa la clase Scanner, para el ingreso de datos de usuario

public class Usuario {
	// Atributos
	private String nombre; // Nombre del jugador
	private int vidas; // Número de vidas para el juego
	
	// Constructores
	public Usuario() { // Constructor del usuario; inicializando el número de vidas y dando un nombre predeterminado
		this.nombre = "Jugador";
		this.vidas = 5;
	}
	
	// Setters
	public void SetNombre(String nombre) { // Define el nombre de jugador, si el usuario lo ingresa
		this.nombre = nombre;
	}
	
	public void SetVidas(int vidas) { // Define el número de vidas de jugador; usualmente utilizado cuando se pierde una ronda
		this.vidas = vidas;
	}
	
	// Getters
	public String GetNombre() { // Obtiene el nombre del jugador
		return this.nombre;
	}
	
	public int GetVidas() { // Obtiene el número de vidas restantes
		return this.vidas;
	}
	
	// Métodos
	public void RestarVida() { // Resta una vida de jugador, cuando se pierde una ronda
		this.vidas = this.vidas - 1;
	}
	
	public void IngresarNombre() { // Ingresa el nombre de usuario
		Scanner ingresoNombre = new Scanner(System.in); // Crea un objeto de Scanner
		System.out.print("Ingresar nombre: ");
		this.nombre = ingresoNombre.nextLine();
	}
}
