-- 코드를 입력하세요
SELECT o.ANIMAL_ID,o.NAME from ANIMAL_OUTS o 
where o.ANIMAL_ID not in (Select animal_id from animal_ins);