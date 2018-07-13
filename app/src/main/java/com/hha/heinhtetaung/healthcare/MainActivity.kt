package com.hha.heinhtetaung.healthcare

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.hha.heinhtetaung.healthcare.adapters.HealthCareAdapter
import com.hha.heinhtetaung.healthcare.data.models.HealthCareModel
import com.hha.heinhtetaung.healthcare.data.vo.HealthCareVO
import com.hha.heinhtetaung.healthcare.mvp.presenters.HealthCarePresenter
import com.hha.heinhtetaung.healthcare.mvp.views.HealthCareView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HealthCareView {


    private lateinit var mPresenter: HealthCarePresenter
    private lateinit var mHealthAdapter: HealthCareAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        mPresenter = ViewModelProviders.of(this).get(HealthCarePresenter::class.java)
        mPresenter.initPresenter(this)



        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        mHealthAdapter = HealthCareAdapter(applicationContext, mPresenter)
        rvHealthcare.adapter = mHealthAdapter
        rvHealthcare.layoutManager = LinearLayoutManager(applicationContext)

        mPresenter.getHealthcareLD().observe(this, Observer<List<HealthCareVO>> { healthcareList ->
            displaytHealthcareList(healthcareList!!)
        })


    }

    fun displaytHealthcareList(healthcareList: List<HealthCareVO>) {
        mHealthAdapter.appendNewData(healthcareList)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun launchHealthcare(url: String) {
        var builder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
        var customtabIntent: CustomTabsIntent = builder.build()
        customtabIntent.launchUrl(applicationContext, Uri.parse(url))
    }


}
