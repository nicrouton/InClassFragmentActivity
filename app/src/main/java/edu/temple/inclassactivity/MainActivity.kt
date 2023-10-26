package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

// auto fragment instantiation
class MainActivity : AppCompatActivity() {

    lateinit var someVar: Array<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()


        val imageButton = findViewById<Button>(R.id.imageButton)

        imageButton.setOnClickListener {
            (supportFragmentManager.findFragmentById(R.id.imageFragment) as ImageDisplayFragment).setImages(imageArray)
        }


        // Attach an instance of ImageDisplayFragment using factory method
        //val fragment1= ImageDisplayFragment.newInstance(imageArray)

        // add a support fragment manager
        // checking to see if a fragment is attached or if it is null
        // if it is null do transactions again, if it isn't use the old one
        // fragment reference or null for findfrag
        // !is = is not

        /*if (supportFragmentManager.findFragmentById(R.id.imageFragment) !is ImageDisplayFragment) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.imageFragment, fragment1)
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()

        }*/

        //if (::someVar.isInitialized)

    }
}