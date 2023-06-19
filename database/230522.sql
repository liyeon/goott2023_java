CREATE TABLE jobs2 AS SELECT * FROM jobs;

select * from jobs2;
desc jobs2;

insert into jobs2 values('MMMM', '매니저매니머', 500,20000);
commit;

create table swingmember(
id varchar2(10) primary key,
pwd varchar2(10),
name varchar2(20),
tel varchar2(15));

select * from swingmember;
drop table swingmember;
select * from tab;

purge recyclebin;-- 해당 사용자의 recyclebin으로 생성된 모든 object를 삭제합니다.

insert into swingmember values('blue1', '111', 'hong', '111-111');

select * from swingmember where id='blue1';