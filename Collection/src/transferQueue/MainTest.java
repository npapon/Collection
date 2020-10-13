package transferQueue;

import java.util.concurrent.LinkedTransferQueue;

public class MainTest {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        LinkedTransferQueue<String> linkedTransferQueue = new LinkedTransferQueue<String>();

        System.out.println( "Debut du transfert dans la queue" );

        try {
            linkedTransferQueue.transfer( "Nicolas" );
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println( "fin du transfert" );
    }

}
