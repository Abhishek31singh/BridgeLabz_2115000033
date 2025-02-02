class Person{
    int num;
    Person(){
        this.num = 10;
        System.out.println("Default Constructor Called");
    }
    Person(Person ref){
        this.num = ref.num;
        System.out.println("Copy Constructor Called");
    }
    public void display(){
        System.out.println(num);
    }
}
public class CopyConstructor {
    public static void main(String[] args) {
        Person org = new Person();
        org.display();
        System.out.println("-----------------");
        Person copied = new Person(org);
        copied.display();
        
    }
}
