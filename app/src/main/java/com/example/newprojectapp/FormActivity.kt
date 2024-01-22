package com.example.newprojectapp

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.ScrollView
import android.widget.Spinner
import android.widget.Toast

class FormActivity : AppCompatActivity() {

    private val scrollViewIds = arrayOf(
        R.id.scroll1,
        R.id.scroll2,
        R.id.scroll3,
        R.id.scroll4,
        R.id.scroll5,
        R.id.scroll6
    )

    private lateinit var userName: EditText
    private lateinit var userSocial: EditText
    private lateinit var userAge: EditText
    private lateinit var selfDesc: EditText
    private lateinit var fromPrice: EditText
    private lateinit var fromLive: EditText
    private lateinit var toPrice: EditText
    private lateinit var toLive: EditText
    private lateinit var fromLiveNeighbour: EditText
    private lateinit var toLiveNeighbour: EditText

    private val editTexts = arrayOf(
        R.id.edit_name,
        R.id.edit_ref,
        R.id.user_birth_date,
        R.id.edit_self_desc,
        R.id.from_price,
        R.id.from_live,
        R.id.to_price,
        R.id.to_live,
        R.id.from_live_neighbour,
        R.id.to_live_neighbour
    )

    private lateinit var genderGroup: RadioGroup
    private lateinit var citizenshipCroup: RadioGroup
    private lateinit var chronotypeGroup: RadioGroup
    private lateinit var smokingGroup: RadioGroup
    private lateinit var alcoholGroup: RadioGroup
    private lateinit var animalGroup: RadioGroup
    private lateinit var wishGenderGroup: RadioGroup
    private lateinit var wishChronotypeGroup: RadioGroup
    private lateinit var wishSmokingGroup: RadioGroup
    private lateinit var wishAlcoholGroup: RadioGroup
    private lateinit var wishAnimalGroup: RadioGroup

    private val radioGroups = arrayOf(
        R.id.gender_group,
        R.id.citizenship_group,
        R.id.chronotype_group,
        R.id.smoking_group,
        R.id.alcohol_group,
        R.id.animal_group,
        R.id.wish_gender_group,
        R.id.wish_chronotype_group,
        R.id.wish_smoking_group,
        R.id.wish_alcohol_group,
        R.id.wish_animal_group
    )

    private lateinit var flatTypeSpinner: Spinner
    private lateinit var districtSpinner: Spinner
    private lateinit var rentalSpinner: Spinner

    private val spinners = arrayOf(
        R.id.flat_type_spinner,
        R.id.district_spinner,
        R.id.rental_spinner
    )

    private lateinit var photo1: ImageView
    private lateinit var photo2: ImageView
    private lateinit var photo3: ImageView
    private lateinit var flatPhoto1: ImageView
    private lateinit var flatPhoto2: ImageView
    private lateinit var flatPhoto3: ImageView

    private val photos = arrayOf(
        R.id.first_photo,
        R.id.second_photo,
        R.id.third_photo,
        R.id.first_flat_photo,
        R.id.second_flat_photo,
        R.id.third_flat_photo
    )

    private var currentIndex = 0

    private val PICK_IMAGE_REQUEST = 1
    private var selectedImageView: ImageView? = null
    private var photoAdded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        for (i in scrollViewIds.indices){
            if (i == 0)
                findViewById<ScrollView>(scrollViewIds[i]).visibility = View.VISIBLE
            else
                findViewById<ScrollView>(scrollViewIds[i]).visibility = View.INVISIBLE
        }

        photo1 = findViewById(R.id.first_photo)
        photo2 = findViewById(R.id.second_photo)
        photo3 = findViewById(R.id.third_photo)
        flatPhoto1 = findViewById(R.id.first_flat_photo)
        flatPhoto2 = findViewById(R.id.second_flat_photo)
        flatPhoto3 = findViewById(R.id.third_flat_photo)

        val backButton: ImageButton = findViewById(R.id.back_button_form)
        val forwardButton: ImageButton = findViewById(R.id.forward_button)
        val backwardButton: ImageButton = findViewById(R.id.backward_button)

        userName = findViewById(R.id.edit_name)
        userSocial = findViewById(R.id.edit_ref)
        userAge = findViewById(R.id.user_birth_date)
        selfDesc = findViewById(R.id.edit_self_desc)
        fromPrice = findViewById(R.id.from_price)
        fromLive = findViewById(R.id.from_live)
        toPrice = findViewById(R.id.to_price)
        toLive = findViewById(R.id.to_live)
        fromLiveNeighbour = findViewById(R.id.from_live_neighbour)
        toLiveNeighbour = findViewById(R.id.to_live_neighbour)

        genderGroup = findViewById(R.id.gender_group)
        citizenshipCroup = findViewById(R.id.citizenship_group)
        chronotypeGroup = findViewById(R.id.chronotype_group)
        smokingGroup = findViewById(R.id.smoking_group)
        alcoholGroup = findViewById(R.id.alcohol_group)
        animalGroup = findViewById(R.id.animal_group)
        wishGenderGroup = findViewById(R.id.wish_gender_group)
        wishChronotypeGroup = findViewById(R.id.wish_chronotype_group)
        wishSmokingGroup = findViewById(R.id.wish_smoking_group)
        wishAlcoholGroup = findViewById(R.id.wish_alcohol_group)
        wishAnimalGroup = findViewById(R.id.wish_animal_group)

        flatTypeSpinner = findViewById(R.id.flat_type_spinner)
        districtSpinner = findViewById(R.id.district_spinner)
        rentalSpinner = findViewById(R.id.rental_spinner)

        val flatAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, SpinnerData.flatTypeSpinnerData)
        val districtAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, SpinnerData.districtSpinnerData)
        val rentalAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, SpinnerData.rentalSpinnerData)

        flatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        rentalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        flatTypeSpinner.setSelection(0)
        districtSpinner.setSelection(0)
        rentalSpinner.setSelection(0)

        flatTypeSpinner.adapter = flatAdapter
        districtSpinner.adapter = districtAdapter
        rentalSpinner.adapter = rentalAdapter

        flatTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedFlatItem = SpinnerData.flatTypeSpinnerData[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                flatTypeSpinner.setSelection(0)
            }
        }

        districtSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedDistrictItem = SpinnerData.districtSpinnerData[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                districtSpinner.setSelection(0)
            }
        }

        rentalSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedRentalItem = SpinnerData.rentalSpinnerData[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                rentalSpinner.setSelection(0)
            }
        }

        forwardButton.setOnClickListener {
            showNextScrollView()
        }

        backwardButton.setOnClickListener {
            showPreviousScrollView()
        }

        backButton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        photo1.setOnClickListener { onImageViewClick(it) }
        photo2.setOnClickListener { onImageViewClick(it) }
        photo3.setOnClickListener { onImageViewClick(it) }
        flatPhoto1.setOnClickListener { onImageViewClick(it) }
        flatPhoto2.setOnClickListener { onImageViewClick(it) }
        flatPhoto3.setOnClickListener { onImageViewClick(it) }

        /*val name = userName.text.toString().trim()
        val social = userSocial.text.toString().trim()
        val age = userAge.text.toString().trim()
        val desc = selfDesc.text.toString().trim()
        val fromP = fromPrice.text.toString().trim()
        val toP = toPrice.text.toString().trim()
        val fromL = fromLive.text.toString().trim()
        val toL = toLive.text.toString().trim()
        val fromLN = fromLiveNeighbour.text.toString().trim()
        val toLN = toLiveNeighbour.text.toString().trim()*/
    }

    private fun showNextScrollView() {
        if (currentIndex < scrollViewIds.size - 1) {
            findViewById<ScrollView>(scrollViewIds[currentIndex]).visibility = View.INVISIBLE
            currentIndex++
            findViewById<ScrollView>(scrollViewIds[currentIndex]).visibility = View.VISIBLE
            if (currentIndex > 0)
                findViewById<ImageButton>(R.id.backward_button).visibility = View.VISIBLE
        }
        else if (currentIndex == 5) {
            if (validateData()) {
                val intent = Intent(this, NeighboursActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun showPreviousScrollView() {
        if (currentIndex > 0) {
            findViewById<ScrollView>(scrollViewIds[currentIndex]).visibility = View.INVISIBLE
            currentIndex--
            findViewById<ScrollView>(scrollViewIds[currentIndex]).visibility = View.VISIBLE
            if (currentIndex == 0)
                findViewById<ImageButton>(R.id.backward_button).visibility = View.INVISIBLE
        }
    }

    private fun validateData(): Boolean {
        for (i in editTexts.indices) {
            if (findViewById<EditText>(editTexts[i]).text.isEmpty()) {
                showToast("Не все поля заполнены")
                return false
            }
        }
        for (i in radioGroups.indices) {
            if (!isRadioButtonSelected(findViewById(radioGroups[i]))) {
                showToast("Не все кнопки выбраны")
                return false
            }
        }
        for (i in spinners.indices) {
            if (findViewById<Spinner>(spinners[i]).selectedItemPosition == 0) {
                showToast("Не все поля выбраны")
                return false
            }
        }
        for (i in photos.indices){
            if (!isPhotoAdded()){
                showToast("Добавьте фотографии")
                return false
            }
        }
        return true
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun isRadioButtonSelected(radioGroup: RadioGroup): Boolean {
        return radioGroup.checkedRadioButtonId != -1
    }

    private fun onImageViewClick(view: View) {
        selectedImageView = view as ImageView

        // Open gallery to select an image
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            // Get the selected image URI
            val imageUri = data.data

            // Set the selected image to the clicked ImageView
            selectedImageView?.setImageURI(imageUri)
        }
    }

    private fun isPhotoAdded(): Boolean {
        return photoAdded
    }
}