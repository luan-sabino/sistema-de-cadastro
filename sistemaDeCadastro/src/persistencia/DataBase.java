package persistencia;

import java.io.Serializable;
import java.util.ArrayList;

import componente.Departamento;
import servidor.Docente;
import servidor.Efetivo;
import servidor.Funcionario;
import servidor.Substituto;
import servidor.Tecnico;
@SuppressWarnings({ "unchecked", "rawtypes" })
public class DataBase implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3099659464227016421L;
	
	public ArrayList<Departamento> departamentos = new ArrayList<>();
	private static DataBase instance = null;
	
	private DataBase(){
	}
	
	public static DataBase getDataBase() {
		/*if(instance == null) {
			instance = new DataBase(); //Retirar o comentario para resetar a DB
		}*/
		return instance;
	}
	
	public static void setDataBase(DataBase obj) {
		instance = obj;
	}
	
	public ArrayList<Funcionario> getTodosFuncionarios() {
		ArrayList holder = new ArrayList<>(); 
		for(int i = 0; i < departamentos.size(); i++) {
			holder.addAll(departamentos.get(i).concatTodosFuncionarios());	
		}
		return holder;			
	}
	
	public ArrayList<Docente> getTodosDocentes() {
		ArrayList holder = new ArrayList<>(); 
		for(int i = 0; i < departamentos.size(); i++) {
			holder.addAll(departamentos.get(i).getArrayDeEfetivo());	
			holder.addAll(departamentos.get(i).getArrayDeSubstituto());	
		}
		return holder;			
	}
	
	public ArrayList<Substituto> getTodosSubstitutos() {
		ArrayList holder = new ArrayList<>(); 
		for(int i = 0; i < departamentos.size(); i++) {	
			holder.addAll(departamentos.get(i).getArrayDeSubstituto());	
		}
		return holder;			
	}
	
	public ArrayList<Efetivo> getTodosEfetivos() {
		ArrayList holder = new ArrayList<>(); 
		for(int i = 0; i < departamentos.size(); i++) {
			holder.addAll(departamentos.get(i).getArrayDeEfetivo());	
		}
		return holder;			
	}
	
	public ArrayList<Tecnico> getTodosTecnicos() {
		ArrayList holder = new ArrayList<>(); 
		for(int i = 0; i < departamentos.size(); i++) {
			holder.addAll(departamentos.get(i).getArrayDeTecnico());	
		}
		return holder;			
	}
	
	public ArrayList<Departamento> getArrayDepartamento() {
		return departamentos;
	}

	
	
	

}
