package sn.fall.metier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Serveur extends Thread{
	private ServerSocket serveur;
	private BufferedReader fromClient;
	private PrintStream toClient;
	private Socket client;
	Scanner scan= new Scanner(System.in);
	
	public Serveur() {
		try {
			serveur= new ServerSocket(631);
			System.out.println("serveur demarre");
			this.start();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		
	}

	@Override
	public void run() {
		try {
			client=serveur.accept();
			toClient=new PrintStream(client.getOutputStream());
			fromClient= new BufferedReader(new InputStreamReader(client.getInputStream()));
			while(true) {
				String message=fromClient.readLine();
				if(message.equalsIgnoreCase("quit")) {
					break;
				}
				System.out.println("Message du client : "+message);
				System.out.println("Message du serveur");
				toClient.println(scan.nextLine());
			}
			client.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
