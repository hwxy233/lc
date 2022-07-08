# name國家名	    continent洲份	area面積	    population人口	gdp國民生產總值
# Afghanistan	Asia	        652230	    25500100	    20343000000
# Albania	    Europe	        28748	    2831741	        12960000000
# Algeria	    Africa	        2381741	    37100000	    188681000000
# Andorra	    Europe	        468	        78115	        3712000000
# Angola	    Africa	        1246700	    20609294	    100990000000


# 1. 列出每個國家的名字 name，當中人口 population 是高於俄羅斯'Russia'的人口。

SELECT name
FROM world
WHERE population >
      (SELECT population
       FROM world
       WHERE name = 'Russia');

# 2. 列出歐州每國家的人均GDP，當中人均GDP要高於英國'United Kingdom'的數值。
SELECT name
FROM world
WHERE continent = 'Europe'
  AND (gdp / population) > (SELECT gdp / population
                            FROM world
                            WHERE name = 'United Kingdom');

# 3. 在阿根廷Argentina 及 澳大利亞 Australia所在的洲份中，
# 列出當中的國家名字 name 及洲分 continent 。
# 按國字名字順序排序

SELECT name, continent
FROM world
WHERE continent IN
      (SELECT continent FROM world WHERE name IN ('Argentina', 'Australia'))
order by name;

# 4. 哪一個國家的人口比加拿大Canada的多，但比波蘭Poland的少?列出國家名字name和人口population 。
select name, population
from world
where population > (select population from world where name = 'Canada')
  and population < (select population from world where name = 'Poland');

# 5. Germany德國（人口8000萬），在Europe歐洲國家的人口最多。Austria奧地利（人口850萬）擁有德國總人口的11％。
# 顯示歐洲的國家名稱name和每個國家的人口population。以德國的人口的百分比作人口顯示。
# 小數位數,您可以使用函數ROUND 刪除小數。百分號 % 您可以使用函數 CONCAT 增加的百分比符號。

select name, CONCAT(ROUND((population / (select population from world where name = 'Germany')) * 100), '%')
from world
where continent = 'Europe';

# 6. 哪些國家的GDP比Europe歐洲的全部國家都要高呢? [只需列出 name 。]
# (有些國家的記錄中，GDP是NULL，沒有填入資料的。)

select name
from world
where gdp > ALL (select gdp from world where gdp IS NOT NULL and continent = 'Europe');

# 7. 在每一個州中找出最大面積的國家，列出洲份 continent, 國家名字 name 及面積 area。
# (有些國家的記錄中，AREA是NULL，沒有填入資料的。)

SELECT continent, name, area
FROM world x
WHERE area is not null
  and area >= ALL
      (SELECT area
       FROM world y
       WHERE y.continent = x.continent);

# 8. 列出洲份名稱，和每個洲份中國家名字按子母順序是排首位的國家名。(即每洲只有列一國)

select x.continent, x.name
from world x
where x.name <= ALL (select name from world where continent = x.continent);

# 9. 找出洲份，當中全部國家都有少於或等於 25000000 人口.
# 在這些洲份中，列出國家名字name，continent 洲份和population人口。

select x.name, x.continent, x.population
from world x
where 25000000 >= ALL (select population from world where continent = x.continent);

# 10. 有些國家的人口是同洲份的所有其他國的3倍或以上。列出 國家名字name 和 洲份 continent。

select name, continent
from world x
where x.population >= ALL (select population * 3 from world where continent = x.continent AND name <> x.name);