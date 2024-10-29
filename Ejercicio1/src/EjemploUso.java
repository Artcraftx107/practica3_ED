/*******************************
 * Copyright (C) [2024] [J.L. Triviño]
 *
 * Este programa es software libre: puedes redistribuirlo y/o modificarlo
 * bajo los términos de la Licencia Pública General de GNU según lo publicado
 * por la Free Software Foundation, ya sea la versión 3 de la Licencia, o
 * (a tu elección) cualquier versión posterior.
 *
 * Este programa se distribuye con la esperanza de que sea útil, pero
 * SIN NINGUNA GARANTÍA; ni siquiera la garantía implícita de
 * COMERCIABILIDAD o IDONEIDAD PARA UN PROPÓSITO PARTICULAR.
 * Consulta la Licencia Pública General de GNU para obtener más detalles.
 *
 * Deberías haber recibido una copia de la Licencia Pública General de GNU
 * junto con este programa. Si no es así, consulta <http://www.gnu.org/licenses/>.
 */


import java.util.Scanner;

import cola.ArrayQueue;
import cola.Queue;

public final class EjemploUso {
    private static void probar( Queue<Integer> queue, Scanner scanner ) {
        System.out.println("Introduce una secuencia de números enteros. Ingresa 'fin' para terminar:");
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            queue.enqueue(number);
        }

        System.out.println( "La cola leída es: "+queue );

        System.out.println("Números introducidos:");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }


    @SuppressWarnings("unlikely-arg-type")
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var queueArray = new ArrayQueue<Integer>();

        probar( queueArray, scanner );

        scanner.next();
        scanner.close();

        queueArray = new ArrayQueue<Integer>();
        var queueArray2 = new ArrayQueue<Integer>();
        for( int k = 0; k < 10; k++ ) {
            queueArray.enqueue(k);
            queueArray2.enqueue(k);
        }

        if (queueArray.equals( queueArray2 )) {
            System.out.println( "Las colas son iguales" );
        }else {
            System.out.println( "Las colas son diferentes" );
        }
    }
}