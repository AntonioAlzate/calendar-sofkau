# calendar-sofkau

## Modo de uso

1. Modificar el application.properties con los datos de tu servidor de MongoDb
2. Se debe tener una base de datos en MongoDb con una colección llamada program y poner los datos del archivo data-dummy.json
3. para realizar las peticiones una vez se corre la aplicación:
    1. para generar el calendario y almacenarlo --> http://localhost:8080/api/v1/calendar/generate/{id}/{fecha}
        * id --> va el id que se genero en la base de datos al añadir los datos de data.dummy.json
        * fecha --> es la fecha inicial para empezar la generacion del calendario debe ir en formato dd-MM-yyyy ejemplo **01-01-2022**
        
    2. Para obtener los datos del calendario que se almaceno --> http://localhost:8080/api/v1/calendar/get
    
Gracias por leer :v:
