package com.example.lab_week_06

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender
import kotlin.lazy

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        // Initialize the adapter once with all necessary parameters, including the OnClickListener.
        CatAdapter(layoutInflater, GlideImageLoader(this), object: CatAdapter.OnClickListener {
            // when this is triggered, the pop up dialog will be shown
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup the adapter for the recycler view
        recyclerView.adapter = catAdapter

        // Setup the layout manager for the recycler view
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //Instantiate ItemTouchHelper for the swipe to delete callback and
//attach it to the recycler view
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // Add data to the model list in the adapter
        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.AmericanCurl,
                    "Barnaby",
                    "Likes to nap in sunbeams.",
                    "https://cdn2.thecatapi.com/images/4x3.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.BalineseJavanese,
                    "Jasmine",
                    "Enjoys playing with yarn.",
                    "https://cdn2.thecatapi.com/images/5i2.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.ExoticShorthair,
                    "Gus",
                    "Adores feather toys.",
                    "https://cdn2.thecatapi.com/images/8g5.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.AmericanCurl,
                    "Penelope",
                    "Loves chasing laser pointers.",
                    "https://cdn2.thecatapi.com/images/a2b.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Leo",
                    "King of the scratching post.",
                    "https://cdn2.thecatapi.com/images/b4b.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Zoe",
                    "Expert at finding comfy spots.",
                    "https://cdn2.thecatapi.com/images/c0a.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.AmericanCurl,
                    "Milo",
                    "Has a PhD in bird watching.",
                    "https://cdn2.thecatapi.com/images/d4c.jpg"
                )
            )
        )
    }

    // This will create a pop up dialog when one of the items from the recycler view is clicked
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            // Set the title for the dialog
            .setTitle("Cat Selected")
            // Set the message for the dialog
            .setMessage("You have selected cat ${cat.name}")
            // Set if the OK button should be enabled
            .setPositiveButton("OK") { _, _ -> }.show()
    }
}