package com.bhaskar.mynote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bhaskar.mynote.databinding.ActivityDataInsertBinding;

public class DataInsertActivity extends AppCompatActivity {
ActivityDataInsertBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String type=getIntent().getStringExtra("type");

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("title",binding.title.getText().toString());
                intent.putExtra("disp",binding.disp.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DataInsertActivity.this,MainActivity.class));
    }
}