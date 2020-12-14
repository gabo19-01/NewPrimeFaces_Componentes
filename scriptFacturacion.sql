use facturacion;

CREATE TABLE Usuario (
usuarioID int, 
nombre varchar(50),
correo varchar(40),
contrasena varchar(40),
primary key (usuarioID));

CREATE TABLE Evento(
eventoID int, 
tiempoInicio date,
tiempoFin date,
creador int,
titulo varchar(20),
descripcion varchar(100),
completado bool,
tipoAlerta int, 
PRIMARY KEY (eventoID),
FOREIGN KEY(creador)REFERENCES Usuario(usuarioID));


CREATE TABLE Alerta(
alertaID int,
fechaFinal date,
fechaProxima date,
intervalo int,
eventoID int,
primary key (alertaID),
FOREIGN KEY (eventoID) REFERENCES Evento(eventoID));

CREATE TABLE Adjunto(
adjuntoID int,
adjuntoPath varchar(100),
eventoID int,
PRIMARY KEY (adjuntoID), 
FOREIGN KEY (eventoID) REFERENCES Evento(eventoID)
);

CREATE TABLE Departamento(
departamentoID int,
nombreDepartamento varchar(30),
PRIMARY KEY (departamentoID)
);

CREATE TABLE Participante_Evento(
eventoID int, 
participanteID int,
FOREIGN KEY (eventoID) REFERENCES Evento(eventoID),
FOREIGN KEY (participanteID) REFERENCES Usuario(usuarioID));

CREATE TABLE Evento_Departamento(
departamentoID int, 
eventoID int,
foreign key (departamentoID) references Departamento(departamentoID),
foreign key(eventoID)REFERENCES Evento(eventoID)
);

CREATE TABLE Usuario_Departamento(
usuarioID int,
departamentoID int,
foreign key (departamentoID) references Departamento(departamentoID),
foreign key (usuarioID) references Usuario(usuarioID)
)

