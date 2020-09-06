package servidor;


import java.io.Serializable;


public abstract class Docente extends Funcionario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -515043679349567200L;

	public Docente(String nome, String codigo, String nivel, String titulacao) {
		super(nome, codigo, nivel);
		this.titulacao = titulacao;
	}
	
	public String titulacao;
	
	abstract double calcularSalario();
	
}
