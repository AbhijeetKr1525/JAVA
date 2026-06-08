class Student {

    int rollNo;
    String name;

    static String college = "ABC College";  
    Student(int r, String n) {
        rollNo = r;
        name = n;
    }

    
    static void changeCollege() {
        college = "XYZ College";
    }

    void display() {
        System.out.println(rollNo + " " + name + " " + college);
    }
}

public class StaticExample {
    public static void main(String[] args) {

        
        Student.changeCollege();

        Student s1 = new Student(1, "Rahul");
        Student s2 = new Student(2, "Priya");

        s1.display();
        s2.display();
    }
}
