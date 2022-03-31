package com.example.csv.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.csv.domain.Bank;
import com.example.csv.service.BankService;

@RestController
public class BankController {
	
	@Autowired
	private BankService bankService = new BankService();
	
	@GetMapping("/get")
	public String getResp() {
		
		return "Request received!";
	}
	//end point to see if the data is being loaded
	@RequestMapping("/getData")
	public List<Bank> getBankData() throws IOException {
		return bankService.getBankDetails();
	}
	//end point to do the search by city and state
	@RequestMapping("/searchByCityAndState")
	public List<Bank> searchByCityAndState(@RequestBody Bank bank){
		List<Bank> newList = new ArrayList<Bank>();
		try {
			List<Bank> banks = bankService.getBankDetails();
			//for each element in the list, check weather the given input is equal. 
			for(Bank b : banks) {
				if( b.getState().equals(bank.getState()) && b.getCity().equals(bank.getCity()) ) {
					newList.add(b);
				}
				System.out.println(b.toString());
			}
			
		} catch (IOException e) {
			System.out.println("Exception: "+e);
		}
		return newList;
	}
	//end point to search by city or state or type or name or zipcode.
	@RequestMapping("/searchByAll")
	public List<Bank> searchBank(@RequestBody Bank bank){
		List<Bank> newList = new ArrayList<Bank>();
		try {
			List<Bank> banks = bankService.getBankDetails();
	//for each element in the list, check if any of the criteria matches.	
			for(Bank b : banks) {
				if( b.getState().equals(bank.getState()) || b.getCity().equals(bank.getCity()) 
					|| b.getType().equals(bank.getType()) || b.getZipCode().equals(bank.getZipCode()) 
					|| b.getBankName().equals(bank.getBankName())  ) {
					newList.add(b);
				}
				System.out.println(b.toString());
			}
			
		} catch (IOException e) {
			System.out.println("Exception: "+e);
		}
		return newList;
	}

}
