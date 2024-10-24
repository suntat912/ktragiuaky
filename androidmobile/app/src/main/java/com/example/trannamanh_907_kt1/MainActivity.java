package com.example.trannamanh_907_kt1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edittaikhoan;
    private EditText editmatkhau;
    private Button buttondangky;
    private Button buttondangnhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Khởi tạo EditText và Button
        edittaikhoan = findViewById(R.id.edittaikhoan);
        editmatkhau = findViewById(R.id.editmatkhau);
        buttondangky = findViewById(R.id.buttondangky);
        buttondangnhap = findViewById(R.id.buttondangnhap);

        // Thiết lập sự kiện nhấn nút Đăng Ký
        buttondangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến MainActivity2
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


        buttondangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến MainActivity2
                Intent i = getIntent();
                Bundle bundle = i.getExtras();

                if (bundle != null) {
                    String user = bundle.getString("username");
                    String password = bundle.getString("password");

                    // Kiểm tra tài khoản và mật khẩu
                    boolean u = user.equals(edittaikhoan.getText().toString());
                    boolean p = password.equals(editmatkhau.getText().toString());

                    if (u && p) {
                        Toast.makeText(MainActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(MainActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Nhận dữ liệu từ Intent


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}