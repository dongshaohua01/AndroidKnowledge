package com.cmcc.androidknowledge.annotations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cmcc.androidknowledge.R;

/**
 * 元注解：声明注解的注解
 */
public class AnnotationActivity extends AppCompatActivity {


    @InjectView(R.id.tv)
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);

        InjectUtils.injectView(this);

        tv.setText("hello word Annotation!!!");

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(AnnotationActivity.this,AnnotationTwoActivity.class);
              intent.putExtra("name","huahau~");
              AnnotationActivity.this.startActivity(intent);
            }
        });
    }
}