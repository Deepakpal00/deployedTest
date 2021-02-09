package com.deployed.serviceImplementation;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.springframework.stereotype.Service;

import com.deployed.service.CalculateCostService;

@Service
public class CalculateCostServiceImpl implements CalculateCostService{

	@Override
	public int calculateMinCost(int[] input) {

		if(input.length<=0) {
			return 0;
		}

		if(input.length==1) {
			return input[0];
		}

		// calculating array length 
		int inputLength = input.length;

		int minCost = 0;

		// Create a priority queue rather than heap because we can create heap by using PriorityQueue
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(); 

		Arrays.stream(input).forEach(e->priorityQueue.add(e));


		//poll all elements from queue until the queue size is 1 for calculation
		while (priorityQueue.size() > 1) { 
			int first = priorityQueue.poll(); 
			int second = priorityQueue.poll(); 
			minCost = minCost + first + second; 
			priorityQueue.add(first + second); 
		}

		return minCost;

	}
}
