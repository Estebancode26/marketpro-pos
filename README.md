
md
![CI](https://github.com/Estebancode26/marketpro-pos/actions/workflows/ci.yml/badge.svg)

# MarketPro POS API

API backend para gestión de punto de venta, inventario y reportes mínimos.

---

##  Requisitos
- JDK 21  
- Maven 3.9+  
- Docker  

---

##  Instalación local
```bash
mvn clean package
java -jar pos-api/target/pos-api-0.0.1-SNAPSHOT.jar
```

##  Instalación Docker
```bash
docker compose up --build
```

---

##  Documentación Swagger
Disponible en: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

##  Endpoints 
| Método | Ruta              | Descripción             |
|--------|-------------------|-------------------------|
| GET    | /api/products     | Listar productos        |
| POST   | /api/products     | Crear producto          |
| PUT    | /api/products/{id}| Actualizar producto     |
| DELETE | /api/products/{id}| Eliminar producto       |
| POST   | /api/sales        | Registrar venta         |
| GET    | /api/sales        | Listar ventas           |
| POST   | /api/returns      | Registrar devolución    |
| GET    | /api/status       | Estado del sistema      |

---

## Seguridad por roles
| Rol     | Rutas permitidas                          |
|---------|-------------------------------------------|
| ADMIN   | Todas las rutas CRUD y reportes           |
| SELLER  | /api/sales, /api/products (solo lectura)  |
| AUDITOR | /api/status, /api/sales, /api/returns     |

---

##  CI/CD
- Workflow: `.github/workflows/ci.yml`  
- Artifact generado automáticamente: `pos-api-jar`  


---

## Repositorio
[https://github.com/Estebancode26/marketpro-pos](https://github.com/Estebancode26/marketpro-pos)






