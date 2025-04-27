import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Gravity;



import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button sum, ave;
    Toast toast;
    View view;
    double firstNum = 0, secondNum = 0, total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.etNum1GE3);
        num2 = findViewById(R.id.etNum2GE3);
        sum = findViewById(R.id.btnSumGE3);
        ave = findViewById(R.id.btnAveGE3);

        showSum();
        showAverage();
    }

    public void showSum() {
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1.getText().toString().isEmpty() || num2.getText().toString().isEmpty()) {
                    showErrorToast();
                } else {
                    double firstNum = Double.parseDouble(num1.getText().toString());
                    double secondNum = Double.parseDouble(num2.getText().toString());
                    double sum = firstNum + secondNum;

                    Toast.makeText(MainActivity.this, "SUM: " + sum, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showAverage() {
        ave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1.getText().toString().isEmpty() || num2.getText().toString().isEmpty()) {
                    showErrorToast();
                } else {
                    double firstNum = Double.parseDouble(num1.getText().toString());
                    double secondNum = Double.parseDouble(num2.getText().toString());
                    double ave = (firstNum + secondNum) / 2;

                    Toast.makeText(MainActivity.this, "AVE: " + ave, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showErrorToast() {
        toast = Toast.makeText(getApplicationContext(), "Please Enter a Number", Toast.LENGTH_SHORT);
        View view = toast.getView();
        view.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }
}
