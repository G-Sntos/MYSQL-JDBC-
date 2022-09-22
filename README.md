# MYSQL-JDBC-

Ejercicio 1.- MYSQL

REALIZA UN PROGRAMA EN JAVA QUE CONECTE CON UNA BASE DE DATOS MYSQL
MEDIANTE UN CONECTOR JDBC. LA BASE DE DATOS SERÁ LA SIGUIENTE.-

TABLE libro(
ISBN INT(10) PRIMARY KEY,
titulo CHAR(30) NOT NULL,
autor CHAR(30),
númejemplares INT(2),
anyopublicacion INT(4),
editorial CHAR(30),
numpag INT(4));
TABLE socio(
numsocio INT(5) PRIMARY KEY,
nombre CHAR(15) NOT NULL,
apellidos CHAR(15) NOT NULL,
telefono CHAR(10),
edad INT(5),
falta DATE);
TABLE prestamo(
libro INT(10) NOT NULL,
socio INT(5) NOT NULL,
fprestamo DATE NOT NULL,
fdevolucion DATE,
PRIMARY KEY (libro,socio,fprestamo),
FOREIGN KEY (libro) REFERENCES libro,
FOREIGN KEY (socio) REFERENCES socio);
MENÚ “CONSULTA DATOS”.- DONDE LE MOSTRAREMOS LA SIGUIENTE INFORMACIÓN

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
14.- SOCIO QUE MÁS PRÉSTAMOS TIENE EN LA BIBLIOTECA
A LOS MENÚS DE LA PRÁCTICA ANTERIOR (INSERTAR DATOS, LISTADO DATOS Y
ELIMINACIÓN DE DATOS) HABRÁ QUE AÑADIRLES ESTE MENÚ 
