insert into Paciente (nome, telefone) values ('Julia', '99887755');
insert into Paciente (nome, telefone) values ('Pedro', '88775544');
insert into Paciente (nome, telefone) values ('Juan', '77554433');

insert into Medico (nome, crm) values ('Paulo', '90.264/SP');
insert into Medico (nome, crm) values ('Bruno', '80.375/TO');
insert into Medico (nome, crm) values ('Milena', '70.486/GO');

insert into Consulta (data, paciente_id ,medico_id ,valor, observacao) values ('20-10-2023',1 , 1 ,200, 'Raio-X');
insert into Consulta (data, paciente_id ,medico_id , valor, observacao) values ('16-06-2023',1 ,2, 150, 'Ultrasson');
insert into Consulta (data, paciente_id ,medico_id ,valor, observacao) values ('03-11-2023',2 , 1 ,200, 'Genicologista');