/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
      try{ 
        
      conectaDAO conexao= new conectaDAO();
      conexao.conectar();
    
        
        String sql="insert into produtos (nome, valor,status) values"+"(?,?,?)";
        PreparedStatement st= conexao.getConexao().prepareStatement(sql);

           st.setString(1, produto.getNome());
           st.setInt(2,produto.getValor()); 
           st.setString(3, produto.getStatus());
           st.execute();
        }
        
         catch (Exception ex) {
          System.out.println("Erro ao cadastrar produto: " + ex.getMessage());}}
    
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

