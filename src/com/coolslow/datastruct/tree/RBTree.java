package com.coolslow.datastruct.tree;


import com.coolslow.datastruct.MyStack;
import com.coolslow.utils.MyIterator;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 1.每个结点要么是红的要么是黑的。  
 * 2.根结点是黑的。  
 * 3.每个叶结点（叶结点即指树尾端NIL指针或NULL结点）都是黑的。  
 * 4.如果一个结点是红的，那么它的两个儿子都是黑的。  
 * 5.对于任意结点而言，其到叶结点树尾端NIL指针的每条路径都包含相同数目的黑结点。 
 *
 * @param <T>
 */
// https://blog.csdn.net/abcdef314159/article/details/77193888

public class RBTree<T extends Comparable<T>> {

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    private Node<T> root;
    private int size;

    public void add(T data) {
        if (data == null) {
            return;
        }
        Node<T> target = find(data, true);
        Node<T> node = new Node<>(data, target, null, null);
        if (root == null) {
            root = node;
            size++;
            return;
        }
        if (data.compareTo(target.data) > 0) {
            target.right = node;
        } else if (data.compareTo(target.data) < 0) {
            target.left = node;
        } else {
            return;
        }
        size++;
        fixAdd(node);
    }

    public void addAll(T[] data) {
        if (data == null || data.length == 0) {
            return;
        }
        for (T datum : data) {
            add(datum);
        }
    }

    public Node<T> find(T data, boolean isMount) {
        if (data == null || root == null) {
            return null;
        }
        Node<T> temp = root;
        Node<T> target = null;
        while (temp != null) {
            if (data.compareTo(temp.data) > 0) {
                target = temp;
                temp = temp.right;
            } else if (data.compareTo(temp.data) < 0) {
                target = temp;
                temp = temp.left;
            } else {
                if (isMount) {
                    return null;
                } else {
                    return temp;
                }
            }
        }
        if (isMount) {
            return target;
        } else {
            return null;
        }
    }

    private void fixAdd(Node<T> node) {
        setColor(node, RED);
        while (node != null && node != root && colorOf(parentOf(node)) == RED) {
            if (parentOf(node) == leftOf(parentOf(parentOf(node)))) {
                Node<T> uncle = rightOf(parentOf(parentOf(node)));
                if (colorOf(uncle) == RED) {
                    setColor(uncle, BLACK);
                    setColor(parentOf(node), BLACK);
                    setColor(parentOf(parentOf(node)), RED);
                    node = parentOf(parentOf(node));
                } else {
                    if (node == rightOf(parentOf(node))) {
                        node = parentOf(node);
                        rotateLeft(node);
                    }
                    setColor(parentOf(node), BLACK);
                    setColor(parentOf(parentOf(node)), RED);
                    rotateRight(parentOf(parentOf(node)));
                }
            } else {
                Node<T> uncle = leftOf(parentOf(parentOf(node)));
                if (colorOf(uncle) == RED) {
                    setColor(uncle, BLACK);
                    setColor(parentOf(node), BLACK);
                    setColor(parentOf(parentOf(node)), RED);
                    node = parentOf(parentOf(node));
                } else {
                    if (node == leftOf(parentOf(node))) {
                        node = parentOf(node);
                        rotateRight(node);
                    }
                    setColor(parentOf(node), BLACK);
                    setColor(parentOf(parentOf(node)), RED);
                    rotateLeft(parentOf(parentOf(node)));
                }
            }
        }
        setColor(root, BLACK);
    }

    public void rotateLeft(Node<T> node) {
        if (node == null || rightOf(node) == null) {
            return;
        }
        Node<T> parent = parentOf(node);
        Node<T> left = leftOf(node);
        Node<T> right = rightOf(node);
        Node<T> minNode = right.left;

        right.parent = parent;
        if (parent != null) {
            if (parent.left == node) {
                parent.left = right;
            } else {
                parent.right = right;
            }
        } else {
            root = right;
        }
        right.left = node;
        node.parent = right;

        node.right = minNode;
        if (minNode != null) {
            minNode.parent = node;
        }
    }

    public void rotateRight(Node<T> node) {
        if (node == null || leftOf(node) == null) {
            return;
        }
        Node<T> parent = parentOf(node);
        Node<T> left = leftOf(node);
        Node<T> right = rightOf(node);
        Node<T> maxNode = leftOf(node).right;

        left.parent = parent;
        if (parent != null) {
            if (node == parent.left) {
                parent.left = left;
            } else {
                parent.right = left;
            }
        } else {
            root = left;
        }

        left.right = node;
        node.parent = left;

        node.left = maxNode;
        if (maxNode != null) {
            maxNode.parent = node;
        }

    }

    public void remove(T data) {
        Node<T> curr = find(data, false);
        if (curr == null) {
            return;
        }
        if (curr.left == null && curr.right == null) {
            if (colorOf(curr) == BLACK) {
                fixDelete(curr);
            }
            Node<T> p = curr.parent;
            if (p != null) {
                if (curr == p.left) {
                    p.left = null;
                } else {
                    p.right = null;
                }
            } else {
                root = null;
            }
        } else if (curr.left == null) {
            Node<T> p = curr.parent;
            Node<T> r = curr.right;
            r.parent = p;
            if (p != null) {
                if (curr == p.left) {
                    p.left = r;
                } else {
                    p.right = r;
                }
            } else {
                root = r;
            }
            if (colorOf(r) == BLACK) {
                fixDelete(r);
            }

        } else if (curr.right == null) {
            Node<T> p = curr.parent;
            Node<T> l = curr.left;
            l.parent = p;
            if (p != null) {
                if (p.left == curr) {
                    p.left = l;
                } else {
                    p.right = l;
                }
            } else {
                root = l;
            }
            if (colorOf(l) == BLACK) {
                fixDelete(l);
            }
        } else {
            Node<T> maxNode = successor(curr);
            curr.data = maxNode.data;
            Node<T> maxParent = maxNode.parent;
            if (maxNode == curr.right) {
                curr.right = maxNode.right;
                if (maxNode.right != null) {
                    maxNode.right.parent = curr;
                }
            } else {
                maxParent.left = maxNode.right;
                if (maxNode.right != null) {
                    maxNode.right.parent = maxParent;
                }
            }
        }
        size--;
    }

    private void fixDelete(Node<T> node) {
        while (node != root && colorOf(node) == BLACK) {
            if (node == leftOf(parentOf(node))) {
                Node<T> brother = rightOf(parentOf(node));
                if (colorOf(brother) == RED) {
                    setColor(brother, BLACK);
                    setColor(parentOf(brother), RED);
                    rotateLeft(parentOf(brother));
                    brother = rightOf(parentOf(node));
                }
                if (colorOf(leftOf(brother)) == BLACK && colorOf(rightOf(brother)) == BLACK) {
                    setColor(brother, RED);
                    node = parentOf(node);
                } else {
                    if (colorOf(rightOf(brother)) == BLACK) {
                        setColor(leftOf(brother), BLACK);
                        setColor(brother, RED);
                        rotateRight(brother);
                        brother = rightOf(parentOf(node));
                    }
                    setColor(brother, colorOf(parentOf(brother)));
                    setColor(parentOf(brother), BLACK);
                    setColor(rightOf(brother), BLACK);
                    rotateLeft(parentOf(brother));
                    node = root;
                }
            } else {
                Node<T> brother = leftOf(parentOf(node));
                if (colorOf(brother) == RED) {
                    setColor(brother, BLACK);
                    setColor(parentOf(brother), RED);
                    rotateRight(parentOf(brother));
                    brother = leftOf(parentOf(node));
                }
                if (colorOf(leftOf(brother)) == BLACK && colorOf(rightOf(brother)) == BLACK) {
                    setColor(brother, RED);
                    node = parentOf(node);
                } else {
                    if (colorOf(leftOf(brother)) == BLACK) {
                        setColor(brother, RED);
                        setColor(rightOf(brother), BLACK);
                        rotateLeft(brother);
                        brother = leftOf(parentOf(node));
                    }
                    setColor(brother, colorOf(parentOf(brother)));
                    setColor(leftOf(brother), BLACK);
                    setColor(parentOf(brother), BLACK);
                    rotateRight(parentOf(brother));
                    node = root;
                }
            }
        }
        setColor(node, BLACK);
    }

    private Node<T> successor(Node<T> node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            Node<T> temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        } else {
            Node<T> temp = node.parent;
            Node<T> ch = node;
            while (temp != null && temp.right == ch) {
                ch = temp;
                temp = temp.parent;
            }
            return temp;
        }
    }

    public Node<T> predecessor(Node<T> node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            Node<T> temp = node.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            return temp;
        } else {
            Node<T> temp = node.parent;
            Node<T> ch = node;
            while (temp != null && temp.left == ch) {
                ch = temp;
                temp = temp.parent;
            }
            return temp;
        }
    }

    private Node<T> parentOf(Node<T> node) {
        return node == null ? null : node.parent;
    }

    private Node<T> leftOf(Node<T> node) {
        return node == null ? null : node.left;
    }

    private Node<T> rightOf(Node<T> node) {
        return node == null ? null : node.right;
    }

    private boolean colorOf(Node<T> node) {
        return node == null ? BLACK : node.color;
    }

    private void setColor(Node<T> node, boolean c) {
        if (node != null) {
            node.color = c;
        }
    }

    public void iteratorPost(MyIterator<Node<T>> iterator) {
        iteratorPost(root, iterator);
    }

    private void iteratorPost(Node<T> node, MyIterator<Node<T>> iterator) {
        MyStack<Node<T>> stack = new MyStack<>();
        Node<T> temp = node;
        Node<T> visited = null;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.peek();
            if (temp.right == null || temp.right == visited) {
                temp = stack.pop();
                if (iterator != null) {
                    iterator.call(temp);
                }
                visited = temp;
                temp = null;
            } else {
                temp = temp.right;
            }
        }
    }

    public int getTreeHeight(Node<T> node) {
        MyStack<Node<T>> stack = new MyStack<>();
        Node<T> temp = node;
        Node<T> visited = null;
        int height = 0;
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

    public Map<String, Integer> getBlackCount(Node<T> node) {
        MyStack<Node<T>> stack = new MyStack<>();
        Node<T> temp = node;
        Node<T> visited = null;
        Map<String, Integer> recorder = new LinkedHashMap<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.peek();
            if (temp.right == null || temp.right == visited) {
                temp = stack.pop();
                if (temp.left == null && temp.right == null) {
                    int blackCount = 1;
                    Node<T> initP = temp;
                    while (initP != node) {
                        if (initP.color == BLACK) {
                            blackCount++;
                        }
                        initP = initP.parent;
                    }
                    recorder.put(temp.data.toString(), blackCount);
                }
                visited = temp;
                temp = null;
            } else {
                temp = temp.right;
            }
        }
        return recorder;
    }

    public int size() {
        return size;
    }

    public static class Node<T> {
        public boolean color = BLACK;
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
