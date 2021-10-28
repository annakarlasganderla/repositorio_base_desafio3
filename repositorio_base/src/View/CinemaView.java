package View;

import Controller.CinemaController;
import Model.Cinema;

import java.util.Scanner;

public class CinemaView {

    Scanner entrada = new Scanner(System.in);
    CinemaController cinemaController = new CinemaController();
    SessaoView sessaoView = new SessaoView();

    public void cadastrarCinema(){

        Cinema cinema = new Cinema();

        System.out.print("Digite o ID:");
        cinema.setId(entrada.nextLong());

        entrada.nextLine();

        System.out.print("Digite o nome do cinema:");
        cinema.setNome(entrada.next());

        entrada.nextLine();

        System.out.print("CNPJ:");
        cinema.setCnpj(entrada.next());

        System.out.println("Cinema cadastrado com sucesso! \n" + cinema);

        cinemaController.cadastrar(cinema);

    }

    public void listarCinemas(){

        System.out.println(cinemaController.listar());

    }

    public Long selecionaCinema(){

        this.listarCinemas();

        System.out.println("Digite o codigo do cinema que deseja selecionar.");

        Long idSelecionado = entrada.nextLong();

        if(cinemaController.idExistente(idSelecionado)){

            return idSelecionado;

        }

        return null;

    }

    public void menuCinema(){

        System.out.println("1 - Listar cinemas\n2 - Cadastrar cinema\n 3 - Acessar cinema");

        switch (entrada.nextInt()){

            case 1:
                this.listarCinemas();
            break;

            case 2:
                this.cadastrarCinema();
                this.menuCinema();
            break;

            case 3:
                cinemaController.setCinemaSelecionado(selecionaCinema());
                menuInterno(cinemaController.getCinemaSelecionado());
            break;

        }

    }

    public void menuInterno(Long cinemaSelecionado){

        System.out.println("1 - Listar sessoes\n2 - Cadastrar sessao\n3 - Deletar Cinema");

        switch (entrada.nextInt()){

            case 1:

                sessaoView.listarSessoesByIdCinema(cinemaSelecionado);

            break;
            case 2:

                sessaoView.cadastrarSessao(cinemaSelecionado);

            break;
            case 3:

                System.out.println("Em andamento");

            break;
        }

    }

}
