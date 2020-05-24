package com.aai.covid_kotlin.constant

object ApiConstant {

    /*    const val ipAddress = "http://gsgassetsdev.aurionpro.com:8180/covid-api/"

    const val aai_login = ipAddress + "login"
    const val saveTravellerDetails = ipAddress + "endpoint/traveller/saveTravellerDetails"
    const val saveSenstiveCountries = ipAddress + "endpoint/country/saveSenstiveCountries"
    const val getAllTraveller = ipAddress + "endpoint/traveller/getAllTraveller"
    const val getNearestPhcc = ipAddress + "endpoint/phcc/getNearestPhcc"
    const val sendMail = ipAddress + "endpoint/traveller/sendMail"
    const val getDataOfInfectedPeoplePerDay = ipAddress + "endpoint/dashboard/getDataOfInfectedPeoplePerDay"
    const val getDataOfInfectedPeopleAirportWise = ipAddress + "endpoint/dashboard/getDataOfInfectedPeopleAirportWise"
    const val updateUser = ipAddress + "endpoint/user/updateUser"
    */


    //Production URL.:
/*
     const val ipAddress = "http://gsgassets.aurionpro.com:8092/consumer/rest/consumerTestService"
*/
    //DEVELOPMENT URL
     const val ipAddress = "http://gsgassetsdev.aurionpro.com:8095/consumer/rest/dit/consumerTestService/";
    //this url link for preventive maintenance
/*
    private const val ipAddress = "http://gsgassetsdev.aurionpro.com:8094/consumer/rest/pmproject/consumerTestService";
*/

    //DEVELOPMENT URL
    /*private static final String ipAddress = "http://gsgassetsdev.aurionpro.com:8095/consumer/rest/dit/consumerTestService";*/ //this url link for preventive maintenance
    /*  private static final String ipAddress = "http://gsgassetsdev.aurionpro.com:8094/consumer/rest/pmproject/consumerTestService";*/
    const val forgetpassword: String = ipAddress + "core/user/forgetpassword"
    const val loginVerifivcation: String = "core/user/loginverification" //need to change
    const val logoutapi1: String = ipAddress + "core/user/logout"
    const val getallorders: String = ipAddress + "core/purchaseOrder/getallorders" //search po

    const val getpurchaseorderinfo: String = ipAddress + "core/purchaseOrder/getpurchaseorderinfo"
    const val getalltaskmaster: String = ipAddress + "core/master/getalltaskmaster"
    const val getallCategory: String = ipAddress + "core/master/getallcategory"
    const val getsubCategory: String = ipAddress + "core/master/getsubcategorybycategoryid"
    const val getallticketdata: String = ipAddress + "core/master/getallticketdata"
    const val getticketbyid: String = ipAddress + "core/master/getticketbyid" //getticketbyid/{id}

    const val getPOHistorybyid: String =
        ipAddress + "core/master/getPOHistorybyid" //getPOHistorybyid/{id}

    const val getvendorcomparisonfrompurchaseorder: String =
        ipAddress + "core/master/getvendorcomparisonfrompurchaseorder"

    const val updateTaskMasterData: String = ipAddress + "core/master/updateTaskMasterData"
    const val report_getpendingpayment: String = ipAddress + "core/master/getpendingpaymentreport"
    const val gettaskreportbyid: String = ipAddress + "core/master/gettaskreportbyid"
    const val report_getmonthwisepaymentreport: String =
        ipAddress + "core/master/getmonthwisepaymentreport"
    const val getallcityfordropdown: String = ipAddress + "core/master/getallcityfordropdown"
    const val getlocationByCity: String = ipAddress + "core/master/getlocationByCity"
    const val getassetByLocation: String = ipAddress + "core/asset/getassetByLocation"
    const val getassetbyid: String = ipAddress + "core/asset/getassetbyid" ///getassetbyid/{id}

    const val getallassetfordropdown: String = ipAddress + "core/asset/getallassetfordropdown"
    const val getasset: String = ipAddress + "core/asset/getasset" //get asset by category

    const val savemobileappkey: String =
        ipAddress + "core/register/savemobileappkey" ///getassetbyid/{id}

    const val getallActiveConsumerprofile: String =
        ipAddress + "core/register/getallActiveConsumerprofile"
    const val addresschild: String = ipAddress + "party/partymaster/getaddresschild/"
    const val getallpartyinfo: String = ipAddress + "party/partymaster/getallpartyinfo" //get

    const val getDetartment: String = ipAddress + "core/Dept/getAllDeptWithRights"
    const val rcOrders: String = ipAddress + "core/rcOrder/getallorders"
    const val rcgetpurchaseorderinfo: String = ipAddress + "core/rcOrder/getpurchaseorderinfo"
    const val report_getApprovalCount: String = ipAddress + "core/report/getApprovalCount"
    const val report_getallapprovalreport: String = ipAddress + "core/report/getallapprovalreport"
    const val report_getprojectvendorwisereport: String =
        ipAddress + "core/report/getprojectvendorwisereport"
    const val report_getallsupplierreport: String = ipAddress + "core/report/getallsupplierreport"
    const val report_getAssetsCount: String = ipAddress + "assets/report/getAssetsCount"
    const val report_getCatWiseReport: String = ipAddress + "core/pOReport/getCatWiseReport"
    const val getAllProductData: String = ipAddress + "core/product/getAllProductData"
    const val rcTaskgetalltaskmaster: String = ipAddress + "core/rctask/getalltaskmaster"
    const val getProjectNames: String = ipAddress + "dashboard/project/getProjectNames"
    const val rcUpdatedTaskMasterData: String = ipAddress + "core/rctask/updateTaskMasterData"
    const val rcGetPOHistorybyid: String =
        ipAddress + "core/rctask/getPOHistorybyid" //getPOHistorybyid/{id}

    const val getAllAmendmentTask: String = ipAddress + "core/amendment/getAllAmendmentTask"
    const val getAllHistoryTaskAmendment: String =
        ipAddress + "core/amendment/getAllHistoryTaskAmendment"
    const val updateAmendmentTask: String = ipAddress + "core/amendment/updateAmendmentTask"
    const val getAllOpenTicket: String = ipAddress + "ticket/ticketActionHistory/getAllOpenTicket"
    const val updateTicketHistoryData: String =
        ipAddress + "ticket/ticketActionHistory/updateTicketHistoryData"
    const val getHistoryTicketList: String =
        ipAddress + "ticket/ticketActionHistory/getHistoryTicketList"
    const val getallprsSearch: String = ipAddress + "core/master/getallprsSearch"
    const val getprsbyid: String = ipAddress + "core/master/getprsbyid" ///getprsbyid/{id}

    const val getAllPrsTask: String = ipAddress + "core/prs/getAllPrsTask"
    const val updatePrsTask: String = ipAddress + "core/prs/updatePrsTask"
    const val getAllHistoryTask: String = ipAddress + "core/prs/getAllHistoryTask"
    const val getPrsHistoryById: String =
        ipAddress + "core/prs/getPrsHistoryById" //getPrsHistoryById/{id}

    const val getparentticket: String = ipAddress + "core/master/getparentticket"
    const val getsubcategorybyticketid: String =
        ipAddress + "core/master/getsubcategorybyticketid"
    const val getallclassifications: String = ipAddress + "core/master/getallclassifications"
    const val getalllocationfordropdown: String =
        ipAddress + "core/master/getalllocationfordropdown"
    const val getallassetdata: String = ipAddress + "core/asset/getallassetdata"
    const val getassetauditbyid: String =
        ipAddress + "core/asset/getassetauditbyid" //getassetauditbyid/{id}

    const val updateassetdata: String = ipAddress + "core/asset/updateassetdata"
    const val getTicketAging: String = ipAddress + "ticket/report/getTicketAging"
    const val getVendor: String = ipAddress + "ticket/ticketActionHistory/getVendor"
    const val changepassword: String = ipAddress + "core/user/changepassword"
    const val getconsumerprofilebyid: String = ipAddress + "core/register/getconsumerprofilebyid"
    const val secondstepregistration: String = ipAddress + "core/register/secondstepregistration"
    const val getallorganisationsdropdown: String =
        ipAddress + "core/organisation/getallorganisationsdropdown"


}
