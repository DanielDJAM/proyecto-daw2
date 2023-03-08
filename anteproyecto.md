<div align="justify">

# Anteproyecto - ECOMER

<div align="center">
<img src="img/verduras.png" />
</div>

### Descripción del problema.

La brecha digital ha hecho que nuestros productores se separen de los clientes y viceversa. Tambíen, la actual situación económica
está haciendo que muchas familias vean como su sueldo se desvanece comprando algunos prodúctos básicos. Todo lo anterior, nos ha llevado
a que compremos productos de mala calidad y por ende, empeore nuestra salud.

### Objetivo.

- Acercar al productor agrícola y al consumidor.
- El consumidor podrá ahorrar y/o comprar mayor cantidad y calidad en los productos expuestos.
- Mejora de la salud del consumidor.
- Tanto el productor como el consumidor llegar a tener más conciencia con el Medio Ambiente y actuar al respecto.
- El productor podrá conseguir un margen superior de ganancias al no tener que contar con intermediarios.
- Todos los productos expuestos tengan un sello legítimo de calidad.

### Arquitectura y tecnologías a utilizar.

La mejor arquitectura a utilizar en nuestro caso será Microservicios. La escalabilidad que nos ofrece es ideal a la hora de gestionar un e-commerce. La modularidad para que los diferentes equipos (Frontend, Backend, Despliegue, QA...) puedan trabajar independientemente.
La agilidad para la implementación continua y el despliegue rápido de nuevas actualizaciones sin afectar al funcionamiento. La agilidad anterior hace que tenga bastante resilencia ante los fallos parciales del sistema sin llegar a afectar al funcionamiento global.

Por todo lo mencionado anteriormente, he llegado a la conclusión que es lo que mejor se adapta al proyecto.

Utilizaremos Java(Spring Boot) para el Backend, Angular o React para el Frontend, Docker-compose para el despliegue, (si da tiempo) Jenkins para verificar con pipelines, una base de datos MySQL y quizás otra de MongoDB para la búsqueda rápida de usuarios en la base de datos (pendiente de revisar).

</div>
