package com.example.myapplication_1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.osety.amironlibrary.DrawableUtils;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityChatWithDriver extends AppCompatActivity {

    ImageButton androidImageButton;

    RecyclerView rv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        androidImageButton = (ImageButton) findViewById(R.id.img_cross_grey);

             /*androidImageButton.setOnClickListener(new View.OnClickListener(){
                 public void onClick(View v){
                     Toast.makeText(MainActivity.this,"", Toast.LENGTH_LONG).show();
                 }
             });*/

        setContentView(R.layout.chat_with_driver);

        rv = (RecyclerView) findViewById(R.id.rl_chat_with_driver_recycler);

    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {



        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onStart() {
        super.onStart();


        RecyclerView recyclerViewMenu = rv;




        try {

            AdapterGridViewMenu.ItemsMenu[] itemsMenu = getMenuItems();//model_data

            AdapterGridViewMenu adapterGridViewMenu = new AdapterGridViewMenu(itemsMenu, getBaseContext());//this;
            recyclerViewMenu.setAdapter( adapterGridViewMenu );
            recyclerViewMenu.setLayoutManager(
                    new LinearLayoutManager( getBaseContext(), RecyclerView.HORIZONTAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

    }

    private AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        AdapterGridViewMenu.ItemsMenu []_arr = new AdapterGridViewMenu.ItemsMenu[]{
                new AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        new AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        "Уже выхожу"),

                new AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        new AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        "Не вижу вас")
        };
        return _arr;

    }


    public static class AdapterGridViewMenu extends RecyclerView.Adapter<AdapterGridViewMenu.ViewHolder> {

        private final ItemsMenu[] itemsMenu;
        private final LayoutInflater layoutInflater;
        private final Context context;

        public AdapterGridViewMenu(AdapterGridViewMenu.ItemsMenu[] itemsMenu, Context context) {
            this.itemsMenu = itemsMenu;
            this.context = context;

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_empty_chat_driver, viewGroup, false);
            return new ViewHolder(v);

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            final ItemsMenu _item = itemsMenu[i];

            Drawable ic_background_xml = context.getResources().getDrawable(R.mipmap.icon_car);
            float _dens = context.getResources().getDisplayMetrics().density;

            Drawable ic_rout_color = DrawableUtils.setTintDrawable(ic_background_xml, _item.getColorBackground());

            int _size = Math.round(_dens * 40);

            viewHolder.title.setText( _item.getTitle() );
            viewHolder.cv_item.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {

                        _item.getCallBack().call(_item);

                    } catch ( NullPointerException e) {
                        e.printStackTrace();
                    }

                }
            });

        }

        @Override
        public int getItemCount() {
            return itemsMenu.length;
        }

        public static class ItemsMenu {

            public interface CallBack {
                void call(ItemsMenu itemsMenu);
            }

            private @ColorInt int colorBackgroundInt;
            private CallBack callBack;
            private String title;

            public ItemsMenu(int colorBackgroundRes, CallBack callBack,String title) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.callBack = callBack;
                this.title = title;
            }

            public CallBack getCallBack() {
                return callBack;
            }

            public String getTitle() {
                return title;
            }

            public int getColorBackground() {
                return colorBackgroundInt;
            }

        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView title;
            private final CardView cv_item;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                cv_item = itemView.findViewById(R.id.cv_cell__empty_chat_with_driver);
                title = itemView.findViewById(R.id.cv_cell__empty_chat_with_driver_title);

            }
        }

    }
}

