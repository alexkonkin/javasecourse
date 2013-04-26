package com.binarytree;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 4/15/13
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */

import com.binarytree.BinaryTree.Node;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class NodeTest {
    @Test
        public void testAddRootNode()throws Exception{
            Node aNode = new Node(10);
            assertEquals(10, (int) aNode.getValue());
            assertNull(aNode.getObjectLinkLeft());
            assertNull(aNode.getObjectLinkRight());
    }

    @Test
        public void testAddItemToTheEmptyNode()throws Exception{
            Node aNode = new Node(10);
            assertEquals(10, (int) aNode.getValue());
            assertNull(aNode.getObjectLinkLeft());
            aNode.addValue(9);
            assertNotNull(aNode.getObjectLinkLeft());
    }

    @Test
        public void testAddItemToTheNonEmptyNode()throws Exception{
            Node aNode = new Node(10);
            assertEquals(10, (int) aNode.getValue());
            assertNull(aNode.getObjectLinkLeft());
            aNode.addValue(9);
            assertNotNull(aNode.getObjectLinkLeft());
            aNode.addValue(11);
            assertNotNull(aNode.getObjectLinkRight());
    }

    @Test
    public void testAddItemToTheChildNode()throws Exception{
            Node aNode = new Node(10);
            assertEquals(10, (int) aNode.getValue());
            assertNull(aNode.getObjectLinkLeft());
            aNode.addValue(9);
            assertNotNull(aNode.getObjectLinkLeft());
            aNode.addValue(11);
            assertNotNull(aNode.getObjectLinkRight());
            aNode.addValue(8);

            System.out.println(aNode.toString());

            Node aNodeLeftChild = aNode.getObjectLinkLeft();
            Node aChildOfLeftNode = aNodeLeftChild.getObjectLinkLeft();
            assertEquals(10, (int) aNode.getValue());
            assertEquals(11, (int) aNode.getObjectLinkRight().getValue());
            assertEquals(9, (int) aNode.getObjectLinkLeft().getValue());
            assertEquals(8, (int)aChildOfLeftNode.getValue());
    }

    @Test
        public void testCheckTheDepthOfTheTree()throws Exception{
            Node aNode = new Node(10);
            aNode.addValue(1);
            aNode.addValue(11);
            assertEquals(2,aNode.getMaxLeafDepth());
    }

    @Test
    public void testPrintContentsOfTheBinaryTree()throws Exception{
            Node aNode = new Node(10);
            aNode.addValue(1);
            aNode.addValue(11);
            assertEquals("(10, (1, null, null), (11, null, null))",aNode.toString());
    }
}
