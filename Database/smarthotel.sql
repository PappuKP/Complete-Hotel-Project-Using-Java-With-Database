-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 07, 2018 at 09:42 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smarthotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `checkout`
--

CREATE TABLE `checkout` (
  `id` int(11) NOT NULL,
  `cus_name` varchar(100) NOT NULL,
  `cus_father` varchar(100) NOT NULL,
  `address` varchar(255) NOT NULL,
  `cus_nic` bigint(20) NOT NULL,
  `cus_date` date NOT NULL,
  `out_date` date NOT NULL,
  `phone` bigint(20) NOT NULL,
  `cus_country` varchar(50) NOT NULL,
  `cus_city` varchar(50) NOT NULL,
  `cus_adult` int(11) NOT NULL,
  `cus_child` int(11) NOT NULL,
  `room_type` varchar(100) NOT NULL,
  `room_no` int(11) NOT NULL,
  `room_cost` float NOT NULL,
  `taxes` float NOT NULL,
  `total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `checkout`
--

INSERT INTO `checkout` (`id`, `cus_name`, `cus_father`, `address`, `cus_nic`, `cus_date`, `out_date`, `phone`, `cus_country`, `cus_city`, `cus_adult`, `cus_child`, `room_type`, `room_no`, `room_cost`, `taxes`, `total`) VALUES
(1, 'zeeshan', 'Haji', 'nawa kili akhri stop', 654654, '2018-10-23', '2018-11-03', 32468798465, 'Pakistan', 'Quetta', 2, 0, 'Double', 201, 0, 54, 1054),
(2, 'khaliq', 'ghazi', 'alamdar road quetta', 9879879, '2018-10-30', '2018-11-03', 4654654, 'Pakistan', 'Quetta', 2, 2, 'Luxury', 654, 0, 210, 1110),
(3, 'zeeshan', 'babar', 'kawari road near mcb', 986546213216, '2018-10-23', '2018-11-02', 32468798465, 'Pakistan', 'Quetta', 0, 0, 'Single', 201, 0, 30, 730),
(4, 'Zain', 'khan', 'nasrullah khan chowk', 987654654654, '2018-10-31', '2018-11-01', 3266555, 'Pakistan', 'Quetta', 5, 2, 'Single', 202, 0, 300, 1200),
(5, 'Aurang', 'Zaib', 'raisani road quetta', 6549876546, '2018-10-30', '2018-11-03', 3266858, 'Pakistan', 'Quetta', 7, 3, 'Double', 301, 0, 324, 1254),
(6, 'Raja', 'hasnan', 'sabzal road quetta', 321462255, '2018-10-30', '2018-11-03', 3263545, 'Pakistan', 'Quetta', 8, 5, 'Luxury', 106, 0, 988, 2088),
(7, 'Waqas', 'tahir', '987654oilkjlkjlkj', 32165432132, '2018-11-01', '2018-11-04', 3267548, 'Pakistan', 'Plandri', 3, 1, 'Double', 205, 0, 600, 2600),
(8, 'Taimoor', 'baig', 'joint road quetta', 65432132, '2018-11-01', '2018-11-05', 3254545, 'Pakistan', 'Quetta', 6, 2, 'Delux', 109, 0, 1000, 10876),
(9, 'Razia', 'ahsan', 'teen town', 65465465, '2018-11-01', '2018-11-06', 32659874, 'Pakistan', 'Lahore', 1, 0, 'Single', 303, 0, 50, 1150),
(10, 'Mansoor', 'zaib', 'lkjl ', 98654, '2018-11-01', '2018-11-05', 3265974, 'Pakistan', 'Panjgur', 1, 0, 'Double', 304, 0, 50, 1150),
(11, 'Alam', 'azeem', '987 phase ho no 32', 9876545, '2018-11-01', '2018-11-05', 39876546, 'Pakistan', 'Liari', 5, 2, 'Luxury', 104, 0, 210, 1710),
(12, 'Sadiq', 'niyamat', 'sirki road ', 987654, '2018-10-24', '2018-11-04', 3985474, 'Pakistan', 'Zhob', 4, 5, 'Delux', 202, 0, 310, 2310),
(13, 'musa', 'khan', 'lkjlk lkjlk ', 654654654, '2018-11-02', '2018-11-03', 652458745, 'Pakistan', 'Lahri', 2, 2, 'Family', 602, 0, 31, 1018),
(14, 'Kaleem', 'hadi', 'yyy yyy yyy ', 984984984, '2018-11-02', '2018-11-03', 652458745, 'Pakistan', 'Abbottabad', 5, 1, 'Family', 601, 0, 31, 2300),
(15, 'azeem', 'zubair', 'ii uuu ooo uuu ', 54986545444, '2018-11-02', '2018-11-05', 652458745, 'Pakistan', 'Duki', 6, 3, 'Family', 605, 0, 200, 1500),
(16, 'jamal', 'haji', 'new colony main', 5465465, '2018-11-03', '2018-11-04', 65245474, 'Pakistan', 'Bagh', 4, 2, 'Single', 401, 0, 200, 2000);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `father` varchar(100) NOT NULL,
  `idcard` bigint(20) NOT NULL,
  `phone` bigint(20) NOT NULL,
  `designation` varchar(100) NOT NULL,
  `salary` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `father`, `idcard`, `phone`, `designation`, `salary`) VALUES
(2, 'Khaliq Dad', 'Ghazi Muhammad', 5650311674779, 3322996178, 'IT Officer', 65000),
(3, 'Zeeshan', 'Haji Sab', 5245487554459, 3322665598, 'Manager', 70000);

-- --------------------------------------------------------

--
-- Table structure for table `expenses`
--

CREATE TABLE `expenses` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `nature` varchar(255) NOT NULL,
  `expens` double NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expenses`
--

INSERT INTO `expenses` (`id`, `name`, `nature`, `expens`, `date`) VALUES
(1, 'Khaliq dad', 'tution fee for university', 10000, '2018-11-04');

-- --------------------------------------------------------

--
-- Table structure for table `guests`
--

CREATE TABLE `guests` (
  `id` int(11) NOT NULL,
  `cus_name` varchar(100) NOT NULL,
  `cus_father` varchar(100) NOT NULL,
  `address` varchar(255) NOT NULL,
  `cus_nic` bigint(20) NOT NULL,
  `cus_date` date NOT NULL,
  `phone` bigint(20) NOT NULL,
  `cus_country` varchar(50) NOT NULL,
  `cus_city` varchar(50) NOT NULL,
  `cus_adult` int(11) NOT NULL,
  `cus_child` int(11) NOT NULL,
  `room_type` varchar(100) NOT NULL,
  `room_no` int(11) NOT NULL,
  `room_cost` float NOT NULL,
  `taxes` float NOT NULL,
  `total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `guests`
--

INSERT INTO `guests` (`id`, `cus_name`, `cus_father`, `address`, `cus_nic`, `cus_date`, `phone`, `cus_country`, `cus_city`, `cus_adult`, `cus_child`, `room_type`, `room_no`, `room_cost`, `taxes`, `total`) VALUES
(17, 'raziq', 'mughal', 'mughal abad quetta', 98498654, '2018-11-03', 65245474, 'Pakistan', 'Quetta', 3, 1, 'Single', 402, 1650, 30, 1680),
(18, 'Ajmal', 'najam', 'has no address', 654654654, '2018-11-03', 252535555, 'Pakistan', 'Panjgur', 2, 0, 'Double', 403, 1770, 55, 1825),
(19, 'Shahbaz', 'niyamat', 'ojjj jao ge na', 65498653213, '2018-11-03', 965847545, 'Pakistan', 'Kohat', 5, 1, 'Delux', 306, 1630, 25, 1655),
(20, 'waleed', 'rameez', 'Hello no address', 987774445888, '2018-11-04', 65465465, 'Pakistan', 'Tando Allahyar', 6, 2, 'Double', 400, 3000, 400, 3400),
(21, 'shah', 'hussain', '654654', 9879879879, '2018-11-01', 98798798, 'Palestine', 'None', 5, 2, 'Single', 411, 987, 88, 1075),
(22, 'roshi', 'rashik', 'llll jjj iii ', 98546546, '2018-11-08', 745896588, 'Afghanistan  ', 'None', 4, 1, 'Double', 212, 2400, 88, 2400),
(23, 'Kabeer', 'nasir', 'no where buddy', 254856958, '2018-11-03', 232565455, 'Pakistan', 'Mangla', 3, 0, 'Luxury', 208, 1500, 60, 1560),
(24, 'Nazeer', 'wakeel', 'kanak highway', 63256532622, '2018-11-01', 986549878, 'Pakistan', 'Kanak', 2, 0, 'Delux', 209, 1500, 90, 1590);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `username`, `password`, `status`) VALUES
(2, 'admin', '03322', 'Administrator'),
(3, 'zeeshan', '03322', 'admin'),
(4, 'aurang', 'aurang', 'admin'),
(5, 'khaliq', '03322afg', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` bigint(20) NOT NULL,
  `roomtype` varchar(100) NOT NULL,
  `roomno` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `checkout`
--
ALTER TABLE `checkout`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `expenses`
--
ALTER TABLE `expenses`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `guests`
--
ALTER TABLE `guests`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `checkout`
--
ALTER TABLE `checkout`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `expenses`
--
ALTER TABLE `expenses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `guests`
--
ALTER TABLE `guests`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
