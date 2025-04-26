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
import java.sql.SQLException;
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
       try{
        conectaDAO conexao= new conectaDAO();
      conexao.conectar();
        
        String  sql= "select*from produtos";
        
        PreparedStatement st= conexao.getConexao().prepareStatement(sql);
        
        ResultSet rs= st.executeQuery();
        
        ArrayList<ProdutosDTO> listagem= new ArrayList<>();
        
        while(rs.next()){
            ProdutosDTO pdto= new ProdutosDTO();
            
            pdto.setId(rs.getInt("id"));
            pdto.setNome(rs.getString("nome"));
            pdto.setValor(rs.getInt("valor"));
            pdto.setStatus(rs.getString("status"));
            listagem.add(pdto);}
        
        return listagem;
        }
    
       catch(Exception e){
           return null;
       }
    }

        public void venderProduto(int id){
           try{
               conectaDAO conexao= new conectaDAO();
                  conexao.conectar();
      
            String sql="update produtos set status='Vendido' where id=?";
            
            PreparedStatement st= conexao.getConexao().prepareStatement(sql);
           
             ProdutosDTO pdto= new ProdutosDTO();
             
              st.setInt(1, id);
              st.execute();
                         }
           catch(Exception e){
               System.out.println("erro ao atualizar status"+e.getMessage());
           }
        
        }

}
      

