# game(賽事)
# id(編號)	mdate(日期)	    stadium(場館)                team1(隊伍1) team2(隊伍2)
# ------------------------------------------------------------------------------
# 1001	    8 June 2012	    National Stadium, Warsaw	POL	         GRE
# 1002	    8 June 2012	    Stadion Miejski (Wroclaw)	RUS	         CZE
# 1003	    12 June 2012	Stadion Miejski (Wroclaw)	GRE	         CZE
# 1004	    12 June 2012	National Stadium, Warsaw	POL	         RUS
#
# goal(入球)
# matchid(賽事編號)	teamid(隊伍編號)	player(入球球員)	        gtime(入球時間)
# ------------------------------------------------------------------------
# 1001	            POL	            Robert Lewandowski	    17
# 1001	            GRE	            Dimitris Salpingidis	51
# 1002	            RUS	            Alan Dzagoev	        15
# 1001	            RUS	            Roman Pavlyuchenko	    82
#
# eteam(歐洲隊伍)
# id(編號)	teamname(隊名)	coach(教練)
# ------------------------------------------
# POL	    Poland	        Franciszek Smuda
# RUS	    Russia	        Dick Advocaat
# CZE	    Czech Republic	Michal Bilek
# GRE	    Greece	        Fernando Santos

# 1. 修改此SQL以列出 賽事編號 matchid 和球員名 player ,該球員代表德國隊Germany入球的。
# 要找出德國隊球員，要檢查: teamid = 'GER'

SELECT matchid, player
FROM goal
WHERE teamid = 'GER';

# 2. 由以上查詢，你可見Lars Bender's 於賽事 1012入球。.現在我們想知道此賽事的對賽隊伍是哪一隊。
# 留意在 goal 表格中的欄位 matchid ，是對應表格game的欄位id。我們可以在表格 game中找出賽事1012的資料。
# 只顯示賽事1012的 id, stadium, team1, team2

SELECT id, stadium, team1, team2
FROM game
where id = 1012;

# 3. 我們可以利用JOIN來同時進行以上兩個步驟。
# SELECT * FROM game JOIN goal ON (id = matchid)
# 語句 FROM 表示合拼兩個表格game 和 goal的數據。
# 語句 ON 表示如何找出 game中每一列應該配對goal中的哪一列
# goal的 id 必須配對game的 matchid 。
# 簡單來說，就是 ON (game.id=goal.matchid)
# 以下SQL列出每個入球的球員(來自goal表格) 和場館名(來自game表格)
# 修改它來顯示每一個德國入球的球員名，隊伍名，場館和日期。

SELECT player, teamid, stadium, mdate
FROM game
         JOIN goal ON (id = matchid)
where goal.teamid = 'GER';

# 4. 使用上題相同的 JOIN語句，
# 列出球員名字叫Mario (player LIKE 'Mario%')有入球的 隊伍1 team1, 隊伍2 team2 和 球員名 player

select team1, team2, player
from game
         join goal on (game.id = goal.matchid)
where goal.player LIKE 'Mario%';