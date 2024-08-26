-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-08-2024 a las 02:02:47
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `casa_facil`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tareas`
--

CREATE TABLE `tareas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `puntuacion` int(11) NOT NULL,
  `obligatoria` tinyint(1) NOT NULL DEFAULT 0,
  `ciclo` enum('Diaria','Semanal','Quincenal','Mensual') NOT NULL DEFAULT 'Diaria',
  `estado` enum('Completada','Incumplida','Pendiente','Aplazada') NOT NULL DEFAULT 'Pendiente'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tareas`
--

INSERT INTO `tareas` (`id`, `nombre`, `descripcion`, `puntuacion`, `obligatoria`, `ciclo`, `estado`) VALUES
(1, 'Limpiar Baño', 'Completo....', 30, 1, 'Semanal', 'Pendiente'),
(2, 'Limpiar Cocina', 'Incluye nevera y fogón', 30, 1, 'Semanal', 'Pendiente'),
(3, 'Lavar Ventanas', 'Ciudado, no molestar a los vecinos.... ', 25, 0, 'Mensual', 'Pendiente'),
(4, 'Sacar la basura', 'La orgánica de 7 a 11pm', 10, 1, 'Diaria', 'Pendiente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `puntuacion` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `email`, `pwd`, `puntuacion`) VALUES
(1, 'Mariela', 'mariela@gmail.com', 'maryam', 125),
(2, 'Eduardo', 'eddy@gmail.com', 'eddy', 119),
(4, 'Jorge', 'jorge@gmail.com', 'victor', 25),
(7, 'Ernesto', 'erne@gmail.com', 'erne', 15),
(9, 'marjor', 'marjor@gmail.com', 'marjor', 0),
(21, 'pepe', 'pepe@gmail.com', 'pepe', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_tarea`
--

CREATE TABLE `usuario_tarea` (
  `id` int(11) NOT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `tarea_id` int(11) DEFAULT NULL,
  `estado` varchar(50) DEFAULT 'pendiente',
  `fecha_asignacion` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario_tarea`
--

INSERT INTO `usuario_tarea` (`id`, `usuario_id`, `tarea_id`, `estado`, `fecha_asignacion`) VALUES
(1, 1, 1, 'completada', '2024-08-19 13:50:09'),
(2, 2, 2, 'completada', '2024-08-13 20:47:23'),
(3, 4, 3, 'completada', '2024-08-15 09:38:08'),
(4, 2, 4, 'completada', '2024-08-15 09:38:50');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tareas`
--
ALTER TABLE `tareas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indices de la tabla `usuario_tarea`
--
ALTER TABLE `usuario_tarea`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuario_id` (`usuario_id`),
  ADD KEY `tarea_id` (`tarea_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tareas`
--
ALTER TABLE `tareas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `usuario_tarea`
--
ALTER TABLE `usuario_tarea`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuario_tarea`
--
ALTER TABLE `usuario_tarea`
  ADD CONSTRAINT `usuario_tarea_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `usuario_tarea_ibfk_2` FOREIGN KEY (`tarea_id`) REFERENCES `tareas` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
