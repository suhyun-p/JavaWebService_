/*
  UserEntity
*/
create table if not exists user_table (
    no bigint not null auto_increment,
    name varchar(10) not null,
    primary key(no)
);

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