package com.example.csv.service;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.csv.domain.Bank;
//service layer to fetch the data
@Service
public class BankService {
		String line = "";
		//creating a list to store the data.
		public List<Bank> getBankDetails() throws IOException {
			
			List<Bank> banks = new ArrayList<>();
			//reading the given file using BufferedReader
			try {
				 BufferedReader br = new BufferedReader(new FileReader("src/main/resources/ProgrammingAssignment.csv")); 

					while((line =br.readLine())!= null) {
						Bank bank = new Bank();
						String [] data = line.split(",");
						
						bank.setId(data[0]);
						bank.setBankName(data[1]);
						bank.setType(data[2]);
						bank.setCity(data[3]);
						bank.setState(data[4]);
						bank.setZipCode(data[5]);
						banks.add(bank);
					}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
		
			}
			return banks;
			
		}
}

