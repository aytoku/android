package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.PartnersAdapter;
import com.example.myapplication_1.R;

public class PartnersFragment extends Fragment {

    public static final String TAG = "PartnersFragment";
    private RecyclerView partners_rv;

    public static PartnersFragment getInstance(Bundle args) {

        PartnersFragment partnersFragment = new PartnersFragment();
        partnersFragment.setArguments(args);

        return partnersFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.partners,
                container, false);

        partners_rv = view.findViewById(R.id.recycler_partners);
        ImageButton imageButton = view.findViewById(R.id.rl_partners_button);
        TextView textView = view.findViewById(R.id.rl_partners_blacklist);

        Bundle bundle = new Bundle();
        final Fragment informationFragment = InformationFragment.getInstance(bundle);
        final Fragment blacklistPartnersFragment = BlacklistPartnersFragment.getInstance(bundle);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, informationFragment);
                fragmentTransaction.commit();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, blacklistPartnersFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerView = partners_rv;
        try {
            PartnersAdapter.PartnersItems[] partnersItems = getPartnersItems();
            PartnersAdapter partnersAdapter = new PartnersAdapter(partnersItems, getActivity().getBaseContext());
            recyclerView.setAdapter( partnersAdapter );
            recyclerView.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerView.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private PartnersAdapter.PartnersItems[] getPartnersItems() {
        PartnersAdapter.PartnersItems []_arr = new PartnersAdapter.PartnersItems[]{
                new PartnersAdapter.PartnersItems(
                        R.drawable.icon_arrow_right,
                        "Партнер 1",
                        new PartnersAdapter.PartnersItems.CallBack(){
                            @Override
                            public void call(PartnersAdapter.PartnersItems partnersItems){
                                try {
                                    Bundle bundle = new Bundle();
                                    Fragment spinnerFragment = SpinnerFragment.getInstance(bundle);
                                    String message_title = "Партнер 1";
                                    String message_desc = "ООО Партнер 1, 362040, Северная\nОсетия-Алания Респ., г. Владикавказ\nпросп.Мира, д. 31, ORGN:111111939";
                                    bundle.putString("message_title", message_title);
                                    bundle.putString("message_desc", message_desc);
                                    spinnerFragment.setArguments(bundle);
                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.rl_main, spinnerFragment);
                                    fragmentTransaction.commit();
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

        new PartnersAdapter.PartnersItems(
                        R.drawable.icon_arrow_right,
                        "Партнер 2",
                new PartnersAdapter.PartnersItems.CallBack(){
                    @Override
                    public void call(PartnersAdapter.PartnersItems partnersItems){
                        try {
                            Bundle bundle = new Bundle();
                            Fragment spinnerFragment = SpinnerFragment.getInstance(bundle);
                            String message_title = "Партнер 2";
                            String message_desc = "ООО Партнер 2, 362040, Северная\nОсетия-Алания Респ., г. Владикавказ\nпросп.Мира, д. 31, ORGN:111111939";
                            bundle.putString("message_title", message_title);
                            bundle.putString("message_desc", message_desc);
                            spinnerFragment.setArguments(bundle);
                            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.rl_main, spinnerFragment);
                            fragmentTransaction.commit();
                        }catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                })
        };
        return _arr;
    }
}