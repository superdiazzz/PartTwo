package mobile.android.partthree

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import mobile.android.partthree.repositories.DataRepository
import mobile.android.partthree.viewmodels.AppViewModelFactory
import org.kodein.di.*
import org.kodein.di.android.x.androidXModule
import timber.log.Timber

class MyApplication : MultiDexApplication(), DIAware{

    override val di by DI.lazy {
        import(androidXModule(this@MyApplication))

        bind() from singleton { AppViewModelFactory(instance(), instance()) }
        bind() from singleton { DataRepository.getInstance(instance()) }
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