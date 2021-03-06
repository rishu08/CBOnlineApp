package com.codingblocks.cbonlineapp.ui

import android.graphics.Color
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.solver.widgets.ConstraintWidget
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.nestedScrollView

class AllCourseFragmentUi<T> : AnkoComponent<T> {
    lateinit var rvCourses: RecyclerView
    lateinit var titleText: TextView

    override fun createView(ui: AnkoContext<T>): View = with(ui) {
        nestedScrollView {
            constraintLayout {
                titleText = textView("All Courses") {
                    id = View.generateViewId()
                    textSize = 24f
                    textColor = Color.BLACK
                    typeface = Typeface.createFromAsset(context.assets, "fonts/Cabin-Medium.ttf")
                }.lparams(width = wrapContent, height = wrapContent) {
                    topMargin = dip(8)
                    marginStart = dip(16)
                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                    horizontalBias = 0.0f
                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID

                }

                val view = view {
                    id = View.generateViewId()
                    backgroundColor = Color.BLACK
                }.lparams(width = 0, height = dip(2)) {
                    topMargin = dip(8)
                    marginStart = dip(16)
                    marginEnd = dip(20)
                    endToEnd = titleText.id
                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                    topToBottom = titleText.id

                }


                rvCourses = recyclerView {
                    id = View.generateViewId()
                    overScrollMode = View.OVER_SCROLL_NEVER
                }.lparams(width = matchParent, height = matchParent) {
                    topMargin = dip(8)
                    marginStart = dip(4)
                    marginEnd = dip(4)
                    horizontalBias = 0.0f
                    matchConstraintDefaultHeight = ConstraintWidget.MATCH_CONSTRAINT_WRAP
                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                    topToBottom = view.id

                }


            }.lparams(width = matchParent, height = matchParent) {
                isFocusableInTouchMode = true
                descendantFocusability = ViewGroup.FOCUS_BLOCK_DESCENDANTS
            }
        }
    }


}