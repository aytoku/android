package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.TripDetailsAdapter;
import com.example.myapplication_1.R;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;

import ru.osety.amironlibrary.Query.QueryPost;
import ru.osety.amironlibrary.Query.QueryTemplate;

public class TripDetailsFragment extends Fragment {

    public static final String TAG = "TripDetailsFragment";

    public static TripDetailsFragment getInstance(Bundle args) {

        TripDetailsFragment tripDetailsFragment = new TripDetailsFragment();
        tripDetailsFragment.setArguments(args);

        return tripDetailsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.trip_details,
                container, false);

        ImageButton button = view.findViewById(R.id.rl_order_details_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                MachinePurposeLowerPartFragment machinePurposeLowerPartFragment = MachinePurposeLowerPartFragment.getInstance(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, machinePurposeLowerPartFragment);
                fragmentTransaction.commit();
            }
        });

        final RecyclerView trip_details_title_rv = view.findViewById(R.id.ll_trip_details_title_recycler);
        try{
            TripDetailsAdapter.TripDetailsItems[] tripDetailsItems = getTripDetailsItems();
            TripDetailsAdapter tripDetailsAdapter = new TripDetailsAdapter(tripDetailsItems, getActivity().getApplicationContext());
            trip_details_title_rv.setAdapter( tripDetailsAdapter );
            trip_details_title_rv.setLayoutManager(
                    new LinearLayoutManager( getActivity().getBaseContext(), RecyclerView.VERTICAL, false ) );
            trip_details_title_rv.setItemAnimator( new DefaultItemAnimator() );
        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

        return view;
    }

    private TripDetailsAdapter.TripDetailsItems[] getTripDetailsItems() {
        TripDetailsAdapter.TripDetailsItems[] arr = new TripDetailsAdapter.TripDetailsItems[]{
                new TripDetailsAdapter.TripDetailsItems(
                        "Водитель", new String[]{"Гаглоев Игорь Борисович", "Серый LADA 2114, A944 PK 15", "+7 (988) 839-57-11"}),
                new TripDetailsAdapter.TripDetailsItems(
                        "Поездка", new String[]{"улица Бзарова, 27/2", "улица Nалалихина, 47"}),
                new TripDetailsAdapter.TripDetailsItems(
                        "Время", new String[]{"Сегодня в 22:26"}),
                new TripDetailsAdapter.TripDetailsItems(
                        "Стоимость", new String[]{"Эконом", "121 \u20BD"}),
                new TripDetailsAdapter.TripDetailsItems(
                        "Оплата", new String[]{"Visa 0729"}),
        };
        return arr;
    }

    private void getData(){
        final JsonObject jo = new JsonObject();
        Map<String, String> _mapHead = new ArrayMap<>();
        _mapHead.put("Accept-Charset", "UTF-8");
        _mapHead.put("Content-Type", "application/json;charset=" + "UTF-8");
        //_mapHead.put("Authorization", "Bearer" + TOKEN);
        new QueryPost<JsonObject>(new QueryTemplate.CallBack<Integer, JsonObject, String>() {
            @Override
            public void asyncBefore() throws InterruptedException {
            }

            @Override
            public JsonObject async(String result) throws ClassCastException {
                JsonParser jsonParser = new JsonParser();
                return  jsonParser.parse(result).getAsJsonObject();
            }

            @Override
            public void sync(JsonObject result) {

            }

            @Override
            public void progress(Integer... status) {

            }

            @Override
            public void cancel(JsonObject result, Throwable throwable) {

            }
        }).addRequestPropertyHead(_mapHead)
                .setAsyncThreadPool(true)
                    .query();
    }
}