package com.example.komponenkontrolinput;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etEmail, etPassword;
    RadioButton rbLaki, rbPerempuan;
    CheckBox cbMembaca, cbOlahraga;
    Spinner spJurusan;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen
        etNama = findViewById(R.id.etNama);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        rbLaki = findViewById(R.id.rbLaki);
        rbPerempuan = findViewById(R.id.rbPerempuan);

        cbMembaca = findViewById(R.id.cbMembaca);
        cbOlahraga = findViewById(R.id.cbOlahraga);

        spJurusan = findViewById(R.id.spJurusan);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Isi data Spinner
        String[] jurusan = {
                "Pilih Jurusan",
                "Teknik Informatika",
                "Sistem Informasi",
                "Manajemen",
                "Akuntansi"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                jurusan
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spJurusan.setAdapter(adapter);

        // Event tombol submit
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nama = etNama.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                // Validasi sederhana
                if (nama.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Semua field harus diisi!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // Gender (manual karena tidak pakai RadioGroup)
                String gender = "";
                if (rbLaki.isChecked()) {
                    gender = "Laki-laki";
                } else if (rbPerempuan.isChecked()) {
                    gender = "Perempuan";
                } else {
                    gender = "Belum dipilih";
                }

                // Hobi
                StringBuilder hobi = new StringBuilder();
                if (cbMembaca.isChecked()) hobi.append("Membaca ");
                if (cbOlahraga.isChecked()) hobi.append("Olahraga ");

                if (hobi.length() == 0) {
                    hobi.append("Tidak ada");
                }

                // Jurusan
                String jurusan = spJurusan.getSelectedItem().toString();

                // Output hasil
                String hasil = "Nama: " + nama +
                        "\nEmail: " + email +
                        "\nPassword: " + password +
                        "\nGender: " + gender +
                        "\nHobi: " + hobi +
                        "\nJurusan: " + jurusan;

                Toast.makeText(MainActivity.this, hasil, Toast.LENGTH_LONG).show();
            }
        });

        // Optional: supaya RadioButton tetap satu pilihan
        rbLaki.setOnClickListener(v -> {
            if (rbLaki.isChecked()) rbPerempuan.setChecked(false);
        });

        rbPerempuan.setOnClickListener(v -> {
            if (rbPerempuan.isChecked()) rbLaki.setChecked(false);
        });

    }
}