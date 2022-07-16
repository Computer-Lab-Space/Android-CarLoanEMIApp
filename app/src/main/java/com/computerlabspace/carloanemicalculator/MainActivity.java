package com.computerlabspace.carloanemicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.computerlabspace.emiloancaluculatorserver.EMIAidlInterface;

import java.text.DecimalFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText principalAmnt, interestRate, downPayment, tenure;
    TextView emiResult;
    Button calculateEmiBtn;
    EMIAidlInterface emiAidlInterface;
    DecimalFormat formatter = new DecimalFormat("#0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        principalAmnt = findViewById(R.id.principal_amnt_input_id);
        interestRate = findViewById(R.id.interest_rate_input_id);
        downPayment = findViewById(R.id.down_payment_input_id);
        tenure = findViewById(R.id.loan_term_input_id);
        emiResult = findViewById(R.id.emi_result_placeholder_id);
        calculateEmiBtn = findViewById(R.id.calculate_emi_btn_id);
        calculateEmiBtn.setOnClickListener(this);
        if(emiAidlInterface == null) {
            Intent intentService = new Intent("emiloanservice");
            intentService.setPackage("com.computerlabspace.emiloancaluculatorserver");
            Intent explicitIntent = convertImplicitIntentToExplicitIntent(intentService, this);
            bindService(explicitIntent, serviceConnection, Context.BIND_AUTO_CREATE);
        }
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            emiAidlInterface = EMIAidlInterface.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    public void onClick(View view) {
        long p = Long.parseLong(principalAmnt.getText().toString());
        long d = Long.parseLong(downPayment.getText().toString());
        float r = Float.parseFloat(interestRate.getText().toString());
        int n = Integer.parseInt(tenure.getText().toString());
        try {
            double emi = emiAidlInterface.calculateEMI(p, d, r, n);
            emiResult.setText(formatter.format(emi));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static Intent convertImplicitIntentToExplicitIntent(Intent implicitIntent, Context context) {
        PackageManager pm = context.getPackageManager();
        // List<PackageInfo> packageInfos = pm.getInstalledPackages(0);
        List<ResolveInfo> resolveInfoList = pm.queryIntentServices(implicitIntent, 0);
        if(resolveInfoList == null || resolveInfoList.isEmpty()) {
            return null;
        }
        ResolveInfo serviceInfo = resolveInfoList.get(0);
        ComponentName componentName = new ComponentName(serviceInfo.serviceInfo.packageName, serviceInfo.serviceInfo.name);
        Intent explicitIntent = new Intent(implicitIntent);
        explicitIntent.setComponent(componentName);
        return explicitIntent;
    }
}