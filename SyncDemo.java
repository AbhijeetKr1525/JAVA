class Printer {
    synchronized void printJob(String job) {
        System.out.println("Printing: " + job);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
    }
}

class UserThread extends Thread {
    Printer p;
    String job;

    UserThread(Printer p, String job) {
        this.p = p;
        this.job = job;
    }

    public void run() {
        p.printJob(job);
    }
}

public class SyncDemo {
    public static void main(String[] args) {
        Printer p = new Printer();

        UserThread t1 = new UserThread(p, "Doc1");
        UserThread t2 = new UserThread(p, "Doc2");
        UserThread t3 = new UserThread(p, "Doc3");
0
        t1.start();
        t2.start();
        t3.start();
    }
}
