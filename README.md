# proyecto-eldar

### Para entrar a la pag swagger donde estan los endpoints:

https://eldar-app.herokuapp.com/swagger-ui/index.html#/
# proyecto-eldar

### Para entrar a la pag swagger donde estan los endpoints:

https://eldar-app.herokuapp.com/swagger-ui/index.html#/

### /card/insertCard (Json para insertar tarjetas nuevas)

ID AUTOINCREMENT(no necesita setear id)

Este endpoint esta creado sin restriccion de nada.

```json 
{
 
    "marca": "AMEX",
    "number": "374245455400126",
    "name": "Lituan",
    "lastName": "Marlon",
    "month": "10",
    "year": "2026",
    "importeCard": 20000
}
```

### /card/getAllCards (Devuelve todas las tarjetas de la db para obtener id)
```json 
[
  {
    "idCard": 1,
    "marca": "VISA",
    "number": "4917484589897107",
    "name": "Eduardo",
    "lastName": "Casanova",
    "month": "12",
    "year": "2023",
    "importeCard": 10000
  },
  {
    "idCard": 2,
    "marca": "VISA",
    "number": "4001919257537193",
    "name": "Eduardo",
    "lastName": "Rogelio",
    "month": "8",
    "year": "2024",
    "importeCard": 10000
  }
]
```

### /card/calculateTasa 

**INSERCION**
```json 
{
  "idCard": 1,
  "montoOperation": 100,
  "dia": 1,
  "mes": 12,
  "ano": 1990
}
```
Calcula la tasa en base a ->

* VISA [ Toma el año lo divide por el mes el porcentaje de esto se lo suma al importe ingresado, retorna un json con **IMPORTE** con tasa y **MARCA** ]
* NARANJA [ Toma el día del mes y lo multiplica por 0.5 el porcentaje de esto se lo suma al importe ingresado, retorna un json con **IMPORTE** con tasa y **MARCA** ]
* AMEX [ Toma el mes y lo multiplica por 0.1 el porcentaje de esto se lo suma al importe ingresado, retorna un json con **IMPORTE** con tasa y **MARCA** ]

**RESULTADO**
```json
{
  "importeTasa": 107.5,
  "marca": "VISA"
}
```

![image](https://user-images.githubusercontent.com/20959371/190888433-ee4b1669-46ef-43e8-b532-2e4d5a2356b7.png)
