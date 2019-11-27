import com.coolslow.datastruct.MySingleLinkedList;
import com.coolslow.datastruct.tree.BinaryTree;
import com.coolslow.utils.MyData;
import com.coolslow.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

public class TreeTest {


    public static void test1() {


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
        iteratorPre(tree);
        MyUtils.printLine();
        recursivePre(tree);

        MyUtils.printMarkLine("in order iterator");
        iteratorIn(tree);
        MyUtils.printLine();
        recursiveIn(tree);

        MyUtils.printMarkLine("post order iterator");
        iteratorPost(tree);
        MyUtils.printLine();
        recursivePost(tree);

    }


    public static void test2() {

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
        iteratorIn(tree);

        int remove = 50;
        MyUtils.printMarkLine("remove " + remove);
        tree.remove(remove);

        List<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i] != remove) {
                nodes.add(data[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodes.size(); i++) {
            int node = nodes.get(i);
            BinaryTree.Node temp = tree.find(node, false);
            if (temp != null) {
                if (temp.parent != null) {
                    sb.append(node + " parent = " + temp.parent.data + "       ");
                } else {
                    sb.append(node + " parent = null       ");
                }
                if (temp.left != null) {
                    sb.append(node + " leftchild = " + temp.left.data + "       ");
                } else {
                    sb.append(node + " leftchild = null       ");
                }
                if (temp.right != null) {
                    sb.append(node + " rightchild = " + temp.right.data + "       ");
                } else {
                    sb.append(node + " rightchild = null       ");
                }
                sb.append("\n");
            }
        }
        MyUtils.println(sb.toString());
        MyUtils.printMarkLine("in order iterator finish");
        iteratorIn(tree);

    }


    public static void test3() {

        Integer[] data = new Integer[]{//
                100, //
                50, //
                25, 75, 37, 43, 45, 44, 31, 12, 6, 18, //
        };
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.addAll(data);


        StringBuilder sb = new StringBuilder();
        sb.append("tree  count = " + tree.size() + "\n");
        sb.append("tree leaf count = " + tree.getTreeLeafCount() + "\n");
        sb.append("tree node count = " + tree.getTreeNodeCount() + "\n");
        sb.append("tree height  = " + tree.getTreeHeight() + "\n");
        MyUtils.println(sb.toString());

        MyUtils.printMarkLine("in order iterator finish");
        iteratorIn(tree);

    }

    public static void iteratorPre(BinaryTree tree) {
        tree.iteratorPre(data -> {
            MyUtils.print(data + ", ");
        });
    }

    public static void iteratorIn(BinaryTree tree) {
        tree.iteratorIn(data -> {
            MyUtils.print(data + ", ");
        });
    }

    public static void iteratorPost(BinaryTree tree) {
        tree.iteratorPost(data -> {
            MyUtils.print(data + ", ");
        });
    }

    public static void recursivePre(BinaryTree tree) {
        tree.recursivePre(data -> {
            MyUtils.print(data + ", ");
        });
    }

    public static void recursiveIn(BinaryTree tree) {
        tree.recursiveIn(data -> {
            MyUtils.print(data + ", ");
        });
    }

    public static void recursivePost(BinaryTree tree) {
        tree.recursivePost(data -> {
            MyUtils.print(data + ", ");
        });
    }

    public static void iteratorBfs(BinaryTree tree) {
        tree.iteratorBfs(data -> {
            MyUtils.print(data + ", ");
        });
    }


}
