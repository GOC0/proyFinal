import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Arista {

	 private char origen;
	    private char destino;
	    private int peso;
	    private int tiempo;

	   
	    public Arista(char origen, char destino, int peso, int tiempo) {
			super();
			this.origen = origen;
			this.destino = destino;
			this.peso = peso;
			this.tiempo = tiempo;
		}

		public char getOrigen() {
	        return origen;
	    }

	    public char getDestino() {
	        return destino;
	    }

	    public int getPeso() {
	        return peso;
	    }
		@Override
		public String toString() {
	        return origen + " - " + destino + " : " + peso;
	    }
		public int getTiempo() {
			return tiempo;
		}
}
