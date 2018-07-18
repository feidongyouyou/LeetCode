package Java_LiGang;

/**
 * Created by Administrator on 2018/5/25.
 */
class Creature {
    public Creature(){
        System.out.println("Creature无参");
    }
}

class Animal extends Creature{
    public Animal(){
        System.out.println("Animal无参");
    }
    public Animal(String name){
        System.out.println("Animal一参");
    }
    public Animal(String name, int age, int weight){
        System.out.println("Animal三参");
    }
    public Animal(String name, int age){
        this();
        System.out.println("Animal两参");
    }
}

public class Wolf extends Animal{
    public Wolf(){
        super("灰太狼", 3);
        System.out.println("Wolf无参");
    }

    public static void main(String[] args) {
        new Wolf();
    }
}

