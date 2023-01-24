package ejercicios;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EjerciciosMejorados {

	private static void ejercicio2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime un número entero: ");
		int num = sc.nextInt();

		if (num % 10 == 0) {
			System.out.println("Tú número es múltiplo de 10");
		} else {
			System.out.println("Tú número no es múltiplo de 10");
		}
	}

	private static void ejercicio3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Escribe una letra");
		char letra = sc.nextLine().charAt(0);
		if (letra >= 'A' && letra <= 'Z') { // tiene que ir con comillas simples
			System.out.println("Es una letra mayúscula");
		} else {
			System.out.println("No es una letra mayúscula");
		}
	}

	private static void ejercicio4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe dos palabras: ");
		String cadena1 = sc.nextLine();
		String cadena2 = sc.nextLine();
		if (cadena1.equals(cadena2)) {
			System.out.println("Las palabras son iguales");
		} else {
			System.out.println("Las palabras son diferentes");
		}

	}

	private static void ejercicio5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa dos números");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		if (num2 != 0) {
			System.out.println(num1 + "/" + num2 + " = " + (num1 / num2));
		} else {
			System.out.println("El divisor no puede ser cero");
		}
	}

	private static void ejercicio9() { //java17
		// MEJORADO
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese un número de mes: ");
		int mes = sc.nextInt();
		if (mes >= 1 && mes <= 12) {
			switch (mes) {
			case 1, 3, 5, 7, 8, 10, 12: // SWITCH IMPROVED
				System.out.println("El mes tiene 31 días");
				break;
			case 4, 6, 9, 11:
				System.out.println("El mes tiene 30 días");
				break;
			case 2:
				System.out.println("El mes tiene 28 días");
				break;
			}
		} else {
			System.out.println("El número de mes no es correcto");
		}
		sc.close();

	}

	private static void ejercicio10() {
		// diferente, hecho con otros condicionales

		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe un carácter: ");
		char caracter = sc.next().charAt(0);

		if (caracter == '.' || caracter == ',' || caracter == ';' || caracter == ':') {
			System.out.println("Es un signo de puntuacion");
		} else if (Character.isDigit(caracter)) { // NEW toma en cuenta del 0 al 9 en cualquier idioma
			System.out.println("Es un numero del 0 al 9");
		} else {
			System.out.println("Has ingresado otro tipo de caracter");
		}
		sc.close();
	}

	private static void ejercicio11() {
		Scanner sc = new Scanner(System.in);
		int operacion = -1;

		System.out.println("Ingresa dos números para hacer una operación:");
		System.out.println("Numero 1 : ");
		int num1 = sc.nextInt();
		System.out.println("Numero 2 : ");
		int num2 = sc.nextInt();

		while (operacion != 5) { // volvemos a pedir el menu para seguir haciendo operaciones
			System.out.println("Elige una operación:");
			System.out.println("1- Sumar");
			System.out.println("2- Restar");
			System.out.println("3- Dividir");
			System.out.println("4- Multiplicar");
			System.out.println("5- Salir");
			operacion = sc.nextInt();
			switch (operacion) {
			case 1:
				System.out.println(num1 + num2);
				break;
			case 2:
				System.out.println(num1 - num2);
				break;
			case 3:
				if (num2 != 0) {
					System.out.println(num1 / num2);
				} else {
					System.out.println("El divisor no puede ser cero");
				}
				break;
			case 4:
				System.out.println(num1 * num2);
				break;
			case 5:
				System.out.println("Gracias por utilizar la calculadora");
			default:
				System.out.println("Opción no válida. Vuelva a elegir opción.\n");
				break;
			}

		}
		sc.close();

	}

	private static void ejercicio12() {
		Scanner sc = new Scanner(System.in);
		double precio = 50;
		System.out.println("Dime tu edad para comprobar el precio de la entrada:");
		int edad = sc.nextInt();
		sc.nextLine();
		double descuento = 0;
		String socio = "no";

		if (edad < 18) {
			descuento = 0.25;
			precio = precio * (1 - descuento);

		} else if (edad > 18 && edad <= 65) {
			System.out.println("Es usted socio del club?: ");
			socio = sc.nextLine();
			if (socio.toLowerCase().equals("si")) {
				descuento = 0.40;
				precio = precio * (1 - descuento);
			}
		} else if (edad >= 65) {
			descuento = 0.75;
			precio = precio * (1 - descuento);

		}
		System.out.println("El precio de su entrada es de: " + "€" + precio);
		System.out.println("Se le ha aplicado un descuento del : " + (descuento * 100) + "%");

	}
	
	private static void ejercicio12b() {
		Scanner sc = new Scanner(System.in);
		double precio = 50;
		final double MENOR_EDAD = 0.25;
		final double SOCIO = 0.40;
		final double MAYOR_65 = 0.75;
		System.out.println("Dime tu edad para comprobar el precio de la entrada:");
		int edad = sc.nextInt();
		sc.nextLine(); //DESP de coger numeros por pantalla limpiamos el buffer
		
		if (edad<18) {
			precio = precio * ( 1- MENOR_EDAD);
		} else if (edad > 18 && edad <= 65 ) {
			System.out.println("Es usted socio ? (si/no)");
			String socio = sc.nextLine();
			if (socio.equalsIgnoreCase("si") || socio.equalsIgnoreCase("sí") || socio.equalsIgnoreCase("s")) {
				precio = precio * (1- SOCIO);
			}
		} else {
			precio = precio * ( 1- MAYOR_65);
		}
		System.out.println("El precio de su entrada es de : " + precio + "€");
		
		sc.close();
	}
	
	private static void ejercicio12Pattern() {
		//EXPRESIONES REGULARES CON PATTERN
		Scanner sc = new Scanner(System.in);
		double precio = 50;
		final double MENOR_EDAD = 0.25;
		final double SOCIO = 0.40;
		final double MAYOR_65 = 0.75;
		System.out.println("Dime tu edad para comprobar el precio de la entrada:");
		int edad = sc.nextInt();
		sc.nextLine(); //DESP de coger numeros por pantalla limpiamos el buffer
		
		if (edad<18) {
			precio = precio * ( 1- MENOR_EDAD);
		} else if (edad > 18 && edad <= 65 ) {
			System.out.println("Es usted socio ? (si/no)");
			String socio = sc.nextLine();
			//SOLUCIÓN CON EXPRESIÓN REGULAR 
			Pattern regex = Pattern.compile("^s[iíÍ]?$", Pattern.CASE_INSENSITIVE);			
			Matcher m = regex.matcher(socio);
			if (m.matches()) {
				precio = precio * (1-SOCIO);
			}
		} else {
			precio = precio * ( 1- MAYOR_65);
		}
		System.out.println("El precio de su entrada es de : " + precio + "€");
		
		sc.close();
	}
	
	private static void ejercicio12GrupoFor() {
        Scanner sc = new Scanner(System.in);
        final double PRECIO_ENTRADA = 50;
        final double MENOR_EDAD = 0.25;
        final double SOCIO = 0.40;
        final double MAYOR_65 = 0.75;
        double precioTotal = 0;
        double precioEntrada = PRECIO_ENTRADA;
        
        System.out.println("Cuantas personas vienen en grupo?");
        int numeroDePersonas = sc.nextInt();
        sc.nextLine();
       
        
        for (int i = 1; i <= numeroDePersonas; i++) {
            System.out.println("Dime la edad de la persona " + i + ":");
            int edad = sc.nextInt();
            sc.nextLine();
            precioEntrada = PRECIO_ENTRADA;
            
            if (edad < 18) {
                precioEntrada = PRECIO_ENTRADA * (1 - MENOR_EDAD);
            } else if (edad >= 18 && edad <= 65) {
                System.out.println("Es usted socio ? (si/no)");
                String socio = sc.nextLine();
                //SOLUCIÓN CON EXPRESIÓN REGULAR 
                Pattern regex = Pattern.compile("^s[iíÍ]?$", Pattern.CASE_INSENSITIVE);
                Matcher m = regex.matcher(socio);
                if (m.matches()) {
                    precioEntrada = PRECIO_ENTRADA * (1 - SOCIO);
                }
            } else {
                precioEntrada = PRECIO_ENTRADA * (1 - MAYOR_65);
            }
            precioTotal += precioEntrada;
        }
        System.out.println("El precio total de las entradas para el grupo es de: " + precioTotal + "€");
    }

	public static void ejercicio12GrupoWhile() {
		 Scanner sc = new Scanner(System.in);
		 	final double PRECIO_ENTRADA = 50;
	        final double MENOR_EDAD = 0.25;
	        final double SOCIO = 0.40;
	        final double MAYOR_65 = 0.75;
	        double precioTotal = 0;
	        double precioEntrada = PRECIO_ENTRADA;
	        
	        System.out.println("Cuantas personas vienen en grupo?");
	        int numeroDePersonas = sc.nextInt();
	        sc.nextLine();
	        
	        int i = 1;
	        while (i <= numeroDePersonas) {
	            System.out.println("Dime la edad de la persona " + i + ":");
	            int edad = sc.nextInt();
	            sc.nextLine();
	            precioEntrada = PRECIO_ENTRADA;
	            
	            if (edad <= 18) {
	                precioEntrada = PRECIO_ENTRADA * (1 - MENOR_EDAD);
	            } else if (edad > 18 && edad <= 65) {
	                System.out.println("Es usted socio ? (si/no)");
	                String socio = sc.nextLine();
	                //SOLUCIÓN CON EXPRESIÓN REGULAR 
	                Pattern regex = Pattern.compile("^s[iíÍ]?$", Pattern.CASE_INSENSITIVE);
	                Matcher m = regex.matcher(socio);
	                if (m.matches()) {
	                    precioEntrada = PRECIO_ENTRADA * (1 - SOCIO);
	                }
	            } else {
	                precioEntrada = PRECIO_ENTRADA * (1 - MAYOR_65);
	            }
	            precioTotal += precioEntrada;
	            i++;
	        }
	        System.out.println("El precio total de las entradas para el grupo es de: " + precioTotal + "€");
	        sc.close();
	}
	public static void ejemploDado() {

	}

	public static void main(String[] args) {
		ejercicio12GrupoFor();

	}

}
