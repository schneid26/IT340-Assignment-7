class BST2 { 
 private Node root; 
    //Basic Node definition. Each Node contains a Value, a left child, and a right child
    class Node { 
        int val; 
        Node left, right; 
  
        public Node(int value) { 
         val = value; 
            left =null;
            right = null; 
        } 
    } 
  
  
    public BST2(int rootValue) {  
        root = new Node(rootValue);  
    } 
  
    //insert Value into the appropriate spot in the tree
    private Node insert(Node root,int value) { 
  

        if (root == null) { 
            root = new Node(value); 
            return root; 
        } 
  
        if (value < root.val) 
            root.left = insert(root.left, value); 
        else if (value > root.val) 
            root.right = insert(root.right, value); 
  
        return root; 
    } 
  
 
    //finish code to print all values with an inorder traversal 
    void inorderTraversal(Node root) {   
      if (root != null) { 
          
          inorderTraversal(root.left); 
          System.out.println(root.val);
          inorderTraversal(root.right);  
       } 
        
    }
    void preorderTraversal(Node root){
      if (root != null) { 
          
          System.out.println(root.val);
          preorderTraversal(root.left); 
          preorderTraversal(root.right);  
       }    
    }
    void postorderTraversal(Node root){
      if (root != null) { 
         
          postorderTraversal(root.left); 
          postorderTraversal(root.right); 
          System.out.println(root.val);
      } 
    }
   
     static Node search(int n,Node root){
      
      if(root != null){
        if(root.val == n){
           return root;
        } else {
            Node foundNode = search(n, root.left);
            if(foundNode == null) {
                foundNode = search(n, root.right);
            return foundNode;
            }
           
         }
    } else {
        return null;
    } 
     return null;
    }
     static boolean mySearch(int n, Node root){
      
       Node result=search(n,root);
      
       if(result == null){
         return false;
     }
       else {
     return true;
       }
     }
     
     
    public static void main(String[] args) { 
     //create tree with a root of 5
        BST2 tree = new BST2(5);   
      
        tree.insert(tree.root,2); 
        tree.insert(tree.root,7); 
        tree.insert(tree.root,10); 
        tree.insert(tree.root,4); 
        tree.insert(tree.root,1);  
  
        //start traversal at root
        tree.inorderTraversal(tree.root);
        tree.preorderTraversal(tree.root);
        tree.postorderTraversal(tree.root);
        System.out.println(mySearch(99,tree.root));
    } 
}