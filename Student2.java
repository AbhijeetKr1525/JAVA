 class Student2 {
    int id;
    String name;

    Student2(int i, String n){
        id=i;
        name=n;
    }

    void display(){
        System.out.println("ID:"+id+ "name:"+ name);
    }
    
    public static void main(String[] args) {
         Student2 obj1 = new Student2(101, "Rahul");
        Student2 obj2 = new Student2(102, "Priya");

        obj1.display();
        obj2.display();

    }
}
