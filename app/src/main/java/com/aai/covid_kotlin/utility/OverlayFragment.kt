package com.aai.covid_kotlin.utility

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.view.*
import android.widget.ProgressBar
import androidx.fragment.app.DialogFragment
import com.aai.covid_kotlin.R

class OverlayFragment : DialogFragment() {
    var progressBar: ProgressBar? = null
    var progressBarValue = 0
    var handler: Handler? = null
    var waitTimeInMillis = 500
    var maxProgress = 60
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.isCancelable = false
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
        val view: View =
            inflater.inflate(R.layout.circular_progress_bar, container, false)
        view.setBackgroundColor(Color.parseColor("#99000000"))
        dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)

        /*   */ /* Set progress as per 30 second timeout */ /*
        handler = new Handler();
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
      //  progressBar.setScaleY(2f); // set thickness of line
        progressBar.setMax(maxProgress);
        progressBar.setProgress(0);
        progressBar.setSecondaryProgress(0);
        progressBarValue=0;

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while(progressBarValue < maxProgress)
                {
                    progressBarValue++;

                 handler.post(new Runnable() {
                        @Override
                        public void run() {

                            progressBar.setProgress(progressBarValue);

                        }
                    });try {
                    Thread.sleep(waitTimeInMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }

                if(progressBarValue>maxProgress)
                {
                    progressBar.setVisibility(View.GONE);
                }


            }
        }).start();

      */
        /* End of progress */ /*
*/return view
    }

    fun onProgressCompleted() {
        waitTimeInMillis = 10
    }

    companion object {
        fun newInstance(): OverlayFragment {
            return OverlayFragment()
        }
    }
}
