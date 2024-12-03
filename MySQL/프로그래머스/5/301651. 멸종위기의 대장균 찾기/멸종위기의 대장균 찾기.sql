-- 코드를 작성해주세요
with recursive EcoliHierarchy as (
    select ID, PARENT_ID, 1 as generation
    from ECOLI_DATA
    where PARENT_ID is null
    
    union all
    
    select c.ID, c.PARENT_ID, p.generation+1 as generation
    from ECOLI_DATA as c
    inner join EcoliHierarchy as p
    on p.ID = c.PARENT_ID
)
select count(A.ID) as COUNT, A.generation as GENERATION
from EcoliHierarchy as A
left join EcoliHierarchy as B
on A.ID = B.PARENT_ID
where B.PARENT_ID is null
group by A.generation