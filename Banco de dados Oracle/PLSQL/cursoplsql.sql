CREATE TABLE segmercado (id NUMBER(5),
    descricao VARCHAR2(100));
    
ALTER TABLE segmercado ADD CONSTRAINT segmercado_id_pk 
PRIMARY KEY (id)

CREATE TABLE client(
        ID NUMBER(5),
        razao_social VARCHAR2(100),
        CNPJ VARCHAR2(20),
        segmercado_id NUMBER(5),
        data_inclusao DATE,
        faturamento_previsto NUMBER(10,2),
        categoria VARCHAR2(20));
        
alter table cliente add constraint cliente_id_pk primary key (id)

alter table cliente
add constraint cliente_segmercado_fk
foreign key (segmercado_id)
references segmercado (id)


--------------------- AULA 01 ---------------------

set serveroutput on -- para exibir os resultador na saida do script

DECLARE
    v_id number(5) := 1;
    
BEGIN
    v_id := 2;
    DBMS_OUTPUT.PUT_LINE(v_id);    
    
END;

DECLARE
    v_a number(5);
    v_b number(5);
    v_c number(5);
BEGIN
    v_a := 10;
    v_b := 15;
    v_c := v_a + v_b;
    DBMS_OUTPUT.PUT_LINE('Valor de V_C: ' || v_c);
END;

--------------------- AULA 02 ---------------------

-- INSERT

DECLARE
    v_id number(5) :=1;
    v_descricao varchar2(100) := 'varejo';
    
BEGIN
    insert into segmercado values (v_id, v_descricao);
    commit;
    
END;

select * from segmercado

-- nome_da_tabela.nome_da_coluna%type para pegar o mesmo tipo
-- de dado da coluna na tabela e atribuir a variavel.

DECLARE
    v_id segmercado.id%type :=2;
    v_descricao segmercado.descricao%type := 'atacado';
    
BEGIN
    insert into segmercado values (v_id, upper(v_descricao));
    commit;
    
END;

-- upper: para guarda na coluna em maiusculo.

DECLARE
    v_id segmercado.id%type := 1;
    v_descricao segmercado.descricao%type := 'varejista';
BEGIN
    update segmercado
    set descricao = upper(v_descricao)
    where id = v_id;
    
    v_id := 2;
    v_descricao := 'atacadista';
    
    update segmercado
    set descricao = upper(v_descricao)
    where id = v_id;
    
    commit;
END;

-- UPDATE

DECLARE
    v_id segmercado.id%type := 3;
    v_descricao segmercado.descricao%type := 'esportivo';
BEGIN
    insert into segmercado values (v_id, upper(v_descricao));
    commit;
END;

-- DELETE

DECLARE
    v_id segmercado.id%type := 3;

BEGIN
    delete from segmercado
    where id = v_id;
    commit;

END;    


select * from segmercado

--------------------- AULA 03 ---------------------

-- Procedure Criando

CREATE PROCEDURE incluir_segmercado(
        p_id in number,
        p_descricao in varchar2)
IS
BEGIN
    insert into segmercado
        values (p_id, upper(p_descricao));
    commit;
END;    

--

EXECUTE incluir_segmercado(3, 'Farmaceutico')

--

BEGIN
    incluir_segmercado(4,'Industrial');
END;

--

select * from segmercado order by id 

--

CREATE OR REPLACE PROCEDURE incluir_segmercado(
    p_id in segmercado.id%type,
    p_descricao in segmercado.descricao%type)
IS
BEGIN
    insert into segmercado
        values(p_id, upper(p_descricao));
    commit;
END;

-- FUNÇÃO

CREATE OR REPLACE FUNCTION obter_descricao_segmercado
    (p_id IN segmercado.id%type)
    RETURN segmercado.descricao%type
IS
    v_descricao segmercado.descricao%type;
BEGIN
    SELECT descricao INTO v_descricao
        FROM segmercado
        WHERE id = p_id;
    RETURN v_descricao;
END;  

-- EXECUTANDO A FUNÇÃO

VARIABLE g_descricao varchar2(100)
EXECUTE :g_descricao := obter_descricao_segmercado(1)
PRINT g_descricao

--

SET SERVEROUTPUT ON
DECLARE
    v_descricao segmercado.descricao%type;
BEGIN
    v_descricao := obter_descricao_segmercado(2);
    dbms_output.put_line('Descricao: '||v_descricao);
END;

--

CREATE OR REPLACE PROCEDURE incluir_cliente(
    p_id in cliente.id%type,
    p_razao_social in cliente.razao_social%type,
    p_cnpj cliente.cnpj%type,
    p_segmercado_id in cliente.segmercado_id%type,
    p_faturamento_previsto in cliente.faturamento_previsto%type)
IS
    v_categoria cliente.categoria%type;
BEGIN
    IF p_faturamento_previsto < 10000 THEN
        v_categoria := 'PEQUENO';
    ELSIF p_faturamento_previsto < 50000 THEN
        v_categoria := 'MEDIO';
    ELSIF p_faturamento_previsto < 100000 THEN    
        v_categoria := 'MEDIO GRANDE';
    ELSE
        v_categoria := 'GRANDE';
    END IF;
    
    insert into cliente
        values (p_id, upper(p_razao_social), p_cnpj, p_segmercado_id,SYSDATE,
        p_faturamento_previsto, v_categoria);
    commit;
END;

--

EXECUTE incluir_cliente(1,'SUPERMECADO XYZ','12345',NULL,150000);

--

SELECT * FROM CLIENTE

--

CREATE OR REPLACE FUNCTION categoria_cliente
    (p_faturamento_previsto in cliente.faturamento_previsto%type)
    return cliente.categoria%type
IS
BEGIN
    IF p_faturamento_previsto < 10000 THEN
        RETURN 'PEQUENO';
    ELSIF p_faturamento_previsto < 50000 THEN
        RETURN 'MEDIO';
    ELSIF p_faturamento_previsto < 100000 THEN
        RETURN 'MEDIO GRANDE';
    ELSE
        RETURN 'GRANDE';
    END IF;
END;

--

execute incluir_cliente (2,'SUPERMERCADO IDK','67890', null,90000);

--

SELECT * FROM CLIENTE

-- inclui a função categoria_cliente em uma procedure
-- incluir cliente

create or replace PROCEDURE incluir_cliente(
    p_id in cliente.id%type,
    p_razao_social in cliente.razao_social%type,
    p_cnpj cliente.cnpj%type,
    p_segmercado_id in cliente.segmercado_id%type,
    p_faturamento_previsto in cliente.faturamento_previsto%type)
IS
    v_categoria cliente.categoria%type;
BEGIN
    
    v_categoria := categoria_cliente(p_faturamento_previsto);

    insert into cliente
        values (p_id, upper(p_razao_social), p_cnpj, p_segmercado_id,SYSDATE,
        p_faturamento_previsto, v_categoria);
    commit;
END;

--


CREATE OR REPLACE FUNCTION obter_descricao_segmercado (
    p_id IN segmercado.id%type)
    RETURN segmercado.descricao%type
IS
    v_descricao segmercado.descricao%type;
BEGIN
    select descricao into v_descricao
        from segmercado
        where id = p_id;
    return v_descricao;
END;    

SET SERVEROUTPUT ON

DECLARE
    v_descricao segmercado.descricao%type;
BEGIN
    v_descricao := obter_descricao_segmercado(2);
    dbms_output.put_line('Descricao: ' || v_descricao);
END;

--

VARIABLE g_descricao varchar2(100)
EXECUTE :g_descricao := obter_descricao_segmercado (1)
PRINT g_descricao   
    
----------------------- AULA 04 ---------------------

select * from cliente

--

CREATE OR REPLACE PROCEDURE format_cnpj(
    p_cnpj in out cliente.cnpj%type)
IS
BEGIN
    p_cnpj := substr(p_cnpj,1,2) ||'/'|| substr(p_cnpj,3);
END;

-- in out permite fazer leitura ou alteração do parametro
    
variable g_cnpj varchar2(10)    
execute :g_cnpj := '12345'   
print g_cnpj

--

EXECUTE format_cnpj(:g_cnpj)

--

print g_cnpj

--

execute incluir_cliente(3,'Industria RTY','12378', NULL, 110000)

select * from cliente order by id

----------------------- AULA 05 ---------------------

-- Se não vai devolver valor é procedure, caso retorne é função

CREATE OR REPLACE PROCEDURE atualizar_cli_seg_mercado(
    p_id cliente.id%type,
    p_segmercado_id in cliente.segmercado_id%type)
IS
BEGIN
    UPDATE cliente
        SET segmercado_id = p_segmercado_id
        WHERE id = p_id;
    COMMIT;
END;    

-- LOOP BASICO

DECLARE
    v_segmercado_id cliente.segmercado_id%type := 1;
    v_i number(3);
BEGIN
        v_i := 1;
    LOOP
        atualizar_cli_seg_mercado(v_i, v_segmercado_id);
        v_i := v_i + 1;
        EXIT WHEN v_i > 3;
    END LOOP;
END;    

-- FOR LOOP BASICO

DECLARE
    v_segmercado_id cliente.segmercado_id%type := 2;
BEGIN
    FOR i IN 1..3 LOOP
        atualizar_cli_seg_mercado(i, v_segmercado_id);    
    END LOOP;
    COMMIT;
END;    

--

DECLARE
    v_id              NUMBER;
    v_segmercado_id   NUMBER;
BEGIN
    v_id := 1;
    v_segmercado_id := 2;
    atualizar_cli_seg_mercado(p_id => v_id, p_segmercado_id => v_segmercado_id);
--rollback; 
END;

--

DECLARE 
    v_segmercado_id cliente.segmercado_id%type := 1;
    v_i number(3);
BEGIN
    v_i := 3;
LOOP
    atualizar_cli_seg_mercado(v_i, v_segmercado_id);
    v_i := v_i + 1;
    EXIT WHEN v_i > 3;
    END LOOP;
END;    

--
DECLARE
    v_segmercado_id cliente.segmercado_id%type := 2;
    v_id cliente.id%type;
    CURSOR cur_cliente is SELECT id from cliente; 
BEGIN
    FOR cli_rec IN cur_cliente LOOP
       ATUALIZAR_CLI_SEG_MERCADO(cli_rec.id, v_segmercado_id);
    END LOOP;
END;

select * from cliente order by id

--------------------- AULA 06 ---------------------

-- o FETCH vai percorrendo o select pelo id e vai guardando o id de cada linha
-- na variavel v_id ou seja a cada linah que ele percorre o v_id vai sendo
-- atualizado, antes disso temos que declarar o cursor e lhe atribuir uma
-- função, como no exemplo abaixo é um select id from cliente
-- apos isso da um OPEN e um FETCH para ser feita a pesquisa
-- e por fim CLOSE para fechar o cursor.

DECLARE
    v_id cliente.id%type;
    v_segmercado_id cliente.segmercado_id%type := 1;
    CURSOR cursor_cliente IS
        SELECT id
        FROM cliente;
BEGIN
    OPEN cursor_cliente;
    
    LOOP
        FETCH cursor_cliente INTO v_id;
        EXIT WHEN cursor_cliente%NOTFOUND;
        atualizar_cli_seg_mercado(v_id, v_segmercado_id);
    END LOOP;
    
    CLOSE cursor_cliente;
    
    COMMIT;
END;

--

select * from cliente

-- Cursor com laço For

DECLARE
    v_segmercado_id cliente.segmercado_id%type := 2;
    CURSOR cursor_cliente IS
        SELECT id
        FROM cliente;
BEGIN
    
    FOR cli_rec IN cursor_cliente LOOP
        atualizar_cli_seg_mercado(cli_rec.id, v_segmercado_id);
    END LOOP;
            
    COMMIT;
END;

--------------------- AULA 07 ---------------------

create or replace PROCEDURE incluir_cliente(
    p_id in cliente.id%type,
    p_razao_social in cliente.razao_social%type,
    p_cnpj  cliente.cnpj%type,
    p_segmercado_id in cliente.segmercado_id%type,
    p_faturamento_previsto in cliente.faturamento_previsto%type)
IS
    v_categoria cliente.categoria%type;
    v_cnpj cliente.cnpj%type := p_cnpj;
BEGIN
    
    v_categoria := categoria_cliente(p_faturamento_previsto);
    
    format_cnpj(v_cnpj);

    insert into cliente
        values (p_id, upper(p_razao_social), v_cnpj, p_segmercado_id,SYSDATE,
        p_faturamento_previsto, v_categoria);
    commit;
    
EXCEPTION -- tratamento de erros!
    WHEN dup_val_on_index THEN
        raise_application_error(-20010, 'Cliente já cadastrado');
    
END;
--
-- set serveroutput on -- só precisa para o pacote dbms_output
--
EXECUTE incluir_cliente(6, 'Industria RTY', '12378', 10, 11000)
--

create or replace PROCEDURE incluir_cliente(
    p_id in cliente.id%type,
    p_razao_social in cliente.razao_social%type,
    p_cnpj  cliente.cnpj%type,
    p_segmercado_id in cliente.segmercado_id%type,
    p_faturamento_previsto in cliente.faturamento_previsto%type)
IS
    v_categoria cliente.categoria%type;
    v_cnpj cliente.cnpj%type := p_cnpj;
    e_null EXCEPTION;-- tipo exception, utilizado para o tratamento, em que e_null representa o nome do erro a ser tratado.
    pragma EXCEPTION_INIT (e_null, -1400);--Acrescentaremos outra exceção que irá associar e_null a algum código de erro, no caso, o -01400.
BEGIN
    
    v_categoria := categoria_cliente(p_faturamento_previsto);
    
    format_cnpj(v_cnpj);

    insert into cliente
        values (p_id, upper(p_razao_social), v_cnpj, p_segmercado_id,SYSDATE,
        p_faturamento_previsto, v_categoria);
    commit;
    
EXCEPTION
    WHEN dup_val_on_index THEN
        -- dbms_output.put_line ('Cliente já cadastrado');
        raise_application_error(-20010, 'Cliente já cadastrado');
    WHEN e_null THEN--O terceiro passo consiste em, dentro da parte de exceção, fazermos referência a este nome.
        raise_application_error(-20015, 'A coluna ID tem preenchimento obrigatorio.');
    WHEN others THEN--Existe um nome de exceção denominado others para o tratamento de erros não previstos, que se localizará depois de todos os demais tratamentos.
        raise_application_error(-20020, sqlerrm());--à função sqlerrm(), que se refere à error message ("mensagem de erro", em português), nativo do Oracle, que mostrará a mensagem de erro sugerida pelo programa caso o erro não seja tratado anteriormente.
    
END;

--

create or replace PROCEDURE atualizar_cli_seg_mercado(
    p_id cliente.id%type,
    p_segmercado_id in cliente.segmercado_id%type)
IS
    e_cliente_id_inexistente exception;--O primeiro passo para fazermos este tratamento consiste em lembrarmos que o erro é sempre tratado por nome, que por sua vez é associado ao tipo exception.
BEGIN
    UPDATE cliente
        SET segmercado_id = p_segmercado_id
        WHERE id = p_id;
    IF sql%notfound THEN--poderemos testar se o comando devolve algo ou não, Deste modo chamamos o atributo %NOTFOUND do Cursor implícito, e é como se tratássemos este comando anterior como sendo um Cursor, cujo nome é SQL, No caso, será devolvido um valor booleano (verdadeiro ou falso).
        --Será verdadeiro, ou true, se o comando anterior não tiver feito nada, ou seja, no caso de passarmos o código de um cliente inexistente. E será falso, ou false, quando o comando UPDATE atualizar pelo menos uma linha.
        raise e_cliente_id_inexistente;--O comando RAISE força o erro de execução
        END IF;
    COMMIT;
EXCEPTION
    WHEN e_cliente_id_inexistente then--Após a pausa do bloco é enviada uma mensagem, transferindo-se o fluxo para a parte de exceção    
    RAISE_APPLICATION_ERROR(-20100, 'Cliente inexistente');
END;  

--
select * from cliente

EXECUTE atualizar_cli_seg_mercado(10,1)







































