package br.com.arduinocasa;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    ImageView imagemLiga;
    ImageView desligar;
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagemLiga = (ImageView) findViewById(R.id.imagemLiga);

    }
/*
    public void clique(View v){

    }
*/
    public void clicar(View v) {
    //Lista de itens
        ArrayList<String> itens = new ArrayList<String>();
        itens.add("Liga");
        itens.add("Desliga");
        //adapter utilizando um layout customizado (TextView)
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.item_alerta, itens);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Qualifique este software:");
        //define o diálogo como uma lista, passa o adapter.
        builder.setSingleChoiceItems(adapter, 0, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                //Toast.makeText(MainActivity.this, "posição selecionada=" + arg1, Toast.LENGTH_SHORT).show();
                if(arg1 == 0){
                    imagemLiga.setImageResource(R.drawable.btliga);

                }
                else if(arg1 == 1){
                    imagemLiga.setImageResource(R.drawable.btdesliga);
                }
        alerta.dismiss();
            }
        });

        alerta = builder.create();
        alerta.show(); }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
