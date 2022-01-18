-- task 1
SELECT f2.title,
       sp.show_time,
       f2.length,
       ss.title,
       ss.show_time,
       ss.length
FROM schedule sp
         JOIN (
    SELECT s.show_time
         , f.title
         , DATE_ADD(s.show_time, INTERVAL f.length MINUTE) AS end_time
         , s.id                                            as schedule_id
         , f.length
    FROM schedule s
             JOIN film f on f.id = s.film_id
) ss ON (sp.show_time BETWEEN ss.show_time AND ss.end_time) AND (sp.id != ss.schedule_id)
         LEFT JOIN film f2 on sp.film_id = f2.id
ORDER BY sp.show_time
;



-- task 3
(
    SELECT ch.title,
           SUM(ch.count_by_seans) as bill_count_by_film,
           AVG(ch.count_by_seans) as avg_bills_by_seans,
           SUM(summ_by_seans)     as summ_by_film
    FROM (SELECT s.film_id,
                 f.title,
                 COUNT(b.id)          as count_by_seans,
                 COUNT(b.id) * s.cost as summ_by_seans
          FROM schedule s
                   LEFT JOIN film f ON f.id = s.film_id
                   LEFT JOIN bill b ON s.id = b.schedule_id
          GROUP BY s.film_id, s.id) ch
    GROUP BY ch.film_id
    ORDER BY summ_by_film DESC
)
UNION
(
    SELECT 'Итого:',
           SUM(ch.count_by_seans) as bill_count_by_film,
           AVG(ch.count_by_seans) as avg_bills_by_seans,
           SUM(summ_by_seans)     as summ_by_film
    FROM (SELECT COUNT(b.id)          as count_by_seans,
                 COUNT(b.id) * s.cost as summ_by_seans
          FROM schedule s
                   LEFT JOIN bill b ON s.id = b.schedule_id
          GROUP BY s.film_id, s.id) ch
)
;

-- task4

SELECT periods.period,
       periods.title,
       SUM(periods.count) as bills_count,
       SUM(periods.cost) as bills_sum
FROM (
         SELECT COUNT(b.id)        as count,
                COUNT(b.id) * cost as cost,
                '9-15'             as period,
                f.title
         FROM schedule s
                  JOIN bill b on s.id = b.schedule_id
                  LEFT JOIN film f ON f.id = s.film_id
         WHERE TIME(show_time) between '09:00:00' AND '15:00:00'
         GROUP BY s.film_id, s.id

         UNION

         SELECT COUNT(b.id)        as count,
                COUNT(b.id) * cost as cost,
                '15-18'            as period,
                f.title
         FROM schedule s
                  JOIN bill b on s.id = b.schedule_id
                  LEFT JOIN film f ON f.id = s.film_id
         WHERE TIME(show_time) between '15:00:00' AND '18:00:00'
         GROUP BY s.film_id, s.id

         UNION

         SELECT COUNT(b.id)        as count,
                COUNT(b.id) * cost as cost,
                '18-21'            as period,
                f.title
         FROM schedule s
                  JOIN bill b on s.id = b.schedule_id
                  LEFT JOIN film f ON f.id = s.film_id
         WHERE TIME(show_time) between '18:00:00' AND '21:00:00'
         GROUP BY s.film_id, s.id

         UNION

         SELECT COUNT(b.id)        as count,
                COUNT(b.id) * cost as cost,
                '21-0'             as period,
                f.title
         FROM schedule s
                  JOIN bill b on s.id = b.schedule_id
                  LEFT JOIN film f ON f.id = s.film_id
         WHERE TIME(show_time) between '21:00:00' AND '23:59:59'
         GROUP BY s.film_id, s.id
     ) periods
GROUP BY periods.period, periods.title
;
