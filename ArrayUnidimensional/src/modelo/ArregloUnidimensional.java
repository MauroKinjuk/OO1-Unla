package modelo;

import java.util.Arrays;

public class ArregloUnidimensional {
	int[] vector;

	public ArregloUnidimensional(int[] vector) {
		this.vector = vector;
	}

	public int[] getVector() {
		return vector;
	}

	public void setVector(int[] vector) {
		this.vector = vector;
	}

	// Metodos

	public int traerlElMenor() {
		int aux = vector[0];
		for (int i = 0; i < vector.length; i++) {
			if (aux > vector[i]) {
				aux = vector[i];
			}
		}
		return aux;
	}

	public int traerlElMayor() {
		int aux = vector[0];
		for (int i = 0; i < vector.length; i++) {
			if (aux < vector[i]) {
				aux = vector[i];
			}
		}
		return aux;
	}

	public double calcularPromedio() {
		double aux = 0;
		for (int i = 0; i < vector.length; i++) {
			aux += vector[i];
		}
		return (aux / vector.length);
	}

	public int[] ordenarAscendente() {
		int i, j, aux;
		for (i = 0; i < vector.length - 1; i++) {
			for (j = 0; j < vector.length - 1; j++) {
				// Si numero actual > numero siguiente, entonces
				if (vector[j] > vector[j + 1]) {
					aux = vector[j];
					vector[j] = vector[j + 1];
					vector[j + 1] = aux;
				}
			}

		}
		return vector;
	}

	public int[] ordenarDescendente() {
		int i, j, aux;
		for (i = 0; i < vector.length - 1; i++) {
			for (j = 0; j < vector.length - 1; j++) {
				// Si numero actual < numero siguiente, entonces
				if (vector[j] < vector[j + 1]) {
					aux = vector[j];
					vector[j] = vector[j + 1];
					vector[j + 1] = aux;
				}
			}

		}
		return vector;
	}

	public int traerFrecuencia(int numero) {
		int aux = 0;
		for(int i = 0; i < vector.length; i++) {
			if(vector[i] == numero) {
				aux++;
			}
		}
		return aux;
	}
	
	public int traerModa() {
		int aux = 0;
		int aux2 = 0;
		
		for (int i = 0; i < vector.length; i++) {
			if(vector[i] > aux) {
				aux = traerFrecuencia(vector[i]);
				aux2 = vector[i];
			}
		}
		return aux2;
		
	}
}
