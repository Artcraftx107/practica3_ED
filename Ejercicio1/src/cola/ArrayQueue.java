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


package cola;

import java.util.Arrays;
import java.util.Objects;

public class ArrayQueue<E> extends AbstractQueue<E> {
    private E[] elements;
    private int head, tail;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        head = 0;
        tail = 0;
    }

    @Override
    public void enqueue(E item) {
        if (size == elements.length) {
            resize(elements.length * 2);  // Redimensiona si el array esta lleno
        }
        elements[tail] = item;
        tail = (tail + 1) % elements.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        E item = elements[head];
        elements[head] = null;  // Permite recolección de basura
        head = (head + 1) % elements.length;
        size--;

        // Redimensiona a la mitad si la cola es menor que un cuarto de su capacidad
        if (size > 0 && size <= elements.length / 4 && elements.length / 2 >= INITIAL_CAPACITY) {
            resize(elements.length / 2);
        }

        return item;
    }

    @Override
    public E head() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return elements[head];
    }

    @Override
    protected E[] toArray() {
        @SuppressWarnings("unchecked")
        E[] array = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[(head + i) % elements.length];
        }
        return array;
    }

    private void resize(int nuevaCapacidad) {
        @SuppressWarnings("unchecked")
        E[] nuevoArray = (E[]) new Object[nuevaCapacidad];
        for (int i = 0; i < size; i++) {
            nuevoArray[i] = elements[(head + i) % elements.length];
        }
        elements = nuevoArray;
        head = 0;
        tail = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayQueue)) return false;
        ArrayQueue<?> other = (ArrayQueue<?>) o;
        if (this.size != other.size) return false;

        boolean equalArrays = true;
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(this.elements[(head + i) % elements.length],
                    other.elements[(other.head + i) % other.elements.length])) {
                equalArrays = false;
            }
        }
        return equalArrays;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, Arrays.hashCode(toArray()), head, tail);
    }
}