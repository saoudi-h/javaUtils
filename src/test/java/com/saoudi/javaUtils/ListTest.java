
package com.saoudi.javaUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class ListTest {

    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = new List<>();
    }

    @Test
    void testGetFirst() {
        list.append(1);
        list.append(2);
        list.append(3);

        Integer first = list.getFirst();
        assertEquals(1, first);
    }

    @Test
    void testSetFirst() {
        list.append(1);
        list.append(2);
        list.append(3);

        list.setFirst(10);

        Integer first = list.getFirst();
        assertEquals(10, first);
    }

    @Test
    void testGetLast() {
        list.append(1);
        list.append(2);
        list.append(3);

        Integer last = list.getLast();
        assertEquals(3, last);
    }

    @Test
    void testSetLast() {
        list.append(1);
        list.append(2);
        list.append(3);

        list.setLast(10);

        Integer last = list.getLast();
        assertEquals(10, last);
    }

    @Test
    void testPush() {
        list.push(1);
        list.push(2);
        list.push(3);

        Integer first = list.getFirst();
        assertEquals(3, first);
    }

    @Test
    public void testEmptyConstructor() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.length);
    }

    @Test
    public void testValueConstructor() {
        List<Integer> list = new List<>(5);
        assertFalse(list.isEmpty());
        assertEquals(1, list.length);
        assertEquals(5, list.get(0));
    }

    @Test
    public void testArrayConstructor() {
        Integer[] array = {1, 2, 3, 4, 5};
        List<Integer> list = new List<>(array);
        assertFalse(list.isEmpty());
        assertEquals(array.length, list.length);
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], list.get(i));
        }
    }

    @Test
    public void testPushElement() {
        list.push(4);
        assertEquals(1,list.length);
        assertEquals(4,list.get(0));
        Integer[] array = {1, 2, 3, 4, 5};
        List<Integer> list = new List<>(array);
        list.push(6);
        list.push(7);
        list.push(8);
        assertEquals(8,list.length);
        assertEquals(6,list.get(2));
        assertEquals(8,list.get(0));
        assertEquals(5,list.get(7));
    }

    @Test
    public void testAppendElement() {
        list.append(4);
        assertEquals(1,list.length);
        assertEquals(4,list.get(0));
        Integer[] array = {1, 2, 3, 4, 5};
        List<Integer> list = new List<>(array);
        list.append(6);
        list.append(7);
        list.append(8);
        assertEquals(8,list.length);
        assertEquals(3,list.get(2));
        assertEquals(1,list.get(0));
        assertEquals(8,list.get(7));
    }

    @Test
    public void testInsertElement(){
        assertThrows(IllegalArgumentException.class, () ->list.insert(4,7));
        list.insert(0,1);
        assertEquals(1,list.get(0));
        list.insert(0,2);
        assertEquals(2,list.get(0));
        list.insert(1,3);
        assertEquals(3,list.get(1));
        list.insert(0,4);
        assertEquals(4,list.get(0));
        list.insert(list.length,11);
        assertEquals(11,list.get(list.length-1));
        assertEquals(5,list.length);
    }

    @Test
    public void testRemove() {
        list.append(1);
        list.append(2);
        list.append(3);

        // Remove element at index 1
        list.remove(1);
        assertEquals(2, list.length);
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));

        // Remove element at index 0
        list.remove(0);
        assertEquals(1, list.length);
        assertEquals(3, list.get(0));

        // Remove non-existent element
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    void testClear() {
        list.append(1);
        list.append(2);
        list.append(3);

        assertFalse(list.isEmpty());
        assertEquals(3, list.length);

        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.length);
        assertNull(list.getFirst());
        assertNull(list.getLast());
    }

    @Test
    public void testFind() {
        // Test avec filtre qui retourne vrai pour les nombres pairs
        Filtre<Integer> evenFilter = new Filtre<Integer>() {
            @Override
            public boolean apply(Integer element) {
                return element % 2 == 0;
            }
        };

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        Integer result = list.find(evenFilter);
        assertEquals(2, result);

        // Test avec filtre qui retourne le premiere entier impaire
        Filtre<Integer> oddFilter = new Filtre<Integer>() {
            @Override
            public boolean apply(Integer element) {
                return element % 2 != 0;
            }
        };

        result = list.find(oddFilter);
        assertEquals(1, result);

        // Test avec filtre qui retourne le première element divisible par 3
        Filtre<Integer> divisibleByThreeFilter = e-> e % 3 == 0;


        result = list.find(divisibleByThreeFilter);
        assertEquals(3, result);

        // Test avec Filtre qui retourne le premier nombre >10

        // Aucun resultat ne satisfait la condition du filtre
        result = list.find(e->e>10);
        assertNull(result);
    }

    // test iterable

    @Test
    public void testIterable(){
        Integer[] array = {1, 2, 3, 4, 5};
        List<Integer> list = new List<>(array);
        int i = 0;
        for (Integer element:list) {
            assertEquals(element,array[i]);
            i++;
        }
    }



    @Test
    void testFindAll() {
        // Test avec filtre qui retourne vrai pour les nombres pairs
        Filtre<Integer> evenFilter = new Filtre<Integer>() {
            @Override
            public boolean apply(Integer element) {
                return element % 2 == 0;
            }
        };

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);

        List<Integer> result = list.findAll(evenFilter);
        assertEquals(2, result.get(0));
        assertEquals(4, result.get(1));

        // Test avec filtre qui retourne les nombres impaires
        Filtre<Integer> oddFilter = new Filtre<Integer>() {
            @Override
            public boolean apply(Integer element) {
                return element % 2 != 0;
            }
        };

        result = list.findAll(oddFilter);
        assertEquals(1, result.get(0));
        assertEquals(3, result.get(1));
        assertEquals(5, result.get(2));

        // Test avec filtre qui retourne le premier element divisible par 3.
        Filtre<Integer> divisibleByThreeFilter = e-> e % 3 == 0;


        result = list.findAll(divisibleByThreeFilter);
        assertEquals(3, result.get(0));
        assertEquals(6, result.get(1));

        // Test avec Filtre qui retourne le premier nombre >10

        // Aucun résultat ne satisfait la condition du filtre
        result = list.findAll(e->e>10);
        assertEquals(0,result.length);
    }


    @Test
    public void testToArrayList() {
        Integer[] array = {1, 2, 3, 4, 5};
        list = new List<>(array);
        ArrayList<Integer> arrayList = list.toArrayList();
        assertEquals(list.length, arrayList.size());
        assertTrue(arrayList.contains(1));
        assertTrue(arrayList.contains(2));
        assertTrue(arrayList.contains(3));
        assertTrue(arrayList.contains(4));
        assertTrue(arrayList.contains(5));
    }

    @Test
    public void testToArray() {
        Point[] array = {new Point(1), new Point(2), new Point(3), new Point(4), new Point(5)};
        List<Point> list2 = new List<>(array);
        Object[] tab = list2.toArray();
        assertEquals(list2.length, tab.length);
        assertEquals(tab[0],array[0]);
        assertEquals(tab[1],array[1]);
        assertEquals(tab[2],array[2]);
        assertEquals(tab[3],array[3]);
        assertEquals(tab[4],array[4]);


        assertSame(tab[0],array[0]);
        assertSame(tab[1],array[1]);
        assertSame(tab[2],array[2]);
        assertSame(tab[3],array[3]);
        assertSame(tab[4],array[4]);
    }

//    @Test
//    public void testToArrayTest() {
//        Point[] array = {new Point(1), new Point(2), new Point(3), new Point(4), new Point(5)};
//        List<Point> list2 = new List<>(array);
//        Point[] tab = list2.toArrayTest();
//        assertEquals(list2.length, tab.length);
//        assertEquals(tab[0],array[0]);
//        assertEquals(tab[1],array[1]);
//        assertEquals(tab[2],array[2]);
//        assertEquals(tab[3],array[3]);
//        assertEquals(tab[4],array[4]);
//
//
//        assertSame(tab[0],array[0]);
//        assertSame(tab[1],array[1]);
//        assertSame(tab[2],array[2]);
//        assertSame(tab[3],array[3]);
//        assertSame(tab[4],array[4]);
//    }

}