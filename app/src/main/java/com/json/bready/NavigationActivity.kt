package com.json.bready

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.add
import androidx.fragment.app.replace
import com.json.bready.databinding.ActivityNavigationBinding

class NavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)


        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<HomeFragment>(R.id.navigation_fragment)
        }

        binding.bottomNavigation.selectedItemId = R.id.home
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<HomeFragment>(R.id.navigation_fragment)
                    }
                    true
                }

                R.id.recipes -> {
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<RecipesFragment>(R.id.navigation_fragment)
                    }
                    true
                }

                R.id.profile -> {
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<ProfileFragment>(R.id.navigation_fragment)
                    }
                    true
                }

                else -> false
            }
        }

    }

}