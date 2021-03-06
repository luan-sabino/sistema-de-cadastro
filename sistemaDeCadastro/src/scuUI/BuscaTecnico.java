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

public class BuscaTecnico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3881435816190407978L;
	private JPanel contentPane;
	private static JTextField textNome = new JTextField();
	private static JTextField textCodigo = new JTextField();
	private static JTextField textNivel = new JTextField();
	private static JTextField textFuncao = new JTextField();
	private static JTextField textSalario = new JTextField();
	private final JButton btnDeletarFuncionario = new JButton("Deletar funcionario");
	private DataCare dc =  new DataCare();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscaTecnico frame = new BuscaTecnico();
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
	public BuscaTecnico() {
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
						textFuncao.setText("");
						textSalario.setText("");
						
					} catch (NullPointerException e2) {
						JOptionPane.showMessageDialog(null, "O funcionario n�o esta cadastrado");
					}
					
					
				}
			}
		});
		setResizable(false);
		setTitle("T\u00E9cnico");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 327, 223);
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
		
		textFuncao.setHorizontalAlignment(SwingConstants.CENTER);
		textFuncao.setEditable(false);
		textFuncao.setColumns(10);
		
		textSalario.setHorizontalAlignment(SwingConstants.CENTER);
		textSalario.setEditable(false);
		textSalario.setColumns(10);
		
		JLabel lblNivel = new JLabel("Nivel");
		
		JLabel lblFuncao = new JLabel("Fun\u00E7\u00E3o");
		
		JLabel lblSalario = new JLabel("Salario");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNome)
								.addComponent(lblNivel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCodigo, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblFuncao, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFuncao, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNivel, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
								.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNome, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSalario, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnDeletarFuncionario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textSalario, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))))
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
						.addComponent(textFuncao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFuncao))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSalario)
						.addComponent(textSalario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDeletarFuncionario)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public static void setData(String nome, String codigo, String nivel, String funcao, double salario) {
		textNome.setText(nome);
		textCodigo.setText(codigo);
		textNivel.setText(nivel);
		textFuncao.setText(funcao);
		textSalario.setText(String.valueOf(salario));	
	}

}


