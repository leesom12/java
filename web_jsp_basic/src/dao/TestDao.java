package dao;

import java.util.ArrayList;

import dto.TsetDto;

public class TestDao {
	
	public int getTotal(int a, int b) {
		return a+b;
	}
	
	public ArrayList<TsetDto> getList(){
		ArrayList<TsetDto> dtos= new ArrayList<>();
		TsetDto dto1= new TsetDto("이상민","서울",30);
		TsetDto dto2= new TsetDto("박사율","부산",25);
		dtos.add(dto1);
		dtos.add(dto2);
		return dtos;
	}
}
