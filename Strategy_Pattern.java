/*
Link: https://medium.com/free-code-camp/the-strategy-pattern-explained-using-java-bc30542204e0
*/

public interface EatBehabior {
    public void eat();
}

public interface BarkBehavior {
    public void bark();
}

public class PlayfulBark implements BarkBehavior {
    @override
    public void bark() {
        System.out.println("Bark! Bark!");
    }
}

public class MuteBark implements BarkBehavior {
    @override
    public void bark() {
        System.out.println("This is mute bark");
    }
}

public class NormalEat implements EatBehabior {
    @override
    public void eat() {
        System.out.println("Normal Eat and be fatty");
    }
}

public class DietEat implements EatBehabior {
    @override
    public void eat() {
        System.out.println("Diet eat and good");
    }
}

public class Dog {
    EatBehavior eatBehavior;
    BarkBehavior barkBehavior;

    public Dog () {}

    public void doBark() {
        barkBehavior.bark();
    }

    public void doEat() {
        eatBehavior.eat();
    }
}

public class Labrador extends Dog {
    public Labrador() {
        eatBehavior = new NormalEat();
        barkBehavior = new PlayfulBark();
    }
    public void setEatBehavior(EatBehavior eb) {
        eatBehavior = eb;
    }
    public void setBarkBehavior(BarkBehavior bb) {
        barkBehavior = bb;
    }
    public void DisplayMessage() {
        System.out.println("This is normal message");
    }
}


public class DogSimulatorApp {
    public static void main(String[] args) {
        Dog lab = new Labrador();
        lab.doEat(); // Normal Eat and be fatty
        lab.setEatBehavior(new DietEat());
        lab.doEat(); // Diet eat and good
        lab.doBark(); // Bark! Bark!
    }
}

