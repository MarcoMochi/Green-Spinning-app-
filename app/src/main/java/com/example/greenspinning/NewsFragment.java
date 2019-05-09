package com.example.greenspinning;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {

    private NewsAdapter adapter;
    private List<News> newsList;

    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
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
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.news);
        newsList = new ArrayList<>();
        adapter = new NewsAdapter(getActivity(), newsList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        prepareNews();
        return view;
    }

    private void prepareNews() {
        int[] covers = new int[]{
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4};

        News a = new News("How Green is 'Green' Energy?", "While these efforts are commendable, much of the development of green energy is having large impacts on the ...", covers[0]);
        newsList.add(a);

        a = new News("From Oil to Solar: Saudi Arabia\n", "Life in Saudi Arabia has long been defined by the oil that flows from the kingdom. Over decades, the vast wealth it pumped ...", covers[1]);
        newsList.add(a);

        a = new News("A.I for Energy Efficiency", "The US Energy Information Agency (EIA) defines renewable energy as an energy source that naturally regenerate, such ...", covers[2]);
        newsList.add(a);

        a = new News("Renewable Energy from Wood Wastes", "Food waste is an untapped energy source which mostly ends up rotting in landfills thereby greenhouse gases ...", covers[3]);
        newsList.add(a);


        adapter.notifyDataSetChanged();
    }

}
