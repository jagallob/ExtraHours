# ExtraHours

Wireframes
https://miro.com/app/board/uXjVKxUM7T8=/?moveToWidget=3458764597049633884&cot=14
https://www.figma.com/design/QdMm6JmxJ7tPx4XKkLhXLB/Extra-Hours-Delta?node-id=0-1&m=dev&t=o7T4U9zHz9zgULpy-1

 # **MANUAL DE USUARIO**
 
## **Introducción**

Este manual de usuario está diseñado para guiar a los empleados, managers y administradores en el uso del sistema de gestión de horas extra de Amadeus. Este sistema permite:

- Agregar, actualizar, eliminar y aprobar registros de horas extra.
- Generar informes detallados. 
- Configurar parámetros relacionados con las horas extra.
- Gestionar empleados (agregar, actualizar y eliminar personal).

El sistema está diseñado para cumplir con las normativas laborales colombianas relacionadas con la gestión de horas extra.


## **Tecnologías usadas**

- Frontend: React con JavaScript
- Backend: Java con Spring Boot
- Base de datos: MySQL

## **Recomendaciones iniciales**

- Realizar las instalaciones globales necesarias con el siguiente comando:
   npm i

- Instalar Vite en el client side del frontend:
   npm i vite

- Iniciar el cliente (frontend) con el siguiente comando:
   npm run dev

- Activar el backend desde el IDE (por ejemplo, IntelliJ IDEA).

- Asegurarse de que la base de datos MySQL esté activa y configurada correctamente.


## **Funcionalidades Principales**

### 1. **Agregar Horas Extra**
   
##### **Perfil**: Empleado / Superusuario
##### **Acción**: Registrar nueva hora extra.
##### **Campos Requeridos:**
#### ID del empleado (cédula).
#### Fecha del registro.
#### Hora inicio y hora fin.
#### Observaciones.

### 2. **Gestión Horas Extra**
   
##### **Perfil**: Manager / Superusuario
##### **Acción**:  Actualizar, aprobar o eliminar registros de horas extra. El sistema emitirá una alerta si el empleado supera el límite de horas extra semanales configurado.
##### **Campos Requeridos**:
##### ID del empleado (cédula).

## 3. **Generar Informes**
   
##### **Perfil**: Empleado / Manager / Superusuario
##### **Acción**:  Generar y descargar informes en formato Excel.
##### **Opciones de generación:**
##### - Por ID del empleado (cédula).
##### - Por rango de fechas (inicio y fin).
##### **Campos Requeridos**:
##### ID del empleado (cédula).
##### Rango de fecha (Inicial y Final).

## 4.  **Configuraciones**
 
##### **Perfil**: Superusuario
##### **Acción**: Configurar parámetros y gestionar personal.

####  4.1 Configurar parámetros de horas extra:
#####   - Límite semanal de horas extra.
#####   - Multiplicador Hora Diurna.
#####   - Multiplicador Hora Nocturna.
#####   - Multiplicador Hora Festiva Diurna.
#####   - Multiplicador Hora Festiva Nocturna.
#####   - Inicio Hora Diurna (24h).
#####   - Fin Hora Diurna (24h).

####  4.2 Agregar nuevo personal:
##### **Campos Requeridos**:
#####   - ID (cédula).
#####   - Nombre.
#####   - Posición.
#####   - Salario.
#####   - Manager asignado.
#####   - Manager ID.
#####   - Seleccionar el rol.
#####   Nota: el correo electrónico se genera automáticamente, al dar click en Agregar se genera el nuevo usuario en la tabla users, la contraseña inicial por defecto es password123 y se recomienda cambiarla al primer inicio de sesión.

####  4.3 Actualizar o Eliminar personal:
##### **Campos Requeridos**:
#####   - ID


## **Roles**

### **Empleado**
#### - Acceso: Registrar horas extra, consultar informes propios.

### **Manager**
#### - Acceso: Gestionar horas extra (actualizar, aprobar, eliminar), generar informes por rango de fecha o por empleado.

### **Superusuario**
#### - Acceso: Configurar parámetros del sistema, gestionar empleados, y realizar todas las acciones de empleados y managers.
