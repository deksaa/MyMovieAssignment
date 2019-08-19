package com.mobven.moviesapplication.activity.splashactivity

import android.util.Log
import android.widget.Toast
import com.mobven.moviesapplication.service.ResponseCallback
import com.mobven.moviesapplication.constants.Constants
import com.mobven.moviesapplication.constants.ErrorMessages
import com.mobven.moviesapplication.activity.mainactivity.MainActivity
import com.mobven.moviesapplication.model.LoginCredentialModel
import com.mobven.moviesapplication.model.Token
import com.mobven.moviesapplication.repository.LoginRepository
import com.mobven.moviesapplication.response.LoginResponse
import com.mobven.moviesapplication.response.RequestTokenResponse
import com.mobven.moviesapplication.response.SessionResponse
import com.mobven.moviesapplication.util.SharedPreferencesUtil.SharedPreferencesHelper
import com.mobven.moviesapplication.util.handlerutil.HandlerCallback
import com.mobven.moviesapplication.util.handlerutil.HandlerManager
import com.mobven.moviesapplication.util.intentutil.IntentHelper
import retrofit2.Call
import javax.inject.Inject

class SplashActivityPresenter @Inject constructor() : SplashActivityContract.Presenter {

    private lateinit var mView: SplashActivityContract.View

    @Inject
    lateinit var mHandlerManager: HandlerManager

    @Inject
    lateinit var mIntentHelper: IntentHelper

    @Inject
    lateinit var mLoginRepository: LoginRepository

    @Inject
    lateinit var mSharedPreferencesHelper: SharedPreferencesHelper

    private var mHandlerCallBack = object : HandlerCallback{
        override fun onCompleted() {
            mIntentHelper.openActivity(MainActivity::class.java)
            mView.finishActivity()
        }
    }

    override fun setView(view: SplashActivityContract.View) {
        mView = view
    }

    override fun initializeSplashScreen() {
        mView.initViews()
    }

    override fun requestToken() {
        mLoginRepository.getRequestToken(Constants.API_KEY, requestTokenCallback)
    }

    override fun createSession() {
        mLoginRepository.createSession(Constants.API_KEY, Token(mSharedPreferencesHelper.loadPreferences(Constants.API_PREF_REQUEST_TOKEN)), createSessionCallback)
    }

    override fun login() {
        mLoginRepository.login(Constants.API_KEY, LoginCredentialModel(Constants.API_USERNAME, Constants.API_PASSWORD, mSharedPreferencesHelper.loadPreferences(Constants.API_PREF_REQUEST_TOKEN)!!), loginCallback)
    }

    private var requestTokenCallback = object: ResponseCallback<RequestTokenResponse>{
        override fun onSuccess(call: Call<RequestTokenResponse>, response: RequestTokenResponse) {
            if (response.success!!)
            {
                Log.d(this@SplashActivityPresenter.javaClass.simpleName, String.format("Request_Token ->>> %s", response.requestToken))
                mSharedPreferencesHelper.savePreferences(Constants.API_PREF_REQUEST_TOKEN, response.requestToken)
                login()
            }
            else
            {
                mView.showToastMessage(ErrorMessages.GENERAL_ERROR, Toast.LENGTH_LONG)
                mView.finishActivity()
            }
        }

        override fun onFailure(call: Call<RequestTokenResponse>, t: Throwable) {
            Log.e(this@SplashActivityPresenter.javaClass.simpleName, t.localizedMessage!!)
            mView.showToastMessage(ErrorMessages.GENERAL_ERROR, Toast.LENGTH_LONG)
            mView.finishActivity()
        }
    }

    private var loginCallback = object : ResponseCallback<LoginResponse>{
        override fun onSuccess(call: Call<LoginResponse>, response: LoginResponse) {
            if (response.success!!)
            {
                Log.d(this@SplashActivityPresenter.javaClass.simpleName, String.format("Request_Token ->>> %s", response.requestToken))
                mSharedPreferencesHelper.savePreferences(Constants.API_PREF_REQUEST_TOKEN, response.requestToken)
                createSession()
            }
            else
            {
                mView.showToastMessage(ErrorMessages.GENERAL_ERROR, Toast.LENGTH_LONG)
                mView.finishActivity()
            }
        }

        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
            Log.e(this@SplashActivityPresenter.javaClass.simpleName, t.localizedMessage!!)
            mView.showToastMessage(ErrorMessages.GENERAL_ERROR, Toast.LENGTH_LONG)
            mView.finishActivity()
        }
    }

    private var createSessionCallback = object: ResponseCallback<SessionResponse>{
        override fun onSuccess(call: Call<SessionResponse>, response: SessionResponse) {
            if (response.success!!)
            {
                Log.d(this@SplashActivityPresenter.javaClass.simpleName, String.format("Session_ID ->>> %s", response.sessionId))
                mSharedPreferencesHelper.savePreferences(Constants.API_PREF_SESSION_ID, response.sessionId)
                mHandlerManager.providePostDelayedHandler(mHandlerCallBack)
            }
            else
            {
                mView.showToastMessage(ErrorMessages.GENERAL_ERROR, Toast.LENGTH_LONG)
                mView.finishActivity()
            }
        }

        override fun onFailure(call: Call<SessionResponse>, t: Throwable) {
            Log.e(this@SplashActivityPresenter.javaClass.simpleName, t.localizedMessage!!)
            mView.showToastMessage(ErrorMessages.GENERAL_ERROR, Toast.LENGTH_LONG)
            mView.finishActivity()
        }
    }

}