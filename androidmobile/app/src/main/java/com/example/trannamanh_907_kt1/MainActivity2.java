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

public class MainActivity2 extends AppCompatActivity {

    private EditText edittaikhoan;
    private EditText editPassword;
    private EditText editPasswordRepeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        // Khởi tạo EditText
        edittaikhoan = findViewById(R.id.edittaikhoan);
        editPassword = findViewById(R.id.editpassword);
        editPasswordRepeat = findViewById(R.id.editpasswordrepeat);

        // Khởi tạo nút Đăng Ký
        Button buttonDangKy = findViewById(R.id.buttondangky);

        // Thiết lập sự kiện nhấn nút
        buttonDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String your_username = edittaikhoan.getText().toString();
                String password = editPassword.getText().toString();
                String passwordRepeat = editPasswordRepeat.getText().toString();

                // Kiểm tra mật khẩu
                if (!password.equals(passwordRepeat)) {
                    Toast.makeText(MainActivity2.this, "Mật khẩu lỗi!", Toast.LENGTH_SHORT).show();
                } else {
                    // Hiển thị thông báo Đăng ký thành công
                    Toast.makeText(MainActivity2.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();

                    // Chuyển đến MainActivity
                    Intent i = new Intent(MainActivity2.this, MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("username", your_username);
                    bundle.putString("password", password);
                    i.putExtras(bundle);
                    startActivity(i);
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}