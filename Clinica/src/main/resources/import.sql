insert into pessoa (tipo, nome, crm) values ( 'M','Pedro', '90.264/SP');
insert into pessoa (tipo, nome, crm) values ( 'M','Fernanda', '80.355/TO');
insert into pessoa (tipo, nome, telefone) values ('P', 'Julia', 235689);
insert into pessoa (tipo, nome, telefone) values ('P', 'Renata',124578);

insert into consulta (valor, medico_id, paciente_id, dataEHorario, observacao) values (200, 1 , 3, ' 2001-11-01T05:06', 'Raio-X');
insert into consulta (valor, medico_id, paciente_id, dataEHorario, observacao) values (150, 2 , 4, '2001-11-01T05:06', 'Ultrasson');

insert into role (nome) values ('ROLE_ADMIN');
insert into role (nome) values ('ROLE_USER');


insert into usuario (login, password) values  ('admin', '$2a$10$AP2f5JMWY8a80TWeSqB61.rjQ8r3BRvfLDwUI5VUITXRXZhSwJmvW');
insert into usuario (login, password) values  ('user', '$2a$10$AP2f5JMWY8a80TWeSqB61.rjQ8r3BRvfLDwUI5VUITXRXZhSwJmvW');

insert into usuario_roles (usuarios_id, roles_id) values (1,1);
insert into usuario_roles (usuarios_id, roles_id) values (2,2);


