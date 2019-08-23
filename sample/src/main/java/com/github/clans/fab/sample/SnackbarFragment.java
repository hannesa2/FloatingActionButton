package com.github.clans.fab.sample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.github.fab.sample.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SnackbarFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.snackbar_fragment, container, false);
    }

    @Override
    @SuppressLint("WrongConstant")
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Locale[] availableLocales = Locale.getAvailableLocales();
        List<String> locales = new ArrayList<>();
        for (Locale locale : availableLocales) {
            locales.add(locale.getDisplayName());
        }

        ListView mListView = view.findViewById(R.id.list);
        mListView.setAdapter(new ArrayAdapter<>(requireActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, locales));

        final FloatingActionMenu mFabMenu = view.findViewById(R.id.snackbar_fab);

        FloatingActionButton snackbarFab = new FloatingActionButton(getActivity());
        snackbarFab.setLabelText("Click to show snackbar");
        snackbarFab.setImageResource(R.drawable.ic_edit);
        snackbarFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mFabMenu, "Replace with your own action", Snackbar.LENGTH_LONG).show();
            }
        });
        mFabMenu.addMenuButton(snackbarFab);
    }
}
