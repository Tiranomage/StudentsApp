package com.example.newprojectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import java.sql.Connection


class RegActivity : AppCompatActivity() {

    private lateinit var connect: Connection
    private lateinit var connectionResult: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        val userEmail: EditText = findViewById(R.id.user_mail)
        val userPass: EditText = findViewById(R.id.user_pass)
        val button: Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        linkToAuth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

            button.setOnClickListener {
                val email = userEmail.text.toString().trim()
                val pass = userPass.text.toString().trim()

                if(email == "" || pass == "")
                    Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
                else {
                    /*addNewUser(email, pass, "Олег", "M")*/
                    Toast.makeText(this, "Регистрация успешна", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                    /*val db = DBHelper()
                    val ch = ConnectionHelper()
                    connect = ch.connectionClass()
                    if (connect!=null) {
                        val newUserAdded = ch.addNewUser(email, pass, "oleg", "M")
                        if (newUserAdded != null) {
                            Toast.makeText(this, "Регистрация успешна", Toast.LENGTH_LONG).show()

                            userEmail.text.clear()
                            userPass.text.clear()

                            val intent = Intent(this, MenuActivity::class.java)
                            startActivity(intent)
                        }
                    }
                    else
                        Toast.makeText(this, "Нет соединения", Toast.LENGTH_LONG).show()*/
                }
            }
        /*button.setOnClickListener {
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if(email == "" || pass == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                addNewUser(email, pass, "Олег", "M")
                Toast.makeText(this, "Регистрация успешна", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                /*val db = DBHelper()
                val ch = ConnectionHelper()
                connect = ch.connectionClass()
                if (connect!=null) {
                    val newUserAdded = ch.addNewUser(email, pass, "oleg", "M")
                    if (newUserAdded != null) {
                        Toast.makeText(this, "Регистрация успешна", Toast.LENGTH_LONG).show()

                        userEmail.text.clear()
                        userPass.text.clear()

                        val intent = Intent(this, MenuActivity::class.java)
                        startActivity(intent)
                    }
                }
                else
                    Toast.makeText(this, "Нет соединения", Toast.LENGTH_LONG).show()*/
            }
        }*/
    }

    fun addNewUser(mail: String, password: String, name: String?, gender: String?) {
        println("OK")
        main()
        val db = DBHelper.getInstance()
        val ch = ConnectionHelper()
        val connection = ch.connectionClass()
        val conn = db.getConnection()
        println("OK")
        if (conn != null) {
            try {
                println("OK")
                val query = "INSERT INTO users (mail, password, name, gender) VALUES (?, ?, ?, ?)"
                val preparedStatement = conn.prepareStatement(query)

                preparedStatement.setString(1, mail)
                preparedStatement.setString(2, password)
                if (name != null)
                    preparedStatement.setString(3, name) // Default to 0 if age is null
                if (gender != null)
                    preparedStatement.setString(4, gender)

                preparedStatement.execute()

                println("User added successfully.")
                preparedStatement.close()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                conn.close()
            }
        }
        else {
            Toast.makeText(this, "Проблемы с соединением", Toast.LENGTH_LONG).show()
        }
    }
}