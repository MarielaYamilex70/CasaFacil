# CasaFacil
 Proyecto Final de JAVA en DICAMPUS

 
**Casa Fácil** es una aplicación web para la gestión de usuarios y tareas, que incluye funcionalidades completas para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar). La aplicación también muestra información meteorológica en el encabezado y utiliza Docker para facilitar el despliegue.

## Características del Proyecto

- **Gestión de Usuarios**: CRUD completo para usuarios.
- **Gestión de Tareas**: CRUD completo para tareas.
- **Relación Usuario-Tareas**: Gestión y asignación de tareas a usuarios.
- **Control de Sesiones**: Verificación de sesión para acceso restringido.
- **Integración con API del Clima**: Información meteorológica en el encabezado.
- **Configuración con Docker**: Despliegue simplificado mediante Docker.

## Tecnologías Utilizadas

- **Java EE**: Backend y lógica de negocio.
- **JSP (JavaServer Pages)**: Vistas dinámicas.
- **Servlets**: Manejo de peticiones HTTP.
- **Gson**: Procesamiento de JSON.
- **Docker**: Contenedorización y despliegue.
- **Tomcat**: Servidor de aplicaciones.
- **Maven**: Gestión de dependencias y construcción.

## Instalación y Configuración

### Clonación del Repositorio

```bash
git clone https://github.com/tu_usuario/casa-facil.git
cd casa-facil
```

### Instalación de Dependencias

Asegúrate de tener [Maven](https://maven.apache.org/) instalado y ejecuta:

```bash
mvn install
```

### Configuración del Entorno

- **Archivos de Propiedades**: Configura los archivos necesarios en el directorio raíz del proyecto (excluidos del control de versiones).

### Construcción y Despliegue con Docker

1. **Construir la Imagen Docker**

   Crea una imagen Docker para la aplicación:

   ```bash
   docker build -t casa-facil .
   ```

2. **Ejecutar el Contenedor**

   Ejecuta el contenedor Docker:

   ```bash
   docker run -p 8080:8080 casa-facil
   ```

   Accede a la aplicación en tu navegador en [http://localhost:8080/casa-facil](http://localhost:8080/casa-facil).

## Uso

- **Inicio de Sesión**: Requiere autenticación para acceder a la gestión de usuarios y tareas.
- **Gestión de Usuarios**: Crear, leer, actualizar y eliminar usuarios.
- **Gestión de Tareas**: Crear, leer, actualizar y eliminar tareas.
- **Información Meteorológica**: Mostrada en el encabezado de la aplicación.

## Estructura del Proyecto

```
casa-facil/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── casaFacil/
│   │   │   ├── conectores/
│   │   │   ├── consumoAPI/
│   │   │   ├── gestion/
│   │   │   ├── modelos/
│   │   │   ├── resources/
│   │   │   └── servlet/
│   │   │ 
│   │   ├── resources/
│   │   └── webapp/
│   │       ├── css/
│   │       ├── images/
│   │       ├── WEB-INF/
│   │       │   ├── lib/
│   │       │   └── web.xml
│   │       ├── views/
│   │       │   ├── 
│   │       └── index.jsp
│   └── test/
│
├── Dockerfile
├── .gitignore
└── pom.xml
```


---

Este README proporciona una visión completa del proyecto, incluyendo características, tecnologías, instalación, uso y estructura. Asegúrate de personalizar la información específica y las rutas según tu configuración y necesidades.
