package com.mobven.moviesapplication.splashactivity

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.RequestManager
import com.mobven.moviesapplication.R
import com.mobven.moviesapplication.constants.Constants
import com.mobven.moviesapplication.util.SharedPreferencesUtil.SharedPreferencesModule
import com.mobven.moviesapplication.util.intentutil.IntentModule
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity : AppCompatActivity(), SplashActivityContract.View {

    @BindView(R.id.logoIV)
    lateinit var dateTimeTV: ImageView

    @Inject
    lateinit var mPresenter: SplashActivityPresenter

    @Inject
    lateinit var mRequestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        DaggerSplashActivityComponent.builder()
            .intentModule(IntentModule(activity = this))
            .sharedPreferencesModule(SharedPreferencesModule(this, Constants.API_PREF_NAME, Constants.API_PREF_LABEL))
            .splashActivityModule(SplashActivityModule(this))
            .build().inject(this)

        this.mPresenter.setView(this)
        this.mPresenter.initializeSplashScreen()
        this.mPresenter.login()
    }

    override fun initViews() {
        ButterKnife.bind(this)

        mRequestManager
            .load(R.drawable.mobven)
            .error(R.drawable.error_drawable)
            .into(logoIV)
    }

    override fun showToastMessage(message: String, duration: Int) {
        Toast.makeText(this, message, duration).show()
    }

    override fun finishActivity() {
        this.finish()
    }
}