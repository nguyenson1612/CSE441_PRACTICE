package com.example.btth03;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailActivity extends AppCompatActivity {
    private TextView studentName;
    private TextView studentGpa;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        studentName = findViewById(R.id.student_name_detail);
        studentGpa = findViewById(R.id.student_gpa_detail);

        // Lấy thông tin sinh viên từ Intent
        String studentId = getIntent().getStringExtra("studentId");
        student = findStudentById(studentId);

        if (student != null) {
            studentName.setText(student.getName());
            studentGpa.setText(String.valueOf(student.getGpa()));
        }

        // Xử lý khi nhấn nút sửa hoặc xóa
    }

    private Student findStudentById(String id) {
        // Tìm sinh viên theo id
        // Giả sử bạn có danh sách sinh viên
        return new Student(id, "Trinh Van Phuc", 3.5); // Ví dụ
    }
}

