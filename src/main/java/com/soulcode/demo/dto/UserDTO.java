package com.soulcode.demo.dto;

import com.soulcode.demo.models.Sector;
import com.soulcode.demo.models.TypeUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDTO {
    private String nome;
    private String email;
    private String senha;
    private String confirmacaoSenha;
    private TypeUser tipo;
    private Sector setor;

    public UserDTO() {
    }


}
