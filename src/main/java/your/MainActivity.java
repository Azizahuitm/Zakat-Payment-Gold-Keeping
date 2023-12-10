package your.package.name; // Replace with your actual package name

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText weightEditText, valueEditText;
    private Spinner typeSpinner;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = findViewById(R.id.weightEditText);
        valueEditText = findViewById(R.id.valueEditText);
        typeSpinner = findViewById(R.id.typeSpinner);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.gold_types,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateZakat();
            }
        });
    }

    private void calculateZakat() {
        try {
            double weight = Double.parseDouble(weightEditText.getText().toString());
            double value = Double.parseDouble(valueEditText.getText().toString());
            String type = typeSpinner.getSelectedItem().toString();

            double goldValue = weight * value;

            double goldValueZakatPayable;
            double goldWeightMinusX = (type.equals("Keep")) ? Math.max(weight - 85, 0) : Math.max(weight - 200, 0);
            goldValueZakatPayable = goldWeightMinusX * value;

            double zakat = 0.025 * goldValueZakatPayable;

            String result = String.format(
                    "Total Value of the Gold: RM %.2f\n" +
                    "Total Gold Value that is Zakat Payable: RM %.2f\n" +
                    "Total Zakat: RM %.2f", goldValue, goldValueZakatPayable, zakat);

            resultTextView.setText(result);
        } catch (NumberFormatException e) {
            resultTextView.setText("Please enter valid numbers for weight and value.");
        }
    }
}
