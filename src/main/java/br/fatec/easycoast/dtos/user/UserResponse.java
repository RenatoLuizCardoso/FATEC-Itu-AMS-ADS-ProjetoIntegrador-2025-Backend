package br.fatec.easycoast.dtos.user;

public record UserResponse( 
     Long id,
     String name,
     String login,
     String password,
     UserProfile profile ) {

}
