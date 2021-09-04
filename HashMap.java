class MyHashMap {
    
     class Node{
        int value;
        int key;
        Node next;
        public Node(int key,int value){
            this.value=value;
            this.key=key;
        }
    }

    Node [] nodes;
    int buckets;


    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets=10000;
        nodes= new Node[buckets];

    }
    private int index(int key){
        return Integer.hashCode(key)%buckets;
    }


    private Node find(Node head,int key){
        Node prev=head;
        Node cur=head.next;
        while(cur!=null && cur.key!=key){
            prev=cur;
            cur=cur.next;
        }
        return prev;
    }
    
  /** value will always be non-negative. */
    public void put(int key, int value) {
        int index=index(key);
        if (nodes[index]== null) {
            nodes[index] = new Node(-1,-1);
        }
        Node prev= find(nodes[index], key);
        if (prev.next==null){
            prev.next= new Node(key,value);
        }else{
            prev.next.value=value;
        }

    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = index (key);
        if (nodes[index] == null){
            return -1;
        }
        Node prev = find (nodes [index], key);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.value; 
    }
    
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        
        int index = index (key);
        
        if (null == nodes [index]) {
            return;
        }
       Node prev = find (nodes[index], key);
      if (null == prev.next) return;
       prev.next = prev.next.next;
        
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
