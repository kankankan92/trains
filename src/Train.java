public class Train {
    private String name = " ";
    Wagon first = null;

    @Override
    public String toString(){
        String str = "//[]+++[]]-";
        Wagon cur = first;
        while(cur != null){
            str += cur.toString();
            cur = cur.next;   // здесь застревали навсегда в бесконечном цикле, т.к. не перемещал указаатель
        }
        return str;
    }

    public void add(Wagon wagon){
        if(first==null){
            first=wagon;
        }else{
            Wagon current=first;
            while (current.next!=null){
                current=current.next;
            }
            current.next=wagon;
            wagon.prev=current;
        }
    }

    public Wagon remove(){
        if(first==null){
            return null;
        }else{
            if(first.next==null){
                Wagon wagon=first;
                first=null;
                return wagon;
            }else{
                Wagon current=first;
                while (current.next!=null){
                    current=current.next;
                }
                current.prev.next=null;
                current.prev=null;
                return current;
            }
        }
    }
}
