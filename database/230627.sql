--oracle DAY 9. 230627 47일차
--랜덤 데이터 만들기
--랜덤 넘버 생성(양수, 음수 둘 다 랜덤)
select dbms_random.random from dual;

--랜덤 넘버 생성(0~1 소수점 값 까지)
select dbms_random.value from dual;

--랜덤 넘버 생성(0~1000)
select dbms_random.value(1,1000) from dual;
select round(dbms_random.value(1,1000),0) from dual;--정수만 소수점 값 제외

--랜덤 문자 생성(대문자)
select dbms_random.string('U',20) from dual; -- (U or u : 대문자, 20: 길이)

--랜덤 문자 생성(소문자)
select dbms_random.string('L',20) from dual; -- (L or l : 소문자, 20: 길이)

--랜덤 문자 생성(대소문자 섞어서)
select dbms_random.string('A',20) from dual; -- (A or a : 대소문자 섞여서, 20: 길이)

--랜덤 문자 생성(대문자,숫자 섞어서)
select dbms_random.string('X',20) from dual; -- (X or x : 대문자,숫자 섞여서, 20: 길이)

--랜덤 문자 생성(출력 가능한 문자) 랜덤 비밀번호 생성할 때 좋을 듯
select dbms_random.string('P',20) from dual; -- (P or p : 출력 가능한 문자, 20: 길이)


create table example(
x number,
y varchar2(2000));
-- rpad RPAD("값", "총 문자길이", "채움문자")
/
begin
    for i in 1..1000 loop
        insert into example values(i,rpad(dbms_random.random,5,'*'));
    end loop;
end;
/
select * from example;
select count(*) from example;

--------------------------------------------------------------------------------
--의미있는 테이블 만들기
create table random5(
cola varchar2(20),
colb number,
colc number,
cold varchar2(30),
cole varchar2(30),
colf varchar2(30),
colg number,
colh varchar2(30),
coli varchar2(30)
);
select * from random5;

--step1
/
declare
    type tbl_ins is table of random5%rowtype index by binary_integer;
    w_ins tbl_ins;
begin
    for i in 1..14000 loop
        w_ins(i).cola:=i;
        w_ins(i).colb:=300000;
        w_ins(i).colc:=99;
        w_ins(i).cold:='ABC' || dbms_random.string('x',10);
        w_ins(i).cole:='EEEEEEEEEEEEE';
        w_ins(i).colf:='FFFFFFFFFFFFF';
        w_ins(i).colg:=99999999;
        w_ins(i).colh:='HHHHHHHHHHHHH';
        w_ins(i).coli:='IIIIIIIIIIIII';
    end loop;
    forall i in 1..14000 insert into random5 values w_ins(i);
    commit;
end;
/

select count(*) from random5;
select * from random5;
delete from random5;
commit;

--step2 날짜 랜덤
/
declare
    type tbl_ins is table of random5%rowtype index by binary_integer;
    w_ins tbl_ins;
begin
    for i in 1..14000 loop
        w_ins(i).cola:=i;
        w_ins(i).colb:=300000;
        w_ins(i).colc:=99;
        w_ins(i).cold:=to_date(round(dbms_random.value(1,28))
                                ||'-'|| round(dbms_random.value(1,12)) 
                                ||'-'|| round(dbms_random.value(1900,2022)),
                                'DD-MM-YYYY');
        w_ins(i).cole:='EEEEEEEEEEEEE';
        w_ins(i).colf:='FFFFFFFFFFFFF';
        w_ins(i).colg:=99999999;
        w_ins(i).colh:='HHHHHHHHHHHHH';
        w_ins(i).coli:='IIIIIIIIIIIII';
    end loop;
    forall i in 1..14000 insert into random5 values w_ins(i);
    commit;
end;
/

select count(*) from random5;
select * from random5;
delete from random5;
commit;

--------------------------------------------------------------------------------

create table sale2(
cola number,--판매구분
colb date,--판매날짜
colc number,--옷의 종류(청바지1~청바지5)
cold number,--판매가격
cole number);--판매량

create index idx_cola on sale2(cola);

--step3
/
declare
    type tbl_ins is table of sale2%rowtype index by binary_integer;
    w_ins tbl_ins;
begin
    for i in 1..14000 loop
        w_ins(i).cola:=i;
        w_ins(i).colb:=to_date(round(dbms_random.value(1,28))
                                ||'-'|| round(dbms_random.value(1,12)) 
                                ||'-'|| round(dbms_random.value(1900,2022)),
                                'DD-MM-YYYY');
        w_ins(i).colc:=round(dbms_random.value(1,5));
        w_ins(i).cold:=round(dbms_random.value(10000,20000));
        w_ins(i).cole:=round(dbms_random.value(5,10));
    end loop;
    forall i in 1..14000 insert into sale2 values w_ins(i);
    commit;
end;
/
select count(*) from sale2;
select * from sale2 order by cola;
delete from sale2;
commit;

--통계처리
select colc, sum(cold)*sum(cole) "total price"
from sale2 
group by colc;

select colc, round(sum(cold)*sum(cole)/1000000) "total price(백만 단위)"
from sale2 
group by colc;

--decode 함수 적용
select decode(colc,1,'청바지1',2,'청바지2',3,'청바지3',4,'청바지4',5,'청바지5') goods,
round(sum(cold)*sum(cole)/1000000) "Total Price(백만 단위)"
from sale2 
group by colc 
order by goods;

--------------------------------------------------------------------------------
--backup
--도구 -> 데이터베이스 익스포트

--HR계정 console 백업, C에 backuphr 폴더 만들기 -> cmd에서 명령어
-- export
C:\backuphr>exp userid=hr/123456@xe file=c:\backuphr\hralltable.dump
--HR계정 console 복원 import
C:\backuphr>imp hr/123456@xe file=c:\backuphr\hralltable.dump

--특정테이블 백업
C:\backuphr>exp userid=hr/123456@xe file=c:\backuphr\hrbigemptable.dump tables=bigemp
--특정테이블 복원
C:\backuphr>imp hr/123456@xe file=c:\backuphr\hrbigemptable.dump

--복수개 테이블 백업
C:\backuphr>exp userid=hr/123456@xe file=c:\backuphr\hr3table.dump tables=(bigemp,dept,emp)
--복수개 테이블 복원
C:\backuphr>imp hr/123456@xe file=c:\backuphr\hr3table.dump


--팁 - 테이블 삭제
select 'drop table '|| table_name || ' cascade constraints;' from user_tables;

drop table REGIONS cascade constraints;
drop table LOCATIONS cascade constraints;
drop table DEPARTMENTS cascade constraints;
drop table JOBS cascade constraints;
drop table EMPLOYEES cascade constraints;
drop table JOB_HISTORY cascade constraints;
drop table SAMPLE cascade constraints;
drop table PROFESSOR cascade constraints;
drop table DEPARTMENT cascade constraints;
drop table STUDENT cascade constraints;
drop table REGIONS3 cascade constraints;
drop table COUNTRIES3 cascade constraints;
drop table TBL1 cascade constraints;
drop table TBL2 cascade constraints;
drop table PLAYER cascade constraints;
drop table TEAM cascade constraints;
drop table STADIUM cascade constraints;
drop table ONE cascade constraints;
drop table TWO cascade constraints;
drop table DEPT2 cascade constraints;
drop table EMP2 cascade constraints;
drop table O_TABLE cascade constraints;
drop table S_ORDER cascade constraints;
drop table BOARD1 cascade constraints;
drop table BOARD2 cascade constraints;
drop table USERS cascade constraints;
drop table SALGRADE cascade constraints;
drop table STUDENT2 cascade constraints;
drop table GRADE cascade constraints;
drop table SUBJECT cascade constraints;
drop table TEST01 cascade constraints;
drop table TEST02 cascade constraints;
drop table I_TEST6 cascade constraints;
drop table EMP10 cascade constraints;
drop table EMP_IDX cascade constraints;
drop table EXAMPLE cascade constraints;
drop table RANDOM5 cascade constraints;
drop table SALE2 cascade constraints;
drop table ADDR cascade constraints;
drop table ADDRESS2 cascade constraints;
drop table ADDRMEMO cascade constraints;
drop table BIGEMP cascade constraints;
drop table DEPT cascade constraints;
drop table EMP cascade constraints;
drop table COUNTRIES cascade constraints;


--check option
-- 테이블 생성과 동시에 체크 제약조건 생성하기
create table chtable(
name varchar2(10),
gender char(3) constraint emp_gender check(gender in('남','여')));--'남','여'만 입력가능
-- ㅈㅔ약 조건이 없는 테이블 
create table chtable(
name varchar2(10),
gender char(3));

drop table chtable purge;
insert into chtable values('hong','남');
select * from chtable;

--check 제약조건 삭제
alter table chtable 
drop constraint emp_gender;
commit;
delete from chtable;

--check 제약조건 추가(테이블 생성 후)
alter table chtable add constraint chtable_ch_gender check(gender in('M','F'));

SELECT * FROM ALL_CONSTRAINTS where table_name='CHTABLE';

insert into chtable values('hong','M');
select * from chtable;

--check option 범위로 제약
create table chtable2(
name varchar2(10),
score number constraint chtable2_chk check(score between 50 and 100));

SELECT * FROM ALL_CONSTRAINTS where table_name='CHTABLE2';

insert into chtable2 values('hong',60);
select * from chtable2;