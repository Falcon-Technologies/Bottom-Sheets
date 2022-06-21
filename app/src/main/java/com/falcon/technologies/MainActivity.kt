package com.falcon.technologies

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.falcon.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet.root)

        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {

            override fun onStateChanged(bottomSheet: View, state: Int) {
                when (state) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        binding.buttonBottomSheetPersistent.text = "hidden Bottom Sheet"
                    }
                    BottomSheetBehavior.STATE_EXPANDED ->
                        binding.buttonBottomSheetPersistent.text = "Close Bottom Sheet"
                    BottomSheetBehavior.STATE_COLLAPSED ->
                        binding.buttonBottomSheetPersistent.text = "collaps Bottom Sheet"
                    BottomSheetBehavior.STATE_DRAGGING -> {
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        binding.buttonBottomSheetPersistent.text = "settling bottom sheet"

                    }
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                        binding.buttonBottomSheetPersistent.text = "Half bottom sheet"
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }

        })

        binding.buttonBottomSheetPersistent.setOnClickListener {
            val state = if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                BottomSheetBehavior.STATE_COLLAPSED
            } else {
                BottomSheetBehavior.STATE_EXPANDED
            }
            bottomSheetBehavior.state = state
        }

        binding.buttonBottomSheetModal.setOnClickListener {
            MyBottomSheetDialogFragment().apply {
                show(supportFragmentManager, tag)
            }
        }

    }
}