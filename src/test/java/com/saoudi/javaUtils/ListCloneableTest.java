package com.saoudi.javaUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 *
 */
public class ListCloneableTest {

    private ListCloneable<Point> list;

    @BeforeEach
    void setUp() {
        list = new ListCloneable<>();
    }

    @Test
    void testGetFirst() {
        list.append(new Point(1));
        list.append(new Point(2));
        list.append(new Point(3));

        Point first = list.getFirst();
        assertEquals(1, first.getX());
    }

    @Test
    void testSetFirst() {
        list.append(new Point(1));
        list.append(new Point(2));
        list.append(new Point(3));

        list.setFirst(new Point(10));

        Point first = list.getFirst();
        assertEquals(10, first.getX());
    }

    @Test
    void testGetLast() {
        list.append(new Point(1));
        list.append(new Point(2));
        list.append(new Point(3));

        Point last = list.getLast();
        assertEquals(3, last.getY());
    }

    @Test
    void testSetLast() {
        list.append(new Point(1,2));
        list.append(new Point(2,0));
        list.append(new Point(3,45));

        list.setLast(new Point(7,8));

        Point last = list.getLast();
        assertEquals(7, last.getX());
        assertEquals(8, last.getY());
    }

    @Test
    void testPush() {
        list.push(new Point(1,2));
        list.push(new Point(2,0));
        list.push(new Point(3,45));

        Point first = list.getFirst();
        assertEquals(3, first.getX());
    }

    @Test
    public void testEmptyConstructor() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.length);
    }

    @Test
    public void testValueConstructor() {
        Point p = new Point(4,12);
        ListCloneable<Point> list = new ListCloneable<>(p);
        assertFalse(list.isEmpty());
        assertEquals(1, list.length);
        assertEquals(p, list.get(0));
    }

    @Test
    public void testArrayConstructor() {
        Point[] array = {new Point(1), new Point(2), new Point(3), new Point(4), new Point(5)};
        ListCloneable<Point> list = new ListCloneable<>(array);
        assertFalse(list.isEmpty());
        assertEquals(array.length, list.length);
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], list.get(i));
        }
    }

    @Test
    public void testPushElement() {
        list.push(new Point(4));
        assertEquals(1,list.length);
        assertEquals(4,list.get(0).getX());
        Point[] array = {new Point(1), new Point(2), new Point(3), new Point(4), new Point(5)};
        ListCloneable<Point> list = new ListCloneable<>(array);
        list.push(new Point(6));
        list.push(new Point(7));
        list.push(new Point(8));
        assertEquals(8,list.length);
        assertEquals(6,list.get(2).getX());
        assertEquals(8,list.get(0).getY());
        assertEquals(5,list.get(7).getX());
    }

    @Test
    public void testAppendElement() {
        list.append(new Point(4));
        assertEquals(1,list.length);
        assertEquals(4,list.get(0).getX());
        Point[] array = {new Point(1), new Point(2), new Point(3), new Point(4), new Point(5)};
        ListCloneable<Point> list = new ListCloneable<>(array);
        list.append(new Point(6));
        list.append(new Point(7));
        list.append(new Point(8));
        assertEquals(8,list.length);
        assertEquals(3,list.get(2).getX());
        assertEquals(1,list.get(0).getX());
        assertEquals(8,list.get(7).getX());
    }

    @Test
    public void testInsertElement(){
        assertThrows(IllegalArgumentException.class, () ->list.insert(4,new Point(7)));
        list.insert(0,new Point(1));
        assertEquals(1,list.get(0).getY());
        list.insert(0,new Point(2));
        assertEquals(2,list.get(0).getX());
        list.insert(1,new Point(3));
        assertEquals(3,list.get(1).getY());
        list.insert(0,new Point(4));
        assertEquals(4,list.get(0).getX());
        list.insert(list.length,new Point(11));
        assertEquals(11,list.get(list.length-1).getX());
        assertEquals(5,list.length);
    }

    @Test
    public void testRemove() {
        list.append(new Point(1));
        list.append(new Point(2));
        list.append(new Point(3));

        // Remove element at index 1
        list.remove(1);
        assertEquals(2, list.length);
        assertEquals(1, list.get(0).getX());
        assertEquals(3, list.get(1).getY());

        // Remove element at index 0
        list.remove(0);
        assertEquals(1, list.length);
        assertEquals(3, list.get(0).getY());

        // Remove non-existent element
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    void testClear() {
        list.append(new Point(1));
        list.append(new Point(2));
        list.append(new Point(3));

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

        list.append(new Point(2,1));
        list.append(new Point(2));
        list.append(new Point(3,8));
        list.append(new Point(4));
        list.append(new Point(11,5));

        // Test avec filtre qui retourne vrai pour les Points carre (x==y)
        Filtre<Point> squarFilter = e-> e.getX() == e.getY();
        Point result = list.find(squarFilter);
        assertEquals(2, result.getX());

        // Test avec filtre Point.x supérieur a Point.y
        Filtre<Point> xgyFilter =x->x.getX() > x.getY()*2;
        result = list.find(xgyFilter);
        assertEquals(new Point(11,5), result);

        // Test avec filtre Point.x + Point.y >10
        Filtre<Point> xAndyGtenFilter = e-> e.getX() + e.getY() > 10;
        result = list.find(xAndyGtenFilter);
        assertEquals(new Point(3,8), result);

        // Test avec Filtre qui retourne les points > 15
        // Aucun résultat ne satisfait la condition du filtre
        result = list.find(e->e.getX()>15);
        assertNull(result);
    }

    // test iterable

    @Test
    public void testIterable(){
        Point[] array = {new Point(1), new Point(2), new Point(3), new Point(4), new Point(5)};
        ListCloneable<Point> list = new ListCloneable<>(array);
        int i = 0;
        for (Point element:list) {
            assertEquals(element,array[i]);
            assertNotSame(element,array[i]);
            i++;
        }
    }



    @Test
    void testFindAll() {

        list.append(new Point(2,1));
        list.append(new Point(2));
        list.append(new Point(3,8));
        list.append(new Point(4));
        list.append(new Point(11,5));
        list.append(new Point(9,4));

        // Test avec filtre qui retourne vrai pour les Points carre (x==y)
        Filtre<Point> squarFilter = e-> e.getX() == e.getY();

        ListCloneable<Point> result = list.findAll(squarFilter);
        assertEquals(new Point(2), result.get(0));
        assertEquals(new Point(4), result.get(1));

        // Test avec filtre Point.x supérieur à Point.y
        Filtre<Point> xgyFilter =x->x.getX() > x.getY()*2;
        result = list.findAll(xgyFilter);
        assertEquals(new Point(11,5), result.get(0));
        assertEquals(new Point(9,4), result.get(1));


        // Test avec filtre Point.x + Point.y >10
        Filtre<Point> xAndyGtenFilter = e-> e.getX() + e.getY() > 10;
        result = list.findAll(xAndyGtenFilter);
        assertEquals(new Point(3,8), result.get(0));
        assertEquals(new Point(11,5), result.get(1));
        assertEquals(new Point(9,4), result.get(2));

        // Test avec Filtre qui retourne les points > 15
        // Aucun résultat ne satisfait la condition du filtre
        result = list.findAll(e->e.getX()>15);
        assertEquals(0, result.length);
    }
}