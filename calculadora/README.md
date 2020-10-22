# pruebaSanitas

Para todo el proceso de desarrollo seguiremos la metodologia de gitflow, aunque no sigo la nomenclatura al 100%.

La primera subida se ha desarrollado en la rama main con la estructura base del proyecto de Spring Boot. 

A partir de este paso se ha creado una rama develop para cada paso de desarrollo, que es donde se han hecho los cambios de los nuevos desarrollos, apoyándonos en ramas feature para cada issue.

Una vez que se ha tenido una versión estable, sin errores de compilación y con los junit respectivos implementados, se ha ido haciendo merge en la rama main.

Para los test unitarios añadimos la libreria Mockito a traves de maven.

Para añadir el trazador que se nos pasa como libreria, primero lo añadimos como dependencia al pom y añadimos los jar a nuestro repositorio local. 

Se ha añadido al repositorio local en la estructura de carpetas: io.corp.calculator

mvn install:install-file -Dfile=C:\Users\Jose\.m2\repository\test4\tracer-1.0.0.jar -DgroupId=io.corp.calculator -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar

Adaptando la ruta a donde tengamos ubicado el jar.

Se implementa la interfaz de usuario de Swagger, para que sea mas facil e intuitivo de consumir.

Por ultimo se mergeara la ultima rama develop en main para generar una version de la api operativa.

Para usar la api se debe compilar a traves de maven usando el comando mvn clean install, y se creara un jar en la carpeta target del proyecto.

Ejecutando este jar, se desplegara el webservice en localhost:8888, para acceder a la interfaz hay que acceder mediante la ruta: http://localhost:8888/swagger-ui.html 

He decidido al final desarrollar un solo endpoint para que sea más fácil de mantener, y si el día de mañana, esta api se amplia solo habría que tocar la capa de servicio y el tipo Enum que contiene el tipo de operaciones que se pueden realizar.
