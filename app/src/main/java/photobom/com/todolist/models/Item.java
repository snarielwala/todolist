package photobom.com.todolist.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;

import java.io.Serializable;
import java.util.List;


/**
 * Created by snarielwala on 12/13/15.
 */

@Table(name = "Item")
public class Item extends Model implements Serializable {

    // This is a regular field
    @Column(name = "name")
    private String name;

    @Column(name = "dueDate")
    public String dueDate;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }


    // Make sure to have a default constructor for every ActiveAndroid model
    public Item(){
        super();
    }

    //old constructor
    public Item(String name){
        super();
        this.name = name;
        this.dueDate=dueDate;
    }

    public Item(String name, String dueDate){
        super();
        this.name = name;
        this.dueDate=dueDate;
    }

    //old AddItem
    public static Item addItem(String name){
        Item item = new Item(name);
        item.save();
        return item;
    }

    public static Item addItem(String name, String dueDate){
        Item item = new Item(name,dueDate);
        item.save();
        return item;
    }

    public static void updateItem(Long id, String name, String dueDate){
        new Update(Item.class)
                .set("name = ?, dueDate = ?", name, dueDate)
                .where("Id = ?", id)
                .execute();
    }

    //old updateItem
    public static void updateItem(Long id, String name){
        new Update(Item.class)
                .set("name = ?", name)
                .where("Id = ?", id)
                .execute();
    }

    public static List<Item> getAllItems(){
        return new Select()
                .from(Item.class)
                .orderBy("Id ASC")
                .execute();
    }

    public void deleteItem(int id){
        new Delete().from(Item.class).where("Id = ?", id).execute();
    }

    @Override
    public String toString(){
        return this.name;
    }

}