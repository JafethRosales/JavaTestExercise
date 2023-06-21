package Sesion2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DatabaseTest {

    //Arrange
    private Database db;

    @BeforeEach
    public void setup(){
        db = new Database();
    }

    @Test
    @DisplayName("Database's size is 0")
    public void sizeZero(){
        assertEquals(db.size(), 0);
    }

    @Test
    @DisplayName("Database data insertion")
    public void insert(){
        db.insert(new Product(1, "Coca 3gr"));
        db.insert(new Product(2, "gansito"));

        assertEquals(db.size(), 2);
    }

    @Test
    @DisplayName("Search by ID")
    public void  findById(){
        db.insert(new Product(1, "coca 3gr"));
        db.insert(new Product(2, "gansito"));
        db.insert(new Product(3, "mordisko"));
        db.insert(new Product(4, "sabritones"));

        Product p = db.getById(4);

        assertEquals(p.getId(), 4);
        assertEquals(p.getName(), "sabritones");
    }

    @Test
    @DisplayName("Database can be cleared")
    public void clear() {
        db.insert(new Product(1, "Coca Cola 3lt"));
        db.insert(new Product(2, "Gansito"));
        db.insert(new Product(3, "Mordisko"));
        db.insert(new Product(4, "Sabritas 30g"));

        assertEquals(db.size(), 4);

        db.clear();

        assertEquals(db.size(), 0);
    }

    @Test
    @DisplayName("Database can change name")
    public void changeName() {
        db.insert(new Product(1, "Coca Cola 3lt"));
        db.insert(new Product(2, "Gansito"));
        db.insert(new Product(3, "Mordisko"));
        db.insert(new Product(4, "Sabritas 30g"));

        db.renameById(1, "Coca 3gr");

        assertEquals(db.getById(1).getName(), "Coca 3gr");
    }

    @Test
    @DisplayName("Delete product by id")
    public void deleteById() {
        db.insert(new Product(1, "Coca Cola 3lt"));
        db.insert(new Product(2, "Gansito"));
        db.insert(new Product(3, "Mordisko"));

        boolean deleted = db.deleteById(1);

        assertTrue(deleted);
        assertEquals(db.size(), 2);
    }

}
