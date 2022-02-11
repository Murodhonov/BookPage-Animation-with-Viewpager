package uz.umarxon.bookpageanimationviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.umarxon.bookpageanimationviewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewPager
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(BlankFragment.newInstance("second",""), "ONE")
        adapter.addFragment(BlankFragment(), "TWO")
        adapter.addFragment(BlankFragment.newInstance("second",""), "ONE")
        adapter.addFragment(BlankFragment(), "TWO")
        adapter.addFragment(BlankFragment.newInstance("second",""), "ONE")
        adapter.addFragment(BlankFragment(), "THREE")
        viewPager.adapter = adapter

        val bookFlipPageTransformer = BookFlipPageTransformer()

        bookFlipPageTransformer.isEnableScale = true

        bookFlipPageTransformer.scaleAmountPercent = 10f

        viewPager.setPageTransformer(true, bookFlipPageTransformer)

    }
}