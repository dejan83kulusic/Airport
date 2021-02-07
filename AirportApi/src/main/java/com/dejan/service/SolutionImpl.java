package com.dejan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

@Service
class SolutionImpl implements Solucija{
	

	
	
	class node{
		int v,val;
		public node(int v,int val) {
			this.v=v;
			this.val=val;
		}
	}
	
	class node1{
		int id,num,val;
		public node1(int id,int num,int val) {
			this.id=id;
			this.num=num;
			this.val=val;
		}
	}
	
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    	
    	int ans=Integer.MAX_VALUE;
    	int[][] dis=new int[n][K+1];
    	Queue<node1> q=new LinkedList<>();
    	Map<Integer, List<node>> road=new HashMap<Integer, List<node>>();
    	
    	for(int i=0;i<flights.length;i++) {
    		if(!road.containsKey(flights[i][0]))
    			road.put(flights[i][0], new ArrayList<>());
    		road.get(flights[i][0]).add(new node(flights[i][1],flights[i][2]));
    	}
    	
    	for(int i=0;i<n;i++)
    		for(int j=0;j<=K;j++)
    			dis[i][j]=Integer.MAX_VALUE-20000;
    	
    	q.add(new node1(src,0,0));
    	dis[src][0]=0;
    	
    	while(!q.isEmpty()) {
    		node1 now=q.poll();
    		//System.out.println(now.id);
    		if(now.id==dst || !road.containsKey(now.id))
    			continue;
    		//System.out.println(now.val);
    		for(int i=0;i<road.get(now.id).size();i++) {
    			int index=road.get(now.id).get(i).v;
    			int weight=road.get(now.id).get(i).val;
    			int num=(index==dst?now.num:now.num+1);
    			if(num>K) continue;
    			if(dis[index][num]>dis[now.id][now.num]+weight) {
    				dis[index][num]=dis[now.id][now.num]+weight;
    				q.add(new node1(index,num,dis[index][num]));
    			}
    		}
    	}
    	
    	for(int i=0;i<=K;i++)
    		ans=Math.min(ans, dis[dst][i]);
    	return ans==Integer.MAX_VALUE-20000?-1:ans;
    }
}