package com.caner.ws;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.caner.entity.GaleriEntity;

@Path("/deneme")
public class GaleriService {

	GaleriOperation galeriOperiton = new GaleriOperation();

	@GET
	@Path("/getGaleri")
	@Produces(MediaType.APPLICATION_JSON)

	public Response getGaleri() throws Throwable {
		try {
			galeriOperiton.selectDatabase();
		} catch (Exception e) {
			System.err.println("Hata select : \n" + e);
		}
		return Response.ok(galeriOperiton.selectDatabase().toString()).build();
	}

	@POST
	@Path("/postGaleri")
	@Produces(MediaType.APPLICATION_JSON)
	public Response postGaleri(ArrayList<GaleriEntity> galeriEntity) throws Throwable {
		// int listCount = galeriEntity.size();

		// System.out.println("Araba ismi : " + galeriEntity.get(0).getCarName());
		// System.out.println("Araba modeli : " + galeriEntity.get(0).getCarModel());
		// System.out.println("Araba rengi : " + galeriEntity.get(0).getCarColour());

		// for (int i = 0; i < listCount; i++) {
		// GaleriEntity galeriList = galeriEntity.get(i);
		//
		// System.out.println("Araba ismi : " + galeriList.getCarName());
		// System.out.println("Araba modeli : " + galeriList.getCarModel());
		// System.out.println("Araba rengi : " + galeriList.getCarColour());
		// }

		/*
		 * Json datalarını okuyarak veritabanına eklendi 
		 * Body-raw json  şeklinde
		 */
		for (GaleriEntity galeriEntity2 : galeriEntity) {

			System.out.println("Araba ismi 		: " + galeriEntity2.getCarName());
			System.out.println("Araba modeli	: " + galeriEntity2.getCarModel());
			System.out.println("Araba rengi 	: " + galeriEntity2.getCarColour());
			galeriOperiton.insertDatabase(galeriEntity2);

		}

		try {

		} catch (Exception e) {
			System.err.println("Hata post insert : " + e);
		}
		return Response.status(Status.CREATED).build();
	}

	@POST
	@Path("/postUpdate")
	@Produces(MediaType.APPLICATION_JSON)
	public Response postUpdateGaleri(ArrayList<GaleriEntity> galeriEntity) throws SQLException {
		/*
		 * update ile postmenden gonderdigim datalari  databaseye guncelledik
		 * body-raw json tipinde degisiklik yapildi
		 */
		
		for (GaleriEntity updateGaleri : galeriEntity) {

			galeriOperiton.updateDatabase(updateGaleri);
		}
		try {

		} catch (Exception e) {
			System.err.println("Hata post update : " + e);
		}
		return Response.status(202).build();
	}
}