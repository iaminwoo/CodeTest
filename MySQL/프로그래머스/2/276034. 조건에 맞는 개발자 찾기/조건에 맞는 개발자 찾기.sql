-- 코드를 작성해주세요
select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS
where (
    DEVELOPERS.SKILL_CODE & (select `CODE` from SKILLCODES where NAME = 'Python')
    = (select `CODE` from SKILLCODES where NAME = 'Python')
)
or (
    DEVELOPERS.SKILL_CODE & (select `CODE` from SKILLCODES where NAME = 'C#')
    = (select `CODE` from SKILLCODES where NAME = 'C#')
)
order by ID asc;