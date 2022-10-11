public class Persona {
    public String name;
    public int age;

    public Persona() {
        this.name = "John";
        this.age = 31;
    }

    public Persona(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return name + ", " + age;
    }

    public boolean equals(Persona otherPersona){
        if (this.name.equals(otherPersona.name) && this.age == otherPersona.age){
            return true;
        }
        else{
            return false;
        }
    }
}
