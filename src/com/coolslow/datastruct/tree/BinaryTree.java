package com.coolslow.datastruct.tree;

import com.coolslow.datastruct.MyQueue;
import com.coolslow.datastruct.MyStack;
import com.coolslow.utils.MyIterator;

import java.util.Stack;

/**
 * Tasks：
 *
 *
 * <p>
 * 树的创建 done
 * 树的创建 数组方式 done
 * 树节点添加 done
 * 树节点删除 done
 * 树遍历（递归）done
 * 树遍历（循环）done
 * 层次遍历（循环）done
 * 树的高度 done
 * 树的节点 done
 * 树的叶子节点 done
 * <p>
 * 树集合生产器 done
 *
 * <p>
 * 搜索二插树
 * 哈夫曼树
 * 平衡树AVL
 * 红黑树
 * b树
 * b+树
 * 堆树
 */
public class BinaryTree<T extends Comparable<T>> {

    private Node root;
    private int size;

    public BinaryTree() {
    }

    public void add(T data) {
        Node target = find(data, true);
        Node node = new Node(data, target, null, null);
        if (root == null) {
            root = node;
            size++;
            return;
        }
        if (target != null) {
            if (target.data != null && target.data.compareTo(data) > 0) {
                target.left = node;
            } else {
                target.right = node;
            }
            size++;
        }
    }

    public void addAll(T[] data) {
        if (data == null) {
            return;
        }
        for (int i = 0; i < data.length; i++) {
            add(data[i]);
        }
    }

    public Node find(T data, boolean isFindMount) {
        if (data == null) {
            return null;
        }
        Node temp = root;
        Node target = temp;
        boolean isMatch = false;
        while (temp != null) {
            if (data.compareTo(temp.data) > 0) {
                target = temp;
                temp = temp.right;
            } else if (data.compareTo(temp.data) < 0) {
                target = temp;
                temp = temp.left;
            } else {
                if (isFindMount) {
                    return null;
                } else {
                    isMatch = true;
                    target = temp;
                    temp = null;
                }
            }
        }
        if (isFindMount) {
            return target;
        } else {
            if (isMatch) {
                return target;
            } else {
                return null;
            }
        }
    }

    public void remove(T data) {
        if (data == null) {
            return;
        }
        Node curr = find(data, false);
        if (curr == null) {
            return;
        }
        if (curr.left == null && curr.right == null) {
            Node parent = curr.parent;
            if (parent.left == curr) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (curr.left == null) {
            Node parent = curr.parent;
            Node node = curr.right;
            parent.right = node;
            node.parent = parent;
        } else if (curr.right == null) {
            Node parent = curr.parent;
            Node node = curr.left;
            parent.left = node;
            node.parent = parent;
        } else {
            Node parent = curr.parent;
            Node left = curr.left;
            Node right = curr.right;
            Node max = curr.left;

            while (max.right != null) {
                max = max.right;
            }
            Node maxParent = max.parent;
            Node maxLeft = max.left;

            if (parent.left == curr) {
                parent.left = max;
                max.parent = parent;
            } else {
                parent.right = max;
                max.parent = parent;
            }
            max.right = right;
            right.parent = max;

            if (max != left) {
                max.left = left;
                left.parent = max;
                maxParent.right = maxLeft;
                if (maxLeft != null) {
                    maxLeft.parent = maxParent;
                }
            }
        }
        size--;
    }

    public int getTreeHeight() {
        if (root == null) {
            return 0;
        }
        int height = 1;
        MyStack<Node> stack = new MyStack<>();
        Node temp = root;
        Node visited = null;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.peek();
            if (temp.right == null || temp.right == visited) {
                height = Math.max(height, stack.size());
                temp = stack.pop();
                visited = temp;
                temp = null;
            } else {
                temp = temp.right;
            }
        }
        return height;
    }


    public int getTreeLeafCount() {
        int count = 0;
        if (root == null) {
            return count;
        }
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        Node visited = null;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.peek();
            if (temp.right == null || temp.right == visited) {
                temp = stack.pop();
                visited = temp;
                if (temp.left == null && temp.right == null) {
                    count++;
                }
                temp = null;
            } else {
                temp = temp.right;
            }
        }
        return count;
    }

    public int getTreeNodeCount() {
        return size() - getTreeLeafCount();
    }

    public void iteratorPre(MyIterator<T> iterator) {
        MyStack<Node> stack = new MyStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            if (temp != null) {
                if (iterator != null) {
                    iterator.call(temp.data);
                }
                if (temp.right != null) {
                    stack.push(temp.right);
                }
                if (temp.left != null) {
                    stack.push(temp.left);
                }
            }
        }
    }

    public void iteratorIn(MyIterator<T> iterator) {
        MyStack<Node> stack = new MyStack<>();
        Node temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            if (iterator != null) {
                iterator.call(temp.data);
            }
            temp = temp.right;
        }
    }

    public void iteratorPost(MyIterator<T> iterator) {
        MyStack<Node> stack = new MyStack<>();
        Node visited = null;
        Node temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.peek();
            if (temp.right == null || temp.right == visited) {
                temp = stack.pop();
                visited = temp;
                if (iterator != null) {
                    iterator.call(temp.data);
                }
                temp = null;
            } else {
                temp = temp.right;
            }
        }
    }

    MyIterator<T> iterator;

    public void recursivePre(MyIterator<T> iterator) {
        this.iterator = iterator;
        recursivePre(root);
    }

    private void recursivePre(Node node) {
        if (node != null) {
            if (iterator != null) {
                iterator.call(node.data);
            }
            recursivePre(node.left);
            recursivePre(node.right);
        }
    }

    public void recursiveIn(MyIterator<T> iterator) {
        this.iterator = iterator;
        recursiveIn(root);
    }

    private void recursiveIn(Node node) {
        if (node != null) {
            recursiveIn(node.left);
            if (iterator != null) {
                iterator.call(node.data);
            }
            recursiveIn(node.right);
        }
    }

    public void recursivePost(MyIterator<T> iterator) {
        this.iterator = iterator;
        recursivePost(root);
    }

    private void recursivePost(Node node) {
        if (node != null) {
            recursivePost(node.left);
            recursivePost(node.right);
            if (iterator != null) {
                iterator.call(node.data);
            }
        }
    }

    public void iteratorBfs(MyIterator<T> iterator) {
        MyQueue<Node> queue = new MyQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (iterator != null) {
                iterator.call(temp.data);
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public int size() {
        return size;
    }

    public final class Node {
        public T data;
        public Node parent;
        public Node left;
        public Node right;

        Node(T data, Node parent, Node left, Node right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

}
