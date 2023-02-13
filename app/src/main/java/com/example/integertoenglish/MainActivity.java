package com.example.integertoenglish;


import androidx.appcompat.app.AppCompatActivity;
import  android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.os.Bundle;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputField = findViewById(R.id.input_field);
        Button displayButton = findViewById(R.id.display_button);
        final TextView outputView = findViewById(R.id.output_view);

        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputString = inputField.getText().toString();
                int inputNumber = Integer.parseInt(inputString);
                String converted = convert(inputNumber);
                outputView.setText(converted);
            }
        });
    }

    public static String convert(int num){
        String str = "";

        HashMap<Integer,String> map = new HashMap<Integer, String>();
        map.put(0, "");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");



        int[] digits = getDigitsArray(num);
        int count =digits.length; // number of digits

        while(count>=1){


            int digit  = digits[count-1];
            num = num - (digit*(  (int)Math.pow(10.0, count-1)    )); // this is to remove the first digit from the number

            if(count==9 || count==6 || count==3){
                str = str + map.get(digit) + " hundred ";

            }else if(count==8 || count==5 || count==2){
                if(digit==0){

                }else if(digit==8){
                    str = str + "eighty ";
                }else if(digit==5){
                    str = str + "fifty ";
                }else if(digit==4){
                    str = str + "forty ";
                }else if(digit==3){
                    str = str + "thirty ";
                }else if(digit==2){
                    str = str + "twenty ";
                }else if(digit==1){
                    int x = digits[count-2];
                    if(x==0){
                        str = str + "ten ";
                    }else if(x==1){
                        str = str + "eleven ";
                    }else if(x==2){
                        str = str + "twelve ";
                    }else if(x==3){
                        str = str + "thirteen ";
                    }else if(x==4){
                        str = str + "forteen ";
                    }else if(x==5){
                        str = str + "fifteen ";
                    }else if(x==6){
                        str = str + "sixteen ";
                    }else if(x==7){
                        str = str + "seventeen ";
                    }else if(x==8){
                        str = str + "eighteen ";
                    }else if(x==9){
                        str = str + "nineteen ";
                    }

                    if(count==8){
                        str =  str+ "million and ";
                    }
                    if(count==5){
                        str =  str+ "thousand and ";
                    }
                    count--;
                }else{
                    str = str + map.get(digit)+ "ty ";
                }
            }else{
                str = str + map.get(digit) ;
                if(count==7){
                    str =  str+ " million and ";
                }
                if(count==4){
                    str =  str+ " thousand and ";
                }

            }

            count--;

        }
        return str;

    }

    public static int[] getDigitsArray(int number) { // stores the digits of a number in an array
        String numberAsString = Integer.toString(number);
        int[] digitsArray = new int[numberAsString.length()];

        for (int i = 0; i < numberAsString.length(); i++) {
            digitsArray[i] = Character.getNumericValue(numberAsString.charAt(i));
        }
        int start = 0;
        int end = digitsArray.length - 1;

        while (start < end) {
            int temp = digitsArray[start];
            digitsArray[start] = digitsArray[end];
            digitsArray[end] = temp;

            start++;
            end--;
        }

        return digitsArray;
    }
}
