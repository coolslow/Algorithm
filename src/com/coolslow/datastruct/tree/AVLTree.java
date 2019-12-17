package com.coolslow.datastruct.tree;

import com.coolslow.datastruct.MyStack;
import com.coolslow.utils.MyIterator;

/**
 * AVL树
 * <p>
 * by MrThanksgiving
 */
public class AVLTree<T extends Comparable<T>> {

    private Node<T> root;
    private int size = 0;

    public AVLTree() {
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
            if (data.compareTo(target.data) > 0) {
                target.right = node;
            } else {
                target.left = node;
            }
            size++;
            calcBalance(target);
        }
    }

    public void addAll(T[] data) {
        if (data == null || data.length == 0) {
            return;
        }
        for (T datum : data) {
            add(datum);
        }

    }

    private Node<T> find(T data, boolean isFindMount) {
        if (data == null || root == null) {
            return null;
        }
        Node<T> target = null;
        Node<T> temp = root;
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


    private void calcBalance(Node<T> target) {
        if (target == null) {
            return;
        }
        while (target.parent != null) {
            target = target.parent;
            int leftHeight = getTreeHeight(target.left);
            int rightHeight = getTreeHeight(target.right);
            if (leftHeight - rightHeight == 2) {
                if (target.left != null) {
                    int l = getTreeHeight(target.left.left);
                    int r = getTreeHeight(target.left.right);
                    if (l > r) {
                        target = rotateLL(target);
                    } else if (l < r) {
                        target = rotateLR(target);
                    }
                }
            } else if (leftHeight - rightHeight == -2) {
                if (target.right != null) {
                    int l = getTreeHeight(target.right.left);
                    int r = getTreeHeight(target.right.right);
                    if (l < r) {
                        target = rotateRR(target);
                    } else if (l > r) {
                        target = rotateRL(target);
                    }
                }
            }
        }
    }

    public int getTreeHeight(Node<T> node) {
        if (node == null) {
            return 0;
        }
        int height = 0;
        MyStack<Node<T>> stack = new MyStack<>();
        Node<T> temp = node;
        Node<T> visited = null;
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

    /**
     * //                   p
     * //                 /
     * //              srcRoot
     * //              /
     * //          newRoot
     * //           /
     * //        child
     * //
     */
    private Node<T> rotateLL(Node<T> srcRoot) {
        if (srcRoot == null) {
            return null;
        }
        Node<T> srcParent = srcRoot.parent;
        Node<T> newRoot = srcRoot.left;
        Node<T> newRootRight = newRoot.right;

        if (srcParent != null) {
            if (srcParent.left == srcRoot) {
                srcParent.left = newRoot;
                newRoot.parent = srcParent;
            } else {
                srcParent.right = newRoot;
                newRoot.parent = srcParent;
            }
        } else {
            root = newRoot;
            newRoot.parent = null;
        }

        newRoot.right = srcRoot;
        srcRoot.parent = newRoot;

        srcRoot.left = newRootRight;
        if (newRootRight != null) {
            newRootRight.parent = srcRoot;
        }
        return newRoot;

    }

    /**
     * //         p
     * //           \
     * //         srcRoot
     * //              \
     * //             newRoot
     * //                \
     * //               child
     * //
     */
    private Node<T> rotateRR(Node<T> srcRoot) {
        if (srcRoot == null) {
            return null;
        }
        Node<T> srcParent = srcRoot.parent;
        Node<T> newRoot = srcRoot.right;
        Node<T> newRootLeft = newRoot.left;
        if (srcParent != null) {
            if (srcParent.left == srcRoot) {
                srcParent.left = newRoot;
                newRoot.parent = srcParent;
            } else {
                srcParent.right = newRoot;
                newRoot.parent = srcParent;
            }
        } else {
            root = newRoot;
            newRoot.parent = null;
        }
        newRoot.left = srcRoot;
        srcRoot.parent = newRoot;

        srcRoot.right = newRootLeft;
        if (newRootLeft != null) {
            newRootLeft.parent = srcRoot;
        }
        return newRoot;
    }


    /**
     * //                  p
     * //                /
     * //            srcRoot
     * //             /
     * //        newRoot
     * //             \
     * //             child
     * //
     */
    private Node<T> rotateLR(Node<T> srcRoot) {
        if (srcRoot == null) {
            return null;
        }
        rotateRR(srcRoot.left);
        return rotateLL(srcRoot);
    }

    /**
     * //             p
     * //               \
     * //             srcRoot
     * //                  \
     * //               newRoot
     * //                /
     * //            child
     * //
     */
    private Node<T> rotateRL(Node<T> srcRoot) {
        if (srcRoot == null) {
            return null;
        }
        rotateLL(srcRoot.right);
        return rotateRR(srcRoot);
    }

    public void remove(T data) {
        Node<T> target;
        Node<T> curr = find(data, false);
        if (curr == null) {
            return;
        }
        if (curr.left == null && curr.right == null) {
            Node<T> parent = curr.parent;
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
            target = parent;
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
            target = parent;
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
            target = parent;
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
            target = maxParent;

//            Node<T> parent = curr.parent;
//            Node<T> left = curr.left;
//            Node<T> right = curr.right;
//
//            Node<T> max = curr.left;
//            while (max.right != null) {
//                max = max.right;
//            }
//            Node<T> maxParent = max.parent;
//            Node<T> maxLeft = max.left;
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
//            target = maxParent;

        }
        size--;
        calcBalance(target);
    }

    private MyIterator<T> iterator;

    public void testIteratorPost(MyIterator<Node<T>> iterator) {
        MyStack<Node<T>> stack = new MyStack<>();
        Node<T> temp = root;
        Node<T> visited = null;
        while (temp != null || stack.empty()) {
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

    public static class Node<T> {
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
