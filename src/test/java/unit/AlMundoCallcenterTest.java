package unit;

import core.Dispatcher;
import org.junit.Test;
import utils.Global;

import java.util.concurrent.TimeUnit;

public class AlMundoCallcenterTest {

    @Test
    public void GetBEQPLimit_ReturnOK() throws Exception {
        synchronized (Global.EXECUTOR) {
            for(int i = 0; i<15; i++) {
                Dispatcher.getInstance().dispatchCall();
                Thread.sleep(100); //Wait for log to write
            }
        }

        Global.EXECUTOR.shutdown();
        Global.EXECUTOR.awaitTermination(50, TimeUnit.SECONDS);
    }
}
