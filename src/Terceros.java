
import java.sql.*;
import Terceros.*;
import javax.swing.JOptionPane;


public class Terceros extends TerceroPOA{
    conexion objConec = new conexion();

    @Override
    public boolean insertarTercero(String nombres, String apellidos, String telefono) {
        boolean resultado = false;
        try {
            String sql= "insert into terceros (nombres, apellidos, telefono)values('"+nombres+"','"+apellidos+"','"+telefono+"')";
            objConec.conectar();
            Statement st = objConec.Conexion.createStatement();
            int valor= st.executeUpdate(sql);
            if(valor>0){
            resultado=true;
            }
            //se cierran todas la conecciones 
            objConec.Conexion.close();
            st.close();
            
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error al insertar" +e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean actualizarTercero(int id, String nombres, String apellidos, String telefono) {
        boolean resultado = false;
        try {
            String sql= "update terceros set nombres='"+nombres+"',apellidos='"+apellidos+"',telefono='"+telefono+"'";
            Statement st = objConec.Conexion.createStatement();
            int valor= st.executeUpdate(sql);
            if(valor>0){
            resultado=true;
            }
            //se cierran todas la conecciones 
            objConec.Conexion.close();
            st.close();
            
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error al actualizar" +e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean eliminarTerceros(int id) {
         boolean resultado = false;
        try {
            String sql = "Delete from terceros where id= "+id; 
            Statement st = objConec.Conexion.createStatement();
            int valor= st.executeUpdate(sql);
            if(valor>0){
            resultado=true;
            }
            //se cierran todas la conecciones 
            objConec.Conexion.close();
            st.close();
            
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error al eliminar" +e.getMessage());
        }
        return resultado;
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
            //se cierran las conexiones
            rs.close();
            objConec.Conexion.close();
        } catch (Exception e) {
            System.out.println("ERROR: "+ e.getMessage());
        }
      return resultado;
    }

    @Override
    public void shoutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet cargarTerceros(){
        ResultSet resultado = null;
        try {
            String sql= "select nombres, apellidos, telefonos from terceros";
            objConec.conectar();
            Statement st = objConec.Conexion.createStatement();
            resultado = st.executeQuery(sql);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR: "+ e.getMessage());
        }
        
        return resultado;
    }
    
}
