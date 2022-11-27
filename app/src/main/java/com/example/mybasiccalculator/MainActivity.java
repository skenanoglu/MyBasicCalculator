package com.example.mybasiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String operator ;
    TextView tv_result;
    TextView tv_operator;
    TextView tv_new_number;

    Double operand1;
    Double operand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_0 = findViewById(R.id.btn_0);
        Button btn_1 = findViewById(R.id.btn_1);
        Button btn_2 = findViewById(R.id.btn_2);
        Button btn_3 = findViewById(R.id.btn_3);
        Button btn_4 = findViewById(R.id.btn_4);
        Button btn_5 = findViewById(R.id.btn_5);
        Button btn_6 = findViewById(R.id.btn_6);
        Button btn_7 = findViewById(R.id.btn_7);
        Button btn_8 = findViewById(R.id.btn_8);
        Button btn_9 = findViewById(R.id.btn_9);


        Button btn_dot = findViewById(R.id.btn_dot);
        Button btn_ac = findViewById(R.id.btn_ac);
        Button btn_del = findViewById(R.id.btn_del);
        Button btn_percent = findViewById(R.id.btn_percent);
        Button btn_equal = findViewById(R.id.btn_equal);
        Button btn_plus = findViewById(R.id.btn_plus);
        Button btn_minus = findViewById(R.id.btn_minus);
        Button btn_multp = findViewById(R.id.btn_multp);
        Button btn_divide = findViewById(R.id.btn_dvd);

        tv_operator=  findViewById(R.id.tv_operator);
        tv_result =  findViewById(R.id.tv_result);
        tv_new_number =  findViewById(R.id.tv_new_number);


        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                tv_new_number.append(button.getText().toString());
            }
        };

       btn_0.setOnClickListener(numberListener);
       btn_1.setOnClickListener(numberListener);
       btn_2.setOnClickListener(numberListener);
       btn_3.setOnClickListener(numberListener);
       btn_4.setOnClickListener(numberListener);
       btn_5.setOnClickListener(numberListener);
       btn_6.setOnClickListener(numberListener);
       btn_7.setOnClickListener(numberListener);
       btn_8.setOnClickListener(numberListener);
       btn_9.setOnClickListener(numberListener);


       View.OnClickListener operatorListener = new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                Button button = (Button) view;
                String op =button.getText().toString();
                String value = tv_new_number.getText().toString();

                try {
                    Double doubleValur = Double.valueOf(value);
                    PerformOperation(doubleValur,op);
                }
                catch(NumberFormatException e){
                    e.printStackTrace();
                }
                operator = op;
                tv_operator.setText(operator);

           }
       };


        btn_dot.setOnClickListener(operatorListener);
        btn_ac.setOnClickListener(operatorListener);
        btn_del.setOnClickListener(operatorListener);
        btn_percent.setOnClickListener(operatorListener);
        btn_equal.setOnClickListener(operatorListener);
        btn_plus.setOnClickListener(operatorListener);
        btn_minus.setOnClickListener(operatorListener);
        btn_multp.setOnClickListener(operatorListener);
        btn_divide.setOnClickListener(operatorListener);



        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv_new_number.getText().toString().length()>0)
                {
                    tv_new_number.setText(tv_new_number.getText().toString().substring(0,tv_new_number.getText().toString().length()-1));
                }
            }
        });


        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_new_number.setText("");
                tv_result.setText("");
                tv_operator.setText("");
            }
        });


    }
    private void PerformOperation(Double value,String op){
        if(operand1 ==null ){
            operand1 = value;
        }
        else{
            operand2 =value ;
            if(operator == "=")
            {
                operator = op;
            }

            switch (operator){
                case "=":
                    operand1=operand2;
                    break;
                case "+":
                    operand1 +=operand2 ;
                    break;
                case "-":
                    operand1 +=operand2 ;
                    break;
                case "x":
                    operand1 *=operand2 ;
                    break;
                case "/":
                    if(operand2==0)
                    {
                        operand1=0.0;
                    }
                    operand1/=operand2;
                    break;
                case "%":
                    operand1*=operand2/100;
                    break;


            }

        }

        tv_result.setText(operand1.toString());
        tv_new_number.setText("");

    }
}