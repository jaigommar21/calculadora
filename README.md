

# Calculadora basada en Microservicios con SpringBoot

Soporta las operaciones de suma y resta con dos operandos

Usa la libreria tracer

## Requisitos 
- versión de Java 11
- version de Maven 3.8 o superior

## Procedimiento

1. Descargar el repositorio girhub
2. Instalar la libreria tracer-1.0.0.jar en el repositorio local
3. Instalación de Maven
4. Ejecutar el JAR de la carpeta /target


Realizar los siguiente pasos en una consolta:

```
git clone https://github.com/RotaruDan/calculadora
cd calculadora
mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -Dfile=./lib/tracer-1.0.0.jar
mvn clean install

```

Ejecución de la aplicación:

```
java -jar target/calculadora.jar`
```

Con esto levantamos nuestro servicios REST en `http://localhost:8080/api/calcular`


## API REST

Para probar el servicio puedes usar Postman o el comando curl

La petición al servicio REST se realiza de la siguiente manera :

`GET http://localhost:8080/api/calcular/operando/ope1/ope2`

Donde:
- operando : representa la operacion y puede ser el texto : SUMA o RESTA
- ope1 y ope2 : son los operandos y pueden ser enteros o decimales

Ejemplo :

La siguiente  operación : 

`GET http://localhost:8080/api/calcular/SUMA/4.4/3.4`

nos devolvera:

```
{
    "operacion": "SUMA",
    "operando1": 4.4,
    "operando2": 3.4,
    "resultado": 7.8
}
```

## Ejecutar tests

Para ejecutar los test solo debes ejecutar el comando `mvn clean test` en la carpeta donde has bajado el proyecto.

