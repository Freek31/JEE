package service.exceptions;


public class ServiceFactoryException extends RuntimeException { 

 	private static final long serialVersionUID = 1L; 

 	public ServiceFactoryException() { 
 		super(); 
 	} 
 
 	public ServiceFactoryException(String message, Throwable cause, 
 			boolean enableSuppression, boolean writableStackTrace) { 
 		super(message, cause, enableSuppression, writableStackTrace); 
 	} 
 
 	public ServiceFactoryException(String message, Throwable cause) { 
 		super(message, cause); 
 	} 

 	public ServiceFactoryException(String message) { 
 		super(message); 
 	} 
 
 	public ServiceFactoryException(Throwable cause) { 
 		super(cause); 
 	} 
} 