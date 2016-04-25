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

/*Data for the table `additional_charge` */

insert  into `additional_charge`(`additional_charge_id`,`name`,`cost`) values (1,'Bar Service',220),(2,'Steam Table',60),(3,'Pop',200),(4,'Servery',200),(5,'Ice Machine',25),(6,'Dish Rental',200),(7,'BBQ',50),(8,'Coffee Pot',40),(11,'test',20);

/*Data for the table `booking` */

insert  into `booking`(`booking_id`,`facility_id`,`client_id`,`employee_id`,`booking_type`,`invoice_no`,`catering`,`rate`,`eventTitle`,`startTime`,`endTime`,`setupTime`,`tearDownTime`,`numberOfPeople`) values (4,1,4,NULL,5,NULL,NULL,10,'Local Hockey','2010-03-05 20:15:00','2010-03-05 22:30:00',15,15,45),(4545,1,24,1,2,100003,NULL,4,'Sunwest Christian Fellows','2010-04-08 18:00:00','2010-04-08 23:00:00',10,10,60),(5556,2,17,5,2,100001,NULL,3,'Ice Skating','2010-03-31 11:00:00','2010-03-31 13:00:00',30,15,60),(55555,2,17,5,2,100001,NULL,3,'HockeyStuff','2010-03-31 17:00:00','2010-03-31 18:30:00',15,15,40),(55556,1,1,3,2,NULL,8,4,'Testing2','2010-04-01 15:30:00','2010-04-01 17:30:00',0,0,60),(55560,8,21,4,25,100002,11,3,'Soccer Game','2010-05-11 02:00:00','2010-05-11 04:00:00',15,60,120),(55561,1,17,3,1,100002,12,4,'Test','2010-04-07 12:00:00','2010-04-07 13:00:00',15,15,0),(55562,1,25,1,18,100004,NULL,9,'Jr A Knights Lacrosse','2010-04-12 21:00:00','2010-04-12 22:30:00',0,15,30),(55563,1,25,1,18,100004,NULL,9,'Jr A Knights Lacrosse','2010-04-15 21:00:00','2010-04-15 22:30:00',0,15,30),(55564,1,25,1,18,100004,NULL,9,'Jr A Knights Lacrosse','2010-04-19 21:00:00','2010-04-19 22:30:00',0,15,30),(55565,1,25,1,18,100004,NULL,9,'Jr A Knights Lacrosse','2010-04-22 21:00:00','2010-04-22 22:30:00',0,15,30),(55566,1,25,1,18,100004,NULL,9,'Jr A Knights Lacrosse','2010-04-26 21:00:00','2010-04-26 22:30:00',0,15,30),(55567,1,26,1,17,NULL,NULL,9,'Rockyview Inline Hockey','2010-04-12 18:00:00','2010-04-12 21:00:00',15,0,30),(55568,1,26,1,17,NULL,NULL,9,'Rockyview Inline Hockey','2010-04-13 19:00:00','2010-04-13 21:00:00',15,0,30),(55569,1,26,1,17,NULL,NULL,9,'Rockyview Inline Hockey','2010-04-14 19:00:00','2010-04-14 21:00:00',15,0,30),(55570,1,26,1,17,NULL,NULL,9,'Rockyview Inline Hockey','2010-04-15 19:00:00','2010-04-15 21:00:00',15,0,30),(55571,1,26,1,17,NULL,NULL,9,'Rockyview Inline Hockey','2010-04-17 12:00:00','2010-04-17 15:00:00',15,0,30),(55572,1,26,1,17,NULL,NULL,9,'Rockyview Inline Hockey','2010-04-19 18:00:00','2010-04-19 21:00:00',15,0,30),(55574,1,26,1,17,NULL,NULL,9,'Rockyview Inline Hockey','2010-04-20 19:00:00','2010-04-20 21:00:00',15,0,30),(55575,1,26,1,17,NULL,NULL,9,'Rockyview Inline Hockey','2010-04-26 19:00:00','2010-04-26 21:00:00',15,0,30),(55576,2,26,1,19,NULL,NULL,5,'Rockyview Meeting','2010-04-17 09:00:00','2010-04-17 12:00:00',15,15,20),(55577,2,27,1,19,NULL,NULL,5,'4-H Meeting','2010-04-13 18:00:00','2010-04-13 21:00:00',15,15,20),(55578,2,28,1,19,NULL,NULL,3,'Ag Society - Ladies Night','2010-04-24 08:00:00','2010-04-24 23:00:00',15,15,50),(55580,1,29,1,18,NULL,NULL,9,'Axemen Midget Lacrosse','2010-04-18 13:00:00','2010-04-18 14:00:00',15,15,30),(55585,1,17,1,5,NULL,NULL,13,'Non-Local Minor Hockey','2010-04-14 17:30:00','2010-04-14 21:30:00',15,15,30),(55586,1,6,1,19,NULL,NULL,4,'Indus Figure Skating','2010-04-21 18:30:00','2010-04-21 20:30:00',15,15,100),(55587,3,1,1,19,NULL,NULL,9,'Baseball Diamond rental','2010-04-29 18:00:00','2010-04-29 21:00:00',15,15,50),(55588,2,28,1,19,NULL,NULL,3,'Ag Society - Mens Auction','2010-04-17 07:00:00','2010-04-17 12:00:00',15,15,NULL);

/*Data for the table `booking_additional_charges` */

insert  into `booking_additional_charges`(`additional_charge_id`,`booking_id`) values (1,4545),(3,4545);

/*Data for the table `booking_type` */

insert  into `booking_type`(`booking_type_id`,`name`,`setupTime`,`teardownTime`) values (1,'Wedding',1,2),(2,'Dance',0,0),(3,'Competition',0,0),(4,'Figure Skating',0,0),(5,'Hockey',0,0),(6,'Tournament',0,0),(7,'Figure Skating Test Day',0,0),(8,'School',0,0),(9,'Public Skating',0,0),(11,'Inline Hockey',0,0),(12,'Tournament',0,0),(13,'Figure Skating Test Day',0,0),(14,'School',0,0),(15,'Public Skating',0,0),(16,'Power Skating',0,0),(17,'Inline Hockey',0,0),(18,'Lacrosse',0,0),(19,'Rental',0,0),(20,'Birthday Party',0,0),(21,'Corporate Outing',0,0),(22,'Camp',0,0),(23,'Clinic',0,0),(24,'Leauge',0,0),(25,'Other',0,0),(26,'Closed/Maintenance',0,0),(27,'Ceili',0,0),(30,'Test',15,15);

/*Data for the table `catering` */

insert  into `catering`(`catering_id`,`chargeName`,`charge`,`description`) values (1,'Menu 1',3.5,NULL),(2,'Menu 2',4.5,NULL),(3,'Menu 3',5.5,NULL),(4,'Menu 4',6.5,''),(5,'Menu 5',7.5,''),(6,'Menu 6',8.5,''),(7,'Hot Beverages',0.5,''),(8,'Cold Beverages',1,''),(9,'Platter',1.5,''),(10,'',0,''),(11,'',0,''),(12,'',0,'');

/*Data for the table `client` */

insert  into `client`(`client_id`,`givenName`,`surname`,`address`,`city`,`province`,`postalCode`,`country`,`email`,`discount`,`password`,`homePhone`,`workPhone`,`cellPhone`) values (1,'Walter','Adolph','204 Sunrise Circle SE','Calgary','AB','T3J5A5','Canada','wadolph@email.com',0,'','4032560326','',''),(3,'Elaine','Ogston','Box 1 Site 6 RR#7','Calgary','AB','T2R1Z1','Canada','eogston@email.com',0,'','4039365882','4031234567','4028523456'),(4,'Don','Lausen','53 Anderson Ave','Strathmore','AB','T4E2C2','Canada','dlauren@email.com',0,'','4039365109','',''),(6,'Dereck','Gustaysen','50 Wenstrom Cres','Langdon','AB','T1J1R1','Canada','dgustaysen@email.com',0,'','4039366177','4039013314',''),(7,'Brian','Dow','147 Ventura Way','Calgary','AB','T2J5N5','Canada','bdow@email.com',0,'','4032919084','',''),(8,'Mike ','Graham','14 Wenstrom Cres','Langdon','AB','T2J0Y0','Canada','mgraham@shaw.ca',0,'','','',''),(9,'Mary','Murray','','','','','','mmurray@shaw.ca',0,'','4039365618','',''),(10,'Don','Bailie','Box 36','Indus','AB','T2X1R1','Canada','dbailie@shaw.ca',0,'','4035692591','4036782345','4031234567'),(11,'Murray','Robertson','','','','','','mrobertson@shaw.ca',0,'','','4038266842',''),(12,'Kevin','Antonishyn','54 Anderson Ave','Langdon','AB','T1Y3R3','Canada','kantonishyn@shaw.ca',0,'','4039366189','',''),(13,'Mary','Laycock','234234 Range Road 283','','AB','T2X4R1','Canada','mlaycock@shaw.ca',0,'','4032799096','4037092035','4033380456'),(14,'Noel','Cronin','195 Hawkview Manor Circle NW','Calgary','AB','T2J5N5','Canada','ncronin@shaw.ca',0,'','4038045655','',''),(15,'Jim ','Thomas','284087 TWP Rd 230','','AB','T2J0Y0','Canada','jthomas@shaw.ca',0,'','4037200188','',''),(16,'Clint','Patzack','383 Copperstone Grove SE','Calgary','AB','T2N 1Z','Canada','cpatzack@shaw.ca',0,'password','','4038730109',''),(17,'Gerogie','Fisher','206 Arbor Stone Rise SE','Calgary','AB','T2Y2Y2','Canada','gfisher@shaw.ca',0,'','4038038355','4033742007','1234567890'),(18,'Bonita ','Martinez','','','','','','bonita@shaw.ca',0,'','4035050330','4032233453','4031256890'),(21,'John','Guitan','','','','','','johnadam@shaw.ca',0,'','','',''),(23,'Kerry','Linch','','','','','','klinch@shaw.ca',0,'','','',''),(24,'Evan','Jellovich','101-239 Midpark Way Southeast','Calgary','AB','T2X1M1','Canada','ejellovich@shaw.ca',0,'','','4032542823',''),(25,'Elizabeth','Poitras','Box 54065, 108-2640 52 St. NE','Calgary','AB','T1Y3R3','Canada','cpoitras@shaw.ca',0,'','','',''),(26,'Andrea','Silverthorne','Box 363, 16 Midlake Boulevard SE','Calgary','AB','T2X2X1','Canada','lthorney@shaw.ca',0,'','','4032565003',''),(27,'Laurie ','Toews','','','','','','ljacob@shaw.ca',0,'','','4039486449',''),(28,'Terry','Bearpaw','BOX 2085, 122 Brent Boulevard','Strathmore','AB','T1P1K1','Canada','tbearpaw@shaw.ca',0,'','','4039345822',''),(29,'Kim','Preteau','Box 607, 440-10816 MacLeod Trail South','Calgary','AB','T2J5N1','Canada','kpreteau@shaw.ca',0,'','','4039516892','');

/*Data for the table `employee` */

insert  into `employee`(`employee_id`,`password`,`username`,`givenName`,`surname`,`employeeLevel`) values (1,'password','kerri','Kerri','Lynch',3),(3,'password','corey','Corey','Cantley',3),(4,'password','Jorge','Jorge','Pinochet',3),(5,'password','Lisa','Lisa','Wut',3),(6,'password','Derek','Derek','Lion',3),(7,'password','Stuff','Cindy','Clayton',3),(8,'password','Sharon','Cherry','Random',3),(10,'password','PvsZ','John','Stuby',3),(11,'password','STFU','Bruce','Willis',3),(13,'password','jerry','Jerry','Springer',3),(18,'test','test','test','test',1);

/*Data for the table `facility` */

insert  into `facility`(`facility_id`,`openTime`,`closeTime`,`setupTime`,`teardownTime`,`name`,`maxCapacity`,`minBookingInterval`,`minBookingTime`) values (1,8,23,15,15,'Arena',0,60,60),(2,8,24,15,15,'Banquet Hall',500,60,60),(3,8,23,15,15,'Ball Diamond',0,60,60),(4,8,23,15,15,'Meeting Room',0,60,60),(8,8,20,15,60,'Soccer Field ',0,2,33);

/*Data for the table `facility_additional_charges` */

insert  into `facility_additional_charges`(`additional_charge_id`,`facility_id`) values (1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(3,8);

/*Data for the table `facility_rates` */

insert  into `facility_rates`(`rate_id`,`facility_id`) values (4,1),(1,2),(3,2),(4,2),(1,3),(1,8),(3,8);

/*Data for the table `gst` */

insert  into `gst`(`gst_id`,`gst`) values (3,1.05);

/*Data for the table `invoice` */

insert  into `invoice`(`invoice_no`,`client_id`,`date`,`description`,`gst_id`) values (100001,17,'2010-05-01','Midnapore Hockey League',3),(100002,17,'2010-04-06',NULL,3),(100003,16,'2010-05-03','Wedding',3),(100004,25,'2010-04-08','',3);

/*Data for the table `organization` */

insert  into `organization`(`organization_id`,`name`,`discount`,`description`,`client_contact`) values (1,'Midnapore Minor Hockey Assoc.',0,'Midnapore Minor Hockey Assoc.',1),(2,'Indus Figure Skating Club',50,'Indus Figure Skating Club',6),(3,'Blue Herons Ringette',0,'Blue Herons Ringette',3),(4,'Strathmore Ringette',0,'Strathmore Ringette',4),(5,'Indus Lightning Ringette',0,'Indus Lightning Ringette',6),(6,'IMHA',0,'IMHA',6),(7,'Orica Blasters Hockey Club',0,'Orica Blasters Hockey Club',7),(8,'Indus Coyotes Hockey Club',0,'Indus Coyotes Hockey Club',8),(9,'Retreads Hockey Club',0,'Retreads Hockey Club',9),(10,'Wildrose',0,'Wildrose',10),(11,'Alta Link Managment Co',0,'Alta Link Managment Co',11),(12,'Puckaneers Hockey Club',0,'Puckaneers Hockey Club',12),(13,'Ringers Ringette',0,'Ringers Ringette',13),(14,'Calgary RATH Ringette',0,'Calgary RATH Ringette',14),(15,'Patzack Consulting',0,'Patzack Consulting',16),(16,'Strathmore Lacross Club',0,'Strathmore Lacross Club',17),(21,'Sunwest Christian Fellowship',0,'Sunwest Christian Fellowship',24),(22,'Calgary Knights Lacrosse',10,'Calgary Knights Lacrosse',25),(23,'Rockyview Inline Hockey Assoc',10,'Rockyview Inline Hockey Assoc',26),(24,'4-H Southbow',0,'4-H Southbow',27),(25,'Agricultural Society',15,'Strathmore & District Agr Soc',28),(26,'Calgary Axemen Hockey',0,'Calgary Axemen Hockey - Midget',29);

/*Data for the table `organization_clients` */

insert  into `organization_clients`(`organization_id`,`client_id`) values (1,1),(3,1),(3,3),(4,4),(6,6),(7,7),(8,8),(9,9),(10,10),(11,11),(12,12),(13,13),(14,14),(15,16),(16,17),(7,21),(9,21),(10,21),(14,23),(21,24),(22,25),(23,26),(24,27),(25,28),(26,29);

/*Data for the table `payment` */

insert  into `payment`(`payment_id`,`invoice_no`,`paymentDate`,`paymentAmount`,`payment_type`) values (1,100001,'2010-01-01',200,'cash'),(2,100003,'2010-03-31',600,'cash'),(3,100003,'2010-03-31',400,'check');

/*Data for the table `phone_number` */

insert  into `phone_number`(`area_code`,`number`,`type`,`client_id`) values (403,2560326,'Home',1),(403,9365882,'Home',3),(403,9365109,'Home',4),(403,9013314,'Business',6),(403,9366177,'Home',6),(403,2919084,'Home',7),(403,9365618,'Home',9),(403,8266842,'Business',11),(403,9366189,'Home',12),(403,2799096,'Home',13),(403,8045655,'Home',14),(403,7200188,'Home',15),(403,8730109,'Business',16),(403,3742007,'Business',17),(403,8038355,'Home',17);

/*Data for the table `rate` */

insert  into `rate`(`rate_id`,`name`,`description`,`rate`,`damageDeposit`,`bookingDeposit`,`isHourly`,`validStartTime`,`validEndTime`,`sunday`,`monday`,`tuesday`,`wednesday`,`thursday`,`friday`,`saturday`) values (1,'Hall Daytime','Daytime rate for the banquet hall. M-F 8:00AM - 5:00PM',80,100,10,1,'10:00:00','22:00:00',1,1,1,1,1,1,1),(3,'Hall Full Weekend','Friday - Sunday 12:00 PM - 10:00 AM',600,500,100,1,'08:00:00','22:00:00',0,0,0,0,0,0,0),(4,'Hall Weekend','Saturday or Sunday',300,300,100,1,'08:00:00','22:00:00',0,0,0,0,0,0,0),(5,'Meeting Room- One Day','One day rental of a meeting room.',50,0,0,1,'08:00:00','22:00:00',0,0,0,0,0,0,0),(6,'Meeting Room-  One Day /M','Monthly rental of one meeting room',150,0,0,1,'08:00:00','22:00:00',0,0,0,0,0,0,0),(7,'Meeting Room- 2 Meetings ','Monthly rental of meeting rooms. 2 or more',200,0,0,1,'08:00:00','22:00:00',0,0,0,0,0,0,0),(8,'Kitchen Rental','Kitchen Rental',500,0,0,1,'08:00:00','22:00:00',0,0,0,0,0,0,0),(9,'Dry Pad','Dry Pad',65,0,0,1,'08:00:00','22:00:00',0,0,0,0,0,0,0),(10,'Primetime Ice 1','Primetime rate for local adults and non-resident minor sports',190,0,0,1,'08:00:00','22:00:00',0,0,0,0,0,0,0),(11,'Primetime Ice 2','Local Minor Sports',155,0,0,1,'08:00:00','22:00:00',0,0,0,0,0,0,0),(12,'Primetime Ice 3','Non-resident adults',195,0,0,1,'08:00:00','22:00:00',0,0,0,0,0,0,0),(13,'Non-Primetime','Non-Prime time',60,0,0,1,'08:00:00','22:00:00',0,0,0,0,0,0,0),(14,'Midnapore','Midnapore rate',170,0,0,1,'08:00:00','22:00:00',0,0,0,0,0,0,0),(16,'Testing','Just for testing\r\n',50,50,50,1,'08:00:00','22:00:00',0,0,0,0,0,0,0);

/*Data for the table `todoitem` */

insert  into `todoitem`(`date`,`name`,`description`,`todoitem_id`) values ('2010-04-04','test','test',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
