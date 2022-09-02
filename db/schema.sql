DROP DATABASE IF EXISTS proj_data;
CREATE DATABASE proj_data;
USE proj_data;


CREATE TABLE `member` (
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    loginId CHAR(20) NOT NULL,
    loginPw CHAR(60) NOT NULL,
    `authLevel` SMALLINT(2) UNSIGNED DEFAULT 3 COMMENT '권한레벨(3=일반, 7=관리자)',
    `name` CHAR(20) NOT NULL,
    email CHAR(50) NOT NULL,
    cellphoneNo CHAR(20) NOT NULL,
    location CHAR(100) NOT NULL,  
    delStatus TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '탈퇴여부(0=탈퇴전, 1=탈퇴)',
    delDate DATETIME COMMENT '탈퇴날짜'
);

CREATE TABLE `aram` (
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    workDate DATETIME NOT NULL,
    repairDate DATETIME NOT NULL, 
    activeDate DATETIME NOT NULL,
    ol CHAR(100)NOT NULL,
    intel CHAR(100) NOT NULL,
    `area` CHAR(10) NOT NULL,
    `stat` BOOLEAN NOT NULL  
);

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'admin',
loginPw = 'admin',
authLevel = 7,
`name` = "관리자",
email = "amdin@gmail.com",
cellphoneNo = "01011112222",
location = "101호";

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user1',
loginPw = 'user1',
authLevel = 7,
`name` = "유저1",
email = "user1@gmail.com",
cellphoneNo = "01011112222",
location = "102호";


INSERT INTO `aram`
SET workDate = NOW(),
repairDate = NOW(),
ol = '101호',
intel = '유류 및 화기 다수',
`area` = '주방';



INSERT INTO `aram`
SET workDate = NOW(),
repairDate = NOW(),
ol = '102호',
intel = '유류 및 화기 다수',
`area` = '주방';


INSERT INTO `aram`
SET workDate = NOW(),
repairDate = NOW(),
ol = '101호',
intel = '목재가구 천,의류 등',
`area` = '안방';
SELECT location
FROM `member`;

INSERT INTO `aram`
SET workDate = NOW(),
repairDate = NOW(),
ol = '102호',
intel = '목재가구 천,의류 등',
`area` = '안방';
SELECT location
FROM `member`;

SELECT ol
FROM `aram`;

SELECT * FROM `member`;

SELECT * FROM `aram`;

SELECT `ol` FROM `aram`;


SELECT A.*
FROM `aram` AS A
LEFT JOIN MEMBER AS M
ON A.ol = M.location
ORDER BY id DESC;

SELECT ol,workDate,repairDate,`area`
FROM `aram`;

SELECT A.*
FROM `aram` AS A
LEFT JOIN MEMBER AS M
ON A.ol = M.location;


SELECT ol,`area`,stat,activeDate
FROM `aram`
WHERE ol = "101호";


SELECT ol,`area`,stat
FROM `aram`
WHERE ol = "102호";


