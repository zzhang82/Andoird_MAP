//Name: Zheshuang Zhang   ID:011823101
package com.map524s1a.billcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.SeekBar.OnSeekBarChangeListener;

//import com.map524s1a.BillCalculator.R;

//import com.map524s1a.tipcalculator.R;

import java.security.PublicKey;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private SeekBar tipPercentSeekBar;
    private SeekBar taxPercentSeekBar;
    private EditText amountEditText;
    private EditText amountEditText2;
    private TextView amountTextVIew, percentTextView, percentTextView2,subTotalTextView, totalTextView;
    //tipTextView ;

    NumberFormat currentcyFormat = NumberFormat.getCurrencyInstance();
    NumberFormat percentFormat = NumberFormat.getPercentInstance();

    double billAmount, tip, total, subTotal;
    double percent = 0.15;
    double percenttax = 0.13;


    //call when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inner and outter classes R=resources(Outter) and id(Innner) hold serval data field
        setContentView(R.layout.activity_main);

        this.tipPercentSeekBar=(SeekBar) findViewById(R.id.tipPercentSeekBar);
        this.taxPercentSeekBar=(SeekBar) findViewById(R.id.taxPercentSeekBar);
        this.amountEditText=(EditText) findViewById(R.id.amountEditText);
        this.amountEditText2=(EditText) findViewById(R.id.amountEditText);

        this.amountTextVIew=(TextView) findViewById(R.id.amountTextView);
        this.percentTextView=(TextView) findViewById(R.id.percentTextView);

        this.percentTextView2=(TextView) findViewById(R.id.percentTextView2);

        //this.tipTextView=(TextView) findViewById(R.id.tipTextView);
        this.totalTextView=(TextView) findViewById(R.id.totalTextView);
        this.subTotalTextView=(TextView) findViewById(R.id.subTotalTextView);

        //preset default number to 0 on the field
        //this.tipTextView.setText(currentcyFormat.format(0));
        this.totalTextView.setText(currentcyFormat.format(0));
        this.subTotalTextView.setText(currentcyFormat.format(0));


        this.amountEditText.addTextChangedListener(amountEditTextWatcher);
        this.amountEditText2.addTextChangedListener(amountEditTextWatcher2);
        this.tipPercentSeekBar.setOnSeekBarChangeListener(percentSeekBarListener);
        this.taxPercentSeekBar.setOnSeekBarChangeListener(percentSeekBarListener2);



    }

    SeekBar.OnSeekBarChangeListener percentSeekBarListener =
            new SeekBar.OnSeekBarChangeListener(){
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                    //progress is the current value, when have new progress value it will be called 0-30
                    percent = progress /100.00;
                    percentTextView.setText(percentFormat.format(percent));
                    calculate();

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar){

                }
                @Override
                public void onStopTrackingTouch(SeekBar seekBar){

                }

            };

    SeekBar.OnSeekBarChangeListener percentSeekBarListener2 =
            new SeekBar.OnSeekBarChangeListener(){
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                    //progress is the current value, when have new progress value it will be called 0-30
                    percenttax = progress /100.00;
                    percentTextView2.setText(percentFormat.format(percenttax));
                    calculate();

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar){

                }
                @Override
                public void onStopTrackingTouch(SeekBar seekBar){

                }

            };


    public TextWatcher amountEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                String stringAmount = charSequence.toString();
                double doubleAmount = Double.parseDouble(stringAmount);
                billAmount = doubleAmount / 100;
                amountTextVIew.setText(currentcyFormat.format(billAmount));
            } catch (NumberFormatException ex) {
                amountTextVIew.setText("");
                billAmount = 0.0;
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public TextWatcher amountEditTextWatcher2 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                String stringAmount = charSequence.toString();
                double doubleAmount = Double.parseDouble(stringAmount);
                billAmount = doubleAmount / 100;
                amountTextVIew.setText(currentcyFormat.format(billAmount));
            } catch (NumberFormatException ex) {
                amountTextVIew.setText("");
                billAmount = 0.0;
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

                private void calculate() {
                    subTotal = billAmount *(1+percenttax);
                    tip = subTotal * percent;
                    total = subTotal + tip;

                    subTotalTextView.setText(currentcyFormat.format(subTotal));
                    //tipTextView.setText(currentcyFormat.format(tip));
                    totalTextView.setText(currentcyFormat.format(total));
                }


            }


