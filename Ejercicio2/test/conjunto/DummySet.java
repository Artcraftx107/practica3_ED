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

//Dummy class for testing exceptions
public class DummySet<E> extends AbstractSet<E> {

	public DummySet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(E element) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<E> union(Set<E> other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<E> intersection(Set<E> other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<E> difference(Set<E> other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSubset(Set<E> other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected E[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
