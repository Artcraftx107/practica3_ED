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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListSetTest {
	private LinkedListSet<Integer> set;

	@BeforeEach
	void setUp() {
		set = new LinkedListSet<>();
	}

	@Test
	void testAdd() {
		set.add(1);
		assertTrue(set.contains(1));
	}

	@Test
	void testRemove() {
		set.add(1);
		set.remove(1);
		assertFalse(set.contains(1));
	}

	@Test
	void testContains() {
		set.add(1);
		assertTrue(set.contains(1));
		assertFalse(set.contains(2));
	}

	@Test
	void testIsEmpty() {
		assertTrue(set.isEmpty());
		set.add(1);
		assertFalse(set.isEmpty());
	}

	@Test
	void testClear() {
		set.add(1);
		set.clear();
		assertTrue(set.isEmpty());
	}

	@Test
	void testUnion() {
		LinkedListSet<Integer> other = new LinkedListSet<>();
		set.add(1);
		other.add(2);
		LinkedListSet<Integer> union = (LinkedListSet<Integer>) set.union(other);
		assertTrue(union.contains(1));
		assertTrue(union.contains(2));
	}

	@Test
	void testIntersection() {
		LinkedListSet<Integer> other = new LinkedListSet<>();
		set.add(1);
		set.add(2);
		other.add(2);
		other.add(3);
		LinkedListSet<Integer> intersection = (LinkedListSet<Integer>) set.intersection(other);
		assertTrue(intersection.contains(2));
		assertFalse(intersection.contains(1));
		assertFalse(intersection.contains(3));
	}

	@Test
	void testDifference() {
		LinkedListSet<Integer> other = new LinkedListSet<>();
		set.add(1);
		set.add(2);
		other.add(2);
		other.add(3);
		LinkedListSet<Integer> difference = (LinkedListSet<Integer>) set.difference(other);
		assertTrue(difference.contains(1));
		assertFalse(difference.contains(2));
		assertFalse(difference.contains(3));
	}

	@Test
	void testIsSubset() {
		LinkedListSet<Integer> other = new LinkedListSet<>();
		set.add(1);
		set.add(2);
		other.add(1);
		other.add(2);
		other.add(3);
		assertTrue(set.isSubset(other));
		other.remove(2);
		assertFalse(set.isSubset(other));
	}

	@Test
	void testUnionClassCastException() {
		Set<Integer> other = new DummySet<>();
		set.add(1);
		other.add(2);
		assertThrows(ClassCastException.class, () -> {
			set.union(other);
		});
	}

	@Test
	void testIntersectionClassCastException() {
		Set<Integer> other = new DummySet<>();
		set.add(1);
		other.add(2);
		assertThrows(ClassCastException.class, () -> {
			set.intersection(other);
		});
	}

	@Test
	void testDifferenceClassCastException() {
		Set<Integer> other = new DummySet<>();
		set.add(1);
		other.add(2);
		assertThrows(ClassCastException.class, () -> {
			set.difference(other);
		});
	}

	@Test
	void testIsSubsetClassCastException() {
		Set<Integer> other = new DummySet<>();
		set.add(1);
		other.add(2);
		assertThrows(ClassCastException.class, () -> {
			set.isSubset(other);
		});
	}
}

