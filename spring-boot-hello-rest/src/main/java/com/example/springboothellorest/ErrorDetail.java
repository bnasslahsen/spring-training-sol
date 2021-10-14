package com.example.springboothellorest;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

/**
 * @author bnasslahsen
 */
@Data
@Builder
public class ErrorDetail {

	private String id;

	private String message;

}
