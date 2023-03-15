package com.example.infaz_hesaplama.InfazHesaplama;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.deneme.infaz_hesaplama.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import java.util.ArrayList;

public class Sonuc0 extends AppCompatActivity {
    String bihakkinTahliyeSuresi;
    Button btnAyrintili_Sonuc;
    String cagriKagidiYakalamaEmri;
    int cezaevindeKalinacakToplamSureInt = 0;
    String cezaevindeKalinacakToplamSureString;
    int cezaevindeKalinacakToplamSure_RaporOlumsuzsa = 0;
    Context context = this;
    int denSerSuresi_RaporOlumsuzsa = 0;
    String denSerbestlik;
    int denSerbestlikInt = 0;
    String denSerbestlikKisa;
    String dogrudanAcigaGirme;
    String format_cezaevine_giris_tarihi33;
    TextView goster17;
    TextView goster20;
    TextView goster21;
    TextView goster22;
    TextView goster23;
    TextView goster7;
    String indirimler;
    int kapalidaGececekGunSayisi = 0;
    String kapalidanAcigaAyrilmaString;
    private AdView mAdView;
    /* access modifiers changed from: private */
    public InterstitialAd mInterstitialAd;
    int mahsupGunSayisi = 0;
    TextView org_ayr_tes_edilirse;
    TextView org_ayr_tes_edilmezse;
    String orgutAciklamasi;
    String orgutSeciliMi;
    PieChart pie_Chart;
    PieChart pie_Chart_2;
    int sartlaTahliye = 0;
    int sartlaTahliyeIndirimiInt = 0;
    String sartlaTahliyeString;
    String tahliyeTarihiSeciliMi;
    String tarihler;
    TextView tvKapalidan_ayrilma;
    TextView tv_acik_gun;
    TextView tv_acik_gun2;
    TextView tv_den_ser_gun;
    TextView tv_den_ser_gun2;
    TextView tv_kapali_gun;
    TextView tv_kapali_gun2;
    TextView tv_sartla_tah_ind_gun;
    TextView tv_sartla_tah_ind_gun2;
    TextView yatar_Suresi;
    String yatariVarMi;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.sonuc0);
        this.mAdView = (AdView) findViewById(R.id.adView);
        this.mAdView.loadAd(new AdRequest.Builder().build());
        MobileAds.initialize((Context) this, (OnInitializationCompleteListener) new OnInitializationCompleteListener() {
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        InterstitialAd interstitialAd = new InterstitialAd(this);
        this.mInterstitialAd = interstitialAd;
        interstitialAd.setAdUnitId("ca-app-pub-2876770816331493/6076959626");
        this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
        this.mInterstitialAd.setAdListener(new AdListener() {
            public void onAdClosed() {
                Sonuc0.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
                Sonuc0.this.ayintiliSonucEkraninaGec();
            }
        });
        getSupportActionBar().hide();
        TextView textView = (TextView) findViewById(R.id.goster9);
        TextView textView2 = (TextView) findViewById(R.id.tvKapalidan_ayrilma);
        TextView textView3 = (TextView) findViewById(R.id.yatar_Suresi);
        this.pie_Chart = (PieChart) findViewById(R.id.pie_Chart);
        this.pie_Chart_2 = (PieChart) findViewById(R.id.pie_Chart_2);
        this.tv_kapali_gun = (TextView) findViewById(R.id.tv_kapali_gun);
        this.tv_acik_gun = (TextView) findViewById(R.id.tv_acik_gun);
        this.tv_sartla_tah_ind_gun = (TextView) findViewById(R.id.tv_sartla_tah_ind_gun);
        this.tv_den_ser_gun = (TextView) findViewById(R.id.tv_den_ser_gun);
        this.tv_kapali_gun2 = (TextView) findViewById(R.id.tv_kapali_gun2);
        this.tv_acik_gun2 = (TextView) findViewById(R.id.tv_acik_gun2);
        this.tv_sartla_tah_ind_gun2 = (TextView) findViewById(R.id.tv_sartla_tah_ind_gun2);
        this.tv_den_ser_gun2 = (TextView) findViewById(R.id.tv_den_ser_gun2);
        this.org_ayr_tes_edilirse = (TextView) findViewById(R.id.org_ayr_tes_edilirse);
        this.org_ayr_tes_edilmezse = (TextView) findViewById(R.id.org_ayr_tes_edilmezse);
        this.indirimler = getIntent().getExtras().getString("anahtar");
        this.sartlaTahliyeString = getIntent().getExtras().getString("anahtar2");
        this.denSerbestlik = getIntent().getExtras().getString("anahtar3");
        this.dogrudanAcigaGirme = getIntent().getExtras().getString("anahtar4");
        this.kapalidanAcigaAyrilmaString = getIntent().getExtras().getString("anahtar5");
        this.sartlaTahliye = getIntent().getExtras().getInt("anahtar6");
        this.bihakkinTahliyeSuresi = getIntent().getExtras().getString("anahtar7");
        String string = getIntent().getExtras().getString("anahtar8");
        this.yatariVarMi = string;
        ((TextView) findViewById(R.id.goster8)).setText(string);
        String string2 = getIntent().getExtras().getString("anahtar9");
        this.cezaevindeKalinacakToplamSureString = string2;
        textView.setText(string2);
        this.denSerbestlikKisa = getIntent().getExtras().getString("anahtar10");
        this.orgutAciklamasi = getIntent().getExtras().getString("anahtar11");
        this.cezaevindeKalinacakToplamSureInt = getIntent().getExtras().getInt("anahtar12");
        this.kapalidaGececekGunSayisi = getIntent().getExtras().getInt("anahtar13");
        this.denSerbestlikInt = getIntent().getExtras().getInt("anahtar14");
        this.sartlaTahliyeIndirimiInt = getIntent().getExtras().getInt("anahtar15");
        this.mahsupGunSayisi = getIntent().getExtras().getInt("anahtar16");
        this.orgutSeciliMi = getIntent().getExtras().getString("anahtar17");
        this.denSerSuresi_RaporOlumsuzsa = getIntent().getExtras().getInt("anahtar18");
        this.cezaevindeKalinacakToplamSure_RaporOlumsuzsa = getIntent().getExtras().getInt("anahtar19");
        this.cagriKagidiYakalamaEmri = getIntent().getExtras().getString("anahtar20");
        this.format_cezaevine_giris_tarihi33 = getIntent().getExtras().getString("anahtar21");
        this.tarihler = getIntent().getExtras().getString("anahtar22");
        this.tahliyeTarihiSeciliMi = getIntent().getExtras().getString("anahtar23");
        ((Button) findViewById(R.id.btnAyrintili_Sonuc)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Sonuc0.this.mInterstitialAd.isLoaded()) {
                    Sonuc0.this.mInterstitialAd.show();
                } else if (!Sonuc0.this.mInterstitialAd.isLoaded()) {
                    Sonuc0.this.ayintiliSonucEkraninaGec();
                }
            }
        });
        ((Button) findViewById(R.id.btnGeri)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Sonuc0.this.startActivity(new Intent(Sonuc0.this.context, C0520infaz_hesaplama.class));
            }
        });
        if (textView.getText().toString().matches("")) {
            textView.setVisibility(8);
            textView3.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView3.setVisibility(0);
        }
        pastaGrafik();
    }

    public void ayintiliSonucEkraninaGec() {
        Intent intent = new Intent(getApplicationContext(), SonucEkrani.class);
        intent.putExtra("anahtar", this.indirimler);
        intent.putExtra("anahtar2", this.sartlaTahliyeString);
        intent.putExtra("anahtar3", this.denSerbestlik);
        intent.putExtra("anahtar4", this.dogrudanAcigaGirme);
        intent.putExtra("anahtar5", this.kapalidanAcigaAyrilmaString);
        intent.putExtra("anahtar7", this.bihakkinTahliyeSuresi);
        intent.putExtra("anahtar9", this.cezaevindeKalinacakToplamSureString);
        intent.putExtra("anahtar11", this.orgutAciklamasi);
        intent.putExtra("anahtar13", this.kapalidaGececekGunSayisi);
        intent.putExtra("anahtar17", this.orgutSeciliMi);
        intent.putExtra("anahtar20", this.cagriKagidiYakalamaEmri);
        intent.putExtra("anahtar21", this.format_cezaevine_giris_tarihi33);
        intent.putExtra("anahtar22", this.tarihler);
        intent.putExtra("anahtar23", this.tahliyeTarihiSeciliMi);
        startActivity(intent);
    }

    public void pastaGrafik() {
        String str;
        this.pie_Chart.setUsePercentValues(false);
        this.pie_Chart.getDescription().setEnabled(false);
        this.pie_Chart.setDragDecelerationFrictionCoef(0.95f);
        this.pie_Chart.setDrawHoleEnabled(true);
        this.pie_Chart.setHoleColor(-1);
        this.pie_Chart.setEntryLabelTextSize(15.0f);
        this.pie_Chart.setTransparentCircleRadius(61.0f);
        int parseColor = Color.parseColor("#333333");
        this.pie_Chart.setEntryLabelColor(parseColor);
        int i = this.cezaevindeKalinacakToplamSureInt;
        int i2 = this.kapalidaGececekGunSayisi;
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = i - i2;
        if (i3 < 0) {
            i3 = 0;
        }
        int i4 = this.denSerbestlikInt;
        int i5 = this.sartlaTahliyeIndirimiInt;
        ArrayList arrayList = new ArrayList();
        if (i4 > 0) {
            arrayList.add(new PieEntry((float) i4, "Den. Ser."));
        }
        if (i3 > 0) {
            arrayList.add(new PieEntry((float) i3, "Açık"));
        }
        if (i2 > 0) {
            arrayList.add(new PieEntry((float) i2, "Kapalı"));
        }
        if (i5 > 0) {
            arrayList.add(new PieEntry((float) i5, "Şartla Tah. İnd."));
        }
        this.pie_Chart.animateY(1000, Easing.EasingOption.EaseInOutCubic);
        PieDataSet pieDataSet = new PieDataSet(arrayList, "");
        pieDataSet.setSliceSpace(1.0f);
        pieDataSet.setSelectionShift(5.0f);
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        PieData pieData = new PieData(pieDataSet);
        pieData.setValueTextSize(15.0f);
        pieData.setValueTextColor(-1);
        this.pie_Chart.setData(pieData);
        TextView textView = this.tv_kapali_gun;
        textView.setText("Kapalı Cezaevinde: " + i2 + " Gün (" + gunCevirme(i2) + ")");
        if (i3 == 0) {
            this.tv_acik_gun.setText("Açık Cezaevinde: Birkaç gün");
        } else {
            TextView textView2 = this.tv_acik_gun;
            textView2.setText("Açık Cezaevinde: " + i3 + " Gün (" + gunCevirme(i3) + ")");
        }
        TextView textView3 = this.tv_sartla_tah_ind_gun;
        textView3.setText("Şartla Tah. İnd.: " + i5 + " Gün (" + gunCevirme(i5) + ")");
        TextView textView4 = this.tv_den_ser_gun;
        textView4.setText("Denetimli Serbestlik: " + i4 + " Gün (" + gunCevirme(i4) + ")");
        if (Integer.parseInt(this.orgutSeciliMi) == 1) {
            this.pie_Chart_2.setVisibility(0);
            this.tv_kapali_gun2.setVisibility(0);
            this.tv_acik_gun2.setVisibility(0);
            this.tv_sartla_tah_ind_gun2.setVisibility(0);
            this.tv_den_ser_gun2.setVisibility(0);
            this.org_ayr_tes_edilirse.setVisibility(0);
            this.org_ayr_tes_edilmezse.setVisibility(0);
            this.pie_Chart_2.setUsePercentValues(false);
            this.pie_Chart_2.getDescription().setEnabled(false);
            this.pie_Chart_2.setDragDecelerationFrictionCoef(0.95f);
            this.pie_Chart_2.setDrawHoleEnabled(true);
            this.pie_Chart_2.setHoleColor(-1);
            this.pie_Chart_2.setEntryLabelTextSize(15.0f);
            this.pie_Chart_2.setTransparentCircleRadius(61.0f);
            this.pie_Chart_2.setEntryLabelColor(parseColor);
            int i6 = this.cezaevindeKalinacakToplamSure_RaporOlumsuzsa;
            if (i6 < 0) {
                i6 = 0;
            }
            int i7 = this.denSerSuresi_RaporOlumsuzsa;
            ArrayList arrayList2 = new ArrayList();
            if (i7 > 0) {
                str = "Denetimli Serbestlik: ";
                arrayList2.add(new PieEntry((float) i7, "Den. Ser."));
            } else {
                str = "Denetimli Serbestlik: ";
            }
            if (i6 > 0) {
                arrayList2.add(new PieEntry((float) i6, "Kapalı"));
            }
            if (i5 > 0) {
                arrayList2.add(new PieEntry((float) i5, "Şartla Tah. İnd."));
            }
            this.pie_Chart_2.animateY(1000, Easing.EasingOption.EaseInOutCubic);
            PieDataSet pieDataSet2 = new PieDataSet(arrayList2, "");
            pieDataSet2.setSliceSpace(1.0f);
            pieDataSet2.setSelectionShift(5.0f);
            pieDataSet2.setColors(ColorTemplate.MATERIAL_COLORS);
            PieData pieData2 = new PieData(pieDataSet2);
            pieData2.setValueTextSize(15.0f);
            pieData2.setValueTextColor(-1);
            this.pie_Chart_2.setData(pieData2);
            this.tv_acik_gun2.setText("Açık Cezaevinde: Birkaç gün");
            TextView textView5 = this.tv_kapali_gun2;
            textView5.setText("Kapalı Cezaevinde: " + i6 + " Gün (" + gunCevirme(i6) + ")");
            TextView textView6 = this.tv_sartla_tah_ind_gun2;
            textView6.setText("Şartla Tah. İnd.: " + i5 + " Gün (" + gunCevirme(i5) + ")");
            TextView textView7 = this.tv_den_ser_gun2;
            textView7.setText(str + i7 + " Gün (" + gunCevirme(i7) + ")");
            return;
        }
        this.pie_Chart_2.setVisibility(8);
    }

    public static String gunCevirme(int i) {
        int i2;
        int i3;
        int i4 = i % 365;
        if (i4 == 0) {
            return (i / 365) + " Yıl";
        } else if (i > 365 && i4 != 0 && i4 % 30 == 0) {
            return ((int) Math.floor((double) (i / 365))) + " Yıl " + (i4 / 30) + " Ay";
        } else if (i < 365 && i4 != 0 && i4 % 30 == 0) {
            return (i4 / 30) + " Ay";
        } else if (i > 365 && i4 != 0 && (i3 = i4 % 30) != 0) {
            return ((int) Math.floor((double) (i / 365))) + " Yıl " + ((int) Math.floor((double) (i4 / 30))) + " Ay " + i3 + " Gün";
        } else if (i >= 365 || i4 == 0 || (i2 = i4 % 30) == 0) {
            return null;
        } else {
            return ((int) Math.floor((double) (i4 / 30))) + " Ay " + i2 + " Gün";
        }
    }
}
