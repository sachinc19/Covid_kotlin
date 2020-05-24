package com.aai.covid_kotlin.constant

object Constant {
    const val mBroadcastStringAction = "com.truiton.broadcast.string"
    const val mBroadcasAction = "com.truiton.broadcast.loc"
    const val RECEIVE_LOC = "com.ipms.RECEIVE_LOC"

    const val SCAN_CONTENT = "scan_content"
    var SAVE_TOKEN = "save_token"
    var TAG_SAVE_SENSITIVE_COUNTRY = "tag_save_sensitive_country"
    var TAG_SAVE_TRAVELLLER_DETAISL = "tag_save_traveller_details"
    var TAG_GET_TRAVELLLER_DETAISL = "tag_get_traveller_details"
    var TAG_LOGIN = "tag_login"

    var PASSENGER_DETAILS = "PASSANGER_DETAILS"

    var F_TAG_BODY_TEMP = "F_TAG_BODY_TEMP"
    var F_TAG_SCANNER_DETAILS = "F_TAG_SCANNER_DETAILS"

    var hint_Search_location = "Select location"

    var hint_Search_location_in_city = "Select location in City"
    var hint_Search_travellerArrivalDate = "Select Traveller Arrival Date"
    var hint_Search_travellerCountryOfOrgin = "Select Traveller Country OfOrgin"
    var hint_Search_travellingDestination = "Select Travelling Destination"
    var hint_Search_travellerBodyTemp = "Enter Traveller BodyTemp"


    var TITLE_hospital_list = "HOSPITAL LIST"
    var TITLE_BOdy_temp = "BODY TEMP"
    var TITLE_SCANNER_DETAILS = "SCANNER DETAILS"
    var TITLE_TRAVELLER_TRACKING_MAP = "TRAVELLER TRACKING MAP"
    //get location
    var sLatitude = 0.0
    var sLongitude = 0.0


    const val select_Login_Mode = "Select Login Mode"
    const val state = "State"
    const val taluka = "Taluka"
    const val rashan_Shop = "FCS Shop"

    const val wRashan_shop = "FCS Shop"
    const val wTaluka = "Taluka Warehouse"
    const val wState = "State Warehouse"

    const val OutWard = "OutWard"
    const val InWard = "InWard"
    const val Rashan_User = "FCS User"

    const val USER_MODE = "USER_MODE"
    const val QR_code_wheat = "WHEAT"
    const val QR_code_rice = "RICE"
    const val QR_code_sugar1 = "SUGAR"

    ////////////////
    var IMG_CODE = 222
    var isgetAssetLocationList = true

    const val Broadcast_BACKTODASHBOARD = "broadcast_backtodashboard"
    const val IS_PERMISSION_DENIED = "permission_denied"
    var isFamilySel = false
    const val address1 = "ADDRESS1"
    var TAG_ALL_TASK_MASTER = "tag_all_task_master"
    var TAG_getpurchaseorderinfo = "tag_getpurchaseorderinfo"
    var U_UPDATE_TASK_MASTER_DATA = "u_update_task_masteradata" //service unique tag

    var U_ADDRESS_CHILD = "u_address_child"
    ///fragment tag
    var F_TAG_MAIN_MENU = "F_TAG_MAIN_MENU"
    var F_TAG_SUB_MENU = "F_TAG_SUB_MENU"

    var F_TAG_PO_APPROVAL_TASK = "F_TAG_PO_APPROVAL_TASK"
    var F_TAG_PURCHASE_ORDER = "F_TAG_PURCHASE_ORDER"
    var F_TAG_RATE_CONTRACT = "F_TAG_RATE_CONTRACT"
    var F_TAG_RATE_CONTRACT_TASK = "F_TAG_RATE_CONTRACT_TASK"
    var F_TAG_PO_AMENDMENT = "F_TAG_PO_AMENDMENT_TASK"
    var F_TAG_PO_STATUS_REPORT = "F_TAG_PO_STATUS_REPORT"
    var F_TAG_PO_APROVAL_STATUS_REPORT_DETAILS =
        "F_TAG_PO_APROVAL_STATUS_REPORT_DETAILS"
    var F_TAG_PO_SUMMARY_REPORT = "F_TAG_PO_SUMMARY_REPORT"
    var F_TAG_PO_PERIODIC_REPORT = "F_TAG_PO_PERIODIC_REPORT"
    var F_TAG_SUPPLIER_WISE_REPORT = "F_TAG_SUPPLIER_WISE_REPORT"
    var F_TAG_PENDING_PAYMENT_REPORT = "F_TAG_PENDING PAYMENT_REPORT"
    var F_TAG_Monthly_PAYMENT_REPORT = "F_TAG_MONTHLY_PAYMENT_REPORT"
    var F_TAG_ASSETS_REPORT = "F_TAG_ASSETS_REPORT"
    var F_TAG_CITY_ASSETS_REPORT = "F_TAG_CITY_ASSETS_REPORT"
    var F_TAG_DASHBOARD = "F_TAG_DASHBOARD"
    var F_TAG_NOTIFICATION = "F_TAG_NOTIFICATION"
    var F_TAG_TICKET_PENDING = "F_TAG_TICKET_PENDING"
    var F_TAG_TICKET_DETAILS = "F_TAG_TICKET_DETAILS"
    var F_TAG_HISTORY_DETAILS = "F_TAG_HISTORY_DETAILS"
    var F_TAG_PRS_MASTER = "F_TAG_PRS_MASTER"
    var F_TAG_PRS_TASK_MASTER = "F_TAG_PRS_TASK_MASTER"
    var F_TAG_ASSET_MANANGEMENT = "F_TAG_ASSET_MANAGEMENT"
    var F_TAG_TICKET_MIS = "F_TAG_TICKET_MIS"
    var F_TAG_PREVENTIVE_MAINTENANCE = "F_TAG_PREVENTIVE_MAINTENANCE"

    var CONSUMERPROFILE = "CONSUMERPROFILE"
    var MENULIST = "MENULIST"
    var ASSIGN_DISTRICT = "Assign_district"
    //folder Name
    var MENUFOLDER = "MENUFOLDER"
    //share preference
    var USERTOKEN = "USERTOKEN"
    var ROLEJOB = "ROLEJOB"
    var EMPLOYEE_CODE = "employee_code"
    var EMPLOYEE_NAME = "employee_name"
    var SELECTEDDISTRICT = "selecteddistrict"
    var FB_menuname = "fb_menuname" //fb fragment bundle

    //hintd
    var hint_serach_by_po_status = "Search by Po status"
    var hint_Search_by_aprroval_level = "Search by Approval level"
    var hint_Search_by_project = "Search by project"
    var hint_Search_by_vender = "Search by Vendor"
    var hint_Search_by_Department = "Search by Department"
    var hint_Search_by_From_Date = "From Date"
    var hint_Search_by_To_Date = "To Date"
    var hint_Search_by_workflow = "Select WorkFlow"
    var hint_Search_by_Till_Date = "Till Date"
    var hint_Search_by_year = "-Select Year-"
    var hint_Search_by_Month = "-Select Month-"
    var hint_Search_by_select_category = "Select Category"
    var hint_Search_by_select_sub_category = "Select Sub Category"
    var hint_Search_by_select_product = "Select Product"
    var hint_Search_by_select_city = "-Select City-"
    var hint_Search_by_select_location = " -Select Location-"
    var hint_Search_by_org = "Search by Organisation"

    var hint_Search_District = " -Select District-"
    var hint_Search_by_City = " -Select City-"
    var hint_Search_by_select_policeStation = " -Select PoliceStation-"
    var hint_Asset_Status = " -Asset Status-"
    var select_ticket_type = "Select Ticket Type"
    var Search_by_account_name = "Search by account"
    var select_status = "Select Status"
    var select_priority = "Select Priority"
    var select_ticket_owner = "Select Ticket Owner"
    var select_classification = "select Classification"
    var select_ticket_category = "Select Ticket Category"
    var select_ticket_subcategory = "Select Ticket Sub-Category"
    var select_Asset_name = "Select Asset Name"
    var select_Assignedto = "Select Assigned To"
    var select_Action = "Select Action"
    var select_resolvedDate = "Select Resolved Date"
    var Select_Vender_Name = "Select Vender Name"
    //preventive Maintenance
    var date = "Date"
    var PM_date = "PM Date"
    var next_due_date = "Next Due Date"
    var ptw_no = "Enter PTW NO"
    var Next_Due_Date = "Next Due Date"


    var F_TAG_PMVIEW = "F_TAG_PMVIEW"
    var F_TAG_PMTASK = "F_TAG_PMTASK"


    var hint_select_date_range = "Select Both From Date & To Date!"

    //page size
    const val PAGE_SIZE = 25
    //Page Title
    var TITLE_DASHBOARD = "DASHBOARD"
    var TITLE_SUBMENU = "IPMS"
    var TITLE_PO_DETAIL = "PURCHASE ORDER"
    var TITLE_PO_APPROVAL_TASK = "PO APPROVAL TASK"
    var TITLE_RATE_CONTRACT = "RATE CONTRACT"
    var TITLE_RATE_CONTRACT_TASK = "RATE CONTRACT TASK"
    var TITLE_PO_AMENDMENT_TASK = "PO AMENDMENT TASK"
    var TITLE_DEFAULT = "DETAILS"
    var TITLE_PO_STATUS_REPORT = "PO STATUS REPORT"
    var TITLE_PO_SUMMARY_REPORT = "PO SUMMARY REPORT"
    var TITLE_PO_PERIODIC_REPORT = "PO PERIODIC REPORT"
    var TITLE_SUPPLIER_WISE__REPORT = "SUPPLIER WISE REPORT"
    var TITLE_PENDING_PAYMENT__REPORT = "PENDING PAYMENT REPORT"
    var TITLE_MONTHLY_PAYMENT__REPORT = "MONTHLY PAYMENT REPORT"
    var TITLE_ASSETS__REPORT = "ASSETS REPORT"
    var TITLE_CITY_ASSETS__REPORT = "CITY WISE ASSETS"
    var TITLE_NOTIFICATION = "NOTIFICATION"
    var TITLE_REPORT = "REPORT"
    var TITLE_PO_MANAGEMENT = "PO MANAGEMENT"
    var TITLE_HELP_DESK = "HELP DESK"
    var TITLE_TICKET_MASTER = "TICKET MASTER"
    var TITLE_PENDING_TICKET = "PENDING TICKETS"
    var TITLE_PRS_MASTER = "PRS MASTER"
    var TITLE_PRS_TASK_MASTER = "PRS TASK MASTER"
    var TITLE_ASSET_MANAGEMENT = "ASSET MANAGEMENT"
    var TITLE_ASSET_SETTING = "ASSET SETTINGS"
    var TITLE_MIS = "TICKET MIS REPORT"
    var TITLE_PREVENTIVE_MAINTENANCE = "PREVENTIVE MAINTENANCE"


    //image gallaty
    const val IMAGE_DIRECTORY_NAME = "GSG_gallary"
    const val IMG_URL = "img_url"

    //notification
    const val NOTIFICATION_PONO = "message"
    const val NOTIFICATIONTYPE = "notificationType"
    const val NOTICFICATION_TICKETNO = "ticketNo"
    const val NOTIFICATION_Reg_Id = "RegId"
    const val ISNOTIFICATION_READ = "isNotificationRead"
    const val mNotification = 1
    const val mLogin = 2

    // po Approval event
    var clickevent = 0 //default

    const val po_no_evnt = 0
    const val annexture_attachment_evnt = 1

    const val TeamLeader = "TEAM LEADER"

    const val Search_by_AssetName = "Search by Asset Name"
    const val Search_by_Station_Location = "Search by Station Location"
    const val Search_by_AssetCategory = "Search by Asset Category"
    const val SearchbyPMstatus = "Search by PM status"


}