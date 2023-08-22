package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.AnimalDAO;
import modelo.Animal;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CadastroAnimal extends JFrame {

	private JPanel contentPane;
	private JTextField txtRegiaovive;
	private JTextField txtEspecie;
	private JLabel lblEspecie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAnimal frame = new CadastroAnimal();
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
	public CadastroAnimal() {
		setTitle("Cadastrar Animal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegiaovive = new JLabel("Região que vive:");
		lblRegiaovive.setForeground(new Color(204, 255, 255));
		lblRegiaovive.setBounds(66, 115, 86, 14);
		contentPane.add(lblRegiaovive);
		
		txtRegiaovive = new JTextField();
		txtRegiaovive.setBackground(new Color(0, 204, 255));
		txtRegiaovive.setBounds(173, 112, 86, 20);
		contentPane.add(txtRegiaovive);
		txtRegiaovive.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(0, 0, 0));
		btnCadastrar.setBackground(new Color(51, 0, 255));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String regiaovive = txtRegiaovive.getText();
				String especie = txtEspecie.getText();
				
				Animal a = new Animal();
				a.setRegiaovive(regiaovive);
				a.setEspecie(especie);
				AnimalDAO dao = new AnimalDAO();
				dao.inserir(a);
			}
		});
		btnCadastrar.setBounds(173, 161, 86, 23);
		contentPane.add(btnCadastrar);
		
		txtEspecie = new JTextField();
		txtEspecie.setBackground(new Color(0, 204, 255));
		txtEspecie.setColumns(10);
		txtEspecie.setBounds(173, 75, 86, 20);
		contentPane.add(txtEspecie);
		
		lblEspecie = new JLabel("Espécie:");
		lblEspecie.setForeground(new Color(204, 255, 255));
		lblEspecie.setBounds(106, 78, 46, 14);
		contentPane.add(lblEspecie);
	}
}