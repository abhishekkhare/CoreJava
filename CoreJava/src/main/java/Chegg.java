import java.util.ArrayList;
import java.util.List;

public class Chegg {

	public static void main(String[] args) {
		

	}
	
	 public static void printNodeD(Node root) {
	        if(root!=null){
	            if(root.parent==null){
	               System.out.println("Node::" + root.id); 
	            }
	            List<Node> children = root.children;
	            for(Node node: children){
	                System.out.println("Node::" + node.id);
	                if(node.children != null && node.children.size()>0){    
	                    printNodeD(node);
	                } 
	            }
	            
	        }
	    }

	    public static void printNodeB(Node root) {
	        if(root!=null){
	            System.out.println("Node::" + root.id); 
	            int index=0;
	            List<List<Node>> remainingChildren =  new ArrayList<List<Node>>();
	            List<Node> children = root.children;
	            if(children!=null && children.size()>0){
	                while(true){
	                    for(Node node: children){
	                        if(node!=null){
	                            System.out.println("Node::" + node.id); 
	                            if(node.children!=null && node.children.size()>0)
	                                remainingChildren.add(node.children);
	                        }
	                    }
	                    if(remainingChildren.size()>index){
	                        children = remainingChildren.get(index);
	                        index++;
	                    }else{
	                        break;
	                    }
	                
	                }
	            }
	            
	            
	            
	        }
	    }


	    
	    public static class Node {
	        public String id;
	        public List<Node> children;
	        public Node parent;
	    }

}
