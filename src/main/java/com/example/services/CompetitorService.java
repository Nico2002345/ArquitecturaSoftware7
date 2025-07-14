/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.Competitor;
import com.example.models.CompetitorDTO;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Stateless
@Path("/competitors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompetitorService {

    @PersistenceContext(unitName = "competitorPU")
    private EntityManager em;

    @GET
    public Response getAll() {
        try {
           List<Competitor> competitors = em.createQuery(
    "SELECT c FROM Competitor c ORDER BY c.surname ASC")
    .getResultList();
            return Response.ok(competitors)
                    .header("Access-Control-Allow-Origin", "*")
                    .build();

        } catch (Exception e) {
            return Response.status(500)
                    .entity(Collections.singletonMap("error", "No se pudo obtener la lista de competidores"))
                    .build();
        }
    }

    @POST
    @Path("/add")
    public Response createCompetitor(CompetitorDTO dto) {
        try {
            Competitor competitor = new Competitor(
                    dto.getName(),
                    dto.getSurname(),
                    dto.getAge(),
                    dto.getTelephone(),
                    dto.getCellphone(),
                    dto.getAddress(),
                    dto.getCity(),
                    dto.getCountry(),
                    false,
                    dto.getEmail(),
                    dto.getPassword()
            );

            em.persist(competitor);

           Map<String, Object> response = new HashMap<String, Object>();
            response.put("competitorId", competitor.getId());

            return Response.ok(response)
                    .header("Access-Control-Allow-Origin", "*")
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500)
                    .entity(Collections.singletonMap("error", "Error al guardar el competidor"))
                    .build();
        }
    }
}

