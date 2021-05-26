package com.cmcc.androidknowledge.annotations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.cmcc.androidknowledge.R;

public class AnnotationTwoActivity extends AppCompatActivity {


    @IntentBindData("name")
    private String name;

    @InjectView(R.id.tv)
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation_two);

        InjectUtils.injectView(this);
        IntentBindDataUtils.inIntentDate(this);

        tv.setText(name);
    }
}