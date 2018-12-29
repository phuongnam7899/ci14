public class animal {
    // attributes
    String name;
    int age;

    public animal(){

    }
    public animal(String name, int age){
        this.name = name;
        this.age = age;

    }



    //methods
    void run(){
        System.out.println(this.name + " is running");
    }

    void eat(){
        System.out.println(this.name + " is eating");
    }
}
