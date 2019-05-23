package presentation;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import sn.fall.metier.Serveur;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Serveur serveur= new Serveur();
		/*for(int i=0;i<1500;i++) {
		try {
			Socket socket= new Socket("localhost",i);
			System.out.println("port disponible "+i);
			
		}catch (UnknownHostException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		catch (IOException e) {
			
		}
		}*/
	}

}
