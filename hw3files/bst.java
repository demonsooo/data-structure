class bst{
    
    Node root;

    private class Node{
    	
    	// These attributes of the Node class will not be sufficient for those attempting the AVL extra credit.
    	// You are free to add extra attributes as you see fit, but do not remove attributes given as it will mess with help code.
        String keyword;
        Record record;
        int size;
        Node l;
        Node r;

        private Node(String k){
        	// TODO Instantialize a new Node with keyword k.
         keyword = k;
         size = 0;
        }

        private void update(Record r){
        	//TODO Adds the Record r to the linked list of records. You do not have to check if the record is already in the list.
        	//HINT: Add the Record r to the front of your linked list.
         record = new Record(r.id, r.title, r.author, record);
         size ++;
        }

       
    }

    public bst(){
        this.root = null;
    }
      
    public void insert(String keyword, FileData fd){
        Record recordToAdd = new Record(fd.id, fd.author, fd.title, null);
        //TODO Write a recursive insertion that adds recordToAdd to the list of records for the node associated
        //with keyword. If there is no node, this code should add the node.
        if(contains(keyword)){
            insertHelper1(root, keyword, recordToAdd);     
        } else {
            Node nodeToAdd = new Node(keyword);
            nodeToAdd.update(recordToAdd);
            if(root == null) {
               root = nodeToAdd;
            }else{
               insertHelper2(root, keyword, nodeToAdd);
           }
        }       
    }
    
    private boolean insertHelper1(Node root, String k, Record r){
         if(root == null) { //the keyword is not in this branch
            return false;
         } else if(root.keyword.equals(k)){ //insert value to given keyword
            root.update(r);
            return true;
         } else {
            if(!insertHelper1(root.l, k, r)){ //find if the keyword is in the left branch
               insertHelper1(root.r, k, r); //find if the keyword is in the right branch
            }
            return true;
         }
    }
    
    private void insertHelper2(Node root,String k, Node nodeToAdd){
         if(root.keyword.compareTo(k) < 0) {
            if(root.l == null) {
               root.l = nodeToAdd;
            } else {
               insertHelper2(root.l, k, nodeToAdd);
            }
         } else {
            if(root.r == null) {
               root.r = nodeToAdd;
            } else {
               insertHelper2(root.r, k, nodeToAdd);
            }
         }    
    }
    
 
    public boolean contains(String keyword){
    	//TODO Write a recursive function which returns true if a particular keyword exists in the bst
    	return containsHelper(root, keyword);
    }
    
    private boolean containsHelper(Node root,String k){
      if(root == null) {
         return false;
      } else if(root.keyword.equals(k)){
         return true;
      } else if(!containsHelper(root.l, k)){
         return containsHelper(root.r, k);
      }
      return true;
    }
      

    public Record get_records(String keyword){
      //TODO Returns the first record for a particular keyword. This record will link to other records
    	//If the keyword is not in the bst, it should return null.
      if(!contains(keyword)){
    	   return null;
      } else {
         return get_recordsHelper(root, keyword);
      }
    }
    
    private Record get_recordsHelper(Node root, String k){
      if (root.keyword.equals(k)) {
         return root.record;
      } else {
         Record l = get_recordsHelper(root.l, k);
         if(l != null) {
            return l;
         } else {
            return get_recordsHelper(root.r, k);
         }        
      }
   }

    public void delete(String keyword){
    	//TODO Write a recursive function which removes the Node with keyword from the binary search tree.
    	//You may not use lazy deletion and if the keyword is not in the bst, the function should do nothing.
      if(contains(keyword)) {
         if(root.keyword.equals(keyword)){
            Node right = root.r;
            root = root.l;
            insertHelper2(root, right.keyword, right);
         } else{
            deleteHelper(root, keyword);
         }
      }
    } 
    
    private boolean deleteHelper(Node root, String k){
      if(root.l != null && root.l.keyword.equals(k)){
         Node right = root.l.r;
         root.l = root.l.l;
         insertHelper2(root, right.keyword, right);
         return true;
      } else if(root.l != null && root.r.keyword.equals(k)){
         Node right = root.r.r;
         root.r = root.r.l;
         insertHelper2(root, right.keyword, right);
         return true;
      } else {
         if(deleteHelper(root.l, k)) {
            return true;
         } else {
            return deleteHelper(root.r, k);
         }
      }
    
    }

    public void print(){
        print(root);
    }

    private void print(Node t){
        if (t!=null){
            print(t.l);
            System.out.println(t.keyword);
            Record r = t.record;
            while(r != null){
                System.out.printf("\t%s\n",r.title);
                r = r.next;
            }
            print(t.r);
        } 
    }
    

}
