
/*CREATE DATABASE IF NOT EXISTS student_system;
create table student(
`num` int(9) primary key not null, 
`name` varchar(10) not null,
chinese_grade int(3) not null default 0,
math_grade int(3) not null default 0,
english_grade int(3) not null default 0
)engine=innodb DEFAULT CHARSET=utf8*/
/*根据如下要求写出SQL语句
- 学生表：student(学号,学生姓名,出生年月,性别)
- 成绩表：score(学号,课程号,成绩)
- 课程表：course(课程号,课程名称,教师号)
- 教师表：teacher(教师号,教师姓名)*/
CREATE DATABASE IF NOT EXISTS classtable;
CREATE TABLE IF NOT EXISTS`students`(
`studentid` INT(9) PRIMARY KEY NOT NULL COMMENT '学号',
`studentname` VARCHAR(20) NOT NULL DEFAULT '匿名' COMMENT '学生姓名',
`birth` DATETIME DEFAULT NULL COMMENT '出生日期',
`sex` VARCHAR(10) NOT NULL DEFAULT 'm'COMMENT '性别'
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `students` (`studentid`,`studentname`,`birth`,`sex`)
VALUES('202021010','liunan','2000-1-1','m'),
('202021012','liufan','2000-2-3','w'),('202021011','yangping','2001-4-3','m');
CREATE TABLE IF NOT EXISTS `score`(
`studentid` INT(9) NOT NULL COMMENT '学号',
`classid` INT(5) NOT NULL DEFAULT '00000' COMMENT '课程号',
`grade` INT(3) NOT NULL DEFAULT '0' COMMENT '成绩'
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `score` (`studentid`,`classid`,`grade`)
VALUES('202021010','00001','60'),('202021011','00002','70'),
('202021010','00002','80'),('202021011','00001','85'),
('202021012','00001','60'),('202021012','00002','78');
CREATE TABLE IF NOT EXISTS `course`(
`classid` INT(5) NOT NULL DEFAULT '00000' COMMENT '课程号',
`classname` VARCHAR(20) NOT NULL COMMENT '课程名称',
`teacherid` INT(4) NOT NULL COMMENT '教师编号'
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `course`(`classid`,`classname`,`teacherid`)
VALUES('00001','高数','0001'),('00002','线代','0002'),('00003','面向对象','0003');
CREATE TABLE IF NOT EXISTS `teacher`(
`teacherid` INT(4) NOT NULL COMMENT '教师编号',
`teachername` VARCHAR(30) NOT NULL COMMENT '教师姓名'
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `teacher`(`teacherid`,`teachername`)
VALUES('0001','zhanghua'),('0002','liming'),('0003','wangshan'),('0004','liuyu');
-- 查询各科成绩最高和最低的分， 以如下的形式显示：课程号，最高分，最低分
SELECT a.`classid` AS 'id' ,a.`grade` AS 'max',b.`grade` AS 'min' 
FROM `score` AS a,`score`AS b
WHERE a.`classid`=b.`classid`
AND a.`studentid`!=b.`studentid`
-- and a.`grade`!= b.`grade` 
 AND a.`grade`=(SELECT MAX(m.grade) FROM `score` AS m WHERE a.`classid`=m.`classid`)
AND b.`grade`=(SELECT MIN(n.grade)FROM `score` AS n WHERE b.`classid`=n.`classid`);
-- 查询学生的总成绩并进行排名
SELECT `studentid` AS 'id' ,SUM(grade) AS 'su' FROM score 
GROUP BY `studentid`
ORDER BY su DESC
-- 查询平均成绩大于60分的学生的学号和平均成绩
SELECT `studentid` AS 'id' ,AVG(grade)  AS 'av' FROM score 
GROUP BY `studentid`
ORDER BY av DESC