-- 코드를 입력하세요
SELECT PT_NAME, PT_NO, GEND_CD, AGE, if(TLNO is null, 'NONE',TLNO) as TLNO
from PATIENT
where AGE <= 12
and GEND_CD = 'W'
order by AGE desc, PT_NAME asc;