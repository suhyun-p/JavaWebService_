/*
  SchoolEntity
*/
create table if not exists school_table (
    school_no bigint not null auto_increment,
    school_name varchar(10) not null,
    primary key(school_no)
);

/*
  StudentEntity
*/
create table if not exists student_table (
    student_no bigint not null auto_increment,
    student_name varchar(10) not null,
    school_no bigint not null,
    primary key(student_no)
);

/*
  User Table
*/
create table if not exists user (
    no bigint not null auto_increment,
    nickname varchar(20) not null,
    sex varchar(1) not null,
    type varchar(10) not null,
    primary key(no)
);