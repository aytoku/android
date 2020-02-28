package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.AssistantNotificationAdapter;
import com.example.myapplication_1.Adapters.EarningsPageAdapter;
import com.example.myapplication_1.R;

public class AssistantNotificationFragment extends Fragment {

    public static final String TAG = "AssistantNotificationFragment";
    private RecyclerView assistant_notification_rv;

    public static AssistantNotificationFragment getInstance(Bundle args) {

        AssistantNotificationFragment assistantNotificationFragment = new AssistantNotificationFragment();
        assistantNotificationFragment.setArguments(args);

        return assistantNotificationFragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.assistant_notification,
                container, false);

        assistant_notification_rv = view.findViewById(R.id.rl_assistant_notification_recycler);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerView = assistant_notification_rv;
        try{
            AssistantNotificationAdapter.AssistantNotificationItems[] assistantNotificationItems = getAssistantNotificationItems();
            AssistantNotificationAdapter assistantNotificationAdapter = new AssistantNotificationAdapter(assistantNotificationItems, getActivity().getBaseContext());
            recyclerView.setAdapter( assistantNotificationAdapter );
            recyclerView.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerView.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }
    }

    private AssistantNotificationAdapter.AssistantNotificationItems[] getAssistantNotificationItems() {
        AssistantNotificationAdapter.AssistantNotificationItems []_arr = new AssistantNotificationAdapter.AssistantNotificationItems[]{
                new AssistantNotificationAdapter.AssistantNotificationItems(
                        new String[] {"Как настроение?", "3 минуты назад"},
                        new String[]{"Нормально", "\uD83D\uDC4D", "Отлично"},
                        new String[] {"Заголовок новости",
                                "Задача организации, в особенности же\nструктура организации обеспечивает широкому\nкругу (специалистов) участие в формировании\nсистемы обучения кадров, соответствует\nнасущным потребностям.",
                                "30 минут назад"}),

                new AssistantNotificationAdapter.AssistantNotificationItems(
                        new String[] {"Как настроение?", "3 минуты назад"},
                        new String[]{"Нормально", "\uD83D\uDC4D", "Отлично"},
                        new String[] {"Заголовок новости",
                                "Задача организации, в особенности же\nструктура организации обеспечивает широкому\nкругу (специалистов) участие в формировании\nсистемы обучения кадров, соответствует\nнасущным потребностям.",
                                "30 минут назад"})

        };
        return _arr;
    }
}