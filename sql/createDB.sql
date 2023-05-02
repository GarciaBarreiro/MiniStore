CREATE TABLE Usuarios (
    correo VARCHAR(255) PRIMARY KEY,
    contraseña VARCHAR(255)
);

CREATE TABLE Pedidos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    correo VARCHAR(255),
    importe_final DECIMAL(10,2),
    FOREIGN KEY (correo) REFERENCES Usuarios(correo)
);

INSERT INTO Usuarios (correo, contraseña) VALUES 
('usuario1@ejemplo.com', 'contraseña1'),
('usuario2@ejemplo.com', 'contraseña2');

INSERT INTO Pedidos (correo, importe_final) VALUES 
('usuario1@ejemplo.com', 100.50),
('usuario2@ejemplo.com', 75.20);