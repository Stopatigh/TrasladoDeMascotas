package ar.edu.unlam.pb1;

public class Destino {
	
	private String nombre;
	private int codigo;
	private double distanciaKm;
	
	public Destino (String nombre, int codigo, double distanciaKm) {
		this.nombre=nombre;
		this.codigo=codigo;
		this.distanciaKm=distanciaKm;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getDistanciaKm() {
		return distanciaKm;
	}

	public void setDistanciaKm(double distanciaKm) {
		this.distanciaKm = distanciaKm;
	}

	@Override
	public String toString() {
		return "[Nombre = " + nombre + ", codigo = " + codigo + ", distanciaKm = " + distanciaKm + "]";
	} 
	

}
