package com.example.customview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SwitchActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton toast, snack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.truefalse);
        toast = findViewById(R.id.Toast);
        snack = findViewById(R.id.Snackbar);
        Button buttonOk = findViewById(R.id.OK);
        buttonOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.OK) {
            Intent intent = new Intent();
            if (toast.isChecked()) intent.putExtra("Tag", 1);
            if (snack.isChecked()) intent.putExtra("Tag", 2);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
