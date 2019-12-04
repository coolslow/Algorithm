package com.coolslow.struct;

import com.coolslow.datastruct.tree.BinaryTree;
import com.coolslow.utils.MyUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TreeBinaryTest {

    @Test
    public void test1() {


        BinaryTree<String> tree = new BinaryTree<>();
        tree.add("H");
        tree.add("D");
        tree.add("B");
        tree.add("A");
        tree.add("C");
        tree.add("F");
        tree.add("G");
        tree.add("L");
        tree.add("N");
        tree.add("J");
        tree.add("K");
        tree.add("M");

        MyUtils.printMarkLine("pre order iterator");
        tree.iteratorPre(data -> MyUtils.print(data + ", "));


        MyUtils.printLine();
        tree.recursivePre(data -> MyUtils.print(data + ", "));

        MyUtils.printMarkLine("in order iterator");
        tree.iteratorIn(data -> MyUtils.print(data + ", "));
        MyUtils.printLine();
        tree.recursiveIn(data -> MyUtils.print(data + ", "));

        MyUtils.printMarkLine("post order iterator");
        tree.iteratorPost(data -> MyUtils.print(data + ", "));
        MyUtils.printLine();
        tree.recursivePost(data -> MyUtils.print(data + ", "));

    }

    @Test
    public void test2() {

//        BinaryTree<Integer> tree = new BinaryTree<>();
//        iteratorIn(tree);
//        BinaryTree<String> tree = new BinaryTree<>();
//        tree.add("H");
//        tree.add("D");
//        tree.add("B");
//        tree.add("A");
//        tree.add("C");
//        tree.add("F");
//        tree.add("G");
//        tree.add("L");
//        tree.add("N");
//        tree.add("J");
//        tree.add("K");
//        tree.add("M");
//        tree.add("M");
//        MySingleLinkedList<Integer> testData = MyData.generateBinaryTree(10,false,false);
//        MyUtils.printMarkLine("array list order iterator");
//        for(int i=0;i<testData.size();i++){
//            MyUtils.print(testData.get(i) + ", ");
//        }
//        testData.iterator(data -> {
//            tree.add(data);
//        });
//        MyUtils.printMarkLine("pre order iterator");
//        iteratorPre(tree);
//        MyUtils.printLine();
//        recursivePre(tree);
//
//        MyUtils.printMarkLine("in order iterator");
//        iteratorIn(tree);
//        MyUtils.printLine();
//        recursiveIn(tree);
//
//        MyUtils.printMarkLine("post order iterator");
//        iteratorPost(tree);
//        MyUtils.printLine();
//        recursivePost(tree);
//        MyUtils.printMarkLine("bfs order iterator");
//        iteratorBfs(tree);
//        MyUtils.printLine();

//        Integer[] data = new Integer[]{//
//                100, //
//                50, 150, //
//                25, 75, 125, 175, //
//                12, 37, 62, 87, 112, 137, 162, 187, //
//                6, 18, 31, 28, 43,45, 56, 68, 81, 93, 106, 118, 131, 143, 156, 168, 181, 193
//        };
        Integer[] data = new Integer[]{//
                100, //
                50, //
                25, 75, 37, 43, 45, 44, 31, 12, 6, 18, //
        };
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.addAll(data);

        MyUtils.printMarkLine("in order iterator before");
        tree.iteratorIn(source -> MyUtils.print(source + ", "));

        int remove = 50;
        MyUtils.printMarkLine("remove " + remove);
        tree.remove(remove);

        List<Integer> nodes = new ArrayList<>();
        for (Integer datum : data) {
            if (datum != remove) {
                nodes.add(datum);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int node : nodes) {
            BinaryTree.Node temp = tree.find(node, false);
            if (temp != null) {
                if (temp.parent != null) {
                    sb.append(node).append(" parent = ").append(temp.parent.data).append("       ");
                } else {
                    sb.append(node).append(" parent = null       ");
                }
                if (temp.left != null) {
                    sb.append(node).append(" leftchild = ").append(temp.left.data).append("       ");
                } else {
                    sb.append(node).append(" leftchild = null       ");
                }
                if (temp.right != null) {
                    sb.append(node).append(" rightchild = ").append(temp.right.data).append("       ");
                } else {
                    sb.append(node).append(" rightchild = null       ");
                }
                sb.append("\n");
            }
        }
        MyUtils.println(sb.toString());
        MyUtils.printMarkLine("in order iterator finish");
        tree.iteratorIn(source -> MyUtils.print(source + ", "));

        Assert.assertTrue(true);

    }

    @Test
    public void test3() {

        Integer[] data = new Integer[]{//
                100, //
                50, //
                25, 75, 37, 43, 45, 44, 31, 12, 6, 18, //
        };
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.addAll(data);


        String msg = "tree  count = " + tree.size() + "\n" +
                "tree leaf count = " + tree.getTreeLeafCount() + "\n" +
                "tree node count = " + tree.getTreeNodeCount() + "\n" +
                "tree height  = " + tree.getTreeHeight() + "\n";
        MyUtils.println(msg);
        MyUtils.printMarkLine("in order iterator finish");
        tree.iteratorIn(source -> MyUtils.print(source + ", "));

        Assert.assertTrue(true);

    }

}
