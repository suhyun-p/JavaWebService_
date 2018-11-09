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

insert into career(user_no, type, career) values (3, 'Awards', '2016 코리아 라틴컵 살사 아마 개인전 우승');
insert into career(user_no, type, career) values (3, 'Awards', '2017 상해 한중 바차타 소셜 배틀전 우승');
insert into career(user_no, type, career) values (3, 'Awards', '2017 국민대 총장배 바차타 개인전 준우승');
insert into career(user_no, type, career) values (3, 'Awards', '2017 명지대 총장배 국제 실용댄스대회 살사 개인전 최우수상');
insert into career(user_no, type, career) values (3, 'Performance', '2016 해피살사 7주년 파티공연반');
insert into career(user_no, type, career) values (3, 'Performance', '2016 메리어트 호텔 살사 소셜공연');
insert into career(user_no, type, career) values (3, 'Performance', '2016 그라시아스 준단원 막심 공연');
insert into career(user_no, type, career) values (3, 'Performance', '2016 에스틸로 시즌6 라틴컵 축공');
insert into career(user_no, type, career) values (3, 'Performance', '2016 해피살사 라틴컵 바차타 축공');
insert into career(user_no, type, career) values (3, 'Performance', '2016 방송통신대학교 초청 살사 커플공연');
insert into career(user_no, type, career) values (3, 'Performance', '2016 살사홀릭 연말파티 바차타 커플공연');
insert into career(user_no, type, career) values (3, 'Performance', '2016 에버라틴 연말파티 바차타 커플공연');
insert into career(user_no, type, career) values (3, 'Performance', '2017 에스틸로 시즌6 국민대 동호회 대항전 축하공연');
insert into career(user_no, type, career) values (3, 'Performance', '2017 상하이 한.중 살사 바차타 페스티벌 바차타 커플공연');
insert into career(user_no, type, career) values (3, 'Performance', '2017 살사로 정모 센슈얼 바차타 커플공연');
insert into career(user_no, type, career) values (3, 'Performance', '2017 그라시아스8주년 캐논공연');
insert into career(user_no, type, career) values (3, 'Performance', '2017 퓨마&리비 보니따 바차타 커플 공연');
insert into career(user_no, type, career) values (3, 'Performance', '2017 막시&나히르 부트캠프 메인공연');
insert into career(user_no, type, career) values (3, 'Workshop', '2015 에스틸로 시즌5');
insert into career(user_no, type, career) values (3, 'Workshop', '2015 페르소나 시즌5');
insert into career(user_no, type, career) values (3, 'Workshop', '2016 바일레사노 시즌5');
insert into career(user_no, type, career) values (3, 'Workshop', '2017 보니따 센슈얼 바차타 초청 오픈강습');
insert into career(user_no, type, career) values (3, 'Workshop', '2017 소공녀 파티 센슈얼 바차타 초청 오픈강습');
insert into career(user_no, type, career) values (3, 'Workshop', '2017 보니따 마마렛 파티 주최 (마이클, 퓨마, 스칼렛)');
insert into career(user_no, type, career) values (3, 'Workshop', '2017 살사로 동호회 살사 한곡완성반 메인 강사');
insert into career(user_no, type, career) values (3, 'Workshop', '2017 상하이 한.중 살사 카니발 텐션 에프터 파티');
insert into career(user_no, type, career) values (3, 'Workshop', '바차타 커플공연 및 워크샵');
insert into career(user_no, type, career) values (3, 'Workshop', '2017 보니따 4주 바차타 초청 워크샵');
insert into career(user_no, type, career) values (3, 'Workshop', '2017 마콘도 2주 바차타 초청 워크샵');
insert into career(user_no, type, career) values (3, 'Workshop', '2017 대구보니따 설슈얼바차타 초청 워크샵');
insert into career(user_no, type, career) values (3, 'Workshop', '2017 살사로 동호회 살사 중급반 메인강사');
insert into career(user_no, type, career) values (3, 'Workshop', '2017 바차타 소셜 배틀전 주최 in스텝빠');
insert into career(user_no, type, career) values (3, 'Workshop', '2017 홍대 스텝 4주 워크샵');
insert into career(user_no, type, career) values (3, 'Workshop', '2017 센슈얼 보니따 1기 퓨전 바차타 안무지도');
insert into career(user_no, type, career) values (3, 'Workshop', '2017 제주 페스티벌 바차타 뮤비 촬영');
insert into career(user_no, type, career) values (3, 'Workshop', '2017 이태원 살사 뮤비 촬영​');

insert into career(user_no, type, career) values (4, 'Profile', 'Team AHORA main director');
insert into career(user_no, type, career) values (4, 'Profile', '2017 Sensual week Professional master');

/*
  Class
*/
insert into class (title, tutor1, tutor2, room, payment, contact) values ('AHORA 바차타 트레이닝', 3, 4, '홍대클럽 텐션', 'NH농협 010-7290-9770-19/유무형', '010-9219-9770 퓨마');
insert into class (title, tutor1, room,payment, contact) values ('Team Ahora Ladies', 4, '텐션', '우리은행 180-08-244668 전신영', '010 2335 8364');