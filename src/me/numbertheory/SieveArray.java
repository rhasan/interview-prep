package me.numbertheory;

import java.util.ArrayList;
import java.util.List;

import javax.naming.LimitExceededException;

public class SieveArray {
	
	private final int MAX_LIMIT;
	private boolean[] composite;
	private List<Integer> primes;
	
	public SieveArray(int max_limit) {
		MAX_LIMIT = max_limit;
		composite = new boolean[MAX_LIMIT+1];
		composite[0] = true;
		composite[1] = true;
		
		for(int i = 2+2; i <= MAX_LIMIT; i+=2) {
			composite[i] = true;
		}
		for(long i = 3; i*i <= MAX_LIMIT; i+=2) {
			if(composite[(int)i] == false) {
				for(int j = (int) (i + i); j <= MAX_LIMIT; j += i) {
					composite[j] = true;
				}
			}
		}
		primes = new ArrayList<Integer>();
		
		for(int i = 1; i <= MAX_LIMIT; i++) {
			try {
				if(isPrime(i)) primes.add(i);
			} catch (LimitExceededException e) {
				
			}
		}
	}
	
	public boolean isPrime(long x) throws LimitExceededException {
		
		if(x <= MAX_LIMIT)	return !composite[(int)x];
			
		assert x > MAX_LIMIT;
		
		
		long lastPrime = primes.get(primes.size()-1);
		if( x > lastPrime * lastPrime) throw new LimitExceededException("Maximum value can be:" + (lastPrime * lastPrime));
		assert x <= lastPrime * lastPrime;
		
		for(int i= 0 ; i < primes.size(); i++) {
			if(x % primes.get(i) == 0) return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) throws LimitExceededException {
		SieveArray sieve = new SieveArray(10000000);
		System.out.println(sieve.isPrime(2879));
	}

}
