package com.hk.member.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.member.vo.Member;

@Repository
public class MemberDao {

   @Autowired
   DataSource dataSource;
   
   public List<Member> memberList() { 
	   Connection connection;
       PreparedStatement pStmt = null;
       ResultSet rs = null;
       String query = "select mno, email, pwd, mname, cre_date, mod_date from members order by mno";
       List<Member> members = new ArrayList<Member>();
       
       try {
          connection = dataSource.getConnection();
          pStmt = connection.prepareStatement(query);
          rs = pStmt.executeQuery();
          while(rs.next()) { 
            
            Member member = new Member();
            member.setMno(rs.getInt("mno"));
            member.setEmail(rs.getString("email"));
            member.setPwd(rs.getString("pwd"));
            member.setMname(rs.getString("mname"));
            member.setCre_date(rs.getDate("cre_date"));
            member.setMod_date(rs.getDate("mod_date"));
            
            members.add(member);
         }

      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally { 
         if(rs !=null)
            try {
               rs.close();
            } catch (Exception e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         if(pStmt !=null)
            try {
               pStmt.close();
            } catch (Exception e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
      }
      
      return members;      
   }
}