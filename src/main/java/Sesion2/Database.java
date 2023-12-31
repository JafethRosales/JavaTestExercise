package Sesion2;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Database {

    private List<Product> db;

    public Database(){
        db = new LinkedList<>();
    }

    public void insert(Product data) {
        db.add(data);
    }

    public int size() {
        return db.size();
    }

    public Product getById(long id) {
        for (Product product : db) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    public void clear() {
        db.clear();
    }

    public void renameById(long id, String newName){
        for (Product product : db) {
            if (product.getId() == id) {
                product.setName(newName);
            }
        }
    }

    public boolean deleteById(long id) {
        for (Product product : db) {
            if (product.getId() == id) {
                return db.remove(product);
            }
        }
        return false;
    }
 }