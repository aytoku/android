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

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.osety.amironlibrary.DrawableUtils;

public class MainActivityCountryCodeSelection extends AppCompatActivity {

    ImageButton androidImageButton;

    RecyclerView rv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        androidImageButton = (ImageButton) findViewById(R.id.img_cross_grey);


        setContentView(R.layout.country_code_selection);

        rv = (RecyclerView) findViewById(R.id.rl_country_code_selection_recycler);

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
                    new LinearLayoutManager( getBaseContext(), RecyclerView.VERTICAL, false ) );
            recyclerViewMenu.setItemAnimator( new DefaultItemAnimator() );

        } catch ( NullPointerException e) {
            e.printStackTrace();
        }

    }

    private AdapterGridViewMenu.ItemsMenu[] getMenuItems() {

        AdapterGridViewMenu.ItemsMenu []_arr = new AdapterGridViewMenu.ItemsMenu[]{

                new AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),
                        "Г",
                        R.mipmap.georgia,
                        "Грузия",
                        new AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, "+995"),
                new AdapterGridViewMenu.ItemsMenu(
                        getResources().getColor(R.color.my_gray),"Р",
                        R.mipmap.russia,
                        "Россия",
                        new AdapterGridViewMenu.ItemsMenu.CallBack() {
                            @Override
                            public void call(AdapterGridViewMenu.ItemsMenu itemsMenu) {

                                try {

                                    Bundle _args = new Bundle();

                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, "+7")

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

            ViewGroup v = (ViewGroup) layoutInflater.inflate(R.layout.cell_country_code_selection, viewGroup, false);
            return new ViewHolder(v);

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            final ItemsMenu _item = itemsMenu[i];

            Drawable ic_background_xml = context.getResources().getDrawable(R.mipmap.icon_car);
            float _dens = context.getResources().getDisplayMetrics().density;

            Drawable ic_rout_color = DrawableUtils.setTintDrawable(ic_background_xml, _item.getColorBackground());

            int _size = Math.round(_dens * 40);
            Drawable _def_draw = context.getResources().getDrawable(_item.getImgResId());
            Bitmap _bitmap = DrawableUtils.convertToBitmap(_def_draw, _size, _size);

            viewHolder.img.setBackground( ic_rout_color );
            viewHolder.img.setScaleType(ImageView.ScaleType.CENTER);
            viewHolder.img.setImageBitmap( _bitmap );
            viewHolder.letter.setText( _item.getLetter() );
            viewHolder.title.setText( _item.getStr() );
            viewHolder.time.setText( _item.getTime() );

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
            private String letter;
            private int imgResId;
            private String str;
            private CallBack callBack;
            private String time;

            public ItemsMenu(int colorBackgroundRes, String letter, int imgResId, String str, CallBack callBack,String time) {
                this.colorBackgroundInt = colorBackgroundRes;
                this.letter = letter;
                this.imgResId = imgResId;
                this.str = str;
                this.callBack = callBack;
                this.time = time;
            }

            public CallBack getCallBack() {
                return callBack;
            }

            public String getLetter(){return letter;}

            public int getImgResId() {
                return imgResId;
            }

            public String getStr() {
                return str;
            }

            public String getTime() {
                return time;
            }

            public int getColorBackground() {
                return colorBackgroundInt;
            }

        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView letter;
            private final ImageView img;
            private final TextView title;
            private final TextView time;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                letter = itemView.findViewById(R.id.ll_cell_country_code_selection_letter);
                img = itemView.findViewById(R.id.ll_cell_country_code_selection_img_georgia);
                title = itemView.findViewById(R.id.ll_cell_country_code_selection_country_georgia);
                time = itemView.findViewById(R.id.ll_cell_country_code_selection_georgia_number_code);

            }
        }

    }
}

