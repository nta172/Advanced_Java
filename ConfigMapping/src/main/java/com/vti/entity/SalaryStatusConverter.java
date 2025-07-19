package com.vti.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.vti.entity.Salary.Status;

@Converter(autoApply = true)

public class SalaryStatusConverter implements AttributeConverter<Salary.Status, String> {

	@Override
	public String convertToDatabaseColumn(Status status) {
		if (status == null) {
			return null;
		}
		return status.getStatus();
	}

	@Override
	public Status convertToEntityAttribute(String sqlStatus) {
		if (sqlStatus == null) {
			return null;
		}
		return Salary.Status.toEnum(sqlStatus);
	}

}
