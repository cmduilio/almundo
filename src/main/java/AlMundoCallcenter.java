import core.Dispatcher;
import utils.Global;

import java.util.concurrent.TimeUnit;

public class AlMundoCallcenter {
    public static void main(String[] args){
        if(args.length > 0){
            textBasedCallcenter();
        }else{
            make10Calls();
        }
    }

    private static void textBasedCallcenter(){
        String input;
        char option = ' ';
        System.out.println("Hello!\nThis is almundo's callcenter, what can i help you with?");
        while (option != Global.QUIT) {
            System.out.println("To make a call press c");
            System.out.println("To quit press q");
            System.out.println("So... what do you choose?");

            input = Global.SCANNER.nextLine();

            if (input.length() == 1){
                option = input.toLowerCase().charAt(0);
            }

            switch (option){
                case Global.CALL:
                    Dispatcher.getInstance().dispatchCall();
                    break;
                case Global.QUIT:
                    System.out.println("Ok!");
                    break;
                default:
                    System.out.println("Come on man, choose one of the above!");
                    break;
            }
        }

        System.out.println("Thank you for calling almundo's callcenter service, have a nice day! :)");
        System.exit(0);
    }

    private static void make10Calls(){
        synchronized (Global.EXECUTOR) {
            for(int i = 0; i<10; i++) {
                Dispatcher.getInstance().dispatchCall();
                try {
                    Thread.sleep(100); //Wait for log to write
                }catch (InterruptedException ex){

                }
            }
        }

        Global.EXECUTOR.shutdown();
        try {
            Global.EXECUTOR.awaitTermination(50, TimeUnit.SECONDS);
        }catch (InterruptedException ex){

        }
    }
}
