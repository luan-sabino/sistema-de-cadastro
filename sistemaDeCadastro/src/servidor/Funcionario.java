package servidor;

import java.io.Serializable;


public abstract class Funcionario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4518054318272266664L;
	
	public String nome;
	public String codigo;
	public String nivel;
	public double salario;
	
	public Funcionario(String nome, String codigo, String nivel) {
		this.nome = nome;
		this.codigo = codigo;
		this.nivel = nivel;
		}
	
	abstract double calcularSalario();
	

}
