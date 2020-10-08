package BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class MainAvecTousLesTypesDeQueue {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        System.out.println( "EXEMPLE AVEC LINKEDBLOCKINGQUEUE" );
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<Integer>( 10 );
        DoIt.doIt( linkedBlockingQueue );

        System.out.println( "------------------------" );

        System.out.println( "EXEMPLE AVEC ARRAYBLOCKINGQUEUE" );
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>( 10 );
        DoIt.doIt( arrayBlockingQueue );

        System.out.println( "------------------------" );

        System.out.println( "EXEMPLE AVEC PRIORITYBLOCKINGQUEUE" );
        PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<Integer>( 10 );
        DoIt.doIt( priorityBlockingQueue );

        System.out.println( "------------------------" );
    }

}
