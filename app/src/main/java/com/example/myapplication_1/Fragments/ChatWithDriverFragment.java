//package com.example.myapplication_1.Fragments;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.DefaultItemAnimator;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.myapplication_1.Adapters.ChatWithDriverAdapter;
//import com.example.myapplication_1.Adapters.DeployedMessagesAdapter;
//import com.example.myapplication_1.R;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class ChatWithDriverFragment extends Fragment {
//
//    public static final String TAG = "ChatWithDriverFragment";
//    private RecyclerView rv;
//    private RecyclerView rv1;
//    private List<String>list;
//
//    public static ChatWithDriverFragment getInstance(Bundle args) {
//
//        ChatWithDriverFragment chatWithDriverFragment = new ChatWithDriverFragment();
//        chatWithDriverFragment.setArguments(args);
//
//        return chatWithDriverFragment;
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//
//        View view = inflater.inflate(R.layout.empty_chat_with_driver,
//                container, false);
//
//        rv = view.findViewById(R.id.rl_empty_chat_with_driver_recycler);
//        rv1 = view.findViewById(R.id.deployed_messages_recycler);
//
//        return view;
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//        RecyclerView recyclerViewMenu = rv;
//        try {
//            ChatWithDriverAdapter.ChatWithDriverItem[] chatWithDriverItems = getChatWithDriverItems();
//            ChatWithDriverAdapter adapterGridViewMenu = new ChatWithDriverAdapter(chatWithDriverItems, getActivity().getBaseContext());
//            recyclerViewMenu.setAdapter( adapterGridViewMenu );
//            recyclerViewMenu.setLayoutManager(
//                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.HORIZONTAL, false ) );
//            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );
//        } catch ( NullPointerException e) {
//            e.printStackTrace();
//        }
//
//        RecyclerView recyclerView1 = rv1;
//        try {
//            DeployedMessagesAdapter.DeployedMessagesItems[] itemsMenu = getMenuItems1();
//            List<DeployedMessagesAdapter.DeployedMessagesItems> itemsMenuList = new ArrayList<>(Arrays.asList(itemsMenu));
//            RecyclerView.Adapter adapterGridViewMenu = new DeployedMessagesAdapter(list, getActivity().getBaseContext());
//            recyclerView1.setAdapter(adapterGridViewMenu);
//            recyclerView1.setLayoutManager(
//                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ));
//            recyclerView1.setItemAnimator( new DefaultItemAnimator() );
//        } catch ( NullPointerException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private ChatWithDriverAdapter.ChatWithDriverItem[] getChatWithDriverItems() {
//
//        ChatWithDriverAdapter.ChatWithDriverItem []_arr = new ChatWithDriverAdapter.ChatWithDriverItem[]{
//                new ChatWithDriverAdapter.ChatWithDriverItem( "Уже выхожу"),
//                new ChatWithDriverAdapter.ChatWithDriverItem("Не вижу вас")
//        };
//        return _arr;
//    }
//
//    private DeployedMessagesAdapter.DeployedMessagesItems[] getMenuItems1() {
//
//        DeployedMessagesAdapter.DeployedMessagesItems[] arr = new DeployedMessagesAdapter.DeployedMessagesItems[]{
//
//                new DeployedMessagesAdapter.DeployedMessagesItems(
//                        "Выполните еще три заказа и получите\n+30 к рейтингу"),
//
//                new DeployedMessagesAdapter.DeployedMessagesItems(
//                        "Выполните еще три заказа и получите\n+30 к рейтингу"),
//
//                new DeployedMessagesAdapter.DeployedMessagesItems(
//                        "Как настроение?")
//        };
//        return arr;
//    }
//}