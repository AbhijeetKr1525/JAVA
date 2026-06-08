 class Student {
    String name;
    String city;
    int age;

    void printdata(){
        System.out.println("Nmae:" + name);
        System.out.println("City" + city);
        System.out.println("age" +age);


    }
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        
        s1.name ="Abhijeet";
        s1.city = "Bihar";
        s1.age =20;
        
        s2.name ="Ayush";
        s2.city ="Delhi";
        s2.age =19;

        s1.printdata();
        s2.printdata();


    }
}

