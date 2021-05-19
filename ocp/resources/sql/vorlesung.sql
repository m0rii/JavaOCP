SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS hoert;
DROP TABLE IF EXISTS vorlesung;
DROP TABLE IF EXISTS professor;
DROP TABLE IF EXISTS student;




/* Create Tables */

CREATE TABLE hoert
(
        matrnr int NOT NULL,
        vorlnr int NOT NULL,
        PRIMARY KEY (matrnr, vorlnr)
);


CREATE TABLE professor
(
        persnr int NOT NULL,
        name varchar(40) NOT NULL,
        PRIMARY KEY (persnr)
);


CREATE TABLE student
(
        matrnr int NOT NULL,
        name varchar(40) NOT NULL,
        PRIMARY KEY (matrnr)
);


CREATE TABLE vorlesung
(
        vorlnr int NOT NULL,
        titel varchar(40) NOT NULL,
        persnr int NOT NULL,
        PRIMARY KEY (vorlnr)
);



/* Create Foreign Keys */

ALTER TABLE vorlesung
        ADD FOREIGN KEY (persnr)
        REFERENCES professor (persnr)
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
;


ALTER TABLE hoert
        ADD FOREIGN KEY (matrnr)
        REFERENCES student (matrnr)
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
;


ALTER TABLE hoert
        ADD FOREIGN KEY (vorlnr)
        REFERENCES vorlesung (vorlnr)
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
;