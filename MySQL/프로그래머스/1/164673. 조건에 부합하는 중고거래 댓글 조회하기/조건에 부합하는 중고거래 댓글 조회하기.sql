-- 코드를 입력하세요
SELECT b.TITLE as TITLE, b.BOARD_ID as BOARD_ID,
r.REPLY_ID as REPLY_ID, r.WRITER_ID as WRITER_ID,
r.CONTENTS as CONTENTS,
date_format(r.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE
from USED_GOODS_BOARD as b
inner join USED_GOODS_REPLY as r
on b.BOARD_ID = r.BOARD_ID
where b.CREATED_DATE like '2022-10%'
order by r.CREATED_DATE asc, b.TITLE asc;