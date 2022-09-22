import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class jFrameConsultarDatos extends JFrame {
	JButton listadoLibro = new JButton();
	JButton listadoSocio = new JButton();
	JButton numeroPrestamo = new JButton();
	JButton numeroLibros = new JButton();
	JButton listadoSocioNO = new JButton();
	JButton listadoSocioAlta = new JButton();
	JButton prestamoSuperior = new JButton();
	JButton numeroLibrosPrestados = new JButton();
	JButton listadoLibrosPrestados = new JButton();
	JButton sociosSacadoLibro = new JButton();
	JButton libroSuperadoFecha = new JButton();
	JButton sociosLibrosActualmente = new JButton();
	JButton libroMasPrestado = new JButton();
	JButton socioMasPrestamoTiene = new JButton();
	JButton volverMenu = new JButton();
	JButton volverSeleccion = new JButton();
	JTextArea mostrarInfo = new JTextArea();
	/*
1.- LISTADO LIBROS QUE HA SACADO UN SOCIO
2.- LISTADO DE SOCIOS QUE HA COGIDO UN DETERMINADO LIBRO.
3.- NÚMERO DE PRÉSTAMOS DE UN LIBRO
4.- NÚMERO DE LIBROS PRESTADOS A UN SOCIO DETERMINADO
5.- LISTADO SOCIOS QUE NO HAN SACADO NINGÚN LIBRO.
6.- LISTADO DE SOCIOS DADOS DE ALTA EN UN AÑO INTRODUCIDO POR PANTALLA
7.- PRÉSTAMOS QUE HAN TENIDO DURACIÓN SUPERIOR A 10 DIAS
8.- NÚMERO DE LIBROS PRESTADOS ACTUALMENTE
9.- LISTADO DE LIBROS PRESTADOS ACTUALMENTE
10.- SOCIOS QUE HAN SACADO MAS DE UNA VEZ EL MISMO LIBRO.
11.- LIBROS QUE HAN SUPERADO LA FECHA FIN DE PRÉSTAMO (FPRESTAMO+1 SEMANA)
12.- SOCIOS QUE TIENEN LIBROS ACTUALMENTE
13.- LIBRO MÁS PRESTADO DE LA BIBLIOTECA
14.- SOCIO QUE MÁS PRÉSTAMOS TIENE EN LA BIBLIOTECA*/
	
	public jFrameConsultarDatos() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
		this.setSize(740, 550);
		this.setTitle("Consultar Datos");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(102, 153, 255));
		//quitar el "border" cuando esta en foco el button
		listadoLibro.setFocusable(false);
		listadoSocio.setFocusable(false);
		numeroPrestamo.setFocusable(false);
		numeroLibros.setFocusable(false);
		listadoSocioNO.setFocusable(false);
		listadoSocioAlta.setFocusable(false);
		prestamoSuperior.setFocusable(false);
		numeroLibrosPrestados.setFocusable(false);
		listadoLibrosPrestados.setFocusable(false);
		sociosSacadoLibro.setFocusable(false);
		libroSuperadoFecha.setFocusable(false);
		sociosLibrosActualmente.setFocusable(false);
		libroMasPrestado.setFocusable(false);
		socioMasPrestamoTiene.setFocusable(false);
		volverMenu.setFocusable(false);
		//poner texto al los buttones
		listadoLibro.setText("LISTADO LIBROS QUE HA SACADO UN SOCIO");
		listadoSocio.setText("LISTADO DE SOCIOS QUE HA COGIDO UN DETERMINADO LIBRO.");
		numeroPrestamo.setText("NÚMERO DE PRÉSTAMOS DE UN LIBRO");
		numeroLibros.setText("NÚMERO DE LIBROS PRESTADOS A UN SOCIO DETERMINADO");
		listadoSocioNO.setText("LISTADO SOCIOS QUE NO HAN SACADO NINGÚN LIBRO.");
		listadoSocioAlta.setText("LISTADO DE SOCIOS DADOS DE ALTA EN UN AÑO INTRODUCIDO POR PANTALLA");
		prestamoSuperior.setText("PRÉSTAMOS QUE HAN TENIDO DURACIÓN SUPERIOR A 10 DIAS");
		numeroLibrosPrestados.setText("NÚMERO DE LIBROS PRESTADOS ACTUALMENTE");
		listadoLibrosPrestados.setText("LISTADO DE LIBROS PRESTADOS ACTUALMENTE");
		sociosSacadoLibro.setText("SOCIOS QUE HAN SACADO MAS DE UNA VEZ EL MISMO LIBRO.");
		libroSuperadoFecha.setText("LIBROS QUE HAN SUPERADO LA FECHA FIN DE PRÉSTAMO");
		sociosLibrosActualmente.setText("SOCIOS QUE TIENEN LIBROS ACTUALMENTE");
		libroMasPrestado.setText("LIBRO MÁS PRESTADO DE LA BIBLIOTECA");
		socioMasPrestamoTiene.setText("SOCIO QUE MÁS PRÉSTAMOS TIENE EN LA BIBLIOTECA");
		volverMenu.setText("Volver");
		//medidas de los buttones
		//vacio* porque, los textos son muy largo, por defecto adjustan al base del texto que lleva.
		volverMenu.setPreferredSize(new Dimension(100,50));
		//meter buttones al frame
		this.add(listadoLibro);
		this.add(listadoSocio);
		this.add(numeroPrestamo);
		this.add(numeroLibros);
		this.add(listadoSocioNO);
		this.add(listadoSocioAlta);
		this.add(prestamoSuperior);
		this.add(numeroLibrosPrestados);
		this.add(listadoLibrosPrestados);
		this.add(sociosSacadoLibro);
		this.add(libroSuperadoFecha);
		this.add(sociosLibrosActualmente);
		this.add(libroMasPrestado);
		this.add(socioMasPrestamoTiene);
		this.add(volverMenu);
		//acciones de cada button
		//1
		listadoLibro.addActionListener(e->{
			int inputUsuario =Integer.valueOf( JOptionPane.showInputDialog ("Num Socio: "));
			JFrame listadoLibro = new JFrame(); // nuevo jFrame para Mostrar Datos
			listadoLibro.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
			listadoLibro.setSize(300, 280);
			listadoLibro.setTitle("Datos Solicitado");
			listadoLibro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			listadoLibro.setResizable(false);
			listadoLibro.getContentPane().setBackground(new Color(102, 153, 255));
			String resulta = listadoLibroI(inputUsuario);
			mostrarInfo.setBounds(0, 0, 250, 300);
			mostrarInfo.append(resulta);
			listadoLibro.add(mostrarInfo);
			listadoLibro.setVisible(true);
				
		});
		//2
		listadoSocio.addActionListener(e->{
			int inputUsuario =Integer.valueOf( JOptionPane.showInputDialog ("Num ISBN: "));
			JFrame listadoSocio = new JFrame(); // nuevo jFrame para Mostrar Datos
			listadoSocio.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
			listadoSocio.setSize(300, 280);
			listadoSocio.setTitle("Datos Solicitado");
			listadoSocio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			listadoSocio.setResizable(false);
			listadoSocio.getContentPane().setBackground(new Color(102, 153, 255));
			String resulta = listadoSocio(inputUsuario);
			mostrarInfo.setBounds(0, 0, 250, 300);
			mostrarInfo.append(resulta);
			listadoSocio.add(mostrarInfo);
			listadoSocio.setVisible(true);
				});
		//3
		numeroPrestamo.addActionListener(e->{
			
			int inputUsuario =Integer.valueOf( JOptionPane.showInputDialog ("Num ISBN: "));
			JFrame numeroPrestamo = new JFrame(); // nuevo jFrame para Mostrar Datos
			numeroPrestamo.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
			numeroPrestamo.setSize(300, 280);
			numeroPrestamo.setTitle("Datos Solicitado");
			numeroPrestamo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			numeroPrestamo.setResizable(false);
			numeroPrestamo.getContentPane().setBackground(new Color(102, 153, 255));
			String resulta = numeroPrestamosLibro(inputUsuario);
			mostrarInfo.setBounds(0, 0, 250, 300);
			mostrarInfo.append(resulta);
			numeroPrestamo.add(mostrarInfo);
			numeroPrestamo.setVisible(true);

		});
		//4
		numeroLibros.addActionListener(e->{
			int inputUsuario =Integer.valueOf( JOptionPane.showInputDialog ("Num Socio: "));
			JFrame numeroLibro = new JFrame(); // nuevo jFrame para Mostrar Datos
			numeroLibro.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
			numeroLibro.setSize(300, 280);
			numeroLibro.setTitle("Datos Solicitado");
			numeroLibro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			numeroLibro.setResizable(false);
			numeroLibro.getContentPane().setBackground(new Color(102, 153, 255));
			String resulta = numeroLibroPrestadoSocio(inputUsuario);
			mostrarInfo.setBounds(0, 0, 250, 300);
			mostrarInfo.append(resulta);
			numeroLibro.add(mostrarInfo);
			numeroLibro.setVisible(true);
		});
		//5
		listadoSocioNO.addActionListener(e->{
			JFrame listadoSocioNO = new JFrame(); // nuevo jFrame para Mostrar Datos
			listadoSocioNO.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
			listadoSocioNO.setSize(300, 280);
			listadoSocioNO.setTitle("Datos Solicitado");
			listadoSocioNO.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			listadoSocioNO.setResizable(false);
			listadoSocioNO.getContentPane().setBackground(new Color(102, 153, 255));
			String resulta = listadoSocioNoSacadoLibro();
			mostrarInfo.setBounds(0, 0, 250, 300);
			mostrarInfo.append(resulta);
			listadoSocioNO.add(mostrarInfo);
			listadoSocioNO.setVisible(true);
		});
		//6
		listadoSocioAlta.addActionListener(e->{
			int inputUsuario =Integer.valueOf( JOptionPane.showInputDialog ("Anyo:" ));
			JFrame listadoSocioAlta = new JFrame(); // nuevo jFrame para Mostrar Datos
			listadoSocioAlta.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
			listadoSocioAlta.setSize(300, 280);
			listadoSocioAlta.setTitle("Datos Solicitado");
			listadoSocioAlta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			listadoSocioAlta.setResizable(false);
			listadoSocioAlta.getContentPane().setBackground(new Color(102, 153, 255));
			String resulta = listadoSocioAlta(inputUsuario);
			mostrarInfo.setBounds(0, 0, 250, 300);
			mostrarInfo.append(resulta);
			listadoSocioAlta.add(mostrarInfo);
			listadoSocioAlta.setVisible(true);
		});
		//7
		prestamoSuperior.addActionListener(e->{
			JFrame prestamoSuperior = new JFrame(); // nuevo jFrame para Mostrar Datos
			prestamoSuperior.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
			prestamoSuperior.setSize(300, 280);
			prestamoSuperior.setTitle("Datos Solicitado");
			prestamoSuperior.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			prestamoSuperior.setResizable(false);
			prestamoSuperior.getContentPane().setBackground(new Color(102, 153, 255));
			String resulta = prestamoDiezDias();
			mostrarInfo.setBounds(0, 0, 250, 300);
			mostrarInfo.append(resulta);
			prestamoSuperior.add(mostrarInfo);
			prestamoSuperior.setVisible(true);
		});
		//8
		numeroLibrosPrestados.addActionListener(e->{
			JFrame numeroLibroPrestadoActual = new JFrame(); // nuevo jFrame para Mostrar Datos
			numeroLibroPrestadoActual.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
			numeroLibroPrestadoActual.setSize(300, 280);
			numeroLibroPrestadoActual.setTitle("Datos Solicitado");
			numeroLibroPrestadoActual.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			numeroLibroPrestadoActual.setResizable(false);
			numeroLibroPrestadoActual.getContentPane().setBackground(new Color(102, 153, 255));
			String resulta = numeroLibroPrestadoActual();
			mostrarInfo.setBounds(0, 0, 250, 300);
			mostrarInfo.append(resulta);
			numeroLibroPrestadoActual.add(mostrarInfo);
			numeroLibroPrestadoActual.setVisible(true);
		});
		//9
		listadoLibrosPrestados.addActionListener(e->{
			JFrame listadoLibroPrestadoActual = new JFrame(); // nuevo jFrame para Mostrar Datos
			listadoLibroPrestadoActual.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
			listadoLibroPrestadoActual.setSize(300, 280);
			listadoLibroPrestadoActual.setTitle("Datos Solicitado");
			listadoLibroPrestadoActual.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			listadoLibroPrestadoActual.setResizable(false);
			listadoLibroPrestadoActual.getContentPane().setBackground(new Color(102, 153, 255));
			String resulta = listadoLibroPrestadoActual();
			mostrarInfo.setBounds(0, 0, 250, 300);
			mostrarInfo.append(resulta);
			listadoLibroPrestadoActual.add(mostrarInfo);
			listadoLibroPrestadoActual.setVisible(true);
		});
		//10
		sociosSacadoLibro.addActionListener(e->{
			JFrame socioSacadoMasUnaVez = new JFrame(); // nuevo jFrame para Mostrar Datos
			socioSacadoMasUnaVez.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
			socioSacadoMasUnaVez.setSize(300, 280);
			socioSacadoMasUnaVez.setTitle("Datos Solicitado");
			socioSacadoMasUnaVez.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			socioSacadoMasUnaVez.setResizable(false);
			socioSacadoMasUnaVez.getContentPane().setBackground(new Color(102, 153, 255));
			String resulta = socioSacadoMasUnaVez();
			mostrarInfo.setBounds(0, 0, 250, 300);
			mostrarInfo.append(resulta);
			socioSacadoMasUnaVez.add(mostrarInfo);
			socioSacadoMasUnaVez.setVisible(true);
		});
		//11
		libroSuperadoFecha.addActionListener(e->{
			JFrame librosSuperadoFecha = new JFrame(); // nuevo jFrame para Mostrar Datos
			librosSuperadoFecha.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
			librosSuperadoFecha.setSize(300, 280);
			librosSuperadoFecha.setTitle("Datos Solicitado");
			librosSuperadoFecha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			librosSuperadoFecha.setResizable(false);
			librosSuperadoFecha.getContentPane().setBackground(new Color(102, 153, 255));
			String resulta = librosSuperadoFecha();
			mostrarInfo.setBounds(0, 0, 250, 300);
			mostrarInfo.append(resulta);
			librosSuperadoFecha.add(mostrarInfo);
			librosSuperadoFecha.setVisible(true);
		});
		//12
		sociosLibrosActualmente.addActionListener(e->{
			JFrame sociosTienenlibro = new JFrame(); // nuevo jFrame para Mostrar Datos
			sociosTienenlibro.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
			sociosTienenlibro.setSize(300, 280);
			sociosTienenlibro.setTitle("Datos Solicitado");
			sociosTienenlibro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			sociosTienenlibro.setResizable(false);
			sociosTienenlibro.getContentPane().setBackground(new Color(102, 153, 255));
			String resulta = sociosTienenlibro();
			mostrarInfo.setBounds(0, 0, 250, 300);
			mostrarInfo.append(resulta);
			sociosTienenlibro.add(mostrarInfo);
			sociosTienenlibro.setVisible(true);
		});
		//13
		libroMasPrestado.addActionListener(e->{
			JFrame libroMasPrestado = new JFrame(); // nuevo jFrame para Mostrar Datos
			libroMasPrestado.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
			libroMasPrestado.setSize(300, 280);
			libroMasPrestado.setTitle("Datos Solicitado");
			libroMasPrestado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			libroMasPrestado.setResizable(false);
			libroMasPrestado.getContentPane().setBackground(new Color(102, 153, 255));
			String resulta = libroMasPrestado();
			mostrarInfo.setBounds(0, 0, 250, 300);
			mostrarInfo.append(resulta);
			libroMasPrestado.add(mostrarInfo);
			libroMasPrestado.setVisible(true);
		});
		//14
		socioMasPrestamoTiene.addActionListener(e->{
			JFrame socioMasPrestamo = new JFrame(); // nuevo jFrame para Mostrar Datos
			socioMasPrestamo.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
			socioMasPrestamo.setSize(300, 280);
			socioMasPrestamo.setTitle("Datos Solicitado");
			socioMasPrestamo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			socioMasPrestamo.setResizable(false);
			socioMasPrestamo.getContentPane().setBackground(new Color(102, 153, 255));
			String resulta = socioMasPrestamo();
			mostrarInfo.setBounds(0, 0, 250, 300);
			mostrarInfo.append(resulta);
			socioMasPrestamo.add(mostrarInfo);
			socioMasPrestamo.setVisible(true);
		});		
		volverMenu.addActionListener(e->{
			jFrameMenu nuevoMenu = new jFrameMenu();
			this.dispose();
		});
		
		
		this.setVisible(true);
		}
	//conexion de todas las funciones
	private Connection connect() { // conexion modificado para el MYSQL
		 Connection con=null;
		 	try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/mydb","root","gayle2503@gmail.com!");  
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}  
	
	        return con;
	    }
	//funciones por cada button
	private String listadoLibroI(int socio) {
		String sql = "SELECT libro.titulo,prestamo.libro FROM prestamo INNER JOIN libro on prestamo.libro = libro.ISBN WHERE prestamo.socio="+socio; // query que busca el ejercicio
        String resultado="";
        try (Connection conn = this.connect();  //usando el conn del mySQL
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
               
               // loop del resulta a mostrar
               while (rs.next()) {
                   resultado+=(rs.getString("titulo") +  "\t" + 
                                      rs.getInt("libro") + "\t");
                                     
               }
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
           return resultado; //devuelve el conjunto del loop como un string
	}
	private String listadoSocio(int isbn) {
		String sql = "SELECT prestamo.socio, socio.nombre FROM prestamo INNER JOIN socio on prestamo.socio = socio.numsocio WHERE libro = "+isbn; // query que busca el ejercicio
        String resultado="";
        try (Connection conn = this.connect();  //usando el conn del mySQL
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
               
               // loop del resulta a mostrar
               while (rs.next()) {
                   resultado+=(rs.getInt("socio") +  "\t"+
                		   		rs.getString("nombre")+"\t");
                                     
               }
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
           return resultado; //devuelve el conjunto del loop como un string
		}
	private String numeroPrestamosLibro(int isbn) {
		String sql = "SELECT libro, COUNT(libro) FROM prestamo WHERE libro="+isbn; // query que busca el ejercicio
        String resultado="";
        try (Connection conn = this.connect();  //usando el conn del mySQL
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
               
               // loop del resulta a mostrar
               while (rs.next()) {
                   resultado+=(rs.getInt("libro") +  "\t"+
                		   rs.getInt("COUNT(libro)"));
                                     
               }
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
           return resultado; //devuelve el conjunto del loop como un string
	}
	private String numeroLibroPrestadoSocio(int numsocio) {
		String sql = "SELECT libro, COUNT(libro) FROM prestamo WHERE socio="+numsocio; // query que busca el ejercicio
        String resultado="";
        try (Connection conn = this.connect();  //usando el conn del mySQL
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
               
               // loop del resulta a mostrar
               while (rs.next()) {
                   resultado+=(rs.getInt("libro") +  "\t" + 
                                      rs.getInt("COUNT(libro)") + "\t");
                                     
               }
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
           return resultado; //devuelve el conjunto del loop como un string
	}
	private String listadoSocioNoSacadoLibro() {
		String sql = "prestamo.socio, socio.nombre, COUNT(libro) FROM prestamo INNER JOIN socio on socio.numsocio=prestamo.socio ORDER BY COUNT(libro) DESC"; // query que busca el ejercicio
        String resultado="";
        try (Connection conn = this.connect();  //usando el conn del mySQL
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
               
               // loop del resulta a mostrar
               while (rs.next()) {
                   resultado+=(rs.getInt("socio") + "\t"+
                		   		rs.getString("nombre")+"\t"+
                		   		rs.getInt("COUNT(libro)"));
                                     
               }
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
           return resultado; //devuelve el conjunto del loop como un string
	}
	private String listadoSocioAlta(int anyo) {
		String sql = "SELECT numsocio,nombre FROM socio WHERE falta >= "+anyo+"-01-01"; // query que busca el ejercicio
        String resultado="";
        try (Connection conn = this.connect();  //usando el conn del mySQL
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
               
               // loop del resulta a mostrar
               while (rs.next()) {
                   resultado+=(rs.getInt("numsocio") + "\t"+
                		   rs.getString("nombre") + "\t");
                                     
               }
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
           return resultado; //devuelve el conjunto del loop como un string
	}
	private String prestamoDiezDias() {
		String sql = "SELECT DATEDIFF(fprestamo,fdevolucion),libro FROM prestamo WHERE DATEDIFF(fprestamo,fdevolucion)>10"; // query que busca el ejercicio
        String resultado="";
        try (Connection conn = this.connect();  //usando el conn del mySQL
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
               
               // loop del resulta a mostrar
               while (rs.next()) {
                   resultado+=(rs.getInt("DATEDIFF(fprestamo,fdevolucion)") + "\t"+
                		   rs.getInt("libro") + "\t");
                                     
               }
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
           return resultado; //devuelve el conjunto del loop como un string
	}
	private String numeroLibroPrestadoActual() {
		String sql = "SELECT COUNT(libro) FROM prestamo WHERE fdevolucion = null"; // query que busca el ejercicio
        String resultado="";
 
        try (Connection conn = this.connect();  //usando el conn del mySQL
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
               
               // loop del resulta a mostrar
               while (rs.next()) {
                   resultado+=(rs.getInt("COUNT(libro)") + "\t");
                          
               }
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
           return resultado; //devuelve el numero de libros
	}
	private String listadoLibroPrestadoActual() {
		String sql = "libro.titulo, prestamo.libro FROM prestamo INNER JOIN libro on prestamo.libro = libro.ISBN WHERE fdevolucion = null"; // query que busca el ejercicio
        String resultado="";
        
        try (Connection conn = this.connect();  //usando el conn del mySQL
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
               
               // loop del resulta a mostrar
               while (rs.next()) {
                   resultado+=(rs.getString("libro") + "\t"+
                		   rs.getInt("libro") + "\t");
                           
               }
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
           return resultado; //devuelve el listado de libros
	}
	private String socioSacadoMasUnaVez() {

		String sql = "SELECT socio.nombre,COUNT(libro) FROM prestamo INNER JOIN socio on socio.numsocio = prestamo.socio"; // query que busca el ejercicio
        String resultado="";
        
        try (Connection conn = this.connect();  //usando el conn del mySQL
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
               
               // loop del resulta a mostrar
               while (rs.next()) {
                   resultado+=(rs.getString("nombre") + "\t"+
                		   rs.getInt("COUNT(libro)") + "\t");
                           
               }
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
           return resultado; //devuelve el listado de libros
	}
	private String librosSuperadoFecha() {
		String sql = "SELECT libro.titulo,prestamo.libro FROM prestamo INNER JOIN libro on prestamo.libro = libro.ISBN WHERE DATEDIFF(fprestamo,CURDATE())>7"; // query que busca el ejercicio
        String resultado="";
        
        try (Connection conn = this.connect();  //usando el conn del mySQL
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
               
               // loop del resulta a mostrar
               while (rs.next()) {
                   resultado+=(rs.getString("titulo") + "\t"+
                		   rs.getInt("libro") + "\t");
                           
               }
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
           return resultado; //devuelve el listado de libros
	}
	private String sociosTienenlibro() {

		String sql = "SELECT prestamo.libro,socio.nombre FROM prestamo INNER JOIN socio on prestamo.socio = socio.numsocio; WHERE fdevolucion = null"; // query que busca el ejercicio
        String resultado="";
        
        try (Connection conn = this.connect();  //usando el conn del mySQL
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
               
               // loop del resulta a mostrar
               while (rs.next()) {
                   resultado+=(rs.getInt("libro") + "\t"+
                		   rs.getString("nombre") + "\t");
                           
               }
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
           return resultado; //devuelve el listado de libros
	}
	private String libroMasPrestado() {
		String sql = "SELECT libro.titulo,prestamo.libro, COUNT(libro)FROM prestamo INNER JOIN libro on prestamo.libro = libro.ISBN ORDER BY COUNT(libro) ASC"; // query que busca el ejercicio
        String resultado="";
        
        try (Connection conn = this.connect();  //usando el conn del mySQL
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
               
               // loop del resulta a mostrar
               while (rs.next()) {
                   resultado+=(rs.getString("titulo") + "\t"+
                		   rs.getInt("libro") + "\t"+
                		   rs.getInt("COUNT(libro)")+ "\t");
                           
               }
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
           return resultado; //devuelve el listado de libros
	}
	private String socioMasPrestamo() {
		String sql = "SELECT socio.nombre, COUNT(fprestamo) FROM prestamo INNER JOIN socio on prestamo.socio = socio.numsocio ORDER BY COUNT(fprestamo) ASC"; // query que busca el ejercicio
        String resultado="";
        
        try (Connection conn = this.connect();  //usando el conn del mySQL
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
               
               // loop del resulta a mostrar
               while (rs.next()) {
                   resultado+=(rs.getString("nombre") + "\t"+
                		   rs.getInt("COUNT(fprestamo)") + "\t");
                           
               }
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
           return resultado; //devuelve el listado de libros
	}
}                         