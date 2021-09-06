package POO;
import java.time.DayOfWeek;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Scanner;
import ControladorBiblioteca.ControladorBiblioteca;
import Repositório.autor.autorJaCadastradoException;
import Repositório.autor.autorNaoCadastradaException;
import Repositório.editora.editoraJaCadastradaException;
import Repositório.editora.editoraNaoCadastradaException;
import Repositório.emprestimo.EmprestimoJaCadastradaException;
import Repositório.emprestimo.EmprestimoNaoCadastradaException;
import Repositório.exemplar.exemplaresJaCadastradaException;
import Repositório.exemplar.exemplaresNaoCadastradaException;
import Repositório.obra.ObraJaCadastradaException;
import Repositório.obra.ObraNaoCadastradaException;
import Repositório.usuário.UsuarioJaCadastradaException;
import Repositório.usuário.UsuarioNaoCadastradaException;
import model.autor.Autor;
import model.obra.Obra;
import model.emprestimo.Emprestimo;
import model.exemplares.Exemplar;
import model.usuario.Usuario;
import java.time.LocalDate;
import java.util.List;
import model.editora.Editora;





public class Main {
    static ControladorBiblioteca controlador;

    public static void main(String[] args) throws Exception {

        controlador = new ControladorBiblioteca();

        int opcao;
        inserirDados();
        Scanner scanner = new Scanner(System.in);


        do {
            limpaTela();
            System.out.println("MENU PRINCIPAL");
            System.out.println("==== =========");
            System.out.println();
            System.out.println("<1> Usuário");
            System.out.println("<2> Obra");
            System.out.println("<3> Autor");
            System.out.println("<4> Exemplar");
            System.out.println("<5> Editora");
            System.out.println("<6> Emprestimo");
            System.out.println("<0> Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");

            try {

                opcao = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }

            switch (opcao) {
                case 0:
                    limpaTela();
                    break;
                case 1:
                    CadastrarUsuario();
                    break;
                case 2:
                    CadastrarObra();
                    break;
                case 3:
                    CadastrarAutor();
                    break;
                case 4:
                    CadastrarExemplar();
                    break;
                case 5:
                    CadastrarEditora();
                    break;
                case 6:
                    CadastrarEmprestimo();
                    break;
            }
        } while (opcao != 0);

        controlador.exit();
        System.out.println("Programa terminado");
    }


    public static void inserirDados() throws UsuarioJaCadastradaException, editoraJaCadastradaException, autorJaCadastradoException, ObraJaCadastradaException, exemplaresJaCadastradaException, EmprestimoJaCadastradaException {
        try {
            Usuario usuario1 = new Usuario("vitor", "rua magalhaes", "Ciencia da computação ");
            Usuario usuario2 = new Usuario("pedro ", "Travessa Antonio", "Ciencia da computação ");
            controlador.InserirUsuario(usuario1);
            controlador.InserirUsuario(usuario2);

            Editora editora1 = new Editora("Itaituba", "Almeida");
            Editora editora2 = new Editora("Itba", "Ala");

            controlador.InserirEditora(editora1);
            controlador.InserirEditora(editora2);

            Autor autor1 = new Autor("Vitor", "Brasileiro");
            Autor autor2 = new Autor("Vor", "Bleiro");
            controlador.InserirAutor(autor1);
            controlador.InserirAutor(autor2);

            Obra obra1 = new Obra(1, "Lua", "2020", "1°", "Saúde", autor1, editora1);



            controlador.InserirObra(obra1);


            Exemplar exemplar1 = new Exemplar(obra1);
            controlador.InserirExemplares(exemplar1);
            Exemplar exemplar2 = new Exemplar(obra1);
            controlador.InserirExemplares(exemplar2);
            Emprestimo emprestimo = new Emprestimo(LocalDate.of(2021,05,01),usuario1,exemplar2,false);
            controlador.InserirEmprestimo(emprestimo);



        } catch (UsuarioJaCadastradaException | editoraJaCadastradaException | autorJaCadastradoException | ObraJaCadastradaException | exemplaresJaCadastradaException   ex) {
        }
    }


    private static void limpaTela() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }



    public static void CadastrarUsuario() {
        int opcao;
        do {
            limpaTela();
            System.out.println("Cadastro Usuário");
            System.out.println("==== =========");
            System.out.println();
            System.out.println("<1> Inserir Usuário");
            System.out.println("<2> Excluir Usuário");
            System.out.println("<3> Buscar Usuário");
            System.out.println("<4> Listar Usuários");
            System.out.println("<5> Alterar Usuário");
            System.out.println("<0> Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");

            try {

                Scanner scanner = new Scanner(System.in);
                opcao = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }

            switch (opcao) {
                case 0:
                    limpaTela();
                    break;
                case 1:
                    inserirUsuario();
                    break;
                case 2:
                    deletarUsuario();
                    break;
                case 3:
                    buscarUsuario();
                    break;

                case 4:
                    listarUsuario();
                    break;
                case 5:
                    alterarUsuario();
                    break;

            }
        } while (opcao != 0);
    }

    public static void alterarUsuario(){
        limpaTela();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        try{
            Usuario usuario = controlador.BuscarUsuario(nome);

            System.out.println();
            System.out.println("Nome: "+ usuario.getNome());
            System.out.println();
            System.out.println("Nome: (<enter> = Não alterar)");
            String name = scanner.nextLine();
            if(!name.equals("")){
                usuario.setNome(nome);
            }

            System.out.println();
            System.out.println("Curso: "+usuario.getCurso());
            System.out.println();
            System.out.println("Curso: (<enter> = Não alterar)");
            String curso = scanner.nextLine();
            if(!curso.equals("")){
                usuario.setCurso(curso);
            }

            System.out.println();
            System.out.println("Usuario: "+usuario.getEndereco());
            System.out.println();
            System.out.println("Endereço: (<enter> = Não alterar)");
            String end = scanner.nextLine();
            if(!end.equals("")){
                usuario.setEndereco(end);
            }
        } catch (UsuarioNaoCadastradaException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();


    }


    public static void inserirUsuario() {
        Scanner scanner = new Scanner(System.in);
        limpaTela();
        System.out.println("Cadastro de Usuário");
        System.out.println("-------------------");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Curso: ");
        String curso = scanner.nextLine();

        Usuario usuario = new Usuario(nome, endereco, curso);

        try {
            controlador.InserirUsuario(usuario);
            System.out.println("Usuário cadastrados");

        } catch (UsuarioJaCadastradaException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    private static void deletarUsuario() {
        limpaTela();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Excluir Usuário");
        System.out.println("================");
        System.out.println();
        System.out.print("Nome do Usuário: ");
        String nome = scanner.nextLine();

        try {
            Usuario usuario = controlador.BuscarUsuario(nome);
            System.out.println();
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("ID: " + usuario.getId_Usuario());
            System.out.println("Curso: " + usuario.getCurso());
            System.out.println();

            System.out.print("Exclui esse Usuário? (s/n)?");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
                controlador.DeletarUsuario(usuario);
                System.out.println("Conta excluída!");
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    private static void buscarUsuario() {
        limpaTela();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        try {
            Usuario usuario = controlador.BuscarUsuario(nome);
            limpaTela();
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Endereço: " + usuario.getEndereco());
            System.out.println("ID: " + usuario.getId_Usuario());
            System.out.println("Curso: " + usuario.getCurso());
        } catch (UsuarioNaoCadastradaException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    private static void listarUsuario(){
        Scanner scanner = new Scanner(System.in);
        try{
        List<Usuario> lista = controlador.getAllusuario();
        limpaTela();

        for (Usuario usuario: lista) {

            System.out.println("Nome: "+usuario.getNome());
            System.out.println("Curso: "+usuario.getCurso());
            System.out.println("ID: "+usuario.getId_Usuario());
            System.out.println();
            System.out.println("|================================|");
            System.out.print("\n");

            }

    } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    public static void CadastrarObra() {
        int opcao;

        do {
            limpaTela();
            System.out.println("Cadastro Obra");
            System.out.println("==== =========");
            System.out.println();
            System.out.println("<1> Inserir Obra");
            System.out.println("<2> Excluir Obra");
            System.out.println("<3> Buscar Obra");
            System.out.println("<4> Listar Obra");
            System.out.println("<0> Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");

            try {

                Scanner scanner = new Scanner(System.in);
                opcao = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }

            switch (opcao) {
                case 0:
                    limpaTela();
                    break;
                case 1:
                    inserirObra();
                    break;
                case 2:
                    deletarObra();
                    break;
                case 3:
                    buscarObra();
                    break;
                case 4:
                    listarObra();
                    break;

            }
        } while (opcao != 0);
    }


    public static void inserirObra() {

        Scanner scanner = new Scanner(System.in);
        limpaTela();
        System.out.println("Cadastro da Obra");
        System.out.println("-------------------");
        System.out.println("Titulo: ");
        String titulo =  scanner.nextLine();

        System.out.println("-------------------");


        System.out.println("Código ISBN: ");
        String isbn = scanner.nextLine();
        int isbnplus = Integer.valueOf(isbn);
        System.out.println("-------------------");

        System.out.println("Ano: ");
        String ano = scanner.nextLine();
        System.out.println("-------------------");

        System.out.println("Edição: ");
        String edicao = scanner.nextLine();
        System.out.println("-------------------");

        System.out.println("Sessão: ");
        String sessao = scanner.nextLine();
        System.out.println("-------------------");

        System.out.println("Nome do Autor: ");
        String nome_autor = scanner.nextLine();
        System.out.println("-------------------");

        System.out.println("Nascionalidade: ");
        String Nasc = scanner.nextLine();
        System.out.println("-------------------");

        System.out.println("Cidade da editora: ");
        String editora_nome = scanner.nextLine();
        System.out.println("-------------------");

        System.out.println("Nome da cidade da editora: ");
        String cidade_editora = scanner.nextLine();

        Autor autor = new Autor(nome_autor,Nasc);
        Editora editora = new Editora(cidade_editora,editora_nome);
        Obra obra = new Obra(isbnplus,titulo,ano,edicao,sessao,autor,editora);
        Exemplar exemplar = new Exemplar(obra);
        try{
            controlador.InserirAutor(autor);
            controlador.InserirEditora(editora);
            controlador.InserirObra(obra);
            controlador.InserirExemplares(exemplar);
            System.out.println("Obra Cadastrada com sucesso!");
        } catch (autorJaCadastradoException |ObraJaCadastradaException |editoraJaCadastradaException e) {
            e.printStackTrace();
        } catch (exemplaresJaCadastradaException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    public static void deletarObra(){
        limpaTela();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome da Obra: ");
        String nome = scanner.nextLine();
        try{
            Obra obra = controlador.BuscarObra(nome);
            System.out.print("Nome da Obra: "+obra.getTitulo());
            System.out.print(" | Autor: "+obra.getAutor().getNome()+"\n");
            System.out.print("Edição: "+obra.getEdicao());

            System.out.print("Gostaria de excluir a obra (s/n)?");
            String resp = scanner.nextLine();

            if (resp.equalsIgnoreCase("s")) {
                controlador.DeletarObra(obra);
                controlador.DeletarAutor(obra.getAutor());
                controlador.DeletarEditora(obra.getEditora());
                System.out.println("Obra excluída");
            }

        } catch (autorNaoCadastradaException | editoraNaoCadastradaException | ObraNaoCadastradaException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();

    }

    public static void buscarObra(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome da Obra: ");
        String nome = scanner.nextLine();

        try{
            Obra obra = controlador.BuscarObra(nome);
            System.out.print(" Nome: "+ obra.getTitulo() +"\n Ano: "+ obra.getAno());
            System.out.print("\n ISBN da obra: "+obra.getIsbn());
            System.out.print("\n Sessão: "+obra.getSessao());
            System.out.print("\n Autor: "+obra.getAutor().getNome());
            System.out.print(" Editora: "+obra.getEditora().getNome()+"\n Cidade: "+obra.getEditora().getCidade());
        } catch (ObraNaoCadastradaException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    public static void listarObra(){
        Scanner scanner = new Scanner(System.in);
        List<Obra>lista = controlador.getAllobra();
        try{
        for (Obra obra:lista) {
            System.out.println("Titulo: "+obra.getTitulo());
            System.out.println("Autor: "+obra.getAutor().getNome());
            System.out.println("Edição: "+obra.getEdicao());
            System.out.println("Editora: "+obra.getEditora().getNome());
            System.out.println();
            System.out.println("|=================================|");
            System.out.println();
        }
    } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }


    public static void CadastrarAutor(){
        int opcao;

        do {
            limpaTela();
            System.out.println("Cadastro Autor");
            System.out.println("==== =========");
            System.out.println();
            System.out.println("<1> Inserir Autor");
            System.out.println("<2> Excluir Autor");
            System.out.println("<3> Buscar Autor");
            System.out.println("<4> Listar Autor");
            System.out.println("<0> Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");

            try {

                Scanner scanner = new Scanner(System.in);
                opcao = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }

            switch (opcao) {
                case 0:
                    limpaTela();
                    break;
                case 1:
                    inserirAutor();
                    break;
                case 2:
                    deletarAutor();
                    break;
                case 3:
                    buscarAutor();
                    break;
                case 4:
                    listarAutor();
                    break;

            }
        } while (opcao != 0);
    }

    public static void inserirAutor(){
        limpaTela();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Nascionalidade: ");
        String nasc = scanner.nextLine();
        Autor autor = new Autor(nome,nasc);

        try{
            controlador.InserirAutor(autor);
            System.out.println("Cadastrador com sucesso");
        } catch (autorJaCadastradoException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    public static void deletarAutor(){
        limpaTela();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        try{
            Autor autor = controlador.BuscarAutor(nome);
            System.out.println("Autor: "+autor.getNome());
            System.out.println("Nascionalidade: "+ autor.getNascionalidade());
            System.out.println();
            System.out.println("Tem certeza que deseja excluir (s/n)?");
            String resp = scanner.nextLine();

            if(resp.equalsIgnoreCase("s")){
                controlador.DeletarAutor(autor);
            }
        } catch (autorNaoCadastradaException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    public static void buscarAutor(){
        limpaTela();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        try{
            Autor autor = controlador.BuscarAutor(nome);
            System.out.println("Nome: "+autor.getNome());
            System.out.println("Nascionalidade: "+autor.getNascionalidade());
            System.out.println();
        } catch (autorNaoCadastradaException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    public static void listarAutor(){
        limpaTela();
        Scanner scanner = new Scanner(System.in);
        List<Autor> lista = controlador.getAllAutores();
        try{
            for (Autor autor:lista) {
                System.out.println("|======================|");
                System.out.println();
                System.out.println("Nome: "+autor.getNome());
                System.out.println("Nascionalidade: "+autor.getNascionalidade());
                System.out.println();
            }
            System.out.println("|======================|");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();

    }


    public static void CadastrarExemplar() throws ObraNaoCadastradaException {
        int opcao;

        do {
            limpaTela();
            System.out.println("Cadastro Exemplar");
            System.out.println("==== =========");
            System.out.println();
            System.out.println("<1> Inserir Exemplar");
            System.out.println("<2> Excluir Exemplar");
            System.out.println("<3> Buscar Exemplar");
            System.out.println("<4> Listar Exemplar");
            System.out.println("<5> Listar todos Exemplar");
            System.out.println("<0> Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");

            try {

                Scanner scanner = new Scanner(System.in);
                opcao = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }

            switch (opcao) {
                case 0:
                    limpaTela();
                    break;
                case 1:
                    inserirExemplar();
                    break;
                case 2:
                    deletarExemplar();
                    break;
                case 3:
                    buscarExemplar();
                    break;
                case 4:
                    listaExemplar();
                    break;
                case 5:
                    listatodosExemplares();
                    break;

            }
        } while (opcao != 0);
    }

    public static void inserirExemplar() {
        limpaTela();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome da Obra: ");
        String nome = scanner.nextLine();
        try{
            Obra obra = controlador.BuscarObra(nome);
            Exemplar exemplar = new Exemplar(obra);
            controlador.InserirExemplares(exemplar);
            System.out.println("Cadastrado com sucesso!");

        } catch (ObraNaoCadastradaException e) {
            e.printStackTrace();
        } catch (exemplaresJaCadastradaException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();

    }

    public static void buscarExemplar(){
        limpaTela();
        Scanner scanner = new Scanner(System.in);
        System.out.println("ID do exemplar");
        String id = scanner.nextLine();
        System.out.println();
        System.out.println("================================");
        try{
            Exemplar exemplar = controlador.BuscarExemplares(id);
            System.out.println("Nome: "+ exemplar.getObra().getTitulo());
            System.out.println("ID do exemplar: "+exemplar.getId());
            System.out.println("================================");


        } catch (exemplaresNaoCadastradaException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();

    }

    public static void deletarExemplar() throws ObraNaoCadastradaException {
        limpaTela();
        Scanner scanner = new Scanner(System.in);
        System.out.println("id do exemplar: ");
        String ID = scanner.nextLine();
        try{
            Exemplar exemplar = controlador.BuscarExemplares(ID);

            System.out.println("Nome da obra: "+ exemplar.getObra().getTitulo());
            System.out.println("Editora: "+ exemplar.getObra().getEditora().getNome());
            System.out.println("Tem certeza que deseja excluir (s/n)?");
            String resp = scanner.nextLine();
            if(!resp.equals("s")){
                controlador.DeletarExemplares(exemplar);
            }


            System.out.println("");
        } catch (exemplaresNaoCadastradaException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }
    public static void listaExemplar() {
        limpaTela();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Titulo: ");
        String titulo = scanner.nextLine();
        try {
            List<Exemplar> lista = controlador.getAllExemplar(titulo);
            System.out.println("LISTA Dx " + titulo.toUpperCase());
            int a = 0;
            for (Exemplar exemplar : lista) {

                System.out.printf("--> " + String.valueOf(a) + "|" + "_" + "|");
                System.out.printf(" Titulo:" + exemplar.getObra().getTitulo() + "|");
                System.out.printf(" ID do Exemplar:" + exemplar.getId() + "|");
                System.out.println(" ID da obra:" + exemplar.getObra().getIsbn() + "|");
                a = a + 1;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();

    }

    public static void listatodosExemplares() {
        limpaTela();
        Scanner scanner = new Scanner(System.in);
        try {
            List<Exemplar> lista = controlador.getAllexemplares();
            System.out.println("LISTA Dx " );
            int a = 0;
            for (Exemplar exemplar : lista) {

                System.out.printf("--> " + String.valueOf(a) + "|" + "_" + "|");
                System.out.printf(" Titulo:" + exemplar.getObra().getTitulo() + "|");
                System.out.printf(" ID do Exemplar:" + exemplar.getId() + "|");
                System.out.println(" ID da obra:" + exemplar.getObra().getIsbn() + "|");
                a = a + 1;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();

    }


    public static void CadastrarEditora(){
        int opcao;

        do {
            limpaTela();
            System.out.println("Cadastro Editora");
            System.out.println("==== =========");
            System.out.println();
            System.out.println("<1> Inserir Editora");
            System.out.println("<2> Excluir Editora");
            System.out.println("<3> Buscar Editora");
            System.out.println("<4> Listar Editora");
            System.out.println("<5> Alterar Editora");
            System.out.println("<0> Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");

            try {

                Scanner scanner = new Scanner(System.in);
                opcao = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }

            switch (opcao) {
                case 0:
                    limpaTela();
                    break;
                case 1:
                    inserirEditora();
                    break;
                case 2:
                    deletarEditora();
                    break;
                case 3:
                    buscarEditora();
                    break;
                case 4:
                    listarEditoras();
                    break;
                case 5:
                    listarEditoras();
                    break;


            }
        } while (opcao != 0);
    }

    public static void inserirEditora(){
        limpaTela();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Cidade: ");
        String cidade = scanner.nextLine();
        Editora editora = new Editora(cidade,nome);
        try{
            controlador.InserirEditora(editora);
            System.out.println("Editora cadastrada com sucesso!");

        } catch (editoraJaCadastradaException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("<enter> para voltar");
        scanner.nextLine();
    }

    public static void deletarEditora(){
        limpaTela();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome:");
        String nome = scanner.nextLine();

        try{
            Editora editora = controlador.BuscarEditora(nome);
            System.out.println("Nome: "+ editora.getNome());
            System.out.println("Cidade: "+editora.getCidade());

            System.out.println("Tem certeza que deseja deletar (s/n)? "+editora.getNome());
            String resp = scanner.nextLine();
            if(!resp.equals("s")){
                controlador.DeletarEditora(editora);
                System.out.println("Deletado com sucesso");
            }
        } catch (editoraNaoCadastradaException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    public static void buscarEditora(){
        limpaTela();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        try{
                Editora editora = controlador.BuscarEditora(nome);
            System.out.println("Nome: "+editora.getNome());
            System.out.println("Cidade: "+editora.getCidade());
        } catch (editoraNaoCadastradaException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }

    public  static void listarEditoras(){
        limpaTela();
        Scanner scanner = new Scanner(System.in);
        try{
            List<Editora> lista = controlador.getAlleditora();
            int a = 0;
            for (Editora editora:lista) {
                System.out.println("===================");
                System.out.println(a+"|_| "+" Nome: "+editora.getNome());
                System.out.println("      Cidade: "+editora.getCidade());
                a++;

            }
        }catch (Exception e){
            System.err.println(e);
        }
        System.out.println();
        System.out.println("tecle <enter> para voltar");
        scanner.nextLine();
    }


    public static void CadastrarEmprestimo(){
        int opcao;

        do {
            limpaTela();
            System.out.println("Cadastro Emprestimo");
            System.out.println("==== =========");
            System.out.println();
            System.out.println("<1> Inserir Emprestimo");
            System.out.println("<2> Devolver Emprestimo");
            System.out.println("<3> Buscar Emprestimo");
            System.out.println("<4> Listar Emprestimos ");
            System.out.println("<5> Listar Emprestimos atrasados ");
            System.out.println("<0> Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");

            try {

                Scanner scanner = new Scanner(System.in);
                opcao = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }

            switch (opcao) {
                case 0:
                    limpaTela();
                    break;
                case 1:
                    inserirEmprestimo();
                    break;
                case 2:
                    devolverEmprestimo();
                    break;
                case 3:
                    buscarEmprestimo();
                    break;
                case 4:
                    listarEmprestimo();
                    break;
                case 5:
                    listarEmprestimoAtrasado();
                    break;



            }
        } while (opcao != 0);
    }

    public static void inserirEmprestimo(){
        limpaTela();
        boolean emprestimo_ = false;
        Scanner scanner = new Scanner(System.in);
        LocalDate dataEmprestimo;
        LocalDate datadeentrega;
        System.out.println("Ano de Emprestimo: ");
        int ano = scanner.nextInt();
        System.out.println("Mes de Emprestimo: ");
        int mes = scanner.nextInt();
        System.out.println("dia de Emprestimo ");
        int dia = scanner.nextInt();
        String pula = scanner.nextLine();
        System.out.println("Nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.println("id do exemplar: ");
        int id_exemplar = scanner.nextInt();
        String id = String.valueOf(id_exemplar);
        dataEmprestimo = LocalDate.of(ano,mes,dia);
        try {

            datadeentrega = dataEmprestimo.plusDays(7);

            if(datadeentrega.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                datadeentrega = datadeentrega.plusDays(1);
            }
            if(datadeentrega.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
                datadeentrega = datadeentrega.plusDays(2);
            }

            Usuario usuario = controlador.BuscarUsuario(nome);
            Exemplar exemplar = controlador.BuscarExemplares(id);
            Emprestimo emprestimo = new Emprestimo(dataEmprestimo,usuario,exemplar,emprestimo_);
            controlador.InserirEmprestimo(emprestimo);
            System.out.println("Emprestimo realizado com sucesso!");
            System.out.println("\n\nData de devolução: "+datadeentrega);

        } catch (UsuarioNaoCadastradaException e) {
            e.printStackTrace();
        } catch (exemplaresNaoCadastradaException e) {
            e.printStackTrace();
        } catch (EmprestimoJaCadastradaException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.print("Para retornar pressione <enter>");
        scanner.nextLine();
        scanner.nextLine();


    }

    public static void devolverEmprestimo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("ID do emprestimo");
        String id = scanner.nextLine();
        LocalDate diaentregado;
        System.out.println("Ano: ");
        int ano = scanner.nextInt();
        System.out.println("Mês: ");
        int mes = scanner.nextInt();
        System.out.println("Dia: ");
        int dia = scanner.nextInt();
        diaentregado = LocalDate.of(ano,mes,dia);

        try{
            Emprestimo emprestimo = controlador.BuscarEmprestimo(id);
            LocalDate datafinal = emprestimo.getDataincial().plusDays(7);
            if(datafinal.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                datafinal = datafinal.plusDays(1);
            }else if(datafinal.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
                datafinal = datafinal.plusDays(2);
            }



            long dias = ChronoUnit.DAYS.between( datafinal,diaentregado);

            if(dias>0){
                emprestimo.setDevolveu(false);
                System.out.println("São "+dias+" dias atrasado!");
                double valorApagar = dias*0.25;
                System.out.println("Pagará R$"+valorApagar+ " pelo atraso!");

            }else{
                System.out.println("Livro entregue com sucesso!");
                emprestimo.setDevolveu(true);
            }

            controlador.DeletarEmprestimo(emprestimo);
        } catch (EmprestimoNaoCadastradaException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.print("Para retornar pressione <enter>");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void listarEmprestimo(){
        Scanner scanner = new Scanner(System.in);
        try {
            List<Emprestimo> lista = controlador.getAllemprestimo();
            for (Emprestimo emprestimo : lista) {
                System.out.println("Exemplar: " + emprestimo.getExemplar().getObra().getTitulo());
                System.out.println("Editora: " + emprestimo.getExemplar().getObra().getEditora().getNome());
                System.out.println("Autor: " + emprestimo.getExemplar().getObra().getAutor().getNome());
                System.out.println("Edição: " + emprestimo.getExemplar().getObra().getEdicao());
                System.out.println("ID: " + emprestimo.getId());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println();
        System.out.print("Para retornar pressione <enter>");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void buscarEmprestimo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("ID do emprestimo");
        String id = scanner.nextLine();
        try{
            Emprestimo emprestimo = controlador.BuscarEmprestimo(id);
            System.out.println("Livro: "+emprestimo.getExemplar().getObra().getTitulo());
            System.out.println("Aluno: "+emprestimo.getUsuario().getNome());
            System.out.println("Data do emprestimo "+emprestimo.getDataincial());
            if(emprestimo.getDevolveu() == false ){
                System.out.println("Não devolvido");
            }else {
                System.out.println("Devolvido!");


            }
        } catch (EmprestimoNaoCadastradaException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.print("Para retornar pressione <enter>");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void listarEmprestimoAtrasado(){
        Scanner scanner= new Scanner(System.in);

        try{
            List<Emprestimo>lista = controlador.getAllemprestimo();
            for (Emprestimo emprestimo:lista) {
                if(emprestimo.getDevolveu() == false)
                    System.out.println(emprestimo.toString());
                System.out.println("Aluno: -----> " + emprestimo.getUsuario().getNome() + "| ID do aluno: "+emprestimo.getUsuario().getId_Usuario());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println();
        System.out.print("Para retornar pressione <enter>");
        scanner.nextLine();
        scanner.nextLine();

    }
}







