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

public class BuscaDocenteEfetivo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3881435816190407978L;
	private JPanel contentPane;
	private static JTextField textNome = new JTextField();
	private static JTextField textCodigo = new JTextField();
	private static JTextField textNivel = new JTextField();
	private static JTextField textTitulacao = new JTextField();
	private static JTextField textArea = new JTextField();
	private static JTextField textSalario = new JTextField();
	private DataCare dc = new DataCare();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscaDocenteEfetivo frame = new BuscaDocenteEfetivo();
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
	public BuscaDocenteEfetivo() {
		setResizable(false);
		setTitle("Docente Efetivo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 327, 238);
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
		
		textArea.setHorizontalAlignment(SwingConstants.CENTER);
		textArea.setEditable(false);
		textArea.setColumns(10);
		
		textSalario.setHorizontalAlignment(SwingConstants.CENTER);
		textSalario.setEditable(false);
		textSalario.setColumns(10);
		
		JLabel lblNivel = new JLabel("Nivel");
		
		JLabel lblTitulao = new JLabel("Titula\u00E7\u00E3o");
		
		JLabel lblArea = new JLabel("Area");
		
		JLabel lblSalario = new JLabel("Salario");
		
		JButton btnDeletaFuncionario = new JButton("Deletar funcionario");
		btnDeletaFuncionario.addActionListener(new ActionListener() {
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
						textArea.setText("");
						
					} catch (NullPointerException e2) {
						JOptionPane.showMessageDialog(null, "O funcionario n�o esta cadastrado");
					}
					
					
				}	
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNome)
						.addComponent(lblNivel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblArea, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodigo, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTitulao, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addComponent(lblSalario, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnDeletaFuncionario, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textSalario, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
						.addComponent(textArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
						.addComponent(textTitulacao, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
						.addComponent(textNivel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
						.addComponent(textCodigo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
						.addComponent(textNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
					.addGap(20))
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
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblArea))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textSalario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSalario))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDeletaFuncionario)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public static void setData(String nome, String codigo, String nivel, String titulacao, String area, double salario) {
		textNome.setText(nome);
		textCodigo.setText(codigo);
		textNivel.setText(nivel);
		textTitulacao.setText(titulacao);
		textArea.setText(area);
		textSalario.setText(String.valueOf(salario));	
	}
}


