-- 코드를 작성해주세요
select c.ID, c.GENOTYPE, p.GENOTYPE as PARENT_GENOTYPE
from ECOLI_DATA as p
left join ECOLI_DATA as c
on p.Id = c.PARENT_ID
where p.GENOTYPE & c.GENOTYPE = p.GENOTYPE
order by ID asc;