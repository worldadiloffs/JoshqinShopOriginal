package uz.itschool.joshqinshoporiginal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.itschool.joshqinshoporiginal.ui.SplashFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.main, SplashFragment()).commit()
    }
}