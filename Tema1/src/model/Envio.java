package model;

public abstract class Envio {
	protected int codigo;
	protected String destinatario;
	protected double importeBase;
	
	
	public Envio(int codigo, String destinatario, double importeBase) {
		super();
		this.codigo = codigo;
		this.destinatario = destinatario;
		this.importeBase = importeBase;
	}


	public abstract double importeFinal();


	public int getCodigo() {
		return codigo;
	}


	public String getDestinatario() {
		return destinatario;
	}


	public double getImporteBase() {
		return importeBase;
	}
	
}