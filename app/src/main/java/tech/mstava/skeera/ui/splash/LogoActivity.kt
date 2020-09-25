package tech.mstava.skeera.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import tech.mstava.skeera.R
import tech.mstava.skeera.ui.auth.LoginActivity

class LogoActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)

        Handler().postDelayed(
            {
                val intent = Intent(this@LogoActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }, SPLASH_TIME_OUT)
    }
}