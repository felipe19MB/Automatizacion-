Automatización Web GanaNet
---  
Para la aplicación GanaNet se contempla la automatización de pruebas E2E
que permiten una regresión y validación de las funcionalidades de la aplicación de una manera más ágil y eficaz.

El framework utilizado para la automatización de las pruebas es Serenity BDD utilizando el patron de diseño Screenplay  
Link de referencia: https://serenity-bdd.github.io/

Requisito para ejecutar:
+ **Java 1.8**
+ **gradle 6 o superior**

Ejecución de pruebas
---  

Para ejecutar el proyecto completo utilizar el comando:
```
 gradle test   
```  
Para ejecutar un runner específico :

```  gradle clean test -Dtest.single=MiRunner  ```   
```  gradle clean test -Prunner=MiRunner  ```
Para ejecutar diferentes runners separándolos por comas:
```  gradle clean test -Prunner=PrimerRunner,SegundoRunner  ```
Para Generar la evidencia de pruebas:
```  gradle aggregate  ```
Aunque el proyecto por si solo genera la evidencia automaticamente una vez finalice la ejecución.
# Ejemplo comandos de ejecución:
```   gradle clean test -Dtest.single=LoginRunner aggregate  ```  