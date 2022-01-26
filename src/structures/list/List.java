package structures.list;


public class List<E> {
    
    private Node<E> first; 
    private Node<E> last;
    private Node<E> pos;

    public List() {
        first = null;
        last = null;
    }

    public void put (E value){
        if (first == null){
            first = new Node<E>(value, null);
            last = first;
        }else{
            Node<E> newList = new Node<E>(value, null);
            last.setNext(newList);
            last = newList;
        }
    }
    
    /*public void putInOrder(E value) {
    	Node<K, E> prev = null;
    	Node<K, E> data = first;
    	
        while (data != null && key.compareTo(data.getKey()) > 0){
        	prev = data;
        	data = data.getNext();
        	
        }
        
        if (data != null && key.compareTo(data.getKey()) == 0) {
        	data.setValue(value);
        	return;
        }
        
        if (prev != null) {
        	Node<K, E> newList = new Node<K, E>(key, value, data);

            prev.setNext(newList);
            if (newList.getNext() == null) {
            	last = newList;            	
            }
        } else {            	
        	first = new Node<K, E>(key, value, data);
            if (first.getNext() == null) {
            	last = first;
            }
    	}
    }*/
    
    public E delete (E value){
        //E value = null;

        if (first != null){
        	Node<E> prev = null;
        	Node<E> data = first;
        	
            while (data != null && !data.getValue().equals(value)){
            	prev = data;
            	data = data.getNext();
            }
            
            if (data.getValue().equals(value)) {
            	
            	value = data.getValue();
                
            	if (prev != null) {
            		if (last == data) 
            			last = prev;
            		prev.setNext(data.getNext());
            	} else {
                	first = data.getNext();
                	if (last == data) 
                		last = first;
            	}
            }                
        }
        return value;
    }

    public E search(E value){
        Node<E> data = first;

        while(data != null){
            if (data.getValue().equals(value)){
                return data.getValue();
            }
            data = data.getNext();
        }
        
        return null;
    }

    public E listFirst ( ) {
    	this.pos = first; 
    	if (first != null)
    		return first.getValue();
    	return null;
	}
    	
    public E listNext ( ) {
		this.pos = this.pos.getNext();
		
		if (this.pos == null) return null ;
		else return this.pos.getValue();
	}

    public void imprime ( ) {
    	Node<E> aux = this.first;
    	while (aux != null) {
    		System.out. println (aux.getValue().toString( )) ;
    		aux = aux.getNext(); 
    	}
	}
   
    public E first() {
    	if (first != null)
    		return first.getValue();
    	return null;
    }
    public boolean empty() {
    	if (this.first == null) {
    		return true;
    	}
    	return false;
    }

}
