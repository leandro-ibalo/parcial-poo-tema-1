package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.Envio;
import model.EnvioExpress;
import model.EnvioUrbano;

public class LecturaArchivo {
	public Map<Integer,Envio>lecturaArchivo(String ruta){
		Map<Integer,Envio>lista=new HashMap<>();
		
		try(BufferedReader br=new BufferedReader(new FileReader(ruta))){
			String linea;
			boolean primera=true;
			while((linea=br.readLine())!=null) {
				if(linea.trim().isEmpty())continue;
				if(primera) {primera=false;continue;}
				String[]p=linea.split("\\|");
				String tipo=p[0].trim();
				int codigo;
				try {codigo=Integer.parseInt(p[1].trim());}
				catch(NumberFormatException e) {System.out.println("error: "+e);continue;}
				if (lista.containsKey(codigo)) {
					System.out.println("el codigo: "+codigo+"está repetido");
					continue;
				}
				if(tipo.equalsIgnoreCase("E")&&p.length==5){
					String destinatario=p[2].trim();
					double importeBase=Double.parseDouble(p[3].trim());
					int kilometro=Integer.parseInt(p[4].trim());
					lista.put(codigo,new EnvioExpress(codigo, destinatario, importeBase, kilometro));
				}else if(tipo.equalsIgnoreCase("U")&&p.length==5) {
					String detinatario=p[2].trim();
					double importeBase=Double.parseDouble(p[3].trim());
					String zona=p[4].trim();
					lista.put(codigo,new EnvioUrbano(codigo, detinatario, importeBase, zona));
				}else {System.out.println("error"+"en el codigo"+codigo);
				}
			}
		}
				catch(IOException e) {System.out.println("error al leer el archviio"+ e);}
				catch(NumberFormatException e) {System.out.println("error "+e);}
		return lista;
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		
		
	}

