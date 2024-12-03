-- 코드를 작성해주세요
select info.ITEM_ID as ITEM_ID, info.ITEM_NAME as ITEM_NAME,
info.RARITY as RARITY
from ITEM_INFO as info
inner join (
  select tree.ITEM_ID
  from ITEM_INFO as info inner join ITEM_TREE as tree
  on info.ITEM_ID = tree.PARENT_ITEM_ID
  where info.RARITY = 'RARE'
) as up
on info.ITEM_ID = up.ITEM_ID
order by info.ITEM_ID desc;
