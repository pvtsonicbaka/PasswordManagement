-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 20, 2024 at 12:26 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `passwordManagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `login_logs`
--

CREATE TABLE `login_logs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(255) NOT NULL,
  `login_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `password_update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login_logs`
--

INSERT INTO `login_logs` (`id`, `username`, `login_time`, `password_update_time`) VALUES
(13, 'sajjad', '2024-08-20 09:34:56', '0000-00-00 00:00:00'),
(14, 'sajjad', '2024-08-20 09:36:54', '0000-00-00 00:00:00'),
(15, 'sajjad', '2024-08-20 09:37:25', '0000-00-00 00:00:00'),
(16, 'sajjad', '2024-08-20 09:40:31', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(255) NOT NULL,
  `hashed_password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `hashed_password`) VALUES
(3, 'sajjad', '03ac674216f3e15c761ee1a5e255f067');

--
-- Triggers `users`
--
DELIMITER $$
CREATE TRIGGER `deleteUserLogs` AFTER DELETE ON `users` FOR EACH ROW BEGIN
	DELETE from login_logs WHERE  username = old.username;
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login_logs`
--
ALTER TABLE `login_logs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login_logs`
--
ALTER TABLE `login_logs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
