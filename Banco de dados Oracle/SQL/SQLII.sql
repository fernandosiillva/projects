----------------------AULA 01----------------------------------

SQL> @DIRETORIO_DO_ARQUIVO_SQL/sql1br.sql
/

select table_name from user_tables;

select aluno.nome, curso.nome from aluno 
    join matricula on matricula.aluno_id = aluno.id 
    join curso on curso.id = matricula.curso_id;

select a.nome, c.nome from aluno a 
    join matricula m on m.aluno_id = a.id 
    join curso c on c.id = m.curso_id;
    
select a.nome from aluno a where exists(
    select m.id from matricula m where m.aluno_id = a.id
);

select a.nome from aluno a where not exists(
    select m.id from matricula m where m.aluno_id = a.id
);    
    
select * from exercicio e where exists(
    select r.id from resposta r where r.exercicio_id = e.id
);    

select * from exercicio e where not exists(
    select r.id from resposta r where r.exercicio_id = e.id
);

select c.nome from curso c where exists (
    select m.id from matricula m where m.curso_id = c.id
);

select c.nome from curso c where not exists (
    select m.id from matricula m where m.curso_id = c.id
);

show parameter nls_lang;


@C:\Users\ferna\Downloads\sql1br.sql
/

select a.nome from aluno a where not exists(
select m.id from matricula m where m.aluno_id = a.id)

select * from matricula
/


select a.nome from aluno a where not exists(
select m.id from matricula m where m.aluno_id = a.id 
and extract (year from data) = 2015)
/

select a.nome from aluno a where not exists (
    select m.id from matricula m where m.aluno_id = a.id and 
    m.data > (select sysdate - interval '1' year from dual));
/

select a.nome from aluno a where not exists (
    select m.id from matricula m where m.aluno_id = a.id and 
    m.data > (select sysdate - interval '1' year from dual));

----------------------AULA 02----------------------------------    
    
desc nota    

desc resposta

desc exercicio

desc secao




select c.nome, count(e.id) as quantidade from exercicio e
join secao s on s.id = e.secao_id
join curso c on c.id = s.curso_id
group by c.nome
/

select c.nome, count(a.id) from curso c
join matricula m on m.curso_id = c.id
join aluno a on a.id = m.aluno_id
group by c.nome
/    

desc curso
/

desc matricula
/

select c.nome, count(a.id) as quantidade from curso c    
join matricula m on m.curso_id = c.id    
join aluno a on a.id = m.aluno_id
group by c.nome
    
desc nota
desc resposta    
desc exercicio
desc secao
desc curso

select c.nome, avg(n.nota) from nota n
join resposta r on r.id = n.resposta_id
join exercicio e on e.id = r.exercicio_id
join secao s on s.id = e.secao_id
join curso c on c.id = s.curso_id
group by c.nome
/


select c.nome,avg(n.nota) as media from nota n
join resposta r on r.id = n.resposta_id
join exercicio e on e.id = r.exercicio_id
join secao s on s.id = e.secao_id
join curso c on c.id = s.curso_id
group by c.nome
/

desc curso
desc nota
desc resposta
desc exercicio
desc secao
desc aluno

select c.nome, avg(n.nota) as media from nota n
join resposta r on r.id = n.resposta_id
join exercicio e on e.id = r.exercicio_id
join secao s on s.id = e.secao_id
join curso c on c.id = s.curso_id
join aluno a on a.id = r.aluno_id
where a.nome like '%Silva%' or a.nome like '%Santos%'
group by c.nome    
/    

desc resposta    
desc exercicio
desc secao

select count(r.id) as quantidade, e.pergunta from resposta r
join exercicio e on e.id = r.exercicio_id
--join secao s on s.id = e.secao_id
--join curso c on c.id = s.curso_id
group by e.pergunta
 /
 
select e.pergunta, count(r.id) as quantidade from exercicio e 
    join resposta r on r.exercicio_id = e.id  
group by e.pergunta
order by count(r.id) desc;

desc nota    
desc aluno    
desc curso
desc matricula
desc resposta

select a.nome, c.nome, avg(n.nota) as media from nota n
    join resposta r on r.id = n.resposta_id
    join exercicio e on e.id = r.exercicio_id
    join secao s on s.id = e.secao_id
    join curso c on c.id = s.curso_id
    join aluno a on a.id = r.aluno_id
group by a.nome, c.nome;

----------------------AULA 03----------------------------------       
    
select a.nome, c.nome, avg(n.nota) from nota n
join reposta r on r.id = n.resposta_id
join exercicio e on e.id = r.exercicio_id
join secao s on s.id = e.secao_id
join curso c on c.id = s.curso_id
join aluno a on a.id = r.aluno_id
group by a.nome, c.nome
having avg(n.nota) < 5


select count(a.id), c.nome from curso c
join matricula m on m.curso_id = c.id
join aluno a on a.id = m.aluno_id
group by c.nome
having count(a.id) < 3

desc resposta

select a.nome, c.nome, avg(n.nota) as media from nota n
join resposta r on r.id = n.resposta_id
join exercicio e on e.id = r.exercicio_id
join secao s on s.id = e.secao_id
join curso c on c.id = s.curso_id
join aluno a on a.id = r.aluno_id
group by c.nome,a.nome
having avg(n.nota) <= 5

select count(a.id) as quantidade, c.nome from curso c
join matricula m on m.curso_id = c.id
join aluno a on m.aluno_id = a.id
group by c.nome
having count(a.id) < 3

desc nota

select a.nome, c.nome, avg(n.nota) as media from nota n
join resposta r on r.id = n.resposta_id
join exercicio e on e.id = r.exercicio_id
join secao s on s.id = e.secao_id
join curso c on c.id = s.curso_id
join aluno a on a.id = r.aluno_id
group by a.nome, c.nome
having avg(n.nota) < 5

desc matricula

select c.nome, count(m.id) as quantidade from curso c
join matricula m on c.id = m.curso_id
group by c.nome
having count(m.id) > 1

desc curso

select c.nome, count(s.id) as quantidade from curso c
join secao s on c.id = s.curso_id
group by c.nome
having count(s.id) > 3


----------------------AULA 04 ----------------------------------       

desc matricula

select distinct tipo from matricula

select c.nome, m.tipo, count(m.id) as quantidade from matricula m
join curso c on c.id = m.curso_id
where m.tipo = 'PAGA_PF' or m.tipo = 'PAGA_PJ'
group by c.nome, m.tipo

select c.nome, m.tipo, count(m.id) as quantidade from matricula m
join curso c on c.id = m.curso_id
where m.tipo in ('PAGA_PF','PAGA_PJ')
group by c.nome, m.tipo

select * from aluno

select a.nome, c.nome from curso c
join matricula m on   m.curso_id = c.id
join aluno a on a.id = m.aluno_id
where a.id in (1,3,4)
order by a.nome

select * from curso

select a.nome as aluno, c.nome as curso from curso c
join matricula m on m.curso_id = c.id
join aluno a on a.id = m.aluno_id
where c.id in (1,9)

desc matricula

select distinct tipo from matricula

select c.nome, m.tipo, count(m.id) as quantidade from matricula m
join curso c on m.curso_id = c.id
where m.tipo in ('PAGA_PJ','PAGA_PF')
group by c.nome, m.tipo

select * from aluno

select c.nome, a.nome from curso c
join matricula m on m.curso_id = c.id
join aluno a on a.id = m.aluno_id
where m.aluno_id in (1,3,4)
order by a.nome

select * from curso

select a.nome, c.nome from curso c
join matricula m on m.curso_id = c.id
join aluno a on m.aluno_id = a.id
where c.id in (1,9)

select distinct tipo from matricula


select c.nome, count(m.id) as quantidade from curso c
join matricula m on m.curso_id = c.id
where m.tipo in ('PAGA_PF','PAGAPJ')
group by c.nome


desc resposta
desc secao

select e.pergunta as exercicio, count(r.id) as quantidade,c.nome from exercicio e
join resposta r on e.id = r.exercicio_id
join secao s on s.id = e.secao_id
join curso c on c.id = s.curso_id
where c.id in (1,3)
group by e.pergunta,c.nome

---------------------- AULA 05 ----------------------------------   

select a.nome, c.nome, avg(n.nota) as media, 
avg(n.nota) - (select avg(n.nota) from nota n) as diferenca from nota n
join resposta r on r.id = n.resposta_id
join exercicio e on e.id = r.exercicio_id
join secao s on s.id = e.secao_id
join curso c on c.id = s.curso_id
join aluno a on a.id = r.aluno_id
group by c.nome, a.nome


select a.nome,(select count(r.id) from resposta r where a.id = r.aluno_id)
as respostas from aluno a

select a.nome,(select count(m.id) from matricula m where a.id = m.aluno_id)
as matriculas from aluno a

select a.nome, c.nome, avg(n.nota) as media, 
avg(n.nota) - (select avg(n.nota) from nota n) as diferenca from nota n
join resposta r on r.id = n.resposta_id
join exercicio e on e.id = r.exercicio_id
join secao s on s.id = e.secao_id
join curso c on c.id = s.curso_id
join aluno a on r.aluno_id = a.id
group by a.nome, c.nome

select a.nome ,
(select count(r.id) from resposta r where r.aluno_id = a.id) as quantidade
from aluno a

select a.nome ,
(select count(m.id) from matricula m where m.aluno_id = a.id) as matricula
from aluno a

select data from matricula
desc aluno

select a.nome, c.nome,
avg(n.nota) as media,
avg(n.nota) - (select avg(n.nota) from nota n) as diferenca
from nota n
join resposta r on r.id = n.resposta_id
join exercicio e on e.id = r.exercicio_id
join secao s on s.id = e.secao_id
join curso c on c.id = s.curso_id
join aluno a on a.id = r.aluno_id
join matricula m on m.aluno_id = a.id
where m.data > '01-01-2015'
group by a.nome, c.nome

select 
    a.nome, 
    c.nome,
    avg(n.nota) as media, 
    avg(n.nota) - (select avg(n.nota) from nota n) as diferenca
 from nota n
    join resposta r on r.id = n.resposta_id
    join exercicio e on e.id = r.exercicio_id
    join secao s on s.id = e.secao_id
    join curso c on c.id = s.curso_id
    join aluno a on a.id = r.aluno_id
where a.id in (select aluno_id from matricula where data > (select sysdate - interval '6' month from dual))
group by c.nome, a.nome;

---------------------- AULA 06 ----------------------------------   

select a.nome, count (r.id) as respostas from aluno a
left join resposta r on r.aluno_id = a.id
group by a.nome

select a.nome, r.resposta_dada from aluno a
left join resposta r on r.aluno_id = a.id

insert into resposta(id, exercicio_id, aluno_id, resposta_dada)
values (28,1,5000,'vb e c#')

delete from resposta where aluno_id = 5000



select a.nome, resposta_dada from aluno a
left join resposta r on r.aluno_id = a.id and r.exercicio_id = 1


---------------------- AULA 07 ---------------------------------- 

select a.nome from aluno a

select count (a.id) from aluno a

select rownum, nome email from (select a.nome,a.email from aluno a order by a.nome)
where rownum <= 2 and email like '%.com'




select * from (select rownum r, nome 
from (select a.nome from aluno a order by a.nome)) where r > 5

select * from (select rownum r, nome from 
(select a.nome from aluno a order by a.nome) where rownum <= 10)
where r > 5
























    
    
    
    
    