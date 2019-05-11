package com.example.greenspinning;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList date = new ArrayList<>(Arrays.asList("03/07/19", "01/07/19", "28/06/19", "26/06/19", "24/06/19", "21/06/19", "19/06/19", "17/06/19", "14/06/19", "12/06/19", "10/06/19", "07/06/19", "05/06/19", "03/06/19"));
    ArrayList producedWatt = new ArrayList<>(Arrays.asList("Jonathan Body", "Chandra Mosbey", "Randee Kovacich", "Hobert Lombard", "Wallace Tompson", "Lauran Vue", "Tawna Stelter", "Shawana Teal", "Lula Lares", "Joelle Mefford", "Antonia Cahall", "Harris Burtch", "Linn Nixon", "Eddie Bernhard"));
    ArrayList helpers = new ArrayList<>(Arrays.asList("120", "80", "200", "150", "75", "175", "215", "90", "90", "130", "175", "100", "200", "80"));
    ArrayList calories = new ArrayList<>(Arrays.asList("820", "830", "790", "800", "1020", "998", "735", "956", "822", "930", "1075", "770", "802", "810"));
    ArrayList speed = new ArrayList<>(Arrays.asList("18 Km/h", "16 Km/h", "15 Km/h", "17 Km/h", "18 Km/h", "17 Km/h", "15 Km/h", "20 Km/h", "14 Km/h", "13 Km/h", "15 Km/h", "14 Km/h", "18 Km/h", "15 Km/h"));
    ArrayList km = new ArrayList<>(Arrays.asList("19", "20", "22", "15", "34", "19", "15", "19", "18", "16", "17", "22", "20", "14"));
    ArrayList spinning_class = new ArrayList<>(Arrays.asList("Spinning Class #14", "Spinning Class #13", "Spinning Class #12", "Spinning Class #11", "Spinning Class #10", "Spinning Class #9", "Spinning Class #8", "Spinning Class #7", "Spinning Class #6", "Spinning Class #5", "Spinning Class #4", "Spinning Class #3", "Spinning Class #2", "Spinning Class #1"));
    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), date, producedWatt, helpers, calories, speed, km, spinning_class);
        recyclerView.setAdapter(customAdapter);

        return view;
    }
}
