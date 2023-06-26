-- 46일차 오라클 DAY8 230626
-- 프로시저 2
-- 프로시저의 조건문과 반복문 
-- if문
-- 실행결과를화면에출력해주기위해 ON한다.
SET SERVEROUTPUT ON;
/
declare
    vnum number:=16;
begin
    if mod(vnum,2)=1 then
        dbms_output.put_line(vnum || '는 홀수');
    else
        dbms_output.put_line(vnum || '는 짝수');
    end if;
end;
/

-- case
/
declare
    vnum number:=95;
begin
    case
        when vnum>=90 then dbms_output.put_line(vnum || ' : A등급');
        when vnum>=80 then dbms_output.put_line(vnum || ' : B등급');
        when vnum>=70 then dbms_output.put_line(vnum || ' : C등급');
        when vnum>=60 then dbms_output.put_line(vnum || ' : D등급');
        
    end case;
end;
/

-- loop 문
/
declare
    vnum number:=0;
begin
    loop
        dbms_output.put_line('현재 vnum : ' || vnum);
        vnum:=vnum+1;
        exit when vnum>5;
    end loop;
end;
/

-- while 문
/
declare
    vnum number:=0;
begin
    while vnum<5 loop
        dbms_output.put_line('현재 while vnum : ' || vnum);
        vnum:=vnum+1;
    end loop;
end;
/

-- for문
/
declare
begin
    for i in 0..5 loop
    dbms_output.put_line('현재 for vnum : ' || i);
    end loop;
end;
/

select dname from dept where deptno=10;

-- 예외
-- dname 은 number  타입이 아니기 때문에 예외 발생
/
declare
    vwrong number;
begin
    select dname into vwrong
    from dept where deptno=10;
    dbms_output.put_line('예외 발생하고 실행될까요? ');
exception
    when value_error then
        dbms_output.put_line('예외 발생 ');
end;
/

-----------------------------
-- join 보충
-- 테이블 3개
create table student2(
no number,
name varchar2(15),
subject_id number,
score number);

create table grade(
grade char(4),
min_score number,
max_score number);

create table subject(
subject_id number,
subject_name varchar2(30));

insert into subject values(10,'Computer Enginnerring');
insert into subject values(20,'Music');
insert into subject values(30,'English');
insert into subject values(40,'History');
insert into subject values(50,'Math');
commit;

insert into student2 values(1000,'James',10,98);
insert into student2 values(1001,'Ford',10,91);
insert into student2 values(1002,'Allen',20,89);
insert into student2 values(1003,'Steve',30,83);
insert into student2 values(1004,'Miller',40,78);
commit;

insert into grade values('A+',96,100);
insert into grade values('A0',90,95);
insert into grade values('B+',86,89);
insert into grade values('B0',80,85);
insert into grade values('C+',76,79);
insert into grade values('C0',70,75);
insert into grade values('D+',66,69);
insert into grade values('D0',60,65);
insert into grade values('F',0,64);

commit;


select * from student2;
select * from grade;
select * from subject;

delete from student2;
delete from grade;
delete from subject;

-- 등가 조인
-- equip join 테이블 두개
select s.name,b.subject_name
from student2 s join subject b
on s.subject_id = b.subject_id;

-- 3개 테이블 조인
-- 점수별로 등급(grade 테이블의 grade) 표현
-- ansi 조인
select s.name,b.subject_name, s.score, g.grade
from student2 s join subject b
on s.subject_id = b.subject_id
join grade g
on s.score between g.min_score and g.max_score ;

-- oracle 조인
select s.name,b.subject_name, s.score, g.grade
from student2 s ,subject b,grade g
where s.subject_id = b.subject_id
and s.score between g.min_score and g.max_score ;

-- ---------------------------------------------------------------
-- self 조인
select * from emp;
delete from emp where empno=9000;
commit;

-- smith 의 사수 이름은 ford 조인 처리
SELECT E1.EMPNO, E1.ENAME, E2.ENAME 매니저이름
FROM EMP E1, EMP E2
WHERE E1.MGR=E2.EMPNO;

-- trigger 방아쇠처럼 신호감지하고 그 신호에 반응해서 동작하는 쿼리를 말한다.
-- 특정 테이블에 삽입, 수정, 삭제 등의 데이터 변경 이벤트가 발생하면 dbms에서 자동적으로 실행되도록 구현된 프로그램
-- 전체 트랜잭션 대상과 각행에 의해 발생되는 경우 모두를 포함할 수 있고 테이블과 뷰, DB 작업을 대상으로 정의 할 수 있음
create table test01(
no number not null,
name varchar2(10),
a number,
b number
);

select * from test01;

insert into test01 values(1,'A',10,20);

create table test02
as
select * from test01;

select * from test02; -- 트리거를 실행하면 test01 데이터가 들어옴

delete from test01;
delete from test02;


commit;

--insert 트리거 만들기
/
create or replace trigger in_test02
    after insert on test01
    for each row
declare
-- 변수선언
begin
    insert into test02 values(:new.no, :new.name,:new.a,:new.b);
end;
/

insert into test01 values(1,'A',10,20);-- 트리거 in_test02가 test01의 insert 신호를 받아 동작
insert into test01 values(300,'A',100,200);


-- trigger 삭제
drop trigger in_test02;

-- delete 트리거 만들기
/
create or replace trigger del_test02
    after delete on test01
    for each row
declare
-- 변수선언
begin
    delete test02 where no=:old.no;
end;
/

select * from test01;
select * from test02;
delete from test01 where no=1;

-- update 트리거 만들기
/
create or replace trigger up_test02
    after update on test01
    for each row
declare
-- 변수선언
begin
    update test02 set no=:new.no where no=:old.no;
end;
/

delete from test01;
select * from test01;
select * from test02;

update test01
set no=50
where no=1;

-- 트리거 통합
/
create or replace trigger t_indelup_test02
    after insert or delete or update on test01
    for each row
declare
-- 변수선언
begin
    if inserting then
        insert into test02 values(:new.no, :new.name,:new.a,:new.b);
    elsif deleting then
        delete test02 where no=:old.no;
    elsif updating then
        update test02 set no=:new.no where no=:old.no;
    end if;
end;
/

drop trigger del_test02;
drop trigger in_test02;
drop trigger up_test02;

insert into test01 values(1,'A',10,20);-- 트리거 in_test02가 test01의 insert 신호를 받아 동작
insert into test01 values(300,'A',100,200);

delete from test01;
delete from test02;

select * from test01;
select * from test02;

update test01
set no=50
where no=300;

-- -------------------------------------
-- 데이터가 위치한 장소의 정보를 가진 일종의 주소록, 데이터의 주소(ROWID) 를 가지고 있음
-- 빠르게 데이터 작업을 하기 위한 방법으로 사용 되고 있따.
-- 추가적인 쓰기 작업과 저장 공간을 활용하여 데이터베이스 테이블의 검색 속도를 향상시키기 위한 자료구조
--index  : 쿼리의 결과값을 효율적으로 검색 지원한다.
-- 무조건 많은 인덱스를 설정하면 스플릿 현상으로 더 악영향 미친다.
select * from user_indexes; -- 인덱스의 모든 내용]
select rowid, empno, ename from emp; --rowid는 자동으로 생성됨

select * from employees;

select * from user_indexes where table_name='EMPLOYEES';

-- 모니터링 시작
alter index EMP_EMP_ID_PK monitoring usage;

-- 사용 여부 확ㅇ딘
select index_name, monitoring, used
from v$object_usage
where index_name='EMP_EMP_ID_PK';

-- index 벨런싱 확인
create table i_test6 (no number);

select * from i_test6;
delete from i_test6;
/
begin
    for i in 1..10000 loop
        insert into i_test6 values(i);
    end loop;
    commit;
end;
/

select * from user_indexes where table_name='I_TEST6';

-- 인덱스 생성
create index idx_test6_no
on i_test6(no);

-- 벨런싱 조회
select * from index_stats;
desc index_stats;

-- 분석 명령
analyze index IDX_TEST6_NO validate structure;
select del_lf_rows, lf_rows_len from index_stats;

-- 밸런스 조회
-- 0 에 가까울수록 컨디션이 좋음
select (del_lf_rows/ lf_rows_len)*100 balance from index_stats;

-- 일부 데이터 삭제
delete from i_test6
where no between 3000 and 6000;

select count(*) from i_test6;
commit;

select (del_lf_rows/ lf_rows_len)*100 balance from index_stats;

analyze index IDX_TEST6_NO validate structure;

-- 밸런스 초기화
alter index idx_test6_no rebuild;

-- bigemp import 후
select count(*) from bigemp;

-- 성능 테스트 테이블 준비
select * from bigemp;
select * from bigemp order by dbms_random.value;-- 실행할때마다 정렬이 바뀜

create table emp10
as
select * from bigemp order by dbms_random.value;

create table emp_idx
as
select * from bigemp order by dbms_random.value;

select count(*) from emp10; -- index 없는 테이블
select count(*) from emp_idx;-- index 추가할 테이블

--emp_idx index 추가
create index idx_empidx_emp on emp_idx(emp_no);

select * from user_indexes
where table_name='EMP_IDX';

select * from user_indexes
where table_name='EMP10';

-- 성능비교
-- 인덱스 없는 성능 
select * from emp10 where emp_no<10100;-- 0.009초 0.004초인덱스가 없는 테이블 실행 결과
select * from emp10 where emp_no<20100;-- 0.009초 인덱스가 없는 테이블 실행 결과

-- 인덱스 있는 성능
select * from emp_idx where emp_no<10100;-- 0.005초 0.002초 인덱스가 있는 테이블 실행 결과
select * from emp_idx where emp_no<20100;-- 0.005초 0.002초 인덱스가 있는 테이블 실행 결과

-- LOCK 기능 확인하기
COMMIT;
SELECT * FROM EMP;
CONN SYSTEM;
SHOW USER;

-- HR 계정에 LOCK 확인
SELECT * FROM V$LOCKED_OBJECT WHERE ORACLE_USERNAME='HR';

-- HR에서 UPDATE 실행
UPDATE EMP SET ENAME='ALLEN5' WHERE EMPNO=7499;
commit;
-- 시스템에서 락 확인
-- 위에서 수정하고 COMMIT 을 안해줬기때문에 LOCK 걸림
SELECT * FROM V$LOCKED_OBJECT WHERE ORACLE_USERNAME='HR';
select * from all_objects where object_name='emp';