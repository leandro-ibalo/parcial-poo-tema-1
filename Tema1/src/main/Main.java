package main;

import java.util.Map;
import java.util.Scanner;

import model.Envio;
import repository.LecturaArchivo;
import service.EnvioService;
import service.EnvioServiceImpl;

public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		LecturaArchivo lectura=new LecturaArchivo();
		Map<Integer,Envio>listaM=lectura.lecturaArchivo("envios.txt");
		EnvioService servicio=new EnvioServiceImpl(listaM);
		String opcion="";
		do {
			System.out.println();
			System.out.println("");
			System.out.println("1. mostrar todos los envios");
			System.out.println("2. buscar envio");
			System.out.println("3. calcular recaudacion total");
			System.out.println("4. envio de mayor costo final");
			System.out.println("5. total de envios express");
			System.out.println("6. envios superiores a 15000");
			System.out.println("7. promedio de costo final de los envios Urbanos");
			System.out.println("8. lista de los destinatarios de envios express");
			System.out.println("9. todos los ids ordenados segun el costo final");
			System.out.println();
			System.out.println("ingresar opcion: ");
			opcion=scanner.nextLine();
			System.out.println();
			
			switch(opcion) {
			case "1":servicio.mostrarTodosLosEnvios();break;
			case "2":System.out.println("ingrese el codigo: ");
			String input=scanner.nextLine();
			try {
				int codigo=Integer.parseInt(input);
				servicio.buscarEnvio(codigo);;
				
			
			}catch(NumberFormatException e) {System.out.println(); System.out.println("error");}
			break;
			
			case "3":servicio.recaudacionTotal();break;
			case"4":servicio.envioDeMayorCostoFinal();break;
			case"5":servicio.mostrarEnnviosExpress();break;
			case"6":servicio.enviosCostoFinalMayorA(15000);break;
			case"7":servicio.promedioCostoFinalEnvioUrbano();break;
			case"8":servicio.listaEnviosExpress();break;
			case"9":servicio.ordenEnvios();break;
			case"0":System.out.println("adeu dadeu");break;
			default:System.out.println("error");
		}
}while(!opcion.equals("0"));
scanner.close();
	}
}
