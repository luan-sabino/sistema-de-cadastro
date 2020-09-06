package controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import componente.Departamento;
import persistencia.Constantes;
import persistencia.DataBase;
import servidor.Efetivo;
import servidor.Funcionario;
import servidor.Substituto;
import servidor.Tecnico;
@SuppressWarnings({"resource"})
public class DataCare extends Constantes {
	
	public DataBase db = DataBase.getDataBase();
	
	public void salvaDados() throws IOException {
		
		FileOutputStream arquivoDaGravacao = new FileOutputStream("DataBase.dat");
		ObjectOutputStream objDaGravacao = new ObjectOutputStream(arquivoDaGravacao);
		
		objDaGravacao.writeObject(db);
		objDaGravacao.flush();
		objDaGravacao.close();
		arquivoDaGravacao.flush();
		arquivoDaGravacao.close();
	}
	
	public void lerDados() throws IOException, ClassNotFoundException{
		
		
		
		FileInputStream arquivoDaLeitura = new FileInputStream("DataBase.dat");
		ObjectInputStream objDaLeitura = new ObjectInputStream(arquivoDaLeitura);
		
		DataBase.setDataBase((DataBase) objDaLeitura.readObject());
		
		objDaLeitura.close();
		arquivoDaLeitura.close();
		
	}
	//###################################################################
	protected int getLinhasFromTxt(String nomeArquivo) throws IOException {
		Scanner sc = new Scanner(new File (nomeArquivo));
		int linhas = 0;
		while(sc.hasNextLine()) {
			linhas++;
			sc.nextLine();
		}
		sc.close();
		return linhas;
	}

	private Departamento geraDepartamentoByTxt(int pulaLinha) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("departamentoData.txt"))
				.useDelimiter(";");
		
		if(pulaLinha == 0) {}
		else {
			for(int i = 1; i <= pulaLinha; i++) {
				sc.nextLine();
			}
		}
		
		String nome = sc.next();		
		String codigo = sc.next();
		
		Departamento d = new Departamento(nome, codigo);
		sc.close();
		return d;
		
		
		
	}

	public void setArrayDeDepartamentosByTxt(ArrayList<Departamento> departamentos) throws IOException {
		int numeroLinhas = getLinhasFromTxt("departamentoData.txt");
		for(int i = 0; i < numeroLinhas; i++) {
			departamentos.add(geraDepartamentoByTxt(i));
		}
	}
	
	public void preencheDB() throws IOException {
		setArrayDeDepartamentosByTxt(getDepartamentosArray());
	}
	
	//###################################################################
	
	public void criaFuncionario(String nome, String codigo, String nivel, String funcao,
								Departamento d) {
		Tecnico t = new Tecnico(nome,codigo,nivel,funcao);
		d.getArrayDeTecnico().add(t);
		d.addSalarioFuncAoGastoDoDep(t.salario);
	}
	public void criaFuncionario(String nome, String codigo, String nivel, String titulacao, 
								String area, Departamento d) {
		Efetivo e = new Efetivo(nome,codigo,nivel,titulacao,area);
		d.getArrayDeEfetivo().add(e);
		d.addSalarioFuncAoGastoDoDep(e.salario);
	}
	public void criaFuncionario(String nome, String codigo, String nivel, String titulacao, 
								int cargaHoraria, Departamento d) {
		Substituto s = new Substituto(nome,codigo,nivel,titulacao,cargaHoraria);
		d.getArrayDeSubstituto().add(s);
		d.addSalarioFuncAoGastoDoDep(s.salario);
	}

	public Departamento getDepartamentosByIndex(int i) {
		return db.departamentos.get(i);
	}

	public ArrayList<Departamento> getDepartamentosArray() {
		return db.departamentos;
	}

	public Departamento getDepartamentoByCode(String codigoDepartamento) {
		for(int i = 0; i < getDepartamentosArray().size(); i++) {
			if(codigoDepartamento.equals(getDepartamentosByIndex(i).getCodigo())) {
				return getDepartamentosByIndex(i);
			}
		}
		return null;
	}
	
	public Departamento getDepartamentoByNome(String nome) {
		for(int i = 0; i < getDepartamentosArray().size(); i++) {
			if(nome.equals(getDepartamentosByIndex(i).getNome())) {
				return getDepartamentosByIndex(i);
			}
		}
		return null;
	}
	
	public Object getFuncionarioByNameOrCode(String nomeOuCodigo) {
		if(getEfetivoByNameOrCode(nomeOuCodigo) != null) return getEfetivoByNameOrCode(nomeOuCodigo);
			else if(getSubstitutoByNameOrCode(nomeOuCodigo) != null) return getSubstitutoByNameOrCode(nomeOuCodigo);
				else if(getTecnicoByNameOrCode(nomeOuCodigo) != null) return getTecnicoByNameOrCode(nomeOuCodigo);
					else return null;
	}
	
	public Object getEfetivoByNameOrCode(String nomeOuCodigo) {
		for(int i = 0; i < getDepartamentosArray().size(); i++) {
			for(int j = 0; j < getDepartamentosByIndex(i).getArrayDeEfetivo().size(); j++) {
				String nome = getDepartamentosByIndex(i).getArrayDeEfetivo().get(j).nome;
				String codigo = getDepartamentosByIndex(i).getArrayDeEfetivo().get(j).codigo;
				if(nomeOuCodigo.equals(nome) || nomeOuCodigo.equals(codigo)) {
					return getDepartamentosByIndex(i).getArrayDeEfetivo().get(j);
				}
			}
		}
		return null;
	}
	
	public Object getSubstitutoByNameOrCode(String nomeOuCodigo) {
		for(int i = 0; i < getDepartamentosArray().size(); i++) {
			for(int j = 0; j < getDepartamentosByIndex(i).getArrayDeSubstituto().size(); j++) {
				String nome = getDepartamentosByIndex(i).getArrayDeSubstituto().get(j).nome;
				String codigo = getDepartamentosByIndex(i).getArrayDeSubstituto().get(j).codigo;
				if(nomeOuCodigo.equals(nome) || nomeOuCodigo.equals(codigo)) {
					return getDepartamentosByIndex(i).getArrayDeSubstituto().get(j);
				}
			}
		}
		return null;
	}
	
	public Object getTecnicoByNameOrCode(String nomeOuCodigo) {
		for(int i = 0; i < getDepartamentosArray().size(); i++) {
			for(int j = 0; j < getDepartamentosByIndex(i).getArrayDeTecnico().size(); j++) {
				String nome = getDepartamentosByIndex(i).getArrayDeTecnico().get(j).nome;
				String codigo = getDepartamentosByIndex(i).getArrayDeTecnico().get(j).codigo;
				if(nomeOuCodigo.equals(nome) || nomeOuCodigo.equals(codigo)) {
					return getDepartamentosByIndex(i).getArrayDeTecnico().get(j);
				}
			}
		}
		return null;
	}

	public double getGastoTotal() {
		
		double gastoTotal = 0;
		for(int i = 0; i < getDepartamentosArray().size(); i++) {
			gastoTotal += getDepartamentosByIndex(i).getGasto();
		}
		return gastoTotal;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Funcionario> getFuncionarioByFaixaSalarial(double faixaMin, double faixaMax) {
		ArrayList<Funcionario> holder = new ArrayList<Funcionario>();
		for(int i = 0; i < getDepartamentosArray().size(); i++) {
			holder.addAll(getDepartamentosByIndex(i).concatTodosFuncionarios());
		}
		ArrayList<Funcionario> holderEscolhidos = new ArrayList<Funcionario>();
		for(int i  = 0; i < holder.size(); i++) {
			if(holder.get(i).salario >= faixaMin && holder.get(i).salario <= faixaMax)
				holderEscolhidos.add(holder.get(i));
		}
		return holderEscolhidos;
	}
	
}
