package com.example.myapplication_1.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapters.PaymentMethodAdapter;
import com.example.myapplication_1.R;

import java.util.List;

public class NewCardFragment extends Fragment {

    public static final String TAG = "NewCardFragment";
    static final String KEY_CARD_NUMBER = "Key_card_number";
    static final String KEY_DATE = "Key_date";
    static final String KEY_CVV = "Key_cvv";
    
    private EditText editText;
    private EditText editText1;
    private EditText editText2;
    private TextView zero;
    private TextView one;
    private TextView two;
    private TextView three;
    private TextView four;
    private TextView five;
    private TextView six;
    private TextView seven;
    private TextView eight;
    private TextView nine;
    private RecyclerView.Adapter paymentMethodAdapter;
    private List<PaymentMethodAdapter.PaymentMethodItems> itemsMenuList;

    public static NewCardFragment getInstance(Bundle args) {

        NewCardFragment newCardFragment = new NewCardFragment();
        newCardFragment.setArguments(args);

        return newCardFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.new_card,
                container, false);

        ImageButton imageButton = view.findViewById(R.id.rl_new_card_button);
        zero = view.findViewById(R.id.zero);
        one = view.findViewById(R.id.one);
        two = view.findViewById(R.id.two);
        three = view.findViewById(R.id.three);
        four = view.findViewById(R.id.four);
        five = view.findViewById(R.id.five);
        six = view.findViewById(R.id.six);
        seven = view.findViewById(R.id.seven);
        eight = view.findViewById(R.id.eight);
        nine = view.findViewById(R.id.nine);
        editText = view.findViewById(R.id.ll_new_card_card_number_field);
        editText1 = view.findViewById(R.id.ll_new_card_term_field);
        editText2 = view.findViewById(R.id.ll_new_card_cvv_field);
        ImageView delete = view.findViewById(R.id.delete);
        CardView accept_button = view.findViewById(R.id.ll_new_card_cardButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                PaymentMethodFragment paymentMethodFragment = PaymentMethodFragment.getInstance(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, paymentMethodFragment);
                fragmentTransaction.commit();
            }
        });

        accept_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddButtonClicked();
                Bundle bundle = new Bundle();
                PaymentMethodFragment paymentMethodFragment = PaymentMethodFragment.getInstance(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_main, paymentMethodFragment);
                fragmentTransaction.commit();
            }
        });

        cardNumber();

        final int[] len = {0};
        final int[] len1 = {0};
        final int[] len2 = {0};

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(null);
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable s) {
                int i = editText.getText().toString().length();
                if (i < 5)
                    len[0] = 0;
                    if (i == 5 && len[0] < 6) {
                        len[0] = 6;
                        String ss = s.toString();
                        String first = ss.substring(0, ss.length() - 1);
                        String last = ss.substring(ss.length() - 1);
                        editText.setText(first + " " + last);
                        editText.setSelection(editText.getText().length());
                }

                if (i < 10)
                    len1[0] = 0;
                    if (i == 10 && len1[0] < 10) {
                        len1[0] = 11;
                        String ss = s.toString();
                        String first = ss.substring(0, ss.length() - 1);
                        String last = ss.substring(ss.length() - 1);
                        editText.setText(first + " " + last);
                        editText.setSelection(editText.getText().length());
                }

                if (i < 15)
                    len2[0] = 0;
                    if (i == 15 && len2[0] < 15) {
                        len2[0] = 16;
                        String ss = s.toString();
                        String first = ss.substring(0, ss.length() - 1);
                        String last = ss.substring(ss.length() - 1);
                        editText.setText(first + " " + last);
                        editText.setSelection(editText.getText().length());
                }
            }
        });

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable s) {
                int i = editText1.getText().toString().length();
                if (i < 3)
                    len[0] = 0;
                    if (i == 3 && len[0] < 3) {
                        len[0] = 4;
                        String ss = s.toString();
                        String first = ss.substring(0, ss.length() - 1);
                        String last = ss.substring(ss.length() - 1);
                        editText1.setText(first + "/" + last);
                        editText1.setSelection(editText1.getText().length());
                }
            }
        });

        return view;
    }

    private void cardNumber(){
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editText.getId() == R.id.ll_new_card_card_number_field){
                    editText.getText().insert(editText.getSelectionEnd(),"0");
                }
                if(editText1.getId() == R.id.ll_new_card_term_field){
                    editText1.getText().insert(editText1.getSelectionEnd(),"0");
                }
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().insert(editText.getSelectionEnd(),"1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().insert(editText.getSelectionEnd(),"2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().insert(editText.getSelectionEnd(),"3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().insert(editText.getSelectionEnd(),"4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().insert(editText.getSelectionEnd(),"5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().insert(editText.getSelectionEnd(),"6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().insert(editText.getSelectionEnd(),"7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().insert(editText.getSelectionEnd(),"8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().insert(editText.getSelectionEnd(),"9");
            }
        });
    }

    private void validityNumber(){
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.getText().insert(editText1.getSelectionEnd(),"0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.getText().insert(editText1.getSelectionEnd(),"1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.getText().insert(editText1.getSelectionEnd(),"2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.getText().insert(editText1.getSelectionEnd(),"3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.getText().insert(editText1.getSelectionEnd(),"4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.getText().insert(editText1.getSelectionEnd(),"5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.getText().insert(editText1.getSelectionEnd(),"6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.getText().insert(editText1.getSelectionEnd(),"7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.getText().insert(editText1.getSelectionEnd(),"8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.getText().insert(editText1.getSelectionEnd(),"9");
            }
        });
    }

    private void cvv(){
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText2.getText().insert(editText2.getSelectionEnd(),"0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText2.getText().insert(editText2.getSelectionEnd(),"1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText2.getText().insert(editText2.getSelectionEnd(),"2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText2.getText().insert(editText2.getSelectionEnd(),"3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText2.getText().insert(editText2.getSelectionEnd(),"4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText2.getText().insert(editText2.getSelectionEnd(),"5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText2.getText().insert(editText2.getSelectionEnd(),"6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText2.getText().insert(editText2.getSelectionEnd(),"7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText2.getText().insert(editText2.getSelectionEnd(),"8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText2.getText().insert(editText2.getSelectionEnd(),"9");
            }
        });
    }

    private void onAddButtonClicked() {
        try {
            itemsMenuList.add(itemsMenuList.size(), new PaymentMethodAdapter.PaymentMethodItems(
                    R.mipmap.icon_sber,"VISA","","", R.drawable.togle_uncheked,
                    new PaymentMethodAdapter.PaymentMethodItems.CallBack(){
                        @Override
                        public void call(PaymentMethodAdapter.PaymentMethodItems paymentMethodItems){
                            try {
                            }catch (NullPointerException e) {
                                e.printStackTrace();
                            }
                        }
                    })
            );
            paymentMethodAdapter.notifyItemInserted(itemsMenuList.size()-1);
            paymentMethodAdapter.notifyDataSetChanged();
        } catch(NumberFormatException e) {
            Toast.makeText(getActivity().getApplicationContext(), "The field is empty",
                    Toast.LENGTH_SHORT).show();
        }
    }
}