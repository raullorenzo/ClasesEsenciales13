package edu.upc.eetac.dsa.rlorenzo.Ejercicio13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorConcurrente {

	public static void main(String[] args) throws IOException {

		ServerSocket s; // Socket servidor
		Socket sc; // Socket cliente
		BufferedReader b; // Canal de Lectura

		try {
			// Creo el socket server

			s = new ServerSocket(4444);
			System.out.println("Esperando conexi�n");

			while (true) {

				final PrintStream p; // Canal de escritura
				// Invoco el metodo accept del socket servidor, me devuelve una
				// referencia al socket cliente

				sc = s.accept();

				// Obtengo una referencia a los canales de escritura y lectura
				// del socket cliente

				p = new PrintStream(sc.getOutputStream());

				Runnable r = new Runnable() {

					public void run() {
						String mensaje;
						Date now = new Date();
						SimpleDateFormat fecha = new SimpleDateFormat(
								"dd/MM/yyyy HH:mm:ss");
						mensaje = fecha.format(now);

						System.out.println(mensaje);

						// Escribo en canal de escritura el mismo mensaje
						// recibido
						p.println(mensaje);

					}

				};
				new Thread(r).start();
			}
		} catch (IOException e) {

			System.out.println("No puedo crear el socket");

		}
	}

}