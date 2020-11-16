package impl;

import i.INode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MyStructureTest {

    private MyStructure myStructure;

    @BeforeEach
    void beforeEachMethod() {
        myStructure = new MyStructure();
        INode node1 = new MyNode("1", "a");
        INode node2 = new MyNode("2", "b");
        INode node3 = new MyNode("3", "c");
        INode node4 = new MyNode("4", "d");

        MyCompositeNode compositeNode1 = new MyCompositeNode("5", "e");
        MyCompositeNode compositeNode2 = new MyCompositeNode("6", "f");

        compositeNode1.addNode(node1);
        compositeNode1.addNode(node2);
        compositeNode2.addNode(node3);

        myStructure.addNode(node4);
        myStructure.addNode(compositeNode1);
        myStructure.addNode(compositeNode2);
    }

    @Test
    void shouldReturnProperNodeCountTest() {
        int actualnNodeCount = myStructure.count();
        int expectedNodeCount = 6;

        assertEquals(expectedNodeCount, actualnNodeCount);
    }

    @Test
    void findByCodeShouldReturnNullTest() {
        INode actual = myStructure.findByCode("z");
        assertNull(actual);
    }

    @ParameterizedTest
    @CsvSource({"1,a", "2,b", "3,c", "4,d", "5,e", "6,f"})
    void findByCodeShouldReturnSameNodeAsFindByRenderer(String code, String renderer) {
        INode actual = myStructure.findByCode(code);
        INode expected = myStructure.findByRenderer(renderer);
        assertEquals(expected, actual);
    }
}