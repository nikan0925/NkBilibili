package com.nk.nkbilibili;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import butterknife.ButterKnife;
import com.nk.nkbilibili.api.ApiClient;
import com.nk.nkbilibili.api.entity.LiveAppIndexBean;
import com.nk.nkbilibili.ui.activity.ToolbarActivity;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setDoubleClickToExitEnabled(false);
        setDisplayShowTitleEnabled(false);

        ApiClient.liveApiService
            .getLiveAppIndex()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<LiveAppIndexBean>() {
                @Override public void call(LiveAppIndexBean liveAppIndexBean) {
                    Log.d("nikan", liveAppIndexBean.getMessage());
                }
            }, new Action1<Throwable>() {
                @Override public void call(Throwable throwable) {
                    Log.d("nikan", throwable.toString());
                }
            });

    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
