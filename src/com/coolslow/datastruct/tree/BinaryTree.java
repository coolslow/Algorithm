package com.coolslow.datastruct.tree;

import com.coolslow.datastruct.queue.MyQueue;
import com.coolslow.datastruct.stack.MyStack;
import com.coolslow.datastruct.utils.MyIterator;

import java.util.Stack;

/**
 * 二叉树
 * <p>
 * by MrThanksgiving
 */
public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root;
    private int size;

    public BinaryTree() {
    }

    public void add(T data) {
        Node<T> target = find(data, true);
        Node<T> node = new Node<>(data, target, null, null);
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
        for (T datum : data) {
            add(datum);
        }
    }

    public Node<T> find(T data, boolean isFindMount) {
        if (data == null) {
            return null;
        }
        Node<T> temp = root;
        Node<T> target = temp;
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
                    return temp;
                }
            }
        }
        if (isFindMount) {
            return target;
        } else {
            return null;
        }
    }

    public void remove(T data) {
        if (data == null) {
            return;
        }
        Node<T> curr = find(data, false);
        if (curr == null) {
            return;
        }
        if (curr.left == null && curr.right == null) {
            Node parent = curr.parent;
            if (parent != null) {
                if (parent.left == curr) {
                    parent.left = null;
                    curr.parent = null;
                } else {
                    parent.right = null;
                    curr.parent = null;
                }
            } else {
                root = null;
                curr.parent = null;
            }

        } else if (curr.left == null) {
            Node<T> parent = curr.parent;
            Node<T> right = curr.right;
            if (parent != null) {
                if (parent.left == curr) {
                    parent.left = right;
                    right.parent = parent;
                } else {
                    parent.right = right;
                    right.parent = parent;
                }
            } else {
                root = right;
                right.parent = null;
            }

        } else if (curr.right == null) {
            Node<T> parent = curr.parent;
            Node<T> left = curr.left;
            if (parent != null) {
                if (parent.left == curr) {
                    parent.left = left;
                    left.parent = parent;
                } else {
                    parent.right = left;
                    left.parent = parent;
                }
            } else {
                root = left;
                left.parent = null;
            }
        } else {
            Node<T> maxNode = curr.left;
            while (maxNode.right != null) {
                maxNode = maxNode.right;
            }
            Node<T> maxParent = maxNode.parent;
            curr.data = maxNode.data;
            if (maxNode == curr.left) {
                curr.left = maxNode.left;
                if (maxNode.left != null) {
                    maxNode.left.parent = curr;
                }
            } else {
                maxParent.right = maxNode.left;
                if (maxNode.left != null) {
                    maxNode.left.parent = maxParent;
                }
            }

//            Node<T> parent = curr.parent;
//            Node<T> left = curr.left;
//            Node<T> right = curr.right;
//            Node<T> max = curr.left;
//            while (max.right != null) {
//                max = max.right;
//            }
//            Node maxParent = max.parent;
//            Node maxLeft = max.left;
//
//            if (parent != null) {
//                if (parent.left == curr) {
//                    parent.left = max;
//                    max.parent = parent;
//                } else {
//                    parent.right = max;
//                    max.parent = parent;
//                }
//            } else {
//                root = max;
//                max.parent = null;
//            }
//
//            max.right = right;
//            right.parent = max;
//
//            if (max != left) {
//                max.left = left;
//                left.parent = max;
//
//                maxParent.right = maxLeft;
//                if (maxLeft != null) {
//                    maxLeft.parent = maxParent;
//                }
//            }
        }
        size--;
    }

    public int getTreeHeight() {
        if (root == null) {
            return -1;
        }
        int height = 0;
        MyStack<Node> stack = new MyStack<>();
        Node temp = root;
        Node visited = null;
        while (temp != null || stack.empty()) {
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
        MyStack<Node<T>> stack = new MyStack<>();
        stack.push(root);
        while (stack.empty()) {
            Node<T> temp = stack.pop();
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
        MyStack<Node<T>> stack = new MyStack<>();
        Node<T> temp = root;
        while (temp != null || stack.empty()) {
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
        MyStack<Node<T>> stack = new MyStack<>();
        Node<T> visited = null;
        Node<T> temp = root;
        while (temp != null || stack.empty()) {
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

    private MyIterator<T> iterator;

    public void recursivePre(MyIterator<T> iterator) {
        this.iterator = iterator;
        recursivePre(root);
    }

    private void recursivePre(Node<T> node) {
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

    private void recursiveIn(Node<T> node) {
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

    private void recursivePost(Node<T> node) {
        if (node != null) {
            recursivePost(node.left);
            recursivePost(node.right);
            if (iterator != null) {
                iterator.call(node.data);
            }
        }
    }

    public void iteratorBfs(MyIterator<T> iterator) {
        MyQueue<Node<T>> queue = new MyQueue<>();
        queue.add(root);
        while (queue.empty()) {
            Node<T> temp = queue.remove();
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

    public final static class Node<T> {
        public T data;
        public Node<T> parent;
        public Node<T> left;
        public Node<T> right;

        Node(T data, Node<T> parent, Node<T> left, Node<T> right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

}
