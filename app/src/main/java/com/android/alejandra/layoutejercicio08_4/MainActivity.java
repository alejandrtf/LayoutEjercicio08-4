package com.android.alejandra.layoutejercicio08_4;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvRojo, tvNaranja, tvAmarillo, tvVerde, tvAzul, tvIndigo, tvVioleta;
    private int contPulsadas = 0; //no bandas pulsadas
    private TextView bandaAnterior = null;
    private String textoPrimera;
    private int colorFondoPrimera;
    private ColorStateList colorTextoPrimera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //obtengo referencias
        initReferencias();
        initListeners();

    }

    /**
     * Asigno listeners
     */
    private void initListeners() {
        tvRojo.setOnClickListener(this);
        tvAmarillo.setOnClickListener(this);
        tvAzul.setOnClickListener(this);
        tvIndigo.setOnClickListener(this);
        tvNaranja.setOnClickListener(this);
        tvVerde.setOnClickListener(this);
        tvVioleta.setOnClickListener(this);
    }

    /**
     * Obtengo referencias
     */
    private void initReferencias() {
        tvRojo = (TextView) findViewById(R.id.tvRojo);
        tvAmarillo = (TextView) findViewById(R.id.tvAmarillo);
        tvAzul = (TextView) findViewById(R.id.tvAzul);
        tvIndigo = (TextView) findViewById(R.id.tvIndigo);
        tvNaranja = (TextView) findViewById(R.id.tvNaranja);
        tvVerde = (TextView) findViewById(R.id.tvVerde);
        tvVioleta = (TextView) findViewById(R.id.tvViolet);

    }


    /**
     * Método que  permite intercambiar el nombre de dos colores, al pulsar primero en uno y luego
     * en otro.
     *
     * @param tvPrimera TextView pulsada en primer lugar
     * @param tvSegunda TextView pulsada en segundo lugar
     */
    public void intercambiarBanda(TextView tvPrimera, TextView tvSegunda) {

        // intercambiar las bandas (color y texto)
        // guardo el texto de la primera banda en una auxiliar
        textoPrimera = tvPrimera.getText().toString();
        //guardo el color de la primera banda en una auxiliar
        colorFondoPrimera = ((ColorDrawable)tvPrimera.getBackground()).getColor();
        //guardo el color del texto de la primera banda en una auxiliar
        colorTextoPrimera=tvPrimera.getTextColors();

        // cambio el texto de la primera por el de  la segunda
        tvPrimera.setText(tvSegunda.getText());
        //cambio el color de la primera por el de la segunda
       tvPrimera.setBackgroundColor(((ColorDrawable)tvSegunda.getBackground()).getColor());
        //cambio el color del texto de la primera por el de la segunda
        tvPrimera.setTextColor(tvSegunda.getTextColors());

        // cambio el texto de la segunda por el de  la primera
        tvSegunda.setText(textoPrimera);
        //cambio el color de la segunda por el de la primera
        tvSegunda.setBackgroundColor(colorFondoPrimera);
        tvSegunda.setTextColor(colorTextoPrimera);
        // reinicio el contador
        contPulsadas = 0;
    }


    @Override
    public void onClick(View v) {
        TextView pulsada = (TextView) v;

        Toast.makeText(this, "Has pulsado " + pulsada.getText().toString() + "!!!", Toast.LENGTH_SHORT).show();

        if (contPulsadas == 0) {
            // primera vez que se pulsa una banda
            bandaAnterior = pulsada;
            contPulsadas++;
        } else {
            // no es la primera banda que se pulsa
            if (contPulsadas == 1) {
                intercambiarBanda(bandaAnterior, pulsada);
            }
        }
    }
}
