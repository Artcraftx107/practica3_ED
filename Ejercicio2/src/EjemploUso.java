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


import conjunto.LinkedListSet;
import conjunto.Set;

public final class EjemploUso {
	private static void probar( Set<Integer> set1, Set<Integer> set2 ) {
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        var unionSet = set1.union(set2);
        var intersectionSet = set1.intersection(set2);
        var differenceSet = set1.difference(set2);
        boolean isSubset = set1.isSubset(set2);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Unión: " + unionSet);
        System.out.println("Intersección: " + intersectionSet);
        System.out.println("Diferencia: " + differenceSet);
        System.out.println("Set 1 es subconjunto de Set 2: " + isSubset);	
	}
	
	
    public static void main(String[] args) {           
    	   var set1 = new LinkedListSet<Integer>();
          var set2 = new LinkedListSet<Integer>();
 
           System.out.println();
           
           System.out.println( "Conjunto con listas" );
           probar( set1, set2 );
    }
}
