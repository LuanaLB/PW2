create table produto (
    id int primary key,
    valor decimal(10, 2),
    descricao varchar(255)
);

insert into produto (id, valor, descricao) values (1, 19.99, 'Pao');
insert into produto (id, valor, descricao) values (2, 22.99, 'Arroz');
insert into produto (id, valor, descricao) values (3, 2.50, 'Cuscuz');
