create table cafe_order(
tnum NUMBER,
totalmenu CLOB,
totalprice VARCHAR2(255),
tdate DATE
);

create table cafe_member(
id varchar2(255) PRIMARY KEY,
pw varchar2(255),
name varchar2(255)
);

INSERT INTO cafe_member VALUES ('admin', '1234','aaaa');

select * from cafe_member;

-- ------------------------------------------------------------------------------

drop table cafe_order;
drop SEQUENCE cafeorder_seq;

select cafeorder_seq.nextval from dual;-- 현재 시퀀스 값 조회

CREATE SEQUENCE cafeorder_seq
       INCREMENT BY 1 -- 증가값
       START WITH 1 -- 시작값
       MINVALUE 1 -- 최소값
       MAXVALUE 100 -- 최대값 
       NOCYCLE -- 최대값 도달시 시작값부터 다시 반복
       NOCACHE --cache 사용 여부
       NOORDER; -- 요청 순서대로 값 생성할지 여부
       
       
INSERT INTO cafe_order VALUES (cafeorder_seq.nextval, '[카페라떼,돌체라떼,돌체라떼]',10000,sysdate);
commit;
select *from cafe_order ORDER BY tnum desc ;
