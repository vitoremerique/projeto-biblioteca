package ControladorBiblioteca;

import Repositório.autor.RepositorioAutor;
import Repositório.autor.RepositorioAutorInterface;
import Repositório.autor.autorJaCadastradoException;
import Repositório.autor.autorNaoCadastradaException;
import Repositório.editora.RepositorioEditora;
import Repositório.editora.RepositorioEditoraInterface;
import Repositório.editora.editoraJaCadastradaException;
import Repositório.editora.editoraNaoCadastradaException;
import Repositório.emprestimo.EmprestimoJaCadastradaException;
import Repositório.emprestimo.EmprestimoNaoCadastradaException;
import Repositório.emprestimo.RepositorioEmprestimo;
import Repositório.emprestimo.RepositorioEmprestimoInterface;
import Repositório.exemplar.RepositorioExemplares;
import Repositório.exemplar.RepositorioExemplaresInterface;
import Repositório.exemplar.exemplaresJaCadastradaException;
import Repositório.exemplar.exemplaresNaoCadastradaException;
import Repositório.obra.ObraJaCadastradaException;
import Repositório.obra.ObraNaoCadastradaException;
import Repositório.obra.RepositorioObra;
import Repositório.obra.RepositorioObraLista;
import Repositório.usuário.RepositorioUsuario;
import Repositório.usuário.RepositorioUsuarioInterface;
import Repositório.usuário.UsuarioJaCadastradaException;
import Repositório.usuário.UsuarioNaoCadastradaException;
import model.autor.Autor;
import model.obra.Obra;


import model.editora.Editora;
import model.emprestimo.Emprestimo;

import model.exemplares.Exemplar;
import model.usuario.Usuario;


import java.util.List;

public class ControladorBiblioteca {
    private RepositorioUsuarioInterface repositorioUsuario;
    private RepositorioAutorInterface repositorioAutor;
    private RepositorioEditoraInterface repositorioEditora;
    private RepositorioEmprestimoInterface repositorioEmprestimo;
    private RepositorioExemplaresInterface repositorioExemplares;
    private RepositorioObra repositorioObra;



    public ControladorBiblioteca(){
        repositorioUsuario = new RepositorioUsuario();
        repositorioAutor = new RepositorioAutor();
        repositorioEditora = new RepositorioEditora();
        repositorioEmprestimo = new RepositorioEmprestimo();
        repositorioExemplares = new RepositorioExemplares();
        repositorioObra = new RepositorioObraLista();

    }

    public Usuario BuscarUsuario(String nome) throws UsuarioNaoCadastradaException{
        return repositorioUsuario.BuscarUsuario(nome);
    }
    public void InserirUsuario(Usuario usuarioes) throws UsuarioJaCadastradaException{
        repositorioUsuario.InserirUsuario(usuarioes);
    }
    public void AlterarUsuario(Usuario usuarioes) throws UsuarioNaoCadastradaException{
        repositorioUsuario.AlterarUsuario(usuarioes);
    }
    public void DeletarUsuario(Usuario usuarioes) throws UsuarioNaoCadastradaException{
        repositorioUsuario.DeletarUsuario(usuarioes);
    }
    public List<Usuario> getAllusuario(){
        return repositorioUsuario.getAll();
    }



    public Autor BuscarAutor(String nome) throws autorNaoCadastradaException {
        return repositorioAutor.BuscarAutor(nome);
    }

    public void InserirAutor(Autor autores) throws autorJaCadastradoException {
        repositorioAutor.InserirAutor(autores);
    }

    public void AlterarAutor(Autor autores) throws autorNaoCadastradaException {
        repositorioAutor.AlterarAutor(autores);
    }
    public void DeletarAutor(Autor autores) throws autorNaoCadastradaException {
        repositorioAutor.DeletarAutor(autores);
    }

    public List<Autor> getAllAutores(){
        return repositorioAutor.getAll();
    }




    public Editora BuscarEditora(String nome) throws editoraNaoCadastradaException{
        return repositorioEditora.BuscarEditora(nome);
    }
    public void InserirEditora(Editora editora) throws editoraJaCadastradaException {
        repositorioEditora.InserirEditora(editora);
    }
    public void AlterarEditora(Editora editora) throws editoraNaoCadastradaException {
        repositorioEditora.AlterarEditora(editora);
    }
    public void DeletarEditora(Editora editora) throws editoraNaoCadastradaException {
        repositorioEditora.DeletarEditora(editora);
    }
    public List<Editora> getAlleditora(){
        return repositorioEditora.getAll();
    }


    public Emprestimo BuscarEmprestimo(String id) throws EmprestimoNaoCadastradaException {
        return repositorioEmprestimo.BuscarEmprestimo(id);
    }

    public void InserirEmprestimo(Emprestimo emprestimo) throws EmprestimoJaCadastradaException {
        repositorioEmprestimo.InserirEmprestimo(emprestimo);
    }

    public void AlterarEmprestimo(Emprestimo emprestimo) throws EmprestimoNaoCadastradaException {
        repositorioEmprestimo.AlterarEmprestimo(emprestimo);
    }
    public void DeletarEmprestimo(Emprestimo emprestimo) throws EmprestimoNaoCadastradaException {
        repositorioEmprestimo.DeletarEmprestimo(emprestimo);
    }
    public List<Emprestimo> getAllemprestimo() {
        return repositorioEmprestimo.getAll();
    }


    public Exemplar BuscarExemplares(String id) throws exemplaresNaoCadastradaException {
        return repositorioExemplares.BuscarExemplares(id);
    }
    public void InserirExemplares(Exemplar exemplares) throws exemplaresJaCadastradaException {
        repositorioExemplares.InserirExemplares(exemplares);

    }
    public void AlterarExemplares(Exemplar exemplares) throws exemplaresNaoCadastradaException {
        repositorioExemplares.AlterarExemplares(exemplares);
    }
    public void DeletarExemplares(Exemplar exemplares) throws exemplaresNaoCadastradaException {
        repositorioExemplares.DeletarExemplares(exemplares);
    }
    public List<Exemplar> getAllexemplares(){
        return repositorioExemplares.getAllE();
    }

    public List<Exemplar> getAllExemplar(String Titular) {
       return repositorioExemplares.getAllExemplar(Titular);
    }


    public Obra BuscarObra(String Titulo) throws ObraNaoCadastradaException {
        return repositorioObra.BuscarObra(Titulo);
    }
    public void InserirObra(Obra obra) throws ObraJaCadastradaException {
        repositorioObra.InserirObra(obra);
    }
    public void AlterarObra(Obra obra) throws ObraNaoCadastradaException {
        repositorioObra.AlterarObra(obra);
    }
    public void DeletarObra(Obra obra) throws ObraNaoCadastradaException {
        repositorioObra.DeletarObra(obra);
    }
    public List<Obra> getAllobra(){
        return repositorioObra.getAll();
    }

    public void exit(){

    }


















}
