package com.usp.belluzzi.nbaweb.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.usp.belluzzi.nbaweb.cluster.model.StatsSeason;
import com.usp.belluzzi.nbaweb.cluster.model.Team;



public class ReadArchive {

	static Logger log = Logger.getLogger("ReadArchive");

	public static Map<String, StatsSeason> readXLSX (String path) throws IOException{
		log.info("Iniciou a fun��o de leitura de arquivo");

		Map<String, StatsSeason> hash = new HashMap<String, StatsSeason> ();

		String csvFile = path;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";



		br = new BufferedReader(new FileReader(csvFile));
		log.info("Leu o arquivo (" + path + ")");

		int a = 0;
		while ((line = br.readLine()) != null) {
			if (!line.isEmpty()){

				// use comma as separator
				String[] statsBR = line.split(cvsSplitBy);

				//log.info("Leu uma linha do arquivo com  (" + statsBR.length + ") dados" );

				if (!statsBR[0].equals("TP")){

					Team team = new Team (statsBR[0], statsBR[1]);

					int threePoint = Integer.parseInt(statsBR[2]);
					int threePointAttempt = Integer.parseInt(statsBR[3]); 
					int twoPoint = Integer.parseInt(statsBR[4]);
					int twoPointAttempt = Integer.parseInt(statsBR[5]);
					int freeThrow = Integer.parseInt(statsBR[6]); 
					int freeThrowAttempt = Integer.parseInt(statsBR[7]); 
					int offensiveRebound = Integer.parseInt(statsBR[8]); 
					int defensiveRebound = Integer.parseInt(statsBR[9]); 
					int assist = Integer.parseInt(statsBR[10]);
					int steal = Integer.parseInt(statsBR[11]); 
					int block = Integer.parseInt(statsBR[12]); 
					int turnover = Integer.parseInt(statsBR[13]); 
					int personalFoul = Integer.parseInt(statsBR[14]);
					int point  = Integer.parseInt(statsBR[15]);

					//TP		Team					3P		3PA		2P		2PA		FT		FTA		ORB		DRB		TRB		AST		STL		BLK		TOV		PF		PTS
					//15/16		Golden State Warriors	1077	2592	2412	4567	1366	1790	816		2972	3788	2373	689		498		1245	1701	9421

					StatsSeason statsSeason = new StatsSeason (team, threePoint, threePointAttempt, twoPoint, twoPointAttempt, freeThrow, freeThrowAttempt, offensiveRebound, 
							defensiveRebound, assist, steal, block, turnover, personalFoul, point);



					hash.put(team.toString(), statsSeason);

					System.out.println("a[" + a + "] = new " + statsSeason.toString());

					a++;
					//log.info("Inseriu as estatisticas do team (" + team.toString() + ") valores (" + statsSeason.toString() + ")");
				}
				//System.out.println(statsSeason);
			}

		}

		log.info("Terminou o processo de leitura");

		return hash;
	}


	public static Map<String, StatsSeason> hardCodeOfffensive () throws IOException{

		Map<String, StatsSeason> hash = new HashMap<String, StatsSeason> ();

		StatsSeason a [] = new StatsSeason[300];

		a[0] = new StatsSeason ("15/16","Golden State Warriors",1077,2592,2412,4567,1366,1790,816,2972,2373,689,498,1245,1701,9421,null);
		a[1] = new StatsSeason ("15/16","Oklahoma City Thunder/Seattle SuperSonics",678,1945,2694,5137,1616,2067,1071,2916,1883,603,487,1305,1691,9038,null);
		a[2] = new StatsSeason ("15/16","Sacramento Kings",660,1839,2623,5244,1514,2089,868,2760,2009,733,368,1326,1676,8740,null);
		a[3] = new StatsSeason ("15/16","Houston Rockets",878,2533,2216,4314,1671,2407,930,2601,1821,821,430,1307,1790,8737,null);
		a[4] = new StatsSeason ("15/16","Boston Celtics",717,2142,2499,5176,1520,1929,950,2733,1981,752,348,1127,1796,8669,null);
		a[5] = new StatsSeason ("15/16","Portland Trail Blazers",864,2336,2303,4704,1424,1889,948,2782,1748,562,380,1200,1782,8622,null);
		a[6] = new StatsSeason ("15/16","Los Angeles Clippers",797,2190,2344,4569,1490,2152,721,2727,1873,709,460,1063,1746,8569,null);
		a[7] = new StatsSeason ("15/16","Cleveland Cavaliers",880,2428,2291,4460,1333,1783,873,2777,1861,551,317,1114,1666,8555,null);
		a[8] = new StatsSeason ("15/16","Washington Wizards",709,1983,2529,5050,1349,1849,743,2688,2005,708,323,1186,1708,8534,null);
		a[9] = new StatsSeason ("15/16","San Antonio Spurs",570,1518,2719,5279,1342,1672,770,2831,2010,677,485,1071,1433,8490,null);
		a[10] = new StatsSeason ("15/16","Charlotte Hornets/Bobcats",873,2410,2163,4512,1534,1941,734,2869,1778,595,438,1030,1487,8479,null);
		a[11] = new StatsSeason ("15/16","Atlanta Hawks",815,2326,2353,4597,1282,1638,679,2772,2100,747,486,1226,1570,8433,null);
		a[12] = new StatsSeason ("15/16","New Orleans/Oklahoma City/New Orleans Pelicans/Hornets",702,1951,2451,5089,1415,1823,782,2712,1818,633,342,1102,1713,8423,null);
		a[13] = new StatsSeason ("15/16","Toronto Raptors",708,1915,2298,4754,1702,2190,836,2724,1536,636,449,1073,1610,8422,null);
		a[14] = new StatsSeason ("15/16","Minnesota Timberwolves",455,1347,2640,5321,1753,2213,821,2587,1916,656,375,1231,1696,8398,null);
		a[15] = new StatsSeason ("15/16","Dallas Mavericks",806,2342,2258,4558,1454,1831,751,2781,1813,560,306,1047,1595,8388,null);
		a[16] = new StatsSeason ("15/16","Indiana Pacers",663,1889,2479,5096,1430,1872,847,2779,1741,742,391,1219,1641,8377,null);
		a[17] = new StatsSeason ("15/16","Orlando Magic",636,1818,2606,5302,1249,1649,843,2709,1933,673,417,1155,1701,8369,null);
		a[18] = new StatsSeason ("15/16","Detroit Pistons",740,2148,2371,4939,1399,2095,1021,2777,1594,573,304,1110,1557,8361,null);
		a[19] = new StatsSeason ("15/16","Denver Nuggets",656,1943,2437,5060,1513,1974,941,2718,1858,609,395,1202,1723,8355,null);
		a[20] = new StatsSeason ("15/16","Chicago Bulls",651,1753,2514,5417,1354,1720,907,2889,1870,495,470,1141,1545,8335,null);
		a[21] = new StatsSeason ("15/16","Phoenix Suns",738,2118,2313,4900,1431,1905,943,2733,1701,632,313,1410,1858,8271,null);
		a[22] = new StatsSeason ("15/16","Miami Heat",498,1480,2652,5217,1406,1889,807,2811,1709,553,531,1155,1502,8204,null);
		a[23] = new StatsSeason ("15/16","Memphis Grizzlies",504,1521,2515,5338,1584,2024,916,2497,1697,724,350,1090,1783,8126,null);
		a[24] = new StatsSeason ("15/16","Milwaukee Bucks",440,1277,2705,5463,1392,1863,858,2559,1895,672,475,1247,1695,8122,null);
		a[25] = new StatsSeason ("15/16","Brooklyn/New Jersey Nets",531,1508,2605,5412,1286,1699,863,2614,1829,627,332,1212,1476,8089,null);
		a[26] = new StatsSeason ("15/16","New York Knicks",610,1762,2412,5124,1411,1753,850,2788,1682,467,466,1099,1616,8065,null);
		a[27] = new StatsSeason ("15/16","Utah Jazz",694,1956,2263,4637,1402,1885,880,2665,1555,631,425,1224,1655,8010,null);
		a[28] = new StatsSeason ("15/16","Philadelphia 76ers",764,2255,2206,4632,1284,1850,777,2605,1765,680,495,1343,1780,7988,null);
		a[29] = new StatsSeason ("15/16","Los Angeles Lakers",639,2016,2241,4940,1583,2028,878,2645,1478,593,337,1124,1662,7982,null);
		a[30] = new StatsSeason ("14/15","Golden State Warriors",883,2217,2527,4920,1313,1709,853,2814,2248,762,496,1185,1628,9016,null);
		a[31] = new StatsSeason ("14/15","Los Angeles Clippers",827,2202,2401,4628,1468,2067,784,2711,2031,640,409,1012,1749,8751,null);
		a[32] = new StatsSeason ("14/15","Dallas Mavericks",732,2082,2523,4954,1386,1843,858,2608,1846,663,371,1062,1644,8628,null);
		a[33] = new StatsSeason ("14/15","Toronto Raptors",726,2060,2382,4769,1585,2014,881,2526,1701,615,357,1057,1712,8527,null);
		a[34] = new StatsSeason ("14/15","Oklahoma City Thunder/Seattle SuperSonics",632,1864,2552,5255,1524,2020,1052,2844,1681,598,454,1205,1829,8524,null);
		a[35] = new StatsSeason ("14/15","Houston Rockets",933,2680,2099,4152,1525,2133,958,2624,1820,777,407,1366,1803,8522,null);
		a[36] = new StatsSeason ("14/15","San Antonio Spurs",677,1847,2531,5007,1368,1754,806,2772,2000,657,444,1146,1564,8461,null);
		a[37] = new StatsSeason ("14/15","Cleveland Cavaliers",826,2253,2263,4486,1453,1934,911,2612,1814,603,340,1171,1510,8457,null);
		a[38] = new StatsSeason ("14/15","Portland Trail Blazers",807,2231,2368,4818,1272,1589,879,2881,1799,525,372,1117,1494,8429,null);
		a[39] = new StatsSeason ("14/15","Atlanta Hawks",818,2152,2303,4547,1349,1735,715,2611,2111,744,380,1167,1457,8409,null);
		a[40] = new StatsSeason ("14/15","Phoenix Suns",698,2048,2480,4990,1343,1767,896,2643,1659,700,385,1238,1744,8397,null);
		a[41] = new StatsSeason ("14/15","Denver Nuggets",660,2032,2439,5126,1462,1991,1012,2653,1788,641,367,1166,1882,8320,null);
		a[42] = new StatsSeason ("14/15","Boston Celtics",660,2021,2533,5190,1266,1678,910,2685,2009,674,294,1133,1738,8312,null);
		a[43] = new StatsSeason ("14/15","Sacramento Kings",461,1350,2549,5267,1829,2400,895,2728,1667,550,324,1333,1696,8310,null);
		a[44] = new StatsSeason ("14/15","Chicago Bulls",645,1825,2356,4972,1618,2067,959,2792,1781,514,476,1145,1495,8265,null);
		a[45] = new StatsSeason ("14/15","New Orleans/Oklahoma City/New Orleans Pelicans/Hornets",586,1583,2522,5212,1345,1790,942,2621,1806,553,510,1087,1530,8147,null);
		a[46] = new StatsSeason ("14/15","Washington Wizards",497,1381,2642,5409,1305,1758,862,2801,1969,601,378,1233,1707,8080,null);
		a[47] = new StatsSeason ("14/15","Detroit Pistons",703,2043,2338,4995,1292,1838,1051,2630,1771,623,383,1099,1559,8077,null);
		a[48] = new StatsSeason ("14/15","Los Angeles Lakers",532,1546,2522,5474,1433,1935,952,2647,1715,578,366,1086,1741,8073,null);
		a[49] = new StatsSeason ("14/15","Memphis Grizzlies",423,1246,2674,5517,1445,1869,856,2634,1777,700,347,1094,1567,8062,null);
		a[50] = new StatsSeason ("14/15","Brooklyn/New Jersey Nets",541,1633,2528,5171,1359,1817,846,2627,1716,576,340,1133,1579,8038,null);
		a[51] = new StatsSeason ("14/15","Milwaukee Bucks",545,1500,2538,5222,1312,1734,876,2574,1932,789,403,1373,1814,8023,null);
		a[52] = new StatsSeason ("14/15","Minnesota Timberwolves",406,1223,2580,5597,1638,2110,949,2406,1771,668,327,1231,1571,8016,null);
		a[53] = new StatsSeason ("14/15","Indiana Pacers",612,1740,2386,5084,1373,1817,856,2822,1757,505,375,1147,1742,7981,null);
		a[54] = new StatsSeason ("14/15","Orlando Magic",554,1598,2522,5194,1141,1565,822,2607,1692,647,314,1221,1714,7847,null);
		a[55] = new StatsSeason ("14/15","Utah Jazz",610,1781,2290,4711,1391,1929,988,2617,1632,623,489,1256,1583,7801,null);
		a[56] = new StatsSeason ("14/15","Miami Heat",556,1659,2329,4671,1438,1940,747,2461,1626,642,372,1214,1636,7764,null);
		a[57] = new StatsSeason ("14/15","Charlotte Hornets/Bobcats",498,1566,2415,5366,1397,1867,820,2793,1654,499,448,976,1494,7721,null);
		a[58] = new StatsSeason ("14/15","Philadelphia 76ers",692,2160,2073,4617,1320,1953,978,2536,1683,789,487,1453,1778,7542,null);
		a[59] = new StatsSeason ("14/15","New York Knicks",560,1614,2322,5112,1211,1575,867,2443,1746,575,382,1206,1768,7535,null);
		a[60] = new StatsSeason ("13/14","Los Angeles Clippers",693,1966,2515,4795,1741,2384,858,2668,2016,703,397,1136,1767,8850,null);
		a[61] = new StatsSeason ("13/14","Houston Rockets",779,2179,2339,4424,1814,2549,920,2797,1755,621,461,1323,1676,8829,null);
		a[62] = new StatsSeason ("13/14","Minnesota Timberwolves",600,1757,2589,5418,1790,2301,1024,2644,1963,718,297,1142,1504,8768,null);
		a[63] = new StatsSeason ("13/14","Portland Trail Blazers",770,2071,2437,5063,1569,1926,1022,2786,1904,454,387,1125,1576,8753,null);
		a[64] = new StatsSeason ("13/14","Oklahoma City Thunder/Seattle SuperSonics",664,1839,2530,4943,1653,2052,887,2781,1794,678,501,1256,1858,8705,null);
		a[65] = new StatsSeason ("13/14","San Antonio Spurs",698,1757,2628,5087,1289,1642,762,2786,2064,604,420,1180,1495,8639,null);
		a[66] = new StatsSeason ("13/14","Phoenix Suns",765,2055,2407,4790,1520,2004,928,2601,1563,688,374,1258,1798,8629,null);
		a[67] = new StatsSeason ("13/14","Dallas Mavericks",721,1877,2528,4981,1378,1733,840,2514,1935,704,356,1110,1636,8597,null);
		a[68] = new StatsSeason ("13/14","Denver Nuggets",702,1959,2445,5083,1563,2154,1009,2717,1838,615,459,1305,1890,8559,null);
		a[69] = new StatsSeason ("13/14","Golden State Warriors",774,2037,2462,4968,1303,1731,896,2819,1912,642,407,1247,1784,8549,null);
		a[70] = new StatsSeason ("13/14","Los Angeles Lakers",774,2032,2365,4948,1390,1835,745,2620,2006,611,446,1239,1627,8442,null);
		a[71] = new StatsSeason ("13/14","Miami Heat",665,1829,2477,4443,1431,1884,627,2397,1847,732,367,1212,1596,8380,null);
		a[72] = new StatsSeason ("13/14","Toronto Raptors",713,1917,2279,4801,1608,2055,935,2552,1737,577,343,1159,1882,8305,null);
		a[73] = new StatsSeason ("13/14","Detroit Pistons",507,1580,2675,5544,1415,2111,1196,2525,1714,687,395,1193,1666,8286,null);
		a[74] = new StatsSeason ("13/14","Atlanta Hawks",768,2116,2293,4572,1392,1782,713,2565,2041,680,326,1251,1577,8282,null);
		a[75] = new StatsSeason ("13/14","Washington Wizards",647,1704,2530,5216,1253,1715,886,2573,1909,668,377,1204,1675,8254,null);
		a[76] = new StatsSeason ("13/14","Sacramento Kings",491,1475,2535,5291,1698,2237,990,2656,1547,587,318,1249,1849,8241,null);
		a[77] = new StatsSeason ("13/14","New Orleans/Oklahoma City/New Orleans Pelicans/Hornets",486,1303,2615,5458,1489,1936,933,2486,1745,647,523,1129,1857,8177,null);
		a[78] = new StatsSeason ("13/14","Philadelphia 76ers",577,1847,2531,5303,1362,1918,949,2556,1791,765,330,1384,1844,8155,null);
		a[79] = new StatsSeason ("13/14","New York Knicks",759,2038,2268,4701,1271,1670,870,2437,1641,631,367,1063,1815,8084,null);
		a[80] = new StatsSeason ("13/14","Brooklyn/New Jersey Nets",709,1922,2222,4469,1508,2002,721,2407,1714,705,311,1191,1777,8079,null);
		a[81] = new StatsSeason ("13/14","Cleveland Cavaliers",584,1640,2452,5315,1398,1861,989,2629,1738,579,304,1163,1640,8054,null);
		a[82] = new StatsSeason ("13/14","Charlotte Hornets/Bobcats",516,1471,2460,5259,1474,2000,776,2724,1778,499,421,1010,1493,7942,null);
		a[83] = new StatsSeason ("13/14","Indiana Pacers",550,1542,2399,5031,1485,1907,834,2831,1651,550,446,1237,1675,7933,null);
		a[84] = new StatsSeason ("13/14","Orlando Magic",563,1596,2459,5188,1307,1714,794,2654,1726,630,350,1222,1678,7914,null);
		a[85] = new StatsSeason ("13/14","Boston Celtics",575,1729,2421,5154,1325,1706,980,2505,1726,584,343,1261,1743,7892,null);
		a[86] = new StatsSeason ("13/14","Memphis Grizzlies",405,1147,2717,5576,1235,1666,950,2526,1792,631,375,1124,1568,7884,null);
		a[87] = new StatsSeason ("13/14","Milwaukee Bucks",548,1553,2404,5184,1377,1843,971,2399,1760,541,403,1238,1713,7829,null);
		a[88] = new StatsSeason ("13/14","Utah Jazz",543,1577,2408,5075,1346,1803,904,2477,1664,570,366,1200,1699,7791,null);
		a[89] = new StatsSeason ("13/14","Chicago Bulls",508,1459,2335,5118,1486,1908,937,2683,1860,594,424,1223,1565,7680,null);
		a[90] = new StatsSeason ("12/13","Denver Nuggets",521,1518,2818,5465,1505,2148,1092,2601,2002,762,533,1253,1682,8704,null);
		a[91] = new StatsSeason ("12/13","Houston Rockets",867,2369,2257,4413,1573,2087,909,2652,1902,679,359,1348,1662,8688,null);
		a[92] = new StatsSeason ("12/13","Oklahoma City Thunder/Seattle SuperSonics",598,1588,2528,4916,1819,2196,854,2725,1753,679,624,1253,1654,8669,null);
		a[93] = new StatsSeason ("12/13","San Antonio Spurs",663,1764,2547,4911,1365,1725,666,2721,2058,695,446,1206,1427,8448,null);
		a[94] = new StatsSeason ("12/13","Miami Heat",717,1809,2431,4539,1423,1887,676,2490,1890,710,441,1143,1533,8436,null);
		a[95] = new StatsSeason ("12/13","Los Angeles Lakers",715,2015,2326,4625,1584,2289,942,2732,1818,576,429,1232,1467,8381,null);
		a[96] = new StatsSeason ("12/13","Golden State Warriors",658,1632,2472,5208,1378,1744,885,2801,1845,567,346,1236,1753,8296,null);
		a[97] = new StatsSeason ("12/13","Dallas Mavericks",606,1628,2576,5264,1323,1669,767,2670,1906,648,454,1144,1698,8293,null);
		a[98] = new StatsSeason ("12/13","Los Angeles Clippers",627,1752,2533,4856,1342,1888,938,2475,1958,784,461,1197,1716,8289,null);
		a[99] = new StatsSeason ("12/13","Sacramento Kings",610,1681,2476,5223,1437,1869,943,2385,1708,671,342,1199,1717,8219,null);
		a[100] = new StatsSeason ("12/13","New York Knicks",891,2371,2105,4318,1313,1729,890,2436,1579,672,294,988,1650,8196,null);
		a[101] = new StatsSeason ("12/13","Milwaukee Bucks",601,1670,2527,5527,1251,1700,1068,2537,1876,685,550,1156,1554,8108,null);
		a[102] = new StatsSeason ("12/13","Utah Jazz",507,1385,2539,5325,1439,1883,989,2457,1859,690,515,1210,1750,8038,null);
		a[103] = new StatsSeason ("12/13","Atlanta Hawks",706,1901,2378,4743,1158,1619,758,2593,2007,664,369,1219,1473,8032,null);
		a[104] = new StatsSeason ("12/13","Portland Trail Blazers",673,1904,2336,4811,1304,1680,874,2474,1784,538,353,1203,1518,7995,null);
		a[105] = new StatsSeason ("12/13","Toronto Raptors",571,1665,2408,5020,1442,1831,871,2426,1765,595,392,1124,1836,7971,null);
		a[106] = new StatsSeason ("12/13","Brooklyn/New Jersey Nets",628,1760,2314,4784,1432,1958,1047,2460,1668,599,391,1206,1500,7944,null);
		a[107] = new StatsSeason ("12/13","Cleveland Cavaliers",547,1581,2446,5320,1380,1826,1004,2359,1694,647,334,1149,1737,7913,null);
		a[108] = new StatsSeason ("12/13","Minnesota Timberwolves",450,1475,2493,5227,1515,2042,973,2473,1836,700,387,1214,1509,7851,null);
		a[109] = new StatsSeason ("12/13","Boston Celtics",498,1390,2503,5069,1318,1698,654,2533,1843,667,365,1181,1717,7818,null);
		a[110] = new StatsSeason ("12/13","Phoenix Suns",480,1455,2581,5462,1203,1618,959,2454,1855,659,434,1278,1688,7805,null);
		a[111] = new StatsSeason ("12/13","Detroit Pistons",513,1440,2466,5198,1307,1870,991,2463,1742,574,400,1241,1623,7778,null);
		a[112] = new StatsSeason ("12/13","Orlando Magic",506,1537,2587,5367,1026,1359,890,2612,1871,528,358,1191,1591,7718,null);
		a[113] = new StatsSeason ("12/13","New Orleans/Oklahoma City/New Orleans Pelicans/Hornets",535,1474,2420,5115,1269,1636,988,2426,1721,520,440,1193,1673,7714,null);
		a[114] = new StatsSeason ("12/13","Indiana Pacers",555,1599,2290,4926,1429,1915,1043,2671,1645,580,513,1227,1623,7674,null);
		a[115] = new StatsSeason ("12/13","Charlotte Hornets/Bobcats",469,1399,2354,5250,1546,2060,917,2389,1587,591,479,1153,1561,7661,null);
		a[116] = new StatsSeason ("12/13","Memphis Grizzlies",382,1107,2582,5572,1349,1746,1059,2445,1715,703,436,1144,1660,7659,null);
		a[117] = new StatsSeason ("12/13","Washington Wizards",545,1495,2365,5198,1279,1746,887,2652,1775,598,376,1238,1681,7644,null);
		a[118] = new StatsSeason ("12/13","Chicago Bulls",446,1265,2480,5433,1343,1738,1026,2514,1886,588,417,1171,1617,7641,null);
		a[119] = new StatsSeason ("12/13","Philadelphia 76ers",518,1438,2541,5457,1004,1377,896,2493,1867,609,384,1070,1505,7640,null);
		a[120] = new StatsSeason ("10/11","Denver Nuggets",662,1704,2483,4909,1859,2429,791,2652,1813,605,352,1157,1719,8811,null);
		a[121] = new StatsSeason ("10/11","New York Knicks",765,2081,2375,4786,1689,2087,847,2470,1757,625,475,1123,1743,8734,null);
		a[122] = new StatsSeason ("10/11","Houston Rockets",677,1843,2493,5132,1668,2083,962,2549,1955,581,371,1110,1641,8685,null);
		a[123] = new StatsSeason ("10/11","Phoenix Suns",701,1857,2518,4987,1472,1939,821,2478,1945,545,357,1169,1666,8611,null);
		a[124] = new StatsSeason ("10/11","Oklahoma City Thunder/Seattle SuperSonics",487,1403,2579,5206,1977,2401,903,2604,1672,654,487,1156,1836,8596,null);
		a[125] = new StatsSeason ("10/11","San Antonio Spurs",685,1727,2463,4901,1521,1984,829,2603,1836,602,372,1101,1556,8502,null);
		a[126] = new StatsSeason ("10/11","Golden State Warriors",685,1749,2566,5298,1290,1695,955,2370,1847,737,406,1198,1806,8477,null);
		a[127] = new StatsSeason ("10/11","Miami Heat",547,1479,2484,4822,1760,2288,790,2666,1639,544,430,1142,1674,8369,null);
		a[128] = new StatsSeason ("10/11","Los Angeles Lakers",524,1487,2604,5270,1541,1979,989,2616,1801,602,422,1073,1555,8321,null);
		a[129] = new StatsSeason ("10/11","Minnesota Timberwolves",589,1565,2501,5449,1519,1977,1085,2556,1650,592,422,1398,1825,8288,null);
		a[130] = new StatsSeason ("10/11","Dallas Mavericks",645,1768,2424,4695,1437,1850,780,2618,1954,557,352,1145,1575,8220,null);
		a[131] = new StatsSeason ("10/11","Memphis Grizzlies",309,926,2891,5875,1486,1981,970,2391,1691,771,441,1145,1705,8195,null);
		a[132] = new StatsSeason ("10/11","Indiana Pacers",585,1653,2418,5134,1592,2035,914,2657,1611,584,456,1262,1782,8183,null);
		a[133] = new StatsSeason ("10/11","Utah Jazz",435,1256,2629,5334,1590,2061,898,2338,1921,629,484,1175,1865,8153,null);
		a[134] = new StatsSeason ("10/11","Sacramento Kings",428,1277,2706,5702,1455,1981,1071,2526,1675,608,391,1324,1805,8151,null);
		a[135] = new StatsSeason ("10/11","Orlando Magic",770,2103,2186,4308,1453,2101,864,2679,1636,548,384,1224,1640,8135,null);
		a[136] = new StatsSeason ("10/11","Toronto Raptors",345,1091,2799,5664,1491,1976,963,2343,1795,581,350,1206,1807,8124,null);
		a[137] = new StatsSeason ("10/11","Philadelphia 76ers",443,1248,2682,5528,1426,1851,850,2578,1861,621,355,1063,1592,8119,null);
		a[138] = new StatsSeason ("10/11","Los Angeles Clippers",513,1519,2502,5075,1546,2187,955,2501,1813,585,402,1343,1733,8089,null);
		a[139] = new StatsSeason ("10/11","Chicago Bulls",511,1415,2531,5172,1492,2008,967,2654,1827,592,468,1161,1639,8087,null);
		a[140] = new StatsSeason ("10/11","Washington Wizards",392,1182,2656,5706,1489,1999,1013,2374,1592,665,502,1258,1850,7977,null);
		a[141] = new StatsSeason ("10/11","Detroit Pistons",472,1256,2584,5391,1367,1854,931,2236,1730,595,328,1067,1629,7951,null);
		a[142] = new StatsSeason ("10/11","Boston Celtics",408,1119,2615,5100,1459,1895,639,2542,1921,676,344,1195,1678,7913,null);
		a[143] = new StatsSeason ("10/11","Portland Trail Blazers",518,1503,2433,5096,1476,1835,996,2230,1736,660,358,1070,1585,7896,null);
		a[144] = new StatsSeason ("10/11","Cleveland Cavaliers",509,1489,2377,5158,1546,2075,856,2449,1720,544,341,1166,1648,7827,null);
		a[145] = new StatsSeason ("10/11","Atlanta Hawks",502,1427,2469,5002,1346,1728,762,2460,1802,497,341,1118,1554,7790,null);
		a[146] = new StatsSeason ("10/11","New Orleans/Oklahoma City/New Orleans Pelicans/Hornets",444,1232,2500,5184,1452,1897,824,2468,1691,624,359,1069,1719,7784,null);
		a[147] = new StatsSeason ("10/11","Brooklyn/New Jersey Nets",459,1337,2459,5301,1427,1881,909,2440,1723,458,384,1152,1807,7722,null);
		a[148] = new StatsSeason ("10/11","Charlotte Hornets/Bobcats",393,1203,2480,5162,1511,1999,848,2444,1728,524,433,1192,1637,7650,null);
		a[149] = new StatsSeason ("10/11","Milwaukee Bucks",483,1414,2331,5130,1423,1881,862,2480,1545,617,399,1103,1682,7534,null);
		a[150] = new StatsSeason ("09/10","Golden State Warriors",633,1687,2696,5407,1631,2085,753,2397,1839,761,340,1204,1886,8922,null);
		a[151] = new StatsSeason ("09/10","Denver Nuggets",544,1517,2580,5161,1937,2508,889,2505,1719,683,417,1136,1844,8729,null);
		a[152] = new StatsSeason ("09/10","Utah Jazz",439,1207,2788,5368,1654,2233,872,2588,2187,675,400,1246,1859,8547,null);
		a[153] = new StatsSeason ("09/10","Toronto Raptors",518,1397,2681,5234,1618,2118,806,2507,1804,469,384,1100,1819,8534,null);
		a[154] = new StatsSeason ("09/10","Orlando Magic",841,2241,2164,4153,1575,2176,810,2736,1615,512,456,1155,1629,8426,null);
		a[155] = new StatsSeason ("09/10","Memphis Grizzlies",344,1020,2879,5855,1614,2202,1070,2496,1543,645,399,1248,1655,8404,null);
		a[156] = new StatsSeason ("09/10","Houston Rockets",646,1838,2448,5085,1561,2022,971,2471,1790,583,318,1188,1712,8395,null);
		a[157] = new StatsSeason ("09/10","Cleveland Cavaliers",602,1582,2499,4809,1569,2180,791,2692,1835,564,425,1137,1591,8373,null);
		a[158] = new StatsSeason ("09/10","New York Knicks",743,2145,2384,4731,1376,1759,836,2477,1772,586,305,1148,1638,8373,null);
		a[159] = new StatsSeason ("09/10","Dallas Mavericks",558,1498,2582,5262,1526,1870,834,2586,1917,624,449,1059,1563,8364,null);
		a[160] = new StatsSeason ("09/10","Los Angeles Lakers",532,1562,2612,5313,1519,1985,973,2662,1730,612,400,1096,1592,8339,null);
		a[161] = new StatsSeason ("09/10","Atlanta Hawks",524,1455,2657,5346,1452,1914,969,2451,1789,592,413,980,1632,8338,null);
		a[162] = new StatsSeason ("09/10","Oklahoma City Thunder/Seattle SuperSonics",418,1229,2645,5400,1778,2210,960,2607,1639,654,481,1227,1743,8322,null);
		a[163] = new StatsSeason ("09/10","San Antonio Spurs",554,1547,2596,5112,1458,1969,887,2621,1829,516,381,1116,1669,8312,null);
		a[164] = new StatsSeason ("09/10","Indiana Pacers",659,1896,2361,4927,1564,2019,785,2618,1730,585,439,1232,1848,8263,null);
		a[165] = new StatsSeason ("09/10","New Orleans/Oklahoma City/New Orleans Pelicans/Hornets",571,1572,2607,5270,1293,1661,852,2450,1828,625,300,1103,1606,8220,null);
		a[166] = new StatsSeason ("09/10","Sacramento Kings",482,1383,2662,5512,1430,1969,977,2518,1679,564,366,1226,1827,8200,null);
		a[167] = new StatsSeason ("09/10","Boston Celtics",499,1433,2540,4861,1559,2090,716,2449,1930,701,402,1219,1816,8136,null);
		a[168] = new StatsSeason ("09/10","Minnesota Timberwolves",403,1181,2703,5742,1436,1926,962,2556,1626,597,306,1333,1699,8051,null);
		a[169] = new StatsSeason ("09/10","Portland Trail Blazers",491,1388,2483,5065,1606,2033,913,2383,1674,523,350,1012,1715,8045,null);
		a[170] = new StatsSeason ("09/10","Philadelphia 76ers",474,1381,2613,5325,1366,1808,941,2421,1723,667,439,1192,1677,8014,null);
		a[171] = new StatsSeason ("09/10","Milwaukee Bucks",645,1813,2405,5185,1264,1675,965,2560,1740,580,385,1085,1823,8009,null);
		a[172] = new StatsSeason ("09/10","Chicago Bulls",352,1066,2729,5759,1479,1962,937,2715,1704,531,478,1175,1648,7993,null);
		a[173] = new StatsSeason ("09/10","Miami Heat",494,1426,2490,5092,1452,1931,875,2553,1548,605,457,1079,1710,7914,null);
		a[174] = new StatsSeason ("09/10","Washington Wizards",432,1225,2576,5475,1444,1895,966,2458,1557,493,421,1219,1752,7892,null);
		a[175] = new StatsSeason ("09/10","Los Angeles Clippers",483,1457,2519,5144,1362,1867,927,2502,1810,532,466,1285,1581,7849,null);
		a[176] = new StatsSeason ("09/10","Charlotte Hornets/Bobcats",460,1331,2398,4975,1637,2180,858,2490,1658,632,446,1290,1597,7813,null);
		a[177] = new StatsSeason ("09/10","Detroit Pistons",374,1190,2566,5412,1455,1998,1053,2242,1591,596,313,1100,1822,7709,null);
		a[178] = new StatsSeason ("09/10","Phoenix Suns",730,1770,2609,5018,1631,2117,910,2616,1912,479,418,1210,1713,9039,null);
		a[179] = new StatsSeason ("09/10","Brooklyn/New Jersey Nets",377,1185,2436,5369,1572,2015,897,2358,1540,573,393,1182,1643,7575,null);
		a[180] = new StatsSeason ("08/09","Phoenix Suns",553,1445,2820,5250,1675,2251,900,2520,1905,589,420,1288,1691,8974,null);
		a[181] = new StatsSeason ("08/09","Golden State Warriors",550,1475,2681,5580,1893,2392,953,2492,1711,638,527,1201,1842,8905,null);
		a[182] = new StatsSeason ("08/09","Los Angeles Lakers",547,1516,2760,5465,1607,2087,1015,2587,1908,718,420,1103,1698,8768,null);
		a[183] = new StatsSeason ("08/09","New York Knicks",823,2284,2334,4807,1490,1900,911,2545,1738,610,204,1174,1672,8627,null);
		a[184] = new StatsSeason ("08/09","Indiana Pacers",652,1725,2568,5355,1525,1890,924,2661,1775,573,434,1189,1895,8617,null);
		a[185] = new StatsSeason ("08/09","Denver Nuggets",548,1477,2510,5033,1891,2487,905,2507,1820,710,492,1257,1874,8555,null);
		a[186] = new StatsSeason ("08/09","Utah Jazz",392,1122,2751,5501,1814,2352,940,2423,2024,719,374,1210,1830,8492,null);
		a[187] = new StatsSeason ("08/09","Chicago Bulls",493,1293,2633,5553,1633,2052,970,2481,1732,615,453,1192,1709,8378,null);
		a[188] = new StatsSeason ("08/09","Dallas Mavericks",571,1632,2557,5138,1516,1852,909,2595,1779,591,429,1043,1600,8343,null);
		a[189] = new StatsSeason ("08/09","Orlando Magic",817,2147,2112,4269,1611,2253,819,2728,1593,570,439,1142,1664,8286,null);
		a[190] = new StatsSeason ("08/09","Boston Celtics",538,1355,2537,4978,1587,2075,869,2586,1862,621,387,1280,1897,8275,null);
		a[191] = new StatsSeason ("08/09","Sacramento Kings",586,1594,2404,5091,1682,2107,840,2366,1619,569,349,1266,1910,8248,null);
		a[192] = new StatsSeason ("08/09","Cleveland Cavaliers",656,1670,2366,4784,1523,2012,886,2574,1663,593,435,1045,1663,8223,null);
		a[193] = new StatsSeason ("08/09","Portland Trail Blazers",596,1555,2422,4939,1521,1988,1060,2360,1667,550,402,1055,1671,8153,null);
		a[194] = new StatsSeason ("08/09","Milwaukee Bucks",511,1408,2498,5347,1613,2067,973,2367,1802,609,308,1154,1986,8142,null);
		a[195] = new StatsSeason ("08/09","Toronto Raptors",479,1289,2575,5384,1534,1861,802,2513,1835,523,390,1098,1593,8121,null);
		a[196] = new StatsSeason ("08/09","Houston Rockets",621,1656,2338,4870,1531,1903,862,2662,1662,548,355,1158,1553,8070,null);
		a[197] = new StatsSeason ("08/09","Miami Heat",582,1631,2452,5015,1411,1871,828,2411,1671,651,451,1026,1696,8061,null);
		a[198] = new StatsSeason ("08/09","Atlanta Hawks",597,1633,2359,4818,1537,2085,870,2412,1657,603,376,1048,1610,8046,null);
		a[199] = new StatsSeason ("08/09","Brooklyn/New Jersey Nets",652,1735,2273,4801,1542,1980,850,2415,1636,559,391,1075,1838,8044,null);
		a[200] = new StatsSeason ("08/09","Minnesota Timberwolves",543,1539,2443,5227,1504,1957,975,2442,1674,512,322,1165,1785,8019,null);
		a[201] = new StatsSeason ("08/09","Philadelphia 76ers",341,1072,2656,5460,1652,2216,1039,2336,1647,658,415,1157,1650,7987,null);
		a[202] = new StatsSeason ("08/09","San Antonio Spurs",625,1620,2417,4914,1249,1641,728,2638,1736,474,329,963,1546,7958,null);
		a[203] = new StatsSeason ("08/09","Oklahoma City Thunder/Seattle SuperSonics",328,949,2671,5767,1626,2069,999,2497,1663,608,371,1330,1655,7952,null);
		a[204] = new StatsSeason ("08/09","Washington Wizards",395,1198,2599,5457,1494,1948,956,2330,1641,619,365,1146,1679,7877,null);
		a[205] = new StatsSeason ("08/09","New Orleans/Oklahoma City/New Orleans Pelicans/Hornets",556,1526,2355,4840,1479,1833,802,2453,1609,593,338,1029,1665,7857,null);
		a[206] = new StatsSeason ("08/09","Los Angeles Clippers",535,1513,2420,5183,1354,1839,890,2377,1723,572,482,1221,1650,7799,null);
		a[207] = new StatsSeason ("08/09","Detroit Pistons",377,1079,2604,5480,1388,1849,949,2448,1689,493,377,973,1712,7727,null);
		a[208] = new StatsSeason ("08/09","Memphis Grizzlies",398,1106,2467,5205,1570,2077,847,2337,1423,615,385,1252,1777,7698,null);
		a[209] = new StatsSeason ("08/09","Charlotte Hornets/Bobcats",490,1339,2376,4960,1455,1965,886,2366,1741,580,397,1279,1754,7677,null);
		a[210] = new StatsSeason ("07/08","Golden State Warriors",761,2185,2642,5221,1538,2044,1045,2496,1833,744,377,1082,1875,9105,null);
		a[211] = new StatsSeason ("07/08","Denver Nuggets",569,1605,2738,5433,1891,2519,918,2698,2024,752,551,1203,1731,9074,null);
		a[212] = new StatsSeason ("07/08","Phoenix Suns",694,1764,2698,5018,1548,1977,720,2683,2188,532,518,1184,1633,9026,null);
		a[213] = new StatsSeason ("07/08","Los Angeles Lakers",662,1751,2586,5067,1746,2270,898,2722,2003,654,438,1156,1691,8904,null);
		a[214] = new StatsSeason ("07/08","Utah Jazz",407,1095,2872,5497,1745,2298,942,2410,2165,717,355,1200,1970,8710,null);
		a[215] = new StatsSeason ("07/08","Orlando Magic",801,2074,2257,4372,1650,2288,768,2677,1706,520,333,1173,1688,8567,null);
		a[216] = new StatsSeason ("07/08","Indiana Pacers",755,2021,2347,4972,1568,2042,904,2633,1864,623,412,1236,1921,8527,null);
		a[217] = new StatsSeason ("07/08","Sacramento Kings",510,1367,2533,5191,1812,2272,829,2456,1567,651,334,1317,1839,8408,null);
		a[218] = new StatsSeason ("07/08","New Orleans/Oklahoma City/New Orleans Pelicans/Hornets",630,1621,2534,5175,1312,1707,937,2494,1785,637,321,974,1531,8270,null);
		a[219] = new StatsSeason ("07/08","Memphis Grizzlies",620,1779,2440,4958,1517,2097,848,2567,1574,503,386,1251,1592,8257,null);
		a[220] = new StatsSeason ("07/08","Boston Celtics",596,1564,2390,4722,1677,2176,830,2615,1833,696,379,1246,1864,8245,null);
		a[221] = new StatsSeason ("07/08","Dallas Mavericks",494,1403,2531,5112,1690,2075,883,2643,1720,490,402,1037,1786,8234,null);
		a[222] = new StatsSeason ("07/08","Toronto Raptors",572,1459,2576,5267,1347,1658,790,2496,1953,570,336,959,1596,8215,null);
		a[223] = new StatsSeason ("07/08","Washington Wizards",575,1614,2411,5081,1557,1991,1007,2404,1607,632,391,1082,1606,8104,null);
		a[224] = new StatsSeason ("07/08","Atlanta Hawks",384,1078,2591,5474,1720,2227,1008,2454,1804,600,448,1223,1673,8054,null);
		a[225] = new StatsSeason ("07/08","Oklahoma City Thunder/Seattle SuperSonics",313,939,2812,6093,1436,1866,971,2688,1748,531,400,1310,1680,7999,null);
		a[226] = new StatsSeason ("07/08","Detroit Pistons",487,1330,2512,5221,1507,1965,974,2423,1831,583,472,956,1688,7992,null);
		a[227] = new StatsSeason ("07/08","Chicago Bulls",474,1305,2513,5556,1533,2029,1050,2478,1811,635,429,1197,1784,7981,null);
		a[228] = new StatsSeason ("07/08","Charlotte Hornets/Bobcats",529,1443,2431,5111,1510,2115,892,2440,1748,614,402,1204,1777,7959,null);
		a[229] = new StatsSeason ("07/08","Milwaukee Bucks",452,1313,2574,5432,1452,1980,1055,2363,1760,544,361,1210,1748,7956,null);
		a[230] = new StatsSeason ("07/08","New York Knicks",490,1454,2477,5303,1524,2095,1029,2457,1530,521,213,1187,1761,7948,null);
		a[231] = new StatsSeason ("07/08","Houston Rockets",583,1707,2420,4991,1342,1848,1002,2659,1757,598,420,1125,1609,7931,null);
		a[232] = new StatsSeason ("07/08","Philadelphia 76ers",302,952,2754,5696,1509,2137,1067,2370,1673,712,400,1172,1620,7923,null);
		a[233] = new StatsSeason ("07/08","Cleveland Cavaliers",552,1544,2385,5153,1477,2061,1092,2563,1640,579,427,1145,1712,7903,null);
		a[234] = new StatsSeason ("07/08","Brooklyn/New Jersey Nets",498,1430,2358,5020,1647,2237,913,2520,1925,521,390,1229,1855,7857,null);
		a[235] = new StatsSeason ("07/08","Minnesota Timberwolves",441,1259,2635,5558,1246,1693,964,2428,1630,616,306,1188,1885,7839,null);
		a[236] = new StatsSeason ("07/08","San Antonio Spurs",594,1610,2344,4814,1350,1774,771,2612,1718,521,337,1035,1537,7820,null);
		a[237] = new StatsSeason ("07/08","Portland Trail Blazers",538,1426,2397,5120,1412,1841,901,2438,1733,455,360,1056,1642,7820,null);
		a[238] = new StatsSeason ("07/08","Los Angeles Clippers",350,1079,2470,5366,1702,2178,800,2491,1732,557,398,1180,1745,7692,null);
		a[239] = new StatsSeason ("07/08","Miami Heat",491,1373,2317,4963,1384,1903,743,2342,1644,589,355,1202,1670,7491,null);
		a[240] = new StatsSeason ("06/07","Phoenix Suns",785,1965,2603,4890,1476,1827,737,2583,2122,553,394,1189,1659,9037,null);
		a[241] = new StatsSeason ("06/07","Golden State Warriors",700,1967,2561,5081,1515,2113,940,2456,1950,750,466,1309,1933,8737,null);
		a[242] = new StatsSeason ("06/07","Denver Nuggets",484,1440,2680,5365,1827,2449,1001,2558,1920,678,435,1352,1756,8639,null);
		a[243] = new StatsSeason ("06/07","Washington Wizards",561,1614,2509,5206,1855,2425,998,2379,1660,635,375,1133,1823,8556,null);
		a[244] = new StatsSeason ("06/07","Los Angeles Lakers",608,1724,2495,4940,1660,2221,886,2495,1850,600,421,1273,1889,8474,null);
		a[245] = new StatsSeason ("06/07","Memphis Grizzlies",500,1362,2498,5086,1835,2410,866,2375,1680,564,407,1343,1827,8331,null);
		a[246] = new StatsSeason ("06/07","Utah Jazz",354,1056,2715,5415,1830,2462,1030,2456,2024,577,339,1277,2067,8322,null);
		a[247] = new StatsSeason ("06/07","Sacramento Kings",530,1513,2411,5019,1891,2473,797,2396,1665,671,265,1194,1792,8303,null);
		a[248] = new StatsSeason ("06/07","Dallas Mavericks",535,1404,2475,5038,1646,2045,920,2515,1632,560,408,1140,1837,8201,null);
		a[249] = new StatsSeason ("06/07","Milwaukee Bucks",524,1472,2597,5242,1406,1919,941,2272,1771,587,224,1240,1821,8172,null);
		a[250] = new StatsSeason ("06/07","Toronto Raptors",531,1464,2501,5083,1562,1982,755,2480,1822,581,321,1104,1672,8157,null);
		a[251] = new StatsSeason ("06/07","Oklahoma City Thunder/Seattle SuperSonics",525,1451,2522,5177,1511,1911,928,2322,1695,631,301,1268,1801,8130,null);
		a[252] = new StatsSeason ("06/07","Chicago Bulls",480,1237,2566,5426,1528,2083,984,2597,1832,639,445,1310,1908,8100,null);
		a[253] = new StatsSeason ("06/07","San Antonio Spurs",595,1561,2404,4767,1486,1980,761,2577,1814,587,417,1137,1588,8079,null);
		a[254] = new StatsSeason ("06/07","Brooklyn/New Jersey Nets",609,1676,2304,4703,1566,2153,822,2525,1962,499,273,1212,1869,8001,null);
		a[255] = new StatsSeason ("06/07","New York Knicks",474,1370,2429,4986,1714,2396,1032,2516,1532,543,260,1405,1932,7994,null);
		a[256] = new StatsSeason ("06/07","Houston Rockets",705,1893,2201,4635,1436,1906,880,2673,1704,583,337,1162,1710,7953,null);
		a[257] = new StatsSeason ("06/07","Charlotte Hornets/Bobcats",457,1280,2503,5363,1568,2136,920,2346,1836,638,369,1224,1985,7945,null);
		a[258] = new StatsSeason ("06/07","Cleveland Cavaliers",494,1404,2484,5254,1484,2133,1039,2529,1708,625,353,1177,1781,7934,null);
		a[259] = new StatsSeason ("06/07","Minnesota Timberwolves",384,1089,2613,5414,1499,1892,819,2474,1848,532,325,1278,1758,7877,null);
		a[260] = new StatsSeason ("06/07","Detroit Pistons",449,1305,2493,5179,1539,1988,948,2374,1768,583,472,1001,1672,7872,null);
		a[261] = new StatsSeason ("06/07","Boston Celtics",471,1283,2387,5171,1670,2178,918,2391,1630,589,382,1350,1971,7857,null);
		a[262] = new StatsSeason ("06/07","Los Angeles Clippers",314,903,2566,5415,1769,2245,888,2484,1762,596,472,1239,1858,7843,null);
		a[263] = new StatsSeason ("06/07","Indiana Pacers",481,1389,2391,5172,1615,2125,990,2441,1680,599,447,1335,1912,7840,null);
		a[264] = new StatsSeason ("06/07","New Orleans/Oklahoma City/New Orleans Pelicans/Hornets",455,1256,2516,5418,1436,1941,1025,2512,1537,522,347,1187,1620,7833,null);
		a[265] = new StatsSeason ("06/07","Philadelphia 76ers",284,823,2648,5585,1637,2135,899,2353,1669,590,390,1258,1671,7785,null);
		a[266] = new StatsSeason ("06/07","Orlando Magic",342,962,2533,5128,1679,2393,920,2418,1525,565,416,1392,1904,7771,null);
		a[267] = new StatsSeason ("06/07","Miami Heat",528,1539,2391,4749,1393,2019,817,2526,1681,566,442,1201,1749,7759,null);
		a[268] = new StatsSeason ("06/07","Portland Trail Blazers",426,1232,2448,5160,1543,2006,923,2299,1513,555,380,1236,1931,7717,null);
		a[269] = new StatsSeason ("06/07","Atlanta Hawks",341,1038,2490,5334,1677,2203,976,2312,1573,609,446,1306,1970,7680,null);
		a[270] = new StatsSeason ("05/06","Phoenix Suns",837,2097,2593,5070,1189,1475,778,2650,2179,549,412,1088,1683,8886,null);
		a[271] = new StatsSeason ("05/06","Oklahoma City Thunder/Seattle SuperSonics",605,1631,2472,5080,1652,2104,1013,2233,1696,622,306,1208,1933,8411,null);
		a[272] = new StatsSeason ("05/06","Washington Wizards",497,1394,2478,5262,1889,2496,1035,2344,1523,658,339,1143,1855,8336,null);
		a[273] = new StatsSeason ("05/06","Toronto Raptors",608,1620,2405,5019,1653,2089,864,2291,1593,529,272,1071,1965,8287,null);
		a[274] = new StatsSeason ("05/06","Denver Nuggets",350,1076,2728,5596,1721,2312,903,2486,1921,698,463,1216,1863,8227,null);
		a[275] = new StatsSeason ("05/06","Miami Heat",497,1441,2542,4914,1616,2310,858,2675,1692,522,442,1186,1871,8191,null);
		a[276] = new StatsSeason ("05/06","Los Angeles Lakers",552,1583,2440,5024,1618,2172,970,2488,1734,628,350,1143,1894,8154,null);
		a[277] = new StatsSeason ("05/06","Philadelphia 76ers",375,1031,2626,5515,1770,2330,873,2425,1653,651,404,1159,1712,8147,null);
		a[278] = new StatsSeason ("05/06","Dallas Mavericks",416,1113,2532,5262,1818,2322,1030,2431,1473,593,488,1112,1834,8130,null);
		a[279] = new StatsSeason ("05/06","Sacramento Kings",494,1408,2460,5092,1704,2173,852,2473,1825,608,299,1199,1672,8106,null);
		a[280] = new StatsSeason ("05/06","Golden State Warriors",625,1832,2314,4953,1573,2190,980,2485,1694,604,357,1156,1941,8076,null);
		a[281] = new StatsSeason ("05/06","Boston Celtics",467,1290,2484,5032,1664,2204,813,2432,1716,578,422,1359,2033,8033,null);
		a[282] = new StatsSeason ("05/06","Milwaukee Bucks",507,1335,2469,5231,1561,2115,929,2448,1769,597,270,1197,1902,8020,null);
		a[283] = new StatsSeason ("05/06","Chicago Bulls",560,1477,2444,5260,1452,1967,906,2602,1804,508,345,1224,2038,8020,null);
		a[284] = new StatsSeason ("05/06","Cleveland Cavaliers",497,1465,2411,4947,1689,2318,959,2511,1560,567,392,1137,1733,8002,null);
		a[285] = new StatsSeason ("05/06","Atlanta Hawks",424,1154,2522,5342,1656,2207,1069,2232,1625,587,394,1284,2054,7972,null);
		a[286] = new StatsSeason ("05/06","Los Angeles Clippers",290,843,2703,5600,1694,2142,828,2704,1708,534,503,1185,1872,7970,null);
		a[287] = new StatsSeason ("05/06","Charlotte Hornets/Bobcats",428,1261,2533,5582,1593,2186,990,2270,1717,822,354,1167,1960,7943,null);
		a[288] = new StatsSeason ("05/06","Detroit Pistons",557,1451,2426,5107,1418,1950,975,2347,1971,580,490,931,1513,7941,null);
		a[289] = new StatsSeason ("05/06","New York Knicks",320,884,2502,5322,1878,2587,1034,2360,1468,555,271,1449,2157,7842,null);
		a[290] = new StatsSeason ("05/06","San Antonio Spurs",524,1362,2469,4980,1327,1891,851,2548,1717,543,467,1126,1714,7837,null);
		a[291] = new StatsSeason ("05/06","Orlando Magic",299,796,2612,5371,1663,2277,892,2402,1495,532,362,1240,1908,7784,null);
		a[292] = new StatsSeason ("05/06","Indiana Pacers",536,1536,2250,4738,1591,2158,898,2559,1631,598,409,1254,1821,7699,null);
		a[293] = new StatsSeason ("05/06","Brooklyn/New Jersey Nets",477,1447,2301,4870,1658,2187,822,2539,1884,558,278,1119,1903,7691,null);
		a[294] = new StatsSeason ("05/06","New Orleans/Oklahoma City/New Orleans Pelicans/Hornets",300,885,2531,5543,1649,2176,918,2379,1519,611,311,1095,1786,7611,null);
		a[295] = new StatsSeason ("05/06","Utah Jazz",311,925,2433,5282,1774,2466,1071,2380,1772,524,492,1290,2032,7573,null);
		a[296] = new StatsSeason ("05/06","Memphis Grizzlies",590,1578,2156,4547,1476,2077,834,2379,1586,600,442,1134,1757,7558,null);
		a[297] = new StatsSeason ("05/06","Minnesota Timberwolves",310,942,2578,5398,1436,1895,811,2422,1716,559,471,1189,1889,7522,null);
		a[298] = new StatsSeason ("05/06","Houston Rockets",469,1414,2239,4838,1502,1980,849,2565,1580,588,320,1193,1863,7387,null);
		a[299] = new StatsSeason ("05/06","Portland Trail Blazers",364,1042,2427,5225,1339,1944,886,2203,1490,529,435,1205,1828,7285,null);

		int aux = 0;
		while (aux < 300){
			hash.put(a[aux].getTeam().toString(), a[aux]);

			aux++;
		}

		return hash;

	}

	public static Map<String, StatsSeason> hardCodeDefensive () throws IOException{

		Map<String, StatsSeason> hash = new HashMap<String, StatsSeason> ();

		StatsSeason a [] = new StatsSeason[300];

		a[0] = new StatsSeason ("05/06","Memphis Grizzlies",408,1223,2283,4949,1465,1942,927,2404,1605,597,456,1213,1867,7255,null);
		a[1] = new StatsSeason ("05/06","San Antonio Spurs",300,886,2482,5534,1414,1912,886,2417,1336,599,343,1136,1709,7278,null);
		a[2] = new StatsSeason ("05/06","Detroit Pistons",329,1012,2586,5438,1235,1677,951,2399,1541,481,285,1145,1726,7394,null);
		a[3] = new StatsSeason ("05/06","Houston Rockets",541,1465,2167,4845,1560,2135,874,2477,1647,582,373,1094,1716,7517,null);
		a[4] = new StatsSeason ("05/06","Indiana Pacers",371,1083,2460,5421,1511,2060,968,2416,1520,661,399,1112,1800,7544,null);
		a[5] = new StatsSeason ("05/06","Brooklyn/New Jersey Nets",465,1336,2265,4886,1654,2232,787,2599,1641,589,329,1177,1889,7579,null);
		a[6] = new StatsSeason ("05/06","Dallas Mavericks",404,1120,2397,5199,1626,2163,935,2209,1433,536,400,1151,1958,7632,null);
		a[7] = new StatsSeason ("05/06","Minnesota Timberwolves",447,1229,2405,5245,1525,2072,974,2411,1554,539,374,1139,1736,7676,null);
		a[8] = new StatsSeason ("05/06","Utah Jazz",490,1297,2240,4780,1839,2466,871,2237,1511,663,463,1166,2104,7789,null);
		a[9] = new StatsSeason ("05/06","Cleveland Cavaliers",459,1291,2490,5190,1462,1970,807,2421,1666,540,357,1079,1842,7819,null);
		a[10] = new StatsSeason ("05/06","Los Angeles Clippers",474,1367,2413,5271,1593,2175,858,2432,1765,570,355,1053,1777,7841,null);
		a[11] = new StatsSeason ("05/06","New Orleans/Oklahoma City Hornets/New Orleans Hornets/Pelicans",546,1486,2337,4800,1530,2014,860,2498,1584,527,432,1197,1910,7842,null);
		a[12] = new StatsSeason ("05/06","Orlando Magic",460,1287,2410,5040,1672,2285,911,2239,1644,615,386,1099,1899,7872,null);
		a[13] = new StatsSeason ("05/06","Miami Heat",490,1359,2381,5170,1642,2223,826,2359,1596,560,298,1063,1938,7874,null);
		a[14] = new StatsSeason ("05/06","Los Angeles Lakers",474,1342,2471,5205,1585,2123,893,2399,1730,536,354,1158,1925,7949,null);
		a[15] = new StatsSeason ("05/06","Chicago Bulls",501,1428,2272,5087,1921,2472,881,2541,1652,611,420,1228,1883,7968,null);
		a[16] = new StatsSeason ("05/06","Sacramento Kings",462,1316,2591,5410,1412,1891,953,2503,1733,656,403,1199,1886,7980,null);
		a[17] = new StatsSeason ("05/06","Portland Trail Blazers",498,1306,2534,5166,1498,1971,1029,2445,1737,592,403,1060,1704,8060,null);
		a[18] = new StatsSeason ("05/06","Milwaukee Bucks",490,1385,2482,4998,1671,2237,832,2475,1847,606,414,1182,1937,8105,null);
		a[19] = new StatsSeason ("05/06","Boston Celtics",446,1265,2498,5197,1825,2457,910,2369,1763,688,404,1210,1837,8159,null);
		a[20] = new StatsSeason ("05/06","Washington Wizards",501,1379,2513,5098,1655,2222,964,2477,1766,537,341,1326,2075,8184,null);
		a[21] = new StatsSeason ("05/06","Golden State Warriors",469,1335,2578,5339,1624,2187,985,2662,1828,576,409,1258,1919,8187,null);
		a[22] = new StatsSeason ("05/06","Denver Nuggets",530,1480,2540,5284,1538,2090,965,2469,1959,586,436,1323,1911,8208,null);
		a[23] = new StatsSeason ("05/06","Charlotte Bobcats/Hornets",458,1285,2607,5125,1683,2283,940,2667,1881,577,441,1464,1929,8271,null);
		a[24] = new StatsSeason ("05/06","Philadelphia 76ers",498,1420,2602,5279,1609,2111,974,2533,1882,630,386,1269,1898,8307,null);
		a[25] = new StatsSeason ("05/06","Atlanta Hawks",444,1205,2631,5228,1768,2372,981,2335,1689,597,422,1227,1855,8362,null);
		a[26] = new StatsSeason ("05/06","New York Knicks",565,1495,2402,4864,1868,2480,883,2280,1744,674,437,1154,2079,8367,null);
		a[27] = new StatsSeason ("05/06","Phoenix Suns",516,1423,2727,5718,1429,1956,1028,2735,1546,591,282,1218,1623,8431,null);
		a[28] = new StatsSeason ("05/06","Toronto Raptors",508,1363,2656,5085,1696,2267,835,2539,1938,518,359,1165,1834,8532,null);
		a[29] = new StatsSeason ("05/06","Seattle SuperSonics/Oklahoma City Thunder",542,1445,2660,5151,1713,2255,1003,2316,1973,598,399,1194,1820,8659,null);
		a[30] = new StatsSeason ("06/07","San Antonio Spurs",368,1101,2492,5362,1300,1756,829,2379,1416,580,337,1176,1739,7388,null);
		a[31] = new StatsSeason ("06/07","Detroit Pistons",409,1205,2410,5132,1484,2006,973,2403,1647,521,290,1205,1668,7531,null);
		a[32] = new StatsSeason ("06/07","Houston Rockets",472,1346,2321,5157,1497,2000,800,2548,1588,571,353,1163,1631,7555,null);
		a[33] = new StatsSeason ("06/07","Dallas Mavericks",375,1074,2415,5167,1654,2216,839,2286,1471,565,312,1190,1811,7609,null);
		a[34] = new StatsSeason ("06/07","Cleveland Cavaliers",405,1231,2433,5106,1539,2096,807,2461,1649,540,349,1254,1804,7620,null);
		a[35] = new StatsSeason ("06/07","Chicago Bulls",484,1387,2309,5029,1619,2219,897,2456,1675,614,433,1429,1900,7689,null);
		a[36] = new StatsSeason ("06/07","Orlando Magic",461,1306,2278,4885,1768,2327,865,2217,1609,678,376,1232,1921,7707,null);
		a[37] = new StatsSeason ("06/07","Miami Heat",531,1495,2364,5022,1513,2039,921,2467,1656,562,314,1185,1790,7834,null);
		a[38] = new StatsSeason ("06/07","Los Angeles Clippers",455,1341,2457,5095,1602,2142,843,2377,1722,582,321,1132,1829,7881,null);
		a[39] = new StatsSeason ("06/07","New Orleans/Oklahoma City Hornets/New Orleans Hornets/Pelicans",559,1575,2445,5004,1395,1839,853,2493,1703,554,392,1119,1733,7962,null);
		a[40] = new StatsSeason ("06/07","Philadelphia 76ers",503,1424,2536,5146,1452,1926,969,2404,1825,606,320,1280,1801,8033,null);
		a[41] = new StatsSeason ("06/07","Indiana Pacers",437,1175,2494,5241,1741,2311,915,2499,1642,644,410,1289,1942,8040,null);
		a[42] = new StatsSeason ("06/07","Brooklyn/New Jersey Nets",519,1455,2392,5021,1723,2261,867,2526,1805,584,369,1188,1886,8064,null);
		a[43] = new StatsSeason ("06/07","Portland Trail Blazers",467,1293,2495,4999,1678,2157,850,2347,1703,539,380,1127,1750,8069,null);
		a[44] = new StatsSeason ("06/07","Atlanta Hawks",465,1236,2488,5099,1699,2315,948,2370,1732,597,421,1247,1853,8070,null);
		a[45] = new StatsSeason ("06/07","Toronto Raptors",533,1491,2518,5102,1441,1911,848,2641,1742,489,317,1241,1786,8076,null);
		a[46] = new StatsSeason ("06/07","Utah Jazz",506,1424,2313,4767,1943,2534,813,2223,1552,623,438,1230,2010,8087,null);
		a[47] = new StatsSeason ("06/07","Boston Celtics",429,1212,2537,5125,1776,2376,848,2476,1811,604,449,1250,1757,8137,null);
		a[48] = new StatsSeason ("06/07","Minnesota Timberwolves",518,1488,2557,5201,1510,1987,957,2438,1782,583,360,1163,1679,8178,null);
		a[49] = new StatsSeason ("06/07","New York Knicks",573,1523,2448,5043,1613,2135,885,2297,1748,616,406,1122,1875,8228,null);
		a[50] = new StatsSeason ("06/07","Charlotte Bobcats/Hornets",452,1245,2547,5205,1802,2404,929,2562,1717,603,437,1296,1786,8252,null);
		a[51] = new StatsSeason ("06/07","Seattle SuperSonics/Oklahoma City Thunder",519,1437,2607,5131,1596,2124,954,2408,1870,590,341,1233,1635,8367,null);
		a[52] = new StatsSeason ("06/07","Phoenix Suns",504,1387,2734,5700,1458,1901,1008,2504,1548,566,304,1242,1759,8438,null);
		a[53] = new StatsSeason ("06/07","Sacramento Kings",557,1524,2590,5147,1600,2115,907,2648,1840,572,405,1335,1990,8451,null);
		a[54] = new StatsSeason ("06/07","Los Angeles Lakers",523,1462,2574,5257,1763,2320,955,2508,1798,649,409,1208,1916,8480,null);
		a[55] = new StatsSeason ("06/07","Denver Nuggets",554,1569,2703,5519,1438,1945,1006,2461,2010,680,424,1343,1946,8506,null);
		a[56] = new StatsSeason ("06/07","Milwaukee Bucks",565,1537,2636,5136,1564,2109,1062,2468,2077,615,433,1284,1718,8531,null);
		a[57] = new StatsSeason ("06/07","Washington Wizards",598,1585,2568,5115,1668,2146,973,2551,1942,519,380,1291,1927,8598,null);
		a[58] = new StatsSeason ("06/07","Memphis Grizzlies",576,1480,2711,5281,1603,2113,965,2483,2062,681,450,1253,1992,8753,null);
		a[59] = new StatsSeason ("06/07","Golden State Warriors",609,1664,2562,5207,1814,2419,1074,2733,2023,680,399,1525,1832,8765,null);
		a[60] = new StatsSeason ("07/08","Detroit Pistons",409,1233,2318,5006,1523,2047,865,2344,1563,477,319,1108,1618,7386,null);
		a[61] = new StatsSeason ("07/08","Boston Celtics",485,1535,2172,4806,1605,2160,899,2290,1539,594,389,1308,1818,7404,null);
		a[62] = new StatsSeason ("07/08","San Antonio Spurs",420,1227,2437,5204,1293,1710,776,2527,1490,566,361,1058,1625,7427,null);
		a[63] = new StatsSeason ("07/08","Houston Rockets",433,1186,2419,5408,1410,1912,894,2441,1548,622,379,1094,1615,7547,null);
		a[64] = new StatsSeason ("07/08","New Orleans/Oklahoma City Hornets/New Orleans Hornets/Pelicans",544,1552,2494,5052,1217,1579,815,2533,1779,470,331,1136,1573,7837,null);
		a[65] = new StatsSeason ("07/08","Dallas Mavericks",408,1168,2495,5383,1648,2168,882,2419,1547,536,357,999,1739,7862,null);
		a[66] = new StatsSeason ("07/08","Philadelphia 76ers",557,1549,2443,4955,1332,1726,923,2293,1903,550,420,1289,1708,7889,null);
		a[67] = new StatsSeason ("07/08","Portland Trail Blazers",533,1499,2450,5117,1401,1828,957,2465,1714,488,301,1026,1656,7900,null);
		a[68] = new StatsSeason ("07/08","Cleveland Cavaliers",506,1419,2433,5043,1548,2070,814,2500,1721,559,388,1092,1666,7932,null);
		a[69] = new StatsSeason ("07/08","Toronto Raptors",619,1683,2388,4886,1344,1732,830,2583,1797,470,333,1149,1508,7977,null);
		a[70] = new StatsSeason ("07/08","Orlando Magic",516,1441,2541,5414,1489,1975,900,2519,1764,581,344,1081,1898,8119,null);
		a[71] = new StatsSeason ("07/08","Washington Wizards",683,1768,2332,4769,1418,1880,900,2478,1958,529,360,1149,1656,8131,null);
		a[72] = new StatsSeason ("07/08","Utah Jazz",506,1419,2390,4867,1848,2468,844,2256,1629,619,420,1305,1891,8146,null);
		a[73] = new StatsSeason ("07/08","Miami Heat",552,1497,2477,4980,1590,2105,916,2617,1817,631,341,1166,1650,8200,null);
		a[74] = new StatsSeason ("07/08","Atlanta Hawks",512,1413,2603,5320,1461,1943,968,2386,1825,615,421,1123,1793,8203,null);
		a[75] = new StatsSeason ("07/08","Chicago Bulls",571,1522,2411,5061,1699,2217,914,2582,1794,648,465,1254,1746,8234,null);
		a[76] = new StatsSeason ("07/08","Brooklyn/New Jersey Nets",534,1448,2448,5095,1774,2311,896,2517,1810,662,362,1098,1836,8272,null);
		a[77] = new StatsSeason ("07/08","Los Angeles Clippers",486,1393,2628,5277,1574,2096,916,2657,1834,590,388,1112,1773,8288,null);
		a[78] = new StatsSeason ("07/08","Los Angeles Lakers",554,1531,2573,5491,1501,1995,988,2521,1793,634,368,1168,1850,8309,null);
		a[79] = new StatsSeason ("07/08","Charlotte Bobcats/Hornets",517,1456,2598,5228,1571,2102,999,2588,1785,625,476,1177,1721,8318,null);
		a[80] = new StatsSeason ("07/08","Minnesota Timberwolves",541,1516,2515,4965,1742,2266,871,2545,1899,610,467,1103,1434,8395,null);
		a[81] = new StatsSeason ("07/08","New York Knicks",587,1592,2597,5119,1535,2078,924,2573,1773,621,429,1046,1665,8490,null);
		a[82] = new StatsSeason ("07/08","Milwaukee Bucks",588,1530,2559,5032,1639,2141,872,2464,1913,647,404,1125,1727,8521,null);
		a[83] = new StatsSeason ("07/08","Sacramento Kings",597,1600,2540,5132,1722,2287,970,2465,1878,661,452,1250,1892,8593,null);
		a[84] = new StatsSeason ("07/08","Phoenix Suns",469,1329,2899,6055,1407,1879,1101,2498,1607,601,311,1101,1731,8612,null);
		a[85] = new StatsSeason ("07/08","Indiana Pacers",606,1571,2487,5246,1850,2443,929,2800,1820,663,416,1297,1782,8642,null);
		a[86] = new StatsSeason ("07/08","Seattle SuperSonics/Oklahoma City Thunder",607,1576,2681,5560,1534,2048,961,2655,1997,706,440,1082,1610,8717,null);
		a[87] = new StatsSeason ("07/08","Memphis Grizzlies",591,1625,2803,5451,1387,1791,932,2721,1963,711,403,1096,1842,8766,null);
		a[88] = new StatsSeason ("07/08","Denver Nuggets",621,1710,2713,5593,1481,2028,1042,2680,2107,644,393,1343,1950,8770,null);
		a[89] = new StatsSeason ("07/08","Golden State Warriors",572,1556,2701,5442,1806,2378,1053,2803,1939,567,413,1384,1736,8924,null);
		a[90] = new StatsSeason ("08/09","Cleveland Cavaliers",482,1447,2293,4997,1459,1895,878,2310,1568,519,338,1137,1664,7491,null);
		a[91] = new StatsSeason ("08/09","San Antonio Spurs",447,1180,2526,5388,1257,1635,745,2570,1481,531,352,961,1511,7650,null);
		a[92] = new StatsSeason ("08/09","Boston Celtics",507,1452,2256,4966,1626,2110,834,2249,1553,585,389,1195,1820,7659,null);
		a[93] = new StatsSeason ("08/09","Portland Trail Blazers",487,1301,2412,5001,1430,1780,786,2190,1590,514,319,1082,1733,7715,null);
		a[94] = new StatsSeason ("08/09","New Orleans/Oklahoma City Hornets/New Orleans Hornets/Pelicans",575,1625,2276,4704,1453,1879,822,2459,1649,476,290,1089,1675,7730,null);
		a[95] = new StatsSeason ("08/09","Orlando Magic",444,1297,2492,5488,1421,1882,864,2591,1488,564,308,1072,1840,7737,null);
		a[96] = new StatsSeason ("08/09","Houston Rockets",464,1298,2527,5437,1296,1730,873,2399,1620,588,435,1012,1689,7742,null);
		a[97] = new StatsSeason ("08/09","Detroit Pistons",435,1228,2441,5152,1580,2039,861,2453,1651,461,342,964,1612,7767,null);
		a[98] = new StatsSeason ("08/09","Charlotte Bobcats/Hornets",558,1526,2325,4823,1457,1928,877,2310,1604,626,488,1206,1714,7781,null);
		a[99] = new StatsSeason ("08/09","Atlanta Hawks",528,1496,2474,5113,1385,1800,955,2481,1705,530,354,1121,1681,7917,null);
		a[100] = new StatsSeason ("08/09","Philadelphia 76ers",585,1595,2412,4894,1402,1792,935,2285,1799,575,400,1278,1786,7981,null);
		a[101] = new StatsSeason ("08/09","Miami Heat",591,1519,2329,4893,1609,2086,896,2536,1646,528,335,1246,1632,8040,null);
		a[102] = new StatsSeason ("08/09","Los Angeles Lakers",586,1700,2464,5125,1454,1931,959,2440,1854,635,392,1275,1816,8140,null);
		a[103] = new StatsSeason ("08/09","Memphis Grizzlies",536,1510,2482,4868,1574,2043,842,2431,1735,632,443,1194,1786,8146,null);
		a[104] = new StatsSeason ("08/09","Dallas Mavericks",517,1379,2554,5373,1522,1907,884,2509,1611,589,334,1064,1645,8181,null);
		a[105] = new StatsSeason ("08/09","Milwaukee Bucks",562,1486,2292,4747,1961,2480,831,2527,1730,616,376,1350,1842,8231,null);
		a[106] = new StatsSeason ("08/09","Brooklyn/New Jersey Nets",600,1536,2353,4849,1738,2281,872,2523,1793,567,393,1103,1680,8244,null);
		a[107] = new StatsSeason ("08/09","Utah Jazz",534,1479,2485,5030,1703,2233,908,2393,1640,658,424,1323,1972,8275,null);
		a[108] = new StatsSeason ("08/09","Denver Nuggets",601,1643,2365,5095,1742,2228,991,2391,1756,648,447,1265,1944,8275,null);
		a[109] = new StatsSeason ("08/09","Toronto Raptors",629,1716,2543,5111,1379,1759,895,2539,1887,521,386,1093,1645,8352,null);
		a[110] = new StatsSeason ("08/09","Chicago Bulls",486,1400,2655,5464,1633,2077,1017,2491,1723,622,449,1177,1708,8401,null);
		a[111] = new StatsSeason ("08/09","Minnesota Timberwolves",536,1420,2573,5141,1668,2145,813,2539,1765,610,484,1028,1642,8422,null);
		a[112] = new StatsSeason ("08/09","Seattle SuperSonics/Oklahoma City Thunder",524,1439,2706,5360,1468,1930,884,2496,1769,697,407,1140,1656,8452,null);
		a[113] = new StatsSeason ("08/09","Washington Wizards",674,1740,2490,4825,1487,1959,934,2491,2015,593,431,1140,1638,8489,null);
		a[114] = new StatsSeason ("08/09","Los Angeles Clippers",536,1431,2682,5374,1546,2035,962,2653,1951,652,414,1093,1609,8518,null);
		a[115] = new StatsSeason ("08/09","Indiana Pacers",569,1519,2572,5343,1857,2431,909,2708,1731,635,444,1151,1692,8708,null);
		a[116] = new StatsSeason ("08/09","Phoenix Suns",626,1635,2652,5390,1634,2108,993,2352,1741,706,369,1165,1877,8816,null);
		a[117] = new StatsSeason ("08/09","New York Knicks",571,1625,2807,5416,1514,1998,954,2826,1774,654,437,1188,1592,8841,null);
		a[118] = new StatsSeason ("08/09","Sacramento Kings",580,1430,2701,5362,1824,2412,1018,2592,1796,704,423,1178,1737,8966,null);
		a[119] = new StatsSeason ("08/09","Golden State Warriors",582,1531,2819,5742,1828,2346,1165,2695,1980,647,414,1229,1927,9212,null);
		a[120] = new StatsSeason ("09/10","Charlotte Bobcats/Hornets",573,1696,2352,4840,1270,1710,868,2382,1666,614,502,1256,1804,7693,null);
		a[121] = new StatsSeason ("09/10","Miami Heat",524,1531,2289,4877,1577,2091,856,2483,1545,517,355,1184,1639,7727,null);
		a[122] = new StatsSeason ("09/10","Portland Trail Blazers",480,1399,2470,4953,1394,1870,801,2322,1583,485,333,1104,1767,7774,null);
		a[123] = new StatsSeason ("09/10","Orlando Magic",522,1437,2433,5302,1380,1830,800,2481,1550,551,288,1050,1819,7812,null);
		a[124] = new StatsSeason ("09/10","Boston Celtics",470,1375,2410,5015,1606,2152,868,2418,1585,578,386,1283,1777,7836,null);
		a[125] = new StatsSeason ("09/10","Cleveland Cavaliers",524,1511,2411,5122,1444,1907,794,2366,1661,542,325,1045,1708,7838,null);
		a[126] = new StatsSeason ("09/10","Milwaukee Bucks",438,1276,2432,5085,1692,2211,790,2722,1581,573,421,1254,1664,7870,null);
		a[127] = new StatsSeason ("09/10","San Antonio Spurs",412,1200,2613,5491,1433,1896,814,2427,1576,567,417,1032,1672,7895,null);
		a[128] = new StatsSeason ("09/10","Los Angeles Lakers",520,1585,2530,5255,1332,1776,914,2546,1792,573,363,1159,1737,7952,null);
		a[129] = new StatsSeason ("09/10","Atlanta Hawks",480,1392,2568,5231,1380,1852,922,2471,1719,506,359,1135,1582,7956,null);
		a[130] = new StatsSeason ("09/10","Seattle SuperSonics/Oklahoma City Thunder",481,1414,2526,5304,1541,2018,937,2397,1618,616,384,1238,1755,8036,null);
		a[131] = new StatsSeason ("09/10","Utah Jazz",552,1559,2356,4912,1741,2286,837,2376,1628,632,445,1238,1818,8109,null);
		a[132] = new StatsSeason ("09/10","Chicago Bulls",584,1680,2459,5205,1457,1958,916,2589,1715,578,438,1090,1643,8127,null);
		a[133] = new StatsSeason ("09/10","Detroit Pistons",568,1514,2397,4658,1630,2124,814,2420,1898,549,401,1174,1702,8128,null);
		a[134] = new StatsSeason ("09/10","Dallas Mavericks",525,1515,2582,5290,1402,1849,922,2592,1659,563,337,1195,1652,8141,null);
		a[135] = new StatsSeason ("09/10","Washington Wizards",528,1466,2555,5198,1590,2088,935,2530,1772,569,415,1115,1684,8284,null);
		a[136] = new StatsSeason ("09/10","Brooklyn/New Jersey Nets",468,1278,2704,5315,1511,2021,925,2683,1960,638,421,1149,1647,8323,null);
		a[137] = new StatsSeason ("09/10","Philadelphia 76ers",606,1542,2499,5031,1518,1983,888,2470,1810,621,332,1189,1534,8334,null);
		a[138] = new StatsSeason ("09/10","Los Angeles Clippers",529,1457,2664,5335,1455,1910,879,2490,1926,686,363,1059,1588,8370,null);
		a[139] = new StatsSeason ("09/10","Denver Nuggets",523,1498,2565,5268,1695,2207,955,2513,1723,578,438,1235,1943,8394,null);
		a[140] = new StatsSeason ("09/10","New Orleans/Oklahoma City Hornets/New Orleans Hornets/Pelicans",539,1517,2711,5213,1383,1841,870,2586,1925,574,367,1177,1597,8422,null);
		a[141] = new StatsSeason ("09/10","Houston Rockets",489,1344,2747,5466,1464,1917,875,2632,1716,597,532,1207,1840,8425,null);
		a[142] = new StatsSeason ("09/10","Indiana Pacers",510,1405,2603,5470,1774,2346,969,2852,1694,654,414,1227,1709,8510,null);
		a[143] = new StatsSeason ("09/10","Memphis Grizzlies",572,1618,2705,5231,1402,1858,907,2349,1875,635,501,1165,1840,8528,null);
		a[144] = new StatsSeason ("09/10","Sacramento Kings",497,1391,2702,5437,1663,2149,909,2538,1683,586,468,1120,1650,8558,null);
		a[145] = new StatsSeason ("09/10","Phoenix Suns",561,1582,2674,5583,1606,2114,1081,2391,1704,646,365,1065,1789,8637,null);
		a[146] = new StatsSeason ("09/10","Toronto Raptors",609,1665,2585,5159,1683,2146,933,2453,1889,580,360,1040,1730,8680,null);
		a[147] = new StatsSeason ("09/10","New York Knicks",553,1571,2799,5331,1429,1896,959,2724,1723,585,368,1182,1576,8686,null);
		a[148] = new StatsSeason ("09/10","Minnesota Timberwolves",618,1690,2725,5271,1534,1981,917,2640,2103,721,442,1173,1686,8838,null);
		a[149] = new StatsSeason ("09/10","Golden State Warriors",567,1514,2842,5519,1832,2390,1100,2842,1979,645,407,1442,1757,9217,null);
		a[150] = new StatsSeason ("10/11","Boston Celtics",443,1304,2325,5067,1494,1975,862,2387,1533,574,364,1262,1659,7473,null);
		a[151] = new StatsSeason ("10/11","Chicago Bulls",427,1308,2378,5215,1450,1898,828,2322,1556,568,477,1159,1645,7487,null);
		a[152] = new StatsSeason ("10/11","Milwaukee Bucks",437,1309,2397,5033,1498,1946,836,2629,1657,507,392,1245,1694,7603,null);
		a[153] = new StatsSeason ("10/11","Orlando Magic",516,1476,2349,5093,1441,1940,805,2450,1646,606,310,1136,1791,7687,null);
		a[154] = new StatsSeason ("10/11","New Orleans/Oklahoma City Hornets/New Orleans Hornets/Pelicans",557,1562,2325,4744,1390,1805,769,2457,1739,497,396,1192,1674,7711,null);
		a[155] = new StatsSeason ("10/11","Miami Heat",546,1584,2323,5030,1473,1980,864,2349,1651,574,246,1081,1788,7757,null);
		a[156] = new StatsSeason ("10/11","Portland Trail Blazers",529,1440,2375,4778,1434,1869,868,2385,1573,566,339,1286,1743,7771,null);
		a[157] = new StatsSeason ("10/11","Los Angeles Lakers",558,1668,2450,5220,1246,1628,1002,2399,1827,585,372,1116,1700,7820,null);
		a[158] = new StatsSeason ("10/11","Atlanta Hawks",459,1358,2550,5179,1380,1782,839,2488,1751,548,348,1026,1517,7857,null);
		a[159] = new StatsSeason ("10/11","Dallas Mavericks",508,1480,2488,5176,1373,1830,880,2459,1689,623,303,1114,1650,7873,null);
		a[160] = new StatsSeason ("10/11","Charlotte Bobcats/Hornets",577,1609,2379,4883,1489,1908,804,2446,1777,601,496,1082,1730,7978,null);
		a[161] = new StatsSeason ("10/11","Philadelphia 76ers",468,1375,2528,5263,1536,1987,881,2608,1762,583,376,1168,1544,7996,null);
		a[162] = new StatsSeason ("10/11","Memphis Grizzlies",587,1592,2380,4897,1482,1948,905,2387,1724,613,505,1367,1754,8003,null);
		a[163] = new StatsSeason ("10/11","San Antonio Spurs",479,1305,2648,5555,1301,1698,884,2494,1685,567,374,1095,1701,8034,null);
		a[164] = new StatsSeason ("10/11","Brooklyn/New Jersey Nets",507,1393,2562,5209,1589,2115,849,2575,1824,561,375,1010,1638,8234,null);
		a[165] = new StatsSeason ("10/11","Detroit Pistons",523,1461,2587,4944,1503,1962,866,2470,1910,568,381,1160,1545,8246,null);
		a[166] = new StatsSeason ("10/11","Indiana Pacers",511,1423,2560,5414,1618,2157,931,2618,1670,615,467,1143,1758,8271,null);
		a[167] = new StatsSeason ("10/11","Seattle SuperSonics/Oklahoma City Thunder",482,1335,2641,5488,1557,2093,932,2395,1712,587,356,1152,1767,8285,null);
		a[168] = new StatsSeason ("10/11","Utah Jazz",592,1573,2375,4887,1777,2285,925,2426,1700,609,411,1199,1802,8303,null);
		a[169] = new StatsSeason ("10/11","Los Angeles Clippers",584,1598,2462,5090,1670,2167,914,2410,1827,659,404,1125,1811,8346,null);
		a[170] = new StatsSeason ("10/11","Denver Nuggets",576,1675,2577,5201,1539,2036,864,2525,1820,611,488,1127,1864,8421,null);
		a[171] = new StatsSeason ("10/11","Houston Rockets",448,1250,2818,5729,1526,1954,955,2552,1707,588,449,1125,1754,8506,null);
		a[172] = new StatsSeason ("10/11","Cleveland Cavaliers",664,1614,2568,5190,1438,1894,894,2676,1984,619,489,1111,1747,8566,null);
		a[173] = new StatsSeason ("10/11","Washington Wizards",560,1500,2614,5241,1676,2202,994,2607,1898,624,413,1293,1662,8584,null);
		a[174] = new StatsSeason ("10/11","Sacramento Kings",480,1353,2780,5473,1589,2085,868,2508,1779,666,464,1204,1723,8589,null);
		a[175] = new StatsSeason ("10/11","Toronto Raptors",541,1438,2672,5230,1672,2175,912,2457,1854,625,456,1141,1620,8639,null);
		a[176] = new StatsSeason ("10/11","Golden State Warriors",567,1586,2606,5202,1755,2262,1051,2623,2029,672,352,1324,1512,8668,null);
		a[177] = new StatsSeason ("10/11","New York Knicks",536,1442,2706,5428,1650,2165,964,2646,1682,586,360,1250,1703,8670,null);
		a[178] = new StatsSeason ("10/11","Phoenix Suns",585,1595,2724,5423,1481,1964,985,2647,1890,644,356,1189,1740,8684,null);
		a[179] = new StatsSeason ("10/11","Minnesota Timberwolves",639,1707,2591,5195,1733,2227,913,2577,2031,777,447,1183,1717,8832,null);
		a[180] = new StatsSeason ("12/13","Memphis Grizzlies",504,1489,2244,4823,1319,1763,845,2359,1599,600,450,1268,1643,7319,null);
		a[181] = new StatsSeason ("12/13","Indiana Pacers",440,1344,2357,5313,1314,1728,909,2401,1555,611,459,1096,1777,7348,null);
		a[182] = new StatsSeason ("12/13","Chicago Bulls",453,1309,2453,5256,1350,1826,901,2469,1545,600,477,1123,1609,7615,null);
		a[183] = new StatsSeason ("12/13","Los Angeles Clippers",627,1682,2207,4715,1465,1956,891,2315,1812,606,335,1319,1712,7760,null);
		a[184] = new StatsSeason ("12/13","Miami Heat",624,1783,2295,4850,1329,1735,921,2369,1655,649,262,1280,1673,7791,null);
		a[185] = new StatsSeason ("12/13","Brooklyn/New Jersey Nets",518,1415,2548,5199,1148,1571,878,2336,1756,614,390,1102,1751,7798,null);
		a[186] = new StatsSeason ("12/13","Boston Celtics",550,1610,2376,5029,1434,1937,925,2603,1752,634,378,1239,1574,7836,null);
		a[187] = new StatsSeason ("12/13","New York Knicks",639,1789,2277,4576,1378,1821,824,2591,1580,523,327,1242,1576,7849,null);
		a[188] = new StatsSeason ("12/13","Washington Wizards",586,1680,2358,5017,1378,1867,903,2719,1767,639,358,1193,1569,7852,null);
		a[189] = new StatsSeason ("12/13","Philadelphia 76ers",549,1574,2468,5069,1331,1752,903,2704,1870,590,396,1175,1331,7914,null);
		a[190] = new StatsSeason ("12/13","Seattle SuperSonics/Oklahoma City Thunder",610,1761,2356,5211,1372,1773,987,2350,1681,673,322,1212,1698,7914,null);
		a[191] = new StatsSeason ("12/13","San Antonio Spurs",519,1471,2560,5489,1246,1639,912,2577,1756,675,405,1221,1565,7923,null);
		a[192] = new StatsSeason ("12/13","Atlanta Hawks",620,1635,2453,5188,1233,1617,928,2659,1825,689,350,1249,1543,7999,null);
		a[193] = new StatsSeason ("12/13","New Orleans/Oklahoma City Hornets/New Orleans Hornets/Pelicans",632,1688,2398,4747,1339,1764,835,2391,1915,648,492,1086,1534,8031,null);
		a[194] = new StatsSeason ("12/13","Utah Jazz",560,1513,2443,5037,1479,1953,901,2446,1689,640,480,1206,1670,8045,null);
		a[195] = new StatsSeason ("12/13","Minnesota Timberwolves",576,1559,2537,5098,1243,1652,871,2583,1832,661,481,1302,1847,8045,null);
		a[196] = new StatsSeason ("12/13","Toronto Raptors",546,1511,2425,4982,1604,2148,877,2544,1796,578,387,1169,1650,8092,null);
		a[197] = new StatsSeason ("12/13","Detroit Pistons",604,1676,2452,4979,1389,1823,911,2514,1837,691,472,1126,1630,8105,null);
		a[198] = new StatsSeason ("12/13","Golden State Warriors",657,1896,2394,5058,1464,1958,907,2596,1931,670,399,1110,1571,8223,null);
		a[199] = new StatsSeason ("12/13","Milwaukee Bucks",529,1519,2623,5427,1398,1841,1019,2757,1893,658,362,1310,1567,8231,null);
		a[200] = new StatsSeason ("12/13","Portland Trail Blazers",521,1531,2703,5276,1286,1690,901,2578,1944,691,359,1074,1537,8255,null);
		a[201] = new StatsSeason ("12/13","Los Angeles Lakers",613,1718,2640,5462,1167,1594,947,2551,1918,696,396,1061,1891,8286,null);
		a[202] = new StatsSeason ("12/13","Denver Nuggets",687,1894,2434,5131,1358,1858,1020,2391,1936,658,554,1305,1775,8287,null);
		a[203] = new StatsSeason ("12/13","Orlando Magic",617,1721,2552,5121,1336,1811,888,2618,1946,592,430,1020,1353,8291,null);
		a[204] = new StatsSeason ("12/13","Cleveland Cavaliers",610,1639,2499,4888,1469,1987,889,2563,1963,624,560,1249,1615,8297,null);
		a[205] = new StatsSeason ("12/13","Phoenix Suns",568,1464,2613,5307,1405,1855,958,2598,1870,684,421,1258,1511,8335,null);
		a[206] = new StatsSeason ("12/13","Dallas Mavericks",642,1789,2425,5101,1566,2079,985,2752,1805,698,340,1202,1547,8342,null);
		a[207] = new StatsSeason ("12/13","Houston Rockets",661,1798,2523,5209,1374,1771,876,2539,1858,693,498,1210,1674,8403,null);
		a[208] = new StatsSeason ("12/13","Charlotte Bobcats/Hornets",716,1847,2469,4915,1332,1784,971,2645,2071,569,565,1152,1746,8418,null);
		a[209] = new StatsSeason ("12/13","Sacramento Kings",625,1762,2597,5069,1550,1980,973,2601,2058,624,517,1208,1636,8619,null);
		a[210] = new StatsSeason ("13/14","Chicago Bulls",538,1532,2329,5128,1256,1668,876,2508,1604,621,490,1178,1714,7528,null);
		a[211] = new StatsSeason ("13/14","Indiana Pacers",538,1561,2312,5224,1334,1768,855,2521,1525,593,378,1120,1793,7572,null);
		a[212] = new StatsSeason ("13/14","Memphis Grizzlies",615,1731,2309,4769,1292,1686,809,2403,1632,591,410,1162,1553,7755,null);
		a[213] = new StatsSeason ("13/14","Charlotte Bobcats/Hornets",665,1800,2357,5038,1251,1649,785,2766,1718,514,415,1090,1716,7960,null);
		a[214] = new StatsSeason ("13/14","Miami Heat",694,1917,2267,4558,1374,1832,886,2420,1751,667,256,1369,1675,7990,null);
		a[215] = new StatsSeason ("13/14","San Antonio Spurs",529,1500,2567,5476,1285,1691,862,2600,1669,628,379,1137,1585,8006,null);
		a[216] = new StatsSeason ("13/14","Toronto Raptors",568,1578,2389,4995,1557,2071,854,2505,1719,596,352,1224,1815,8039,null);
		a[217] = new StatsSeason ("13/14","New York Knicks",713,1921,2221,4480,1568,2050,843,2600,1618,513,277,1193,1611,8149,null);
		a[218] = new StatsSeason ("13/14","Washington Wizards",612,1763,2426,4869,1462,1912,827,2633,1824,631,320,1314,1600,8150,null);
		a[219] = new StatsSeason ("13/14","Golden State Warriors",569,1656,2450,5264,1548,2023,878,2671,1683,649,342,1232,1584,8155,null);
		a[220] = new StatsSeason ("13/14","Brooklyn/New Jersey Nets",662,1802,2318,4709,1539,2026,921,2594,1723,608,337,1296,1704,8161,null);
		a[221] = new StatsSeason ("13/14","Seattle SuperSonics/Oklahoma City Thunder",705,1968,2279,4874,1512,2080,900,2456,1785,669,296,1248,1672,8185,null);
		a[222] = new StatsSeason ("13/14","Boston Celtics",539,1553,2562,5122,1517,1993,871,2596,1813,609,373,1168,1564,8258,null);
		a[223] = new StatsSeason ("13/14","Los Angeles Clippers",595,1791,2473,5167,1547,2049,1011,2575,1908,570,284,1261,1919,8278,null);
		a[224] = new StatsSeason ("13/14","Atlanta Hawks",654,1793,2509,5050,1341,1793,882,2688,1901,672,354,1247,1643,8321,null);
		a[225] = new StatsSeason ("13/14","Cleveland Cavaliers",765,2083,2332,4764,1365,1803,841,2648,2037,587,461,1144,1599,8324,null);
		a[226] = new StatsSeason ("13/14","Orlando Magic",659,1778,2467,5083,1449,1881,859,2746,1848,581,445,1146,1500,8360,null);
		a[227] = new StatsSeason ("13/14","Utah Jazz",599,1591,2539,5048,1504,1945,846,2640,1788,617,401,1034,1673,8379,null);
		a[228] = new StatsSeason ("13/14","New Orleans/Oklahoma City Hornets/New Orleans Hornets/Pelicans",652,1827,2403,4740,1637,2176,881,2538,1845,577,504,1185,1664,8399,null);
		a[229] = new StatsSeason ("13/14","Dallas Mavericks",678,1888,2418,4785,1530,2019,943,2569,1808,635,288,1312,1633,8400,null);
		a[230] = new StatsSeason ("13/14","Phoenix Suns",556,1632,2562,5208,1621,2115,926,2586,1664,613,332,1258,1749,8413,null);
		a[231] = new StatsSeason ("13/14","Portland Trail Blazers",534,1504,2714,5699,1396,1822,944,2622,1675,639,304,985,1698,8426,null);
		a[232] = new StatsSeason ("13/14","Houston Rockets",666,1889,2531,5329,1395,1844,977,2439,1821,704,460,1149,1993,8455,null);
		a[233] = new StatsSeason ("13/14","Sacramento Kings",696,1833,2407,4901,1577,2139,813,2568,1927,637,459,1116,1897,8479,null);
		a[234] = new StatsSeason ("13/14","Milwaukee Bucks",697,1826,2449,4896,1511,2011,961,2608,1870,640,413,1158,1690,8500,null);
		a[235] = new StatsSeason ("13/14","Minnesota Timberwolves",663,1820,2658,5228,1244,1645,908,2717,1875,644,457,1346,1936,8549,null);
		a[236] = new StatsSeason ("13/14","Detroit Pistons",683,1872,2525,4948,1487,1967,913,2612,2001,670,403,1230,1699,8586,null);
		a[237] = new StatsSeason ("13/14","Denver Nuggets",605,1724,2633,5362,1654,2168,930,2665,1843,694,459,1178,1778,8735,null);
		a[238] = new StatsSeason ("13/14","Los Angeles Lakers",666,1843,2774,5507,1412,1942,1068,2950,2112,790,387,1164,1580,8958,null);
		a[239] = new StatsSeason ("13/14","Philadelphia 76ers",739,1998,2545,4977,1705,2261,976,2871,2144,736,558,1391,1686,9012,null);
		a[240] = new StatsSeason ("14/15","Utah Jazz",604,1670,2331,4917,1309,1760,811,2406,1594,674,382,1076,1604,7783,null);
		a[241] = new StatsSeason ("14/15","Memphis Grizzlies",663,1889,2291,4795,1225,1651,864,2616,1652,604,424,1257,1662,7796,null);
		a[242] = new StatsSeason ("14/15","San Antonio Spurs",558,1550,2486,5311,1307,1754,813,2643,1699,648,362,1167,1613,7953,null);
		a[243] = new StatsSeason ("14/15","Indiana Pacers",591,1713,2358,5071,1469,1951,800,2704,1633,617,386,1045,1754,7958,null);
		a[244] = new StatsSeason ("14/15","Atlanta Hawks",720,2112,2271,4703,1262,1651,948,2631,1931,604,404,1317,1611,7964,null);
		a[245] = new StatsSeason ("14/15","Miami Heat",666,1887,2294,4636,1391,1905,894,2467,1748,646,359,1215,1715,7977,null);
		a[246] = new StatsSeason ("14/15","Charlotte Bobcats/Hornets",649,1816,2371,5047,1292,1673,728,2890,1815,502,440,1033,1708,7981,null);
		a[247] = new StatsSeason ("14/15","Milwaukee Bucks",676,1974,2241,4707,1478,1993,938,2576,1831,708,392,1425,1649,7988,null);
		a[248] = new StatsSeason ("14/15","Chicago Bulls",538,1605,2557,5504,1291,1723,963,2598,1657,614,443,1000,1736,8019,null);
		a[249] = new StatsSeason ("14/15","Washington Wizards",657,1885,2308,4959,1434,1942,821,2599,1634,655,350,1145,1610,8021,null);
		a[250] = new StatsSeason ("14/15","Portland Trail Blazers",524,1552,2606,5571,1298,1713,902,2754,1669,655,297,999,1534,8082,null);
		a[251] = new StatsSeason ("14/15","New Orleans/Oklahoma City Hornets/New Orleans Hornets/Pelicans",537,1605,2571,5209,1329,1751,870,2537,1700,555,475,1003,1533,8082,null);
		a[252] = new StatsSeason ("14/15","Cleveland Cavaliers",634,1848,2487,5002,1214,1629,885,2487,1974,642,368,1092,1685,8090,null);
		a[253] = new StatsSeason ("14/15","Detroit Pistons",635,1789,2471,5028,1312,1699,877,2740,1949,572,391,1146,1584,8159,null);
		a[254] = new StatsSeason ("14/15","Golden State Warriors",592,1757,2439,5327,1534,2011,963,2690,1718,680,293,1329,1541,8188,null);
		a[255] = new StatsSeason ("14/15","Los Angeles Clippers",683,1959,2301,4786,1560,2105,868,2649,1904,548,245,1171,1766,8211,null);
		a[256] = new StatsSeason ("14/15","Houston Rockets",605,1881,2487,5102,1451,1932,973,2621,1752,726,437,1342,1730,8240,null);
		a[257] = new StatsSeason ("14/15","Brooklyn/New Jersey Nets",696,1944,2454,4969,1278,1748,937,2699,1944,643,372,1137,1641,8274,null);
		a[258] = new StatsSeason ("14/15","Toronto Raptors",633,1828,2483,4959,1410,1923,922,2559,1870,567,413,1182,1668,8275,null);
		a[259] = new StatsSeason ("14/15","Philadelphia 76ers",658,1879,2387,4906,1530,2023,940,2853,1942,779,454,1374,1657,8278,null);
		a[260] = new StatsSeason ("14/15","New York Knicks",694,1825,2337,4767,1543,2032,898,2669,1783,659,353,1153,1564,8299,null);
		a[261] = new StatsSeason ("14/15","Boston Celtics",607,1804,2518,5139,1442,1909,893,2772,1798,583,431,1239,1545,8299,null);
		a[262] = new StatsSeason ("14/15","Orlando Magic",682,1853,2430,4867,1410,1878,825,2739,1921,635,441,1185,1467,8316,null);
		a[263] = new StatsSeason ("14/15","Seattle SuperSonics/Oklahoma City Thunder",681,1984,2404,5024,1494,2005,917,2587,1815,642,377,1118,1675,8345,null);
		a[264] = new StatsSeason ("14/15","Dallas Mavericks",741,2034,2376,4896,1415,1879,1006,2778,1830,602,314,1339,1816,8390,null);
		a[265] = new StatsSeason ("14/15","Phoenix Suns",633,1798,2516,5174,1540,2030,951,2766,1734,651,337,1276,1664,8471,null);
		a[266] = new StatsSeason ("14/15","Denver Nuggets",631,1823,2533,5086,1652,2208,899,2798,1894,611,504,1177,1698,8611,null);
		a[267] = new StatsSeason ("14/15","Sacramento Kings",718,2055,2520,5039,1420,1898,898,2479,1912,712,508,1059,1958,8614,null);
		a[268] = new StatsSeason ("14/15","Los Angeles Lakers",697,1921,2483,4896,1577,2118,824,2797,1966,611,396,1068,1589,8634,null);
		a[269] = new StatsSeason ("14/15","Minnesota Timberwolves",697,1897,2676,5036,1294,1704,953,2619,1933,686,449,1243,1751,8737,null);
		a[270] = new StatsSeason ("15/16","San Antonio Spurs",541,1634,2387,5075,1221,1611,747,2576,1707,592,317,1214,1597,7618,null);
		a[271] = new StatsSeason ("15/16","Utah Jazz",649,1819,2271,4730,1374,1842,764,2522,1568,652,385,1146,1629,7863,null);
		a[272] = new StatsSeason ("15/16","Toronto Raptors",717,1922,2274,4810,1354,1809,782,2561,1781,534,442,1094,1801,8053,null);
		a[273] = new StatsSeason ("15/16","Cleveland Cavaliers",647,1862,2372,4874,1378,1855,760,2604,1756,590,362,1092,1690,8063,null);
		a[274] = new StatsSeason ("15/16","Miami Heat",605,1742,2449,5172,1356,1761,803,2580,1657,612,337,1060,1608,8069,null);
		a[275] = new StatsSeason ("15/16","Atlanta Hawks",679,2008,2367,5050,1366,1810,944,2869,1808,706,411,1324,1500,8137,null);
		a[276] = new StatsSeason ("15/16","Los Angeles Clippers",645,1909,2370,5037,1543,2055,968,2861,1740,583,259,1260,1842,8218,null);
		a[277] = new StatsSeason ("15/16","Indiana Pacers",679,2035,2386,4927,1428,1901,877,2774,1707,634,366,1297,1676,8237,null);
		a[278] = new StatsSeason ("15/16","Charlotte Bobcats/Hornets",726,2081,2372,4890,1334,1735,726,2936,1901,553,448,1103,1670,8256,null);
		a[279] = new StatsSeason ("15/16","New York Knicks",626,1838,2488,5197,1435,1904,890,2733,1703,589,343,927,1520,8289,null);
		a[280] = new StatsSeason ("15/16","Memphis Grizzlies",797,2185,2150,4274,1619,2107,830,2711,1792,576,469,1328,1732,8310,null);
		a[281] = new StatsSeason ("15/16","Detroit Pistons",596,1679,2586,5224,1351,1726,725,2763,1766,583,366,1099,1773,8311,null);
		a[282] = new StatsSeason ("15/16","Boston Celtics",643,1912,2432,5061,1613,2136,932,2838,1715,622,450,1348,1718,8406,null);
		a[283] = new StatsSeason ("15/16","Dallas Mavericks",743,2170,2401,4801,1382,1873,868,2887,1800,617,363,1142,1757,8413,null);
		a[284] = new StatsSeason ("15/16","Seattle SuperSonics/Oklahoma City Thunder",667,1949,2483,5243,1474,1950,923,2373,1767,719,373,1068,1653,8441,null);
		a[285] = new StatsSeason ("15/16","Chicago Bulls",651,1885,2583,5448,1337,1813,969,2798,1848,655,465,974,1535,8456,null);
		a[286] = new StatsSeason ("15/16","Milwaukee Bucks",765,2171,2332,4646,1506,1961,942,2583,2013,679,462,1269,1600,8465,null);
		a[287] = new StatsSeason ("15/16","Orlando Magic",732,2041,2418,4809,1470,1971,832,2800,1899,620,448,1240,1497,8502,null);
		a[288] = new StatsSeason ("15/16","Golden State Warriors",640,1928,2548,5402,1523,2013,937,2662,1823,710,336,1185,1627,8539,null);
		a[289] = new StatsSeason ("15/16","Portland Trail Blazers",700,1888,2446,5057,1562,2129,867,2716,1770,630,424,1088,1597,8554,null);
		a[290] = new StatsSeason ("15/16","Washington Wizards",737,1987,2433,4881,1498,1947,773,2858,1846,661,356,1325,1651,8575,null);
		a[291] = new StatsSeason ("15/16","Denver Nuggets",754,2033,2428,4871,1491,1958,799,2700,1924,660,517,1122,1712,8609,null);
		a[292] = new StatsSeason ("15/16","Minnesota Timberwolves",742,2089,2534,4873,1394,1842,877,2558,1857,638,427,1220,1768,8688,null);
		a[293] = new StatsSeason ("15/16","Brooklyn/New Jersey Nets",775,2100,2570,4884,1227,1608,840,2719,2006,720,430,1162,1510,8692,null);
		a[294] = new StatsSeason ("15/16","Houston Rockets",796,2206,2404,4771,1525,2018,970,2690,2015,734,404,1360,1847,8721,null);
		a[295] = new StatsSeason ("15/16","New Orleans/Oklahoma City Hornets/New Orleans Hornets/Pelicans",754,2043,2464,4834,1544,1972,730,2912,1899,602,423,1127,1630,8734,null);
		a[296] = new StatsSeason ("15/16","Los Angeles Lakers",700,2016,2623,5007,1420,1942,897,2915,2022,617,458,1037,1573,8766,null);
		a[297] = new StatsSeason ("15/16","Phoenix Suns",770,2041,2438,4829,1631,2177,813,2770,1837,782,449,1224,1770,8817,null);
		a[298] = new StatsSeason ("15/16","Philadelphia 76ers",638,1776,2615,5229,1683,2141,913,2987,1919,711,466,1241,1571,8827,null);
		a[299] = new StatsSeason ("15/16","Sacramento Kings",839,2293,2488,4901,1450,1902,926,2765,1986,722,437,1308,1800,8943,null);

		int aux = 0;
		while (aux < 300){
			hash.put(a[aux].getTeam().toString(), a[aux]);

			aux++;
		}

		return hash;

	}


	public static Map<String, StatsSeason> testeOfensivo () throws IOException{

		Map<String, StatsSeason> hash = new HashMap<String, StatsSeason> ();

		StatsSeason a [] = new StatsSeason[30];

		a[0] = new StatsSeason ("AT","Atlanta Hawks",893,2502,2285,4653,1280,1658,876,2722,1919,738,424,1262,1768,8529,null);
		a[1] = new StatsSeason ("BC","Boston Celtics",735,2213,2433,4822,1570,2042,883,2769,1851,623,425,1141,1664,8641,null);
		a[2] = new StatsSeason ("BN","Brooklyn Nets",816,2232,2598,5217,1581,2049,902,2965,1888,780,457,1092,1671,9225,null);
		a[3] = new StatsSeason ("CH","Charlotte Hornets",950,2576,2287,4516,1161,1496,732,2909,2012,539,450,1071,1631,8585,null);
		a[4] = new StatsSeason ("CB","Chicago Bulls",731,2121,2505,4978,1197,1555,843,2698,1939,602,378,1100,1541,8400,null);
		a[5] = new StatsSeason ("CC","Cleveland Cavaliers",850,2353,2483,4931,1271,1644,902,2724,2024,598,349,1033,1690,8787,null);
		a[6] = new StatsSeason ("DM","Dallas Mavericks",788,2074,2247,4403,1411,1827,727,2923,1743,535,280,1225,1591,8269,null);
		a[7] = new StatsSeason ("DN","Denver Nuggets",808,2153,2646,5095,1403,1794,770,2576,1972,681,404,982,1653,9119,null);
		a[8] = new StatsSeason ("DP","Detroit Pistons",767,2098,2377,4732,1346,1726,656,2861,1929,551,339,1046,1434,8401,null);
		a[9] = new StatsSeason ("GS","Golden State Warriors",737,2277,2444,5034,1450,1905,963,2604,1862,705,313,1272,1588,8549,null);
		a[10] = new StatsSeason ("HR","Houston Rockets",820,2389,2555,4897,1415,1819,878,2735,1979,697,409,1235,1674,8985,null);
		a[11] = new StatsSeason ("IP","Indiana Pacers",849,2389,2266,4520,1557,1974,879,2751,1832,661,407,1225,1599,8636,null);
		a[12] = new StatsSeason ("LC","Los Angeles Clippers",753,2154,2410,4845,1480,1917,837,2700,1891,577,258,1084,1835,8559,null);
		a[13] = new StatsSeason ("LL","Los Angeles Lakers",830,2245,2575,4808,1499,1966,843,2801,2110,698,440,1188,1520,9139,null);
		a[14] = new StatsSeason ("MG","Memphis Grizzlies",813,2299,2051,4166,1658,2202,761,2692,1645,574,410,1171,1708,8199,null);
		a[15] = new StatsSeason ("MH","Miami Heat",639,1864,2469,5040,1518,1940,837,2737,1611,556,398,1121,1530,8373,null);
		a[16] = new StatsSeason ("MB","Milwaukee Bucks",816,2312,2300,4490,1464,1900,845,2636,1974,609,375,1205,1579,8512,null);
		a[17] = new StatsSeason ("MT","Minnesota Timberwolves",811,2213,2435,4616,1445,1881,806,2508,1896,629,413,1169,1681,8748,null);
		a[18] = new StatsSeason ("NP","New Orleans Pelicans",863,2445,2423,4854,1293,1697,872,3091,1921,603,348,1144,1581,8728,null);
		a[19] = new StatsSeason ("NK","New York Knicks",806,2313,2453,4850,1533,1988,953,2715,1786,615,377,1060,1516,8857,null);
		a[20] = new StatsSeason ("OT","Oklahoma City Thunder",724,2036,2491,4962,1525,1996,750,2583,1758,698,450,1129,1697,8679,null);
		a[21] = new StatsSeason ("OM","Orlando Magic",794,2161,2510,4920,1425,1860,799,2934,1936,622,419,1069,1532,8827,null);
		a[22] = new StatsSeason ("P7","Philadelphia 76ers",729,2044,2515,4999,1650,2135,886,2802,1859,704,446,1241,1610,8867,null);
		a[23] = new StatsSeason ("HS","Phoenix Suns",825,2159,2475,4911,1868,2387,840,2772,1818,663,435,1222,1822,9293,null);
		a[24] = new StatsSeason ("PB","Portland Trail Blazers",762,2058,2451,5011,1706,2173,830,2778,1688,633,431,1052,1624,8894,null);
		a[25] = new StatsSeason ("SK","Sacramento Kings",896,2462,2257,4362,1546,1988,826,2689,1941,694,420,1145,1646,8748,null);
		a[26] = new StatsSeason ("SS","San Antonio Spurs",668,1942,2364,4897,1315,1705,800,2600,1757,614,333,1184,1623,8047,null);
		a[27] = new StatsSeason ("TR","Toronto Raptors",794,2240,2258,4561,1519,1948,831,2619,1786,547,392,1200,1666,8417,null);
		a[28] = new StatsSeason ("UJ","Utah Jazz",671,1874,2307,4849,1308,1701,742,2554,1463,598,312,995,1655,7935,null);
		a[29] = new StatsSeason ("WW","Washington Wizards",810,2224,2443,4754,1489,1982,868,2661,1870,606,377,1257,1621,8805,null);

		int aux = 0;
		while (aux < 30){
			hash.put(a[aux].getTeam().toString(), a[aux]);

			aux++;
		}

		return hash;

	}

	public static Map<String, StatsSeason> testeDefensivo () throws IOException{

		Map<String, StatsSeason> hash = new HashMap<String, StatsSeason> ();

		StatsSeason a [] = new StatsSeason[30];
		
		a[0] = new StatsSeason ("AT","Atlanta Hawks",729,2137,2394,4781,1484,2039,842,2793,1938,672,397,1294,1491,8459,null);
		a[1] = new StatsSeason ("BC","Boston Celtics",985,2742,2183,4236,1536,1903,744,2698,2069,617,340,1088,1686,8857,null);
		a[2] = new StatsSeason ("BN","Brooklyn Nets",877,2591,2225,4396,1592,2020,721,2879,1756,593,387,1356,1726,8673,null);
		a[3] = new StatsSeason ("CH","Charlotte Hornets",824,2347,2269,4653,1591,1953,721,2853,1891,571,390,942,1360,8601,null);
		a[4] = new StatsSeason ("CB","Chicago Bulls",623,1831,2546,5310,1474,1848,999,2797,1851,643,393,1112,1455,8435,null);
		a[5] = new StatsSeason ("CC","Cleveland Cavaliers",1067,2779,2208,4184,1431,1913,766,2821,1858,539,327,1121,1486,9048,null);
		a[6] = new StatsSeason ("DM","Dallas Mavericks",878,2473,2090,4277,1215,1516,647,2516,1705,614,307,972,1567,8029,null);
		a[7] = new StatsSeason ("DN","Denver Nuggets",870,2365,2507,4829,1537,1986,966,2837,2077,568,323,1226,1567,9161,null);
		a[8] = new StatsSeason ("DP","Detroit Pistons",631,1915,2638,5367,1140,1586,908,2838,1732,574,310,973,1467,8309,null);
		a[9] = new StatsSeason ("GS","Golden State Warriors",982,2562,2550,4578,1457,1850,770,2873,2491,785,555,1211,1585,9503,null);
		a[10] = new StatsSeason ("HR","Houston Rockets",1181,3306,2124,3846,1667,2177,892,2746,2070,670,352,1240,1634,9458,null);
		a[11] = new StatsSeason ("IP","Indiana Pacers",709,1885,2512,5046,1467,1811,742,2702,1844,669,409,1130,1597,8618,null);
		a[12] = new StatsSeason ("LC","Los Angeles Clippers",841,2245,2401,4575,1586,2128,738,2790,1848,612,347,1062,1626,8911,null);
		a[13] = new StatsSeason ("LL","Los Angeles Lakers",730,2110,2494,5054,1397,1853,933,2636,1716,674,320,1243,1698,8575,null);
		a[14] = new StatsSeason ("MG","Memphis Grizzlies",767,2169,2217,4685,1504,1918,886,2621,1744,653,344,1059,1840,8239,null);
		a[15] = new StatsSeason ("MH","Miami Heat",808,2213,2394,4824,1248,1768,872,2705,1742,588,469,1102,1680,8460,null);
		a[16] = new StatsSeason ("MB","Milwaukee Bucks",720,1946,2462,4769,1413,1839,723,2589,1984,666,436,1145,1660,8497,null);
		a[17] = new StatsSeason ("MT","Minnesota Timberwolves",601,1723,2634,5199,1586,1986,938,2540,1940,654,370,1150,1646,8657,null);
		a[18] = new StatsSeason ("NP","New Orleans Pelicans",768,2196,2442,4934,1368,1825,703,2879,1869,638,453,1054,1490,8556,null);
		a[19] = new StatsSeason ("NK","New York Knicks",704,2022,2540,5234,1364,1731,983,2723,1786,581,455,1139,1668,8556,null);
		a[20] = new StatsSeason ("OT","Oklahoma City Thunder",692,2116,2545,5053,1575,2113,1002,2821,1721,648,408,1230,1715,8741,null);
		a[21] = new StatsSeason ("OM","Orlando Magic",701,2139,2438,4994,1309,1753,807,2734,1820,580,396,1091,1584,8288,null);
		a[22] = new StatsSeason ("P7","Philadelphia 76ers",831,2443,2257,4549,1393,1806,807,2706,1949,692,420,1366,1793,8400,null);
		a[23] = new StatsSeason ("HS","Phoenix Suns",615,1854,2655,5406,1676,2159,976,2712,1604,673,399,1265,2030,8831,null);
		a[24] = new StatsSeason ("PB","Portland Trail Blazers",852,2272,2391,4787,1513,1940,830,2750,1733,574,408,1126,1736,8851,null);
		a[25] = new StatsSeason ("SK","Sacramento Kings",737,1960,2368,4774,1483,1913,715,2652,1844,627,324,1201,1667,8430,null);
		a[26] = new StatsSeason ("SS","San Antonio Spurs",753,1927,2469,4937,1440,1806,821,2777,1954,655,484,1101,1498,8637,null);
		a[27] = new StatsSeason ("TR","Toronto Raptors",725,1996,2486,4922,1615,2028,871,2676,1517,677,400,1041,1708,8762,null);
		a[28] = new StatsSeason ("UJ","Utah Jazz",791,2128,2242,4387,1401,1875,771,2774,1651,550,410,1118,1545,8258,null);
		a[29] = new StatsSeason ("WW","Washington Wizards",756,2030,2632,5107,1421,1812,843,2671,1956,693,336,1162,1745,8953,null);
		
		int aux = 0;
		while (aux < 30){
			hash.put(a[aux].getTeam().toString(), a[aux]);

			aux++;
		}

		return hash;

	}
	}