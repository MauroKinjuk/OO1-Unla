
import numeros.Numero;

public class test {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Numero n1 = new Numero(5);
		
		System.out.println(n1.sumar(1));
		System.out.println(n1.multiplicar(1));
		System.out.println(n1.esPar());
		System.out.println(n1.esPrimo());
		System.out.println(n1.convertirAString());
		System.out.println(n1.convertirADouble());
		System.out.println(n1.calcularPotencia(2));
		System.out.println(n1.calcularFactorial());
	}

}
