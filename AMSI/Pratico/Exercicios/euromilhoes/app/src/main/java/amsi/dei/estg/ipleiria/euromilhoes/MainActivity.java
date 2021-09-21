package amsi.dei.estg.ipleiria.euromilhoes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvChave1, tvChave2, tvChave3, tvChave4, tvChave5;
    private TextView tvEstrela1, tvEstrela2;

    private TextView tvChaveAleatoria, tvChaveAleatoria2;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvChave1 = (TextView)findViewById(R.id.tvChave1);
        this.tvChave2 = (TextView)findViewById(R.id.tvChave2);
        this.tvChave3 = (TextView)findViewById(R.id.tvChave3);
        this.tvChave4 = (TextView)findViewById(R.id.tvChave4);
        this.tvChave5 = (TextView)findViewById(R.id.tvChave5);
        this.tvEstrela1 = (TextView)findViewById(R.id.tvEstrela1);
        this.tvEstrela2 = (TextView)findViewById(R.id.tvEstrela2);

        this.tvChaveAleatoria = (TextView)findViewById(R.id.tvChaveAleatoria);
        this.tvChaveAleatoria2 = (TextView)findViewById(R.id.tvChaveAleatoria2);
        this.tvResultado = (TextView)findViewById(R.id.tvResultado);

    }

    /**
     * Trigger no butao "Gerar Chave"
     * @param view
     */
    public void onClickGenerateKey(View view) {


        if (this.tvChave1.getText().toString() != null && this.tvChave2.getText().toString() != null  && this.tvChave3.getText().toString() != null  && this.tvChave4.getText().toString() != null  && this.tvChave5.getText().toString() != null  && this.tvEstrela1.getText().toString() != null  && this.tvEstrela2.getText().toString() != null )
        {

        }
        else
        {
         //o buton aparece quando o ultimo numero (estrela) e introduzido
            int[] numeros = generateKeys(5, 1, 50);
            int[] estrelas = generateKeys(2, 1, 12);

            this.setKeys(this.tvChaveAleatoria, numeros);
            this.setKeys(this.tvChaveAleatoria2, estrelas);

            this.tvResultado.setText("Acertou " + correctKeys(numeros, getNumbers()) + " números, e " + correctKeys(estrelas, getStars()) + " estrelas.");
          }
    }

    /**
     * Gera um numero entre regras especificas e diferentes de "to_do" o Array Return de Integer Array.
     * Generates a number within specified rules and different from all in the array. Returns an Integer.
     * @param min
     * @param max
     * @param array
     * @return int
     */
    private int getRandomNumber(int min, int max, int[] array) {
        if (min > max) {
            return 0;
        } else {
            Random rand = new Random();
            int randInt = 0;
            boolean exists = false;
            do {
                exists = false;
                randInt = rand.nextInt(max - min) + min;
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == randInt) {
                        exists = true;
                    }
                }
            } while(exists);

            return randInt;
        }
    }

    /**
     * Gera uma quantidade de numreos especificos entre 2 numeros. Return de Integer Array.
     * @param quant
     * @param minVal
     * @param maxVal
     * @return int[]
     */
    private int[] generateKeys(int quant, int minVal, int maxVal) {
        int[] numeros = new int[quant];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = getRandomNumber(minVal, maxVal, numeros);
        }

        return numeros;
    }

    /**
     * Por cada Integer no arrany acrescenta na View um novo valor.
     * @param tv
     * @param array
     */
    private void setKeys(TextView tv, int[] array) {
        tv.setText("");
        for (int i = 0; i < array.length; i++) {
            tv.append(array[i] + "");
            if (i < array.length-1) {
                tv.append("   ");
            }
        }
    }

    private int correctKeys(int[] original, int[] compare) {

        int equal = 0;

        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < compare.length; j++) {
                if (original[i] == compare[j]) {
                    equal++;
                }
            }
        }
        return equal;
    }

    private int[] getNumbers() {
        int[] res = {
                Integer.parseInt(tvChave1.getText().toString()),
                Integer.parseInt(tvChave2.getText().toString()),
                Integer.parseInt(tvChave3.getText().toString()),
                Integer.parseInt(tvChave4.getText().toString()),
                Integer.parseInt(tvChave5.getText().toString())
        };
        return res;
    }

    private int[] getStars() {
        int[] res = {
                Integer.parseInt(tvEstrela1.getText().toString()),
                Integer.parseInt(tvEstrela2.getText().toString())
        };
        return res;
    }

}
