
package conexionmysqlcorba;

import java.sql.*;
import Terceros.*;


public class Terceros extends TerceroPOA{
    conexion objConec = new conexion();

    @Override
    public boolean insertarTercero(String nombres, String apellidos, String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarTercero(int id, String nombres, String apellidos, String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarTerceros(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String consultarTerceros(int id) {
      String resultado = "";
        try {
            String sqlConsultar = "Select* from terceros where id = "+ id;
            objConec.conectar();
            Statement st = objConec.Conexion.createStatement();
            ResultSet rs = st.executeQuery(sqlConsultar);
            while(rs.next()){
            resultado += rs.getString(2)+"-"
                    +rs.getString(3)+"-"
                    +rs.getString(4);
            }
        } catch (Exception e) {
            System.out.println("ERROR: "+ e.getMessage());
        }
      return resultado;
    }

    @Override
    public void shoutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
