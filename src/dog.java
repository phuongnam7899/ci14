public class dog extends animal {
    String country;

    public dog(String name,int age,String country ){
        this.name = name;
        this.age =age;
        this.country = country;
    }

    @Override
    void run() {
        super.run(); //animal.run()
        //System.out.println("...");
    }
}
