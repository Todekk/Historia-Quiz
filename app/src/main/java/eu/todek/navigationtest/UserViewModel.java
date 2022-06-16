package eu.todek.navigationtest;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private final UsersRepository repository;
    private final LiveData<List<User>> users;

    public UserViewModel(Application application){
        super(application);
        repository = new UsersRepository(application);
        users = repository.getAllUsers();
    }

    LiveData<List<User>> getUsers(){
        return users;
    }

    public void insert(User user){
        repository.insert(user);
    }
}
