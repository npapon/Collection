package transferQueue;

import java.util.concurrent.LinkedTransferQueue;

public class MainTest3 {

    public static void main( String[] args ) {
        LinkedTransferQueue<String> linkedTransferQueue = new LinkedTransferQueue<String>();

        ProducteurTest producteurTest = new ProducteurTest( linkedTransferQueue, 2 );
        producteurTest.start();

        try {
            Thread.sleep( 2000 );
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println( linkedTransferQueue );
        try {
            Thread.sleep( 2000 );
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println( linkedTransferQueue );

    }

}
