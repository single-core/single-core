--- !Ups

CREATE TABLE TASK (
    ID bigint(20) NOT NULL AUTO_INCREMENT,
    NAME varchar(255) NOT NULL,
    CONTENT varchar(255),
    TAG varchar(255),
    TASK_TYPE varchar(10),
    TASK_STATUS varchar(10),
    DEAD_DATE date
);

--- !Downs

drop table TASK;