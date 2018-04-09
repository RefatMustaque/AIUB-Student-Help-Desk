-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 10, 2018 at 02:44 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `phonebook`
--

-- --------------------------------------------------------

--
-- Table structure for table `catagory`
--

CREATE TABLE `catagory` (
  `Id` int(250) NOT NULL,
  `catagory` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `catagory`
--

INSERT INTO `catagory` (`Id`, `catagory`) VALUES
(1, 'Friend'),
(2, 'Teacher'),
(3, 'Classmate'),
(4, 'Junior'),
(5, 'Known'),
(6, 'Relative'),
(7, 'Senior'),
(8, 'Close Relative');

-- --------------------------------------------------------

--
-- Table structure for table `completedcourse`
--

CREATE TABLE `completedcourse` (
  `Id` int(250) NOT NULL,
  `CourseName` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `completedcourse`
--

INSERT INTO `completedcourse` (`Id`, `CourseName`) VALUES
(10, '[Object Oriented Programming I]'),
(11, '[Chemistry]');

-- --------------------------------------------------------

--
-- Table structure for table `courselist`
--

CREATE TABLE `courselist` (
  `Id` int(250) NOT NULL,
  `CourseName` varchar(250) NOT NULL,
  `PREREQ.` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courselist`
--

INSERT INTO `courselist` (`Id`, `CourseName`, `PREREQ.`) VALUES
(1, 'Bangla', ''),
(2, 'English', ''),
(3, 'Microprocessor', ''),
(4, 'Business Communication', ''),
(5, 'Object Oriented Programming I', ''),
(6, 'Physics', ''),
(7, 'Chemistry', '');

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `ID` int(250) NOT NULL,
  `Name` varchar(250) NOT NULL,
  `Address` varchar(250) NOT NULL,
  `Phone` varchar(250) NOT NULL,
  `Email` varchar(250) NOT NULL,
  `Catagory` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`ID`, `Name`, `Address`, `Phone`, `Email`, `Catagory`) VALUES
(2, 'Tonmoy', 'Mirpur', '0928372617261', 'tonmoy@gmail.com', 'Friend'),
(6, 'Labiba', 'Savar', '028372819372', 'labiba@gmail.com', 'Known'),
(10, 'Tanvir', 'Sirajganj', '2345532', 'tanvir@gmail.com', 'Known'),
(11, 'Johorul Islam', 'Dhaka', '2345522', 'johorul@gmail.com', 'Relative');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `catagory`
--
ALTER TABLE `catagory`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `completedcourse`
--
ALTER TABLE `completedcourse`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `courselist`
--
ALTER TABLE `courselist`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Unique` (`Email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `catagory`
--
ALTER TABLE `catagory`
  MODIFY `Id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `completedcourse`
--
ALTER TABLE `completedcourse`
  MODIFY `Id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `courselist`
--
ALTER TABLE `courselist`
  MODIFY `Id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `ID` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
