-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 24, 2021 at 09:59 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `latbootcamp`
--

-- --------------------------------------------------------

--
-- Table structure for table `userdata`
--

CREATE TABLE `userdata` (
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userdata`
--

INSERT INTO `userdata` (`name`, `address`, `gender`, `age`, `password`) VALUES
('bobby', 'kemang', 'Male', 1, 'bobbY7iga'),
('richard', 'pade', 'Male', 3, 'richard123R'),
('Paimon', 'Teyvat', 'Female', 1, 'epicGames1'),
('Aichan', 'impact the 3rd', 'Female', 1, 'honkaiImpact3rd'),
('2b', 'nier', 'Female', 10, 'nierAuto3'),
('Ben', 'Mondstat', 'Male', 4, 'boukenDa2'),
('Xinyan', 'Liyue', 'Female', 4, 'rokuDayo1'),
('Tohma', 'Inazuma', 'Male', 4, 'inuMaru3'),
('HOV', 'HI3', 'Female', 1, 'shinNe1122'),
('Andi', 'Kembang sepatu', 'Male', 5, 'andiAnd12'),
('Bagas', 'Jalan Kebangsaan', 'Male', 1, 'Bagas3131'),
('Dodi', 'tetangga', 'Male', 4, 'Doddy121'),
('Giga', 'Dimanamana', 'Female', 3, 'Gigabyte123'),
('Yunanto', 'Sekolah', 'Male', 2, 'besokSenin12'),
('Zara', 'Deket sini', 'Female', 3, 'Zarasa12'),
('Cia', 'sekolah', 'Female', 3, 'ciatciatW2'),
('Amichon', 'Tetangga', 'Female', 4, 'Amichon2324'),
('Jukut', 'Bekasi', 'Male', 4, 'JukutJuk23'),
('Salto', 'atletis', 'Male', 3, 'bapakKaoSalt0'),
('Sleb', 'Spring', 'Female', 4, 'Sleb2324'),
('Claymore', 'Balcksmith', 'Male', 3, 'Prototype123'),
('Kusa', 'Ground', 'Male', 3, 'rumputYangb3'),
('Noelle', 'Mondstat', 'Female', 4, 'tankerT1');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
