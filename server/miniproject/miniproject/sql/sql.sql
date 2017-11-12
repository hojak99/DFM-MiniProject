use miniproject;

CREATE TABLE `board` (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(300) NOT NULL,
  `content` varchar(10000) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  `crt_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `open_yn` char(1) NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=3;

select * from board where open_yn = 'Y' limit 5, 1;

insert into board (seq, title, content, user_id, open_yn) values (7, 'asdasd', 'asdasd', 'hojak', 'Y');
