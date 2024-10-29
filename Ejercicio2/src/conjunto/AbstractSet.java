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
* test*/


package conjunto;

import java.util.Arrays;
import java.util.Objects;


public abstract class AbstractSet<E> implements Set<E> {
	protected int size = 0;

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public void clear() {
		size=0;
	}

	protected abstract E[] toArray();


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AbstractSet<E> that = (AbstractSet<E>) o;
		if (this.size()!= that.size())return false;

		boolean equal = true;
		for(E element : that.toArray()){
			if(!that.contains(element)){
				equal=false;
			}
		}
		return equal;
	}

	@Override
	public int hashCode() {
		var elements = toArray();
		int result = Objects.hash(size);
		for( E e : elements ) {
			result = result + e.hashCode();
		}
		return result;    	
	}

	@Override
	public String toString() {
		return getClass().getName()+"{" +
				"elements=" + Arrays.toString(toArray()) +
				", size=" + size +
				'}';   	
	}
}