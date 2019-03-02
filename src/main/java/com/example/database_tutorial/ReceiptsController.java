package com.example.database_tutorial;

import com.example.database_tutorial.models.Outlet;
import com.example.database_tutorial.models.Receipts;
import com.example.database_tutorial.repositories.ReceiptsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/receipts")
public class ReceiptsController {

    @Autowired
    private ReceiptsRepository repository;

    @RequestMapping(value = "/daily/{restId}", method = RequestMethod.GET)
    public HashMap<String, Double> getDailyReportForOutlet(@PathVariable("restId") String restId){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy");
        return saleForOutlet(restId, simpleDateFormat);
    }

    @RequestMapping(value = "/monthly/{restId}", method = RequestMethod.GET)
    public HashMap<String, Double> getMonthlyReportForOutlet(@PathVariable("restId") String restId){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM, yyyy");
        return saleForOutlet(restId, simpleDateFormat);
    }

    @RequestMapping(value = "/weekly/{restId}", method = RequestMethod.GET)
    public HashMap<String, Double> getWeeklyReportForOutlet(@PathVariable("restId") String restId){
        HashMap<String, Double> outletSaleByDate = new HashMap<>();
        for (Receipts receipt :
                repository.findAll()) {
            for (Outlet outlet :
                    receipt.outlets) {
                if (outlet.restId.equals(restId)){
                    amountForOutlet(outletSaleByDate, receipt.getDateAsWeek(), outlet.grandtTotal);
                }
            }
        }
        return outletSaleByDate;
    }

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public HashMap<String, Double> getPaymentForAllRestaurants(){
        HashMap<String, Double> totalAmountToOutlets = new HashMap<>();
        for (Receipts receipt :
                repository.findAll()) {
            for (Outlet outlet :
                    receipt.outlets) {
                amountForOutlet(totalAmountToOutlets, outlet.restId, outlet.grandtTotal);
            }
        }
        return totalAmountToOutlets;
    }

    

    private void amountForOutlet(HashMap<String, Double> paymentByRestaurant, String key, Double value) {
        Double amount;
        if(paymentByRestaurant.containsKey(key)) {
            amount = paymentByRestaurant.get(key) + value;
        }
        else {
            amount = value;
        }
        paymentByRestaurant.put(key, amount);
    }


    private HashMap<String, Double> saleForOutlet(String restId, SimpleDateFormat simpleDateFormat) {
        HashMap<String, Double> outletSaleByDate = new HashMap<>();
        for (Receipts receipt :
                repository.findAll()) {
            for (Outlet outlet :
                    receipt.outlets) {
                if (outlet.restId.equals(restId)){
                    amountForOutlet(outletSaleByDate, receipt.getDate(simpleDateFormat), outlet.grandtTotal);
                }
            }
        }
        return outletSaleByDate;
    }
}
