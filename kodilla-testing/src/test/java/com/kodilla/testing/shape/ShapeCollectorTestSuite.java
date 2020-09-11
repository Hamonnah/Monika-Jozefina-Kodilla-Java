package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforAllTests() {
        System.out.println("This is the beginning of tests...");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("\n This is the end of tests.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("\n Preparing to execute test #" + testCounter);
    }

    @After
    public void afterEveryTest () {
        System.out.println("Test # " + testCounter + " is finished!");
    }

    @Test
    public void testAddFigure() {
        //given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle(10);
        Triangle triangle = new Triangle(5,3.2);
        //when
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(triangle);
        //then
        Assert.assertEquals(circle, shapeCollector.getFigure(0));
        Assert.assertEquals(triangle, shapeCollector.getFigure(1));
    }

    @Test
    public void testRemoveFigure() {
        //given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle(10);
        Triangle triangle = new Triangle(5, 3.2);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(triangle);
        //when
        shapeCollector.removeFigure(circle);
        //then
        Assert.assertEquals(triangle, shapeCollector.getFigure(0));
        Assert.assertNull(shapeCollector.getFigure(1));

    }

    @Test
    public void testGetFigure() {
        //given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle(10);
        Triangle triangle = new Triangle(5, 3.2);
        Square square = new Square(12);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(triangle);
        shapeCollector.addFigure(square);
        //then
        Assert.assertEquals(circle, shapeCollector.getFigure(0));
        Assert.assertEquals(triangle, shapeCollector.getFigure(1));
        Assert.assertEquals(square, shapeCollector.getFigure(2));
    }

    @Test
    public void testShowFigures() {
        //given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle(10);
        Triangle triangle = new Triangle(5, 3.2);
        Square square = new Square(12);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(triangle);
        shapeCollector.addFigure(square);
        //when
        shapeCollector.showFigures();
    }

}
