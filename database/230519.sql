select * from countries;
-- select 조건 달기
-- where 사용
select * from countries
where region_id=2;

-- 테이블 구조 확인
desc countries;

-- country_id 가 AR인 데이터 검색
select * from countries
where country_id='AR';

-- country_id 가 AR,DE 데이터 검색
select * from countries
where country_id='AR' or country_id='DE';

-- delete
-- CRUD
-- 조건이 없는 삭제
delete from boats;
-- 테이블 삭제
drop table boats;

select * from address;

-- 조건이 있는 삭제 
delete from address
where id ='moon';

select * from boats;
-- CRUD UPDATE
-- UPDATE 테이블명 SET 칼럼명 = 변경할 데이터 WHERE 칼럼명= 조건
-- bit 가 103인 price를 70000으로 변경
update boats set price = 70000 where bid='103';
update boats set price = 90000 where bid='102';
update boats set price = 100000 where bid='104';
update boats set price = 80000 where bid='101';

-- 여러개 업데이트 하기
update boats set bname='Marine', color='red' where bid='101';

create table members(
name varchar2(10),
position varchar2(20),
tel varchar2(20),
address varchar2(50),
height number(3),
day date
);

insert into members values('임꺽정','사장','010-1234-1234','서울',158,'1970.11.18');
insert into members values('홍길금','부사장','010-1234-5678','강원',188,'2002.05.27');
insert into members values('홍길은','연구소장','010-8765-1234','인천',175,'1984.08.11');
insert into members values('홍길동','연구원','010-3244-4634','서울',158,'1997.04.25');
insert into members values('심청이','비서실장','010-5634-3334','충북',168,'1997.01.31');
insert into members values('타노스','비서','010-1244-4124','충남',208,'1845.02.11');
insert into members values('임찬규','사장아들','010-3910-6352','경기도 광명시',179,'1997.04.25');

select * from members;

-- 임꺼정 데이터 (record) 삭제
delete from members WHERE name='임꺽정';
update members set position='부장', address='대전' where name='홍길동';

create table  bookinfo(
bb_code varchar2(20),
bb_name varchar2(200),
bb_shop varchar2(100),
bb_writer varchar2(80),
bb_price number
);

insert into bookinfo values('0001', '자바의 정석', '도우출판', '남궁성', 25000);
insert into bookinfo values('0002', '난 정말 JAVA를 공부한적이 없다구요', '오렌지미디어', '윤성우', 28000);
insert into bookinfo values('0003', '난 정말 JAVA를 공부한적이 없다구요', '오렌지미디어', '윤성우', 28000);
select * from bookinfo;

create table  studentinfo(
s_no number,
s_name varchar2(100),
s_addr varchar2(200),
s_grade number,
s_birth varchar2(100),
s_subj varchar2(80),
s_score number
);
drop table studentinfo;
insert into studentinfo values(1, '리여닝', '서울시 도봉구 도봉도봉', 6, '19990704', '1abc', 10);
select * from studentinfo;
commit;