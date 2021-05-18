/** 
Pattern name: Decorator Design Pattern
Idea from:  https://medium.com/deciphering-deadlocks/what-is-decorator-design-pattern-in-java-21283d7f7c1e
**/

public abstract class Pizza {
    String description = "Basic Pizza";

    public String getDescription() {
        return description;
    }

    public Double getCost();
}

public class ThickCrustPizza extends Pizza {
    public ThickCrustPizza() {
        description = "Thick crust Pizza, with tomato sauce";
    }

    public Double getCost() {
        return 8.00;    // base cost of a Thick Crust Pizza
    }
}

public class ThinCrustPizza extends Pizza {
    public ThinCrustPizza() {
        description = "Thin crust Pizza, with tomato sauce";
    }

    public Double getCost() {
        return 7.50;    // base cost of a Thin Crust Pizza
    }
}

public abstract class ToppingsDecorator extends Pizza {
    Pizza Pizza;
    public abstract String getDescription();
}

public class Cheese extends ToppingsDecorator {
    public Cheese(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return this.pizza.getDescription() + ", " + "cheese";
    }
    
    public Double getCost() {
        return this.pizza.getCost() + 0.50;
    }
}

public class Olives extends ToppingsDecorator {
    public Olives(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription() + ", olives";
    }

    public Double getCost() {
        return pizza.getCost() + 0.25;
    }
}


// call Pizza from main

public class PizzaStore {
    public static void main(String args[]) {
        Pizza pizza = new ThinCrustPizza();
        Pizza cheesePizza = new Cheese(pizza);
        Pizza cheesedOlivePizza = new Olives(cheesePizza);

        System.out.println("CheeseOlivePizza: Description: " + getDescription());
        System.out.println("CheeseOlivePizza: Cost: " + cheesedOlivePizza.getCost());
    }
}