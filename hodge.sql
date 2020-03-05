DROP DATABASE 'c1981660_TestDB';
CREATE DATABASE `c1981660_TestDB` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE 'c1981660_TestDB'
CREATE TABLE `People` (
  `PeopleId` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(20) CHARACTER SET utf8 NOT NULL,
  `Surname` varchar(20) CHARACTER SET utf8 NOT NULL,
  `Email` varchar(40) CHARACTER SET utf8 NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `Enabled` tinyint(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`PeopleId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
CREATE TABLE `authorities` (
  `PeopleID` int(11) NOT NULL,
  `authority` varchar(50) NOT NULL,
  PRIMARY KEY (`PeopleID`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`PeopleID`) REFERENCES `People` (`PeopleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `Events` (
  `EventId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Organiser` int(11) NOT NULL,
  `Location` varchar(40) CHARACTER SET utf8 NOT NULL,
  `Description` varchar(255) CHARACTER SET utf8 NOT NULL,
  `TeamBased` tinyint(1) NOT NULL,
  `DietReq` tinyint(1) NOT NULL,
  `Date` date NOT NULL,
  `Time` varchar(45) NOT NULL,
  `TeamSize` int(11) DEFAULT NULL,
  PRIMARY KEY (`EventId`)
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=latin1;
CREATE TABLE `Status` (
  `StatusId` int(11) NOT NULL AUTO_INCREMENT,
  `Stat` varchar(10) NOT NULL,
  PRIMARY KEY (`StatusId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
CREATE TABLE `Teams` (
  `TeamId` int(11) NOT NULL AUTO_INCREMENT,
  `TeamName` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`TeamId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `SPRING_SESSION` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;
CREATE TABLE `SPRING_SESSION_ATTRIBUTES` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`),
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `SPRING_SESSION` (`PRIMARY_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

CREATE TABLE `BookingStatus` (
  `bookingStatusId` int(11) NOT NULL AUTO_INCREMENT,
  `peopleId` int(11) NOT NULL,
  `eventId` int(11) NOT NULL,
  `statusId` int(11) NOT NULL,
  `dietReq` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `teammembers` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bookingStatusId`),
  KEY `BookingStatus_ibfk_2` (`eventId`),
  KEY `BookingStatus_ibfk_3` (`statusId`),
  CONSTRAINT `BookingStatus_ibfk_2` FOREIGN KEY (`eventId`) REFERENCES `Events` (`EventId`),
  CONSTRAINT `BookingStatus_ibfk_3` FOREIGN KEY (`statusId`) REFERENCES `Status` (`StatusId`)
) ENGINE=InnoDB AUTO_INCREMENT=193 DEFAULT CHARSET=latin1;