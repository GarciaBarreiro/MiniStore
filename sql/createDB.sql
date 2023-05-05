CREATE TABLE Usuarios (
    correo VARCHAR(255) PRIMARY KEY,
    clave VARCHAR(255)
);

CREATE TABLE Pedidos (
    id BIGSERIAL PRIMARY key,
    correo VARCHAR(255),
    importe_final DECIMAL(10,2),
    FOREIGN KEY (correo) REFERENCES Usuarios(correo)
);

INSERT INTO Usuarios (correo, clave) VALUES 
('usuario1@ejemplo.com', 'clave1'),
('usuario2@ejemplo.com', 'clave2');

INSERT INTO Pedidos (correo, importe_final) VALUES 
('usuario1@ejemplo.com', 100.50),
('usuario2@ejemplo.com', 75.20);
