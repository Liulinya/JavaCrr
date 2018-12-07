// kth sorted element in a binary search tree
class Node { 
    int data; 
    Node left, right; 
    Node(int d) { 
        data = d; 
        left = right = null; 
    } 
} 
  
public class BinaryTree { 
    static Node root; 
    
    public static void main(String[] args) { 
        BinaryTree tree = new BinaryTree(); 
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7}; 
        int n = arr.length; 
        root = tree.sortedArrayToBST(arr, 0, n - 1); 
        System.out.println("Preorder traversal of constructed BST"); 
        tree.preOrder(root); 
    }
        
    // a function that constructs Balanced Binary Search Tree from a sorted array
    Node sortedArrayToBST(int arr[], int start, int end) { 
        // base case 
        if (start > end) { 
            return null; 
        } 
  
        //get the middle element and make it root
        int mid = (start + end) / 2; 
        Node node = new Node(arr[mid]); 
  
        // recursively construct the left subtree and make it left child of root
        node.left = sortedArrayToBST(arr, start, mid - 1); 
  
        // recursively construct the right subtree and make it right child of root
        node.right = sortedArrayToBST(arr, mid + 1, end); 
          
        return node; 
    } 
  
    // a utility function to print preorder traversal of BST
    void preOrder(Node node) { 
        if (node == null) { 
            return; 
        } 
        System.out.print(node.data + " "); 
        preOrder(node.left); 
        preOrder(node.right); 
    }  
} 