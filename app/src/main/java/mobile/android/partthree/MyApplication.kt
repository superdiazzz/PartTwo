package mobile.android.partthree

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule
import timber.log.Timber

class MyApplication : MultiDexApplication(), DIAware{

    override val di by DI.lazy {
        import(androidXModule(this@MyApplication))
    }

    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun onCreate() {
        super.onCreate()

        // Init Timber Log
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}