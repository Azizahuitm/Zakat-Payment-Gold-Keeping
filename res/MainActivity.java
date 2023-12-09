package your.package.name; // Replace with your actual package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText, groupEditText, studentNumberEditText, programmeCodeEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        groupEditText = findViewById(R.id.groupEditText);
        studentNumberEditText = findViewById(R.id.studentNumberEditText);
        programmeCodeEditText = findViewById(R.id.programmeCodeEditText);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get entered details
                String name = nameEditText.getText().toString();
                String group = groupEditText.getText().toString();
                String studentNumber = studentNumberEditText.getText().toString();
                String programmeCode = programmeCodeEditText.getText().toString();

                // Pass details to the AboutActivity
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("group", group);
                intent.putExtra("studentNumber", studentNumber);
                intent.putExtra("programmeCode", programmeCode);
                startActivity(intent);
            }
        });
    }
}
