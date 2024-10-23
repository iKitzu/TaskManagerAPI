-- Tabla de Usuarios
CREATE TABLE usuarios (
    id INT NOT NULL AUTO_INCREMENT,
    nombre_usuario VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    contrasena_hash TEXT NOT NULL,
    fecha_de_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT UC_nombre_usuario UNIQUE (nombre_usuario),
    CONSTRAINT UC_email UNIQUE (email)
);

-- Tabla de Actividades
CREATE TABLE activdades (
    id INT NOT NULL AUTO_INCREMENT,
    usuario_fk INT NULL,
    titulo VARCHAR(100) NOT NULL,
    descripcion TEXT NULL,
    estado ENUM('pendiente', 'en proceso', 'completada') NOT NULL,
    prioridad ENUM('alta', 'media', 'baja') NOT NULL DEFAULT 'media',
    fecha_de_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_de_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_usuarios_actividades FOREIGN KEY (usuario_fk) REFERENCES usuarios (id)
);

-- Tabla de Recordatorios
CREATE TABLE recordatorios (
    id INT NOT NULL AUTO_INCREMENT,
    actividades_fk INT NULL,
    fecha_de_recordatorio DATETIME NOT NULL,
    mensaje TEXT NULL,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_actividades_recordatorios FOREIGN KEY (actividades_fk) REFERENCES activdades (id)
);

-- Tabla de Objetivos
CREATE TABLE objetivos (
    id INT NOT NULL AUTO_INCREMENT,
    usuario_fk INT NULL,
    title VARCHAR(100) NOT NULL,
    description TEXT NULL,
    fecha_de_vencimiento DATETIME NULL,
    estado ENUM('activo', 'pendiente', 'suspendido') NOT NULL,
    fecha_de_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_usuarios_objetivos FOREIGN KEY (usuario_fk) REFERENCES usuarios (id)
);

-- Tabla de Hitos para los Objetivos
CREATE TABLE hitos (
    id INT NOT NULL AUTO_INCREMENT,
    objetivo_fk INT NOT NULL,
    descripcion TEXT NOT NULL,
    fecha_de_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    completado BOOLEAN DEFAULT FALSE,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_objetivo_hitos FOREIGN KEY (objetivo_fk) REFERENCES objetivos (id)
);

-- Tabla de Estadísticas
CREATE TABLE estadisticas (
    id INT NOT NULL AUTO_INCREMENT,
    usuario_fk INT NULL,
    fecha_de_la_estadística TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    actividades_completadas INT NOT NULL,
    objetivos_completados INT NOT NULL,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_usuarios_estadisticas FOREIGN KEY (usuario_fk) REFERENCES usuarios (id)
);

-- Tabla de Categorías
CREATE TABLE categorias (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    CONSTRAINT PK_id PRIMARY KEY (id)
);

-- Tabla de Etiquetas
CREATE TABLE etiquetas (
    id INT NOT NULL AUTO_INCREMENT,
    actividades_fk INT NULL,
    nombre VARCHAR(100) NOT NULL,
    categoria_fk INT NULL,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_actividades_etiquetas FOREIGN KEY (actividades_fk) REFERENCES activdades (id),
    CONSTRAINT FK_categorias_etiquetas FOREIGN KEY (categoria_fk) REFERENCES categorias (id)
);

-- Tabla para la Colaboración entre Usuarios en Actividades
CREATE TABLE colaboraciones (
    id INT NOT NULL AUTO_INCREMENT,
    actividad_fk INT NOT NULL,
    usuario_fk INT NOT NULL,
    rol ENUM('creador', 'colaborador') NOT NULL DEFAULT 'colaborador',
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_actividad_colaboraciones FOREIGN KEY (actividad_fk) REFERENCES activdades (id),
    CONSTRAINT FK_usuario_colaboraciones FOREIGN KEY (usuario_fk) REFERENCES usuarios (id)
);

-- Tabla para Reportes de Rendimiento
CREATE TABLE reportes (
    id INT NOT NULL AUTO_INCREMENT,
    usuario_fk INT NOT NULL,
    tipo_reporte ENUM('diario', 'semanal', 'mensual') NOT NULL,
    fecha_inicio DATETIME NOT NULL,
    fecha_fin DATETIME NOT NULL,
    actividades_completadas INT DEFAULT 0,
    objetivos_completados INT DEFAULT 0,
    CONSTRAINT PK_id PRIMARY KEY (id),
    CONSTRAINT FK_usuario_reportes FOREIGN KEY (usuario_fk) REFERENCES usuarios (id)
);