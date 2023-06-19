select * from tab;
-- show user;

select * from countries;

-- 테이블 만들기
-- CRUD ( CREATE, READ, UPDATE, DELETE ) 
CREATE table sample1(
no VARCHAR2(10),
name VARCHAR2(20)
);
-- sample1 의 구조
desc sample1;
-- 테이블의 내용 확인
select * from sample1;

CREATE TABLE address(
id VARCHAR2(10),
name VARCHAR2(20),
tel CHAR(13)
);

insert into address VALUES('flower', '화사', '010-1111-1111');
insert into address VALUES('fintree', '솔라', '010-1111-1111');
insert into address VALUES('moon', '문별', '010-1111-1111');
insert into address VALUES('whee', '휘인', '010-1111-1111');
select * from address;

drop table sampl1;

create table boats(
bid NUMBER,
bname VARCHAR2(20),
color VARCHAR2(20),
price number
);

insert into boats values(101,'interlake','blue',30000);
insert into boats values(102,'interlake','red',29000);
insert into boats values(103,'Clipper','green',42000);
insert into boats values(104,'Marine','red',18000);

select * from boats; -- 조회 쿼리

delete from boats; -- 내용물 삭제
-- query 질의
drop table boats; -- 테이블 삭제

create table reserves(
sid VARCHAR2(10),
bid VARCHAR2(10),
day date
);

insert into reserves values('22', '101','2012-10-10');
insert into reserves values('22', '102',to_date('2012-10-10', 'YYYY.MM.DD'));
select  TO_DATE('2012-12-12') from reserves;

create table member(
name VARCHAR2(20),
position VARCHAR2(30),
tel VARCHAR2(30),
addr VARCHAR2(50),
height NUMBER,
joindate DATE
);

insert into member values('김리연', '대표이사', '(010)0000-0000', '서울시 도봉구 도봉도봉', 170, SYSDATE);
insert into member values('김리연', '영업사원', '(02)0000-0000', '서울시 도봉구 도봉도봉', 170, SYSDATE);
insert into member values('김리연', '영업 과장', '(070)0000-0000', '서울시 도봉구 도봉도봉', 170, SYSDATE);
insert into member values('김리연', '대표이사', '(080)0000-0000', '서울시 도봉구 도봉도봉', 170, SYSDATE);
insert into member values('김리연', '대표이사', '(040)0000-0000', '서울시 도봉구 도봉도봉', 170, SYSDATE);
insert into member values('김리연', '대표이사', '(050)0000-0000', '서울시 도봉구 도봉도봉', 170, SYSDATE);
insert into member values('김리연', '대표이사', '(02)0000-0000', '서울시 도봉구 도봉도봉', 170, SYSDATE);
insert into member values('김리연', '대표이사', '(032)0000-0000', '서울시 도봉구 도봉도봉', 170, SYSDATE);

SELECT
name AS 이름, position AS 담당자직위, tel AS 전화번호, addr AS 주소, height AS 키,
TO_CHAR(joindate, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초') AS 가입날짜 
FROM member;

commit;
