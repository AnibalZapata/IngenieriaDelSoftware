import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import JuegoSabioNecio.Juego;



public class JuegoText {
	
	Juego juego;
	
	
	@Before
	public void setup(){
		juego = new Juego();
	}
	
	@Test
	public void CuandoCreoUnJuegoElTableroDeberiaEstarVacio(){
		assertTrue(juego.tableroVacio());
	}
	
	@Test
	public void CuandoMarcoElEspacioLibreDebeEstarEnElRangoValido(){
		int rangoEspacioLibre = 15;
		assertTrue(this.juego.VerificaRangoDelEspacioLibre(rangoEspacioLibre));
	}
	
	@Test
	public void CuandoMarcoElEspacionLibreDeberiaEstarOcupado(){
		this.juego.marcarCasilla(0,0);
		assertFalse(juego.EstaOcuapdo(0));
	}
	
	@Test
	public void CuandoSeMarcaElEspacioLibreEnElTableroDebeExitirElEspacioLibre(){
		this.juego.tableroLleno();
		this.juego.marcarEspacioLibre(14,0);
		assertFalse(juego.EstaOcuapdo(14));
	}
	
	
	@Test
	public void CuandoMarcoPorLoMenosUnaCasillaDelTableroEsteTableroNoDeberiaEstarVacio(){
		this.juego.marcarCasilla(14,0);
		assertTrue(this.juego.tableroVacio());
		
	}

	@Test
	public void CuandoMarcoTodasLasCasillasElTableroDeberiaEstarLleno(){
		
		this.juego.marcarCasilla(0, 'B');
		this.juego.marcarCasilla(1, 'R');
		this.juego.marcarCasilla(2, 'B');
		this.juego.marcarCasilla(3, 'R');
		this.juego.marcarCasilla(4, 'A');
		this.juego.marcarCasilla(5, 'R');
		this.juego.marcarCasilla(6, 'B');
		this.juego.marcarCasilla(7, 'A');
		this.juego.marcarCasilla(8, 'A');
		this.juego.marcarCasilla(9, 'B');
		this.juego.marcarCasilla(10, 'R');
		this.juego.marcarCasilla(11, 'A');
		this.juego.marcarCasilla(12, 'R');
		this.juego.marcarCasilla(13, 'B');
		this.juego.marcarCasilla(0, 'A');
			
		assertTrue(this.juego.tableroLleno());

	}
	
	@Test
	public void CuandoMarcoUnaCasillaDelTableroDeberiaEstarOcupado(){
		this.juego.marcarCasilla(4, 1);
		assertTrue(this.juego.EstaOcuapdo(4));
	}
	
	@Test
	public void CuandoNoSeMarcaUnaCasillaDelTableroNoDeberiaEstarOcupado(){
		this.juego.marcarCasilla(0, 1);
		this.juego.marcarCasilla(1, 2);
		assertFalse(this.juego.EstaOcuapdo(2));
	}
	
	@Test
	public void CuandoMarcoUnaCasillaLaPosicionDebeEstarEnElRangoDelTablero(){
		int posicionTablero = 15;
		assertTrue(this.juego.casillaValida(posicionTablero));
	}
	
	
	@Test
	public void VerificarPosicionDeCasillasNoValidaDentroElTablero(){
		int posicionTablero = 20;
		assertFalse(this.juego.casillaValida(posicionTablero));
	}
	

	@Test
	public void CuandoLaPosicionDelTableroElValorIngresadoDebeSerUnNumero(){
		char posicionTablero = 'z';
		assertTrue(this.juego.casillaValidarCarracteres(posicionTablero));
	}
	
	/*@Test
	public void CuandoSeInicialElJuegoDeberiaDibujarUnTableroVacio(){
		assertEquals("Deberia dibujar un tablero  con todas las posiciones de las casillas",this.juego.dibujarTablero());
	}*/
		
}


