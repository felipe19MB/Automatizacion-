# Estandar de Codificacion
---
<span style="font-weight: bold;color:white;margin:0 8px 0 0;padding:4px 6px;background-color:#6e9286;border-radius:3px">do</span>
Nombar los metodos dentro de la clase utilizando la nomenclatura **camelCase**
```java
// Don't

    public String GetNombre()
    {
        // ...
    }

// Correct

    public String getNombre()
    {
        // ...
    }

```

---
<span style="font-weight: bold;color:white;margin:0 8px 0 0;padding:4px 6px;background-color:#6e9286;border-radius:2px;">do</span>
Nombrar los elementos especificando el tipo de elemento como prefijo de maximo 3 caracteres y usando la nomenclatura **camelCase**
```java
// Don't

    @FindBy(xpath="")
    private WebElement BotonIngresar;
 
// Correct

    @FindBy(xpath="")
    private WebElement btnIngresar;

```
---
<span style="font-weight: bold;color:white;margin:0 8px 0 0;padding:4px 6px;background-color:#6e9286;border-radius:2px;">do</span>
Nombrar los variables dentro de la clase lo mas descriptivo posible para su proposito usando la nomenclatura **camelCase**
```java
// Don't

    String x = "Helmut"
 
// Correct

    String nombre = "Helmut"


```
<span style="font-weight: bold;color:white;margin:0 8px 0 0;padding:4px 6px;background-color:#6e9286;border-radius:3px">do</span>
Usar **PascalCasing** para los nombres de las clases
```java
public class DashBoardPage
{
}
``` 

---
<span style="font-weight: bold;color:white;margin:0 8px 0 0;padding:4px 6px;background-color:#6e9286;border-radius:2px;">do</span>
Nombrar las etiquetas dentro del feature file con la nomenclatura **PascalCase** y agregar por defecto el numero del caso de prueba definido en zpehyr para automatizar
```java
// Don't

    @smoke_test
    @Caso1
 
// Correct

    @SmokeTest
    @INT-T200


```

---
<span style="font-weight: bold;color:white;margin:0 8px 0 0;padding:4px 6px;background-color:#6e9286;border-radius:2px;">do</span>
Nombrar los parametros dentro del feature file con la nomenclatura **camelCase**
```java
// Don't

    |Usuario|Password|NombreUsuario|
 
// Correct

    |usuario|password|nombreUsuario|


```

---
<span style="font-weight: bold;color:white;margin:0 8px 0 0;padding:4px 6px;background-color:#6e9286;border-radius:2px;">do</span>
Usar la misma descripcion definida en Zephyr en el **Scenario Outline**
```java
// Don't

    Como usuario quiero iniciar sesion en Ganamovil para poder ver si tengo acceso.
 
// Correct

    INT-T200 Como usuario quiero iniciar sesion en Ganamovil para poder ver si tengo acceso.


```
---
<span style="font-weight: bold;color:white;margin:0 8px 0 0;padding:4px 6px;background-color:#6e9286;border-radius:2px;">do</span>
Nombrar los paquetes usando la nomenclatura **snake_case**
```java
// Don't

    Acceso
 
// Correct

    acceso


```
   
# Estandar de comentarios

**IMPORTANTE:** Para empezar a comentar escribe /** sobre un metodo y presiona enter.

* Todos los comentarios deberian iniciar con UpperCase
* Todos los comentarios deberian terminar con un punto.

<span style="font-weight: bold;color:white;margin:0 8px 0 0;padding:4px 6px;background-color:#6e9286;border-radius:2px;">do</span>Como comentar un metodo estandar de tipo void (Que no retorna ningun valor).

```java
        /**
        * Este metodo permite guardar un listado de usuarios
        * 
        * @param List<String> usuarios
        * 
        */
        public void guardarUsuarios(List<String> usuarios)
        {
        }
```



<span style="font-weight: bold;color:white;margin:0 8px 0 0;padding:4px 6px;background-color:#6e9286;border-radius:2px;">do</span>Como comentar un metodo estandar que retorna un valor.

```java
        /**
        * Este metodo realiza la suma de 2 valores y retorna el resultado.
        * 
        * @param int valor1
        * @param int valor2
        * @return La suma de los valores 1 y 2
        */
        public int sumar(final int valor1,final int valor2)
        {
            int resultado = valor1+valor2;
            return resultado;
        }
```


<span style="font-weight: bold;color:white;margin:0 8px 0 0;padding:4px 6px;background-color:#6e9286;border-radius:2px;">do</span>Como comentar un variables global

```java
        /**
        * Esta es una instancia del PageObject de la pagina principal
        * 
        */
        

```
