-- ---------------------------------------------------
-- 230620
-- ---------------------------------------------------
--문법순서
--select from where group by having order by
--실행순서 from where group by (그룹화)having(그룹의 조건)SELECT order by(정렬)

-- replace 문자열 대치 ****
-- replace (칼럼, 문자1,문자2)
select *from emp;
-- ename의 앞글자 2글자를 **로 대치
select ename, replace(ename, 'SM','**')from emp;

select ename, replace(ename,substr(ename,1,2), '**')from emp;

-- job앞글자 2글자를 --로 변환
select job, replace(job, substr(job,1,2),'--') replacejob from emp;

--tel - 를 제거
select tel, instr(tel,'-') from student;
select tel, replace(tel,substr(tel,instr(tel,'-'),1) ,'')from student;

-- 주민번호에 - 를추가
-- CONCAT 사용
SELECT JUMIN FROM STUDENT;
SELECT  CONCAT(CONCAT(SUBSTR(JUMIN,1,6),'-'),SUBSTR(JUMIN,7)) FROM STUDENT;

-- 단일행 함수의 숫자관련 함수
-- ROUND 반올림 함수
SELECT 987.456, ROUND(987.456,2) FROM DUAL;-- 소수점 두번째자리까지표현
SELECT 987.456, ROUND(987.456,0) FROM DUAL;-- 소수점 0번째자리까지표현
SELECT 987.456, ROUND(987.456,-1) FROM DUAL;-- 10 단위
SELECT 987.456, ROUND(987.456,-2) FROM DUAL;-- 100단위

-- TRUNC 절삭 함수 ****
SELECT 987.456, TRUNC(987.456,2) FROM DUAL;-- 반올림X 자릿수 뒤로 잘라버림
SELECT 987.456, TRUNC(987.456,0) FROM DUAL;
SELECT 987.456, TRUNC(987.456,-1) FROM DUAL;

-- MOD CEIL FLOOR
SELECT MOD(121,10) FROM DUAL; --숫자1, 숫자2의로 나눈 나머지
SELECT CEIL(100.123) FROM DUAL; -- 올림
SELECT CEIL(-100.123) FROM DUAL;-- 올림
SELECT FLOOR(100.123) FROM DUAL;-- 내림

-- CEIL함수 응용
SELECT ROWNUM, EMPNO, ENAME FROM EMP;-- ROWNUM 자동 생성됨
-- 팀구분
SELECT ROWNUM, CEIL(ROWNUM/3) || '팀' TEAM, ENAME FROM EMP;

-- POWER 함수
SELECT POWER(2,3) FROM DUAL;-- 2의 3승

-- 단일행 함수의 날짜 함수
-- SYSDATE *** 현재 날짜 (오라클이 설치된 시스템의 날짜)
SELECT SYSDATE FROM DUAL;

-- MONTHS_BETWEEN(날짜1, 날짜2)  ** 특정 기간 개월수
SELECT MONTHS_BETWEEN('23/06/20', '23/01/20')FROM DUAL;-- 두 날짜 사이의 개월수
SELECT CEIL(MONTHS_BETWEEN('23/06/20', '23/01/05')) FROM DUAL;

-- ADD_MONTHS(날짜, 더해질 월)
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 5) FROM DUAL;

--NEXT_DAY 다가오는 날짜
SELECT NEXT_DAY('23/06/20','월요일')FROM DUAL;-- 20일 이후에 처음 나오는 월요일의 날짜

-- LAST_DAY(날짜) 해당 날짜에 해당하는 달의 마지막 날짜
SELECT SYSDATE,LAST_DAY(SYSDATE) FROM DUAL;

-- 묵시적 형변환, 자동형변환
SELECT '2'+'2' FROM DUAL;
SELECT 2+2 FROM DUAL;
-- TO_NUMBER(‘숫자에 대응되는 문자’);를 숫자로 바꿔준다.
SELECT 2+TO_NUMBER('2') FROM DUAL;-- (명시적형변환)

-- YEAR FORMAT
SELECT SYSDATE FROM DUAL;
SELECT SYSDATE,TO_CHAR(SYSDATE,'yyyy-mm-dd')FROM DUAL;
SELECT SYSDATE,TO_CHAR(SYSDATE,'yy-mm-dd')FROM DUAL;
SELECT SYSDATE,TO_CHAR(SYSDATE,'year')FROM DUAL;

-- MONTH FORMAT
SELECT SYSDATE,TO_CHAR(SYSDATE,'MM')FROM DUAL;
SELECT SYSDATE,TO_CHAR(SYSDATE,'MON')FROM DUAL;
SELECT SYSDATE,TO_CHAR(SYSDATE,'MONTH')FROM DUAL;
SELECT SYSDATE,TO_CHAR(SYSDATE,'MONTH','NLS_DATE_LANGUAGE=ENGLISH')FROM DUAL;

-- DAY FORMAT
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DD')FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DAY')FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DDTH')FROM DUAL;

-- HOUR FORMAT
SELECT  SYSDATE, TO_CHAR(SYSDATE, 'RRRR-MM-DD HH24:MI:SS') FROM DUAL; -- 시분초

-- 숫자형을  문자형으로 변환 ***
SELECT ENAME,SAL,COMM,SAL+COMM FROM EMP;
SELECT ENAME,SAL,COMM,SAL+COMM*12 연봉, TO_CHAR(SAL+COMM*12, '$999,999,999') 달러 FROM EMP;

-- TO_NUMBER *** 
SELECT TO_NUMBER('55') FROM DUAL;

-- NVL ****** NULL VALUE
-- NVL(칼럼명, 값) 칼럼이 NULL일때 값으로 대치하겠다.
-- 비어 있는 경우 기본 값을 지정 해 줄 때 쓴다.
SELECT * FROM EMP;
SELECT NVL(COMM, 0)FROM EMP;
SELECT SAL, COMM, SAL+COMM FROM EMP;-- 원하는결과불일치
SELECT SAL, COMM, SAL+NVL(COMM, 0) FROM EMP;

-- NVL2 *********
-- 함수 :  NVL2("값", "지정값1", "지정값2") // NVL2("값", "NOT NULL", "NULL") 
-- NVL2(COL1,COL2,COL3) COL1이 NULL이 아니면 COL2, NULL이면COL3
SELECT ENAME, SAL, NVL2(COMM, SAL+COMM, SAL+0) FROM EMP;


-- STUDENT에서 DEPTNO2가 NULL값을 0으로 NVL을 활용해서 치환하고
-- 이름 아이디 주민 DEPTNO2를출력
-- 조건 DEPTNO1이 201이거나 103인데이터
SELECT NAME, ID, JUMIN,NVL(DEPTNO2,0) FROM STUDENT WHERE DEPTNO1=201 OR DEPTNO1=103;

-- DECODE 함수 IF문과 유사하다.
-- decode(deptno, 101, 'computer enginerring', 'etc') deptno가 101이면 'computer enginerring' 출력하고 나머지는 etc
SELECT * FROM PROFESSOR;
SELECT DEPTNO, NAME, DECODE(DEPTNO, 101, 'computer enginerring', 'etc') 직업 FROM PROFESSOR;
-- 동시에 적용하기
SELECT DEPTNO, NAME, DECODE(DEPTNO, 
101, 'COM ENG', 
102, 'MULTI ENG',
103, 'SOFTW ENG',
201, 'ELEC ENG',
202, 'MECHAN ENG',
203, 'CHEMICAL ENG',
301, 'INFORMATION SIENCE') 직업 FROM PROFESSOR;

-- EMP 테이블에 적용하기
-- decode 사용 emp 테이블에 부서이름 출력
SELECT * FROM EMP;
SELECT * FROM DEPT;
SELECT DEPTNO, DECODE(DEPTNO, 
10,'ACCOUNTING',
20, 'RESEARCH',
30, 'SALES',
40, 'OPERATIONS','ETC'
)FROM EMP;

-- CASE WHEN 표현식
-- CASE WHEN [조건식1] THEN[조건1 만족시 리턴값]WHEN [조건식2] THEN[조건2 만족시 리턴값] ELSE [조건 만족하지 않을시 리턴값] END AS [칼럼명]
-- CASE [대상값]WHEN [조건식1] THEN[조건1 만족시 리턴값] WHEN [조건식2] THEN[조건2 만족시 리턴값]END
--CASE 조건 WHEN 결과 THEN 출력 ****
-- TEL 지역번호 에 맞는 CASE 문 적용
SELECT TEL, SUBSTR(TEL,1,INSTR(TEL,')',1,1)-1) 지역번호,
CASE SUBSTR(TEL,1,INSTR(TEL,')',1,1)-1)
        WHEN '02' THEN '서울'
        WHEN '031' THEN '경기도'
        WHEN '051' THEN '부산'
        WHEN '053' THEN '대구'
        WHEN '033' THEN '강원도'
        ELSE 'ETC'
END 지역
FROM STUDENT;

SELECT * FROM EMP;
-- 복수행 함수 (그룹함수)****
SELECT COUNT(*), COUNT(COMM) FROM EMP;
-- SUM 함수
SELECT COUNT(COMM), SUM(COMM) FROM EMP;

-- AVG 함수 평균
SELECT COUNT(COMM), SUM(COMM), AVG(COMM) FROM EMP;
SELECT COUNT(COMM), SUM(COMM), AVG(NVL(COMM,0)) FROM EMP;
SELECT COUNT(COMM), SUM(COMM), ROUND(AVG(NVL(COMM,0)),2) FROM EMP;

-- MAX MIN
SELECT MAX(SAL), MIN(SAL) FROM EMP;

-- STDDEV VARIANCE 표준편차, 분산
SELECT ROUND(STDDEV(SAL),2) 표준편차, ROUND(VARIANCE(SAL),2) 분산 FROM EMP;

-- GROUP BY ****** 그룹화
SELECT * FROM EMP;
-- DEPTNO로 그룹화, 부서별로 그룹화
-- 그룹화한 필드는 사용가능
SELECT DEPTNO FROM EMP GROUP BY DEPTNO;

-- 부서별로 SAL 의 합계를 보겠다.
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO;

SELECT DEPTNO, SUM(SAL), ENAME FROM EMP GROUP BY DEPTNO;-- 오류 그룹이 적용된 함수만 사용가능

-- GROUP BY 의 조건절 표현
SELECT DEPTNO, SUM(SAL) 
FROM EMP
WHERE DEPTNO IN(20,30)
GROUP BY DEPTNO
HAVING SUM(SAL)>9500;

--실행순서 from where group by (그룹화)having(그룹의 조건)SELECT order by(정렬)

SELECT DEPTNO,SAL
FROM EMP
WHERE DEPTNO IN(20,30);

SELECT DEPTNO, SUM(SAL) 
FROM EMP
WHERE DEPTNO IN(20,30)
GROUP BY DEPTNO
HAVING SUM(SAL)>9000
ORDER BY DEPTNO DESC;

-- DEPTNO1과 WEIGHT를 이용한 그룹화 적용
SELECT DEPTNO1, SUM(WEIGHT)
FROM STUDENT
WHERE DEPTNO1 IN(101,102)
GROUP BY DEPTNO1
HAVING SUM(WEIGHT)>120
ORDER BY DEPTNO1 DESC;


-- 2차 그룹화
SELET * FROM EMP;
-- deptno, job 2차 그룹화
SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO;

SELECT DEPTNO, JOB, SUM(SAL), AVG(SAL), COUNT(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
HAVING COUNT(SAL)<=3
ORDER BY DEPTNO;

-- 교수테이블에서 분야별로 (deptno) 보너스를 받은 사람의 수와 보너스 합계
-- 정렬은 deptno
select deptno,count(bonus),sum(bonus)
from professor
group by deptno
order by deptno;

-- 그룹 필드를 연도로 사용
-- 년도별로 그룹화, 년도로 정렬
select to_char(hiredate,'yyyy')
from professor 
group by to_char(hiredate,'yyyy') 
order by to_char(hiredate,'yyyy');

-- 십단위 연도로 표현
select round(to_number(to_char(hiredate,'yyyy')),-1), count(pay), sum(pay)
from professor 
group by round(to_number(to_char(hiredate,'yyyy')),-1) 
order by round(to_number(to_char(hiredate,'yyyy')),-1);

-- 별칭사용
select round(to_number(to_char(hiredate,'yyyy')),-1) tenyear, count(pay), sum(pay)
from professor 
group by round(to_number(to_char(hiredate,'yyyy')),-1) tenyear
order by tenyear;

select * from student;
--jumin필드의 년도별로 묶어서 학생의 평균 키 평균 몸무게 합계키 등 표현
SELECT SUBSTR(JUMIN,1,2) YEAR, AVG(HEIGHT), AVG(WEIGHT),SUM(HEIGHT)
FROM STUDENT
GROUP BY SUBSTR(JUMIN,1,2)
ORDER BY YEAR;