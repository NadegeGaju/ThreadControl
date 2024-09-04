package org.example;

class InterruptibleTask implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Running...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted!");
        }
    }
}

class ThreadInterruptionExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptibleTask());
        thread.start();

        Thread.sleep(3000); // Let the thread run for a while
        thread.interrupt(); // Interrupt the thread
    }
}



