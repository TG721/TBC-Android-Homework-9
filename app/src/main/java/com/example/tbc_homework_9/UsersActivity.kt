package com.example.tbc_homework_9

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tbc_homework_9.databinding.ActivityUserBinding
import com.example.tbc_homework_9.databinding.ActivityUsersBinding


class UsersActivity : AppCompatActivity() {

    lateinit var saveData: ArrayList<String>

    private lateinit var binding: ActivityUsersBinding
    var userList = mutableListOf(
        User("Nika", "Tabatadze", "nikatabatadze9@gmail.com"),
        User("Luka", "Parchukidze", "parchukidze.luka@gmail.com"),
        User("Tengiz", "Gachechilzde", "tengiz152@gmail.com"),
        User("Giorgi", "Gabidauri", "giorgi.gabidauri16@gmail.com"),
        User("Luka", "Jangava", "luka.janjgava.1@btu.edu.ge"),
        User("Lika", "khokhiashvili", "lika.khokhiashvili.1@btu.edu.ge"),
        User("Baia", "Asanidze", "baiaasanidze@gmail.com"),
        User("Mariam", "Eristavi", "mariami.eristavi.1@btu.edu.ge"),
        User("Davit", "Tsiskarashvili", "datotsiskarashvili@gmail.com")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter = UserAdapter(userList)
        val recyclerView = binding.mainRecyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        val addButton = binding.addButton
        addButton.setOnClickListener {
            Intent(this, UserActivity::class.java).also {
                startActivity(it)

            }

        }

        var recievedFirstName: String? = intent.getStringExtra("first_name")
        var recievedlastName: String? = intent.getStringExtra("last_name")
        var recievedEmail: String? = intent.getStringExtra("email")

        if (recievedFirstName != null && recievedlastName != null && recievedEmail != null) {
            val user = User(
                recievedFirstName.toString(),
                recievedlastName.toString(),
                recievedEmail.toString()
            )
            userList.add(user)
            adapter.notifyItemInserted(userList.size - 1)
        }


    }


}