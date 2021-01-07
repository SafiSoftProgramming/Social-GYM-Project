-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 17, 2020 at 04:50 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.2.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Social_Gym`
--

-- --------------------------------------------------------

--
-- Table structure for table `adpost`
--

CREATE TABLE `adpost` (
  `_id` int(11) NOT NULL,
  `ad_desc` text COLLATE utf8_bin NOT NULL,
  `ad_gif` text COLLATE utf8_bin NOT NULL,
  `ad_name` text COLLATE utf8_bin NOT NULL,
  `ad_icon` text COLLATE utf8_bin NOT NULL,
  `ad_time_date` text COLLATE utf8_bin NOT NULL,
  `promo_code` text COLLATE utf8_bin NOT NULL,
  `promo_code_expiry_date` text COLLATE utf8_bin NOT NULL,
  `contact_details` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `adpost`
--

INSERT INTO `adpost` (`_id`, `ad_desc`, `ad_gif`, `ad_name`, `ad_icon`, `ad_time_date`, `promo_code`, `promo_code_expiry_date`, `contact_details`) VALUES
(38, 'dsgfg', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'retgr', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'ads', '', '', ''),
(39, 'dsgfg', 'http://192.168.1.2/gym_imgs/14.gif', 'retgr', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'ads', '', '', ''),
(40, 'yyyyyyyyyyyyyyyyyyyyyyyyyy', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'retgr', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'ads', '', '', ''),
(41, 'rrrrrrrrrrrrrrrrrrrrr', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'retgr', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'ads', '', '', ''),
(42, 'ooooooooooooooooooo', 'http://192.168.1.2/gym_imgs/14.gif', 'retgr', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'ads', '', '', ''),
(43, 'llllllllllll', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'retgr', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'ads', '', '', ''),
(44, 'There\'s more good news. Research also shows that exercise enhances sleep, prevents weight gain, and reduces the risk of high blood pressure, stroke, type 2 diabetes, and even depression.', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'retgr', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'ads', '', '', ''),
(45, 'ggggggg', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'retgr', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'ads', '', '', ''),
(46, 'جب أولاً قبل الشروع في الذهاب إلى صالات الجيم  اجراء اختبار لصحتك قبل بدء برنامج كمال الأجسام لأنك تحتاج إلى قلب سليم وكذلك كلى سليمة وكبد سليم كي تستطيع بناء البروتينات على صورة خلايا عضلية وبالتالي  يجب  قياس نسبة الكوليسترول في الدم  وكذلك البروتينات الدهنية العالية والمنخفضة الكثافة مثل الترايجلسرايد و السي رياكتف بروتين و اجراء التحاليل التالية:  وظائف كبد وظائف كلي للذكور وظائف البروستاتا\r\n\r\nاقرأ المحتوى الأصلي على موقع كل يوم معلومة طبية:', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'retgr', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'ads', '', '', ''),
(47, 'Another study looked at patients with stable heart failure and determined that exercise relieves symptoms, improves quality of life, reduces hospitalization, and in some cases, reduces the risk of death,\" adds Dr. Permuth-Levine. She points out that exercise isn\'t just important for people who are already living with health conditions: \"If we can see benefits of moderate exercise in people who are recovering from disease, we might see even greater benefits in those of us who are generally well.', 'http://192.168.1.2/gym_imgs/14.gif', 'retgr', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'ads', '', '', ''),
(48, 'Another study looked at patients with stable heart failure and determined that exercise relieves symptoms, improves quality of life, reduces hospitalization, and in some cases, reduces the risk of death,\" adds Dr. Permuth-Levine. She points out that exercise isn\'t just important for people who are already living with health conditions: \"If we can see benefits of moderate exercise in people who are recovering from disease, we might see even greater benefits in those of us who are generally well.', 'http://192.168.1.2/gym_imgs/rr.jpg', 'retgr', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'ads', '', '', ''),
(49, 'Another study looked at patients with stable heart failure and determined that exercise relieves symptoms, improves quality of life, reduces hospitalization, and in some cases, reduces the risk of death,\" adds Dr. Permuth-Levine. She points out that exercise isn\'t just important for people who are already living with health conditions: \"If we can see benefits of moderate exercise in people who are recovering from disease, we might see even greater benefits in those of us who are generally well.', 'http://192.168.1.2/gym_imgs/q2.jpg', 'retgr', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'ads', '', '', ''),
(50, 'Another study looked at patients with stable heart failure and determined that exercise relieves symptoms, improves quality of life, reduces hospitalization, and in some cases, reduces the risk of death,\" adds Dr. Permuth-Levine. She points out that exercise isn\'t just important for people who are already living with health conditions: \"If we can see benefits of moderate exercise in people who are recovering from disease, we might see even greater benefits in those of us who are generally well.', 'http://192.168.1.2/gym_imgs/13.gif', 'retgr', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'ads', '', '', ''),
(51, 'Another study looked at patients with stable heart failure and determined that exercise relieves symptoms, improves quality of life, reduces reduces w improves improves', 'http://192.168.1.2/gym_imgs/11.gif', 'retgr', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'ads', '', '', ''),
(52, 'Another study looked at patients with stable heart failure and determined that exercise relieves symptoms, \r\nhttps://www.facebook.com/profile.php?id=612065743 improves quality of life, reduces reduces w improves improves', 'http://192.168.1.2/gym_imgs/q2.jpg', 'Supplement Store', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'ads', 'gn-50', '22-January-2020', '5 sultam hussen st mohatt el raml');

-- --------------------------------------------------------

--
-- Table structure for table `ads_pics`
--

CREATE TABLE `ads_pics` (
  `_id` int(11) NOT NULL,
  `ad_name` text COLLATE utf8_bin NOT NULL,
  `ad_img` longblob NOT NULL,
  `ad_time` int(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `members_at_the_gym`
--

CREATE TABLE `members_at_the_gym` (
  `_id` int(11) NOT NULL,
  `member_name` varchar(200) COLLATE utf8_bin NOT NULL,
  `member_photo` text COLLATE utf8_bin NOT NULL,
  `member_start_date` varchar(200) COLLATE utf8_bin NOT NULL,
  `member_end_date` varchar(200) COLLATE utf8_bin NOT NULL,
  `plane` varchar(200) COLLATE utf8_bin NOT NULL,
  `workout_one_name` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `workout_two_name` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `enter_member_time_date` text COLLATE utf8_bin NOT NULL,
  `rfid` text COLLATE utf8_bin NOT NULL,
  `enter_member_date` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `members_workout_history`
--

CREATE TABLE `members_workout_history` (
  `_id` int(11) NOT NULL,
  `member_name` varchar(200) COLLATE utf8_bin NOT NULL,
  `member_photo` text COLLATE utf8_bin NOT NULL,
  `workout_one_name` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `workout_two_name` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `start_workout_date` text COLLATE utf8_bin NOT NULL,
  `start_workout_time` text COLLATE utf8_bin NOT NULL,
  `end_workout_time` text COLLATE utf8_bin NOT NULL,
  `workout_time_duration` text COLLATE utf8_bin NOT NULL,
  `workout_rate` text COLLATE utf8_bin NOT NULL,
  `workout_sign_out_mode` text COLLATE utf8_bin NOT NULL,
  `rfid` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `members_workout_history`
--

INSERT INTO `members_workout_history` (`_id`, `member_name`, `member_photo`, `workout_one_name`, `workout_two_name`, `start_workout_date`, `start_workout_time`, `end_workout_time`, `workout_time_duration`, `workout_rate`, `workout_sign_out_mode`, `rfid`) VALUES
(1, 'mahmoud el mlah abo', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', 'Back', 'Crossfit', '22-January-2020', 'enter_member_time_date', '03:31 AM', '0 : 52 : 31', '80', 'manual', ''),
(2, 'mahmoud el mlah abo', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', 'Back', 'Crossfit', '22-January-2020', '02:39 AM', '03:48 AM', '1 : 8 : 56', '20', 'manual', ''),
(3, 'mahmoud el mlah abo', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', 'Back', 'Crossfit', '22-January-2020', '02:39 AM', '04:15 AM', '1 : 36 : 33', '80', 'manual', ''),
(4, 'mahmoud el mlah abo', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', 'Back', 'Crossfit', '22-January-2020', '02:39 AM', '04:22 AM', '1 : 43 : 22', '100', 'manual', ''),
(5, 'xx', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'Leg', 'Crossfit', '', '01:44 AM', '04:27 AM', '2 : 43 : 00', '20', 'manual', ''),
(6, 'Ahmed adel ', 'http://192.168.1.2/members_profile_imgs/Social_Gym10426C89.jpg', 'Leg', 'Abs', '22-January-2020', '04:26 AM', '04:32 AM', '0 : 6 : 11', '80', 'manual', ''),
(7, 'Ahmed adel ', 'http://192.168.1.2/members_profile_imgs/Social_Gym10426C89.jpg', 'Cardio', 'Back', '22-January-2020', '04:50 AM', '04:50 AM', '00 : 00 : 11', '20', 'manual', ''),
(8, 'mahmoud el mlah abo', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', 'Crossfit', 'Cardio', '22-January-2020', '05:24 AM', '08:12 AM', '02 : 47 : 56', '50', 'manual', ''),
(9, 'xx', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'Leg', 'Crossfit', '22-January-2020', '04:59 AM', '08:27 AM', '03 : 28 : 23', '100', 'manual', ''),
(10, 'Ahmed adel ', 'http://192.168.1.2/members_profile_imgs/Social_Gym10426C89.jpg', 'Arm', 'Crossfit', '22-January-2020', '05:02 AM', '08:33 AM', '03 : 31 : 08', '80', 'manual', ''),
(11, 'mahmoud el mlah abo', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', 'Crossfit', 'Arm', '22-January-2020', '08:34 AM', '08:34 AM', '00 : 00 : 29', '20', 'manual', ''),
(12, 'Ahmed adel ', 'http://192.168.1.2/members_profile_imgs/Social_Gym10426C89.jpg', 'Leg', 'Abs', '23-January-2020', '02:45 AM', '02:46 AM', '00 : 01 : 08', '80', 'manual', '10 42 6C 89'),
(13, 'Ahmed adel ', 'http://192.168.1.2/members_profile_imgs/Social_Gym10426C89.jpg', 'Back', 'Crossfit', '23-January-2020', '04:46 AM', '04:46 AM', '00 : 00 : 19', '20', 'manual', '10 42 6C 89'),
(14, 'Ahmed adel ', 'http://192.168.1.2/members_profile_imgs/Social_Gym10426C89.jpg', 'Arm', 'Chest', '23-January-2020', '04:48 AM', '04:48 AM', '00 : 00 : 43', '100', 'manual', '10 42 6C 89'),
(15, 'xx', 'http://192.168.1.2/members_profile_imgs/Social_GymC6887C89.jpg', 'Arm', 'Abs', '23-January-2020', '02:45 AM', '11:38 AM', '08 : 49 : 27', '20', 'manual', 'C6 88 7C 89'),
(16, 'xx', 'http://192.168.1.2/members_profile_imgs/Social_GymC6887C89.jpg', 'Back', '', '23-January-2020', '11:39 AM', '11:39 AM', '00 : 00 : 09', '100', 'manual', 'C6 88 7C 89'),
(17, 'Ahmed adel ', 'http://192.168.1.2/members_profile_imgs/Social_Gym10426C89.jpg', '', 'Crossfit', '23-January-2020', '11:34 AM', '11:39 AM', '00 : 05 : 38', '20', 'manual', '10 42 6C 89'),
(18, 'xx', 'http://192.168.1.2/members_profile_imgs/Social_GymC6887C89.jpg', 'Abs', 'Leg', '23-January-2020', '01:01 PM', '10:52 PM', '09 : 51 : 47', '50', 'Auto', 'C6 88 7C 89'),
(19, 'mahmoud el mlah abo', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', 'Shoulders', 'Crossfit', '23-January-2020', '02:45 AM', '11:03 PM', '08 : 18 : 26', '50', 'Auto', '2D D9 77 89'),
(20, 'Ahmed adel ', 'http://192.168.1.2/members_profile_imgs/Social_Gym10426C89.jpg', 'Leg', 'Arm', '23-January-2020', '09:08 PM', '11:33 PM', '02 : 25 : 47', '20', 'Manual', '10 42 6C 89'),
(21, 'mahmoud el mlah abo', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', 'Shoulders', 'Leg', '23-January-2020', '11:26 PM', '12:03 AM', '00 : 37 : 23', '20', 'Manual', '2D D9 77 89'),
(22, 'xx', 'http://192.168.1.2/members_profile_imgs/Social_GymC6887C89.jpg', 'Arm', 'Chest', '23-January-2020', '11:27 PM', '02:49 AM', '03 : 22 : 53', '50', 'Auto', 'C6 88 7C 89'),
(23, 'yuy', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'Abs', '', '23-January-2020', '11:27 PM', '02:49 AM', '03 : 22 : 53', '50', 'Auto', 'E6 F4 4B 79'),
(24, 'Ahmed adel ', 'http://192.168.1.2/members_profile_imgs/Social_Gym10426C89.jpg', 'Leg', '', '23-January-2020', '11:35 PM', '02:49 AM', '03 : 14 : 53', '50', 'Auto', '10 42 6C 89'),
(25, 'melegy', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'Chest', '', '23-January-2020', '11:54 PM', '03:42 PM', '03 : 48 : 24', '50', 'Auto', 'C0 31 20 A8'),
(26, 'yuy', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'Shoulders', '', '24-January-2020', '03:43 PM', '05:16 PM', '01 : 32 : 59', '100', 'Manual', 'E6 F4 4B 79'),
(27, 'yuy', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'Back', 'Abs', '24-January-2020', '05:19 PM', '05:19 PM', '00 : 00 : 47', '0', 'Manual', 'E6 F4 4B 79'),
(28, 'yuy', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'Leg', 'Arm', '24-January-2020', '05:31 PM', '05:31 PM', '00 : 00 : 15', '80', 'Manual', 'E6 F4 4B 79'),
(29, 'yuy', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'Shoulders', 'Arm', '24-January-2020', '05:49 PM', '05:50 PM', '00 : 00 : 51', '80', 'Manual', 'E6 F4 4B 79'),
(30, 'yuy', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'Shoulders', 'Crossfit', '24-January-2020', '05:50 PM', '06:03 PM', '00 : 13 : 02', '20', 'Manual', 'E6 F4 4B 79'),
(31, 'melegy', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'Leg', 'Crossfit', '24-January-2020', '05:12 PM', '08:12 PM', '03 : 00 : 31', '50', 'Auto', 'C0 31 20 A8'),
(32, 'xx', 'http://192.168.1.2/members_profile_imgs/Social_GymC6887C89.jpg', 'Arm', 'Abs', '24-January-2020', '05:12 PM', '08:12 PM', '03 : 00 : 31', '50', 'Auto', 'C6 88 7C 89'),
(33, 'mahmoud el mlah abo', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', 'Leg', 'Shoulders', '24-January-2020', '05:13 PM', '08:15 PM', '03 : 02 : 51', '50', 'Auto', '2D D9 77 89'),
(34, 'Ahmed adel ', 'http://192.168.1.2/members_profile_imgs/Social_Gym10426C89.jpg', 'Chest', 'Abs', '24-January-2020', '05:13 PM', '08:15 PM', '03 : 02 : 51', '50', 'Auto', '10 42 6C 89'),
(35, 'melegy', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'Arm', 'Chest', '24-January-2020', '09:00 PM', '09:55 PM', '00 : 55 : 43', '50', 'Manual', 'C0 31 20 A8'),
(36, 'mahmoud el mlah abo', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', 'Chest', 'Arm', '24-January-2020', '08:54 PM', '10:01 PM', '01 : 07 : 38', '50', 'Manual', '2D D9 77 89'),
(37, 'yuy', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'Back', '', '24-January-2020', '08:54 PM', '10:38 PM', '01 : 44 : 33', '100', 'Manual', 'E6 F4 4B 79'),
(38, 'mahmoud el mlah abo', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', 'Leg', '', '24-January-2020', '10:01 PM', '10:40 PM', '00 : 39 : 13', '20', 'Manual', '2D D9 77 89'),
(39, 'Ahmed adel ', 'http://192.168.1.2/members_profile_imgs/Social_Gym10426C89.jpg', 'Back', 'Leg', '24-January-2020', '09:05 PM', '12:05 AM', '03 : 00 : 51', '50', 'Auto', '10 42 6C 89'),
(40, 'xx', 'http://192.168.1.2/members_profile_imgs/Social_GymC6887C89.jpg', 'Crossfit', 'Cardio', '24-January-2020', '09:13 PM', '12:15 AM', '03 : 02 : 51', '50', 'Auto', 'C6 88 7C 89'),
(41, 'melegy', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'Leg', '', '24-January-2020', '09:56 PM', '02:48 PM', '04 : 52 : 31', '50', 'Auto', 'C0 31 20 A8'),
(42, 'yuy', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'Arm', '', '24-January-2020', '10:48 PM', '02:48 PM', '03 : 00 : 31', '50', 'Auto', 'E6 F4 4B 79'),
(43, 'yuy', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'Arm', 'Back', '25-January-2020', '05:32 PM', '08:32 PM', '03 : 00 : 41', '50', 'Auto', 'E6 F4 4B 79'),
(44, 'melegy', 'http://192.168.1.2/members_profile_imgs/Social_GymC03120A8.jpg', 'Chest', '', '25-January-2020', '05:33 PM', '08:36 PM', '03 : 03 : 01', '50', 'Auto', 'C0 31 20 A8'),
(45, 'xx', 'http://192.168.1.2/members_profile_imgs/Social_GymC6887C89.jpg', 'Crossfit', '', '26-January-2020', '01:28 PM', '07:57 PM', '06 : 29 : 02', '50', 'Auto', 'C6 88 7C 89'),
(46, 'melegy', 'http://192.168.1.2/members_profile_imgs/Social_GymC03120A8.jpg', 'Arm', 'Back', '26-January-2020', '01:28 PM', '07:57 PM', '06 : 29 : 02', '50', 'Auto', 'C0 31 20 A8'),
(47, 'Ahmed adel ', 'http://192.168.1.2/members_profile_imgs/Social_Gym10426C89.jpg', 'Back', 'Crossfit', '26-January-2020', '01:28 PM', '07:57 PM', '06 : 29 : 02', '50', 'Auto', '10 42 6C 89'),
(48, 'mahmoud el mlah abo', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', '', 'Back', '26-January-2020', '01:29 PM', '07:57 PM', '06 : 28 : 02', '50', 'Auto', '2D D9 77 89'),
(49, 'yuy', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'Chest', 'Abs', '26-January-2020', '01:29 PM', '07:57 PM', '06 : 28 : 02', '50', 'Auto', 'E6 F4 4B 79'),
(50, 'mahmoud el mlah abo', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', 'Leg', '', '26-January-2020', '08:05 PM', '01:00 AM', '04 : 55 : 08', '50', 'Auto', '2D D9 77 89'),
(51, 'Ahmed adel ', 'http://192.168.1.2/members_profile_imgs/Social_Gym10426C89.jpg', 'Leg', 'Back', '26-January-2020', '10:02 PM', '01:03 AM', '03 : 01 : 28', '50', 'Auto', '10 42 6C 89'),
(52, 'melegy', 'http://192.168.1.2/members_profile_imgs/Social_GymC03120A8.jpg', 'Abs', 'Cardio', '26-January-2020', '10:04 PM', '01:06 AM', '03 : 02 : 48', '50', 'Auto', 'C0 31 20 A8'),
(53, 'yuy', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'Shoulders', 'Abs', '26-January-2020', '10:06 PM', '01:10 AM', '03 : 04 : 08', '50', 'Auto', 'E6 F4 4B 79'),
(54, 'melegy', 'http://192.168.1.2/members_profile_imgs/Social_GymC03120A8.jpg', 'Shoulders', 'Crossfit', '27-January-2020', '02:49 PM', '05:52 PM', '03 : 03 : 18', '50', 'Auto', 'C0 31 20 A8'),
(55, 'mahmoud el mlah abo', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', 'Leg', '', '27-January-2020', '02:51 PM', '05:52 PM', '03 : 01 : 18', '50', 'Auto', '2D D9 77 89'),
(56, 'melegy', 'http://192.168.1.2/members_profile_imgs/Social_GymC03120A8.jpg', 'Shoulders', '', '28-January-2020', '01:31 AM', '10:18 PM', '08 : 47 : 44', '50', 'Auto', 'C0 31 20 A8'),
(57, 'mahmoud el mlah abo', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', 'Arm', 'Back', '28-January-2020', '01:31 AM', '10:18 PM', '08 : 47 : 44', '50', 'Auto', '2D D9 77 89'),
(58, 'xx', 'http://192.168.1.2/members_profile_imgs/Social_GymC6887C89.jpg', 'Arm', 'Shoulders', '30-January-2020', '08:59 PM', '11:59 PM', '03 : 00 : 04', '50', 'Auto', 'C6 88 7C 89'),
(59, 'mahmoud el mlah abo', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', 'Back', '', '30-January-2020', '09:02 PM', '12:02 AM', '03 : 00 : 24', '50', 'Auto', '2D D9 77 89'),
(60, 'Ahmed adel ', 'http://192.168.1.2/members_profile_imgs/Social_Gym10426C89.jpg', 'Abs', 'Arm', '30-January-2020', '09:04 PM', '12:05 AM', '03 : 01 : 43', '50', 'Auto', '10 42 6C 89'),
(61, 'melegy', 'http://192.168.1.2/members_profile_imgs/Social_GymC03120A8.jpg', 'Shoulders', '', '30-January-2020', '09:19 PM', '12:19 AM', '03 : 00 : 04', '50', 'Auto', 'C0 31 20 A8'),
(62, 'yuy', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'Leg', 'Shoulders', '30-January-2020', '09:20 PM', '12:22 AM', '03 : 02 : 23', '50', 'Auto', 'E6 F4 4B 79'),
(63, 'melegy', 'http://192.168.1.2/members_profile_imgs/Social_GymC03120A8.jpg', 'Shoulders', 'Leg', '31-January-2020', '12:23 AM', '03:25 PM', '03 : 02 : 43', '50', 'Auto', 'C0 31 20 A8'),
(64, 'mahmoud el mlah abo', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', 'Arm', 'Back', '31-January-2020', '02:10 AM', '07:08 PM', '04 : 58 : 29', '50', 'Auto', '2D D9 77 89'),
(65, 'xx', 'http://192.168.1.2/members_profile_imgs/Social_GymC6887C89.jpg', 'Cardio', '', '31-January-2020', '02:10 AM', '07:08 PM', '04 : 58 : 29', '50', 'Auto', 'C6 88 7C 89'),
(66, 'Ahmed adel ', 'http://192.168.1.2/members_profile_imgs/Social_Gym10426C89.jpg', 'Back', 'Abs', '31-January-2020', '02:10 AM', '07:08 PM', '04 : 58 : 29', '50', 'Auto', '10 42 6C 89'),
(67, 'mahmoud el mlah abo', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', 'Back', 'Abs', '04-February-2020', '06:09 PM', '01:56 AM', '07 : 47 : 49', '50', 'Auto', '2D D9 77 89'),
(68, 'melegy', 'http://192.168.1.2/members_profile_imgs/Social_GymC03120A8.jpg', 'Arm', 'Abs', '05-February-2020', '05:16 PM', '01:55 AM', '08 : 39 : 04', '50', 'Auto', 'C0 31 20 A8');

-- --------------------------------------------------------

--
-- Table structure for table `member_data`
--

CREATE TABLE `member_data` (
  `_id` int(11) NOT NULL,
  `full_name` varchar(200) COLLATE utf8_bin NOT NULL,
  `phone_number` varchar(200) COLLATE utf8_bin NOT NULL,
  `registration_date` varchar(200) COLLATE utf8_bin NOT NULL,
  `start_date` varchar(200) COLLATE utf8_bin NOT NULL,
  `end_date` varchar(200) COLLATE utf8_bin NOT NULL,
  `plane` varchar(200) COLLATE utf8_bin NOT NULL,
  `gender` varchar(200) COLLATE utf8_bin NOT NULL,
  `weight_kg` varchar(200) COLLATE utf8_bin NOT NULL,
  `height_cm` varchar(200) COLLATE utf8_bin NOT NULL,
  `birthdate` varchar(200) COLLATE utf8_bin NOT NULL,
  `address` varchar(200) COLLATE utf8_bin NOT NULL,
  `hint` varchar(200) COLLATE utf8_bin NOT NULL,
  `img_title` varchar(200) COLLATE utf8_bin NOT NULL,
  `image` text COLLATE utf8_bin NOT NULL,
  `RFID` varchar(200) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `member_data`
--

INSERT INTO `member_data` (`_id`, `full_name`, `phone_number`, `registration_date`, `start_date`, `end_date`, `plane`, `gender`, `weight_kg`, `height_cm`, `birthdate`, `address`, `hint`, `img_title`, `image`, `RFID`) VALUES
(57, 'Ahmed adel ', '011245874', '2020-01-01', '2020-01-01', '2020-01-31', 'JFXComboBox', 'male', '34', '34', '2008-08-14', 'dsfgdfg', 'dsfdsf', '34', 'http://192.168.1.2/members_profile_imgs/Social_Gym10426C89.jpg', '10 42 6C 89'),
(58, 'mahmoud el mlah abo', '012557898887', '2020-01-01', '2020-01-17', '2020-02-17', 'JFXComboBox', 'female', '34', '342', '2020-01-29', 'dfdsf', 'dfsdfsd', '34', 'http://192.168.1.2/members_profile_imgs/Social_Gym2DD97789.jpg', '2D D9 77 89'),
(61, 'Ahmed adel ', '011245874', '2020-01-01', '2020-01-01', '2020-01-31', 'JFXComboBox', 'male', '34', '34', '2008-08-14', 'dsfgdfg', 'dsfdsf', '34', 'http://192.168.1.2/members_profile_imgs/Social_Gym10426C89.jpg', '10 42 6C 89'),
(62, 'xx', 'xx', '2020-01-13', '2020-01-21', '2020-01-18', 'JFXComboBox', 'male', 'x', 'x', '2020-01-13', 'x', 'x', '34', 'http://192.168.1.2/members_profile_imgs/Social_GymC03120A8.jpg', 'C6 88 7C 89'),
(63, 'yuy', '6765', '2020-01-09', '2020-01-16', '2020-01-03', 'JFXComboBox', 'male', '56', '45', '2020-01-23', 'cdgfd', 'fdgdf', '34', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'E6 F4 4B 79'),
(64, 'melegy', '23154654065046', '2020-01-08', '2020-01-09', '2020-01-16', 'JFXComboBox', 'female', '85', '85', '2020-01-09', 'yyyyy', 'yyyyy', '34', 'http://192.168.1.2/members_profile_imgs/Social_GymC03120A8.jpg', 'C0 31 20 A8');

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `_id` int(11) NOT NULL,
  `massage_head` text COLLATE utf8_bin NOT NULL,
  `massage_body` text COLLATE utf8_bin NOT NULL,
  `massage_time_date` text COLLATE utf8_bin NOT NULL,
  `massage_icon` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `notification`
--

INSERT INTO `notification` (`_id`, `massage_head`, `massage_body`, `massage_time_date`, `massage_icon`) VALUES
(113, 'uyuy', 'ffjhgkjhkjhjkhjkhjk\nbgjkhkjhkhjkhjkhkjhkjhkj\nwww.facebook.com', '23-January 12:52 PM', 'Question'),
(114, 'مسابقه جديده', 'جيم 33 عامل مسابقه لو كسبت هتاخد خصم 25% على تجديد اشتراك لو جيت الجيم 10 ايام ورا بعض من غير انقطاع هتكون كسبت معانا و تستاهل الخصم  \r\n\r\nجيم 33 عامل مسابقه لو كسبت هتاخد خصم 25% على تجديد اشتراك لو جيت الجيم 10 ايام ورا بعض من غير انقطاع هتكون كسبت معانا و تستاهل الخصم  \r\n\r\nجيم 33 عامل مسابقه لو كسبت هتاخد خصم 25% على تجديد اشتراك لو جيت الجيم 10 ايام ورا بعض من غير انقطاع هتكون كسبت معانا و تستاهل الخصم  \r\n\r\nجيم 33 عامل مسابقه لو كسبت هتاخد خصم 25% على تجديد اشتراك لو جيت الجيم 10 ايام ورا بعض من غير انقطاع هتكون كسبت معانا و تستاهل الخصم  \r\n\r\nجيم 33 عامل مسابقه لو كسبت هتاخد خصم 25% على تجديد اشتراك لو جيت الجيم 10 ايام ورا بعض من غير انقطاع هتكون كسبت معانا و تستاهل الخصم  \r\n\r\nجيم 33 عامل مسابقه لو كسبت هتاخد خصم 25% على تجديد اشتراك لو جيت الجيم 10 ايام ورا بعض من غير انقطاع هتكون كسبت معانا و تستاهل الخصم  \r\n\r\nجيم 33 عامل مسابقه لو كسبت هتاخد خصم 25% على تجديد اشتراك لو جيت الجيم 10 ايام ورا بعض من غير انقطاع هتكون كسبت معانا و تستاهل الخصم  \r\n\r\nجيم 33 عامل مسابقه لو كسبت هتاخد خصم 25% على تجديد اشتراك لو جيت الجيم 10 ايام ورا بعض من غير انقطاع هتكون كسبت معانا و تستاهل الخصم  \r\n\r\nجيم 33 عامل مسابقه لو كسبت هتاخد خصم 25% على تجديد اشتراك لو جيت الجيم 10 ايام ورا بعض من غير انقطاع هتكون كسبت معانا و تستاهل الخصم  \r\n\r\nجيم 33 عامل مسابقه لو كسبت هتاخد خصم 25% على تجديد اشتراك لو جيت الجيم 10 ايام ورا بعض من غير انقطاع هتكون كسبت معانا و تستاهل الخصم  \r\n\r\nجيم 33 عامل مسابقه لو كسبت هتاخد خصم 25% على تجديد اشتراك لو جيت الجيم 10 ايام ورا بعض من غير انقطاع هتكون كسبت معانا و تستاهل الخصم  \r\n\r\n\r\n\r\n', '24-January 00:37 AM', 'Product'),
(115, 'jhjhh', 'yhyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy\n\n', '24-January 17:20 PM', 'Idea'),
(116, 'mguk', 'ukgtuilytoi\n\n', '24-January 17:24 PM', 'Idea'),
(117, 'mmmmmmmmmmm', 'mmmmmmmmmmmmmmmmmmmm\n\n', '24-January 17:32 PM', 'Caution');

-- --------------------------------------------------------

--
-- Table structure for table `staff_data`
--

CREATE TABLE `staff_data` (
  `_id` int(200) NOT NULL,
  `full_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `phone_number` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_name` varchar(200) COLLATE utf16_bin NOT NULL,
  `user_password` varchar(200) COLLATE utf16_bin NOT NULL,
  `staff_birthdate` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `staff_start_date` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `jop_title` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_privileges` varchar(200) COLLATE utf16_bin NOT NULL,
  `gender` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `staff_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `staff_hint` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `image_titel` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `image` text COLLATE utf16_bin NOT NULL,
  `RFID` varchar(200) COLLATE utf16_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_bin;

--
-- Dumping data for table `staff_data`
--

INSERT INTO `staff_data` (`_id`, `full_name`, `phone_number`, `user_name`, `user_password`, `staff_birthdate`, `staff_start_date`, `jop_title`, `user_privileges`, `gender`, `staff_address`, `staff_hint`, `image_titel`, `image`, `RFID`) VALUES
(44, '', '3', 'm', 'm', '', '', '', '', '', '', '', '', '', '4'),
(45, 'gygy34', '015445475434', 'mostafa34', '17293334', '2020-01-15', '2020-01-20', 'JFXComboBox', 'JFXComboBox', 'female', 'hmfgjyh34', 'jgkj34', '34', 'http://192.168.1.2/members_profile_imgs/defult_user_profile.png', 'E6 F4 4B 79');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adpost`
--
ALTER TABLE `adpost`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `ads_pics`
--
ALTER TABLE `ads_pics`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `members_at_the_gym`
--
ALTER TABLE `members_at_the_gym`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `members_workout_history`
--
ALTER TABLE `members_workout_history`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `member_data`
--
ALTER TABLE `member_data`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `staff_data`
--
ALTER TABLE `staff_data`
  ADD PRIMARY KEY (`_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adpost`
--
ALTER TABLE `adpost`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `ads_pics`
--
ALTER TABLE `ads_pics`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `members_at_the_gym`
--
ALTER TABLE `members_at_the_gym`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=220;

--
-- AUTO_INCREMENT for table `members_workout_history`
--
ALTER TABLE `members_workout_history`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;

--
-- AUTO_INCREMENT for table `member_data`
--
ALTER TABLE `member_data`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=118;

--
-- AUTO_INCREMENT for table `staff_data`
--
ALTER TABLE `staff_data`
  MODIFY `_id` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
