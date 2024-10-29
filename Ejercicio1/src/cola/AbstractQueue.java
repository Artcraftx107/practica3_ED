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
import java.util.Iterator;
import java.util.Objects;

public abstract class AbstractQueue<E> implements Queue<E> {
    protected int size = 0;  // Mantiene el tamaño actual de la cola

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Método abstracto que convierte la cola en un array de sus elementos.
     * Las implementaciones concretas deben definir este método.
     */
    protected abstract E[] toArray();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Queue<?> otherQueue = (Queue<?>) obj;
        if (this.size() != otherQueue.size()) return false;

        // Convertir ambos a iteradores para comparar los elementos en orden
        Iterator<E> thisIterator = Arrays.asList(this.toArray()).iterator();
        Iterator<?> otherIterator = Arrays.asList(((AbstractQueue<?>) otherQueue).toArray()).iterator();

        boolean equalColas = true;
        while (thisIterator.hasNext() && otherIterator.hasNext()) {
            if (!Objects.equals(thisIterator.next(), otherIterator.next())) {
                equalColas = false;
            }
        }
        return equalColas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, Arrays.hashCode(toArray()));
    }

    @Override
    public String toString() {
        return getClass().getName() + "{elements=" + Arrays.toString(toArray()) + ", size=" + size + '}';
    }
}