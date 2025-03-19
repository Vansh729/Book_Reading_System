-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 29, 2024 at 06:48 AM
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
-- Database: `ebook`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `passpin` (IN `use_name` VARCHAR(50), OUT `pin` VARCHAR(50))   BEGIN
SELECT  pass_code into pin from user where user_name=use_name;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `book_id` int(11) NOT NULL,
  `book_name` varchar(50) NOT NULL,
  `auther_name` varchar(50) NOT NULL,
  `pages` int(11) NOT NULL,
  `cate_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`book_id`, `book_name`, `auther_name`, `pages`, `cate_id`) VALUES
(1, 'carmilla', 'Joseph Sheridan Le Fanu', 129, 1),
(2, 'Dracula', 'Bram Stoker', 606, 1),
(3, 'Frankenstein', 'Mary Shelley', 331, 1),
(4, 'The Black Cat', 'Edgar Allan Poe', 19, 1),
(5, 'The Call of Cthulhu', 'H.P. Lovecraft', 53, 1),
(6, 'The Canterville Ghost ', 'Oscar Wilde', 53, 1),
(7, 'The Golem', 'Gustav Meyrink', 183, 1),
(8, 'The Phantom of the Opera', 'Gaston Leroux', 337, 1),
(9, 'The Picture of Dorian Gray', 'Oscar Wilde', 229, 1),
(10, 'Journey to the Centre of the Earth', 'Jules Verne', 437, 2),
(11, 'Bleak House', 'Charles Dickens', 1003, 2),
(12, 'From the Earth to the Moon', 'Jules Verne', 457, 2),
(13, 'The Adventures of Pinocchio', 'Carlo Collodi', 148, 2),
(14, 'The Island of Doctor Moreau', 'H.G. Wells', 126, 2),
(15, 'The Mysterious Island', 'Jules Verne', 899, 2),
(16, 'The Night Land', 'William Hope Hodgson', 246, 2),
(17, 'The Wonderful Wizard of Oz', 'L. Frank Baum', 193, 2),
(18, 'The Wood Beyond the World', 'William Morris', 188, 2),
(19, 'Around the Moon', 'Jules Verne', 430, 3),
(20, 'Caesars Column', 'Edmund Morris', 273, 3),
(21, 'Nineteen Eighty-Four', 'George Orwell', 174, 3),
(22, 'The Artist of the Beautiful', 'Nathaniel Hawthorne', 16, 3),
(23, 'The Blazing World', 'Margaret Cavendish', 96, 3),
(24, 'The Brick Moon', 'Edward Everett Hale', 120, 3),
(25, 'The Lost World', 'Arthur Conan Doyle', 205, 3),
(26, 'The Time Machine', 'H.G. Wells', 65, 3),
(27, 'Twenty Thousand Leagues Under the Seas', 'Jules Verne', 350, 3),
(28, 'A Study in Scarlet', 'Arthur Conan Doyle', 122, 4),
(29, 'In the Fog', 'Richard Harding Davis', 58, 4),
(30, 'The Adventures of Sherlock Holmes', 'Arthur Conan Doyle', 269, 4),
(31, 'The Lodger', 'Marie Belloc Lowndes', 224, 4),
(32, 'The Murders in the Rue Morgue', 'Edgar Allan Poe', 57, 4),
(33, 'The Mysterious Affair at Styles', 'Agatha Christie', 179, 4),
(34, 'The Red House Mystery', 'A.A. Milne', 184, 4),
(35, 'The Sign of Four', 'Arthur Conan Doyle', 111, 4),
(36, 'The Vampire', 'John Polidori', 34, 4),
(37, 'Lady Chatterleys Lover', 'D.H. Lawrence', 229, 5),
(38, 'Sense and Sensibility', 'Jane Austen', 551, 5),
(39, 'Anna Karenina', 'Leo Tolstoy', 1604, 5),
(40, 'A Room with a View', 'E.M. Forster', 168, 5),
(41, 'Emma', 'Jane Austen', 666, 5),
(42, 'Jane Eyre', 'Charlotte Brontë', 813, 5),
(43, 'Pride and Prejudice', 'Jane Austen', 273, 5),
(44, 'Persuasion', 'Jane Austen', 171, 5),
(45, 'The Lady of the Camellias', 'Alexandre Dumas fils', 153, 5),
(46, 'Floor Games', 'H.G. Wells', 16, 6),
(47, 'The Discovery of the Future', 'H.G. Wells', 19, 6),
(48, 'The Time Machine', 'H.G. Wells', 66, 6),
(49, 'This Misery of Boots', 'H.G. Wells', 15, 6),
(50, 'A Short History of the World', 'H.G. Wells', 227, 6),
(51, 'The Wonderful Visit', 'H.G. Wells', 148, 6),
(52, 'The Island of Dr. Moreau', 'H.G. Wells', 129, 6),
(53, 'The Invisible Man', 'H.G. Wells', 156, 6),
(54, 'The Wheels of Chance', 'H.G. Wells', 181, 6),
(55, 'Traditional Foods of India', 'S. S. Jonnalagadda', 15, 7),
(56, 'Central and South Indian Cuisine', 'Rama G. S. V. Rao', 32, 7),
(57, 'Pita Bread Pizza Crust', 'Linda Stephen', 1, 7),
(58, '13 Proven Health Benefits of Coffee', 'Dr. John McDougall', 7, 7),
(59, 'Coffee Recipes', 'Various authors', 26, 7),
(60, 'Chocolate Recipe Book', 'Patricia Lousada', 16, 7),
(61, 'Best of Indian Vegetarian Recipes', 'Rama G. S. V. Rao', 20, 7),
(62, 'Thai Green Curry Paste', 'Various authors', 21, 7),
(63, 'The Little Book of Sushi', 'Jenna M. Smith', 21, 7),
(64, 'The Pirate Frog, and Other Tales', 'Lorna M. Pruitt', 139, 8),
(65, 'Philosophy for Children', 'Matthew Lipman', 10, 8),
(66, 'Basic Short Vowels', 'Carole C. Smith', 170, 8),
(67, 'Run!!! A Ghost Comes', 'Sue A. Williams', 18, 8),
(68, 'The Little Mermaid', 'Hans Christian Andersen', 19, 8),
(69, 'Dinosaurs On Alaska’s North Slope', 'David W. Elliott', 16, 8),
(70, 'A Unicorn', 'M. R. S. Wood', 9, 8),
(71, 'Cinderella', 'Various authors', 5, 8),
(72, 'Funny Riddles', 'Various authors', 13, 8),
(73, 'Albert Einstein', 'Walter Isaacson', 76, 9),
(74, 'The Story of Gandhi', 'Louis Fischer', 84, 9),
(75, 'Nelson Mandela Biography', 'Nelson Mandela', 4, 9),
(76, 'A P J Abdul Kalam', 'A P J Abdul Kalam', 141, 9),
(77, 'Mother Teresa', 'Mother Teresa', 174, 9),
(78, 'Rabindranath Tagore', 'Rabindranath Tagore', 13, 9),
(79, 'Sarojini Naidu', 'Sarojini Naidu', 2, 9),
(80, 'MS Dhoni', 'MS Dhoni', 8, 9),
(81, 'Aryabhatta', 'Aryabhatta', 22, 9),
(82, 'The Woman in White', 'Wilkie Collins', 583, 10),
(83, 'The Devils Elixir', 'E.T.A. Hoffmann', 392, 10),
(84, 'The Riddle of the Sands', 'Erskine Childers', 292, 10),
(85, 'Wylders Hand', 'J. Sheridan Le Fanu', 347, 10),
(86, 'Northanger Abbey', 'Jane Austen', 170, 10),
(87, 'Original Short Stories', 'Guy de Maupassant', 351, 10),
(88, 'The Moonstone', 'Wilkie Collins', 385, 10),
(89, 'The Count of Monte Cristo', 'Alexandre Dumas', 464, 10),
(90, 'The Last Man', 'Mary Shelley', 615, 10);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `cate_id` int(11) NOT NULL,
  `category_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`cate_id`, `category_name`) VALUES
(1, 'Horror'),
(2, 'Fantasy'),
(3, 'Science fiction'),
(4, 'Mystery'),
(5, 'Romance novel'),
(6, 'History'),
(7, 'Cookbook'),
(8, 'Children\'s literature'),
(9, 'Biography'),
(10, 'Thriller');

-- --------------------------------------------------------

--
-- Table structure for table `logins`
--

CREATE TABLE `logins` (
  `log_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logins`
--

INSERT INTO `logins` (`log_id`, `user_id`, `user_name`, `time`) VALUES
(1, 3, 'vaa', '2024-08-28 12:46:06'),
(2, 1, 'vansh', '2024-08-28 12:56:33'),
(3, 1, 'vansh', '2024-08-29 10:13:30');

-- --------------------------------------------------------

--
-- Table structure for table `readlist`
--

CREATE TABLE `readlist` (
  `sr_no` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `book_id` int(11) NOT NULL,
  `book_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `readlist`
--

INSERT INTO `readlist` (`sr_no`, `user_name`, `book_id`, `book_name`) VALUES
(1, 'vansh', 31, 'The Lodger'),
(2, 'vansh', 5, 'The Call of Cthulhu');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `pass_code` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `pass_code`) VALUES
(1, 'vansh', '2'),
(2, 'bb', 'vansh'),
(3, 'vaa', '2525'),
(4, 'vvvv', '252525');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`book_id`),
  ADD KEY `fk` (`cate_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`cate_id`);

--
-- Indexes for table `logins`
--
ALTER TABLE `logins`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `fk` (`user_id`);

--
-- Indexes for table `readlist`
--
ALTER TABLE `readlist`
  ADD PRIMARY KEY (`sr_no`),
  ADD KEY `fk` (`book_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

--
-- AUTO_INCREMENT for table `logins`
--
ALTER TABLE `logins`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `readlist`
--
ALTER TABLE `readlist`
  MODIFY `sr_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `books`
--
ALTER TABLE `books`
  ADD CONSTRAINT `fk` FOREIGN KEY (`cate_id`) REFERENCES `books` (`book_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
