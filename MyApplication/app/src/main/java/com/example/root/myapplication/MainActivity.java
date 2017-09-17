package com.example.root.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Manifest;

/*
Activity principal
 */
public class MainActivity extends AppCompatActivity {

    /*Lista de strings contendo nossas string informadas no formulario*/
    private List<String> tasks = new ArrayList<String>();
    /*Objeto que pertece a classe view do android, será referenciado ao nosso recurso xml para criar uma lista vertical */
    private ListView listView;
    /*converte cada objeto na lista de strings em um item da listview que será populdo*/
    private ArrayAdapter arrayAdapter;

    /*on create é o primeiro estágio do ciclo de vida do aplicativo android, cria o layout e inicia as operações
    * Bundle, são os pacotes para iniciar a activity
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*inicializar os atributos da activity*/

        /*Obtem o listView no xml por meio da classe R e o id da listview*/
        listView = (ListView) findViewById(R.id.listView);

        /*array adapter responśavel por criar a lista vertical*/
        arrayAdapter = new ArrayAdapter(this,
                R.layout.item_task,
                R.id.textView,
                tasks);

        /*Seta o array adapter na listview*/
        listView.setAdapter(arrayAdapter);
        message(this, "onCreate()");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    /*método para ações do menu do topo*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_task:
                final EditText editText = new EditText(this);

                /*Abre  dialog e configura como será o comportamento do mesmo*/
                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("Add new task")
                        .setMessage("What do you want to add?")
                        .setView(editText)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String task = String.valueOf(editText.getText());

                                arrayAdapter.add(task);
                                Log.d("MAIN", "Task added: " + tasks);
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();

                dialog.show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*foi criado um onclick no botão e este método é responśavel pela configuração da ação*/
    public void removeTask(View view) {
        View parent = (View) view.getParent();

        TextView task = (TextView) parent.findViewById(R.id.textView);
        String taskText = String.valueOf(task.getText());

        arrayAdapter.remove(taskText);
        arrayAdapter.notifyDataSetChanged();
    }

    /*mensagem de ação*/
    public void message(Context context, String mesage){
        Toast.makeText(context, mesage, Toast.LENGTH_SHORT).show();
    }

    protected void onStart(){
        super.onStart();
        message(this, "onStart()");
    }

    protected void onRestart(){
        super.onRestart();
        message(this, "onRestart()");
    }

    protected void onResume(){
        super.onResume();
        message(this, "onResume()");
    }

    protected void onPause(){
        super.onPause();
        message(this, "onPause");
    }

    protected void onStop(){
        super.onStop();
        message(this, "onStop()");
    }

    protected void onDestroy(){
        super.onDestroy();
        message(this, "onDestroy()");
    }

    public void changeActivity(View view){
        //Intent it = new Intent(this, NewActivity.class);
        //startActivity(it);

       /* Intent it = new Intent(this, NewActivity.class);
        Bundle b = new Bundle();
        b.putString("key", "testando bundle");
        it.putExtras(b);
        startActivity(it);*/

        /*Uri uri = Uri.parse("http://google.com.br");
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);*/


        /*Uri uri = Uri.parse("tel:12345678");
        Intent it = new Intent(Intent.ACTION_CALL, uri);
        startActivity(it);*/

       Intent it = new Intent(this, NewActivity.class);
        int codigo = 1;
        startActivityForResult(it, codigo);
    }

    /*resposta do startActivityForResult*/
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        Bundle b = data.getExtras();
        String retorno = b.getString("Resposta");

        Log.d("MAIN", retorno);

        if (requestCode == 1) {

        }

        if(requestCode == 2){

        }
    }

}
