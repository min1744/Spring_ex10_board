select * from memberfile;

delete MEMBERFILE where id in ('t1', 't3')

commit

select * from member

select * from
		(select rownum R, MEM.* from
		(select M.*, F.num, F.fname, F.oname from MEMBER M full join MEMBERFILE F on (M.id=F.id) where grade != 0 order by M.id asc) MEM) 
		where R between 1 and 10

select * from files;

create table files(
	fnum number(8) constraint files_fnum_pk primary key,
	num number(8) not null,--다른 테이블을 참조할 수 있기 때문에 foreign key(x) -> not null(o)
	fname varchar2(2000),
	oname varchar2(2000)
);

create table notice(
num number(8),
title varchar2(400),
writer varchar2(400),
contents CLOB,
reg_date date,
hit number(8),
constraint notice_num_pk primary key (num)
);

create sequence notice_seq
start with 1
increment by 1
nomaxvalue
nocycle
nocache;

create table member(
id varchar2(400),
pw varchar2(400) not null,
name varchar2(400) not null,
email varchar2(400) not null,
grade number(8) not null,
constraint member_id_pk primary key(id)
);

create table memberfile(
num number(8),
id varchar2(400),
fname varchar2(400) not null,
oname varchar2(400) not null,
constraint memberfile_num_pk primary key(num),
constraint memberfile_id_fk foreign key (id) references member(id)
on delete cascade
);

create sequence memberfile_seq
start with 1
increment by 1
nomaxvalue
nocycle
nocache;

create sequence files_seq
start with 1
increment by 1
nomaxvalue
nocycle
nocache;

select * from MEMBER;
select * from MEMBERFILE;

select m.id, m.name, f.fname from member m inner join memberfile f on(m.id=f.id) where m.id = 'tt' and m.pw = 'tt';
select n.*, f.* from notice n inner join files f on (n.num=f.num) where n.num = 15;
select * from notice;