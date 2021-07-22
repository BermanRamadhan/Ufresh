package com.uninet.ufresh.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.uninet.ufresh.R
import com.uninet.ufresh.model.SwipeIntroModel

class SwipedIntroAdapter : PagerAdapter {

    var context:Context
    var mListSwipeScreen :List<SwipeIntroModel>
    constructor(context: Context, mListSwipeScreen: List<SwipeIntroModel>){
        this.context = context
        this.mListSwipeScreen = mListSwipeScreen
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layoutScreen: View = inflater.inflate(R.layout.item_swipe_intro, null)
        val bg = layoutScreen.findViewById<View>(R.id.view__swipe)
        val imgSlide = layoutScreen.findViewById<ImageView>(R.id.imageintroswipe)
        val text1 = layoutScreen.findViewById<TextView>(R.id.typog__swipe__intro)
        val text2 = layoutScreen.findViewById<TextView>(R.id.typog__swipe__intro2)
        val description = layoutScreen.findViewById<TextView>(R.id.typog__swipe__intro3)

        bg.setBackgroundColor(mListSwipeScreen.get(position).bg)
        bg.invalidate()
        imgSlide.setImageResource(mListSwipeScreen.get(position).si_gambar)
        text1.setText(mListSwipeScreen.get(position).si_text1)
        text2.setText(mListSwipeScreen.get(position).si_text2)
        description.setText(mListSwipeScreen.get(position).si_text3)

        container.addView(layoutScreen)
        return layoutScreen
    }
    override fun getCount(): Int {
        return mListSwipeScreen.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return `object` == view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}