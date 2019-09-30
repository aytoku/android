package com.example.myapplication_1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityCodeScreen extends AppCompatActivity {

    EditText code_field1;
    EditText code_field2;
    EditText code_field3;
    EditText code_field4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.code);

        code_field1 = (EditText)findViewById(R.id.ll_code_screen1);
        code_field2 = (EditText)findViewById(R.id.ll_code_screen2);
        code_field3 = (EditText)findViewById(R.id.ll_code_screen3);
        code_field4 = (EditText)findViewById(R.id.ll_code_screen4);


        code_field1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                code_field1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean b) {
                        if(code_field1.getText().toString().length()==0) {
                            code_field1.getText();
                        }
                    }
                });
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {

                if(code_field1.getText().toString().length()==1) {
                    code_field2.requestFocus();
                    code_field1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View view, boolean b) {

                            code_field1.setText("");
                        }
                    });
                }
            }
        });

        code_field2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count) {
                code_field2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean b) {
                        if(code_field2.getText().toString().length()==0) {
                            code_field2.getText();
                        }
                    }
                });
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {
                if(code_field2.getText().toString().length()==1) {
                    code_field3.requestFocus();
                    code_field2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View view, boolean b) {

                            code_field2.setText("");

                        }
                    });
                }
            }
        });

        code_field3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count) {
                code_field3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean b) {
                        if(code_field3.getText().toString().length()==0) {
                            code_field3.getText();
                        }
                    }
                });
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void afterTextChanged(Editable s) {
                if(code_field3.getText().toString().length()==1) {
                    code_field4.requestFocus();
                    code_field3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View view, boolean b) {
                            code_field3.setText("");
                        }
                    });
                }
            }
        });

        code_field4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_UP) {

                    code_field3.requestFocus();
                }
                return false;
            }
        });
        code_field3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_UP) {

                    code_field2.requestFocus();
                }
                return false;
            }
        });

        code_field2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_UP) {

                    code_field1.requestFocus();
                }
                return false;
            }
        });
    }
}
