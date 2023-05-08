# Prueba-Tecnica-ecommerce
Construir una aplicación/servicio en SpringBoot que provea una endpoint REST de consulta.

Construir una aplicación/servicio en SpringBoot que provea una endpoint REST de consulta que:
• Acepte como parámetros de entrada: fecha de aplicación, idenQficador de producto, idenQficador
de cadena.
• Devuelva como datos de salida: idenQficador de producto, idenQficador de cadena, tarifa a aplicar,
fechas de aplicación y precio final a aplicar.
• Se debe uQlizar una base de datos en memoria (Qpo h2) e inicializar con los datos del ejemplo, (se
pueden cambiar el nombre de los campos y añadir otros nuevos si se quiere, elegir el Qpo de dato
que se considere adecuado para los mismos).

• Desarrollar unos test al Endpoint REST que validen las siguientes peQciones al servicio con los
datos del ejemplo:

o Test 1: peQción a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
o Test 2: peQción a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
o Test 3: peQción a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
o Test 4: peQción a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
o Test 5: peQción a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
