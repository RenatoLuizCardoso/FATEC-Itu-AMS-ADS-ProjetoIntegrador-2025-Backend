package br.fatec.easycoast.dtos.user;

public record UserRequest(
     String name,
     String login,
     String password,
     UserProfile profile
) {

}
