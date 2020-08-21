package com.maulik.togadiya.view.home

import android.app.AlertDialog
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.observe
import com.maulik.togadiya.R
import com.maulik.togadiya.base.BaseActivity
import com.maulik.togadiya.databinding.ActivityHomeBinding
import com.maulik.togadiya.extension.navigateToAndFinish
import com.maulik.togadiya.model.AlbumData
import com.maulik.togadiya.utils.IAdapterOnClick
import com.maulik.togadiya.view.home.adapter.AlbumAdapter
import com.maulik.togadiya.view.login.LoginActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeActivity :
    BaseActivity<ActivityHomeBinding, HomeActivityState, HomeActivityViewModel>(R.layout.activity_home),
    IAdapterOnClick {

    override val viewModel: HomeActivityViewModel by viewModel()
    var listAdapter: AlbumAdapter = AlbumAdapter(this)
    private var listData: ArrayList<AlbumData>? = null

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        when (id) {
            R.id.logout -> {
                openAlertForLogout()
            }
        }
        return true
    }

    private fun openAlertForLogout() {
        val builder = AlertDialog.Builder(this)
        //set title for alert dialog
        builder.setMessage(getString(R.string.logout_msg))
        //performing positive action
        builder.setPositiveButton(getString(R.string.yes)) { dialogInterface, which ->
            defaultPref.data.isLoggedIn = false
            defaultPref.store()
            navigateToAndFinish<LoginActivity>()
        }
        //performing negative action
        builder.setNegativeButton(getString(R.string.no)) { dialogInterface, which ->
            dialogInterface.dismiss()
        }
        // Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()
        // Set other dialog properties
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    override fun observeViewStat(state: HomeActivityState) {
        reyData.adapter = listAdapter
        state.albumAPIState.observe(this) {
            when (it) {
                is HomeActivityState.AlbumResponse.Loading -> {
                    state.isLoading.value = true
                }

                is HomeActivityState.AlbumResponse.Success -> {
                    state.isLoading.value = false
                    it.data.let {
                        listData = it
                        listData?.let { data ->
                            listAdapter.setList(data)
                        }
                    }
                }

                is HomeActivityState.AlbumResponse.Failure -> {
                    state.isLoading.value = false
                    toast(it.throwable.localizedMessage)
                }
            }
        }
    }

    override fun onClick(view: View?, item: Any, position: Int) {

    }
}