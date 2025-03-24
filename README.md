# Emprendedores de Negocios - 2025
## Grupo No.3
### Integrantes
- **Luis Carlos Lima Pérez**
- **Angelica María Mejía Tzoc**
- **Mynor Ebenezer Alonso Miranda**
- **Katherine Daniela Portillo Meléndez**
- **Josué Emanuel Ramírez Aquino**
- **Josseline Emerita Galeano Hernández**
- **Timothy Gerald Palma Pérez**
- **Henry Timoteo Hernández Salay**

# NimbusGuard - Sistema de Alertas de Emergencia

## Descripción del Proyecto

NimbusGuard es una aplicación móvil desarrollada en Kotlin para Android que permite a los usuarios reportar emergencias con un solo clic. La aplicación proporciona un sistema de registro e inicio de sesión de usuarios, y una interfaz de usuario intuitiva construida con Jetpack Compose.

## Arquitectura del Proyecto

El proyecto sigue una arquitectura basada en componentes con una clara separación de responsabilidades:

- **PantallasDeLaApp**: Contiene todas las pantallas principales de la aplicación
- **Componentes**: Elementos de UI reutilizables organizados por pantalla
- **ManejoDeUsuarios**: Gestión de usuarios y autenticación
- **Navegacion**: Sistema de navegación entre pantallas

## Características Principales

- Sistema de registro de usuario con validación de datos
- Autenticación de usuarios
- Interfaz de usuario moderna con Jetpack Compose
- Tutorial integrado para nuevos usuarios
- Reportes de emergencias con un solo clic
- Gestión segura de datos personales

## Tecnologías Utilizadas

- **Kotlin**: Lenguaje de programación principal
- **Jetpack Compose**: Framework de UI declarativo
- **Navigation Component**: Gestión de la navegación entre pantallas
- **Firebase Authentication**: Para manejo de usuarios (inferido por la estructura del código)
- **Fuentes de Google**: Integración de fuentes personalizadas

## Estructura de Pantallas

### Pantalla de Tutorial
Muestra información introductoria sobre la aplicación:
- Texto de bienvenida
- Instrucciones de uso
- Carrusel de imágenes ilustrativas
- Botones para iniciar sesión o registrarse

### Pantalla de Registro
Formulario completo para registro de nuevos usuarios:
- Campos para datos personales (nombre, apellidos, CUI)
- Información de contacto (teléfono, correo)
- Datos geográficos (departamento, municipio)
- Validación de datos antes de envío
- Diálogo de confirmación con enmascaramiento de datos sensibles

### Pantalla de Login
Permite a los usuarios autenticarse en la aplicación (inferido por la navegación)

### Pantalla Principal
Dashboard principal con funcionalidad de alertas (inferido por la navegación)

## Componentes Clave

### Componentes de Registro
- Campos de entrada para todos los datos de usuario
- Botón de registro con validación
- Diálogo de confirmación con datos enmascarados

### Componentes de Tutorial
- TextoBienvenida: Título principal personalizado
- InstruccionesUso: Texto explicativo
- PhotoCarousel: Carrusel de imágenes
- ActionButtons: Botones de navegación

## Gestión de Usuarios

El sistema maneja objetos `User` con los siguientes atributos:
- uid: Identificador único
- name: Nombre del usuario
- lastname: Apellidos
- email: Correo electrónico
- password: Contraseña
- cui: Código Único de Identificación
- number: Número telefónico
- department: Departamento
- municipality: Municipio

La clase `UserAuthService` gestiona el registro y autenticación de usuarios.

## Configuración del Proyecto

El proyecto usa la configuración estándar de Android con:
- AndroidX
- Kotlin code style oficial
- JVM con memoria de 2048m
- Codificación UTF-8

## Navegación

El sistema utiliza el componente de navegación de Android Jetpack con rutas definidas para cada pantalla en la clase `ManejoDeLasPantallasDeLaApp`.

## Seguridad

Se implementan prácticas de seguridad como:
- Enmascaramiento de datos sensibles en la UI
- Ocultamiento completo de contraseñas
- Sistema de autenticación seguro

## Diseño UI/UX

- Uso de fuentes personalizadas de Google (Spicy Rice, Nerko One)
- Interfaces limpias con espaciado adecuado
- Carrusel de imágenes para tutorial visual
- Formularios con validación y feedback inmediato
- Diálogos de confirmación

# Guía de Usuario y Documentación Técnica de NimbusGuard

## Guía de Uso Paso a Paso

### 1. Iniciando la Aplicación

Al abrir la aplicación por primera vez, se muestra la **Pantalla de Bienvenida** que introduce al usuario a NimbusGuard.

### 2. Pantalla de Información/Tutorial

- Muestra una introducción a NimbusGuard
- Presenta instrucciones básicas de uso
- Incluye un carrusel de imágenes ilustrativas
- Ofrece botones para navegar al registro o inicio de sesión

### 3. Registro de Usuario

- Complete todos los campos requeridos:
  - Nombre y apellidos
  - CUI (Código Único de Identificación)
  - Teléfono
  - Departamento y municipio
  - Correo electrónico
  - Contraseña
- Al presionar "Registrarse", aparecerá un diálogo de confirmación
- Revise sus datos y confirme para completar el registro

### 4. Inicio de Sesión

- Ingrese su correo electrónico y contraseña
- Presione "Iniciar Sesión" para acceder a la aplicación

### 5. Pantalla Principal

- Incluye una barra de navegación inferior con acceso a:
  - Inicio (pantalla principal)
  - Notificaciones
  - Perfil de usuario
- Muestra el botón de alerta principal para reportar incidentes

### 6. Gestión de Notificaciones

- Visualice todas las alertas y notificaciones recibidas
- Interactúe con cada notificación según sea necesario

### 7. Perfil de Usuario

- Visualice y edite su información personal
- Gestione configuraciones de cuenta

## Descripción Técnica de Componentes

### Archivos Principales y su Función

#### Pantallas

- **PantallaDeBienvenida**: Pantalla inicial que muestra al abrir la app.
- **PantallaConInfoApp**: Muestra información tutorial de la aplicación.
- **PantallaDeRegistro**: Gestiona el registro de nuevos usuarios con validación de campos.
- **PantallaDeLogin**: Maneja la autenticación de usuarios existentes.
- **PantallaPrincipal**: Centro de la aplicación con acceso a todas las funciones principales.
- **PantallaDeNotificacion**: Muestra y gestiona las alertas recibidas.
- **PantallaDePerfil**: Permite ver y editar la información del usuario.

#### Componentes

- **Componentes.Registro**: Contiene campos individuales (NombreField, ApellidoField, etc.) para la pantalla de registro.
- **Componentes.PantallaTutorial**: Elementos como TextoBienvenida, InstruccionesUso y PhotoCarousel para la pantalla informativa.
- **Componentes.Inicio**: Incluye BotonDeAlertaViewModel para gestionar el estado del botón de alerta principal.
- **Componentes.Notificacion**: Maneja el repositorio y lógica de notificaciones.

#### Navegación y Servicios

- **NavegacionApp**: Configura las rutas y navegación entre pantallas.
- **ManejoDeLasPantallasDeLaApp**: Define las rutas para la navegación.
- **UserAuthService**: Maneja la autenticación, registro y gestión de usuarios con Firebase.

### Flujo de Datos

1. El usuario ingresa datos en formularios (registro/login)
2. Los servicios de autenticación validan los datos con Firebase
3. Se navega a la pantalla principal al autenticarse correctamente
4. El usuario puede interactuar con el botón de alerta y otras funcionalidades
5. Las notificaciones se gestionan y muestran en tiempo real

### Consideraciones de Seguridad

- Contraseñas enmascaradas en la interfaz
- Datos sensibles parcialmente ocultos en diálogos de confirmación
- Validación de datos en formularios

## Requisitos del Sistema

- Android OS
- Conexión a internet para registro, inicio de sesión y envío de alertas
- Activar la ubicación en el dispositivo
