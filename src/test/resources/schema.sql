drop table if exists Events;
create table if not exists Events (
    EventId int(11) NOT NULL AUTO_INCREMENT,
    Name varchar(100) NOT NULL,
    Organiser int(11) NOT NULL,
    Location varchar(40) NOT NULL,
    Description varchar(255) NOT NULL,
    TeamBased int(1) NOT NULL,
    DietReq int(1) NOT NULL,
    Date date NOT NULL,
    Time varchar(45) NOT NULL,
    TeamSize int(11) DEFAULT NULL,
    PRIMARY KEY (EventId)
);
drop table if exists BookingStatus;
create table if not exists BookingStatus (
    bookingStatusId int(11) NOT NULL,
    peopleId        int(11) NOT NULL,
    eventId         int(11) NOT NULL,
    statusId        int(11) NOT NULL,
    dietReq         varchar(255) DEFAULT NULL,
    teammembers     varchar(255)
);
drop table if exists People;
create table if not exists People (
    PeopleId int(11),
    FirstName varchar(20),
    Surname varchar(20),
    Email varchar(40),
    password varchar(255),
    Enabled int(4)
);
drop table if exists authorities;
create table if not exists authorities (
    PeopleID int(11),
    authority varchar(50)
);
drop table if exists users;
create table if not exists users (
    username varchar(50) NOT NULL,
    password varchar(100) NOT NULL,
    enabled int(4),
    PRIMARY KEY (username)
);


