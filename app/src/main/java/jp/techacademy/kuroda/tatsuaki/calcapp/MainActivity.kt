package jp.techacademy.kuroda.tatsuaki.calcapp
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
//import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.support.design.widget.Snackbar

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
     }

    override fun onClick(v: View) {
        val val1=editText1.text.toString()//.toDouble()// + editText2
        val val2=editText2.text.toString()//.toDouble()
        if ( val1.length == 0 || val2.length == 0) {
            Snackbar.make(v, "数値が入力されていません", Snackbar.LENGTH_INDEFINITE)
                .setAction("OK") {
                    Log.d("UI_PARTS", "Snackbarをタップした")
                }.show()
        }else {
            val value1=val1.toDouble()
            val value2=val2.toDouble()

            when (v.id) {
                R.id.button1 -> showAdd(value1,value2)//textView.text = editText.text.toString()
                R.id.button2 -> showSub(value1,value2)
                R.id.button3 -> showMul(value1,value2)
                R.id.button4 -> showdiv(value1,value2,v)
            }
        }
    }
    fun showVal(d:Double){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("VALUE1", d)
        startActivity(intent)
    }
    private fun showAdd(v1:Double,v2:Double) {
        showVal(v1+v2)
//        val intent = Intent(this, SecondActivity::class.java)
//        intent.putExtra("VALUE1", v1 + v2)
//        startActivity(intent)
    }
    private fun showSub(v1:Double,v2:Double) {
        showVal(v1-v2)
    }
    private fun showMul(v1:Double,v2:Double) {
showVal(v1*v2)
    }
    private fun showdiv(v1:Double,v2:Double,v:View) {
        if (v2 == 0.0){
                Snackbar.make(v, "0では割れません", Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK") {
                        Log.d("UI_PARTS", "0では割れません")
                    }.show()
        }else{
showVal(v1/v2)
        }
    }
}