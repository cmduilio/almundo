package core;

import entities.Employee;
import utils.Global;

public class Dispatcher {
    private static Dispatcher dispatcher = new Dispatcher();

    private Dispatcher() {}

    public static Dispatcher getInstance(){
        return dispatcher;
    }

    public void dispatchCall(){
        Global.EXECUTOR.submit(()->{
            System.out.println("\n--> Calling dispatchCall\n");
            Employee employee = Callcenter.getInstance().getNext();

            if(employee == null){
                System.out.println("\n- Sorry! No employee is available, try next time!\n");
                return;
            }

            try {
                Global.CALLS++;
                System.out.println("We now have " + Global.CALLS + " calls at the same time.");
                System.out.printf("\n- Hi! I'm %s and i'm %s what's your question?\n\n", employee.getName(), employee.getClass().getSimpleName());

                waitEndingCall();
            }catch (InterruptedException ex){
                System.out.println("Interrupted Exception");
            }finally {
                Callcenter.getInstance().add(employee);
                Global.CALLS--;
                System.out.println("We now have " + Global.CALLS + " calls at the same time.");
            }

            System.out.println("\n<-- Call ended\n");
        });
    }

    private void waitEndingCall() throws InterruptedException {
        long seconds = (long) ((Math.random()*6)+5); //get random between 5 and 10
        Thread.sleep(seconds * 1000); // sleeps x seconds, can only be 5 or 10
    }
}
