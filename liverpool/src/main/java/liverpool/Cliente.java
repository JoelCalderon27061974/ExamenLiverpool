package liverpool;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.jackson.JacksonFeature;

public class Cliente {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient().register(new JacksonFeature());
		List<Articulo> articulo = client
		.target("http://www.localhost:8080/articulos")
		.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Articulo>>() {
		});
		 
		for(Articulo a: articulo) {
			System.out.println(a.getId());
			System.out.println(a.getNombre());
			System.out.println(a.getDescripcion());
			System.out.println(a.getPrecio());
			System.out.println(a.getModelo());
		 
		}
	}

}
