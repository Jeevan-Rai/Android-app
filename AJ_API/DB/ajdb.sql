-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2023 at 10:28 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ajdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `Branch_ID` int(11) NOT NULL,
  `Branch_Name` varchar(20) NOT NULL,
  `Description` varchar(50) NOT NULL,
  `Status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `br_details`
--

CREATE TABLE `br_details` (
  `Br_Details_ID` int(11) NOT NULL,
  `Branch_ID` int(11) NOT NULL,
  `Br_Details_Name` varchar(20) NOT NULL,
  `Description` varchar(50) NOT NULL,
  `Status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `class_id` int(11) NOT NULL,
  `classname` varchar(30) NOT NULL,
  `section` varchar(10) NOT NULL,
  `stream_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `Fac_ID` int(20) NOT NULL,
  `Fname` varchar(20) NOT NULL,
  `Lname` varchar(20) NOT NULL,
  `Phone_No` int(15) NOT NULL,
  `Email_ID` varchar(20) NOT NULL,
  `Add_1` varchar(40) NOT NULL,
  `Add_2` varchar(40) NOT NULL,
  `Pincode` varchar(7) NOT NULL,
  `Status` varchar(10) NOT NULL,
  `Gender` varchar(8) NOT NULL,
  `Qualification` varchar(20) NOT NULL,
  `password` varchar(15) NOT NULL,
  `url` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

CREATE TABLE `marks` (
  `Marks_ID` int(11) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `Test_ID` int(11) NOT NULL,
  `Student_ID` int(11) NOT NULL,
  `mark` varchar(5) NOT NULL,
  `atts` int(11) NOT NULL,
  `tatts` int(11) NOT NULL,
  `Sub_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `stream`
--

CREATE TABLE `stream` (
  `stream_id` int(11) NOT NULL,
  `combination` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Fname` varchar(15) DEFAULT NULL,
  `Lname` varchar(15) DEFAULT NULL,
  `Student_ID` int(20) NOT NULL,
  `stream_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `Roll_No` varchar(20) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Phone_No` varchar(15) DEFAULT NULL,
  `Email_ID` varchar(25) DEFAULT NULL,
  `Remarks` text DEFAULT NULL,
  `Reg_No` int(20) DEFAULT NULL,
  `SATS_No` int(11) DEFAULT NULL,
  `Enroll_No` int(11) DEFAULT NULL,
  `Fathers_Name` varchar(25) DEFAULT NULL,
  `Mothers_Name` varchar(25) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Address_1` varchar(30) DEFAULT NULL,
  `Address_2` varchar(30) DEFAULT NULL,
  `City` varchar(25) DEFAULT NULL,
  `Pincode` varchar(7) DEFAULT NULL,
  `url` varchar(80) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `subfac`
--

CREATE TABLE `subfac` (
  `subfacid` int(11) NOT NULL,
  `Fac_ID` int(11) NOT NULL,
  `Sub_ID` int(11) NOT NULL,
  `sem` varchar(5) NOT NULL,
  `sec` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `Sub_ID` int(11) NOT NULL,
  `Sub_Name` varchar(20) NOT NULL,
  `Description` text NOT NULL,
  `Sub_Code` varchar(25) DEFAULT NULL,
  `Status` varchar(30) NOT NULL,
  `Branch_ID` int(11) NOT NULL,
  `stream_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE `test` (
  `Test_ID` int(11) NOT NULL,
  `Test_Name` varchar(25) NOT NULL,
  `Max_marks` int(11) NOT NULL,
  `Description` text NOT NULL,
  `Sub_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`Branch_ID`);

--
-- Indexes for table `br_details`
--
ALTER TABLE `br_details`
  ADD PRIMARY KEY (`Br_Details_ID`),
  ADD KEY `Branch_ID` (`Branch_ID`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`class_id`),
  ADD KEY `stream_id` (`stream_id`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`Fac_ID`);

--
-- Indexes for table `marks`
--
ALTER TABLE `marks`
  ADD PRIMARY KEY (`Marks_ID`),
  ADD KEY `Test_ID` (`Test_ID`),
  ADD KEY `Student_ID` (`Student_ID`),
  ADD KEY `Sub_ID` (`Sub_ID`);

--
-- Indexes for table `stream`
--
ALTER TABLE `stream`
  ADD PRIMARY KEY (`stream_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`Student_ID`),
  ADD KEY `stream_id` (`stream_id`),
  ADD KEY `class_id` (`class_id`);

--
-- Indexes for table `subfac`
--
ALTER TABLE `subfac`
  ADD PRIMARY KEY (`subfacid`),
  ADD KEY `Fac_ID` (`Fac_ID`),
  ADD KEY `Sub_ID` (`Sub_ID`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`Sub_ID`),
  ADD KEY `Branch_ID` (`Branch_ID`),
  ADD KEY `stream_id` (`stream_id`);

--
-- Indexes for table `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`Test_ID`),
  ADD KEY `Sub_ID` (`Sub_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `branch`
--
ALTER TABLE `branch`
  MODIFY `Branch_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `br_details`
--
ALTER TABLE `br_details`
  MODIFY `Br_Details_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `class_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `faculty`
--
ALTER TABLE `faculty`
  MODIFY `Fac_ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `marks`
--
ALTER TABLE `marks`
  MODIFY `Marks_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1235;

--
-- AUTO_INCREMENT for table `stream`
--
ALTER TABLE `stream`
  MODIFY `stream_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `Student_ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1235;

--
-- AUTO_INCREMENT for table `subfac`
--
ALTER TABLE `subfac`
  MODIFY `subfacid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `Sub_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `test`
--
ALTER TABLE `test`
  MODIFY `Test_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `br_details`
--
ALTER TABLE `br_details`
  ADD CONSTRAINT `br_details_ibfk_1` FOREIGN KEY (`Branch_ID`) REFERENCES `branch` (`Branch_ID`);

--
-- Constraints for table `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `class_ibfk_1` FOREIGN KEY (`stream_id`) REFERENCES `stream` (`stream_id`);

--
-- Constraints for table `marks`
--
ALTER TABLE `marks`
  ADD CONSTRAINT `marks_ibfk_1` FOREIGN KEY (`Test_ID`) REFERENCES `test` (`Test_ID`),
  ADD CONSTRAINT `marks_ibfk_2` FOREIGN KEY (`Student_ID`) REFERENCES `student` (`Student_ID`),
  ADD CONSTRAINT `marks_ibfk_3` FOREIGN KEY (`Sub_ID`) REFERENCES `subject` (`Sub_ID`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`stream_id`) REFERENCES `stream` (`stream_id`),
  ADD CONSTRAINT `student_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`);

--
-- Constraints for table `subfac`
--
ALTER TABLE `subfac`
  ADD CONSTRAINT `subfac_ibfk_1` FOREIGN KEY (`Fac_ID`) REFERENCES `faculty` (`Fac_ID`),
  ADD CONSTRAINT `subfac_ibfk_2` FOREIGN KEY (`Sub_ID`) REFERENCES `subject` (`Sub_ID`);

--
-- Constraints for table `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`stream_id`) REFERENCES `stream` (`stream_id`);

--
-- Constraints for table `test`
--
ALTER TABLE `test`
  ADD CONSTRAINT `test_ibfk_1` FOREIGN KEY (`Sub_ID`) REFERENCES `subject` (`Sub_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
