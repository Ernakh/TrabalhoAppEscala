package com.example.appescala;

public class Enfermeiro {
        public String nome;
        public String login;
        public String senha;
        public String cargo;

        public Enfermeiro(){
        }

        public Enfermeiro(String nome, String login, String senha, String cargo){
            this.nome = nome;
            this.login = login;
            this.senha = senha;
            this.cargo = cargo;
        }
}
