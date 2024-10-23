INSERT INTO usuarios (nombre_usuario, email, contrasena_hash) VALUES 
('juanperez', 'juanperez@gmail.com', '123'),
('mariaruiz', 'mariaruiz@hotmail.com', '123'),
('carloslopez', 'carloslopez@yahoo.com', '123');

INSERT INTO activdades (usuario_fk, titulo, descripcion, estado, prioridad) VALUES
(1, 'Hacer ejercicio', 'Hacer 30 minutos de ejercicio', 'pendiente', 'alta'),
(2, 'Leer un libro', 'Leer 20 páginas del libro de productividad', 'en proceso', 'media'),
(3, 'Estudiar programación', 'Estudiar JavaScript por 1 hora', 'completada', 'baja');

INSERT INTO recordatorios (actividades_fk, fecha_de_recordatorio, mensaje) VALUES
(1, '2024-10-12 08:00:00', 'Recordatorio: Hacer ejercicio por la mañana'),
(2, '2024-10-12 18:00:00', 'Recordatorio: Leer antes de acostarte'),
(3, '2024-10-13 10:00:00', 'Revisar conceptos de JavaScript');

INSERT INTO objetivos (usuario_fk, title, description, fecha_de_vencimiento, estado) VALUES
(1, 'Perder 5 kg en 2 meses', 'Objetivo de pérdida de peso mediante dieta y ejercicio', '2024-12-01 00:00:00', 'activo'),
(2, 'Leer 5 libros en 3 meses', 'Mejorar los hábitos de lectura', '2024-11-01 00:00:00', 'pendiente'),
(3, 'Aprender JavaScript', 'Completar curso de JavaScript', '2024-12-31 00:00:00', 'activo');

INSERT INTO hitos (objetivo_fk, descripcion, completado) VALUES
(1, 'Perder 1 kg en la primera semana', FALSE),
(2, 'Leer el primer libro', TRUE),
(3, 'Completar el módulo básico de JavaScript', FALSE);

INSERT INTO estadisticas (usuario_fk, actividades_completadas, objetivos_completados) VALUES
(1, 10, 2),
(2, 5, 1),
(3, 7, 3);

INSERT INTO categorias (nombre) VALUES
('Salud'),
('Crecimiento personal'),
('Educación');

INSERT INTO etiquetas (actividades_fk, nombre, categoria_fk) VALUES
(1, 'Salud', 1),
(2, 'Crecimiento personal', 2),
(3, 'Educación', 3);

INSERT INTO colaboraciones (actividad_fk, usuario_fk, rol) VALUES
(1, 2, 'colaborador'),
(2, 3, 'colaborador'),
(3, 1, 'creador');

INSERT INTO reportes (usuario_fk, tipo_reporte, fecha_inicio, fecha_fin, actividades_completadas, objetivos_completados) VALUES
(1, 'semanal', '2024-10-01 00:00:00', '2024-10-07 23:59:59', 3, 1),
(2, 'mensual', '2024-09-01 00:00:00', '2024-09-30 23:59:59', 10, 2),
(3, 'diario', '2024-10-11 00:00:00', '2024-10-11 23:59:59', 1, 0);