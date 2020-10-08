package BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        BlockingQueue<Integer> prioriteQueue = new ArrayBlockingQueue<Integer>( 20 );
        long timeOut = 2;
        TimeUnit uniteDeTemps = TimeUnit.SECONDS;

        SampleThread sampleThread = new SampleThread( uniteDeTemps, 2, prioriteQueue );
        sampleThread.start();

        try {
            sampleThread.join();
        } catch ( InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.print( prioriteQueue );
    }

}
