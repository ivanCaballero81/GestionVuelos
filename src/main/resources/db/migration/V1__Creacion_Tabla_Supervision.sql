CREATE TABLE  REGISTRO.PAIS (
  idPais INT NOT NULL,
  nombre VARCHAR(45) NULL,
  PRIMARY KEY (`idPais`)
);

CREATE TABLE  REGISTRO.PASAJERO (
  idPasajero INT NOT NULL primary key,
  nombre VARCHAR(150) NULL,
  paterno VARCHAR(150) NULL,
  materno VARCHAR(150) NULL,
  tipoDocumento VARCHAR(45) NULL,
  numeroDocumento VARCHAR(12) NULL,
  nacimiento DATE NULL,
  mail VARCHAR(50) NULL,
  clave VARCHAR(45) NULL,
  idPais INT NOT NULL,
 FOREIGN KEY(idPais) REFERENCES PAIS(idPais)
);

CREATE TABLE REGISTRO.AEROPUERTO (
  idAeropuerto INT NOT NULL primary key,
  nombre VARCHAR(45) NOT NULL ,
  idPais INT NOT NULL,
   FOREIGN KEY(idPais) REFERENCES PAIS(idPais)
);

CREATE TABLE  REGISTRO.RESERVA (
  idReserva INT NOT NULL primary key,
  costo DECIMAL(12,2) NOT NULL,
  fecha DATE  NOT NULL,
  observacion VARCHAR(200) NULL
);

CREATE TABLE  REGISTRO.PAGO (
  idPago INT NOT NULL primary key,
  fecha DATE NULL,
  monto DECIMAL(12,2) NOT NULL,
  tipoComprobante VARCHAR(50) NULL,
  numeroComprobante VARCHAR(50) NULL,
  impuesto DECIMAL(12,2) NOT NULL,
  idPasajero INT NOT NULL,
  idReserva INT NOT NULL,
 FOREIGN KEY(idPasajero) REFERENCES PASAJERO(idPasajero),
FOREIGN KEY(idReserva) REFERENCES RESERVA(idReserva)
);

CREATE TABLE  REGISTRO.TARIFA (
  idTarifa INT NOT NULL primary key,
  clase VARCHAR(50) NULL,
  precio DECIMAL(12,2) NULL,
  impuesto DECIMAL(12,2) NULL
);
CREATE TABLE IF NOT EXISTS REGISTRO.AEROLINEA (
  idAerolinea INT NOT NULL primary key,
  ruc VARCHAR(11) NULL,
  nombre VARCHAR(200) NULL
);

CREATE TABLE REGISTRO.AVION (
  idAvion INT NOT NULL primary key,
  fabricante INT NULL,
  tipo VARCHAR(45) NULL,
  capacidad INT NULL,
  idAerolinea INT NOT NULL,
  FOREIGN KEY(idAerolinea) REFERENCES AEROLINEA(idAerolinea)
);

CREATE TABLE REGISTRO.ASIENTO (
  idAsiento INT NOT NULL PRIMARY KEY,
  fila VARCHAR(45) NULL,
  letra VARCHAR(45) NULL
);

CREATE TABLE REGISTRO.VUELO (
  idAeropuerto INT NOT NULL,
  idReserva INT NOT NULL,
  idTarifa INT NOT NULL,
  idAvion INT NOT NULL,
  idAsiento INT NOT NULL,
    FOREIGN KEY(idAeropuerto) REFERENCES AEROPUERTO(idAeropuerto),
    FOREIGN KEY(idReserva) REFERENCES RESERVA(idReserva),
    FOREIGN KEY(idTarifa) REFERENCES TARIFA(idTarifa),
    FOREIGN KEY(idAvion) REFERENCES AVION(idAvion),
    FOREIGN KEY(idAsiento) REFERENCES ASIENTO(idAsiento)
);

