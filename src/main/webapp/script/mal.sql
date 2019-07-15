select * from cart C inner join product P on (C.pid = P.pid) inner join options O on(C.options = O.num) where C.id = 'admin'

create table cart(
num number(8),
id varchar2(400),
pid varchar2(400),
options number(8),
amount number(8),
constraint cart_num_pk primary key(num),
constraint cart_id_fk foreign key(id) references member(id) on delete cascade,
constraint cart_pid_fk foreign key(pid) references product(pid) on delete set null
)

select * from cart
commit

delete cart
	
select * from options
select * from product
B1562918711576

insert into options values(product_seq.nextval, 'B1562918711576', 'White')

 T1563151766460 T        adf     123 sadfas
  B1562918711576 B        adsaf 12312 asdfsa

 
 
CREATE TABLE Product
(
    Pid             VARCHAR2(400)    NOT NULL, 
    Category        VARCHAR2(100)    NULL, 
    Title           VARCHAR2(400)    NULL, 
    Price           NUMBER(8)        NULL, 
    SubContents     VARCHAR2(400)    NULL, 
    MainContents    CLOB             NULL, 
    Amount          NUMBER(8)        NULL, 
    reg_date        DATE             NULL, 
    CONSTRAINT PRODUCT_PID_PK PRIMARY KEY (Pid)
)

create sequence product_seq
start with 1
increment by 1
nomaxvalue
nocycle
nocache

CREATE TABLE Options
(
    num         NUMBER(8)        NOT NULL, 
    Pid         VARCHAR2(400)    NULL, 
    Contents    VARCHAR2(400)    NULL, 
    CONSTRAINT OPTIONS_NUM_PK PRIMARY KEY (num),
    CONSTRAINT OPTIONS_PID_FK FOREIGN KEY (PID) REFERENCES PRODUCT(PID)
    ON DELETE CASCADE
)

CREATE TABLE thumbnail
(
    num      NUMBER(8)        NOT NULL, 
    pid      VARCHAR2(400)    NULL, 
    Fname    VARCHAR2(400)    NULL, 
    Oname    VARCHAR2(400)    NULL, 
    CONSTRAINT THUMBNAIL_NUM_PK PRIMARY KEY (num),
    CONSTRAINT THUMBNAIL_PID_FK FOREIGN KEY (PID) REFERENCES PRODUCT(PID)
)

select * from tab
select * from thumbnail
select * from PRODUCT