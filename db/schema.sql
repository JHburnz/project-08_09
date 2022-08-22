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
    aramType SMALLINT(2) UNSIGNED DEFAULT 3 COMMENT '알람 종류(1=감지기, 2=스프링쿨러)',
    `area` CHAR(100) NOT NULL   
);

DESC `aram`;


