class Foo {
    private int count = 1;
    public Foo() {
        
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        count++;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        
        while(count<2){
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        count++;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        
        while(count<3){
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
