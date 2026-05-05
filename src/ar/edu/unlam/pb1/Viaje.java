package ar.edu.unlam.pb1;

public class Viaje {
	
	private Destino destino;
	private String nombreMascota;
	private int porcentajeDescuento;
	private double precioBruto;
	private double precioNeto;
	
	public Viaje (Destino destino, String nombreMascota, int porcentajeDescuento, double precioBruto) {
		this.destino=destino;
		this.nombreMascota=nombreMascota;
		this.porcentajeDescuento=porcentajeDescuento;
		this.precioBruto=precioBruto;
		this.precioNeto= precioBruto - (precioBruto * (porcentajeDescuento / 100));
		
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public int getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(int porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public double getPrecioBruto() {
		return precioBruto;
	}

	public void setPrecioBruto(double precioBruto) {
		this.precioBruto = precioBruto;
	}

	public double getPrecioNeto() {
		return precioNeto;
	}

	public void setPrecioNeto(double precioNeto) {
		this.precioNeto = precioNeto;
	}
	
	
	
	

}
