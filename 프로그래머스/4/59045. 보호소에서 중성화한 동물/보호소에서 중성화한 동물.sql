-- 코드를 입력하세요
SELECT
AO.ANIMAL_ID,
AI.ANIMAL_TYPE,
AO.NAME
FROM ANIMAL_INS AI,
      ANIMAL_OUTS AO
WHERE AI.ANIMAL_ID = AO.ANIMAL_ID
AND AI.ANIMAL_ID IN (SELECT ANIMAL_ID
                      FROM ANIMAL_INS 
                      where SEX_UPON_INTAKE NOT IN('Neutered Male','Spayed Female')
                 )
AND AO.SEX_UPON_OUTCOME IN('Neutered Male','Spayed Female')
ORDER BY AI.ANIMAL_ID