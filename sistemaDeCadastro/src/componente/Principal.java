package componente;

import java.io.FileNotFoundException;
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
		uni = new Universidade();
		try {
			dc.lerDados();
		} catch(FileNotFoundException e) {
			uni.dc.preencheDB();
		};
		
				
		
		Constantes consta = new Constantes();
			
		
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