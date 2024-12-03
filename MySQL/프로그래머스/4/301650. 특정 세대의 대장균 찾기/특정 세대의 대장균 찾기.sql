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
select ID
from EcoliHierarchy
where generation = 3
order by ID asc;