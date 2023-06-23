-- 230623 DAY7& 45

create table addrmemo(
ano number,
aname varchar2(20),
addr varchar2(100),
atel varchar2(100)
);

create sequence ano_seq;

INSERT INTO ADDRMEMO VALUES(ANO_SEQ.NEXTVAL,'김리연', '서울시 도봉구 도봉도봉', '010-0000-0000');
/
begin
    for i in 0..5 loop
        INSERT INTO ADDRMEMO VALUES(ANO_SEQ.NEXTVAL,CONCAT('김리연',i+1), CONCAT('서울시 도봉구 도봉도봉',i+1), '010-0000-0000');
    end loop;
end;
/

SELECT * FROM ADDRMEMO;

-- --------------------------------------------------------------------
-- 저장 프로시저
-- precedure pl/sql (procedure laguage / sql ) 오라클에서 제공하는 프로그래밍 언어

create table board2(
bid number,
btitle varchar2(30),
bcontent varchar2(100),
bwriter varchar2(20),
bstep number
);

desc board2;
-- 시퀀스 만들기
create sequence board2_seq;
-- 시퀀스 삭제
drop sequence board2_seq;

select board2_seq.currval from dual;
select board2_seq.nextval from dual;

-- 데이터 입력
insert into board2 values(board2_seq.nextval, 'big data', '빅데이터 전망', 'hong1', 3);

select * from board2;
commit;

-- buffer 에 메세지가 출력되도록
set serveroutput on;
--기본적으로 PL/SQL은 결과물을 보여주지 않는다.

--결과물을 보고 싶다면 SERVEROUTPUT 설정 을 ON 으로 설정해 주어야 한다.
-- 프로시저로 적용하면서 이해해보자..
insert into board2 values(board2_seq.nextval, 'big data', '빅데이터 전망', 'hong1', 3);

/
create or replace procedure brd2_insert(
    title varchar2, 
    bcontent varchar2, 
    writer varchar2,
    step NUMBER
)
is
begin
    insert into board2 values(board2_seq.nextval, title, bcontent, writer, step);
    dbms_output.put_line(title || ',' || writer); -- 콘솔창처럼 확인하기
end;
/
;
-- 프로시저 실행
exec brd2_insert('big data2', 'bbbbbbbbbbbbbb5','hong5',5);

-- 미션
-- emp 테이블 적용
select * from emp;
desc emp;
INSERT INTO EMP VALUES(9000,'KIM','CLERK',NULL,TO_DATE('23-06-2023','dd-mm-yyyy'),7000,NULL,10);

/
create or replace procedure emp_insert(
    NO NUMBER, NAME VARCHAR2,
    JOB VARCHAR2, MGR NUMBER, 
    HIREDATE DATE, SAL NUMBER, 
    COMM NUMBER, DEPTNO NUMBER
)
is
begin
    insert into EMP values(NO, NAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO);
end;
/
;

EXEC EMP_INSERT(9001,'KIM','CLERK',NULL,SYSDATE,7000,NULL,10);

-- 실행결과를화면에출력해주기위해 ON한다.
SET SERVEROUTPUT ON;
/
BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO');
END;
/
;

-- 업데이트 프로시저
/
create or replace procedure emp_update(
    salname varchar2
)
is
begin
    update emp set sal = 30000 where ename=salname;
    DBMS_OUTPUT.PUT_LINE(salname);
end;
/
;
exec emp_update('FORD');
update emp set sal = 10000 where ename='FORD';

-- select 프로시저 만들기
select * from employees;

-- 날짜에서 특정 정보 추출
select extract(year from hire_date) 년도, hire_date from employees;

select employee_id, last_name, hire_date
from employees
where extract(year from hire_date)=2003;


-- 프로시저 이름 yearselect
/
create or replace procedure yearselect(p_year number)
is
-- 변수 선언 %type은 기존에 만들어져있는테이블의 타입을 여기에 적용해서 사용하겠다.
    id employees.employee_id%type;
    name employees.last_name%type;
    hiredate employees.hire_date%type;
    
begin
    select employee_id, last_name, hire_date
    -- into절 필요
    into id,name,hiredate
    from employees
    where extract(year from hire_date)=p_year;
    dbms_output.put_line(id || ',' || name);
end;
/

exec yearselect(2001);-- 한개의 레코드라 나옴
exec yearselect(2001);-- 여러개의 레코드는 불가능함


-- step 2
/
create or replace procedure yearselect(p_year number)
is
-- 변수 선언 (%rowtype  : 객체 자체의 타입을 그대로 쓰겠다.)
    emp employees%rowtype; -- 테이블 통으로 타입 가져오기
-- 커서 등록
    cursor emp_cur is select employee_id, last_name, hire_date
    from employees
    where extract(year from hire_date)=p_year;
begin
    loop
    
    end loop
    dbms_output.put_line(id || ',' || name);
end;
/
;
-- step 3
/
create or replace procedure yearselect2(p_year number)
is
-- 변수 선언 (%rowtype  : 객체 자체의 타입을 그대로 쓰겠다.)
    emp employees%rowtype; -- 테이블 통으로 타입 가져오기
-- 커서 등록
    cursor emp_cur is select employee_id, last_name, hire_date
    from employees
    where extract(year from hire_date)=p_year;
begin
    -- 커서 오픈
    open emp_cur;
    loop
    -- 데이터 읽기 커서를 읽어서 데이터로 저장해주겠음
        fetch emp_cur into emp.employee_id,emp.last_name,emp.hire_date;
        EXIT WHEN emp_cur%NOTFOUND; -- 데이터가 모두 종료되면 끝내겠음
            dbms_output.put_line(emp.employee_id || ',' || emp.last_name || emp.hire_date);
    end loop;
    -- 커서 종료
    close emp_cur;
end;
/
exec yearselect2(2001);
exec yearselect2(2003); 


-- ALTER *******
-- 테이블과 같은 데이터 구조를 정의하는데 사용되는 명령어들로 (생성, 변경, 삭제, 이름변경)
-- 데이터 구조와 관련된 명령어들을 말함
create table users(
deptname varchar2(50) not null,
username varchar2(50),
id number primary key,
salary number
);

insert into users values('영업팀', '김영업',101,5000000);
insert into users values('영업팀', '박영업',102,5000000);
insert into users values('영업팀', '박인사',103,5000000);
insert into users values('영업팀', '최영업',104,5000000);
insert into users values('영업팀', '김총무',105,5000000);

select * from users;

-- 테이블 이름 변경
alter table users rename to username;
alter table username rename to users;

-- 칼럼 추가
alter table users add(addr varchar2(1000));
desc users;

alter table users add(point number);

-- 칼럼 삭제
alter table users drop column addr;
alter table users drop column point;

select * from users; 
-- 칼럼 이름 변경
-- salary -> sal
alter table users rename column salary to sal;

-- sal -> pay
alter table users rename column sal to pay;


-- 칼럼의 타입 변경
alter table users modify sal varchar2(20);
alter table users modify sal number;


-- username의 타입 변경
desc users;
alter table users modify username varchar2(255);
alter table users modify username varchar2(50);

delete from users;

-- 서브쿼리 from 절에 사용하기
CREATE TABLE SALGRADE
        (GRADE NUMBER,
         LOSAL NUMBER,
         HISAL NUMBER);

INSERT INTO SALGRADE VALUES (1,  700, 1200);
INSERT INTO SALGRADE VALUES (2, 1201, 1400);
INSERT INTO SALGRADE VALUES (3, 1401, 2000);
INSERT INTO SALGRADE VALUES (4, 2001, 3000);
INSERT INTO SALGRADE VALUES (5, 3001, 9999); 
COMMIT;
SELECT * FROM SALGRADE;

-- from 절에도 사용 가능
select * from emp where deptno=10;

select e10.empno, e10.ename, e10.deptno
from(select * from emp where deptno=10) e10;

-- join 적용
select   e10.empno, e10.ename, e10.deptno, d.dname, d.loc
from(select * from emp where deptno=10) e10,
(select * from dept) d
where e10.deptno=d.deptno;

-- select 절에 사용하기
-- 평점매길때사용할수있다.
select grade from salgrade
where e.sal between losal and hisal;
select * from salgrade;
select * from emp;

select empno, ename, (select grade from salgrade
where e.sal between losal and hisal) as salgrade
from emp e;

