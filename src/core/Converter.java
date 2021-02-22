package core;
import java.io.*;

public class Converter {
	String[] input;
	String output;
	
	//Función inicializadora
	public void initializer(String s) {
		input=new String[s.length()];
		for(int i=0; i<input.length; i++) {
			input[i]=String.valueOf(s.charAt(i));
		}
	}
	
	//Inicia cadena de funciones de cálculo
	public void DecToBin (String s){ //Decimal a Binario
		/* Pasos de conversión
		 * 
		 * 1. Dividir el número entre 2
		 * 2. Obtener el cociente entero para la siguiente iteración
		 * 3. Obtener el residuo del dígito binario
		 * 4. Repetir los pasos hasta que el cociente sea igual a 0
		 */
		
		int dtbInput=Integer.parseInt(s);
		String dtbOutput=new String();
		
		do {
			dtbInput=dtbInput/2;
			System.out.println(dtbInput);
			dtbOutput=dtbOutput.concat(String.valueOf(dtbInput%2));
		} while(dtbInput/2!=0);
	}
	
	public void DecToOct () {
		
	}
	
	public String[] getInput() {
		return input;
	}
	
	public String getOutput(){
		return output;
	}
}
