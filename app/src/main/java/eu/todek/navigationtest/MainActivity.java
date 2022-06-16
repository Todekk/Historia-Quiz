package eu.todek.navigationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import eu.todek.navigationtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.drawerLayout);

        drawerLayout = binding.drawerLayout;



        //final NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_view);
        FragmentManager manager = getSupportFragmentManager();
        NavHostFragment fragment = (NavHostFragment) manager.findFragmentById(R.id.nav_host_view);
        NavController navController = fragment.getNavController();

        NavigationUI.setupWithNavController(binding.navView, navController);

        NavigationUI.setupActionBarWithNavController(this, fragment.getNavController(), drawerLayout);

    }




    @Override
    public boolean onSupportNavigateUp() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_view);

        NavController navController = navHostFragment.getNavController();
        return NavigationUI.navigateUp(navController, drawerLayout) ;
    }


}