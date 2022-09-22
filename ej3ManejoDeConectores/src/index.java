
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class index {


	public static void main(String[] args) {
		jFrameMenu a = new jFrameMenu();//empezar el GUI de la programa

	}
	
	private Connection connect() {  //este funcion es la diferencia a comparacion de los ultimos ejercicios.
									//más los 14 Queries que esta en su propio clase.
									//no he usado este conn en particular, pero lo puse para explicar el cambio.
		 Connection con=null;
		 	try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/mydb","root","gayle2503@gmail.com!");    // mydb-nombre de mi Sql, root - usuario, - gayle2503@gmail.com!- es el clave.
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	
	        return con;
	    }
	
	//el SQL script que he usado para crear las tablas tambien esta adjuntado con el archivo.
}

