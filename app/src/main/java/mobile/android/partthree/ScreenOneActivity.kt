package mobile.android.partthree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import mobile.android.partthree.`interface`.ScreenOneListener
import mobile.android.partthree.adapter.ContactAdapter
import mobile.android.partthree.base.BaseActivity
import mobile.android.partthree.databinding.ActivityScreenOneBinding
import mobile.android.partthree.model.DataResponseItem
import mobile.android.partthree.utils.Common
import mobile.android.partthree.utils.Coroutines
import mobile.android.partthree.viewmodels.ScreenOneViewModel
import org.kodein.di.DIAware
import org.kodein.di.android.di
import timber.log.Timber

class ScreenOneActivity : BaseActivity(), ScreenOneListener {

    private lateinit var binding : ActivityScreenOneBinding

    private val viewModel : ScreenOneViewModel by viewModels<ScreenOneViewModel> { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreenOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.listener = this
        viewModel.getListContact()

//        val test = Common.inputStreamToString(resources.openRawResource(R.raw.data))

//        binding.textTest.text = test



        binding.swipeRef.setOnRefreshListener {
            Coroutines.delayMain(2000, work = {
                binding.swipeRef.isRefreshing = false
                Toast.makeText(this, "Reloaded!", Toast.LENGTH_SHORT).show()
            })
        }

    }

    override fun onSuccess(list: List<DataResponseItem>) {

        Timber.d("Isi ${list.toString()}")
        val adapter = ContactAdapter(this, list)
        binding.recyclerview.adapter = adapter
    }
}