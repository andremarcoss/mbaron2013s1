package com.example.auto_home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.DelayQueue;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.IntToString;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.VideoView;
import android.provider.Settings;

public class controlej extends Activity {
	private Button abri, fechar,ajuste;
	private ToggleButton tgbuttonLuz, tgbuttonTeperatura;
	private SeekBar seekBar;
	private TextView texto;
	private String temp;
	private Boolean verifica = false;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.controle);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.controle);
		this.setVolumeControlStream(AudioManager.STREAM_NOTIFICATION);

		abri = (Button) findViewById(R.id.btabri);
		abri.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				enviaInstrucao("comando", "1001", "enviacomandos");
			}
		});

		fechar = (Button) findViewById(R.id.btfechar);
		fechar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				enviaInstrucao("comando", "1011", "enviacomandos");
			}
		});

		tgbuttonLuz = (ToggleButton) findViewById(R.id.tBluz);
		tgbuttonLuz.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (tgbuttonLuz.isChecked()) {
					enviaInstrucao("comando", "1111", "enviacomandos");

				} else {
					enviaInstrucao("comando", "1110", "enviacomandos");

				}
			}
		});

		tgbuttonTeperatura = (ToggleButton) findViewById(R.id.tBcamera);
		tgbuttonTeperatura.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				if (tgbuttonTeperatura.isChecked()) {

					atualizatemp();
					verifica = true;
					controleSeekBar();

				} else {

					texto = (TextView) findViewById(R.id.textView5);
					texto.setText("0");
					enviaInstrucao("comando", "666", "trocatemp");
					verifica = false;

				}

			}

		});
	}

	private void controleSeekBar() {

		seekBar = (SeekBar) findViewById(R.id.seekBar1);
		seekBar.setMax(50);

		try {

			// Listener to receive changes to the SeekBar4's progress level
			seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

				@Override
				public void onStopTrackingTouch(SeekBar arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onStartTrackingTouch(SeekBar arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onProgressChanged(SeekBar arg0, int progress,
						boolean fromUser) {
					String aux = "";

					if (verifica == true) {

						if ((progress >= 0) && (progress <= 5)) {
							Log.i("seekbar", "5");
							aux = "5";

						} else if ((progress >= 6) && (progress <= 10)) {

							Log.i("seekbar", "10");
							aux = "10";

						} else if ((progress >= 11) && (progress <= 15)) {

							Log.i("seekbar", "15");
							aux = "15";

						} else if ((progress >= 16) && (progress <= 20)) {

							Log.i("seekbar", "20");
							aux = "20";

						} else if ((progress >= 21) && (progress <= 25)) {

							Log.i("seekbar", "25");
							aux = "25";

						} else if ((progress >= 26) && (progress <= 30)) {

							Log.i("seekbar", "30");
							aux = "30";

						} else if ((progress >= 31) && (progress <= 35)) {

							Log.i("seekbar", "35");
							aux = "35";

						} else if ((progress >= 36) && (progress <= 40)) {

							Log.i("seekbar", "40");
							aux = "40";

						} else if ((progress >= 41) && (progress <= 45)) {

							Log.i("seekbar", "45");
							aux = "45";

						} else if ((progress >= 46) && (progress <= 50)) {

							Log.i("seekbar", "50");
							aux = "50";
						}

					}
					trocatemp(aux);

				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void trocatemp(final String x) {

		ajuste = (Button) findViewById(R.id.ajuste);
		ajuste.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String aux = x;
				if (verifica == true) {
					try {
						Log.i("ajuste de temp dentro do else aux2", aux);
						enviaInstrucao("comando", aux, "trocatemp");
						atualizatemp();

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}

				}
			}
		});
	}

	private void atualizatemp() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
			enviaInstrucao("comando", "0000", "retornatemp");
			// Thread.sleep(1000);
			texto = (TextView) findViewById(R.id.textView5);
			texto.setText(temp);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			atualizatemp();
		}

	}

	void enviaInstrucao(String acao, String comando, String pagina) {
		try {
			Thread.sleep(1000);

			Log.i("enviaIstrucao", "entrou no evento");
			String urlPost = "http://192.168.2.100/android/" + pagina + ".php";
			ArrayList<NameValuePair> parametrosPost = new ArrayList<NameValuePair>();
			parametrosPost.add(new BasicNameValuePair(acao, comando));
			String respostaRetorna = null;
			// Log.i("enviaInstrucao", "vai entar no try");
			try {
				respostaRetorna = conexaoj.executaHttpPost(urlPost,
						parametrosPost);
				// Log.i("enviaInstrucao", "dentro do try");
				String resposta = respostaRetorna.toString();
				resposta = resposta.replaceAll("\\s", "");
				temp = resposta;
				// Log.i("resposta temp", temp);
			} catch (Exception erro) {
				erro.printStackTrace();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
