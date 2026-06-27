public class abstractExample {
    public void main(String[] args){
        
    }
}

abstract class Menu{
    public String name;

    public double price;

    public boolean is_vegetarian;

    public abstract double calculate();

    public abstract void displayDescription();


}

class mainCourses extends Menu{

    boolean is_spicy;

    int size;

    @Override
    public double calculate(){
        double result = super.price * size;
        return result; // Just for example
    }

    @Override
    public void displayDescription(){
        System.out.println(super.name);
    }


}

class Desserts extends Menu{
    
    String allergyWarning;

    int sweetLevel;
    
    @Override
    public double calculate(){
        double result = super.price * sweetLevel;
        return result; // Just for example
    }

    @Override
    public void displayDescription(){
        System.out.println(super.name);// Just for example
    }

}

