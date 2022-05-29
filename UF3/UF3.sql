-- holamon 

BEGIN
DBMS_OUTPUT.PUT_LINE('Hola mundo');
END;
/

-- exemples
DECLARE
    x integer;
BEGIN
    x:=3*5;
    DBMS_OUTPUT.PUT_LINE('x val: ' || x);
END;
/
DECLARE
x char(20);
BEGIN
	x:='Jordi';	
	x:=Upper(x);
	DBMS_OUTPUT.PUT_LINE('Hola: ' || x || '!');
END;
/

DECLARE
    x varchar2(20);
    y number(6);
BEGIN
    x:='Jordi';
    y:=length(x);
    DBMS_OUTPUT.PUT_LINE('longitud de: '||x|| ' es ' || y);
END;
/

DECLARE
    y number(6);
BEGIN
    y:=12;
    if y > 10 THEN
        DBMS_OUTPUT.PUT_LINE('Es major que 10');
    END IF;
END;
/

DECLARE
    y number(6);
BEGIN
    y:=12;
    if y > 10 THEN
        DBMS_OUTPUT.PUT_LINE('Es major que 10');
    else 
        DBMS_OUTPUT.PUT_LINE('Es menor que 10');
    END IF;
END;

-- Dies de la setmana
DECLARE
    x number(2);
    y varchar(20);
BEGIN
    x:=1;
    y:=CASE x
        WHEN 1 THEN 'Lunes'
        WHEN 2 THEN 'Martes'
        WHEN 3 THEN 'Miercoles'
        WHEN 4 THEN 'Jueves'
        WHEN 5 THEN 'Viernes'
        WHEN 6 THEN 'Sabado'
        WHEN 7 THEN 'Domingo'
    END;
    DBMS_OUTPUT.PUT_LINE(y);
END;
/

-- Bucle while
DECLARE
    x number;
BEGIN
    while x<10 loop
        DBMS_OUTPUT.PUT_LINE(x);
        x:=X+1;
    END loop;
END;

-- Bucle for
DECLARE
    x integer;
BEGIN
    for x in reverse 0..9 loop 
           DBMS_OUTPUT.PUT_LINE('x vale: ' || x);
    END loop;
END;
/

-- Bucle loop

DECLARE
    x number:=0;
BEGIN
    loop
        DBMS_OUTPUT.PUT_LINE('x vale: ' || x);
        x:=x+1;
        exit when x>=10;
    END loop;
END;
/


-- Procediment escriu
CREATE PROCEDURE escriu(x varchar2) IS
BEGIN
   DBMS_OUTPUT.PUT_LINE(x);
END;
/

--Funcio


DECLARE
BEGIN
END;
/
--PARAME
CREATE OR REPLACE PROCEDURE prova3(x IN integer, y OUT integer) IS
BEGIN
    y:=x+5;
END;
/

CREATE OR REPLACE PROCEDURE prova4(x IN OUT integer) IS
BEGIN  
    x:= x+7;
END;
/

DECLARE 
    z integer;
BEGIN
    z:=3;

END;
/

--VARIABLE (INTO)
-- variables
CREATE OR REPLACE PROCEDURE cons_empl(codi number) IS
    v_codi NUMBER(3);
    v_nom VARCHAR2(20);
    v_cognom VARCHAR2(50);
    v_sou NUMBER(8,2);
    quants number(1);
BEGIN

    SELECT count(*) into quants 
    from empleats where codi_empl=codi;
    IF quants=1 THEN
        SELECT CODI_EMPL, NOM_EMPL, COGNOM_EMPL, SOU
        INTO v_codi, v_nom, v_cognom, v_sou
        FROM empleats
        WHERE codi_empl=codi;
        DBMS_OUTPUT.PUT_LINE('------------------------------------');
        DBMS_OUTPUT.PUT_LINE('          DADES DE L''EMPLEAT       ');
        DBMS_OUTPUT.PUT_LINE('------------------------------------');
        DBMS_OUTPUT.PUT_LINE('CODI: ' || v_codi);
        DBMS_OUTPUT.PUT_LINE('NOM: ' || v_nom || ' ' || v_cognom);
        DBMS_OUTPUT.PUT_LINE('SOU: ' || v_sou);
        DBMS_OUTPUT.PUT_LINE('------------------------------------');
    else
        DBMS_OUTPUT.PUT_LINE('Error: No existeix cap empleat amb aquest codi');
    END IF;
END;
/


-- crear usuari
CREATE OR REPLACE PROCEDURE creaUsuari(
                        c NUMBER, 
                        n VARCHAR2, 
                        a VARCHAR2, 
                        s NUMBER
                ) IS 
BEGIN
    IF (s >900) THEN
        INSERT INTO empleats (codi_empl, nom_empl, cognom_empl, sou)
        VALUES (c, n, a, s);
        DBMS_OUTPUT.put_line('Empleat donat d''alta correctament');
    ELSE
        DBMS_OUTPUT.put_line('Error. El sou ha de ser superior a 900');
    END IF;
END;
/

