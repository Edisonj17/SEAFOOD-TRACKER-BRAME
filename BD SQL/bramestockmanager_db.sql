create database BrameStockManager;
use BrameStockManager;

-- Tabla de usuarios
CREATE TABLE usuarios (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    contrasena VARCHAR(45) NOT NULL,
    rol VARCHAR(10) NOT NULL -- Puede ser "admin", "empleado", etc.
);

-- Tabla de proveedores
CREATE TABLE proveedores (
    id_proveedor INT PRIMARY KEY AUTO_INCREMENT,
    nombre_proveedor VARCHAR(100) NOT NULL,
    contacto_proveedor VARCHAR(100), -- Portavoz del proveedor
    telefono_proveedor VARCHAR(20),
    email_proveedor VARCHAR(100)
);

-- Tabla de productos
CREATE TABLE productos (
    id_producto INT PRIMARY KEY AUTO_INCREMENT,
    nombre_producto VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL NOT NULL,
    stock INT NOT NULL -- Existencias en el inventario
);

-- Tabla intermedia para la relación n:m entre proveedores y productos
CREATE TABLE proveedor_producto (
    id_proveedor INT,
    id_producto INT,
    PRIMARY KEY (id_proveedor, id_producto),
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Tabla de ingresos
CREATE TABLE ingresos (
    id_ingreso INT PRIMARY KEY AUTO_INCREMENT,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    fecha_ingreso DATETIME NOT NULL,
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Tabla de egresos
CREATE TABLE egresos (
    id_egreso INT PRIMARY KEY AUTO_INCREMENT,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    fecha_egreso DATETIME NOT NULL,
    tipo_egreso VARCHAR(50) NOT NULL, -- Puede ser "venta", "donacion", etc.
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Tabla de movimientos
CREATE TABLE movimientos (
    id_movimiento INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    tipo_movimiento VARCHAR(50) NOT NULL, -- Puede ser "ingreso" o "egreso"
    fecha_movimiento DATETIME NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Indices adicionales para mejorar el rendimiento
CREATE INDEX idx_producto_proveedor ON proveedor_producto (id_proveedor);
CREATE INDEX idx_ingreso_producto ON ingresos (id_producto);
CREATE INDEX idx_egreso_producto ON egresos (id_producto);
CREATE INDEX idx_movimiento_usuario_producto ON movimientos (id_usuario, id_producto);