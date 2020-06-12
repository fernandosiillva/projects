
----------------------------------- AULA 01 --------------------------------------

create table compras
    (id number primary key,
    valor number, 
    observacoes varchar2(30), 
    data date,
    recebido char check(recebido in (0,1)))
/
    
create sequence id_seq;    
/

insert into compras
    (id, valor, data, observacoes,recebido)
    values
    (id_seq.nextval, 100, '12-jan-2007', 'Compras de maio', '1')
/

select * from compras
/

show parameter nls_lang;
/

select valor * 3, data from compras
/

select valor *3 as triplo from compras
/

insert into compras
    (id, valor, data, observacoes,recebido)
    values
    (id_seq.nextval, 500, '01-jul-2018', 'Compras de julho', '1')
/

select * from compras
/

select valor, data from compras where valor >100
/

select valor, data from compras where valor < 100
/

select * from compras where valor < 120 and recebido = '1'
/

select * from compras where valor < 120 or recebido = '1'
/

select * from compras where observacoes like 'Compras%'
/

select * from compras where observacoes like '%de%'
/


@C:\Users\ferna\Downloads\cap1br.sql
/

select * from compras
/

select valor, observacoes from compras where data >= '15/nov/2008'
/

select * from compras where data >= '15/nov/2008' and data < '15/nov/2010'
/

select * 
from compras 
where valor >= 15 
AND valor <= 35 
and observaCOES like 'LANCHONETE%'
/

SELECT * FROM COMPRAS where recebido = '0'
/


INSERT INTO COMPRAS (ID, VALOR, DATA, OBSERVACOES, RECEBIDO) 
VALUES (ID_SEQ.NEXTVAL, 100.0, '08-JAN-2010', 'COMIDA', '1');
/

select * from compras where valor > 5000 or recebido = '1'
/

select * from compras where (valor >= 1000 and valor <= 3000) or valor > 5000
/

----------------------------------- AULA 02 --------------------------------------


SELECT * FROM COMPRAS
/

SELECT * FROM COMPRAS WHERE VALOR BETWEEN 200 AND 700
/

SELECT * FROM COMPRAS WHERE DATA BETWEEN '01-JAN-2010' AND '01-ABR-2010'
/

UPDATE COMPRAS SET VALOR = 900 WHERE ID = 29
/

SELECT * FROM COMPRAS WHERE ID = 29
/

UPDATE COMPRAS SET VALOR = 100, OBSERVACOES = 'UMA COMPRA COMUN'
WHERE DATA NOT BETWEEN '01-JAN-2010' AND '01-ABR-2010'
/

SELECT * FROM COMPRAS
/

UPDATE COMPRAS SET OBSERVACOES = 'DATAS FESTTIVAS' 
WHERE DATA IN ('12-OUT-2010', '25-DEZ-2010', '12-JUN-2010')
/

delete from compras where id = 10
/

delete from compras where valor < 50
/

delete from compras where data between '05-03-209' and '20-03-2009'

update compras 
set observacoes = 'compras do dia dos namorados' 
where data = '12-06-2010'

select * from compras where data = '12-06-2010'
/

update compras set valor = valor + 10 where data < '01-06-2009'
/

update compras 
set observacoes = 'entrege antes de 2011', recebido = 1 
where data between '01-07-2009' and '01-07-2010'
/

select * from compras where not valor = 108.00


----------------------------------- AULA 03 --------------------------------------


desc compras
/

insert into compras (id, valor, observacoes, data, recebido)
values (id_seq.nextval, 500, '01-AGO-2015', NULL, '1')
/

SELECT * FROM COMPRAS WHERE DATA IS NULL
/

DELETE FROM COMPRAS WHERE DATA IS NULL
/

ALTER TABLE COMPRAS MODIFY (DATA DATE NOT NULL)
/

DESC COMPRAS
/

alter table compras modify (recebido char default '0' check (recebido in (0,1)))
/

insert into compras (id, valor, data,observacoes)
values (id_seq.nextval, 500,'03-ago-2015', 'presente pro filho')
/

select * from compras
/

alter table compras add (forma_pagt varchar2(10) 
check (forma_pagt in ('boleto', 'dinheiro', 'cartao')))
/

desc compras
/

insert into compras (id, valor, observacoes, data, forma_pagt)
values (id_seq.nextval, 500, 'presente pra mae', '15-ago-2015', 'boleto')
/

select * from compras
/

update compras set forma_pagt = 'dinheiro' where forma_pagt is null
/

alter table compras rename column forma_pagt to forma_pagto
/

ALTER TABLE COMPRAS MODIFY (observacoes varchar2(30) NOT NULL)
/

desc compras
/

create table compras(
    id number primary key,
    valor number, 
    observacoes varchar2(30) not null, 
    data date,
    recebido char default '0' check(recebido in (0,1)))
    forma_pagt varchar2(10) check (forma_pagt in ('boleto', 'dinheiro', 'cartao')
/


----------------------------------- AULA 04 --------------------------------------


select sum(valor) from compras
/

select sum(valor) from compras where data > '01-jan-2010'
/

select avg (valor) from compras
/

select count(id) from compras where data between '01-jan-2010' and '31-dez-2010'
/

select sum (valor) as soma, avg(valor) as media from compras
/

select sum(valor) as soma from compras where recebido = '1'
/

select sum (valor) as soma from compras where recebido = '0'
/

select sum(valor) from compras group by recebido
/

select recebido, sum(valor) from compras group by recebido
/

select extract(year from data), sum(valor) 
from compras group by extract (year from data)
/

select extract(year from data) as ano, sum(valor) as soma from compras
group by extract(year from data)
order by ano
/

SELECT RECEBIDO, SUM(VALOR) AS SOMA, COUNT(VALOR) AS TOTAL 
FROM COMPRAS 
GROUP BY RECEBIDO 
ORDER BY SOMA DESC;

select avg(valor) as media from compras where data < '12-03-2009'
/

desc compras

select forma_pagto ,sum(valor) as soma 
from compras 
where data < '10-11-2010' 
group by forma_pagto
/

select * from compras

SELECT COUNT(1) AS QUANTIDADE 
FROM COMPRAS 
WHERE DATA < '12-MAR-2009' AND RECEBIDO = '1';
/

select sum(valor) as soma , forma_pagto, recebido 
from compras group by forma_pagto, recebido
/

----------------------------------- AULA 05 --------------------------------------

select * from compras
/

create table compradores(
    id number primary key,
    nome varchar2(30) not null,
    endereco varchar2(30) not null,
    telefone varchar2(20) not null
)

desc compradores
/

create sequence id_compradores_seq
/

insert into compradores (id, nome, endereco, telefone)
values (ID_COMPRADORES_SEQ.nextval, 'Flavio', 'Rua do Duvidor, 123', '(11) 1111-1111')
/

insert into compradores (id, nome, endereco, telefone)
values (ID_COMPRADORES_SEQ.nextval, 'Nico', 'Av. Presidente Vargas, 321', '(22) 2222-2222')
/

select * from compradores
/

alter table compras add (comprador_id number)
/

desc compras
/

update compras set comprador_id = 1 where id <= 20
/

update compras set comprador_id = 2 where id > 20
/

select * from compras
/

select observacoes, valor, nome
from compras join compradores on compras.comprador_id = compradores.id
/

alter table compras add foreign key (comprador_id)
references compradores (id)
/

desc compras
/

ALTER TABLE COMPRAS MODIFY (COMPRADOR_ID NUMBER NOT NULL);
/

SELECT * FROM COMPRAS, COMPRADORES;
/

select nome, valor from compras 
join compradores on compras.comprador_id = compradores.id
where data < '09/07/2010'
/

SELECT * FROM COMPRAS JOIN COMPRADORES ON COMPRAS.COMPRADOR_ID = COMPRADORES.ID 
WHERE COMPRADOR_ID = 1;
/

SELECT COMPRAS.* FROM COMPRAS 
JOIN COMPRADORES ON COMPRAS.COMPRADOR_ID = COMPRADORES.ID 
WHERE NOME LIKE 'FLAVIO%';
/


select nome, sum(valor) as soma from COMPRAS 
join compradores on compras.comprador_id = compradores.id
group by nome
/







































