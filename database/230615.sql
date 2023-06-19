show user;
select * from tab;

purge RECYCLEBIN;-- 해당 사용자의 recyclebin으로 생성된 모든 object를 삭제합니다.

-- database 시작
--DBMS(database management system)
--종류 : oracle mysql, mariadb db2
--RDB : realtional database 관계형 데이터 베이스
-- 테이블 용어 : row (record, tuple), column ( attribute, filed )

-- 테이블 생성
create table addr(
name varchar2(20),
address varchar2(100),
tel varchar2(20),
memo varchar2(300)
);

-- 테이블 구조확인
desc addr;

-- 테이블 삭제 
drop table addr;
-- 테이블을 삭제하면서 휴지통 비우기
drop table addr purge;

-- 데이터 삽입

insert into addr values('hong','seoul','111-111-111','개발자');
insert into addr values('hong2','seoul','111-111-111','개발자2');
-- memo 필드 공간을 비워두고 데이터 삽입
insert into addr values('hong3', 'busan', '222-2222', null);
--insert into addr values('hong4', 'busan', '333-6333');-- 필드의 갯수와 불일치

insert into addr(name, address, tel) values('hong4', 'busan', '333-6333');
insert into addr(name, memo) values('hong5', '메모메모메모');
insert into addr values('hong6', 'inchon', '1111-1111', 'null');
-- 데이터 조회
select * from addr;

--sql (structured query language ) 구조화된 질의 언어

-- type
--char, varchar2, number, date, timestamp, 

create table sample(
name char(10), -- 고정 길이 글자를 한글자 넣더라도 10바이트로 고정
addr varchar2(50), -- 가변 길이 
regdate date, -- 
birth timestamp
);
select * from sample;
desc sample;
insert into sample values('홍길동','서울',sysdate,sysdate);
insert into sample values('홍길동님', '서울', sysdate,sysdate);-- 실패
insert into sample values('aaaaaaaaa', '서울', sysdate,sysdate);-- 성공

insert into sample values('홍길동3','서울','2020-01-05','1999-07-04 15:30:05.0000060');

create table emp(
empno number(4) not null,-- 사번
ename varchar2(10),-- 사원이름
job varchar2(9),-- 직책
mgr number(4),-- 사수번호
hiredate date,-- 입사일
sal number(7,2),-- 소수점 두자리까지 나타내기 -- 급여
comm number(7,2),-- 커미션
deptno number(2)-- 부서번호
);
select * from emp;
desc emp;

insert into emp values(7369,'SMITH', 'CLERK', 7902, '1980-12-17', 800, null, 20);
insert into emp values(7499,'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600, 300, 30);
insert into emp values(7521,'WARD','SALESMAN',7698,'81/02/22', 1250,500,30);
insert into emp values(7566,'JONES', 'MANAGER',7839,'81/04/02',2975, NULL, 20);
insert into emp values(7654,'MARTIN','SALESMAN',7698,'81/09/28', 1250,1400,30);
insert into emp values(7698,'BLAKE','MANAGER',7839,'81/05/01',2850,NULL,30);
insert into emp values(7782,'CLARK','MANAGER',7839,'81/06/09',2450,NULL,10);
insert into emp values(7788,'SCOTT','ANALYST',7566,'82/12/09',3000,NULL,20);
insert into emp values(7839,'KING','PRESIDENT',NULL,'81/11/17',5000,NULL,10);
insert into emp values(7844,'TURNER','SALESMAN',7698,'81/09/08',1500,NULL,30);
insert into emp values(7876,'ADAMS','CLERK',7788,'83/01/12',1100,NULL,20);
insert into emp values(7900,'JAMES','CLERK',7698,'81/12/03',950,NULL,30);
insert into emp values(7902,'FORD','ANALYST',7566,'81/12/03',3000,NULL,20);
insert into emp values(7934,'MILLER','CLERK',7782,'82/01/23',1300,NULL,10);
insert into emp values(7901,'홍길동','ANALYST',7782,'23/10/30', 1300,NULL,10);

commit;-- 메모리에 등록된 데이터를 물리적 디비 저장소에 저장