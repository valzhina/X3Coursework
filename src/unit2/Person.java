package unit2;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) { //This feature is known as overloading.
        setName(name);
        setAge(age);
    }

    public Person() {
        this("JohnDoe", 99);
    }

    //    ======================================
//    CONSTRUCTOR
    public String getName() { return name;}
    public int getAge() { return age;}

    public void setName(String name) { this.name = name;}

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
        else{
            System.out.println("Invalid integer for age: must be 0 or greater");
        }
    }

    public void introduce(){
        System.out.println("Hi, my name is " + getName() + ".");
    }

    @Override
    public String toString() {
        return "{ name = " + this.name + ", \n" +
                "age = " + this.age + "\n" +
                "}\n";

    }

    public boolean equals(Person otherPerson) {
        if (this.name.equals(otherPerson.name) && this.age == otherPerson.age) {
            return true;
        } else {
            return false;
        }
    }
}

class Student extends Person {
    private char grade;

    public Student() {
        this("Student", 12,'B');
    }

    public Student(String name, int age) {
        super(name, age);
        this.grade = grade;
    }

    public Student(String name, int age, char grade) {
        super(name, age);
        this.grade = grade;
    }

    public char getGrade(){
        return grade;
    }

    public void setGrade(char grade) {


        Character.toUpperCase(grade);
        if (grade == 'A' || grade == 'B' || grade == 'C' || grade == 'D') {
            this.grade = grade;
        }
        else{
            System.out.println("Invalid char for grade: one of four allowed chars");
        }
    }
}


class Teacher extends Person {
    private int salary;

    public Teacher() {
        this("Teacher", 47,120000);
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }


    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary) {
        if (salary >= 150000) {
            this.salary = salary;
        }
        else{
            System.out.println("Invalid int for salary: should be higher or equal 150K");
        }
    }
    public void introduce(){
        System.out.println("Hello, I'm Professor " + getName() + ".");
    }
    public void introduce(String otherName){
        System.out.println("Nice to meet you, " + otherName + "! I'm Professor " + getName() + ".");
    }
}

