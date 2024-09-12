package com.example.tallernro1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText numero1, numero2;
    private Button btnCalcularPotencia;
    private RadioGroup radioGroup;
    private RadioButton rbHipotenusa, rbMCM, rbMayor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        btnCalcularPotencia = findViewById(R.id.btnCalcularPotencia);
        radioGroup = findViewById(R.id.radioGroup);
        rbHipotenusa = findViewById(R.id.rbHipotenusa);
        rbMCM = findViewById(R.id.rbMCM);
        rbMayor = findViewById(R.id.rbMayor);

        btnCalcularPotencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPotencia();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               /* switch (checkedId) {
                    case rbHipotenusa:
                        calcularHipotenusa();
                        break;
                    case rbMCM:
                        calcularMCM();
                        break;
                    case rbMayor:
                        calcularMayor();
                        break;
                } */
                RadioButton radioButton = findViewById(checkedId);
                //Toast.makeText(MainActivity.this, "Selected Radio Button is : " + radioButton.getText(), Toast.LENGTH_SHORT).show();
                if (radioButton.getId() == rbHipotenusa.getId()){
                    calcularHipotenusa();
                }
                else if (radioButton.getId()==rbMCM.getId()) {
                    calcularMCM();
                }
                else if (radioButton.getId()==rbMayor.getId()) {
                    calcularMayor();
                }
            }
        });
    }

    private void calcularPotencia() {
        double n1 = Double.parseDouble(numero1.getText().toString());
        double n2 = Double.parseDouble(numero2.getText().toString());
        double resultado = Math.pow(n1, n2);
        Toast.makeText(this, "Potencia: " + resultado, Toast.LENGTH_SHORT).show();
    }

    private void calcularHipotenusa() {
        double n1 = Double.parseDouble(numero1.getText().toString());
        double n2 = Double.parseDouble(numero2.getText().toString());
        double hipotenusa = Math.sqrt(Math.pow(n1, 2) + Math.pow(n2, 2));
        Toast.makeText(this, "Hipotenusa: " + hipotenusa, Toast.LENGTH_SHORT).show();
    }

    private void calcularMCM() {
        int n1 = Integer.parseInt(numero1.getText().toString());
        int n2 = Integer.parseInt(numero2.getText().toString());
        int mcm = (n1 * n2) / gcd(n1, n2);
        Toast.makeText(this, "MCM: " + mcm, Toast.LENGTH_SHORT).show();
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private void calcularMayor() {
        double n1 = Double.parseDouble(numero1.getText().toString());
        double n2 = Double.parseDouble(numero2.getText().toString());
        double mayor = Math.max(n1, n2);
        Toast.makeText(this, "Mayor: " + mayor, Toast.LENGTH_SHORT).show();
    }
}
