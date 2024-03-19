public class LinkedListDeque<T> implements Deque<T>{
    private class node{
        public T data;
        public node pre,next;

        public node(node p,T d,node n){
            data=d;
            pre=p;
            next=n;
        }

        public node(node p,node n){
            pre=p;
            next=n;
        }
    }
    
    private int size;
    private node pointer;
    
    public LinkedListDeque(){
        /**init */
        pointer=new node(null,null);
        size=0;
        pointer.next=pointer;
        pointer.pre=pointer;
    }

    @Override
    public void addFirst(T item){
        node tep=new node(pointer,item,pointer.next);
        pointer.next.pre=tep;
        pointer.next=tep;
        size++;
    }
    @Override
    public void addLast(T item){
        node tep=new node(pointer.pre,item,pointer);
        pointer.pre.next=tep;
        pointer.pre=tep;
        size++;
    }
    @Override
    public boolean isEmpty(){
        if(size>0) return false;
        else return true;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void printDeque(){
        node p=pointer;
        while(p.next!=pointer){
            p=p.next;
            System.out.print(p.data+" ");
        }
    }
    @Override
    public T removeFirst(){
        if(pointer.next==pointer) return null;
        node tep=pointer.next;
        pointer.next=tep.next;
        tep.next.pre=pointer;
        size--;
        return tep.data;
    }
    @Override
    public T removeLast(){
        if(pointer.pre==pointer) return null;
        node tep=pointer.pre;
        pointer.pre=tep.pre;
        tep.pre.next=pointer;
        size--;
        return tep.data;
    }
    @Override
    public T get(int index){
        if(index>=size) return null;
        node p=pointer;
        for(int i=0;i<=index;i++){
            p=p.next;
        }
        return p.data;
    }

    private T getRecuriveHelp(node n,int index){
        if(index==0) return n.data;
        else return getRecuriveHelp(n.next, index-1);
    }

    public T getRecursive(int index){
        if(index>=size) return null;
        return getRecuriveHelp(pointer.next, index);
    }
}
