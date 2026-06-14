package model;

public class EnvioExpress extends  Envio {
	private int kilometro;

	public EnvioExpress(int codigo, String destinatario, double importeBase, int kilometro) {
		super(codigo, destinatario, importeBase);
		this.kilometro = kilometro;
	}

	@Override
	public double importeFinal() {
		// TODO Auto-generated method stub
		return importeBase+(kilometro*500);
	}

	@Override
	public String toString() {
		return "EnvioExpress [kilometro=" + kilometro + ", codigo=" + codigo + ", destinatario=" + destinatario
				+ ", importeBase=" + importeBase + ", importe final=" + importeFinal() + "]";
	}

}
