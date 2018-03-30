# SpringRemind
 Training SpringFramework

#DB Setting

192.168.226.141:3306/book_ex
username:zerock
password:1234



/** member table **/

 create table tbl_member (
 userid varchar(50) not null,
 userpw varchar(50) not null,
 username varchar(50) not null,
 email varchar(100) ,
 regdate timestamp default now(),
 updatedate timestamp default now(),
 primary key(userid)
 );

/** board table **/

 create table tbl_board (
 bno int not null auto_increment,
 title varchar(200) not null,
 content text null,
 writer varchar(50) not null ,
 regdate timestamp default now(),
 updatedate timestamp default now(),
 viewcnt int default 0,
 primary key(bno)
 );

/** reply table **/

create table tbl_reply (
rno int NOT NULL auto_increment,
bno int NOT NULL default 0,
replytext varchar(1000) NOT NULL,
replyer varchar(50) NOT NULL,
regdate timestamp NOT NULL default now(),
updatedate timestamp NOT NULL default now(),
primary key(rno)
);
alter table tbl_reply add constraint fk_board
foreign key (bno) references tbl_board (bno);

