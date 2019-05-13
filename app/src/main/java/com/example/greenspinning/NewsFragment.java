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
                R.drawable.image11,
                R.drawable.image12,
                R.drawable.image13,
                R.drawable.image14};

        News a = new News("HOW GREEN IS 'GREEN' ENERGY?\n", "While these efforts are commendable, much of the development of green energy is having large impacts...\n\n\n\nREAD ALL", "Renewable energy is an important piece of the puzzle in meeting growing energy demands and mitigating climate change, but the potentially adverse effects of such technologies are often overlooked. Given that climate and ecology are inextricably linked, assessing the effects of energy technologies requires one to consider their full suite of global environmental concerns. We review here the ecological impacts of three major types of renewable energy – hydro, solar, and wind energy – and highlight some strategies for mitigating their negative effects. All three types can have significant environmental consequences in certain contexts. Wind power has the fewest and most easily mitigated impacts; solar energy is comparably benign if designed and managed carefully. Hydropower clearly has the greatest risks, particularly in certain ecological and geographical settings. More research is needed to assess the environmental impacts of these ‘green’ energy technologies, given that all are rapidly expanding globally." ,covers[0]);
        newsList.add(a);

        a = new News("FROM OIL TO SOLAR: SAUDI ARABIA\n", "Life in Saudi Arabia has long been defined by the oil that flows from the kingdom. Over decades, the vast wealth it pumped ...\n\n\n\nREAD ALL", "Life in Saudi Arabia has long been defined by the oil that flows from the kingdom. Over decades, the vast wealth it pumped out paid not just for gleaming towers and shopping malls but also for a government sector that employs a majority of working Saudis.\n" +
                "\n" +
                "Now, Saudi Arabia is trying to tie its future to another natural resource it has in abundance: sunlight.\n" +
                "\n" +
                "The world’s largest oil exporter is embarking, under Prince Mohammed bin Salman, on an ambitious effort to diversify its economy and reinvigorate growth, in part by plowing money into renewable energy. The Saudi government wants not just to reshape its energy mix at home but also to emerge as a global force in clean power.\n" +
                "\n" +
                "Reaching that goal is a big if. But the strategy is finally making progress after fits and starts.\n" +
                "\n" +
                "Riyadh on Monday tapped ACWA Power, a Saudi energy company, to build a solar farm that would generate enough electricity to power around 40,000 homes. The project will cost $300 million and create hundreds of jobs, according to Turki al-Shehri, head of the kingdom’s renewable energy program. By the end of the year, Saudi Arabia aims to invest up to $7 billion to develop seven new solar plants and a big wind farm. The country hopes that renewables, which now represent a negligible amount of the energy it uses, will be able to provide as much as 10 percent of its power generation by the end of 2023.",covers[1]);
        newsList.add(a);

        a = new News("A.I FOR ENERGY EFFICIENCY", "The US Energy Information Agency (EIA) defines renewable energy as an energy source that naturally regenerate, such ...\n\n\n\nREAD ALL","The U.S. Energy Information Agency (EIA) defines renewable energy as an energy source that naturally regenerates, such as solar or wind. In contrast, fossil fuels are considered finite. The EIA reports that in 2016, 10 percent of all energy consumed in the U.S. was derived from renewable energy sources. This is equivalent to roughly “10.2 quadrillion British thermal units (Btu) —1 quadrillion is the number 1 followed by 15 zeros”.\n" +
                "\n" +
                "Despite the increasing use of renewables which notably became the leading global source of electricity in 2015, there are still persistent barriers to wider implementation related to policy and technology. Researchers and companies are exploring how artificial intelligence could assist in improving accessibility and efficiency of renewable energy technology.\n" +
                "\n" +
                "In this article we present examples of renewable energy technologies which incorporate AI. We cover three major categories of renewable technologies that should be of interest to business leaders in the green energy space:\n" +
                "\n" +
                "Energy Forecasting  – Industry data is used to train AI algorithms to make accurate forecasts, helping to inform power supply and demand\n" +
                "Energy Efficiency – AI is used to track and optimize how energy efficiency\n" +
                "Energy Accessibility – AI is used to model utility cost savings and provide recommendations for smart home investments\n" +
                "For each application we provide a company overview, explanation of how the platform functions and outcome data and/or results where available. Each example is organized under a sub-heading which serves as a quick reference when navigating through the article." ,covers[2]);
        newsList.add(a);

        a = new News("RENEWABLE ENRGY FROM FOOD WASTE", "Food waste is an untapped energy source which mostly ends up rotting in landfills thereby greenhouse gases ...\n\n\n\nREAD ALL","Food waste is an untapped energy source which mostly ends up rotting in landfills thereby releasing greenhouse gases into the atmosphere. Food waste is difficult to treat or recycle since it contains high levels of sodium salt and moisture, and is mixed with other waste during collection. Major generators of food wastes include hotels, restaurants, supermarkets, residential blocks, cafeterias, airline caterers, food processing industries etc.\n" +
                "\n" +
                "In United States, food waste is the third largest waste stream after paper and yard waste. Around 12.7 percent of the total municipal solid waste (MSW) generated in the year 2008 was food scraps which amounted to about 32 million tons. According to EPA, about 31 million tons of food waste was thrown away into landfills or incinerators in 2008. As far as United Kingdom is concerned, each year 8.3 million tonnes of food is thrown away by households. These statistics are an indication of tremendous amount of food waste generated all over the world.\n" +
                "\n" +
                "The proportion of food waste in municipal waste stream is gradually increasing and hence a proper food waste management strategy needs to be devised to ensure its eco-friendly and sustainable disposal. Currently, only about 3% of food waste is recycled throughout USA, mainly through composting. Composting provides an alternative to landfill disposal of food waste, however it requires large areas of land, produces volatile organic compounds and consumes energy. Consequently, there is an urgent need to explore better recycling alternatives. Anaerobic digestion has been successfully used in several European and Asian countries to stabilize food wastes, and to provide beneficial end-products. Sweden, Austria, Denmark, Germany and England have led the way in developing new advanced biogas technologies and setting up new projects for conversion of food waste into energy." ,covers[3]);
        newsList.add(a);


        adapter.notifyDataSetChanged();
    }

}
