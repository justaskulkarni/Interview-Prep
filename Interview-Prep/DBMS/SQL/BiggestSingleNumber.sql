select max(num) as num
from MyNumbers 
where num not in (select num 
                  from MyNumbers
                  group by num
                  having count(num) > 1);