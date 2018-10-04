package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    char value;
    TreeNode left;
    TreeNode right;

    TreeNode(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class poj3367 {

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int numTest = Integer.valueOf(stdin.readLine());
        String line;
        while (numTest > 0 && (line = stdin.readLine()) != null) {
            numTest--;
            TreeNode root = constructTree(line);
            String outExp = convertExpression(root);
            System.out.println(outExp);
        }

    }

    public static TreeNode constructTree(String expression) {
        /*
         * Use a stack to do post-order construction
         */
        char[] expArr = expression.toCharArray();
        Stack<TreeNode> myStack = new Stack<TreeNode>();
        for (int i = 0; i < expArr.length; i++) {
            char curr = expArr[i];
            TreeNode newNode = new TreeNode(curr);
            if (!Character.isLowerCase(curr)) {
                TreeNode right = myStack.pop();
                TreeNode left = myStack.pop();
                newNode.left = left;
                newNode.right = right;
            }
            myStack.push(newNode);
        }
        return myStack.pop();
    }

    public static String convertExpression(TreeNode root) {

        StringBuffer sb = new StringBuffer();

        Queue<TreeNode> myQueue = new LinkedList<TreeNode>();

        /*
         * Get all the values in level order
         * And reverse
         */
        myQueue.offer(root);
        while (!myQueue.isEmpty()) {
            TreeNode curr = myQueue.poll();
            sb.append(curr.value);
            if (curr.left != null) {
                myQueue.offer(curr.left);
            }
            if (curr.right != null) {
                myQueue.offer(curr.right);
            }
        }

        return sb.reverse().toString();
    }
}
