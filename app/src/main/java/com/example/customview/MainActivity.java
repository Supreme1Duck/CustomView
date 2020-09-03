package com.example.customview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static int trueFalse;
    private final String prefValueTag = "PreferenceValue";
    private SharedPreferences preferences;

    public static int gettrueFalse() {
        return trueFalse;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("SharedPreferences", MODE_PRIVATE);
        loadPreferences();
        if (gettrueFalse() == 0) {
            Intent intent = new Intent(MainActivity.this, SwitchActivity.class);
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        assert data != null;
        trueFalse = data.getIntExtra("Tag", 0);
    }

    private void savePreferences() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(prefValueTag, trueFalse);
        editor.apply();
    }

    private void loadPreferences() {
        trueFalse = preferences.getInt(prefValueTag, 0);
    }

    @Override
    protected void onDestroy() {
        savePreferences();
        super.onDestroy();
    }
}
