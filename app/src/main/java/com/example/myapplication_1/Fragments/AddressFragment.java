package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.AddressAdapter;
import com.example.myapplication_1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddressFragment extends Fragment {

    public static final String TAG = "AddressFragment";
    private RecyclerView.Adapter addressAdapter;
    private List<AddressAdapter.AddressItems> addressItemsList;


    public static AddressFragment getInstance(Bundle args) {

        AddressFragment addressFragment = new AddressFragment();
        addressFragment.setArguments(args);

        return addressFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.addresses_fragment,
                container, false);

        RecyclerView address_rv = view.findViewById(R.id.ll_address_rl_address_ll_address_address_recycler);
        ImageButton button = view.findViewById(R.id.ll_address_rl_address_button_plusik);
        ImageButton imageButton = view.findViewById(R.id.ll_address_rl_address_button_strelka);

        Bundle bundle = new Bundle();
        final Menu11Fragment menu11Fragment = Menu11Fragment.getInstance(bundle);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, menu11Fragment);
                fragmentTransaction.commit();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddButtonClicked(view);
            }
        });

        try{
            AddressAdapter.AddressItems[] addressItems = getAddressItems();
            addressItemsList = new ArrayList<>(Arrays.asList(addressItems));
            addressAdapter = new AddressAdapter(addressItemsList, getActivity().getBaseContext());
            address_rv.setAdapter(addressAdapter);
            address_rv.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
            address_rv.setItemAnimator( new DefaultItemAnimator() );
        }catch(NullPointerException e){
            e.printStackTrace();
        }

        return view;
    }

    private void onAddButtonClicked(View view) {
        try{
            addressItemsList.add(addressItemsList.size(), new AddressAdapter.AddressItems(
                    R.mipmap.icon_button_plus,
                    "Добавить адрес дома",
                    new AddressAdapter.AddressItems.CallBack(){
                        @Override
                        public void call(AddressAdapter.AddressItems itemsMenu){
                            try{
                                Bundle bundle = new Bundle();
                                SearchFragment searchFragment = SearchFragment.getInstance(bundle);
                                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.rl_main, searchFragment);
                                fragmentTransaction.commit();
                                String message = bundle.getString("message");
                                getActivity().getIntent().getExtras().get(message);
                            }catch (NullPointerException e) {
                                e.printStackTrace();
                            }
                        }
                    }));
            addressAdapter.notifyItemInserted(addressItemsList.size()-1);
            addressAdapter.notifyDataSetChanged();
        }catch(NumberFormatException e) {
            Toast.makeText(getActivity().getApplicationContext(), "The field is empty",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private AddressAdapter.AddressItems[] getAddressItems() {
        AddressAdapter.AddressItems[] arr = new AddressAdapter.AddressItems[]{
                new AddressAdapter.AddressItems(
                        R.mipmap.icon_button_plus,
                        "Добавить адрес дома",
                        new AddressAdapter.AddressItems.CallBack(){
                            @Override
                            public void call(AddressAdapter.AddressItems addressItems){
                                try {
                                    Bundle bundle = new Bundle();
                                    SearchFragment searchFragment = SearchFragment.getInstance(bundle);
                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.rl_main, searchFragment);
                                    fragmentTransaction.commit();
                                    String message = bundle.getString("message");
                                    getActivity().getIntent().getExtras().get(message);
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        }),

                new AddressAdapter.AddressItems(
                        R.mipmap.icon_button_plus,
                        "Добавить адрес дома",
                        new AddressAdapter.AddressItems.CallBack(){
                            @Override
                            public void call(AddressAdapter.AddressItems addressItems){
                                try {
                                    Bundle bundle = getArguments();
                                    SearchFragment searchFragment = SearchFragment.getInstance(bundle);
                                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.rl_main, searchFragment);
                                    fragmentTransaction.commit();
                                    String message = bundle.getString("message");
                                    getActivity().getIntent().getExtras().get(message);
                                }catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        })
        };
        return arr;
    }
}