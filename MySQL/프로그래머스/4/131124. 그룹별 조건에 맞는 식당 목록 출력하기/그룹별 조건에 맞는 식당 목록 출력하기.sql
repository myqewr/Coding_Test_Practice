-- 코드를 입력하세요
SELECT m.member_name,r.review_text,Date_Format(r.review_date, "20%y-%m-%d")
from member_profile m join rest_review r
on m.member_id=r.member_id
 where r.member_id = (select member_id from rest_review group by member_id order by count(*) desc limit 1)
order by r.review_date,r.review_text;