package org.hse.demoproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DemoActivity extends AppCompatActivity {
    private TextView result;
    private EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        number = findViewById(R.id.numberInput);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        result = findViewById(R.id.resultText);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String numberVal = number.getText().toString();
                    if (numberVal.isEmpty()) {
                        numberVal = "0";
                    }
                    int number = Integer.parseInt(numberVal);
                    validateNumberRange(number);        // проверка значения на диапазон (от 1 до 10000)
                    int sum = sumNumbersUpTo(number);
                    result.setText("Result: " + sum);   // устанавливаем текст в Result
                    result.setVisibility(View.VISIBLE); // чтобы показать результат
                } catch (NumberFormatException e) {
                    Toast.makeText(DemoActivity.this, "Please enter a valid number between 1 and 10000", Toast.LENGTH_SHORT).show();
                } catch (OutOfRangeException e) {
                    Toast.makeText(DemoActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String numberVal = number.getText().toString();
                    if (numberVal.isEmpty()) {
                        numberVal = "0";
                    }
                    int number = Integer.parseInt(numberVal);
                    validateNumberRange(number);        // проверка значения на диапазон (от 1 до 10000)
                    long product = multiplyEvenNumbersUpTo(number);
                    result.setText("Result: " + product);   // устанавливаем текст в Result
                    result.setVisibility(View.VISIBLE);     // чтобы показать результат
                } catch (NumberFormatException e) {
                    Toast.makeText(DemoActivity.this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
                } catch (OutOfRangeException | ArithmeticException e) {
                    Toast.makeText(DemoActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private int sumNumbersUpTo(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    private long multiplyEvenNumbersUpTo(int n) {
        long product = 1;
        for (int i = 2; i <= n; i += 2) {
            if (product > Long.MAX_VALUE / i) { // проверка на переполнение
                throw new ArithmeticException("Result is too large");
            }
            product *= i;
        }
        return product;
    }

    private void validateNumberRange(int number) throws OutOfRangeException {
        if (number < 1 || number > 10000) {
            throw new OutOfRangeException("Please enter a number between 1 and 10000");
        }
    }
}
