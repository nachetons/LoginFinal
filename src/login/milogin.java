package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class milogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtCorreo;
	private JPasswordField txtContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					milogin frame = new milogin();
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
	public milogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setBounds(124, 41, 57, 19);
		contentPane.add(lblRegistro);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(51, 103, 63, 19);
		contentPane.add(lblCorreo);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(51, 148, 63, 24);
		contentPane.add(lblContrasea);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(106, 102, 143, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);

		txtContrasena = new JPasswordField();
		txtContrasena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				int mincaracteres = 7;
				int maxcaracteres = 11;
				txtContrasena.setBackground(Color.WHITE);

				char[] contrasena = txtContrasena.getPassword();
				String contrasenafinal = new String(contrasena);
				for (int i = 0; i < contrasenafinal.length(); i++) {
					char letra = contrasenafinal.charAt(i);
					String letraStr = String.valueOf(letra);
					System.out.println(contrasena);
					if (i > maxcaracteres || i < mincaracteres) {
						txtContrasena.setBackground(Color.RED);
					} else {
						txtContrasena.setBackground(Color.WHITE);
					}
					if (contrasena.length == 0) {
						txtContrasena.setBackground(Color.WHITE);
					}

				}
			}
		});

		txtContrasena.setBounds(124, 150, 125, 20);
		contentPane.add(txtContrasena);

		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int contador = 0;
				String correo = txtCorreo.getText();
				char[] contrasena = txtContrasena.getPassword();
				String contrasenafinal = new String(contrasena);
				int contNumero = 0;
				int contLetraMay = 0;
				int contLetraMin = 0;

				for (int i = 0; i < correo.length(); i++) {
					if (correo.charAt(i) == '@' || correo.charAt(i) == '.') {
						contador = contador + 1;
					}

				}
				if (contador == 2) {
					System.out.println("Correo introducido valido");
				} else {
					System.out.println("Correo introducido no valido");
				}

				for (int i = 0; i < contrasenafinal.length(); i++) {
					char letra = contrasenafinal.charAt(i);
					String letraStr = String.valueOf(letra);
					if (letraStr.matches("[A-Z]")) {
						contLetraMay++;
					} else if (letraStr.matches("[a-z]")) {
						contLetraMin++;
					} else if (letraStr.matches("[0-9]")) {
						contNumero++;
					}

				}
				if (contLetraMay > 1 && contLetraMin > 1 && contNumero > 1) {
					JOptionPane.showMessageDialog(null, "Registrado satisfactoriamente", "Registro",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Registro no valido no se cumplen las reglas establecidas",
							"Registro", JOptionPane.WARNING_MESSAGE);
				}
				System.out.println("Cantidad de letras mayusculas:" + contLetraMay);

				System.out.println("Cantidad de letras minusculas:" + contLetraMin);

				System.out.println("Cantidad de numeros:" + contNumero);

			}
		});
		btnAcceder.setBounds(160, 193, 89, 23);
		contentPane.add(btnAcceder);

		JButton btnMostrarPass = new JButton("Mostrar Pass");
		btnMostrarPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int contNumero = 0;
				int contLetraMay = 0;
				int contLetraMin = 0;
				String correo = txtCorreo.getText();
				char[] contrasena = txtContrasena.getPassword();
				String contrasenafinal = new String(contrasena);
				for (int i = 0; i < contrasenafinal.length(); i++) {
					char letra = contrasenafinal.charAt(i);
					String letraStr = String.valueOf(letra);
					if (letraStr.matches("[A-Z]")) {
						contLetraMay++;
					} else if (letraStr.matches("[a-z]")) {
						contLetraMin++;
					} else if (letraStr.matches("[0-9]")) {
						contNumero++;
					} 
						

					
				} // fin for
				if (contrasenafinal.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campos vacios", "Error", JOptionPane.INFORMATION_MESSAGE);

				}else{
				JOptionPane.showMessageDialog(null, contrasenafinal, "Tu password es",
								JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnMostrarPass.setBounds(10, 211, 109, 39);
		contentPane.add(btnMostrarPass);
	}
}
