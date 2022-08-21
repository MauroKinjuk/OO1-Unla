package numeros;

public class Numero {

	private int n;
	
public Numero(int n) {
	this.n = n;
}

	//Set y get
	public int getNumber() {
		return n;
	}
	
	public void setNumber(int n) {
		this.n = n;
	}
	
	public int sumar(int n1) {
		int suma = n + n1;
		return suma;
	}
	
	public int multiplicar(int n1) {
		return n*n1;
	}
	
	public Boolean esPar() {
		int resultado = (n%2);
		if (resultado == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean esPrimo() {
		//Si se puede dividir por 2 no es primo
		if (n % 2 == 0) {
			return false;
		}else{
			for (int i = 3; i*i<= n; i+=2) {
				if (n%2 == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public String convertirAString() {
		String resultado = "El numero a string es: " + String.valueOf(n);
		return resultado;
	}
	
	public double convertirADouble() {
		double resultado = Double.valueOf(n);
		return resultado;
	}
	
	
	public double calcularPotencia(int exp) {
		double resultado = Math.pow(n,exp);
		return resultado;
	}
	
	public int calcularFactorial() {
		int resultado = 1;
		if (n==0 || n<0) {
			resultado = 1;
		}else {
			for (int i=1; i <= n; i++) {
				resultado = resultado*i;
			}
		}
		return resultado;
	}
	
	
}	
