package com.example.greenspinning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    private static final int TARGET_FRAGMENT_REQUEST_CODE = 1;
    private static final String BAD_HABITS1 = "message";
    TextView inputBadHabits1;
    FloatingActionButton fab;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        inputBadHabits1 = v.findViewById(R.id.input_bad_habits1);

        fab = v.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFrag = DialogFragment.newInstance();
                dialogFrag.setTargetFragment(ProfileFragment.this, TARGET_FRAGMENT_REQUEST_CODE);
                dialogFrag.setParentFab(fab);
                dialogFrag.show(getFragmentManager(), dialogFrag.getTag());
            }
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if( resultCode != Activity.RESULT_OK ) {
            return;
        }
        if( requestCode == TARGET_FRAGMENT_REQUEST_CODE ) {
            String greeting = data.getStringExtra(BAD_HABITS1);
            inputBadHabits1.setText(greeting);
            fab.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.view));
        }
    }

    public static Intent newIntent(String message) {
        Intent intent = new Intent();
        intent.putExtra(BAD_HABITS1, message);
        return intent;
    }


}
