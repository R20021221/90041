import java.util.*;

class parity<K, V>{



}


class Storage<T>{

    private ArrayList<T> List = new ArrayList<>();
     
    public void addItem(T item){
        List.add(item);
    }
    
    public void indexItem(){
        for(T item: List){
            System.out.println(item);
        }
    }
}

public class genericsExample{
    public static void main(String[] args){
        
        Storage<Double> MarkStorage = new Storage<>();
        Storage<String> FruitStorage = new Storage<>();

        FruitStorage.addItem(1，"Apple");
        FruitStorage.addItem("Banana");

        FruitStorage.indexItem();

        MarkStorage.addItem(85.0);
        MarkStorage.addItem(30.5);

        MarkStorage.indexItem();

    }
}