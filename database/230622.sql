DROP TABLE ONE PURGE;
DROP TABLE TWO PURGE;

-- 생성과 동시에 제약조건 설정하기
CREATE TABLE ONE(
NO NUMBER CONSTRAINT PK_ONE_NO PRIMARY KEY,
NAME VARCHAR2(10));

CREATE TABLE TWO(
NUM NUMBER CONSTRAINT FK_TWO_NUM REFERENCES ONE(NO),
ADDR VARCHAR2(30)
);

-- DAY 6 230622 미션 관게ㅖ설정
-- 그림 제시
-- 서브쿼리(SUBQUERY) ***** 쿼리 속에 쿼리
-- 괄호 안의 쿼리가 먼저 실행된다.
-- SELECT * FROM EMP WHERE 조건 (SELECT SAL FROM EMP WHERE ~~~)

-- 단일행 서브쿼리
-- 서브쿼리의 결과가 단일행이다.
-- SCOTT 의 SAL 보다 작은 급여를 받는 사람의 정보를 출력하시오
SELECT * FROM EMP
WHERE ENAME='SCOTT';
SELECT * FROM EMP
WHERE SAL<3000;-- SCOTT 급여가 인상되면 잘못된 정보를 출력한다.

-- 단일행 서브쿼리
SELECT * FROM EMP
WHERE SAL<(SELECT SAL FROM EMP WHERE ENAME='SCOTT');

-- emp 테이블에서 ward 보다 comm 을 적게 받는 사람의 이름과 comm 출력
SELECT * FROM EMP
WHERE COMM<(SELECT COMM FROM EMP WHERE ENAME='WARD');

SELECT * FROM PROFESSOR;

-- PROFESSOR 테이블에서 Sharon Stone 교수의 직급과 동일한 교수중 현재 급여가 250이 안되는 교수의 급여를 20%인상
-- 직급 출력
SELECT * FROM PROFESSOR
WHERE NAME='Sharon Stone';
-- 동일한 직급 정보
SELECT * FROM PROFESSOR
WHERE POSITION=(SELECT POSITION FROM PROFESSOR
WHERE NAME='Sharon Stone') AND PAY<250;

UPDATE PROFESSOR SET PAY=PAY*1.2
WHERE POSITION=(SELECT POSITION FROM PROFESSOR
WHERE NAME='Sharon Stone') AND PAY<250;

ROLLBACK;

-- 서브쿼리 주의점
-- 1. 서브쿼리 부분은 WHERE 절의 연산자 오른쪽에 위치한다.
-- 2. 반드릿 괄호() 로 묶어야한다.
-- 3. 특별한 경우를 제외하고 서브쿼리 절에 ORDER BY는 사용 불가하다.
-- 4. 단일행 서브쿼리와 다중행 서브쿼리로 나뉜다.
-- 단일행 서브쿼리의 연산자
-- =, <> 같지않다, > , >=, <, <=

-- student 테이블과 department 테이블을 사용하여 'Anthony Hopkins' 학생과 1전공(deptno1) 이 동일한 학생들의 이름과 1전공 이름 출력
-- 'Anthony Hopkins'의 1전공
SELECT * FROM STUDENT WHERE NAME='Anthony Hopkins';
SELECT * FROM DEPARTMENT;
SELECT DEPTNO1 FROM STUDENT
WHERE NAME='Anthony Hopkins';

-- 조인 사용
SELECT S.NAME, D.DEPTNO, D.DNAME 
FROM DEPARTMENT D,STUDENT S
WHERE D.DEPTNO=S.DEPTNO1 AND S.NAME='Anthony Hopkins';

-- 서브쿼리 적용
SELECT S.NAME, S.DEPTNO1, D.DNAME 
FROM STUDENT S,DEPARTMENT D
WHERE S.DEPTNO1=D.DEPTNO AND S.DEPTNO1=(SELECT DEPTNO1 FROM STUDENT WHERE NAME='Anthony Hopkins');

-- STUDENT 테이블에서 1전공이 201번인 학과평균 몸무게보다 몸무게가 많은 학생의 이름과 몸무게 출력
-- 1전공이 201번인 학과 평균 몸무게
SELECT AVG(WEIGHT) FROM STUDENT WHERE DEPTNO1=201;
SELECT NAME, WEIGHT FROM STUDENT WHERE DEPTNO1=201 AND WEIGHT>=(SELECT AVG(WEIGHT) FROM STUDENT WHERE DEPTNO1=201);

-- 다중행 서브쿼리
-- 결과행이 2개 이상
-- IN 결과를 메인에서 모두 검색
-- EXISTS 값이 있으면
-- >ANY 최소값보다큰
-- <ANY 최대값보다 작은
-- <ALL 최소값보다 작은
-- >ALL 최대값보다 큰

SELECT SAL FROM EMP WHERE DEPTNO=20;

DROP TABLE EMP2 PURGE;

create table dept2(
dcode varchar2(6) primary key,
dname varchar2(30) not null,
pdept varchar2(6),
area varchar2(30));

INSERT INTO DEPT2 VALUES ('0001','President','','Pohang Main Office');
INSERT INTO DEPT2 VALUES ('1000','Management Support Team','0001','Seoul Branch Office');
INSERT INTO DEPT2 VALUES ('1001','Financial Management Team','1000','Seoul Branch Office');
INSERT INTO DEPT2 VALUES ('1002','General affairs','1000','Seoul Branch Office');
INSERT INTO DEPT2 VALUES ('1003','Engineering division','0001','Pohang Main Office');
INSERT INTO DEPT2 VALUES ('1004','H/W Support Team','1003','Daejeon Branch Office');
INSERT INTO DEPT2 VALUES ('1005','S/W Support Team','1003','Kyunggi Branch Office');
INSERT INTO DEPT2 VALUES ('1006','Business Department','0001','Pohang Main Office');
INSERT INTO DEPT2 VALUES ('1007','Business Planning Team','1006','Pohang Main Office');
INSERT INTO DEPT2 VALUES ('1008','Sales1 Team','1007','Busan Branch Office');
INSERT INTO DEPT2 VALUES ('1009','Sales2 Team','1007','Kyunggi Branch Office');
INSERT INTO DEPT2 VALUES ('1010','Sales3 Team','1007','Seoul Branch Office');
INSERT INTO DEPT2 VALUES ('1011','Sales4 Team','1007','Ulsan Branch Office');

create table emp2(
empno number primary key,
name varchar2(30) not null,
birthday date,
deptno varchar2(6) not null,
emp_type varchar2(30),
tel varchar2(15),
hobby varchar2(30),
pay number,
position varchar2(30),
pempno number);

INSERT INTO EMP2 VALUES (19900101,'Kurt Russell',TO_DATE('19640125','YYYYMMDD'),'0001','Permanent employee','054)223-0001','music',100000000,'Boss',null);
INSERT INTO EMP2 VALUES (19960101,'AL Pacino',TO_DATE('19730322','YYYYMMDD'),'1000','Permanent employee','02)6255-8000','reading',72000000,'Department head',19900101);
INSERT INTO EMP2 VALUES (19970201,'Woody Harrelson',TO_DATE('19750415','YYYYMMDD'),'1000','Permanent employee','02)6255-8005','Fitness',50000000,'Section head',19960101);
INSERT INTO EMP2 VALUES (19930331,'Tommy Lee Jones',TO_DATE('19760525','YYYYMMDD'),'1001','Perment employee','02)6255-8010','bike',60000000,'Deputy department head',19960101);
INSERT INTO EMP2 VALUES (19950303,'Gene Hackman',TO_DATE('19730615','YYYYMMDD'),'1002','Perment employee','02)6255-8020','Marathon',56000000,'Section head',19960101);
INSERT INTO EMP2 VALUES (19966102,'Kevin Bacon',TO_DATE('19720705','YYYYMMDD'),'1003','Perment employee','052)223-4000','Music',75000000,'Department head',19900101);
INSERT INTO EMP2 VALUES (19930402,'Hugh Grant',TO_DATE('19720815','YYYYMMDD'),'1004','Perment employee','042)998-7005','Climb',51000000,'Section head',19966102);
INSERT INTO EMP2 VALUES (19960303,'Keanu Reeves',TO_DATE('19710925','YYYYMMDD'),'1005','Perment employee','031)564-3340','Climb',35000000,'Deputy Section chief',19966102);
INSERT INTO EMP2 VALUES (19970112,'Val Kilmer',TO_DATE('19761105','YYYYMMDD'),'1006','Perment employee','054)223-4500','Swim',68000000,'Department head',19900101);
INSERT INTO EMP2 VALUES (19960212,'Chris O''Donnell',TO_DATE('19721215','YYYYMMDD'),'1007','Perment employee','054)223-4600',null,49000000,'Section head',19970112);
INSERT INTO EMP2 VALUES (20000101,'Jack Nicholson',TO_DATE('19850125','YYYYMMDD'),'1008','Contracted Worker','051)123-4567','Climb', 30000000,'',19960212);
INSERT INTO EMP2 VALUES (20000102,'Denzel Washington',TO_DATE('19830322','YYYYMMDD'),'1009','Contracted Worker','031)234-5678','Fishing', 30000000,'',19960212);
INSERT INTO EMP2 VALUES (20000203,'Richard Gere',TO_DATE('19820415','YYYYMMDD'),'1010','Contracted Worker','02)2345-6789','Baduk', 30000000,'',19960212);
INSERT INTO EMP2 VALUES (20000334,'Kevin Costner',TO_DATE('19810525','YYYYMMDD'),'1011','Contracted Worker','053)456-7890','Singing', 30000000,'',19960212);
INSERT INTO EMP2 VALUES (20000305,'JohnTravolta',TO_DATE('19800615','YYYYMMDD'),'1008','Probation','051)567-8901','Reading book', 22000000,'',19960212);
INSERT INTO EMP2 VALUES (20006106,'Robert De Niro',TO_DATE('19800705','YYYYMMDD'),'1009','Probation','031)678-9012','Driking',   22000000,'',19960212);
INSERT INTO EMP2 VALUES (20000407,'Sly Stallone',TO_DATE('19800815','YYYYMMDD'),'1010','Probation','02)2789-0123','Computer game', 22000000,'',19960212);
INSERT INTO EMP2 VALUES (20000308,'Tom Cruise',TO_DATE('19800925','YYYYMMDD'),'1011','Intern','053)890-1234','Golf', 20000000,'',19960212);
INSERT INTO EMP2 VALUES (20000119,'Harrison Ford',TO_DATE('19801105','YYYYMMDD'),'1004','Intern','042)901-2345','Drinking',   20000000,'',19930402);
INSERT INTO EMP2 VALUES (20000210,'Clint Eastwood',TO_DATE('19801215','YYYYMMDD'),'1005','Intern','031)345-3456','Reading book', 20000000,'',19960303);
COMMIT;

SELECT * FROM EMP2;
SELECT * FROM DPET2;

-- EMP2 테이블과 DEPT2 테이블을 참조하여
-- 근무지역( DEPT2테이블의 AREA 칼럼 )이 'Pohang Main Office'인 모든 사원들의 사번과 이름. 부서번호 출력
SELECT DCODE FROM DEPT2
WHERE AREA='Pohang Main Office';

SELECT EMPNO, NAME, DEPTNO FROM EMP2 WHERE DEPTNO IN(0001,1003,1006,1007);

SELECT EMPNO, NAME, DEPTNO FROM EMP2 WHERE DEPTNO IN(
SELECT DCODE FROM DEPT2 WHERE AREA='Pohang Main Office');

-- EMP2 테이블에서 전체 직원중 'Section head' 직급의 최소 연봉자보다 연봉이 높은 사람의 이름과 직급, 연봉 출력
SELECT pay FROM EMP2 WHERE position='Section head';

SELECT NAME, PAY, POSITION FROM EMP2 WHERE PAY>49000000;

-- 최소값 보다 큰
SELECT NAME, PAY, POSITION FROM EMP2 WHERE PAY>ANY(SELECT pay FROM EMP2 WHERE position='Section head');

-- 반대개념 적용
-- 최대값보다 작은
SELECT NAME, PAY, POSITION FROM EMP2 WHERE PAY<ANY(SELECT pay FROM EMP2 WHERE position='Section head');

-- 최소값보다 작은
SELECT NAME, PAY, POSITION FROM EMP2 WHERE PAY<ALL(SELECT pay FROM EMP2 WHERE position='Section head');

-- 최대값보다 큰
SELECT NAME, PAY, POSITION FROM EMP2 WHERE PAY>ALL(SELECT pay FROM EMP2 WHERE position='Section head');

-- EXIST 활용 -- 결과값이 하나라도 있으면 실행하고 아니면 실행되지않음
SELECT * FROM DEPT WHERE DEPTNO=20;

SELECT * FROM DEPT WHERE EXISTS(SELECT * FROM DEPT WHERE DEPTNO=30);


-- 다중 칼럼 서브쿼리
select * from student;
-- 학년별로 최대 몸무게
SELECT GRADE, MAX(WEIGHT)
FROM STUDENT
GROUP BY GRADE;

-- 학년별로 뭄무게가 제일 많이 나가는 학생의 이름, 몸무게 출력
SELECT GRADE, NAME,WEIGHT
FROM STUDENT
WHERE (GRADE, WEIGHT) IN(
SELECT GRADE, MAX(WEIGHT)
FROM STUDENT
GROUP BY GRADE
);

-- professor, department 테이블에서 각 학과별로 입사일이 가장 오래된 교수의 교수번호와 이름, 학과명 출력
SELECT * FROM PROFESSOR;
-- 학과별로 입사일이 가장 오래된 교수
SELECT DEPTNO, MIN(HIREDATE)
FROM PROFESSOR  GROUP BY DEPTNO ORDER BY DEPTNO;

-- 교수번호와 이름, 학과명 출력
SELECT P.PROFNO, P.NAME, D.DNAME
FROM PROFESSOR P, DEPARTMENT D
WHERE P.DEPTNO=D.DEPTNO;

SELECT P.PROFNO, P.NAME, D.DNAME
FROM PROFESSOR P, DEPARTMENT D
WHERE P.DEPTNO=D.DEPTNO
AND(P.DEPTNO, P.HIREDATE)
IN(SELECT DEPTNO, MIN(HIREDATE)
FROM PROFESSOR  GROUP BY DEPTNO)ORDER BY P.DEPTNO;


-- 시스템에서 유저 생성하기
show user; -- 어떤 유저로 접속됐는지 확인
CONN SYSTEM;
-- 사용자 만들기
create user blue IDENTIFIED by 123456;
-- 권한 설정
GRANT CONNECT, RESOURCE, DBA TO BLUE;
conn system;
conn blue;

CREATE TABLE AA(
AA NUMBER,
NAME VARCHAR2(10)
);

-- 사용자 삭제
REVOKE CONNECT,DBA,RESOURCE FROM blue;
DROP USER blue CASCADE;
DROP TABLE AA;


-- VIEW 활용
SELECT * FROM DEPP;

-- 뷰란 가상 테이블을 의미한다
-- 원래 테이블은 데이터가 들어있지만 뷰에는 데이터가 없고 원본 테이블에서 데이터를 불러오는 쿼리만 존재
-- 일반적으로 데이터를 조회할 목적으로 사용**
CREATE VIEW AVIEW
AS
SELECT EMPNO, ENAME HIREDATE FROM EMP;

SELECT * FROM AVIEW;

-- 뷰 삭제
DROP VIEW AVIEW;

CREATE TABLE O_TABLE(
A NUMBER,
B NUMBER
);

-- 뷰에 데이터를 넣으면 o_table에도 들어감
SELECT * FROM O_TABLE;
SELECT * FROM VIEW1;
-- O_TABLE 형식으로 뷰 만들기
CREATE VIEW VIEW1
AS
SELECT A, B FROM O_TABLE;

-- VIEW1에 데이터 입력
INSERT INTO VIEW1 VALUES(1,2);
INSERT INTO o_table VALUES(1,2);

rollback;

-- VIEW2 생성
CREATE VIEW VIEW2
AS
SELECT A,B
FROM O_TABLE
WITH READ ONLY;
INSERT INTO VIEW2 VALUES(3,4);-- READONLY라 INSERT 안됨
INSERT INTO o_table VALUES(7,8);
select * from view2; -- 읽기 가능

-- view3 생성
CREATE VIEW VIEW3
AS
SELECT A,B
FROM O_TABLE
where a=5
WITH check option;

insert into view3 values(3,4);-- 불능
insert into view3 values(5,6);-- 가능 a가 5인 값만 허용
insert into view3 values(5,7);-- 가능 a가 5인 값만 허용
select * from view3;

update view3 set a=50;

-- view join과 함께 활용
-- emp dept 테이블 조인 결과를 view 로 생성

select * from emp;
select * from dept;

create view empdeptview
AS
select e.empno, e.ename, e.job, d.dname
from emp e inner join dept d
on e.deptno=d.deptno
order by e.ename;

select * from empdeptview;
select * from empdeptview where empno=7499;

update emp
set job='clerk2222'
where ename ='ADAMS';

-- SEQUENCE 시퀀스 ***** 자동 증가
CREATE TABLE S_ORDER(
ord_no number(4),
ord_name varchar2(10),
p_name varchar2(20),
p_qty number
);

insert into s_order values(1,'ja', 'apple', 5);
insert into s_order values(2,'ja', 'apple', 5);
insert into s_order values(3,'ja', 'apple', 5);

select * from s_order;

rollback;

--시퀀스 생성
-- 위 테이블에 데이터 입력해서 활용

--       INCREMENT BY 1 -- 증가값
--       START WITH 1 -- 시작값
--       MINVALUE 1 -- 최소값
--       MAXVALUE 100 -- 최대값 
--       NOCYCLE -- 최대값 도달시 시작값부터 다시 반복
--       NOCACHE --cache 사용 여부
--       NOORDER; -- 요청 순서대로 값 생성할지 여부
create sequence s_orderno_seq
increment by 1
start with 100
maxvalue 110
minvalue 90
cycle
CACHE 2; -- 캐시 사이즈를 뛰어 넘어 시작한다
select * from s_order;
insert into s_order values(
s_orderno_seq.nextval, 'ja', 'apple', 5
);

select s_orderno_seq.currval from dual; -- 현재 시퀀스변화확인

/
begin
    for i in 1..100 loop
        insert into s_order values(s_orderno_seq.nextval, 'ja', 'apple', 5);
    end loop;
end;
/

-- 게시판 용 테이블에 적용
create table board1(
num number,-- 글번호 
title varchar2(100), -- 글제목
memo varchar2(300)
);

create sequence board1_seq;

/
begin
    for i in 1..100 loop
        insert into board1 values(board1_seq.nextval, 'ja', 'apple');
    end loop;
end;
/

-- 시퀀스 검색
select * from user_sequences where sequence_name='BOARD1_SEQ';

select * from board1;
delete from board1;
-- 시퀀스 수정
alter sequence board1_seq
increment by 2;

DESC user_sequences;

--시퀀스 초기화
/
create or replace procedure re_seq
(
    SNAME in varchar2
)
is
    VAL number;
begin
    EXECUTE IMMEDIATE 'SELECT ' || SNAME || '.NEXTVAL FROM DUAL ' INTO  VAL;
   EXECUTE IMMEDIATE 'ALTER SEQUENCE ' || SNAME || ' INCREMENT BY -' || VAL || ' MINVALUE 0';
   EXECUTE IMMEDIATE 'SELECT ' || SNAME || '.NEXTVAL FROM DUAL ' INTO VAL;
   EXECUTE IMMEDIATE 'ALTER SEQUENCE ' || SNAME || ' INCREMENT BY 1 MINVALUE 0';    
end;
/
;

select board1_seq.CURRVAL FROM DUAL;
exec re_seq('BOARD1_SEQ');

drop sequence BOARD1_SEQ;