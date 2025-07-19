package com.vti;

import java.util.List;

import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.Position.Status;
import com.vti.repository.PositionRepository;

public class ProgramPosition {
	public static void main(String[] args) {
		PositionRepository positionRepository = new PositionRepository();

		System.out.println("***********GET ALL POSITIONS***********");

		List<Position> positions = positionRepository.getAllPosition();

		for (Position position : positions) {
			System.out.println(position);
		}
//		
//		System.out.println("\n\n***********GET POSITION BY ID***********");
//
//		Position positionById = positionRepository.getPositionByID((short) 1);
//		System.out.println(positionById);
		
//		System.out.println("\n\n***********GET POSITION BY NAME***********");
//
//		Position positionByName = positionRepository.getPositionByName("SCRUMMASTER");
//		System.out.println(positionByName);
		
//		System.out.println("\n\n***********CREATE POSITION***********");
//
//		Position positionCreate = new Position();
//		positionCreate.setStatus(Position.Status.PM);
//		positionRepository.createPosition(positionCreate);
		
//		System.out.println("\n\n***********UPDATE DEPARTMENT 1***********");
//
//		positionRepository.updatePosition((short) 3, Position.Status.PM);
//		
//		System.out.println("\n\n***********UPDATE POSITION 2***********");
//
//		Position positionUpdate = new Position();
//		positionUpdate.setId((short) 2);
//		positionUpdate.setStatus(Position.Status.SCRUMMASTER);;
//		positionRepository.updatePosition(positionUpdate);
		
//		System.out.println("\n\n***********DELETE POSITIONS***********");
//		positionRepository.deletePosition((short) 2);
		
//		System.out.println("***********CHECK POSITIONS EXISTS BY ID***********");
//		System.out.println(positionRepository.isPositionExistsByID((short) 1));

//		System.out.println("***********CHECK POSITIONS EXISTS BY NAME***********");
//		System.out.println(positionRepository.isPositionExistsByName("TEST"));
	}
}
