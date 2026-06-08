class SleepThread1 extends Thread {
    public void run() {
        try {
            System.out.println("Thread running: " + Thread.currentThread().getName());
            Thread.sleep(5000); // 5 sec sleep
            System.out.println("Thread woke up after 5 seconds");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        SleepThread1 t = new SleepThread1();
        t.setName("MyThread-1"); // change name
        t.start();
    }
}