package com.binarytree.BinaryTree;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 4/12/13
 * Time: 5:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Node {
   private Integer value;
   private Node left;
   private Node right;

   public Node(int aValue){
        this.value = aValue;
   }

   public int getMaxLeafDepth(){
       int depth = 1;

       if (isLeaf()) {
           // do nothing
       } else if (left == null) {
           depth += right.getMaxLeafDepth();
       } else if (right == null) {
           depth += left.getMaxLeafDepth();
       } else {
           depth += Math.max(left.getMaxLeafDepth(), right.getMaxLeafDepth());
       }

       return depth;
   }

   public void addValue (Integer aValue){
       if (aValue < value) {
           if (left == null) {
               left = new Node(aValue);
           } else {
               left.addValue(aValue);
           }
       } else if (aValue > value) {
           if (right == null) {
               right = new Node(aValue);
           } else {
               right.addValue(aValue);
           }
       }
   }

    public Integer getValue (){
        return this.value;
    }

    public Node getObjectLink(){
        return this;
    }

    public Node getObjectLinkLeft(){
        return this.left;
    }

    public Node getObjectLinkRight(){
        return this.left;
    }


   public boolean isLeaf(){
       return (left == null && right == null);
   }

   public boolean isLeftValueEmpty(){
       return this.left != null;
   }

    public boolean isRightValueEmpty(){
        return this.right != null;
    }

    public String toString(){
        return String.format("(%s, %s, %s)", value, left, right);
    }


}
