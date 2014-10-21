package co.ielectron.cuadrado;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Principal extends Activity implements View.OnClickListener{

    private EditText txtNumber;
    private Button btnCalc;
    private String valor;
    private TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtNumber = (EditText) findViewById(R.id.txtNumero);
        btnCalc = (Button) findViewById(R.id.btnCalcular);
        lblResultado = (TextView) findViewById(R.id.lblResultado);

        btnCalc.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Integer valor;
        try{
            valor = Integer.parseInt(txtNumber.getText().toString());
        }catch (NumberFormatException e){
            valor = 0;
        }
        Toast.makeText(
                getBaseContext(),
                "el valor es " + valor * valor,
                Toast.LENGTH_LONG
        ).show();
        Integer cuadrado = valor * valor;
        lblResultado.setText(cuadrado.toString());

    }
}
