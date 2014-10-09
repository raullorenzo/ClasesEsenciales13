package edu.upc.eetac.dsa.rlorenzo.Ejercicio13;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {

		Socket s;
		BufferedReader b;

		String host = "localhost";
		int port = 4444;
		String respuesta;

		try {

			// Creo una conexion al socket servidor
			s = new Socket(host, port);

			// Creo las referencias al canal de escritura y lectura del socket
			b = new BufferedReader(new InputStreamReader(s.getInputStream()));

			// Espero la respuesta por el canal de lectura
			respuesta = b.readLine();
			System.out.println(respuesta);

			b.close();
			s.close();

		} catch (UnknownHostException e) {
			System.out.println("No puedo conectarme a " + host + ":" + port);
		} catch (IOException e) {
			System.out.println("Error de E/S en " + host + ":" + port);
		}
	}
}