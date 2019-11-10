import org.junit.Test;
import static org.junit.Assert.*;

class StatementTest {
    @Test
    public void testStatement() {
        Customer jobson = new Customer("Jobson");

        Movie interstellar_movie  = new Movie("Interstellar", 0);
        Movie elTopo_movie = new Movie("El Topo", 1);
        Movie drive_movie     = new Movie("Drive", 2);

        Rental interstellar_rental  = new Rental(interstellar_movie, 2);
        Rental elTopo_rental = new Rental(elTopo_movie, 3);
        Rental drive_rental     = new Rental(drive_movie, 1);

        assertEquals(jobson.statement()
                     , "Rental Record for Jobson\n"
                     + "Amount owed is 0.0\n"
                     + "You earned 0 frequent renter points");

        jobson.addRental(drive_rental);
        assertEquals(jobson.statement()
                     , "Rental Record for Jobson\n"
                     + "\tdDrive\t1.5\n"
                     + "Amount owed is 1.5\n"
                     + "You earned 1 frequent renter points");

        jobson.addRental(interstellar_rental);
        assertEquals(jobson.statement()
                     , "Rental Record for Jobson\n"
                     + "\tDrive\t1.5\n"
                     + "\tInterstellar\t2.0\n"
                     + "Amount owed is 3.5\n"
                     + "You earned 2 frequent renter points");

        jobson.addRental(elTopo_rental);
        assertEquals(jobson.statement()
                     , "Rental Record for Jobson\n"
                     + "\tDrive\t1.5\n"
                     + "\tInterstellar\t2.0\n"
                     + "\tEl Topo\t9.0\n"
                     + "Amount owed is 12.5\n"
                     + "You earned 4 frequent renter points");
    }   
}