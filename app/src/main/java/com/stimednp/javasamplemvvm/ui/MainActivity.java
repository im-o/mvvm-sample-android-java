package com.stimednp.javasamplemvvm.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.stimednp.javasamplemvvm.databinding.ActivityMainBinding;
import com.stimednp.javasamplemvvm.viewmodel.MovieViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViewModel();
    }

    private void initViewModel() {
        MovieViewModel viewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        viewModel.getMovies().observe(this, movieLists -> {
            Log.e("INI", "DATA -> " + movieLists.size());
        });
    }
}
