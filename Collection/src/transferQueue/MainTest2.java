package transferQueue;

import java.util.concurrent.LinkedTransferQueue;

public class MainTest2 {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        LinkedTransferQueue<String> linkedTransferQueue = new LinkedTransferQueue<String>();

        ProducteurTest producteurTest = new ProducteurTest( linkedTransferQueue, 1 );

        System.out.println( "Debut du transfert dans la queue" );
        producteurTest.start();
        try {
            Thread.sleep( 3000 );
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println( "fin du sleep" );

        System.out.println( linkedTransferQueue );

        System.out.println( "fin du transfert" );

        try {
            linkedTransferQueue.take();
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println( linkedTransferQueue );

        linkedTransferQueue.offer( "Leslie" );
        linkedTransferQueue.offer( "Valentine" );

        System.out.println( linkedTransferQueue );

    }

}
