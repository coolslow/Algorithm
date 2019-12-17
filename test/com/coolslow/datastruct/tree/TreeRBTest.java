package com.coolslow.datastruct.tree;

import com.coolslow.datastruct.utils.MyData;
import com.coolslow.datastruct.utils.MyUtils;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 红黑树 测试类
 * <p>
 * by MrThanksgiving
 */
public class TreeRBTest {

    @Test
    public void test1() {
        RBTree<Integer> tree = new RBTree<>();
        Integer[] data = new Integer[]{100, 50, 25, 75, 12, 30, 60, 80};
        tree.addAll(data);
        tree.rotateLeft(tree.find(50, false));
        String msg = getRBTreeInfo(tree);
        MyUtils.println(msg);
    }

    @Test
    public void test2() {
        RBTree<Integer> tree = new RBTree<>();
        Integer[] data = new Integer[]{100, 50, 25, 75, 12, 30, 60, 80};
        tree.addAll(data);
        tree.rotateRight(tree.find(50, false));
        String msg = getRBTreeInfo(tree);
        MyUtils.println(msg);
    }

    @Test
    public void test3() {
        RBTree<Integer> tree = new RBTree<>();
        Integer[] data = new Integer[]{100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 9, 8};
        tree.addAll(data);
        String msg = getRBTreeInfo(tree);
        MyUtils.println(msg);
    }

    // base remove
    @Test
    public void test4() {
        RBTree<Integer> tree = new RBTree<>();
        Integer[] data = new Integer[]{100, 150, 50, 25, 75, 37, 40, 39};
        tree.addAll(data);
        String msg = getRBTreeInfo(tree);
        MyUtils.println(msg);
        MyUtils.printMarkLine("remove 50");
        tree.remove(50);
        msg = getRBTreeInfo(tree);
        MyUtils.println(msg);
    }

    // rb remove
    @Test
    public void test5() {
        RBTree<Integer> tree = new RBTree<>();
        Integer[] data = new Integer[]{100, 150, 50, 25, 75, 37, 40, 39};
        tree.addAll(data);
        String msg = getRBTreeInfo(tree);
        MyUtils.println(msg);
        MyUtils.printMarkLine("remove 50");
        tree.remove(50);
        msg = getRBTreeInfo(tree);
        MyUtils.println(msg);
    }

    // rb remove
    @Test
    public void test6() {
        RBTree<Integer> tree = new RBTree<>();
        Integer[] data = new Integer[]{100, 150, 50, 25, 75, 37, 40, 39};
        tree.addAll(data);
        String msg = getRBTreeInfo(tree);
        MyUtils.println(msg);
        int remove = 100;
        MyUtils.printMarkLine("remove " + remove);
        tree.remove(remove);
        msg = getRBTreeInfo(tree);
        MyUtils.println(msg);
    }


    // rb random
    @Test
    public void test7() {

//        Integer[] data = new Integer[]{100, 150, 50, 25, 75, 37, 40, 39};
        Integer[] data = MyData.generateRandomDataNoRepeat(20);
        MyData.verifyDataNoRepeat(data);

        MyUtils.startTime();
        RBTree<Integer> tree = new RBTree<>();
        tree.addAll(data);
        MyUtils.endTime("创建" + tree.size() + "个节点，耗时");
        String msg = verifyInfo(tree);
        MyUtils.println(msg);
        MyUtils.endTime("验证创建是否正确，耗时");

        int remove = 524288;
        tree.remove(remove);
        MyUtils.endTime("删除节点" + remove + "，耗时");


    }


    private <T extends Comparable<T>> String getRBTreeInfo(RBTree<T> tree) {
        StringBuilder stringBuilder = new StringBuilder();
        tree.iteratorPost(source -> {
            stringBuilder.append("data=").append(source.data).append("    color=").append(source.color ? "BLACK" : "RED").append("    ");

            if (source.parent != null) {
                stringBuilder.append("parent = ").append(source.parent.data).append("    color=").append(source.parent.color ? "BLACK" : "RED").append("   ");
            } else {
                stringBuilder.append("parent = null   ");
            }
            if (source.left != null) {
                stringBuilder.append("leftchild = ").append(source.left.data).append("    color=").append(source.left.color ? "BLACK" : "RED").append("   ");
            } else {
                stringBuilder.append("leftchild = null   ");
            }
            if (source.right != null) {
                stringBuilder.append("rightchild = ").append(source.right.data).append("    color=").append(source.right.color ? "BLACK" : "RED").append("   ");
            } else {
                stringBuilder.append("rightchild = null   ");
            }

            int leftHeight = tree.getTreeHeight(source.left);
            int rightHeight = tree.getTreeHeight(source.right);
            double heightFactor = (Math.max(leftHeight, rightHeight) + 1) * 1.0 / (Math.min(leftHeight, rightHeight) + 1);
            stringBuilder.append("leftHeight=").append(leftHeight + 1).append("    rightHeight=").append(rightHeight + 1).append("    heightFactor=").append(heightFactor).append("    ");
            stringBuilder.append("\n                ");
            Map<String, Integer> map = tree.getBlackCount(source);

            map.forEach((key, value) -> stringBuilder.append("child=").append(key).append("    blackcount=").append(value).append("    "));
            stringBuilder.append("\n");

        });
        return stringBuilder.toString();
    }

    private <T extends Comparable<T>> String verifyInfo(RBTree<T> tree) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = tree.size();
        AtomicInteger progress = new AtomicInteger();
        tree.iteratorPost(source -> {

            int leftHeight = tree.getTreeHeight(source.left);
            int rightHeight = tree.getTreeHeight(source.right);
            double heightFactor = (Math.max(leftHeight, rightHeight) + 1) * 1.0 / (Math.min(leftHeight, rightHeight) + 1);
            if (heightFactor > 2) {
                stringBuilder.append(source.data).append("   heightFactor=").append(heightFactor);
            }
            Map<String, Integer> map = tree.getBlackCount(source);
            int defaultValue = 0;
            int i = 0;
            boolean isFirstRecorder = true;
            for (Map.Entry<String, Integer> m : map.entrySet()) {
                if (i == 0) {
                    defaultValue = m.getValue();
                }
                if (defaultValue != m.getValue()) {
                    if (isFirstRecorder) {
                        stringBuilder.append(source.data).append("   defaultValue=").append(defaultValue);
                        isFirstRecorder = false;
                    }
                    stringBuilder.append("   child=").append(m.getKey()).append("    blackCount=").append(m.getValue());
                }
                i++;
            }

            progress.getAndIncrement();
            int curr = progress.get();
            if (curr % 10000 == 0) {
                MyUtils.println("curr=" + curr + "  total=" + size);
            } else {
                if (curr == size) {
                    MyUtils.println("curr=" + curr + "  total=" + size);
                }
            }

            if (curr == size) {
                stringBuilder.append("verify finish");
            }
        });

        return stringBuilder.toString();
    }


}
