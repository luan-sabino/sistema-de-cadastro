package componente;

import java.io.Serializable;
import java.util.ArrayList;
import servidor.Efetivo;
import servidor.Funcionario;
import servidor.Substituto;
import servidor.Tecnico;

@SuppressWarnings({"rawtypes","unchecked"})
public class Departamento implements Serializable {
	
	private static final long serialVersionUID = 7981058245839144343L;
	
	
	public Departamento() {
	}
	
	
	public Departamento(String nome, String codigo) {
		setNome(nome);
		setCodigo(codigo);
	}
	
	private String nome;
	private String codigo;
	private double gasto = 0;
	
	private ArrayList<Substituto> substitutos = new ArrayList<>();
	private ArrayList<Tecnico> tecnicos = new ArrayList<>();
	private ArrayList<Efetivo> efetivos = new ArrayList<>();
	
	
	//#######SETTS
	private void setNome(String nome) {
		this.nome = nome;
	}
	
	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	//#########GETTS
	public String getNome(){
		return this.nome;
	}
	
	public String getCodigo() {
		return this.codigo;
	}

	public double getGasto() {
		return this.gasto;
	}
	
	private ArrayList getArrayDeFuncionarios(ArrayList f) {
		ArrayList<Funcionario> f2 = (ArrayList<Funcionario>) f;
		f = f2;
		return f;
	}
	
	public ArrayList<Tecnico> getArrayDeTecnico() {
		return this.tecnicos;
	}

	public ArrayList<Efetivo> getArrayDeEfetivo() {
		return this.efetivos;
	}
	
	public ArrayList<Substituto> getArrayDeSubstituto() {
		return this.substitutos;
	}
	
	public Tecnico getTecnicoByIndex(int index) {
		return this.tecnicos.get(index);
	}
	
	public Efetivo getEfetivoByIndex(int index) {
		return this.efetivos.get(index);
	}
	
	public Substituto getSubstitutoByIndex(int index) {
		return this.substitutos.get(index);
	}
	
	
	//#########OTHERS
	public ArrayList concatTodosFuncionarios() {
		ArrayList todosFuncionarios = new ArrayList<>();
		todosFuncionarios.addAll(getArrayDeFuncionarios(substitutos));
		todosFuncionarios.addAll(getArrayDeFuncionarios(tecnicos));
		todosFuncionarios.addAll(getArrayDeFuncionarios(efetivos));
		return todosFuncionarios;
	}
	
	public void addSalarioFuncAoGastoDoDep(double salario) {
		gasto+=salario;
	}
	
	
	
}
