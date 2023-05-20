package mobile.android.partthree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mobile.android.partthree.base.BaseActivity
import mobile.android.partthree.databinding.ActivityScreenTwoBinding

class ScreenTwoActivity : BaseActivity() {

    private lateinit var binding : ActivityScreenTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreenTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}