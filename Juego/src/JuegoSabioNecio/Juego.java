package JuegoSabioNecio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Juego {
	
	private int [] tablero;
	private char [] tableroCaracteres;
	private int contador;
	BufferedReader entradaPosicion;
	private int posicionInicialFicha;
	private int posicionFinalFicha;
	 
		
	public Juego(){
		this.tablero = new int [15];
		this.tableroCaracteres = new char [15];
		this.contador = 2;
		this.entradaPosicion = new BufferedReader(new InputStreamReader(System.in));
	    this.posicionInicialFicha = 0;
		this.posicionFinalFicha = 0;
		
	}	
		
	/**
	 * Funcion: Llena el tablero con las posiciones de cada ficha
	 */
	public void tableroDeCaracteres(){
		for(int i = 0 ; i < this.tableroCaracteres.length ; i ++)
		{
			this.tableroCaracteres[i] = 'H';
		}
	}
	
	public boolean tableroLleno(){
		boolean respuesta = true;
		
		for(int i = 0 ; i < 15 ; i ++){
			this.tablero[i] = (i + 1);
		}
		return respuesta;
	}
	
	/**
	 * Funcion: Verifica si el tablero del juego se encuntra vacio
	 * @return Devuelve true si el tablero esta vacio
	 */
	public boolean tableroVacio() {
		
		boolean respuesta = true;
		
		for(int i= 0 ; i < this.tablero.length ; i ++){
			if(this.tablero[i] != 0){
				respuesta = false;
			}
		}
		return respuesta;
	}

	/**
	 * Funcion: Verifica si el tablero del juego esta lleno
	 * @param espacioLibre: Indica la posicion del espacio libre en el tablero del juego
	 * @param marca: Toma el valor de '0' cuando se indica el espacio libre
	 */
	public void marcarEspacioLibre(int espacioLibre, int marca) {
		// TODO Auto-generated method stub
		this.tablero[espacioLibre] = marca;
	}

	/**
	 * Funcion: Verifica una casilla del tablero si esta ocupada
	 * @param posicionTablero
	 * @return booelan
	 */
	public boolean EstaOcuapdo(int posicionTablero) {
			return (this.tablero[posicionTablero] != 0);
	}

	/**
	 * Funcion: Verifica si el espacio libre del tablero es valido
	 * @param rangoEspacioLibre
	 * @return Devuelve si true si el espacio es valido
	 */
	public boolean VerificaRangoDelEspacioLibre(int rangoEspacioLibre) {
		boolean  repuesta = false;
		if(rangoEspacioLibre < 16){
			repuesta = true;
		}
		return repuesta;
	}


	public void marcarCasilla(int casilla, int marca) {
		// TODO Auto-generated method stub
		this.tablero[casilla] = marca;
		
	}


	public boolean casillaValida(int posicionTablero) {
		// TODO Auto-generated method stub
		boolean respuesta = false;
		if(posicionTablero > 0 && posicionTablero <= this.tablero.length){
			respuesta = true;
		}
		return respuesta;
	}


	public boolean casillaValidarCarracteres(char posicionTablero) {

		boolean respuesta = false;

			if(((int)posicionTablero >= 97  && (int)posicionTablero <= 122) || ((int)posicionTablero >= 65 && (int)posicionTablero <= 90)){
				respuesta = true;
			}
    
		return respuesta;
	}
	

	public void imprimirTableroPosiciones(int tablero[],int posicionInicio,int posicionFin) {
		for (int i = posicionInicio ; i <= posicionFin ; i++){
			System.out.print(this.tablero[i] +" "+ " "+" "+" ");
		}
		System.out.print("\n"+"\n");
	}
	
	public void imprimirTableroCaracteres(char tableroCaracteres[],int posicionInicio,int posicionFin) {
		for (int i = posicionInicio ; i <= posicionFin ; i++){
			//System.out.print((char)this.tableroCaracteres[i] +" "+ " "+" "+" ");
			System.out.print(this.tableroCaracteres[i] +" "+ " "+" "+" ");
		}
		System.out.print("\n"+"\n");
	}
	
	public void imprimirEspacioBlanco(){
		for(int i = 0 ; i < contador ; i++){
	            System.out.print(" ");
	        }
	}
	
	public void triangulo(){
				
		this.imprimirTableroCaracteres(this.tableroCaracteres,0,4);
		this.imprimirTableroPosiciones(this.tablero,0, 4);
		this.imprimirEspacioBlanco();
		
		this.imprimirTableroCaracteres(this.tableroCaracteres, 5, 8);
		this.imprimirEspacioBlanco();
		this.imprimirTableroPosiciones(this.tablero, 5, 8);
		this.contador = this.contador + 2;
		
		this.imprimirEspacioBlanco();
		System.out.print(" ");
		this.imprimirTableroCaracteres(this.tableroCaracteres, 9, 11);
		this.imprimirEspacioBlanco();
				
		this.imprimirTableroPosiciones(this.tablero, 9, 11);
		this.contador++;
		
		this.imprimirEspacioBlanco();
		System.out.print(" ");
		System.out.print(" ");
		this.imprimirTableroCaracteres(this.tableroCaracteres, 12, 13);
		this.imprimirEspacioBlanco();
		System.out.print(" ");
		
		this.imprimirTableroPosiciones(tablero, 12, 13);
		this.contador = this.contador + 3;
		this.imprimirEspacioBlanco();
		System.out.print(" ");
		System.out.print(" ");
		
		this.imprimirTableroCaracteres(this.tableroCaracteres, 14, 14);
		this.imprimirEspacioBlanco();
		System.out.print(" ");
		this.imprimirTableroPosiciones(this.tablero, 14, 14);
		this.contador = 2;
		
	}
	
	public void colocarLaPosicionDelEspacioLibreEnElTablero() throws IOException{
		
		System.out.print("Ingrese un valor entre 1 a 15 donde quieres que este el espacio [VACIO]: ");
		try {
		     int exponente = Integer.parseInt(entradaPosicion.readLine());
		     if( exponente >= 1 && exponente <= 15 ) {
		       this.tableroCaracteres[exponente - 1] = 'O';
		       System.out.println("\n" + "Este es el triangulo: " + "\n");
		       triangulo();
		     }
		     else{
			   System.out.println("pon un valor entre 1 y 15 ");
			   this.colocarLaPosicionDelEspacioLibreEnElTablero();
		     }
		     //Capturamos la excepcion si no ingresa un numero
		} catch(NumberFormatException e){ 
			
			System.out.println("Exitio un error para corrregirlo por favor pon un numero entre el 1 -15");
			this.colocarLaPosicionDelEspacioLibreEnElTablero();
			System.out.print(this.tableroCaracteres[4]);
		    }
		
		}
	
	public void valorInicialDeLaFicha() throws IOException {
		try {
			System.out.print("Por favor ingresa el [VALOR INICIAL]: ");
		     int parametro = Integer.parseInt(this.entradaPosicion.readLine());
		     if(parametro >= 1 && parametro <= 15){
		          this.posicionInicialFicha = parametro;
		     }
		     else{
		    	 System.out.println("Debe ingresar un valor entre 1 a 15");
		    	 this.valorInicialDeLaFicha();
		     }
		} catch(NumberFormatException e) {
			
			System.out.println("Por favor ingresa el valor numerico");
			this.valorInicialDeLaFicha();
		}
	}
	
	public void valorFinalDeLaFicha() throws IOException {
		try {
			System.out.print("Por favor ingresa el [VALOR INICIAL]: ");
		     int parametro = Integer.parseInt(this.entradaPosicion.readLine());
		     if(parametro>=1 && parametro <=15){
		          this.posicionFinalFicha = parametro;
		     }
		     else{
		    	 System.out.println("Debe ingresar un valor entre 1 a 15");
		    	 this.valorFinalDeLaFicha();
		    	 
		     }
		} catch(NumberFormatException e) {
			
			System.out.print("Por favor ingresa el valor numerico: ");
			this.valorFinalDeLaFicha();
		}
	}
	
	public void verificarJugada()throws IOException{
		if(this.tableroCaracteres[this.posicionFinalFicha - 1] == '_'){
			System.out.println("a comer"+this.tableroCaracteres[this.posicionFinalFicha - 1]);
			this.validarJugada();
		}
		else{
			System.out.println("no se puede ejecutar el movimiento" );
			
			this.valorInicialDeLaFicha();
			this.valorFinalDeLaFicha();
		}
	}
	
	public void metodoRealizaJugada(int inicio,int medio,int fin) throws IOException{
		this.tableroCaracteres[inicio] = '_';
		this.tableroCaracteres[medio] = this.tableroCaracteres[fin];
		this.tableroCaracteres[fin] = '_';
		triangulo();
		pedirJugada();
		
	}
	
	public void validarJugada() throws IOException{
		switch (this.posicionInicialFicha){
			case 1:
				if(this.posicionFinalFicha == 3){
					metodoRealizaJugada(1,2,0);
				}
					
				else if(this.posicionFinalFicha == 10){
					
					metodoRealizaJugada(5,9,0);
				
				}
			case 2:
				if(this.posicionFinalFicha==4){
					metodoRealizaJugada(2,3,1);
					
				}
					
				else if(this.posicionFinalFicha == 11){
					metodoRealizaJugada(6,10,1);
								
				}
			case 3: 
				if(this.posicionFinalFicha==1){
					metodoRealizaJugada(1,0,2);					
				}
					
				else if(this.posicionFinalFicha == 5){
					metodoRealizaJugada(3,4,2);	
								
				}
				else if(this.posicionFinalFicha == 10){
					metodoRealizaJugada(6,9,2);
					
				}
				else if(this.posicionFinalFicha == 12){
					metodoRealizaJugada(7,11,2);			
				}
			case 4:
				if(this.posicionFinalFicha==2){
					metodoRealizaJugada(2,1,3);					
				}
					
				else if(this.posicionFinalFicha == 11){
					metodoRealizaJugada(7,10,3);	
								
				}
			case 5:
				if(this.posicionFinalFicha==3){
					metodoRealizaJugada(3,2,4);					
				}
					
				else if(this.posicionFinalFicha == 12){
					metodoRealizaJugada(8,11,4);	
								
				}
			case 6:
				if(this.posicionFinalFicha==8){
					metodoRealizaJugada(6,7,5);					
				}
					
				else if(this.posicionFinalFicha == 13){
					metodoRealizaJugada(9,12,5);	
								
				}
			case 7:
				if(this.posicionFinalFicha==9){
					metodoRealizaJugada(7,8,6);					
				}
					
				else if(this.posicionFinalFicha == 14){
					metodoRealizaJugada(10,13,6);	
								
				}
			case 8:
				if(this.posicionFinalFicha==6){
					metodoRealizaJugada(6,5,7);					
				}
					
				else if(this.posicionFinalFicha == 13){
					metodoRealizaJugada(10,12,7);	
								
				}
				
			case 9:
				if(this.posicionFinalFicha==7){
					metodoRealizaJugada(7,6,8);					
				}
					
				else if(this.posicionFinalFicha == 14){
					metodoRealizaJugada(11,13,8);	
								
				}
			case 10:
				if(this.posicionFinalFicha==1){
					metodoRealizaJugada(5,0,9);					
				}
					
				else if(this.posicionFinalFicha == 3){
					metodoRealizaJugada(6,2,9);	
								
				}
				else if(this.posicionFinalFicha == 12){
					metodoRealizaJugada(10,11,9);
					
				}
				else if(this.posicionFinalFicha == 15){
					metodoRealizaJugada(12,14,9);			
				}
			case 11:
				if(this.posicionFinalFicha==2){
					metodoRealizaJugada(6,1,10);					
				}
					
				else if(this.posicionFinalFicha == 4){
					metodoRealizaJugada(7,3,10);	
								
				}
			case 12:
				if(this.posicionFinalFicha==3){
					metodoRealizaJugada(7,2,11);					
				}
					
				else if(this.posicionFinalFicha == 5){
					metodoRealizaJugada(8,4,11);	
								
				}
				else if(this.posicionFinalFicha == 10){
					metodoRealizaJugada(10,9,11);
					
				}
				else if(this.posicionFinalFicha == 15){
					metodoRealizaJugada(13,14,11);			
				}
			case 13:
				if(this.posicionFinalFicha==6){
					metodoRealizaJugada(9,5,12);					
				}
					
				else if(this.posicionFinalFicha == 8){
					metodoRealizaJugada(10,7,12);	
								
				}
			case 14:
				if(this.posicionFinalFicha==7){
					metodoRealizaJugada(10,6,13);					
				}
					
				else if(this.posicionFinalFicha == 9){
					metodoRealizaJugada(11,8,13);	
								
				}
			case 15:
				if(this.posicionFinalFicha==10){
					metodoRealizaJugada(12,9,14);					
				}
					
				else if(this.posicionFinalFicha == 12){
					metodoRealizaJugada(13,11,14);	
								
				}
			
		}
	}
	
	public void pedirJugada() throws IOException {
		this.valorInicialDeLaFicha();
		this.valorFinalDeLaFicha();
		this.verificarJugada();
	}
		
		

}
