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

public class LinkedListSet<E> extends AbstractSet<E> {
	private static class Node<E>{
        E data;
        Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }		
	}
	
    private Node<E> top;
	
	public LinkedListSet() {
		top=null;
	}

	@Override
	public void add(E element) {
		if(!contains(element)){
			top = new Node<>(element, top);
			size++;
		}
	}

	@Override
	public void remove(E element) {
		if (top != null) {
			if(top.data.equals(element)){
				top=top.next;
				size--;
			}else{
				Node<E> actual = top;
				boolean found = false;
				while(actual.next!=null && !found){
					if(actual.data.equals(element)){
						actual.next=actual.next.next;
						size--;
						found=true;
					}else{
						actual=actual.next;
					}
				}
			}
		}
	}

	@Override
	public boolean contains(E element) {
		Node<E> current = top;
		boolean found = false;
		while(current!=null && !found){
			if(current.data.equals(element)){
				found=true;
			}
			current=current.next;
		}
		return found;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public void clear() {
		top = null;
		size=0;
	}

	@Override
	public Set<E> union(Set<E> other) {
		Set<E> result = new LinkedListSet<>();
		for(E element : toArray()){
			result.add(element);
		}
		AbstractSet<E> that = (AbstractSet<E>) other;
		for(E otherElement : that.toArray()){
			result.add(otherElement);
		}
		return result;
	}

	@Override
	public Set<E> intersection(Set<E> other) {
		Set<E> result = new LinkedListSet<>();
		for(E element : toArray()){
			if(other.contains(element)){
				result.add(element);
			}
		}
		
		return result;
	}

	@Override
	public Set<E> difference(Set<E> other) {
		Set<E> result = new LinkedListSet<>();
		AbstractSet<E> that = (AbstractSet<E>) other;
		for(E element : toArray()){
			if(!that.contains(element)){
				result.add(element);
			}
		}

		for(E otherElement : that.toArray()){
			if(!result.contains(otherElement) && !contains(otherElement)){
				result.add(otherElement);
			}
		}

		
		return result;
	}

	@Override
	public boolean isSubset(Set<E> other) {
		boolean subset = true;
		for(E element : toArray()){
			if(!other.contains(element)){
				subset=false;
			}
		}
		return subset;
	}

	@Override
	public E[] toArray() {
		@SuppressWarnings("unchecked")
		E[] result = (E[]) new Object[size];
		Node<E> current = top;
		int index = 0;
		while(current!=null){
			result[index++] = current.data;
			current=current.next;
		}
		return result;
	}
}