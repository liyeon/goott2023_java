-- 51번 같은 업무를 하는 사람의 수가 4명 이상인 업무와 인원수를 출력하라.
select job, count(job)
from emp
group by job
having count(job)>=4;
-- 52번 각 부서별 평균 월급, 전체 원급, 최고 원급, 최저 월급 을 구하여 평균 원급이 많은 순으로 출력하라.
select deptno, trunc(avg(sal)), sum(sal), max(sal), min(sal)
from emp
group by deptno;
-- 53번 EMP와 DEPT TABLE 을 JOIN하여 부서번호, 부서명, 이름, 급여를 출력하라.
select e.deptno, d.dname, e.ename, e.sal
from emp e, dept d
where e.deptno=d.deptno;
-- 54번 이름이 ALLEN인 사원의 부서명을 출력하라.
select e.ename, d.dname
from emp e, dept d
where (e.deptno = d.deptno) and e.ename='ALLEN';
-- 55번 DEPT TABLE 에 있는 모든 부서를 출력하고, EMP  TABLE 에 있는 DATA와 JOIN하여 
-- 모든 사원의 이름, 부서번호, 부서명, 급여를 출력하라.
select e.ename, e.deptno, d.dname, e.sal
from dept d, emp e
where d.deptno = e.deptno
order by d.dname;