INSERT INTO user_dev.cliente (id, razao_social) 
values (5, 'PADARIA DEF');

------------------ aula 02 ---------------------------

CREATE OR REPLACE PROCEDURE APL_INCLUIR_CLIENTE
   (p_id in cliente.id%type,
    p_razao_social in cliente.razao_social%type,
    p_CNPJ in cliente.CNPJ%type,
    p_segmercado_id in cliente.segmercado_id%type,
    p_faturamento_previsto in cliente.faturamento_previsto%type)

IS
BEGIN
    incluir_cliente(p_id, p_razao_social,p_cnpj,p_segmercado_id,p_faturamento_previsto);
END;

EXEC apl_incluir_cliente(6 ,'SEGUNDO CLIENTE INCLUIDO POR USER_APP','23456',2,100000);

-- SEM SYNONYM

EXEC USER_DEV.cliente_pac.incluir_cliente(10,'PRIMEIRO INCLUIDO POR USER_APP VIA PACK','2489',2,100000);
-- COM SYNONYM
EXEC cliente_pac.incluir_cliente(15,'SEGUNDO INCLUIDO POR USER_APP VIA PACK','2489',2,100000);

-- executando uma procedure do pacote

EXEC cliente_pac.excluir_cliente(10);

select * from cliente
--
set serveroutput on
--
EXEC apl_incluir_cliente(null ,'CLIENTE','14890',3,100000);

--

create or replace procedure incluir_segmercado
    (p_id in segmercado.id%type,
     p_descricao in segmercado.descricao%type)
is
begin
    insert into segmercado values (p_id, upper (p_descricao));
exception
    when exception_pac.e_null then
    raise_application_error(-20015,'Campo obrigatorio');
end; 


--
exec incluir_segmercado (null,'segmercado uncluio por user_app');
--
select * from cliente

exec apl_incluir_cliente (35,'teste','78947',1,20000)

set serveroutput on

exec dbms_output.put_line(cliente_pac.g_cli_lim_fatur_pequeno)









