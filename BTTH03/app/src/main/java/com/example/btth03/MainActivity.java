package com.example.btth03;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentAdapter adapter;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Khởi tạo RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Lấy dữ liệu từ JSON và hiển thị
        studentList = loadStudentsFromJson();
        adapter = new StudentAdapter(studentList, new StudentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Student student) {
                // Chuyển đến trang chi tiết khi nhấn vào một sinh viên
                Intent intent = new Intent(MainActivity.this, StudentDetailActivity.class);
                intent.putExtra("studentId", student.getId());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

        // Thiết lập padding cho window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Hàm tải dữ liệu từ JSON (giả sử dữ liệu được lưu trong file local hoặc tải từ server)
    private List<Student> loadStudentsFromJson() {
        // Tải và phân tích JSON thành danh sách sinh viên
        // (Sử dụng Gson, Jackson hoặc cách tự code)
        List<Student> students = new ArrayList<>();
        students.add(new Student("1", "Nguyen Minh Son", 3.5));
        students.add(new Student("2", "Nguyen Van A", 3.7));
        // Thêm nhiều sinh viên khác từ JSON
        return students;
    }
}
