-- DAY2 230616---------------------------------------------------------------------------------------------------------------------------------
DELETE FROM EMP;

INSERT INTO EMP VALUES(7369,'SMITH','CLERK',7902,TO_DATE('17-12-1980','dd-mm-yyyy'),800,NULL,20);
INSERT INTO EMP VALUES (7499, 'ALLEN',  'SALESMAN',  7698,TO_DATE('20-02-1981', 'DD-MM-YYYY'), 1600,  300, 30);
INSERT INTO EMP VALUES(7521, 'WARD',   'SALESMAN',  7698,TO_DATE('22-02-1981', 'DD-MM-YYYY'), 1250,  500, 30);
INSERT INTO EMP VALUES(7566, 'JONES',  'MANAGER',   7839,TO_DATE('02-04-1981', 'DD-MM-YYYY'),  2975, NULL, 20);
INSERT INTO EMP VALUES(7654, 'MARTIN', 'SALESMAN',  7698,TO_DATE('28-09-1981', 'DD-MM-YYYY'), 1250, 1400, 30);
INSERT INTO EMP VALUES(7698, 'BLAKE',  'MANAGER',   7839,TO_DATE('01-05-1981', 'DD-MM-YYYY'),  2850, NULL, 30);
INSERT INTO EMP VALUES(7782, 'CLARK',  'MANAGER',   7839, TO_DATE('09-06-1981', 'DD-MM-YYYY'),  2450, NULL, 10);
INSERT INTO EMP VALUES(7788, 'SCOTT',  'ANALYST',   7566,TO_DATE('09-12-1982', 'DD-MM-YYYY'), 3000, NULL, 20);
INSERT INTO EMP VALUES(7839, 'KING',   'PRESIDENT', NULL, TO_DATE('17-11-1981', 'DD-MM-YYYY'), 5000, NULL, 10);
INSERT INTO EMP VALUES(7844, 'TURNER', 'SALESMAN',  7698, TO_DATE('08-09-1981', 'DD-MM-YYYY'),  1500, NULL, 30);
INSERT INTO EMP VALUES(7876, 'ADAMS',  'CLERK',     7788,TO_DATE('12-01-1983', 'DD-MM-YYYY'), 1100, NULL, 20);
INSERT INTO EMP VALUES(7900, 'JAMES',  'CLERK',     7698, TO_DATE('03-12-1981', 'DD-MM-YYYY'),   950, NULL, 30);
INSERT INTO EMP VALUES (7902, 'FORD',   'ANALYST',   7566, TO_DATE('03-12-1981', 'DD-MM-YYYY'),  3000, NULL, 20);
INSERT INTO EMP VALUES(7934, 'MILLER', 'CLERK',     7782, TO_DATE('23-01-1982', 'DD-MM-YYYY'), 1300, NULL, 10);
INSERT INTO EMP VALUES(8934, 'MILLER', 'CLERK',     7782, TO_DATE('23-01-1982', 'DD-MM-YYYY'), 1300.555555, NULL, 10);

select * from emp;

-- 데이터 삭제
delete from emp;
-- 일부 삭제
delete from emp where empno=7499;
-- scott 삭제
delete from emp where ename='SCOTT';
delete from emp where job='CLERK';

create table dept(
deptno number,
dname varchar2(14),
loc varchar2(13));
INSERT INTO dept VALUES(10,'ACCOUNTING','NEW YONK');
INSERT INTO dept VALUES(20,'RESEARCH','DALLAS');
INSERT INTO dept VALUES(30,'SALES','CHICAGO');
INSERT INTO dept VALUES(40,'OPERATIONS','BOSTON');
desc dept;
select * from dept;
-- not null ( alt + 작은 따옴표 대소문자 변경)
-- 테이블의 무결성을 유지하기 위한 제약 조건 not null
create table address2(
name varchar2(20) not null,
addr varchar2(100) not null,
tel varchar2(20)
);

insert into address2 values('hong', 'seoul', null);
--insert into address2 values(null,'seoul', null);-- not null 제약 조건 위배

-- aliasing 별칭
select empno as "사번" from emp;
select empno as "사번", ename as "사원이름", job as "직책", mgr as "사수번호", hiredate as "입사일", sal as "급여", comm as "커미션", deptno as "부서번호" from emp;
select empno 사번, ename 사원이름 from emp;

-- 연결 연산자
select ename from emp;
-- 앞에있는 작은 따옴표와 뒤에있는 작은 따옴표는 문자열이라는 뜻
-- ename 에 's를 연결해준다.
select ename || '''s job is ' || job from emp;
select ename || '''s 급여는 ' || sal ||'달러이다.' from emp where ename='SMITH';
select ename || '''s 매니저 번호는 ' || mgr ||'이다.' from emp where ename='SMITH';

-- 중복값 제거 distinct
select * from emp;
select distinct job from emp;
select distinct deptno from emp;

-- 갯수함수 count
select count(distinct job) from emp;
select count(job) from emp;
-- null 값은 카운트 하지 않음 주의
select count(*) from emp;-- record 의 갯수

-- 부서의 갯수는 갯수 출력 중복값 제거
select count(distinct deptno) "부서 갯수" from emp;
select * from countries;
-- || 복습
-- ar's 본 단어는 argetina이다 
select country_id || '''s의 본 단어는 '||country_name from countries;
select * from employees;
-- steven 의 이메일은 sking이고 폰넘버는 515.123.4567이다
select first_name || '의 이메일은' ||email||'이고 폰넘버는'||phone_number||'이다.' nameemailphone from employees ;

-- employees 의 테이블의 부서번호 코드를 중복제거하여 갯수를 조회
select distinct department_id "부서 갯수" from employees ;
select count(distinct department_id) "부서 갯수" from employees ;

-- primary key 기본키 유니크함 nut null 포함
-- 칼럼에 데이터가 유일해야한다. NOT NULL UNIQUE
create table emp(
empno number(4) primary key,-- 사번
ename varchar2(10),-- 사원이름
job varchar2(9),-- 직책
mgr number(4),-- 사수번호
hiredate date,-- 입사일
sal number(7,2),-- 소수점 두자리까지 나타내기 -- 급여
comm number(7,2),-- 커미션
deptno number(2)-- 부서번호
);

-- where  조건절
-- select 풀력할 칼럼 from 테이블명 where 출력할 조건
-- empno 7900 데이터 조회
select * from emp where empno=7900;
select * from emp;

-- 이름이 MARTIN인 사람 조회
select * from emp where ename='MARTIN';
-- job 이 clerk인 데이터 조회
select * from emp where job ='CLERK';
select * from emp where job='SALESMAN';

-- 출력할 칼럼 지정
select ename, empno, hiredate from emp;

-- 입사일 조회 사번 이름 급여 입사일 데이터 조회 81년 12월 3일
select hiredate, empno, ename, sal from emp where hiredate='1981-12-3';

-- sql 산술연산
-- 현재 급여에서 10%인상해서 인상된 급여 표시 출력
select sal,sal*1.1 "인상된 급여" from emp;

-- 급여의 150% 보너스 지급 '보너스 금액' 조회
select sal,sal+(sal*0.5) "보너스 금액" from emp;

-- sql 비교연산
-- sql 2000 이상인 데이터 조회
select * from emp;
select * from emp where sal>= 2000;

-- sal 1500이하인 데이터 조회
select * from emp where sal<= 1500;

-- 부서 번호가 20인 데이터 조회
select * from emp
where deptno=20;

-- 조건이 복수개일때조회
-- sal 1500이하이고 부서번호가 20인 데이터 조회
select * from emp where sal<=1500 and deptno=20;
-- 문법 순서
--select 
--from 
--where
--group by
--having 
--order by 

-- 실행순서
--from
--where
--group by
--having
--select
--order by

-- 날짜 비교
-- 입사일이 81 12 3 이전에 입사한 데이터 조회
select * from emp
where hiredate <='1981-12-3';

-- 문자 비교
-- 이름이 smith 보다 작은 데이터 조회
select * from emp
where ename<='SMITH';

-- between a and b 사용 a에서 bRkwl
-- sal 2000~3000까지 조회
select * from emp
where sal BETWEEN 2000 and 3000;
select * from emp
where sal BETWEEN 4450 and 3000;-- 작은 값이 앞쪽에 위치해야함

-- 페이징 처리에 쓰임
-- 위 내용을 비교연산으로 변형
select * from emp
where sal >= 2450 and sal<=3000;

-- between james ~martine
select * from emp
where ename BETWEEN 'JAMES' and 'MARTINE';

-- IN 연산자 간편하게 여러 조건 검색 ***
-- 부서 번호가 20, 30 인 데이터 조회
-- or 사용
select * from emp where deptno=20 or deptno=30;

select * from emp where deptno in(20,30);

-- 직책이 clerk, analyst 데이터 조회
select * from emp
where job in('CLERK','ANALYST');

-- like 연산자 비슷한 데이터 조회 *** 
--sal 1로 시작하는 데이터 조회
select * from emp
where ename like 'W%';

-- R로 끝나는 사람 조회
select * from emp
where ename like '%R';

-- A가 포함된 데이터 조회
select * from emp
where ename like '%A%';
-- 네이버에서 검색어 검색할때사용

-- 직원 이름중에 두번째 글자가 L인 데이터 조회
select * from emp
where ename like '_L%';

-- 세번째 글자가 R인 데이터 출력
select * from emp
where ename like '__R%';

-- 이름 중 끝에서 세번째 글자가 N인 데이터 조회
select * from emp
where ename like '%N__';

-- erd (Entity-Relation Diagram)
commit;