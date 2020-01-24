package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.SettingsAdapter;
import com.example.myapplication_1.R;

public class SettingsFragment extends Fragment {

    public static final String TAG = "SettingsFragment";
    private RecyclerView settings_rv;

    public static SettingsFragment getInstance(Bundle args) {

        SettingsFragment settingsFragment = new SettingsFragment();
        settingsFragment.setArguments(args);

        return settingsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.settings,
                container, false);

        settings_rv = view.findViewById(R.id.recycler_settings);
        ImageButton imageButton = view.findViewById(R.id.ll_setting_button);

        Bundle _args = new Bundle();
        final Menu11Fragment menu11Fragment = Menu11Fragment.getInstance(_args);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, menu11Fragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerView = settings_rv;
        try {
            SettingsAdapter.SettingsItems[] settingsItems = getSettingItems();
            SettingsAdapter settingsAdapter = new SettingsAdapter(settingsItems, getActivity().getBaseContext());
            recyclerView.setAdapter( settingsAdapter );
            recyclerView.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerView.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private SettingsAdapter.SettingsItems[] getSettingItems() {

        SettingsAdapter.SettingsItems []_arr = new SettingsAdapter.SettingsItems[]{

                new SettingsAdapter.SettingsItems(
                        "Не звонить"),
                new SettingsAdapter.SettingsItems(
                        "Не предлагать сообщения о\nснижении цены")
        };
        return _arr;
    }
}