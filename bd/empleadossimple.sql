create database if not exists empleados_simple;
use empleados_simple;

create table if not exists emp (cif varchar(9) NOT NULL, nombre varchar(20), apellidos varchar(20), edad integer, primary key (cif));
insert into emp values ("34334789H", "Antonio", "Martín", 23);
insert into emp values ("21094387T", "Juan", "González", 40);
insert into emp values ("01293474E", "Isabel", "Fuentes", 18);
insert into emp values ("23948745F", "Lucille", "King", 25);
insert into emp values ("40948574G", "Neo", "Preno", 12);


GRANT ALL ON empleados_simple.* TO maza@localhost IDENTIFIED BY 'maza';