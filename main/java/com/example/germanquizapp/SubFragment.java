package com.example.germanquizapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.germanquizapp.AdapterClass.SubAdapter;
import com.example.germanquizapp.databinding.FragmentHomeBinding;
import com.example.germanquizapp.databinding.FragmentSubBinding;
import com.example.germanquizapp.modelClass.SubModel;

import java.util.ArrayList;


public class SubFragment extends Fragment {
    FragmentSubBinding binding;
    ArrayList<SubModel> list=new ArrayList<>();
    SubAdapter adapter;
    String title;

    public SubFragment() {
        // Required empty public constructor
    }
    public SubFragment(String title) {
        this.title=title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentSubBinding.inflate(getLayoutInflater());
        LoadData();
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
    private void LoadData() {
        binding.rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        list.clear();
        switch (title) {
            case "Everyday Objects":
                list.add(new SubModel("Household Items", "Common household items", "Everyday Objects"));
                list.add(new SubModel("Kitchen Utensils", "Items used in the kitchen", "Everyday Objects"));
                list.add(new SubModel("Personal Items", "Personal care items", "Everyday Objects"));
                list.add(new SubModel("Office Supplies", "Common office supplies", "Everyday Objects"));
                list.add(new SubModel("Electronic Devices", "Everyday gadgets", "Everyday Objects"));
                break;
            case "Family Members":
                list.add(new SubModel("Parents", "Parents (Mother and Father)", "Family Members"));
                list.add(new SubModel("Siblings", "Brothers and Sisters", "Family Members"));
                list.add(new SubModel("Extended Family", "Extended family members", "Family Members"));
                list.add(new SubModel("Relatives", "Close relatives", "Family Members"));
                list.add(new SubModel("Children", "Children in the family", "Family Members"));
                break;

            case "Animals":
                list.add(new SubModel("Mammals", "Various mammals", "Animals"));
                list.add(new SubModel("Birds", "Different types of birds", "Animals"));
                list.add(new SubModel("Aquatic Animals", "Animals living in water", "Animals"));
                list.add(new SubModel("Insects", "Various insects", "Animals"));
                list.add(new SubModel("Reptiles", "Different reptilian species", "Animals"));
                break;

            case "Food & Drinks":
                list.add(new SubModel("Fruits", "Various fruits", "Food & Drinks"));
                list.add(new SubModel("Vegetables", "Different vegetables", "Food & Drinks"));
                list.add(new SubModel("Beverages", "Different beverages", "Food & Drinks"));
                list.add(new SubModel("Dairy Products", "Various dairy items", "Food & Drinks"));
                list.add(new SubModel("Snacks", "Different snacks", "Food & Drinks"));
                break;

            case "Numbers":
                list.add(new SubModel("Cardinal Numbers", "Basic counting numbers", "Numbers"));
                list.add(new SubModel("Ordinal Numbers", "Numbers that denote position or order", "Numbers"));
                list.add(new SubModel("Fractions and Decimals", "Numbers representing parts of a whole", "Numbers"));
                list.add(new SubModel("Roman Numerals", "Symbols used in ancient Rome for counting", "Numbers"));
                list.add(new SubModel("Prime Numbers", "Numbers divisible only by 1 and themselves", "Numbers"));
                break;

        }

        adapter=new SubAdapter(getContext(),list);
        binding.rcv.setAdapter(adapter);
    }
}