package componente;

import controladores.DataCare;
import persistencia.DataBase;

public class Universidade {
	
	private static final String nome = "ULSP";
	DataBase db = DataBase.getDataBase();
	public DataCare dc = new DataCare();
	
	public Universidade() {
		
	}
	
	//########SETTS
	
	//########GETTS
	public String getNome() {
		return nome;
	}
	
	//#######OTHERS

	

}
