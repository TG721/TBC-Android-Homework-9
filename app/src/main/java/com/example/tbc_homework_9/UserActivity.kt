package com.example.tbc_homework_9

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tbc_homework_9.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val saveButton = binding.saveButton
        saveButton.setOnClickListener {
            val first_name = binding.editTextFirstName.text.toString()
            val last_name = binding.editTextLastName.text.toString()
            val email = binding.editTextEmail.text.toString()
            val user = User(first_name, last_name, email)
            Intent(this, UsersActivity::class.java).also {
                it.putExtra("first_name", first_name)
                it.putExtra("last_name", last_name)
                it.putExtra("email", email)
                startActivity(it)

            }
        }
    }
}