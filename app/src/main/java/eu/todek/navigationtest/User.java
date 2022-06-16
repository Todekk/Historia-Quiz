package eu.todek.navigationtest;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {


    public User(String firstName, String lastName, String score){
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @PrimaryKey (autoGenerate = true)
    private int uid;

    @ColumnInfo (name = "first_name")
    private final String firstName;

    @ColumnInfo (name = "last_name")
    private final String lastName;

    @ColumnInfo (name = "score")
    private final String score;

    public int getUid() {
        return uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getScore() {
        return score;
    }
}

