package com.example.germanquizapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailsFragment extends Fragment {

    private TextView emailTextView;
    private TextView contactTextView;
    private TextView linkedInTextView;
    private TextView privacyPolicyTextView;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        // Initialize views
        emailTextView = view.findViewById(R.id.emailValueTextView);
        contactTextView = view.findViewById(R.id.contactValueTextView);
        linkedInTextView = view.findViewById(R.id.linkedinValueTextView);

        // Replace with your actual information
        String email = "dhairyasarswatwork2005@gmail.com";
        String contactNumber = "+91-9410496070";
        String linkedInUrl = "www.linkedin.com/in/dhairya-sarswat";

        emailTextView.setText(email);
        contactTextView.setText(contactNumber);
        linkedInTextView.setText(linkedInUrl);

        return view;
    }
}
