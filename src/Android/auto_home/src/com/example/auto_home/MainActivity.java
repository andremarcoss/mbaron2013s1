package com.example.auto_home;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText txtsenha, txtlogin;
	Button btAcessar;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txtlogin = (EditText) findViewById(R.id.editlogin);
		txtsenha = (EditText) findViewById(R.id.editsenha);

		btAcessar = (Button) findViewById(R.id.btlogar);
		btAcessar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//Log.i("activity_main", "entrou no evento");
				String urlPost = "http://192.168.2.100/android/conexao.php";
				ArrayList<NameValuePair> parametrosPost = new ArrayList<NameValuePair>();
				parametrosPost.add(new BasicNameValuePair("login", txtlogin
						.getText().toString()));
				parametrosPost.add(new BasicNameValuePair("senha", txtsenha
						.getText().toString()));
				String respostaRetorna = null;
				//Log.i("activity_main", "vai entar no try");
				try {
					respostaRetorna = conexaoj.executaHttpPost(urlPost,
							parametrosPost);
					String resposta = respostaRetorna.toString();
					resposta = resposta.replaceAll("\\s", "");
					if (resposta.equals("1")) {
						//Log.i("activity_main", "entrou no if");
						Intent intent = new Intent(MainActivity.this,controlej.class);
						startActivity(intent);
					} else {
						AlertDialog.Builder dialogo = new AlertDialog.Builder(
								MainActivity.this);
						dialogo.setTitle("Aviso");
						dialogo.setMessage("Usuario ou Senha Invalido");
						dialogo.setNeutralButton("OK", null);
						dialogo.show();
					}

				} catch (Exception erro) {
					AlertDialog.Builder dialogo = new AlertDialog.Builder(
							MainActivity.this);
					dialogo.setTitle("Aviso");
					dialogo.setMessage("Erro"+erro);
					dialogo.setNeutralButton("OK", null);
					dialogo.show();
				}
			}
		});
	}

}
