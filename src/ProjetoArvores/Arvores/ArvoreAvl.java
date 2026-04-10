package Trabalhos.src.ProjetoArvores.Arvores;


    class AVLNode {
        int value, height;
        AVLNode left, right;

        AVLNode(int value) {
            this.value = value;
            height = 1;
        }
    }

    public class ArvoreAvl {

        AVLNode root;

        int height(AVLNode node) {
            if (node == null)
                return 0;
            return node.height;
        }

        int getBalance(AVLNode node) {
            if (node == null)
                return 0;
            return height(node.left) - height(node.right);
        }

        AVLNode rotateRight(AVLNode y) {

            AVLNode x = y.left;
            AVLNode T2 = x.right;

            x.right = y;
            y.left = T2;

            y.height = Math.max(height(y.left), height(y.right)) + 1;
            x.height = Math.max(height(x.left), height(x.right)) + 1;

            return x;
        }

        AVLNode rotateLeft(AVLNode x) {

            AVLNode y = x.right;
            AVLNode T2 = y.left;

            y.left = x;
            x.right = T2;

            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;

            return y;
        }

        public void insert(int value) {
            root = insertRec(root, value);
        }

        AVLNode insertRec(AVLNode node, int value) {

            if (node == null)
                return new AVLNode(value);

            if (value < node.value)
                node.left = insertRec(node.left, value);

            else if (value > node.value)
                node.right = insertRec(node.right, value);

            else
                return node;

            node.height = 1 + Math.max(height(node.left), height(node.right));

            return balance(node);
        }

        public void remove(int value) {
            root = removeRec(root, value);
        }

        AVLNode removeRec(AVLNode node, int value) {

            if (node == null)
                return node;

            if (value < node.value)
                node.left = removeRec(node.left, value);

            else if (value > node.value)
                node.right = removeRec(node.right, value);

            else {

                if (node.left == null || node.right == null) {

                    AVLNode temp = null;

                    if (temp == node.left)
                        temp = node.right;
                    else
                        temp = node.left;

                    if (temp == null) {
                        node = null;
                    } else {
                        node = temp;
                    }

                } else {

                    AVLNode temp = minValueNode(node.right);

                    node.value = temp.value;

                    node.right = removeRec(node.right, temp.value);
                }
            }

            if (node == null)
                return node;

            node.height = Math.max(height(node.left), height(node.right)) + 1;

            return balance(node);
        }

        AVLNode balance(AVLNode node) {

            int balance = getBalance(node);

            // LL
            if (balance > 1 && getBalance(node.left) >= 0)
                return rotateRight(node);

            // LR
            if (balance > 1 && getBalance(node.left) < 0) {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }

            // RR
            if (balance < -1 && getBalance(node.right) <= 0)
                return rotateLeft(node);

            // RL
            if (balance < -1 && getBalance(node.right) > 0) {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }

            return node;
        }

        AVLNode minValueNode(AVLNode node) {

            AVLNode current = node;

            while (current.left != null)
                current = current.left;

            return current;
        }

        public boolean search(int value) {
            return searchRec(root, value);
        }

        boolean searchRec(AVLNode node, int value) {

            if (node == null)
                return false;

            if (value == node.value)
                return true;

            if (value < node.value)
                return searchRec(node.left, value);

            return searchRec(node.right, value);
        }

        public int getHeight() {
            return height(root);
        }
    }
