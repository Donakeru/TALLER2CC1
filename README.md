# TALLER 2 - CIENCIAS DE LA COMPUTACIÓN 1

DANIEL ALEJANDRO CHAVEZ BUSTOS - 20212020109
ALEJANDRO - 20


### DESCRIPCIÓN DE LA ACTIVIDAD
En una redonda mesa, cual si fuera torno del hado y escuela de picardías, siéntanse, por ventura y a la buena de Dios, varios pastores de almas —cada cual con su caudal contante y sonante, y con su grey de fieles que le siguen con más o menos fervor—, colocados al acaso como quien mezcla naipes sin mirar, quedando el corro en perpetua trabazón, que el último da la mano al primero y ninguno se queda sin vecino por ambos costados; y manda la fortuna que empiece la danza aquel pastor que más doblones guarda en sus arcas, el cual, tentado por la musa de la diosa Alea, escoge sin previo aviso si ha de mirar a su siniestra o a su diestra, y entre cuantos vecinos se le cuenten por más próximos hasta un número n que el juego determine de antemano, señala al más escaso en feligreses para darle pasaporte de la rueda, traspasándole —¡oh mudanza del siglo!— su gente y su tesoro, y enviándolo de cabeza a la pila de los desposeídos, donde el postrero en caer será el primero en salir, si merced a la suerte llegare ocasión; hecho lo cual, el que así obró designa al siguiente en tomar la palabra y moverse, que no siempre ha de ser el contiguo, sino aquel que las reglas así consientan, y prosigue la rueda sin desfallecer.

Mas si aconteciere —y acontece más a menudo que sermón en cuaresma— que la susodicha pila no esté vacía, el pastor a quien tocare el turno podrá escoger, según mejor le cuadre y su conciencia le dicte, entre volver a arrimar la guadaña y segar otra cabeza de vecino —siempre con el escrutinio de los n inmediatos en la dirección escogida, eligiendo al de menor grey— o, por el contrario, sacar del olvido al que encima de todos yace en la pila, restituyéndolo a la mesa y dándole, no poco ni demasiado, sino la mitad cabal de sus fieles y de su riqueza, con lo cual renace el caído como Lázaro al llamado, y vuelve a la rueda trabado cual eslabón recién bruñido; y sepa todo lector prudente que, si en alguna vuelta el que manda es el más pobre de la compañía, lícito le será meter mano —una sola vez en su turno— en la faltriquera del más rico, y llevarse de ella la tercia parte, tanto en ovejas como en moneda, con lo que la balanza de la fortuna, que suele ser coja, endereza por un instante su pata.

Guárdese, empero, una severa cortesía de vecindad: puede un pastor tener por su izquierda compañero del mesmo trato o negocio —pues no hay contra ello fuero ni pragmática—, mas por su derecha, ¡antes se hiele el Tajo!, jamás habrá de aposentarse quien comparta oficio con él; de manera que, tras cada degüello, rescate o hurto piadoso, se verifique y, si menester fuere, se reorganice el corro hasta que no quede a la diestra sombra de consanguinidad mercantil; y concluirá el juego cuando, rotos los demás eslabones, quede en la redonda pista un solo pastor, rey de burlas y veras, dueño de bolsas y conciencias. Encomendase, finalmente, a los discretos ingenios que lo implementen en la lengua de Java, con traza visible y de buen manejo que pinte la mesa por círculos y la pila por columnas, siendo de sabios moderar el gentío y limitar el número de estos líderes espirituales, no por mengua de espíritu, sino por alivio de los ojos y descanso del arte.

### REQUERIMIENTOS RECUPERADOS (con psobiles cambios)

(INDISPENSABLE: MVC)

1) **Estructura de datos:**
    - Se debe crear una lista circular doblemente enlazada, donde cada nodo representa a un pastor. **OK**
    - Cada pastor tiene como atributos al menos: **OK**
        - caudal (dinero o doblones en sus arcas).
        - feligreses (cantidad de fieles que lo siguen).
        - ocupacion. (se realiza con una clase que funcionará como un directorio de ocupaciones)
    - Pila LIFO

2) **Inicialización:**
    - Los pastores se ubican en la lista de forma aleatoria (como quien mezcla naipes). **OK**
    - La lista debe mantener la circularidad: el último apunta al primero y viceversa. **OK**

3) **Selección inicial del turno:**
    - El primer pastor en actuar es aquel con mayor caudal. **OK**

4) **Mecánica del turno:**
    - El pastor en turno decide (al azar o por regla) mirar hacia la izquierda o hacia la derecha.
    - Puede contar hasta n vecinos en la dirección elegida (n es un parámetro definido por las reglas del juego).
    - Entre esos vecinos contados, selecciona al que tenga menos feligreses.

5) **Eliminación y transferencia:**
    - El pastor seleccionado es eliminado de la rueda (sale de la lista circular).
    - Sus feligreses y caudal se transfieren al pastor que lo eliminó.
    - El eliminado se envía a una pila de desposeídos (estructura tipo LIFO: el último en entrar será el primero en salir).

4) **Continuidad del juego:**
    - El pastor que acaba de eliminar a otro designa al siguiente en jugar.
    - El turno no necesariamente pasa al vecino inmediato, sino que depende de las reglas definidas.
    - El juego continúa mientras queden pastores en la rueda.

5) **Uso de la pila de desposeídos:**
    - Si la pila no está vacía, el pastor en turno tiene dos opciones:
        - Eliminar nuevamente a un vecino (como en la mecánica ya descrita).
        - Rescatar al pastor que se encuentra en la cima de la pila (el último eliminado).
    - Si elige rescatarlo, este pastor vuelve a la rueda y recibe:
    - La mitad exacta de los feligreses del pastor que lo rescató.
    - La mitad exacta del caudal del pastor que lo rescató.
    - El rescatado es reincorporado a la lista circular en la posición correspondiente (como un nodo activo).

6) **Regla de compensación de riqueza:**
    - Si el pastor en turno resulta ser el más pobre de todos los presentes en la rueda, entonces:
    - Puede realizar una sola vez en su turno una acción especial:
    - Tomar la tercera parte (1/3) de los feligreses y del caudal del pastor más rico.

7) **Uso de la pila de desposeídos:**
    - Si la pila no está vacía, el pastor en turno tiene dos opciones:
        - Eliminar nuevamente a un vecino (como en la mecánica ya descrita).
        - Rescatar al pastor que se encuentra en la cima de la pila (el último eliminado).
    - Si elige rescatarlo, este pastor vuelve a la rueda y recibe:
        - La mitad exacta de los feligreses del pastor que lo rescató.
        - La mitad exacta del caudal del pastor que lo rescató.
    - El rescatado es reincorporado a la lista circular en la posición correspondiente (como un nodo activo).

8) **Regla de compensación de riqueza:**
    - Si el pastor en turno resulta ser el más pobre de todos los presentes en la rueda, entonces:
        - Puede realizar una sola vez en su turno una acción especial:
            - Tomar la tercera parte (1/3) de los feligreses y del caudal del pastor más rico.
    - Esta acción busca equilibrar la “balanza de la fortuna”.

