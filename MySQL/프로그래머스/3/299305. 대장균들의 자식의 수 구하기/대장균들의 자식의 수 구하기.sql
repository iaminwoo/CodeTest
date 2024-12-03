-- 코드를 작성해주세요
select I.ID,
if(CHILD_COUNT is null, 0, CHILD_COUNT) as CHILD_COUNT

from

(select ID from ECOLI_DATA) as I

left join

(select A.ID, count(*) as CHILD_COUNT
from (select ID from ECOLI_DATA) as A

inner join ECOLI_DATA as B
 
on A.ID = B.PARENT_ID
 
group by A.ID) as II

on I.ID = II.ID;