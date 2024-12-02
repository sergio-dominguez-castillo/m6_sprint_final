## Caso “MobiStore”

La empresa distribuidora de equipos móviles MovilCL busca iniciar su transformación digital 
con el desarrollo de una aplicación móvil Android. En esta primera fase, el objetivo principal 
es crear un mínimo producto viable (MVP) que permita a los posibles clientes visualizar un 
catálogo de teléfonos móviles disponibles y seleccionar aquellos que les interesen.

### Alcance del Proyecto.

- Los usuarios podrán navegar por un listado de teléfonos móviles que se encuentran en venta.
- Los usuarios podrán seleccionar un teléfono específico para obtener más detalles.

### Detalles Técnicos.

- El equipo de desarrollo Backend ha implementado una API REST que provee la información necesaria sobre los teléfonos y sus características.
- Se solicita desarrollar una aplicación Android que consuma la API REST proporcionada.
- El servicio REST cuenta con dos endpoints; El primero proporciona la totalidad de equipos móviles disponibles, y el segundo entrega los detalles de cada equipo a través de su identificador.
- El proyecto debe ser lo suficientemente flexible para ser escalado y mejorado con funcionalidades adicionales en fases futuras.
- Bajo los paradigmas de flexibilidad y escalabilidad, además de costos de mantención bajos, la API mínima para realizar el proyecto es 27 y su target 34.

1. APIs:

- https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/products/
- https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/details/1

2. No olvides utilizar el estilo de Arquitectura MVVM-StateFlow-ROOM.

- Esto quiere decir que debes utilizar un código limpio, respetar estilos de codificación y evitar a toda costa el código espagueti.
- Antes de mostrar los elementos en la primera lista, captura la respuesta de la API en ROOM para generar una persistencia de datos.

3. El proyecto consta de dos vistas:

- La primera es aquella que muestra la totalidad de equipos.
- La segunda muestra al detalle la información del equipo seleccionado.
- Importante: La segunda pantalla debe poseer un botón flotante que permita enviar un correo.

4. Dentro de la primera vista los elementos se deben mostrar por medio de una Columna o una Grilla, el diseño queda a tu elección.

- Demás está decir que tanto la columna como la grilla deben ser de la familia Lazy (LazyColumn o LazyVerticalGrid).

5. La navegación dentro de la aplicación debe ser controlada por un NavManager y a nivel de diseño por una TopBar.

6. La paleta de colores de la aplicación consta de cuatro colores que debes utilizar con mucha sabiduría.

- 0xFF252243
- 0xFF5161F1
- 0xFF63E9F8
- 0xFFFFFFFF
- (Pueden agregar colores extras sin problemas, siempre y cuando exista una armonía en el diseño).

7. Ningún color dentro de la aplicación debe establecerse a la fuerza, es decir, debes crear sus respectivas variables y modificar el Theme según corresponda.

8. Todo texto dentro de la aplicación debe estar dentro de su respectiva variable. A excepción de aquellos que provienen directamente de la API.

9. La API de detalle retorna un valor booleano de “credit”, es importante que, al momento de crear la vista de detalle, este dato no se muestre tal cual y se cambie por:

- true: Acepta Crédito.
- false: Sólo Efectivo.

10. La segunda vista además de mostrar el detalle al que se accedió a través del id del móvil, debe tener un botón flotante:

- Al darle clic se debe abrir la aplicación que permite enviar correos.
- La siguiente información debe aparecer por defecto:
o Destinatario: info@novaera.cl
o Asunto: Consulta {name} - Id: {id}
o Mensaje predefinido (Pueden modificarlo a su gusto, lo importante es que muestre el nombre y el id.
“Hola, me gustaría obtener más información del móvil {name} de código {id}. Quedo atento a su respuesta”.

11. Realiza dos Tests dentro de la aplicación:

- 1 test Unitario.
- 1 test Instrumental.

12. Una vez completo tu proyecto, crea un repositorio en tu GitHub y alójalo allí. Copia el enlace dentro de un archivo .txt y súbelo al nodo.