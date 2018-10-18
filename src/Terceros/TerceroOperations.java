package Terceros;



public interface TerceroOperations 
{
  boolean insertarTercero (String nombres, String apellidos, String telefono);
  boolean actualizarTercero (int id, String nombres, String apellidos, String telefono);
  boolean eliminarTerceros (int id);
  String consultarTerceros (int id);
  void shoutdown ();
} // interface TerceroOperations
