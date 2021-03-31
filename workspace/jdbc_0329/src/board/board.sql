select * from c_emp;
select * from c_dept;

--member 테이블 - id, password, name
--board 테이블 번호 제목 내용 작성자 작성시간 글암호 조회수
create table member(
id varchar2(30) constraint member_id_pk primary key,
password number(5),
name varchar2(30)
)

insert into member values('oracle', 1111, '김회원');
insert into member values('java', 1111, '박신입');
insert into member values('spring', 1111, '홍회원');
insert into member values('jdbc', 1111, '최회원');
insert into member values('python', 1111, '이회원');
insert into member values('B', 1111, '홍회원');
insert into member values('portran', 1111, '문신입');
insert into member values('C', 1111, '강회원');
insert into member values('chrome', 1111, '정회원');
insert into member values('explorer', 1111, '조회원');
insert into member values('windows', 1111, '현회원');
insert into member values('linux', 1111, '황회원');

create table board(
seq number(5) constraint board_seq_pk primary key,
title varchar2(200) constraint board_title_nn not null,
contents varchar2(4000),
writer varchar2(30) constraint board_title_fk references member(id),
time date default sysdate,
password number(4),
viewcount number(5)
);

select * from board;

create sequence board_seq;


select seq, title, writer, viewcount
from (select rownum r, seq, title, writer, viewcount
from (select * from board order by time desc)
)
where r between 1 and 10;