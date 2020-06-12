GRANT EXECUTE ON ATUALIZAR_CLI_SEG_MERCADO TO USER_APP;
GRANT EXECUTE ON ATUALIZAR_FATURAMENTO_PREVISTO TO USER_APP;
GRANT EXECUTE ON EXCLUIR_CLIENTE TO USER_APP;
GRANT EXECUTE ON INCLUIR_CLIENTE TO USER_APP;

GRANT SELECT ON CLIENTE TO USER_APP;

INSERT INTO cliente (id, razao_social) values (5, 'PADARIA DEF');

ROLLBACK;


----------------------- Aula 02 --------------------------

CREATE PUBLIC SYNONYM INCLUIR_CLIENTE FOR
user_dev.INCLUIR_CLIENTE;

CREATE PUBLIC SYNONYM ATUALIZAR_CLI_SEG_MERCADO FOR
user_dev.ATUALIZAR_CLI_SEG_MERCADO;

CREATE PUBLIC SYNONYM ATUALIZAR_FATURAMENTO_PREVISTO FOR
user_dev.ATUALIZAR_FATURAMENTO_PREVISTO;

CREATE PUBLIC SYNONYM EXCLUIR_CLIENTE FOR
user_dev.EXCLUIR_CLIENTE;

CREATE PUBLIC SYNONYM CLIENTE FOR
user_dev.CLIENTE;

@utldtree.sql

EXEC deptree_fill('TABLE','USER_DEV','CLIENTE')

EXEC deptree_fill('procedure','user_dev','incluir_CLIENTE')

select * from deptree_temptab

select nested_level,schema,type,name from deptree order by seq#

------------------ aula 04 ------------------------------

-- Criando Pacote

-- Cabeçalho, onde outras aplicações conseguem
-- enxergar os parametros do pack.
CREATE OR REPLACE PACKAGE CLIENTE_PAC IS
    
    PROCEDURE INCLUIR_CLIENTE
    (P_ID IN CLIENTE.ID%TYPE,
     P_RAZAO_SOCIAL IN CLIENTE.RAZAO_SOCIAL%TYPE,
     P_CNPJ CLIENTE.CNPJ%TYPE,
     P_SEGMERCADO_ID CLIENTE.SEGMERCADO_ID%TYPE,
     P_FATURAMENTO_PREVISTO CLIENTE.FATURAMENTO_PREVISTO%TYPE);
     
END;

-- Corpo do pacote
     
CREATE OR REPLACE PACKAGE BODY CLIENTE_PAC IS

    PROCEDURE INCLUIR_CLIENTE 
   (p_id in cliente.id%type,
    p_razao_social in cliente.razao_social%type,
    p_CNPJ cliente.CNPJ%type ,
    p_segmercado_id cliente.segmercado_id%type,
    p_faturamento_previsto cliente.faturamento_previsto%type)
IS
    v_categoria cliente.categoria%type;
    v_CNPJ cliente.cnpj%type := p_CNPJ;
    v_codigo_erro number(5);
    v_mensagem_erro varchar2(200);
    v_dummy number;
    v_verifica_segmento boolean;
    e_segmento exception;
BEGIN
    v_verifica_segmento := 	verifica_segmento_mercado(p_segmercado_id);
    IF v_verifica_segmento = false THEN
        RAISE e_segmento;
    END IF;
    v_categoria := obter_categoria_cliente(p_faturamento_previsto);
    format_cnpj (v_cnpj);
    INSERT INTO cliente 
          VALUES (p_id, UPPER(p_razao_social), v_CNPJ, p_segmercado_id
                  ,SYSDATE, p_faturamento_previsto, v_categoria);
   COMMIT;   
EXCEPTION
    WHEN dup_val_on_index then
        raise_application_error(-20010,'Cliente já cadastrado');
    WHEN e_segmento then
        raise_application_error (-20011,'Segmento de mercado inexistente');
    WHEN OTHERS then
        v_codigo_erro := sqlcode;
        v_mensagem_erro := sqlerrm;
        raise_application_error (-20000,to_char(v_codigo_erro)||v_mensagem_erro);
END;

END;

--

GRANT EXECUTE ON CLIENTE_PAC TO USER_APP;
--
CREATE PUBLIC SYNONYM CLIENTE_PAC FOR USER_DEV.CLIENTE_PAC

-- atualizando a package

create or replace PACKAGE CLIENTE_PAC IS
    
     PROCEDURE INCLUIR_CLIENTE
     (P_ID IN CLIENTE.ID%TYPE,
     P_RAZAO_SOCIAL IN CLIENTE.RAZAO_SOCIAL%TYPE,
     P_CNPJ CLIENTE.CNPJ%TYPE,
     P_SEGMERCADO_ID CLIENTE.SEGMERCADO_ID%TYPE,
     P_FATURAMENTO_PREVISTO CLIENTE.FATURAMENTO_PREVISTO%TYPE);
    
     PROCEDURE ATUALIZAR_CLI_SEG_MERCADO
     (p_id cliente.id%type,
     p_segmercado_id cliente.segmercado_id%type);
     
     PROCEDURE ATUALIZAR_FATURAMENTO_PREVISTO
     (p_id in cliente.id%type,
     p_faturamento_previsto in cliente.faturamento_previsto%type);
    
     PROCEDURE EXCLUIR_CLIENTE
     (p_id in cliente.id%type); 
END;

--

create or replace PACKAGE BODY CLIENTE_PAC IS

    PROCEDURE INCLUIR_CLIENTE 
   (p_id in cliente.id%type,
    p_razao_social in cliente.razao_social%type,
    p_CNPJ cliente.CNPJ%type ,
    p_segmercado_id cliente.segmercado_id%type,
    p_faturamento_previsto cliente.faturamento_previsto%type)
IS
    v_categoria cliente.categoria%type;
    v_CNPJ cliente.cnpj%type := p_CNPJ;
    v_codigo_erro number(5);
    v_mensagem_erro varchar2(200);
    v_dummy number;
    v_verifica_segmento boolean;
    e_segmento exception;
BEGIN
    v_verifica_segmento := 	verifica_segmento_mercado(p_segmercado_id);
    IF v_verifica_segmento = false THEN
        RAISE e_segmento;
    END IF;
    v_categoria := obter_categoria_cliente(p_faturamento_previsto);
    format_cnpj (v_cnpj);
    INSERT INTO cliente 
          VALUES (p_id, UPPER(p_razao_social), v_CNPJ, p_segmercado_id
                  ,SYSDATE, p_faturamento_previsto, v_categoria);
   COMMIT;   
EXCEPTION
    WHEN dup_val_on_index then
        raise_application_error(-20010,'Cliente já cadastrado');
    WHEN e_segmento then
        raise_application_error (-20011,'Segmento de mercado inexistente');
    WHEN OTHERS then
        v_codigo_erro := sqlcode;
        v_mensagem_erro := sqlerrm;
        raise_application_error (-20000,to_char(v_codigo_erro)||v_mensagem_erro);
END;

    PROCEDURE ATUALIZAR_CLI_SEG_MERCADO
    (p_id cliente.id%type,
     p_segmercado_id cliente.segmercado_id%type)
IS
        e_fk exception;
        pragma exception_init(e_fk, -2291);
        e_no_update exception;
BEGIN
    UPDATE cliente
        SET segmercado_id = p_segmercado_id
        WHERE id = p_id;
    IF SQL%NOTFOUND then
        RAISE e_no_update;
    END IF;
    COMMIT;
EXCEPTION
    WHEN e_fk then
        RAISE_APPLICATION_ERROR (-20001,'Segmento de Mercado Inexistente');
    WHEN e_no_update then
       RAISE_APPLICATION_ERROR (-20002,'Cliente Inexistente');
END;

    PROCEDURE ATUALIZAR_FATURAMENTO_PREVISTO
    (p_id in cliente.id%type,
     p_faturamento_previsto in cliente.faturamento_previsto%type)
IS 
    v_categoria cliente.categoria%type;
    e_error_id exception;
BEGIN
    v_categoria := obter_categoria_cliente(p_faturamento_previsto);
    UPDATE cliente
        SET categoria = v_categoria,
            faturamento_previsto = p_faturamento_previsto
        WHERE id = p_id;
    IF SQL%NOTFOUND THEN
        RAISE e_error_id;
    END IF;
    COMMIT;
EXCEPTION
    WHEN e_error_id then
        raise_application_error(-20010,'Cliente inexistente');
END;

    PROCEDURE EXCLUIR_CLIENTE
    (p_id in cliente.id%type)
IS 
    e_error_id exception;
BEGIN
    DELETE FROM cliente
        WHERE id = p_id;
    IF SQL%NOTFOUND THEN
        RAISE e_error_id;
    END IF;
    COMMIT;
EXCEPTION
    WHEN e_error_id then
        raise_application_error(-20010,'Cliente inexistente');
END;

    
END;

--

grant execute on cliente_pac to user_app;

-- criando um pacote de exeção

create or replace package exception_pac
is
    e_null exception;
    pragma exception_init (e_null, -1400);
    
    e_fk exception;
    pragma exception_init (e_fk, -2291);

end;    

grant , insert on segmercado to user_app;

create public synonym segmercado for user_dev.segmercado;

drop public synonym segmercado for user_dev.segmercado;

grant execute on exception_pac to public;


grant public synonym exception_pac for user_dev.exception_pac;

GRANT EXECUTE ON EXCEPTION_PAC TO PUBLIC;

CREATE PUBLIC SYNONYM EXCEPTION_PAC FOR user_dev.EXCEPTION_PAC;


























