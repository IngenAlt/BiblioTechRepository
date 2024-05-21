package Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class BiblioDao {

    static Connection conectado;

    private static Connection conectar() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_bibliotech", "root", "Admin");
        return conectado;
    }

    public static ResultSet fazerLogin(String u, String e, String s) throws ClassNotFoundException, SQLException {
        conectado = conectar();
        PreparedStatement st = conectado.prepareStatement("SELECT cpf FROM usuario WHERE nome = ? AND email = ? AND senha = ?");
        st.setString(1, u);
        st.setString(2,e);
        st.setString(3, s);
        ResultSet resultado = st.executeQuery();
        return resultado;
    }

    public static void cadastrarUsuario (String n, String e, String s, String c) throws ClassNotFoundException, SQLException {
        conectado = conectar();
        PreparedStatement st = conectado.prepareStatement("INSERT INTO usuario VALUES(?,?,?,?)");
        st.setString(1, n);
        st.setString(2, e);
        st.setString(3, s);
        st.setString(4, c);
        st.executeUpdate();
    }
    
    public static void redefinirSenha (String s, String e, String c) throws ClassNotFoundException, SQLException {
        conectado = conectar();
        PreparedStatement st = conectado.prepareStatement("UPDATE usuario SET senha = ? WHERE email = ? AND cpf = ?");
        st.setString(1, s);
        st.setString(2, e);
        st.setString(3, c);
        st.executeUpdate();

    }
    
    public static void editarDados(String n, String e, String s, String c) throws ClassNotFoundException, SQLException {
        conectado = conectar();
        PreparedStatement st = conectado.prepareStatement("UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE cpf = ?");
        st.setString(1, n);
        st.setString(2, e);
        st.setString(3, s);
        st.setString(4,c);
        st.executeUpdate();
    }     
    
}
