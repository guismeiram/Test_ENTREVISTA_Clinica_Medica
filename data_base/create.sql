create sequence hibernate_sequence start 1 increment 1;
create table tb_consulta (id int8 not null, primary key (id));
create table tb_consulta_consultorio (consulta_id int8 not null, consultorio_id int8 not null);
create table tb_consulta_medico (consulta_id int8 not null, medico_id int8 not null);
create table tb_consultorio (id int8 not null, data_hora_consulta timestamp, numero_consultorio varchar(255), primary key (id));
create table tb_consultorio_medico (consultorio_id int8 not null, medico_id int8 not null);
create table tb_medico (id int8 not null, crm varchar(255), especialidade_medica varchar(255), idade int4 not null, nome varchar(255), primary key (id));
alter table tb_consulta_consultorio add constraint UK_sv43t1afff1s71q8qaiiu53ct unique (consultorio_id);
alter table tb_consulta_medico add constraint UK_1wbg8ndg4mh5r6m44g9k1id8x unique (medico_id);
alter table tb_consultorio_medico add constraint UK_f5u26p3uxyk0a2eg0pxrpus0d unique (medico_id);
alter table tb_consulta_consultorio add constraint FKjxpt2jyy38bmjfg4rvvkklj12 foreign key (consultorio_id) references tb_consultorio;
alter table tb_consulta_consultorio add constraint FKhlv90l1n4v178l6obi9u40a3i foreign key (consulta_id) references tb_consulta;
alter table tb_consulta_medico add constraint FKdh352arw4kh2rm5pjfcu532e4 foreign key (medico_id) references tb_medico;
alter table tb_consulta_medico add constraint FKg9h9d5nyk8123nfw0pe0ka3xt foreign key (consulta_id) references tb_consulta;
alter table tb_consultorio_medico add constraint FKpstscldit5729buqr9y6fs2im foreign key (medico_id) references tb_medico;
alter table tb_consultorio_medico add constraint FKfg5kc7yyd7kt8odxvdh0a06lb foreign key (consultorio_id) references tb_consultorio;
