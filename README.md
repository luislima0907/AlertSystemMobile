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

# Cosas por Hacer en la App Móvil del Sistema de Cabina de Emergencias

Todo lo que se indicará a continuación debe funcionar en tiempo real, es decir,
no se debe recargar la app para que los cambios se apliquen. También se deben mantener
los cambios que se hagan mientras se navega en las pantallas de la app y cuando se
cierre la app de la memoria del dispositivo, esto con el fin de que las configuraciones
y cambios que se hagan en la app perduren en cualquier situación.

# Guía de Implementación para Mejorar el Registro en la App (Mynor)

## 1. Mejoras en la UI del Registro

1. **Rediseñar la pantalla de registro**

  Estos cambios se realizaran en los archivos:
  
  - `CamposDelRegistro.kt` que se encuentra en esta ruta `\AlertSystemApp\app\src\main\java\gt\edu\miumg\luis\alertsystemappmovil\Componentes\Registro\CamposDelRegistro.kt`.
  - `PantallaDeRegistro.kt` que se encuentra en esta ruta `\AlertSystemApp\app\src\main\java\gt\edu\miumg\luis\alertsystemappmovil\PantallasDeLaApp\PantallaDeRegistro.kt`.
  
     - Añadir más elementos visuales como iconos para cada campo
     - Mejorar los espaciados y márgenes
     - Implementar un diseño más atractivo con colores consistentes
     - Mejorar el aspecto visual de los campos de texto

2. **Añadir botón de regreso**
   - Implementar un botón en la esquina superior izquierda
   - Conectarlo para navegar de vuelta a la pantalla tutorial, esta tiene como nombre `PantallaDeTutorial` y esta en la ruta 
     `\AlertSystemApp\app\src\main\java\gt\edu\miumg\luis\alertsystemappmovil\Componentes\PantallaTutorial\PantallaDeTutorial.kt` y para conectar la navegacion se tienen 
     que usar los archivos de `NavegacionApp.kt` y `ManejoDeLasPantallasDeLaApp.kt` para definir correctamente las rutas y controladores. Estos archivos se encuentran en 
     esta ruta `\AlertSystemApp\app\src\main\java\gt\edu\miumg\luis\alertsystemappmovil\Navegacion`.
   - Usar un icono de flecha para indicar regreso

## 2. Modificar el Flujo de Registro

1. **Modificar lógica final de registro**

Aqui se debe modificar la clase principal que contiene al usuario dentro de la app, se llama `User` y se encuentra en esta ruta `\AlertSystemApp\app\src\main\java\gt\edu\miumg\luis\alertsystemappmovil\ManejoDeUsuarios\User.kt`. Agregar campos en la clase `User` para guardar:

   - Tipo de plan (gratuito o pago)
   - Fecha de inicio de suscripción
   - Fecha de vencimiento de suscripción
   - Solo después de aceptar términos, registrar en Firebase

2. **Ajustar el proceso confirmación**
   - Mantener el diálogo existente que muestra los datos ingresados
   - Modificar la función `handleUserRegistration` que se encuentra en el archivo `PantalllaDeRegistro.kt` para que no registre al usuario inmediatamente

3. **Crear pantalla de selección de planes**

Para crear una nueva pantalla en la navegacion de la app debe de agregarla al archivo `ManejoDeLasPantallasDeLaApp` para definir su ruta, la nueva pantalla se puede llamar `PantallaDePlanes.kt` y se debe almacenar en este directorio `\AlertSystemApp\app\src\main\java\gt\edu\miumg\luis\alertsystemappmovil\PantallasDeLaApp` luego en esa misma pantalla se debe definir el `navController` para que al final se pueda agregar el controlador de la pantalla al archivo `NavegacionApp.kt` que se encuentra en esta ruta `\AlertSystemApp\app\src\main\java\gt\edu\miumg\luis\alertsystemappmovil\Navegacion\NavegacionApp.kt`.

   - Diseñar una nueva pantalla después de confirmar los datos en la ventana emergente del registro, es decir, cuando se le de al boton de `aceptar` al cuadro emergente que      aparece con los datos que ingreso el usuario en el formulario de registro, entonces que lo redireccione a la `PantallaDePlanes.kt`. Ahi tambien se debe incluir un 
     boton para cancelar esa operacion, y cuando se le de click, entonces que lo redirija nuevamente a la `PantallaDeRegistro.kt`.
   - Mostrar tres opciones de planes:
     - Plan gratuito (prueba de 2 semanas) aunque para las primeras pruebas (seran alrededor de 5 a 10 minutos para ver si se manejan los tiempos de suscripcion activa 
       correctamente, y cuando ya funcionen entonces ya se le asigna el tiempo de dos semanas a partir de la fecha actual)
     - Plan básico de pago
     - Plan premium de pago
   - Incluir detalles de cada plan (precio, características), tambien se puede incluir límite de alertas por día y alguna funcionalidad extra que se le agregue en un 
     futuro, o alguna sugerencia del equipo.

4. **Implementar simulación de pago**
   - Crear una interfaz para seleccionar método de pago (tarjeta crédito/débito)
   - Diseñar un formulario básico para datos de pago
   - Simular procesamiento con indicador de carga cuando se le de a un boton de `aceptar` para que complete el formulario y despues lo redirija a una nueva pantalla llamada 
     `PantallaDeTerminosYCondiciones.kt` y se debe crear en este directorio `\AlertSystemApp\app\src\main\java\gt\edu\miumg\luis\alertsystemappmovil\PantallasDeLaApp`

5. **Desarrollar pantalla de términos y condiciones**
   - Crear una nueva pantalla: `PantallaDeTerminosYCondiciones.kt`
   - Mostrar texto completo de términos y condiciones para el uso de la app
   - Añadir casilla de verificación "He leído y acepto los términos" hasta abajo del texto
   - Habilitar botón de `aceptar` solo cuando la casilla esté marcada. Cuando se le de a ese boton de `aceptar` entonces que ahora si registre el usuario y lo redirija           hacia la `PantallaPrincipal.kt`

## 3. Implementar Validaciones Adicionales

1. **Validación de planes**
   - Crear sistema para verificar estado del plan del usuario
   - Implementar validación de fechas para verificar expiración

2. **Persistencia de datos**
   - Asegurar que la información del usuario se mantenga durante toda la navegación
   - Implementar almacenamiento temporal de datos hasta completar el registro

# Guía de Implementación para Mejoras en la Pantalla de Login (Angelica)

## 1. Mejorar la Interfaz de Usuario (UI)

Estos cambios se realizaran en los archivos:
- `Login.kt` que se encuentra en esta ruta `\AlertSystemApp\app\src\main\java\gt\edu\miumg\luis\alertsystemappmovil\Componentes\Login\Login.kt`.
- `PantallaDeLogin.kt` que se encuentra en esta ruta `\AlertSystemApp\app\src\main\java\gt\edu\miumg\luis\alertsystemappmovil\PantallasDeLaApp\PantallaDeLogin.kt`.

  - Actualizar el diseño de los campos de entrada (correo y contraseña)
  - Agregar efectos visuales de feedback para estados de error
  - Implementar diseño más atractivo y coherente con la identidad visual
  - Ajustar espaciado, tipografía y colores

## 2. Agregar Botón de Retorno
- Implementar botón para volver a la pantalla de tutorial
- Ubicarlo en una posición accesible (parte superior izquierda)
- Conectarlo con el NavController para navegar hacia atrás

## 3. Integrar Sistema de Validación de Planes de Suscripción
- Crear modelo de datos para planes de suscripción
- Implementar verificación del estado del plan al iniciar sesión
- Almacenar información de planes en Firebase
- Verificar vigencia del plan (fechas de inicio/vencimiento)

## 4. Implementar Sistema de Restricciones
- Crear estados globales para controlar acceso a funcionalidades
- Deshabilitar botones de alertas cuando no hay plan activo
- Deshabilitar edición de perfil para usuarios sin plan activo
- Deshabilitar botón de limpieza de notificaciones sin plan activo

## 5. Desarrollar Sistema de Mensajes de Advertencia
- Diseñar componentes visuales para advertencias
- Mostrar mensajes específicos según las restricciones detectadas
- Implementar lógica para mostrar/ocultar advertencias dinámicamente
- Crear jerarquía visual para múltiples advertencias simultáneas

## 6. Crear Navegación a Pantalla de Planes
- Diseñar botón o enlace desde las advertencias hacia `PantallaDePlanes`

## 7. Implementar Sistema de Renovación
- Crear interfaz para renovación de planes vencidos (utilizar la `PantallaDePlanes` para crear esa interfaz, claro esta, de que hay que hacer una validacion de comprobacion 
  previa sobre de que si el usuario ya tenia un plan activo para poder renovarlo, exceptuando el plan gratuito si en dado caso ya lo tomo)
- Mostrar información del plan actual y fecha de vencimiento
- Proporcionar opciones para renovar o cambiar de plan

## 8. Agregar Validaciones Adicionales
- Implementar verificación de estado de ubicación
- Agregar validación de permisos de geolocalización
- Verificar conectividad (WiFi o datos móviles)
- Diseñar lógica para desactivar botones de alerta si no se cumplen requisitos

## 9. Desarrollar Sistema de Notificaciones Visuales
- Crear iconos de advertencia para cada tipo de restricción
- Implementar mensajes claros sobre cómo resolver cada problema
- Proporcionar acceso directo a configuraciones relevantes

## 10. Implementar Persistencia de Estado
- Asegurar que las configuraciones y estados se mantengan durante la navegación
- Mantener estado de validaciones al cerrar/abrir la aplicación
- Manejar reactivación automática de funciones cuando se resuelven restricciones

# Guía para implementar el requerimiento del botón "Eliminar Cuenta" (Henry)

## Paso 1: Añadir campos de suscripción al modelo de usuario
- En los campos en la clase `User` deben estar los siguientes para establecer la logica del boton:
  - Tipo de plan (gratuito o pago)
  - Fecha de inicio de suscripción
  - Fecha de vencimiento de suscripción

## Paso 2: Crear lógica para verificar estado de suscripción
- Implementar una función que compare la fecha actual con la fecha de vencimiento
- Retornar un booleano que indique si la suscripción está activa

## Paso 3: Modificar la pantalla de perfil
- Adaptar `PantallaDePerfil.kt` para obtener el estado de suscripción del usuario
- Añadir un estado booleano para controlar si el botón "Eliminar Cuenta" debe estar habilitado
- Actualizar la propiedad `enabled` del botón según el estado de suscripción

## Paso 4: Mejorar el diálogo de confirmación de eliminación
- Añadir información detallada sobre las desventajas de eliminar la cuenta:
  - Pérdida de historial de alertas
  - Pérdida de configuraciones personales
  - Necesidad de volver a registrarse para usar el servicio
  
## Paso 5: Aumentar el tiempo del contador regresivo
- Modificar el valor actual de 10 segundos a un tiempo mayor (30-60 segundos)
- Actualizar el texto del contador para reflejar mejor el propósito

## Paso 6: Verificar el estado de suscripción periódicamente
- Implementar un mecanismo para verificar el estado de suscripción cuando se carga el perfil
- Actualizar el estado del botón si la suscripción cambia mientras el usuario está en la app

## Paso 7: Pruebas
- Verificar que el botón esté deshabilitado cuando hay una suscripción activa
- Comprobar que se habilite correctamente cuando la suscripción vence
- Probar que el contador regresivo funcione correctamente
- Confirmar que la información adicional sobre desventajas se muestre en el diálogo

## Paso 8: Integración
- Asegurar que estos cambios funcionen correctamente con el resto del sistema de suscripciones
- Verificar que la funcionalidad persista al navegar entre pantallas y al reiniciar la app

# Guía para implementar la funcionalidad de agregar fotografías a las alertas (Timothy)

## 1. Agregar permisos en el `AndroidManifest.xml`, este se encuentra en `\AlertSystemApp\app\src\main\AndroidManifest.xml`
- Añadir permisos para acceder a la cámara
- Añadir permisos para acceder al almacenamiento interno/galería

## 2. Modificar el modelo de datos de Alert y Notificacion
- Actualizar la clase `Alert` en `FireStoreServiceAlert.kt` para incluir un campo de imagen (URL o URI), estos archivos se encuentran en 
  `\AlertSystemApp\app\src\main\java\gt\edu\miumg\luis\alertsystemappmovil\Componentes\Inicio`
- Actualizar la clase `Notificacion` en `NotificacionRepository.kt` para soportar este nuevo campo, estos archivos se encuentran en 
  `\AlertSystemApp\app\src\main\java\gt\edu\miumg\luis\alertsystemappmovil\Componentes\Notificacion`

## 3. Actualizar el diálogo de alerta en `BotonDeAlerta.kt`, este se encuentra en `\AlertSystemApp\app\src\main\java\gt\edu\miumg\luis\alertsystemappmovil\Componentes\Inicio\BotonDeAlerta.kt`
- Rediseñar el `showAlertInputDialog` para incluir:
  - Un botón para seleccionar imagen de la galería
  - Un botón para tomar una foto con la cámara
  - Un área de vista previa de la imagen seleccionada
  - Mejorar el diseño general para una experiencia más intuitiva

## 4. Implementar la lógica de selección de imágenes
- Crear funciones para manejar la selección de imágenes desde la galería
- Crear funciones para manejar la captura de imágenes con la cámara
- Mostrar la vista previa de la imagen seleccionada dentro del diálogo

## 5. Gestionar los permisos en tiempo de ejecución
- Implementar solicitudes de permisos para cámara y galería
- Manejar casos donde los permisos sean denegados
- Proporcionar mensajes explicativos al usuario

## 6. Actualizar el procesamiento de alertas
- Modificar `handleSendAlert` para incluir el procesamiento de imágenes, esta funcion se encuentra en 
  `\AlertSystemApp\app\src\main\java\gt\edu\miumg\luis\alertsystemappmovil\Componentes\Inicio\BotonDeAlerta.kt`
- Subir la imagen a Firebase Storage para tener una URL accesible
- Incluir la URL de la imagen en el documento de alerta en Firestore

## 7. Actualizar el servicio de notificaciones
- Modificar `createNotification` para incluir la referencia a la imagen, esta funcion se encuentra en 
  `\AlertSystemApp\app\src\main\java\gt\edu\miumg\luis\alertsystemappmovil\Componentes\Notificacion\NotificationService.kt`
- Actualizar el repositorio para almacenar la información de la imagen

## 8. Actualizar la visualización de notificaciones
- Modificar `NotificacionItem` para mostrar la imagen del usuario, este componente se encuentra en 
  `\AlertSystemApp\app\src\main\java\gt\edu\miumg\luis\alertsystemappmovil\PantallasDeLaApp\PantallaDeNotificacion.kt`
- Ajustar el tamaño de la imagen para que se adapte al espacio disponible
- Añadir una visualización ampliada al hacer clic en la imagen

## 9. Pruebas
- Probar la funcionalidad de selección de imágenes
- Probar la visualización en diferentes tamaños de pantalla
- Comprobar que la imagen se muestra correctamente en las notificaciones

# Guía de Implementación para Mejoras en el Sistema de Notificaciones (Josue)

## 1. Implementar Notificaciones Push para Cambios de Estado

1. Mejorar `NotificationService.kt` para usar correctamente el sistema de notificaciones Android, este archivo se encuentra en 
  `\AlertSystemApp\app\src\main\java\gt\edu\miumg\luis\alertsystemappmovil\Componentes\Notificacion\NotificationService.kt`
2. Configurar un PendingIntent para que al pulsar la notificación dirija a la pantalla de notificaciones
3. Agregar información detallada (título, texto, icono) a las notificaciones push

## 2. Persistir Notificaciones entre Sesiones

1. Modificar `NotificacionRepository` para usar Room Database o SharedPreferences
2. Crear métodos para guardar y recuperar notificaciones 
3. Implementar la carga de notificaciones guardadas cuando la app inicia

## 3. Agregar Botón para Limpiar Notificaciones

1. Añadir un botón en `PantallaDeNotificacion.kt` en la parte superior o inferior
2. Implementar lógica para verificar si todas las alertas tienen estado "resuelta"
3. Habilitar/deshabilitar el botón según la condición anterior
4. Crear función para limpiar notificaciones cuando se pulse el botón

## 4. Añadir Iconos de Estado en Notificaciones

1. Crear/añadir iconos diferentes para cada estado de alerta (pendiente, en atención, resuelta)
2. Modificar `NotificacionItem.kt` para mostrar el icono correspondiente
3. Actualizar `NotificationService.kt` para usar el icono adecuado en las notificaciones push

## 5. Desaparecer Notificaciones Push al Visualizarlas

1. Implementar método en `NotificationService` para cancelar notificaciones del sistema
2. Llamar a este método cuando el usuario entre a la pantalla de notificaciones
3. Usar los IDs de alerta para eliminar las notificaciones específicas 

## 6. Corregir Contador de Notificaciones

1. Modificar la lógica actual en `NotificacionRepository`
2. Implementar un sistema de notificaciones "no leídas"
3. Actualizar el estado a "leído" cuando el usuario ve la notificación 
4. Ajustar `contadorDeNotificaciones` para mostrar solo notificaciones no leídas

## 7. Añadir Filtrado de Notificaciones

1. Crear una barra superior en `PantallaDeNotificacion.kt` con opciones de filtro
2. Implementar un estado para el filtro seleccionado (pendiente, en atención, resuelta, todas)
3. Modificar la función que muestra las notificaciones para aplicar el filtro
4. Añadir mensaje e icono cuando no hay notificaciones para el filtro seleccionado

## Consideraciones Adicionales

- Asegurar que las imágenes adjuntas a alertas (mencionadas en el punto 4 de las instrucciones) se muestren correctamente en las notificaciones
- Mantener la consistencia visual entre notificaciones push y la pantalla de notificaciones
- Implementar animaciones suaves para mejorar la experiencia de usuario

# Guía para implementar ajustes adicionales en el perfil y cambios en la UI generales en la app (Katherine)

## 1. Deshabilitar edición del perfil y cierre de sesión durante alertas activas

1. **Modificar PantallaDePerfil.kt para verificar estados de alertas:**
   - Agregar una función para consultar las notificaciones del usuario actual
   - Filtrar notificaciones para detectar alertas con estado "pendiente" o "en atención"
   - Utilizar `NotificacionRepository` para acceder a las notificaciones guardadas

2. **Implementar lógica de desactivación de botones:**
   - Crear un estado booleano para controlar la habilitación de botones
   - Actualizar este estado basado en los resultados de la consulta de notificaciones
   - Aplicar la propiedad "enabled" a los botones de edición y cierre de sesión

3. **Configurar actualizaciones en tiempo real:**
   - Implementar un LaunchedEffect o un sistema de observación para detectar cambios en el estado de alertas
   - Actualizar la UI cuando cambien los estados de las notificaciones

## 2. Deshabilitar la limpieza de notificaciones durante alertas activas

1. **Añadir un botón para limpiar notificaciones en PantallaDeNotificacion:**
   - Diseñar e implementar un botón de limpieza en la interfaz de notificaciones
   - Crear la función para eliminar notificaciones resueltas

2. **Implementar la lógica de verificación:**
   - Verificar si existen notificaciones con estado "pendiente" o "en atención"
   - Deshabilitar el botón de limpieza si hay alertas activas
   - Habilitar el botón solo cuando todas las alertas estén "resueltas"

## 3. Mostrar información de suscripción en el perfil

1. **Actualizar el modelo de usuario:**
   - Añadir campos para almacenar el tipo de suscripción y fecha de expiración
   - Modificar UserFireStoreService para gestionar estos nuevos campos

2. **Modificar la interfaz del perfil:**
   - Añadir sección para mostrar la información de suscripción
   - Diseñar una tarjeta o contenedor visual para esta información
   - Incluir campos para tipo de plan y fecha de vencimiento

3. **Implementar lógica para obtener datos de suscripción:**
   - Crear funciones para obtener la información de suscripción desde Firestore
   - Asegurar que estos datos se cargan al iniciar la pantalla de perfil

## 4. Implementar selector de modo claro/oscuro

1. **Crear sistema de gestión de temas:**
   - Implementar un ViewModel para manejar el estado del tema
   - Configurar almacenamiento persistente de la preferencia de tema

2. **Añadir control de cambio de tema en el perfil:**
   - Diseñar un Switch o Toggle para cambiar entre temas
   - Conectar este control con el ViewModel de temas

3. **Aplicar el tema seleccionado:**
   - Modificar el contenedor principal de la aplicación para aplicar el tema seleccionado
   - Crear recursos de color para modo claro y oscuro

## 5. Añadir sección de información y tutorial (Esto se hara al tener toda la app finalizada)

1. **Diseñar nueva sección en el perfil:**
   - Crear un botón o tarjeta que lleve a la información de la app
   - Diseñar un botón que dirija al tutorial

2. **Crear pantalla de información:**
   - Implementar una nueva pantalla con detalles sobre la aplicación
   - Añadir a ManejoDeLasPantallasDeLaApp la ruta a esta pantalla

3. **Crear pantalla de tutorial:**
   - Diseñar una interfaz de tutorial con pasos claros
   - Implementar un sistema de navegación entre los pasos del tutorial
   - Incluir imágenes ilustrativas y textos descriptivos

4. **Conectar sistema de navegación:**
   - Asegurar que las nuevas pantallas están correctamente integradas en el flujo de navegación
   - Implementar botones para volver al perfil desde estas pantallas

# Guía de implementación para mejorar la pantalla de tutorial (Josseline)

## 1. Reemplazar imágenes con videos tutoriales

- Crear una estructura para almacenar videos tutoriales en lugar de imágenes estáticas
- Modificar `PhotoCarousel()` para ser `VideoCarousel()` que reproduzca videos en lugar de mostrar imágenes, esta funcion se encuentra en `PantallaDeTutorial` que esta en 
  esta ruta `\AlertSystemApp\app\src\main\java\gt\edu\miumg\luis\alertsystemappmovil\Componentes\PantallaTutorial\PantallaDeTutorial.kt`
- Preparar 4-5 videos cortos (15-30 segundos cada uno) que muestren distintas funcionalidades:
  - Registro e inicio de sesión
  - Envío de alertas
  - Gestión de notificaciones
  - Uso del perfil
  - Planes de suscripción

## 2. Implementar reproducción en bucle

- Configurar la reproducción automática de los videos
- Implementar reproducción en bucle (loop) para cada video
- Eliminar controles de reproducción estándar para que no parezca un reproductor de video
- Agregar transiciones suaves entre videos para mejor experiencia visual

## 3. Mejorar la UI del tutorial

- Rediseñar el layout de la pantalla para mejor integración de los videos
- Aumentar el tamaño del área de visualización de videos
- Añadir indicadores de navegación entre videos (puntos o barras)
- Mejorar el espaciado y alineación de elementos
- Incorporar animaciones de transición entre componentes

## 4. Añadir información de planes de suscripción

- Crear una nueva sección debajo del carrusel de videos para mostrar planes disponibles
- Diseñar tarjetas comparativas para cada plan:
  - Plan gratuito (prueba de 2 semanas)
  - Planes premium (al menos 2 opciones)
- Incluir para cada plan:
  - Nombre del plan
  - Precio
  - Duración
  - Características incluidas (límite de alertas, funciones adicionales)
  - Breve descripción de beneficios

## 5. Optimización técnica

- Implementar carga eficiente de videos (precargar solo el actual y siguiente)
- Asegurar que los videos se adapten a diferentes tamaños de pantalla
- Implementar detección de pausa cuando el usuario abandona la pantalla
- Añadir gestión de errores en caso de problemas al cargar videos

## 6. Consideraciones adicionales

- Asegurar que los videos sean accesibles (subtítulos opcionales)
- Permitir al usuario saltar entre videos mediante gestos
- Considerar añadir un botón para ver todos los tutoriales en una lista
- Mantener coherencia visual con el resto de la aplicación
