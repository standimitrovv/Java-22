import Paper.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PublicationTest {

    @Test
    void getPrice() {
        Paper paper = new Paper(PaperType.NEWSPAPER, PaperSize.A2);
        Publication publication = new Publication("Random", 20, paper);
        double price = publication.getPrice();
        double expectedPrice = 100;
        assertEquals(expectedPrice, price);
    }
}