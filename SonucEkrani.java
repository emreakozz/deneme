package com.example.infaz_hesaplama.InfazHesaplama;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.deneme.infaz_hesaplama.R;
import com.example.infaz_hesaplama.MainActivity;
import com.example.infaz_hesaplama.sss_ekrani;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class SonucEkrani extends AppCompatActivity {
    Button btn_tarihlere_git;
    Context context = this;
    ImageButton infaz_hesaplaya_don;
    private AdView mAdView;
    ImageButton menuye_don;
    TextView netice20;
    ImageButton sss_a_git;
    TextView tvKapalidanAcigaAyrilma;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.sonuc_ekrani);
        getSupportActionBar().hide();
        this.mAdView = (AdView) findViewById(R.id.adView);
        this.mAdView.loadAd(new AdRequest.Builder().build());
        TextView textView = (TextView) findViewById(R.id.netice5);
        TextView textView2 = (TextView) findViewById(R.id.netice9);
        TextView textView3 = (TextView) findViewById(R.id.top_yatar);
        TextView textView4 = (TextView) findViewById(R.id.netice11);
        TextView textView5 = (TextView) findViewById(R.id.tvKapalidanAcigaAyrilma);
        TextView textView6 = (TextView) findViewById(R.id.Orgut_Aciklama);
        this.infaz_hesaplaya_don = (ImageButton) findViewById(R.id.infaz_hesaplaya_don);
        this.menuye_don = (ImageButton) findViewById(R.id.menuye_don);
        this.sss_a_git = (ImageButton) findViewById(R.id.sss_a_git);
        this.netice20 = (TextView) findViewById(R.id.netice20);
        this.btn_tarihlere_git = (Button) findViewById(R.id.btn_tarihlere_git);
        ((TextView) findViewById(R.id.netice1)).setText(getIntent().getExtras().getString("anahtar"));
        ((TextView) findViewById(R.id.netice2)).setText(getIntent().getExtras().getString("anahtar2"));
        ((TextView) findViewById(R.id.netice3)).setText(getIntent().getExtras().getString("anahtar3"));
        ((TextView) findViewById(R.id.netice4)).setText(getIntent().getExtras().getString("anahtar4"));
        textView.setText(getIntent().getExtras().getString("anahtar5"));
        ((TextView) findViewById(R.id.netice7)).setText(getIntent().getExtras().getString("anahtar7"));
        textView2.setText(getIntent().getExtras().getString("anahtar9"));
        textView4.setText(getIntent().getExtras().getString("anahtar11"));
        int i = getIntent().getExtras().getInt("anahtar13");
        final String string = getIntent().getExtras().getString("anahtar17");
        this.netice20.setText(getIntent().getExtras().getString("anahtar20"));
        final String string2 = getIntent().getExtras().getString("anahtar21");
        final String string3 = getIntent().getExtras().getString("anahtar22");
        String string4 = getIntent().getExtras().getString("anahtar23");
        if (i <= 0) {
            textView.setText("Mahsup süresi kapalıda kalınacak süreden daha fazla (veya eşit) olduğundan, hükümlü 'gir-çık' yapacak. Başka bir deyişle, hükümlü birkaç gün kapalıda kalıp açığa ayrılacak.");
        }
        if (textView4.getText().toString().matches("")) {
            textView4.setVisibility(8);
            textView6.setVisibility(8);
        } else {
            textView4.setVisibility(0);
            textView6.setVisibility(0);
        }
        if (Integer.valueOf(string4).intValue() == 0) {
            this.btn_tarihlere_git.setVisibility(8);
        } else {
            this.btn_tarihlere_git.setVisibility(0);
        }
        this.infaz_hesaplaya_don.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SonucEkrani.this.startActivity(new Intent(SonucEkrani.this.context, C0520infaz_hesaplama.class));
            }
        });
        this.menuye_don.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SonucEkrani.this.startActivity(new Intent(SonucEkrani.this.context, MainActivity.class));
            }
        });
        this.sss_a_git.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SonucEkrani.this.startActivity(new Intent(SonucEkrani.this.context, sss_ekrani.class));
            }
        });
        this.btn_tarihlere_git.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(SonucEkrani.this.getApplicationContext(), tarihler_ekrani.class);
                intent.putExtra("anahtar17", string);
                intent.putExtra("anahtar21", string2);
                intent.putExtra("anahtar22", string3);
                SonucEkrani.this.startActivity(intent);
            }
        });
        if (textView2.getText().toString().matches("")) {
            textView2.setVisibility(8);
            textView3.setVisibility(8);
            return;
        }
        textView2.setVisibility(0);
        textView3.setVisibility(0);
    }
}
