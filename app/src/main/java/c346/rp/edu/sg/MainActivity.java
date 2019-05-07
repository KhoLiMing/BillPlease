package c346.rp.edu.sg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView textTotal;
    TextView textPerPerson;
    Button buttonCalc;
    Button buttonReset;
    ToggleButton toggleServiceCharge;
    ToggleButton toggleGST;
    EditText editAmount;
    EditText editPeople;
    double gst = 1 ;
    double service = 1 ;
    double amount = 0;
    int people = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCalc = findViewById(R.id.buttonCalc);
        buttonReset = findViewById(R.id.buttonReset);
        textTotal = findViewById(R.id.textTotal);
        textPerPerson = findViewById(R.id.textPerPerson);
        toggleServiceCharge = findViewById(R.id.toggleServiceCharge);
        toggleGST = findViewById(R.id.toggleGST);
        editAmount = findViewById(R.id.editAmount);
        editPeople = findViewById(R.id.editPeople);



        buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(toggleGST.isChecked() == true){
                            gst = 1.07 ;
                 }
                 if(toggleServiceCharge.isChecked() == true){
                            service = 1.10;
                        }

                amount = Double.parseDouble(editAmount.getText().toString());
                people =  Integer.parseInt(editPeople.getText().toString());
                String total = String.format("%.2f", (amount * service * gst));
                String perperson = String.format("%.2f", (amount * service * gst)/ people);
                textTotal.setText(total);
                textPerPerson.setText(perperson);

            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editAmount.setText("");
                editPeople.setText("");
                textTotal.setText("");
                textPerPerson.setText("");
            }
        });
        }
}
