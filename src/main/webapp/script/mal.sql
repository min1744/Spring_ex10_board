select * from options

insert into options values(product_seq.nextval, 't24165', 'White')

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