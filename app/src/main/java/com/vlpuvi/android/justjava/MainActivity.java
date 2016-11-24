package com.vlpuvi.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate)
    {
        int pricePerCup = 5;
        if(hasWhippedCream)
        {
            pricePerCup += 1;
        }
        if(hasChocolate)
        {
            pricePerCup +=2;
        }

        return pricePerCup * quantity;
    }

    public void submitOrder(View view)
    {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        EditText nameEditText = (EditText) findViewById(R.id.name_edit_text);
        String name = nameEditText.getText().toString();

        int total = calculatePrice(hasWhippedCream, hasChocolate);

        String message = createOrderSummary(total, hasWhippedCream, hasChocolate, name);
        displayPrice(message);
    }

    public void increment(View view)
    {
        quantity += 1;
        display(quantity);
    }

    public void decrement(View view)
    {
        if(quantity != 0)
        {
            quantity -= 1;
            display(quantity);
        }
        else
        {
            display(0);
        }
    }

    private String createOrderSummary(int price, boolean hasWhippedCream,boolean hasChocolate, String name)
    {
        String priceMessage = "Name : " + name;
        priceMessage += "\nAdd Whipped Cream : " + hasWhippedCream;
        priceMessage += "\nAdd Chololate : " + hasChocolate;
        priceMessage += "\nQuantity : " + quantity;
        priceMessage += "\nTotal : " + price;
        priceMessage += "\nThank you!!";
        return priceMessage;
    }

    private void display(int n)
    {
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+n);
    }

    private void displayPrice(String str)
    {
        TextView orderSummaryTextView = (TextView)findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(str);
    }
}
