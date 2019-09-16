USE master
go
create 
database AgendaEscolar
go
use AgendaEscolar
go
create table USUARIO (
	NOMBRE NVARCHAR(80) NOT NULL,
	CONSTRAINT PK_USUARIO PRIMARY KEY (NOMBRE)
)

go
create table NOTA (
	ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
	USUARIO NVARCHAR(80) NOT NULL,
	MODULO NVARCHAR(50) NOT NULL,
	CALIFICACION INT NOT NULL,
	FECHA DATE not null,
	OBSERVACIONES NVARCHAR(500) NULL,

	
	CONSTRAINT PK_NOTA PRIMARY KEY (ID),
	CONSTRAINT FK_USUARIONOTA FOREIGN KEY (USUARIO)
	REFERENCES USUARIO(NOMBRE)
	ON DELETE NO ACTION ON UPDATE CASCADE,
)