Para todo el proceso de desarrollo seguiremos la metodologia de gitflow, aunque no sigo la nomenclatura al 100%.

La primera subida se ha desarrollado en la rama main con la estructura base del proyecto de Spring Boot. 

A partir de este paso se ha creado una rama develop para cada paso de desarrollo, que es donde se han hecho los cambios de los nuevos desarrollos, apoyándonos en ramas feature para cada issue.

Una vez que se ha tenido una versión estable, sin errores de compilación y con los junit respectivos implementados, se ha ido haciendo merge en la rama main.

Para los test unitarios añadimos la libreria Mockito a traves de maven. Como aconsejaba que esta prueba se realice aproximadamente en unas 4 horas, he tratado la excepción de que si envia un null en la entrada, en la salida devuelve 0. Con algo más de tiempo, se podría capturar la excepción y mostrar un mensaje de error más descriptivo.

Para añadir el trazador que se nos pasa como libreria, primero lo añadimos como dependencia al pom y añadimos los jar a nuestro repositorio local. 

Se ha añadido al repositorio local en la estructura de carpetas: io.corp.calculator

Para usar la api se debe compilar a traves de maven usando el comando mvn clean install, y se creara un jar en la carpeta target del proyecto.

Se implementa la interfaz de usuario de Swagger, para que sea mas facil e intuitivo de consumir.

Ejecutando este jar, se desplegara el webservice en localhost:8888, para acceder a la interfaz hay que acceder mediante la ruta: http://localhost:8888/swagger-ui.html 
