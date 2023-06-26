-- 21번 이름 중 S자가 들어가 있는 사람만 모든 정보를 출력하라.
select * from emp where ename like '%S%';
-- 22번 이름이 S로 시작하고 마지막 글자가 T인 사람의 모든 정보를 출력하라(단, 이름은 전체 5자리이다.)
select * from emp where ename like 'S___T';
-- 23번 첫 번쨰 문자는 관계없고, 두 번째 문자가 A인 사람의 정보를 출력하라.
select * from emp where ename like '_A%';
-- 24번 커미션이 NULL인 사람의 정보를 출력하라.
select * from emp where comm is null;
-- 25번 커미션이 NULL이 아닌 사람의 정보를 출력하라.
select * from emp where comm is not null;
-- 26번 부서가 30번 부서이고 급여가 $1,500 이상인 사람의 이름, 부서, 월급을 출력하라.
select ename, deptno, sal from emp where deptno=30 AND sal>=1500;
-- 27번 이름의 첫 글자가 K로 시작하거나 부서번호가 30인 사람의 사원번호, 이름, 부서번호를 출력하라.
select empno, ename, deptno from emp where ename like 'K%' OR deptno=30;
-- 28번 급여가 $1500 이상이고 부서번호가 30번인 사원 중 직업이 MANAGER인 사람의 정보를 추력하라.
select * from emp where sal >=1500 AND deptno=30 AND job='MANAGER';
-- 29번 부서번호가 30인 사람 중 사원번호가 SORT.
select * from emp where deptno=30 order by empno asc;
-- 30번 급여가 많은 순으로 SORT하라.
select * from emp order by sal desc;
-- 31번 부서번호로 ASCENDING SORT  한 후 급여가 많은 사람 순으로 출력하라.
select * from emp order by deptno asc, sal desc;
-- 32번 부서 번호가 DESCENDING SORT하고, 이름 순으로 ASCENDING SORT, 급여순으로 DESCENDING SORT 하라.
select * from emp order by deptno desc, empno asc, sal desc;
-- 33번 EMP TABLE 에서 이름, 급여, 커미션 금액, 총액 (SAL + COMM) 을 구하여 총액이 많은 순서로 출력하라. 
-- 단 커미션이 NULL인 사람은 제외한다.
select ename, sal, comm, (nvl(sal+comm,sal+0)) 총액 from emp where comm is not null order by (nvl(sal+comm,sal+0)) desc;
-- 34번 10번 부서의 모든 사람들에게 급여의 13%를 보너스로 지불하기로 하였다. 이름, 급여, 보너스 금액, 부서번호를 출력하라.
select ename, sal, (sal*0.13)보너스금액, deptno from emp where deptno=10;
-- 35번 30번 부서의 연봉을 계산하여 이름, 부서번호, 급여, 연봉을 출력하라.
-- 단 연말에 급여의 150%를 보너스로 지급한다.
select ename, deptno, sal, ((sal*12)+nvl(comm,0)+(sal*1.5)) 연봉 from emp where deptno=30;
-- 36번 부서번호가 20인 부서의 시간당 임금을 계산하여 출력하라.
-- 단 1달의 근무일수가 12일이고, 1일 근무시간은 5시간이다.
-- 출력양식은 이름, 급여, 시간당 임금(소수이하 첫 번째 자리에서 반올림)을 출력하라.
select ename, sal, round(((sal/12)/5),1) from emp where deptno=20;
-- 37번 급여가 $1,500 부터 $ 3,000 사이의 사람은 급여가 15%를 회비로 지불하기로 하였다.
-- 이름, 급여, 회비(소수점 두 자리에서 반올림) 출력하라.
select ename,sal, round((sal/0.15),2)회비 from emp where sal between 1500 and 3000;
-- 38번 급여가 $2,000 이상인 모든 사람은 급여가 15%를 경보비로 내기로 하였다.
-- 이름, 급여, 경조비 를 출력하라.
select ename, sal, trunc(sal/0.15)경조사비 from emp where sal>=2000;
-- 39번 입사일 부터 지금까지의 날짜수를 출력하라. 부서번호, 이름, 입사일, 현재일, 
-- 근무일수(소수점 이하 절삭), 근무년수, 근무월수(30일 기준), 근무주수를 출력하라.
select deptno, ename, hiredate, sysdate,
TRUNC(SYSDATE-HIREDATE) 근무일수,
TRUNC((SYSDATE-HIREDATE)/ 365)  근무년수,
TRUNC((SYSDATE-HIREDATE)/30) 근무월수,
TRUNC((SYSDATE-HIREDATE)/7) 근무주수
from emp;

select deptno, ename, hiredate, sysdate,
MONTHS_BETWEEN(SYSDATE,HIREDATE) 근무월수,
TRUNC((SYSDATE-HIREDATE)/30) 근무월수
from emp;
-- 40번 모든 사원의 실수령액을 계산하여 출력하라. 
-- 단 급여가 많은 순으로 이름, 급여, 실수령액을 출력하라
-- (실수령액은 급여에 대해 10%의 세금을 뺸 금액)
select ename, sal,(sal-(sal*0.1)) 실수령액 from emp order by sal desc;
-- 41번 입사일로부터 90일이 지난 후의 사원이름, 입사일, 90일 후의 날, 급여를 출력하라.
select ename, hiredate, (hiredate+90)as "90일후" ,sal from emp;
-- 42번 입사일로 부터 6개월이 지난 후의 입사일, 6개월 후의 날짜, 급여를 출력하라.
select hiredate, add_months(hiredate,6),sal from emp;
-- 43번 입사한 달의 근무일수를 계산하여 부서번호, 이름, 근무일수를 출력하라.
select deptno, ename, (last_day(hiredate)-hiredate) from emp;
-- 44번 모든 사원의 60일이 지난 후의 MONDAY 는 몇 년 , 몇 월, 몇 일 인가를 구하여
-- 이름, 입사일, MONDAY를 출력하라.
select ename, hiredate,next_day(hiredate+60,'월') from emp;
-- 45번 입사일로부터 오늘까지의 일수를 구하여 이름, 입사일, 근무일수를 출력하라.
select ename, hiredate, trunc(sysdate-hiredate) from emp;
-- 46번 입사일을 1996년 5월 14일 의 형태로 이름, 입사일을 출력하라.
select to_char(hiredate, 'yyyy"년" mm"월"dd"일"')from emp;
-- 47번 이름의 글자수가 6자 이상인 사람의 이름을 앞에서 3자리만 구하여 소문자로 이름만을 출력하라.
select lower(substr(ename,1,3)), ename from emp where length(ename)>=6;
-- 48번 10번 부서 월급의 평균, 최고, 최저, 인원수를 구하여 출력하라.
select trunc(avg(sal)), max(sal), min(sal), count(*) from emp where deptno=10;
-- 49번 각 부서별 급여의 평균, 최고, 최저, 인원수를 구하여 출력하라.
select trunc(avg(sal)), max(sal), min(sal), count(*) from emp group by deptno;
-- 50번 각 부서별 같은 업무를 하는 사람의 인원수를 구하여 부서번호, 업무명, 인원수를 출력하라.
select deptno, job, count(*) from emp group by deptno, job order by deptno;