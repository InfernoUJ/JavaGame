package viewmodel;

import java.util.function.Consumer;

public class Mover<T> extends Thread{

    /*
        my bicycle
    */
    private boolean isStopped = false;
    private final T argument;
    // TODO: rewrite on Runnable, not Consumer
    private final Consumer<T> action;

    public Mover(Consumer<T> action, T argument){
        this.action = action;
        this.argument = argument;
    }

    public void stopWork(){
        //System.out.println("    Stopping " + argument);
        isStopped = true;
    }

    public void run(){
        while (true){
            //System.out.println("    Running " + argument);
            if(!isStopped){
                action.accept(argument);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void resumeWork() {
        //System.out.println("    Resuming " + argument);
        isStopped = false;
    }
}
