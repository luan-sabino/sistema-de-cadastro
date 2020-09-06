package servidor;

import java.io.Serializable;

import persistencia.Constantes;


public class Tecnico extends Funcionario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2180699313588639326L;


	public Tecnico(String nome, String codigo, String nivel, String funcao) {
		super(nome, codigo, nivel);
		this.funcao = funcao;
		calcularSalario();
	}
	


	public Tecnico() {
		super(null,null,null);
		// TODO Auto-generated constructor stub
	}



	public String funcao;
	
	
	double calcularSalario() {
		return this.salario = 1000 + ( 1000 * (Constantes.Percentual(this.nivel)/100.0)); 
	}

}
