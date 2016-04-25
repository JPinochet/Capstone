/*
SQLyog Trial v8.32 
MySQL - 5.1.45-community : Database - indusdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`indusdb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `indusdb`;

/*Table structure for table `additional_charge` */

DROP TABLE IF EXISTS `additional_charge`;

CREATE TABLE `additional_charge` (
  `additional_charge_id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  PRIMARY KEY (`additional_charge_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Table structure for table `booking` */

DROP TABLE IF EXISTS `booking`;

CREATE TABLE `booking` (
  `booking_id` int(6) NOT NULL AUTO_INCREMENT,
  `facility_id` int(6) NOT NULL,
  `client_id` int(6) NOT NULL,
  `employee_id` int(6) DEFAULT NULL,
  `booking_type` int(6) DEFAULT NULL,
  `invoice_no` int(6) DEFAULT NULL,
  `catering` int(6) DEFAULT NULL,
  `rate` int(6) DEFAULT NULL,
  `eventTitle` varchar(25) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `setupTime` int(11) DEFAULT NULL,
  `tearDownTime` int(11) DEFAULT NULL,
  `numberOfPeople` int(11) DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `facility_id` (`facility_id`),
  KEY `client_id` (`client_id`),
  KEY `employee_id` (`employee_id`),
  KEY `booking_type` (`booking_type`),
  KEY `catering` (`catering`),
  KEY `rate` (`rate`),
  KEY `invoice_no` (`invoice_no`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`facility_id`) REFERENCES `facility` (`facility_id`) ON DELETE CASCADE,
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`) ON DELETE CASCADE,
  CONSTRAINT `booking_ibfk_4` FOREIGN KEY (`booking_type`) REFERENCES `booking_type` (`booking_type_id`) ON DELETE SET NULL,
  CONSTRAINT `booking_ibfk_5` FOREIGN KEY (`catering`) REFERENCES `catering` (`catering_id`) ON DELETE SET NULL,
  CONSTRAINT `booking_ibfk_6` FOREIGN KEY (`rate`) REFERENCES `rate` (`rate_id`) ON DELETE SET NULL,
  CONSTRAINT `booking_ibfk_7` FOREIGN KEY (`invoice_no`) REFERENCES `invoice` (`invoice_no`) ON DELETE SET NULL,
  CONSTRAINT `booking_ibfk_8` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=55589 DEFAULT CHARSET=latin1;

/*Table structure for table `booking_additional_charges` */

DROP TABLE IF EXISTS `booking_additional_charges`;

CREATE TABLE `booking_additional_charges` (
  `additional_charge_id` int(6) NOT NULL,
  `booking_id` int(6) NOT NULL,
  PRIMARY KEY (`additional_charge_id`,`booking_id`),
  KEY `booking_id` (`booking_id`),
  CONSTRAINT `booking_additional_charges_ibfk_5` FOREIGN KEY (`additional_charge_id`) REFERENCES `additional_charge` (`additional_charge_id`) ON DELETE CASCADE,
  CONSTRAINT `booking_additional_charges_ibfk_4` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `booking_type` */

DROP TABLE IF EXISTS `booking_type`;

CREATE TABLE `booking_type` (
  `booking_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `setupTime` int(11) NOT NULL,
  `teardownTime` int(11) NOT NULL,
  PRIMARY KEY (`booking_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

/*Table structure for table `catering` */

DROP TABLE IF EXISTS `catering`;

CREATE TABLE `catering` (
  `catering_id` int(6) NOT NULL AUTO_INCREMENT,
  `chargeName` varchar(25) DEFAULT NULL,
  `charge` double DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`catering_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Table structure for table `client` */

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `client_id` int(6) NOT NULL AUTO_INCREMENT,
  `givenName` varchar(40) NOT NULL,
  `surname` varchar(63) NOT NULL,
  `address` varchar(75) DEFAULT NULL,
  `city` varchar(75) DEFAULT NULL,
  `province` varchar(2) DEFAULT NULL,
  `postalCode` varchar(6) DEFAULT NULL,
  `country` varchar(25) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `discount` int(3) DEFAULT NULL,
  `password` varchar(25) NOT NULL,
  `homePhone` varchar(10) DEFAULT NULL,
  `workPhone` varchar(10) DEFAULT NULL,
  `cellPhone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `employee_id` int(6) NOT NULL AUTO_INCREMENT,
  `password` varchar(25) NOT NULL,
  `username` varchar(25) DEFAULT NULL,
  `givenName` varchar(25) DEFAULT NULL,
  `surname` varchar(25) DEFAULT NULL,
  `employeeLevel` int(1) NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Table structure for table `facility` */

DROP TABLE IF EXISTS `facility`;

CREATE TABLE `facility` (
  `facility_id` int(6) NOT NULL AUTO_INCREMENT,
  `openTime` int(11) DEFAULT NULL,
  `closeTime` int(11) DEFAULT NULL,
  `setupTime` int(11) DEFAULT NULL,
  `teardownTime` int(11) DEFAULT NULL,
  `name` varchar(25) NOT NULL,
  `maxCapacity` int(11) DEFAULT NULL,
  `minBookingInterval` int(11) DEFAULT NULL,
  `minBookingTime` int(11) DEFAULT NULL,
  PRIMARY KEY (`facility_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Table structure for table `facility_additional_charges` */

DROP TABLE IF EXISTS `facility_additional_charges`;

CREATE TABLE `facility_additional_charges` (
  `additional_charge_id` int(11) NOT NULL,
  `facility_id` int(11) NOT NULL,
  PRIMARY KEY (`additional_charge_id`,`facility_id`),
  KEY `facility_id` (`facility_id`),
  CONSTRAINT `facility_additional_charges_ibfk_3` FOREIGN KEY (`additional_charge_id`) REFERENCES `additional_charge` (`additional_charge_id`) ON DELETE CASCADE,
  CONSTRAINT `facility_additional_charges_ibfk_4` FOREIGN KEY (`facility_id`) REFERENCES `facility` (`facility_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `facility_rates` */

DROP TABLE IF EXISTS `facility_rates`;

CREATE TABLE `facility_rates` (
  `rate_id` int(11) NOT NULL,
  `facility_id` int(11) NOT NULL,
  PRIMARY KEY (`rate_id`,`facility_id`),
  KEY `facility_id` (`facility_id`),
  CONSTRAINT `facility_rates_ibfk_3` FOREIGN KEY (`rate_id`) REFERENCES `rate` (`rate_id`) ON DELETE CASCADE,
  CONSTRAINT `facility_rates_ibfk_4` FOREIGN KEY (`facility_id`) REFERENCES `facility` (`facility_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `gst` */

DROP TABLE IF EXISTS `gst`;

CREATE TABLE `gst` (
  `gst_id` int(11) NOT NULL AUTO_INCREMENT,
  `gst` double NOT NULL,
  PRIMARY KEY (`gst_id`),
  KEY `gst_id` (`gst_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Table structure for table `invoice` */

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `invoice_no` int(9) NOT NULL AUTO_INCREMENT,
  `client_id` int(6) DEFAULT NULL,
  `date` date NOT NULL,
  `description` varchar(400) DEFAULT NULL,
  `gst_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`invoice_no`),
  KEY `client_id` (`client_id`),
  KEY `gst_id` (`gst_id`),
  CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`) ON DELETE SET NULL,
  CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`gst_id`) REFERENCES `gst` (`gst_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=100006 DEFAULT CHARSET=latin1;

/*Table structure for table `organization` */

DROP TABLE IF EXISTS `organization`;

CREATE TABLE `organization` (
  `organization_id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL,
  `client_contact` int(6) DEFAULT NULL,
  PRIMARY KEY (`organization_id`),
  KEY `client_contact` (`client_contact`),
  CONSTRAINT `organization_ibfk_1` FOREIGN KEY (`client_contact`) REFERENCES `client` (`client_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

/*Table structure for table `organization_clients` */

DROP TABLE IF EXISTS `organization_clients`;

CREATE TABLE `organization_clients` (
  `organization_id` int(6) NOT NULL,
  `client_id` int(6) NOT NULL,
  PRIMARY KEY (`organization_id`,`client_id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `organization_clients_ibfk_3` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`organization_id`) ON DELETE CASCADE,
  CONSTRAINT `organization_clients_ibfk_4` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `payment` */

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
  `payment_id` int(6) NOT NULL AUTO_INCREMENT,
  `invoice_no` int(6) NOT NULL,
  `paymentDate` date NOT NULL,
  `paymentAmount` double NOT NULL,
  `payment_type` enum('check','credit card','cash','debit') DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `invoice_no` (`invoice_no`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`invoice_no`) REFERENCES `invoice` (`invoice_no`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Table structure for table `phone_number` */

DROP TABLE IF EXISTS `phone_number`;

CREATE TABLE `phone_number` (
  `area_code` int(3) NOT NULL,
  `number` int(7) NOT NULL,
  `type` varchar(25) NOT NULL,
  `client_id` int(6) NOT NULL,
  PRIMARY KEY (`area_code`,`number`,`type`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `phone_number_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `rate` */

DROP TABLE IF EXISTS `rate`;

CREATE TABLE `rate` (
  `rate_id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `description` varchar(400) DEFAULT NULL,
  `rate` double NOT NULL,
  `damageDeposit` double DEFAULT NULL,
  `bookingDeposit` double DEFAULT NULL,
  `isHourly` tinyint(1) DEFAULT NULL,
  `validStartTime` time DEFAULT NULL,
  `validEndTime` time DEFAULT NULL,
  `sunday` tinyint(1) DEFAULT NULL,
  `monday` tinyint(1) DEFAULT NULL,
  `tuesday` tinyint(1) DEFAULT NULL,
  `wednesday` tinyint(1) DEFAULT NULL,
  `thursday` tinyint(1) DEFAULT NULL,
  `friday` tinyint(1) DEFAULT NULL,
  `saturday` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`rate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

/*Table structure for table `todoitem` */

DROP TABLE IF EXISTS `todoitem`;

CREATE TABLE `todoitem` (
  `date` date DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL,
  `todoitem_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`todoitem_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Insert administrator employee */
insert  into `employee`(`password`,`username`,`givenName`,`surname`,`employeeLevel`) values ('admin','admin','admin','admin',3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
