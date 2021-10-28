package Controller;

import Model.Cinema;

import java.util.ArrayList;
import java.util.List;

public class CinemaController {

    private List<Cinema> cinemas = new ArrayList<>();
    private Long cinemaSelecionado;

    public Long getCinemaSelecionado() {
        return cinemaSelecionado;
    }

    public void setCinemaSelecionado(Long cinemaSelecionado) {
        this.cinemaSelecionado = cinemaSelecionado;
    }

    public void cadastrar(Cinema cinema){

        if(!idExistente(cinema.getId())){

            cinemas.add(cinema);

        }else{

            System.out.println("Cadastre outro Id.");

        }

    }

    public boolean idExistente(Long idCinema){

        for(int i = 0; i < cinemas.size(); i++){

            if(cinemas.get(i).getId() == idCinema){

                System.out.println("Esse ID já existe.");
                return true;
            }
        }
        return false;
    }

    public List<Cinema> listar(){

        return cinemas;

    }
}