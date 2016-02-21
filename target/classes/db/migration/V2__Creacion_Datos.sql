/**
 * Author:  Ivan Caballero <icaballero at crossnet.ws>
 * Created: Jan 18, 2016
 */

INSERT INTO REGISTRO.PAIS (idPais,nombre) VALUES(1,'Perú');
INSERT INTO REGISTRO.PAIS (idPais,nombre) VALUES(2,'Colombia');
INSERT INTO REGISTRO.PAIS (idPais,nombre) VALUES(3,'Mexico');
INSERT INTO REGISTRO.PAIS (idPais,nombre) VALUES(4,'Chile');
INSERT INTO REGISTRO.PAIS (idPais,nombre) VALUES(5,'España');
INSERT INTO REGISTRO.PAIS (idPais,nombre) VALUES(6,'Turkia');

INSERT INTO REGISTRO.PASAJERO (
    idPasajero,
    nombre,
    paterno,
    materno,
    tipoDocumento,
    numeroDocumento,
    nacimiento,
    mail,
    clave,
    idPais
)VALUES(
    1,
    'Jose Ivan',
    'Caballero',
    'Pomajambo',
    'DNI',
    '412488899',
    STR_TO_DATE('01-01-1991', '%d-%m-%Y'),
    '',
    MD5('liebe'),
    1
);
INSERT INTO REGISTRO.PASAJERO (
    idPasajero,
    nombre,
    paterno,
    materno,
    tipoDocumento,
    numeroDocumento,
    nacimiento,
    mail,
    clave,
    idPais
)VALUES(
    2,
    'Erika',
    'Requena',
    'Bermudez',
    'DNI',
    '99999999',
    STR_TO_DATE('01-01-1961', '%d-%m-%Y'),
    '',
    MD5('kinder'),
    1
);

INSERT INTO REGISTRO.AEROPUERTO (idAeropuerto,nombre,idPais)
VALUES 
('1','Jorge Chávez','1'),
('2','Bariloche','2'),
('3','Aeropuerto Internacional de México','3'),
('4','Mar del Plata','4'),
('5','Aeropuerto Adolfo Suárez Madrid-Barajas','5'),
('6','Aeropuerto de Barcelona-El Prat','5'),
('7','Istanbul Ataturk Airport','6');

INSERT INTO REGISTRO.TARIFA (idTarifa,clase,precio,impuesto)
VALUES
('1','Supervip',1200,12),
('2','Vip',1000,12),
('3','Nacional',800,12),
('4','Económica',500,0);


INSERT INTO REGISTRO.RESERVA(
    idReserva,
    costo,
    fecha,
    observacion
)VALUES
    (1,'140',STR_TO_DATE('27-04-2016', '%d-%m-%Y'),''),
    (2,'120',STR_TO_DATE('26-04-2016', '%d-%m-%Y'),''),
    (3,'100',STR_TO_DATE('06-05-2016', '%d-%m-%Y'),'');