package test;

import java.util.Arrays;

import modelo.ArregloUnidimensional;

public class ArregloUnidimensionalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 = {1,3,5,2,8,2};
		ArregloUnidimensional vector = new ArregloUnidimensional(a1);
		
		System.out.println("Ordenado ascendente: ");
		System.out.println(Arrays.toString(vector.ordenarAscendente()));
		System.out.println("Ordenado descendente: ");
		System.out.println(Arrays.toString(vector.ordenarDescendente()));
		System.out.println("Menor: ");
		System.out.println(vector.traerlElMenor());
		System.out.println("Mayor: ");
		System.out.println(vector.traerlElMayor());
		System.out.println("Promedio: ");
		System.out.println(vector.calcularPromedio());
		System.out.println("Frecuencia: ");
		System.out.println(vector.traerFrecuencia(1));
		System.out.println("Moda: ");
		System.out.println(vector.traerModa());
	}
	

}
