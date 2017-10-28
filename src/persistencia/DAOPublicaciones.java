package persistencia;

import java.util.LinkedList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import modelo.Publicacion;



public class DAOPublicaciones {

    
	public static void insert(Publicacion publicacion) {
		Document doc=new Document();
		doc.append("name", publicacion.getNombre());
		doc.append("email", publicacion.getEmail());
		doc.append("fecha", publicacion.getFecha());
		doc.append("mensaje", publicacion.getMensaje());
		doc.append("imagen", publicacion.getImagen());
		
		
		
		MongoBroker broker= MongoBroker.get();
		MongoCollection<Document>publicaciones=broker.getCollection("Publicaciones");
		publicaciones.insertOne(doc);
		
	}
	

	
	public static void update (Publicacion publicacion) throws Exception {
		Document doc=new Document();
		doc.append("id", publicacion.getIdPublicacion());
		
		MongoBroker broker= MongoBroker.get();
		MongoCollection<Document>publicaciones=broker.getCollection("Publicaciones");
		publicaciones.deleteOne(doc);
		
		Document doc2=new Document();
		doc2.append("name", publicacion.getNombre());
		doc2.append("email", publicacion.getEmail());
		doc2.append("mensaje",publicacion.getMensaje());
		doc2.append("imagen", publicacion.getImagen());
		doc2.append("fecha", publicacion.getFecha());
		
	
		publicaciones.insertOne(doc2);
		
	}

	public static Publicacion select(int idPublicacion) throws Exception {
		Publicacion result = null;
		MongoBroker broker = MongoBroker.get();
		MongoCollection<Document> publicaciones=broker.getCollection("Publicaciones");
		Document criterio=new Document();
		criterio.append("id", idPublicacion);
		
		FindIterable<Document> resultado=publicaciones.find(criterio);
		Document publicacion=resultado.first();
		
		if (publicacion!=null) {
			result = new Publicacion(publicacion.getInteger("idPublicacion"), publicacion.getString("email"), 
			publicacion.getString("nombre"), publicacion.getString("fecha"), publicacion.getString("imagen"), publicacion.getString("mensaje"));
		}
		
		return result;
	}
	
	public static void delete(Publicacion publicacion) {
		Document bso=new Document();
		bso.append("idPublicacion", publicacion.getNombre());
		
		MongoBroker broker= MongoBroker.get();
		MongoCollection<Document>publicaciones=broker.getCollection("Publicaciones");
		publicaciones.deleteOne(bso);
		
	}
	

}
