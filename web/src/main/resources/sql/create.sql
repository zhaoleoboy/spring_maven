CREATE TABLE `user` (`username` varchar(40) NOT NULL,`password` varchar(40) NOT NULL,`age` int(3) DEFAULT NULL,`name` varchar(40) DEFAULT NULL,`role` varchar(40) DEFAULT NULL,PRIMARY KEY (`username`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;