package model;

public class EnvioUrbano extends Envio {
	private String zona;

	

	public EnvioUrbano(int codigo, String destinatario, double importeBase, String zona) {
		super(codigo, destinatario, importeBase);
		this.zona = zona;
	}



	@Override
	public double importeFinal() {
		// TODO Auto-generated method stub
	if(	 zona.equalsIgnoreCase("CABA")){return importeBase+1000;}
	else{return importeBase+2000;}
	}



	@Override
	public String toString() {
		return "EnvioUrbano [zona=" + zona + ", codigo=" + codigo + ", destinatario=" + destinatario + ", importeBase="
				+ importeBase + ", importe Final: " + importeFinal() + "]";
	}
	
	
	
	
	

}
