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

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ArrayQueueTest {
    private ArrayQueue<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new ArrayQueue<>();
    }

    @Test
    public void testPushAndPop() {
        stack.enqueue(1);
        stack.enqueue(2);
        stack.enqueue(3);

        assertEquals(Integer.valueOf(1), stack.dequeue());
        assertEquals(Integer.valueOf(2), stack.dequeue());
        assertEquals(Integer.valueOf(3), stack.dequeue());
    }

    @Test
    public void testPopEmptyStack() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            stack.dequeue();
        });
        assertEquals("La pila está vacía", exception.getMessage());
    }

    @Test
    public void testPeek() {
        stack.enqueue(1);
        stack.enqueue(2);
        
        assertEquals(Integer.valueOf(1), stack.head());
        stack.dequeue();
        assertEquals(Integer.valueOf(2), stack.head());
    }

    @Test
    public void testPeekEmptyStack() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            stack.head();
        });
        assertEquals("La pila está vacía", exception.getMessage());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.enqueue(1);
        assertFalse(stack.isEmpty());
        stack.dequeue();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testResize() {
        for (int i = 0; i < 200; i++) {
            stack.enqueue(i);
        }
        for (int i = 0; i < 200; i++) {
            assertEquals(Integer.valueOf(i), stack.dequeue());
        }
    }
    
    @Test
    public void testEquals() {
    	var stack2 = new ArrayQueue<>();
    	
    	for( int k = 0; k < 200; k++ ) {
    		assertEquals( stack, stack2 );
    		stack.enqueue( k );
    		stack2.enqueue( k );
    	}
    	
    	while (!stack.isEmpty()) {
    		assertEquals( stack, stack2 );
    		stack.dequeue();
    		stack2.dequeue();	
    	}
    	
		assertEquals( stack, stack2 );    	
    }
}