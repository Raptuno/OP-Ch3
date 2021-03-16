package core;

import java.util.Arrays;
import java.util.Collections;

public class Converter {
	String[] output;
	
	//Funci�n inicializadora para la conversi�n a binario
	public int bitCalc(String s) { //M�todo para calcular tama�o de bits
		int bci=Integer.parseInt(s);
		return (int)(Math.log(bci)/Math.log(2)+1);
	}
	
	//Inicia cadena de funciones de c�lculo
	public void DecToBin (String s){ //Decimal a Binario
		/* Pasos de conversión
		 * 
		 * 1. Dividir el número entre 2
		 * 2. Obtener el cociente entero para la siguiente iteración
		 * 3. Obtener el residuo del dígito binario
		 * 4. Repetir los pasos hasta que el cociente sea igual a 0
		 */
		
		output=new String[bitCalc(s)];
		int dtbInput=Integer.parseInt(s);
		
		for(int i=0; i<output.length; i++) {
			output[i]=String.valueOf(dtbInput%2);
			dtbInput=dtbInput/2;
		}
		Collections.reverse(Arrays.asList(output));
	}
	
	public void DecToOct (String s) { //Decimal a Octal
		/* Pasos para la conversión
		 * 
		 * Nota: Todos los números menores que o iguales a 7 se mantienen iguales
		 * 
		 * Paso 1: Si el número es mayor a 7
		 * 
		 */
		
		int input=Integer.parseInt(s); 
	}
	
	public String getOutput(){
		String opt=new String();
		for (int i=0; i<output.length; i++) {
			opt=opt.concat(output[i]);
		}
		return opt;
	}
}
