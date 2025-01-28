# Proyecto Reto2025 Mobile

## Descripción
Este proyecto es una aplicación móvil desarrollada en Kotlin y Java, utilizando Gradle como sistema de construcción.
La aplicación permite a los usuarios ver las actividades programadas o solicitadas y añadir datos, si participan en alguna de ellas, como incidencias, asistentes por grupo etc... 
tambien pueden subir fotos que queden relaccionadas con la actividad o marcar puntos de interes en un mapa relaccionados con dicha actividad.

## Estructura del Proyecto

### API
Aqui tenemos la conexion a la API para poder trabajar con la base de datos.

### Componentes
Este archivo contiene componentes de la interfaz de usuario, como el mapa de Google y los diálogos para añadir y eliminar puntos de interés, calendario, barras superiores o inferiores...
tambien tenemos un objeto en el que se guardaran los datos del usuario que inicia sesion

### Data
en esta clase se recogen todos los elementos presentes en la base de datos

### Navigation
En este paquete encontramos los datos necesarios para la navegacion entre pantallas

### ViewModel
Un paquete que contiene las clases cuyos metodos se encargaran de manejar los datos de cada elemento de la base de datos, asi sea para consultar añadir modificar o borrar datos.

### Views
El paquete que contiene todas las vistas de la aplicacion

## Funcionalidades Principales

### Consulta de actividades
podemos consultar todas las actividades programadas y registradas y ver toda la informacion disponible, ya sea buscando la actividad por nombre, estado, fecha o consultando 
las actividades que uno mismo ha solicitado o en las que participa

### Comentarios e incidencias
en el caso de que el usuario logeado participe en una actividad podra ademas añadir o editar incidencias, 
modificar el numero de asistentes y añadir comentarios para cada grupo.

### Subida de Fotos
La aplicación permite a los usuarios hacer fotos y seleccionarlas desde la galeria, poder revisar las selecionadas y guardarlas a traves de la API

### Gestión de Puntos de Interés
Los usuarios pueden añadir y eliminar puntos de interés en un mapa de Google.

## Dependencias
El proyecto utiliza varias dependencias, incluyendo:
- Retrofit para las llamadas a la API.
- Google Maps para la visualización del mapa.
- AndroidX para componentes de la interfaz de usuario y gestión del ciclo de vida.

