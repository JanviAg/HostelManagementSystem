create database hostelmanagementsystem;
use hostelmanagementsystem;

CREATE TABLE `users` (
  `id` varchar(3) NOT NULL,
  `name` varchar(255) NOT NULL,
  `father_name` varchar(255) NOT NULL,
  `cnic` int(17) NOT NULL,
  `date_of_birth` varchar(255) NOT NULL,
  `eductionLevel` varchar(255) NOT NULL,
  `college_name` varchar(255) NOT NULL,
  `securityFee` int(22) NOT NULL,
  `user_type` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users` (`id`, `name`, `father_name`, `cnic`, `date_of_birth`, `eductionLevel`, `college_name`, `securityFee`, `user_type`) VALUES
(1, 'Alfaha', 'Gama', 88, '25-10-1996', 'BCA', 'MK Gandhi',1000, NULL),
(2, 'Bhumika', 'Sunil', 99, '19-06-2000', 'BBA', 'Christ', 2000, NULL),
(3, 'Janvi', 'Rakesh', 44, '21-02-2001', 'B.COM.', 'St. Xavier', 12000, NULL),
(4, 'Aditi', 'Sunil', 88, '24-01-2001', 'LLB', 'SIES',5000, NULL),
(5, 'Admin', 'Akash', 123, '21-02-2001', 'MSC', 'LK',12000, 'A');

ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);
  
  SELECT * FROM users;
