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

insert into career(user_no, type, career) values (3, '수상경력', 'Test');
/*
  Class
*/
insert into class (title, tutor1, tutor2, room, payment, contact) values ('AHORA 바차타 트레이닝', 3, 4, '홍대클럽 텐션', 'NH농협 010-7290-9770-19/유무형', '010-9219-9770 퓨마');
insert into class (title, tutor1, room,payment, contact) values ('Team Ahora Ladies', 4, '텐션', '우리은행 180-08-244668 전신영', '010 2335 8364');