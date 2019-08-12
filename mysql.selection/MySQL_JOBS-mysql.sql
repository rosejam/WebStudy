CREATE TABLE IF NOT EXISTS job 
   (JOBID VARCHAR(10) NOT NULL, 
	JOBTITLE VARCHAR(35), 
	MINSAL INT(6), 
	MAXSAL INT(6)
   );


Insert into job values ('AD_PRES','President',20080,40000);
Insert into job values ('AD_VP','Administration Vice President',15000,30000);
Insert into job values ('AD_ASST','Administration Assistant',3000,6000);
Insert into job values ('FI_MGR','Finance Manager',8200,16000);
Insert into job values ('FI_ACCOUNT','Accountant',4200,9000);
Insert into job values ('AC_MGR','Accounting Manager',8200,16000);
Insert into job values ('AC_ACCOUNT','Public Accountant',4200,9000);
Insert into job values ('SA_MAN','Sales Manager',10000,20080);
Insert into job values ('SA_REP','Sales Representative',6000,12008);
Insert into job values ('PU_MAN','Purchasing Manager',8000,15000);
Insert into job values ('PU_CLERK','Purchasing Clerk',2500,5500);
Insert into job values ('ST_MAN','Stock Manager',5500,8500);
Insert into job values ('ST_CLERK','Stock Clerk',2008,5000);
Insert into job values ('SH_CLERK','Shipping Clerk',2500,5500);
Insert into job values ('IT_PROG','Programmer',4000,10000);
Insert into job values ('MK_MAN','Marketing Manager',9000,15000);
Insert into job values ('MK_REP','Marketing Representative',4000,9000);
Insert into job values ('HR_REP','Human Resources Representative',4000,9000);
Insert into job values ('PR_REP','Public Relations Representative',4500,10500);
