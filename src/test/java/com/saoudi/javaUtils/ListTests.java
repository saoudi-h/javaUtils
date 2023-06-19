
package com.saoudi.javaUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

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
    public void testGetFirstFilter() {
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

        Integer result = list.getFirst(evenFilter);
        assertEquals(2, result);

        // Test avec filtre qui retourne le premiere entier divisible par 2
        Filtre<Integer> oddFilter = new Filtre<Integer>() {
            @Override
            public boolean apply(Integer element) {
                return element % 2 != 0;
            }
        };

        result = list.getFirst(oddFilter);
        assertEquals(1, result);

        // Test avec filtre qui retourne le première element divisible par 3
        Filtre<Integer> divisibleByThreeFilter = e-> e % 3 == 0;


        result = list.getFirst(divisibleByThreeFilter);
        assertEquals(3, result);

        // Test avec Filtre qui retourne le premier nombre >10

        // Aucun resultat ne satisfait la condition du filtre
        result = list.getFirst(e->e>10);
        assertNull(result);
    }
}