# 全球統計:群組函數
# 此教程是有關群組函數，例如COUNT, SUM 和 AVG。
# 群組函數把多個數值運算，得出結果只有一個數值。
# 例如SUM函數會把數值2,4,和5運算成結果11。
#
# name:國家名稱	continent:洲份	area:面積	population:人口	gdp:國內生產總值
# ------------------------------------------------------------------------
# Afghanistan	Asia	        652230	    25500100	    20343000000
# Albania	    Europe	        28748	    2831741	        12960000000
# Algeria	    Africa	        2381741	    37100000	    188681000000
# Andorra	    Europe	        468	        78115	        3712000000
# Angola	    Africa	        1246700	    20609294	    100990000000

# 1. 展示世界的總人口。

SELECT SUM(population)
FROM world;

# 2. 列出所有的洲份, 每個只有一次。

select distinct continent
FROM world;

# 3. 找出非洲(Africa)的GDP總和。

SELECT SUM(gdp)
FROM world
where continent = 'Africa';

# 4. 有多少個國家具有至少百萬(1000000)的面積。

select COUNT(*)
from world
where area >= 1000000;

# 5. ('France','Germany','Spain')（“法國”，“德國”，“西班牙”）的總人口是多少？

select sum(population)
from world
where name in ('France', 'Germany', 'Spain');

# 6. 對於每一個洲份，顯示洲份和國家的數量。

select continent, COUNT(name)
from world
group by continent;

# 7. 對於每一個洲份，顯示洲份和至少有1000萬人(10,000,000)口國家的數目。

select continent, COUNT(name)
from world
where population > 10000000
group by continent;

# 8. 列出有至少100百萬(1億)(100,000,000)人口的洲份。

select continent
from world
group by continent
having sum(population) >= 100000000;