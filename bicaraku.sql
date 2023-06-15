-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 15, 2023 at 07:40 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bicaraku`
--

-- --------------------------------------------------------

--
-- Table structure for table `detailhuruf`
--

CREATE TABLE `detailhuruf` (
  `id` int(11) NOT NULL,
  `idhuruf` int(11) NOT NULL,
  `gambar` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detailhuruf`
--

INSERT INTO `detailhuruf` (`id`, `idhuruf`, `gambar`) VALUES
(7, 7, 'https://storage.googleapis.com/bicaraku-storage/kamus/A/A%20(119).jpeg'),
(8, 7, ' https://storage.googleapis.com/bicaraku-storage/kamus/A/A%20(26).jpeg'),
(9, 7, 'https://storage.googleapis.com/bicaraku-storage/kamus/A/A_1.jpg'),
(10, 8, 'https://storage.googleapis.com/bicaraku-storage/kamus/B/B%20(103).jpeg'),
(11, 8, 'https://storage.googleapis.com/bicaraku-storage/kamus/B/B%20(211).jpeg'),
(12, 8, 'https://storage.googleapis.com/bicaraku-storage/kamus/B/B_1.jpg'),
(13, 9, 'https://storage.googleapis.com/bicaraku-storage/kamus/C/C%20(115).jpeg'),
(14, 9, 'https://storage.googleapis.com/bicaraku-storage/kamus/C/C%20(124).jpeg'),
(15, 9, 'https://storage.googleapis.com/bicaraku-storage/kamus/C/C%20(124).jpeg'),
(16, 10, 'https://storage.googleapis.com/bicaraku-storage/kamus/D/D%20(142).jpeg'),
(17, 10, 'https://storage.googleapis.com/bicaraku-storage/kamus/D/D%20(69).jpeg'),
(18, 10, 'https://storage.googleapis.com/bicaraku-storage/kamus/D/D_1.jpg'),
(19, 11, 'https://storage.googleapis.com/bicaraku-storage/kamus/E/E%20(40).jpeg'),
(20, 11, 'https://storage.googleapis.com/bicaraku-storage/kamus/E/E%20(93).jpeg'),
(21, 11, 'https://storage.googleapis.com/bicaraku-storage/kamus/E/E_1.jpg'),
(22, 12, 'https://storage.googleapis.com/bicaraku-storage/kamus/F/F%20(103).jpeg'),
(23, 12, 'https://storage.googleapis.com/bicaraku-storage/kamus/F/F%20(391).jpeg'),
(24, 12, 'https://storage.googleapis.com/bicaraku-storage/kamus/F/F_1.jpg'),
(25, 13, 'https://storage.googleapis.com/bicaraku-storage/kamus/G/G%20(15).jpg'),
(26, 13, 'https://storage.googleapis.com/bicaraku-storage/kamus/G/G%20(165).jpeg'),
(27, 13, 'https://storage.googleapis.com/bicaraku-storage/kamus/G/G%20(85).jpeg'),
(28, 14, 'https://storage.googleapis.com/bicaraku-storage/kamus/H/H%20(57).jpeg'),
(29, 14, 'https://storage.googleapis.com/bicaraku-storage/kamus/H/H%20(89).jpeg'),
(30, 14, 'https://storage.googleapis.com/bicaraku-storage/kamus/H/H_1.jpg'),
(31, 15, 'https://storage.googleapis.com/bicaraku-storage/kamus/I/I%20(58).jpeg'),
(32, 15, 'https://storage.googleapis.com/bicaraku-storage/kamus/I/I%20(89).jpeg'),
(33, 15, 'https://storage.googleapis.com/bicaraku-storage/kamus/I/I_1.jpg'),
(34, 16, 'https://storage.googleapis.com/bicaraku-storage/kamus/J/J%20(3).jpg'),
(35, 16, 'https://storage.googleapis.com/bicaraku-storage/kamus/J/J%20(9).jpg'),
(36, 16, 'https://storage.googleapis.com/bicaraku-storage/kamus/J/J_1.jpg'),
(40, 17, 'https://storage.googleapis.com/bicaraku-storage/kamus/K/K%20(110).jpeg'),
(41, 17, 'https://storage.googleapis.com/bicaraku-storage/kamus/K/K%20(228).jpeg'),
(42, 17, 'https://storage.googleapis.com/bicaraku-storage/kamus/K/K_1.jpg'),
(43, 18, 'https://storage.googleapis.com/bicaraku-storage/kamus/L/L%20(108).jpeg'),
(44, 18, 'https://storage.googleapis.com/bicaraku-storage/kamus/L/L%20(44).jpeg'),
(45, 18, 'https://storage.googleapis.com/bicaraku-storage/kamus/L/L_4.jpg'),
(46, 19, 'https://storage.googleapis.com/bicaraku-storage/kamus/M/M%20(176).jpeg'),
(47, 19, 'https://storage.googleapis.com/bicaraku-storage/kamus/M/M%20(89).jpeg'),
(48, 19, 'https://storage.googleapis.com/bicaraku-storage/kamus/M/M_1.jpg'),
(49, 20, 'https://storage.googleapis.com/bicaraku-storage/kamus/N/N%20(148).jpeg'),
(50, 20, 'https://storage.googleapis.com/bicaraku-storage/kamus/N/N%20(94).jpeg'),
(51, 20, 'https://storage.googleapis.com/bicaraku-storage/kamus/N/N_1.jpg'),
(52, 21, 'https://storage.googleapis.com/bicaraku-storage/kamus/O/O%20(145).jpeg'),
(53, 21, 'https://storage.googleapis.com/bicaraku-storage/kamus/O/O%20(68).jpeg'),
(54, 21, 'https://storage.googleapis.com/bicaraku-storage/kamus/O/O_1.jpg'),
(55, 22, 'https://storage.googleapis.com/bicaraku-storage/kamus/P/P%20(102).jpeg'),
(56, 22, 'https://storage.googleapis.com/bicaraku-storage/kamus/P/P%20(175).jpeg'),
(57, 22, 'https://storage.googleapis.com/bicaraku-storage/kamus/P/P_1.jpg'),
(58, 23, 'https://storage.googleapis.com/bicaraku-storage/kamus/Q/Q%20(112).jpeg'),
(59, 23, 'https://storage.googleapis.com/bicaraku-storage/kamus/Q/Q%20(80).jpeg'),
(60, 23, 'https://storage.googleapis.com/bicaraku-storage/kamus/Q/Q_1.jpg'),
(61, 24, 'https://storage.googleapis.com/bicaraku-storage/kamus/R/R%20(148).jpeg'),
(62, 24, 'https://storage.googleapis.com/bicaraku-storage/kamus/R/R%20(75).jpeg'),
(63, 24, 'https://storage.googleapis.com/bicaraku-storage/kamus/R/R_1.jpg'),
(64, 25, 'https://storage.googleapis.com/bicaraku-storage/kamus/S/S%20(107).jpeg'),
(65, 25, 'https://storage.googleapis.com/bicaraku-storage/kamus/S/S%20(161).jpeg'),
(66, 25, 'https://storage.googleapis.com/bicaraku-storage/kamus/S/S_01.jpg'),
(67, 26, 'https://storage.googleapis.com/bicaraku-storage/kamus/T/T%20(111).jpeg'),
(68, 26, 'https://storage.googleapis.com/bicaraku-storage/kamus/T/T%20(201).jpeg'),
(69, 26, 'https://storage.googleapis.com/bicaraku-storage/kamus/T/T_1.jpg'),
(70, 27, 'https://storage.googleapis.com/bicaraku-storage/kamus/U/U%20(112).jpeg'),
(71, 27, 'https://storage.googleapis.com/bicaraku-storage/kamus/U/U%20(215).jpeg'),
(72, 27, 'https://storage.googleapis.com/bicaraku-storage/kamus/U/U_1.jpg'),
(73, 28, 'https://storage.googleapis.com/bicaraku-storage/kamus/V/V%20(134).jpeg'),
(74, 28, 'https://storage.googleapis.com/bicaraku-storage/kamus/V/V%20(148).jpeg'),
(75, 28, 'https://storage.googleapis.com/bicaraku-storage/kamus/V/V_1.jpg'),
(76, 29, 'https://storage.googleapis.com/bicaraku-storage/kamus/W/W%20(134).jpeg'),
(77, 29, 'https://storage.googleapis.com/bicaraku-storage/kamus/W/W%20(75).jpeg'),
(78, 29, 'https://storage.googleapis.com/bicaraku-storage/kamus/W/W_1.jpg'),
(79, 30, 'https://storage.googleapis.com/bicaraku-storage/kamus/X/X%20(161).jpeg'),
(80, 30, 'https://storage.googleapis.com/bicaraku-storage/kamus/X/X%20(197).jpeg'),
(81, 30, 'https://storage.googleapis.com/bicaraku-storage/kamus/X/X_1.jpg'),
(82, 31, 'https://storage.googleapis.com/bicaraku-storage/kamus/Y/Y%20(170).jpeg'),
(83, 31, ' https://storage.googleapis.com/bicaraku-storage/kamus/Y/Y%20(93).jpeg'),
(84, 31, 'https://storage.googleapis.com/bicaraku-storage/kamus/Y/Y_1.jpg'),
(85, 32, 'https://storage.googleapis.com/bicaraku-storage/kamus/Z/Z%20(2).jpg'),
(86, 32, 'https://storage.googleapis.com/bicaraku-storage/kamus/Z/Z_1.jpg'),
(87, 32, 'https://storage.googleapis.com/bicaraku-storage/kamus/Z/Z_6.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `huruf`
--

CREATE TABLE `huruf` (
  `idhuruf` int(11) NOT NULL,
  `teks` varchar(10) NOT NULL,
  `gambar` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `huruf`
--

INSERT INTO `huruf` (`idhuruf`, `teks`, `gambar`) VALUES
(7, 'A', 'https://storage.googleapis.com/bicaraku-storage/kamus/A/A%20(1).jpeg'),
(8, 'B', 'https://storage.googleapis.com/bicaraku-storage/kamus/B/B%20(1).jpeg'),
(9, 'C', 'https://storage.googleapis.com/bicaraku-storage/kamus/C/C%20(1).jpeg'),
(10, 'D', 'https://storage.googleapis.com/bicaraku-storage/kamus/D/D%20(1).jpeg'),
(11, 'E', 'https://storage.googleapis.com/bicaraku-storage/kamus/E/E%20(1).jpeg'),
(12, 'F', 'https://storage.googleapis.com/bicaraku-storage/kamus/F/F%20(1).jpeg'),
(13, 'G', 'https://storage.googleapis.com/bicaraku-storage/kamus/G/G%20(1).jpeg'),
(14, 'H', 'https://storage.googleapis.com/bicaraku-storage/kamus/H/H%20(1).jpeg'),
(15, 'I', 'https://storage.googleapis.com/bicaraku-storage/kamus/I/I%20(1).jpeg'),
(16, 'J', 'https://storage.googleapis.com/bicaraku-storage/kamus/J/J%20(12).jpg'),
(17, 'K', 'https://storage.googleapis.com/bicaraku-storage/kamus/K/K%20(101).jpeg'),
(18, 'L', 'https://storage.googleapis.com/bicaraku-storage/kamus/L/L%20(1).jpeg'),
(19, 'M', 'https://storage.googleapis.com/bicaraku-storage/kamus/M/M%20(1).jpeg'),
(20, 'N', 'https://storage.googleapis.com/bicaraku-storage/kamus/N/N%20(1).jpeg'),
(21, 'O', 'https://storage.googleapis.com/bicaraku-storage/kamus/O/O%20(1).jpeg'),
(22, 'P', 'https://storage.googleapis.com/bicaraku-storage/kamus/P/P%20(1).jpeg'),
(23, 'Q', 'https://storage.googleapis.com/bicaraku-storage/kamus/Q/Q%20(1).jpeg'),
(24, 'R', 'https://storage.googleapis.com/bicaraku-storage/kamus/R/R%20(1).jpeg'),
(25, 'S', ' https://storage.googleapis.com/bicaraku-storage/kamus/S/S%20(1).jpeg'),
(26, 'T', 'https://storage.googleapis.com/bicaraku-storage/kamus/T/T%20(1).jpeg'),
(27, 'U', ' https://storage.googleapis.com/bicaraku-storage/kamus/U/U%20(1).jpeg'),
(28, 'V', 'https://storage.googleapis.com/bicaraku-storage/kamus/V/V%20(1).jpeg'),
(29, 'W', 'https://storage.googleapis.com/bicaraku-storage/kamus/W/W%20(1).jpeg'),
(30, 'X', 'https://storage.googleapis.com/bicaraku-storage/kamus/X/X%20(1).jpeg'),
(31, 'Y', 'https://storage.googleapis.com/bicaraku-storage/kamus/Y/Y%20(1).jpeg'),
(32, 'Z', 'https://storage.googleapis.com/bicaraku-storage/kamus/Z/Z%20(10).jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detailhuruf`
--
ALTER TABLE `detailhuruf`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idhuruf` (`idhuruf`);

--
-- Indexes for table `huruf`
--
ALTER TABLE `huruf`
  ADD PRIMARY KEY (`idhuruf`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detailhuruf`
--
ALTER TABLE `detailhuruf`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=88;

--
-- AUTO_INCREMENT for table `huruf`
--
ALTER TABLE `huruf`
  MODIFY `idhuruf` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
