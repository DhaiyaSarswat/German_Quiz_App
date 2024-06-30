package com.example.germanquizapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.germanquizapp.databinding.FragmentQuizBinding;
import com.example.germanquizapp.databinding.FragmentResultBinding;

import java.sql.Wrapper;

public class ResultFragment extends Fragment {
    FragmentResultBinding binding;
    int right,allQuestion;
    String category,title;
    public ResultFragment() {
        // Required empty public constructor
    }
    public ResultFragment(int right,int allQuestion,String category,String title) {
        this.right=right;
        this.allQuestion=allQuestion;
        this.category=category;
        this.title=title;
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultBinding.inflate(getLayoutInflater());
        String rightscore=String.valueOf(right);
        String wrongscore=String.valueOf(allQuestion-right);
        String totalScore=String.valueOf(allQuestion);
        binding.correct.setText(rightscore+" Correct");
        binding.incorrect.setText(wrongscore+" Incorrect");
        binding.score.setText("You got the "+rightscore+" out of "+totalScore);

        binding.explorebtn.setOnClickListener(v->{
            AppCompatActivity activity=(AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new SubFragment(category)).commit();


        });
        binding.replay.setOnClickListener(v->{
            AppCompatActivity activity=(AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new QuizFragment(category,title)).commit();

        });

        return binding.getRoot();
    }
}