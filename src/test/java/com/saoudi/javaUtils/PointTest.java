package com.saoudi.javaUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class PointTest {
    @Test
    void testToString() {
        Point point = new Point(3, 4);
        String expected = "Point : {x:3, y:4}";
        assertEquals(expected, point.toString());
    }

    @Test
    void testEquals() {
        Point point1 = new Point(3, 4);
        Point point2 = new Point(3, 4);
        Point point3 = new Point(5, 6);

        assertEquals(point1, point2);
        assertNotEquals(point1, point3);
    }

    @Test
    void testClone() {
        try {
            Point point = new Point(3, 4);
            Point clonedPoint = (Point) point.clone();

            assertEquals(point, clonedPoint);
            assertNotSame(point, clonedPoint);
        } catch (CloneNotSupportedException e) {
            fail("Cloning failed");
        }
    }

    @Test
    void testHashCode() {
        Point point1 = new Point(3, 4);
        Point point2 = new Point(3, 4);
        Point point3 = new Point(5, 6);

        assertEquals(point1.hashCode(), point2.hashCode());
        assertNotEquals(point1.hashCode(), point3.hashCode());
    }

    @Test
    void testGettersAndSetters() {
        Point point = new Point(3, 4);

        assertEquals(3, point.getX());
        assertEquals(4, point.getY());

        point.setX(5);
        point.setY(6);

        assertEquals(5, point.getX());
        assertEquals(6, point.getY());
    }
}
