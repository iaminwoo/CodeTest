-- 코드를 작성해주세요
select C.ID
from ECOLI_DATA as A
left join ECOLI_DATA as B on A.ID = B.PARENT_ID
left join ECOLI_DATA as C on B.ID = C.PARENT_ID
where C.ID is not null and A.PARENT_ID is null;