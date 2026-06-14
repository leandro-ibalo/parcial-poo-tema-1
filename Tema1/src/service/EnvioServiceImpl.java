package service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Envio;
import model.EnvioExpress;
import model.EnvioUrbano;

public class EnvioServiceImpl implements EnvioService{
	private Map<Integer,Envio>listaMap;
	public EnvioServiceImpl(Map<Integer,Envio>listaMap){this.listaMap=(listaMap!=null)?listaMap:new HashMap<>();}
	@Override
	public void mostrarTodosLosEnvios() {
		if(listaMap.isEmpty()) {System.out.println("la lista está vacia");return;}
		listaMap.values().stream().forEach(System.out::println);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void buscarEnvio(int codigo) {
	Envio b=listaMap.get(codigo);
		if(b!=null) {System.out.println("envio encontrado:"+ b);return;}
		else {System.out.println("no se encontro el envio");}		// TODO Auto-generated method stub
		
	}
	@Override
	public void recaudacionTotal() {
		double total=listaMap.values().stream()
				.mapToDouble(Envio::importeFinal)
				.sum();
		System.out.println("la recaudacion total es de: "+total);// TODO Auto-generated method stub
		
	}
	@Override
	public void envioDeMayorCostoFinal() {
		listaMap.values().stream()
		.max(Comparator.comparingDouble(Envio::importeFinal))
		.ifPresentOrElse
		(e->System.out.println(e),
		()->System.out.println("error no hay nada"));
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mostrarEnnviosExpress() {
		if(listaMap.isEmpty()) {System.out.println("la lista está vacia");return;}
		long cantidad=listaMap.values().stream()
				.filter(e->e instanceof EnvioExpress)
				.count();
	System.out.println("la cantidad de envios express es de: "+cantidad);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enviosCostoFinalMayorA(double x) {
		if(listaMap.isEmpty()) {System.out.println("la lista está vacia");return;}

		listaMap.values().stream()
		.filter(e->e.importeFinal()>x)
		.forEach(System.out::println);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void promedioCostoFinalEnvioUrbano() {
		if(listaMap.isEmpty()) {System.out.println("la lista está vacia");return;}

	double promedio=	listaMap.values().stream()
				.filter(e->e instanceof EnvioUrbano)
				.mapToDouble(Envio::importeFinal)
				.average()
				.orElse(0);
	System.out.println("el promedio es de: "+promedio);
	}
		// TODO Auto-generated method stub
		
	
	@Override
	public void listaEnviosExpress() {
		if(listaMap.isEmpty()) {System.out.println("la lista está vacia");return;}

		List<String>lista=listaMap.values().stream()
				.filter(e->e instanceof EnvioExpress)
				.map(Envio::getDestinatario)
				.collect(Collectors.toList());
		System.out.println(lista);
	}
	@Override
	public void ordenEnvios() {
		if(listaMap.isEmpty()) {System.out.println("la lista está vacia");return;}

	    List<Integer> orden = listaMap.values().stream()
	            .sorted(Comparator.comparingDouble(Envio::importeFinal).reversed())
	            .map(Envio::getCodigo)
	            .collect(Collectors.toList());
	    System.out.println(orden);
	}
	
	
}
