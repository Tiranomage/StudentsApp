package com.example.newprojectapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement

/*class DBHelper(val context: Context, val factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "app", factory, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT NULL, email TEXT, pass TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun addUser(user : User) {
        val values = ContentValues()
        values.put("email", user.email)
        values.put("pass", user.pass)

        val db = this.writableDatabase
        db.insert("users", null, values)

        db.close()
    }

    fun getUser(email: String, pass: String): Boolean {
        val db = this.readableDatabase

        val result = db.rawQuery("SELECT * FROM users WHERE email = '$email' AND pass = '$pass'", null)
        return result.moveToFirst()
    }
}*/

class DBHelper() {
    val url = "jdbc:mysql://localhost:3306/urfuaparts"
    val user = "root"
    val password = ""

    init {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver")
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }

    companion object {
        private val instance: DBHelper = DBHelper()

        fun getInstance(): DBHelper {
            return instance
        }
    }

    fun getConnection(): Connection? {
        return try {
            DriverManager.getConnection(url, user, password)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun addNewUser(mail: String, password: String, name: String?, gender: String?) {
        println("OK")
        val connection = getConnection()
        println("OK")
        if (connection != null) {
            try {
                println("OK")
                val query = "INSERT INTO users (mail, password, name, gender) VALUES (?, ?, ?, ?)"
                val preparedStatement = connection.prepareStatement(query)

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
                connection.close()
            }
        }
    }

    fun registerUser(username: String, pass: String): Boolean {
        var connection: Connection? = null
        var preparedStatement: PreparedStatement? = null

        return try {
            connection = DriverManager.getConnection(url, user, password)
            val query = "INSERT INTO users (mail, password, name, gender) VALUES (?, ?, ?, ?)"
            preparedStatement = connection.prepareStatement(query)
            preparedStatement.setString(1, username)
            preparedStatement.setString(2, pass)
            preparedStatement.setString(3, "Олег")
            preparedStatement.setString(4, "М")
            preparedStatement.executeUpdate() > 0
        } finally {
            preparedStatement?.close()
            connection?.close()
        }
    }

    fun userExists(mail: String, password: String): Boolean {
        val connection = getConnection()
        if (connection != null) {
            try {
                val query = "SELECT COUNT(*) AS count FROM users WHERE mail = ? AND password = ?"
                val preparedStatement: PreparedStatement = connection.prepareStatement(query)

                preparedStatement.setString(1, mail)
                preparedStatement.setString(2, password)

                val resultSet: ResultSet = preparedStatement.executeQuery()

                if (resultSet.next()) {
                    val count = resultSet.getInt("count")
                    return count > 0
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                connection.close()
            }
        }
        return false
    }

    fun fetchDataFromUserTable() {
        val connection = getConnection()
        if (connection != null) {
            try {
                val statement: Statement = connection.createStatement()
                val query = "SELECT * FROM users"
                val resultSet: ResultSet = statement.executeQuery(query)

                while (resultSet.next()) {
                    val userId = resultSet.getInt("id")
                    val userMail = resultSet.getString("mail")
                    val userPassword = resultSet.getString("password")
                    val userName = resultSet.getString("name")
                    val userGender = resultSet.getString("gender")

                    println("User ID: $userId, Mail: $userMail, Password: $userPassword, Name: $userName, Gender: $userGender")
                }

                resultSet.close()
                statement.close()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                connection.close()
            }
        }
    }
}

fun main() {
    val dbHelper = DBHelper()

    // Establish connection and fetch data from the user table
    dbHelper.fetchDataFromUserTable()
}
