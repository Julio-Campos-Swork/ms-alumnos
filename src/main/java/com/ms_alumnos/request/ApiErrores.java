package com.ms_alumnos.request;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatusCode;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ApiErrores {

	private String mensaje;
	private List<String> detalles;
	private HttpStatusCode status;
	private LocalDateTime timestamp;

	

}
