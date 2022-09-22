

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class jFrameMenu extends JFrame{
	
	JButton button2= new JButton();
	JButton button3= new JButton();
	JButton button4= new JButton();
	JButton button5= new JButton();
	JButton button6= new JButton(); // Lo que pide el ejercicio
	jFrameInsertar jFrameInsertar;
	jFrameBorrar jFrameBorrar;
	public jFrameMenu(){
		//Base frame del menu
		this.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
		this.setSize(250, 350);
		this.setTitle("Ej 3 mySQL");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(102, 153, 255));
		//Texto Butones
		button2.setText("Insertar Datos");
		button3.setText("Eliminar Datos");
		button4.setText("Mostrar Datos");
		button5.setText("Salir");
		button6.setText("Consultar Datos");  // Lo que pide el ejercicio
		//para quitar el "border" del texto.
	
		button2.setFocusable(false); 
		button3.setFocusable(false);
		button4.setFocusable(false);
		button5.setFocusable(false);
		button6.setFocusable(false);
		//Tamaño buttones

		button2.setPreferredSize(new Dimension(150,35));
		button3.setPreferredSize(new Dimension(150,35));
		button4.setPreferredSize(new Dimension(150,35));
		button5.setPreferredSize(new Dimension(150,35));
		button6.setPreferredSize(new Dimension(150,35)); // Lo que pide el ejercicio
		//Meter Butones en Frame
		
		this.add(button2);
		this.add(button3);
		this.add(button4);
		this.add(button6); // Lo que pide el ejercicio
		this.add(button5);
		//acciones de cada button
	
		button2.addActionListener(e->{
			jFrameInsertar = new jFrameInsertar();
			this.dispose();
			
		});
		//acciones de cada button
		button3.addActionListener(e->{
			jFrameBorrar = new jFrameBorrar();
			this.dispose();
			
		});
		//acciones de cada button
		button4.addActionListener(e->{
			jFrameMostrarDatos a = new jFrameMostrarDatos();
			this.dispose();
			
		});
		button5.addActionListener(e->{
			System.exit(0);
			
		});
		button6.addActionListener(e->{
			jFrameConsultarDatos jFrameConsultarDatos = new jFrameConsultarDatos();
			this.dispose();
			
		});
		
		
		this.setVisible(true);
	}
}
