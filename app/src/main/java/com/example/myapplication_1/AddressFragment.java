//package com.example.myapplication_1;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageButton;
//import android.widget.Toast;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.DefaultItemAnimator;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.myapplication_1.Adapters.AddressAdapter;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class AddressFragment extends Fragment {
//
//    public static AddressFragment getInstance(Bundle args) {
//
//        AddressFragment f = new AddressFragment();
//        f.setArguments(args);
//
//        return f;
//    }
//
//    RecyclerView rv;
//    RecyclerView.Adapter adapterGridViewMenu;
//    private List<AddressAdapter.AdapterGridViewMenu.ItemsMenu> itemsMenuList;
//    ImageButton button;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//
//        View view = inflater.inflate(R.layout.addresses_fragment,
//                container, false);
//
//        rv = view.findViewById(R.id.ll_address_rl_address_ll_address_address_recycler);
//
//        button = view.findViewById(R.id.ll_address_rl_address_button_plusik);
//
//        final RecyclerView recyclerViewMenu = rv;
//
//        try {
//
//            AddressAdapter.AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();
//            itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
//            adapterGridViewMenu = new AddressAdapter.AdapterGridViewMenu(itemsMenuList, getBaseContext());
//            recyclerViewMenu.setAdapter(adapterGridViewMenu);
//            recyclerViewMenu.setLayoutManager(
//                    new LinearLayoutManager( getBaseContext(), RecyclerView.VERTICAL, false ));
//            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );
//
//        } catch ( NullPointerException e) {
//            e.printStackTrace();
//        }
//
//        addListener();
//    }
//
//    public void addListener(){
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(AddressFragment.this, EditMyAdressFragment.class );
//                startActivity(intent);
//            }
//        });
//    }
//
//    public void onAddButtonClicked(View view) {
//
//        try {
//            itemsMenuList.add(itemsMenuList.size(), new AddressAdapter.AdapterGridViewMenu.ItemsMenu(getResources().getColor(R.color.my_gray),
//                    R.mipmap.icon_button_plus,
//                    "Максима Горького, 123"));
//            adapterGridViewMenu.notifyItemInserted(itemsMenuList.size()-1);
//            adapterGridViewMenu.notifyDataSetChanged();
//
//        } catch(NumberFormatException e) {
//            Toast.makeText(getApplicationContext(), "The field is empty",
//                    Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
//
//        return super.onCreateView(parent, name, context, attrs);
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//    }
//
//    private AddressAdapter.AdapterGridViewMenu.ItemsMenu[] getMenuItems() {
//
//        AddressAdapter.AdapterGridViewMenu.ItemsMenu[] arr = new AddressAdapter.AdapterGridViewMenu.ItemsMenu[]{
//
//                new AddressAdapter.AdapterGridViewMenu.ItemsMenu(
//                        getResources().getColor(R.color.my_gray),
//                        R.mipmap.icon_button_plus,
//                        "Добавить адрес дома"),
//
//                new AddressAdapter.AdapterGridViewMenu.ItemsMenu(
//                        getResources().getColor(R.color.my_gray),
//                        R.mipmap.icon_button_plus,
//                        "Добавить адрес дома")
//        };
//        return arr;
//    }
//}
//
