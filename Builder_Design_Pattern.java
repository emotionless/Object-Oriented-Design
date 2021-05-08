/*
Link: https://medium.com/@ajinkyabadve/builder-design-patterns-in-java-1ffb12648850
*/
public class Person {
    private String firstName;
    private String MiddleName;
    private String lastName;
    private int age;
    ...

    public Person(String firstName, String middleName, String lastName, int age, String fathersName, String mothersName, Double height, Double weight) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.height = height;
        this.weight = weight;
    }
    public static class Builder {
        private String firstName;
        private String middleName;
        private String lastName;
        private int age;
        private String fathersName;
        private String mothersName;
        private double height;
        private double weight;

        public Builder() {}

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder setMiddleName(String middleName) {
            this.middleName = middelName;
            return this;
        }
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        ...

        public Person build() {
            return new Person(firstName, middleName, lastName, age, fathersName, mothersName, height, weight);
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Person person = new Person.Builder()
                        .setFirstName("Faruk")
                        .setMiddleName("Hossain")
                        .setLastName("Milon")
                        .setAge(30)
                        .setHeight(5.8)
                        .build();
        System.out.println(person.getAge());
    }
}
