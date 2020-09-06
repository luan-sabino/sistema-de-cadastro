package servidor;

import java.io.Serializable;

import persistencia.Constantes;


public class Efetivo extends Docente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 717961034856958645L;

	public Efetivo(String nome, String codigo, String nivel, String titulacao, String area) {
		super(nome, codigo, nivel, titulacao);
		this.area = area;
		this.salario = calcularSalario();
	}
	
	public Efetivo() {
		super(null, null, null, null);
	}

	public String area;
	
	public double calcularSalario() {
		return this.salario = 2000 + ( 2000 * (Constantes.Percentual(this.nivel)/100.0)) + (2000 * 0.05); 
	}
	
}
