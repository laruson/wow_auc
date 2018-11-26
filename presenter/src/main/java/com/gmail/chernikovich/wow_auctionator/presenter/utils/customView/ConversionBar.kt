package com.gmail.chernikovich.wow_auctionator.presenter.utils.customView

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.gmail.chernikovich.wow_auctionator.R
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.view.clicks
import io.reactivex.Observable

class ConversionBar: LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs){
        val text:String
        val atr=context.theme.obtainStyledAttributes(attrs,R.styleable.CustomView,0,0)
        try{
            text = atr.getString(R.styleable.CustomView_setText)!!
        }finally {
            atr.recycle()
        }
        setText(text)
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    val back =  ImageView(context)
    val forward = ImageView(context)
    val textView = TextView(context)

    init {

        layoutSettings()
        backButtonSettings()
        forwardButtonSettings()
        textSettings()

        this.addView(back)
        this.addView(textView)
        this.addView(forward)


    }

    private fun layoutSettings(){
        this.orientation = LinearLayout.HORIZONTAL
        this.weightSum = 100F
        var params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT)
        this.layoutParams = params
    }

    private fun backButtonSettings(){
        back.setImageResource(R.drawable.black)
        val params = LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT)
        params.weight=8F
        back.layoutParams = params
    }

    private fun forwardButtonSettings(){
        forward.setImageResource(R.drawable.forward)
        val params = LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT)
        params.weight=8F
        forward.layoutParams = params
    }

    private fun textSettings(){
        val params = LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT)
        params.weight=84F
        textView.layoutParams = params
        textView.gravity = Gravity.CENTER
        textView.textSize=25F
        textView.text="Hello"
    }

    fun setText(text:String){
        textView.text = text
    }
}