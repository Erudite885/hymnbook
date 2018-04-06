package com.techbeloved.hymnbook;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by kennedy on 4/6/18.
 */

public class HymnTitlesFragment extends Fragment {
    ArrayList<Hymn> hymns;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_song_list, container, false);
        RecyclerView rvHymns = rootView.findViewById(R.id.song_list_recyclerview);

        // Initialize hymns
        hymns = Hymn.createHymnList();
        // Create adapter passing in the sample user data
        HymnAdapter hymnAdapter = new HymnAdapter(getActivity(), hymns);
        // Attache the adapter to the recycler
        rvHymns.setAdapter(hymnAdapter);
        // Set layout manager to position the items
        rvHymns.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }

    public HymnTitlesFragment(){
        // Empty constructor
    }
}
