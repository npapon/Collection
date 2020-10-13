package transferQueue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

public class ProducteurTest
        extends Thread {

    private LinkedTransferQueue<String> linkedTransferQueue;
    private int                         modeDeTransfert;

    public ProducteurTest( LinkedTransferQueue<String> linkedTransferQueue, int modeDeTransfert ) {
        this.linkedTransferQueue = linkedTransferQueue;
        this.modeDeTransfert = modeDeTransfert;

    }

    public void run() {
        if ( modeDeTransfert == 1 ) {

            try {
                System.out.println( "transfer" );
                linkedTransferQueue.transfer( "Nicolas" );
            } catch ( InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            try {
                System.out.println( "trytransfer" );
                linkedTransferQueue.tryTransfer( "Sasha", 3000, TimeUnit.MILLISECONDS );

            } catch ( InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

}
