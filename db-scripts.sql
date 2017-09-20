
-- Create table
create table STAR_APPLICATION_SETTINGS
(
  star_id    NUMBER(19) not null,
  sett_name  VARCHAR2(150),
  is_enabled NUMBER(1),
  sched_id   NUMBER(19)
);

-- Create table
create table STAR_APPLICATION_SCHEDULER
(
  star_id         NUMBER(19) not null,
  schd_name       VARCHAR2(200),
  started_on      DATE,
  status          VARCHAR2(200),
  last_changed_on DATE,
  is_enabled      NUMBER(1)
);


-- Create table
create table STAR_SCHEDULER_JOBS
(
  star_id           NUMBER(19) not null,
  job_name          VARCHAR2(100),
  description       VARCHAR2(100),
  start_time        DATE,
  end_time          DATE,
  status            VARCHAR2(100),
  started_on        DATE,
  ended_on          DATE,
  entity_name       VARCHAR2(150),
  repeated_interval VARCHAR2(100),
  is_enabled        NUMBER(1),
  job_id            NUMBER(19)
);



-- Create table
create table STAR_SM_USER
(
  star_id       NUMBER(19) not null,
  user_name     VARCHAR2(100),
  user_password VARCHAR2(100),
  is_enabled    NUMBER(1)
);


-- Create table
create table STAR_SM_USER_ROLE
(
  star_id          NUMBER(19) not null,
  role_name        VARCHAR2(100),
  role_description VARCHAR2(100)
);


-- Create table
create table STAR_USER_REGISTRN
(
  star_id     NUMBER(19) not null,
  first_name  VARCHAR2(100),
  last_name   VARCHAR2(100),
  email       VARCHAR2(200),
  gender      VARCHAR2(200),
  dob         DATE,
  contact_num VARCHAR2(200)
);

-- Create table
create table STAR_MAIL_DETAIL
(
  star_id    NUMBER(19) not null,
  date_sched DATE,
  date_sent  DATE,
  status     VARCHAR2(100),
  comments   VARCHAR2(100),
  user_id    NUMBER(19)
);




insert into STAR_APPLICATION_SETTINGS (STAR_ID, SETT_NAME, IS_ENABLED, SCHED_ID)
values (1, 'Sett1', 1, 1);


insert into STAR_APPLICATION_SCHEDULER (STAR_ID, SCHD_NAME, STARTED_ON, STATUS, LAST_CHANGED_ON, IS_ENABLED)
values (1, 'email-sch', to_date('20-09-2017', 'dd-mm-yyyy'), 'STARTED', null, 1);

insert into STAR_SCHEDULER_JOBS (STAR_ID, JOB_NAME, DESCRIPTION, START_TIME, END_TIME, STATUS, STARTED_ON, ENDED_ON, ENTITY_NAME, REPEATED_INTERVAL, IS_ENABLED, JOB_ID)
values (1, 'job1', 'job-test', to_date('14-09-2017', 'dd-mm-yyyy'), to_date('17-09-2018', 'dd-mm-yyyy'), 'NEW', null, null, 'starMailerJob', '50000', 1, 1);

insert into STAR_SM_USER_ROLE (STAR_ID, ROLE_NAME, ROLE_DESCRIPTION)
values (1, '1', '1');




