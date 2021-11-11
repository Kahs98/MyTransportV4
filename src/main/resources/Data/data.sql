INSERT INTO tipo_usuario (nombre) VALUES ('Cliente');
INSERT INTO tipo_usuario (nombre) VALUES ('Empresa de Servicio');
INSERT INTO tipo_usuario (nombre) VALUES ('Administrador');

INSERT INTO usuario (password,username,id_tipo_usuario) VALUES ('12345','cliente',1);
INSERT INTO usuario (password,username,id_tipo_usuario) VALUES ('us2','JuanC',1);
INSERT INTO usuario (password,username,id_tipo_usuario) VALUES ('12345','personal',2);
INSERT INTO usuario (password,username,id_tipo_usuario) VALUES ('us4','MartaP',2);
INSERT INTO usuario (password,username,id_tipo_usuario) VALUES ('admin','admin',3);

INSERT INTO administrador (apellidos,email,nombre,id_usuario) VALUES ('Artica Hurtadi','kev@gmail.com','Kevin',5);

INSERT INTO cliente (apellidos,celular,email,nombre,id_usuario) VALUES ('Rondan ',978563412,'rondan@gmail.com','Ruben',1);
INSERT INTO cliente (apellidos,celular,email,nombre,id_usuario) VALUES ('Quichca',975372412,'quichca@gmail.com','Luis',2);

INSERT INTO empresa_servicio (apellidos,celular,nombre_empresa,email,nombre, habilitado,id_usuario) VALUES ('Paz Jara',918173446,'especialista en limpieza de suelo laminado','12345MP@gmail.com','Marta',true,4);
INSERT INTO empresa_servicio (apellidos,celular,nombre_empresa,email,nombre, habilitado,id_usuario) VALUES ('Galvez Acosta',912433412,'10 años de experiencia en limpieza','pedro123@gmail.com','Pedro',true,3);


INSERT INTO horario (lunes,martes,miercoles,jueves,viernes,sabado,domingo,id_company_service) VALUES (false,true,true,true,true,true,true,2);
INSERT INTO horario (lunes,martes,miercoles,jueves,viernes,sabado,domingo,id_company_service) VALUES (true,true,true,true,true,true,true,1);

INSERT INTO ambiente (nombre) VALUES ('Dormitorio');
INSERT INTO ambiente (nombre) VALUES ('Comedor');
INSERT INTO ambiente (nombre) VALUES ('Cocina');
INSERT INTO ambiente (nombre) VALUES ('Biblioteca');
INSERT INTO ambiente (nombre) VALUES ('Baño');
INSERT INTO ambiente (nombre) VALUES ('Sala');



INSERT INTO distrito (nombre) VALUES ('Ancon');
INSERT INTO distrito (nombre) VALUES ('Ate');
INSERT INTO distrito (nombre) VALUES ('Barranco');
INSERT INTO distrito (nombre) VALUES ('Breña');
INSERT INTO distrito (nombre) VALUES ('Carabayllo');
INSERT INTO distrito (nombre) VALUES ('Chaclacayo');
INSERT INTO distrito (nombre) VALUES ('Chorrillos');
INSERT INTO distrito (nombre) VALUES ('Cieneguilla');
INSERT INTO distrito (nombre) VALUES ('Comas');
INSERT INTO distrito (nombre) VALUES ('El Agustino');
INSERT INTO distrito (nombre) VALUES ('Independencia');
INSERT INTO distrito (nombre) VALUES ('Jesus Maria');
INSERT INTO distrito (nombre) VALUES ('La Molina');
INSERT INTO distrito (nombre) VALUES ('La Victoria');
INSERT INTO distrito (nombre) VALUES ('Lima');
INSERT INTO distrito (nombre) VALUES ('Lince');
INSERT INTO distrito (nombre) VALUES ('Los Olivos');
INSERT INTO distrito (nombre) VALUES ('Lurigancho');
INSERT INTO distrito (nombre) VALUES ('Lurin');
INSERT INTO distrito (nombre) VALUES ('Magdalena del Mar');
INSERT INTO distrito (nombre) VALUES ('Miraflores');
INSERT INTO distrito (nombre) VALUES ('Pachacamac');
INSERT INTO distrito (nombre) VALUES ('Pucusana');
INSERT INTO distrito (nombre) VALUES ('Pueblo Libre');
INSERT INTO distrito (nombre) VALUES ('Puente Piedra');
INSERT INTO distrito (nombre) VALUES ('Punta Hermosa');
INSERT INTO distrito (nombre) VALUES ('Punta Negra');
INSERT INTO distrito (nombre) VALUES ('Rimac');
INSERT INTO distrito (nombre) VALUES ('San Bartolo');
INSERT INTO distrito (nombre) VALUES ('San Borja');
INSERT INTO distrito (nombre) VALUES ('San Isidro');
INSERT INTO distrito (nombre) VALUES ('San Juan de Lurigancho');
INSERT INTO distrito (nombre) VALUES ('San Juan de Miraflores');
INSERT INTO distrito (nombre) VALUES ('San Luis');
INSERT INTO distrito (nombre) VALUES ('San Martin de Porres');
INSERT INTO distrito (nombre) VALUES ('San Miguel');
INSERT INTO distrito (nombre) VALUES ('Santa Anita');
INSERT INTO distrito (nombre) VALUES ('Santa Maria del Mar');
INSERT INTO distrito (nombre) VALUES ('Santa Rosa');
INSERT INTO distrito (nombre) VALUES ('Santiago de Surco');
INSERT INTO distrito (nombre) VALUES ('Surquillo');
INSERT INTO distrito (nombre) VALUES ('Villa El Salvador');
INSERT INTO distrito (nombre) VALUES ('Villa Maria del Triunfo');

INSERT INTO vehiculo (nombre,id_cliente,id_distrito) VALUES ('A2b',2,3);
INSERT INTO vehiculo (nombre,id_cliente,id_distrito) VALUES ('Ave Hybrid Bikes',1,5);
INSERT INTO vehiculo (nombre,id_cliente,id_distrito) VALUES ('Benelli',1,6);

INSERT INTO reserva (duracion,estado,fecha,hora_inicio,kit_limpieza_extra, precio, id_company_service,id_vehiculo) VALUES (2,'realizado','2019-07-17', '08:00',true,80,2,1);
INSERT INTO reserva (duracion,estado,fecha,hora_inicio,kit_limpieza_extra, precio, id_company_service,id_vehiculo) VALUES (3,'realizado','2019-07-17', '08:00',true,90,2,2);

INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,1,1);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (3,2,1);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,3,1);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (3,4,1);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,5,1);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,6,1);

INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,1,2);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,2,2);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,3,2);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,4,2);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (1,5,2);
INSERT INTO detalle_reserva (cantidad,id_ambiente,id_reserva) VALUES (2,6,2);

INSERT INTO parametro (nombre,valor,unidad) VALUES ('Tiempo de limpieza',45,'minutos');
INSERT INTO parametro (nombre,valor,unidad) VALUES ('Costo de promedio',15,'soles/hora');
INSERT INTO parametro (nombre,valor,unidad) VALUES ('Costo kit',50,'soles/hora');
