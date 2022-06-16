package eu.todek.navigationtest;


import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UsersRepository {
    private UserDao userDao;

    public UsersRepository(Application application){
        AppDatabase database = AppDatabase.getDatabase(application);
        userDao = database.userDao();
    }

    LiveData<List<User>> getAllUsers(){
        return userDao.getAll();
    }

    public void insert(User user){
        AppDatabase.databaseWriteExecutor.execute(() -> userDao.insert(user));
    }
}
