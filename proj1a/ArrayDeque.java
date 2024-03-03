public class ArrayDeque<T> {
    private class arry_circle {
        T[] a = (T[]) new Object[8];
        int head=0;
        int tail=1;
        int len=8;
        
        private int addIndex(int index,int step){
            return (index+step)%len;
        }
        
        private int minusIndex(int index,int step){
            int move=index-step;
            while(move<0) move+=len;
            return move;
        }

        public int moveIndex(int index,int step){
            if(step>=0) return addIndex(index, step);
            else return minusIndex(index,-step);
        }
        public int moveIndex(int index){
            int step=1;
            if(step>=0) return addIndex(index, step);
            else return minusIndex(index,-step);
        }

        public void grow(){
            T[] newA = (T[]) new Object[len*2];
            int newHead=0,newTail=1;
            for(int i=moveIndex(head);i!=tail;i=moveIndex(i)){
                newA[newTail]=a[i];
                newTail++;
            }
            head=newHead;
            tail=newTail;
            len*=2;
        }

        public void shrink(){
            if(len==8) return;
            T[] newA = (T[]) new Object[len/2];
            int newHead=0,newTail=1;
            for(int i=moveIndex(head);i!=tail;i=moveIndex(i)){
                newA[newTail]=a[i];
                newTail++;
            }
            head=newHead;
            tail=newTail;
            len/=2;
        }
    }

    private arry_circle a;

    public ArrayDeque(){
        a=new arry_circle();
    }

    public void addFirst(T item){
        if(a.moveIndex(a.head,-1)==a.tail)
            a.grow();
        a.a[a.head]=item;
        a.head=a.moveIndex(a.head,-1);
    }

    public void addLast(T item){
        if(a.moveIndex(a.tail,1)==a.head)
            a.grow();
        a.a[a.tail]=item;
        a.tail=a.moveIndex(a.tail,1);
    }

    public boolean isEmpty(){
        return a.moveIndex(a.head)==a.tail;
    }

    public int size(){
        int len=a.tail-a.head;
        while (len<0) len+=a.len;
        return len-1;
    }

    public void printDeque(){
        for(int i=a.moveIndex(a.head);i!=a.tail;i=a.moveIndex(i))
            System.out.print(a.a[i]+" ");
    }

    public T removeFirst(){
        if(isEmpty()) return null;
        a.head=a.moveIndex(a.head);
        T tep=a.a[a.head];
        if(size()+2<=a.len/2) a.shrink();
        return tep;
    }

    public T removeLast(){
        if(isEmpty()) return null;
        a.tail=a.moveIndex(a.tail,-1);
        T tep=a.a[a.tail];
        if(size()+2<=a.len/2) a.shrink();
        return tep;
    }

    public T get(int index){
        if(index>=size()) return null;
        return a.a[a.moveIndex(a.head,index+1)];
    }
}
