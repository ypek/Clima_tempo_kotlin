import android.R
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.MainActivity



class HomeActivity : AppCompatActivity() {
    private var cityEditText: EditText? = null
    private var searchButton: Button? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
super.onCreate(savedInstanceState, persistentState)
        setContentView(com.example.weatherapp.R.layout.activity_home)
        cityEditText = findViewById(com.example.weatherapp.R.id.et_city)
        searchButton = findViewById(com.example.weatherapp.R.id.btn_search)

        searchButton?.setOnClickListener(View.OnClickListener {
            val city = cityEditText?.text.toString()
            if (city == "") {
                Toast.makeText(this@HomeActivity, "Please enter a city name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@HomeActivity, MainActivity::class.java)
                intent.putExtra("city", city)
                startActivity(intent)
            }
        })
    }
}