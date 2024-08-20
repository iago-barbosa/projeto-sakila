/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.FilmeBean;

/**
 *
 * @author Senai
 */
public class FilmesDAO {
    
    public List<FilmeBean> ler(){
            List<FilmeBean> conjuntoFilmes = new ArrayList();
            
            try{
                Connection conexao = Conexao.conectar();
                PreparedStatement stmt = null;
                ResultSet rs = null;
                
                stmt = conexao.prepareStatement("SELECT * FROM film");
                
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    FilmeBean bean = new FilmeBean();
                    
                    bean.setFilm_id(rs.getInt("film_id"));
                    bean.setTitle(rs.getString("title"));
                    bean.setDescription(rs.getString("description"));
                    bean.setRelease_year(rs.getInt("release_year"));
                    
                    
                    conjuntoFilmes.add(bean);
                    
                }
                
                rs.close();
                stmt.close();
                conexao.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            return conjuntoFilmes;
    }
    
    
    public void InserirFilme(FilmeBean bean){
        
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement("INSERT INTO film(title,description,release_year) VALUES(?,?,?)");
            
            stmt.setString(1, bean.getTitle());
            stmt.setString(2, bean.getDescription());
            stmt.setInt(3, bean.getRelease_year());
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    public void DeletarFilme(FilmeBean bean){
        
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            
            stmt = conexao.prepareStatement("DELETE FROM film WHERE film_id = ?");
            
            stmt.setInt(1, bean.getFilm_id());
            
            stmt.execute();
            
            stmt.close();
            conexao.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
      public FilmeBean selecionarFilme(int id){
       FilmeBean filmeSelecionado = new FilmeBean();
       
       try{
           Connection conexao = Conexao.conectar();
           PreparedStatement stmt = null;
           ResultSet rs = null;
          
           stmt = conexao.prepareStatement("SELECT * FROM film WHERE film_id = ?");
           
           stmt.setInt(1, id);
           
           rs = stmt.executeQuery();
           
           if(rs.next()){
              filmeSelecionado.setTitle(rs.getString("title"));
              filmeSelecionado.setDescription(rs.getString("description"));
              filmeSelecionado.setRelease_year(rs.getInt("release_year"));
           }
           
           
           rs.close();
           stmt.close();
           conexao.close();
       }catch(SQLException e){
           e.printStackTrace();
       }
       
       return filmeSelecionado;
   }
 
    
    
}
