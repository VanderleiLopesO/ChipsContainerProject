package com.vanderlei.chipcontainerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val chipsList = arrayListOf<Chip>()
    private val nameList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpNames()
        setUpChips()
    }

    private fun setUpNames() {
        nameList.add(resources.getString(R.string.option1))
        nameList.add(resources.getString(R.string.option2))
        nameList.add(resources.getString(R.string.option3))
    }

    private fun setUpChips() {
        for (i in 0..2) {
            chipsList.add(Chip(this))
        }

        chipsList.forEachIndexed { i, it ->
            it.apply {
                backgroundDrawable = ContextCompat.getDrawable(this@MainActivity, R.drawable.background_chip)
                closeIcon = ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_close)
                isCloseIconVisible = true
                isClickable = false
                text = nameList[i]

                setOnCloseIconClickListener {
                    it.visibility = View.GONE
                }
            }

            chipGroup.addView(it)
        }
    }
}