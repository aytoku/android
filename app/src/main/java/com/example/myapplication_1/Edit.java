//package com.example.myapplication_1;
//
//import android.os.Bundle;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class Edit extends AppCompatActivity {
//    private LinearLayout mLayout;
//    private EditText mEditText;
//    private Button mButton;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.edit);
//        mLayout = (LinearLayout) findViewById(R.id.linearLayout);
//        mEditText = (EditText) findViewById(R.id.editText);
//        mButton = (Button) findViewById(R.id.button);
//        mButton.setOnClickListener(onClick());
//        TextView textView = new TextView(this);
//        textView.setText("New text");
//    }
//
//    private View.OnClickListener onClick() {
//            return new View.OnClickListener() {
//                @Override public void onClick(View v) {
//                    mLayout.addView(createNewTextView(mEditText.getText().toString()));
//                }
//
//                private View createNewTextView(String toString) {
//                    final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                    final TextView textView = new TextView(this); textView.setLayoutParams(lparams);
//                    textView.setText("New text: " + text); return textView;
//                }
//            }; }
//    }
//}
