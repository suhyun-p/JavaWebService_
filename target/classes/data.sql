/*
  SchoolEntity
*/
insert into school_table (school_name) values ('매력고');
insert into school_table (school_name) values ('예체능고');

/*
  StudentEntity
*/
insert into student_table (student_name, school_no) values ('나라', 1);
insert into student_table (student_name, school_no) values ('민하', 1);
insert into student_table (student_name, school_no) values ('나나', 1);
insert into student_table (student_name, school_no) values ('홍길동', 2);
insert into student_table (student_name, school_no) values ('유재석', 2);

/*
  User
*/
insert into user (nickname, sex, type, is_admin) values ('브라우니', 'M', 'Normal', true);
insert into user (nickname, sex, type) values ('칼리', 'F', 'Normal');
insert into user (nickname, sex, type) values ('퓨마', 'M', 'Tutor');
insert into user (nickname, sex, type) values ('스칼렛', 'F', 'Tutor');