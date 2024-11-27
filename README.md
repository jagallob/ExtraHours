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



## -English Version-


# ExtraHours

Wireframes
https://miro.com/app/board/uXjVKxUM7T8=/?moveToWidget=3458764597049633884&cot=14
https://www.figma.com/design/QdMm6JmxJ7tPx4XKkLhXLB/Extra-Hours-Delta?node-id=0-1&m=dev&t=o7T4U9zHz9zgULpy-1

 # **USER GUIDE**
 
## **Introduction**


This user manual was written to guide employees, managers, and administrators who will use the Amadeus overtime management system. This system allows users to:

- Add, update, delete, and approve overtime records.
- Generate detailed reports.
- Configure parameters related to overtime.
- Manage employees (add, update, and delete personnel).

The system was designed to comply with the Colombian labor regulations related to overtime management.



## **Technologies used**

- Frontend: React con JavaScript
- Backend: Java con Spring Boot
- Database: MySQL

## **Initial Recommendations**

- Perform the necessary global installations with the following command:
  npm i

- Install Vite on the client side of the frontend:
  npm i vite

- Start the client (frontend) with the following command:
  npm run dev

- Activate the backend from the IDE (e.g., IntelliJ IDEA).

- Ensure that the MySQL database is active and properly configured.


## **Main Features**

### 1. **Add Overtime**
   
##### **Profile**: Employee / Superuser  
##### **Action**: Register new overtime hours.  
##### **Required Fields:**  
#### Employee ID (identification number).  
#### Record date.  
#### Start time and end time.  
#### Observations.

### 2. **Overtime Management**
   
##### **Profile**: Manager / Superuser  
##### **Action**: Update, approve, or delete overtime records. The system will issue an alert if the employee exceeds the configured weekly overtime limit.  
##### **Required Fields:**  
##### Employee ID (identification number).  

## 3. **Generate Reports**
   
##### **Profile**: Employee / Manager / Superuser  
##### **Action**: Generate and download reports in Excel format.  
##### **Generation Options:**  
##### - By Employee ID (identification number).  
##### - By date range (start and end).  
##### **Required Fields:**  
##### Employee ID (identification number).  
##### Date range (Start and End).  

## 4. **Settings**
 
##### **Profile**: Superuser  
##### **Action**: Configure parameters and manage personnel.  

####  4.1 Configure overtime parameters:  
#####   - Weekly overtime limit.  
#####   - Daytime Hour Multiplier.  
#####   - Nighttime Hour Multiplier.  
#####   - Holiday Daytime Hour Multiplier.  
#####   - Holiday Nighttime Hour Multiplier.  
#####   - Daytime Hour Start (24h format).  
#####   - Daytime Hour End (24h format).  

####  4.2 Add new personnel:  
##### **Required Fields:**  
#####   - ID (identification number).  
#####   - Name.  
#####   - Position.  
#####   - Salary.  
#####   - Assigned manager.  
#####   - Manager ID.  
#####   - Select the role.  
#####   Note: The email is generated automatically. Clicking "Add" creates a new user in the *users* table. The default initial password is *password123*, Is recommended to change the password upon the first login.  

####  4.3 Update or Delete personnel:  
##### **Required Fields:**  
#####   - ID  

## **Roles**

### **Employee**  
#### - Access: Register overtime hours, and view your reports.

### **Manager**  
#### - Access: Manage overtime hours (update, approve, delete), generate reports by date range or by the employee.

### **Superuser**  
#### - Access: Configure system parameters, manage employees and perform all actions available to employees and managers. 
