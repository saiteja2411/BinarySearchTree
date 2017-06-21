
package binarysearchtree;

public class BinarySearchTree {

    public Node root;
    public static void main(String[] args) throws InterruptedException {
        
        
        BinarySearchTree BS =new BinarySearchTree();
        BS.insert(8);
        BS.insert(4);
        BS.insert(9);
        BS.insert(3);
        BS.insert(7);
        BS.insert(5);
        BS.display();
        
        Thread.sleep(2000);
        BS.delete(7);
        //System.out.println("Found ");
        //boolean found=BS.search(0);
        //System.out.println(found);
        //BS.insert(9);
         Thread.sleep(2000);
        BS.display();
        
    }
    
    void delete(int i){
        
        Node x=root;
        while(x!=null){
            System.out.println("hi 1");
            if(x.value==i)
            {
                
                System.out.println("hi 2");
                Node n1=root;
                while(n1.left!=x || n1.right!=x)
                {
                    
                    System.out.println("hi 3");
                    if(n1.left==x){
                        if(x.left==null && x.right==null){
                            n1.left=null;
                            return;
                        }
                        else if(x.left.value<x.right.value){
                            n1.left=x.right;
                            cover(x.left);
                        }
                        else{
                            n1.left=x.left;
                            cover(x.right);
                        }
                        
                    }
                    else if(n1.right==x ){
                        if(x.left==null && x.right==null){
                            n1.right=null;
                            return;
                        }
                        else if(x.left.value<x.right.value){
                            n1.right=x.right;
                            cover(x.left);
                        }
                        else{
                            n1.right=x.left;
                            cover(x.right);
                        }
                        
                    }
                    else if(x.value<n1.value)
                        n1=n1.left;
                    else if(x.value>n1.value)
                        n1=n1.right;
                    else if(n1.left==null && n1.right==null)
                        return;
                }
            }
            else if(i<x.value){
                System.out.println("left");
                x=x.left;
            }
            else if(i>x.value){
                System.out.println("right");
                x=x.right;
            }
            //System.out.println("binarysearchtree.BinarySearchTree.delete()");
        }
    }
    
    boolean search(int i){
        Node x= root;
        while(x!=null) {
            
            if(x.value==i){
                return true;
            }
            else {
                if(x.value<i){
                    x=x.right;
                }
                else if(x.value>i)
                    x=x.left;
            }
       }
        return false;
    }
    
    
    void insert(int i){
        
        Node newNode= new Node(i);
        
        if(root==null){
            root=newNode;
            return;
        }
        Node parent= root;
        while(true){
            if(i<parent.value){
                
                if(parent.left==null){
                    parent.left=newNode;
                    return;
                }   
                parent=parent.left;
            }
            if(i>parent.value){
                
                if(parent.right==null){
                    parent.right=newNode;
                    return;
                }  
                parent=parent.right;
            }
        }
    }
    
    void display(){
         display(root);
    }
    void display(Node n){
       
        if(n!=null){
            display(n.left);
            System.err.print(n.value+" | ");
            display(n.right);
        }
       
    }

    private void cover(Node left) {
        
        insert(left.value);
        if(left.left!=null){
        cover(left.left);
        }
        if(left.left!=null){
        cover(left.right);
        }
    }
}

