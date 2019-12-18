//package Strategy_Pattern;
//
//import java.util.ArrayList;
//
//class Duck {
//    FlyBehavior flyBehavior;
//    QuackBehavior quackBehavior;
//    
//    void performFly() {
//        flyBehavior.fly();
//    }
//    void performQuack() {
//        quackBehavior.quack();
//    }
//    void swim() {
//        System.out.println("swimming");
//    }
//    void display() {
//        System.out.println("Duck");
//    }
//    void setQuackBehavior(QuackBehavior q) {
//        quackBehavior = q;
//    }
//    void setFlyBehavior(FlyBehavior f) {
//        flyBehavior = f;
//    }
//}
//
//interface FlyBehavior {
//    void fly();
//}
//
//interface QuackBehavior {
//    void quack();
//}
//
//class MallardDuck extends Duck {
//    MallardDuck() {
//        setFlyBehavior(new FlyWithWings());
//        setQuackBehavior(new Quack());
//    }
//    void display() {
//        System.out.println("MallardDuck");
//    }
//}
//class RedheadDuck extends Duck {
//    RedheadDuck() {
//        setFlyBehavior(new FlyWithWings());
//        setQuackBehavior(new Quack());
//    }
//    void display() {
//        System.out.println("RedheadDuck");
//    }
//}
//
//class RubberDuck extends Duck  {
//    RubberDuck() {
//        setFlyBehavior(new FlyNoWay());
//        setQuackBehavior(new Squeak());
//    }
//    public void display() {
//        System.out.println("RubberDuck");
//    }
//    
//    //public void fly() {
////        System.out.println("cannot fly");
////    }
//}
//
//class Quack implements QuackBehavior {
//    public void quack() {
//        System.out.println("quack");
//    }
//}
//
//class MuteQuack implements QuackBehavior {
//    public void quack() {
////        System.out.println("");
//    }
//}
//
//class Squeak implements QuackBehavior {
//    public void quack() {
////        System.out.println("squeak");
//    }
//}
//
//class FlyWithWings implements FlyBehavior {
//    public void fly() {
//        System.out.println("flying");
//    }
//}
//
//class FlyNoWay implements FlyBehavior {
//    public void fly() {
//        System.out.println("cannot fly");
//    }
//}
//
//public class MainDuck {
//    public void doDuck(Duck d) {
//        d.display();
//        d.performFly();
//        d.swim();
//        d.performQuack();
//    }
//
//    public static void main(String[] args) {
// 
//        ArrayList<Duck> list = new ArrayList<>();
////        list.add(new Duck());
//        list.add(new MallardDuck());
//        list.add(new RedheadDuck());
//        list.add(new RubberDuck());
//		MainDuck dv3 = new MainDuck();
//        for (Duck duck : list) {
//            dv3.doDuck(duck);
//        }
//
//
//    }
//}
