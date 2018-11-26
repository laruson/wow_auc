package com.gmail.chernikovich.wow_auctionator.presenter.utils.customView

import android.content.Context
import android.support.v4.content.res.ResourcesCompat
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import com.gmail.chernikovich.wow_auctionator.R

class GoldView: LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs){
        val gold:String
        val silver:String
        val copper:String

        val atr=context.theme.obtainStyledAttributes(attrs, R.styleable.GoldView,0,0)
        try{
            gold = atr.getString(R.styleable.GoldView_setGold)!!
            silver = atr.getString(R.styleable.GoldView_setSilver)!!
            copper = atr.getString(R.styleable.GoldView_setCopper)!!
        }finally {
            atr.recycle()
        }
        setGold(gold)
        setSilver(silver)
        setCopper(copper)
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    val gold = TextView(context)
    val silver = TextView(context)
    val copper = TextView(context)

    init {
        layoutSettings()
        goldSettings()
        silverSettings()
        copperSettings()

        this.addView(gold)
        this.addView(silver)
        this.addView(copper)

    }

    private fun layoutSettings(){
        this.orientation = LinearLayout.HORIZONTAL
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT)
        this.layoutParams = params
    }

    private fun goldSettings(){
        gold.setCompoundDrawablesRelative(null,null, ResourcesCompat.getDrawable(context.resources,R.mipmap.gold_mini,null), null)
        val params = LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT)
        gold.layoutParams = params
    }

    private fun silverSettings(){
        silver.setCompoundDrawablesRelative(null,null, ResourcesCompat.getDrawable(context.resources,R.mipmap.silver,null), null)
        val params = LinearLayout.LayoutParams(32,LinearLayout.LayoutParams.WRAP_CONTENT)
        silver.layoutParams = params
    }

    private fun copperSettings(){
        copper.setCompoundDrawablesRelative(null,null, ResourcesCompat.getDrawable(context.resources,R.mipmap.copper,null), null)
        val params = LinearLayout.LayoutParams(32,LinearLayout.LayoutParams.WRAP_CONTENT)
        copper.layoutParams = params
    }

    fun setGold(text:String){
        gold.text = text
    }

    fun setSilver(text:String){
        gold.text = text
    }

    fun setCopper(text:String){
        gold.text = text
    }

}