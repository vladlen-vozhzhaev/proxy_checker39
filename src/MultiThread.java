public class MultiThread {
    public static void main(String[] args) {
        /*MyThread thread1 = new MyThread();
        thread1.task = "МЫть посуду";
        MyThread thread2  = new MyThread();
        thread2.task = "Стирать белье";
        MyThread thread3 = new MyThread();
        thread3.task = "Пылесосить";
        thread1.start();
        thread2.start();
        thread3.start();*/
        /*Thread thread1 = new Thread(new MyRunnableClass("МЫть посуду"));
        Thread thread2 = new Thread(new MyRunnableClass("Стирать белье"));
        Thread thread3 = new Thread(new MyRunnableClass("Пылесосить"));
        thread1.start();
        thread2.start();
        thread3.start();*/
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Мыть посуду - выполнен на "+i+"%");
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Стирать белье - выполнен на "+i+"%");
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Пылесосить - выполнен на "+i+"%");
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class MyRunnableClass implements Runnable{
    String task;

    public MyRunnableClass(String task) {
        this.task = task;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(task + " - выполнен на "+i+"%");
        }
    }
}
class MyThread extends Thread{
    String task;
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(task + " - выполнен на "+i+"%");
        }
    }
}
