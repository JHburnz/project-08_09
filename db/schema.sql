# DB 생성
DROP DATABASE IF EXISTS proj_data;
CREATE DATABASE proj_data;
USE proj_data;

# 멤버 테이블 생성
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