package com.sistemapizzaria.sistemapizzaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sistemapizzaria.sistemapizzaria.models.Usuario;
import com.sistemapizzaria.sistemapizzaria.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    /* 
     * Essa é a service do aluno. Neste momento, foram adicionados apenas métodos de CRUD.
     * Futuramente serão adicionados os outros métodos, com o desenvolvimento dos outros componentes da API.
     * O controller do usuário só contemplará os endpoints aqui presentes, a primeiro momento.
    */

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Utilizado apenas por ADMs
    public ResponseEntity<List<Usuario>> listarTodos(){
        return new ResponseEntity<>(usuarioRepository.findByEstaAtivoTrue(), HttpStatus.OK);
    }

    //Utilizado por ADMs e pela Cozinha (Atendimento ao cliente)
    public ResponseEntity<?> procurarPorCelular(String celular){
        if(usuarioRepository.findByCelular(celular) == null){
            return new ResponseEntity<>("Não existe um cliente cadastrado com esse celular", 
            HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuarioRepository.findByCelular(celular)
        , HttpStatus.OK); 
    }

    public ResponseEntity<?> cadastrarUsuario(Usuario usuario){
        if(usuarioRepository.findByEmail(usuario.getEmail()) != null){
            return new ResponseEntity<>("Já existe um usuário cadastrado com esse email!", 
            HttpStatus.CONFLICT);
        }       
        return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }

    public ResponseEntity<?> editarUsuario(Usuario usuario){
        Optional <Usuario> usuarioAntesdaEdicaoOpt = usuarioRepository.findById(usuario.getID());
        
        if (usuarioAntesdaEdicaoOpt.isEmpty()) {
            return new ResponseEntity<>("Usuário não encontrado!", HttpStatus.NOT_FOUND);
        }
    
        Usuario usuarioAntesdaEdicao = usuarioAntesdaEdicaoOpt.get();
        if (usuario.getEmail() != null && !usuario.getEmail().equals(usuarioAntesdaEdicao.getEmail())) {
            if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
                return new ResponseEntity<>("Já existe um usuário cadastrado com este e-mail!", HttpStatus.CONFLICT);
            }
        }
        //Isso é novo pra mim. geralmente fazia a edição atributo por atributo, manualmente; isso aqui facilita demais.
        BeanUtils.copyProperties(usuario, usuarioAntesdaEdicao);
        return new ResponseEntity<>(usuarioRepository.save(usuarioAntesdaEdicao), HttpStatus.OK);
    }
    
    //SOFT DELETE. só to mudando o atributo estaAtivo no usuario. Assim ele n vai aparecer qnd eu fazer a query do listar todos.
    public ResponseEntity<?> apagarUsuario(String id){
        Optional <Usuario> usuarioPorID= usuarioRepository.findById(id);
        if(usuarioPorID.isEmpty()){
            return new ResponseEntity<>("Não existe um usuário com este ID!", 
            HttpStatus.NOT_FOUND);
        }
        Usuario usuarioExistente= usuarioPorID.get();
        usuarioExistente.setEstaAtivo(false);
        usuarioRepository.save(usuarioExistente);
        return new ResponseEntity<>( "Usuário apagado com sucesso!", HttpStatus.OK);
    }
}
