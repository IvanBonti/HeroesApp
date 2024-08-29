Se detalla el propósito y la función de cada módulo en la arquitectura típica de una aplicación de Spring Boot siguiendo el patrón MVC (Model-View-Controller), con una capa adicional de 
Service y Repository:


1. Model
   Descripción: Este módulo representa las entidades o clases que corresponden a la estructura de los datos en la aplicación. Define los objetos que se utilizan en el dominio de la aplicación, como "Hero" o "Vote" en este caso.
   Responsabilidad:
   Define las propiedades de las entidades (como atributos de un héroe o un voto).
   Incluye validaciones y reglas básicas asociadas a los datos.
   Puede utilizar anotaciones de JPA (Java Persistence API) para mapear estas clases a tablas en una base de datos relacional.

2. Controller
   Descripción: Este módulo actúa como una interfaz entre el usuario y la lógica de negocio de la aplicación. Recibe las solicitudes HTTP del cliente (como Postman o un navegador) y las dirige al servicio correspondiente.
   Responsabilidad:
   Maneja las solicitudes HTTP entrantes (GET, POST, PUT, DELETE).
   Valida los datos de entrada.
   Llama a los servicios apropiados para realizar operaciones de negocio.
   Devuelve las respuestas HTTP al cliente con los datos necesarios o mensajes de error.

3. Repository
   Descripción: Este módulo se encarga de la interacción directa con la base de datos. Utiliza Spring Data JPA para simplificar el acceso a la base de datos.
   Responsabilidad:
   Realiza operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre las entidades en la base de datos.
   Define métodos personalizados de consulta utilizando nombres de métodos específicos o anotaciones como @Query.
   Permite que la capa de servicio interactúe con la base de datos de una manera abstracta y desacoplada.

4. Service
   Descripción: Este módulo contiene la lógica de negocio de la aplicación. Se encarga de coordinar las operaciones entre los controladores y los repositorios, asegurando que la aplicación funcione de acuerdo con las reglas de negocio.
   Responsabilidad:
   Implementa la lógica de negocio y reglas de la aplicación.
   Interactúa con los repositorios para realizar operaciones de acceso a datos.
   Gestiona la transaccionalidad, asegurando que las operaciones en la base de datos sean consistentes y se completen correctamente.
   Proporciona una capa intermedia entre el controlador y el repositorio, permitiendo un desacoplamiento y facilitando el mantenimiento del código.


Flujo de Datos en la Arquitectura:
1. Usuario/Cliente envía una solicitud HTTP al Controller.
2. Controller valida la solicitud y la delega al Service correspondiente.
3. Service ejecuta la lógica de negocio, utilizando los Repositories para acceder a los datos en la base de datos.
4. Repository interactúa con la base de datos y devuelve los resultados al Service.
5. Service procesa los resultados y los envía de vuelta al Controller.
6. Controller genera la respuesta HTTP y la devuelve al Usuario/Cliente.



