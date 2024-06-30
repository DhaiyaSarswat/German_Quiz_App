package com.example.germanquizapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.germanquizapp.AdapterClass.HomeAdapter;
import com.example.germanquizapp.databinding.FragmentHomeBinding;
import com.example.germanquizapp.modelClass.HomeModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ArrayList<HomeModel> list = new ArrayList<>();
    private HomeAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        setupRecyclerView();
        setupButtonClick();
        setupGoetheIconClick(); // Setup click listener for Goethe icon
        return binding.getRoot();
    }

    private void setupRecyclerView() {
        binding.rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        list.clear();
        list.add(new HomeModel("Everyday Objects", "Common objects in German."));
        list.add(new HomeModel("Family Members", "German family vocabulary."));
        list.add(new HomeModel("Animals", "Names of animals in German."));
        list.add(new HomeModel("Food & Drinks", "German food and drinks."));
        list.add(new HomeModel("Numbers", "Learn numbers in German."));

        adapter = new HomeAdapter(getContext(), list);
        binding.rcv.setAdapter(adapter);
    }

    private void setupButtonClick() {
        binding.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to DetailsFragment
                navigateToDetailsFragment();
            }
        });
    }

    private void setupGoetheIconClick() {
        binding.goetheIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open URL in browser when Goethe icon is clicked
                String url = "https://www.goethe.de/pro/relaunch/prf/de/A1_SD1_Wortliste_02.pdf"; // Replace with your actual URL
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    private void navigateToDetailsFragment() {
        DetailsFragment detailsFragment = new DetailsFragment();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.wrapper, detailsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
