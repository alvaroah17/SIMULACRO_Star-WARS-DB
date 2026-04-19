-- ==============================================================================
-- SIMULACRO EXAMEN: StarWarsDB
-- Estructura: tablas catalogo con FK hacia la tabla principal Pilotos
-- ==============================================================================

CREATE TABLE Especies (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    bonificador_fuerza INT DEFAULT 0,
    bonificador_agilidad INT DEFAULT 0
);

CREATE TABLE Facciones (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE Planetas (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    nivel_minimo_acceso INT DEFAULT 1
);

-- TABLA PRINCIPAL: todas las de arriba apuntan aqui con FK
CREATE TABLE Pilotos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    nivel INT DEFAULT 1,
    creditos INT DEFAULT 100,
    vida_actual INT DEFAULT 100,
    id_especie INT,
    id_faccion INT,
    id_planeta_actual INT,
    FOREIGN KEY (id_especie) REFERENCES Especies(id) ON DELETE RESTRICT,
    FOREIGN KEY (id_faccion) REFERENCES Facciones(id) ON DELETE RESTRICT,
    FOREIGN KEY (id_planeta_actual) REFERENCES Planetas(id) ON DELETE SET NULL
);

INSERT INTO Especies (nombre, bonificador_fuerza, bonificador_agilidad) VALUES
('Humano', 5, 5), ('Wookiee', 20, -5), ('Twi-lek', 3, 10), ('Droide', 0, 8);

INSERT INTO Facciones (nombre) VALUES
('Jedi'), ('Sith'), ('Cazarrecompensas'), ('Piloto Rebelde');

INSERT INTO Planetas (nombre, nivel_minimo_acceso) VALUES
('Tatooine', 1), ('Coruscant', 5), ('Hoth', 8), ('Dagobah', 15);

INSERT INTO Pilotos (nombre, nivel, creditos, vida_actual, id_especie, id_faccion, id_planeta_actual) VALUES
('Luke Skywalker', 5, 350, 110, 1, 1, 1),
('Darth Vader', 10, 900, 150, 1, 2, 2),
('Chewbacca', 6, 200, 200, 2, 4, 1),
('Ahsoka Tano', 4, 80, 95, 3, 1, 1);
