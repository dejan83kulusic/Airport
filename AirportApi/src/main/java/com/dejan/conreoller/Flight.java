package com.dejan.conreoller;

public class Flight {

	private int[][] flights;
	private int src;
	private int dst;

	public Flight(int[][] flights, int src, int dst) {
		super();
		this.flights = flights;
		this.src = src;
		this.dst = dst;
	}

	public Flight() {

	}

	public int[][] getFlights() {
		return flights;
	}

	public void setFlights(int[][] flights) {
		this.flights = flights;
	}

	public int getSrc() {
		return src;
	}

	public void setSrc(int src) {
		this.src = src;
	}

	public int getDst() {
		return dst;
	}

	public void setDst(int dst) {
		this.dst = dst;
	}

}
