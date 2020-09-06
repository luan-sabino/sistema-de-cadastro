package servidor;

import java.io.Serializable;

import persistencia.Constantes;


public class Substituto extends Docente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -648712109096187933L;

	public Substituto(String nome, String codigo, String nivel, String titulacao, int cargaHoraria) {
		super(nome, codigo, nivel, titulacao);
		this.cargaHoraria = cargaHoraria;
		this.salario = calcularSalario();
	}
	
	public Substituto() {
		super(null, null, null, null);
	}

	public int cargaHoraria;
	
	public double calcularSalario() {
		return this.salario = 1500 + ( 1500 * (Constantes.Percentual(this.nivel)/100.0)); 
	}

}
