-- ------------------------------------------------------------------------------------
-- NULL 조회
-- ------------------------------------------------------------------------------------
select * from emp;
select * from emp where comm is null;
select * from emp where mgr is null;

-- ------------------------------------------------------------------------------------
-- null이 아닌 값 조회
-- ------------------------------------------------------------------------------------
select * from emp where comm is not null;

-- 입사일이 82.1.1이후, sal 이 1300이상인 사원의 정보 조회
select * from emp where sal >=1300 and hiredate>='1982-01-01';
-- 급여가 1000초과하고 커미션이 1000미만이거나 커미션이 null인 사번, 이름, 급여, 커미션 조회
select empno, ename, sal, comm from emp where sal>1000 and (comm<1000 OR comm is null);


-- ------------------------------------------------------------------------------------
-- ROLLBACK 커밋 전에 처리
-- ------------------------------------------------------------------------------------
INSERT INTO EMP VALUES(8000,'SMITH','CLERK',7902,TO_DATE('17-12-1980','dd-mm-yyyy'),800,NULL,20);
INSERT INTO EMP VALUES(8001, 'MILLER', 'CLERK',     7782, TO_DATE('23-01-1982', 'DD-MM-YYYY'), 1300, NULL, 10);
-- rollback 을 하면 위에 인서트 한 내용이 사라짐
delete from emp where empno in(8000,8001);
rollback;
commit;-- 커밋을 하고나서는 롤백 안됨

@C:\javabigset2023\oracle\stuprodep.sql; -- 외부 데이터 import
select * from student;
select count(*) from student;
select * from department;
select * from professor;


select * from emp;
select * from dept;
-- ------------------------------------------------------------------------------------
-- union 합집합;
-- ------------------------------------------------------------------------------------
select studno AS "pno sno", name, deptno1,1 from student where deptno1=101
union -- 중복값 배제
select profno, name, deptno,2 from professor where deptno=101;

-- ------------------------------------------------------------------------------------
-- union all
-- ------------------------------------------------------------------------------------
select studno AS "pno sno", name, deptno1,1 from student where deptno1=101
union all -- 모두 출력
select profno, name, deptno,2 from professor where deptno=101;
-- 차이나는 데이터
select studno, name
from student
where deptno1=101
union 
select studno, name
from student
where deptno2=201;

select studno, name
from student
where deptno1=101
union all
select studno, name
from student
where deptno2=201;
-- ------------------------------------------------------------------------------------
-- 교집합 intersect
-- ------------------------------------------------------------------------------------
select studno, name
from student
where deptno1=101
intersect
select studno, name
from student
where deptno2=201;
-- ------------------------------------------------------------------------------------
-- 차집합 minus
-- ------------------------------------------------------------------------------------
select studno, name
from student
where deptno1=101
minus
select studno, name
from student
where deptno2=201;

desc emp;
desc dept;

-- emp 에서 minus를 이용해 급여가 2500달러 이하인 사람의 급여를 10% 인상하기
select ename, (sal*1.1),sal job from emp
minus
select ename, (sal*1.1),sal job from emp where sal>2500;
-- 사용상 주의점 : 칼럼의 갯수와 타입이 일치해야한다.

-- 문법순서
-- select
-- from
-- where
-- group by -- 그룹화
-- having -- 그룹화 조건
-- order by -- 정렬
-- 실행순서
-- from
-- where
-- group by
-- having
-- order by

-- order by 정렬 오름차순(ASC) 내림차순(DESC)
SELECT * FROM EMP ORDER BY ENAME ASC;-- 오름차순 기본값이 어센딩
SELECT * FROM EMP ORDER BY ENAME DESC; -- 내림차순

-- 여러 필드에 적용 
-- JOB 에 오름차순, EMPNO에 내림차순
SELECT * FROM EMP ORDER BY JOB ASC, EMPNO DESC;-- 1차 정렬된 범위 안에서 2차 정렬이 이루어짐
SELECT * FROM EMP ORDER BY JOB, EMPNO DESC;-- 1차 정렬 2차 정렬 ASC 는 기본값이라 생략 가능
--SELECT * FROM EMP ORDER BY EMPNO ASC, JOB DESC;-- EMPNO는 PK라 의미 없음 부분그룹이 되어질수있는 필드를 1차 정렬로 묶는다.

-- DEPTNO DESC 1차 SAL ASC 2차
SELECT * FROM EMP ORDER BY DEPTNO DESC, SAL;
-- 조건 20, 30 만 포함되게
SELECT * FROM EMP WHERE DEPTNO IN(20,30) ORDER BY DEPTNO DESC, SAL;


-- 교수 테이블에서 이름의 첫글자가 M이거나 부서번호가 102인 데이터를 교수번호로 내림차순하여 교수번호,이름,아이디,부서번호,이메일을 출력하시요
SELECT PROFNO, NAME, ID, DEPTNO, EMAIL 
FROM PROFESSOR 
WHERE NAME like 'M%' OR DEPTNO=102 
ORDER BY PROFNO DESC;

-- 단일행 함수 한번에 하나씩 처리하는 함수
--INITCAP 첫글자만 대문자로
SELECT ENAME, INITCAP(ENAME) FROM EMP WHERE DEPTNO=10;
-- 교수 테이블에서 이름에 첫글자만 대문자 적용
SELECT NAME, INITCAP(NAME) FROM PROFESSOR WHERE DEPTNO=101;

-- LOWER 소문자 UPPER 대문자
SELECT ENAME, LOWER(ENAME) LOWERNAME, UPPER(ENAME) UPPERNAME FROM EMP;

-- LENGTH 문자길이
SELECT ENAME, LENGTH(ENAME) FROM EMP;
-- LENGTHB 한글 길이 BYTE SIZE
SELECT ENAME, LENGTHB(ENAME) FROM EMP;

SELECT '홍길동', LENGTH('홍길동'), LENGTHB('홍길동'), LENGTHB('金') FROM DUAL;

-- CONCAT 함수 문자열 연결
-- SMITH, CLECK
SELECT CONCAT(CONCAT(ENAME,'의 직업은 '),JOB) FROM EMP;

-- SUBSTR 문자열 특정길이 추출 ****
--SUBSTR(문자열,위치,글자갯수)
SELECT 'ABCDEFG',SUBSTR('ABCDEFG',3) FROM DUAL;-- 글자갯수 생략은 끝까지 출력하도록
SELECT 'ABCDEFG',SUBSTR('ABCDEFG',3,2) FROM DUAL;-- 위치에서 갯수만큼 출력
SELECT 'ABCDEFG',SUBSTR('ABCDEFG',-3,2) FROM DUAL;-- 뒤에서 3번째 위치에서 갯수만큼
SELECT 'ABCDEFG',SUBSTR('ABCDEFG',-3,4) FROM DUAL;-- 뒤에서 3번쨰 위치에서 갯수만큼

-- EMP 테이블에 적용
-- ENAME, JOB
SELECT ENAME, SUBSTR(ENAME,2,3),JOB, SUBSTR(JOB,2,3) FROM EMP;
-- 위 내용을 소문자로 변환
SELECT ENAME, LOWER(ENAME),JOB, LOWER(JOB) FROM EMP;

-- INSTR 특정 문자열 위치값 반환 ***
-- INSTR('문자열', '찾는문자', 찾는 시작 위치, 찾는 문자 번째) 찾는 문자가 가장 첫번째에 위치하는 숫자를 리턴 
SELECT 'A-B-C-D' FROM DUAL;
SELECT 'A-B-C-D' , INSTR('A-B-C-D', '-',1,2) FROM DUAL;-- 처음부터 '-' 를 찾아서 두번 째 나오는 위치 
SELECT 'A-B-C-D' , INSTR('A-B-C-D', '-',3,2) FROM DUAL;-- 3번쨰부터 '-' 를 찾아서 두번 째 나오는 위치 
SELECT 'A-B-C-D' , INSTR('A-B-C-D', '-',3,5) FROM DUAL;-- 찾는 결과가 없을 때 0으로 리턴


SELECT TEL, SUBSTR(TEL,1,INSTR(TEL,')',1,1)-1) 지역번호 FROM STUDENT;
--EMAIL의 아이디만 추출 
SELECT EMAIL, SUBSTR(EMAIL,1,INSTR(EMAIL,'@',1,1)-1) FROM PROFESSOR;

-- LPAD 왼쪽에 채운다.
--LPAD(문자,문자길이,대체할문자)
SELECT NAME, ID FROM STUDENT WHERE DEPTNO1=201;
SELECT NAME, ID,LPAD(ID,10,'*') FROM STUDENT WHERE DEPTNO1=201;
-- 1234MOORE LPAD적용
SELECT NAME, ID,LPAD(ID,10,'123456789') FROM STUDENT WHERE DEPTNO1=201;

--RPAD 오른쪽에 채운다.
SELECT ENAME,RPAD(ENAME,10,'-') FROM EMP WHERE DEPTNO=10;
SELECT ENAME,RPAD(ENAME,10,'123456789') FROM EMP WHERE DEPTNO=10;


-- 변형 SMITH12345-> SMITH56789
-- RPAD, SUBSTR,LENGTH
SELECT ENAME,RPAD(ENAME,10,SUBSTR('123456789',6)) FROM EMP WHERE ENAME='MILLER';
SELECT ENAME,RPAD(ENAME,10,SUBSTR('123456789',4)) FROM EMP WHERE ENAME='FORD';

SELECT ENAME,RPAD(ENAME,10,SUBSTR('123456789',LENGTH(ENAME))) FROM EMP;
