-- SE COLOCA ESTE SCRIPT POR QUE SE SOLICITA EN PREFEERNCIAS, AUNQUE EN EL API SE CREA EN FORMA AUTOMATICA


CREATE TABLE Articulo2
 (
	 IdArticulo  int  primary key not null,
	 Nombre      varchar(20) not null,
	 Descripcion Varchar(200) not null,
	 Precio      int not null,
	 Modelo      varchar(10)
 );

 

INSERT INTO ARTICULO2(IdArticulo,Nombre,Descripcion,Precio,Modelo) VALUES(1,'articulo 1','descripcion del articulo 1', 10, 'modelo 1');
INSERT INTO ARTICULO2(IdArticulo,Nombre,Descripcion,Precio,Modelo) VALUES(2,'articulo 2','descripcion del articulo 2', 10, 'modelo 2');
INSERT INTO ARTICULO2(IdArticulo,Nombre,Descripcion,Precio,Modelo) VALUES(3,'articulo 3','descripcion del articulo 3', 10, 'modelo 3');
INSERT INTO ARTICULO2(IdArticulo,Nombre,Descripcion,Precio,Modelo) VALUES(4,'articulo 4','descripcion del articulo 4', 10, 'modelo 4');