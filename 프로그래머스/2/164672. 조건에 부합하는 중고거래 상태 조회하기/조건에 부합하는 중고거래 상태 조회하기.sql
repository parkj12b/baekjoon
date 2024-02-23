-- 코드를 입력하세요
SELECT
    board_id, 
    writer_id, 
    title, 
    price, 
    if (a.status = 'reserved', '예약중', if (a.status = 'SALE', '판매중', '거래완료')) as status
from
    used_goods_board as a
where
    date_format(created_date, "%Y-%m-%d") = "2022-10-05"
order by
    board_id desc;