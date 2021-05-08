/*
Link: https://medium.com/@p.osinaga/using-observer-pattern-in-java-2fb6621bc0ce
*/
public abstract class Observer {
    protected Subject subject;
    public void notify();
}

public class Subject {
    List<Observer> observers;
    private String state;

    public Subject(String state) {
        observers = new ArrayList<Observer>();
        setState(state);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setState(String state) {
        this.state = state;
        for (Observer ob : observers) {
            ob.notify();
        }
    }
}

public class LengthObserver extends Observer {
    public LengthObserver(Subject sub) {
        this.subject = sub;
        this.subject.addObserver(this);
    }

    public void notify() {
        return this.state.length();
    }
}

public class CountDigitsObserver extends Observer {
    public CounterDIgitsObserver(Subject sub) {
        this.subject = sub;
        this.subject.addObserver(this);
    }

    public void notify() {
        int cnt = 0;
        for (Char ch : state) {
            if (isDigits(ch)) {
                cnt++;
            }
        }
        return cnt;
    }
}


public class Main {

    public static void main(String args[]) {
        Subject sub = new Subject("Initial text");
        new LengthObserver(sub);
        new COuntDigitsObserver(sub);
        sub.setState("1. This is after change state 2");
        sub.setState("");
    }
}
