package com.vic.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author vic
 * date: 29/11/2022
 * purpose: The Service Class
 *
 */
@Service
public class MirroredNumService {

	public boolean getMirrored(int number) {
		int num = number;
		int reverse = 0;
		
		while(num > 0) {
           int remainer = num % 10;
           reverse = reverse * 10;
           reverse = reverse + remainer;
           num = num / 10;
	       } 
		if(number == reverse)
			return true;
		else 
			return false;
	}
}
