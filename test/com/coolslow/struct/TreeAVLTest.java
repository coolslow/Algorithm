package com.coolslow.struct;

import com.coolslow.datastruct.tree.AVLTree;
import com.coolslow.utils.MyUtils;
import org.junit.Test;

/**
 * AVL 测试类
 * <p>
 * by MrThanksgiving
 */
public class TreeAVLTest {


    /**
     * avl tree test
     * ll rotate
     */
    @Test
    public void test1() {
        Integer[] data = new Integer[]{//
                100,
                50,
                25, //
        };
        baseRotateTest(data);
    }

    /**
     * avl tree test
     * rr rotate
     */
    @Test
    public void test2() {
        Integer[] data = new Integer[]{//
                25,
                50,
                100, //
        };
        baseRotateTest(data);
    }

    /**
     * avl tree test
     * lr rotate
     */
    @Test
    public void test3() {
        Integer[] data = new Integer[]{//
                100,
                50,
                75, //
        };
        baseRotateTest(data);
    }

    /**
     * avl tree test
     * rl rotate
     */
    @Test
    public void test4() {
        Integer[] data = new Integer[]{//
                50,
                100,
                75, //
        };
        baseRotateTest(data);
    }

    /**
     * avl tree test
     */
    @Test
    public void test5() {
        Integer[] data = new Integer[]{//
                100,
                50,
                150,
                25,
                175,
                12,
                60,
                70,
                80,
                85,
                90,
                91,
                92, 93, 94, 95, 96, 97, 98
                //
        };
        baseRotateTest(data);
    }

    @Test
    public void test6() {
        int count = 100;
        Integer[] data = new Integer[count];
        for (int i = 0; i < count; i++) {
            data[i] = i;
        }
        baseRotateTest(data);
    }

    private void baseRotateTest(Integer[] data) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.addAll(data);
        MyUtils.println(getMessage(avlTree));
    }

    private String getMessage(AVLTree<Integer> avlTree) {
        StringBuilder sb = new StringBuilder();
        avlTree.testIteratorPost((AVLTree.Node<Integer> source) -> {
            if (source.parent != null) {
                sb.append("data = ").append(source.data).append("       parent = ").append(source.parent.data).append("       ");
            } else {
                sb.append("data = ").append(source.data).append("       parent = null       ");
            }
            if (source.left != null) {
                sb.append(" leftchild = ").append(source.left.data).append("       ");
            } else {
                sb.append(" leftchild = null       ");
            }
            if (source.right != null) {
                sb.append(" rightchild = ").append(source.right.data).append("       ");
            } else {
                sb.append(" rightchild = null       ");
            }
            sb.append("balanceFactor=").append(avlTree.getTreeHeight(source.left) - avlTree.getTreeHeight(source.right)).append("  \n");
        });
        return sb.toString();
    }

    /**
     * remove
     */
    @Test
    public void test7() {
        Integer[] data = new Integer[]{//
                100,
                50,
                75,
                150,
                80,
                25,
                90,
                91,
        };

        int remove = 25;
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.addAll(data);
        MyUtils.println(getMessage(avlTree));

        MyUtils.printMarkLine("remove " + remove);
        avlTree.remove(remove);

        MyUtils.println(getMessage(avlTree));
    }


}
