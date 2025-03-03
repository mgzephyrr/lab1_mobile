package org.hse.android;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_base);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button studentButton = findViewById(R.id.studentButton);
        Button teacherButton = findViewById(R.id.teacherButton);

        studentButton.setOnClickListener(v ->
                Toast.makeText(BaseActivity.this, getString(R.string.student_click), Toast.LENGTH_SHORT).show()
        );

        teacherButton.setOnClickListener(v ->
                Toast.makeText(BaseActivity.this, getString(R.string.teacher_click), Toast.LENGTH_SHORT).show()
        );
    }
}