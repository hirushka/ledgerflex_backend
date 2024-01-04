package com.hiru96.ledgerflex.Payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

	private Boolean success;
	private String message;

}
