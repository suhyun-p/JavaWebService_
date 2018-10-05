drop table tbl_user if exists;

create table tbl_user (
  id varchar(45) not null,
  username varchar(45) not null,
  password varchar(45) not null
)