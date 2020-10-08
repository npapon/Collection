package BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MainTest {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>( 1 );
        try {
            blockingQueue.offer( 10 );
            blockingQueue.offer( 11, 3L, TimeUnit.SECONDS );
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println( blockingQueue );

        BlockingQueue<Integer> blockingQueue2 = new LinkedBlockingQueue<Integer>( 1 );

        try {
            blockingQueue2.put( 1 );
            blockingQueue2.put( 2 );
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println( blockingQueue2 );

    }

}
