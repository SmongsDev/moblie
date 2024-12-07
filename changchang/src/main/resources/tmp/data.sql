USE chang;

-- title table
INSERT INTO title (name, description, rarity, conditions) VALUES 
('창대생', '창원대학교 학생', '일반', '기본 칭호'),
('과대', '학과 내 학생회장을 맡고 있는 학생. 학과의 대표 역할을 하며 다양한 행사와 활동을 주도하는 리더.', '레어', '학과 학생회장직을 맡은 학생'),
('휴학생', '학업을 일시적으로 중단한 학생. 개인적인 사유나 기타 이유로 휴학을 한 상태.', '일반', '현재 휴학 중인 학생'),
('학회장', '학과 내 또는 학교의 동아리, 학회를 이끄는 대표. 활동을 조직하고 회원들을 관리하는 리더 역할을 한다.', '영웅', '동아리나 학회의 회장직을 맡은 학생'),
('졸업생', '대학을 졸업한 학생. 모든 학점을 이수하고 학위를 취득한 졸업생에게 부여되는 칭호.', '레어', '학위를 취득하고 졸업한 학생'),
('부학회장', '학회에서 회장의 바로 밑에서 지원하고 활동을 보조하는 부회장. 다양한 학회 활동을 책임지고 조직한다.', '영웅', '학회의 부회장직을 맡은 학생'),
('비둘기', '학생들 사이에서 종종 캠퍼스에서 자주 보이는 인물. 수업이나 활동에 자주 등장하지만 별다른 참여나 관심을 보이지 않는 학생.', '히든', '개인주의 학생'),
('동아리 회장', '동아리 내에서 가장 높은 직책을 맡고 있는 학생. 동아리의 전반적인 활동을 이끌고 조직하는 리더 역할을 한다.', '희귀', '동아리의 회장직을 맡은 학생'),
('CASPER 회장', '모든 동아리를 압도하는 CASPER 내에서 가장 높은 직책을 맡고 있는 학생. 창원대의 얼굴이 보통 해당 역할을 부여받는다.', '희든', 'CASPER 동아리의 회장직을 맡은 학생'),
('복학생', '대학 생활을 재개한 학생', '일반', '최소 1학기 이상 휴학 후 복학한 학생'),
('과탑', '자신의 학과에서 학업 성적이 가장 뛰어난 학생. 과내에서 최고 성적을 기록한 자에게 부여되는 칭호.', '영웅', '학과에서 가장 높은 GPA를 보유한 학생'),
('컴공 1과대', '학과를 위해 헌신하며 지지를 받는 존재.', '희귀', '학과 활동을 주도하며 모든 학생의 존경을 받는 자'),
('컴공 2과대', '모든 업적을 달성한 전설적인 존재', '희귀', '4과대의 지지를 받는 자'),
('컴공 3과대', '학과의 조화를 이끄는 중추적인 존재.', '희귀', '학생 간의 화합을 이끌며 학과의 성장을 돕는 자'),
('컴공 4과대', '학과를 대표하는 상징적인 지도자.', '희귀', '학과의 미래를 설계하고 이끌어가는 자');

-- subject table
INSERT INTO subject ( name) VALUES ('고급자료구조');
INSERT INTO subject (name) VALUES ('모바일프로그래밍');
INSERT INTO subject (name) VALUES ('논리설계');
INSERT INTO subject (name) VALUES ('컴퓨터그래픽스');
INSERT INTO subject (name) VALUES ('프로그래밍언어론');
INSERT INTO subject (name) VALUES ('데이터베이스언어실습');

-- Insert schedules
INSERT INTO schedule (day_of_week, start_time, end_time, subject_id) VALUES 
('Monday', '10:30', '12:00', 1),
('Wednesday', '9:00', '10:30', 1);
INSERT INTO schedule (day_of_week, start_time, end_time, subject_id) VALUES 
('Monday', '10:30', '12:00', 2),
('Wednesday', '14:00', '15:30', 2);
INSERT INTO schedule (day_of_week, start_time, end_time, subject_id) VALUES 
('Tuesday', '9:00', '10:30', 3),
('Thursday', '10:30', '12:00', 3);
INSERT INTO schedule (day_of_week, start_time, end_time, subject_id) VALUES 
('Tuesday', '10:30', '12:00', 4),
('Thursday', '9:00', '10:30', 4);
INSERT INTO schedule (day_of_week, start_time, end_time, subject_id) VALUES 
('Tuesday', '15:00', '16:30', 5),
('Thursday', '16:30', '18:00', 5);
INSERT INTO schedule (day_of_week, start_time, end_time, subject_id) VALUES 
('Friday', '12:00', '15:00', 6);


-- department table
INSERT INTO department (name, crawl_url, link_pattern) VALUES ('컴퓨터공학과', 'https://www.changwon.ac.kr/ce/na/ntt/selectNttList.do?mi=6627&bbsId=2187', 'https://www.changwon.ac.kr/ce/na/ntt/selectNttInfo.do?mi=6627&nttSn=');
INSERT INTO department (name, crawl_url, link_pattern) VALUES ('정보통신공학과', 'https://www.changwon.ac.kr/it/na/ntt/selectNttList.do?mi=6661&bbsId=2198', 'https://www.changwon.ac.kr/it/na/ntt/selectNttInfo.do?mi=6661&nttSn=');
INSERT INTO department (name, crawl_url, link_pattern) VALUES ('산업시스템공학과', 'https://www.changwon.ac.kr/ie/na/ntt/selectNttList.do?mi=6583&bbsId=2178', 'https://www.changwon.ac.kr/ie/na/ntt/selectNttInfo.do?mi=6583&nttSn=');
INSERT INTO department (name, crawl_url, link_pattern) VALUES ('스마트오션모빌리티공학과', 'https://www.changwon.ac.kr/some/na/ntt/selectNttList.do?mi=16835&bbsId=6526', 'https://www.changwon.ac.kr/some/na/ntt/selectNttInfo.do?mi=16835&nttSn=');
INSERT INTO department (name, crawl_url, link_pattern) VALUES ('스마트그린공학부 환경에너지공학전공', 'https://www.changwon.ac.kr/envcnu/na/ntt/selectNttList.do?mi=12719&bbsId=2348', 'https://www.changwon.ac.kr/envcnu/na/ntt/selectNttInfo.do?mi=12719&nttSn=');
INSERT INTO department (name, crawl_url, link_pattern) VALUES ('스마트그린공학부 건설시스템공학전공', 'https://www.changwon.ac.kr/cven/na/ntt/selectNttList.do?mi=9757&bbsId=2840', 'https://www.changwon.ac.kr/cven/na/ntt/selectNttInfo.do?mi=9757&nttSn=');
INSERT INTO department (name, crawl_url, link_pattern) VALUES ('건축학부 건축공학전공', 'https://www.changwon.ac.kr/ae/na/ntt/selectNttList.do?mi=7510&bbsId=2378', 'https://www.changwon.ac.kr/ae/na/ntt/selectNttInfo.do?mi=7510&nttSn=');
INSERT INTO department (name, crawl_url, link_pattern) VALUES ('건축학부 건축학전공', 'https://www.changwon.ac.kr/archi/na/ntt/selectNttList.do?mi=8026&bbsId=2471', 'https://www.changwon.ac.kr/archi/na/ntt/selectNttInfo.do?mi=8026&nttSn=');
INSERT INTO department (name, crawl_url, link_pattern) VALUES ('전기전자제어공학부 전기공학전공', 'https://www.changwon.ac.kr/electric/na/ntt/selectNttList.do?mi=11977&bbsId=2073', 'https://www.changwon.ac.kr/electric/na/ntt/selectNttInfo.do?mi=11977&nttSn=');
INSERT INTO department (name, crawl_url, link_pattern) VALUES ('전기전자제어공학부 전자공학전공', 'https://www.changwon.ac.kr/electron/na/ntt/selectNttList.do?mi=6061&bbsId=2080', 'https://www.changwon.ac.kr/electron/na/ntt/selectNttInfo.do?mi=6061&nttSn=');
INSERT INTO department (name, crawl_url, link_pattern) VALUES ('전기전자제어공학부 로봇제어계측공학전공', 'https://www.changwon.ac.kr/cie/na/ntt/selectNttList.do?mi=6703&bbsId=2207', 'https://www.changwon.ac.kr/cie/na/ntt/selectNttInfo.do?mi=6703&nttSn=');
INSERT INTO department (name, crawl_url, link_pattern) VALUES ('신소재공학부', 'https://www.changwon.ac.kr/material/na/ntt/selectNttList.do?mi=5265&bbsId=1889', 'https://www.changwon.ac.kr/material/na/ntt/selectNttInfo.do?mi=5265&nttSn=');
INSERT INTO department (name, crawl_url, link_pattern) VALUES ('메카융합공학과(야)', 'https://www.changwon.ac.kr/mc/na/ntt/selectNttList.do?mi=5726&bbsId=1998', 'https://www.changwon.ac.kr/mc/na/ntt/selectNttInfo.do?mi=5726&nttSn=');


-- create User
INSERT INTO user (student_id, username, password, role, points, character_status_id) VALUES
('20213114', '윤영필', 'test99', 'USER', 100, NULL);
INSERT INTO user (student_id, username, password, role, points, character_status_id) VALUES
('20213115', '이관호', 'front', 'USER', 500, NULL);
INSERT INTO user_subject (user_id, subject_id) VALUES
(1, 1), -- 윤영필이 '고급자료구조' 수강
(1, 2), -- 윤영필이 '모바일프로그래밍' 수강
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5),
(2, 6);
INSERT INTO assignment_status (user_id, subject_id, submitted, deadline) VALUES
(1, 1, TRUE, '2024-12-10 23:59:59'), -- 윤영필이 '고급자료구조' 과제를 제출
(1, 2, FALSE, '2024-12-15 23:59:59'), -- 윤영필이 '모바일프로그래밍' 과제를 제출하지 않음
(2, 2, FALSE, '2024-12-15 23:59:59'),
(2, 4, FALSE, '2024-12-12 23:59:59'); 

INSERT INTO to_do (content, user_id) VALUES
('고급자료구조 과제 완료', 1), -- 윤영필의 ToDo 리스트 항목
('모바일프로그래밍 크롤링 준비', 1),
('모바일프로그래밍 발표 준비', 2);

INSERT INTO character_status (grade, stress, happiness, focus, academic_ability, current_title_id) VALUES
(2, 0, 100, 50, 50, 1);
UPDATE user 
SET character_status_id = 1
WHERE id = 1;


INSERT INTO character_status (grade, stress, happiness, focus, academic_ability, current_title_id) VALUES
(2, 20, 100, 30, 50, 13);
UPDATE user 
SET character_status_id = 2
WHERE id = 2;

INSERT INTO character_title (owned, in_use, character_status_id, title_id) VALUES 
(TRUE, TRUE, 1, 1),
(TRUE, FALSE, 1, 7),
(TRUE, FALSE, 2, 1),
(TRUE, TRUE, 2, 13);