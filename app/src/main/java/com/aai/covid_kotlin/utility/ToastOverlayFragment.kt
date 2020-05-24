package com.aai.covid_kotlin.utility

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.aai.covid_kotlin.R

/* dialog fragment to show overlay on screen */
class ToastOverlayFragment : DialogFragment() {
    var layoutMain: LinearLayout? = null
    var text: String? = null
    var imgId = 0
    var txtView: TextView? = null
    var isClicked = false
    fun newInstance(text: String?, image: Int): ToastOverlayFragment {
        val f = ToastOverlayFragment()
        this.text = text
        imgId = image
        return f
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        val window = dialog!!.window
        window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.view_toast, container, false)
        layoutMain =
            view.findViewById<View>(R.id.custom_auth_toast_layout) as LinearLayout
        txtView = view.findViewById<View>(R.id.custom_toast_txt) as TextView

        //  txtView.setTypeface(FontStyle.setTextFont(getActivity(), FontStyle.FONT_TEXT));
        dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        txtView!!.text = text
        txtView!!.setCompoundDrawablesWithIntrinsicBounds(0, imgId, 0, 0)
        if (imgId == R.mipmap.completed) {
            txtView!!.setBackgroundResource(R.color.menu_green)
        }
        layoutMain!!.setOnClickListener {
            isClicked = true
            Utility.hideToastOverlay(fragmentManager)
        }
        Handler().postDelayed(
            { if (!isClicked) Utility.hideToastOverlay(fragmentManager) },
            1500
        ) // make if 2000, 1000 only for Preventive maintenance
        return view
    }
}