package com.example.komponenkontrolinput;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class Activity_Kedua extends AppCompatActivity {

    Button btnDate, btnTime;
    TextView tvDate, tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kedua);

        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);
        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);

        Calendar calendar = Calendar.getInstance();

        // DATE PICKER
        btnDate.setOnClickListener(v -> {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    Activity_Kedua.this,
                    (view, y, m, d) -> {
                        tvDate.setText("Tanggal: " + d + "/" + (m + 1) + "/" + y);
                    },
                    year, month, day
            );

            datePickerDialog.show();
        });

        // TIME PICKER
        btnTime.setOnClickListener(v -> {
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    Activity_Kedua.this,
                    (view, h, m) -> {
                        tvTime.setText("Waktu: " + h + ":" + m);
                    },
                    hour, minute, true
            );

            timePickerDialog.show();
        });



    }
}