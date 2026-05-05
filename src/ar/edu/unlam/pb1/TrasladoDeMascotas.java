package ar.edu.unlam.pb1;

public class TrasladoDeMascotas {

	private static final int CANTIDAD_DESTINOS = 10;
	private static final int CANTIDAD_VIAJES = 100;
	@SuppressWarnings("unused")
	private String nombre;
	private double costoKm;
	private double costoMinimo;
	private Destino[] destinos;
	private Viaje[] viajes;

	public TrasladoDeMascotas(String nombre, double costoKm, double costoMinimo) {
		this.nombre = nombre;
		this.costoKm = costoKm;
		this.costoMinimo = costoMinimo;
		this.destinos = new Destino[CANTIDAD_DESTINOS];
		this.viajes = new Viaje[CANTIDAD_VIAJES];

	}

	public boolean existeDestino(Destino destinoParaAgregar) {
		boolean existe = false;
		int posicion = 0;
		while (!existe && posicion < destinos.length) {
			if (destinos[posicion] == null) {
				posicion++;
			} else if (destinos[posicion].equals(destinoParaAgregar)) {
				existe = true;
			} else {
				posicion++;
			}

		}
		return existe;
	}

	public boolean agregarDestino(Destino destinoParaAgregar) {
		boolean agregado = false;
		int posicion = 0;
		while (!agregado && posicion < destinos.length) {
			if (destinos[posicion] == null) {
				destinos[posicion] = destinoParaAgregar;
				agregado = true;
			} else {
				posicion++;
			}
		}
		return agregado;
	}

	public Destino[] ordenarDestinos() {
		Destino auxiliar = null;

		for (int i = 0; i < destinos.length; i++) {
			for (int j = 0; j < destinos.length - i - 1; j++) {

				if (destinos[j] != null && destinos[j + 1] != null) {
					if (destinos[j].getCodigo() > destinos[j + 1].getCodigo()) {
						auxiliar = destinos[j];
						destinos[j] = destinos[j + 1];
						destinos[j + 1] = auxiliar;
					}
				}

			}
		}
		return destinos;
	}

	public boolean eliminarDestino(int codigoParaEliminar) {
		boolean destinoEliminado = false;
		int posicion = 0;
		while (!destinoEliminado && posicion < destinos.length) {
			if (destinos[posicion].getCodigo() == codigoParaEliminar) {
				destinos[posicion] = null;
				destinoEliminado = true;
			} else {
				posicion++;
			}
		}
		return destinoEliminado;
	}

	public Destino[] getDestinos() {
		return destinos;
	}

	public Destino seleccionarDestinoPorCodigo(int codigo) {
		Destino destinoSeleccionado = null;
		boolean encontrado = false;
		int posicion = 0;
		while (!encontrado && posicion < destinos.length) {
			if (destinos[posicion].getCodigo() == codigo) {
				destinoSeleccionado = destinos[posicion];
				encontrado = true;
			} else {
				posicion++;
			}
		}

		return destinoSeleccionado;
	}

	public boolean agregarViaje(Viaje viajeNuevo) {
		boolean agregado = false;
		int posicion = 0;
		while (!agregado && posicion < viajes.length) {
			if (viajes[posicion] == null) {
				viajes[posicion] = viajeNuevo;
				agregado = true;
			} else {
				posicion++;
			}
		}
		return agregado;
	}

	public double calcularPrecioBruto(Destino destinoCalcular) {
		double precioBruto = costoMinimo + (costoKm * destinoCalcular.getDistanciaKm());
		return precioBruto;

	}

}
