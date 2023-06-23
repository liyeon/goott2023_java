-- <<오라클문제1>>
select * from emp;
-- 1번 부서번호가 10번인 부서의 사람 중 사원번호, 이름, 월급을 출력하라.
select empno, ename, sal from emp where deptno=10;

-- 2번 사원번호가 7369인 사람 중 이름, 입사일, 부서번호를 출력하라.
select ename,hiredate, deptno from emp where empno=7369;

-- 3번 이름이 ALLEN인 사람의 모든 정보를 출력하라.
select * from emp where ename='ALLEN';
-- 4번 입사일이 83/01/12인 사원의 이름, 부서번호, 월급을 출력하라.
select ename, deptno, sal from emp where hiredate='83/01/12';
-- 5번 직업이 MANAGER가 아닌 사람의 모든 정보를 출력하라.
select * from emp where not job='MANAGER';
-- 6번 입사일이 81/04/02 이후에 입사한 사원의 정보를 출력하라.
select * from emp where hiredate>='81/04/02';
-- 7번 급여가 $800 이상인 사람의 이름, 급여, 부서번호를 출력하라.
select ename, sal , deptno from emp where sal>=800;
-- 8번 부서번호가 20번 이상인 사원의 모든 정보를 출력하라.
select * from emp where deptno>=20;
-- 9번 이름이 K로 시작하는 사람보다 높은 이름을 가진 사람의 모든 정보를 출력하라.
select * from emp where ename > 'K' and not ename like 'K%';

-- 10번 입사일이 81/12/09 보다 먼저 입사한 사람들의 모든 정보를 출력하라.
select * from emp where hiredate <'81/12/09';
-- 11번 입사번호가 7698보다 작거나 같은 사람들의 입사번호와 이름을 출력하라.
select empno, ename from emp where empno<= 7698;
-- 12번 입사일이 81/04/02보다 늦고 82/12/09보다 빠른 사원의 이름, 월급, 부서번호를 출력하라.
select ename, sal, deptno from emp where hiredate>'81/04/02' AND hiredate <'82/12/09';
-- 13번 급여가 $1,600보다 크고 $3,000보다 작은 사람의 이름, 직업, 급여를 출력하라.
select ename, job, sal from emp where sal>1600 AND sal <3000;
-- 14번 사원번호가 7654와 7782 사이 이외의 사원의 모든 정보를 출력하라.
select * from emp where empno not BETWEEN 7654 and 7782;
-- 15번 이름이 B와 J사이의 모든 사원의 정보를 출력하라.
select * from emp where ename BETWEEN 'B' and 'J';
-- 16번 입사일이 81년 이외의 입사한 사람의 모든 정보를 출력하라.
select * from emp where not extract(year from hiredate) = '1981';
-- 17번 직업이 MANAGER와 SALESMAN인 사람의 모든 정보를 출력하라.
select * from emp where job in('MANAGER','SALESMAN');
-- 18번 부서번호와 20, 30번을 제외한 모든 사람의 이름, 사원번호, 부서번호를 출력하라.
select ename,empno,deptno from emp where not deptno in(20,30);
-- 19번 S로 시작하는 사원의 사원번호, 이름, 입사일, 부서번호를 출력하라.
select ename,hiredate,deptno from emp where ename like 'S%';
-- 20번 입사일이 81년도인 사람의 모든 정보를 출력하라.
select * from emp where extract(year from hiredate) = '1981';