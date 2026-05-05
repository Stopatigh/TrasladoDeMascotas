package ar.edu.unlam.pb1;

import java.util.Scanner;

public class Interfaz {

	private static Scanner teclado = new Scanner(System.in);
	private static final int AGREGAR_DESTINO = 1, MOSTRAR_DESTINOS = 2, ELIMINAR_DESTINO = 3, AGREGAR_VIAJE = 4,
			MOSTRAR_VIAJE = 5, SALIR = 9;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nombreEmpresa = "Traslados Unlam";
		double costoKm = 20;
		double costoMinimo = 200;

		TrasladoDeMascotas trasladosUnlam = new TrasladoDeMascotas(nombreEmpresa, costoKm, costoMinimo);

		int opcion = 0;

		do {
			mostrarMenu();
			opcion = teclado.nextInt();

			switch (opcion) {
			case AGREGAR_DESTINO:
				agregarDestino(trasladosUnlam);
				break;
			case MOSTRAR_DESTINOS:
				mostrarDestinos(trasladosUnlam);
				break;
			case ELIMINAR_DESTINO:
				eliminarDestino(trasladosUnlam);
				break;
			case AGREGAR_VIAJE:
				agregarViaje(trasladosUnlam);
				break;
			case MOSTRAR_VIAJE:

				break;
			case SALIR:
				System.out.print("Gracias vuelvas prontos");
				break;
			default:
				System.out.println("Opcion invalida, elija una opcion valida");
			}

		} while (opcion != SALIR);

	}

	private static void agregarDestino(TrasladoDeMascotas trasladosUnlam) {
		System.out.println("Agregar destino");
		System.out.println("Ingrese el nombre del destino");
		String nombreDestino = teclado.next();
		System.out.println("Ingrese el codigo del destino");
		int codigoDestino = teclado.nextInt();
		System.out.println("Ingrese la distancia en kilometros");
		double distanciaKm = teclado.nextDouble();

		Destino nuevoDestino = new Destino(nombreDestino, codigoDestino, distanciaKm);
		if (trasladosUnlam.existeDestino(nuevoDestino)) {
			System.out.println("El destino ya existe en el sistema");
		}else if(trasladosUnlam.agregarDestino(nuevoDestino)) {
			System.out.println("Destino agregado con exito");
		}else {
			System.out.println("No se pudo agregar el destino");
		}
		
		
	}

	public static void mostrarMenu() {
		System.out.println(AGREGAR_DESTINO + "- Agregar un destino");
		System.out.println(MOSTRAR_DESTINOS + "- Mostrar un destino");
		System.out.println(ELIMINAR_DESTINO + "- Eliminar un destino");
		System.out.println(AGREGAR_VIAJE + "- Agregar un viaje");
		System.out.println(MOSTRAR_VIAJE + "- Agregar un viaje");
		System.out.println(SALIR + "- 1"
				+ "Salir");
	}

	private static void mostrarDestinos(TrasladoDeMascotas trasladosUnlam) {
		Destino destinos[] = trasladosUnlam.ordenarDestinos();
		int contador = 0;
		for (int i = 0; i < destinos.length; i++) {
			if (destinos[i] != null) {
				System.out.println(++contador + " - " + destinos[i]);
			}

		}
	}

	private static void eliminarDestino(TrasladoDeMascotas trasladosUnlam) {
		System.out.println("Ingrese el codigo de destino que desea eliminar");
		int codigo = teclado.nextInt();
		if(trasladosUnlam.eliminarDestino(codigo)) {
			System.out.println("Destino eliminado con exito");
		}else {
			System.out.println("No se pudo eliminar el destino");
		}
	}
	private static void agregarViaje(TrasladoDeMascotas trasladosUnlam) {
		System.out.println("Agregar viaje");
		System.out.println("Ingrese el nombre de la mascota");
		String nombreMascota = teclado.next();
		System.out.println("Seleccione un destino ingresando su codigo: ");
		mostrarDestinos(trasladosUnlam);
		int codigoSeleccionado=teclado.nextInt();
		Destino destinoSeleccionado= trasladosUnlam.seleccionarDestinoPorCodigo(codigoSeleccionado);
		System.out.println("Ingrese el porcentaje de descuento (0 a 100)");
		int porcentajeDescuento=teclado.nextInt();
		double precioBruto= trasladosUnlam.calcularPrecioBruto(destinoSeleccionado);
		Viaje nuevoViaje = new Viaje (destinoSeleccionado, nombreMascota, porcentajeDescuento, precioBruto );
		if (trasladosUnlam.agregarViaje(nuevoViaje)) {
			System.out.println("Viaje agregado con exito");
		}else {
			System.out.println("No se pudo agregar el viaje");
		}
	}

}
