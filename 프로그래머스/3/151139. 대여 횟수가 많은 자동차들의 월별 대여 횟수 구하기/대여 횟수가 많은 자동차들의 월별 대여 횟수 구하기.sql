-- 코드를 입력하세요

with tmp as (
    select 
        car_id
    from
        car_rental_company_rental_history
    where
        start_date >= '2022-08-01' and start_date < '2022-11-01'
    group by
        car_id
    having
        count(history_id) >= 5
)
select
    month(start_date) as month,
    a.car_id,
    count(b.history_id) as records
from
    tmp as a
    inner join
    car_rental_company_rental_history as b
    on a.car_id = b.car_id
where
    start_date >= '2022-08-01' and start_date < '2022-11-01'
group by
    month, car_id
having
    count(b.history_id) != 0
order by
    month asc, car_id desc;