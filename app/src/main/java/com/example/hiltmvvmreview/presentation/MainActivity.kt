package com.example.hiltmvvmreview.presentation


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hiltmvvmreview.databinding.ActivityMainBinding
import com.example.hiltmvvmreview.domain.models.SaveUserName
import com.example.hiltmvvmreview.models.UserName

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    private val userStorage by lazy(LazyThreadSafetyMode.NONE){
        com.example.hiltmvvmreview.data.storage.SharedPrefs.SharedPrefUserStorage(
            context = applicationContext
        )
    }

    private val userRepository by lazy(LazyThreadSafetyMode.NONE){
        com.example.hiltmvvmreview.data.repository.UserRepositoryImpl(
            userStorage = userStorage
        )
    }
    private val saveUserNameUseCase  by lazy(LazyThreadSafetyMode.NONE){
        com.example.hiltmvvmreview.domain.usecase.SaveUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val getUserNameUseCase  by lazy(LazyThreadSafetyMode.NONE){
        com.example.hiltmvvmreview.domain.usecase.GetUserNameUseCase(
            userRepository = userRepository
        )
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btReceiveData.setOnClickListener{
                val userName: UserName = getUserNameUseCase.execute()
                dataTextView.text = "${userName.firstName} ${userName.lastName}"

            }

            btSendData.setOnClickListener {
                val text = dataEditText.text.toString()
                val params = SaveUserName(name = text)
                val result: Boolean = saveUserNameUseCase.execute(param = params)
                dataTextView.text = "Save result = $result"
            }

        }
    }






}