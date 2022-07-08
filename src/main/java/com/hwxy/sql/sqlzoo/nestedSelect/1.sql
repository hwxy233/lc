-- 1. List each country in the same continent as 'Brazil'.

SELECT name, continent
FROM world
WHERE continent IN
      (SELECT continent
       FROM world
       WHERE name = 'Brazil'
          OR name = 'Mexico');

-- 2. 列出與巴西'Brazil' 和 墨西哥'Mexico'相同洲份的每個國家名和洲份。

SELECT name, continent
FROM world
WHERE continent IN
      (SELECT continent
       FROM world
       WHERE name = 'Brazil'
          OR name = 'Mexico');

-- 3. 顯示中國人口是英國人口的多少倍。
SELECT population / (SELECT population
                     FROM world
                     WHERE name = 'United Kingdom')
FROM world
WHERE name = 'China';

SELECT ((SELECT population FROM world WHERE name = 'China') / (SELECT population
                                                               FROM world
                                                               WHERE name = 'United Kingdom'));

-- 4. 找出哪些國家的人口是高於歐洲每一國的人口。

SELECT name
FROM world
WHERE population > ALL
      (SELECT population
       FROM world
       WHERE continent = 'Europe');

SELECT name
FROM world
WHERE population > (SELECT MAX(population)
                    FROM world
                    WHERE continent = 'Europe');