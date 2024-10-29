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


package conjunto;

public interface Set<E> {
    void add(E element);
    void remove(E element);
    boolean contains(E element);
    int size();
    boolean isEmpty();
    void clear();
    Set<E> union(Set<E> other);
    Set<E> intersection(Set<E> other);
    Set<E> difference(Set<E> other);
    boolean isSubset(Set<E> other);
}
