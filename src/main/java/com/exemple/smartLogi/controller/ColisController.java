package com.exemple.smartLogi.controller;

import com.exemple.smartLogi.model.Colis;
import com.exemple.smartLogi.model.enums.ColisStatut;
import com.exemple.smartLogi.service.coli.ColisService;
import com.exemple.smartLogi.service.livreur.LivreurService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

public class ColisController implements Controller {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ColisService colisService;
    private LivreurService livreurService;

    public ColisController(ColisService colisService){
        this.colisService = colisService;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/json");
        String method = request.getMethod();
        if (method.equals("GET")) {
            List<Colis> listColis = colisService.listerTous();
            response.getWriter().write(objectMapper.writeValueAsString(listColis));
            return null;
        }else if (method.equals("POST")) {
            String idLivreur = request.getParameter("idLivreur");
            double poidsStr = Double.parseDouble(request.getParameter("poids"));
            String destinataire = request.getParameter("destinataire");
            String adresse = request.getParameter("adresse");
            ColisStatut statut = ColisStatut.valueOf(request.getParameter("statut"));

            Colis colis = new Colis();
            colis.setLivreur(livreurService.trouverParId(idLivreur));
            colis.setStatut(statut);
            colis.setDestinataire(destinataire);
            colis.setAdresse(adresse);
            colis.setPoids(poidsStr);

           return  new ModelAndView("jsonView","coli",colis);
        }

        return null;
    }

    public void setLivreurService(LivreurService livreurService) {
        this.livreurService = livreurService;
    }
}
