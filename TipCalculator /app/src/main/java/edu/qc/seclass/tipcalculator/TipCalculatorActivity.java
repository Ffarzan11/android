package edu.qc.seclass.tipcalculator;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class TipCalculatorActivity extends AppCompatActivity {
    EditText checkAmountValue;
    EditText partySizeValue;
    EditText fifteenPercentTipValue, twentyPercentTipValue, twentyfivePercentTipValue;
    EditText fifteenPercentTotalValue, twentyPercentTotalValue,twentyfivePercentTotalValue;
    Button buttonCompute;
    double perPersonAmount,checkAmountDouble;
    int partySizeInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkAmountValue = findViewById(R.id.checkAmountValue);
        partySizeValue = findViewById(R.id.partySizeValue);
        buttonCompute = findViewById(R.id.buttonCompute);
        fifteenPercentTipValue = findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTipValue = findViewById(R.id.twentyPercentTipValue);
        twentyfivePercentTipValue = findViewById(R.id.twentyfivePercentTipValue);
        fifteenPercentTotalValue = findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotalValue = findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotalValue = findViewById(R.id.twentyfivePercentTotalValue);

        checkAmountValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    checkAmountValue.getBackground().setColorFilter(
                            getResources().getColor(android.R.color.holo_red_light), PorterDuff.Mode.SRC_IN);

                    checkAmountValue.invalidate();
                } else {
                    checkAmountValue.getBackground().clearColorFilter();
                    checkAmountValue.invalidate();
                }
            }
        });

        partySizeValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    partySizeValue.getBackground().setColorFilter(
                            getResources().getColor(android.R.color.holo_red_light), PorterDuff.Mode.SRC_IN);

                    partySizeValue.invalidate();
                } else {
                    partySizeValue.getBackground().clearColorFilter();
                    partySizeValue.invalidate();
                }
            }
        });


        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CharSequence message = "Empty or incorrect value(s)!";
                String checkTextField = checkAmountValue.getText().toString().trim();
                String partySizeTextField = partySizeValue.getText().toString().trim();
                if(checkTextField.isEmpty() || partySizeTextField.isEmpty()) {
                    Toast.makeText(TipCalculatorActivity.this, message, Toast.LENGTH_SHORT).show();
                    return;
                }
                checkAmountDouble = Double.parseDouble(checkAmountValue.getText().toString());
                partySizeInt = Integer.parseInt(partySizeValue.getText().toString());
                if (checkAmountDouble < 0 || partySizeInt <= 0) {
                    Toast.makeText(TipCalculatorActivity.this, message, Toast.LENGTH_SHORT).show();
                    return;
                }
                perPersonAmount = checkAmountDouble/partySizeInt;
                fifteenPercentTip(perPersonAmount);
                twentyPercentTip(perPersonAmount);
                twentyfivePercentTip(perPersonAmount);
            }
        });

    }
    public void fifteenPercentTip(double perPersonAmount ) {
        int fifteenPercent = (int) Math.round(0.15 * perPersonAmount);
        int total = (int) Math.round(fifteenPercent + perPersonAmount);
        String convertTip = Integer.toString(fifteenPercent);
        String convertTotal = Integer.toString(total);
        fifteenPercentTipValue.setText(convertTip);
        fifteenPercentTotalValue.setText(convertTotal);
    }
    public void twentyPercentTip(double perPersonAmount) {
        int twentyPercent = (int) Math.round(0.20 * perPersonAmount);
        int total = (int) Math.round(twentyPercent + perPersonAmount);
        String convertTip = Integer.toString(twentyPercent);
        String convertTotal = Integer.toString(total);
        twentyPercentTipValue.setText(convertTip);
        twentyPercentTotalValue.setText(convertTotal);
    }
    public void twentyfivePercentTip(double perPersonAmount) {
        int twentyfivePercent = (int) Math.round(0.25 * perPersonAmount);
        int total = (int) Math.round(twentyfivePercent + perPersonAmount);
        String convertTip = Integer.toString(twentyfivePercent);
        String convertTotal = Integer.toString(total);
        twentyfivePercentTipValue.setText(convertTip);
        twentyfivePercentTotalValue.setText(convertTotal);
    }

}