package com.pp.sdk.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pp.sdk.AppStoreManager;
import com.pp.sdk.UiTarget;
import com.pp.sdk.UpdatableAppListener;

/**
 * @author hengxing.lhx
 * @date 2017/08/11
 */
public class MainActivity extends Activity implements UpdatableAppListener, View.OnClickListener {
    private static final String TAG = "MainActivity";

    private static final String MY_SECRET = "MTA6QkJVTFpXMTNKRGtMSnpBL01ERTVPM2RtWkdWdA==09a7";

    private AppStoreManager mManager;

    private void initSDK() {
        mManager = AppStoreManager.getInstance(this, MY_SECRET);
        mManager.enableNotification(R.drawable.notification_icon);
        mManager.addUpdatableAppChangedListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSDK();

        findViewById(R.id.page_home).setOnClickListener(this);
        findViewById(R.id.download).setOnClickListener(this);
        findViewById(R.id.update).setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mManager.removeUpdatableAppListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.page_home:
                mManager.startUi(UiTarget.HOME);
                break;
            case R.id.download:
                mManager.startDownloadUi(true);
                break;
            case R.id.update:
                mManager.startUi(UiTarget.UPDATE);
                break;
            default:
                break;
        }
    }

    @Override
    public void onUpdatableAppCountChanged(int count) {
        Button btn = (Button) findViewById(R.id.update);
        btn.setText("有" + count + "个应用可更新");
    }
}
