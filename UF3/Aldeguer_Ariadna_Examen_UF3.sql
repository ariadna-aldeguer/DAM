
-- Ariadna Aldeguer Ruiz
-- 17 MAIG 2021

--    Problema 1  --
CREATE OR REPLACE PROCEDURE NouProfe (nom varchar2, id_casa number) IS 
    codi number(38);
    x number;
    exception_casa EXCEPTION;
BEGIN
    SELECT max(id)+1 INTO codi 
    FROM profe;
    
    SELECT count(*) INTO x 
    FROM casa WHERE id = id_casa;

    if x>0 or id_casa is null then
        insert into profe values(codi, nom, id_casa);
        DBMS_OUTPUT.PUT_LINE('Operació realitzada correctament. Id assignat: ' || codi);
    else 
        raise exception_casa;
    end if;
    
EXCEPTION
    WHEN exception_casa THEN
        DBMS_OUTPUT.PUT_LINE('Error: No hi ha cap casa amb aquest codi');
END;
/

--    Problema 2  --

CREATE OR REPLACE PROCEDURE ConsProfe (codi number) IS

    exception_profe EXCEPTION;
    x number;
    nom_profe VARCHAR2(50);
    nom_casa VARCHAR2(50);
    CURSOR c_classes IS 
        SELECT materia FROM classes, profe 
        WHERE profe_id = profe.id AND profe.id = codi;

BEGIN
    SELECT count(*) INTO x FROM profe WHERE id = codi;
    
    if x < 1 then
        RAISE exception_profe;
    end if;
    
    SELECT profe.nom, casa.nom 
    INTO nom_profe, nom_casa FROM 
    profe, casa WHERE profe.casa_id = casa.id AND profe.id = codi;

    DBMS_OUTPUT.PUT_LINE('******************************************');
    DBMS_OUTPUT.PUT_LINE('Nom professor: ' || nom_profe);
    DBMS_OUTPUT.PUT_LINE('Nom casa: ' || nom_casa);
    DBMS_OUTPUT.PUT_LINE('******************************************');
    DBMS_OUTPUT.PUT_LINE('Classes que imparteix: ');
    
    for class in c_classes loop
        DBMS_OUTPUT.PUT_LINE(class.materia);
    end loop;
   
EXCEPTION
    WHEN exception_profe THEN
        DBMS_OUTPUT.PUT_LINE('Error: No hi ha cap professor amb aquest codi');
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Aquest professor no dona cap classe');
END;
/

--    Problema 3  --

CREATE OR REPLACE PROCEDURE BorraProfe(codi number) IS
    x number;
    y number;
    exception_profe EXCEPTION;
    exception_classe EXCEPTION;
BEGIN
    SELECT count(*) INTO x 
    FROM profe WHERE id = codi;

    if x<1 then
        raise exception_profe;
    end if;

    SELECT count(*) INTO y
    FROM classes WHERE profe_id = codi;

    if y>0 then 
        RAISE exception_classe;
    end if;

    DELETE FROM profe
    WHERE codi = id;
    
    DBMS_OUTPUT.PUT_LINE('Operació realitzada correctament');

EXCEPTION
    WHEN exception_profe THEN
        DBMS_OUTPUT.PUT_LINE('Error: No hi ha cap professor amb aquest codi');
    WHEN exception_classe THEN 
        DBMS_OUTPUT.PUT_LINE('Error: Aquest professor esta annexat a classes');
END;
/