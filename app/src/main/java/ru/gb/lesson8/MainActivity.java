package ru.gb.lesson8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private BottomNavigationView  bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.main_bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(this);
    }

    // создает опциональное меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // обрабатывает нажатия на элементы меню
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.main_delete:
                return toast("Delete");
            case R.id.main_new:
                return toast("New");
            case R.id.main_quit:
                return toast("Quit");
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean toast(String text)
    {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch (item.getItemId())
        {
            case R.id.main_delete:
                fragment = new DeleteFragment();
                break;
            case R.id.main_new:
                fragment = new NewFragment();
                break;
            case R.id.main_quit:
                fragment = new QuitFragment();
                break;
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_host, fragment)
                .addToBackStack(null)
                .commit();
        return true;
    }
}