package com.aai.covid_kotlin.utility

import android.app.DialogFragment
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.RelativeLayout
import android.widget.TextView
import com.aai.covid_kotlin.R
import java.net.HttpURLConnection

/* dialog fragment to show overlay on screen */
class ImageToastOverlayFragment : DialogFragment() {
    var layoutMain: RelativeLayout? = null
    var httpConn: HttpURLConnection? = null
    var txtView: TextView? = null
    fun newInstance(httpConn: HttpURLConnection?): ImageToastOverlayFragment {
        val f = ImageToastOverlayFragment()
        this.httpConn = httpConn
        return f
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        val window = dialog.window
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
        savedInstanceState: Bundle
    ): View? {
        val view: View =
            inflater.inflate(R.layout.image_toast_overlay, container, false)
        view.setBackgroundColor(Color.parseColor("#99000000"))
        layoutMain =
            view.findViewById<View>(R.id.layout_image_overlay) as RelativeLayout
        txtView = view.findViewById<View>(R.id.txt_overlay) as TextView
        //  txtView.setTypeface(FontStyle.setTextFont(getActivity(), FontStyle.FONT_TEXT));
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        layoutMain!!.setOnClickListener {
            httpConn!!.disconnect()
            //  Utility.hideImageToastOverlay(getFragmentManager());
        }
        return view
    }
}