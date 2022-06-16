package eu.todek.navigationtest;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    LiveData<List<User>> getAll();

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);


    @Query("SELECT * FROM users WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    LiveData<User> findByName(String first, String last);

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
