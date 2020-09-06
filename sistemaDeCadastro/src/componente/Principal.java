package componente;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import controladores.DataCare;
import persistencia.Constantes;
import scuUI.PrincipalUI;

public class Principal{
	
	public static Universidade uni;
	
	static DataCare dc = new DataCare();

	@SuppressWarnings({"unused" })
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		dc.lerDados();
		
				
		uni = new Universidade();
		Constantes consta = new Constantes();
		//uni.dc.preencheDB(); //USE PARA RESETAR, É NECESSARIO RETIRAR O COMENTARIO NA CLASSE DataBase	
		
		PrincipalUI.main(args);
		
		int delay = 5000;
		int interval = 10000;
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			public void run() {
				try {
					dc.salvaDados();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}, delay, interval);
		
		
		
		
		
		
	
		

	}

}