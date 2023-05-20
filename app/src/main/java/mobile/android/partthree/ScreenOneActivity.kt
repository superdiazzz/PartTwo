package mobile.android.partthree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import mobile.android.partthree.base.BaseActivity
import mobile.android.partthree.databinding.ActivityScreenOneBinding
import mobile.android.partthree.utils.Common
import mobile.android.partthree.viewmodels.ScreenOneViewModel
import org.kodein.di.DIAware
import org.kodein.di.android.di

class ScreenOneActivity : BaseActivity() {

    private lateinit var binding : ActivityScreenOneBinding

    private val viewModel : ScreenOneViewModel by viewModels<ScreenOneViewModel> { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreenOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val test = Common.inputStreamToString(resources.openRawResource(R.raw.data))

        binding.textTest.text = test



    }
}