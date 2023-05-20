package mobile.android.partthree.base

import androidx.appcompat.app.AppCompatActivity
import mobile.android.partthree.viewmodels.AppViewModelFactory
import org.kodein.di.DIAware
import org.kodein.di.android.di
import org.kodein.di.instance

abstract class BaseActivity: AppCompatActivity(), DIAware {

    override val di by di()

    protected val factory : AppViewModelFactory by instance<AppViewModelFactory>()

}