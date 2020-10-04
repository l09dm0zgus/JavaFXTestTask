-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: localhost
-- Время создания: Окт 04 2020 г., 12:31
-- Версия сервера: 10.5.5-MariaDB
-- Версия PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `storedb`
--

-- --------------------------------------------------------

--
-- Структура таблицы `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `categories`
--

INSERT INTO `categories` (`id`, `number`, `name`) VALUES
(95, 1, 'Bananas'),
(96, 2, 'Apples'),
(97, 3, 'Cookies'),
(98, 4, 'Tomato'),
(99, 5, 'Cherrys'),
(100, 6, 'Pasta'),
(101, 7, 'Oatmeal\r\n'),
(102, 8, 'Chips'),
(103, 9, 'Macorrones'),
(104, 10, 'Sweets');

-- --------------------------------------------------------

--
-- Структура таблицы `goods`
--

CREATE TABLE `goods` (
  `id` int(11) NOT NULL,
  `code` text NOT NULL,
  `name` text NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `goods`
--

INSERT INTO `goods` (`id`, `code`, `name`, `price`) VALUES
(1, '100', 'Bananas', 4.6),
(2, '101', 'Bananas', 3.8),
(3, '228', 'Apples', 10),
(4, '231', 'Apples', 6.7),
(5, '333', 'Cookies', 3.45),
(6, '376', 'Cookies', 0.99),
(7, '404', 'Tomato', 4.04),
(8, '401', 'Tomato', 5),
(9, '567', 'Cherrys', 5.67),
(10, '543', 'Cherrys', 8.99),
(11, '666', 'Pasta', 6.66),
(12, '678', 'Pasta', 8.88),
(13, '777', 'Oatmeal', 78.8),
(14, '789', 'Oatmeal', 7.89),
(15, '876', 'Chips', 8.9),
(16, '890', 'Chips', 5.66),
(17, '999', 'Macorrones', 9.99),
(18, '901', 'Macorrones', 5.5),
(19, '1000', 'Sweets', 19.3),
(20, '1234', 'Sweets', 54.7);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `goods`
--
ALTER TABLE `goods`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=105;

--
-- AUTO_INCREMENT для таблицы `goods`
--
ALTER TABLE `goods`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
