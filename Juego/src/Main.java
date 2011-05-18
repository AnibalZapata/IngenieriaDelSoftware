import java.io.IOException;

import JuegoSabioNecio.Juego;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
			Juego juego = new Juego();
			juego.tableroDeCaracteres();
			juego.tableroLleno();
			juego.triangulo();
			juego.colocarLaPosicionDelEspacioLibreEnElTablero();
			juego.pedirJugada();
			
		

	}

}
