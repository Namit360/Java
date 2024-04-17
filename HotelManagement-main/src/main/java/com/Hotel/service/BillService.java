package com.Hotel.service;

import java.util.List;
import com.Hotel.model.Bill;

public interface BillService {

    public Bill saveBill(Bill bill);
    public List<Bill> getAllBill();
    public Bill getBillById(Long id);
    public void deleteBillById(Long id);
    public void updateBill(Bill guest);

}