-- 코드를 작성해주세요
select ID,
if(SIZE_OF_COLONY <= 100, 'LOW', if(SIZE_OF_COLONY <= 1000, 'MEDIUM', 'HIGH'))
   as SIZE
from ECOLI_DATA;