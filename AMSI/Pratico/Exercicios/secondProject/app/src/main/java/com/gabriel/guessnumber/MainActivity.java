package com.gabriel.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int Number;
    private int ToGuess = 10;
    private int Tries = 5;
    private EditText InputNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.Number = this.generateNumber(this.ToGuess);
        this.InputNumber = (EditText)findViewById(R.id.inputNumber);

        String aux = getResources().getString(R.string.input_number) + 10;
        InputNumber.setHint(aux);
    }

    public void onclickGuess(View view) {

        int number = Integer.parseInt(this.InputNumber.getText().toString());

        this.Tries--;
        if (this.Tries > 0) {
            if (number < this.Number) {
                this.changeStateString(Color.rgb(255, 165, 0), "Pequeno!");
                //this.showToast("Pequeno!");
            } else if (number > this.Number) {
                this.changeStateString(Color.rgb(255, 165, 0), "Grande!");
                //this.showToast("Grande!");
            } else {
                this.changeStateString(Color.GREEN, "Acertou!");
                //this.showToast("Acertou!");
                this.showRestart();
            }
        } else {
            this.changeStateString(Color.RED, ":( Falhou! Sem mais tentativas");
            this.showRestart();
        }

    }

    private int generateNumber(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    private void showToast(String s) {
        Context context = getApplicationContext();
        CharSequence text = s;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void changeStateString(int color, String text) {
        TextView tvState = (TextView)findViewById(R.id.tvState);
        tvState.setText(text);
        tvState.setTextColor(color);

        TextView tvTries = (TextView)findViewById(R.id.tvTries);
        tvTries.setText("Tentativas: " + this.Tries);

        TextView inputNumber = (TextView)findViewById(R.id.inputNumber);
        inputNumber.setText("");
    }

    private void restartGame() {
        this.Number = this.generateNumber(this.ToGuess);
        this.Tries = 5;
        changeStateString(Color.BLACK, "Novo Jogo!");
        hideRestart();
    }

    public void onclickRestart(View view) {
        restartGame();
    }

    public void showRestart() {
        Button btnRestart = (Button)findViewById(R.id.btnRestart);
        btnRestart.setVisibility(View.VISIBLE);
    }

    public void hideRestart() {
        Button btnRestart = (Button)findViewById(R.id.btnRestart);
        btnRestart.setVisibility(View.INVISIBLE);
    }
}