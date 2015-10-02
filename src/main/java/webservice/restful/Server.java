package webservice.restful;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import webservice.restful.RoomDAO.Rooms;

public class Server {
	public static void main(String[] args) {  
        RoomService service = new RoomService(); 
  
        // Service instance  
        JAXRSServerFactoryBean restServer = new JAXRSServerFactoryBean();  
        restServer.setResourceClasses(Room.class,Person.class,Rooms.class);  
        restServer.setServiceBean(service);
        restServer.setAddress("http://localhost:9999/");  
        restServer.create();  
    }  
}
