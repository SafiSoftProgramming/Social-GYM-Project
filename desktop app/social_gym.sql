-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 21, 2019 at 02:07 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `social_gym`
--

-- --------------------------------------------------------

--
-- Table structure for table `amp_access`
--

CREATE TABLE `amp_access` (
  `id` int(200) NOT NULL,
  `user_name` varchar(200) COLLATE utf16_bin NOT NULL,
  `password` varchar(200) COLLATE utf16_bin NOT NULL,
  `rf_id` varchar(200) COLLATE utf16_bin NOT NULL,
  `user_privileges` varchar(200) COLLATE utf16_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Dumping data for table `amp_access`
--

INSERT INTO `amp_access` (`id`, `user_name`, `password`, `rf_id`, `user_privileges`) VALUES
(3, 'mostafa', '2345', '45 45 54 45', ''),
(6, 'hamo', 'soajdpa', '12 32 54 56', ''),
(8, 'AWDFAF', 'EFED', '23 23 23 23', ''),
(9, 'WFSAD', 'FEF', 'C0 31 20 A8', ''),
(10, 'mostafa', '2345', '45 45 54 45', ''),
(11, 'AWDFAF', 'EFED', '23 23 23 23', ''),
(12, 'AWDFAF', 'EFED', '23 23 23 23', ''),
(13, 'AWDFAF', 'EFED', '23 23 23 23', ''),
(14, 'AWDFAF', 'EFED', '23 23 23 23', ''),
(15, 'mostafa', '2345', '45 45 54 45', ''),
(16, 'AWDFAF', 'EFED', '23 23 23 23', ''),
(17, 'AWDFAF', 'EFED', '23 23 23 23', ''),
(18, 'AWDFAF', 'EFED', '23 23 23 23', ''),
(19, 'AWDFAF', 'EFED', '23 23 23 23', ''),
(20, 'AWDFAF', 'EFED', '23 23 23 23', ''),
(21, 'AWDFAF', 'EFED', '23 23 23 23', ''),
(22, 'AWDFAF', 'EFED', '23 23 23 23', ''),
(23, 'mostafa', '2345', '45 45 54 45', ''),
(24, 'AWDFAF', 'EFED', '23 23 23 23', ''),
(25, 'AWDFAF', 'EFED', '23 23 23 23', ''),
(26, 'AWDFAF', 'EFED', '23 23 23 23', ''),
(27, 'WFSAD', 'FEF', 'C0 31 20 A8', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `amp_access`
--
ALTER TABLE `amp_access`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `amp_access`
--
ALTER TABLE `amp_access`
  MODIFY `id` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
