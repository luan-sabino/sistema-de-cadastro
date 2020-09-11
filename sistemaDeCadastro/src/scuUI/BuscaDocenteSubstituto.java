package scuUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.DataCare;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscaDocenteSubstituto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3881435816190407978L;
	private JPanel contentPane;
	private static JTextField textNome = new JTextField();
	private static JTextField textCodigo = new JTextField();
	private static JTextField textNivel = new JTextField();
	private static JTextField textTitulacao = new JTextField();
	private static JTextField textCargaHoraria = new JTextField();
	private static JTextField textSalario = new JTextField();
	private final JButton btnDeletarFuncionario = new JButton("Deletar funcionario");
	private DataCare dc = new DataCare();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscaDocenteSubstituto frame = new BuscaDocenteSubstituto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuscaDocenteSubstituto() {
		btnDeletarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
				if(i == JOptionPane.YES_OPTION) {
					try {
						dc.deletaFuncionario(textCodigo.getText());
						JOptionPane.showMessageDialog(null, "O funcionario foi removido com sucesso");
						textNome.setText("");
						textCodigo.setText("");
						textNivel.setText("");
						textTitulacao.setText("");
						textSalario.setText("");
						textCargaHoraria.setText("");
						
					} catch (NullPointerException e2) {
						JOptionPane.showMessageDialog(null, "O funcionario não esta cadastrado");
					}
					
					
				}
			}
		});
		setResizable(false);
		setTitle("Docente Substituto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 367, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome");
		
		textNome.setHorizontalAlignment(SwingConstants.CENTER);
		textNome.setEditable(false);
		textNome.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		
		textCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		textCodigo.setEditable(false);
		textCodigo.setColumns(10);
		
		textNivel.setHorizontalAlignment(SwingConstants.CENTER);
		textNivel.setEditable(false);
		textNivel.setColumns(10);
		
		textTitulacao.setHorizontalAlignment(SwingConstants.CENTER);
		textTitulacao.setEditable(false);
		textTitulacao.setColumns(10);
		
		textCargaHoraria.setHorizontalAlignment(SwingConstants.CENTER);
		textCargaHoraria.setEditable(false);
		textCargaHoraria.setColumns(10);
		
		textSalario.setHorizontalAlignment(SwingConstants.CENTER);
		textSalario.setEditable(false);
		textSalario.setColumns(10);
		
		JLabel lblNivel = new JLabel("Nivel");
		
		JLabel lblTitulao = new JLabel("Titula\u00E7\u00E3o");
		
		JLabel lblCargaHoraria = new JLabel("Carga Horaria");
		
		JLabel lblSalario = new JLabel("Salario");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNome)
						.addComponent(lblNivel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSalario, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitulao, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodigo, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
						.addComponent(lblCargaHoraria, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnDeletarFuncionario, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textSalario, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
						.addComponent(textCargaHoraria, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
						.addComponent(textTitulacao, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
						.addComponent(textNivel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
						.addComponent(textCodigo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
						.addComponent(textNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textNivel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNivel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textTitulacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitulao))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textCargaHoraria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCargaHoraria))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textSalario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSalario))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDeletarFuncionario)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public static void setData(String nome, String codigo, String nivel, String titulacao, int cargaHoraria, double salario) {
		textNome.setText(nome);
		textCodigo.setText(codigo);
		textNivel.setText(nivel);
		textTitulacao.setText(titulacao);
		textCargaHoraria.setText(String.valueOf(cargaHoraria));
		textSalario.setText(String.valueOf(salario));	
	}

}
