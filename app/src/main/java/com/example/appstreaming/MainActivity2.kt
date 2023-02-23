package com.example.appstreaming



import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appstreaming.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    @SuppressLint("UseCompatLoadingForDrawables", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)



        //cambiar icono y texto de color al pulsar el boton con focus
        binding.home.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.home.icon.setTint(Color.parseColor("#f37521"))
                binding.home.setTextColor(Color.parseColor("#f37521"))
            } else {
                binding.home.setIconResource(R.drawable.ic_bottom_navigation_home)
                binding.home.setTextColor(Color.parseColor("#ffffff"))
            }
        }

        binding.watchlist.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.watchlist.icon.setTint(Color.parseColor("#f37521"))
                binding.watchlist.setTextColor(Color.parseColor("#f37521"))
            } else {
                binding.watchlist.setIconResource(R.drawable.ic_bottom_navigation_watchlist)
                binding.watchlist.setTextColor(Color.parseColor("#ffffff"))
            }
        }

        binding.browse.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.browse.icon.setTint(Color.parseColor("#f37521"))
                binding.browse.setTextColor(Color.parseColor("#f37521"))
            } else {
                binding.browse.icon = getDrawable(R.drawable.ic_bottom_navigation_browse)
                binding.browse.setTextColor(Color.parseColor("#ffffff"))
            }
        }

        binding.simulcast.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.simulcast.icon.setTint(Color.parseColor("#f37521"))
                binding.simulcast.setTextColor(Color.parseColor("#f37521"))
            } else {
                binding.simulcast.icon = getDrawable(R.drawable.ic_bottom_navigation_simulcast)
                binding.simulcast.setTextColor(Color.parseColor("#ffffff"))
            }
        }

        binding.settings.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.settings.icon.setTint(Color.parseColor("#f37521"))
                binding.settings.setTextColor(Color.parseColor("#f37521"))
            } else {
                binding.settings.icon = getDrawable(R.drawable.ic_bottom_navigation_settings)
                binding.settings.setTextColor(Color.parseColor("#ffffff"))
            }
        }


    }
}
