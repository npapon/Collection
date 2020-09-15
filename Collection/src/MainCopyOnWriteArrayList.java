import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class MainCopyOnWriteArrayList {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        List<String> famille = new CopyOnWriteArrayList<String>();
        famille.add( "Leslie" );
        famille.add( "Nicolas" );
        famille.add( "Valentine" );
        famille.add( "Sasha" );

        Iterator iterator = famille.iterator();

        while ( iterator.hasNext() ) {
            famille.add( "chenu" );
            System.out.println( iterator.next() );
        }

        System.out.println( "Lecture après ajout" );
        iterator = famille.iterator();

        while ( iterator.hasNext() ) {

            System.out.println( iterator.next() );
        }

    }

}
