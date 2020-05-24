package com.aai.covid_kotlin.utility

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Point
import android.net.ConnectivityManager
import android.os.Build
import android.os.Environment
import android.text.TextUtils
import android.util.DisplayMetrics
import android.util.Patterns
import android.view.WindowManager
import android.view.animation.*
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ListView
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentManager
import com.aai.covid_kotlin.ui.login.LoginActivity
import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Utility {
    private var overlayFragment: OverlayFragment? = null
    private var imageToastOverlayFragment: ImageToastOverlayFragment? = null
    private var toastOverlayFragment: ToastOverlayFragment? = null
    //create encreption code //sachin
    fun md5(s: String): String {
        val MD5 = "MD5"
        try {
            // Create MD5 Hash
            val digest = MessageDigest.getInstance(MD5)
            digest.update(s.toByteArray())
            val messageDigest = digest.digest()

            // Create Hex String
            val hexString = StringBuilder()
            for (aMessageDigest in messageDigest) {
                var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                while (h.length < 2) h = "0$h"
                hexString.append(h)
            }
            return hexString.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ""
    }

    /* Utility method to check whether network is available or not*/
    fun isConnectingToInternet(context: Context): Boolean {

        var connectionManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectionManager.activeNetworkInfo

        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
    }

    /* Utility method to display  progressbar overlay during api call   */
    fun showOverlay(fragmentManager: FragmentManager?) {
        try {
            if (fragmentManager != null) {
                if (fragmentManager.findFragmentByTag(OverlayFragment::class.java.getSimpleName()) == null) {
                    overlayFragment = OverlayFragment()
                    overlayFragment!!.show(
                        fragmentManager,
                        OverlayFragment::class.java.getSimpleName()
                    )
                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    /* Utility method to hide progressbar overlay  */
    fun hideOverlay(fragmentManager: FragmentManager?) {
        try {
            var isDismiss = false
            if (fragmentManager != null) {
                if (fragmentManager.findFragmentByTag(OverlayFragment::class.java.getSimpleName()) != null) {
                    if (overlayFragment != null) {
                        isDismiss = true
                        dismissOverlayFragment()
                    }
                }
            }
            if (overlayFragment != null && !isDismiss) {
                overlayFragment!!.dismissAllowingStateLoss()
                overlayFragment = null
            }
        } catch (e: java.lang.Exception) {
        }
    }

    private fun dismissOverlayFragment() {
        if (overlayFragment != null) {
            overlayFragment!!.dismissAllowingStateLoss()
            overlayFragment = null
        }
    }


    /* Utility method to display  progressbar overlay during api call   */
  /*  public static void showImageToastOverlay(FragmentManager fragmentManager, HttpURLConnection httpConn) {
        try {
            if (fragmentManager != null) {
                if (fragmentManager.findFragmentByTag(ImageToastOverlayFragment.class.getSimpleName()) == null) {
                    imageToastOverlayFragment = new ImageToastOverlayFragment();
                    imageToastOverlayFragment.newInstance(httpConn);
                    imageToastOverlayFragment.show(fragmentManager, ImageToastOverlayFragment.class.getSimpleName());
                }
            }
        } catch (Exception e) {

        }
    }*/


    /* Utility method to hide progressbar overlay  */
    fun hideImageToastOverlay(fragmentManager: FragmentManager?) {
        try {
            var isDismiss = false
            if (fragmentManager != null) {
                if (fragmentManager.findFragmentByTag(ImageToastOverlayFragment::class.java.getSimpleName()) != null) {
                    if (imageToastOverlayFragment != null) {
                        isDismiss = true
                        dismissImageToastOverlayFragment()
                    }
                }
            }
            if (imageToastOverlayFragment != null && !isDismiss) {
                imageToastOverlayFragment!!.dismissAllowingStateLoss()
                imageToastOverlayFragment = null
            }
        } catch (e: java.lang.Exception) {
        }
    }

    private fun dismissImageToastOverlayFragment() {
        if (imageToastOverlayFragment != null) {
            imageToastOverlayFragment!!.dismissAllowingStateLoss()
            imageToastOverlayFragment = null
        }
    }

    /* Utility method to display  progressbar overlay during api call   */
    fun showToastOverlay(
        fragmentManager: FragmentManager?,
        text: String?,
        imgId: Int
    ) {
        try {
            if (fragmentManager != null) {
                if (fragmentManager.findFragmentByTag(ToastOverlayFragment::class.java.getSimpleName()) == null) {
                    toastOverlayFragment = ToastOverlayFragment()
                    toastOverlayFragment!!.newInstance(text, imgId)
                    toastOverlayFragment!!.show(
                        fragmentManager,
                        ToastOverlayFragment::class.java.getSimpleName()
                    )
                }
            }
        } catch (e: java.lang.Exception) {
        }
    }



    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target)
            .matches()
    }

    /* Utility method to hide progressbar overlay  */
    fun hideToastOverlay(fragmentManager: FragmentManager?) {
        try {
            var isDismiss = false
            if (fragmentManager != null) {
                if (fragmentManager.findFragmentByTag(ToastOverlayFragment::class.java.getSimpleName()) != null) {
                    if (toastOverlayFragment != null) {
                        isDismiss = true
                        dismissToastOverlayFragment()
                    }
                }
            }
            if (toastOverlayFragment != null && !isDismiss) {
                toastOverlayFragment!!.dismissAllowingStateLoss()
                toastOverlayFragment = null
            }
        } catch (e: java.lang.Exception) {
        }
    }

    private fun dismissToastOverlayFragment() {
        if (toastOverlayFragment != null) {
            toastOverlayFragment!!.dismissAllowingStateLoss()
            toastOverlayFragment = null
        }
    }
    fun initLayout(page_list: ListView) {
        val set = AnimationSet(true)
        var animation: Animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 200
        set.addAnimation(animation)
        animation = TranslateAnimation(
            Animation.RELATIVE_TO_SELF,
            0.0f,
            Animation.RELATIVE_TO_SELF,
            0.0f,
            Animation.RELATIVE_TO_SELF,
            1.0f,
            Animation.RELATIVE_TO_SELF,
            0.0f
        )
        animation.setDuration(400)
        set.addAnimation(animation)
        val controller = LayoutAnimationController(set, 0.5f)
        page_list.layoutAnimation = controller
    }

    fun isFilePresent(
        context: Context,
        fileName: String,
        folderName: String?): Boolean {
        try {
            val dir = File(
                context.getDir(
                    Environment.DIRECTORY_PICTURES,
                    Context.MODE_PRIVATE
                ), folderName
            )
            //File dir = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), folderName);
            if (!dir.mkdirs()) {
                //   Log.e("DIR", "Directory not created");
            } else {
                //   Log.e("DIR", "Directory created");
            }
            val s = dir.list()
            for (i in s.indices) {
                if (fileName.equals(s[i], ignoreCase = true)) {

                    //     Log.i("","PRESENT IN INTERNAL ====> "+s[i]);
                    return true
                }
            }
        } catch (e: Exception) {
            // TODO Auto-generated catch block
            e.printStackTrace()
            return false
        }
        return false
    }

    fun saveImageInInternal(
        context: Context,
        bitmap: Bitmap,
        file: String?,
        folderName: String?
    ) {
        try {
            val dir = File(
                context.getDir(
                    Environment.DIRECTORY_PICTURES,
                    Context.MODE_PRIVATE
                ), folderName
            )
            // File dir = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), folderName);
            if (!dir.mkdirs()) {
                //Log.e("DIR", "Directory not created");
            } else {
                // Log.e("DIR", "Directory created");
            }
            val fos = FileOutputStream(File(dir, file))
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
            fos.close()

            //  Log.i("","SAVE IN INTERNAL =====> "+file);
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Throws(Exception::class)
    fun loadFileAsBytesArray(fileName: String?): ByteArray {
        val file = File(fileName)
        val length = file.length().toInt()
        val reader =
            BufferedInputStream(FileInputStream(file))
        val bytes = ByteArray(length)
        reader.read(bytes, 0, length)
        reader.close()
        return bytes
    }

    fun getImageFromInternal(
        context: Context,
        fileName: String?,
        folderName: String?
    ): Bitmap? {
        return try {
            // File dir = context.getDir(Environment.DIRECTORY_PICTURES, Context.MODE_PRIVATE);
            val dir = File(
                context.getDir(
                    Environment.DIRECTORY_PICTURES,
                    Context.MODE_PRIVATE
                ), folderName
            )
            // File dir = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), folderName);
            if (!dir.mkdirs()) {
                //  Log.e("DIR", "Directory not created");
            } else {
                //  Log.e("DIR", "Directory created");
            }
            val file = File(dir, fileName)
            val fis = FileInputStream(file)
            val b = BitmapFactory.decodeStream(fis)
            fis.close()
            // Log.i("","GET FROM INTERNAL =====> "+fileName);
            b
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }


    fun dpToPx(dp: Int, context: Context): Int {
        val displayMetrics = context.resources.displayMetrics
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }

    fun callLogin(context: Activity) {
        val i = Intent(context, LoginActivity::class.java)
        context.startActivity(i)
        context.finish()
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    fun getRealDimesion(context: Context): Point {
        val wm = context
            .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val size = Point()
        display.getRealSize(size)
        return size
    }

    val uniqueTag: String
        get() {
            val time = Date().time
            return time.toString()
        }

    fun currentDate(): String {
        val c = Calendar.getInstance().time
        println("Current time => $c")
        val df = SimpleDateFormat("dd/MM/yyyy")
        return df.format(c)
    }

    fun parseDateToddMMyyyy(time: String?): String? {
        val inputPattern = "dd/MM/yyyy HH:mm:SSS"
        val outputPattern = "dd-MM-yyyy"
        val inputFormat = SimpleDateFormat(inputPattern)
        val outputFormat = SimpleDateFormat(outputPattern)
        var date: Date? = null
        var str: String? = null
        try {
            date = inputFormat.parse(time)
            str = outputFormat.format(date)
        } catch (e: NullPointerException) {
            return null
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return str
    }//if you cannot make this folder return
    //take the current timeStamp
    //and make a media file:
//make a new file directory inside the "sdcard" folder

    //if this "JCGCamera folder does not exist

    //make picture and save to a folder
    val outputMediaFile: File?
        get() {
            //make a new file directory inside the "sdcard" folder
            val mediaStorageDir = File("/sdcard/", "WalkMyMind")

            //if this "JCGCamera folder does not exist
            if (!mediaStorageDir.exists()) {
                //if you cannot make this folder return
                if (!mediaStorageDir.mkdirs()) {
                    return null
                }
            }
            //take the current timeStamp
            val timeStamp =
                SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val mediaFile: File
            //and make a media file:
            mediaFile =
                File(mediaStorageDir.path + File.separator + "profilePic" + ".jpg")
            return mediaFile
        }

    /*  fun hideSoftKeyboard(
          context: Context,
          currentFocusedView: View
      ) {
          if (Validate.notNull(currentFocusedView)) {
              val inputMethodManager = context
                  .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
              inputMethodManager.hideSoftInputFromWindow(currentFocusedView.windowToken, 0)
          }
      }*/

    /* Utility method to hide  soft keyboard */
    fun hideSoftKeyboard(activity: Activity) {
        val imm =
            activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val f = activity.currentFocus
        if (null != f && null != f.windowToken && EditText::class.java.isAssignableFrom(f.javaClass)) {
            imm.hideSoftInputFromWindow(f.windowToken, 0)
        } else {
            activity.window
                .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        }
    }

    /*fun dialogFilter(
        context: Context,
        sortArr: Array<String?>,
        sortAlertEventInterface: SortAlertEventInterface
    ) {
        // custom dialog
        val dialog = Dialog(context, R.style.Theme_Dialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v: View = inflater.inflate(R.layout.dialog_sort_view, null)
        dialog.setContentView(v)
        val txtCross = dialog.findViewById<View>(R.id.txtCross) as TextView
        val radioButton =
            arrayOfNulls<RadioButton>(1)
        val rdioGroup_sort =
            dialog.findViewById<View>(R.id.rdioGroup_sort) as RadioGroup
        val rb =
            arrayOfNulls<RadioButton>(sortArr.size)
        for (i in sortArr.indices) {
            rb[i] = RadioButton(context)
            rb[i]!!.layoutParams = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.MATCH_PARENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rb[i]!!.text = sortArr[i]
            rb[i]!!.id = i + 100
            rb[i]!!.setPadding(10, 10, 10, 10)
            rb[i]!!.setBackgroundResource(R.drawable.bottom_radio_line)
            rb[i]!!
                .setTextColor(Color.parseColor("#0452c7")) //R.color.colorPrimary
            rb[i]!!.setTypeface(rb[i]!!.typeface, Typeface.BOLD)
            rdioGroup_sort.addView(rb[i])
        }
        rdioGroup_sort.setOnCheckedChangeListener { radioGroup, checkecId ->
            radioButton[0] =
                radioGroup.findViewById<View>(checkecId) as RadioButton
            sortAlertEventInterface.OnCheckEdSortListner(radioButton[0])
            Handler().postDelayed({
                dialog.dismiss()
                //Do something after 100ms
            }, 400)
        }
        txtCross.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }*/

    /* fun dialogcomon(
         context: Context,
         msg: String?,
         alertEventInterface: AlertEventInterface
     ) {
         // custom dialog
         val dialog = Dialog(context, R.style.Theme_Dialog)

         // dialog.setTitle("Title...");
         dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
         val inflater =
             context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
         val v: View = inflater.inflate(R.layout.dialog_common, null)
         dialog.setContentView(v)
         val txtCross = dialog.findViewById<View>(R.id.txtCross) as TextView
         val edt_remarks =
             dialog.findViewById<View>(R.id.edt_remarks) as EditText
         val txtMessage =
             dialog.findViewById<View>(R.id.txtMessage) as TextView
         txtMessage.text = msg
         val btnSubmit =
             dialog.findViewById<View>(R.id.btnSubmit) as Button
         val btnCancel =
             dialog.findViewById<View>(R.id.btnCancel) as Button
         btnSubmit.setOnClickListener {
             dialog.dismiss()
             alertEventInterface.yesListner()
         }
         btnCancel.setOnClickListener {
             dialog.dismiss()
             alertEventInterface.nesListner()
         }
         txtCross.setOnClickListener { alertEventInterface.nesListner() }
         dialog.show()
     }*/

    /*fun dialogWorkFlowHistoryList(
        context: Context,
        historyResultDtos: List<WorkFlowHistoryResultDto?>
    ) {
        // custom dialog
        val dialog = Dialog(context, R.style.Theme_Dialog)

        // dialog.setTitle("Title...");
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v: View = inflater.inflate(R.layout.dialog_workflow_history, null)
        dialog.setContentView(v)
        val recycleviewsearch: RecyclerView =
            dialog.findViewById<View>(R.id.recycleviewsearch) as RecyclerView
        val txttitle = dialog.findViewById<View>(R.id.txttitle) as TextView
        val txtCross = dialog.findViewById<View>(R.id.txtCross) as TextView
        if (historyResultDtos.size > 0) {
            val listAdapter = WorkFlowListAdapter(context, historyResultDtos)
            val manager =
                LinearLayoutManager(context, LinearLayout.VERTICAL, false)
            recycleviewsearch.setLayoutManager(manager)
            recycleviewsearch.setAdapter(listAdapter)
        } else {
            recycleviewsearch.setVisibility(View.GONE)
            txttitle.text = "Not Send for Approval"
        }
        txtCross.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }*/

/*
    fun dialogVenderComparisionList(
        context: Context,
        venderComparisionResultDtos: List<VenderComparisionResultDto?>
    ) {
        // custom dialog
        val dialog = Dialog(context, R.style.Theme_Dialog)

        // dialog.setTitle("Title...");
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v: View = inflater.inflate(R.layout.dialog_vender_comparision, null)
        dialog.setContentView(v)
        val recycleviewsearch: RecyclerView =
            dialog.findViewById<View>(R.id.recycleviewsearch) as RecyclerView
        val txttitle = dialog.findViewById<View>(R.id.txttitle) as TextView
        val txtCross = dialog.findViewById<View>(R.id.txtCross) as TextView
        if (venderComparisionResultDtos.size > 0) {
            val listAdapter =
                VenderComparisionListAdapter(context, venderComparisionResultDtos)
            val manager =
                LinearLayoutManager(context, LinearLayout.VERTICAL, false)
            recycleviewsearch.setLayoutManager(manager)
            recycleviewsearch.setAdapter(listAdapter)
        } else {
            recycleviewsearch.setVisibility(View.GONE)
            txttitle.text = "No Vendor Comparison has Created!"
        }
        txtCross.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }
*/

    private const val Attach = "Attachment"
    /* fun dialogAnaxtureAttachment(
         context: Context,
         viewPodto: ViewPodto?,
         viewRCDto: ViewRCDto,
         eventListner: AttachmentEventListner
     ) {
         val dialog = Dialog(context, R.style.Theme_Dialog)
         val checkType = if (viewPodto != null) true else false
         dialog.setTitle("Title...")
         dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
         val inflater =
             context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
         val v: View = inflater.inflate(R.layout.dialog_attachment, null)
         dialog.setContentView(v)
         // set the custom dialog components - text, image and button
         val txtCross = dialog.findViewById<View>(R.id.txtCross) as TextView
         val txtannexture =
             dialog.findViewById<View>(R.id.txtannexture) as TextView
         val lblannexture =
             dialog.findViewById<View>(R.id.lblannexture) as TextView
         val lblAttachment =
             dialog.findViewById<View>(R.id.lblAttachment) as TextView
         val layoutAttachment =
             dialog.findViewById<View>(R.id.layoutAttachment) as LinearLayout
         val btnView_workflowHistory =
             dialog.findViewById<View>(R.id.btnView_workflowHistory) as TextView
         val btnvender_workflowHistory =
             dialog.findViewById<View>(R.id.btnvender_workflowHistory) as TextView
         val layout_vender_c =
             dialog.findViewById<View>(R.id.layout_vender_c) as LinearLayout
         val getId: String = if (viewPodto != null) viewPodto.getSearchResults().get(0)
             .getId() else viewRCDto.getSearchResults().get(0).getId()
         val attachments: List<Attachment> =
             if (viewPodto != null) viewPodto.getSearchResults().get(0)
                 .getAttachArray() else viewRCDto.getSearchResults().get(0).getAttachArray()
         if (attachments.size > 0) {
             for (i in attachments.indices) {
                 val tv = TextView(context)
                 tv.setText(attachments[i].getName())
                 tv.setPadding(5, 5, 5, 5)
                 tv.setTextColor(Color.BLUE)
                 layoutAttachment.addView(tv)
                 tv.setOnClickListener {
                     if (tv.text != "") {
                         eventListner.onAttachmentEvent(attachments[i].getSrc(), "")
                     }
                 }
             }
         } else {
             lblAttachment.text = "No Attachment Found!"
         }
         val uploadedTermsAnnexureFileName: String =
             if (viewPodto != null) viewPodto.getSearchResults().get(0)
                 .getUploadedTermsAnnexureFileName() else viewRCDto.getSearchResults().get(0)
                 .getUploadedTermsAnnexureFileName()
         try {
             btnView_workflowHistory.setOnClickListener {
                 if (checkType) {
                     eventListner.onViewWorkFlow(getId, "PO")
                 } else {
                     eventListner.onViewWorkFlow(getId, "RC")
                 }
             }
             if (checkType) {
                 layout_vender_c.visibility = View.VISIBLE
             } else {
                 layout_vender_c.visibility = View.GONE
             }
             btnvender_workflowHistory.setOnClickListener {
                 eventListner.onVenderComparision(
                     getId,
                     ""
                 )
             }
             if (uploadedTermsAnnexureFileName != null) {
                 txtannexture.setText(
                     com.aurionpro.gsg_ipms.utilities.Utility.getPDFname(
                         uploadedTermsAnnexureFileName,
                         ""
                     )
                 )
             } else {
                 lblannexture.text = "No Annexure Found!"
             }
         } catch (e: Exception) {
             e.printStackTrace()
         }
         txtannexture.setOnClickListener {
             if (txtannexture.text != "") {
                 eventListner.onAttachmentEvent(uploadedTermsAnnexureFileName, "")
             }
         }
         txtCross.setOnClickListener { dialog.dismiss() }
         dialog.show()
     }*/

    /* fun dialogAnaxtureAttachment_new(
         context: Context,
         viewPodto: ViewPodto?,
         viewRCDto: ViewRCDto,
         eventListner: AttachmentEventListner
     ) {
         val dialog = Dialog(context, R.style.Theme_Dialog)
         val checkType = if (viewPodto != null) true else false
         dialog.setTitle("Title...")
         dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
         val inflater =
             context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
         val v: View = inflater.inflate(R.layout.dialog_attachment, null)
         dialog.setContentView(v)
         // set the custom dialog components - text, image and button
         val txtCross = dialog.findViewById<View>(R.id.txtCross) as TextView
         val txtannexture =
             dialog.findViewById<View>(R.id.txtannexture) as TextView
         val lblannexture =
             dialog.findViewById<View>(R.id.lblannexture) as TextView
         val lblAttachment =
             dialog.findViewById<View>(R.id.lblAttachment) as TextView
         val btnView_workflowHistory =
             dialog.findViewById<View>(R.id.btnView_workflowHistory) as TextView
         val btnvender_workflowHistory =
             dialog.findViewById<View>(R.id.btnvender_workflowHistory) as TextView
         val layout_vender_c =
             dialog.findViewById<View>(R.id.layout_vender_c) as LinearLayout
         val layoutAttachment =
             dialog.findViewById<View>(R.id.layoutAttachment) as LinearLayout
         val getId: String = if (viewPodto != null) viewPodto.getSearchResults().get(0)
             .getId() else viewRCDto.getSearchResults().get(0).getId()
         val uploadedTermsAnnexureFileName: String =
             if (viewPodto != null) viewPodto.getSearchResults().get(0)
                 .getUploadedTermsAnnexureFileName() else viewRCDto.getSearchResults().get(0)
                 .getUploadedTermsAnnexureFileName()
         val attachments: List<Attachment> =
             if (viewPodto != null) viewPodto.getSearchResults().get(0)
                 .getAttachments() else viewRCDto.getSearchResults().get(0).getAttachments()
         if (attachments != null) {
             if (attachments.size > 0) {
                 for (i in attachments.indices) {
                     val tv = TextView(context)
                     tv.setText(attachments[i].getName())
                     tv.setPadding(5, 5, 5, 5)
                     tv.setTextColor(Color.BLUE)
                     layoutAttachment.addView(tv)
                     tv.setOnClickListener {
                         if (tv.text != "") {
                             eventListner.onAttachmentEvent(attachments[i].getSrc(), "")
                         }
                     }
                 }
             } else {
                 lblAttachment.text = "No Attachment Found!"
             }
         } else {
             lblAttachment.text = "No Attachment Found!"
         }
         try {
             btnView_workflowHistory.visibility = View.GONE
             btnvender_workflowHistory.visibility = View.GONE
             btnView_workflowHistory.setOnClickListener { }
             if (checkType) {
                 layout_vender_c.visibility = View.VISIBLE
             } else {
                 layout_vender_c.visibility = View.GONE
             }
             btnvender_workflowHistory.setOnClickListener {
                 // eventListner.onVenderComparision(getId,"");
             }
             if (uploadedTermsAnnexureFileName != null) {
                 txtannexture.setText(
                     com.aurionpro.gsg_ipms.utilities.Utility.getPDFname(
                         uploadedTermsAnnexureFileName,
                         ""
                     )
                 )
             } else {
                 lblannexture.text = "No Annexure Found!"
             }
         } catch (e: Exception) {
             e.printStackTrace()
         }
         txtannexture.setOnClickListener {
             if (txtannexture.text != "") {
                 eventListner.onAttachmentEvent(uploadedTermsAnnexureFileName, "")
             }
         }
         txtCross.setOnClickListener { dialog.dismiss() }
         dialog.show()
     }
 */
    private fun getPDFname(url: String, defaultFileName: String): String {
        var filename = defaultFileName
        val urlstr = url.split("//").toTypedArray()
        if (urlstr.size == 2) {
            val strArr = urlstr[1].split("/").toTypedArray()
            for (i in strArr.size - 1 downTo 0) {
                filename = strArr[i]
                break
            }
        } else if (urlstr.size == 3) {
            val strArr = urlstr[2].split("/").toTypedArray()
            for (i in strArr.size - 1 downTo 0) {
                filename = strArr[i]
                break
            }
        }
        return filename
    }

    /* fun replaceFragment(
         fragmentManager: android.support.v4.app.FragmentManager,
         fragment: Fragment,
         withAnimation: Boolean,
         addToBackStack: Boolean,
         id: Int
     ) {

         // Initialize a Fragment Transaction.
         val ft: FragmentTransaction = fragmentManager.beginTransaction()
         if (withAnimation) {
             // TO ENABLE FRAGMENT ANIMATION
             ft.setCustomAnimations(
                 R.animator.slide_in_left_object_animator,
                 R.animator.slide_out_left_object_animator,
                 R.animator.slide_in_right_object_animator,
                 R.animator.slide_out_right_object_animator
             )
         }
         ft.replace(id, fragment, fragment.getTag())

         // Add the transaction to backStack with tag of first added fragment
         if (addToBackStack) {
             ft.addToBackStack(fragment.getTag())
         }

         // Commit the transaction.
         ft.commit()
     }*/
}