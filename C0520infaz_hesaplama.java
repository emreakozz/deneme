package com.example.infaz_hesaplama.InfazHesaplama;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.deneme.infaz_hesaplama.R;
import com.example.infaz_hesaplama.MainActivity;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.ReadableInstant;

/* renamed from: com.example.infaz_hesaplama.InfazHesaplama.infaz_hesaplama */
public class C0520infaz_hesaplama extends AppCompatActivity implements View.OnClickListener {
    ImageButton Ib_takvim_cezaevi_giris_tarihi;
    LinearLayout LinLayout_YaslilikCocukDurumu;
    ImageButton alertAcigaAyrilma;
    ImageButton alertBirinciGrupSuclar;
    ImageButton alertCocukYasDenSer4Yil;
    ImageButton alertDialog6545SK;
    ImageButton alertDialogTekerrur;
    ImageButton alertDialog_SucuSeciniz2;
    ImageButton alertDorduncuGrupSuclar;
    ImageButton alertIkinciGrupSuclar;
    ImageButton alertMahsup;
    ImageButton alertOrgutCinsel;
    ImageButton alertSucGrubu;
    ImageButton alertUcuncuGrupSuclar;
    String bihakkinTahliyeSuresi = "";
    Button btn_hesapla;
    Button btn_temizle;
    EditText cAy;
    EditText cAy2;
    EditText cGun;
    EditText cGun2;
    EditText cYil;
    EditText cYil2;
    String cagriKagidiYakalamaEmri = "";
    int cezaevindeKalinacakToplamSureInt = 0;
    String cezaevindeKalinacakToplamSureString = "";
    int cezaevindeKalinacakToplamSure_RaporOlumsuzsa = 0;
    Context context = this;
    int denSerSuresi_RaporOlumsuzsa = 0;
    String denSerbestlik = "";
    int denSerbestlikInt = 0;
    String denSerbestlikKisa = "";
    String dogrudanAcigaGirme = "";
    LinearLayout etTekerrurSure;
    GridLayout grid6545SK;
    GridLayout gridTekerrur;
    RadioGroup grup2016;
    RadioGroup grup2020;
    String indirimler = "";
    int kapalidaGececekGunSayisi = 0;
    String kapalidanAcigaAyrilmaString = "";
    LinearLayout kompleTekerrur;
    LinearLayout layout_Etkin_Pismanlik;
    LinearLayout layout_tahliye_tarihi;

    /* renamed from: layout_uyuşturucu_cinsel  reason: contains not printable characters */
    LinearLayout f182layout_uyuturucu_cinsel;
    LinearLayout linLayoutSucGrubu;
    String[] listItems;
    private AdView mAdView;
    EditText mahsupGun;
    int mahsupGunSayisi = 0;
    RadioButton oncesi2016;
    RadioButton oncesi2020;
    String orgutAciklamasi = "";
    String orgutSeciliMi = "";
    int position = 0;
    RadioButton rb6545SKOnce;
    RadioButton rb6545SKSonra;
    RadioButton rbAcigaAyrilmaEvet;
    RadioButton rbAcigaAyrilmaHayir;
    RadioButton rbBirinciGrupSuc;
    RadioButton rbBirinciTekerrur;
    RadioButton rbCocukYaslilikEvet;
    RadioButton rbCocukYaslilikHayir;
    RadioButton rbDorduncuGrupSuc;
    RadioButton rbEtkin_Evet;
    RadioButton rbEtkin_Hayir;
    RadioButton rbIkinciGrupSuc;
    RadioButton rbIkinciTekerrur;
    RadioButton rbKast;
    RadioButton rbMahsupEvet;
    RadioButton rbMahsupHayir;
    RadioButton rbOrgutCinselEvet;

    /* renamed from: rbOrgutCinselHayır  reason: contains not printable characters */
    RadioButton f183rbOrgutCinselHayr;
    RadioButton rbTaksir;
    RadioButton rbTekerrurEvet;
    RadioButton rbTekerrurHayir;
    RadioButton rbUcuncuGrupSuc;
    RadioButton rb_tahliye_tarihi_evet;
    RadioButton rb_tahliye_tarihi_hayir;
    /* access modifiers changed from: private */
    public RewardedVideoAd rewardedVideoAd;
    RadioGroup rg_SucGruplari;
    RadioGroup rg_YaslilikCocuk;
    int sartlaTahliye = 0;
    int sartlaTahliyeIndirimiInt = 0;
    String sartlaTahliyeString = "";
    RadioButton sonrasi2016;
    RadioButton sonrasi2020;
    StringBuffer sonuc;
    String tahliyeTarihiSeciliMi = "";
    EditText takvim;
    String tarihler = "";
    TextView tvCeza;
    TextView tv_seciliSuc;
    String videoReklamGosterilsinMi = "Hayır";
    String yatariVarMi = "";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.infazhesaplama);
        init();
        getSupportActionBar().hide();
        this.mAdView = (AdView) findViewById(R.id.adView);
        this.mAdView.loadAd(new AdRequest.Builder().build());
        odulluReklam();
        this.btn_hesapla.setOnClickListener(this);
        this.alertDialogTekerrur.setOnClickListener(this);
        this.alertMahsup.setOnClickListener(this);
        this.alertOrgutCinsel.setOnClickListener(this);
        this.alertDialog6545SK.setOnClickListener(this);
        this.alertSucGrubu.setOnClickListener(this);
        this.alertBirinciGrupSuclar.setOnClickListener(this);
        this.alertIkinciGrupSuclar.setOnClickListener(this);
        this.alertUcuncuGrupSuclar.setOnClickListener(this);
        this.alertDorduncuGrupSuclar.setOnClickListener(this);
        this.alertAcigaAyrilma.setOnClickListener(this);
        this.btn_temizle.setOnClickListener(this);
        this.Ib_takvim_cezaevi_giris_tarihi.setOnClickListener(this);
        this.alertDialog_SucuSeciniz2.setOnClickListener(this);
        this.alertCocukYasDenSer4Yil.setOnClickListener(this);
        gorunurluk();
        sayac();
    }

    public void odulluReklam() {
        MobileAds.initialize((Context) this, "ca-app-pub-2876770816331493~2866832183");
        RewardedVideoAd rewardedVideoAdInstance = MobileAds.getRewardedVideoAdInstance(this);
        this.rewardedVideoAd = rewardedVideoAdInstance;
        rewardedVideoAdInstance.loadAd("ca-app-pub-2876770816331493/9729722962", new AdRequest.Builder().build());
        this.rewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            public void onRewardedVideoAdLeftApplication() {
            }

            public void onRewardedVideoAdOpened() {
            }

            public void onRewardedVideoCompleted() {
            }

            public void onRewardedVideoStarted() {
            }

            public void onRewardedVideoAdLoaded() {
                Log.i("Info", "Video reklam yüklendi");
            }

            public void onRewardedVideoAdClosed() {
                C0520infaz_hesaplama.this.rewardedVideoAd.loadAd("ca-app-pub-2876770816331493/9729722962", new AdRequest.Builder().build());
                AlertDialog.Builder builder = new AlertDialog.Builder(C0520infaz_hesaplama.this.context);
                builder.setIcon((int) R.drawable.icon_vector_video);
                builder.setTitle((CharSequence) "Reklam Uyarısı").setMessage((CharSequence) "Video reklamın tamamını izlemezseniz, maalesef sonucu göremezsiniz...").setCancelable(false).setPositiveButton((CharSequence) "KAPAT", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).setNegativeButton((CharSequence) "Reklam İzle", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (C0520infaz_hesaplama.this.rewardedVideoAd.isLoaded()) {
                            C0520infaz_hesaplama.this.rewardedVideoAd.show();
                        } else if (!C0520infaz_hesaplama.this.rewardedVideoAd.isLoaded()) {
                            C0520infaz_hesaplama.this.hesapla();
                        }
                    }
                }).show();
            }

            public void onRewarded(RewardItem rewardItem) {
                C0520infaz_hesaplama.this.hesapla();
            }

            public void onRewardedVideoAdFailedToLoad(int i) {
                Log.i("Info", "Video reklamda hata oluştu");
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        this.rewardedVideoAd.resume(this);
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.rewardedVideoAd.pause(this);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.rewardedVideoAd.destroy(this);
        super.onDestroy();
    }

    public void init() {
        this.cYil = (EditText) findViewById(R.id.cYil);
        this.cAy = (EditText) findViewById(R.id.cAy);
        this.cGun = (EditText) findViewById(R.id.cGun);
        this.cYil2 = (EditText) findViewById(R.id.cYil2);
        this.cAy2 = (EditText) findViewById(R.id.cAy2);
        this.cGun2 = (EditText) findViewById(R.id.cGun2);
        this.takvim = (EditText) findViewById(R.id.takvim);
        this.mahsupGun = (EditText) findViewById(R.id.mahsupGun);
        this.btn_hesapla = (Button) findViewById(R.id.btn_hesapla);
        this.btn_temizle = (Button) findViewById(R.id.btn_temizle);
        this.tvCeza = (TextView) findViewById(R.id.tvCeza);
        this.tv_seciliSuc = (TextView) findViewById(R.id.tv_seciliSuc);
        this.oncesi2016 = (RadioButton) findViewById(R.id.oncesi2016);
        this.sonrasi2016 = (RadioButton) findViewById(R.id.sonrasi2016);
        this.oncesi2020 = (RadioButton) findViewById(R.id.oncesi2020);
        this.sonrasi2020 = (RadioButton) findViewById(R.id.sonrasi2020);
        this.rbMahsupEvet = (RadioButton) findViewById(R.id.rbMahsupEvet);
        this.rbMahsupHayir = (RadioButton) findViewById(R.id.rbMahsupHayir);
        this.rbTekerrurEvet = (RadioButton) findViewById(R.id.rbTekerrurEvet);
        this.rbTekerrurHayir = (RadioButton) findViewById(R.id.rbTekerrurHayir);
        this.rbBirinciTekerrur = (RadioButton) findViewById(R.id.rbBirinciTekerrur);
        this.rbIkinciTekerrur = (RadioButton) findViewById(R.id.rbIkinciTekerrur);
        this.rbTaksir = (RadioButton) findViewById(R.id.rbTaksir);
        this.rbKast = (RadioButton) findViewById(R.id.rbKast);
        this.rbOrgutCinselEvet = (RadioButton) findViewById(R.id.rbOrgutCinselEvet);
        this.f183rbOrgutCinselHayr = (RadioButton) findViewById(R.id.f199rbOrgutCinselHayr);
        this.rb6545SKOnce = (RadioButton) findViewById(R.id.rb6545SKOnce);
        this.rb6545SKSonra = (RadioButton) findViewById(R.id.rb6545SKSonra);
        this.rbBirinciGrupSuc = (RadioButton) findViewById(R.id.rbBirinciGrupSuc);
        this.rbIkinciGrupSuc = (RadioButton) findViewById(R.id.rbIkinciGrupSuc);
        this.rbUcuncuGrupSuc = (RadioButton) findViewById(R.id.rbUcuncuGrupSuc);
        this.rbDorduncuGrupSuc = (RadioButton) findViewById(R.id.rbDorduncuGrupSuc);
        this.rbAcigaAyrilmaEvet = (RadioButton) findViewById(R.id.rbAcigaAyrilmaEvet);
        this.rbAcigaAyrilmaHayir = (RadioButton) findViewById(R.id.rbAcigaAyrilmaHayir);
        this.rbEtkin_Evet = (RadioButton) findViewById(R.id.rbEtkin_Evet);
        this.rbEtkin_Hayir = (RadioButton) findViewById(R.id.rbEtkin_Hayir);
        this.rb_tahliye_tarihi_hayir = (RadioButton) findViewById(R.id.rb_tahliye_tarihi_hayir);
        this.rb_tahliye_tarihi_evet = (RadioButton) findViewById(R.id.rb_tahliye_tarihi_evet);
        this.rbCocukYaslilikEvet = (RadioButton) findViewById(R.id.rbCocukYaslilikEvet);
        this.rbCocukYaslilikHayir = (RadioButton) findViewById(R.id.rbCocukYaslilikHayir);
        this.grup2016 = (RadioGroup) findViewById(R.id.grup2016);
        this.grup2020 = (RadioGroup) findViewById(R.id.grup2020);
        this.rg_SucGruplari = (RadioGroup) findViewById(R.id.rg_SucGruplari);
        this.rg_YaslilikCocuk = (RadioGroup) findViewById(R.id.rg_YaslilikCocuk);
        this.gridTekerrur = (GridLayout) findViewById(R.id.gridTekerrur);
        this.grid6545SK = (GridLayout) findViewById(R.id.grid6545SK);
        this.alertDialogTekerrur = (ImageButton) findViewById(R.id.alertDialogTekerrur);
        this.alertMahsup = (ImageButton) findViewById(R.id.alertMahsup);
        this.alertOrgutCinsel = (ImageButton) findViewById(R.id.alertOrgutCinsel);
        this.alertDialog6545SK = (ImageButton) findViewById(R.id.alertDialog6545SK);
        this.alertSucGrubu = (ImageButton) findViewById(R.id.alertSucGrubu);
        this.alertBirinciGrupSuclar = (ImageButton) findViewById(R.id.alertBirinciGrupSuclar);
        this.alertIkinciGrupSuclar = (ImageButton) findViewById(R.id.alertIkinciGrupSuclar);
        this.alertUcuncuGrupSuclar = (ImageButton) findViewById(R.id.alertUcuncuGrupSuclar);
        this.alertDorduncuGrupSuclar = (ImageButton) findViewById(R.id.alertDorduncuGrupSuclar);
        this.alertAcigaAyrilma = (ImageButton) findViewById(R.id.alertAcigaAyrilma);
        this.alertDialog_SucuSeciniz2 = (ImageButton) findViewById(R.id.alertDialog_SucuSeciniz2);
        this.alertCocukYasDenSer4Yil = (ImageButton) findViewById(R.id.alertCocukYasDenSer4Yil);
        this.etTekerrurSure = (LinearLayout) findViewById(R.id.etTekerrurSure);
        this.kompleTekerrur = (LinearLayout) findViewById(R.id.kompleTekerrur);
        this.f182layout_uyuturucu_cinsel = (LinearLayout) findViewById(R.id.f198layout_uyuturucu_cinsel);
        this.layout_Etkin_Pismanlik = (LinearLayout) findViewById(R.id.layout_Etkin_Pismanlik);
        this.layout_tahliye_tarihi = (LinearLayout) findViewById(R.id.layout_tahliye_tarihi);
        this.linLayoutSucGrubu = (LinearLayout) findViewById(R.id.linLayoutSucGrubu);
        this.LinLayout_YaslilikCocukDurumu = (LinearLayout) findViewById(R.id.LinLayout_YaslilikCocukDurumu);
        this.Ib_takvim_cezaevi_giris_tarihi = (ImageButton) findViewById(R.id.Ib_takvim_cezaevi_giris_tarihi);
        this.sonuc = new StringBuffer();
    }

    /* JADX WARNING: Removed duplicated region for block: B:186:0x0807  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x08d0  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x08f4  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x09e9  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0a0d  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0a95  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0ab1  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0b9f  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0bc5  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x0c41  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x0c87  */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x0d59  */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x0d81  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0e0c  */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x0e52  */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x0f25  */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0f4b  */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x0fdc  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x100c  */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x1116  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x114a  */
    /* JADX WARNING: Removed duplicated region for block: B:390:0x124e  */
    /* JADX WARNING: Removed duplicated region for block: B:474:0x180c  */
    /* JADX WARNING: Removed duplicated region for block: B:505:0x1a94  */
    /* JADX WARNING: Removed duplicated region for block: B:526:0x1b3a  */
    /* JADX WARNING: Removed duplicated region for block: B:535:0x1bf6  */
    /* JADX WARNING: Removed duplicated region for block: B:538:0x1c90  */
    /* JADX WARNING: Removed duplicated region for block: B:539:0x1c95  */
    /* JADX WARNING: Removed duplicated region for block: B:542:0x1ca1  */
    /* JADX WARNING: Removed duplicated region for block: B:543:0x1ca6  */
    /* JADX WARNING: Removed duplicated region for block: B:562:0x1d29  */
    /* JADX WARNING: Removed duplicated region for block: B:563:0x1d2e  */
    /* JADX WARNING: Removed duplicated region for block: B:570:0x1d97  */
    /* JADX WARNING: Removed duplicated region for block: B:571:0x1d9c  */
    /* JADX WARNING: Removed duplicated region for block: B:573:0x1da2  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x1dce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void hesapla() {
        /*
            r27 = this;
            r0 = r27
            android.widget.EditText r1 = r0.cYil
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = ""
            boolean r1 = r1.matches(r2)
            if (r1 == 0) goto L_0x0050
            android.widget.EditText r1 = r0.cAy
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            boolean r1 = r1.matches(r2)
            if (r1 == 0) goto L_0x0050
            android.widget.EditText r1 = r0.cGun
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            boolean r1 = r1.matches(r2)
            if (r1 == 0) goto L_0x0050
            java.lang.String r1 = "Yıl-Ay-Gün verisinden EN AZ birini giriniz !"
            r0.showToastMsj(r1)
            com.daimajia.androidanimations.library.Techniques r1 = com.daimajia.androidanimations.library.Techniques.Shake
            com.daimajia.androidanimations.library.YoYo$AnimationComposer r1 = com.daimajia.androidanimations.library.YoYo.with((com.daimajia.androidanimations.library.Techniques) r1)
            r2 = 700(0x2bc, double:3.46E-321)
            com.daimajia.androidanimations.library.YoYo$AnimationComposer r1 = r1.duration(r2)
            r2 = 1
            com.daimajia.androidanimations.library.YoYo$AnimationComposer r1 = r1.repeat(r2)
            android.widget.Button r2 = r0.btn_hesapla
            r1.playOn(r2)
            return
        L_0x0050:
            android.widget.RadioButton r1 = r0.rbTekerrurEvet
            boolean r1 = r1.isChecked()
            if (r1 == 0) goto L_0x0096
            android.widget.RadioButton r1 = r0.rbBirinciTekerrur
            boolean r1 = r1.isChecked()
            if (r1 == 0) goto L_0x0096
            android.widget.EditText r1 = r0.cYil2
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            boolean r1 = r1.matches(r2)
            if (r1 == 0) goto L_0x0096
            android.widget.EditText r1 = r0.cAy2
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            boolean r1 = r1.matches(r2)
            if (r1 == 0) goto L_0x0096
            android.widget.EditText r1 = r0.cGun2
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            boolean r1 = r1.matches(r2)
            if (r1 == 0) goto L_0x0096
            java.lang.String r1 = "TEKERRÜR İÇİN:\nYıl-Ay-Gün verisinden EN AZ birini giriniz !"
            r0.showToastMsj(r1)
            return
        L_0x0096:
            android.widget.EditText r1 = r0.takvim
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            boolean r1 = r1.matches(r2)
            if (r1 == 0) goto L_0x00b4
            android.widget.RadioButton r1 = r0.rb_tahliye_tarihi_evet
            boolean r1 = r1.isChecked()
            if (r1 == 0) goto L_0x00b4
            java.lang.String r1 = "Cezaevine giriş tarihini giriniz!"
            r0.showToastMsj(r1)
            return
        L_0x00b4:
            android.widget.TextView r1 = r0.tv_seciliSuc
            java.lang.CharSequence r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "Seçilen Suç Yok"
            boolean r1 = r1.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x00cc
            java.lang.String r1 = "Suç ekleyiniz !"
            r0.showToastMsj(r1)
            return
        L_0x00cc:
            double r3 = r27.cezaGuneCevir()
            int r1 = (int) r3
            double r3 = r27.cezaGuneCevir()
            r5 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r3 = r3 / r5
            double r3 = java.lang.Math.ceil(r3)
            int r5 = (int) r3
            double r6 = r27.cezaGuneCevir()
            double r6 = r6 - r3
            int r3 = (int) r6
            r8 = 4629137466983448576(0x403e000000000000, double:30.0)
            double r6 = r6 / r8
            java.lang.Math.floor(r6)
            r27.mahsupGun()
            double r6 = r27.cezaGuneCevir()
            r8 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r6 = r6 / r8
            double r6 = java.lang.Math.ceil(r6)
            int r4 = (int) r6
            double r8 = r27.cezaGuneCevir()
            double r8 = r8 - r6
            int r6 = r27.mahsupGun()
            double r6 = (double) r6
            double r8 = r8 - r6
            int r6 = (int) r8
            double r7 = r27.cezaGuneCevir()
            r9 = 4616189618054758400(0x4010000000000000, double:4.0)
            double r7 = r7 / r9
            double r7 = java.lang.Math.ceil(r7)
            int r9 = (int) r7
            double r10 = r27.cezaGuneCevir()
            double r10 = r10 - r7
            int r7 = r27.mahsupGun()
            double r7 = (double) r7
            double r10 = r10 - r7
            int r7 = (int) r10
            r27.mahsupGun()
            int r8 = r27.mahsupGun()
            int r3 = r3 - r8
            java.lang.String r8 = "Yatarı YOK.\nAma hükümlünün indirimlerden faydalanabilmek için cezaevine 'gir çık' yapması gerek! Bu süre de yaklaşık aşağıda gösterilen kapalı ve açık cezaevinde kalınması gereken süre kadar."
            android.widget.RadioButton r10 = r0.rbIkinciTekerrur
            boolean r10 = r10.isChecked()
            java.lang.String r11 = "1/2"
            java.lang.String r13 = "1/3"
            java.lang.String r14 = "Hükümlü açığa ayrılamayacağından denetimli serbestlikten de faydalanamaz."
            java.lang.String r15 = "Yok"
            java.lang.String r12 = "Yatarı Var"
            r16 = r11
            java.lang.String r11 = "Mahsup: "
            r17 = r13
            java.lang.String r13 = ")"
            r18 = r9
            java.lang.String r9 = " gün ("
            if (r10 != 0) goto L_0x022d
            android.widget.RadioButton r10 = r0.oncesi2016
            boolean r10 = r10.isChecked()
            if (r10 != 0) goto L_0x0154
            android.widget.RadioButton r10 = r0.oncesi2020
            boolean r10 = r10.isChecked()
            if (r10 == 0) goto L_0x022d
        L_0x0154:
            android.widget.RadioButton r10 = r0.rbUcuncuGrupSuc
            boolean r10 = r10.isChecked()
            if (r10 != 0) goto L_0x022d
            android.widget.TextView r10 = r0.tv_seciliSuc
            java.lang.CharSequence r10 = r10.getText()
            java.lang.String r10 = r10.toString()
            r19 = r7
            java.lang.String r7 = "* Diğer suçlar"
            boolean r7 = r10.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x022f
            r7 = 1095(0x447, float:1.534E-42)
            if (r3 <= r7) goto L_0x022f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r11)
            int r7 = r27.mahsupGun()
            r4.append(r7)
            java.lang.String r7 = " Gün\n1/2 İndirim: "
            r4.append(r7)
            r4.append(r5)
            r4.append(r9)
            java.lang.String r7 = gunCevirme(r5)
            r4.append(r7)
            java.lang.String r7 = ")\nDenetimli Serbestlik: 3 yıl"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            r0.indirimler = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r4.append(r9)
            java.lang.String r7 = gunCevirme(r3)
            r4.append(r7)
            r4.append(r13)
            java.lang.String r4 = r4.toString()
            r0.sartlaTahliyeString = r4
            java.lang.String r4 = "Hükümlü iyi hâlli olmak kaydıyla şartla tahliye tarihine 3 yıl kala denetimli serbestlikten faydalanabilir."
            r0.denSerbestlik = r4
            r0.sartlaTahliye = r3
            r0.yatariVarMi = r12
            java.lang.String r4 = "3 yıl"
            r0.denSerbestlikKisa = r4
            r4 = 1095(0x447, float:1.534E-42)
            r0.denSerbestlikInt = r4
            r0.sartlaTahliyeIndirimiInt = r5
            android.widget.RadioButton r5 = r0.rbAcigaAyrilmaEvet
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x01dc
            r0.denSerbestlik = r14
            r0.denSerbestlikKisa = r15
            r5 = 0
            r0.denSerbestlikInt = r5
        L_0x01dc:
            int r5 = r0.kapalidaki_gun_sayisi(r1)
            int r3 = r3 - r4
            if (r5 <= r3) goto L_0x020e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            int r4 = r0.kapalidaki_gun_sayisi(r1)
            r3.append(r4)
            r3.append(r9)
            int r4 = r0.kapalidaki_gun_sayisi(r1)
            java.lang.String r4 = gunCevirme(r4)
            r3.append(r4)
            r3.append(r13)
            java.lang.String r3 = r3.toString()
            r0.cezaevindeKalinacakToplamSureString = r3
            int r3 = r0.kapalidaki_gun_sayisi(r1)
            r0.cezaevindeKalinacakToplamSureInt = r3
            goto L_0x02c7
        L_0x020e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r4.append(r9)
            java.lang.String r5 = gunCevirme(r3)
            r4.append(r5)
            r4.append(r13)
            java.lang.String r4 = r4.toString()
            r0.cezaevindeKalinacakToplamSureString = r4
            r0.cezaevindeKalinacakToplamSureInt = r3
            goto L_0x02c7
        L_0x022d:
            r19 = r7
        L_0x022f:
            android.widget.RadioButton r7 = r0.rbIkinciTekerrur
            boolean r7 = r7.isChecked()
            java.lang.String r10 = " gün\n1/2 İndirim: "
            if (r7 != 0) goto L_0x02d5
            android.widget.RadioButton r7 = r0.oncesi2016
            boolean r7 = r7.isChecked()
            if (r7 != 0) goto L_0x0249
            android.widget.RadioButton r7 = r0.oncesi2020
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x02d5
        L_0x0249:
            android.widget.RadioButton r7 = r0.rbUcuncuGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 != 0) goto L_0x02d5
            android.widget.TextView r7 = r0.tv_seciliSuc
            java.lang.CharSequence r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            r20 = r4
            java.lang.String r4 = "* Diğer suçlar"
            boolean r4 = r7.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x02d7
            r4 = 1095(0x447, float:1.534E-42)
            if (r3 > r4) goto L_0x02d7
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r11)
            int r7 = r27.mahsupGun()
            r4.append(r7)
            r4.append(r10)
            r4.append(r5)
            r4.append(r9)
            java.lang.String r7 = gunCevirme(r5)
            r4.append(r7)
            java.lang.String r7 = ")\nDenetimli Serbestlik: 3 yıl"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            r0.indirimler = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r4.append(r9)
            java.lang.String r7 = gunCevirme(r3)
            r4.append(r7)
            r4.append(r13)
            java.lang.String r4 = r4.toString()
            r0.sartlaTahliyeString = r4
            java.lang.String r4 = r0.gir_cik_durumu(r1)
            r0.denSerbestlik = r4
            r0.sartlaTahliye = r3
            r0.yatariVarMi = r8
            r0.cezaevindeKalinacakToplamSureString = r2
            r3 = 0
            r0.cezaevindeKalinacakToplamSureInt = r3
            java.lang.String r3 = "3 yıl"
            r0.denSerbestlikKisa = r3
            r3 = 1095(0x447, float:1.534E-42)
            r0.denSerbestlikInt = r3
            r0.sartlaTahliyeIndirimiInt = r5
        L_0x02c7:
            r22 = r2
            r3 = r6
            r2 = r12
            r23 = r14
            r25 = r15
            r4 = r16
            r16 = r8
            goto L_0x17f4
        L_0x02d5:
            r20 = r4
        L_0x02d7:
            android.widget.RadioButton r4 = r0.rbIkinciTekerrur
            boolean r4 = r4.isChecked()
            if (r4 != 0) goto L_0x03e1
            android.widget.RadioButton r4 = r0.oncesi2016
            boolean r4 = r4.isChecked()
            if (r4 == 0) goto L_0x03e1
            android.widget.RadioButton r4 = r0.rbUcuncuGrupSuc
            boolean r4 = r4.isChecked()
            if (r4 != 0) goto L_0x03e1
            android.widget.TextView r4 = r0.tv_seciliSuc
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            java.lang.String r7 = "* Kasten öldürmenin ihmali davranışla işlenmesi (TCK 83)"
            boolean r4 = r4.equalsIgnoreCase(r7)
            if (r4 != 0) goto L_0x0325
            android.widget.TextView r4 = r0.tv_seciliSuc
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            java.lang.String r7 = "* İşkence suçu (TCK 94 ve 95)"
            boolean r4 = r4.equalsIgnoreCase(r7)
            if (r4 != 0) goto L_0x0325
            android.widget.TextView r4 = r0.tv_seciliSuc
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            java.lang.String r7 = "* Eziyet suçu (TCK 96)"
            boolean r4 = r4.equalsIgnoreCase(r7)
            if (r4 == 0) goto L_0x03e1
        L_0x0325:
            r4 = 730(0x2da, float:1.023E-42)
            if (r3 <= r4) goto L_0x03e1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r11)
            int r7 = r27.mahsupGun()
            r4.append(r7)
            r4.append(r10)
            r4.append(r5)
            r4.append(r9)
            java.lang.String r7 = gunCevirme(r5)
            r4.append(r7)
            java.lang.String r7 = ")\nDenetimli Serbestlik: 2 yıl"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            r0.indirimler = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r4.append(r9)
            java.lang.String r7 = gunCevirme(r3)
            r4.append(r7)
            r4.append(r13)
            java.lang.String r4 = r4.toString()
            r0.sartlaTahliyeString = r4
            java.lang.String r4 = "Hükümlü iyi hâlli olmak kaydıyla şartla tahliye tarihine 2 yıl kala denetimli serbestlikten faydalanabilir."
            r0.denSerbestlik = r4
            r0.sartlaTahliye = r3
            r0.yatariVarMi = r12
            java.lang.String r4 = "2 yıl"
            r0.denSerbestlikKisa = r4
            r4 = 730(0x2da, float:1.023E-42)
            r0.denSerbestlikInt = r4
            r0.sartlaTahliyeIndirimiInt = r5
            android.widget.RadioButton r4 = r0.rbAcigaAyrilmaEvet
            boolean r4 = r4.isChecked()
            if (r4 == 0) goto L_0x038f
            r0.denSerbestlik = r14
            r0.denSerbestlikKisa = r15
            r4 = 0
            r0.denSerbestlikInt = r4
        L_0x038f:
            int r4 = r0.kapalidaki_gun_sayisi(r1)
            int r3 = r3 + -730
            if (r4 <= r3) goto L_0x03c2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            int r4 = r0.kapalidaki_gun_sayisi(r1)
            r3.append(r4)
            r3.append(r9)
            int r4 = r0.kapalidaki_gun_sayisi(r1)
            java.lang.String r4 = gunCevirme(r4)
            r3.append(r4)
            r3.append(r13)
            java.lang.String r3 = r3.toString()
            r0.cezaevindeKalinacakToplamSureString = r3
            int r3 = r0.kapalidaki_gun_sayisi(r1)
            r0.cezaevindeKalinacakToplamSureInt = r3
            goto L_0x02c7
        L_0x03c2:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r4.append(r9)
            java.lang.String r5 = gunCevirme(r3)
            r4.append(r5)
            r4.append(r13)
            java.lang.String r4 = r4.toString()
            r0.cezaevindeKalinacakToplamSureString = r4
            r0.cezaevindeKalinacakToplamSureInt = r3
            goto L_0x02c7
        L_0x03e1:
            android.widget.RadioButton r4 = r0.rbIkinciTekerrur
            boolean r4 = r4.isChecked()
            if (r4 != 0) goto L_0x0493
            android.widget.RadioButton r4 = r0.oncesi2016
            boolean r4 = r4.isChecked()
            if (r4 == 0) goto L_0x0493
            android.widget.RadioButton r4 = r0.rbUcuncuGrupSuc
            boolean r4 = r4.isChecked()
            if (r4 != 0) goto L_0x0493
            android.widget.TextView r4 = r0.tv_seciliSuc
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            java.lang.String r7 = "* Kasten öldürmenin ihmali davranışla işlenmesi (TCK 83)"
            boolean r4 = r4.equalsIgnoreCase(r7)
            if (r4 != 0) goto L_0x042f
            android.widget.TextView r4 = r0.tv_seciliSuc
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            java.lang.String r7 = "* İşkence suçu (TCK 94 ve 95)"
            boolean r4 = r4.equalsIgnoreCase(r7)
            if (r4 != 0) goto L_0x042f
            android.widget.TextView r4 = r0.tv_seciliSuc
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            java.lang.String r7 = "* Eziyet suçu (TCK 96)"
            boolean r4 = r4.equalsIgnoreCase(r7)
            if (r4 == 0) goto L_0x0493
        L_0x042f:
            r4 = 730(0x2da, float:1.023E-42)
            if (r3 > r4) goto L_0x0493
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r11)
            int r7 = r27.mahsupGun()
            r4.append(r7)
            r4.append(r10)
            r4.append(r5)
            r4.append(r9)
            java.lang.String r7 = gunCevirme(r5)
            r4.append(r7)
            java.lang.String r7 = ")\nDenetimli Serbestlik: 2 yıl"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            r0.indirimler = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r4.append(r9)
            java.lang.String r7 = gunCevirme(r3)
            r4.append(r7)
            r4.append(r13)
            java.lang.String r4 = r4.toString()
            r0.sartlaTahliyeString = r4
            java.lang.String r4 = r0.gir_cik_durumu(r1)
            r0.denSerbestlik = r4
            r0.sartlaTahliye = r3
            r0.yatariVarMi = r8
            r0.cezaevindeKalinacakToplamSureString = r2
            r3 = 0
            r0.cezaevindeKalinacakToplamSureInt = r3
            java.lang.String r3 = "2 yıl"
            r0.denSerbestlikKisa = r3
            r3 = 730(0x2da, float:1.023E-42)
            r0.denSerbestlikInt = r3
            r0.sartlaTahliyeIndirimiInt = r5
            goto L_0x02c7
        L_0x0493:
            android.widget.RadioButton r4 = r0.rbIkinciTekerrur
            boolean r4 = r4.isChecked()
            java.lang.String r7 = "Hükümlü iyi hâlli olmak kaydıyla şartla tahliye tarihine 1 yıl kala denetimli serbestlikten faydalanabilir."
            r21 = r6
            java.lang.String r6 = "1 yıl"
            r22 = r2
            java.lang.String r2 = ")\nDenetimli Serbestlik: 1 yıl"
            r23 = r8
            if (r4 != 0) goto L_0x05b8
            android.widget.RadioButton r4 = r0.oncesi2016
            boolean r4 = r4.isChecked()
            if (r4 != 0) goto L_0x04bf
            android.widget.RadioButton r4 = r0.oncesi2020
            boolean r4 = r4.isChecked()
            if (r4 != 0) goto L_0x04bf
            android.widget.RadioButton r4 = r0.sonrasi2020
            boolean r4 = r4.isChecked()
            if (r4 == 0) goto L_0x05b8
        L_0x04bf:
            android.widget.RadioButton r4 = r0.rbUcuncuGrupSuc
            boolean r4 = r4.isChecked()
            if (r4 != 0) goto L_0x05b8
            android.widget.TextView r4 = r0.tv_seciliSuc
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            java.lang.String r8 = "* Üstsoya, altsoya, eşe veya kardeşe ya da beden veya ruh bakımından kendisini savunamayacak durumda bulunan kişiye karşı işlenen kasten yaralama"
            boolean r4 = r4.equalsIgnoreCase(r8)
            if (r4 != 0) goto L_0x04eb
            android.widget.TextView r4 = r0.tv_seciliSuc
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            java.lang.String r8 = "* Neticesi sebebiyle ağırlaşmış yaralama suçları (m. 87/2-d hariç)"
            boolean r4 = r4.equalsIgnoreCase(r8)
            if (r4 == 0) goto L_0x05b8
        L_0x04eb:
            r4 = 365(0x16d, float:5.11E-43)
            if (r3 <= r4) goto L_0x05b8
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r11)
            int r8 = r27.mahsupGun()
            r4.append(r8)
            r4.append(r10)
            r4.append(r5)
            r4.append(r9)
            java.lang.String r8 = gunCevirme(r5)
            r4.append(r8)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r0.indirimler = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r9)
            java.lang.String r4 = gunCevirme(r3)
            r2.append(r4)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.sartlaTahliyeString = r2
            r0.denSerbestlik = r7
            r0.sartlaTahliye = r3
            r0.yatariVarMi = r12
            r0.denSerbestlikKisa = r6
            r2 = 365(0x16d, float:5.11E-43)
            r0.denSerbestlikInt = r2
            r0.sartlaTahliyeIndirimiInt = r5
            android.widget.RadioButton r2 = r0.rbAcigaAyrilmaEvet
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x054f
            r0.denSerbestlik = r14
            r0.denSerbestlikKisa = r15
            r2 = 0
            r0.denSerbestlikInt = r2
        L_0x054f:
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            int r4 = r0.denSerbestlikInt
            int r4 = r3 - r4
            if (r2 <= r4) goto L_0x0583
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r3 = r0.kapalidaki_gun_sayisi(r1)
            r2.append(r3)
            r2.append(r9)
            int r3 = r0.kapalidaki_gun_sayisi(r1)
            java.lang.String r3 = gunCevirme(r3)
            r2.append(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            r0.cezaevindeKalinacakToplamSureInt = r2
            goto L_0x05ab
        L_0x0583:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r4 = r0.denSerbestlikInt
            int r4 = r3 - r4
            r2.append(r4)
            r2.append(r9)
            int r4 = r0.denSerbestlikInt
            int r4 = r3 - r4
            java.lang.String r4 = gunCevirme(r4)
            r2.append(r4)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.denSerbestlikInt
            int r3 = r3 - r2
            r0.cezaevindeKalinacakToplamSureInt = r3
        L_0x05ab:
            r2 = r12
            r25 = r15
            r4 = r16
            r3 = r21
            r16 = r23
            r23 = r14
            goto L_0x17f4
        L_0x05b8:
            android.widget.RadioButton r4 = r0.rbIkinciTekerrur
            boolean r4 = r4.isChecked()
            if (r4 != 0) goto L_0x0675
            android.widget.RadioButton r4 = r0.oncesi2016
            boolean r4 = r4.isChecked()
            if (r4 != 0) goto L_0x05d8
            android.widget.RadioButton r4 = r0.oncesi2020
            boolean r4 = r4.isChecked()
            if (r4 != 0) goto L_0x05d8
            android.widget.RadioButton r4 = r0.sonrasi2020
            boolean r4 = r4.isChecked()
            if (r4 == 0) goto L_0x0675
        L_0x05d8:
            android.widget.RadioButton r4 = r0.rbUcuncuGrupSuc
            boolean r4 = r4.isChecked()
            if (r4 != 0) goto L_0x0675
            android.widget.TextView r4 = r0.tv_seciliSuc
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            java.lang.String r8 = "* Üstsoya, altsoya, eşe veya kardeşe ya da beden veya ruh bakımından kendisini savunamayacak durumda bulunan kişiye karşı işlenen kasten yaralama"
            boolean r4 = r4.equalsIgnoreCase(r8)
            if (r4 != 0) goto L_0x0604
            android.widget.TextView r4 = r0.tv_seciliSuc
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            java.lang.String r8 = "* Neticesi sebebiyle ağırlaşmış yaralama suçları (m. 87/2-d hariç)"
            boolean r4 = r4.equalsIgnoreCase(r8)
            if (r4 == 0) goto L_0x0675
        L_0x0604:
            r4 = 365(0x16d, float:5.11E-43)
            if (r3 > r4) goto L_0x0675
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r11)
            int r7 = r27.mahsupGun()
            r4.append(r7)
            r4.append(r10)
            r4.append(r5)
            r4.append(r9)
            java.lang.String r7 = gunCevirme(r5)
            r4.append(r7)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r0.indirimler = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r9)
            java.lang.String r4 = gunCevirme(r3)
            r2.append(r4)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.sartlaTahliyeString = r2
            java.lang.String r2 = r0.gir_cik_durumu(r1)
            r0.denSerbestlik = r2
            r0.sartlaTahliye = r3
            r4 = r23
            r0.yatariVarMi = r4
            r8 = r22
            r0.cezaevindeKalinacakToplamSureString = r8
            r2 = 0
            r0.cezaevindeKalinacakToplamSureInt = r2
            r0.denSerbestlikKisa = r6
            r2 = 365(0x16d, float:5.11E-43)
            r0.denSerbestlikInt = r2
            r0.sartlaTahliyeIndirimiInt = r5
            r2 = r12
            r23 = r14
            r25 = r15
            r3 = r21
        L_0x066d:
            r26 = r16
            r16 = r4
            r4 = r26
            goto L_0x17f4
        L_0x0675:
            r8 = r22
            r4 = r23
            r22 = r5
            android.widget.RadioButton r5 = r0.rbIkinciTekerrur
            boolean r5 = r5.isChecked()
            r23 = r10
            java.lang.String r10 = " gün\n1/3 İndirim: "
            if (r5 != 0) goto L_0x07d7
            android.widget.RadioButton r5 = r0.oncesi2016
            boolean r5 = r5.isChecked()
            if (r5 != 0) goto L_0x069f
            android.widget.RadioButton r5 = r0.oncesi2020
            boolean r5 = r5.isChecked()
            if (r5 != 0) goto L_0x069f
            android.widget.RadioButton r5 = r0.sonrasi2020
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x07d7
        L_0x069f:
            android.widget.RadioButton r5 = r0.rbUcuncuGrupSuc
            boolean r5 = r5.isChecked()
            if (r5 != 0) goto L_0x07d7
            android.widget.TextView r5 = r0.tv_seciliSuc
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            r24 = r3
            java.lang.String r3 = "* Yüzde sürekli değişikliğe sebebiyet verecek şekilde ağırlaşmış yaralama suçu (m. 87/2-d hariç)"
            boolean r3 = r5.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x0703
            android.widget.TextView r3 = r0.tv_seciliSuc
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = "* Basit cinsel suçlar TCK (102/1, 104/1, 105)"
            boolean r3 = r3.equalsIgnoreCase(r5)
            if (r3 != 0) goto L_0x0703
            android.widget.TextView r3 = r0.tv_seciliSuc
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = "* Kasten Öldürme suçları (TCK 81, 82)"
            boolean r3 = r3.equalsIgnoreCase(r5)
            if (r3 != 0) goto L_0x0703
            android.widget.TextView r3 = r0.tv_seciliSuc
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = "* Kasten Öldürme suçları (TCK 81, 82, 83)"
            boolean r3 = r3.equalsIgnoreCase(r5)
            if (r3 != 0) goto L_0x0703
            android.widget.TextView r3 = r0.tv_seciliSuc
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = "* Özel hayata ve hayatın gizli alanına karşı suçlar (TCK 132, 133, 134, 135, 136, 137, 138)"
            boolean r3 = r3.equalsIgnoreCase(r5)
            if (r3 == 0) goto L_0x07d9
        L_0x0703:
            r3 = r21
            r5 = 365(0x16d, float:5.11E-43)
            if (r3 <= r5) goto L_0x07db
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r11)
            r21 = r8
            int r8 = r27.mahsupGun()
            r5.append(r8)
            r5.append(r10)
            r8 = r20
            r5.append(r8)
            r5.append(r9)
            java.lang.String r10 = gunCevirme(r8)
            r5.append(r10)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r0.indirimler = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r9)
            java.lang.String r5 = gunCevirme(r3)
            r2.append(r5)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.sartlaTahliyeString = r2
            r0.denSerbestlik = r7
            r0.sartlaTahliye = r3
            r0.yatariVarMi = r12
            r0.denSerbestlikKisa = r6
            r2 = 365(0x16d, float:5.11E-43)
            r0.denSerbestlikInt = r2
            r0.sartlaTahliyeIndirimiInt = r8
            android.widget.RadioButton r2 = r0.rbAcigaAyrilmaEvet
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x076d
            r0.denSerbestlik = r14
            r0.denSerbestlikKisa = r15
            r2 = 0
            r0.denSerbestlikInt = r2
        L_0x076d:
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            int r5 = r0.denSerbestlikInt
            int r6 = r3 - r5
            if (r2 <= r6) goto L_0x07a1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r5 = r0.kapalidaki_gun_sayisi(r1)
            r2.append(r5)
            r2.append(r9)
            int r5 = r0.kapalidaki_gun_sayisi(r1)
            java.lang.String r5 = gunCevirme(r5)
            r2.append(r5)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            r0.cezaevindeKalinacakToplamSureInt = r2
            goto L_0x07ca
        L_0x07a1:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r5 = r0.denSerbestlikInt
            int r6 = r3 - r5
            r2.append(r6)
            r2.append(r9)
            int r5 = r0.denSerbestlikInt
            int r6 = r3 - r5
            java.lang.String r5 = gunCevirme(r6)
            r2.append(r5)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.denSerbestlikInt
            int r6 = r3 - r2
            r0.cezaevindeKalinacakToplamSureInt = r6
        L_0x07ca:
            r16 = r4
            r2 = r12
            r23 = r14
            r25 = r15
        L_0x07d1:
            r4 = r17
            r22 = r21
            goto L_0x17f4
        L_0x07d7:
            r24 = r3
        L_0x07d9:
            r3 = r21
        L_0x07db:
            r21 = r8
            r8 = r20
            android.widget.RadioButton r5 = r0.rbIkinciTekerrur
            boolean r5 = r5.isChecked()
            if (r5 != 0) goto L_0x08d0
            android.widget.RadioButton r5 = r0.oncesi2016
            boolean r5 = r5.isChecked()
            if (r5 != 0) goto L_0x07ff
            android.widget.RadioButton r5 = r0.oncesi2020
            boolean r5 = r5.isChecked()
            if (r5 != 0) goto L_0x07ff
            android.widget.RadioButton r5 = r0.sonrasi2020
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x08d0
        L_0x07ff:
            android.widget.RadioButton r5 = r0.rbUcuncuGrupSuc
            boolean r5 = r5.isChecked()
            if (r5 != 0) goto L_0x08d0
            android.widget.TextView r5 = r0.tv_seciliSuc
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            r20 = r15
            java.lang.String r15 = "* Yüzde sürekli değişikliğe sebebiyet verecek şekilde ağırlaşmış yaralama suçu (m. 87/2-d hariç)"
            boolean r5 = r5.equalsIgnoreCase(r15)
            if (r5 != 0) goto L_0x0863
            android.widget.TextView r5 = r0.tv_seciliSuc
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r15 = "* Basit cinsel suçlar TCK (102/1, 104/1, 105)"
            boolean r5 = r5.equalsIgnoreCase(r15)
            if (r5 != 0) goto L_0x0863
            android.widget.TextView r5 = r0.tv_seciliSuc
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r15 = "* Kasten Öldürme suçları (TCK 81, 82)"
            boolean r5 = r5.equalsIgnoreCase(r15)
            if (r5 != 0) goto L_0x0863
            android.widget.TextView r5 = r0.tv_seciliSuc
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r15 = "* Kasten Öldürme suçları (TCK 81, 82, 83)"
            boolean r5 = r5.equalsIgnoreCase(r15)
            if (r5 != 0) goto L_0x0863
            android.widget.TextView r5 = r0.tv_seciliSuc
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r15 = "* Özel hayata ve hayatın gizli alanına karşı suçlar (TCK 132, 133, 134, 135, 136, 137, 138)"
            boolean r5 = r5.equalsIgnoreCase(r15)
            if (r5 == 0) goto L_0x08d2
        L_0x0863:
            r5 = 365(0x16d, float:5.11E-43)
            if (r3 > r5) goto L_0x08d2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r11)
            int r7 = r27.mahsupGun()
            r5.append(r7)
            r5.append(r10)
            r5.append(r8)
            r5.append(r9)
            java.lang.String r7 = gunCevirme(r8)
            r5.append(r7)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r0.indirimler = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r9)
            java.lang.String r5 = gunCevirme(r3)
            r2.append(r5)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.sartlaTahliyeString = r2
            java.lang.String r2 = r0.gir_cik_durumu(r1)
            r0.denSerbestlik = r2
            r0.sartlaTahliye = r3
            r0.yatariVarMi = r4
            r5 = r21
            r0.cezaevindeKalinacakToplamSureString = r5
            r2 = 0
            r0.cezaevindeKalinacakToplamSureInt = r2
            r0.denSerbestlikKisa = r6
            r2 = 365(0x16d, float:5.11E-43)
            r0.denSerbestlikInt = r2
            r0.sartlaTahliyeIndirimiInt = r8
        L_0x08c3:
            r16 = r4
            r22 = r5
            r2 = r12
            r23 = r14
        L_0x08ca:
            r4 = r17
            r25 = r20
            goto L_0x17f4
        L_0x08d0:
            r20 = r15
        L_0x08d2:
            r5 = r21
            android.widget.RadioButton r15 = r0.rbIkinciTekerrur
            boolean r15 = r15.isChecked()
            if (r15 != 0) goto L_0x09e9
            android.widget.RadioButton r15 = r0.oncesi2020
            boolean r15 = r15.isChecked()
            if (r15 != 0) goto L_0x08ec
            android.widget.RadioButton r15 = r0.sonrasi2020
            boolean r15 = r15.isChecked()
            if (r15 == 0) goto L_0x09e9
        L_0x08ec:
            android.widget.RadioButton r15 = r0.rbUcuncuGrupSuc
            boolean r15 = r15.isChecked()
            if (r15 != 0) goto L_0x09e9
            android.widget.TextView r15 = r0.tv_seciliSuc
            java.lang.CharSequence r15 = r15.getText()
            java.lang.String r15 = r15.toString()
            r21 = r5
            java.lang.String r5 = "* İşkence suçu (TCK 94 ve 95)"
            boolean r5 = r15.equalsIgnoreCase(r5)
            if (r5 != 0) goto L_0x091a
            android.widget.TextView r5 = r0.tv_seciliSuc
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r15 = "* Eziyet suçu (TCK 96)"
            boolean r5 = r5.equalsIgnoreCase(r15)
            if (r5 == 0) goto L_0x09eb
        L_0x091a:
            r5 = 365(0x16d, float:5.11E-43)
            if (r3 <= r5) goto L_0x09eb
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r11)
            int r15 = r27.mahsupGun()
            r5.append(r15)
            r5.append(r10)
            r5.append(r8)
            r5.append(r9)
            java.lang.String r10 = gunCevirme(r8)
            r5.append(r10)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r0.indirimler = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r9)
            java.lang.String r5 = gunCevirme(r3)
            r2.append(r5)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.sartlaTahliyeString = r2
            r0.denSerbestlik = r7
            r0.sartlaTahliye = r3
            r0.yatariVarMi = r12
            r0.denSerbestlikKisa = r6
            r2 = 365(0x16d, float:5.11E-43)
            r0.denSerbestlikInt = r2
            r0.sartlaTahliyeIndirimiInt = r8
            android.widget.RadioButton r2 = r0.rbAcigaAyrilmaEvet
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x0981
            r0.denSerbestlik = r14
            r5 = r20
            r0.denSerbestlikKisa = r5
            r2 = 0
            r0.denSerbestlikInt = r2
            goto L_0x0983
        L_0x0981:
            r5 = r20
        L_0x0983:
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            int r6 = r0.denSerbestlikInt
            int r6 = r3 - r6
            if (r2 <= r6) goto L_0x09b7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r6 = r0.kapalidaki_gun_sayisi(r1)
            r2.append(r6)
            r2.append(r9)
            int r6 = r0.kapalidaki_gun_sayisi(r1)
            java.lang.String r6 = gunCevirme(r6)
            r2.append(r6)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            r0.cezaevindeKalinacakToplamSureInt = r2
            goto L_0x09e0
        L_0x09b7:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r6 = r0.denSerbestlikInt
            int r6 = r3 - r6
            r2.append(r6)
            r2.append(r9)
            int r6 = r0.denSerbestlikInt
            int r6 = r3 - r6
            java.lang.String r6 = gunCevirme(r6)
            r2.append(r6)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.denSerbestlikInt
            int r6 = r3 - r2
            r0.cezaevindeKalinacakToplamSureInt = r6
        L_0x09e0:
            r16 = r4
            r25 = r5
            r2 = r12
            r23 = r14
            goto L_0x07d1
        L_0x09e9:
            r21 = r5
        L_0x09eb:
            r5 = r20
            android.widget.RadioButton r15 = r0.rbIkinciTekerrur
            boolean r15 = r15.isChecked()
            if (r15 != 0) goto L_0x0a95
            android.widget.RadioButton r15 = r0.oncesi2020
            boolean r15 = r15.isChecked()
            if (r15 != 0) goto L_0x0a05
            android.widget.RadioButton r15 = r0.sonrasi2020
            boolean r15 = r15.isChecked()
            if (r15 == 0) goto L_0x0a95
        L_0x0a05:
            android.widget.RadioButton r15 = r0.rbUcuncuGrupSuc
            boolean r15 = r15.isChecked()
            if (r15 != 0) goto L_0x0a95
            android.widget.TextView r15 = r0.tv_seciliSuc
            java.lang.CharSequence r15 = r15.getText()
            java.lang.String r15 = r15.toString()
            r20 = r5
            java.lang.String r5 = "* İşkence suçu (TCK 94 ve 95)"
            boolean r5 = r15.equalsIgnoreCase(r5)
            if (r5 != 0) goto L_0x0a33
            android.widget.TextView r5 = r0.tv_seciliSuc
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r15 = "* Eziyet suçu (TCK 96)"
            boolean r5 = r5.equalsIgnoreCase(r15)
            if (r5 == 0) goto L_0x0a97
        L_0x0a33:
            r5 = 365(0x16d, float:5.11E-43)
            if (r3 > r5) goto L_0x0a97
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r11)
            int r7 = r27.mahsupGun()
            r5.append(r7)
            r5.append(r10)
            r5.append(r8)
            r5.append(r9)
            java.lang.String r7 = gunCevirme(r8)
            r5.append(r7)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r0.indirimler = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r9)
            java.lang.String r5 = gunCevirme(r3)
            r2.append(r5)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.sartlaTahliyeString = r2
            java.lang.String r2 = r0.gir_cik_durumu(r1)
            r0.denSerbestlik = r2
            r0.sartlaTahliye = r3
            r0.yatariVarMi = r4
            r5 = r21
            r0.cezaevindeKalinacakToplamSureString = r5
            r2 = 0
            r0.cezaevindeKalinacakToplamSureInt = r2
            r0.denSerbestlikKisa = r6
            r2 = 365(0x16d, float:5.11E-43)
            r0.denSerbestlikInt = r2
            r0.sartlaTahliyeIndirimiInt = r8
            goto L_0x08c3
        L_0x0a95:
            r20 = r5
        L_0x0a97:
            r5 = r21
            android.widget.RadioButton r15 = r0.rbIkinciTekerrur
            boolean r15 = r15.isChecked()
            if (r15 != 0) goto L_0x0b9f
            android.widget.RadioButton r15 = r0.sonrasi2020
            boolean r15 = r15.isChecked()
            if (r15 == 0) goto L_0x0b9f
            android.widget.RadioButton r15 = r0.rbUcuncuGrupSuc
            boolean r15 = r15.isChecked()
            if (r15 != 0) goto L_0x0b9f
            android.widget.TextView r15 = r0.tv_seciliSuc
            java.lang.CharSequence r15 = r15.getText()
            java.lang.String r15 = r15.toString()
            r21 = r8
            java.lang.String r8 = "* Diğer suçlar"
            boolean r8 = r15.equalsIgnoreCase(r8)
            if (r8 == 0) goto L_0x0ba1
            r8 = r24
            r15 = 365(0x16d, float:5.11E-43)
            if (r8 <= r15) goto L_0x0b9c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r11)
            int r15 = r27.mahsupGun()
            r10.append(r15)
            r15 = r23
            r10.append(r15)
            r15 = r22
            r10.append(r15)
            r10.append(r9)
            r22 = r3
            java.lang.String r3 = gunCevirme(r15)
            r10.append(r3)
            r10.append(r2)
            java.lang.String r2 = r10.toString()
            r0.indirimler = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r8)
            r2.append(r9)
            java.lang.String r3 = gunCevirme(r8)
            r2.append(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.sartlaTahliyeString = r2
            r0.denSerbestlik = r7
            r0.sartlaTahliye = r8
            r0.yatariVarMi = r12
            r0.denSerbestlikKisa = r6
            r2 = 365(0x16d, float:5.11E-43)
            r0.denSerbestlikInt = r2
            r0.sartlaTahliyeIndirimiInt = r15
            android.widget.RadioButton r2 = r0.rbAcigaAyrilmaEvet
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x0b34
            r0.denSerbestlik = r14
            r3 = r20
            r0.denSerbestlikKisa = r3
            r2 = 0
            r0.denSerbestlikInt = r2
            goto L_0x0b36
        L_0x0b34:
            r3 = r20
        L_0x0b36:
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            int r6 = r0.denSerbestlikInt
            int r6 = r8 - r6
            if (r2 <= r6) goto L_0x0b6a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r6 = r0.kapalidaki_gun_sayisi(r1)
            r2.append(r6)
            r2.append(r9)
            int r6 = r0.kapalidaki_gun_sayisi(r1)
            java.lang.String r6 = gunCevirme(r6)
            r2.append(r6)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            r0.cezaevindeKalinacakToplamSureInt = r2
            goto L_0x0b93
        L_0x0b6a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r6 = r0.denSerbestlikInt
            int r6 = r8 - r6
            r2.append(r6)
            r2.append(r9)
            int r6 = r0.denSerbestlikInt
            int r6 = r8 - r6
            java.lang.String r6 = gunCevirme(r6)
            r2.append(r6)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.denSerbestlikInt
            int r2 = r8 - r2
            r0.cezaevindeKalinacakToplamSureInt = r2
        L_0x0b93:
            r25 = r3
            r2 = r12
            r23 = r14
            r3 = r22
            goto L_0x0c3d
        L_0x0b9c:
            r15 = r23
            goto L_0x0ba5
        L_0x0b9f:
            r21 = r8
        L_0x0ba1:
            r15 = r23
            r8 = r24
        L_0x0ba5:
            r26 = r22
            r22 = r3
            r3 = r26
            r23 = r14
            android.widget.RadioButton r14 = r0.rbIkinciTekerrur
            boolean r14 = r14.isChecked()
            if (r14 != 0) goto L_0x0c41
            android.widget.RadioButton r14 = r0.sonrasi2020
            boolean r14 = r14.isChecked()
            if (r14 == 0) goto L_0x0c41
            android.widget.RadioButton r14 = r0.rbUcuncuGrupSuc
            boolean r14 = r14.isChecked()
            if (r14 != 0) goto L_0x0c41
            android.widget.TextView r14 = r0.tv_seciliSuc
            java.lang.CharSequence r14 = r14.getText()
            java.lang.String r14 = r14.toString()
            r24 = r12
            java.lang.String r12 = "* Diğer suçlar"
            boolean r12 = r14.equalsIgnoreCase(r12)
            if (r12 == 0) goto L_0x0c43
            r12 = 365(0x16d, float:5.11E-43)
            if (r8 > r12) goto L_0x0c43
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r11)
            int r10 = r27.mahsupGun()
            r7.append(r10)
            r7.append(r15)
            r7.append(r3)
            r7.append(r9)
            java.lang.String r10 = gunCevirme(r3)
            r7.append(r10)
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            r0.indirimler = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r8)
            r2.append(r9)
            java.lang.String r7 = gunCevirme(r8)
            r2.append(r7)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.sartlaTahliyeString = r2
            java.lang.String r2 = r0.gir_cik_durumu(r1)
            r0.denSerbestlik = r2
            r0.sartlaTahliye = r8
            r0.yatariVarMi = r4
            r0.cezaevindeKalinacakToplamSureString = r5
            r2 = 0
            r0.cezaevindeKalinacakToplamSureInt = r2
            r0.denSerbestlikKisa = r6
            r2 = 365(0x16d, float:5.11E-43)
            r0.denSerbestlikInt = r2
            r0.sartlaTahliyeIndirimiInt = r3
            r25 = r20
            r3 = r22
            r2 = r24
        L_0x0c3d:
            r22 = r5
            goto L_0x066d
        L_0x0c41:
            r24 = r12
        L_0x0c43:
            android.widget.RadioButton r3 = r0.rbIkinciTekerrur
            boolean r3 = r3.isChecked()
            if (r3 != 0) goto L_0x0d59
            android.widget.RadioButton r3 = r0.rb6545SKOnce
            boolean r3 = r3.isChecked()
            if (r3 == 0) goto L_0x0d59
            android.widget.RadioButton r3 = r0.rbUcuncuGrupSuc
            boolean r3 = r3.isChecked()
            if (r3 != 0) goto L_0x0d59
            android.widget.RadioButton r3 = r0.rbTekerrurHayir
            boolean r3 = r3.isChecked()
            if (r3 == 0) goto L_0x0d59
            android.widget.TextView r3 = r0.tv_seciliSuc
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.String r8 = "* Uyuşturucu veya uyarıcı madde imal ve ticareti suçu (TCK 188)"
            boolean r3 = r3.equalsIgnoreCase(r8)
            if (r3 != 0) goto L_0x0c87
            android.widget.TextView r3 = r0.tv_seciliSuc
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.String r8 = "* Ağır cinsel suçlar (TCK 102/2, 103, 104/2-3)"
            boolean r3 = r3.equalsIgnoreCase(r8)
            if (r3 == 0) goto L_0x0d59
        L_0x0c87:
            r3 = r22
            r8 = 365(0x16d, float:5.11E-43)
            if (r3 <= r8) goto L_0x0d56
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r11)
            int r12 = r27.mahsupGun()
            r8.append(r12)
            r8.append(r10)
            r12 = r21
            r8.append(r12)
            r8.append(r9)
            java.lang.String r10 = gunCevirme(r12)
            r8.append(r10)
            r8.append(r2)
            java.lang.String r2 = r8.toString()
            r0.indirimler = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r9)
            java.lang.String r8 = gunCevirme(r3)
            r2.append(r8)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.sartlaTahliyeString = r2
            r0.denSerbestlik = r7
            r0.sartlaTahliye = r3
            r8 = r24
            r0.yatariVarMi = r8
            r0.denSerbestlikKisa = r6
            r2 = 365(0x16d, float:5.11E-43)
            r0.denSerbestlikInt = r2
            r0.sartlaTahliyeIndirimiInt = r12
            android.widget.RadioButton r2 = r0.rbAcigaAyrilmaEvet
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x0cf6
            r14 = r23
            r0.denSerbestlik = r14
            r15 = r20
            r0.denSerbestlikKisa = r15
            r2 = 0
            r0.denSerbestlikInt = r2
            goto L_0x0cfa
        L_0x0cf6:
            r15 = r20
            r14 = r23
        L_0x0cfa:
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            int r6 = r3 + -365
            if (r2 <= r6) goto L_0x0d2c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r6 = r0.kapalidaki_gun_sayisi(r1)
            r2.append(r6)
            r2.append(r9)
            int r6 = r0.kapalidaki_gun_sayisi(r1)
            java.lang.String r6 = gunCevirme(r6)
            r2.append(r6)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            r0.cezaevindeKalinacakToplamSureInt = r2
            goto L_0x0d49
        L_0x0d2c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r2.append(r9)
            java.lang.String r7 = gunCevirme(r6)
            r2.append(r7)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            r0.cezaevindeKalinacakToplamSureInt = r6
        L_0x0d49:
            r16 = r4
            r22 = r5
            r2 = r8
            r23 = r14
            r25 = r15
            r4 = r17
            goto L_0x17f4
        L_0x0d56:
            r12 = r21
            goto L_0x0d5d
        L_0x0d59:
            r12 = r21
            r3 = r22
        L_0x0d5d:
            r14 = r23
            r8 = r24
            android.widget.RadioButton r15 = r0.rbIkinciTekerrur
            boolean r15 = r15.isChecked()
            if (r15 != 0) goto L_0x0e0c
            android.widget.RadioButton r15 = r0.rb6545SKOnce
            boolean r15 = r15.isChecked()
            if (r15 == 0) goto L_0x0e0c
            android.widget.RadioButton r15 = r0.rbUcuncuGrupSuc
            boolean r15 = r15.isChecked()
            if (r15 != 0) goto L_0x0e0c
            android.widget.RadioButton r15 = r0.rbTekerrurHayir
            boolean r15 = r15.isChecked()
            if (r15 == 0) goto L_0x0e0c
            android.widget.TextView r15 = r0.tv_seciliSuc
            java.lang.CharSequence r15 = r15.getText()
            java.lang.String r15 = r15.toString()
            r23 = r14
            java.lang.String r14 = "* Uyuşturucu veya uyarıcı madde imal ve ticareti suçu (TCK 188)"
            boolean r14 = r15.equalsIgnoreCase(r14)
            if (r14 != 0) goto L_0x0da7
            android.widget.TextView r14 = r0.tv_seciliSuc
            java.lang.CharSequence r14 = r14.getText()
            java.lang.String r14 = r14.toString()
            java.lang.String r15 = "* Ağır cinsel suçlar (TCK 102/2, 103, 104/2-3)"
            boolean r14 = r14.equalsIgnoreCase(r15)
            if (r14 == 0) goto L_0x0e0e
        L_0x0da7:
            r14 = 365(0x16d, float:5.11E-43)
            if (r3 > r14) goto L_0x0e0e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r11)
            int r14 = r27.mahsupGun()
            r7.append(r14)
            r7.append(r10)
            r7.append(r12)
            r7.append(r9)
            java.lang.String r10 = gunCevirme(r12)
            r7.append(r10)
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            r0.indirimler = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r9)
            java.lang.String r7 = gunCevirme(r3)
            r2.append(r7)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.sartlaTahliyeString = r2
            java.lang.String r2 = r0.gir_cik_durumu(r1)
            r0.denSerbestlik = r2
            r0.sartlaTahliye = r3
            r0.yatariVarMi = r4
            r0.cezaevindeKalinacakToplamSureString = r5
            r2 = 0
            r0.cezaevindeKalinacakToplamSureInt = r2
            r0.denSerbestlikKisa = r6
            r2 = 365(0x16d, float:5.11E-43)
            r0.denSerbestlikInt = r2
            r0.sartlaTahliyeIndirimiInt = r12
            r16 = r4
            r22 = r5
            r2 = r8
            goto L_0x08ca
        L_0x0e0c:
            r23 = r14
        L_0x0e0e:
            android.widget.RadioButton r14 = r0.rbIkinciTekerrur
            boolean r14 = r14.isChecked()
            if (r14 != 0) goto L_0x0f25
            android.widget.RadioButton r14 = r0.rb6545SKSonra
            boolean r14 = r14.isChecked()
            if (r14 == 0) goto L_0x0f25
            android.widget.RadioButton r14 = r0.rbUcuncuGrupSuc
            boolean r14 = r14.isChecked()
            if (r14 != 0) goto L_0x0f25
            android.widget.RadioButton r14 = r0.rbTekerrurHayir
            boolean r14 = r14.isChecked()
            if (r14 == 0) goto L_0x0f25
            android.widget.TextView r14 = r0.tv_seciliSuc
            java.lang.CharSequence r14 = r14.getText()
            java.lang.String r14 = r14.toString()
            java.lang.String r15 = "* Uyuşturucu veya uyarıcı madde imal ve ticareti suçu (TCK 188)"
            boolean r14 = r14.equalsIgnoreCase(r15)
            if (r14 != 0) goto L_0x0e52
            android.widget.TextView r14 = r0.tv_seciliSuc
            java.lang.CharSequence r14 = r14.getText()
            java.lang.String r14 = r14.toString()
            java.lang.String r15 = "* Ağır cinsel suçlar (TCK 102/2, 103, 104/2-3)"
            boolean r14 = r14.equalsIgnoreCase(r15)
            if (r14 == 0) goto L_0x0f25
        L_0x0e52:
            r14 = r19
            r15 = 365(0x16d, float:5.11E-43)
            if (r14 <= r15) goto L_0x0f22
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r11)
            int r12 = r27.mahsupGun()
            r10.append(r12)
            java.lang.String r12 = " gün\n1/4 İndirim: "
            r10.append(r12)
            r15 = r18
            r10.append(r15)
            r10.append(r9)
            java.lang.String r12 = gunCevirme(r15)
            r10.append(r12)
            r10.append(r2)
            java.lang.String r2 = r10.toString()
            r0.indirimler = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            r2.append(r9)
            java.lang.String r10 = gunCevirme(r14)
            r2.append(r10)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.sartlaTahliyeString = r2
            r0.denSerbestlik = r7
            r0.sartlaTahliye = r14
            r0.yatariVarMi = r8
            r0.denSerbestlikKisa = r6
            r2 = 365(0x16d, float:5.11E-43)
            r0.denSerbestlikInt = r2
            r0.sartlaTahliyeIndirimiInt = r15
            android.widget.RadioButton r6 = r0.rbAcigaAyrilmaEvet
            boolean r6 = r6.isChecked()
            if (r6 == 0) goto L_0x0ec1
            r7 = r23
            r0.denSerbestlik = r7
            r6 = r20
            r0.denSerbestlikKisa = r6
            r10 = 0
            r0.denSerbestlikInt = r10
            goto L_0x0ec5
        L_0x0ec1:
            r6 = r20
            r7 = r23
        L_0x0ec5:
            int r10 = r0.kapalidaki_gun_sayisi(r1)
            int r2 = r14 + -365
            if (r10 <= r2) goto L_0x0ef7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r10 = r0.kapalidaki_gun_sayisi(r1)
            r2.append(r10)
            r2.append(r9)
            int r10 = r0.kapalidaki_gun_sayisi(r1)
            java.lang.String r10 = gunCevirme(r10)
            r2.append(r10)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            r0.cezaevindeKalinacakToplamSureInt = r2
            goto L_0x0f14
        L_0x0ef7:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r2)
            r10.append(r9)
            java.lang.String r12 = gunCevirme(r2)
            r10.append(r12)
            r10.append(r13)
            java.lang.String r10 = r10.toString()
            r0.cezaevindeKalinacakToplamSureString = r10
            r0.cezaevindeKalinacakToplamSureInt = r2
        L_0x0f14:
            java.lang.String r2 = "1/4"
            r16 = r4
            r22 = r5
            r25 = r6
            r23 = r7
            r4 = r2
            r2 = r8
            goto L_0x17f4
        L_0x0f22:
            r15 = r18
            goto L_0x0f29
        L_0x0f25:
            r15 = r18
            r14 = r19
        L_0x0f29:
            r25 = r20
            android.widget.RadioButton r7 = r0.rbIkinciTekerrur
            boolean r7 = r7.isChecked()
            if (r7 != 0) goto L_0x0fdc
            android.widget.RadioButton r7 = r0.rb6545SKSonra
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x0fdc
            android.widget.RadioButton r7 = r0.rbUcuncuGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 != 0) goto L_0x0fdc
            android.widget.RadioButton r7 = r0.rbTekerrurHayir
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x0fdc
            android.widget.TextView r7 = r0.tv_seciliSuc
            java.lang.CharSequence r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            r24 = r8
            java.lang.String r8 = "* Uyuşturucu veya uyarıcı madde imal ve ticareti suçu (TCK 188)"
            boolean r7 = r7.equalsIgnoreCase(r8)
            if (r7 != 0) goto L_0x0f71
            android.widget.TextView r7 = r0.tv_seciliSuc
            java.lang.CharSequence r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "* Ağır cinsel suçlar (TCK 102/2, 103, 104/2-3)"
            boolean r7 = r7.equalsIgnoreCase(r8)
            if (r7 == 0) goto L_0x0fde
        L_0x0f71:
            r7 = 365(0x16d, float:5.11E-43)
            if (r14 > r7) goto L_0x0fde
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r11)
            int r8 = r27.mahsupGun()
            r7.append(r8)
            java.lang.String r8 = " gün\n1/4 İndirim: "
            r7.append(r8)
            r7.append(r15)
            r7.append(r9)
            java.lang.String r8 = gunCevirme(r15)
            r7.append(r8)
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            r0.indirimler = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            r2.append(r9)
            java.lang.String r7 = gunCevirme(r14)
            r2.append(r7)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.sartlaTahliyeString = r2
            java.lang.String r2 = r0.gir_cik_durumu(r1)
            r0.denSerbestlik = r2
            r0.sartlaTahliye = r14
            r0.yatariVarMi = r4
            r0.cezaevindeKalinacakToplamSureString = r5
            r2 = 0
            r0.cezaevindeKalinacakToplamSureInt = r2
            r0.denSerbestlikKisa = r6
            r2 = 365(0x16d, float:5.11E-43)
            r0.denSerbestlikInt = r2
            r0.sartlaTahliyeIndirimiInt = r15
            java.lang.String r2 = "1/4"
            r16 = r4
            r22 = r5
            r4 = r2
        L_0x0fd8:
            r2 = r24
            goto L_0x17f4
        L_0x0fdc:
            r24 = r8
        L_0x0fde:
            android.widget.RadioButton r2 = r0.rbIkinciTekerrur
            boolean r2 = r2.isChecked()
            java.lang.String r6 = "Hükümlünün örgütten ayrıldığı;\n1-Tespit edilirse: 1 yıl\n2-Tespit etdilmezse: Yok"
            java.lang.String r7 = "Hükümlünün örgütten ayrılıp ayrılmadığına göre değişmektedir."
            java.lang.String r8 = ") kapalı ceza evinde kalır."
            r22 = r5
            java.lang.String r5 = ")\n2-Tespit etdilmezse:\n"
            r16 = r4
            java.lang.String r4 = "Hükümlünün örgütten ayrıldığı;\n1-Tespit edilirse:\n"
            if (r2 != 0) goto L_0x1116
            android.widget.RadioButton r2 = r0.rbUcuncuGrupSuc
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x1116
            android.widget.RadioButton r2 = r0.rbEtkin_Hayir
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x1116
            android.widget.RadioButton r2 = r0.rbTekerrurHayir
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x1116
            android.widget.TextView r2 = r0.tv_seciliSuc
            java.lang.CharSequence r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            r21 = r3
            java.lang.String r3 = "* Terör suçları (3713 sayılı yasa)"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x1118
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            int r3 = r27.mahsupGun()
            r2.append(r3)
            java.lang.String r3 = " gün\n1/4 İndirim: "
            r2.append(r3)
            r2.append(r15)
            r2.append(r9)
            java.lang.String r3 = gunCevirme(r15)
            r2.append(r3)
            java.lang.String r3 = ")\nDenetimli Serbestlik: 1 yıl veya Yok"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.indirimler = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            r2.append(r9)
            java.lang.String r3 = gunCevirme(r14)
            r2.append(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.sartlaTahliyeString = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Hükümlünün örgütten ayrıldığı;\n1-Tespit edilirse:\nHükümlü açık ceza evine ayrıldıktan sonra, iyi halli olmak kaydıyla kısa bir süre içinde (3 gün - 1 hafta gibi) işlemleri tamamlanıp denetimli serbestlikle erken tahliye olabilir.\n2-Tespit etdilmezse:\nHükümlü açık cezaevine ayrılamadığı gibi denetimli serbestlikten de faydalanamaz. Şartla tahliye tarihine kadar kapalı cezaevinde kalır. Başka bir anlatımla, hükümlü  "
            r2.append(r3)
            r2.append(r14)
            r2.append(r9)
            java.lang.String r3 = gunCevirme(r14)
            r2.append(r3)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            r0.denSerbestlik = r2
            r0.sartlaTahliye = r14
            r0.yatariVarMi = r7
            r0.denSerbestlikKisa = r6
            r0.sartlaTahliyeIndirimiInt = r15
            r2 = 365(0x16d, float:5.11E-43)
            r0.denSerbestlikInt = r2
            r2 = 0
            r0.denSerSuresi_RaporOlumsuzsa = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            int r7 = r14 + -365
            if (r2 <= r7) goto L_0x10dd
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            int r3 = r0.kapalidaki_gun_sayisi(r1)
            r2.append(r3)
            r2.append(r9)
            int r3 = r0.kapalidaki_gun_sayisi(r1)
            java.lang.String r3 = gunCevirme(r3)
            r2.append(r3)
            r2.append(r5)
            r2.append(r14)
            r2.append(r9)
            java.lang.String r3 = gunCevirme(r14)
            r2.append(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            r0.cezaevindeKalinacakToplamSureInt = r2
            r0.cezaevindeKalinacakToplamSure_RaporOlumsuzsa = r14
            goto L_0x110f
        L_0x10dd:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r7)
            r2.append(r9)
            java.lang.String r3 = gunCevirme(r7)
            r2.append(r3)
            r2.append(r5)
            r2.append(r14)
            r2.append(r9)
            java.lang.String r3 = gunCevirme(r14)
            r2.append(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            r0.cezaevindeKalinacakToplamSureInt = r7
            r0.cezaevindeKalinacakToplamSure_RaporOlumsuzsa = r14
        L_0x110f:
            java.lang.String r2 = "1/4"
            r4 = r2
            r3 = r21
            goto L_0x0fd8
        L_0x1116:
            r21 = r3
        L_0x1118:
            android.widget.RadioButton r2 = r0.rbIkinciTekerrur
            boolean r2 = r2.isChecked()
            if (r2 != 0) goto L_0x124e
            android.widget.RadioButton r2 = r0.rbUcuncuGrupSuc
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x124e
            android.widget.RadioButton r2 = r0.rbEtkin_Evet
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x124e
            android.widget.RadioButton r2 = r0.rbTekerrurHayir
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x124e
            android.widget.TextView r2 = r0.tv_seciliSuc
            java.lang.CharSequence r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "* Terör suçları (3713 sayılı yasa)"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x124e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            int r3 = r27.mahsupGun()
            r2.append(r3)
            java.lang.String r3 = " gün\n1/4 İndirim: "
            r2.append(r3)
            r2.append(r15)
            r2.append(r9)
            java.lang.String r3 = gunCevirme(r15)
            r2.append(r3)
            java.lang.String r3 = ")\nDenetimli Serbestlik: 1 yıl veya Yok"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.indirimler = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            r2.append(r9)
            java.lang.String r3 = gunCevirme(r14)
            r2.append(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.sartlaTahliyeString = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Hükümlünün örgütten ayrıldığı;\n1-Tespit edilirse:\nHükümlü iyi hâlli olmak kaydıyla şartla tahliye tarihine 1 yıl kala denetimli serbestlikten faydalanabilir. Başka bir anlatımla toplamda;\n"
            r2.append(r3)
            int r3 = r14 + -365
            r2.append(r3)
            r2.append(r9)
            java.lang.String r10 = gunCevirme(r3)
            r2.append(r10)
            java.lang.String r10 = ") cezaevinde kaldıktan sonra denetimli serbestlikle erken tahliye olabilir\n2-Tespit etdilmezse:\nHükümlü açık cezaevine ayrılamadığı gibi denetimli serbestlikten de faydalanamaz. Şartla tahliye tarihine kadar kapalı cezaevinde kalır. Diğer bir tabirle, hükümlü  "
            r2.append(r10)
            r2.append(r14)
            r2.append(r9)
            java.lang.String r10 = gunCevirme(r14)
            r2.append(r10)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            r0.denSerbestlik = r2
            r0.sartlaTahliye = r14
            r0.yatariVarMi = r7
            r0.denSerbestlikKisa = r6
            r0.sartlaTahliyeIndirimiInt = r15
            r2 = 365(0x16d, float:5.11E-43)
            r0.denSerbestlikInt = r2
            r2 = 0
            r0.denSerSuresi_RaporOlumsuzsa = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            if (r2 <= r3) goto L_0x121a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            int r3 = r0.kapalidaki_gun_sayisi(r1)
            r2.append(r3)
            r2.append(r9)
            int r3 = r0.kapalidaki_gun_sayisi(r1)
            java.lang.String r3 = gunCevirme(r3)
            r2.append(r3)
            r2.append(r5)
            r2.append(r14)
            r2.append(r9)
            java.lang.String r3 = gunCevirme(r14)
            r2.append(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            r0.cezaevindeKalinacakToplamSureInt = r2
            r0.cezaevindeKalinacakToplamSure_RaporOlumsuzsa = r14
            goto L_0x110f
        L_0x121a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r3)
            r2.append(r9)
            java.lang.String r4 = gunCevirme(r3)
            r2.append(r4)
            r2.append(r5)
            r2.append(r14)
            r2.append(r9)
            java.lang.String r4 = gunCevirme(r14)
            r2.append(r4)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            r0.cezaevindeKalinacakToplamSureInt = r3
            r0.cezaevindeKalinacakToplamSure_RaporOlumsuzsa = r14
            goto L_0x110f
        L_0x124e:
            android.widget.RadioButton r2 = r0.rbIkinciTekerrur
            boolean r2 = r2.isChecked()
            if (r2 != 0) goto L_0x1391
            android.widget.RadioButton r2 = r0.oncesi2016
            boolean r2 = r2.isChecked()
            if (r2 != 0) goto L_0x1266
            android.widget.RadioButton r2 = r0.oncesi2020
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x1391
        L_0x1266:
            android.widget.RadioButton r2 = r0.rbUcuncuGrupSuc
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x1391
            android.widget.RadioButton r2 = r0.rbEtkin_Hayir
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x1391
            android.widget.RadioButton r2 = r0.rbTekerrurHayir
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x1391
            android.widget.TextView r2 = r0.tv_seciliSuc
            java.lang.CharSequence r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "* Terör suçu olmayan örgüt suçları"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x1391
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            int r3 = r27.mahsupGun()
            r2.append(r3)
            r2.append(r10)
            r2.append(r12)
            r2.append(r9)
            java.lang.String r3 = gunCevirme(r12)
            r2.append(r3)
            java.lang.String r3 = ")\nDenetimli Serbestlik: 3 yıl veya Yok"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.indirimler = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = r21
            r2.append(r3)
            r2.append(r9)
            java.lang.String r10 = gunCevirme(r3)
            r2.append(r10)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.sartlaTahliyeString = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r10 = "Hükümlünün örgütten ayrıldığı;\n1-Tespit edilirse:\nHükümlü açık ceza evine ayrıldıktan sonra, iyi halli olmak kaydıyla kısa bir süre içinde (3 gün - 1 hafta gibi) işlemleri tamamlanıp denetimli serbestlikle erken tahliye olabilir.\n2-Tespit etdilmezse:\nHükümlü açık cezaevine ayrılamadığı gibi denetimli serbestlikten de faydalanamaz. Şartla tahliye tarihine kadar kapalı cezaevinde kalır. Başka bir anlatımla, hükümlü  "
            r2.append(r10)
            r2.append(r3)
            r2.append(r9)
            java.lang.String r10 = gunCevirme(r3)
            r2.append(r10)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            r0.denSerbestlik = r2
            r0.sartlaTahliye = r3
            r0.yatariVarMi = r7
            r0.denSerbestlikKisa = r6
            r0.sartlaTahliyeIndirimiInt = r12
            r2 = 1095(0x447, float:1.534E-42)
            r0.denSerbestlikInt = r2
            r2 = 0
            r0.denSerSuresi_RaporOlumsuzsa = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            int r6 = r0.denSerbestlikInt
            int r6 = r3 - r6
            if (r2 <= r6) goto L_0x134f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            int r4 = r0.kapalidaki_gun_sayisi(r1)
            r2.append(r4)
            r2.append(r9)
            int r4 = r0.kapalidaki_gun_sayisi(r1)
            java.lang.String r4 = gunCevirme(r4)
            r2.append(r4)
            r2.append(r5)
            r2.append(r3)
            r2.append(r9)
            java.lang.String r4 = gunCevirme(r3)
            r2.append(r4)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            r0.cezaevindeKalinacakToplamSureInt = r2
            r0.cezaevindeKalinacakToplamSure_RaporOlumsuzsa = r3
            goto L_0x138d
        L_0x134f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            int r4 = r0.denSerbestlikInt
            int r6 = r3 - r4
            r2.append(r6)
            r2.append(r9)
            int r4 = r0.denSerbestlikInt
            int r6 = r3 - r4
            java.lang.String r4 = gunCevirme(r6)
            r2.append(r4)
            r2.append(r5)
            r2.append(r3)
            r2.append(r9)
            java.lang.String r4 = gunCevirme(r3)
            r2.append(r4)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.denSerbestlikInt
            int r6 = r3 - r2
            r0.cezaevindeKalinacakToplamSureInt = r6
            r0.cezaevindeKalinacakToplamSure_RaporOlumsuzsa = r3
        L_0x138d:
            r4 = r17
            goto L_0x0fd8
        L_0x1391:
            r3 = r21
            android.widget.RadioButton r2 = r0.rbIkinciTekerrur
            boolean r2 = r2.isChecked()
            if (r2 != 0) goto L_0x14e7
            android.widget.RadioButton r2 = r0.oncesi2016
            boolean r2 = r2.isChecked()
            if (r2 != 0) goto L_0x13ab
            android.widget.RadioButton r2 = r0.oncesi2020
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x14e7
        L_0x13ab:
            android.widget.RadioButton r2 = r0.rbUcuncuGrupSuc
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x14e7
            android.widget.RadioButton r2 = r0.rbEtkin_Evet
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x14e7
            android.widget.RadioButton r2 = r0.rbTekerrurHayir
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x14e7
            android.widget.TextView r2 = r0.tv_seciliSuc
            java.lang.CharSequence r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r14 = "* Terör suçu olmayan örgüt suçları"
            boolean r2 = r2.equalsIgnoreCase(r14)
            if (r2 == 0) goto L_0x14e7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            int r14 = r27.mahsupGun()
            r2.append(r14)
            r2.append(r10)
            r2.append(r12)
            r2.append(r9)
            java.lang.String r10 = gunCevirme(r12)
            r2.append(r10)
            java.lang.String r10 = ")\nDenetimli Serbestlik: 3 yıl veya Yok"
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            r0.indirimler = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r9)
            java.lang.String r10 = gunCevirme(r3)
            r2.append(r10)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.sartlaTahliyeString = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r10 = "Hükümlünün örgütten ayrıldığı;\n1-Tespit edilirse:\nHükümlü iyi hâlli olmak kaydıyla şartla tahliye tarihine 1 yıl kala denetimli serbestlikten faydalanabilir. Başka bir anlatımla toplamda;\n"
            r2.append(r10)
            int r10 = r3 + -1095
            r2.append(r10)
            r2.append(r9)
            java.lang.String r10 = gunCevirme(r10)
            r2.append(r10)
            java.lang.String r10 = ") cezaevinde kaldıktan sonra denetimli serbestlikle erken tahliye olabilir\n2-Tespit etdilmezse:\nHükümlü açık cezaevine ayrılamadığı gibi denetimli serbestlikten de faydalanamaz. Şartla tahliye tarihine kadar kapalı cezaevinde kalır. Diğer bir tabirle, hükümlü  "
            r2.append(r10)
            r2.append(r3)
            r2.append(r9)
            java.lang.String r10 = gunCevirme(r3)
            r2.append(r10)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            r0.denSerbestlik = r2
            r0.sartlaTahliye = r3
            r0.yatariVarMi = r7
            r0.denSerbestlikKisa = r6
            r0.sartlaTahliyeIndirimiInt = r12
            r2 = 1095(0x447, float:1.534E-42)
            r0.denSerbestlikInt = r2
            r2 = 0
            r0.denSerSuresi_RaporOlumsuzsa = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            int r6 = r0.denSerbestlikInt
            int r6 = r3 - r6
            if (r2 <= r6) goto L_0x14a7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            int r4 = r0.kapalidaki_gun_sayisi(r1)
            r2.append(r4)
            r2.append(r9)
            int r4 = r0.kapalidaki_gun_sayisi(r1)
            java.lang.String r4 = gunCevirme(r4)
            r2.append(r4)
            r2.append(r5)
            r2.append(r3)
            r2.append(r9)
            java.lang.String r4 = gunCevirme(r3)
            r2.append(r4)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            r0.cezaevindeKalinacakToplamSureInt = r2
            r0.cezaevindeKalinacakToplamSure_RaporOlumsuzsa = r3
            goto L_0x138d
        L_0x14a7:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            int r4 = r0.denSerbestlikInt
            int r6 = r3 - r4
            r2.append(r6)
            r2.append(r9)
            int r4 = r0.denSerbestlikInt
            int r6 = r3 - r4
            java.lang.String r4 = gunCevirme(r6)
            r2.append(r4)
            r2.append(r5)
            r2.append(r3)
            r2.append(r9)
            java.lang.String r4 = gunCevirme(r3)
            r2.append(r4)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.denSerbestlikInt
            int r6 = r3 - r2
            r0.cezaevindeKalinacakToplamSureInt = r6
            r0.cezaevindeKalinacakToplamSure_RaporOlumsuzsa = r3
            goto L_0x138d
        L_0x14e7:
            android.widget.RadioButton r2 = r0.rbIkinciTekerrur
            boolean r2 = r2.isChecked()
            if (r2 != 0) goto L_0x161f
            android.widget.RadioButton r2 = r0.sonrasi2020
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x161f
            android.widget.RadioButton r2 = r0.rbUcuncuGrupSuc
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x161f
            android.widget.RadioButton r2 = r0.rbEtkin_Hayir
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x161f
            android.widget.RadioButton r2 = r0.rbTekerrurHayir
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x161f
            android.widget.TextView r2 = r0.tv_seciliSuc
            java.lang.CharSequence r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r14 = "* Terör suçu olmayan örgüt suçları"
            boolean r2 = r2.equalsIgnoreCase(r14)
            if (r2 == 0) goto L_0x161f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            int r14 = r27.mahsupGun()
            r2.append(r14)
            r2.append(r10)
            r2.append(r12)
            r2.append(r9)
            java.lang.String r10 = gunCevirme(r12)
            r2.append(r10)
            java.lang.String r10 = ")\nDenetimli Serbestlik: 1 yıl veya Yok"
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            r0.indirimler = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r9)
            java.lang.String r10 = gunCevirme(r3)
            r2.append(r10)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.sartlaTahliyeString = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r10 = "Hükümlünün örgütten ayrıldığı;\n1-Tespit edilirse:\nHükümlü açık ceza evine ayrıldıktan sonra, iyi halli olmak kaydıyla kısa bir süre içinde (3 gün - 1 hafta gibi) işlemleri tamamlanıp denetimli serbestlikle erken tahliye olabilir.\n2-Tespit etdilmezse:\nHükümlü açık cezaevine ayrılamadığı gibi denetimli serbestlikten de faydalanamaz. Şartla tahliye tarihine kadar kapalı cezaevinde kalır. Başka bir anlatımla, hükümlü  "
            r2.append(r10)
            r2.append(r3)
            r2.append(r9)
            java.lang.String r10 = gunCevirme(r3)
            r2.append(r10)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            r0.denSerbestlik = r2
            r0.sartlaTahliye = r3
            r0.yatariVarMi = r7
            r0.denSerbestlikKisa = r6
            r0.sartlaTahliyeIndirimiInt = r12
            r2 = 365(0x16d, float:5.11E-43)
            r0.denSerbestlikInt = r2
            r2 = 0
            r0.denSerSuresi_RaporOlumsuzsa = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            int r6 = r0.denSerbestlikInt
            int r6 = r3 - r6
            if (r2 <= r6) goto L_0x15df
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            int r4 = r0.kapalidaki_gun_sayisi(r1)
            r2.append(r4)
            r2.append(r9)
            int r4 = r0.kapalidaki_gun_sayisi(r1)
            java.lang.String r4 = gunCevirme(r4)
            r2.append(r4)
            r2.append(r5)
            r2.append(r3)
            r2.append(r9)
            java.lang.String r4 = gunCevirme(r3)
            r2.append(r4)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            r0.cezaevindeKalinacakToplamSureInt = r2
            r0.cezaevindeKalinacakToplamSure_RaporOlumsuzsa = r3
            goto L_0x138d
        L_0x15df:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            int r4 = r0.denSerbestlikInt
            int r6 = r3 - r4
            r2.append(r6)
            r2.append(r9)
            int r4 = r0.denSerbestlikInt
            int r6 = r3 - r4
            java.lang.String r4 = gunCevirme(r6)
            r2.append(r4)
            r2.append(r5)
            r2.append(r3)
            r2.append(r9)
            java.lang.String r4 = gunCevirme(r3)
            r2.append(r4)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.denSerbestlikInt
            int r6 = r3 - r2
            r0.cezaevindeKalinacakToplamSureInt = r6
            r0.cezaevindeKalinacakToplamSure_RaporOlumsuzsa = r3
            goto L_0x138d
        L_0x161f:
            android.widget.RadioButton r2 = r0.rbIkinciTekerrur
            boolean r2 = r2.isChecked()
            if (r2 != 0) goto L_0x176b
            android.widget.RadioButton r2 = r0.sonrasi2020
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x176b
            android.widget.RadioButton r2 = r0.rbUcuncuGrupSuc
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x176b
            android.widget.RadioButton r2 = r0.rbEtkin_Evet
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x176b
            android.widget.RadioButton r2 = r0.rbTekerrurHayir
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x176b
            android.widget.TextView r2 = r0.tv_seciliSuc
            java.lang.CharSequence r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r14 = "* Terör suçu olmayan örgüt suçları"
            boolean r2 = r2.equalsIgnoreCase(r14)
            if (r2 == 0) goto L_0x176b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            int r14 = r27.mahsupGun()
            r2.append(r14)
            r2.append(r10)
            r2.append(r12)
            r2.append(r9)
            java.lang.String r10 = gunCevirme(r12)
            r2.append(r10)
            java.lang.String r10 = ")\nDenetimli Serbestlik: 1 yıl veya Yok"
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            r0.indirimler = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r9)
            java.lang.String r10 = gunCevirme(r3)
            r2.append(r10)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.sartlaTahliyeString = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r10 = "Hükümlünün örgütten ayrıldığı;\n1-Tespit edilirse:\nHükümlü iyi hâlli olmak kaydıyla şartla tahliye tarihine 1 yıl kala denetimli serbestlikten faydalanabilir. Başka bir anlatımla toplamda;\n"
            r2.append(r10)
            int r10 = r3 + -365
            r2.append(r10)
            r2.append(r9)
            java.lang.String r10 = gunCevirme(r10)
            r2.append(r10)
            java.lang.String r10 = ") cezaevinde kaldıktan sonra denetimli serbestlikle erken tahliye olabilir\n2-Tespit etdilmezse:\nHükümlü açık cezaevine ayrılamadığı gibi denetimli serbestlikten de faydalanamaz. Şartla tahliye tarihine kadar kapalı cezaevinde kalır. Diğer bir tabirle, hükümlü  "
            r2.append(r10)
            r2.append(r3)
            r2.append(r9)
            java.lang.String r10 = gunCevirme(r3)
            r2.append(r10)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            r0.denSerbestlik = r2
            r0.sartlaTahliye = r3
            r0.yatariVarMi = r7
            r0.denSerbestlikKisa = r6
            r0.sartlaTahliyeIndirimiInt = r12
            r2 = 365(0x16d, float:5.11E-43)
            r0.denSerbestlikInt = r2
            r2 = 0
            r0.denSerSuresi_RaporOlumsuzsa = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            int r6 = r0.denSerbestlikInt
            int r6 = r3 - r6
            if (r2 <= r6) goto L_0x172b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            int r4 = r0.kapalidaki_gun_sayisi(r1)
            r2.append(r4)
            r2.append(r9)
            int r4 = r0.kapalidaki_gun_sayisi(r1)
            java.lang.String r4 = gunCevirme(r4)
            r2.append(r4)
            r2.append(r5)
            r2.append(r3)
            r2.append(r9)
            java.lang.String r4 = gunCevirme(r3)
            r2.append(r4)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            r0.cezaevindeKalinacakToplamSureInt = r2
            r0.cezaevindeKalinacakToplamSure_RaporOlumsuzsa = r3
            goto L_0x138d
        L_0x172b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            int r4 = r0.denSerbestlikInt
            int r6 = r3 - r4
            r2.append(r6)
            r2.append(r9)
            int r4 = r0.denSerbestlikInt
            int r6 = r3 - r4
            java.lang.String r4 = gunCevirme(r6)
            r2.append(r4)
            r2.append(r5)
            r2.append(r3)
            r2.append(r9)
            java.lang.String r4 = gunCevirme(r3)
            r2.append(r4)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.denSerbestlikInt
            int r6 = r3 - r2
            r0.cezaevindeKalinacakToplamSureInt = r6
            r0.cezaevindeKalinacakToplamSure_RaporOlumsuzsa = r3
            goto L_0x138d
        L_0x176b:
            android.widget.RadioButton r2 = r0.rbTekerrurEvet
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x17f0
            android.widget.RadioButton r2 = r0.rbIkinciTekerrur
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x17f0
            android.widget.RadioButton r2 = r0.rbUcuncuGrupSuc
            boolean r2 = r2.isChecked()
            if (r2 != 0) goto L_0x17f0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            int r4 = r27.mahsupGun()
            r2.append(r4)
            java.lang.String r4 = " gün\n1/3 İndirim: Uygulanmaz!\nDenetimli Serbestlik: Uygulanmaz!"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r0.indirimler = r2
            java.lang.String r2 = "Şartla Tahliye Uygulanmaz!"
            r0.sartlaTahliyeString = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Denetimli Serbestlik Uygulanmaz!\n"
            r2.append(r4)
            r2.append(r1)
            r2.append(r9)
            java.lang.String r4 = gunCevirme(r1)
            r2.append(r4)
            java.lang.String r4 = ") hükümlü cezaevinde kalarak cezanın TAMAMINI yatmalı"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r0.denSerbestlik = r2
            r0.sartlaTahliye = r1
            r2 = r24
            r0.yatariVarMi = r2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r4.append(r9)
            java.lang.String r5 = gunCevirme(r1)
            r4.append(r5)
            r4.append(r13)
            java.lang.String r4 = r4.toString()
            r0.cezaevindeKalinacakToplamSureString = r4
            r0.cezaevindeKalinacakToplamSureInt = r1
            java.lang.String r4 = "Uygulanmaz!"
            r0.denSerbestlikKisa = r4
            r4 = 0
            r0.denSerbestlikInt = r4
            r0.sartlaTahliyeIndirimiInt = r4
            goto L_0x17f2
        L_0x17f0:
            r2 = r24
        L_0x17f2:
            r4 = r22
        L_0x17f4:
            android.widget.RadioButton r5 = r0.rbTekerrurEvet
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x1a94
            android.widget.RadioButton r5 = r0.rbBirinciTekerrur
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x1a94
            android.widget.RadioButton r5 = r0.rbUcuncuGrupSuc
            boolean r5 = r5.isChecked()
            if (r5 != 0) goto L_0x1a94
            int r5 = r0.sartlaTahliye
            if (r5 < r3) goto L_0x1811
            goto L_0x181a
        L_0x1811:
            int r6 = r27.tekerrureEsasSure()
            int r5 = r5 + r6
            int r5 = java.lang.Math.min(r3, r5)
        L_0x181a:
            int r6 = r0.sartlaTahliye
            if (r6 < r3) goto L_0x1872
            int r6 = r1 - r6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Hükümlünün suç ve tarihine göre olan "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " indirimli şartla tahliye süresi ("
            r7.append(r8)
            int r8 = r0.sartlaTahliye
            r7.append(r8)
            java.lang.String r8 = " gün), 1/3 indirimli tekerrür şartla tahliye süresi olan ("
            r7.append(r8)
            r7.append(r3)
            java.lang.String r3 = " günden) daha uzun veya eşit.\nBu sebeple şartla tahliye süresi: "
            r7.append(r3)
            int r3 = r0.sartlaTahliye
            r7.append(r3)
            r7.append(r9)
            int r3 = r0.sartlaTahliye
            java.lang.String r3 = gunCevirme(r3)
            r7.append(r3)
            java.lang.String r3 = ").\nŞartla tahliye indirimi de : "
            r7.append(r3)
            r7.append(r6)
            java.lang.String r3 = " gün. ("
            r7.append(r3)
            java.lang.String r3 = gunCevirme(r6)
            r7.append(r3)
            r7.append(r13)
            java.lang.String r3 = r7.toString()
            goto L_0x1973
        L_0x1872:
            if (r6 >= r3) goto L_0x18fb
            int r7 = r27.tekerrureEsasSure()
            int r6 = r6 + r7
            if (r6 >= r3) goto L_0x18fb
            int r6 = r0.sartlaTahliye
            int r7 = r27.tekerrureEsasSure()
            int r6 = r6 + r7
            int r6 = r1 - r6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Hükümlünün suç ve tarihine göre olan "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " indirimli şartla tahliye süresi ("
            r7.append(r8)
            int r8 = r0.sartlaTahliye
            r7.append(r8)
            java.lang.String r8 = " gün) + tekerrüre esas ceza ("
            r7.append(r8)
            int r8 = r27.tekerrureEsasSure()
            r7.append(r8)
            java.lang.String r8 = " gün) = "
            r7.append(r8)
            int r8 = r0.sartlaTahliye
            int r10 = r27.tekerrureEsasSure()
            int r8 = r8 + r10
            r7.append(r8)
            java.lang.String r8 = " . Bu süre 2/3 tekerrür infaz süresi olan "
            r7.append(r8)
            r7.append(r3)
            java.lang.String r3 = " günden az olduğundan lehe.\nBu sebeple şartla tahliye süresi : "
            r7.append(r3)
            int r3 = r0.sartlaTahliye
            int r8 = r27.tekerrureEsasSure()
            int r3 = r3 + r8
            r7.append(r3)
            r7.append(r9)
            int r3 = r0.sartlaTahliye
            int r8 = r27.tekerrureEsasSure()
            int r3 = r3 + r8
            java.lang.String r3 = gunCevirme(r3)
            r7.append(r3)
            java.lang.String r3 = ").\nŞartla tahliye indirimi de : "
            r7.append(r3)
            r7.append(r6)
            r7.append(r9)
            java.lang.String r3 = gunCevirme(r6)
            r7.append(r3)
            java.lang.String r3 = ")."
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            goto L_0x1973
        L_0x18fb:
            int r6 = r0.sartlaTahliye
            if (r6 >= r3) goto L_0x1970
            int r7 = r27.tekerrureEsasSure()
            int r6 = r6 + r7
            if (r6 <= r3) goto L_0x1970
            int r6 = r1 - r3
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Hükümlünün suç ve tarihine göre olan "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " indirimli şartla tahliye süresi ("
            r7.append(r8)
            int r8 = r0.sartlaTahliye
            r7.append(r8)
            java.lang.String r8 = " gün) + tekerrüre esas ceza ("
            r7.append(r8)
            int r8 = r27.tekerrureEsasSure()
            r7.append(r8)
            java.lang.String r8 = " gün) = "
            r7.append(r8)
            int r8 = r0.sartlaTahliye
            int r10 = r27.tekerrureEsasSure()
            int r8 = r8 + r10
            r7.append(r8)
            java.lang.String r8 = " . Bu süre 2/3 tekerrür infaz süresi olan "
            r7.append(r8)
            r7.append(r3)
            java.lang.String r8 = " günden fazla olduğundan aleyhe.\nBu sebeple şartla tahliye süresi : "
            r7.append(r8)
            r7.append(r3)
            r7.append(r9)
            java.lang.String r3 = gunCevirme(r3)
            r7.append(r3)
            java.lang.String r3 = ").\nŞartla tahliye indirimi de : "
            r7.append(r3)
            r7.append(r6)
            r7.append(r9)
            java.lang.String r3 = gunCevirme(r6)
            r7.append(r3)
            java.lang.String r3 = ")."
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            goto L_0x1973
        L_0x1970:
            r3 = r22
            r6 = 0
        L_0x1973:
            int r7 = r0.denSerbestlikInt
            if (r5 <= r7) goto L_0x1a35
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r11)
            int r8 = r27.mahsupGun()
            r7.append(r8)
            java.lang.String r8 = " gün\n"
            r7.append(r8)
            r7.append(r3)
            java.lang.String r8 = "\nDenetimli Serbestlik: "
            r7.append(r8)
            java.lang.String r8 = r0.denSerbestlikKisa
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r0.indirimler = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            r7.append(r9)
            java.lang.String r8 = gunCevirme(r5)
            r7.append(r8)
            r7.append(r13)
            java.lang.String r7 = r7.toString()
            r0.sartlaTahliyeString = r7
            r0.sartlaTahliye = r5
            r0.yatariVarMi = r2
            r0.sartlaTahliyeIndirimiInt = r6
            android.widget.RadioButton r7 = r0.rbAcigaAyrilmaEvet
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x19d3
            r7 = r23
            r0.denSerbestlik = r7
            r8 = r25
            r0.denSerbestlikKisa = r8
            r10 = 0
            r0.denSerbestlikInt = r10
            goto L_0x19d7
        L_0x19d3:
            r7 = r23
            r8 = r25
        L_0x19d7:
            int r10 = r0.kapalidaki_gun_sayisi(r1)
            int r12 = r0.denSerbestlikInt
            int r12 = r5 - r12
            if (r10 <= r12) goto L_0x1a0b
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            int r12 = r0.kapalidaki_gun_sayisi(r1)
            r10.append(r12)
            r10.append(r9)
            int r12 = r0.kapalidaki_gun_sayisi(r1)
            java.lang.String r12 = gunCevirme(r12)
            r10.append(r12)
            r10.append(r13)
            java.lang.String r10 = r10.toString()
            r0.cezaevindeKalinacakToplamSureString = r10
            int r10 = r0.kapalidaki_gun_sayisi(r1)
            r0.cezaevindeKalinacakToplamSureInt = r10
            goto L_0x1a39
        L_0x1a0b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            int r12 = r0.denSerbestlikInt
            int r12 = r5 - r12
            r10.append(r12)
            r10.append(r9)
            int r12 = r0.denSerbestlikInt
            int r12 = r5 - r12
            java.lang.String r12 = gunCevirme(r12)
            r10.append(r12)
            r10.append(r13)
            java.lang.String r10 = r10.toString()
            r0.cezaevindeKalinacakToplamSureString = r10
            int r10 = r0.denSerbestlikInt
            int r10 = r5 - r10
            r0.cezaevindeKalinacakToplamSureInt = r10
            goto L_0x1a39
        L_0x1a35:
            r7 = r23
            r8 = r25
        L_0x1a39:
            int r10 = r0.denSerbestlikInt
            if (r5 > r10) goto L_0x1a8f
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r11)
            int r12 = r27.mahsupGun()
            r10.append(r12)
            java.lang.String r12 = " gün\n"
            r10.append(r12)
            r10.append(r3)
            java.lang.String r3 = "\nDenetimli Serbestlik: "
            r10.append(r3)
            java.lang.String r3 = r0.denSerbestlikKisa
            r10.append(r3)
            java.lang.String r3 = r10.toString()
            r0.indirimler = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r9)
            java.lang.String r10 = gunCevirme(r5)
            r3.append(r10)
            r3.append(r13)
            java.lang.String r3 = r3.toString()
            r0.sartlaTahliyeString = r3
            r0.sartlaTahliye = r5
            r3 = r16
            r0.yatariVarMi = r3
            r5 = r22
            r0.cezaevindeKalinacakToplamSureString = r5
            r10 = 0
            r0.cezaevindeKalinacakToplamSureInt = r10
            r0.sartlaTahliyeIndirimiInt = r6
            goto L_0x1a9c
        L_0x1a8f:
            r3 = r16
            r5 = r22
            goto L_0x1a9c
        L_0x1a94:
            r3 = r16
            r5 = r22
            r7 = r23
            r8 = r25
        L_0x1a9c:
            android.widget.RadioButton r6 = r0.rbCocukYaslilikEvet
            boolean r6 = r6.isChecked()
            if (r6 == 0) goto L_0x1c43
            android.widget.TextView r6 = r0.tv_seciliSuc
            java.lang.CharSequence r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            java.lang.String r10 = "* İşkence suçu (TCK 94 ve 95)"
            boolean r6 = r6.equalsIgnoreCase(r10)
            if (r6 != 0) goto L_0x1b34
            android.widget.TextView r6 = r0.tv_seciliSuc
            java.lang.CharSequence r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            java.lang.String r10 = "* Eziyet suçu (TCK 96)"
            boolean r6 = r6.equalsIgnoreCase(r10)
            if (r6 != 0) goto L_0x1b34
            android.widget.TextView r6 = r0.tv_seciliSuc
            java.lang.CharSequence r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            java.lang.String r10 = "* Üstsoya, altsoya, eşe veya kardeşe ya da beden veya ruh bakımından kendisini savunamayacak durumda bulunan kişiye karşı işlenen kasten yaralama"
            boolean r6 = r6.equalsIgnoreCase(r10)
            if (r6 != 0) goto L_0x1b34
            android.widget.TextView r6 = r0.tv_seciliSuc
            java.lang.CharSequence r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            java.lang.String r10 = "* Yüzde sürekli değişikliğe sebebiyet verecek şekilde ağırlaşmış yaralama suçu (m. 87/2-d hariç)"
            boolean r6 = r6.equalsIgnoreCase(r10)
            if (r6 != 0) goto L_0x1b34
            android.widget.TextView r6 = r0.tv_seciliSuc
            java.lang.CharSequence r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            java.lang.String r10 = "* Neticesi sebebiyle ağırlaşmış yaralama suçları (m. 87/2-d hariç)"
            boolean r6 = r6.equalsIgnoreCase(r10)
            if (r6 != 0) goto L_0x1b34
            android.widget.TextView r6 = r0.tv_seciliSuc
            java.lang.CharSequence r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            java.lang.String r10 = "* Uyuşturucu veya uyarıcı madde imal ve ticareti suçu (TCK 188)"
            boolean r6 = r6.equalsIgnoreCase(r10)
            if (r6 != 0) goto L_0x1b34
            android.widget.TextView r6 = r0.tv_seciliSuc
            java.lang.CharSequence r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            java.lang.String r10 = "* Diğer suçlar"
            boolean r6 = r6.equalsIgnoreCase(r10)
            if (r6 != 0) goto L_0x1b34
            android.widget.TextView r6 = r0.tv_seciliSuc
            java.lang.CharSequence r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            java.lang.String r10 = "* Terör suçu olmayan örgüt suçları"
            boolean r6 = r6.equalsIgnoreCase(r10)
            if (r6 == 0) goto L_0x1c43
        L_0x1b34:
            int r6 = r0.sartlaTahliye
            r10 = 1460(0x5b4, float:2.046E-42)
            if (r6 <= r10) goto L_0x1bf0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r11)
            int r10 = r27.mahsupGun()
            r6.append(r10)
            java.lang.String r10 = " gün\n"
            r6.append(r10)
            r6.append(r4)
            java.lang.String r10 = " İndirim: "
            r6.append(r10)
            int r10 = r0.sartlaTahliyeIndirimiInt
            r6.append(r10)
            r6.append(r9)
            int r10 = r0.sartlaTahliyeIndirimiInt
            java.lang.String r10 = gunCevirme(r10)
            r6.append(r10)
            java.lang.String r10 = ")\nDenetimli Serbestlik: 4 yıl"
            r6.append(r10)
            java.lang.String r6 = r6.toString()
            r0.indirimler = r6
            java.lang.String r6 = "Hükümlü iyi hâlli olmak kaydıyla şartla tahliye tarihine 4 yıl kala denetimli serbestlikten faydalanabilir."
            r0.denSerbestlik = r6
            r0.yatariVarMi = r2
            java.lang.String r2 = "4 yıl"
            r0.denSerbestlikKisa = r2
            r2 = 1460(0x5b4, float:2.046E-42)
            r0.denSerbestlikInt = r2
            android.widget.RadioButton r2 = r0.rbAcigaAyrilmaEvet
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x1b8f
            r0.denSerbestlik = r7
            r0.denSerbestlikKisa = r8
            r2 = 0
            r0.denSerbestlikInt = r2
        L_0x1b8f:
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            int r6 = r0.sartlaTahliye
            int r7 = r0.denSerbestlikInt
            int r6 = r6 - r7
            if (r2 <= r6) goto L_0x1bc4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r6 = r0.kapalidaki_gun_sayisi(r1)
            r2.append(r6)
            r2.append(r9)
            int r6 = r0.kapalidaki_gun_sayisi(r1)
            java.lang.String r6 = gunCevirme(r6)
            r2.append(r6)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            r0.cezaevindeKalinacakToplamSureInt = r2
            goto L_0x1bf0
        L_0x1bc4:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r6 = r0.sartlaTahliye
            int r7 = r0.denSerbestlikInt
            int r6 = r6 - r7
            r2.append(r6)
            r2.append(r9)
            int r6 = r0.sartlaTahliye
            int r7 = r0.denSerbestlikInt
            int r6 = r6 - r7
            java.lang.String r6 = gunCevirme(r6)
            r2.append(r6)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.cezaevindeKalinacakToplamSureString = r2
            int r2 = r0.sartlaTahliye
            int r6 = r0.denSerbestlikInt
            int r2 = r2 - r6
            r0.cezaevindeKalinacakToplamSureInt = r2
        L_0x1bf0:
            int r2 = r0.sartlaTahliye
            r6 = 1460(0x5b4, float:2.046E-42)
            if (r2 > r6) goto L_0x1c43
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            int r6 = r27.mahsupGun()
            r2.append(r6)
            java.lang.String r6 = " gün\n"
            r2.append(r6)
            r2.append(r4)
            java.lang.String r4 = " İndirim: "
            r2.append(r4)
            int r4 = r0.sartlaTahliyeIndirimiInt
            r2.append(r4)
            r2.append(r9)
            int r4 = r0.sartlaTahliyeIndirimiInt
            java.lang.String r4 = gunCevirme(r4)
            r2.append(r4)
            java.lang.String r4 = ")\nDenetimli Serbestlik: 4 yıl"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r0.indirimler = r2
            java.lang.String r2 = r0.gir_cik_durumu(r1)
            r0.denSerbestlik = r2
            r0.yatariVarMi = r3
            r0.cezaevindeKalinacakToplamSureString = r5
            r2 = 0
            r0.cezaevindeKalinacakToplamSureInt = r2
            java.lang.String r2 = "4 yıl"
            r0.denSerbestlikKisa = r2
            r2 = 1460(0x5b4, float:2.046E-42)
            r0.denSerbestlikInt = r2
        L_0x1c43:
            java.lang.String r2 = r0.dogrudan_Acik(r1)
            r0.dogrudanAcigaGirme = r2
            java.lang.String r2 = r0.davetiye_yakalama(r1)
            r0.cagriKagidiYakalamaEmri = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r3 = r27.mahsupGun()
            int r3 = r1 - r3
            r2.append(r3)
            r2.append(r9)
            int r3 = r27.mahsupGun()
            int r3 = r1 - r3
            java.lang.String r3 = gunCevirme(r3)
            r2.append(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.bihakkinTahliyeSuresi = r2
            java.lang.String r2 = r0.kapalidan_Aciga(r1)
            r0.kapalidanAcigaAyrilmaString = r2
            int r2 = r0.kapalidaki_gun_sayisi(r1)
            r0.kapalidaGececekGunSayisi = r2
            int r2 = r27.mahsupGun()
            r0.mahsupGunSayisi = r2
            android.widget.RadioButton r2 = r0.rbUcuncuGrupSuc
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x1c95
            java.lang.String r2 = "1"
            r0.orgutSeciliMi = r2
            goto L_0x1c99
        L_0x1c95:
            java.lang.String r2 = "0"
            r0.orgutSeciliMi = r2
        L_0x1c99:
            android.widget.RadioButton r2 = r0.rbUcuncuGrupSuc
            boolean r2 = r2.isChecked()
            if (r2 == 0) goto L_0x1ca6
            java.lang.String r2 = "Örgüt suçlarında (Adi-Silahlı-Terör) etkin pişmanlıktan faydalanmayanlar ve mensup oldukları örgütten ayrıldıkları cezaevi idare ve gözlem kurulu kararıyla tespit edilemeyenler açık cezaevine ayrılamaz (Açığa Ayr. Yön. m. 6/2-c-ç) ve bu sebeple denetimli serbestlikten de faydalanamazlar. Anılan kişiler şartla tahliye tarihine kadar kapalı cezaevinde kalırlar.\nBahsi geçen tespit uygulamada, örgüt propagandası suçundan veya örgüte üye olmamakla birlikte bilerek ve isteyerek yardım etme suçundan hükümlü olanlar ile etkin pişmanlıktan faydalananlar hakkında dahi yapılmaktadır. \nÖrgüt suçlarından, örgüt propagandası suçundan veya örgüte üye olmamakla birlikte bilerek ve isteyerek yardım etme suçundan hükümlü olanlar ile etkin pişmanlıktan faydalananlar; mensup oldukları örgütten ayrıldıkları idare ve gözlem kurulu kararıyla tespit edilmişse, cezanın 1/3 ‘ nü kapalı ceza evinde yatmak ve şartla tahliye tarihine 1 yıldan AZ süre kalmak kaydıyla açık cezaevine ayrılabilirler. (Açığa Ayr. Yön. m.6/2-ç) (Etkin pişmanlıktan faydalananlar için 2 yıldan AZ süre kalmak kaydıyla. Açığa Ayr. Yön. m.6/2-c)\nBu kişiler şartla tahliye tarihine 1 yıl kala denetimli serbestlikle erken tahliye olabilirler. (5275 S. Kanun m. 105/A-1)\n\nBu anlattıklarımızın bir kısmında uygulamada birlik yoktur, farklı cezaevleri ve savcılıklarda farklı uygulamalar olabilmektedir. \nZikri geçen kişiler için denetimli serbestliği 6 ay (5275 S. Kanun geçici madde 3/2) uygulayan yerler olduğu gibi, yardım ve propaganda suçlarında üyelik söz konusu olmadığı için (5275 S. Kanun m. 9/2) 1/3 kapalı cezaevinde kalma koşulunu uygulamayan, örgütten ayrıldıklarına dair rapora gerek duymayan yerler de görülmüştür.\n*** Bu açıklamada kullanılan ‘Örgüt’ tabiri, Adi-Silahlı-Terör Örgütlerinin hepsi için kullanılmıştır.\n"
            r0.orgutAciklamasi = r2
            goto L_0x1ca8
        L_0x1ca6:
            r0.orgutAciklamasi = r5
        L_0x1ca8:
            java.util.Calendar r2 = java.util.Calendar.getInstance()
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat
            java.util.Locale r4 = java.util.Locale.US
            java.lang.String r5 = "dd.MM.yyyy"
            r3.<init>(r5, r4)
            android.widget.EditText r4 = r0.takvim     // Catch:{ ParseException -> 0x1cc6 }
            android.text.Editable r4 = r4.getText()     // Catch:{ ParseException -> 0x1cc6 }
            java.lang.String r4 = r4.toString()     // Catch:{ ParseException -> 0x1cc6 }
            java.util.Date r4 = r3.parse(r4)     // Catch:{ ParseException -> 0x1cc6 }
            r2.setTime(r4)     // Catch:{ ParseException -> 0x1cc6 }
        L_0x1cc6:
            java.util.Calendar r4 = java.util.Calendar.getInstance()
            android.widget.EditText r5 = r0.takvim     // Catch:{ ParseException -> 0x1cdb }
            android.text.Editable r5 = r5.getText()     // Catch:{ ParseException -> 0x1cdb }
            java.lang.String r5 = r5.toString()     // Catch:{ ParseException -> 0x1cdb }
            java.util.Date r5 = r3.parse(r5)     // Catch:{ ParseException -> 0x1cdb }
            r4.setTime(r5)     // Catch:{ ParseException -> 0x1cdb }
        L_0x1cdb:
            java.util.Calendar r5 = java.util.Calendar.getInstance()
            android.widget.EditText r6 = r0.takvim     // Catch:{ ParseException -> 0x1cf0 }
            android.text.Editable r6 = r6.getText()     // Catch:{ ParseException -> 0x1cf0 }
            java.lang.String r6 = r6.toString()     // Catch:{ ParseException -> 0x1cf0 }
            java.util.Date r6 = r3.parse(r6)     // Catch:{ ParseException -> 0x1cf0 }
            r5.setTime(r6)     // Catch:{ ParseException -> 0x1cf0 }
        L_0x1cf0:
            java.util.Calendar r6 = java.util.Calendar.getInstance()
            android.widget.EditText r7 = r0.takvim     // Catch:{ ParseException -> 0x1d06 }
            android.text.Editable r7 = r7.getText()     // Catch:{ ParseException -> 0x1d06 }
            java.lang.String r7 = r7.toString()     // Catch:{ ParseException -> 0x1d06 }
            java.util.Date r7 = r3.parse(r7)     // Catch:{ ParseException -> 0x1d06 }
            r6.setTime(r7)     // Catch:{ ParseException -> 0x1d06 }
            goto L_0x1d07
        L_0x1d06:
        L_0x1d07:
            r7 = 5
            int r9 = r0.kapalidaki_gun_sayisi(r1)
            r2.add(r7, r9)
            r7 = 2
            r9 = 0
            r2.add(r7, r9)
            r7 = 1
            r2.add(r7, r9)
            java.util.Date r2 = r2.getTime()
            java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat
            java.lang.String r9 = "dd/MM/yyyy"
            r7.<init>(r9)
            int r9 = r0.kapalidaki_gun_sayisi(r1)
            if (r9 <= 0) goto L_0x1d2e
            java.lang.String r15 = r7.format(r2)
            goto L_0x1d2f
        L_0x1d2e:
            r15 = r8
        L_0x1d2f:
            int r2 = r0.cezaevindeKalinacakToplamSureInt
            r8 = 5
            r4.add(r8, r2)
            r8 = 2
            r9 = 0
            r4.add(r8, r9)
            r8 = 1
            r4.add(r8, r9)
            java.util.Date r4 = r4.getTime()
            java.lang.String r4 = r7.format(r4)
            int r8 = r0.sartlaTahliye
            r10 = 5
            r5.add(r10, r8)
            r8 = 2
            r5.add(r8, r9)
            r8 = 1
            r5.add(r8, r9)
            java.util.Date r5 = r5.getTime()
            java.lang.String r5 = r7.format(r5)
            r8 = 5
            r6.add(r8, r1)
            r1 = 2
            r6.add(r1, r9)
            r1 = 1
            r6.add(r1, r9)
            java.util.Date r1 = r6.getTime()
            java.lang.String r1 = r7.format(r1)
            java.util.Calendar r6 = java.util.Calendar.getInstance()
            android.widget.EditText r7 = r0.takvim     // Catch:{ ParseException -> 0x1d86 }
            android.text.Editable r7 = r7.getText()     // Catch:{ ParseException -> 0x1d86 }
            java.lang.String r7 = r7.toString()     // Catch:{ ParseException -> 0x1d86 }
            java.util.Date r7 = r3.parse(r7)     // Catch:{ ParseException -> 0x1d86 }
            r6.setTime(r7)     // Catch:{ ParseException -> 0x1d86 }
            goto L_0x1d87
        L_0x1d86:
        L_0x1d87:
            java.util.Date r6 = r6.getTime()
            java.lang.String r3 = r3.format(r6)
            android.widget.RadioButton r6 = r0.rb_tahliye_tarihi_evet
            boolean r6 = r6.isChecked()
            if (r6 == 0) goto L_0x1d9c
            java.lang.String r6 = "1"
            r0.tahliyeTarihiSeciliMi = r6
            goto L_0x1da0
        L_0x1d9c:
            java.lang.String r6 = "0"
            r0.tahliyeTarihiSeciliMi = r6
        L_0x1da0:
            if (r2 <= 0) goto L_0x1dce
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "Açığa ayrılma tarihi:\n"
            r2.append(r6)
            r2.append(r15)
            java.lang.String r6 = "\nDen. serbestlikten faydalanma tarihi:\n"
            r2.append(r6)
            r2.append(r4)
            java.lang.String r4 = "\nŞartla tahliye tarihi :\n"
            r2.append(r4)
            r2.append(r5)
            java.lang.String r4 = "\nBihakkın tahliye:\n"
            r2.append(r4)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.tarihler = r1
            goto L_0x1dd2
        L_0x1dce:
            java.lang.String r1 = "Yatarı YOK\nAma hükümlünün indirimlerden faydalanabilmek için cezaevine 'gir çık' yapması gerek! Bu da 1 hafta, 1 ay gibi kısa bir süre"
            r0.tarihler = r1
        L_0x1dd2:
            android.content.Intent r1 = new android.content.Intent
            android.content.Context r2 = r27.getApplicationContext()
            java.lang.Class<com.example.infaz_hesaplama.InfazHesaplama.Sonuc0> r4 = com.example.infaz_hesaplama.InfazHesaplama.Sonuc0.class
            r1.<init>(r2, r4)
            java.lang.String r2 = r0.indirimler
            java.lang.String r4 = "anahtar"
            r1.putExtra(r4, r2)
            java.lang.String r2 = r0.sartlaTahliyeString
            java.lang.String r4 = "anahtar2"
            r1.putExtra(r4, r2)
            java.lang.String r2 = r0.denSerbestlik
            java.lang.String r4 = "anahtar3"
            r1.putExtra(r4, r2)
            java.lang.String r2 = r0.dogrudanAcigaGirme
            java.lang.String r4 = "anahtar4"
            r1.putExtra(r4, r2)
            java.lang.String r2 = r0.kapalidanAcigaAyrilmaString
            java.lang.String r4 = "anahtar5"
            r1.putExtra(r4, r2)
            int r2 = r0.sartlaTahliye
            java.lang.String r4 = "anahtar6"
            r1.putExtra(r4, r2)
            java.lang.String r2 = r0.bihakkinTahliyeSuresi
            java.lang.String r4 = "anahtar7"
            r1.putExtra(r4, r2)
            java.lang.String r2 = r0.yatariVarMi
            java.lang.String r4 = "anahtar8"
            r1.putExtra(r4, r2)
            java.lang.String r2 = r0.cezaevindeKalinacakToplamSureString
            java.lang.String r4 = "anahtar9"
            r1.putExtra(r4, r2)
            java.lang.String r2 = r0.denSerbestlikKisa
            java.lang.String r4 = "anahtar10"
            r1.putExtra(r4, r2)
            java.lang.String r2 = r0.orgutAciklamasi
            java.lang.String r4 = "anahtar11"
            r1.putExtra(r4, r2)
            int r2 = r0.cezaevindeKalinacakToplamSureInt
            java.lang.String r4 = "anahtar12"
            r1.putExtra(r4, r2)
            int r2 = r0.kapalidaGececekGunSayisi
            java.lang.String r4 = "anahtar13"
            r1.putExtra(r4, r2)
            int r2 = r0.denSerbestlikInt
            java.lang.String r4 = "anahtar14"
            r1.putExtra(r4, r2)
            int r2 = r0.sartlaTahliyeIndirimiInt
            java.lang.String r4 = "anahtar15"
            r1.putExtra(r4, r2)
            int r2 = r0.mahsupGunSayisi
            java.lang.String r4 = "anahtar16"
            r1.putExtra(r4, r2)
            java.lang.String r2 = r0.orgutSeciliMi
            java.lang.String r4 = "anahtar17"
            r1.putExtra(r4, r2)
            int r2 = r0.denSerSuresi_RaporOlumsuzsa
            java.lang.String r4 = "anahtar18"
            r1.putExtra(r4, r2)
            int r2 = r0.cezaevindeKalinacakToplamSure_RaporOlumsuzsa
            java.lang.String r4 = "anahtar19"
            r1.putExtra(r4, r2)
            java.lang.String r2 = r0.cagriKagidiYakalamaEmri
            java.lang.String r4 = "anahtar20"
            r1.putExtra(r4, r2)
            java.lang.String r2 = "anahtar21"
            r1.putExtra(r2, r3)
            java.lang.String r2 = r0.tarihler
            java.lang.String r3 = "anahtar22"
            r1.putExtra(r3, r2)
            java.lang.String r2 = r0.tahliyeTarihiSeciliMi
            java.lang.String r3 = "anahtar23"
            r1.putExtra(r3, r2)
            r0.startActivity(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.infaz_hesaplama.InfazHesaplama.C0520infaz_hesaplama.hesapla():void");
    }

    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.Ib_takvim_cezaevi_giris_tarihi /*2131230723*/:
                Calendar instance = Calendar.getInstance();
                new DatePickerDialog(this.context, 5, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                        EditText editText = C0520infaz_hesaplama.this.takvim;
                        editText.setText(i3 + "." + (i2 + 1) + "." + i);
                    }
                }, instance.get(1), instance.get(2), instance.get(5)).show();
                return;
            case R.id.alertUcuncuGrupSuclar /*2131230805*/:
                new AlertDialog.Builder(this.context).setTitle((CharSequence) "3. GRUP SUÇLAR").setMessage((CharSequence) "1- Suç işlemek amacıyla örgüt kurmak ve yönetmek (TCK m. 314/1, 220/1)\n2- Adi-Silahlı-Terör örgütü üyesi olmak (TCK m. 220/2, 314/2) \n3- Örgüt (Adi-Silahlı-Terör) propagandası yapmak (TCK 220/8, TMK 7/2)\n4- Örgüte (Adi-Silahlı-Terör) üye olmamakla birlikte bilerek ve isteyerek yardım etme\n5- Örgüt faaliyeti (Adi-Silahlı-Terör) çerçevesinde işlenen TCK’da yer alan aşağıdaki suçlar: \na) İnsanlığa karşı suç (madde 77, 78)\nb) Kasten öldürme (madde 81, 82)\nc) Uyuşturucu veya uyarıcı madde imal ve ticareti (madde 188)\nd) Devletin güvenliğine karşı suçlar (madde 302, 303, 304, 307, 308)\ne) Anayasal düzene ve bu düzenin işleyişine karşı suçlar (madde 309, 310, 311, 312, 313, 314, 315) \n\n*Açığa Ayr. Yön. m. 6/1.c-2.ç, 5275 S. Kanun m. 9/2 gereği \n").setCancelable(false).setPositiveButton((CharSequence) "KAPAT", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
                return;
            case R.id.btn_hesapla /*2131230843*/:
                if (this.cYil.getText().toString().matches("") && this.cAy.getText().toString().matches("") && this.cGun.getText().toString().matches("")) {
                    showToastMsj("Yıl-Ay-Gün verisinden EN AZ birini giriniz !");
                    YoYo.with(Techniques.Shake).duration(700).repeat(1).playOn(this.btn_hesapla);
                    return;
                } else if (this.rbTekerrurEvet.isChecked() && this.rbBirinciTekerrur.isChecked() && this.cYil2.getText().toString().matches("") && this.cAy2.getText().toString().matches("") && this.cGun2.getText().toString().matches("")) {
                    showToastMsj("TEKERRÜR İÇİN:\nYıl-Ay-Gün verisinden EN AZ birini giriniz !");
                    YoYo.with(Techniques.Shake).duration(700).repeat(1).playOn(this.btn_hesapla);
                    return;
                } else if (this.takvim.getText().toString().matches("") && this.rb_tahliye_tarihi_evet.isChecked()) {
                    showToastMsj("Cezaevine giriş tarihini giriniz!");
                    YoYo.with(Techniques.Shake).duration(700).repeat(1).playOn(this.alertDialog_SucuSeciniz2);
                    return;
                } else if (this.tv_seciliSuc.getText().toString().equalsIgnoreCase("Seçilen Suç Yok")) {
                    showToastMsj("Suç ekleyiniz !");
                    YoYo.with(Techniques.Shake).duration(700).repeat(1).playOn(this.btn_hesapla);
                    return;
                } else if (this.videoReklamGosterilsinMi.equalsIgnoreCase("Evet")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
                    builder.setIcon((int) R.drawable.icon_vector_video);
                    builder.setTitle((CharSequence) "Video Reklam Uyarısı").setMessage((CharSequence) "Haftalık 3 reklamsız kullanma hakkınız dolmuştur. Reklam izleyerek devam edebilir ya da 1 hafta bekleyebilirsiniz.").setCancelable(false).setNegativeButton((CharSequence) "Reklam İzle", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (C0520infaz_hesaplama.this.rewardedVideoAd.isLoaded()) {
                                C0520infaz_hesaplama.this.rewardedVideoAd.show();
                            } else if (!C0520infaz_hesaplama.this.rewardedVideoAd.isLoaded()) {
                                C0520infaz_hesaplama.this.hesapla();
                            }
                        }
                    }).setPositiveButton((CharSequence) "1 Hafta Bekle", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            C0520infaz_hesaplama.this.startActivity(new Intent(C0520infaz_hesaplama.this.context, MainActivity.class));
                        }
                    }).show();
                    return;
                } else {
                    hesapla();
                    return;
                }
            case R.id.btn_temizle /*2131230851*/:
                this.cYil.setText("");
                this.cAy.setText("");
                this.cGun.setText("");
                this.mahsupGun.setText("");
                this.indirimler = "";
                this.sartlaTahliyeString = "";
                this.denSerbestlik = "";
                this.cYil2.setText("");
                this.cAy2.setText("");
                this.cGun2.setText("");
                this.takvim.setText("");
                this.tv_seciliSuc.setText("Seçilen Suç Yok");
                this.oncesi2016.setChecked(false);
                this.sonrasi2020.setChecked(false);
                this.rbMahsupEvet.setChecked(false);
                this.rbTekerrurEvet.setChecked(false);
                this.rbIkinciTekerrur.setChecked(false);
                this.rbTaksir.setChecked(false);
                this.rbOrgutCinselEvet.setChecked(false);
                this.rb6545SKOnce.setChecked(false);
                this.rbBirinciGrupSuc.setChecked(false);
                this.rbIkinciGrupSuc.setChecked(false);
                this.rbUcuncuGrupSuc.setChecked(false);
                this.rbAcigaAyrilmaEvet.setChecked(false);
                this.rbEtkin_Evet.setChecked(false);
                this.rb_tahliye_tarihi_evet.setChecked(false);
                this.rbCocukYaslilikEvet.setChecked(false);
                this.sonrasi2016.setChecked(true);
                this.oncesi2020.setChecked(true);
                this.rbMahsupHayir.setChecked(true);
                this.rbTekerrurHayir.setChecked(true);
                this.rbBirinciTekerrur.setChecked(true);
                this.rbKast.setChecked(true);
                this.f183rbOrgutCinselHayr.setChecked(true);
                this.rb6545SKSonra.setChecked(true);
                this.rbDorduncuGrupSuc.setChecked(true);
                this.rbAcigaAyrilmaHayir.setChecked(true);
                this.rbEtkin_Hayir.setChecked(true);
                this.rb_tahliye_tarihi_hayir.setChecked(true);
                this.rbCocukYaslilikHayir.setChecked(true);
                this.cYil.requestFocus();
                return;
            default:
                switch (id) {
                    case R.id.alertAcigaAyrilma /*2131230793*/:
                        new AlertDialog.Builder(this.context).setTitle((CharSequence) "Açık Cezaevine Ayrılamaya Engel Haller").setMessage((CharSequence) "1- Haklarında iyi hal kararı verilse bile, 5275 s. Kanun’un 44 üncü maddesinde sayılan eylemlerden dolayı toplam beş ve daha fazla hücreye koyma cezası alıp, son hücreye koyma cezasının kaldırılması üzerinden bir yıl geçmemiş olanlar,\n2- Koşullu salıverilme kararı geri alınanların, geri alınan cezalarının tamamı,\n3- Denetimli serbestlik tedbirinin ihlali sonucunda, koşullu salıverilme tarihine kadar olan sürenin tamamı,\n4- Çocuk eğitimevleri hariç, kapalı kurumlardan firar edenler ile açık kurumlardan ikinci kez firar etmiş olanların, firar tarihinden önce kesinleşmiş olan cezaları ve koşullu salıverilme tarihine kadar kesinleşerek infazına başlanacak olan cezalarının tamamı,\n5- İcra ve İflas Kanunu gereğince verilen hapsen tazyik veya tazyik hapisleri dışında, diğer kanunlarda düzenlenen tazyik, disiplin veya zorlama hapislerinin tamamı,\n6-Kapalı kurumda hükümlü olup;\na) İşlediği iddia olunan başka bir suçtan dolayı haklarında CMK’nın 100 üncü maddesine göre tutuklama kararı verilenler,\nb) Yaş, sağlık durumu, bedensel veya zihinsel yetenekleri bakımından çalışma koşullarına uyum sağlayamayacakları idare ve gözlem kurulu kararıyla saptananlar, bu durumları devam ettiği sürece açık kurumlara ayrılamaz. \n\n*Açığa Ayr. Yön. m. 8 gereği\n").setCancelable(false).setPositiveButton((CharSequence) "KAPAT", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
                        return;
                    case R.id.alertBirinciGrupSuclar /*2131230794*/:
                        new AlertDialog.Builder(this.context).setTitle((CharSequence) "1. GRUP SUÇLAR").setMessage((CharSequence) "Eski ve yeni TCK’nın \n1- Nitelikli hırsızlık \n2- Yağma, nitelikli yağma\n3- Uyuşturucu veya uyarıcı madde imal ve ticareti\n4- Uyuşturucu veya uyarıcı madde kullanılmasını kolaylaştırma suçları\n\n*Açığa Ayr. Yön. m. 6/2-a gereği\n").setCancelable(false).setPositiveButton((CharSequence) "KAPAT", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
                        return;
                    case R.id.alertCocukYasDenSer4Yil /*2131230795*/:
                        new AlertDialog.Builder(this.context).setTitle((CharSequence) "Yaşlılık veya Çocuk Durumu").setMessage((CharSequence) "5275 SK geçici m. 6/2 ‘ye göre 30/3/2020 tarihine kadar işlenen suçlar bakımından;\n\n1- 0-6 yaş grubu çocuğu bulunan kadın hükümlüler\n\n2- 70 yaşını bitirmiş hükümlüler \n\n3- Maruz kaldıkları ağır bir hastalık, engellilik veya kocama nedeniyle hayatlarını cezaevinde yalnız idame ettiremeyen 65 yaşını bitirmiş  hükümlüler için denetimli serbestlik 4 yıldır.\n\n***Alttaki suçlar için uygulanmaz:\n\n1- Kasten öldürme suçları (madde 81, 82 ve 83)\n2- Cinsel dokunulmazlığa karşı işlenen suçlar (madde 102, 103, 104 ve 105)\n3- Özel hayata ve hayatın gizli alanına karşı suçlar (madde 132, 133, 134,135,   136, 137 ve 138)\n4- Devletin güvenliğine karşı suçlar (TCK 302-339 arası) \n5- Terör suçları (3713 sayılı yasa)\n").setCancelable(false).setPositiveButton((CharSequence) "KAPAT", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
                        return;
                    case R.id.alertDialog6545SK /*2131230796*/:
                        new AlertDialog.Builder(this.context).setTitle((CharSequence) "Uyuşturucu Ticareti ile Cinsel Suçlarda İnfaz Değişikliği").setMessage((CharSequence) "18/06/2014 tarihli 6545 sayılı Kanun’un 82. maddesi ile 5275 sayılı Kanun’un 108/9. maddesinde yapılan değişiklik  ve sonrasında 15/04/2020 tarihli 7242 S. Kanun ile yapılan değişiklikler uyarınca; aşağıdaki suçlar 28/06/2014 tarihinden önce işlendiyse şartla tahliye için 1/3 indirim, sonra işlendiyse ¼ indirim uygulanacaktır.\n\n5237 sayılı Türk Ceza Kanununun; \n\n1-Vücuda organ veya sair bir cisim sokulması suretiyle cinsel saldırı (TCK 102/2)\n2-Çocukların cinsel istismarı (TCK 103)\n3-Reşit olmayanla cinsel ilişki suçunun nitelikli halleri  (TCK 104/2-3)\n4- Uyuşturucu veya uyarıcı madde imal ve ticareti (m. 188)\n").setCancelable(false).setPositiveButton((CharSequence) "KAPAT", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
                        return;
                    case R.id.alertDialogTekerrur /*2131230797*/:
                        new AlertDialog.Builder(this.context).setTitle((CharSequence) "TEKERRÜR").setMessage((CharSequence) "Tekerrür kelimesinin anlamı yinelenme, tekrarlanma demektir. Türk Ceza Kanunu hükümlerine göre tekerrür, daha önce bir suç işlemiş ve bu suçtan dolayısı cezası kesinleşmiş birinin yasada belirlenen süreler içerisinde yeni bir suç işlemesi halidir.\n\nİkinci defa suç işleyen, yani tekrar suç işleyen kişiye ise mükerrir denir. TCK madde 58. metninde düzenlenen suçta tekerrür kurumu bir güvenlik tedbiri niteliğinde olup tekerrüren suç işleyen kimseye güvenlik tedbirlerine ilişkin kurallar uygulanarak mükerrirlere özgü infaz rejimine göre çektirilmesine karar verilir.\n\nİnfazı hesaplanacak cezada tekerrür uygulanacaksa bu husus mahkeme kararında yazar (TCK m. 58/7).\n\nTekerrür nedeniyle koşullu salıverme süresine eklenecek miktar, tekerrüre esas alınan cezanın en ağırından fazla olamaz (5275 S. Kanun m. 108/2). Bu sebeple tekerrüre esas alınan cezayı uygulamada belirtilen 1. Tekerrür kısmın karşısına Yıl-Ay-Gün olarak giriniz. 2. Tekerrür söz konusuysa girmenize gerek yok.\n").setCancelable(false).setPositiveButton((CharSequence) "KAPAT", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
                        return;
                    case R.id.alertDialog_SucuSeciniz2 /*2131230798*/:
                        if (this.oncesi2016.isChecked()) {
                            this.listItems = new String[]{"* Kasten Öldürme suçları (TCK 81, 82)", "* Kasten öldürmenin ihmali davranışla işlenmesi (TCK 83)", "* İşkence suçu (TCK 94 ve 95)", "* Eziyet suçu (TCK 96)", "* Üstsoya, altsoya, eşe veya kardeşe ya da beden veya ruh bakımından kendisini savunamayacak durumda bulunan kişiye karşı işlenen kasten yaralama", "* Yüzde sürekli değişikliğe sebebiyet verecek şekilde ağırlaşmış yaralama suçu (m. 87/2-d hariç)", "* Neticesi sebebiyle ağırlaşmış yaralama suçları (m. 87/2-d hariç)", "* Basit cinsel suçlar TCK (102/1, 104/1, 105)", "* Ağır cinsel suçlar (TCK 102/2, 103, 104/2-3)", "* Uyuşturucu veya uyarıcı madde imal ve ticareti suçu (TCK 188)", "* Özel hayata ve hayatın gizli alanına karşı suçlar (TCK 132, 133, 134, 135, 136, 137, 138)", "* Terör suçları (3713 sayılı yasa)", "* Terör suçu olmayan örgüt suçları", "* Diğer suçlar"};
                        } else if (this.oncesi2020.isChecked()) {
                            this.listItems = new String[]{"* Kasten Öldürme suçları (TCK 81, 82, 83)", "* İşkence suçu (TCK 94 ve 95)", "* Eziyet suçu (TCK 96)", "* Üstsoya, altsoya, eşe veya kardeşe ya da beden veya ruh bakımından kendisini savunamayacak durumda bulunan kişiye karşı işlenen kasten yaralama", "* Yüzde sürekli değişikliğe sebebiyet verecek şekilde ağırlaşmış yaralama suçu (m. 87/2-d hariç)", "* Neticesi sebebiyle ağırlaşmış yaralama suçları (m. 87/2-d hariç)", "* Basit cinsel suçlar TCK (102/1, 104/1, 105)", "* Ağır cinsel suçlar (TCK 102/2, 103, 104/2-3)", "* Uyuşturucu veya uyarıcı madde imal ve ticareti suçu (TCK 188)", "* Özel hayata ve hayatın gizli alanına karşı suçlar (TCK 132, 133, 134, 135, 136, 137, 138)", "* Terör suçları (3713 sayılı yasa)", "* Terör suçu olmayan örgüt suçları", "* Diğer suçlar"};
                        } else if (this.sonrasi2020.isChecked()) {
                            this.listItems = new String[]{"* Kasten Öldürme suçları (TCK 81, 82, 83)", "* İşkence suçu (TCK 94 ve 95)", "* Eziyet suçu (TCK 96)", "* Üstsoya, altsoya, eşe veya kardeşe ya da beden veya ruh bakımından kendisini savunamayacak durumda bulunan kişiye karşı işlenen kasten yaralama", "* Yüzde sürekli değişikliğe sebebiyet verecek şekilde ağırlaşmış yaralama suçu (m. 87/2-d hariç)", "* Neticesi sebebiyle ağırlaşmış yaralama suçları (m. 87/2-d hariç)", "* Basit cinsel suçlar TCK (102/1, 104/1, 105)", "* Ağır cinsel suçlar (TCK 102/2, 103, 104/2-3)", "* Uyuşturucu veya uyarıcı madde imal ve ticareti suçu (TCK 188)", "* Özel hayata ve hayatın gizli alanına karşı suçlar (TCK 132, 133, 134, 135, 136, 137, 138)", "* Terör suçları (3713 sayılı yasa)", "* Terör suçu olmayan örgüt suçları", "* Diğer suçlar"};
                        }
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                        builder2.setIcon(R.drawable.infaz_hesap);
                        builder2.setTitle("SUÇLAR").setSingleChoiceItems(this.listItems, this.position, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                C0520infaz_hesaplama.this.position = i;
                            }
                        }).setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                C0520infaz_hesaplama.this.tv_seciliSuc.setText(C0520infaz_hesaplama.this.listItems[C0520infaz_hesaplama.this.position]);
                                C0520infaz_hesaplama infaz_hesaplama = C0520infaz_hesaplama.this;
                                infaz_hesaplama.showToastMsjYesil("Eklendi: " + C0520infaz_hesaplama.this.listItems[C0520infaz_hesaplama.this.position]);
                                if (C0520infaz_hesaplama.this.tv_seciliSuc.getText().toString().equalsIgnoreCase("* Uyuşturucu veya uyarıcı madde imal ve ticareti suçu (TCK 188)") || C0520infaz_hesaplama.this.tv_seciliSuc.getText().toString().equalsIgnoreCase("* Ağır cinsel suçlar (TCK 102/2, 103, 104/2-3)")) {
                                    C0520infaz_hesaplama.this.grid6545SK.setVisibility(0);
                                    C0520infaz_hesaplama.this.f182layout_uyuturucu_cinsel.setVisibility(0);
                                } else {
                                    C0520infaz_hesaplama.this.grid6545SK.setVisibility(8);
                                    C0520infaz_hesaplama.this.f182layout_uyuturucu_cinsel.setVisibility(8);
                                }
                                if (C0520infaz_hesaplama.this.tv_seciliSuc.getText().toString().equalsIgnoreCase("* Uyuşturucu veya uyarıcı madde imal ve ticareti suçu (TCK 188)")) {
                                    C0520infaz_hesaplama.this.rbBirinciGrupSuc.setChecked(true);
                                    C0520infaz_hesaplama.this.linLayoutSucGrubu.setVisibility(8);
                                    C0520infaz_hesaplama.this.rg_SucGruplari.setVisibility(8);
                                }
                                if (C0520infaz_hesaplama.this.tv_seciliSuc.getText().toString().equalsIgnoreCase("* Terör suçları (3713 sayılı yasa)") || C0520infaz_hesaplama.this.tv_seciliSuc.getText().toString().equalsIgnoreCase("* Terör suçu olmayan örgüt suçları")) {
                                    C0520infaz_hesaplama.this.rbUcuncuGrupSuc.setChecked(true);
                                    C0520infaz_hesaplama.this.linLayoutSucGrubu.setVisibility(8);
                                    C0520infaz_hesaplama.this.rg_SucGruplari.setVisibility(8);
                                }
                                if (C0520infaz_hesaplama.this.tv_seciliSuc.getText().toString().equalsIgnoreCase("* İşkence suçu (TCK 94 ve 95)") || C0520infaz_hesaplama.this.tv_seciliSuc.getText().toString().equalsIgnoreCase("* Yüzde sürekli değişikliğe sebebiyet verecek şekilde ağırlaşmış yaralama suçu (m. 87/2-d hariç)") || C0520infaz_hesaplama.this.tv_seciliSuc.getText().toString().equalsIgnoreCase("* Neticesi sebebiyle ağırlaşmış yaralama suçları (m. 87/2-d hariç)") || C0520infaz_hesaplama.this.tv_seciliSuc.getText().toString().equalsIgnoreCase("* Özel hayata ve hayatın gizli alanına karşı suçlar (TCK 132, 133, 134, 135, 136, 137, 138)") || C0520infaz_hesaplama.this.tv_seciliSuc.getText().toString().equalsIgnoreCase("* Diğer suçlar") || C0520infaz_hesaplama.this.tv_seciliSuc.getText().toString().equalsIgnoreCase("* Kasten öldürmenin ihmali davranışla işlenmesi (TCK 83)")) {
                                    C0520infaz_hesaplama.this.rbDorduncuGrupSuc.setChecked(true);
                                    C0520infaz_hesaplama.this.linLayoutSucGrubu.setVisibility(0);
                                    C0520infaz_hesaplama.this.rg_SucGruplari.setVisibility(0);
                                }
                            }
                        }).setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        builder2.create().show();
                        return;
                    case R.id.alertDorduncuGrupSuclar /*2131230799*/:
                        new AlertDialog.Builder(this.context).setTitle((CharSequence) "4. GRUP SUÇLAR").setMessage((CharSequence) "Önceki gruplardaki suçların dışında kalan suçlar\n\n*Açığa Ayr. Yön. m. 6/1.a gereği\n").setCancelable(false).setPositiveButton((CharSequence) "KAPAT", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
                        return;
                    case R.id.alertIkinciGrupSuclar /*2131230800*/:
                        new AlertDialog.Builder(this.context).setTitle((CharSequence) "2. GRUP SUÇLAR").setMessage((CharSequence) "Eski ve yeni TCK’nın  \n1- Cinsel saldırı \n2- Çocukların cinsel istismarı\n3- Eşi kasten öldürme, eşi yaralama ve eşe eziyet suçları\n\n*Açığa Ayr. Yön. m. 6/2-b gereği\n").setCancelable(false).setPositiveButton((CharSequence) "KAPAT", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
                        return;
                    case R.id.alertMahsup /*2131230801*/:
                        new AlertDialog.Builder(this.context).setTitle((CharSequence) "MAHSUP").setMessage((CharSequence) "Ceza Hukukunda mahsup, 5237 sayılı Türk Ceza Kanunu'nun 63. maddesinde düzenlenmiştir. Bu maddeye göre; bir hüküm kesinleşmeden önce gerçekleşen ve şahsi hürriyeti sınırlama sonucu doğuran bütün haller sebebiyle geçirilmiş süreler, hapis cezasından indirilecektir.\n\nHükümlü gözaltında ya da tutuklu kaldıysa bu süre hükümlünün cezaevinde kalacağı süreden düşürülür.\n\nNeticeten; hükümlü gözaltında ya da tutuklu kaldıysa bu sürenin kaç gün olduğunu uygulamaya girmelisiniz.\n").setCancelable(false).setPositiveButton((CharSequence) "KAPAT", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
                        return;
                    case R.id.alertOrgutCinsel /*2131230802*/:
                        new AlertDialog.Builder(this.context).setTitle((CharSequence) "Açık Cezaevine Doğrudan Girmeyi Engelleyen Suçlar").setMessage((CharSequence) "Aşağıdaki suçlar cezası süresi ne kadar olursa olsun açık cezaevine doğrudan girmeyi engeller:\n\n1-Terör, Örgüt faaliyeti içerisinde işlenen suçlar, \n2-Cinsel dokunulmazlığa karşı işlenen suçlar\n3-İkinci defa mükerrir olanlar.\n4-Koşullu salıverilme kararının geri alınması nedeniyle cezası aynen infaz edilenler\n\n* 5275 SK m. 14/2\n").setCancelable(false).setPositiveButton((CharSequence) "KAPAT", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
                        return;
                    case R.id.alertSucGrubu /*2131230803*/:
                        new AlertDialog.Builder(this.context).setTitle((CharSequence) "SUÇ TİPİ-GRUBU").setMessage((CharSequence) "Açığa Ayrılma Yönetmeliği 6. maddede hükümlülerin suç tiplerine göre kapalı cezaevinden açık cezaevine ayrılma şartları ve süreleri belirtilmiştir.\n \nBu husus hükümlülerin açık cezaevine ayrılmaları açısından önemli olduğu kadar, cezaevinde kalacakları toplam süre cihetinden de önemlidir. \n\nAşağıdaki 1-2-3-4 numaralı kutucuklara tıkladığınızda size suç gruplarını gösterecektir. Lütfen mahkûmiyet konusu suçun hangi grupta olduğunu işaretleyiniz.\n").setCancelable(false).setPositiveButton((CharSequence) "KAPAT", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
                        return;
                    default:
                        return;
                }
        }
    }

    public void showToastMsj(String str) {
        View inflate = getLayoutInflater().inflate(R.layout.toast_kirmizi, (ViewGroup) findViewById(R.id.toast_linearLayout));
        ((TextView) inflate.findViewById(R.id.toast_tv)).setText(str);
        ((ImageView) inflate.findViewById(R.id.toast_ImageView)).setImageResource(R.drawable.icon_carpi);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(48, 0, 0);
        toast.setDuration(0);
        toast.setView(inflate);
        toast.show();
    }

    public void showToastMsjYesil(String str) {
        View inflate = getLayoutInflater().inflate(R.layout.toast_yesil, (ViewGroup) findViewById(R.id.toast_linearLayout));
        ((TextView) inflate.findViewById(R.id.toast_tv)).setText(str);
        ((ImageView) inflate.findViewById(R.id.toast_ImageView)).setImageResource(R.drawable.icon_okey);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(48, 0, 0);
        toast.setDuration(0);
        toast.setView(inflate);
        toast.show();
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

    public int tekerrureEsasSure() {
        int i;
        int i2;
        int i3 = 0;
        if (this.cYil2.getText().toString().matches("")) {
            i = 0;
        } else {
            i = Integer.parseInt(this.cYil2.getText().toString());
        }
        if (this.cAy2.getText().toString().matches("")) {
            i2 = 0;
        } else {
            i2 = Integer.parseInt(this.cAy2.getText().toString());
        }
        if (!this.cGun2.getText().toString().matches("")) {
            i3 = Integer.parseInt(this.cGun2.getText().toString());
        }
        return (i * 365) + (i2 * 30) + i3;
    }

    public double cezaGuneCevir() {
        double d;
        double d2;
        boolean matches = this.cYil.getText().toString().matches("");
        double d3 = Utils.DOUBLE_EPSILON;
        if (matches) {
            d = 0.0d;
        } else {
            d = Double.parseDouble(this.cYil.getText().toString());
        }
        if (this.cAy.getText().toString().matches("")) {
            d2 = 0.0d;
        } else {
            d2 = Double.parseDouble(this.cAy.getText().toString());
        }
        if (!this.cGun.getText().toString().matches("")) {
            d3 = Double.parseDouble(this.cGun.getText().toString());
        }
        return (d * 365.0d) + (d2 * 30.0d) + d3;
    }

    public int mahsupGun() {
        if (this.mahsupGun.getText().toString().matches("") || this.rbMahsupHayir.isChecked()) {
            return 0;
        }
        return Integer.parseInt(this.mahsupGun.getText().toString());
    }

    public String dogrudan_Acik(int i) {
        if (i > 1095 || !this.rbKast.isChecked() || !this.f183rbOrgutCinselHayr.isChecked() || this.rbUcuncuGrupSuc.isChecked()) {
            return (i > 1825 || !this.rbTaksir.isChecked() || !this.f183rbOrgutCinselHayr.isChecked() || this.rbUcuncuGrupSuc.isChecked()) ? "Hükümlü KAPALI cezaevine girecek" : "Hükümlü doğrudan AÇIK cezaevine girecek";
        }
        return "Hükümlü doğrudan AÇIK cezaevine girecek";
    }

    public String davetiye_yakalama(int i) {
        if (i > 1095 || !this.rbKast.isChecked()) {
            return (i > 1825 || !this.rbTaksir.isChecked()) ? "Hüküm kesinleştiğinde, İnfaz Savcılığı re'sen yakalama emri düzenleyecek." : "Hüküm kesinleştiğinde, hükümlüye çağrı kâğıdı (davetiye) gönderilecek.";
        }
        return "Hüküm kesinleştiğinde, hükümlüye çağrı kâğıdı (davetiye) gönderilecek.";
    }

    public String gir_cik_durumu(int i) {
        if (i > 1095 || !this.rbKast.isChecked() || !this.f183rbOrgutCinselHayr.isChecked() || this.rbUcuncuGrupSuc.isChecked()) {
            return (i > 1825 || !this.rbTaksir.isChecked() || !this.f183rbOrgutCinselHayr.isChecked() || this.rbUcuncuGrupSuc.isChecked()) ? "Hükümlünün şartla tahliye indirimi ve denetimli serbestlik nedeniyle ‘yatarı’ yok. AMA hükümlünün denetimli serbestlikten faydalanabilmek için cezaevine ‘gir-çık’ yapması gerekli. \nŞöyle ki;\nHükümlü önce kapalı cezaevine girecek, burada iyi halli olarak açık cezaevine ayrılmayı hak edecek. Daha sonra açık cezaevinde de iyi halli olduğu tespit edilirse denetimli serbestlikle erken tahliye olabilecek." : "Hükümlünün şartla tahliye indirimi ve denetimli serbestlik nedeniyle ‘yatarı’ yok. AMA hükümlünün denetimli serbestlikten faydalanabilmek için cezaevine ‘gir-çık’ yapması gerekli. \nŞöyle ki;\nHükümlü önce açık cezaevine girecek, burada iyi halli olduğu tespit edilirse denetimli serbestlikle erken tahliye olabilecek. Bu süreç cezaevi ve infaz hâkimliklerinin iş yüküne göre 3 gün veya 1 hafta gibi bir zaman alabilmektedir.";
        }
        return "Hükümlünün şartla tahliye indirimi ve denetimli serbestlik nedeniyle ‘yatarı’ yok. AMA hükümlünün denetimli serbestlikten faydalanabilmek için cezaevine ‘gir-çık’ yapması gerekli. \nŞöyle ki;\nHükümlü önce açık cezaevine girecek, burada iyi halli olduğu tespit edilirse denetimli serbestlikle erken tahliye olabilecek. Bu süreç cezaevi ve infaz hâkimliklerinin iş yüküne göre 3 gün veya 1 hafta gibi bir zaman alabilmektedir.";
    }

    /* renamed from: kapalıdan_ayrilma_genel_kural  reason: contains not printable characters */
    public int m74kapaldan_ayrilma_genel_kural() {
        int cezaGuneCevir = (int) cezaGuneCevir();
        if (cezaGuneCevir < 3650) {
            return 30;
        }
        return cezaGuneCevir / 10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:190:0x04a7  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x04c0  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x053f  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0568  */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x0700  */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0741  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x079f  */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x07e4  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x082a  */
    /* JADX WARNING: Removed duplicated region for block: B:406:0x0a72  */
    /* JADX WARNING: Removed duplicated region for block: B:416:0x0ab3  */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x0b24  */
    /* JADX WARNING: Removed duplicated region for block: B:434:0x0b3d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String kapalidan_Aciga(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r0.sartlaTahliye
            r3 = 1095(0x447, float:1.534E-42)
            if (r1 > r3) goto L_0x0022
            android.widget.RadioButton r4 = r0.rbKast
            boolean r4 = r4.isChecked()
            if (r4 == 0) goto L_0x0022
            android.widget.RadioButton r4 = r0.f183rbOrgutCinselHayr
            boolean r4 = r4.isChecked()
            if (r4 == 0) goto L_0x0022
            android.widget.RadioButton r4 = r0.rbUcuncuGrupSuc
            boolean r4 = r4.isChecked()
            if (r4 == 0) goto L_0x003e
        L_0x0022:
            r4 = 1825(0x721, float:2.557E-42)
            if (r1 > r4) goto L_0x0040
            android.widget.RadioButton r5 = r0.rbTaksir
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x0040
            android.widget.RadioButton r5 = r0.f183rbOrgutCinselHayr
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x0040
            android.widget.RadioButton r5 = r0.rbUcuncuGrupSuc
            boolean r5 = r5.isChecked()
            if (r5 != 0) goto L_0x0040
        L_0x003e:
            r1 = 0
            return r1
        L_0x0040:
            android.widget.RadioButton r5 = r0.rbAcigaAyrilmaEvet
            boolean r5 = r5.isChecked()
            if (r5 != 0) goto L_0x0d2e
            android.widget.RadioButton r5 = r0.rbIkinciTekerrur
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x0052
            goto L_0x0d2e
        L_0x0052:
            if (r1 >= r4) goto L_0x0072
            android.widget.RadioButton r5 = r0.oncesi2016
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x0072
            android.widget.TextView r5 = r0.tv_seciliSuc
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "* Diğer suçlar"
            boolean r5 = r5.equalsIgnoreCase(r6)
            if (r5 == 0) goto L_0x0072
            java.lang.String r1 = "Hükümlü iyi halli olduğu tespit edildiğinde EN GEÇ 3 gün içinde KAPALI cezaevinden AÇIK cezaevine ayrılabilir"
            goto L_0x0d2d
        L_0x0072:
            if (r1 >= r4) goto L_0x00b6
            android.widget.RadioButton r5 = r0.oncesi2016
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x00b6
            android.widget.TextView r5 = r0.tv_seciliSuc
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "* Kasten öldürmenin ihmali davranışla işlenmesi (TCK 83)"
            boolean r5 = r5.equalsIgnoreCase(r6)
            if (r5 != 0) goto L_0x00b2
            android.widget.TextView r5 = r0.tv_seciliSuc
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "* İşkence suçu (TCK 94 ve 95)"
            boolean r5 = r5.equalsIgnoreCase(r6)
            if (r5 != 0) goto L_0x00b2
            android.widget.TextView r5 = r0.tv_seciliSuc
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "* Eziyet suçu (TCK 96)"
            boolean r5 = r5.equalsIgnoreCase(r6)
            if (r5 == 0) goto L_0x00b6
        L_0x00b2:
            java.lang.String r1 = "Hükümlü iyi halli olduğu tespit edildiğinde EN GEÇ 3 gün içinde KAPALI cezaevinden AÇIK cezaevine ayrılabilir"
            goto L_0x0d2d
        L_0x00b6:
            java.lang.String r5 = " gün KAPALI cezaevinde iyi halli olarak kaldıktan sonra AÇIK cezaevine ayrılabilir"
            java.lang.String r6 = "Hükümlü "
            r7 = 2555(0x9fb, float:3.58E-42)
            r8 = 3650(0xe42, float:5.115E-42)
            if (r1 < r4) goto L_0x00f5
            if (r1 >= r8) goto L_0x00f5
            android.widget.RadioButton r9 = r0.oncesi2020
            boolean r9 = r9.isChecked()
            if (r9 != 0) goto L_0x00d2
            android.widget.RadioButton r9 = r0.oncesi2016
            boolean r9 = r9.isChecked()
            if (r9 == 0) goto L_0x00f5
        L_0x00d2:
            if (r2 > r7) goto L_0x00f5
            android.widget.RadioButton r9 = r0.rbDorduncuGrupSuc
            boolean r9 = r9.isChecked()
            if (r9 == 0) goto L_0x00f5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            int r2 = r17.mahsupGun()
            int r2 = 30 - r2
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x00f5:
            java.lang.String r9 = ")gün KAPALI cezaevinde iyi halli olarak kaldıktan sonra AÇIK cezaevine ayrılabilir"
            java.lang.String r10 = " gün gerek\nHükümlü "
            java.lang.String r11 = " gün ("
            if (r1 < r4) goto L_0x0153
            if (r1 >= r8) goto L_0x0153
            android.widget.RadioButton r12 = r0.oncesi2020
            boolean r12 = r12.isChecked()
            if (r12 != 0) goto L_0x010f
            android.widget.RadioButton r12 = r0.oncesi2016
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0153
        L_0x010f:
            if (r2 <= r7) goto L_0x0153
            android.widget.RadioButton r12 = r0.rbDorduncuGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0153
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Kapalıda kalınması gereken en az süre 30 gün\nŞartla tahliyesine 7 yıl kalması için "
            r1.append(r3)
            int r2 = r2 - r7
            r1.append(r2)
            r1.append(r10)
            int r3 = r17.mahsupGun()
            int r3 = 30 - r3
            int r3 = java.lang.Math.max(r3, r2)
            r1.append(r3)
            r1.append(r11)
            int r3 = r17.mahsupGun()
            int r3 = 30 - r3
            int r2 = java.lang.Math.max(r3, r2)
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x0153:
            java.lang.String r12 = ") KAPALI cezaevinde iyi halli olarak geçirdikten sonra AÇIK cezaevine ayrılabilir"
            java.lang.String r13 = " günü ("
            java.lang.String r14 = "Hükümlü toplam cazanın 1/10'nu olan "
            if (r1 < r8) goto L_0x019e
            android.widget.RadioButton r15 = r0.oncesi2020
            boolean r15 = r15.isChecked()
            if (r15 != 0) goto L_0x016b
            android.widget.RadioButton r15 = r0.oncesi2016
            boolean r15 = r15.isChecked()
            if (r15 == 0) goto L_0x019e
        L_0x016b:
            if (r2 > r7) goto L_0x019e
            android.widget.RadioButton r15 = r0.rbDorduncuGrupSuc
            boolean r15 = r15.isChecked()
            if (r15 == 0) goto L_0x019e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            int r2 = r17.mahsupGun()
            int r2 = 90 - r2
            r1.append(r2)
            r1.append(r13)
            int r2 = r17.mahsupGun()
            int r2 = 90 - r2
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x019e:
            java.lang.String r15 = " gün\nŞartla tahliyesine 7 yıl kalması için "
            java.lang.String r3 = ") KAPALI cezaevinde iyi halli olarak kaldıktan sonra AÇIK cezaevine ayrılabilir"
            java.lang.String r4 = "Cezanın 1/10'u: "
            if (r1 < r8) goto L_0x0206
            android.widget.RadioButton r8 = r0.oncesi2020
            boolean r8 = r8.isChecked()
            if (r8 != 0) goto L_0x01b6
            android.widget.RadioButton r8 = r0.oncesi2016
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x0204
        L_0x01b6:
            if (r2 <= r7) goto L_0x0204
            android.widget.RadioButton r8 = r0.rbDorduncuGrupSuc
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x0204
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            r1.append(r4)
            r1.append(r15)
            int r2 = r2 - r7
            r1.append(r2)
            r1.append(r10)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r4 = java.lang.Math.max(r4, r2)
            r1.append(r4)
            r1.append(r11)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r2 = java.lang.Math.max(r4, r2)
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x0204:
            r8 = 3650(0xe42, float:5.115E-42)
        L_0x0206:
            if (r1 >= r8) goto L_0x023d
            android.widget.RadioButton r8 = r0.oncesi2020
            boolean r8 = r8.isChecked()
            if (r8 != 0) goto L_0x0218
            android.widget.RadioButton r8 = r0.oncesi2016
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x023b
        L_0x0218:
            if (r2 > r7) goto L_0x023b
            android.widget.RadioButton r8 = r0.rbDorduncuGrupSuc
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x023b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            int r2 = r17.mahsupGun()
            int r2 = 30 - r2
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x023b:
            r8 = 3650(0xe42, float:5.115E-42)
        L_0x023d:
            if (r1 < r8) goto L_0x029d
            android.widget.RadioButton r8 = r0.oncesi2020
            boolean r8 = r8.isChecked()
            if (r8 != 0) goto L_0x024f
            android.widget.RadioButton r8 = r0.oncesi2016
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x029d
        L_0x024f:
            if (r2 <= r7) goto L_0x029d
            android.widget.RadioButton r8 = r0.rbDorduncuGrupSuc
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x029d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            r1.append(r4)
            r1.append(r15)
            int r2 = r2 - r7
            r1.append(r2)
            r1.append(r10)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r4 = java.lang.Math.max(r4, r2)
            r1.append(r4)
            r1.append(r11)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r2 = java.lang.Math.max(r4, r2)
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x029d:
            r8 = 1825(0x721, float:2.557E-42)
            if (r1 < r8) goto L_0x02d8
            r7 = 3650(0xe42, float:5.115E-42)
            if (r1 >= r7) goto L_0x02d8
            android.widget.RadioButton r7 = r0.oncesi2020
            boolean r7 = r7.isChecked()
            if (r7 != 0) goto L_0x02b5
            android.widget.RadioButton r7 = r0.oncesi2016
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x02d8
        L_0x02b5:
            if (r2 >= r8) goto L_0x02d8
            android.widget.RadioButton r7 = r0.rbBirinciGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x02d8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            int r2 = r17.mahsupGun()
            int r2 = 30 - r2
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x02d8:
            r7 = 1825(0x721, float:2.557E-42)
            if (r1 < r7) goto L_0x0335
            r8 = 3650(0xe42, float:5.115E-42)
            if (r1 >= r8) goto L_0x0335
            android.widget.RadioButton r8 = r0.oncesi2020
            boolean r8 = r8.isChecked()
            if (r8 != 0) goto L_0x02f0
            android.widget.RadioButton r8 = r0.oncesi2016
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x0335
        L_0x02f0:
            if (r2 < r7) goto L_0x0335
            android.widget.RadioButton r7 = r0.rbBirinciGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x0335
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Kapalıda kalınması gereken en az süre 30 gün\nŞartla tahliyesine 5 yıldan AZ kalması için "
            r1.append(r3)
            int r2 = r2 + -1826
            r1.append(r2)
            r1.append(r10)
            int r3 = r17.mahsupGun()
            int r3 = 30 - r3
            int r3 = java.lang.Math.max(r3, r2)
            r1.append(r3)
            r1.append(r11)
            int r3 = r17.mahsupGun()
            int r3 = 30 - r3
            int r2 = java.lang.Math.max(r3, r2)
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x0335:
            r7 = 3650(0xe42, float:5.115E-42)
            if (r1 < r7) goto L_0x037e
            android.widget.RadioButton r7 = r0.oncesi2020
            boolean r7 = r7.isChecked()
            if (r7 != 0) goto L_0x0349
            android.widget.RadioButton r7 = r0.oncesi2016
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x037e
        L_0x0349:
            r7 = 1825(0x721, float:2.557E-42)
            if (r2 >= r7) goto L_0x037e
            android.widget.RadioButton r7 = r0.rbBirinciGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x037e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            int r2 = r17.mahsupGun()
            int r2 = 90 - r2
            r1.append(r2)
            r1.append(r13)
            int r2 = r17.mahsupGun()
            int r2 = 90 - r2
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x037e:
            java.lang.String r7 = " gün\nŞartla tahliyesine 5 yıldan AZ kalması için "
            r8 = 3650(0xe42, float:5.115E-42)
            if (r1 < r8) goto L_0x03e7
            android.widget.RadioButton r8 = r0.oncesi2020
            boolean r8 = r8.isChecked()
            if (r8 != 0) goto L_0x0394
            android.widget.RadioButton r8 = r0.oncesi2016
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x03e5
        L_0x0394:
            r8 = 1825(0x721, float:2.557E-42)
            if (r2 < r8) goto L_0x03e5
            android.widget.RadioButton r8 = r0.rbBirinciGrupSuc
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x03e5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            r1.append(r4)
            r1.append(r7)
            int r2 = r2 + -1826
            r1.append(r2)
            r1.append(r10)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r4 = java.lang.Math.max(r4, r2)
            r1.append(r4)
            r1.append(r11)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r2 = java.lang.Math.max(r4, r2)
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x03e5:
            r8 = 3650(0xe42, float:5.115E-42)
        L_0x03e7:
            if (r1 >= r8) goto L_0x0420
            android.widget.RadioButton r8 = r0.oncesi2020
            boolean r8 = r8.isChecked()
            if (r8 != 0) goto L_0x03f9
            android.widget.RadioButton r8 = r0.oncesi2016
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x041e
        L_0x03f9:
            r8 = 1825(0x721, float:2.557E-42)
            if (r2 >= r8) goto L_0x041e
            android.widget.RadioButton r8 = r0.rbBirinciGrupSuc
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x041e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            int r2 = r17.mahsupGun()
            int r2 = 30 - r2
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x041e:
            r8 = 3650(0xe42, float:5.115E-42)
        L_0x0420:
            if (r1 < r8) goto L_0x0483
            android.widget.RadioButton r8 = r0.oncesi2020
            boolean r8 = r8.isChecked()
            if (r8 != 0) goto L_0x0432
            android.widget.RadioButton r8 = r0.oncesi2016
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x0483
        L_0x0432:
            r8 = 1825(0x721, float:2.557E-42)
            if (r2 < r8) goto L_0x0485
            android.widget.RadioButton r8 = r0.rbBirinciGrupSuc
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x0483
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            r1.append(r4)
            r1.append(r7)
            int r2 = r2 + -1826
            r1.append(r2)
            r1.append(r10)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r4 = java.lang.Math.max(r4, r2)
            r1.append(r4)
            r1.append(r11)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r2 = java.lang.Math.max(r4, r2)
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x0483:
            r8 = 1825(0x721, float:2.557E-42)
        L_0x0485:
            if (r1 < r8) goto L_0x04c0
            r8 = 3650(0xe42, float:5.115E-42)
            if (r1 >= r8) goto L_0x04c0
            android.widget.RadioButton r8 = r0.oncesi2020
            boolean r8 = r8.isChecked()
            if (r8 != 0) goto L_0x049b
            android.widget.RadioButton r8 = r0.oncesi2016
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x04c0
        L_0x049b:
            r8 = 1095(0x447, float:1.534E-42)
            if (r2 >= r8) goto L_0x04c0
            android.widget.RadioButton r8 = r0.rbIkinciGrupSuc
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x04c0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            int r2 = r17.mahsupGun()
            int r2 = 30 - r2
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x04c0:
            r8 = 1825(0x721, float:2.557E-42)
            if (r1 < r8) goto L_0x051f
            r8 = 3650(0xe42, float:5.115E-42)
            if (r1 >= r8) goto L_0x0521
            android.widget.RadioButton r8 = r0.oncesi2020
            boolean r8 = r8.isChecked()
            if (r8 != 0) goto L_0x04d8
            android.widget.RadioButton r8 = r0.oncesi2016
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x051f
        L_0x04d8:
            r8 = 1095(0x447, float:1.534E-42)
            if (r2 < r8) goto L_0x051f
            android.widget.RadioButton r8 = r0.rbIkinciGrupSuc
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x051f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Kapalıda kalınması gereken en az süre 30 gün\nŞartla tahliyesine 3 yıldan AZ kalması için "
            r1.append(r3)
            int r2 = r2 + -1096
            r1.append(r2)
            r1.append(r10)
            int r3 = r17.mahsupGun()
            int r3 = 30 - r3
            int r3 = java.lang.Math.max(r3, r2)
            r1.append(r3)
            r1.append(r11)
            int r3 = r17.mahsupGun()
            int r3 = 30 - r3
            int r2 = java.lang.Math.max(r3, r2)
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x051f:
            r8 = 3650(0xe42, float:5.115E-42)
        L_0x0521:
            if (r1 < r8) goto L_0x0568
            android.widget.RadioButton r8 = r0.oncesi2020
            boolean r8 = r8.isChecked()
            if (r8 != 0) goto L_0x0533
            android.widget.RadioButton r8 = r0.oncesi2016
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x0568
        L_0x0533:
            r8 = 1095(0x447, float:1.534E-42)
            if (r2 >= r8) goto L_0x0568
            android.widget.RadioButton r8 = r0.rbIkinciGrupSuc
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x0568
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            int r2 = r17.mahsupGun()
            int r2 = 90 - r2
            r1.append(r2)
            r1.append(r13)
            int r2 = r17.mahsupGun()
            int r2 = 90 - r2
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x0568:
            java.lang.String r8 = " gün\nŞartla tahliyesine 3 yıldan AZ kalması için "
            r16 = r7
            r7 = 3650(0xe42, float:5.115E-42)
            if (r1 < r7) goto L_0x05d3
            android.widget.RadioButton r7 = r0.oncesi2020
            boolean r7 = r7.isChecked()
            if (r7 != 0) goto L_0x0580
            android.widget.RadioButton r7 = r0.oncesi2016
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x05d1
        L_0x0580:
            r7 = 1095(0x447, float:1.534E-42)
            if (r2 < r7) goto L_0x05d1
            android.widget.RadioButton r7 = r0.rbIkinciGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x05d1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            r1.append(r4)
            r1.append(r8)
            int r2 = r2 + -1096
            r1.append(r2)
            r1.append(r10)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r4 = java.lang.Math.max(r4, r2)
            r1.append(r4)
            r1.append(r11)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r2 = java.lang.Math.max(r4, r2)
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x05d1:
            r7 = 3650(0xe42, float:5.115E-42)
        L_0x05d3:
            if (r1 >= r7) goto L_0x060c
            android.widget.RadioButton r7 = r0.oncesi2020
            boolean r7 = r7.isChecked()
            if (r7 != 0) goto L_0x05e5
            android.widget.RadioButton r7 = r0.oncesi2016
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x060a
        L_0x05e5:
            r7 = 1095(0x447, float:1.534E-42)
            if (r2 >= r7) goto L_0x060a
            android.widget.RadioButton r7 = r0.rbIkinciGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x060a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            int r2 = r17.mahsupGun()
            int r2 = 30 - r2
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x060a:
            r7 = 3650(0xe42, float:5.115E-42)
        L_0x060c:
            if (r1 < r7) goto L_0x066f
            android.widget.RadioButton r7 = r0.oncesi2020
            boolean r7 = r7.isChecked()
            if (r7 != 0) goto L_0x061e
            android.widget.RadioButton r7 = r0.oncesi2016
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x066f
        L_0x061e:
            r7 = 1095(0x447, float:1.534E-42)
            if (r2 < r7) goto L_0x066f
            android.widget.RadioButton r7 = r0.rbIkinciGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x066f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            r1.append(r4)
            r1.append(r8)
            int r2 = r2 + -1096
            r1.append(r2)
            r1.append(r10)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r4 = java.lang.Math.max(r4, r2)
            r1.append(r4)
            r1.append(r11)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r2 = java.lang.Math.max(r4, r2)
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x066f:
            r7 = 1825(0x721, float:2.557E-42)
            if (r1 < r7) goto L_0x06a6
            r7 = 3650(0xe42, float:5.115E-42)
            if (r1 >= r7) goto L_0x06a4
            android.widget.RadioButton r7 = r0.sonrasi2020
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x06a4
            r7 = 2555(0x9fb, float:3.58E-42)
            if (r2 > r7) goto L_0x06a4
            android.widget.RadioButton r7 = r0.rbDorduncuGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x06a4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            int r2 = r17.mahsupGun()
            int r2 = 30 - r2
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x06a4:
            r7 = 1825(0x721, float:2.557E-42)
        L_0x06a6:
            if (r1 < r7) goto L_0x06fc
            r7 = 3650(0xe42, float:5.115E-42)
            if (r1 >= r7) goto L_0x06fe
            android.widget.RadioButton r7 = r0.sonrasi2020
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x06fc
            r7 = 2555(0x9fb, float:3.58E-42)
            if (r2 <= r7) goto L_0x06fc
            android.widget.RadioButton r7 = r0.rbDorduncuGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x06fc
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Kapalıda kalınması gereken en az süre 30 gün\nŞartla tahliyesine 7 yıl kalması için "
            r1.append(r3)
            r3 = 2555(0x9fb, float:3.58E-42)
            int r2 = r2 - r3
            r1.append(r2)
            r1.append(r10)
            int r3 = r17.mahsupGun()
            int r3 = 30 - r3
            int r3 = java.lang.Math.max(r3, r2)
            r1.append(r3)
            r1.append(r11)
            int r3 = r17.mahsupGun()
            int r3 = 30 - r3
            int r2 = java.lang.Math.max(r3, r2)
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x06fc:
            r7 = 3650(0xe42, float:5.115E-42)
        L_0x06fe:
            if (r1 < r7) goto L_0x073f
            android.widget.RadioButton r7 = r0.sonrasi2020
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x073d
            r7 = 2555(0x9fb, float:3.58E-42)
            if (r2 > r7) goto L_0x073d
            android.widget.RadioButton r7 = r0.rbDorduncuGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x073d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            int r2 = r17.mahsupGun()
            int r2 = 90 - r2
            r1.append(r2)
            r1.append(r13)
            int r2 = r17.mahsupGun()
            int r2 = 90 - r2
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x073d:
            r7 = 3650(0xe42, float:5.115E-42)
        L_0x073f:
            if (r1 < r7) goto L_0x079d
            android.widget.RadioButton r7 = r0.sonrasi2020
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x079b
            r7 = 2555(0x9fb, float:3.58E-42)
            if (r2 <= r7) goto L_0x079b
            android.widget.RadioButton r7 = r0.rbDorduncuGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x079b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            r1.append(r4)
            r1.append(r15)
            r4 = 2555(0x9fb, float:3.58E-42)
            int r2 = r2 - r4
            r1.append(r2)
            r1.append(r10)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r4 = java.lang.Math.max(r4, r2)
            r1.append(r4)
            r1.append(r11)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r2 = java.lang.Math.max(r4, r2)
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x079b:
            r7 = 3650(0xe42, float:5.115E-42)
        L_0x079d:
            if (r1 >= r7) goto L_0x07ce
            android.widget.RadioButton r7 = r0.sonrasi2020
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x07cc
            r7 = 2555(0x9fb, float:3.58E-42)
            if (r2 > r7) goto L_0x07cc
            android.widget.RadioButton r7 = r0.rbDorduncuGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x07cc
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            int r2 = r17.mahsupGun()
            int r2 = 30 - r2
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x07cc:
            r7 = 3650(0xe42, float:5.115E-42)
        L_0x07ce:
            if (r1 < r7) goto L_0x082a
            android.widget.RadioButton r7 = r0.sonrasi2020
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x082a
            r7 = 2555(0x9fb, float:3.58E-42)
            if (r2 <= r7) goto L_0x082a
            android.widget.RadioButton r7 = r0.rbDorduncuGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x082a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            r1.append(r4)
            r1.append(r15)
            r4 = 2555(0x9fb, float:3.58E-42)
            int r2 = r2 - r4
            r1.append(r2)
            r1.append(r10)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r4 = java.lang.Math.max(r4, r2)
            r1.append(r4)
            r1.append(r11)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r2 = java.lang.Math.max(r4, r2)
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x082a:
            r7 = 1825(0x721, float:2.557E-42)
            if (r1 < r7) goto L_0x085f
            r15 = 3650(0xe42, float:5.115E-42)
            if (r1 >= r15) goto L_0x085f
            android.widget.RadioButton r15 = r0.sonrasi2020
            boolean r15 = r15.isChecked()
            if (r15 == 0) goto L_0x085f
            if (r2 >= r7) goto L_0x085f
            android.widget.RadioButton r7 = r0.rbBirinciGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x085d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            int r2 = r17.mahsupGun()
            int r2 = 30 - r2
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x085d:
            r7 = 1825(0x721, float:2.557E-42)
        L_0x085f:
            if (r1 < r7) goto L_0x08b2
            r15 = 3650(0xe42, float:5.115E-42)
            if (r1 >= r15) goto L_0x08b2
            android.widget.RadioButton r15 = r0.sonrasi2020
            boolean r15 = r15.isChecked()
            if (r15 == 0) goto L_0x08b2
            if (r2 < r7) goto L_0x08b2
            android.widget.RadioButton r7 = r0.rbBirinciGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x08b2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Kapalıda kalınması gereken en az süre 30 gün\nŞartla tahliyesine 5 yıldan AZ kalması için "
            r1.append(r3)
            int r2 = r2 + -1826
            r1.append(r2)
            r1.append(r10)
            int r3 = r17.mahsupGun()
            int r3 = 30 - r3
            int r3 = java.lang.Math.max(r3, r2)
            r1.append(r3)
            r1.append(r11)
            int r3 = r17.mahsupGun()
            int r3 = 30 - r3
            int r2 = java.lang.Math.max(r3, r2)
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x08b2:
            r7 = 3650(0xe42, float:5.115E-42)
            if (r1 < r7) goto L_0x08f5
            android.widget.RadioButton r7 = r0.sonrasi2020
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x08f3
            r7 = 1825(0x721, float:2.557E-42)
            if (r2 >= r7) goto L_0x08f3
            android.widget.RadioButton r7 = r0.rbBirinciGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x08f3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            int r2 = r17.mahsupGun()
            int r2 = 90 - r2
            r1.append(r2)
            r1.append(r13)
            int r2 = r17.mahsupGun()
            int r2 = 90 - r2
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x08f3:
            r7 = 3650(0xe42, float:5.115E-42)
        L_0x08f5:
            if (r1 < r7) goto L_0x0952
            android.widget.RadioButton r7 = r0.sonrasi2020
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x0952
            r7 = 1825(0x721, float:2.557E-42)
            if (r2 < r7) goto L_0x0952
            android.widget.RadioButton r7 = r0.rbBirinciGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x0952
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            r1.append(r4)
            r7 = r16
            r1.append(r7)
            int r2 = r2 + -1826
            r1.append(r2)
            r1.append(r10)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r4 = java.lang.Math.max(r4, r2)
            r1.append(r4)
            r1.append(r11)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r2 = java.lang.Math.max(r4, r2)
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x0952:
            r7 = r16
            r15 = 3650(0xe42, float:5.115E-42)
            if (r1 >= r15) goto L_0x0987
            android.widget.RadioButton r15 = r0.sonrasi2020
            boolean r15 = r15.isChecked()
            if (r15 == 0) goto L_0x0985
            r15 = 1825(0x721, float:2.557E-42)
            if (r2 >= r15) goto L_0x0985
            android.widget.RadioButton r15 = r0.rbBirinciGrupSuc
            boolean r15 = r15.isChecked()
            if (r15 == 0) goto L_0x0985
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            int r2 = r17.mahsupGun()
            int r2 = 30 - r2
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x0985:
            r15 = 3650(0xe42, float:5.115E-42)
        L_0x0987:
            if (r1 < r15) goto L_0x09e2
            android.widget.RadioButton r15 = r0.sonrasi2020
            boolean r15 = r15.isChecked()
            if (r15 == 0) goto L_0x09e2
            r15 = 1825(0x721, float:2.557E-42)
            if (r2 < r15) goto L_0x09e2
            android.widget.RadioButton r15 = r0.rbBirinciGrupSuc
            boolean r15 = r15.isChecked()
            if (r15 == 0) goto L_0x09e2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            r1.append(r4)
            r1.append(r7)
            int r2 = r2 + -1826
            r1.append(r2)
            r1.append(r10)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r4 = java.lang.Math.max(r4, r2)
            r1.append(r4)
            r1.append(r11)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r2 = java.lang.Math.max(r4, r2)
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x09e2:
            r7 = 1825(0x721, float:2.557E-42)
            if (r1 < r7) goto L_0x0a19
            r7 = 3650(0xe42, float:5.115E-42)
            if (r1 >= r7) goto L_0x0a17
            android.widget.RadioButton r7 = r0.sonrasi2020
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x0a17
            r7 = 1095(0x447, float:1.534E-42)
            if (r2 >= r7) goto L_0x0a17
            android.widget.RadioButton r7 = r0.rbIkinciGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x0a17
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            int r2 = r17.mahsupGun()
            int r2 = 30 - r2
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x0a17:
            r7 = 1825(0x721, float:2.557E-42)
        L_0x0a19:
            if (r1 < r7) goto L_0x0a6e
            r7 = 3650(0xe42, float:5.115E-42)
            if (r1 >= r7) goto L_0x0a70
            android.widget.RadioButton r7 = r0.sonrasi2020
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x0a6e
            r7 = 1095(0x447, float:1.534E-42)
            if (r2 < r7) goto L_0x0a6e
            android.widget.RadioButton r7 = r0.rbIkinciGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x0a6e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Kapalıda kalınması gereken en az süre 30 gün\nŞartla tahliyesine 3 yıldan AZ kalması için "
            r1.append(r3)
            int r2 = r2 + -1096
            r1.append(r2)
            r1.append(r10)
            int r3 = r17.mahsupGun()
            int r3 = 30 - r3
            int r3 = java.lang.Math.max(r3, r2)
            r1.append(r3)
            r1.append(r11)
            int r3 = r17.mahsupGun()
            int r3 = 30 - r3
            int r2 = java.lang.Math.max(r3, r2)
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x0a6e:
            r7 = 3650(0xe42, float:5.115E-42)
        L_0x0a70:
            if (r1 < r7) goto L_0x0ab1
            android.widget.RadioButton r7 = r0.sonrasi2020
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x0aaf
            r7 = 1095(0x447, float:1.534E-42)
            if (r2 >= r7) goto L_0x0aaf
            android.widget.RadioButton r7 = r0.rbIkinciGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x0aaf
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            int r2 = r17.mahsupGun()
            int r2 = 90 - r2
            r1.append(r2)
            r1.append(r13)
            int r2 = r17.mahsupGun()
            int r2 = 90 - r2
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x0aaf:
            r7 = 3650(0xe42, float:5.115E-42)
        L_0x0ab1:
            if (r1 < r7) goto L_0x0b0e
            android.widget.RadioButton r7 = r0.sonrasi2020
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x0b0c
            r7 = 1095(0x447, float:1.534E-42)
            if (r2 < r7) goto L_0x0b0c
            android.widget.RadioButton r7 = r0.rbIkinciGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x0b0c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            r1.append(r4)
            r1.append(r8)
            int r2 = r2 + -1096
            r1.append(r2)
            r1.append(r10)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r4 = java.lang.Math.max(r4, r2)
            r1.append(r4)
            r1.append(r11)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r2 = java.lang.Math.max(r4, r2)
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x0b0c:
            r7 = 3650(0xe42, float:5.115E-42)
        L_0x0b0e:
            if (r1 >= r7) goto L_0x0b3d
            android.widget.RadioButton r7 = r0.sonrasi2020
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x0b3d
            r7 = 1095(0x447, float:1.534E-42)
            if (r2 >= r7) goto L_0x0b3d
            android.widget.RadioButton r7 = r0.rbIkinciGrupSuc
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x0b3d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            int r2 = r17.mahsupGun()
            int r2 = 30 - r2
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x0b3d:
            r5 = 3650(0xe42, float:5.115E-42)
            if (r1 < r5) goto L_0x0b9a
            android.widget.RadioButton r5 = r0.sonrasi2020
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x0b9a
            r5 = 1095(0x447, float:1.534E-42)
            if (r2 < r5) goto L_0x0b9a
            android.widget.RadioButton r5 = r0.rbIkinciGrupSuc
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x0b9a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            r1.append(r4)
            r1.append(r8)
            int r2 = r2 + -1096
            r1.append(r2)
            r1.append(r10)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r4 = java.lang.Math.max(r4, r2)
            r1.append(r4)
            r1.append(r11)
            int r4 = r17.mahsupGun()
            int r4 = 90 - r4
            int r2 = java.lang.Math.max(r4, r2)
            java.lang.String r2 = gunCevirme(r2)
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x0b9a:
            android.widget.RadioButton r3 = r0.oncesi2016
            boolean r3 = r3.isChecked()
            java.lang.String r4 = "Hükümlünün örgütten ayrıldığı;\n1-Tespit edilirse:\n"
            if (r3 != 0) goto L_0x0bb4
            android.widget.RadioButton r3 = r0.oncesi2020
            boolean r3 = r3.isChecked()
            if (r3 != 0) goto L_0x0bb4
            android.widget.RadioButton r3 = r0.sonrasi2020
            boolean r3 = r3.isChecked()
            if (r3 == 0) goto L_0x0c03
        L_0x0bb4:
            r3 = 365(0x16d, float:5.11E-43)
            if (r2 >= r3) goto L_0x0c03
            android.widget.RadioButton r3 = r0.rbUcuncuGrupSuc
            boolean r3 = r3.isChecked()
            if (r3 == 0) goto L_0x0c03
            android.widget.RadioButton r3 = r0.rbEtkin_Hayir
            boolean r3 = r3.isChecked()
            if (r3 == 0) goto L_0x0c03
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            int r3 = r17.m74kapaldan_ayrilma_genel_kural()
            int r1 = r1 / 3
            int r3 = java.lang.Math.max(r3, r1)
            int r4 = r17.mahsupGun()
            int r3 = r3 - r4
            r2.append(r3)
            r2.append(r11)
            int r3 = r17.m74kapaldan_ayrilma_genel_kural()
            int r1 = java.lang.Math.max(r3, r1)
            int r3 = r17.mahsupGun()
            int r1 = r1 - r3
            java.lang.String r1 = gunCevirme(r1)
            r2.append(r1)
            java.lang.String r1 = ") kapalı cezaevinde kaldıktan sonra açık ceza evine ayrılabilir.\n2- Tespit edilmezse:\nHükümlü açık cezaevine ayrılamaz."
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            return r1
        L_0x0c03:
            android.widget.RadioButton r3 = r0.oncesi2016
            boolean r3 = r3.isChecked()
            if (r3 != 0) goto L_0x0c1b
            android.widget.RadioButton r3 = r0.oncesi2020
            boolean r3 = r3.isChecked()
            if (r3 != 0) goto L_0x0c1b
            android.widget.RadioButton r3 = r0.sonrasi2020
            boolean r3 = r3.isChecked()
            if (r3 == 0) goto L_0x0c64
        L_0x0c1b:
            r3 = 365(0x16d, float:5.11E-43)
            if (r2 < r3) goto L_0x0c64
            android.widget.RadioButton r3 = r0.rbUcuncuGrupSuc
            boolean r3 = r3.isChecked()
            if (r3 == 0) goto L_0x0c64
            android.widget.RadioButton r3 = r0.rbEtkin_Hayir
            boolean r3 = r3.isChecked()
            if (r3 == 0) goto L_0x0c64
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            int r1 = r1 / 3
            int r2 = r2 + -364
            int r4 = java.lang.Math.max(r1, r2)
            int r5 = r17.mahsupGun()
            int r4 = r4 - r5
            r3.append(r4)
            r3.append(r11)
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r17.mahsupGun()
            int r1 = r1 - r2
            java.lang.String r1 = gunCevirme(r1)
            r3.append(r1)
            java.lang.String r1 = ") kapalı cezaevinde kaldıktan sonra açık ceza evine ayrılabilir.\n2- Tespit edilmezse:\nHükümlü açık cezaevine ayrılamaz."
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            return r1
        L_0x0c64:
            android.widget.RadioButton r3 = r0.oncesi2016
            boolean r3 = r3.isChecked()
            if (r3 != 0) goto L_0x0c7c
            android.widget.RadioButton r3 = r0.oncesi2020
            boolean r3 = r3.isChecked()
            if (r3 != 0) goto L_0x0c7c
            android.widget.RadioButton r3 = r0.sonrasi2020
            boolean r3 = r3.isChecked()
            if (r3 == 0) goto L_0x0ccb
        L_0x0c7c:
            r3 = 730(0x2da, float:1.023E-42)
            if (r2 >= r3) goto L_0x0ccb
            android.widget.RadioButton r3 = r0.rbUcuncuGrupSuc
            boolean r3 = r3.isChecked()
            if (r3 == 0) goto L_0x0ccb
            android.widget.RadioButton r3 = r0.rbEtkin_Evet
            boolean r3 = r3.isChecked()
            if (r3 == 0) goto L_0x0ccb
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            int r3 = r17.m74kapaldan_ayrilma_genel_kural()
            int r1 = r1 / 3
            int r3 = java.lang.Math.max(r3, r1)
            int r4 = r17.mahsupGun()
            int r3 = r3 - r4
            r2.append(r3)
            r2.append(r11)
            int r3 = r17.m74kapaldan_ayrilma_genel_kural()
            int r1 = java.lang.Math.max(r3, r1)
            int r3 = r17.mahsupGun()
            int r1 = r1 - r3
            java.lang.String r1 = gunCevirme(r1)
            r2.append(r1)
            java.lang.String r1 = ") kapalı cezaevinde kaldıktan sonra açık cezaevine ayrılabilir.\n2- Tespit edilmezse:\nHükümlü açık cezaevine ayrılamaz."
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            return r1
        L_0x0ccb:
            android.widget.RadioButton r3 = r0.oncesi2016
            boolean r3 = r3.isChecked()
            if (r3 != 0) goto L_0x0ce3
            android.widget.RadioButton r3 = r0.oncesi2020
            boolean r3 = r3.isChecked()
            if (r3 != 0) goto L_0x0ce3
            android.widget.RadioButton r3 = r0.sonrasi2020
            boolean r3 = r3.isChecked()
            if (r3 == 0) goto L_0x0d2c
        L_0x0ce3:
            r3 = 730(0x2da, float:1.023E-42)
            if (r2 < r3) goto L_0x0d2c
            android.widget.RadioButton r3 = r0.rbUcuncuGrupSuc
            boolean r3 = r3.isChecked()
            if (r3 == 0) goto L_0x0d2c
            android.widget.RadioButton r3 = r0.rbEtkin_Evet
            boolean r3 = r3.isChecked()
            if (r3 == 0) goto L_0x0d2c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            int r1 = r1 / 3
            int r2 = r2 + -729
            int r4 = java.lang.Math.max(r1, r2)
            int r5 = r17.mahsupGun()
            int r4 = r4 - r5
            r3.append(r4)
            r3.append(r11)
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r17.mahsupGun()
            int r1 = r1 - r2
            java.lang.String r1 = gunCevirme(r1)
            r3.append(r1)
            java.lang.String r1 = ") kapalı cezaevinde kaldıktan sonra açık cezaevine ayrılabilir.\n2- Tespit edilmezse:\nHükümlü açık cezaevine ayrılamaz."
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            return r1
        L_0x0d2c:
            r1 = 0
        L_0x0d2d:
            return r1
        L_0x0d2e:
            java.lang.String r1 = "Hükümlü AÇIK cezaevine AYRILAMAZ"
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.infaz_hesaplama.InfazHesaplama.C0520infaz_hesaplama.kapalidan_Aciga(int):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:391:0x0690  */
    /* JADX WARNING: Removed duplicated region for block: B:413:0x06e7  */
    /* JADX WARNING: Removed duplicated region for block: B:414:0x06e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int kapalidaki_gun_sayisi(int r15) {
        /*
            r14 = this;
            int r0 = r14.sartlaTahliye
            java.lang.String r1 = "* Eziyet suçu (TCK 96)"
            java.lang.String r2 = "* İşkence suçu (TCK 94 ve 95)"
            java.lang.String r3 = "* Kasten öldürmenin ihmali davranışla işlenmesi (TCK 83)"
            java.lang.String r4 = "* Diğer suçlar"
            r5 = 90
            r6 = 0
            r7 = 3
            r8 = 1095(0x447, float:1.534E-42)
            r9 = 30
            r10 = 1825(0x721, float:2.557E-42)
            r11 = 3650(0xe42, float:5.115E-42)
            if (r15 > r8) goto L_0x0030
            android.widget.RadioButton r12 = r14.rbKast
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0030
            android.widget.RadioButton r12 = r14.f183rbOrgutCinselHayr
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0030
            android.widget.RadioButton r12 = r14.rbUcuncuGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x004a
        L_0x0030:
            if (r15 > r10) goto L_0x004d
            android.widget.RadioButton r12 = r14.rbTaksir
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x004d
            android.widget.RadioButton r12 = r14.f183rbOrgutCinselHayr
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x004d
            android.widget.RadioButton r12 = r14.rbUcuncuGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 != 0) goto L_0x004d
        L_0x004a:
            r12 = 0
            goto L_0x0688
        L_0x004d:
            android.widget.RadioButton r12 = r14.rbAcigaAyrilmaEvet
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0058
            r12 = r0
            goto L_0x0688
        L_0x0058:
            android.widget.RadioButton r12 = r14.rbIkinciTekerrur
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0063
            r12 = r15
            goto L_0x0688
        L_0x0063:
            if (r15 >= r10) goto L_0x0080
            android.widget.RadioButton r12 = r14.oncesi2016
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0080
            android.widget.TextView r12 = r14.tv_seciliSuc
            java.lang.CharSequence r12 = r12.getText()
            java.lang.String r12 = r12.toString()
            boolean r12 = r12.equalsIgnoreCase(r4)
            if (r12 == 0) goto L_0x0080
        L_0x007d:
            r12 = 3
            goto L_0x0688
        L_0x0080:
            if (r15 >= r10) goto L_0x00bb
            android.widget.RadioButton r12 = r14.oncesi2016
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x00bb
            android.widget.TextView r12 = r14.tv_seciliSuc
            java.lang.CharSequence r12 = r12.getText()
            java.lang.String r12 = r12.toString()
            boolean r12 = r12.equalsIgnoreCase(r3)
            if (r12 != 0) goto L_0x007d
            android.widget.TextView r12 = r14.tv_seciliSuc
            java.lang.CharSequence r12 = r12.getText()
            java.lang.String r12 = r12.toString()
            boolean r12 = r12.equalsIgnoreCase(r2)
            if (r12 != 0) goto L_0x007d
            android.widget.TextView r12 = r14.tv_seciliSuc
            java.lang.CharSequence r12 = r12.getText()
            java.lang.String r12 = r12.toString()
            boolean r12 = r12.equalsIgnoreCase(r1)
            if (r12 == 0) goto L_0x00bb
            goto L_0x007d
        L_0x00bb:
            r12 = 2555(0x9fb, float:3.58E-42)
            if (r15 < r10) goto L_0x00e3
            if (r15 >= r11) goto L_0x00e3
            android.widget.RadioButton r13 = r14.oncesi2020
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x00d1
            android.widget.RadioButton r13 = r14.oncesi2016
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x00e3
        L_0x00d1:
            if (r0 > r12) goto L_0x00e3
            android.widget.RadioButton r13 = r14.rbDorduncuGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x00e3
            int r12 = r14.mahsupGun()
        L_0x00df:
            int r12 = 30 - r12
            goto L_0x0688
        L_0x00e3:
            if (r15 < r10) goto L_0x010f
            if (r15 >= r11) goto L_0x010f
            android.widget.RadioButton r13 = r14.oncesi2020
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x00f7
            android.widget.RadioButton r13 = r14.oncesi2016
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x010f
        L_0x00f7:
            if (r0 <= r12) goto L_0x010f
            android.widget.RadioButton r13 = r14.rbDorduncuGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x010f
            int r12 = r14.mahsupGun()
            int r12 = 30 - r12
            int r13 = r0 + -2555
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x0688
        L_0x010f:
            if (r15 < r11) goto L_0x0133
            android.widget.RadioButton r13 = r14.oncesi2020
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x0121
            android.widget.RadioButton r13 = r14.oncesi2016
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x0133
        L_0x0121:
            if (r0 > r12) goto L_0x0133
            android.widget.RadioButton r13 = r14.rbDorduncuGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x0133
            int r12 = r14.mahsupGun()
        L_0x012f:
            int r12 = 90 - r12
            goto L_0x0688
        L_0x0133:
            if (r15 < r11) goto L_0x015d
            android.widget.RadioButton r13 = r14.oncesi2020
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x0145
            android.widget.RadioButton r13 = r14.oncesi2016
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x015d
        L_0x0145:
            if (r0 <= r12) goto L_0x015d
            android.widget.RadioButton r13 = r14.rbDorduncuGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x015d
            int r12 = r14.mahsupGun()
            int r12 = 90 - r12
            int r13 = r0 + -2555
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x0688
        L_0x015d:
            if (r15 >= r11) goto L_0x017f
            android.widget.RadioButton r13 = r14.oncesi2020
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x016f
            android.widget.RadioButton r13 = r14.oncesi2016
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x017f
        L_0x016f:
            if (r0 > r12) goto L_0x017f
            android.widget.RadioButton r13 = r14.rbDorduncuGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x017f
            int r12 = r14.mahsupGun()
            goto L_0x00df
        L_0x017f:
            if (r15 < r11) goto L_0x01a9
            android.widget.RadioButton r13 = r14.oncesi2020
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x0191
            android.widget.RadioButton r13 = r14.oncesi2016
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x01a9
        L_0x0191:
            if (r0 <= r12) goto L_0x01a9
            android.widget.RadioButton r13 = r14.rbDorduncuGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x01a9
            int r12 = r14.mahsupGun()
            int r12 = 90 - r12
            int r13 = r0 + -2555
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x0688
        L_0x01a9:
            if (r15 < r10) goto L_0x01cd
            if (r15 >= r11) goto L_0x01cd
            android.widget.RadioButton r13 = r14.oncesi2020
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x01bd
            android.widget.RadioButton r13 = r14.oncesi2016
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x01cd
        L_0x01bd:
            if (r0 >= r10) goto L_0x01cd
            android.widget.RadioButton r13 = r14.rbBirinciGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x01cd
            int r12 = r14.mahsupGun()
            goto L_0x00df
        L_0x01cd:
            if (r15 < r10) goto L_0x01f9
            if (r15 >= r11) goto L_0x01f9
            android.widget.RadioButton r13 = r14.oncesi2020
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x01e1
            android.widget.RadioButton r13 = r14.oncesi2016
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x01f9
        L_0x01e1:
            if (r0 < r10) goto L_0x01f9
            android.widget.RadioButton r13 = r14.rbBirinciGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x01f9
            int r12 = r14.mahsupGun()
            int r12 = 30 - r12
            int r13 = r0 + -1826
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x0688
        L_0x01f9:
            if (r15 < r11) goto L_0x021b
            android.widget.RadioButton r13 = r14.oncesi2020
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x020b
            android.widget.RadioButton r13 = r14.oncesi2016
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x021b
        L_0x020b:
            if (r0 >= r10) goto L_0x021b
            android.widget.RadioButton r13 = r14.rbBirinciGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x021b
            int r12 = r14.mahsupGun()
            goto L_0x012f
        L_0x021b:
            if (r15 < r11) goto L_0x0245
            android.widget.RadioButton r13 = r14.oncesi2020
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x022d
            android.widget.RadioButton r13 = r14.oncesi2016
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x0245
        L_0x022d:
            if (r0 < r10) goto L_0x0245
            android.widget.RadioButton r13 = r14.rbBirinciGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x0245
            int r12 = r14.mahsupGun()
            int r12 = 90 - r12
            int r13 = r0 + -1826
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x0688
        L_0x0245:
            if (r15 >= r11) goto L_0x0267
            android.widget.RadioButton r13 = r14.oncesi2020
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x0257
            android.widget.RadioButton r13 = r14.oncesi2016
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x0267
        L_0x0257:
            if (r0 >= r10) goto L_0x0267
            android.widget.RadioButton r13 = r14.rbBirinciGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x0267
            int r12 = r14.mahsupGun()
            goto L_0x00df
        L_0x0267:
            if (r15 < r11) goto L_0x0291
            android.widget.RadioButton r13 = r14.oncesi2020
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x0279
            android.widget.RadioButton r13 = r14.oncesi2016
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x0291
        L_0x0279:
            if (r0 < r10) goto L_0x0291
            android.widget.RadioButton r13 = r14.rbBirinciGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x0291
            int r12 = r14.mahsupGun()
            int r12 = 90 - r12
            int r13 = r0 + -1826
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x0688
        L_0x0291:
            if (r15 < r10) goto L_0x02b5
            if (r15 >= r11) goto L_0x02b5
            android.widget.RadioButton r13 = r14.oncesi2020
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x02a5
            android.widget.RadioButton r13 = r14.oncesi2016
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x02b5
        L_0x02a5:
            if (r0 >= r8) goto L_0x02b5
            android.widget.RadioButton r13 = r14.rbIkinciGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x02b5
            int r12 = r14.mahsupGun()
            goto L_0x00df
        L_0x02b5:
            if (r15 < r10) goto L_0x02e1
            if (r15 >= r11) goto L_0x02e1
            android.widget.RadioButton r13 = r14.oncesi2020
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x02c9
            android.widget.RadioButton r13 = r14.oncesi2016
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x02e1
        L_0x02c9:
            if (r0 < r8) goto L_0x02e1
            android.widget.RadioButton r13 = r14.rbIkinciGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x02e1
            int r12 = r14.mahsupGun()
            int r12 = 30 - r12
            int r13 = r0 + -1096
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x0688
        L_0x02e1:
            if (r15 < r11) goto L_0x0303
            android.widget.RadioButton r13 = r14.oncesi2020
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x02f3
            android.widget.RadioButton r13 = r14.oncesi2016
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x0303
        L_0x02f3:
            if (r0 >= r8) goto L_0x0303
            android.widget.RadioButton r13 = r14.rbIkinciGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x0303
            int r12 = r14.mahsupGun()
            goto L_0x012f
        L_0x0303:
            if (r15 < r11) goto L_0x032d
            android.widget.RadioButton r13 = r14.oncesi2020
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x0315
            android.widget.RadioButton r13 = r14.oncesi2016
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x032d
        L_0x0315:
            if (r0 < r8) goto L_0x032d
            android.widget.RadioButton r13 = r14.rbIkinciGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x032d
            int r12 = r14.mahsupGun()
            int r12 = 90 - r12
            int r13 = r0 + -1096
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x0688
        L_0x032d:
            if (r15 >= r11) goto L_0x034f
            android.widget.RadioButton r13 = r14.oncesi2020
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x033f
            android.widget.RadioButton r13 = r14.oncesi2016
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x034f
        L_0x033f:
            if (r0 >= r8) goto L_0x034f
            android.widget.RadioButton r13 = r14.rbIkinciGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x034f
            int r12 = r14.mahsupGun()
            goto L_0x00df
        L_0x034f:
            if (r15 < r11) goto L_0x0379
            android.widget.RadioButton r13 = r14.oncesi2020
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x0361
            android.widget.RadioButton r13 = r14.oncesi2016
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x0379
        L_0x0361:
            if (r0 < r8) goto L_0x0379
            android.widget.RadioButton r13 = r14.rbIkinciGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x0379
            int r12 = r14.mahsupGun()
            int r12 = 90 - r12
            int r13 = r0 + -1096
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x0688
        L_0x0379:
            if (r15 < r10) goto L_0x0395
            if (r15 >= r11) goto L_0x0395
            android.widget.RadioButton r13 = r14.sonrasi2020
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x0395
            if (r0 > r12) goto L_0x0395
            android.widget.RadioButton r13 = r14.rbDorduncuGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x0395
            int r12 = r14.mahsupGun()
            goto L_0x00df
        L_0x0395:
            if (r15 < r10) goto L_0x03b9
            if (r15 >= r11) goto L_0x03b9
            android.widget.RadioButton r13 = r14.sonrasi2020
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x03b9
            if (r0 <= r12) goto L_0x03b9
            android.widget.RadioButton r13 = r14.rbDorduncuGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x03b9
            int r12 = r14.mahsupGun()
            int r12 = 30 - r12
            int r13 = r0 + -2555
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x0688
        L_0x03b9:
            if (r15 < r11) goto L_0x03d3
            android.widget.RadioButton r13 = r14.sonrasi2020
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x03d3
            if (r0 > r12) goto L_0x03d3
            android.widget.RadioButton r13 = r14.rbDorduncuGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x03d3
            int r12 = r14.mahsupGun()
            goto L_0x012f
        L_0x03d3:
            if (r15 < r11) goto L_0x03f5
            android.widget.RadioButton r13 = r14.sonrasi2020
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x03f5
            if (r0 <= r12) goto L_0x03f5
            android.widget.RadioButton r13 = r14.rbDorduncuGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x03f5
            int r12 = r14.mahsupGun()
            int r12 = 90 - r12
            int r13 = r0 + -2555
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x0688
        L_0x03f5:
            if (r15 >= r11) goto L_0x040f
            android.widget.RadioButton r13 = r14.sonrasi2020
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x040f
            if (r0 > r12) goto L_0x040f
            android.widget.RadioButton r13 = r14.rbDorduncuGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x040f
            int r12 = r14.mahsupGun()
            goto L_0x00df
        L_0x040f:
            if (r15 < r11) goto L_0x0431
            android.widget.RadioButton r13 = r14.sonrasi2020
            boolean r13 = r13.isChecked()
            if (r13 == 0) goto L_0x0431
            if (r0 <= r12) goto L_0x0431
            android.widget.RadioButton r12 = r14.rbDorduncuGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0431
            int r12 = r14.mahsupGun()
            int r12 = 90 - r12
            int r13 = r0 + -2555
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x0688
        L_0x0431:
            if (r15 < r10) goto L_0x044d
            if (r15 >= r11) goto L_0x044d
            android.widget.RadioButton r12 = r14.sonrasi2020
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x044d
            if (r0 >= r10) goto L_0x044d
            android.widget.RadioButton r12 = r14.rbBirinciGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x044d
            int r12 = r14.mahsupGun()
            goto L_0x00df
        L_0x044d:
            if (r15 < r10) goto L_0x0471
            if (r15 >= r11) goto L_0x0471
            android.widget.RadioButton r12 = r14.sonrasi2020
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0471
            if (r0 < r10) goto L_0x0471
            android.widget.RadioButton r12 = r14.rbBirinciGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0471
            int r12 = r14.mahsupGun()
            int r12 = 30 - r12
            int r13 = r0 + -1826
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x0688
        L_0x0471:
            if (r15 < r11) goto L_0x048b
            android.widget.RadioButton r12 = r14.sonrasi2020
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x048b
            if (r0 >= r10) goto L_0x048b
            android.widget.RadioButton r12 = r14.rbBirinciGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x048b
            int r12 = r14.mahsupGun()
            goto L_0x012f
        L_0x048b:
            if (r15 < r11) goto L_0x04ad
            android.widget.RadioButton r12 = r14.sonrasi2020
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x04ad
            if (r0 < r10) goto L_0x04ad
            android.widget.RadioButton r12 = r14.rbBirinciGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x04ad
            int r12 = r14.mahsupGun()
            int r12 = 90 - r12
            int r13 = r0 + -1826
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x0688
        L_0x04ad:
            if (r15 >= r11) goto L_0x04c7
            android.widget.RadioButton r12 = r14.sonrasi2020
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x04c7
            if (r0 >= r10) goto L_0x04c7
            android.widget.RadioButton r12 = r14.rbBirinciGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x04c7
            int r12 = r14.mahsupGun()
            goto L_0x00df
        L_0x04c7:
            if (r15 < r11) goto L_0x04e9
            android.widget.RadioButton r12 = r14.sonrasi2020
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x04e9
            if (r0 < r10) goto L_0x04e9
            android.widget.RadioButton r12 = r14.rbBirinciGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x04e9
            int r12 = r14.mahsupGun()
            int r12 = 90 - r12
            int r13 = r0 + -1826
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x0688
        L_0x04e9:
            if (r15 < r10) goto L_0x0505
            if (r15 >= r11) goto L_0x0505
            android.widget.RadioButton r12 = r14.sonrasi2020
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0505
            if (r0 >= r8) goto L_0x0505
            android.widget.RadioButton r12 = r14.rbIkinciGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0505
            int r12 = r14.mahsupGun()
            goto L_0x00df
        L_0x0505:
            if (r15 < r10) goto L_0x0529
            if (r15 >= r11) goto L_0x0529
            android.widget.RadioButton r12 = r14.sonrasi2020
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0529
            if (r0 < r8) goto L_0x0529
            android.widget.RadioButton r12 = r14.rbIkinciGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0529
            int r12 = r14.mahsupGun()
            int r12 = 30 - r12
            int r13 = r0 + -1096
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x0688
        L_0x0529:
            if (r15 < r11) goto L_0x0543
            android.widget.RadioButton r12 = r14.sonrasi2020
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0543
            if (r0 >= r8) goto L_0x0543
            android.widget.RadioButton r12 = r14.rbIkinciGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0543
            int r12 = r14.mahsupGun()
            goto L_0x012f
        L_0x0543:
            if (r15 < r11) goto L_0x0565
            android.widget.RadioButton r12 = r14.sonrasi2020
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0565
            if (r0 < r8) goto L_0x0565
            android.widget.RadioButton r12 = r14.rbIkinciGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0565
            int r12 = r14.mahsupGun()
            int r12 = 90 - r12
            int r13 = r0 + -1096
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x0688
        L_0x0565:
            if (r15 >= r11) goto L_0x057f
            android.widget.RadioButton r12 = r14.sonrasi2020
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x057f
            if (r0 >= r8) goto L_0x057f
            android.widget.RadioButton r12 = r14.rbIkinciGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x057f
            int r12 = r14.mahsupGun()
            goto L_0x00df
        L_0x057f:
            if (r15 < r11) goto L_0x05a1
            android.widget.RadioButton r12 = r14.sonrasi2020
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x05a1
            if (r0 < r8) goto L_0x05a1
            android.widget.RadioButton r12 = r14.rbIkinciGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x05a1
            int r12 = r14.mahsupGun()
            int r12 = 90 - r12
            int r13 = r0 + -1096
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x0688
        L_0x05a1:
            android.widget.RadioButton r12 = r14.oncesi2016
            boolean r12 = r12.isChecked()
            r13 = 365(0x16d, float:5.11E-43)
            if (r12 != 0) goto L_0x05bb
            android.widget.RadioButton r12 = r14.oncesi2020
            boolean r12 = r12.isChecked()
            if (r12 != 0) goto L_0x05bb
            android.widget.RadioButton r12 = r14.sonrasi2020
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x05de
        L_0x05bb:
            if (r0 >= r13) goto L_0x05de
            android.widget.RadioButton r12 = r14.rbUcuncuGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x05de
            android.widget.RadioButton r12 = r14.rbEtkin_Hayir
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x05de
            int r12 = r14.m74kapaldan_ayrilma_genel_kural()
            int r13 = r15 / 3
            int r12 = java.lang.Math.max(r12, r13)
            int r13 = r14.mahsupGun()
        L_0x05db:
            int r12 = r12 - r13
            goto L_0x0688
        L_0x05de:
            android.widget.RadioButton r12 = r14.oncesi2016
            boolean r12 = r12.isChecked()
            if (r12 != 0) goto L_0x05f6
            android.widget.RadioButton r12 = r14.oncesi2020
            boolean r12 = r12.isChecked()
            if (r12 != 0) goto L_0x05f6
            android.widget.RadioButton r12 = r14.sonrasi2020
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0615
        L_0x05f6:
            if (r0 < r13) goto L_0x0615
            android.widget.RadioButton r12 = r14.rbUcuncuGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0615
            android.widget.RadioButton r12 = r14.rbEtkin_Hayir
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0615
            int r12 = r15 / 3
            int r13 = r0 + -364
            int r12 = java.lang.Math.max(r12, r13)
            int r13 = r14.mahsupGun()
            goto L_0x05db
        L_0x0615:
            android.widget.RadioButton r12 = r14.oncesi2016
            boolean r12 = r12.isChecked()
            r13 = 730(0x2da, float:1.023E-42)
            if (r12 != 0) goto L_0x062f
            android.widget.RadioButton r12 = r14.oncesi2020
            boolean r12 = r12.isChecked()
            if (r12 != 0) goto L_0x062f
            android.widget.RadioButton r12 = r14.sonrasi2020
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0650
        L_0x062f:
            if (r0 >= r13) goto L_0x0650
            android.widget.RadioButton r12 = r14.rbUcuncuGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0650
            android.widget.RadioButton r12 = r14.rbEtkin_Evet
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x0650
            int r12 = r14.m74kapaldan_ayrilma_genel_kural()
            int r13 = r15 / 3
            int r12 = java.lang.Math.max(r12, r13)
            int r13 = r14.mahsupGun()
            goto L_0x05db
        L_0x0650:
            android.widget.RadioButton r12 = r14.oncesi2016
            boolean r12 = r12.isChecked()
            if (r12 != 0) goto L_0x0668
            android.widget.RadioButton r12 = r14.oncesi2020
            boolean r12 = r12.isChecked()
            if (r12 != 0) goto L_0x0668
            android.widget.RadioButton r12 = r14.sonrasi2020
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x004a
        L_0x0668:
            if (r0 < r13) goto L_0x004a
            android.widget.RadioButton r12 = r14.rbUcuncuGrupSuc
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x004a
            android.widget.RadioButton r12 = r14.rbEtkin_Evet
            boolean r12 = r12.isChecked()
            if (r12 == 0) goto L_0x004a
            int r12 = r15 / 3
            int r13 = r0 + -729
            int r12 = java.lang.Math.max(r12, r13)
            int r13 = r14.mahsupGun()
            goto L_0x05db
        L_0x0688:
            android.widget.RadioButton r13 = r14.rbUcuncuGrupSuc
            boolean r13 = r13.isChecked()
            if (r13 != 0) goto L_0x06a8
            if (r15 >= r11) goto L_0x0698
            int r12 = r12 + -365
            int r12 = java.lang.Math.max(r9, r12)
        L_0x0698:
            if (r15 < r11) goto L_0x06a1
            int r12 = r12 + -365
            int r5 = java.lang.Math.max(r5, r12)
            r12 = r5
        L_0x06a1:
            java.io.PrintStream r5 = java.lang.System.out
            java.lang.String r9 = "7272 çalıştı"
            r5.println(r9)
        L_0x06a8:
            if (r15 > r8) goto L_0x06c2
            android.widget.RadioButton r5 = r14.rbKast
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x06c2
            android.widget.RadioButton r5 = r14.f183rbOrgutCinselHayr
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x06c2
            android.widget.RadioButton r5 = r14.rbUcuncuGrupSuc
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x06dc
        L_0x06c2:
            if (r15 > r10) goto L_0x06df
            android.widget.RadioButton r5 = r14.rbTaksir
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x06df
            android.widget.RadioButton r5 = r14.f183rbOrgutCinselHayr
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x06df
            android.widget.RadioButton r5 = r14.rbUcuncuGrupSuc
            boolean r5 = r5.isChecked()
            if (r5 != 0) goto L_0x06df
        L_0x06dc:
            r15 = 0
            goto L_0x074a
        L_0x06df:
            android.widget.RadioButton r5 = r14.rbAcigaAyrilmaEvet
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x06e9
            r15 = r0
            goto L_0x074a
        L_0x06e9:
            android.widget.RadioButton r0 = r14.rbIkinciTekerrur
            boolean r0 = r0.isChecked()
            if (r0 == 0) goto L_0x06f2
            goto L_0x074a
        L_0x06f2:
            if (r15 >= r10) goto L_0x070e
            android.widget.RadioButton r0 = r14.oncesi2016
            boolean r0 = r0.isChecked()
            if (r0 == 0) goto L_0x070e
            android.widget.TextView r0 = r14.tv_seciliSuc
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = r0.equalsIgnoreCase(r4)
            if (r0 == 0) goto L_0x070e
        L_0x070c:
            r15 = 3
            goto L_0x074a
        L_0x070e:
            if (r15 >= r10) goto L_0x0749
            android.widget.RadioButton r15 = r14.oncesi2016
            boolean r15 = r15.isChecked()
            if (r15 == 0) goto L_0x0749
            android.widget.TextView r15 = r14.tv_seciliSuc
            java.lang.CharSequence r15 = r15.getText()
            java.lang.String r15 = r15.toString()
            boolean r15 = r15.equalsIgnoreCase(r3)
            if (r15 != 0) goto L_0x070c
            android.widget.TextView r15 = r14.tv_seciliSuc
            java.lang.CharSequence r15 = r15.getText()
            java.lang.String r15 = r15.toString()
            boolean r15 = r15.equalsIgnoreCase(r2)
            if (r15 != 0) goto L_0x070c
            android.widget.TextView r15 = r14.tv_seciliSuc
            java.lang.CharSequence r15 = r15.getText()
            java.lang.String r15 = r15.toString()
            boolean r15 = r15.equalsIgnoreCase(r1)
            if (r15 == 0) goto L_0x0749
            goto L_0x070c
        L_0x0749:
            r15 = r12
        L_0x074a:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.infaz_hesaplama.InfazHesaplama.C0520infaz_hesaplama.kapalidaki_gun_sayisi(int):int");
    }

    public void gorunurluk() {
        this.rbMahsupEvet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    C0520infaz_hesaplama.this.mahsupGun.setVisibility(0);
                } else {
                    C0520infaz_hesaplama.this.mahsupGun.setVisibility(8);
                }
            }
        });
        this.oncesi2016.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    C0520infaz_hesaplama.this.grup2020.setVisibility(8);
                    C0520infaz_hesaplama.this.oncesi2020.setChecked(true);
                    return;
                }
                C0520infaz_hesaplama.this.grup2020.setVisibility(0);
            }
        });
        this.sonrasi2020.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    C0520infaz_hesaplama.this.grup2016.setVisibility(8);
                } else {
                    C0520infaz_hesaplama.this.grup2016.setVisibility(0);
                }
            }
        });
        this.rbTekerrurEvet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    C0520infaz_hesaplama.this.gridTekerrur.setVisibility(0);
                } else {
                    C0520infaz_hesaplama.this.gridTekerrur.setVisibility(8);
                }
            }
        });
        this.rbBirinciTekerrur.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    C0520infaz_hesaplama.this.etTekerrurSure.setVisibility(0);
                } else {
                    C0520infaz_hesaplama.this.etTekerrurSure.setVisibility(8);
                }
            }
        });
        this.rbUcuncuGrupSuc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    C0520infaz_hesaplama.this.layout_Etkin_Pismanlik.setVisibility(0);
                } else {
                    C0520infaz_hesaplama.this.layout_Etkin_Pismanlik.setVisibility(8);
                }
            }
        });
        this.rb_tahliye_tarihi_evet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    C0520infaz_hesaplama.this.layout_tahliye_tarihi.setVisibility(0);
                } else {
                    C0520infaz_hesaplama.this.layout_tahliye_tarihi.setVisibility(8);
                }
            }
        });
        this.sonrasi2020.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    C0520infaz_hesaplama.this.LinLayout_YaslilikCocukDurumu.setVisibility(8);
                    C0520infaz_hesaplama.this.rg_YaslilikCocuk.setVisibility(8);
                    return;
                }
                C0520infaz_hesaplama.this.LinLayout_YaslilikCocukDurumu.setVisibility(0);
                C0520infaz_hesaplama.this.rg_YaslilikCocuk.setVisibility(0);
            }
        });
    }

    public void sayac() {
        SharedPreferences sharedPreferences = getSharedPreferences("GirisSayac", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        int i = sharedPreferences.getInt("sayac", 0) + 1;
        edit.putInt("sayac", i);
        edit.commit();
        Log.i("Info", "Sayaç: " + i);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.US);
        if (i == 1) {
            Date date = new Date(System.currentTimeMillis());
            edit.putLong("ilkTarih", date.getTime());
            edit.commit();
            Log.i("Info", "İlk kullanım tarihi (kayıt aşaması):  " + simpleDateFormat.format(date));
        }
        Date date2 = new Date(sharedPreferences.getLong("ilkTarih", 0));
        Log.i("Info", "İlk kullanım tarihi (geri çağırma): " + simpleDateFormat.format(date2));
        Date date3 = new Date(System.currentTimeMillis());
        Log.i("Info", "Son kullanım tarihi: " + simpleDateFormat.format(date3));
        long days = (long) Days.daysBetween((ReadableInstant) new DateTime((Object) date2), (ReadableInstant) new DateTime((Object) date3)).getDays();
        Log.i("Info", "İlk - son kullanım tarihi farkı: " + days);
        if (days > 7) {
            edit.putInt("sayac", 1);
            edit.commit();
            edit.putLong("ilkTarih", new Date(System.currentTimeMillis()).getTime());
            edit.commit();
            i = sharedPreferences.getInt("sayac", 0);
            Log.i("Info", "Gün farki 7 günden fazla olduğundan sayaç (1) ve gün farkı sıfırlandı!");
            Log.i("Info", "Sayaç: " + i);
            Log.i("Info", "Gün farki: " + 0);
            days = 0;
        }
        if (days > 7 || i > 3) {
            Log.i("Info", "Uygulama ödüllü reklamla çalışsın!");
            this.videoReklamGosterilsinMi = "Evet";
            return;
        }
        Log.i("Info", "Uygulama ödüllü reklam olmadan çalışsın!");
    }
}
