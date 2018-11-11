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
  User
*/
create table if not exists user (
    no bigint not null auto_increment,
    nickname varchar(20) not null,
    sex varchar(1) not null,
    type varchar(10) not null default 'Normal',
    is_admin tinyint(1) not null default FALSE ,
    primary key(no)
);

create table if not exists career (
  no bigint not null auto_increment,
  user_no bigint not null,
  type varchar(20),
  career varchar(100),
  primary key(no)
);
/*
  Class
*/
create table if not exists class (
    no bigint not null auto_increment,
    title varchar(100) not null,
    tutor1 bigint not null,
    tutor2 bigint,
    room varchar(100) not null,
    payment varchar(100) not null,
    contact varchar(100) not null,
    primary key(no)
);

create table if not exists curriculum (
    no bigint not null auto_increment,
    class_no bigint not null,
    contents varchar(100) not null,
    primary key(no)
);

create table if not exists price_option (
    no bigint not null auto_increment,
    class_no bigint not null,
    option varchar(100) not null,
    primary key(no)
);

create table if not exists date_option (
    no bigint not null auto_increment,
    class_no bigint not null,
    option varchar(100) not null,
    primary key(no)
);