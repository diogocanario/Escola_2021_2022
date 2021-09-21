-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 30, 2020 at 09:29 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `yii2advanced`
--

-- --------------------------------------------------------

--
-- Table structure for table `branches`
--

DROP TABLE IF EXISTS `branches`;
CREATE TABLE IF NOT EXISTS `branches` (
  `branch_id` int(11) NOT NULL AUTO_INCREMENT,
  `companies_company_id` int(11) DEFAULT NULL,
  `branch_name` varchar(100) DEFAULT NULL,
  `branch_address` varchar(255) DEFAULT NULL,
  `branch_created_date` datetime DEFAULT NULL,
  `branch_status` enum('active','inactive') DEFAULT NULL,
  PRIMARY KEY (`branch_id`),
  KEY `fk_branches_companies` (`companies_company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `companies`
--

DROP TABLE IF EXISTS `companies`;
CREATE TABLE IF NOT EXISTS `companies` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(100) DEFAULT NULL,
  `company_email` varchar(100) DEFAULT NULL,
  `company_address` varchar(255) DEFAULT NULL,
  `company_created_date` datetime DEFAULT NULL,
  `company_status` enum('active','inactive') DEFAULT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `companies`
--

INSERT INTO `companies` (`company_id`, `company_name`, `company_email`, `company_address`, `company_created_date`, `company_status`) VALUES
(3, 'abc1', 'abc2@gmail.com', 'abc', '2020-12-30 00:00:00', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
CREATE TABLE IF NOT EXISTS `departments` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `branches_branch_id` int(11) DEFAULT NULL,
  `department_name` varchar(100) DEFAULT NULL,
  `companies_company_id` int(11) DEFAULT NULL,
  `department_created_date` datetime DEFAULT NULL,
  `department_status` enum('active','inactive') DEFAULT NULL,
  PRIMARY KEY (`department_id`),
  KEY `fk_departments_branches` (`branches_branch_id`),
  KEY `fk_departments_companies` (`companies_company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `migration`
--

DROP TABLE IF EXISTS `migration`;
CREATE TABLE IF NOT EXISTS `migration` (
  `version` varchar(180) NOT NULL,
  `apply_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `migration`
--

INSERT INTO `migration` (`version`, `apply_time`) VALUES
('m000000_000000_base', 1476198955),
('m130524_201442_init', 1476199133),
('m161011_152921_modify_user_table', 1476200137),
('m161011_160958_create_departments_table', 1476203113),
('m161011_161018_create_companies_table', 1476203113),
('m161011_161027_create_branches_table', 1476205318),
('m161011_162841_create_fk_branch_id_branches_departments', 1476205318),
('m161011_165819_create_fk_2_more_fk', 1476205339),
('m190124_110200_add_verification_token_column_to_user_table', 1609350284);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `auth_key` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `password_hash` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password_reset_token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT 10,
  `created_at` int(11) NOT NULL,
  `updated_at` int(11) NOT NULL,
  `verification_token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `password_reset_token` (`password_reset_token`)
) ENGINE=InnoDB AUTO_INCREMENT=213 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `auth_key`, `password_hash`, `password_reset_token`, `email`, `status`, `created_at`, `updated_at`, `verification_token`) VALUES
(1, NULL, NULL, 'user1', 'eXP3HmpLwwMQLf5OMfGULoCfpL6XyUz1', '$2y$13$yuEi7U57ZfxyxBXHAStXpell.FmeE8tGH0njshZv1avlGJkjjU7ue', NULL, 'email1@email1.com', 10, 1609350358, 1609350358, 'eHlCi7YqoCfaHTEXvda9_yW0DEhV_SLF_1609350358'),
(2, NULL, NULL, 'user2', '4Av6HdPmxcXgOktiiirD40T6yhuHexU0', '$2y$13$DXCjI71BwUih/EoMbEN28.hbHjtJTvpF6h6bd9PjFq4TSWTx/05wu', NULL, 'user2@user2.com', 10, 1609350641, 1609350641, 'biRVJFI90wMOb9I8NHKb95MwoxXoHEb2_1609350641'),
(3, NULL, NULL, 'user3', 'KdyRWNlPQdN6DNLfhK_LB7rpfAWgHl1G', '$2y$13$wCROlxrj/xOgSBmhyP9fo.o4uGpAjIoV9thaz6pAueV.7p57m3JPe', NULL, 'user@user.com', 9, 1609351960, 1609351960, 'O2LnTbeMVCgM7ncrLRDUXHDDzHi6TCGj_1609351960'),
(4, 'diogo', 'joao', 'user4', '_yFP72RzfxJ_zwrpHElGWefh1hjeZV7j', '$2y$13$MUmqQy27rHszufnuJO1gQuzyZvX3Gc26eiZisqBAIOzI0UhRbs4qC', NULL, 'user@user1.com', 9, 1609352614, 1609352614, 'h2dYJkpsAZvGcdjTW6LpLhehxRRh3wG9_1609352614');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `branches`
--
ALTER TABLE `branches`
  ADD CONSTRAINT `fk_branches_companies` FOREIGN KEY (`companies_company_id`) REFERENCES `companies` (`company_id`);

--
-- Constraints for table `departments`
--
ALTER TABLE `departments`
  ADD CONSTRAINT `fk_departments_branches` FOREIGN KEY (`branches_branch_id`) REFERENCES `branches` (`branch_id`),
  ADD CONSTRAINT `fk_departments_companies` FOREIGN KEY (`companies_company_id`) REFERENCES `companies` (`company_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
