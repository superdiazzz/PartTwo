package mobile.android.partthree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import mobile.android.partthree.`interface`.ScreenTwoListener
import mobile.android.partthree.base.BaseActivity
import mobile.android.partthree.databinding.ActivityScreenTwoBinding
import mobile.android.partthree.model.DataResponseItem
import mobile.android.partthree.viewmodels.ScreenTwoViewModel

class ScreenTwoActivity : BaseActivity(), ScreenTwoListener {

    companion object{

        const val EXTRA_ID = "extra_id"
    }

    private lateinit var binding : ActivityScreenTwoBinding

    private val viewmodel : ScreenTwoViewModel by viewModels<ScreenTwoViewModel> { factory }

    private val id : String? by lazy { intent.getStringExtra(EXTRA_ID) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreenTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewmodel.listener = this
        id?.let { viewmodel.getDetail(it) }
    }

    override fun onSuccess(detail: DataResponseItem) {

        binding.editName.setText(detail.firstName)
        binding.editLast.setText(detail.lastName)
        binding.editEmail.setText(detail.email)
        binding.editDob.setText(detail.dob)
    }
}