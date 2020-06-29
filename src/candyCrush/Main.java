package candyCrush;
import candyCrush.*;

public class Main {

	public static void main(String[] args) {
		// System.out.println("Yehehey ¿pero qué pasa chavales?¿todo bien, todo correcto? y yo que me alegro.");
		Usuario usuario = new Usuario();
		
		usuario.IngresarNombre();
		
		System.out.println("Nombre = " + usuario.GetNombre());
		System.out.println("Vidas = " + usuario.GetVidas());
		
		/*String[][] tablero = new String[9][9];
		tablero = rellenaTablero();
		
		pintaTablero(tablero);*/
	}

/*	static String[][] rellenaTablero()
	{
		String[][] tableroLleno = new String[9][9];
		
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				Caramelo caramelo;
				
				if(i / 2 == 0)
				{
					caramelo = new Caramelo("Pica", "A");
				}
				else
				{
					 caramelo = new Caramelo("Joya", "B");
				}
				
				tableroLleno[i][j] = caramelo.GetSimbolo();
			}
		}
		
		return tableroLleno;
	}
	
	static void pintaTablero(String[][] tableroParaPintar)
	{
		for(int i = 0; i < 9; i++)
		{
			if(i == 0)
			{
				System.out.print("  1 2 3 4 5 6 7 8 9");
			}
			
			System.out.println();
			
			for(int j = 0; j < 9; j++)
			{
				if(j == 0)
				{
					System.out.print(i + 1 + " ");
				}
				
				System.out.print(tableroParaPintar[i][j] + " ");
			}
		}
	}
*/
}
