package id.tadi.visithumbang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import id.tadi.visithumbang.databinding.ActivityMainBinding
import id.tadi.visithumbang.events.fragments.EventsFragment
import androidx.fragment.app.FragmentTransaction
import id.tadi.visithumbang.accommodations.fragments.AccomodationsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setupView()
        supportActionBar?.hide()
        setContentView(binding.root)
    }

    private fun setupView(){
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.news -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, EventsFragment()).commit()
                    true
                }
                R.id.destinations -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, AccomodationsFragment()).commit()
                    true
                }
                R.id.events -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, EventsFragment()).commit()
                    true
                }
                R.id.accomodations -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, AccomodationsFragment()).commit()
                    true
                }
                else -> {
                    true
                }
            }
        }
        binding.bottomNavigation.selectedItemId = R.id.news

    }

}