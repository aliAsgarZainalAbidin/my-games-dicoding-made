package id.deval.mygames

import android.content.Context
import android.util.Log
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import id.deval.mygames.MainFragment.Companion.TAG

object Utils {

    fun installFavoriteFeature(context : Context, callback : () -> Unit){
        val splitInstallManager = SplitInstallManagerFactory.create(context)
        val moduleFavorite = "favorite"
        if (splitInstallManager.installedModules.contains(moduleFavorite)){
            Log.d(TAG, "Favorite module already installed")
            callback()
            return
        } else {
            val splitInstallRequest = SplitInstallRequest.newBuilder()
                .addModule(moduleFavorite)
                .build()

            splitInstallManager.startInstall(splitInstallRequest)
                .addOnSuccessListener {
                    Log.d(TAG, "Success installing module")
                    callback()
                }
                .addOnFailureListener {
                    Log.d(TAG, "Error installing module")
                }
        }
    }
}