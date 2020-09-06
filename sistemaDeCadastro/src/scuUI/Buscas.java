package scuUI;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import componente.Departamento;
import controladores.DataCare;
import servidor.Efetivo;
import servidor.Substituto;
import servidor.Tecnico;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Buscas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 112220274701075181L;
	/**
	 * Create the panel.
	 */
	DataCare dc = new DataCare();
	private JTextField textFuncNomeOuCodigo;
	BuscaDepartamento bD = new BuscaDepartamento();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Buscas() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Seleciona um departamento, ou indique seu codigo, para exibir suas informa\u00E7\u00F5es");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, this);
		add(lblNewLabel);
		
		JComboBox<Departamento> boxDepartamento = new JComboBox<Departamento>();
		boxDepartamento.setEditable(true);
		springLayout.putConstraint(SpringLayout.NORTH, boxDepartamento, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, boxDepartamento, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, boxDepartamento, 28, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, boxDepartamento, 266, SpringLayout.WEST, this);
		DefaultComboBoxModel dml = new DefaultComboBoxModel();
		for(int i = 0; i < dc.getDepartamentosArray().size(); i++) {
			dml.addElement(dc.getDepartamentosByIndex(i).getNome());
		}
		boxDepartamento.setModel(dml);
		boxDepartamento.setSelectedIndex(-1);
		add(boxDepartamento);
		boxDepartamento.validate();
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Departamento holder = null;
					String dep = boxDepartamento.getSelectedItem().toString();
					holder = dc.getDepartamentoByCode(dep);
					if(holder != null) {
						TabelaFuncionariosDepartamento.setTableDataDocEfe(holder);
						TabelaFuncionariosDepartamento.setTableDataDocSub(holder);
						TabelaFuncionariosDepartamento.setTableDataTec(holder);
						bD.setDataTxt(dc.getDepartamentoByCode(dep));
						bD.setVisible(true);
					}else if(dc.getDepartamentoByNome(boxDepartamento.getSelectedItem().toString()) == null){
						JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum departamento com esse codigo");
					}else {
						Departamento holder_2 = dc.getDepartamentoByNome(boxDepartamento.getSelectedItem().toString());
						for(int i = 0; i < dc.getDepartamentosArray().size(); i++) {
							if(holder_2.getNome() == dc.getDepartamentosByIndex(i).getNome()) {
								TabelaFuncionariosDepartamento.setTableDataDocEfe(holder_2);
								TabelaFuncionariosDepartamento.setTableDataDocSub(holder_2);
								TabelaFuncionariosDepartamento.setTableDataTec(holder_2);
								bD.setDataTxt(holder_2);
								bD.setVisible(true);
							}	
						}
					} 
				}catch(NullPointerException ev)
				{JOptionPane.showMessageDialog(null, "Para fazer uma busca é necessario inserir algo, tente novamente.");};
			}	
			
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnSelecionar, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, btnSelecionar, 0, SpringLayout.EAST, lblNewLabel);
		add(btnSelecionar);
		
		JLabel lblNewLabel_1 = new JLabel("Busque um funcionario atraves de seu Nome ou Codigo");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 16, SpringLayout.SOUTH, boxDepartamento);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		add(lblNewLabel_1);
		
		textFuncNomeOuCodigo = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFuncNomeOuCodigo, 6, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, textFuncNomeOuCodigo, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, textFuncNomeOuCodigo, 0, SpringLayout.EAST, boxDepartamento);
		add(textFuncNomeOuCodigo);
		textFuncNomeOuCodigo.setColumns(10);
		
		JButton btnSelecionarFunc = new JButton("Buscar");
		btnSelecionarFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeOuCodigo = null;
				nomeOuCodigo = textFuncNomeOuCodigo.getText();
				if(dc.getFuncionarioByNameOrCode(nomeOuCodigo) == null) {
					JOptionPane.showMessageDialog(null, "Não existe nenhum funcionario com esse nome");
				}else {
					setFrame(dc.getFuncionarioByNameOrCode(nomeOuCodigo));
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnSelecionarFunc, -1, SpringLayout.NORTH, textFuncNomeOuCodigo);
		springLayout.putConstraint(SpringLayout.WEST, btnSelecionarFunc, 0, SpringLayout.WEST, btnSelecionar);
		add(btnSelecionarFunc);
		boxDepartamento.validate();
		
		
		

	}
	
	private void setFrame(Object obj) {
		if(obj.getClass().equals((new Tecnico()).getClass())) {
			Tecnico holder = (Tecnico)obj;
			BuscaTecnico.setData(holder.nome, holder.codigo, holder.nivel, holder.funcao, holder.salario);
			BuscaTecnico.main(null);
		}else if(obj.getClass().equals((new Substituto()).getClass())) {
			Substituto holder = (Substituto)obj;
			BuscaDocenteSubstituto.setData(holder.nome, holder.codigo, holder.nivel, holder.titulacao, holder.cargaHoraria, holder.salario);
			new BuscaDocenteSubstituto();
		}else{
			Efetivo holder = (Efetivo)obj;
			BuscaDocenteEfetivo.setData(holder.nome, holder.codigo, holder.nivel, holder.titulacao, holder.area, holder.salario);
			new BuscaDocenteSubstituto();
		}
	}

}

