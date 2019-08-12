CREATE TABLE IF NOT EXISTS EMP 
   (EMPID INT(6) not NULL, 
	FNAME VARCHAR(20),
	LNAME VARCHAR(25)DEFAULT NULL, 
	EMAIL VARCHAR(25)DEFAULT NULL, 
	PHONE VARCHAR(20)DEFAULT NULL, 
	HDATE DATE, 
	JOBID VARCHAR(10), 
	SALARY INT(8), 
	COMM DOUBLE, 
	MGRID INT(6), 
	DEPTID INT(4)
   );

Insert into emp  values (100,'Steven','King','SKING','515.123.4567','03/06/17','AD_PRES',24000,null,null,90); 
Insert into emp  values (101,'Neena','Kochhar','NKOCHHAR','515.123.4568','05/09/21','AD_VP',17000,null,100,90);
Insert into emp  values (102,'Lex','De Haan','LDEHAAN','515.123.4569','01/01/13','AD_VP',17000,null,100,90);
Insert into emp  values (103,'Alexander','Hunold','AHUNOLD','590.423.4567','06/01/03','IT_PROG',9000,null,102,60);
Insert into emp  values (104,'Bruce','Ernst','BERNST','590.423.4568','07/05/21','IT_PROG',6000,null,103,60);
Insert into emp  values (105,'David','Austin','DAUSTIN','590.423.4569','05/06/25','IT_PROG',4800,null,103,60);
Insert into emp  values (106,'Valli','Pataballa','VPATABAL','590.423.4560','06/02/05','IT_PROG',4800,null,103,60);
Insert into emp  values (107,'Diana','Lorentz','DLORENTZ','590.423.5567','07/02/07','IT_PROG',4200,null,103,60);
Insert into emp  values (108,'Nancy','Greenberg','NGREENBE','515.124.4569','02/08/17','FI_MGR',12008,null,101,100);
Insert into emp  values (109,'Daniel','Faviet','DFAVIET','515.124.4169','02/08/16','FI_ACCOUNT',9000,null,108,100);
Insert into emp  values (110,'John','Chen','JCHEN','515.124.4269','05/09/28','FI_ACCOUNT',8200,null,108,100);
Insert into emp  values (111,'Ismael','Sciarra','ISCIARRA','515.124.4369','05/09/30','FI_ACCOUNT',7700,null,108,100);
Insert into emp  values (112,'Jose Manuel','Urman','JMURMAN','515.124.4469','06/03/07','FI_ACCOUNT',7800,null,108,100);
Insert into emp  values (113,'Luis','Popp','LPOPP','515.124.4567','07/12/07','FI_ACCOUNT',6900,null,108,100);
Insert into emp  values (114,'Den','Raphaely','DRAPHEAL','515.127.4561','02/12/07','PU_MAN',11000,null,100,30);
Insert into emp  values (115,'Alexander','Khoo','AKHOO','515.127.4562','03/05/18','PU_CLERK',3100,null,114,30);
Insert into emp  values (116,'Shelli','Baida','SBAIDA','515.127.4563','05/12/24','PU_CLERK',2900,null,114,30);
Insert into emp  values (117,'Sigal','Tobias','STOBIAS','515.127.4564','05/07/24','PU_CLERK',2800,null,114,30);
Insert into emp  values (118,'Guy','Himuro','GHIMURO','515.127.4565','06/11/15','PU_CLERK',2600,null,114,30);
Insert into emp  values (119,'Karen','Colmenares','KCOLMENA','515.127.4566','07/08/10','PU_CLERK',2500,null,114,30);
Insert into emp  values (120,'Matthew','Weiss','MWEISS','650.123.1234','04/07/18','ST_MAN',8000,null,100,50);
Insert into emp  values (121,'Adam','Fripp','AFRIPP','650.123.2234','05/04/10','ST_MAN',8200,null,100,50);
Insert into emp  values (122,'Payam','Kaufling','PKAUFLIN','650.123.3234','03/05/01','ST_MAN',7900,null,100,50);
Insert into emp  values (123,'Shanta','Vollman','SVOLLMAN','650.123.4234','05/10/10','ST_MAN',6500,null,100,50);
Insert into emp  values (124,'Kevin','Mourgos','KMOURGOS','650.123.5234','07/11/16','ST_MAN',5800,null,100,50);
Insert into emp  values (125,'Julia','Nayer','JNAYER','650.124.1214','05/07/16','ST_CLERK',3200,null,120,50);
Insert into emp  values (126,'Irene','Mikkilineni','IMIKKILI','650.124.1224','06/09/28','ST_CLERK',2700,null,120,50);
Insert into emp  values (127,'James','Landry','JLANDRY','650.124.1334','07/01/14','ST_CLERK',2400,null,120,50);
Insert into emp  values (128,'Steven','Markle','SMARKLE','650.124.1434','08/03/08','ST_CLERK',2200,null,120,50);
Insert into emp  values (129,'Laura','Bissot','LBISSOT','650.124.5234','05/08/20','ST_CLERK',3300,null,121,50);
Insert into emp  values (130,'Mozhe','Atkinson','MATKINSO','650.124.6234','05/10/30','ST_CLERK',2800,null,121,50);
Insert into emp  values (131,'James','Marlow','JAMRLOW','650.124.7234','05/02/16','ST_CLERK',2500,null,121,50);
Insert into emp  values (132,'TJ','Olson','TJOLSON','650.124.8234','07/04/10','ST_CLERK',2100,null,121,50);
Insert into emp  values (133,'Jason','Mallin','JMALLIN','650.127.1934','04/06/14','ST_CLERK',3300,null,122,50);
Insert into emp  values (134,'Michael','Rogers','MROGERS','650.127.1834','06/08/26','ST_CLERK',2900,null,122,50);
Insert into emp  values (135,'Ki','Gee','KGEE','650.127.1734','07/12/12','ST_CLERK',2400,null,122,50);
Insert into emp  values (136,'Hazel','Philtanker','HPHILTAN','650.127.1634','08/02/06','ST_CLERK',2200,null,122,50);
Insert into emp  values (137,'Renske','Ladwig','RLADWIG','650.121.1234','03/07/14','ST_CLERK',3600,null,123,50);
Insert into emp  values (138,'Stephen','Stiles','SSTILES','650.121.2034','05/10/26','ST_CLERK',3200,null,123,50);
Insert into emp  values (139,'John','Seo','JSEO','650.121.2019','06/02/12','ST_CLERK',2700,null,123,50);
Insert into emp  values (140,'Joshua','Patel','JPATEL','650.121.1834','06/04/06','ST_CLERK',2500,null,123,50);
Insert into emp  values (141,'Trenna','Rajs','TRAJS','650.121.8009','03/10/17','ST_CLERK',3500,null,124,50);
Insert into emp  values (142,'Curtis','Davies','CDAVIES','650.121.2994','05/01/29','ST_CLERK',3100,null,124,50);
Insert into emp  values (143,'Randall','Matos','RMATOS','650.121.2874','06/03/15','ST_CLERK',2600,null,124,50);
Insert into emp  values (144,'Peter','Vargas','PVARGAS','650.121.2004','06/07/09','ST_CLERK',2500,null,124,50);
Insert into emp  values (145,'John','Russell','JRUSSEL','011.44.1344.429268','04/10/01','SA_MAN',14000,0.4,100,80);
Insert into emp  values (146,'Karen','Partners','KPARTNER','011.44.1344.467268','05/01/05','SA_MAN',13500,0.3,100,80);
Insert into emp  values (147,'Alberto','Errazuriz','AERRAZUR','011.44.1344.429278','05/03/10','SA_MAN',12000,0.3,100,80);
Insert into emp  values (148,'Gerald','Cambrault','GCAMBRAU','011.44.1344.619268','07/10/15','SA_MAN',11000,0.3,100,80);
Insert into emp  values (149,'Eleni','Zlotkey','EZLOTKEY','011.44.1344.429018','08/01/29','SA_MAN',10500,0.2,100,80);
Insert into emp  values (150,'Peter','Tucker','PTUCKER','011.44.1344.129268','05/01/30','SA_REP',10000,0.3,145,80);
Insert into emp  values (151,'David','Bernstein','DBERNSTE','011.44.1344.345268','05/03/24','SA_REP',9500,0.25,145,80);
Insert into emp  values (152,'Peter','Hall','PHALL','011.44.1344.478968','05/08/20','SA_REP',9000,0.25,145,80);
Insert into emp  values (153,'Christopher','Olsen','COLSEN','011.44.1344.498718','06/03/30','SA_REP',8000,0.2,145,80);
Insert into emp  values (154,'Nanette','Cambrault','NCAMBRAU','011.44.1344.987668','06/12/09','SA_REP',7500,0.2,145,80);
Insert into emp  values (155,'Oliver','Tuvault','OTUVAULT','011.44.1344.486508','07/11/23','SA_REP',7000,0.15,145,80);
Insert into emp  values (156,'Janette','King','JKING','011.44.1345.429268','04/01/30','SA_REP',10000,0.35,146,80);
Insert into emp  values (157,'Patrick','Sully','PSULLY','011.44.1345.929268','04/03/04','SA_REP',9500,0.35,146,80);
Insert into emp  values (158,'Allan','McEwen','AMCEWEN','011.44.1345.829268','04/08/01','SA_REP',9000,0.35,146,80);
Insert into emp  values (159,'Lindsey','Smith','LSMITH','011.44.1345.729268','05/03/10','SA_REP',8000,0.3,146,80);
Insert into emp  values (160,'Louise','Doran','LDORAN','011.44.1345.629268','05/12/15','SA_REP',7500,0.3,146,80);
Insert into emp  values (161,'Sarath','Sewall','SSEWALL','011.44.1345.529268','06/11/03','SA_REP',7000,0.25,146,80);
Insert into emp  values (162,'Clara','Vishney','CVISHNEY','011.44.1346.129268','05/11/11','SA_REP',10500,0.25,147,80);
Insert into emp  values (163,'Danielle','Greene','DGREENE','011.44.1346.229268','07/03/19','SA_REP',9500,0.15,147,80);
Insert into emp  values (164,'Mattea','Marvins','MMARVINS','011.44.1346.329268','08/01/24','SA_REP',7200,0.1,147,80);
Insert into emp  values (165,'David','Lee','DLEE','011.44.1346.529268','08/02/23','SA_REP',6800,0.1,147,80);
Insert into emp  values (166,'Sundar','Ande','SANDE','011.44.1346.629268','08/03/24','SA_REP',6400,0.1,147,80);
Insert into emp  values (167,'Amit','Banda','ABANDA','011.44.1346.729268','08/04/21','SA_REP',6200,0.1,147,80);
Insert into emp  values (168,'Lisa','Ozer','LOZER','011.44.1343.929268','05/03/11','SA_REP',11500,0.25,148,80);
Insert into emp  values (169,'Harrison','Bloom','HBLOOM','011.44.1343.829268','06/03/23','SA_REP',10000,0.2,148,80);
Insert into emp  values (170,'Tayler','Fox','TFOX','011.44.1343.729268','06/01/24','SA_REP',9600,0.2,148,80);
Insert into emp  values (171,'William','Smith','WSMITH','011.44.1343.629268','07/02/23','SA_REP',7400,0.15,148,80);
Insert into emp  values (172,'Elizabeth','Bates','EBATES','011.44.1343.529268','07/03/24','SA_REP',7300,0.15,148,80);
Insert into emp  values (173,'Sundita','Kumar','SKUMAR','011.44.1343.329268','08/04/21','SA_REP',6100,0.1,148,80);
Insert into emp  values (174,'Ellen','Abel','EABEL','011.44.1644.429267','04/05/11','SA_REP',11000,0.3,149,80);
Insert into emp  values (175,'Alyssa','Hutton','AHUTTON','011.44.1644.429266','05/03/19','SA_REP',8800,0.25,149,80);
Insert into emp  values (176,'Jonathon','Taylor','JTAYLOR','011.44.1644.429265','06/03/24','SA_REP',8600,0.2,149,80);
Insert into emp  values (177,'Jack','Livingston','JLIVINGS','011.44.1644.429264','06/04/23','SA_REP',8400,0.2,149,80);
Insert into emp  values (178,'Kimberely','Grant','KGRANT','011.44.1644.429263','07/05/24','SA_REP',7000,0.15,149,null);
Insert into emp  values (179,'Charles','Johnson','CJOHNSON','011.44.1644.429262','08/01/04','SA_REP',6200,0.1,149,80);
Insert into emp  values (180,'Winston','Taylor','WTAYLOR','650.507.9876','06/01/24','SH_CLERK',3200,null,120,50);
Insert into emp  values (181,'Jean','Fleaur','JFLEAUR','650.507.9877','06/02/23','SH_CLERK',3100,null,120,50);
Insert into emp  values (182,'Martha','Sullivan','MSULLIVA','650.507.9878','07/06/21','SH_CLERK',2500,null,120,50);
Insert into emp  values (183,'Girard','Geoni','GGEONI','650.507.9879','08/02/03','SH_CLERK',2800,null,120,50);
Insert into emp  values (184,'Nandita','Sarchand','NSARCHAN','650.509.1876','04/01/27','SH_CLERK',4200,null,121,50);
Insert into emp  values (185,'Alexis','Bull','ABULL','650.509.2876','05/02/20','SH_CLERK',4100,null,121,50);
Insert into emp  values (186,'Julia','Dellinger','JDELLING','650.509.3876','06/06/24','SH_CLERK',3400,null,121,50);
Insert into emp  values (187,'Anthony','Cabrio','ACABRIO','650.509.4876','07/02/07','SH_CLERK',3000,null,121,50);
Insert into emp  values (188,'Kelly','Chung','KCHUNG','650.505.1876','05/06/14','SH_CLERK',3800,null,122,50);
Insert into emp  values (189,'Jennifer','Dilly','JDILLY','650.505.2876','05/08/13','SH_CLERK',3600,null,122,50);
Insert into emp  values (190,'Timothy','Gates','TGATES','650.505.3876','06/07/11','SH_CLERK',2900,null,122,50);
Insert into emp  values (191,'Randall','Perkins','RPERKINS','650.505.4876','07/12/19','SH_CLERK',2500,null,122,50);
Insert into emp  values (192,'Sarah','Bell','SBELL','650.501.1876','04/02/04','SH_CLERK',4000,null,123,50);
Insert into emp  values (193,'Britney','Everett','BEVERETT','650.501.2876','05/03/03','SH_CLERK',3900,null,123,50);
Insert into emp  values (194,'Samuel','McCain','SMCCAIN','650.501.3876','06/07/01','SH_CLERK',3200,null,123,50);
Insert into emp  values (195,'Vance','Jones','VJONES','650.501.4876','07/03/17','SH_CLERK',2800,null,123,50);
Insert into emp  values (196,'Alana','Walsh','AWALSH','650.507.9811','06/04/24','SH_CLERK',3100,null,124,50);
Insert into emp  values (197,'Kevin','Feeney','KFEENEY','650.507.9822','06/05/23','SH_CLERK',3000,null,124,50);
Insert into emp  values (198,'Donald','OConnell','DOCONNEL','650.507.9833','07/06/21','SH_CLERK',2600,null,124,50);
Insert into emp  values (199,'Douglas','Grant','DGRANT','650.507.9844','08/01/13','SH_CLERK',2600,null,124,50);
Insert into emp  values (200,'Jennifer','Whalen','JWHALEN','515.123.4444','03/09/17','AD_ASST',4400,null,101,10);
Insert into emp  values (201,'Michael','Hartstein','MHARTSTE','515.123.5555','04/02/17','MK_MAN',13000,null,100,20);
Insert into emp  values (202,'Pat','Fay','PFAY','603.123.6666','05/08/17','MK_REP',6000,null,201,20);
Insert into emp  values (203,'Susan','Mavris','SMAVRIS','515.123.7777','02/06/07','HR_REP',6500,null,101,40);
Insert into emp  values (204,'Hermann','Baer','HBAER','515.123.8888','02/06/07','PR_REP',10000,null,101,70);
Insert into emp  values (205,'Shelley','Higgins','SHIGGINS','515.123.8080','02/06/07','AC_MGR',12008,null,101,110);
Insert into emp  values (206,'William','Gietz','WGIETZ','515.123.8181','02/06/07','AC_ACCOUNT',8300,null,205,110);



 
 
 
 